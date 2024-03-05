package com.example.thenoughtyfoxtestapp.presentation.screens.one_comment

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thenoughtyfoxtestapp.domain.entity.CommentModel
import com.example.thenoughtyfoxtestapp.presentation.components.comment.CommentFull
import com.example.thenoughtyfoxtestapp.presentation.components.error.ErrorMessage
import com.example.thenoughtyfoxtestapp.presentation.components.loading.LoadingIndicator
import com.example.thenoughtyfoxtestapp.presentation.components.toolbar.AppToolbar
import com.example.thenoughtyfoxtestapp.presentation.theme.AppTheme

/**
 * @author Knurenko Bogdan 05.03.2024
 */

@Composable
fun FullCommentScreen(
    state: FullCommentState,
    onNavigationClick: () -> Unit,
    onRetry: () -> Unit
) {
    Scaffold(
        topBar = {
            AppToolbar(
                title = "Comment info",
                isNavigationIconVisible = true,
                onNavigationIconClick = onNavigationClick
            )
        },
        content = {
            Box(
                modifier = Modifier
                    .padding(it)
                    .background(color = AppTheme.colors.background)
            ) {
                when (state) {
                    is FullCommentState.CommentLoaded -> CommentFull(state.comment)

                    is FullCommentState.Failure -> ErrorMessage(reason = state.reason, onRetry)

                    FullCommentState.Loading -> Box(modifier = Modifier.fillMaxSize()) {
                        LoadingIndicator(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .size(128.dp)
                        )
                    }
                }
            }
        }
    )
}

@Preview(name = "light")
@Preview(name = "dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun Preview() = AppTheme {
    val testItem = CommentModel(
        id = 1,
        name = "test name with a really loooong string inside",
        email = "test@gmail.com",
        body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum"
    )
    val state = FullCommentState.CommentLoaded(testItem)
    FullCommentScreen(state, onNavigationClick = {}, {})
}