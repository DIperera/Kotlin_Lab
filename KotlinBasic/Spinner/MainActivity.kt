package com.example.spinnerexample

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declare the Spinner variable
    private lateinit var mySpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the layout file to be shown when the activity starts
        setContentView(R.layout.activity_main)

        // Connect the Spinner in the layout file to this Kotlin code
        mySpinner = findViewById(R.id.mySpinner)

        // Create a list of items to show in the spinner
        val languages = listOf("English", "Spanish", "French", "German", "Chinese")

        // Create an ArrayAdapter (this helps show the list in the Spinner)
        // `this` = context, `simple_spinner_item` = layout for each item, `languages` = data source
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)

        // Set the layout to use when the dropdown appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Attach the adapter to the Spinner
        mySpinner.adapter = adapter

        // Set what happens when the user selects an item from the Spinner
        mySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            // Called when an item is selected
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // Get the selected item as a string
                val selected = parent.getItemAtPosition(position).toString()
                // Show a short message on the screen
                Toast.makeText(this@MainActivity, "Selected: $selected", Toast.LENGTH_SHORT).show()
            }

            // Called when nothing is selected (rarely used)
            override fun onNothingSelected(parent: AdapterView<*>) {
                // You can leave this empty
            }
        }
    }
}
