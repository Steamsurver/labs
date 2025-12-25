package com.example.dessertclicker.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

data class ClickerUIState (
    val revenue: Int = 0,
    val dessertsSold: Int = 0,
    val currentDessertIndex: Int = 0,
    val currentDessertPrice: Int = 0,
    val currentDessertImageId: Int = 0
)
