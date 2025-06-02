package com.example.movieapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movieapp.data.local.dao.HeroDAO
import com.example.movieapp.domain.model.Hero

@Database(entities = [Hero::class], version = 1)
abstract class MovieDatabase : RoomDatabase(){
    abstract fun heroDao() : HeroDAO
}