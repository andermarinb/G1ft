package com.example.gifth.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gifth.screens.Login

@Composable
fun AppNavigation(){
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = AppScreens.Login.route) {
        composable(AppScreens.Login.route) { Login(navigationController) }
    }
}