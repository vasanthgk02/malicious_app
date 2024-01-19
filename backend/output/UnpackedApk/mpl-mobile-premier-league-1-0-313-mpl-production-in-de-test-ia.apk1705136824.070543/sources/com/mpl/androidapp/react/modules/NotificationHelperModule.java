package com.mpl.androidapp.react.modules;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.mpl.androidapp.notification.NotificationBuilder;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.MLogger;

@ReactModule(name = "NotificationHelperModule")
public class NotificationHelperModule extends ReactContextBaseJavaModule {
    public static final String TAG = "NotificationHelperModule";

    public NotificationHelperModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void cancelScheduleNotification(String str) {
    }

    @ReactMethod
    public void cancelStickyNotification(String str) {
        new NotificationBuilder(getReactApplicationContext().getApplicationContext()).cancelStickyNotification(str);
    }

    @ReactMethod
    public void createCalenderEventNotification(ReadableMap readableMap) {
        if (readableMap != null && getCurrentActivity() != null) {
            CommonUtils.addEventInCalender(getCurrentActivity(), readableMap);
        }
    }

    @ReactMethod
    public void createLocalNotification(String str) {
    }

    @ReactMethod
    public void createMultipleCalenderEventNotification(ReadableArray readableArray, Promise promise) {
        if (readableArray == null || getCurrentActivity() == null || getCurrentActivity().checkCallingOrSelfPermission("android.permission.WRITE_CALENDAR") != 0) {
            MLogger.d(TAG, "createMultipleCalenderEventNotification: does not have permission");
            promise.resolve(Constants.DOWNLOAD_STATUS_FAILED);
        } else if (CommonUtils.addEventInCalender(getCurrentActivity(), readableArray)) {
            promise.resolve("Success");
        } else {
            promise.resolve(Constants.DOWNLOAD_STATUS_FAILED);
        }
    }

    @ReactMethod
    public void createStickyNotification(String str) {
        new NotificationBuilder(getReactApplicationContext().getApplicationContext()).createStickyNotification(str);
    }

    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void scheduleNotification(String str) {
    }
}
