package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzs;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import org.apache.pdfbox.pdmodel.interactive.form.PDChoice;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class ConnectionTracker {
    public static final Object zzb = new Object();
    public static volatile ConnectionTracker zzc;
    @VisibleForTesting
    public ConcurrentHashMap zza = new ConcurrentHashMap();

    @KeepForSdk
    public static ConnectionTracker getInstance() {
        if (zzc == null) {
            synchronized (zzb) {
                try {
                    if (zzc == null) {
                        zzc = new ConnectionTracker();
                    }
                }
            }
        }
        ConnectionTracker connectionTracker = zzc;
        Preconditions.checkNotNull(connectionTracker);
        return connectionTracker;
    }

    public static final boolean zze(Context context, Intent intent, ServiceConnection serviceConnection, int i, Executor executor) {
        if (!(VERSION.SDK_INT >= 29) || executor == null) {
            return context.bindService(intent, serviceConnection, i);
        }
        return context.bindService(intent, i, executor, serviceConnection);
    }

    @KeepForSdk
    public boolean bindService(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return zzc(context, context.getClass().getName(), intent, serviceConnection, i, true, null);
    }

    @KeepForSdk
    public void unbindService(Context context, ServiceConnection serviceConnection) {
        if (!(!(serviceConnection instanceof zzs)) || !this.zza.containsKey(serviceConnection)) {
            try {
                context.unbindService(serviceConnection);
            } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
            }
            return;
        }
        try {
            try {
                context.unbindService((ServiceConnection) this.zza.get(serviceConnection));
            } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused2) {
            }
        } finally {
            this.zza.remove(serviceConnection);
        }
    }

    public final boolean zzc(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i, boolean z, Executor executor) {
        boolean z2;
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((Wrappers.packageManager(context).getApplicationInfo(packageName, 0).flags & PDChoice.FLAG_MULTI_SELECT) != 0) {
                    return false;
                }
            } catch (NameNotFoundException unused) {
            }
        }
        if (!(serviceConnection instanceof zzs)) {
            ServiceConnection serviceConnection2 = (ServiceConnection) this.zza.putIfAbsent(serviceConnection, serviceConnection);
            if (!(serviceConnection2 == null || serviceConnection == serviceConnection2)) {
                String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", new Object[]{serviceConnection, str, intent.getAction()});
            }
            try {
                z2 = zze(context, intent, serviceConnection, i, executor);
                if (!z2) {
                    return false;
                }
            } finally {
                this.zza.remove(serviceConnection, serviceConnection);
            }
        } else {
            z2 = zze(context, intent, serviceConnection, i, executor);
        }
        return z2;
    }
}
