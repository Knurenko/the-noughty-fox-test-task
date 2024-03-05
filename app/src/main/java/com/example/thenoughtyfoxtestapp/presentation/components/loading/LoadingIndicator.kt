package com.example.thenoughtyfoxtestapp.presentation.components.loading

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.thenoughtyfoxtestapp.presentation.theme.AppTheme

/**
 * @author Knurenko Bogdan 05.03.2024
 */

@Composable
fun LoadingIndicator(modifier: Modifier) =
    CircularProgressIndicator(modifier, color = AppTheme.colors.primary, strokeWidth = 6.dp)