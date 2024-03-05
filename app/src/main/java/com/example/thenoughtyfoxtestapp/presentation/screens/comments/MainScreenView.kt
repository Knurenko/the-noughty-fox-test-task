package com.example.thenoughtyfoxtestapp.presentation.screens.comments

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thenoughtyfoxtestapp.domain.entity.CommentModel
import com.example.thenoughtyfoxtestapp.presentation.components.comment.CommentItem
import com.example.thenoughtyfoxtestapp.presentation.components.error.ErrorMessage
import com.example.thenoughtyfoxtestapp.presentation.components.loading.LoadingIndicator
import com.example.thenoughtyfoxtestapp.presentation.components.toolbar.AppToolbar
import com.example.thenoughtyfoxtestapp.presentation.theme.AppTheme

/**
 * @author Knurenko Bogdan 05.03.2024
 */

@Composable
fun MainScreenView(
    state: MainScreenState,
    onCommentSelected: (Int) -> Unit,
    onFetchCommentsRequested: () -> Unit
) {
    Scaffold(
        topBar = { AppToolbar(title = "The Noughty Fox Test App") },
        content = {
            Box(
                modifier = Modifier
                    .padding(it)
                    .background(color = AppTheme.colors.background)
            ) {
                when (state) {
                    MainScreenState.Loading -> {
                        Box(modifier = Modifier.fillMaxSize()) {
                            LoadingIndicator(
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .size(128.dp)
                            )
                        }
                    }

                    is MainScreenState.CommentsLoaded -> {
                        LazyColumn(modifier = Modifier.fillMaxSize()) {
                            items(state.list) { comment ->
                                CommentItem(
                                    comment = comment,
                                    modifier = Modifier
                                        .padding(2.dp)
                                        .clip(RoundedCornerShape(16.dp))
                                        .clickable { onCommentSelected(comment.id) }
                                )
                            }
                        }
                    }

                    is MainScreenState.Failure -> ErrorMessage(
                        reason = state.reason,
                        retry = { onFetchCommentsRequested() }
                    )
                }
            }
        }
    )
}

@Preview(name = "light")
@Preview(name = "dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun Preview() = AppTheme {
    val comment = CommentModel(id = 1, name = "test name", email = "test email", body = "")
    val list = listOf(comment, comment, comment, comment, comment)
    val state = MainScreenState.CommentsLoaded(list)

    MainScreenView(state, onCommentSelected = {}, onFetchCommentsRequested = {})
}