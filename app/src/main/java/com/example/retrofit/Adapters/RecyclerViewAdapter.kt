package com.example.retrofit.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.Models.UsersItem
import com.example.retrofit.databinding.ListItemBinding

class RecyclerViewAdapter(private val userList: List<UsersItem>):
RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
    inner class ViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder((ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.binding.apply {
            titleTxtView.text = currentItem.title
            bodyTxtView.text = currentItem.body
        }
    }
}