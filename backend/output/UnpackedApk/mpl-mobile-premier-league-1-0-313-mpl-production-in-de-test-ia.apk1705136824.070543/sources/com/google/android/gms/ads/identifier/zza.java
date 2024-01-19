package com.google.android.gms.ads.identifier;

import android.net.Uri;
import android.net.Uri.Builder;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-identifier@@17.1.0 */
public final class zza extends Thread {
    public final /* synthetic */ Map zza;

    public zza(Map map) {
        this.zza = map;
    }

    public final void run() {
        Map map = this.zza;
        Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        for (String str : map.keySet()) {
            buildUpon.appendQueryParameter(str, (String) map.get(str));
        }
        zzc.zza(buildUpon.build().toString());
    }
}
