package com.example.classmate.model

import com.google.firebase.Timestamp

data class ChatPreview(
    val chatId: String = "",
    val partnerName: String = "",
    val lastMessage: String = "",
    val timestamp: Timestamp = Timestamp.now(),
    val unread: Boolean = false
)