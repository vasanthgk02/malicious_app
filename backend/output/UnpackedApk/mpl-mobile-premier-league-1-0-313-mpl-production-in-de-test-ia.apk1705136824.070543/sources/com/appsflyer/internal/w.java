package com.appsflyer.internal;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class w {
    public static final BitSet AFLogger$LogLevel = new BitSet(6);
    public static final Handler AFVersionDeclaration = new Handler(Looper.getMainLooper());
    public static volatile w init;
    public final Runnable AFInAppEventParameterName = new Runnable() {
        public final void run() {
            synchronized (w.this.AFInAppEventType) {
                w wVar = w.this;
                wVar.AppsFlyer2dXConversionCallback.execute(new Runnable() {
                    public final void run() {
                        try {
                            for (Sensor next : w.this.onDeepLinkingNative.getSensorList(-1)) {
                                if (w.AFKeystoreWrapper(next.getType())) {
                                    x xVar = new x(next, w.this.AppsFlyer2dXConversionCallback);
                                    if (!w.this.onInstallConversionFailureNative.containsKey(xVar)) {
                                        w.this.onInstallConversionFailureNative.put(xVar, xVar);
                                    }
                                    w.this.onDeepLinkingNative.registerListener((SensorEventListener) w.this.onInstallConversionFailureNative.get(xVar), next, 0);
                                }
                            }
                        } catch (Throwable unused) {
                        }
                        w.this.onInstallConversionDataLoadedNative = true;
                    }
                });
                w.this.AFKeystoreWrapper.postDelayed(w.this.onAppOpenAttribution, 100);
                w.this.valueOf = true;
            }
        }
    };
    public final Object AFInAppEventType = new Object();
    public final Handler AFKeystoreWrapper;
    public final Executor AppsFlyer2dXConversionCallback = Executors.newSingleThreadExecutor();
    public final Runnable getLevel = new Runnable() {
        public final void run() {
            synchronized (w.this.AFInAppEventType) {
                if (w.this.valueOf) {
                    w.this.AFKeystoreWrapper.removeCallbacks(w.this.AFInAppEventParameterName);
                    w.this.AFKeystoreWrapper.removeCallbacks(w.this.values);
                    w wVar = w.this;
                    wVar.AppsFlyer2dXConversionCallback.execute(new Runnable() {
                        public final void run() {
                            try {
                                if (!w.this.onInstallConversionFailureNative.isEmpty()) {
                                    for (x xVar : w.this.onInstallConversionFailureNative.values()) {
                                        w.this.onDeepLinkingNative.unregisterListener(xVar);
                                        xVar.AFKeystoreWrapper(w.this.onAppOpenAttributionNative, true);
                                    }
                                }
                            } catch (Throwable unused) {
                            }
                            w.this.onAttributionFailureNative = 0;
                            w.this.onInstallConversionDataLoadedNative = false;
                        }
                    });
                    w.this.valueOf = false;
                }
            }
        }
    };
    public final Runnable onAppOpenAttribution = new Runnable() {
        public final void run() {
            synchronized (w.this.AFInAppEventType) {
                if (w.this.onAttributionFailureNative == 0) {
                    w.this.onAttributionFailureNative = 1;
                }
                w.this.AFKeystoreWrapper.postDelayed(w.this.values, ((long) w.this.onAttributionFailureNative) * 500);
            }
        }
    };
    public final Map<x, Map<String, Object>> onAppOpenAttributionNative = new ConcurrentHashMap(AFLogger$LogLevel.size());
    public int onAttributionFailureNative = 1;
    public final SensorManager onDeepLinkingNative;
    public boolean onInstallConversionDataLoadedNative;
    public final Map<x, x> onInstallConversionFailureNative = new HashMap(AFLogger$LogLevel.size());
    public long onResponseNative = 0;
    public boolean valueOf;
    public final Runnable values = new Runnable() {
        public final void run() {
            synchronized (w.this.AFInAppEventType) {
                w wVar = w.this;
                wVar.AppsFlyer2dXConversionCallback.execute(new Runnable() {
                    public final void run() {
                        try {
                            if (!w.this.onInstallConversionFailureNative.isEmpty()) {
                                for (x xVar : w.this.onInstallConversionFailureNative.values()) {
                                    w.this.onDeepLinkingNative.unregisterListener(xVar);
                                    xVar.AFKeystoreWrapper(w.this.onAppOpenAttributionNative, true);
                                }
                            }
                        } catch (Throwable unused) {
                        }
                        w.this.onAttributionFailureNative = 0;
                        w.this.onInstallConversionDataLoadedNative = false;
                    }
                });
            }
        }
    };

    static {
        AFLogger$LogLevel.set(1);
        AFLogger$LogLevel.set(2);
        AFLogger$LogLevel.set(4);
    }

    public w(SensorManager sensorManager, Handler handler) {
        this.onDeepLinkingNative = sensorManager;
        this.AFKeystoreWrapper = handler;
    }

    public static w AFKeystoreWrapper(Context context) {
        if (init != null) {
            return init;
        }
        return AFKeystoreWrapper((SensorManager) context.getApplicationContext().getSystemService("sensor"), AFVersionDeclaration);
    }

    public final List<Map<String, Object>> AFInAppEventParameterName() {
        for (x AFKeystoreWrapper2 : this.onInstallConversionFailureNative.values()) {
            AFKeystoreWrapper2.AFKeystoreWrapper(this.onAppOpenAttributionNative, true);
        }
        Map<x, Map<String, Object>> map = this.onAppOpenAttributionNative;
        if (map == null || map.isEmpty()) {
            return new CopyOnWriteArrayList(Collections.emptyList());
        }
        return new CopyOnWriteArrayList(this.onAppOpenAttributionNative.values());
    }

    private List<Map<String, Object>> values() {
        synchronized (this.AFInAppEventType) {
            if (!this.onInstallConversionFailureNative.isEmpty() && this.onInstallConversionDataLoadedNative) {
                for (x AFKeystoreWrapper2 : this.onInstallConversionFailureNative.values()) {
                    AFKeystoreWrapper2.AFKeystoreWrapper(this.onAppOpenAttributionNative, false);
                }
            }
            if (this.onAppOpenAttributionNative.isEmpty()) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(Collections.emptyList());
                return copyOnWriteArrayList;
            }
            CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList(this.onAppOpenAttributionNative.values());
            return copyOnWriteArrayList2;
        }
    }

    public final void AFInAppEventType() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.onResponseNative;
        if (j != 0) {
            this.onAttributionFailureNative++;
            if (j - currentTimeMillis < 500) {
                this.AFKeystoreWrapper.removeCallbacks(this.values);
                this.AFKeystoreWrapper.post(this.AFInAppEventParameterName);
            }
        } else {
            this.AFKeystoreWrapper.post(this.getLevel);
            this.AFKeystoreWrapper.post(this.AFInAppEventParameterName);
        }
        this.onResponseNative = currentTimeMillis;
    }

    public static w AFKeystoreWrapper(SensorManager sensorManager, Handler handler) {
        if (init == null) {
            synchronized (w.class) {
                if (init == null) {
                    init = new w(sensorManager, handler);
                }
            }
        }
        return init;
    }

    public static boolean AFKeystoreWrapper(int i) {
        return i >= 0 && AFLogger$LogLevel.get(i);
    }

    public final Map<String, Object> AFKeystoreWrapper() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        List<Map<String, Object>> values2 = values();
        if (!values2.isEmpty()) {
            concurrentHashMap.put("sensors", values2);
        } else {
            List<Map<String, Object>> AFInAppEventParameterName2 = AFInAppEventParameterName();
            if (!AFInAppEventParameterName2.isEmpty()) {
                concurrentHashMap.put("sensors", AFInAppEventParameterName2);
            }
        }
        return concurrentHashMap;
    }
}
