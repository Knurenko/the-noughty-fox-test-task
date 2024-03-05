package com.example.thenoughtyfoxtestapp.presentation.components.comment

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thenoughtyfoxtestapp.domain.entity.CommentModel
import com.example.thenoughtyfoxtestapp.presentation.theme.AppTheme

/**
 * @author Knurenko Bogdan 05.03.2024
 */

@Composable
fun CommentFull(comment: CommentModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AppTheme.colors.background)
            .padding(16.dp)
    ) {
        CommentPart(partName = "name:", comment.name)
        CommentPart(partName = "body:", comment.body)
        CommentPart(partName = "email:", partText = comment.email)
    }
}

@Composable
private fun CommentPart(partName: String, partText: String) = Column {
    Text(
        text = partName,
        style = TextStyle(
            fontSize = 16.sp,
            color = AppTheme.colors.primary.copy(alpha = .6f)
        )
    )
    Text(
        modifier = Modifier.padding(start = 8.dp, top = 8.dp),
        text = partText,
        style = TextStyle(color = AppTheme.colors.onBackground, fontSize = 16.sp)
    )
    Spacer(modifier = Modifier.height(16.dp))
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
    CommentFull(comment = testItem)
}
