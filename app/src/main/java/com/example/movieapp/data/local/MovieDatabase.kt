package com.example.movieapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.movieapp.data.local.dao.HeroDAO
import com.example.movieapp.data.local.dao.HeroRemoteKeyDao
import com.example.movieapp.domain.model.Hero
import com.example.movieapp.domain.model.HeroRemoteKeys

@Database(entities = [Hero::class, HeroRemoteKeys::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class MovieDatabase : RoomDatabase(){
    abstract fun heroDao() : HeroDAO
    abstract fun heroRemoteKeyDao() : HeroRemoteKeyDao
}