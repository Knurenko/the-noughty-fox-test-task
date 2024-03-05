package com.example.thenoughtyfoxtestapp.presentation.screens.comments

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
class MainScreenViewModel(
    private val repository: CommentRepository
) : ViewModel() {
    private val _state = MutableStateFlow<MainScreenState>(MainScreenState.Loading)
    val state = _state.asStateFlow()

    fun fetchComments() {
        viewModelScope.launch {
            _state.emit(MainScreenState.Loading)
            try {
                val list = repository.fetchComments()
                _state.emit(MainScreenState.CommentsLoaded(list))
            } catch (e: FetchFailureReason) {
                _state.emit(MainScreenState.Failure(e))
            }
        }
    }

    init {
        fetchComments()
    }
}