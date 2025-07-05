// Package name for the project
package com.example.alertdialogexample

// Importing necessary Android libraries
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

// This is the main activity class of the app, where the UI starts
class MainActivity : AppCompatActivity() {

    // This function runs when the activity is created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the layout for this activity (activity_main.xml)
        setContentView(R.layout.activity_main)

        // Find the Button from the XML layout using its ID
        val showDialogBtn = findViewById<Button>(R.id.showDialogButton)

        // Set a click listener on the button
        showDialogBtn.setOnClickListener {

            // Create an AlertDialog builder using the current activity as context
            val builder = AlertDialog.Builder(this)

            // Set the title of the dialog
            builder.setTitle("Confirm Action")

            // Set the message (main text) of the dialog
            builder.setMessage("Are you sure you want to continue?")

            // Set the action for the "Yes" button
            builder.setPositiveButton("Yes") { dialog, _ ->
                // Show a short message (Toast) when "Yes" is clicked
                Toast.makeText(this, "You clicked Yes", Toast.LENGTH_SHORT).show()

                // Close the dialog
                dialog.dismiss()
            }

            // Set the action for the "No" button
            builder.setNegativeButton("No") { dialog, _ ->
                // Show a message when "No" is clicked
                Toast.makeText(this, "You clicked No", Toast.LENGTH_SHORT).show()

                // Close the dialog
                dialog.dismiss()
            }

            // Make sure the dialog cannot be dismissed by tapping outside it
            builder.setCancelable(false)

            // Create the actual AlertDialog from the builder
            val alertDialog = builder.create()

            // Finally, show the dialog on the screen
            alertDialog.show()
        }
    }
}
