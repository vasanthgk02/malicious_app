package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import in.juspay.hypersdk.core.InflateView;
import java.util.ArrayList;
import java.util.List;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class Objects {

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public static final class ToStringHelper {
        public final List zza = new ArrayList();
        public final Object zzb;

        public /* synthetic */ ToStringHelper(Object obj) {
            Preconditions.checkNotNull(obj);
            this.zzb = obj;
        }

        @KeepForSdk
        public ToStringHelper add(String str, Object obj) {
            List list = this.zza;
            Preconditions.checkNotNull(str);
            String valueOf = String.valueOf(obj);
            list.add(str + InflateView.SETTER_EQUALS + valueOf);
            return this;
        }

        @KeepForSdk
        public String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.zzb.getClass().getSimpleName());
            sb.append('{');
            int size = this.zza.size();
            for (int i = 0; i < size; i++) {
                sb.append((String) this.zza.get(i));
                if (i < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public Objects() {
        throw new AssertionError("Uninstantiable");
    }

    @KeepForSdk
    public static boolean equal(Object obj, Object obj2) {
        boolean z = false;
        if (obj != obj2) {
            if (obj != null) {
                if (!obj.equals(obj2)) {
                    return false;
                }
            }
            return z;
        }
        z = true;
        return z;
    }
}
