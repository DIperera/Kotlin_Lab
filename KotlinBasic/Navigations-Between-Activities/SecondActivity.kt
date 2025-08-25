package com.example.myapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

// Second screen (Activity 2)
class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Connects this activity to its layout file: activity_second.xml
        setContentView(R.layout.activity_second)

        // Optional: Show back arrow on the Action Bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // What happens when user presses the back arrow on Action Bar
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed() // This will behave like the device back button
        return true
    }
}
