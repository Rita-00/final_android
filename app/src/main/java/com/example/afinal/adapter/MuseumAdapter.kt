package com.example.afinal.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.afinal.R

class MuseumAdapter (private val items: List<Triple<Int, String, String>>) :
    RecyclerView.Adapter<MuseumAdapter.ViewHolder>()  {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView? = null
        var name: TextView? = null
        var city: TextView? = null

        init {
            image = itemView.findViewById(R.id.image_mu)
            name = itemView.findViewById(R.id.name_m)
            city = itemView.findViewById(R.id.city)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.rec_museum, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image?.setImageResource(items[position].first)
        holder.name?.text = items[position].second
        holder.city?.text = items[position].third
    }

    override fun getItemCount() : Int {
        return items.size
    }
}