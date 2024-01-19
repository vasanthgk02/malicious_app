package com.google.android.gms.internal.p001authapi;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.internal.Preconditions;

/* renamed from: com.google.android.gms.internal.auth-api.zbn  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zbn {
    public static PendingIntent zba(Context context, AuthCredentialsOptions authCredentialsOptions, HintRequest hintRequest, String str) {
        String str2;
        Preconditions.checkNotNull(context, "context must not be null");
        Preconditions.checkNotNull(hintRequest, "request must not be null");
        if (TextUtils.isEmpty(str)) {
            str2 = zbbb.zba();
        } else {
            Preconditions.checkNotNull(str);
            str2 = str;
        }
        Intent putExtra = new Intent("com.google.android.gms.auth.api.credentials.PICKER").putExtra("claimedCallingPackage", null);
        putExtra.putExtra("logSessionId", str2);
        Parcel obtain = Parcel.obtain();
        hintRequest.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        putExtra.putExtra("com.google.android.gms.credentials.HintRequest", marshall);
        return zbbc.zba(context, 2000, putExtra, zbbc.zba | 134217728);
    }
}
