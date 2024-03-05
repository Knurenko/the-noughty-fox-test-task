package com.example.thenoughtyfoxtestapp.data.mappers

import com.example.thenoughtyfoxtestapp.data.entity.CommentResponse
import com.example.thenoughtyfoxtestapp.domain.entity.CommentModel

/**
 * @author Knurenko Bogdan 05.03.2024
 */
class CommentResponseToModelMapper {
    fun map(response: CommentResponse): CommentModel = CommentModel(
        id = response.id,
        name = response.name,
        email = response.email,
        body = response.body
    )
}