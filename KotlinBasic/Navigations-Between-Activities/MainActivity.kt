package com.example.myapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

// First screen (Activity 1)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Connects this activity to its layout file: activity_main.xml
        setContentView(R.layout.activity_main)

        // Find the button we created in activity_main.xml
        val btnGo = findViewById<Button>(R.id.btnGo)

        // When user clicks the button -> open SecondActivity
        btnGo.setOnClickListener {
            // Intent = "I want to go from this Activity to another one"
            val intent = Intent(this, SecondActivity::class.java)

            // Start SecondActivity
            startActivity(intent)
        }
    }
}
