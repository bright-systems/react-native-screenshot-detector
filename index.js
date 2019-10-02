import { NativeEventEmitter, NativeModules, Platform } from 'react-native';
const { RNScreenshotDetector } = NativeModules;

export const SCREENSHOT_EVENT = 'ScreenshotTaken';

export function subscribe(cb) {
  const eventEmitter = new NativeEventEmitter(RNScreenshotDetector);
  eventEmitter.addListener(SCREENSHOT_EVENT, cb, {});
  if(Platform.OS === 'android') {
    NativeModules.ScreenshotDetector.detectScreenshot();
  }
  return eventEmitter;
}

export function unsubscribe(eventEmitter) {
  eventEmitter.removeAllListeners(SCREENSHOT_EVENT);
}

export function activateAndroidFlagSecure(){
  if(Platform.OS === 'android') {
    NativeModules.ScreenshotDetector.activateFlagSecure();
  }
}

export function deactivateAndroidFlagSecure(){
  if(Platform.OS === 'android') {
    NativeModules.ScreenshotDetector.deactivateFlagSecure();
  }
}