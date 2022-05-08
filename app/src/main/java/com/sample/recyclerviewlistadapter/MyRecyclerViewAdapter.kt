package com.sample.recyclerviewlistadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sample.recyclerviewlistadapter.databinding.LayoutViewholderBinding
import java.util.*

class MyRecyclerViewAdapter: androidx.recyclerview.widget.ListAdapter<Monster, RecyclerView.ViewHolder>(MyDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder = MyViewHolder(
            LayoutViewholderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is MyViewHolder){
            val monster = getItem(position) as Monster
            holder.bind(monster)
        }
    }

    fun moveItem(fromPosition: Int, toPosition: Int){
        val newList = currentList.toMutableList()
        Collections.swap(newList, fromPosition, toPosition)
        submitList(newList)
    }

    fun removeItem(position: Int){
        val newList = currentList.toMutableList()
        newList.removeAt(position)
        submitList(newList)
    }

}