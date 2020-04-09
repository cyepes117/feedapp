package com.gorilla.feedapp.data

class FeedRepository private constructor(private val feedDao: FeedDao) {

    fun getFeed() = feedDao.getFeed()

    suspend fun insertFeed(feed: Feed) = feedDao.insert(feed)

    companion object {
        @Volatile private var instance: FeedRepository? = null
        fun getInstance(feedDao: FeedDao) =
                instance ?: synchronized(this) {
                    instance ?: FeedRepository(feedDao).also { instance = it }
                }
    }
}
