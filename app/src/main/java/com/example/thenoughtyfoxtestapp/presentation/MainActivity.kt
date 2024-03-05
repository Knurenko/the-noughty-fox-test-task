package com.example.thenoughtyfoxtestapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.thenoughtyfoxtestapp.presentation.navigation.NavigationGraph
import com.example.thenoughtyfoxtestapp.presentation.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                NavigationGraph()
            }
        }
    }
}