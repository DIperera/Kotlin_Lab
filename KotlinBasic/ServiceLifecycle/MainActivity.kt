package com.example.myserviceapp

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myserviceapp.databinding.ActivityMainBinding
//ActivityMainBinding is just a safe shortcut to access views(ex: buttons) from activity_main.xml

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var myService: MyService? = null
    private var isBound = false

    // Connection to the service (for bindService)
    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as MyService.LocalBinder
            myService = binder.getService()
            isBound = true
            Log.d("MainActivity", "Service connected")
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            isBound = false
            Log.d("MainActivity", "Service disconnected")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Start Service
        binding.btnStartService.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            startService(intent) // calls onStartCommand
        }

        // Stop Service
        binding.btnStopService.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            stopService(intent)
        }

        // Bind Service
        binding.btnBindService.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            bindService(intent, connection, Context.BIND_AUTO_CREATE) // calls onBind
        }

        // Unbind Service
        binding.btnUnbindService.setOnClickListener {
            if (isBound) {
                unbindService(connection)
                isBound = false
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart called") // Activity lifecycle
    }
}
