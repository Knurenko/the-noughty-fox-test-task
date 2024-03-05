package com.example.thenoughtyfoxtestapp.presentation.components.comment

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thenoughtyfoxtestapp.domain.entity.CommentModel
import com.example.thenoughtyfoxtestapp.presentation.theme.AppTheme

/**
 * @author Knurenko Bogdan 05.03.2024
 */

@Composable
fun CommentItem(comment: CommentModel, modifier: Modifier = Modifier) {
    Row(
        modifier
            .fillMaxWidth()
            .background(color = AppTheme.colors.background)
    ) {
        Avatar(email = comment.email)
        Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)) {
            Email(email = comment.email)
            Name(name = comment.name)
        }
    }
}

@Composable
private fun Avatar(email: String) = Box(
    modifier = Modifier
        .padding(8.dp)
        .background(
            color = AppTheme.colors.primary.copy(alpha = .6f),
            shape = RoundedCornerShape(32.dp)
        )
) {
    Text(
        modifier = Modifier
            .padding(16.dp)
            .size(24.dp),
        text = "${email.first().uppercaseChar()}",
        style = TextStyle(
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            color = AppTheme.colors.onPrimary
        )
    )
}

@Composable
private fun Email(email: String) = Text(
    text = email,
    style = TextStyle(
        fontSize = 14.sp,
        color = AppTheme.colors.primary.copy(alpha = .7f)
    )
)

@Composable
private fun Name(name: String) = Text(
    text = name,
    style = TextStyle(
        color = AppTheme.colors.onBackground.copy(alpha = .8f),
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium
    ),
    maxLines = 1,
    overflow = TextOverflow.Ellipsis
)

@Preview(name = "light")
@Preview(name = "dark", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun Preview() = AppTheme {
    val testItem = CommentModel(
        id = 1,
        name = "test name with a really loooong string inside",
        email = "test@gmail.com",
        body = ""
    )
    CommentItem(comment = testItem)
}