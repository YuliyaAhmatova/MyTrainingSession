package com.example.mytrainingsession

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ListAdapter(context: Context, exercisesList:MutableList<Exercise>): ArrayAdapter<Exercise>(context, R.layout.list_item, exercisesList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val exercise = getItem(position)
        if (view==null){
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent,false)
        }

        val gifItem = view?.findViewById<ImageView>(R.id.gifItem)
        val exerciseItemTV = view?.findViewById<TextView>(R.id.exerciseItemTV)

        gifItem?.setImageResource(exercise?.gifImage!!)
        exerciseItemTV?.text = exercise?.name

        return view!!
    }
}