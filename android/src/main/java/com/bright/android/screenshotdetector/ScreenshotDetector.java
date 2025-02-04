package com.bright.android.screenshotdetector;

import android.os.Handler;
import android.app.Activity;
import android.app.ActivityManager;
import android.view.WindowManager;
import android.widget.Toast;
import android.content.Context;

import java.util.List;

import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.Arguments;

public class ScreenshotDetector extends ReactContextBaseJavaModule {

    ReactApplicationContext reactContext;

    public ScreenshotDetector(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "ScreenshotDetector";
    }

    @ReactMethod
    public void detectScreenshot() {
        final Activity activity = getCurrentActivity();
        final Handler h = new Handler();
        final int delay = 3000; //milliseconds
        final ActivityManager am = (ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE);

        h.postDelayed(new Runnable() {
            public void run() {
                List<ActivityManager.RunningServiceInfo> rs = am.getRunningServices(200);
                WritableMap params = Arguments.createMap();

                for (ActivityManager.RunningServiceInfo ar : rs) {
                    if (ar.process.equals("com.android.systemui:screenshot")) {
                        reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                                .emit("ScreenshotTaken", params);
                    }
                }
                h.postDelayed(this, delay);
            }
        }, delay);
    }
}
