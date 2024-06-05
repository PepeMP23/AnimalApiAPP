package com.example.animalsapi.presentation.states

import com.example.animalsapi.domain.models.Animal

data class AnimalState(
    val isLoading : Boolean = false,
    val animal : Animal = Animal(
        id = 0,
        description = "",
        environmentId =  "",
        facts = listOf("","",""),
        image = "",
        imageGallery = listOf("","",""),
        name = ""
    ),
    val errorMessage : String = ""
)
