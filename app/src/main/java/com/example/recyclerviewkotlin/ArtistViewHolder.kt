package com.example.recyclerviewkotlin

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewkotlin.databinding.CardviewUserBinding
import com.example.recyclerviewkotlin.databinding.CardviewUserSpecialBinding

class ArtistViewHolder( view: View, onItemClicked: (Int) -> Unit) : RecyclerView.ViewHolder(view) {
    init {
        itemView.setOnClickListener {
            onItemClicked(adapterPosition)
        }
    }

    fun bind(model: User) {
    }
}