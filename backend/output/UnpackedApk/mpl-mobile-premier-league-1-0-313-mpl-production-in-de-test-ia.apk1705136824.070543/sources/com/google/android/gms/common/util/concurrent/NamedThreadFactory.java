package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class NamedThreadFactory implements ThreadFactory {
    public final String zza;
    public final ThreadFactory zzb = Executors.defaultThreadFactory();

    @KeepForSdk
    public NamedThreadFactory(String str) {
        Preconditions.checkNotNull(str, "Name must not be null");
        this.zza = str;
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.zzb.newThread(new zza(runnable));
        newThread.setName(this.zza);
        return newThread;
    }
}
