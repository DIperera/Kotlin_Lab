package com.example.myserviceapp

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    private val binder = LocalBinder()

    // For bound service
    inner class LocalBinder : Binder() {
        fun getService(): MyService = this@MyService
    }

    // Called when service is started with startService()
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("MyService", "onStartCommand called")
        // Do background work here...
        return START_STICKY
    }

    // Called when Activity binds to this service
    override fun onBind(intent: Intent?): IBinder {
        Log.d("MyService", "onBind called")
        return binder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d("MyService", "onUnbind called")
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        Log.d("MyService", "onDestroy called")
        super.onDestroy()
    }
}
