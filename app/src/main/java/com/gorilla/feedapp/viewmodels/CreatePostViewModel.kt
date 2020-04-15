package com.gorilla.feedapp.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gorilla.feedapp.data.Feed
import com.gorilla.feedapp.data.FeedRepository
import kotlinx.coroutines.launch
import java.util.*


class CreatePostViewModel internal constructor(
    private val feedRepository: FeedRepository
) : ViewModel() {

    var feedContent = ""
    val formattedCount = MutableLiveData(template(feedContent.length))
    val maxLength = MAX_COUNT

    val feed: Feed
        get() = Feed(
            date = Calendar.getInstance().time.toString(),
            content = feedContent
        )

    fun onTextChanged(s: CharSequence, start: Int, end: Int, count: Int) {
        formattedCount.value = template(s.length)
    }

    private fun template(length: Int) = "${length}/$MAX_COUNT"

    fun insertFeed(feed: Feed) = viewModelScope.launch {
        feedRepository.insertFeed(feed)
    }

    companion object {
        const val MAX_COUNT = 20
    }
}