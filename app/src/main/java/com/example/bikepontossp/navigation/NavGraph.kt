package com.example.bikepontossp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bikepontossp.screens.InitialScreen
import com.example.bikepontossp.screens.LoginScreen
import com.example.bikepontossp.screens.SignupScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.INITIAL
    ) {
        composable(Routes.INITIAL) {
            InitialScreen(
                onStartClick = {
                    navController.navigate(Routes.SIGNUP)
                },
                onLoginClick = {
                    navController.navigate(Routes.LOGIN)
                }
            )
        }

        composable(Routes.SIGNUP) {
            SignupScreen()

        composable(Routes.LOGIN){
            LoginScreen()
        }


        }
    }
}

