package com.example.classmate.ui.navigation

object Destinations {
    const val LANDING = "landing"
    const val LOGIN = "login"
    const val SIGN_UP = "sign_up"
    const val DISCOVER = "discover"
    const val MATCHES = "matches"
    const val EDIT_PROFILE = "edit_profile" // Added back in!
    const val CHAT = "chat/{chatId}/{partnerName}"

    fun createChatRoute(chatId: String, partnerName: String) = "chat/$chatId/$partnerName"
}