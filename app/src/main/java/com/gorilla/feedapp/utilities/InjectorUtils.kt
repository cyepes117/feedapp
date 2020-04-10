package com.gorilla.feedapp.utilities

import android.content.Context
import com.gorilla.feedapp.data.AppDatabase
import com.gorilla.feedapp.data.FeedRepository
import com.gorilla.feedapp.viewmodels.CreatePostViewModelFactory
import com.gorilla.feedapp.viewmodels.FeedListViewModelFactory

object InjectorUtils {

    private fun getFeedRepository(context: Context): FeedRepository {
        return FeedRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).feedDao()
        )
    }

    fun provideFeedListViewModelFactory(
        context: Context
    ): FeedListViewModelFactory {
        val repository = getFeedRepository(context)
        return FeedListViewModelFactory(repository)
    }

    fun provideCreatePostViewModelFactory(
        context: Context
    ): CreatePostViewModelFactory {
        val repository = getFeedRepository(context)
        return CreatePostViewModelFactory(repository)
    }
}
