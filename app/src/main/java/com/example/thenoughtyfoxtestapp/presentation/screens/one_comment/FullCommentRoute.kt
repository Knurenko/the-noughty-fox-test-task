package com.example.thenoughtyfoxtestapp.presentation.screens.one_comment

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

/**
 * @author Knurenko Bogdan 05.03.2024
 */

@Composable
fun FullCommentRoute(commentId: Int, onNavigateBack: () -> Unit) {
    val viewModel: FullCommentViewModel = koinViewModel { parametersOf(commentId) }

    FullCommentScreen(
        state = viewModel.state.collectAsState().value,
        onRetry = { viewModel.fetchCommentById() },
        onNavigationClick = onNavigateBack
    )
}