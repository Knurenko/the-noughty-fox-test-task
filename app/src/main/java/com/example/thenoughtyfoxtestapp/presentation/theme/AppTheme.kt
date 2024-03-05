package com.example.thenoughtyfoxtestapp.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

object AppTheme {
    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current
}

private val LocalColors = staticCompositionLocalOf { lightColors }

@Composable
fun AppTheme(
    isDarkMode: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val themedColors: AppColors = if (isDarkMode) darkColors else lightColors

    CompositionLocalProvider(
        LocalColors provides themedColors,
    ) {
        MaterialTheme {
            content()
        }
    }
}