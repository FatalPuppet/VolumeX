package com.fatalpuppet.volumex.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import android.content.Context
import com.fatalpuppet.volumex.data.usb.UsbState
import com.fatalpuppet.volumex.ui.state.HomeUiState
import com.fatalpuppet.volumex.data.repository.UsbRepository

// This part commented because it might be needed later
//class HomeViewModel(
//    private val usbRepository: UsbRepository
//) : ViewModel() {
class HomeViewModel : ViewModel() {
    var uiState by mutableStateOf(HomeUiState())
        private set

    private lateinit var usbRepository: UsbRepository

    fun initialize(context: Context) {
        usbRepository = UsbRepository(context)
    }

    fun scanUsbDevices() {
        val devices = usbRepository.devices()
        uiState = uiState.copy(
            connectedDevices = devices
        )
        if (devices.isEmpty()) {
            updateUsbState(
                UsbState.WAITING,
                "Waiting for USB device"
            )
        } else {
            updateUsbState(
                UsbState.CONNECTED,
                "${devices.size} USB device(s) connected"
            )
        }
    }

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
    fun refreshUsbStatus() {
        if (usbRepository.hasDevices()) {
            updateUsbState(
                UsbState.CONNECTED,
                "${usbRepository.deviceCount()} USB device(s) detected"
            )
        } else {
            updateUsbState(
                UsbState.WAITING,
                "Waiting for USB device"
            )
        }
    }
}