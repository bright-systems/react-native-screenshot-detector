
package com.reactlibrary;

import android.view.Window;
import android.view.WindowManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class RNScreenshotDetectorModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNScreenshotDetectorModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNScreenshotDetector";
  }

  @ReactMethod
  public void enableScreenshots() {
    getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
      }
    });
  }

  @ReactMethod
  public void disableScreenshots() {
    getCurrentActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
      }
    });
  }

  private Window getWindow() {
    return getCurrentActivity().getWindow();
  }
}
