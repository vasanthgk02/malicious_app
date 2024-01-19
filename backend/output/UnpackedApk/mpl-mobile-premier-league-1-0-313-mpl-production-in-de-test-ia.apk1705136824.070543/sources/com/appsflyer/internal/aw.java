package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import com.appsflyer.AFLogger;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class aw<T> {
    public final Context AFInAppEventParameterName;
    public final FutureTask<T> AFInAppEventType = new FutureTask<>(new Callable<T>() {
        public final T call() {
            if (aw.this.values()) {
                return aw.this.AFInAppEventType();
            }
            return null;
        }
    });
    public final String AFKeystoreWrapper;
    public final String[] valueOf;

    public aw(Context context, String str, String... strArr) {
        this.AFInAppEventParameterName = context;
        this.AFKeystoreWrapper = str;
        this.valueOf = strArr;
    }

    public abstract T AFInAppEventType();

    public T AFKeystoreWrapper() {
        try {
            return this.AFInAppEventType.get(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            AFLogger.valueOf(e2.getMessage(), e2);
            return null;
        }
    }

    public final boolean values() {
        boolean z = false;
        try {
            ProviderInfo resolveContentProvider = this.AFInAppEventParameterName.getPackageManager().resolveContentProvider(this.AFKeystoreWrapper, 128);
            if (resolveContentProvider != null && Arrays.asList(this.valueOf).contains(z.AFInAppEventParameterName(this.AFInAppEventParameterName.getPackageManager(), resolveContentProvider.packageName))) {
                z = true;
            }
            return z;
        } catch (NameNotFoundException | NoSuchAlgorithmException | CertificateException e2) {
            AFLogger.valueOf(e2.getMessage(), e2);
            return false;
        }
    }
}
