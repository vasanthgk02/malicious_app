package com.facebook.imagepipeline.cache;

import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.imagepipeline.cache.MemoryCache.CacheTrimStrategy;

public class NativeMemoryCacheTrimStrategy implements CacheTrimStrategy {
    public static final String TAG = "NativeMemoryCacheTrimStrategy";

    /* renamed from: com.facebook.imagepipeline.cache.NativeMemoryCacheTrimStrategy$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$facebook$common$memory$MemoryTrimType;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|16) */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0024 */
        static {
            /*
                com.facebook.common.memory.MemoryTrimType[] r0 = com.facebook.common.memory.MemoryTrimType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$common$memory$MemoryTrimType = r0
                r1 = 1
                com.facebook.common.memory.MemoryTrimType r2 = com.facebook.common.memory.MemoryTrimType.OnCloseToDalvikHeapLimit     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                r2 = 4
                int[] r3 = $SwitchMap$com$facebook$common$memory$MemoryTrimType     // Catch:{ NoSuchFieldError -> 0x0017 }
                com.facebook.common.memory.MemoryTrimType r4 = com.facebook.common.memory.MemoryTrimType.OnAppBackgrounded     // Catch:{ NoSuchFieldError -> 0x0017 }
                r3[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                r3 = 3
                int[] r4 = $SwitchMap$com$facebook$common$memory$MemoryTrimType     // Catch:{ NoSuchFieldError -> 0x001e }
                com.facebook.common.memory.MemoryTrimType r5 = com.facebook.common.memory.MemoryTrimType.OnSystemMemoryCriticallyLowWhileAppInForeground     // Catch:{ NoSuchFieldError -> 0x001e }
                r4[r1] = r3     // Catch:{ NoSuchFieldError -> 0x001e }
            L_0x001e:
                int[] r1 = $SwitchMap$com$facebook$common$memory$MemoryTrimType     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.facebook.common.memory.MemoryTrimType r4 = com.facebook.common.memory.MemoryTrimType.OnSystemLowMemoryWhileAppInForeground     // Catch:{ NoSuchFieldError -> 0x0024 }
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                int[] r0 = $SwitchMap$com$facebook$common$memory$MemoryTrimType     // Catch:{ NoSuchFieldError -> 0x002b }
                com.facebook.common.memory.MemoryTrimType r1 = com.facebook.common.memory.MemoryTrimType.OnSystemLowMemoryWhileAppInBackground     // Catch:{ NoSuchFieldError -> 0x002b }
                r1 = 5
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.cache.NativeMemoryCacheTrimStrategy.AnonymousClass1.<clinit>():void");
        }
    }

    public double getTrimRatio(MemoryTrimType memoryTrimType) {
        int ordinal = memoryTrimType.ordinal();
        if (ordinal == 0) {
            return 0.0d;
        }
        if (ordinal == 1 || ordinal == 2 || ordinal == 3 || ordinal == 4) {
            return 1.0d;
        }
        FLog.wtf(TAG, "unknown trim type: %s", memoryTrimType);
        return 0.0d;
    }
}
