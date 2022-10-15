package com.hackygirls.prashraya

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_reports.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

private const val REQUEST_CODE_IMAGE_PICK = 0

class ReportsActivity : AppCompatActivity() {
    var curFile: Uri? = null

    val imageRef = Firebase.storage.reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reports)

        ivImage.setOnClickListener {
            val intent = Intent(this, ImageActivity::class.java)
            startActivity(intent)
            finish()
        }
        ivImage2.setOnClickListener {
            val intent = Intent(this, ImagesActivity::class.java)
            startActivity(intent)
            finish()
        }

//        upload.setOnClickListener{
//            val intent = Intent(this, UploadActivity::class.java)
//            startActivity(intent)
//            listFiles()
//        }


    }
//    private fun listFiles() = CoroutineScope(Dispatchers.IO).launch {
//        try {
//            val images = imageRef.child("images/").listAll().await()
//            val imageUrls = mutableListOf<String>()
//            for(image in images.items) {
//                val url = image.downloadUrl.await()
//                imageUrls.add(url.toString())
//            }
//            withContext(Dispatchers.Main) {
//                val imageAdapter = ImageAdapter(imageUrls)
//                rvImages.apply {
//                    adapter = imageAdapter
//                    layoutManager = LinearLayoutManager(this@ReportsActivity)
//                }
//            }
//        } catch(e: Exception) {
//            withContext(Dispatchers.Main) {
//                Toast.makeText(this@ReportsActivity, e.message, Toast.LENGTH_LONG).show()
//            }
//        }
//    }
//
//    private fun deleteImage(filename: String) = CoroutineScope(Dispatchers.IO).launch {
//        try {
//            imageRef.child("images/$filename").delete().await()
//            withContext(Dispatchers.Main) {
//                Toast.makeText(this@ReportsActivity, "Successfully deleted image.",
//                    Toast.LENGTH_LONG).show()
//            }
//        } catch(e: Exception) {
//            withContext(Dispatchers.Main) {
//                Toast.makeText(this@ReportsActivity, e.message, Toast.LENGTH_LONG).show()
//            }
//        }
//    }
//
//    private fun downloadImage(filename: String) = CoroutineScope(Dispatchers.IO).launch {
//        try {
//            val maxDownloadSize = 5L * 1024 * 1024
//            val bytes = imageRef.child("images/$filename").getBytes(maxDownloadSize).await()
//            val bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
//            withContext(Dispatchers.Main) {
//                ivImage.setImageBitmap(bmp)
//            }
//        } catch(e: Exception) {
//            withContext(Dispatchers.Main) {
//                Toast.makeText(this@ReportsActivity, e.message, Toast.LENGTH_LONG).show()
//            }
//        }
//    }
//
////    private fun uploadImageToStorage(filename: String) = CoroutineScope(Dispatchers.IO).launch {
////        try {
////            curFile?.let {
////                imageRef.child("images/$filename").putFile(it).await()
////                withContext(Dispatchers.Main) {
////                    Toast.makeText(this@ReportsActivity, "Successfully uploaded image",
////                        Toast.LENGTH_LONG).show()
////                }
////            }
////        } catch (e: Exception) {
////            withContext(Dispatchers.Main) {
////                Toast.makeText(this@ReportsActivity, e.message, Toast.LENGTH_LONG).show()
////            }
////        }
////    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if(resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_IMAGE_PICK) {
//            data?.data?.let {
//                curFile = it
//                ivImage.setImageURI(it)
//            }
//        }
//    }


}