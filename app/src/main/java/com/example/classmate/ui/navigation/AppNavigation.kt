package com.example.classmate.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.classmate.ui.auth.LandingScreen
import com.example.classmate.ui.auth.LoginScreen
import com.example.classmate.ui.auth.SignUpScreen
import com.example.classmate.ui.discover.DiscoverScreen
import com.example.classmate.ui.profile.EditProfileScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Destinations.LANDING) {
        composable(Destinations.LANDING) {
            LandingScreen(
                onNavigateToLogin = { navController.navigate(Destinations.LOGIN) },
                onNavigateToSignUp = { navController.navigate(Destinations.SIGN_UP) }
            )
        }
        composable(Destinations.LOGIN) {
            LoginScreen(
                onLoginSuccess = { navController.navigate(Destinations.DISCOVER) }
            )
        }
        composable(Destinations.SIGN_UP) {
            SignUpScreen(
                onSignUpSuccess = { navController.navigate(Destinations.DISCOVER) }
            )
        }
        composable(Destinations.DISCOVER) {
            DiscoverScreen(
                onNavigateToProfile = { navController.navigate(Destinations.EDIT_PROFILE) }
            )
        }
        composable(Destinations.EDIT_PROFILE) {
            EditProfileScreen(
                onNavigateToDiscover = { navController.navigate(Destinations.DISCOVER) }
            )
        }
    }
}