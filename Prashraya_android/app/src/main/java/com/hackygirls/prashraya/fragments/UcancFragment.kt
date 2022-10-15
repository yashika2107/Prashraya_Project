package com.hackygirls.prashraya.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hackygirls.prashraya.R
import com.hackygirls.prashraya.databinding.FragmentBcancerBinding
import com.hackygirls.prashraya.databinding.FragmentUcancBinding

class UcancFragment : Fragment() {
   private lateinit var binding : FragmentUcancBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUcancBinding.inflate(inflater)
        binding.signs.setOnClickListener{
            findNavController().navigate(R.id.action_ucancFragment_to_USignsFragment)
        }
        binding.donts.setOnClickListener{
            findNavController().navigate(R.id.action_ucancFragment_to_udoFragment)
        }
        return binding.root
    }

}