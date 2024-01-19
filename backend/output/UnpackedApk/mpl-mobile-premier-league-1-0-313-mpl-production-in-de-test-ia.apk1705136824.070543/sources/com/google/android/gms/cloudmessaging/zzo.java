package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
public final class zzo extends zzp<Void> {
    public zzo(int i, Bundle bundle) {
        super(i, 2, bundle);
    }

    public final void zza(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            zzd(null);
        } else {
            zzc(new zzq("Invalid response to one way request", null));
        }
    }

    public final boolean zzb() {
        return true;
    }
}
