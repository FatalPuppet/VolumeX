# VolumeX Changelog

## 0.1.1-alpha

### Added
- Initial Android Studio project
- Jetpack Compose UI
- Modular UI components
- HomeViewModel
- HomeUiState
- UsbState model
- USB service architecture
- APFS service placeholder
- App constants
- String resources

### Changed
- Renamed project to VolumeX
- Renamed package to com.fatalpuppet.volumex

### Fixed
- Package namespace issues
- Compose dependency issues
- Material Icons configuration

## [0.2.0-alpha] - 2026-08-02

### Added
- Automatic USB device detection.
- USB attach/detach broadcast handling.
- USB device information cards.
- DiskScanner framework.
- Storage package foundation.
- BlockDeviceReader skeleton.
- Partition data model.

### Changed
- Replaced simulated USB detection with real Android UsbManager integration.
- Improved USB status updates.

### Fixed
- HomeViewModel initialization.
- Android 13+ BroadcastReceiver compatibility.
- Safe handling of USB serial numbers without permission.

## [0.2.2-alpha]

### Added
- UsbBlockDeviceReader implementation.
- BlockDeviceReader interface expanded.
- RawSector model.
- DeviceConnectionState enum.
- HexUtils utility.

### Changed
- Storage layer prepared for raw sector access.
- 
## [0.3.0-alpha]

### Added
- UsbDeviceConnection management.
- SCSI command definitions.
- SCSI result model.
- Device connection state machine.
- Sector size constants.
- Hexadecimal utilities for storage debugging.

### Changed
- UsbBlockDeviceReader now maintains an active USB connection.

## [0.4.0-alpha] - 2026-08-03

### Added
- USB interface scanner.
- USB Mass Storage interface discovery.
- USB connection manager.
- USB connection information model.
- USB Mass Storage constants.
- Command Block Wrapper (CBW) model.
- Command Status Wrapper (CSW) model.
- SCSI INQUIRY response model.
- Diagnostics package foundation.

### Changed
- UsbBlockDeviceReader now opens, claims and releases USB interfaces.
- Improved internal USB architecture.

### Fixed
- USB interface detection.
- Endpoint discovery.

## [0.5.0-alpha] - 2026-08-03
### Added
- Bulk USB transport layer.
- Bulk-Only Transport implementation.
- Command Block Wrapper builder.
- Command Status Wrapper parser.
- SCSI executor.
- SCSI command factory.
- SCSI command logger.
- Hex dump formatter.
- Command tag generator.
- USB connection models.
- Transport validation utilities.

### Changed
- Refined USB Mass Storage communication architecture.
- Improved separation between USB, transport and SCSI layers.

### Tested
- Successfully built and executed on Samsung S25 Ultra.
- Successfully detected multiple USB flash drives.