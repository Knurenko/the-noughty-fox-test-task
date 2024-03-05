package com.example.thenoughtyfoxtestapp.presentation.screens.one_comment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thenoughtyfoxtestapp.domain.exceptions.FetchFailureReason
import com.example.thenoughtyfoxtestapp.domain.repository.CommentRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * @author Knurenko Bogdan 05.03.2024
 */
class FullCommentViewModel(
    private val commentId: Int,
    private val repository: CommentRepository
) : ViewModel() {
    private val _state = MutableStateFlow<FullCommentState>(FullCommentState.Loading)
    val state = _state.asStateFlow()

    init {
        fetchCommentById()
    }

    fun fetchCommentById() {
        viewModelScope.launch {
            _state.emit(FullCommentState.Loading)
            try {
                val comment = repository.fetchCommentById(commentId)
                _state.emit(FullCommentState.CommentLoaded(comment))
            } catch (e: FetchFailureReason) {
                _state.emit(FullCommentState.Failure(e))
            }
        }
    }
}