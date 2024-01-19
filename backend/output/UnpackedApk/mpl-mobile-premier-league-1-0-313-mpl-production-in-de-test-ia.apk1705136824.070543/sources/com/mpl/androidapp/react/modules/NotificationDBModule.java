package com.mpl.androidapp.react.modules;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.database.NotificationDataManager;
import org.json.JSONObject;

@ReactModule(name = "NotificationDB")
public class NotificationDBModule extends ReactContextBaseJavaModule {
    public static final String TAG = "NotificationDB";
    public boolean isRegistered = false;
    public Context mContext;
    public NotificationDataManager mNotifDataManger = new NotificationDataManager(getReactApplicationContext());
    public Promise mPromise;

    public NotificationDBModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mContext = reactApplicationContext;
    }

    public void addNotificationData(final String str, final String str2, final boolean z) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            public void run() {
                MPLApplication.getNotificationDataManager().addNotificationData(str, str2, z);
            }
        });
    }

    @ReactMethod
    public void deleteDb(final Promise promise) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            public void run() {
                MPLApplication.getNotificationDataManager().deleteAllNOtificationDataTable();
                promise.resolve("success");
            }
        });
    }

    @ReactMethod
    public void deleteNotificationEvent(final int i, final Promise promise) {
        if (String.valueOf(i) == null || TextUtils.isEmpty(String.valueOf(i)) || i == 0) {
            promise.resolve(new JSONObject().toString());
        } else {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                public void run() {
                    MPLApplication.getNotificationDataManager().deleteNotificationTableElement(i);
                    promise.resolve("success");
                }
            });
        }
    }

    @ReactMethod
    public void fetchNotificationDataBatch(final int i, final int i2, final Promise promise) {
        if (String.valueOf(i) == null || TextUtils.isEmpty(String.valueOf(i)) || i == 0 || String.valueOf(i2) == null || TextUtils.isEmpty(String.valueOf(i2)) || i2 == 0) {
            promise.resolve(new JSONObject().toString());
        } else {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                public void run() {
                    promise.resolve(MPLApplication.getNotificationDataManager().readNotificationDataOnCount(i, i2));
                }
            });
        }
    }

    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void markAllAsRead(final Promise promise) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            public void run() {
                MPLApplication.getNotificationDataManager().markAllAsRead();
                promise.resolve("success");
            }
        });
    }

    @ReactMethod
    public void markOneAsRead(final int i, final Promise promise) {
        if (String.valueOf(i) == null || TextUtils.isEmpty(String.valueOf(i)) || i == 0) {
            promise.resolve(new JSONObject().toString());
        } else {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                public void run() {
                    MPLApplication.getNotificationDataManager().markOneAsRead(i);
                    promise.resolve("success");
                }
            });
        }
    }

    @ReactMethod
    public void newNotificationCount(final Promise promise) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            public void run() {
                promise.resolve(MPLApplication.getNotificationDataManager().unreadNotifCount());
            }
        });
    }
}
