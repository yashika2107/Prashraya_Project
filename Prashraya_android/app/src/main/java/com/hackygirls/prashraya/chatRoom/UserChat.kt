package com.hackygirls.prashraya.chatRoom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.hackygirls.prashraya.R
import com.hackygirls.prashraya.dataclass.User

class UserChat : AppCompatActivity() {
    val userList = ArrayList<UserData>()
    lateinit var userRecyclerView : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_chat)

        userRecyclerView = findViewById(R.id.userRecyclerView)
        userRecyclerView.layoutManager = LinearLayoutManager(this)

//        imgProfile.setOnClickListener {
//            val intent = Intent(this,Profile::class.java)
//            startActivity(intent)
//        }

        getUserList()
    }
    private fun getUserList(){
        val auth: FirebaseUser? = FirebaseAuth.getInstance().currentUser
        val databaseRef: DatabaseReference = FirebaseDatabase.getInstance().getReference("Users")

        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                userList.clear()
                val currentUser = snapshot.getValue(UserData::class.java)
                print(currentUser)
//                if(currentUser!!.userImage == ""){
//                    imgProfile.setImageResource(R.drawable.profile_image)
//                } else {
//                    Glide.with(this@Users).load(currentUser.userImage).into(imgProfile)
//                }
                for(dataSnapShot: DataSnapshot in snapshot.children){
                    val user = dataSnapShot.getValue(UserData::class.java)
                    if(user!!.userID != auth?.uid){
                        userList.add(user)
                    }
                }
                val userAdapter = UserAdapter(this@UserChat, userList)
                userRecyclerView.adapter = userAdapter
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}