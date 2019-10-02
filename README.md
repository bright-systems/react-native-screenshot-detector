
# @bright-systems/react-native-screenshot-detector

*NOTE: forked and adapted from https://github.com/blend/react-native-screenshot-detector*

The goal is to prevent the user from taking screenshots in your app.

Accordingly, this library exports different APIs for Android and iOS. See [Usage](#usage) below.

## Getting started

`$ yarn add @bright-systems/react-native-screenshot-detector`

`$ react-native link @bright-systems/react-native-screenshot-detector`

## Usage

```javascript
import ScreenshotDetector from '@bright-systems/react-native-screenshot-detector';

// iOS
ScreenshotDetector.subscribe(() => {
  // yell at the user. We'll leave the choice of obscenities to you
})

// Android
ScreenshotDetector.disableScreenshots()
ScreenshotDetector.enableScreenshots()
```
