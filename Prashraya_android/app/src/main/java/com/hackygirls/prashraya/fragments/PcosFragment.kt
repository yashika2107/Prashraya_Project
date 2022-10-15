package com.hackygirls.prashraya.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hackygirls.prashraya.R
import com.hackygirls.prashraya.databinding.FragmentBcancerBinding
import com.hackygirls.prashraya.databinding.FragmentPcosBinding

class PcosFragment : Fragment() {

    private lateinit var binding : FragmentPcosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPcosBinding.inflate(inflater)
        binding.signs.setOnClickListener{
            findNavController().navigate(R.id.action_pcosFragment_to_pcosSignsFragment)
        }
        binding.donts.setOnClickListener{
            findNavController().navigate(R.id.action_pcosFragment_to_pcosDoFragment2)
        }
        return binding.root
    }

}