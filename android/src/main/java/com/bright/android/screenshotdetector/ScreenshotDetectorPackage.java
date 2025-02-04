package com.bright.android.screenshotdetector;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import com.bright.android.screenshotdetector.ScreenshotDetector;

import java.util.*;

public class ScreenshotDetectorPackage implements ReactPackage {

   @Override
   public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
       List<NativeModule> modules = new ArrayList<>();
       modules.add(new ScreenshotDetector(reactContext));
       return modules;
   }

   @Override
   public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
       return new ArrayList<>();
   }

}