package com.fatalpuppet.volumex.storage.usb

import android.hardware.usb.UsbConstants
import android.hardware.usb.UsbDevice
import android.hardware.usb.UsbEndpoint
import android.util.Log

class UsbInterfaceScanner {

    fun findMassStorageInterface(
        device: UsbDevice
    ): UsbMassStorageInterface? {

        for (i in 0 until device.interfaceCount) {

            val usbInterface = device.getInterface(i)

            if (usbInterface.interfaceClass != UsbConstants.USB_CLASS_MASS_STORAGE)
                continue

            var bulkIn: UsbEndpoint? = null
            var bulkOut: UsbEndpoint? = null

            for (e in 0 until usbInterface.endpointCount) {

                val endpoint = usbInterface.getEndpoint(e)

                if (endpoint.type != UsbConstants.USB_ENDPOINT_XFER_BULK)
                    continue

                when (endpoint.direction) {

                    UsbConstants.USB_DIR_IN ->
                        bulkIn = endpoint

                    UsbConstants.USB_DIR_OUT ->
                        bulkOut = endpoint
                }
            }

            if (bulkIn != null && bulkOut != null) {
                return UsbMassStorageInterface(
                    usbInterface = usbInterface,
                    bulkIn = bulkIn,
                    bulkOut = bulkOut,
                    interfaceNumber = i
                )
            }

        }

        return null

    }

    fun inspectDevice(
        device: UsbDevice
    ): List<UsbInterfaceInfo> {
        val interfaces = mutableListOf<UsbInterfaceInfo>()
        for (i in 0 until device.interfaceCount) {
            val usbInterface = device.getInterface(i)
            var bulkIn = false
            var bulkOut = false
            for (e in 0 until usbInterface.endpointCount) {
                val endpoint = usbInterface.getEndpoint(e)
                if (endpoint.type != UsbConstants.USB_ENDPOINT_XFER_BULK)
                    continue
                when (endpoint.direction) {
                    UsbConstants.USB_DIR_IN ->
                        bulkIn = true
                    UsbConstants.USB_DIR_OUT ->
                        bulkOut = true
                }
            }
            Log.d(
                "VolumeX",
                "Interface $i | Class=${usbInterface.interfaceClass} | Endpoints=${usbInterface.endpointCount} | Bulk IN=$bulkIn | Bulk OUT=$bulkOut"
            )
            interfaces.add(
                UsbInterfaceInfo(
                    interfaceNumber = i,
                    interfaceClass = usbInterface.interfaceClass,
                    endpointCount = usbInterface.endpointCount,
                    bulkInFound = bulkIn,
                    bulkOutFound = bulkOut
                )
            )
        }
        return interfaces
    }

}