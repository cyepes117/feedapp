package com.gorilla.feedapp.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.gorilla.feedapp.R
import com.gorilla.feedapp.data.Feed
import com.gorilla.feedapp.databinding.FragmentCreatePostBinding
import com.gorilla.feedapp.utilities.InjectorUtils
import com.gorilla.feedapp.viewmodels.CreatePostViewModel

class CreatePostFragment : Fragment() {

    private lateinit var binding: FragmentCreatePostBinding

    private val createPostViewModel: CreatePostViewModel by viewModels {
        InjectorUtils.provideCreatePostViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreatePostBinding.inflate(inflater, container, false).apply {
            viewModel = createPostViewModel
            lifecycleOwner = viewLifecycleOwner
            callback = object : Callback {
                override fun add(feed: Feed?) {
                    feed?.let {
                        createPostViewModel.insertFeed(it)
                        Snackbar.make(root, "Feed added", Snackbar.LENGTH_LONG).show()
                        root.findNavController().navigateUp()
                    }
                }
            }

            toolbar.setNavigationOnClickListener { view ->
                view.findNavController().navigateUp()
            }

            toolbar.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.action_share -> {
                        createShareIntent()
                        true
                    }
                    else -> false
                }
            }
            (activity as? AppCompatActivity)?.setSupportActionBar(toolbar)
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun createShareIntent() {
        val shareText = getString(R.string.share_text_feed,
            createPostViewModel.feed.content.take(10))
        val shareIntent = ShareCompat.IntentBuilder.from(requireActivity())
            .setText(shareText)
            .setType("text/plain")
            .createChooserIntent()
            .addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT or Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
        startActivity(shareIntent)
    }

    interface Callback {
        fun add(feed: Feed?)
    }
}