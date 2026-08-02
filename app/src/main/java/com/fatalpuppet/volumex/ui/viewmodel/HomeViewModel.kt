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
    private var usbRepository: UsbRepository? = null
    fun initialize(context: Context) {
        if (usbRepository == null) {
            usbRepository = UsbRepository(context)
        }
    }
    fun scanUsbDevices() {
        val repository = usbRepository ?: return
        val devices = repository.devices()

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
    fun onUsbChanged() {
        scanUsbDevices()
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
        val repository = usbRepository ?: return

        if (repository.isUsbSupported()) {
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
        val repository = usbRepository ?: return

        if (repository.hasDevices()) {
            updateUsbState(
                UsbState.CONNECTED,
                "${repository.deviceCount()} USB device(s) detected"
            )
        } else {
            updateUsbState(
                UsbState.WAITING,
                "Waiting for USB device"
            )
        }
    }
}