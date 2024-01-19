package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public abstract class DataBufferRef {
    @KeepForSdk
    public final DataHolder mDataHolder;
    @KeepForSdk
    public int mDataRow;
    public int zaa;

    @KeepForSdk
    public boolean equals(Object obj) {
        if (obj instanceof DataBufferRef) {
            DataBufferRef dataBufferRef = (DataBufferRef) obj;
            if (Objects.equal(Integer.valueOf(dataBufferRef.mDataRow), Integer.valueOf(this.mDataRow)) && Objects.equal(Integer.valueOf(dataBufferRef.zaa), Integer.valueOf(this.zaa)) && dataBufferRef.mDataHolder == null) {
                return true;
            }
        }
        return false;
    }

    @KeepForSdk
    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.mDataRow), Integer.valueOf(this.zaa), null});
    }

    public final void zaa(int i) {
        if (i >= 0) {
            throw null;
        }
        Preconditions.checkState(false);
        this.mDataRow = i;
        throw null;
    }
}
