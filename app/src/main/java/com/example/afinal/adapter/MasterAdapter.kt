package com.example.afinal.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.afinal.R

class MasterAdapter (private val items: List<Triple<Int, String, String>>) :
    RecyclerView.Adapter<MasterAdapter.ViewHolder>()  {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView? = null
        var name: TextView? = null
        var year: TextView? = null

        init {
            image = itemView.findViewById(R.id.image_m)
            name = itemView.findViewById(R.id.Name)
            year = itemView.findViewById(R.id.live_year)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.rec_master, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image?.setImageResource(items[position].first)
        holder.name?.text = items[position].second
        holder.year?.text = items[position].third
    }

    override fun getItemCount() : Int {
        return items.size
    }
}