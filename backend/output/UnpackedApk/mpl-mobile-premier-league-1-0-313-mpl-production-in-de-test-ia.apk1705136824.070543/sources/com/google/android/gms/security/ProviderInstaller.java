package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import java.lang.reflect.Method;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class ProviderInstaller {
    public static final GoogleApiAvailabilityLight zza = GoogleApiAvailabilityLight.zza;
    public static final Object zzb = new Object();
    public static Method zzc = null;
    public static Method zzd = null;

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i, Intent intent);

        void onProviderInstalled();
    }

    public static void installIfNeeded(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        Context context2;
        Preconditions.checkNotNull(context, "Context must not be null");
        if (zza != null) {
            GooglePlayServicesUtilLight.ensurePlayServicesAvailable(context, 11925000);
            synchronized (zzb) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                try {
                    context2 = DynamiteModule.load(context, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.providerinstaller.dynamite").zzj;
                } catch (LoadingException e2) {
                    "Failed to load providerinstaller module: ".concat(String.valueOf(e2.getMessage()));
                    context2 = null;
                }
                if (context2 == null) {
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
                    if (remoteContext != null) {
                        try {
                            if (zzd == null) {
                                zzd = remoteContext.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("reportRequestStats", new Class[]{Context.class, Long.TYPE, Long.TYPE});
                            }
                            zzd.invoke(null, new Object[]{context, Long.valueOf(elapsedRealtime), Long.valueOf(elapsedRealtime2)});
                        } catch (Exception e3) {
                            "Failed to report request stats: ".concat(String.valueOf(e3.getMessage()));
                        }
                    }
                    if (remoteContext != null) {
                        zzc(remoteContext, context, "com.google.android.gms.common.security.ProviderInstallerImpl");
                        return;
                    }
                    throw new GooglePlayServicesNotAvailableException(8);
                }
                zzc(context2, context, "com.google.android.gms.providerinstaller.ProviderInstallerImpl");
                return;
            }
        }
        throw null;
    }

    public static void installIfNeededAsync(Context context, ProviderInstallListener providerInstallListener) {
        Preconditions.checkNotNull(context, "Context must not be null");
        Preconditions.checkNotNull(providerInstallListener, "Listener must not be null");
        Preconditions.checkMainThread("Must be called on the UI thread");
        new zza(context, providerInstallListener).execute(new Void[0]);
    }

    public static void zzc(Context context, Context context2, String str) throws GooglePlayServicesNotAvailableException {
        try {
            if (zzc == null) {
                zzc = context.getClassLoader().loadClass(str).getMethod("insertProvider", new Class[]{Context.class});
            }
            zzc.invoke(null, new Object[]{context});
        } catch (Exception e2) {
            Throwable cause = e2.getCause();
            if (Log.isLoggable("ProviderInstaller", 6)) {
                "Failed to install provider: ".concat(String.valueOf(cause == null ? e2.getMessage() : cause.getMessage()));
            }
            throw new GooglePlayServicesNotAvailableException(8);
        }
    }
}
