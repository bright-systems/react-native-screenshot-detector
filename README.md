
# react-native-screenshot-detector

The goal is to prevent the user from taking screenshots in your app.

- Android: possible, via the [FLAG_SECURE flag](https://developer.android.com/reference/android/view/WindowManager.LayoutParams.html#FLAG_SECURE)
- iOS: impossible, but you *can* detect them

Accordingly, this library exports different APIs for Android and iOS. See [Usage](#usage) below.

## Getting started

`$ npm install react-native-screenshot-detector --save`

`$ react-native link react-native-screenshot-detector`

## Usage

```javascript
import ScreenshotDetector from 'react-native-screenshot-detector';

// iOS
ScreenshotDetector.onScreenshot(yourHandler)

// Android
ScreenshotDetector.disableScreenshots()
ScreenshotDetector.enableScreenshots()
```
