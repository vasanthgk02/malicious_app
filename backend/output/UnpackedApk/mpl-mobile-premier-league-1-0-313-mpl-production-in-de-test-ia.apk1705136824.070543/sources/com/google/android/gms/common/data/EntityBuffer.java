package com.google.android.gms.common.data;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public abstract class EntityBuffer<T> extends AbstractDataBuffer<T> {
    public boolean zaa;
    public ArrayList zab;

    @KeepForSdk
    public final T get(int i) {
        int i2;
        int i3;
        zab();
        int zaa2 = zaa(i);
        int i4 = 0;
        if (i >= 0 && i != this.zab.size()) {
            if (i == this.zab.size() - 1) {
                Preconditions.checkNotNull(null);
                i3 = null.zad;
                i2 = ((Integer) this.zab.get(i)).intValue();
            } else {
                i3 = ((Integer) this.zab.get(i + 1)).intValue();
                i2 = ((Integer) this.zab.get(i)).intValue();
            }
            i4 = i3 - i2;
            if (i4 == 1) {
                int zaa3 = zaa(i);
                Preconditions.checkNotNull(null);
                null.getWindowIndex(zaa3);
                if (getChildDataMarkerColumn() == null) {
                    i4 = 1;
                } else {
                    throw null;
                }
            }
        }
        return getEntry(zaa2, i4);
    }

    @KeepForSdk
    public String getChildDataMarkerColumn() {
        return null;
    }

    @KeepForSdk
    public int getCount() {
        zab();
        return this.zab.size();
    }

    @KeepForSdk
    public abstract T getEntry(int i, int i2);

    @KeepForSdk
    public abstract String getPrimaryDataMarkerColumn();

    public final int zaa(int i) {
        if (i >= 0 && i < this.zab.size()) {
            return ((Integer) this.zab.get(i)).intValue();
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline42("Position ", i, " is out of bounds for this buffer"));
    }

    public final void zab() {
        synchronized (this) {
            try {
                if (!this.zaa) {
                    Preconditions.checkNotNull(null);
                    int i = null.zad;
                    ArrayList arrayList = new ArrayList();
                    this.zab = arrayList;
                    if (i <= 0) {
                        this.zaa = true;
                    } else {
                        arrayList.add(Integer.valueOf(0));
                        getPrimaryDataMarkerColumn();
                        throw null;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
