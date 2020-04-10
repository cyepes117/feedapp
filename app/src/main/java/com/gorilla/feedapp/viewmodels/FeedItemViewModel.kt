package com.gorilla.feedapp.viewmodels

import com.gorilla.feedapp.data.Feed
import java.text.SimpleDateFormat
import java.util.*

class FeedItemViewModel(val feed: Feed) {

    val title
        get() = feed.feedId.toString()
    val content
        get() = feed.content
    val imageUrl
        get() = feed.imageUrl
    val date: String
        get() = feed.date
    //get() = dateFormat.format(feed.date)

    companion object {
        private val dateFormat = SimpleDateFormat("MMM d, yyyy", Locale.US)
    }
}
