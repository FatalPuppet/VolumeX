package com.example.apfs_explorer.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "APFS Explorer",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Read APFS-formatted drives directly from Android."
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Please connect an external USB drive."
            )

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Waiting for device..."
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = { }
            ) {

                Text("About")

            }

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Version 0.1.0",
                fontSize = 12.sp
            )

        }

    }

}