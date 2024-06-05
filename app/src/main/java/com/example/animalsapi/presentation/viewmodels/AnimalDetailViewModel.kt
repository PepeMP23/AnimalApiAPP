package com.example.animalsapi.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animalsapi.domain.ApiResult
import com.example.animalsapi.domain.use_cases.GetAnimalsById
import com.example.animalsapi.presentation.states.AnimalState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AnimalDetailViewModel @Inject constructor (
    savedStateHandle : SavedStateHandle,
    private val getAnimalUseCase : GetAnimalsById
) : ViewModel()
{
    private val animalId = savedStateHandle.get<Int>("animalId") ?: 0
    private var animalJob : Job? = null
    private var  _animalState = mutableStateOf(AnimalState())
    val animalState = _animalState

    init {
        getAnimal()
    }

    private fun getAnimal(){
        animalJob?.cancel()
        animalJob = getAnimalUseCase(animalId).onEach { result->
            when(result){
                is ApiResult.Loading -> {
                    _animalState.value = AnimalState(isLoading = true)
                }
                is ApiResult.Success -> {
                    _animalState.value = AnimalState(animal = result.data!!, isLoading = false)
                }
                is ApiResult.Error -> {
                    _animalState.value = AnimalState(errorMessage = result.message, isLoading = false)
                }
            }
        }.launchIn(viewModelScope)
    }
}