package com.example.myapplication.ui

import com.example.myapplication.data.ProductResponse

sealed class UiState {
    data object OnLoading : UiState()
    data class  OnError(val message : String) : UiState()
    data class OnSuccess(val data : ProductResponse) : UiState()
}