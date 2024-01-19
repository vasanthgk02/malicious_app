package com.google.android.gms.location;

import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public interface Geofence {

    @VisibleForTesting
    /* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
    public static final class Builder {
        public String zza = null;
        @TransitionTypes
        public int zzb = 0;
        public long zzc = Long.MIN_VALUE;
        public short zzd = -1;
        public double zze;
        public double zzf;
        public float zzg;
        public int zzh = 0;
        public int zzi = -1;
    }

    /* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
    public @interface GeofenceTransition {
    }

    /* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
    public @interface TransitionTypes {
    }

    String getRequestId();
}
