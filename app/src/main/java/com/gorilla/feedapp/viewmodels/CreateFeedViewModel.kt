package com.gorilla.feedapp.viewmodels

import androidx.lifecycle.ViewModel
import com.gorilla.feedapp.data.Feed
import com.gorilla.feedapp.data.FeedRepository

class CreateFeedViewModel internal constructor(
    private val feedRepository: FeedRepository
) : ViewModel() {

    suspend fun insertFeed(feed: Feed) = feedRepository.insertFeed(feed)
}