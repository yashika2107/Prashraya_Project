package com.hackygirls.prashraya.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hackygirls.prashraya.R
import com.hackygirls.prashraya.databinding.FragmentSgnupBinding
import kotlinx.android.synthetic.main.fragment_sgnup.*

class SgnupFragment : Fragment() {
    private lateinit var binding : FragmentSgnupBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSgnupBinding.inflate(layoutInflater)

        binding.signup.setOnClickListener{
            var bundle = Bundle()
            bundle.putString("email",binding.emailInput.text.toString())
            bundle.putString("password",binding.pswrdInput.text.toString())
            bundle.putString("confirmpassword",binding.cpswrdInput.text.toString())
            findNavController().navigate(R.id.action_sgnupFragment_to_detailsFragment,bundle)
        }
        return binding.root
    }


}