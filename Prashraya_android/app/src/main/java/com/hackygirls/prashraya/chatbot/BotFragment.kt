package com.hackygirls.prashraya.chatbot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.hackygirls.prashraya.R

class BotFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_bot, container, false)
        view.findViewById<WebView>(R.id.webview).webViewClient = WebViewClient()
        view.findViewById<WebView>(R.id.webview).loadUrl("https://prasharya.pythonanywhere.com/bot/")


        return view
    }

}