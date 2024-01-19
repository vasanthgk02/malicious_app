package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.internal.base.zau;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zaaa implements zaca {
    public final Context zaa;
    public final zabe zab;
    public final Looper zac;
    public final zabi zad;
    public final zabi zae;
    public final Map zaf;
    public final Set zag = Collections.newSetFromMap(new WeakHashMap());
    public final Client zah;
    public Bundle zai;
    public ConnectionResult zaj = null;
    public ConnectionResult zak = null;
    public boolean zal = false;
    public final Lock zam;
    public int zan = 0;

    public zaaa(Context context, zabe zabe, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map map, Map map2, ClientSettings clientSettings, AbstractClientBuilder abstractClientBuilder, Client client, ArrayList arrayList, ArrayList arrayList2, Map map3, Map map4) {
        this.zaa = context;
        zabe zabe2 = zabe;
        this.zab = zabe2;
        this.zam = lock;
        this.zac = looper;
        this.zah = client;
        Context context2 = context;
        Lock lock2 = lock;
        Looper looper2 = looper;
        GoogleApiAvailabilityLight googleApiAvailabilityLight2 = googleApiAvailabilityLight;
        zabi zabi = r2;
        zabi zabi2 = new zabi(context2, zabe2, lock2, looper2, googleApiAvailabilityLight2, map2, null, map4, null, arrayList2, new zax(this));
        this.zad = zabi;
        zabi zabi3 = new zabi(context2, this.zab, lock2, looper2, googleApiAvailabilityLight2, map, clientSettings, map3, abstractClientBuilder, arrayList, new zaz(this));
        this.zae = zabi3;
        ArrayMap arrayMap = new ArrayMap();
        for (AnyClientKey put : map2.keySet()) {
            arrayMap.put(put, this.zad);
        }
        for (AnyClientKey put2 : map.keySet()) {
            arrayMap.put(put2, this.zae);
        }
        this.zaf = Collections.unmodifiableMap(arrayMap);
    }

    public static boolean zaE(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    public static /* bridge */ /* synthetic */ void zap(zaaa zaaa) {
        if (zaE(zaaa.zaj)) {
            if (zaE(zaaa.zak) || zaaa.zaC()) {
                int i = zaaa.zan;
                if (i != 1) {
                    if (i != 2) {
                        Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                        zaaa.zan = 0;
                        return;
                    }
                    zabe zabe = zaaa.zab;
                    Preconditions.checkNotNull(zabe);
                    zabe.zab(zaaa.zai);
                }
                zaaa.zaB();
                zaaa.zan = 0;
                return;
            }
            ConnectionResult connectionResult = zaaa.zak;
            if (connectionResult != null) {
                if (zaaa.zan == 1) {
                    zaaa.zaB();
                    return;
                }
                zaaa.zaA(connectionResult);
                zaaa.zad.zar();
            }
        } else if (zaaa.zaj == null || !zaE(zaaa.zak)) {
            ConnectionResult connectionResult2 = zaaa.zaj;
            if (connectionResult2 != null) {
                ConnectionResult connectionResult3 = zaaa.zak;
                if (connectionResult3 != null) {
                    if (zaaa.zae.zaf < zaaa.zad.zaf) {
                        connectionResult2 = connectionResult3;
                    }
                    zaaa.zaA(connectionResult2);
                }
            }
        } else {
            zaaa.zae.zar();
            ConnectionResult connectionResult4 = zaaa.zaj;
            Preconditions.checkNotNull(connectionResult4);
            zaaa.zaA(connectionResult4);
        }
    }

    public final void zaA(ConnectionResult connectionResult) {
        int i = this.zan;
        if (i != 1) {
            if (i != 2) {
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                this.zan = 0;
            }
            this.zab.zaa(connectionResult);
        }
        zaB();
        this.zan = 0;
    }

    public final void zaB() {
        for (SignInConnectionListener onComplete : this.zag) {
            onComplete.onComplete();
        }
        this.zag.clear();
    }

    public final boolean zaC() {
        ConnectionResult connectionResult = this.zak;
        return connectionResult != null && connectionResult.zzb == 4;
    }

    public final boolean zaD(ApiMethodImpl apiMethodImpl) {
        zabi zabi = (zabi) this.zaf.get(apiMethodImpl.getClientKey());
        Preconditions.checkNotNull(zabi, "GoogleApiClient is not configured to use the API required for this call.");
        return zabi.equals(this.zae);
    }

    public final ConnectionResult zac(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public final ApiMethodImpl zae(ApiMethodImpl apiMethodImpl) {
        if (!zaD(apiMethodImpl)) {
            this.zad.zae(apiMethodImpl);
            return apiMethodImpl;
        } else if (zaC()) {
            apiMethodImpl.setFailedResult(new Status(4, null, zaz()));
            return apiMethodImpl;
        } else {
            this.zae.zae(apiMethodImpl);
            return apiMethodImpl;
        }
    }

    public final ApiMethodImpl zaf(ApiMethodImpl apiMethodImpl) {
        if (!zaD(apiMethodImpl)) {
            return this.zad.zaf(apiMethodImpl);
        }
        if (!zaC()) {
            return this.zae.zaf(apiMethodImpl);
        }
        apiMethodImpl.setFailedResult(new Status(4, null, zaz()));
        return apiMethodImpl;
    }

    public final void zaq() {
        this.zan = 2;
        this.zal = false;
        this.zak = null;
        this.zaj = null;
        this.zad.zan.zae();
        this.zae.zan.zae();
    }

    public final void zar() {
        this.zak = null;
        this.zaj = null;
        this.zan = 0;
        this.zad.zar();
        this.zae.zar();
        zaB();
    }

    public final void zas(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.zae.zas(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(":");
        this.zad.zas(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    public final void zat() {
        this.zad.zat();
        this.zae.zat();
    }

    public final void zau() {
        this.zam.lock();
        try {
            boolean zax = zax();
            this.zae.zar();
            this.zak = new ConnectionResult(4);
            if (zax) {
                new zau(this.zac).post(new zav(this));
            } else {
                zaB();
            }
        } finally {
            this.zam.unlock();
        }
    }

    public final boolean zaw() {
        this.zam.lock();
        try {
            boolean z = false;
            if ((this.zad.zan instanceof zaaj) && ((this.zae.zan instanceof zaaj) || zaC() || this.zan == 1)) {
                z = true;
            }
            return z;
        } finally {
            this.zam.unlock();
        }
    }

    public final boolean zax() {
        this.zam.lock();
        try {
            return this.zan == 2;
        } finally {
            this.zam.unlock();
        }
    }

    public final boolean zay(SignInConnectionListener signInConnectionListener) {
        this.zam.lock();
        try {
            if ((zax() || zaw()) && !(this.zae.zan instanceof zaaj)) {
                this.zag.add(signInConnectionListener);
                if (this.zan == 0) {
                    this.zan = 1;
                }
                this.zak = null;
                this.zae.zan.zae();
                return true;
            }
            this.zam.unlock();
            return false;
        } finally {
            this.zam.unlock();
        }
    }

    public final PendingIntent zaz() {
        if (this.zah == null) {
            return null;
        }
        return PendingIntent.getActivity(this.zaa, System.identityHashCode(this.zab), this.zah.getSignInIntent(), zap.zaa | 134217728);
    }
}
