package com.example.bikepontossp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColors = darkColorScheme(
    primary = GreenPrimary,
    secondary = GreenSecondary,
    background = DarkBackground,
    surface = DarkSurface
)

@Composable
fun BikePontosTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColors,
        content = content
    )
}