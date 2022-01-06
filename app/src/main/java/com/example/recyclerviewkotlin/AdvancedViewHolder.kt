package com.example.recyclerviewkotlin

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewkotlin.databinding.CardviewUserBinding
import com.example.recyclerviewkotlin.databinding.CardviewUserSpecialBinding


// Code for Higher Order Function with Listener called in onCreateViewHolder with Binding
class AdvancedViewHolder(view: View, viewName: View, onNameClicked: (String) -> Unit, onItemClicked: (User) -> Unit, retrieveUser: (Int) -> User) : RecyclerView.ViewHolder(view) {

    init {
        itemView.setOnClickListener {
            onItemClicked(retrieveUser(adapterPosition))
        }
        viewName.setOnClickListener{
            onNameClicked(retrieveUser(adapterPosition).name)
        }
    }

    fun bind(model: User) {
    }
}