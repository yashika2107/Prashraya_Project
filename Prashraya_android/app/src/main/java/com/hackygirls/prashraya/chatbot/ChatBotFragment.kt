package com.hackygirls.prashraya.chatbot

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.hackygirls.prashraya.R

class ChatBotFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_chat_bot, container, false)
        // val url :String = arguments?.getString("https://www.irctctourism.com/wheelchair").toString()
//        view.findViewById<WebView>(R.id.webview).webViewClient = WebViewClient()
//        view.findViewById<WebView>(R.id.webview).loadUrl("https://prasharya.pythonanywhere.com/bot/")

//        val url :String = arguments?.getString("https://prasharya.pythonanywhere.com/bot/").toString()
//        view.findViewById<WebView>(R.id.webview).webViewClient = WebViewClient()
//        view.findViewById<WebView>(R.id.webview).loadUrl("https://prasharya.pythonanywhere.com/bot/")

        val url = "https://prasharya.pythonanywhere.com/bot/"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)

        return view
    }


}