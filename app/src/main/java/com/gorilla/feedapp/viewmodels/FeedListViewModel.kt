package com.gorilla.feedapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.gorilla.feedapp.data.Feed
import com.gorilla.feedapp.data.FeedRepository

class FeedListViewModel internal constructor(
    feedRepository: FeedRepository
) : ViewModel() {

    val feeds : LiveData<List<Feed>> = feedRepository.getFeed()
}