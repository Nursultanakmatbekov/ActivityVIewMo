package com.example.activityviewmo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.activityviewmo.data.model.Model
import com.example.activityviewmo.databinding.ItemRecBinding

class NotesAdapter(): ListAdapter<Model, NotesAdapter.ViewHolder>(diffutil) {

     class ViewHolder(private val binding: ItemRecBinding) :
         RecyclerView.ViewHolder(binding.root) {
         fun onBind(item: Model?) {
             binding.tvName.text = item?.name.toString()
             binding.tvAge.text = item?.age.toString()
             binding.tvEmail.text = item?.email.toString()
         }
     }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         return ViewHolder(
             ItemRecBinding.inflate(LayoutInflater.from(parent.context), parent, false)
         )
     }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         getItem(position).let {
             holder.onBind(it)
         }
     }

     companion object {
         private val diffutil = object : DiffUtil.ItemCallback<Model>() {
             override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean {
                 return oldItem.name == newItem.name
             }

             override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean {
                 return oldItem == newItem
             }
         }
     }
 }

