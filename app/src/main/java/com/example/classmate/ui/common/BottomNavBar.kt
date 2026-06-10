package com.example.classmate.ui.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.classmate.ui.navigation.Destinations

@Composable
fun BottomNavBar(
    currentRoute: String,
    onNavigateToDiscover: () -> Unit,
    onNavigateToMatches: () -> Unit,
    onNavigateToProfile: () -> Unit
) {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = "Discover") },
            label = { Text("Discover") },
            selected = currentRoute == Destinations.DISCOVER,
            onClick = onNavigateToDiscover
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.MailOutline, contentDescription = "ClassMates") },
            label = { Text("ClassMates") },
            selected = currentRoute == Destinations.MATCHES,
            onClick = onNavigateToMatches
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
            label = { Text("Profile") },
            selected = currentRoute == Destinations.EDIT_PROFILE,
            onClick = onNavigateToProfile
        )
    }
}