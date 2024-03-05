package com.example.thenoughtyfoxtestapp.data.network.service

import com.example.thenoughtyfoxtestapp.data.entity.CommentResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Knurenko Bogdan 05.03.2024
 */
interface CommentService {
    @GET("/comments")
    suspend fun fetchComments() : List<CommentResponse>

    @GET("/comments/{id}")
    suspend fun fetchCommentById(@Path("id")id: Int): CommentResponse
}