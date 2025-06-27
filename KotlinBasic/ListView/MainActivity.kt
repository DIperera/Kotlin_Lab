package com.example.listviewexample

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declare the ListView variable
    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the layout of this activity to activity_main.xml
        setContentView(R.layout.activity_main)

        // Link the listView variable to the ListView in XML
        listView = findViewById(R.id.listView)

        // Create a list of items to show in the ListView
        val items = listOf("Apple", "Banana", "Cherry", "Date", "Elderberry")

        // Create an ArrayAdapter to connect the list data with the ListView
        // Parameters:
        // 1. Context (this activity)
        // 2. Layout for each item (built-in Android layout)
        // 3. Data source (items list)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)

        // Set the adapter to the ListView to display the data
        listView.adapter = adapter

        // Handle click events on list items
        listView.setOnItemClickListener { _, _, position, _ ->
            // Get the item that was clicked using its position
            val selectedItem = items[position]

            // Show a Toast message with the selected item
            Toast.makeText(this, "Clicked: $selectedItem", Toast.LENGTH_SHORT).show()
        }
    }
}
