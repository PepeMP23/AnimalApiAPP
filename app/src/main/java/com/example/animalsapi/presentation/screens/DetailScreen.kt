package com.example.animalsapi.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.animalsapi.R
import com.example.animalsapi.presentation.theme.Purple40
import com.example.animalsapi.presentation.viewmodels.AnimalDetailViewModel


@Composable
fun DetailScreen(
    animalId : String,
    animalDetailViewModel: AnimalDetailViewModel = hiltViewModel()
){

    val state = animalDetailViewModel.animalState.value

    if(state.isLoading){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
    else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Text(
                text = state.animal.name,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 10.dp),
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            AsyncImage(
                model = state.animal.image,
                contentDescription = null,
                placeholder = painterResource(id = R.drawable.ic_launcher_background),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Text(
                state.animal.description,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 16.dp, end = 16.dp),
                style = TextStyle(
                    color = Color.DarkGray,
                    fontSize = 16.sp,
                    letterSpacing = 2.sp,
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Hechos Interesantes",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 10.dp, bottom = 10.dp),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )
            state.animal.facts.forEach { fact ->
                Text(
                    text = "• $fact",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp, start = 16.dp, end = 16.dp),
                    style = TextStyle(
                        color = Color.DarkGray,
                        fontSize = 16.sp,
                        letterSpacing = 0.5.sp,
                        lineHeight = 20.sp
                    )
                )
            }
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun DetailScreenPreview(){
    DetailScreen("1")
}