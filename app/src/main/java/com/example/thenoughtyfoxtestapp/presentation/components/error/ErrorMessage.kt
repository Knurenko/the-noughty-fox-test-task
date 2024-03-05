package com.example.thenoughtyfoxtestapp.presentation.components.error

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thenoughtyfoxtestapp.R
import com.example.thenoughtyfoxtestapp.domain.exceptions.FetchFailureReason
import com.example.thenoughtyfoxtestapp.presentation.theme.AppTheme

/**
 * @author Knurenko Bogdan 05.03.2024
 */

@Composable
fun ErrorMessage(reason: FetchFailureReason, retry: () -> Unit) =
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            Icon(
                painter = painterResource(R.drawable.ic_error),
                contentDescription = "error icon",
                modifier = Modifier
                    .size(64.dp)
                    .align(Alignment.CenterHorizontally),
                tint = AppTheme.colors.error
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = when (reason) {
                    FetchFailureReason.NoInternetConnection -> stringResource(R.string.no_internet_connection)
                    FetchFailureReason.RequestTooLong -> stringResource(R.string.request_too_long_exception)
                    is FetchFailureReason.UnexpectedException -> reason.message
                        ?: stringResource(R.string.unexpected_error_while_fetching)
                },
                modifier = Modifier.padding(horizontal = 48.dp),
                style = TextStyle(
                    color = AppTheme.colors.error,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 24.sp
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedButton(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = { retry() },
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = AppTheme.colors.primary
                ),
                border = BorderStroke(width = 2.dp, color = AppTheme.colors.background)
            ) {
                Text(text = stringResource(R.string.try_again))
            }
        }
    }

@Preview(name = "light")
@Preview(name = "dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun Preview() = AppTheme {
    ErrorMessage(reason = FetchFailureReason.NoInternetConnection, {})
}