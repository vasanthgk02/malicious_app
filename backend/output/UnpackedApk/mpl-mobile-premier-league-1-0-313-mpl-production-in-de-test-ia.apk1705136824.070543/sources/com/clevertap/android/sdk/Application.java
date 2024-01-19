package com.clevertap.android.sdk;

public class Application extends android.app.Application {
    public void onCreate() {
        synchronized (ActivityLifecycleCallback.class) {
            ActivityLifecycleCallback.register(this, null);
        }
        super.onCreate();
    }
}
