package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zzn {
    public static final Uri zza = new Builder().scheme("content").authority("com.google.android.gms.chimera").build();
    public final String zzb;
    public final String zzc;
    public final ComponentName zzd;
    public final int zze;
    public final boolean zzf;

    public zzn(ComponentName componentName, int i) {
        this.zzb = null;
        this.zzc = null;
        Preconditions.checkNotNull(componentName);
        this.zzd = componentName;
        this.zze = i;
        this.zzf = false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzn)) {
            return false;
        }
        zzn zzn = (zzn) obj;
        return Objects.equal(this.zzb, zzn.zzb) && Objects.equal(this.zzc, zzn.zzc) && Objects.equal(this.zzd, zzn.zzd) && this.zze == zzn.zze && this.zzf == zzn.zzf;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzb, this.zzc, this.zzd, Integer.valueOf(this.zze), Boolean.valueOf(this.zzf)});
    }

    public final String toString() {
        String str = this.zzb;
        if (str != null) {
            return str;
        }
        Preconditions.checkNotNull(this.zzd);
        return this.zzd.flattenToString();
    }

    public final Intent zzc(Context context) {
        Intent intent;
        Bundle bundle;
        if (this.zzb != null) {
            intent = null;
            if (this.zzf) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("serviceActionBundleKey", this.zzb);
                try {
                    bundle = context.getContentResolver().call(zza, "serviceIntentCall", null, bundle2);
                } catch (IllegalArgumentException e2) {
                    "Dynamic intent resolution failed: ".concat(e2.toString());
                    bundle = null;
                }
                if (bundle != null) {
                    intent = (Intent) bundle.getParcelable("serviceResponseIntentKey");
                }
                if (intent == null) {
                    "Dynamic lookup for intent failed for action: ".concat(String.valueOf(this.zzb));
                }
            }
            if (intent == null) {
                return new Intent(this.zzb).setPackage(this.zzc);
            }
        } else {
            intent = new Intent().setComponent(this.zzd);
        }
        return intent;
    }

    public zzn(String str, String str2, int i, boolean z) {
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        Preconditions.checkNotEmpty(str2);
        this.zzc = str2;
        this.zzd = null;
        this.zze = i;
        this.zzf = z;
    }
}
