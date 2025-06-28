package com.example.quizappminiproject

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


//[question[option],question[option],question[option]]
@Composable
fun QuizScreen(
    navController: NavHostController
) {

    val context = LocalContext.current

    val question = listOf(
        "What is the capital of India??" to listOf("London", "Delhi", "Mumbai", "Pune"),
        "Which is the largest planet in our Solar System??" to listOf("Earth", "Mars", "Uranus", "Jupiter"),
        "what is 9 + 5??" to listOf("15", "36", "94", "14"),
        "Which is the national flower of India??" to listOf("Rose", "Hibiscus", "Lotus", "Jasmine"),
        "Which Sport is Leo Messi Associated to??" to listOf("Cricket", "Football", "Table Tennis", "Javelin")
    )

    val correctAnswers = listOf(1,3,3,2,1)

//    state variables
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var selectedAnswer by remember { mutableStateOf(-1) }
    var score by remember { mutableStateOf(0) }

//    Current Question Data
    val currentquestion = question[currentQuestionIndex]
    val questiontext = currentquestion.first
    val options = currentquestion.second

//    actual ui building
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Question ${currentQuestionIndex + 1} of ${question.size}",
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LinearProgressIndicator(
            progress = (currentQuestionIndex + 1).toFloat()/ question.size,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

//        Queston Text
        Text(
            text = questiontext,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(bottom = 24.dp)
        )
//        options
        options.forEachIndexed{index, option ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .selectable(
                        selected = selectedAnswer == index,
                        onClick = { selectedAnswer = index }
                    ),
                colors = CardDefaults.cardColors(
                    containerColor = if (selectedAnswer == index) Color.Blue else Color.White
                )
            ) {
                Text(
                    text = option,
                    modifier = Modifier.padding(16.dp),
                    fontSize = 16.sp
                )

            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (selectedAnswer == correctAnswers[currentQuestionIndex]){
                    score++
                    Toast.makeText(context, "Well done your Answer was correct Score =  $score", Toast.LENGTH_SHORT).show()
                }

                if(currentQuestionIndex < question.size - 1 ){
                    currentQuestionIndex++
                    selectedAnswer = -1
                }else{
                    navController.navigate("result/$score")
                }
            },
            enabled = selectedAnswer != -1,
            modifier = Modifier.fillMaxWidth()
                .height(56.dp)
        ){

            Text(
                text = "Next Question",
                fontSize = 16.sp
            )
        }



    }


}

