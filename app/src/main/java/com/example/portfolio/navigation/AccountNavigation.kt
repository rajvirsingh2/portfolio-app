package com.example.portfolio.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.portfolio.frontend.LoginPage
import com.example.portfolio.frontend.SignUpPage

@Composable
fun MyAccountNavigation() {
    val navController = rememberNavController()
    Column(modifier = Modifier.fillMaxSize()) {
        NavHost(navController = navController, startDestination = "LoginPage") {
            composable(route = "LoginPage") {
                LoginPage(navController = navController)
            }
            composable(route = "SignUpPage") {
                SignUpPage(navController)
            }
        }
    }
}
