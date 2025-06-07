package com.example.movieapp.presentation.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.movieapp.R
import com.example.movieapp.presentation.viewmodels.SplashViewModel
import androidx.compose.runtime.getValue
import com.example.movieapp.ui.theme.Pink40
import com.example.movieapp.ui.theme.Purple40
import androidx.compose.runtime.*
import com.example.movieapp.navigation.Screen
import com.example.movieapp.util.Constants.SPLASH_DELAY
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navHostController: NavHostController,
    splashViewModel: SplashViewModel = hiltViewModel()
) {

    val isOnBoardingCompleted by splashViewModel.onBoardingCompletedState.collectAsState()
    LaunchedEffect(key1 = true) {
        delay(SPLASH_DELAY)
        if (isOnBoardingCompleted) {
            navHostController.popBackStack()
            navHostController.navigate(Screen.Home.route)
        } else {
            navHostController.popBackStack()
            navHostController.navigate(Screen.Welcome.route)
        }
    }

    Splash()
}


@Composable
fun Splash() {
    Box(
        modifier = Modifier
            .background(brush = Brush.verticalGradient(listOf(Purple40, Pink40)))
            .fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_app_icon),
            contentDescription = stringResource(R.string.app_icon)
        )
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    Splash()
}