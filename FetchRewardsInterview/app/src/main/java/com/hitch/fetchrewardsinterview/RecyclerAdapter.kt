package com.hitch.fetchrewardsinterview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<ItemHolder>() {
    private var items: List<Item> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun loadItems(newItems: List<Item>) {
        items = newItems
    }

}

class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var view: View = itemView

    fun bind(model: Item) {
        val id = view.findViewById<TextView>(R.id.id)
        val listid = view.findViewById<TextView>(R.id.listId)
        val name = view.findViewById<TextView>(R.id.name)


        id.text = model.id.toString()
        listid.text = model.listId.toString()
        name.text = model.name
    }
}