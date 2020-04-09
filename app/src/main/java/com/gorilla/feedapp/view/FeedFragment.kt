package com.gorilla.feedapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.lifecycle.observe
import com.gorilla.feedapp.adapters.FeedAdapter
import com.gorilla.feedapp.databinding.FragmentFeedBinding
import com.gorilla.feedapp.utilities.InjectorUtils
import com.gorilla.feedapp.viewmodels.FeedListViewModel

class FeedFragment : Fragment() {

    private lateinit var binding: FragmentFeedBinding

    private val viewModel: FeedListViewModel by viewModels {
        InjectorUtils.provideFeedListViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeedBinding.inflate(inflater, container, false)
        val adapter = FeedAdapter()
        binding.feedList.adapter = adapter
        binding.feedButtonAdd.setOnClickListener {
            navigateToCreatePost()
        }
        subscribeUi(adapter, binding)
        return binding.root
    }

    private fun subscribeUi(adapter: FeedAdapter, binding: FragmentFeedBinding) {
        viewModel.feeds.observe(viewLifecycleOwner) { feed ->
            adapter.submitList(feed)
        }
    }

    private fun navigateToCreatePost() {
        val direction = FeedFragmentDirections.actionFeedFragmentToCreatePostFragment()
        findNavController().navigate(direction)
    }
}