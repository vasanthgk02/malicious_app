package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public class DataBufferSafeParcelable<T extends SafeParcelable> extends AbstractDataBuffer<T> {
    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.Throwable, com.google.android.gms.common.data.DataHolder, java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0, types: [java.lang.Throwable, com.google.android.gms.common.data.DataHolder, java.lang.Object]
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY]]
      uses: [java.lang.Object, com.google.android.gms.common.data.DataHolder, java.lang.Throwable]
      mth insns count: 14
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object get(int r5) {
        /*
            r4 = this;
            r0 = 0
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            int r1 = r0.getWindowIndex(r5)
            java.lang.String r2 = "data"
            r0.zae(r2, r5)
            android.database.CursorWindow[] r3 = r0.zah
            r1 = r3[r1]
            android.os.Bundle r3 = r0.zab
            int r2 = r3.getInt(r2)
            byte[] r5 = r1.getBlob(r5, r2)
            android.os.Parcel r1 = android.os.Parcel.obtain()
            int r2 = r5.length
            r3 = 0
            r1.unmarshall(r5, r3, r2)
            r1.setDataPosition(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.DataBufferSafeParcelable.get(int):java.lang.Object");
    }
}
