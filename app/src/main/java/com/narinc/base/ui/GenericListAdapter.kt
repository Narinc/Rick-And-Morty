package com.narinc.base.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class GenericListAdapter<T> private constructor(DIFF_CALLBACK: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, GenericListAdapter.ViewHolder<T>?>(DIFF_CALLBACK) {
    private var itemLayoutResource = 0
    private var clickListener: ItemClickListener<T>? = null
    private var selectionEnabled = false
    private var selectedItemPosition = RecyclerView.NO_POSITION
    private var clickableViewId = 0

    interface ItemClickListener<T> {
        fun onItemClicked(item: T)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder<T> {
        val inflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(inflater, itemLayoutResource, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder<T>,
        position: Int
    ) {
        val itemClickListener: ItemClickListener<T> =
            object : ItemClickListener<T> {
                override fun onItemClicked(item: T) {
                    if (position != RecyclerView.NO_POSITION) {
                        if (selectionEnabled) {
                            changeSelection(position)
                        }

                        clickListener?.onItemClicked(item)
                    }
                }
            }
        holder.onBind(
            getItem(position),
            clickableViewId,
            itemClickListener,
            selectedItemPosition
        )
    }

    private fun changeSelection(position: Int) {
        if (selectedItemPosition == position) {
            return
        }
        if (selectedItemPosition != RecyclerView.NO_POSITION) {
            notifyItemChanged(selectedItemPosition)
        }
        selectedItemPosition = position
        if (position != RecyclerView.NO_POSITION) {
            notifyItemChanged(position)
        }
    }

    class ViewHolder<T> internal constructor(protected val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(
            t: T,
            clickableViewId: Int,
            itemClickListener: ItemClickListener<T>?,
            selectedItemPosition: Int
        ) {
            binding.setVariable(BR.data, t)
            binding.root.isSelected = selectedItemPosition == bindingAdapterPosition
            if (clickableViewId != 0) {
                binding.root.findViewById<View>(clickableViewId)
                    .setOnClickListener { v: View? ->
                        itemClickListener?.onItemClicked(t)
                    }
            } else binding.root
                .setOnClickListener { v: View? ->
                    itemClickListener?.onItemClicked(t)
                }
            binding.executePendingBindings()
        }
    }

    open class Builder<T> {
        private var itemLayoutResource = 0
        private var listener: ItemClickListener<T>? = null
        private lateinit var itemDiffCallback: DiffUtil.ItemCallback<T>
        protected var selectionEnabled = false
        protected var defaultSelected = RecyclerView.NO_POSITION

        @IdRes
        protected var clickableViewId = 0

        private constructor() {}

        constructor(itemDiffCallback: DiffUtil.ItemCallback<T>) {
            this.itemDiffCallback = itemDiffCallback
        }

        fun itemLayoutResource(@LayoutRes resource: Int): Builder<T> {
            itemLayoutResource = resource
            return this
        }

        fun itemClickListener(listener: ItemClickListener<T>?): Builder<T> {
            this.listener = listener
            return this
        }

        fun selectionEnabled(selectionEnabled: Boolean): Builder<T> {
            this.selectionEnabled = selectionEnabled
            return this
        }

        fun selectionEnabled(
            selectionEnabled: Boolean,
            defaultSelected: Int
        ): Builder<T> {
            this.defaultSelected = defaultSelected
            return selectionEnabled(selectionEnabled)
        }

        fun setClickableViewId(clickableViewId: Int): Builder<T> {
            this.clickableViewId = clickableViewId
            return this
        }

        fun build(): GenericListAdapter<T> {
            require(itemLayoutResource != 0) { "No layout set for item views!" }
            val adapter = GenericListAdapter(itemDiffCallback)
            adapter.itemLayoutResource = itemLayoutResource
            adapter.clickListener = listener
            adapter.selectionEnabled = selectionEnabled
            adapter.selectedItemPosition = defaultSelected
            adapter.clickableViewId = clickableViewId
            return adapter
        }
    }

}

