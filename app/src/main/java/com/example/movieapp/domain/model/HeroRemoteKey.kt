package com.example.movieapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.movieapp.util.Constants.HERO_REMOTE_KEY_TABLE_NAME

@Entity(tableName = HERO_REMOTE_KEY_TABLE_NAME)
data class HeroRemoteKey(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage : Int,
    val nextPage : Int
)
