package com.example.animalsapi.domain.models

data class Animal(
    val id: Int,
    val description: String,
    val environmentId: String,
    val facts: List<String>,
    val image: String,
    val imageGallery: List<String>,
    val name: String
){
    companion object{
        val animalList = List(10){
            Animal(
                id = 1,
                description = "String",
                environmentId =  "662d2505a9cc4064e6be3353",
                facts = listOf("fact1","fact2","fact3"),
                image = "https://i.redd.it/04rwloagnx551.jpg",
                imageGallery = listOf("image1","image2","image3"),
                name = "Nutria"
            )
        }
    }
}