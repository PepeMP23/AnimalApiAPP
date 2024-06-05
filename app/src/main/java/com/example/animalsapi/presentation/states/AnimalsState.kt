package com.example.animalsapi.presentation.states

import com.example.animalsapi.domain.models.Animal

data class AnimalsState (
    val isLoading : Boolean = false,
    val animals : List<Animal> = emptyList(),
    val errorMessage : String = ""
)