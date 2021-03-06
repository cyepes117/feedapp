package com.gorilla.feedapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gorilla.feedapp.data.FeedRepository

class CreatePostViewModelFactory(
    private val feedRepository: FeedRepository
): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CreatePostViewModel(feedRepository) as T
    }
}
