package com.example.thenoughtyfoxtestapp.data.entity

import com.google.gson.annotations.SerializedName

/**
 * @author Knurenko Bogdan 05.03.2024
 */
data class CommentResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("body")
    val body: String
)