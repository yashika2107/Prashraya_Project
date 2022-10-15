package com.hackygirls.prashraya.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hackygirls.prashraya.R
import com.hackygirls.prashraya.databinding.FragmentBcancerBinding

class BcancerFragment : Fragment() {

    private lateinit var binding : FragmentBcancerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBcancerBinding.inflate(inflater)
        binding.signs.setOnClickListener{
            findNavController().navigate(R.id.action_bcancerFragment_to_BCancFragment)
        }
        binding.donts.setOnClickListener{
            findNavController().navigate(R.id.action_bcancerFragment_to_bdoFragment)
        }
        return binding.root
    }


}