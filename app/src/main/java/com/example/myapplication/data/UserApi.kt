package com.example.myapplication.data

import retrofit2.http.GET

interface UserApi {

    @GET("products")
    suspend fun getProducts() : ProductResponse
}