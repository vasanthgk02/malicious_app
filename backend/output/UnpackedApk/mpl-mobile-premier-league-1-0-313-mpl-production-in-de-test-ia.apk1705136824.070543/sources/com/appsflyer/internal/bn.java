package com.appsflyer.internal;

import android.net.TrafficStats;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class bn<Result> implements Comparable<bn<?>>, Callable<bo> {
    public static final AtomicInteger valueOf = new AtomicInteger();
    public final Set<bt> AFInAppEventParameterName = new HashSet();
    public final int AFInAppEventType;
    public final String AFKeystoreWrapper;
    public final bt values;

    public bn(bt btVar, bt[] btVarArr, String str) {
        new HashSet();
        this.AFInAppEventType = valueOf.incrementAndGet();
        this.values = btVar;
        Collections.addAll(this.AFInAppEventParameterName, btVarArr);
        this.AFKeystoreWrapper = str;
    }

    /* renamed from: AFInAppEventParameterName */
    public final bo call() throws Exception {
        TrafficStats.setThreadStatsTag("AppsFlyer".hashCode());
        try {
            return values();
        } catch (Throwable th) {
            bo boVar = bo.FAILURE;
            throw th;
        }
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        bn bnVar = (bn) obj;
        int i = this.values.valueOf - bnVar.values.valueOf;
        return i == 0 ? this.AFInAppEventType - bnVar.AFInAppEventType : i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        bn bnVar = (bn) obj;
        if (this.values != bnVar.values) {
            return false;
        }
        return this.AFKeystoreWrapper.equals(bnVar.AFKeystoreWrapper);
    }

    public final int hashCode() {
        return this.AFKeystoreWrapper.hashCode() + (this.values.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.values);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        sb.append(this.AFKeystoreWrapper);
        String obj = sb.toString();
        if (String.valueOf(this.AFInAppEventType).equals(this.AFKeystoreWrapper)) {
            return obj;
        }
        StringBuilder outline78 = GeneratedOutlineSupport.outline78(obj, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        outline78.append(this.AFInAppEventType);
        return outline78.toString();
    }

    public abstract bo values() throws Exception;
}
