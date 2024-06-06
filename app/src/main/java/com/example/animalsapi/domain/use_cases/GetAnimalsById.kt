package com.example.animalsapi.domain.use_cases

import com.example.animalsapi.data.AnimalService
import com.example.animalsapi.domain.ApiResult
import com.example.animalsapi.domain.models.Animal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.math.log

class GetAnimalsById(
    private val animalsService : AnimalService
) {
    operator fun invoke(id : String) : Flow<ApiResult<Animal>> = flow {
        try {
            emit((ApiResult.Loading("Cargando")))
            val response = animalsService.getAnimalsById(id)
            emit(ApiResult.Success(data = response))
        }
        catch (e : Exception){
            println(e.toString())
            emit(ApiResult.Error(message = "Error", data = null))

        }
    }
}