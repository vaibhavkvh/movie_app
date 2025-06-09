package com.example.movieapp.presentation.screens.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.movieapp.presentation.customWidget.CustomAppBar

@Composable
fun HomeScreen() {
    Scaffold(topBar = {CustomAppBar {  }}) { innerPadding ->

    }
}