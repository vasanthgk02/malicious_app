package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zac implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return ((Scope) obj).zzb.compareTo(((Scope) obj2).zzb);
    }
}
