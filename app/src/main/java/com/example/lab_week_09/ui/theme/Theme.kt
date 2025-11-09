package com.example.lab_week_09.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// New color palettes using the custom colors from Color.kt
private val DarkColorPalette = darkColorScheme(
    primary = PrimaryBlue,
    secondary = LightBlue,
    background = BackgroundDark,
    surface = BackgroundDark,
    onPrimary = TextOnPrimary,
    onSecondary = TextOnPrimary,
    onBackground = TextOnPrimary,
    onSurface = TextOnPrimary
)

private val LightColorPalette = lightColorScheme(
    primary = PrimaryBlue,
    secondary = LightBlue,
    background = BackgroundLight,
    surface = BackgroundLight,
    onPrimary = TextOnPrimary,
    onSecondary = TextOnPrimary,
    onBackground = TextPrimary,
    onSurface = TextPrimary
)

@Composable
fun LAB_WEEK_09Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colors.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes, // Applying the new custom shapes
        content = content
    )
}
