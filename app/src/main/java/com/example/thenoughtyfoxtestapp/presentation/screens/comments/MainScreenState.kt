package com.example.thenoughtyfoxtestapp.presentation.screens.comments

import com.example.thenoughtyfoxtestapp.domain.entity.CommentModel
import com.example.thenoughtyfoxtestapp.domain.exceptions.FetchFailureReason

/**
 * @author Knurenko Bogdan 05.03.2024
 */
sealed class MainScreenState {
    data object Loading : MainScreenState()
    data class CommentsLoaded(val list: List<CommentModel>) : MainScreenState()
    data class Failure(val reason: FetchFailureReason) : MainScreenState()
}