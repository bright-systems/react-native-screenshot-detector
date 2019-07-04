
# @exodus/react-native-screenshot-detector

*NOTE: forked and adapted from https://github.com/blend/react-native-screenshot-detector*

The goal is to prevent the user from taking screenshots in your app.

- Android: possible via the [FLAG_SECURE flag](https://developer.android.com/reference/android/view/WindowManager.LayoutParams.html#FLAG_SECURE)
- iOS: impossible, but you *can* detect them

Accordingly, this library exports different APIs for Android and iOS. See [Usage](#usage) below.

## Getting started

`$ npm install @exodus/react-native-screenshot-detector --save`

`$ react-native link @exodus/react-native-screenshot-detector`

## Usage

```javascript
import ScreenshotDetector from '@exodus/react-native-screenshot-detector';

// iOS
ScreenshotDetector.onScreenshot(() => {
  // yell at the user. We'll leave the choice of obscenities to you
})

// Android
ScreenshotDetector.disableScreenshots()
ScreenshotDetector.enableScreenshots()
```
