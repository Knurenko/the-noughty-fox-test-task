package com.example.thenoughtyfoxtestapp.data.repository

import com.example.thenoughtyfoxtestapp.data.mappers.CommentResponseToModelMapper
import com.example.thenoughtyfoxtestapp.data.network.connection.ConnectionChecker
import com.example.thenoughtyfoxtestapp.data.network.service.CommentService
import com.example.thenoughtyfoxtestapp.domain.entity.CommentModel
import com.example.thenoughtyfoxtestapp.domain.exceptions.FetchDataFailed
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
    override suspend fun fetchComments(): List<CommentModel> {
        if (!connectionChecker.checkInternetConnection()) throw FetchDataFailed.NoInternetConnection

        return try {
            service.fetchComments().map { mapper.map(it) }
        } catch (e: InterruptedIOException) {
            throw FetchDataFailed.RequestTooLong
        } catch (e: Exception) {
            throw FetchDataFailed.UnexpectedException(e)
        }
    }
}