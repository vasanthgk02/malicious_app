package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zbn {
    public static zbn zbd;
    @VisibleForTesting
    public final Storage zba;
    @VisibleForTesting
    public GoogleSignInAccount zbb;
    @VisibleForTesting
    public GoogleSignInOptions zbc = this.zba.getSavedDefaultGoogleSignInOptions();

    public zbn(Context context) {
        Storage instance = Storage.getInstance(context);
        this.zba = instance;
        this.zbb = instance.getSavedDefaultGoogleSignInAccount();
    }

    public static synchronized zbn zbc(Context context) {
        zbn zbn;
        Class<zbn> cls = zbn.class;
        synchronized (cls) {
            Context applicationContext = context.getApplicationContext();
            synchronized (cls) {
                zbn = zbd;
                if (zbn == null) {
                    zbn = new zbn(applicationContext);
                    zbd = zbn;
                }
            }
        }
        return zbn;
    }

    /* JADX INFO: finally extract failed */
    public final synchronized void zbd() {
        Storage storage = this.zba;
        storage.zac.lock();
        try {
            storage.zad.edit().clear().apply();
            storage.zac.unlock();
            this.zbb = null;
            this.zbc = null;
        } catch (Throwable th) {
            storage.zac.unlock();
            throw th;
        }
    }
}
