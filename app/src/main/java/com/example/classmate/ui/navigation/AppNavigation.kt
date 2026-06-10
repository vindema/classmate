package com.example.classmate.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.classmate.ui.auth.LandingScreen
import com.example.classmate.ui.auth.LoginScreen
import com.example.classmate.ui.auth.SignUpScreen
import com.example.classmate.ui.discover.DiscoverScreen
import com.example.classmate.ui.profile.EditProfileScreen
import com.example.classmate.ui.chat.MatchesScreen
import com.example.classmate.ui.chat.ChatScreen

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
                onNavigateToMatches = { navController.navigate(Destinations.MATCHES) },
                onNavigateToProfile = { navController.navigate(Destinations.EDIT_PROFILE) }
            )
        }
        composable(Destinations.MATCHES) {
            MatchesScreen(
                onNavigateToDiscover = { navController.navigate(Destinations.DISCOVER) },
                onNavigateToProfile = { navController.navigate(Destinations.EDIT_PROFILE) },
                onNavigateToChat = { chatId, partnerName ->
                    navController.navigate(Destinations.createChatRoute(chatId, partnerName))
                }
            )
        }
        composable(
            route = Destinations.CHAT,
            arguments = listOf(
                navArgument("chatId") { type = NavType.StringType },
                navArgument("partnerName") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val chatId = backStackEntry.arguments?.getString("chatId") ?: ""
            val partnerName = backStackEntry.arguments?.getString("partnerName") ?: "ClassMate"
            ChatScreen(
                chatId = chatId,
                partnerName = partnerName,
                currentUserId = "current_user_id_mock",
                onNavigateBack = { navController.popBackStack() }
            )
        }
        composable(Destinations.EDIT_PROFILE) {
            EditProfileScreen(
                onNavigateToDiscover = { navController.navigate(Destinations.DISCOVER) },
                onNavigateToMatches = { navController.navigate(Destinations.MATCHES) }
            )
        }
    }
}