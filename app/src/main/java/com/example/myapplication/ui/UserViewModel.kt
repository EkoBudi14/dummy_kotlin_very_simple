package com.example.myapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.User
import com.example.myapplication.data.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserViewModel(
    private val userRepository: UserRepository = UserRepository()
) : ViewModel() {

    private val _state = MutableStateFlow<UiState>(UiState.OnLoading)
    val state = _state.asStateFlow()


    init {
        loadProducts()
    }

    fun loadProducts() {
        viewModelScope.launch {
            _state.value = UiState.OnLoading
            userRepository.getProducts()
                .onFailure { _state.value = UiState.OnError(it.message ?: "Error get api") }
                .onSuccess { _state.value = UiState.OnSuccess(it) }

        }
    }

}