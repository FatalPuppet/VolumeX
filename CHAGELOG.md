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