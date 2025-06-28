package com.example.quizappminiproject

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph() {

    val navContrller = rememberNavController()

    NavHost(
        navController = navContrller,
        startDestination = "quiz"
    ) {
        composable("quiz"){
            QuizScreen(navContrller)
        }
        composable("result/{score}"){ backStackEntry ->
            val score = backStackEntry.arguments?.getString("score")?.toIntOrNull() ?:0
            Score(score = score)
        }
    }


}