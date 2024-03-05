package com.example.thenoughtyfoxtestapp.data.network.service

import com.example.thenoughtyfoxtestapp.data.entity.CommentResponse
import retrofit2.http.GET

/**
 * @author Knurenko Bogdan 05.03.2024
 */
interface CommentService {

    @GET("/comments")
    suspend fun fetchComments() : List<CommentResponse>
}