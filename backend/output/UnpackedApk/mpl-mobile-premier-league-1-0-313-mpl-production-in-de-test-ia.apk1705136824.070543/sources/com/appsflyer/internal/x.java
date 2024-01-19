package com.appsflyer.internal;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

public final class x implements SensorEventListener {
    public double AFInAppEventParameterName;
    public final float[][] AFInAppEventType = new float[2][];
    public long AFKeystoreWrapper;
    public final String AFLogger$LogLevel;
    public final String AFVersionDeclaration;
    public final int AppsFlyer2dXConversionCallback;
    public final Executor getLevel;
    public final long[] valueOf = new long[2];
    public final int values;

    public x(Sensor sensor, Executor executor) {
        this.getLevel = executor;
        this.values = sensor.getType();
        String str = "";
        this.AFLogger$LogLevel = sensor.getName() == null ? str : sensor.getName();
        String vendor = sensor.getVendor();
        str = vendor != null ? vendor : str;
        this.AFVersionDeclaration = str;
        this.AppsFlyer2dXConversionCallback = str.hashCode() + ((this.AFLogger$LogLevel.hashCode() + ((this.values + 31) * 31)) * 31);
    }

    private boolean AFInAppEventParameterName(int i, String str, String str2) {
        return this.values == i && this.AFLogger$LogLevel.equals(str) && this.AFVersionDeclaration.equals(str2);
    }

    public static List<Float> AFInAppEventType(float[] fArr) {
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float valueOf2 : fArr) {
            arrayList.add(Float.valueOf(valueOf2));
        }
        return arrayList;
    }

    public final void AFKeystoreWrapper(Map<x, Map<String, Object>> map, boolean z) {
        if (AFKeystoreWrapper()) {
            map.put(this, AFInAppEventType());
            if (z) {
                int length = this.AFInAppEventType.length;
                for (int i = 0; i < length; i++) {
                    this.AFInAppEventType[i] = null;
                }
                int length2 = this.valueOf.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    this.valueOf[i2] = 0;
                }
                this.AFInAppEventParameterName = 0.0d;
                this.AFKeystoreWrapper = 0;
            }
        } else if (!map.containsKey(this)) {
            map.put(this, AFInAppEventType());
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return AFInAppEventParameterName(xVar.values, xVar.AFLogger$LogLevel, xVar.AFVersionDeclaration);
    }

    public final int hashCode() {
        return this.AppsFlyer2dXConversionCallback;
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        final long j = sensorEvent.timestamp;
        final float[] fArr = sensorEvent.values;
        this.getLevel.execute(new Runnable() {
            public final void run() {
                long currentTimeMillis = System.currentTimeMillis();
                x xVar = x.this;
                float[][] fArr = xVar.AFInAppEventType;
                float[] fArr2 = fArr[0];
                if (fArr2 == null) {
                    float[] fArr3 = fArr;
                    fArr[0] = Arrays.copyOf(fArr3, fArr3.length);
                    x.this.valueOf[0] = currentTimeMillis;
                    return;
                }
                float[] fArr4 = fArr[1];
                if (fArr4 == null) {
                    float[] fArr5 = fArr;
                    float[] copyOf = Arrays.copyOf(fArr5, fArr5.length);
                    x xVar2 = x.this;
                    xVar2.AFInAppEventType[1] = copyOf;
                    xVar2.valueOf[1] = currentTimeMillis;
                    xVar2.AFInAppEventParameterName = x.AFInAppEventParameterName(fArr2, copyOf);
                    return;
                }
                long j = j;
                if (50000000 <= j - xVar.AFKeystoreWrapper) {
                    xVar.AFKeystoreWrapper = j;
                    if (Arrays.equals(fArr4, fArr)) {
                        x.this.valueOf[1] = currentTimeMillis;
                        return;
                    }
                    double AFInAppEventParameterName = x.AFInAppEventParameterName(fArr2, fArr);
                    x xVar3 = x.this;
                    if (AFInAppEventParameterName > xVar3.AFInAppEventParameterName) {
                        float[][] fArr6 = xVar3.AFInAppEventType;
                        float[] fArr7 = fArr;
                        fArr6[1] = Arrays.copyOf(fArr7, fArr7.length);
                        x xVar4 = x.this;
                        xVar4.valueOf[1] = currentTimeMillis;
                        xVar4.AFInAppEventParameterName = AFInAppEventParameterName;
                    }
                }
            }
        });
    }

    public static /* synthetic */ double AFInAppEventParameterName(float[] fArr, float[] fArr2) {
        int min = Math.min(fArr.length, fArr2.length);
        double d2 = 0.0d;
        for (int i = 0; i < min; i++) {
            d2 += StrictMath.pow((double) (fArr[i] - fArr2[i]), 2.0d);
        }
        return Math.sqrt(d2);
    }

    private Map<String, Object> AFInAppEventType() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(7);
        concurrentHashMap.put("sT", Integer.valueOf(this.values));
        concurrentHashMap.put("sN", this.AFLogger$LogLevel);
        concurrentHashMap.put("sV", this.AFVersionDeclaration);
        float[] fArr = this.AFInAppEventType[0];
        if (fArr != null) {
            concurrentHashMap.put("sVS", AFInAppEventType(fArr));
        }
        float[] fArr2 = this.AFInAppEventType[1];
        if (fArr2 != null) {
            concurrentHashMap.put("sVE", AFInAppEventType(fArr2));
        }
        return concurrentHashMap;
    }

    private boolean AFKeystoreWrapper() {
        return this.AFInAppEventType[0] != null;
    }
}
