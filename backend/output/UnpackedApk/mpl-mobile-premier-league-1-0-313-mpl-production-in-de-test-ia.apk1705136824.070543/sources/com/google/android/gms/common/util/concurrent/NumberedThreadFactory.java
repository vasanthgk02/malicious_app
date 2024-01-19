package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.fontbox.cmap.CMapParser;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class NumberedThreadFactory implements ThreadFactory {
    public final String zza;
    public final AtomicInteger zzb = new AtomicInteger();
    public final ThreadFactory zzc = Executors.defaultThreadFactory();

    @KeepForSdk
    public NumberedThreadFactory(String str) {
        Preconditions.checkNotNull(str, "Name must not be null");
        this.zza = str;
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.zzc.newThread(new zza(runnable));
        String str = this.zza;
        int andIncrement = this.zzb.getAndIncrement();
        newThread.setName(str + "[" + andIncrement + CMapParser.MARK_END_OF_ARRAY);
        return newThread;
    }
}
