package com.hackygirls.prashraya

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hackygirls.prashraya.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private lateinit var binding :FragmentMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater)
        binding.pcos.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_pcosFragment)
        }
        binding.pcod.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_pcodFragment)
        }
        binding.ucanc.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_ucancFragment)
        }
        binding.bcanc.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_bcancerFragment)
        }
        binding.appointment.setOnClickListener {

            val url = "https://prasharya.pythonanywhere.com/bot/"
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))

        }
        binding.chatroom.setOnClickListener {
            val newApp = Intent(Intent.ACTION_MAIN)
            newApp.component = ComponentName("com.cometchat.pro.androiduikit", "com.cometchat.pro.androiduikit.MainActivity")
            startActivity(newApp)
        }
        binding.period.setOnClickListener {

            val newApp = Intent(Intent.ACTION_MAIN)
            newApp.component = ComponentName("com.example.customapp", "com.example.customapp.MainActivity")
            startActivity(newApp)
        }
        binding.exercises.setOnClickListener {

            val LaunchIntent: Intent? =
                context?.getPackageManager()?.getLaunchIntentForPackage("com.prasharya.PrasharyaV2")
            startActivity(LaunchIntent)

//            val intent = Intent(Intent.ACTION_MAIN);
//            intent.setComponent(ComponentName.unflattenFromString("com.prasharya.PrasharyaV2"));
//            intent.addCategory(Intent.CATEGORY_LAUNCHER);
//            startActivity(intent);
        }

       binding.reports.setOnClickListener {
           val intent = Intent(requireActivity(), UploadActivity::class.java)
           startActivity(intent)
       }
        return binding.root
    }

}