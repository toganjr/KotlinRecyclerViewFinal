package com.example.recyclerviewkotlin

import android.graphics.ColorSpace
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AwesomeAdapter(private val onItemClicked: (ColorSpace.Model) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var data: List<User> = ArrayList(0)
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}