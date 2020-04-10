package com.gorilla.feedapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "feeds")
data class Feed(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val feedId: Int = 0,
    val title: String = "",
    val date: String,
    val content: String,
    val imageUrl: String = ""
)
