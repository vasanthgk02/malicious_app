package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class RootTelemetryConfigManager {
    public static RootTelemetryConfigManager zza;
    public static final RootTelemetryConfiguration zzb;
    public RootTelemetryConfiguration zzc;

    static {
        RootTelemetryConfiguration rootTelemetryConfiguration = new RootTelemetryConfiguration(0, false, false, 0, 0);
        zzb = rootTelemetryConfiguration;
    }

    @KeepForSdk
    public static synchronized RootTelemetryConfigManager getInstance() {
        RootTelemetryConfigManager rootTelemetryConfigManager;
        synchronized (RootTelemetryConfigManager.class) {
            try {
                if (zza == null) {
                    zza = new RootTelemetryConfigManager();
                }
                rootTelemetryConfigManager = zza;
            }
        }
        return rootTelemetryConfigManager;
    }
}
