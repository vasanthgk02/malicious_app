package com.facebook.react;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;
import com.facebook.react.jstasks.HeadlessJsTaskEventListener;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class HeadlessJsTaskService extends Service implements HeadlessJsTaskEventListener {
    public static WakeLock sWakeLock;
    public final Set<Integer> mActiveTasks = new CopyOnWriteArraySet();

    public void getReactNativeHost() {
        ((ReactApplication) getApplication()).getReactNativeHost();
    }

    public HeadlessJsTaskConfig getTaskConfig() {
        return null;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onDestroy() {
        super.onDestroy();
        getReactNativeHost();
        throw null;
    }

    public void onHeadlessJsTaskFinish(int i) {
        this.mActiveTasks.remove(Integer.valueOf(i));
        if (this.mActiveTasks.size() == 0) {
            stopSelf();
        }
    }

    public void onHeadlessJsTaskStart(int i) {
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        HeadlessJsTaskConfig taskConfig = getTaskConfig();
        if (taskConfig == null) {
            return 2;
        }
        startTask(taskConfig);
        return 3;
    }

    public void startTask(HeadlessJsTaskConfig headlessJsTaskConfig) {
        UiThreadUtil.assertOnUiThread();
        WakeLock wakeLock = sWakeLock;
        if (wakeLock == null || !wakeLock.isHeld()) {
            PowerManager powerManager = (PowerManager) getSystemService("power");
            ImageOriginUtils.assertNotNull(powerManager);
            WakeLock newWakeLock = powerManager.newWakeLock(1, HeadlessJsTaskService.class.getCanonicalName());
            sWakeLock = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            sWakeLock.acquire();
        }
        getReactNativeHost();
        throw null;
    }
}
