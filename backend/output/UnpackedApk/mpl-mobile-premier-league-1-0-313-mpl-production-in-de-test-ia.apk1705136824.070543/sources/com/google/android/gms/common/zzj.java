package com.google.android.gms.common;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzy;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public abstract class zzj extends zzy {
    public final int zza;

    public zzj(byte[] bArr) {
        Preconditions.checkArgument(bArr.length == 25);
        this.zza = Arrays.hashCode(bArr);
    }

    public static byte[] zze(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzz)) {
            try {
                zzz zzz = (zzz) obj;
                if (zzz.zzc() != this.zza) {
                    return false;
                }
                IObjectWrapper zzd = zzz.zzd();
                if (zzd == null) {
                    return false;
                }
                return Arrays.equals(zzf(), (byte[]) ObjectWrapper.unwrap(zzd));
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zza;
    }

    public final int zzc() {
        return this.zza;
    }

    public final IObjectWrapper zzd() {
        return new ObjectWrapper(zzf());
    }

    public abstract byte[] zzf();
}
