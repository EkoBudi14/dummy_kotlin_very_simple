package com.example.myapplication.data

import android.icu.text.CaseMap
import com.google.gson.annotations.SerializedName


data class ProductResponse(
    val products : List<User>
)

data class User(
    val id: Int,
    val title: String,
    val category: String,
    @SerializedName("dimensions")
    val dimension: Dimension,
    @SerializedName("reviews")
    val review: List<Review>
) {
    data class Dimension(
        val width: Double,
        val height: Double,
    )

    data class Review(
        val rating: Int,
        val comment: String,
        val date: String,
        val reviewerName: String,
        val reviewerEmail: String,
    )
}