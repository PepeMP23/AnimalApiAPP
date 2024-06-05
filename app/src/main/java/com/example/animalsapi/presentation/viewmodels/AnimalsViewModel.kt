package com.example.animalsapi.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animalsapi.domain.ApiResult
import com.example.animalsapi.domain.use_cases.GetAnimals
import com.example.animalsapi.presentation.states.AnimalsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AnimalsViewModel @Inject constructor(
    private val getAnimalsUseCase: GetAnimals
) : ViewModel() {
    private var animalsJob : Job? = null
    private var _animalsState = mutableStateOf(AnimalsState())
    val animalsState = _animalsState

    init {
        getAnimals()
    }

    private fun getAnimals(){
        animalsJob?.cancel()
        animalsJob = getAnimalsUseCase().onEach { result ->
            when(result){
                is ApiResult.Loading -> {
                    _animalsState.value = AnimalsState(isLoading = true)
                }

                is ApiResult.Error -> {
                    _animalsState.value = AnimalsState(errorMessage = result.message)
                }

                is ApiResult.Success -> {
                    _animalsState.value = AnimalsState(animals = result.data!!)
                }
            }
        }.launchIn(viewModelScope)
    }
}