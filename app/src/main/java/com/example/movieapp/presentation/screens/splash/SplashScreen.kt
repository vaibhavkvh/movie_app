package com.example.movieapp.presentation.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.movieapp.R
import com.example.movieapp.ui.theme.Pink40
import com.example.movieapp.ui.theme.Purple40

@Composable
fun SplashScreen(navHostController: NavHostController) {

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