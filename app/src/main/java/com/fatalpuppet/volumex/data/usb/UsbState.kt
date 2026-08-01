package com.fatalpuppet.volumex.data.usb

enum class UsbState {
    WAITING,
    CONNECTED,
    PERMISSION_GRANTED,
    SCANNING,
    MOUNTED,
    ERROR
}