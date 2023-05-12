package com.example.astro_booking_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SaccoAdapter(private val saccoList: ArrayList<Saccos>) : RecyclerView.Adapter<SaccoAdapter.SaccoViewHolder>() {
    class SaccoViewHolder(view:View) : RecyclerView.ViewHolder(view) {
        val sacconame:TextView = view.findViewById(R.id.saccoNameTV)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaccoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.sacco_item, parent, false)
        return SaccoViewHolder(view)
    }

    override fun getItemCount(): Int = saccoList.size

    override fun onBindViewHolder(holder: SaccoViewHolder, position: Int) {
        holder.sacconame.text = saccoList[position].name
    }


}