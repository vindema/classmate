package com.example.classmate.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.classmate.ui.common.ClassMateButton
import com.example.classmate.ui.common.ClassMateTextField

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF2C3E75))
                .padding(paddingValues)
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("ClassMate", fontSize = 36.sp, color = Color.White, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(48.dp))

            ClassMateTextField(value = "", onValueChange = {}, placeholder = ".edu Email")
            Spacer(modifier = Modifier.height(16.dp))
            ClassMateTextField(value = "", onValueChange = {}, placeholder = "Password")

            Spacer(modifier = Modifier.height(32.dp))
            ClassMateButton(text = "Log In", onClick = onLoginSuccess)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen({})
}