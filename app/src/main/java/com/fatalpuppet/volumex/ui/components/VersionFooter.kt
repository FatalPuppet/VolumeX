package com.fatalpuppet.volumex.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.fatalpuppet.volumex.R
import com.fatalpuppet.volumex.utils.AppConstants

@Composable
fun VersionFooter() {

    Text(
        text = "${stringResource(R.string.version)} ${AppConstants.VERSION}",
        style = MaterialTheme.typography.bodySmall
    )

}