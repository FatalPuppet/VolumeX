package com.fatalpuppet.volumex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.fatalpuppet.volumex.ui.screens.HomeScreen
import com.fatalpuppet.volumex.ui.theme.VolumeXTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            VolumeXTheme {
                HomeScreen()
            }
        }
    }
}