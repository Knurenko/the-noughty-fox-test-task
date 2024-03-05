package com.example.thenoughtyfoxtestapp.domain.repository

import com.example.thenoughtyfoxtestapp.domain.entity.CommentModel
import com.example.thenoughtyfoxtestapp.domain.exceptions.FetchFailureReason

/**
 * repo used to fetch posts
 * @author Knurenko Bogdan 05.03.2024
 */
interface CommentRepository {
    @Throws(FetchFailureReason::class)
    suspend fun fetchComments(): List<CommentModel>

    @Throws(FetchFailureReason::class)
    suspend fun fetchCommentById(id: Int): CommentModel
}