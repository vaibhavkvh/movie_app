package com.example.movieapp.presentation.screens.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.movieapp.presentation.customWidget.CustomAppBar
import com.example.movieapp.presentation.viewmodels.HomeViewModel

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel()) {

    val allHeroes = homeViewModel.getAllHeroes.collectAsLazyPagingItems()
    Scaffold(topBar = {CustomAppBar {  }}) { innerPadding ->

    }
}