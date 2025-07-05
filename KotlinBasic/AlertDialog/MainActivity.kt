package com.example.alertdialogexample

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val showDialogBtn = findViewById<Button>(R.id.showDialogButton)

        showDialogBtn.setOnClickListener {
            // Create and show AlertDialog
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Confirm Action")
            builder.setMessage("Are you sure you want to continue?")
            builder.setPositiveButton("Yes") { dialog, _ ->
                Toast.makeText(this, "You clicked Yes", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            builder.setNegativeButton("No") { dialog, _ ->
                Toast.makeText(this, "You clicked No", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            builder.setCancelable(false) // prevents closing when touching outside
            val alertDialog = builder.create()
            alertDialog.show()
        }
    }
}
