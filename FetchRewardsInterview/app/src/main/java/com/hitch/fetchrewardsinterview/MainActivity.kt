package com.hitch.fetchrewardsinterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = MainViewModel(application)
        layoutManager = LinearLayoutManager(this)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = layoutManager
        val adapter = RecyclerAdapter()
        recyclerView.adapter = adapter
        adapter.loadItems(viewModel.items)

        viewModel.onItemsUpdated.observe(this, {
            adapter.loadItems(viewModel.items)
            adapter.notifyDataSetChanged()
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.getdata()
    }
}