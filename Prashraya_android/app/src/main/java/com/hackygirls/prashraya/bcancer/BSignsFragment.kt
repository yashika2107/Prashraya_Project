package com.hackygirls.prashraya.bcancer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.hackygirls.prashraya.R

class BCancFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_b_signs, container, false)
        // val url :String = arguments?.getString("https://www.irctctourism.com/wheelchair").toString()
        view.findViewById<WebView>(R.id.webview).webViewClient = WebViewClient()
        view.findViewById<WebView>(R.id.webview).loadUrl("https://www.cancer.org/cancer/breast-cancer/screening-tests-and-early-detection/breast-cancer-signs-and-symptoms.html")

        return view
    }


}