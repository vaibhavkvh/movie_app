package com.example.movieapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


@HiltViewModel
class SplashViewModel @Inject constructor(private val useCases: UseCases)  : ViewModel(){

    private val _onBoardingCompletedState = MutableStateFlow(false)
    val onBoardingCompletedState : StateFlow<Boolean> = _onBoardingCompletedState

    init {
        viewModelScope.launch(Dispatchers.IO){
            _onBoardingCompletedState.value = useCases.readOnBoardingUseCase().stateIn(viewModelScope).value
        }
    }
}