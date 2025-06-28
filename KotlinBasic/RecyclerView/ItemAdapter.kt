import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adapter to bind data to the RecyclerView
class ItemAdapter(private val itemList: List<Item>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Reference to the TextView in item_row.xml that displays item text
        val textViewItem: TextView = itemView.findViewById(R.id.textViewItem)
    }

    // Called when RecyclerView needs a new ViewHolder (i.e., creating new row views)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // Inflate the layout for a single row/item from item_row.xml
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row, parent, false)

        // Return a new ViewHolder that holds this newly created view
        return ItemViewHolder(view)
    }

    // Called by RecyclerView to bind data to a ViewHolder at a specific position
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // Get the item object at the given position in the list
        val item = itemList[position]

        // Set the text of the TextView to display this item's text
        holder.textViewItem.text = item.text
    }

    // Returns the total number of items in the data set
    // RecyclerView uses this to determine how many items to render
    override fun getItemCount(): Int = itemList.size
}

/*
🔴 Example Execution Flow (Suppose you have 3 items):

1.  recyclerView.adapter = adapter
--> RecyclerView asks: "How many items do I have?"
--> Calls **getItemCount()** → returns 3

2. RecyclerView creates only enough views to fit on screen (say 2–3), so:
--> Calls onCreateViewHolder() → inflates item_row.xml layout
--> Calls onBindViewHolder() for position 0 → binds "Apple"
--> Calls onCreateViewHolder() again
--> Calls onBindViewHolder() for position 1 → binds "Banana"

3. You scroll down:
--> Reuses the ViewHolder already created
--> Calls onBindViewHolder() again for position 2 → binds "Cherry"

🔴 When These Functions Are Called ?

RecyclerView internally calls getItemCount() to decide how many ViewHolders it should prepare.
✅ 1. getItemCount()

📍 Called by RecyclerView when it needs to know how many items are in the list.
🔁 Called once initially when setting the adapter, and may be called again when the data set changes.

✅ 2. onBindViewHolder(holder, position)
📍 Called by RecyclerView when it is ready to display data at a specific position.
🔁 Called repeatedly as you scroll through the list.
💡 It binds the data (itemList[position]) to the UI (holder.textViewItem.text = item.text).

🔴 Why ": RecyclerView.Adapter<ItemAdapter.ItemViewHolder>()"? 

--> This means the class ItemAdapter is inheriting from (: means "extends") RecyclerView.Adapter.
RecyclerView.Adapter<...> is a generic class that needs a ViewHolder type.
You're passing your own ViewHolder class: ItemAdapter.ItemViewHolder.

## class ItemAdapter(...)        --> Defines a new class that holds a list of Items.
## private val itemList          --> Saves the list inside the adapter for internal use.
## : RecyclerView.Adapter<...>() --> Makes this class behave like an adapter for RecyclerView.
## ItemAdapter.ItemViewHolder    --> Says that this adapter will use an inner ItemViewHolder class to manage views.

*/
