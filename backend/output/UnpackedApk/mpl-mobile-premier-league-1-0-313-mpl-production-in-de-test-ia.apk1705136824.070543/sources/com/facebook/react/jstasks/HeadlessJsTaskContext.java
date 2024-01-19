package com.facebook.react.jstasks;

import android.os.Handler;
import android.util.SparseArray;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactSoftException;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.appregistry.AppRegistry;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

public class HeadlessJsTaskContext {
    public static final WeakHashMap<ReactContext, HeadlessJsTaskContext> INSTANCES = new WeakHashMap<>();
    public final Map<Integer, HeadlessJsTaskConfig> mActiveTaskConfigs = new ConcurrentHashMap();
    public final Set<Integer> mActiveTasks = new CopyOnWriteArraySet();
    public final Handler mHandler = new Handler();
    public final Set<HeadlessJsTaskEventListener> mHeadlessJsTaskEventListeners = new CopyOnWriteArraySet();
    public final AtomicInteger mLastTaskId = new AtomicInteger(0);
    public final WeakReference<ReactContext> mReactContext;
    public final SparseArray<Runnable> mTaskTimeouts = new SparseArray<>();

    public HeadlessJsTaskContext(ReactContext reactContext) {
        this.mReactContext = new WeakReference<>(reactContext);
    }

    public static HeadlessJsTaskContext getInstance(ReactContext reactContext) {
        HeadlessJsTaskContext headlessJsTaskContext = INSTANCES.get(reactContext);
        if (headlessJsTaskContext != null) {
            return headlessJsTaskContext;
        }
        HeadlessJsTaskContext headlessJsTaskContext2 = new HeadlessJsTaskContext(reactContext);
        INSTANCES.put(reactContext, headlessJsTaskContext2);
        return headlessJsTaskContext2;
    }

    public synchronized void finishTask(final int i) {
        boolean remove = this.mActiveTasks.remove(Integer.valueOf(i));
        ImageOriginUtils.assertCondition(remove, "Tried to finish non-existent task with id " + i + ".");
        boolean z = this.mActiveTaskConfigs.remove(Integer.valueOf(i)) != null;
        ImageOriginUtils.assertCondition(z, "Tried to remove non-existent task config with id " + i + ".");
        Runnable runnable = this.mTaskTimeouts.get(i);
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
            this.mTaskTimeouts.remove(i);
        }
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                for (HeadlessJsTaskEventListener onHeadlessJsTaskFinish : HeadlessJsTaskContext.this.mHeadlessJsTaskEventListeners) {
                    onHeadlessJsTaskFinish.onHeadlessJsTaskFinish(i);
                }
            }
        });
    }

    public synchronized boolean isTaskRunning(int i) {
        try {
        }
        return this.mActiveTasks.contains(Integer.valueOf(i));
    }

    public final synchronized void startTask(HeadlessJsTaskConfig headlessJsTaskConfig, final int i) {
        UiThreadUtil.assertOnUiThread();
        Object obj = this.mReactContext.get();
        ImageOriginUtils.assertNotNull(obj, "Tried to start a task on a react context that has already been destroyed");
        ReactContext reactContext = (ReactContext) obj;
        if (reactContext.getLifecycleState() == LifecycleState.RESUMED) {
            if (!headlessJsTaskConfig.mAllowedInForeground) {
                throw new IllegalStateException("Tried to start task " + headlessJsTaskConfig.mTaskKey + " while in foreground, but this is not allowed.");
            }
        }
        this.mActiveTasks.add(Integer.valueOf(i));
        this.mActiveTaskConfigs.put(Integer.valueOf(i), new HeadlessJsTaskConfig(headlessJsTaskConfig));
        if (reactContext.hasActiveCatalystInstance()) {
            ((AppRegistry) reactContext.getJSModule(AppRegistry.class)).startHeadlessTask(i, headlessJsTaskConfig.mTaskKey, headlessJsTaskConfig.mData);
        } else {
            ReactSoftException.logSoftException("HeadlessJsTaskContext", new RuntimeException("Cannot start headless task, CatalystInstance not available"));
        }
        if (headlessJsTaskConfig.mTimeout > 0) {
            long j = headlessJsTaskConfig.mTimeout;
            AnonymousClass3 r6 = new Runnable() {
                public void run() {
                    HeadlessJsTaskContext.this.finishTask(i);
                }
            };
            this.mTaskTimeouts.append(i, r6);
            this.mHandler.postDelayed(r6, j);
        }
        for (HeadlessJsTaskEventListener onHeadlessJsTaskStart : this.mHeadlessJsTaskEventListeners) {
            onHeadlessJsTaskStart.onHeadlessJsTaskStart(i);
        }
    }
}
