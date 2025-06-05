package com.example.movieapp.domain.model

import androidx.annotation.DrawableRes
import com.example.movieapp.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
){
    object First : OnBoardingPage(
        image = R.drawable.ic_welcome_back,
        title = "Greetings",
        description = "Welcome to the movie app welcome screen 1 dummy description"
    )

    object Second : OnBoardingPage(
        image = R.drawable.ic_explore,
        title = "Explore",
        description = "Welcome to the movie app welcome screen 2 dummy description"
    )

    object Third : OnBoardingPage(
        image = R.drawable.ic_empowerment,
        title = "Empowerment",
        description = "Welcome to the movie app welcome screen 3 dummy description"
    )
}