package com.example.movieapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.movieapp.util.Constants.HERO_REMOTE_KEYS_TABLE_NAME

@Entity(tableName = HERO_REMOTE_KEYS_TABLE_NAME)
data class HeroRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?
)
