package com.example.movieapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.example.movieapp.domain.model.HeroRemoteKey

@Dao
interface HeroRemoteKeyDao {

    @Query("SELECT * FROM hero_remote_key_table WHERE id= :id")
    suspend fun getRemoteKey(id: Int) : HeroRemoteKey?

    @Insert(onConflict = REPLACE)
    suspend fun addAllRemoteKey(heroRemoteKeys : List<HeroRemoteKey>)

    @Query("DELETE FROM hero_remote_key_table")
    suspend fun deleteAllRemoteKeys()

}