package com.google.android.gms.auth.api.accounttransfer;

import android.os.Bundle;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.internal.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzq implements Optional {
    public final Bundle zzb;

    static {
        Bundle bundle = new Bundle();
        if (!bundle.containsKey("accountTypes")) {
            bundle.putStringArrayList("accountTypes", new ArrayList(0));
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzq)) {
            return false;
        }
        Bundle zza = zza();
        Bundle zza2 = ((zzq) obj).zza();
        if (zza.size() != zza2.size()) {
            return false;
        }
        for (String str : zza.keySet()) {
            if (!zza2.containsKey(str)) {
                return false;
            }
            if (!Objects.equal(zza.get(str), zza2.get(str))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        Bundle zza = zza();
        int size = zza.size();
        ArrayList arrayList = new ArrayList(size + size);
        ArrayList arrayList2 = new ArrayList(zza.keySet());
        Collections.sort(arrayList2);
        int size2 = arrayList2.size();
        for (int i = 0; i < size2; i++) {
            String str = (String) arrayList2.get(i);
            arrayList.add(str);
            arrayList.add(zza.get(str));
        }
        return Arrays.hashCode(new Object[]{arrayList});
    }

    public final Bundle zza() {
        return new Bundle(this.zzb);
    }
}
