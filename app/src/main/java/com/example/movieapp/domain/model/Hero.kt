package com.example.movieapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.movieapp.util.Constants.HERO_TABLE_NAME

@Entity(tableName = HERO_TABLE_NAME)
data class Hero(
    @PrimaryKey(autoGenerate = false)
    val id : Int,
    val name: String,
    val image : String,
    val about : String,
    val rating : Double,
    val power : Int,
    val month : String,
    val day : String,
    val family : List<String>,
    val abilities : List<String>,
    val natureTypes : List<String>,
)