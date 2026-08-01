package com.fatalpuppet.volumex.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.fatalpuppet.volumex.data.usb.UsbState
import com.fatalpuppet.volumex.ui.state.HomeUiState
import com.fatalpuppet.volumex.data.repository.UsbRepository

class HomeViewModel(
    private val usbRepository: UsbRepository
) : ViewModel() {
    var uiState by mutableStateOf(HomeUiState())
        private set
    fun onUsbAttached() {
        updateUsbState(
            UsbState.CONNECTED,
            "USB device connected"
        )
    }
    fun onUsbDetached() {
        updateUsbState(
            UsbState.WAITING,
            "Waiting for USB device"
        )
    }
    fun updateUsbState(
        state: UsbState,
        message: String
    ) {
        uiState = uiState.copy(
            usbState = state,
            statusMessage = message
        )
    }
    fun checkUsbSupport() {
        if (usbRepository.isUsbSupported()) {
            updateUsbState(
                UsbState.WAITING,
                "USB Host supported"
            )
        } else {
            updateUsbState(
                UsbState.ERROR,
                "USB Host not supported"
            )
        }
    }
}