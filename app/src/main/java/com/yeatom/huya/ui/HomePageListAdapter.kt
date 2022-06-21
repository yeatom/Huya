package com.yeatom.huya.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yeatom.huya.LiveComponent.LiveItem
import com.yeatom.huya.databinding.FragmentItemHomePageContentBinding

class HomePageListAdapter : ListAdapter<LiveItem, HomePageListAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<LiveItem>() {
        override fun areItemsTheSame(oldItem: LiveItem, newItem: LiveItem): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: LiveItem, newItem: LiveItem): Boolean {
            return false
        }
    }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(FragmentItemHomePageContentBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }

    class ViewHolder(binding: FragmentItemHomePageContentBinding) : RecyclerView.ViewHolder(binding.root) {
        val container = binding.itemContainer
        val title = binding.itemTitle
        fun bindView(item: LiveItem) {
            ImageView(itemView.context).run {
                Glide.with(itemView).load(item.image).into(this)
                container.addView(this)
            }
            title.text = item.title
        }
    }
}