package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
public final class zzr extends zzp<Bundle> {
    public zzr(int i, Bundle bundle) {
        super(i, 1, bundle);
    }

    public final void zza(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        zzd(bundle2);
    }

    public final boolean zzb() {
        return false;
    }
}
