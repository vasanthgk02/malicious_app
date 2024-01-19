package com.reactnative.ivpusic.imagepicker;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableNativeArray;
import java.util.concurrent.atomic.AtomicInteger;

public class ResultCollector {
    public WritableArray arrayResult;
    public boolean multiple;
    public Promise promise;
    public boolean resultSent;
    public int waitCount;
    public AtomicInteger waitCounter;

    public final synchronized boolean isRequestValid() {
        if (this.resultSent) {
            return false;
        }
        if (this.promise == null) {
            return false;
        }
        return true;
    }

    public synchronized void notifyProblem(String str, String str2) {
        if (isRequestValid()) {
            this.promise.reject(str, str2);
            this.resultSent = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void notifySuccess(com.facebook.react.bridge.WritableMap r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.isRequestValid()     // Catch:{ all -> 0x0030 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r2)
            return
        L_0x0009:
            boolean r0 = r2.multiple     // Catch:{ all -> 0x0030 }
            r1 = 1
            if (r0 == 0) goto L_0x0027
            com.facebook.react.bridge.WritableArray r0 = r2.arrayResult     // Catch:{ all -> 0x0030 }
            r0.pushMap(r3)     // Catch:{ all -> 0x0030 }
            java.util.concurrent.atomic.AtomicInteger r3 = r2.waitCounter     // Catch:{ all -> 0x0030 }
            int r3 = r3.addAndGet(r1)     // Catch:{ all -> 0x0030 }
            int r0 = r2.waitCount     // Catch:{ all -> 0x0030 }
            if (r3 != r0) goto L_0x002e
            com.facebook.react.bridge.Promise r3 = r2.promise     // Catch:{ all -> 0x0030 }
            com.facebook.react.bridge.WritableArray r0 = r2.arrayResult     // Catch:{ all -> 0x0030 }
            r3.resolve(r0)     // Catch:{ all -> 0x0030 }
            r2.resultSent = r1     // Catch:{ all -> 0x0030 }
            goto L_0x002e
        L_0x0027:
            com.facebook.react.bridge.Promise r0 = r2.promise     // Catch:{ all -> 0x0030 }
            r0.resolve(r3)     // Catch:{ all -> 0x0030 }
            r2.resultSent = r1     // Catch:{ all -> 0x0030 }
        L_0x002e:
            monitor-exit(r2)
            return
        L_0x0030:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnative.ivpusic.imagepicker.ResultCollector.notifySuccess(com.facebook.react.bridge.WritableMap):void");
    }

    public synchronized void setWaitCount(int i) {
        this.waitCount = i;
        this.waitCounter = new AtomicInteger(0);
    }

    public synchronized void setup(Promise promise2, boolean z) {
        this.promise = promise2;
        this.multiple = z;
        this.resultSent = false;
        this.waitCount = 0;
        this.waitCounter = new AtomicInteger(0);
        if (z) {
            this.arrayResult = new WritableNativeArray();
        }
    }

    public synchronized void notifyProblem(String str, Throwable th) {
        if (isRequestValid()) {
            th.getMessage();
            this.promise.reject(str, th);
            this.resultSent = true;
        }
    }
}
