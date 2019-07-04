// TODO: check out https://github.com/abangfadli/shotwatch

import { NativeModules } from 'react-native'

const unsubscribe = () => {}
const subscribe = () => unsubscribe

const Detector = {
  ...NativeModules.RNScreenshotDetector,
  subscribe,
}

export default Detector
