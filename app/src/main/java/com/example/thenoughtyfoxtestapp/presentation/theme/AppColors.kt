package com.example.thenoughtyfoxtestapp.presentation.theme

import androidx.compose.ui.graphics.Color

/**
 * @author Knurenko Bogdan 13.02.2024
 */
class AppColors(
    val primary: Color,
    val error: Color,
    val background: Color,
    val onPrimary: Color,
    val onBackground: Color
)

val lightColors = AppColors(
    primary = Color(0xFF673AB7),
    error = Color(0xFFF44336),
    background = Color(0xFFFFFFFF),
    onPrimary = Color(0xFFFFFFFF),
    onBackground = Color(0xFF000000)
)

val darkColors = AppColors(
    primary = Color(0xFFFF9800),
    error = Color(0xFFF44336),
    background = Color(0xFF000000),
    onPrimary = Color(0xFF000000),
    onBackground = Color(0xFFFFFFFF)
)
