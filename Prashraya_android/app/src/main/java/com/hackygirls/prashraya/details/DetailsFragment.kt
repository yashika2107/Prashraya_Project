package com.hackygirls.prashraya.details

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.hackygirls.prashraya.HomeActivity
import com.hackygirls.prashraya.MainActivity
import com.hackygirls.prashraya.R
import com.hackygirls.prashraya.databinding.FragmentDetailsBinding
import com.hackygirls.prashraya.databinding.FragmentSgnupBinding
import com.hackygirls.prashraya.dataclass.User
import com.hackygirls.prashraya.dialogflow.DialogActivity
import kotlinx.android.synthetic.main.fragment_sgnup.*

class DetailsFragment : Fragment() {
    private lateinit var binding : FragmentDetailsBinding
    private lateinit var auth: FirebaseAuth

    private lateinit var name : String
    private lateinit var pho : String
    private lateinit var gender : String
    private lateinit var dob : String
    private lateinit var disease : String
    private lateinit var weight : String
    private lateinit var height : String
    private lateinit var symp : String
//    private var args : DetailsFragmen

    private val args : DetailsFragmentArgs by navArgs<DetailsFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(layoutInflater)
        var email = args.email.toString()
        var pass = args.password.toString()
        var confirmPassword = args.confirmpassword.toString()

        auth = FirebaseAuth.getInstance()
        var bundle = this.arguments
        if(bundle!=null){
            email =    bundle.getString("email").toString()
            pass =     bundle.getString("password").toString()
            confirmPassword = bundle.getString("confirmpassword").toString()
        }


        binding.submit.setOnClickListener {
//            signUpUser()
            name = binding.nameInput.text.toString().trim()
            pho = binding.phoneInput.text.toString().trim()
            gender = binding.genderInput.text.toString().trim()
            dob = binding.dobInput.text.toString().trim()
            disease = binding.disInput.text.toString().trim()
            weight = binding.weightInput.text.toString().trim()
            height = binding.heightInput.text.toString().trim()
            symp = binding.sympInput.text.toString().trim()


            if (email.isBlank() || pass.isBlank() || confirmPassword.isBlank()) {
                Toast.makeText(context, "Email and Password can't be blank", Toast.LENGTH_SHORT).show()
            }

            if (pass != confirmPassword) {
                Toast.makeText(context, "Password and Confirm Password do not match", Toast.LENGTH_SHORT)
                    .show()
            }
            auth.createUserWithEmailAndPassword(email, pass).addOnSuccessListener {
                val user = User(email, pass, name, pho, gender, dob, disease, weight, height, symp)
                FirebaseDatabase.getInstance().getReference("Users")
                    .child(FirebaseAuth.getInstance().currentUser!!.uid)
                    .setValue(user).addOnCompleteListener {
                        Toast.makeText(context, "Registration Successful", Toast.LENGTH_SHORT)
                            .show()
                        val intent = Intent(requireActivity(), HomeActivity::class.java)
                        startActivity(intent)
                    }
                    .addOnFailureListener {
                        Toast.makeText(context, "Failed! Try again", Toast.LENGTH_SHORT).show()

                    }

            }
                .addOnFailureListener { e ->
                    Toast.makeText(context, "Signup failed due to ${e.message}", Toast.LENGTH_SHORT)
                        .show()

                }
        }

        return binding.root
    }


}