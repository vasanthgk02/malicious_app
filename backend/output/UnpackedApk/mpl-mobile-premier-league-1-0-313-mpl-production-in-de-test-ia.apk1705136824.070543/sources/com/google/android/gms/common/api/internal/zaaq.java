package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.internal.zak;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zaaq extends zabg {
    public final /* synthetic */ zaaw zaa;
    public final /* synthetic */ zak zab;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zaaq(zabf zabf, zaaw zaaw, zak zak) {
        // this.zaa = zaaw;
        // this.zab = zak;
        super(zabf);
    }

    public final void zaa() {
        zaaw zaaw = this.zaa;
        zak zak = this.zab;
        boolean z = false;
        if (zaaw.zaG(0)) {
            ConnectionResult connectionResult = zak.zab;
            if (connectionResult.isSuccess()) {
                zav zav = zak.zac;
                Preconditions.checkNotNull(zav);
                ConnectionResult connectionResult2 = zav.zac;
                if (!connectionResult2.isSuccess()) {
                    String valueOf = String.valueOf(connectionResult2);
                    Log.wtf("GACConnecting", "Sign-in succeeded with resolve account failure: ".concat(valueOf), new Exception());
                    zaaw.zaD(connectionResult2);
                    return;
                }
                zaaw.zan = true;
                IAccountAccessor zab2 = zav.zab();
                Preconditions.checkNotNull(zab2);
                zaaw.zao = zab2;
                zaaw.zap = zav.zad;
                zaaw.zaq = zav.zae;
                zaaw.zaF();
                return;
            }
            if (zaaw.zal && !connectionResult.hasResolution()) {
                z = true;
            }
            if (z) {
                zaaw.zaA();
                zaaw.zaF();
                return;
            }
            zaaw.zaD(connectionResult);
        }
    }
}
