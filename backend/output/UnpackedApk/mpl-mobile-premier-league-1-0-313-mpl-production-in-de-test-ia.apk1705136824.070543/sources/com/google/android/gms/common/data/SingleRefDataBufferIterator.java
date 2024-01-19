package com.google.android.gms.common.data;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.NoSuchElementException;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public class SingleRefDataBufferIterator<T> extends DataBufferIterator<T> {
    public Object zac;

    public final Object next() {
        if (hasNext()) {
            int i = this.zab + 1;
            this.zab = i;
            if (i == 0) {
                Object obj = this.zaa.get(0);
                Preconditions.checkNotNull(obj);
                this.zac = obj;
                if (!(obj instanceof DataBufferRef)) {
                    throw new IllegalStateException(GeneratedOutlineSupport.outline52("DataBuffer reference of type ", String.valueOf(obj.getClass()), " is not movable"));
                }
            } else {
                Object obj2 = this.zac;
                Preconditions.checkNotNull(obj2);
                ((DataBufferRef) obj2).zaa(this.zab);
            }
            return this.zac;
        }
        throw new NoSuchElementException(GeneratedOutlineSupport.outline41("Cannot advance the iterator beyond ", this.zab));
    }
}
