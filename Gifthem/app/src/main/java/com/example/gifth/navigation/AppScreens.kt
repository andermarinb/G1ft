package com.example.gifth.navigation

sealed class AppScreens(val route: String) {
    object Login: AppScreens("login_screen")
}