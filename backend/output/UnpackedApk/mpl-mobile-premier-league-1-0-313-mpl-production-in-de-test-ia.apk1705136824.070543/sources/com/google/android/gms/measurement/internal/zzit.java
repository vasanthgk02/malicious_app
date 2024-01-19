package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.text.TextUtils;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.modules.network.NetworkingModule;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public final class zzit {
    public static String zzb(String str, String[] strArr, String[] strArr2) {
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i = 0; i < min; i++) {
            String str2 = strArr[i];
            if ((str == null && str2 == null) || (str != null && str.equals(str2))) {
                return strArr2[i];
            }
        }
        return null;
    }

    public static String zzc(Context context, String str, String str2) {
        Preconditions.checkNotNull(context);
        Resources resources = context.getResources();
        if (TextUtils.isEmpty(str2)) {
            str2 = ImageOriginUtils.zza(context);
        }
        int identifier = resources.getIdentifier("google_app_id", NetworkingModule.REQUEST_BODY_KEY_STRING, str2);
        if (identifier == 0) {
            return null;
        }
        try {
            return resources.getString(identifier);
        } catch (NotFoundException unused) {
            return null;
        }
    }
}
