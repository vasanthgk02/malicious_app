package com.mpl.androidapp.react.util;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.PromiseImpl;
import com.facebook.react.bridge.WritableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH&J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J&\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J0\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u0013"}, d2 = {"Lcom/mpl/androidapp/react/util/ShortPromise;", "Lcom/facebook/react/bridge/Promise;", "()V", "onFailure", "", "errorCode", "", "message", "throwable", "", "onSuccess", "description", "", "reject", "code", "userInfo", "Lcom/facebook/react/bridge/WritableMap;", "resolve", "value", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShortPromise.kt */
public abstract class ShortPromise implements Promise {
    public abstract void onFailure(String str, String str2, Throwable th);

    public abstract void onSuccess(Object obj);

    public void reject(String str, String str2) {
        onFailure(str, str2, null);
    }

    public void resolve(Object obj) {
        if (obj != null) {
            onSuccess(obj);
        }
    }

    public void reject(String str, Throwable th) {
        onFailure(str, "", null);
    }

    public void reject(String str, String str2, Throwable th) {
        onFailure(str, str2, th);
    }

    public void reject(Throwable th) {
        onFailure("", "", th);
    }

    public void reject(Throwable th, WritableMap writableMap) {
        onFailure("", "", th);
    }

    public void reject(String str, WritableMap writableMap) {
        Intrinsics.checkNotNullParameter(writableMap, PromiseImpl.ERROR_MAP_KEY_USER_INFO);
        onFailure(str, "", null);
    }

    public void reject(String str, Throwable th, WritableMap writableMap) {
        onFailure(str, "", th);
    }

    public void reject(String str, String str2, WritableMap writableMap) {
        Intrinsics.checkNotNullParameter(writableMap, PromiseImpl.ERROR_MAP_KEY_USER_INFO);
        onFailure(str, str2, null);
    }

    public void reject(String str, String str2, Throwable th, WritableMap writableMap) {
        onFailure(str, str2, th);
    }

    public void reject(String str) {
        onFailure("", str, null);
    }
}
