package com.example.animalsapi.domain.use_cases

import com.example.animalsapi.data.AnimalService
import com.example.animalsapi.domain.ApiResult
import com.example.animalsapi.domain.models.Animal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class GetAnimals(
    private val animalService: AnimalService
){
    operator fun invoke() : Flow<ApiResult<List<Animal>>> = flow {
        try {
            emit(ApiResult.Loading("Cargando"))
            val response = animalService.getAnimals()
            emit(ApiResult.Success(response))
        }
        catch (e:Exception){
            emit(ApiResult.Error(message = "La peticion fallo", data = emptyList()))
        }
    }
}
