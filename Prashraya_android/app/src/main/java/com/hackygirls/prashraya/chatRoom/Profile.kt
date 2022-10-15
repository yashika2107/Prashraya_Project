package com.hackygirls.prashraya.chatRoom

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Images.Media.getBitmap
import android.view.View
import android.widget.Toast
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import com.hackygirls.prashraya.LoginActivity
import com.hackygirls.prashraya.R
import kotlinx.android.synthetic.main.activity_profile.*
import java.io.IOException
import java.util.*
import kotlin.collections.HashMap

class Profile : AppCompatActivity() {
    private lateinit var firebaseUser: FirebaseUser
    private lateinit var databaseReference: DatabaseReference
    private var filePath: Uri? = null
    private lateinit var storage: FirebaseStorage
    private lateinit var storageRef: StorageReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        firebaseUser = FirebaseAuth.getInstance().currentUser!!
        storage = FirebaseStorage.getInstance()
        storageRef = storage.reference
        databaseReference =
            FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.uid)

        databaseReference.addValueEventListener(object : ValueEventListener {
            @SuppressLint("CheckResult")
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(UserChat::class.java)

//                userName.setText(user?.userName)

                userName.text = user?.userName.toString()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext, error.message, Toast.LENGTH_SHORT).show()
            }

        })

        imgBack.setOnClickListener {
            onBackPressed()
        }

//        userImage.setOnClickListener {
//            selectImage()
//        }

        btnSave.setOnClickListener {
            uploadImage()
            progressBar.visibility = View.VISIBLE
        }

        btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }


    }

    // Select Image method
    private fun selectImage() {
        val intent: Intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Image"), 2020)
    }

    private fun uploadImage() = if (filePath != null) {
        val ref = storageRef.child("uploads/" + UUID.randomUUID().toString())
        val uploadTask = ref.putFile(filePath!!)

        val urlTask =
            uploadTask.continueWithTask(Continuation<UploadTask.TaskSnapshot, Task<Uri>> { task ->
                if (!task.isSuccessful) {
                    task.exception?.let {
                        throw it
                    }
                }
                return@Continuation ref.downloadUrl
            }).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val downloadUri = task.result
                    addUploadRecordToDb(downloadUri.toString())
                }
            }.addOnFailureListener {
                Toast.makeText(this, "Upload failure", Toast.LENGTH_SHORT).show()
            }
    } else {
        Toast.makeText(this, "Please Upload an Image", Toast.LENGTH_SHORT).show()
    }

    private fun addUploadRecordToDb(uri: String) {
        val hashMap: HashMap<String, String> = HashMap()
        hashMap["userName"] = userName.text.toString()
        hashMap["userImage"] = uri
        databaseReference.updateChildren(hashMap as Map<String, Any>)
            .addOnSuccessListener {
                Toast.makeText(this, "Saved to DB", Toast.LENGTH_LONG).show()

            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error saving to DB", Toast.LENGTH_LONG).show()
            }
        progressBar.visibility = View.GONE
        btnSave.visibility = View.GONE
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 2020 && resultCode == Activity.RESULT_OK) {
            filePath = data!!.data
            try {
                val bitmap: Bitmap = getBitmap(contentResolver, filePath)
//                userImage.setImageBitmap(bitmap)
                btnSave.visibility = View.VISIBLE
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

}