package com.fatalpuppet.volumex.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext

import com.fatalpuppet.volumex.ui.viewmodel.HomeViewModel
import com.fatalpuppet.volumex.data.usb.UsbState
import com.fatalpuppet.volumex.ui.components.AboutButton
import com.fatalpuppet.volumex.ui.components.AppHeader
import com.fatalpuppet.volumex.ui.components.ConnectButton
import com.fatalpuppet.volumex.ui.components.StatusCard
import com.fatalpuppet.volumex.ui.components.VersionFooter

import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.runtime.remember
import com.fatalpuppet.volumex.ui.state.HomeUiState

@Composable
fun HomeScreen() {

    val homeViewModel: HomeViewModel = viewModel()
    val uiState = homeViewModel.uiState
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        homeViewModel.initialize(context)
        homeViewModel.scanUsbDevices()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        AppHeader()
        StatusCard(
            uiState = uiState
        )
        ConnectButton(
            onClick = {
                homeViewModel.updateUsbState(
                    UsbState.CONNECTED,
                    "USB device detected (simulation)"
                )
            }
        )
        AboutButton()
        VersionFooter()
    }
}