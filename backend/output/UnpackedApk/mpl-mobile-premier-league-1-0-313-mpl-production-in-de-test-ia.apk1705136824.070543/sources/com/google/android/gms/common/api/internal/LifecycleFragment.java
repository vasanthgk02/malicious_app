package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public interface LifecycleFragment {
    @KeepForSdk
    void addCallback(String str, LifecycleCallback lifecycleCallback);

    @KeepForSdk
    <T extends LifecycleCallback> T getCallbackOrNull(String str, Class<T> cls);

    @KeepForSdk
    Activity getLifecycleActivity();

    @KeepForSdk
    void startActivityForResult(Intent intent, int i);
}
