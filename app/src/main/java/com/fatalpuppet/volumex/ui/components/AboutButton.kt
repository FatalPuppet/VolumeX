package com.fatalpuppet.volumex.ui.components

import androidx.compose.material3.TextButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.fatalpuppet.volumex.R

@Composable
fun AboutButton(
    onClick: () -> Unit = {}
) {

    TextButton(
        onClick = onClick
    ) {
        Text(stringResource(R.string.about))
    }

}