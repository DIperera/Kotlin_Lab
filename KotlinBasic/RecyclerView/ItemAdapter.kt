import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adapter to bind data to the RecyclerView
class ItemAdapter(private val itemList: List<Item>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    // ViewHolder class: holds the view references for each item in the list
    // This improves performance by avoiding repeated calls to findViewById
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
