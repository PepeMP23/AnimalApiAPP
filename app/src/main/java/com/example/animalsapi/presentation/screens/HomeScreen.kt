package com.example.animalsapi.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.animalsapi.R
import com.example.animalsapi.presentation.theme.BackgroundCard
import com.example.animalsapi.presentation.theme.BackgroundTitle
import com.example.animalsapi.presentation.theme.Purple40
import com.example.animalsapi.presentation.theme.PurpleGrey80
import com.example.animalsapi.presentation.viewmodels.AnimalsViewModel


@Composable
fun HomeScreen(
    navController: NavController,
    animalsViewModel : AnimalsViewModel = hiltViewModel()
) {

    val state = animalsViewModel.animalsState.value
    if(state.isLoading){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
    else{
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(BackgroundTitle)
                    .padding(24.dp)
            ) {
                Text(
                    text = "Animales",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 36.sp,
                        color = Color.White  // Color de la letra
                    ),
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(10.dp)
            ){
                items(state.animals) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clickable {
                                navController.navigate("animals/${it._id}")
                            }
                            .padding(10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = BackgroundCard
                        ),
                        elevation = CardDefaults.cardElevation(10.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(5.dp)
                        ) {
                            AsyncImage(
                                model = it.image,
                                contentDescription = null,
                                placeholder = painterResource(id = R.drawable.ic_launcher_background),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(3f)
                            )
                            Text(
                                text = it.name,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(0.5f),
                                style = TextStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 24.sp
                                )
                            )
                            /*
                            Text(
                                text = it.environmentId,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(0.5f),
                                style = TextStyle(
                                    fontWeight = FontWeight.W300,
                                    fontSize = 18.sp,
                                    color = Color.DarkGray
                                )
                            )
                             */
                        }
                    }
                }
            }
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}