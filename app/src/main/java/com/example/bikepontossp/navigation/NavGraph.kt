package com.example.bikepontossp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bikepontossp.screens.HomeScreen
import com.example.bikepontossp.screens.InitialScreen
import com.example.bikepontossp.screens.LoginScreen
import com.example.bikepontossp.screens.SignupScreen
import com.example.bikepontossp.screens.UserProfileScreen

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
            SignupScreen(
                onSignupSuccess = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.INITIAL) { inclusive = true }
                    }
                },
                onLoginClick = {
                    navController.navigate(Routes.LOGIN)
                }
            )
        }

        composable(Routes.LOGIN) {
            LoginScreen()
        }

        composable(Routes.HOME) {
            HomeScreen(
                onProfileClick = {
                    navController.navigate(Routes.PROFILE)
                }
            )
        }

        composable(Routes.PROFILE) {
            UserProfileScreen(
                onHomeClick = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.HOME) { inclusive = true }
                    }
                },
                onLogout = {
                    navController.navigate(Routes.INITIAL) {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }
    }
}
