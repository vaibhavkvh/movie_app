package com.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.movieapp.presentation.screens.home.HomeScreen
import com.example.movieapp.presentation.screens.splash.SplashScreen
import com.example.movieapp.presentation.screens.welcome.WelcomeScreen
import com.example.movieapp.util.Constants.DETAILS_ARGUMENT_KEY


@Composable
fun SetupNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.Splash.route) {

        composable(route = Screen.Splash.route) {
            SplashScreen(navHostController = navController)
        }

        composable(route = Screen.Welcome.route) {
            WelcomeScreen(navHostController = navController)
        }

        composable(route = Screen.Home.route) {
            HomeScreen()
        }

        /* composable(
             route = Screen.Details.route,
             arguments = listOf(navArgument(DETAILS_ARGUMENT_KEY) {
                 type = NavType.IntType
             })
         ) {

         }*/

        composable(route = Screen.Search.route) {

        }
    }
}