package com.example.animalsapi.di

import com.example.animalsapi.data.AnimalService
import com.example.animalsapi.domain.use_cases.GetAnimals
import com.example.animalsapi.domain.use_cases.GetAnimalsById
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private val BASE_URL = "https://animals.juanfrausto.com/api/animals/"

    @Provides
    @Singleton
    fun provideAnimalService(): AnimalService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnimalService::class.java)
    }


    @Provides
    @Singleton
    fun provideGetAnimalsUseCase(animalService: AnimalService): GetAnimals {
        return GetAnimals(animalService)
    }

    @Provides
    @Singleton
    fun provideGetAnimalsByIdUseCase(animalService: AnimalService): GetAnimalsById {
        return GetAnimalsById(animalService)
    }
}
