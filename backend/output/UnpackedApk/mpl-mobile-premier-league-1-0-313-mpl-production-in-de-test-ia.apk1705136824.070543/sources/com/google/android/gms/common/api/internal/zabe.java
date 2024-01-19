package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.collection.ArrayMap;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zaj;
import com.google.android.gms.common.internal.zak;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.perf.config.RemoteConfigManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zabe extends GoogleApiClient implements zabz {
    @VisibleForTesting
    public final Queue zaa = new LinkedList();
    @VisibleForTesting
    public zabx zab;
    public final Map zac;
    public Set zad = new HashSet();
    public final ClientSettings zae;
    public final Map zaf;
    public final AbstractClientBuilder zag;
    public Set zah = null;
    public final zadc zai;
    public final Lock zaj;
    public final zak zak;
    public zaca zal = null;
    public final int zam;
    public final Context zan;
    public final Looper zao;
    public volatile boolean zap;
    public long zaq = 120000;
    public long zar = RemoteConfigManager.MIN_APP_START_CONFIG_FETCH_DELAY_MS;
    public final zabc zas;
    public final GoogleApiAvailability zat;
    public final ListenerHolders zau = new ListenerHolders();
    public final ArrayList zav;
    public Integer zaw = null;
    public final zaj zax;

    public zabe(Context context, Lock lock, Looper looper, ClientSettings clientSettings, GoogleApiAvailability googleApiAvailability, AbstractClientBuilder abstractClientBuilder, Map map, List<ConnectionCallbacks> list, List<OnConnectionFailedListener> list2, Map map2, int i, int i2, ArrayList arrayList) {
        int i3 = i;
        zaay zaay = new zaay(this);
        this.zax = zaay;
        this.zan = context;
        this.zaj = lock;
        this.zak = new zak(looper, zaay);
        this.zao = looper;
        this.zas = new zabc(this, looper);
        this.zat = googleApiAvailability;
        this.zam = i3;
        if (i3 >= 0) {
            this.zaw = Integer.valueOf(i2);
        }
        this.zaf = map;
        this.zac = map2;
        this.zav = arrayList;
        this.zai = new zadc();
        for (ConnectionCallbacks connectionCallbacks : list) {
            zak zak2 = this.zak;
            if (zak2 != null) {
                Preconditions.checkNotNull(connectionCallbacks);
                synchronized (zak2.zai) {
                    if (zak2.zac.contains(connectionCallbacks)) {
                        String.valueOf(connectionCallbacks);
                    } else {
                        zak2.zac.add(connectionCallbacks);
                    }
                }
                if (zak2.zab.isConnected()) {
                    Handler handler = zak2.zah;
                    handler.sendMessage(handler.obtainMessage(1, connectionCallbacks));
                }
            } else {
                throw null;
            }
        }
        for (OnConnectionFailedListener zag2 : list2) {
            this.zak.zag(zag2);
        }
        this.zae = clientSettings;
        this.zag = abstractClientBuilder;
    }

    public static int zad(Iterable<Client> iterable, boolean z) {
        boolean z2 = false;
        boolean z3 = false;
        for (Client client : iterable) {
            z2 |= client.requiresSignIn();
            z3 |= client.providesSignIn();
        }
        if (z2) {
            return (!z3 || !z) ? 1 : 2;
        }
        return 3;
    }

    public static String zag(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "UNKNOWN" : "SIGN_IN_MODE_NONE" : "SIGN_IN_MODE_OPTIONAL" : "SIGN_IN_MODE_REQUIRED";
    }

    public static /* bridge */ /* synthetic */ void zai(zabe zabe) {
        zabe.zaj.lock();
        try {
            if (zabe.zap) {
                zabe.zan();
            }
        } finally {
            zabe.zaj.unlock();
        }
    }

    public final ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        Preconditions.checkState(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        this.zaj.lock();
        try {
            Integer num = this.zaw;
            if (num == null) {
                this.zaw = Integer.valueOf(zad(this.zac.values(), false));
            } else if (num.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            Integer num2 = this.zaw;
            Preconditions.checkNotNull(num2);
            zal(num2.intValue());
            this.zak.zae = true;
            zaca zaca = this.zal;
            Preconditions.checkNotNull(zaca);
            return zaca.zac(j, timeUnit);
        } finally {
            this.zaj.unlock();
        }
    }

    public final void connect() {
        this.zaj.lock();
        try {
            int i = 2;
            boolean z = false;
            if (this.zam >= 0) {
                Preconditions.checkState(this.zaw != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.zaw;
                if (num == null) {
                    this.zaw = Integer.valueOf(zad(this.zac.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            Integer num2 = this.zaw;
            Preconditions.checkNotNull(num2);
            int intValue = num2.intValue();
            this.zaj.lock();
            if (intValue == 3 || intValue == 1) {
                i = intValue;
            } else if (intValue != 2) {
                i = intValue;
                Preconditions.checkArgument(z, "Illegal sign-in mode: " + i);
                zal(i);
                zan();
            }
            z = true;
            Preconditions.checkArgument(z, "Illegal sign-in mode: " + i);
            zal(i);
            zan();
        } catch (Throwable th) {
            throw th;
        } finally {
            this.zaj.unlock();
        }
    }

    public final void disconnect() {
        Lock lock;
        this.zaj.lock();
        try {
            this.zai.zab();
            zaca zaca = this.zal;
            if (zaca != null) {
                zaca.zar();
            }
            ListenerHolders listenerHolders = this.zau;
            for (ListenerHolder clear : listenerHolders.zaa) {
                clear.clear();
            }
            listenerHolders.zaa.clear();
            for (ApiMethodImpl apiMethodImpl : this.zaa) {
                apiMethodImpl.zan(null);
                apiMethodImpl.cancel();
            }
            this.zaa.clear();
            if (this.zal == null) {
                lock = this.zaj;
            } else {
                zak();
                this.zak.zaa();
                lock = this.zaj;
            }
            lock.unlock();
        } catch (Throwable th) {
            this.zaj.unlock();
            throw th;
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.zan);
        printWriter.append(str).append("mResuming=").print(this.zap);
        printWriter.append(" mWorkQueue.size()=").print(this.zaa.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.zai.zab.size());
        zaca zaca = this.zal;
        if (zaca != null) {
            zaca.zas(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final <A extends AnyClient, R extends Result, T extends ApiMethodImpl<R, A>> T enqueue(T t) {
        Lock lock;
        Api<?> api = t.getApi();
        boolean containsKey = this.zac.containsKey(t.getClientKey());
        String str = api != null ? api.zac : "the API";
        Preconditions.checkArgument(containsKey, "GoogleApiClient is not configured to use " + str + " required for this call.");
        this.zaj.lock();
        try {
            zaca zaca = this.zal;
            if (zaca == null) {
                this.zaa.add(t);
                lock = this.zaj;
            } else {
                t = zaca.zae(t);
                lock = this.zaj;
            }
            lock.unlock();
            return t;
        } catch (Throwable th) {
            this.zaj.unlock();
            throw th;
        }
    }

    public final <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T execute(T t) {
        Lock lock;
        Api<?> api = t.getApi();
        boolean containsKey = this.zac.containsKey(t.getClientKey());
        String str = api != null ? api.zac : "the API";
        Preconditions.checkArgument(containsKey, "GoogleApiClient is not configured to use " + str + " required for this call.");
        this.zaj.lock();
        try {
            zaca zaca = this.zal;
            if (zaca != null) {
                if (this.zap) {
                    this.zaa.add(t);
                    while (!this.zaa.isEmpty()) {
                        ApiMethodImpl apiMethodImpl = (ApiMethodImpl) this.zaa.remove();
                        zadc zadc = this.zai;
                        zadc.zab.add(apiMethodImpl);
                        apiMethodImpl.zan(zadc.zac);
                        apiMethodImpl.setFailedResult(Status.RESULT_INTERNAL_ERROR);
                    }
                    lock = this.zaj;
                } else {
                    t = zaca.zaf(t);
                    lock = this.zaj;
                }
                lock.unlock();
                return t;
            }
            throw new IllegalStateException("GoogleApiClient is not connected yet.");
        } catch (Throwable th) {
            this.zaj.unlock();
            throw th;
        }
    }

    public final <C extends Client> C getClient(AnyClientKey<C> anyClientKey) {
        C c2 = (Client) this.zac.get(anyClientKey);
        Preconditions.checkNotNull(c2, "Appropriate Api was not requested.");
        return c2;
    }

    public final Context getContext() {
        return this.zan;
    }

    public final Looper getLooper() {
        return this.zao;
    }

    public final boolean isConnected() {
        zaca zaca = this.zal;
        return zaca != null && zaca.zaw();
    }

    public final boolean isConnecting() {
        zaca zaca = this.zal;
        return zaca != null && zaca.zax();
    }

    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        zaca zaca = this.zal;
        return zaca != null && zaca.zay(signInConnectionListener);
    }

    public final void maybeSignOut() {
        zaca zaca = this.zal;
        if (zaca != null) {
            zaca.zau();
        }
    }

    public final void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        zak zak2 = this.zak;
        if (zak2 != null) {
            Preconditions.checkNotNull(onConnectionFailedListener);
            synchronized (zak2.zai) {
                if (!zak2.zad.remove(onConnectionFailedListener)) {
                    String.valueOf(onConnectionFailedListener);
                }
            }
            return;
        }
        throw null;
    }

    public final void zaa(ConnectionResult connectionResult) {
        GoogleApiAvailability googleApiAvailability = this.zat;
        Context context = this.zan;
        int i = connectionResult.zzb;
        if (googleApiAvailability != null) {
            if (!GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, i)) {
                zak();
            }
            if (!this.zap) {
                zak zak2 = this.zak;
                Preconditions.checkHandlerThread(zak2.zah, "onConnectionFailure must only be called on the Handler thread");
                zak2.zah.removeMessages(1);
                synchronized (zak2.zai) {
                    ArrayList arrayList = new ArrayList(zak2.zad);
                    int i2 = zak2.zaf.get();
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        OnConnectionFailedListener onConnectionFailedListener = (OnConnectionFailedListener) it.next();
                        if (!zak2.zae) {
                            break;
                        } else if (zak2.zaf.get() != i2) {
                            break;
                        } else if (zak2.zad.contains(onConnectionFailedListener)) {
                            onConnectionFailedListener.onConnectionFailed(connectionResult);
                        }
                    }
                }
                this.zak.zaa();
                return;
            }
            return;
        }
        throw null;
    }

    public final void zab(Bundle bundle) {
        while (!this.zaa.isEmpty()) {
            execute((ApiMethodImpl) this.zaa.remove());
        }
        zak zak2 = this.zak;
        Preconditions.checkHandlerThread(zak2.zah, "onConnectionSuccess must only be called on the Handler thread");
        synchronized (zak2.zai) {
            Preconditions.checkState(!zak2.zag);
            zak2.zah.removeMessages(1);
            zak2.zag = true;
            Preconditions.checkState(zak2.zaa.isEmpty());
            ArrayList arrayList = new ArrayList(zak2.zac);
            int i = zak2.zaf.get();
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) it.next();
                if (!zak2.zae || !zak2.zab.isConnected()) {
                    break;
                } else if (zak2.zaf.get() != i) {
                    break;
                } else if (!zak2.zaa.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(bundle);
                }
            }
            zak2.zaa.clear();
            zak2.zag = false;
        }
    }

    public final void zac(int i, boolean z) {
        if (i == 1) {
            if (!z && !this.zap) {
                this.zap = true;
                if (this.zab == null) {
                    try {
                        this.zab = this.zat.zac(this.zan.getApplicationContext(), new zabd(this));
                    } catch (SecurityException unused) {
                    }
                }
                zabc zabc = this.zas;
                zabc.sendMessageDelayed(zabc.obtainMessage(1), this.zaq);
                zabc zabc2 = this.zas;
                zabc2.sendMessageDelayed(zabc2.obtainMessage(2), this.zar);
            }
            i = 1;
        }
        for (BasePendingResult forceFailureUnlessReady : (BasePendingResult[]) this.zai.zab.toArray(new BasePendingResult[0])) {
            forceFailureUnlessReady.forceFailureUnlessReady(zadc.zaa);
        }
        zak zak2 = this.zak;
        Preconditions.checkHandlerThread(zak2.zah, "onUnintentionalDisconnection must only be called on the Handler thread");
        zak2.zah.removeMessages(1);
        synchronized (zak2.zai) {
            zak2.zag = true;
            ArrayList arrayList = new ArrayList(zak2.zac);
            int i2 = zak2.zaf.get();
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) it.next();
                if (!zak2.zae) {
                    break;
                } else if (zak2.zaf.get() != i2) {
                    break;
                } else if (zak2.zac.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i);
                }
            }
            zak2.zaa.clear();
            zak2.zag = false;
        }
        this.zak.zaa();
        if (i == 2) {
            zan();
        }
    }

    public final boolean zak() {
        if (!this.zap) {
            return false;
        }
        this.zap = false;
        this.zas.removeMessages(2);
        this.zas.removeMessages(1);
        zabx zabx = this.zab;
        if (zabx != null) {
            zabx.zab();
            this.zab = null;
        }
        return true;
    }

    public final void zal(int i) {
        zabe zabe;
        Integer num = this.zaw;
        if (num == null) {
            this.zaw = Integer.valueOf(i);
        } else if (num.intValue() != i) {
            int intValue = this.zaw.intValue();
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Cannot use sign-in mode: ");
            outline73.append(zag(i));
            outline73.append(". Mode was already set to ");
            outline73.append(zag(intValue));
            throw new IllegalStateException(outline73.toString());
        }
        if (this.zal == null) {
            boolean z = false;
            boolean z2 = false;
            for (Client client : this.zac.values()) {
                z |= client.requiresSignIn();
                z2 |= client.providesSignIn();
            }
            int intValue2 = this.zaw.intValue();
            if (intValue2 == 1) {
                zabe = this;
                if (!z) {
                    throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                } else if (z2) {
                    throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            } else if (intValue2 == 2 && z) {
                Context context = this.zan;
                Lock lock = this.zaj;
                Looper looper = this.zao;
                GoogleApiAvailability googleApiAvailability = this.zat;
                Map map = this.zac;
                ClientSettings clientSettings = this.zae;
                Map map2 = this.zaf;
                AbstractClientBuilder abstractClientBuilder = this.zag;
                ArrayList arrayList = this.zav;
                ArrayMap arrayMap = new ArrayMap();
                ArrayMap arrayMap2 = new ArrayMap();
                Iterator it = map.entrySet().iterator();
                Client client2 = null;
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    Client client3 = (Client) entry.getValue();
                    Iterator it2 = it;
                    if (true == client3.providesSignIn()) {
                        client2 = client3;
                    }
                    if (client3.requiresSignIn()) {
                        arrayMap.put((AnyClientKey) entry.getKey(), client3);
                    } else {
                        arrayMap2.put((AnyClientKey) entry.getKey(), client3);
                    }
                    it = it2;
                }
                Preconditions.checkState(!arrayMap.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
                ArrayMap arrayMap3 = new ArrayMap();
                ArrayMap arrayMap4 = new ArrayMap();
                Iterator it3 = map2.keySet().iterator();
                while (it3.hasNext()) {
                    Api api = (Api) it3.next();
                    Iterator it4 = it3;
                    ClientKey clientKey = api.zab;
                    if (arrayMap.containsKey(clientKey)) {
                        arrayMap3.put(api, (Boolean) map2.get(api));
                    } else if (arrayMap2.containsKey(clientKey)) {
                        arrayMap4.put(api, (Boolean) map2.get(api));
                    } else {
                        throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
                    }
                    it3 = it4;
                }
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    int i3 = size;
                    zat zat2 = (zat) arrayList.get(i2);
                    ArrayList arrayList4 = arrayList;
                    if (arrayMap3.containsKey(zat2.zaa)) {
                        arrayList2.add(zat2);
                    } else if (arrayMap4.containsKey(zat2.zaa)) {
                        arrayList3.add(zat2);
                    } else {
                        throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
                    }
                    i2++;
                    size = i3;
                    arrayList = arrayList4;
                }
                ArrayList arrayList5 = arrayList2;
                zaaa zaaa = new zaaa(context, this, lock, looper, googleApiAvailability, arrayMap, arrayMap2, clientSettings, abstractClientBuilder, client2, arrayList5, arrayList3, arrayMap3, arrayMap4);
                this.zal = zaaa;
                return;
            } else {
                zabe = this;
            }
            zabi zabi = new zabi(zabe.zan, this, zabe.zaj, zabe.zao, zabe.zat, zabe.zac, zabe.zae, zabe.zaf, zabe.zag, zabe.zav, this);
            zabe.zal = zabi;
        }
    }

    public final void zan() {
        this.zak.zae = true;
        zaca zaca = this.zal;
        Preconditions.checkNotNull(zaca);
        zaca.zaq();
    }

    public final void zao(zada zada) {
        this.zaj.lock();
        try {
            if (this.zah == null) {
                this.zah = new HashSet();
            }
            this.zah.add(zada);
        } finally {
            this.zaj.unlock();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0041, code lost:
        if (r3 == false) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zap(com.google.android.gms.common.api.internal.zada r3) {
        /*
            r2 = this;
            java.util.concurrent.locks.Lock r0 = r2.zaj
            r0.lock()
            java.util.Set r0 = r2.zah     // Catch:{ all -> 0x0057 }
            java.lang.String r1 = "GoogleApiClientImpl"
            if (r0 != 0) goto L_0x0016
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ all -> 0x0057 }
            r3.<init>()     // Catch:{ all -> 0x0057 }
            java.lang.String r0 = "Attempted to remove pending transform when no transforms are registered."
            android.util.Log.wtf(r1, r0, r3)     // Catch:{ all -> 0x0057 }
            goto L_0x004a
        L_0x0016:
            boolean r3 = r0.remove(r3)     // Catch:{ all -> 0x0057 }
            if (r3 != 0) goto L_0x0027
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ all -> 0x0057 }
            r3.<init>()     // Catch:{ all -> 0x0057 }
            java.lang.String r0 = "Failed to remove pending transform - this may lead to memory leaks!"
            android.util.Log.wtf(r1, r0, r3)     // Catch:{ all -> 0x0057 }
            goto L_0x004a
        L_0x0027:
            java.util.concurrent.locks.Lock r3 = r2.zaj     // Catch:{ all -> 0x0057 }
            r3.lock()     // Catch:{ all -> 0x0057 }
            java.util.Set r3 = r2.zah     // Catch:{ all -> 0x0050 }
            if (r3 != 0) goto L_0x0036
            java.util.concurrent.locks.Lock r3 = r2.zaj     // Catch:{ all -> 0x0057 }
            r3.unlock()     // Catch:{ all -> 0x0057 }
            goto L_0x0043
        L_0x0036:
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0050 }
            r3 = r3 ^ 1
            java.util.concurrent.locks.Lock r0 = r2.zaj     // Catch:{ all -> 0x0057 }
            r0.unlock()     // Catch:{ all -> 0x0057 }
            if (r3 != 0) goto L_0x004a
        L_0x0043:
            com.google.android.gms.common.api.internal.zaca r3 = r2.zal     // Catch:{ all -> 0x0057 }
            if (r3 == 0) goto L_0x004a
            r3.zat()     // Catch:{ all -> 0x0057 }
        L_0x004a:
            java.util.concurrent.locks.Lock r3 = r2.zaj
            r3.unlock()
            return
        L_0x0050:
            r3 = move-exception
            java.util.concurrent.locks.Lock r0 = r2.zaj     // Catch:{ all -> 0x0057 }
            r0.unlock()     // Catch:{ all -> 0x0057 }
            throw r3     // Catch:{ all -> 0x0057 }
        L_0x0057:
            r3 = move-exception
            java.util.concurrent.locks.Lock r0 = r2.zaj
            r0.unlock()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zabe.zap(com.google.android.gms.common.api.internal.zada):void");
    }
}
