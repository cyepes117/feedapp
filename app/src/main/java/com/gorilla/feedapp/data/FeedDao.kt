package com.gorilla.feedapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FeedDao {
    @Query("SELECT * FROM plants ORDER BY title")
    fun getFeed(): LiveData<List<Feed>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(feed: Feed)
}
