package com.fatalpuppet.volumex.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.fatalpuppet.volumex.R

@Composable
fun ConnectButton(
    onClick: () -> Unit
) {
    Button(onClick = onClick) {
        Text(stringResource(R.string.connect_drive))
    }
}