package com.gorilla.feedapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gorilla.feedapp.data.Feed
import com.gorilla.feedapp.databinding.ListItemFeedBinding
import com.gorilla.feedapp.viewmodels.FeedItemViewModel

class FeedAdapter : ListAdapter<Feed, RecyclerView.ViewHolder>(FeedDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FeedViewHolder(
            ListItemFeedBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = getItem(position)
        (holder as FeedViewHolder).bind(feed)
    }

    class FeedViewHolder(
        private val binding: ListItemFeedBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                binding.feed?.let { _ ->
                    //open feed.imageUrl
                }
            }
        }

        fun bind(item: Feed) {
            binding.apply {
                viewModel = FeedItemViewModel(item)
                executePendingBindings()
            }
        }
    }
}

private class FeedDiffCallback : DiffUtil.ItemCallback<Feed>() {

    override fun areItemsTheSame(oldItem: Feed, newItem: Feed): Boolean {
        return oldItem.feedId == newItem.feedId
    }

    override fun areContentsTheSame(oldItem: Feed, newItem: Feed): Boolean {
        return oldItem == newItem
    }
}
