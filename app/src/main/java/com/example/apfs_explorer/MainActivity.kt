package com.example.apfs_explorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.apfs_explorer.ui.screens.HomeScreen
import com.example.apfs_explorer.ui.theme.APFSExplorerTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            APFSExplorerTheme {
                HomeScreen()
            }
        }
    }
}