package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.wrappers.Wrappers;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.eclipse.paho.client.mqttv3.internal.websocket.WebSocketHandshake;

@ShowFirstParty
@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class AndroidUtilsLight {
    @KeepForSdk
    @Deprecated
    public static byte[] getPackageCertificateHashBytes(Context context, String str) throws NameNotFoundException {
        PackageInfo packageInfo = Wrappers.packageManager(context).zza.getPackageManager().getPackageInfo(str, 64);
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null && signatureArr.length == 1) {
            MessageDigest zza = zza(WebSocketHandshake.SHA1_PROTOCOL);
            if (zza != null) {
                return zza.digest(packageInfo.signatures[0].toByteArray());
            }
        }
        return null;
    }

    public static MessageDigest zza(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }
}
