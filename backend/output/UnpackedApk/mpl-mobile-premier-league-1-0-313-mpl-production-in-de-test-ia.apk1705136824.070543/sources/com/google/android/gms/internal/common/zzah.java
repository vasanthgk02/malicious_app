package com.google.android.gms.internal.common;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.jspecify.nullness.NullMarked;

@NullMarked
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zzah {
    public static Object[] zza(Object[] objArr, int i) {
        int i2 = 0;
        while (i2 < i) {
            if (objArr[i2] != null) {
                i2++;
            } else {
                throw new NullPointerException(GeneratedOutlineSupport.outline41("at index ", i2));
            }
        }
        return objArr;
    }
}
