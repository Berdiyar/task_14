package com.example.a14_sabaq

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(val activity: MainActivity): RecyclerView.Adapter<ListView>() {

    var models: List<User> = listOf()

    fun setData(data: List<User>){
        models = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListView {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ListView(itemView)

    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onBindViewHolder(holder: ListView, position: Int) {
        holder.populateModel(models[position], activity)
    }


}