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

## 0.2.0-alpha

### Added
- Real USB device detection using UsbManager
- USB device information model
- Repository support for connected devices
- Storage package scaffold
- BlockDeviceReader interface

### Changed
- Replaced simulated USB status with real device enumeration

### Fixed
- HomeViewModel initialization
- Android 13+ receiver compatibility