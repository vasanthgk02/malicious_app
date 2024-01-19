package com.google.android.gms.ads.identifier;

import com.google.android.gms.internal.ads_identifier.zzi;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: com.google.android.gms:play-services-ads-identifier@@17.1.0 */
public final class zzc {
    public static final void zza(String str) {
        HttpURLConnection httpURLConnection;
        try {
            zzi.zzb(263);
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 200 || responseCode >= 300) {
                String.valueOf(str).length();
            }
            httpURLConnection.disconnect();
            zzi.zza();
        } catch (IndexOutOfBoundsException e2) {
            String message = e2.getMessage();
            String.valueOf(str).length();
            String.valueOf(message).length();
            zzi.zza();
        } catch (IOException | RuntimeException e3) {
            try {
                String message2 = e3.getMessage();
                String.valueOf(str).length();
                String.valueOf(message2).length();
            } finally {
                zzi.zza();
            }
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
    }
}
