package com.hackygirls.prashraya

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.hackygirls.prashraya.dataclass.User

class SignupActivity : AppCompatActivity() {
    lateinit var etEmail: EditText
    lateinit var etConfPass: EditText
    private lateinit var etPass: EditText
    lateinit var btnSignUp: TextView
    lateinit var tvRedirectLogin: TextView

    // create Firebase authentication object
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

//        etEmail = findViewById(R.id.emailInput)
//        etPass = findViewById(R.id.pswrdInput)
//        etConfPass = findViewById(R.id.cpswrdInput)
//        btnSignUp = findViewById(R.id.signup)
//
//        auth = FirebaseAuth.getInstance()
//
//        btnSignUp.setOnClickListener {
//            signUpUser()
//        }

    }
//    override fun onBackPressed() {
//        moveTaskToBack(true)
//    }
//    private fun signUpUser() {
//        val email = etEmail.text.toString()
//        val pass = etPass.text.toString()
//        val confirmPassword = etConfPass.text.toString()
//
//        // check pass
//        if (email.isBlank() || pass.isBlank() || confirmPassword.isBlank()) {
//            Toast.makeText(this, "Email and Password can't be blank", Toast.LENGTH_SHORT).show()
//            return
//        }
//
//        if (pass != confirmPassword) {
//            Toast.makeText(this, "Password and Confirm Password do not match", Toast.LENGTH_SHORT)
//                .show()
//            return
//        }
//        // If all credential are correct
//        // We call createUserWithEmailAndPassword
//        // using auth object and pass the
//        // email and pass in it.
//
//        auth.createUserWithEmailAndPassword(email, pass).addOnSuccessListener {
//
//            val user = User(email, pass)
//            FirebaseDatabase.getInstance().getReference("Users")
//                .child(FirebaseAuth.getInstance().currentUser!!.uid)
//                .setValue(user).addOnCompleteListener {
//                    Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT)
//                        .show()
//                    val intent = Intent(this, ProfileActivity::class.java)
//                startActivity(intent)
//                finish()
//
//                }
//                .addOnFailureListener {
//                    Toast.makeText(this, "Failed! Try again", Toast.LENGTH_SHORT).show()
//
//                }
//
//        }
//            .addOnFailureListener { e ->
//                Toast.makeText(this, "Signup failed due to ${e.message}", Toast.LENGTH_SHORT)
//                    .show()
//
//            }
////        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
////            if (it.isSuccessful) {
////                Toast.makeText(this, "Successfully Singed Up", Toast.LENGTH_SHORT).show()
////                val intent = Intent(this, ProfileActivity::class.java)
////                startActivity(intent)
////                finish()
////            } else {
////                Toast.makeText(this, "Singed Up Failed!", Toast.LENGTH_SHORT).show()
////            }
////        }
//    }
}