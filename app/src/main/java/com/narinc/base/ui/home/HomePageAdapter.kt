package com.narinc.base.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.narinc.base.data.model.Item
import com.narinc.base.databinding.ItemCharacterBinding

class HomePageAdapter :
    PagingDataAdapter<Item, HomePageAdapter.ViewHolder>(diffCallback = DIFF_CALLBACK) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCharacterBinding.inflate(
            inflater,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    class ViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.data = item
            binding.root.setOnClickListener { view ->
                navigateToDetail(item, view)
            }
            binding.executePendingBindings()
        }

        private fun navigateToDetail(item: Item, view: View) {
            val directions = HomeFragmentDirections.actionHomeFragmentToDetailFragment(item)
            view.findNavController().navigate(directions)
        }
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<Item> =
            object : DiffUtil.ItemCallback<Item>() {
                override fun areItemsTheSame(oldItem: Item, newItem: Item) =
                    oldItem == newItem

                override fun areContentsTheSame(oldItem: Item, newItem: Item) =
                    oldItem.id == newItem.id
            }
    }
}