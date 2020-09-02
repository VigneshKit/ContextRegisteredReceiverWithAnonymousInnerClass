package com.example.contextregisteredreceiverwithanonymousinnerclass

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var myBroadcastReceiver:BroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myBroadcastReceiver = object: BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {
                Toast.makeText(context,"Broadcast Received ${intent?.action}", Toast.LENGTH_LONG).show()
            }
        }
        var intentFilter = IntentFilter()
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE")

        registerReceiver(myBroadcastReceiver, intentFilter)
    }
}