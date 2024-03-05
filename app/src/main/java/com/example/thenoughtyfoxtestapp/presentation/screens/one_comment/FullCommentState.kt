package com.example.thenoughtyfoxtestapp.presentation.screens.one_comment

import com.example.thenoughtyfoxtestapp.domain.entity.CommentModel
import com.example.thenoughtyfoxtestapp.domain.exceptions.FetchFailureReason

/**
 * @author Knurenko Bogdan 05.03.2024
 */
sealed class FullCommentState {
    data object Loading : FullCommentState()
    data class CommentLoaded(val comment: CommentModel) : FullCommentState()
    data class Failure(val reason: FetchFailureReason) : FullCommentState()
}