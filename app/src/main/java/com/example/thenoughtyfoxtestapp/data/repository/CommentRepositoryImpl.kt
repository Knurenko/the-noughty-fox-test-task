package com.example.thenoughtyfoxtestapp.data.repository

import com.example.thenoughtyfoxtestapp.data.mappers.CommentResponseToModelMapper
import com.example.thenoughtyfoxtestapp.data.network.connection.ConnectionChecker
import com.example.thenoughtyfoxtestapp.data.network.service.CommentService
import com.example.thenoughtyfoxtestapp.domain.entity.CommentModel
import com.example.thenoughtyfoxtestapp.domain.exceptions.FetchFailureReason
import com.example.thenoughtyfoxtestapp.domain.repository.CommentRepository
import java.io.InterruptedIOException

/**
 * @author Knurenko Bogdan 05.03.2024
 */
class CommentRepositoryImpl(
    private val service: CommentService,
    private val connectionChecker: ConnectionChecker,
    private val mapper: CommentResponseToModelMapper
) : CommentRepository {
    override suspend fun fetchComments(): List<CommentModel> =
        tryToExecute { service.fetchComments().map { mapper.map(it) } }

    override suspend fun fetchCommentById(id: Int): CommentModel =
        tryToExecute { service.fetchCommentById(id).let { mapper.map(it) } }


    private suspend fun <T> tryToExecute(block: suspend () -> T): T {
        if (!connectionChecker.checkInternetConnection()) throw FetchFailureReason.NoInternetConnection
        return try {
            block()
        } catch (e: InterruptedIOException) {
            throw FetchFailureReason.RequestTooLong
        } catch (e: Exception) {
            throw FetchFailureReason.UnexpectedException(e)
        }
    }
}