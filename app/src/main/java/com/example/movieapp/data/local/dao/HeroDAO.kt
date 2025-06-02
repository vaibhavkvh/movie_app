package com.example.movieapp.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieapp.domain.model.Hero

@Dao
interface HeroDAO {

    @Query("SELECT * FROM hero_table ORDER BY id ASC")
    fun getAllHeroes(): PagingSource<Int, Hero>

    @Query("SELECT * FROM hero_table where id=:heroId")
    fun getSelectedHero(heroId: Int) : Hero

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun adHeroes(heroes : List<Hero>)

    @Query("DELETE FROM hero_table")
    suspend fun deleteAllHeroes()

}