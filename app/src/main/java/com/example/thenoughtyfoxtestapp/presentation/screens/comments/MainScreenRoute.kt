package com.example.thenoughtyfoxtestapp.presentation.screens.comments

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import org.koin.compose.koinInject

/**
 * @author Knurenko Bogdan 05.03.2024
 */

@Composable
fun MainScreenController(onCommentSelected: (Int) -> Unit) {
    val viewModel: MainScreenViewModel = koinInject()

    MainScreenView(
        state = viewModel.state.collectAsState().value,
        onCommentSelected = onCommentSelected,
        onFetchCommentsRequested = { viewModel.fetchComments() }
    )
}