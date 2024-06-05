package com.example.animalsapi.data

import com.example.animalsapi.domain.models.Animal
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimalService {
    @GET("animals")
    suspend fun getAnimals() : List<Animal>

    @GET("animals/{id}")
    suspend fun getAnimalsById(@Path("id")id:Int) : Animal
}