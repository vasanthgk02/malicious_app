package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataBuffer;
import java.util.Iterator;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public class DataBufferResponse<T, R extends AbstractDataBuffer<T> & Result> extends Response<R> implements DataBuffer<T> {
    public final void close() {
        ((AbstractDataBuffer) this.zza).close();
    }

    public final T get(int i) {
        ((AbstractDataBuffer) this.zza).get(i);
        throw null;
    }

    public final int getCount() {
        if (((AbstractDataBuffer) this.zza) != null) {
            return 0;
        }
        throw null;
    }

    public final Iterator<T> iterator() {
        return ((AbstractDataBuffer) this.zza).iterator();
    }

    public final void release() {
        if (((AbstractDataBuffer) this.zza) == null) {
            throw null;
        }
    }
}
