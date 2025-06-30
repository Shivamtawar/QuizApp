package com.example.quizappminiproject

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController


@Composable
fun HomeScreen(
    navController: NavHostController
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),

    ) {
        Text(
            text = "Welcome to the Quiz App",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier.height(120.dp)
        )

        Spacer(modifier = Modifier.height(150.dp))

        Button(
            onClick = {navController.navigate("quiz")},
            modifier = Modifier.fillMaxWidth()
                .padding(50.dp)
        ) {
            Text(
                text ="Enter Quiz"
            )
        }
    }


}