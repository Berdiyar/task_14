package com.example.a14_sabaq

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class ListView(itemview: View): RecyclerView.ViewHolder(itemview){
    val tvTitle: TextView = itemview.tvTitle
    val tvDescription: TextView = itemview.tvDescription
    var idnomer: Int = itemview.id

    fun populateModel(user: User, activity: MainActivity){
        tvTitle.text = user.title
        tvDescription.text = user.description
        idnomer = user.idnomer
        itemView.setOnClickListener{
            activity.onClick(user.idnomer)
        }
        itemView.nast.setOnClickListener {
            activity.onOpButClick(itemView.nast, user.idnomer)
        }
    }

}