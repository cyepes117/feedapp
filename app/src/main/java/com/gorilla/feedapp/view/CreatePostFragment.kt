package com.gorilla.feedapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.gorilla.feedapp.databinding.FragmentCreatePostBinding
import com.gorilla.feedapp.databinding.FragmentFeedBinding
import com.gorilla.feedapp.utilities.InjectorUtils
import com.gorilla.feedapp.viewmodels.FeedListViewModel

class CreatePostFragment : Fragment() {

    private lateinit var binding: FragmentCreatePostBinding

    private val viewModel: FeedListViewModel by viewModels {
        InjectorUtils.provideFeedListViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreatePostBinding.inflate(inflater, container, false)
        return binding.root
    }
}