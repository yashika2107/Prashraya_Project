package com.hackygirls.prashraya.dialogflow

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.hackygirls.prashraya.R
import kotlinx.android.synthetic.main.activity_dialog.*
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import kotlin.collections.ArrayList

class DialogActivity : AppCompatActivity() {
    private var messageList: ArrayList<Message> = ArrayList()

    //dialogFlow
//    private var sessionsClient: SessionsClient? = null
//    private var sessionName: SessionName? = null
//    private val uuid = UUID.randomUUID().toString()
//    private val TAG = "DialogActivity"
//    private lateinit var chatAdapter: ChatAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
        //setting adapter to recyclerview
//        chatAdapter = ChatAdapter(this, messageList)
//        chatView.adapter = chatAdapter
//
//        //onclick listener to update the list and call dialogflow
//        btnSend.setOnClickListener {
//            val message: String = editMessage.text.toString()
//            if (message.isNotEmpty()) {
//                addMessageToList(message, false)
//                sendMessageToBot(message)
//            } else {
//                Toast.makeText(this@DialogActivity, "Please enter text!", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        //initialize bot config
//        setUpBot()
    }
//    @SuppressLint("NotifyDataSetChanged")
//    private fun addMessageToList(message: String, isReceived: Boolean) {
//        messageList.add(Message(message, isReceived))
//        editMessage.setText("")
//        chatAdapter.notifyDataSetChanged()
//        chatView.layoutManager?.scrollToPosition(messageList.size - 1)
//    }
//
//    private fun setUpBot() {
//        try {
//            val stream = this.resources.openRawResource(R.raw.credential)
//            val credentials: GoogleCredentials = GoogleCredentials.fromStream(stream)
//                .createScoped("https://www.googleapis.com/auth/cloud-platform")
//            val projectId: String = (credentials as ServiceAccountCredentials).projectId
//            val settingsBuilder: SessionsSettings.Builder = SessionsSettings.newBuilder()
//            val sessionsSettings: SessionsSettings = settingsBuilder.setCredentialsProvider(
//                FixedCredentialsProvider.create(credentials)
//            ).build()
//            sessionsClient = SessionsClient.create(sessionsSettings)
//            sessionName = SessionName.of(projectId, uuid)
//            Log.d(TAG, "projectId : $projectId")
//        } catch (e: Exception) {
//            Log.d(TAG, "setUpBot: " + e.message)
//        }
//    }
//
//    private fun sendMessageToBot(message: String) {
//        val input = QueryInput.newBuilder()
//            .setText(TextInput.newBuilder().setText(message).setLanguageCode("en-US")).build()
//        GlobalScope.launch {
//            sendMessageInBg(input)
//        }
//    }
//
//    private suspend fun sendMessageInBg(
//        queryInput: QueryInput
//    ) {
//        withContext(Default) {
//            try {
//                val detectIntentRequest = DetectIntentRequest.newBuilder()
//                    .setSession(sessionName.toString())
//                    .setQueryInput(queryInput)
//                    .build()
//                val result = sessionsClient?.detectIntent(detectIntentRequest)
//                if (result != null) {
//                    runOnUiThread {
//                        updateUI(result)
//                    }
//                }
//            } catch (e: java.lang.Exception) {
//                Log.d(TAG, "doInBackground: " + e.message)
//                e.printStackTrace()
//            }
//        }
//    }
//
//    private fun updateUI(response: DetectIntentResponse) {
//        val botReply: String = response.queryResult.fulfillmentText
//        if (botReply.isNotEmpty()) {
//            addMessageToList(botReply, true)
//        } else {
//            Toast.makeText(this, "something went wrong", Toast.LENGTH_SHORT).show()
//        }
//    }
}