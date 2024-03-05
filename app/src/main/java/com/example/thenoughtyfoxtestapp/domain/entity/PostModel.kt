package com.example.thenoughtyfoxtestapp.domain.entity

/**
 * simple data class to represent posts
 * @author Knurenko Bogdan 05.03.2024
 */
data class PostModel(
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)