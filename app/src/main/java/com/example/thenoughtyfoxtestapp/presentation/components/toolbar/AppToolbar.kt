package com.example.thenoughtyfoxtestapp.presentation.components.toolbar

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thenoughtyfoxtestapp.R
import com.example.thenoughtyfoxtestapp.presentation.theme.AppTheme

/**
 * @author Knurenko Bogdan 05.03.2024
 */

@Composable
fun AppToolbar(
    isNavigationIconVisible: Boolean = false,
    onNavigationIconClick: () -> Unit = {},
    title: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .background(color = AppTheme.colors.primary)
    ) {
        if (isNavigationIconVisible) {
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .align(CenterVertically)
                    .clip(RoundedCornerShape(24.dp))
                    .clickable { onNavigationIconClick() },
            ) {
                Icon(
                    modifier = Modifier.padding(8.dp),
                    painter = painterResource(R.drawable.ic_arrow_back),
                    contentDescription = "navigation icon",
                    tint = AppTheme.colors.onPrimary,
                )
            }
        }

        val startPadding = if (isNavigationIconVisible) 16.dp else 32.dp
        Text(
            modifier = Modifier
                .padding(start = startPadding)
                .align(CenterVertically),
            text = title,
            style = TextStyle(color = AppTheme.colors.onPrimary, fontSize = 18.sp)
        )
    }
}

@Preview(name = "light")
@Preview(name = "dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun Preview() = AppTheme {
    AppToolbar(isNavigationIconVisible = true, title = "App bar")
}