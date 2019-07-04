import { NativeEventEmitter, NativeModules } from 'react-native'

const { RNScreenshotDetector } = NativeModules
const eventEmitter = new NativeEventEmitter(RNScreenshotDetector)

const SCREENSHOT_EVENT = 'ScreenshotTaken'

const subscribe = (cb) => {
  const sub = eventEmitter.addListener(SCREENSHOT_EVENT, cb, {})
  return () => sub.remove()
}

export default {
  SCREENSHOT_EVENT,
  subscribe,
}
