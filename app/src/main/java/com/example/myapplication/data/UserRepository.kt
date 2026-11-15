package com.example.myapplication.data

class UserRepository(private val getProd : UserApi = CallApi.getProduct) {
    suspend fun getProducts() : Result<ProductResponse> = runCatching { getProd.getProducts() }
}