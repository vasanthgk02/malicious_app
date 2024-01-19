package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.zap;
import com.google.android.gms.signin.zae;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zabq implements ConnectionCallbacks, OnConnectionFailedListener, zau {
    public final /* synthetic */ GoogleApiManager zaa;
    public final Queue zab = new LinkedList();
    @NotOnlyInitialized
    public final Client zac;
    public final ApiKey zad;
    public final zaad zae;
    public final Set zaf = new HashSet();
    public final Map zag = new HashMap();
    public final int zah;
    public final zact zai;
    public boolean zaj;
    public final List zak = new ArrayList();
    public ConnectionResult zal = null;
    public int zam = 0;

    public zabq(GoogleApiManager googleApiManager, GoogleApi googleApi) {
        this.zaa = googleApiManager;
        this.zac = googleApi.zab(googleApiManager.zat.getLooper(), this);
        this.zad = googleApi.getApiKey();
        this.zae = new zaad();
        this.zah = googleApi.zaa();
        if (this.zac.requiresSignIn()) {
            this.zai = googleApi.zac(googleApiManager.zak, googleApiManager.zat);
        } else {
            this.zai = null;
        }
    }

    public final void onConnected(Bundle bundle) {
        if (Looper.myLooper() == this.zaa.zat.getLooper()) {
            zaG();
        } else {
            this.zaa.zat.post(new zabm(this));
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zar(connectionResult, null);
    }

    public final void onConnectionSuspended(int i) {
        if (Looper.myLooper() == this.zaa.zat.getLooper()) {
            zaH(i);
        } else {
            this.zaa.zat.post(new zabn(this, i));
        }
    }

    public final Feature zaB(Feature[] featureArr) {
        if (!(featureArr == null || featureArr.length == 0)) {
            Feature[] availableFeatures = this.zac.getAvailableFeatures();
            if (availableFeatures == null) {
                availableFeatures = new Feature[0];
            }
            ArrayMap arrayMap = new ArrayMap(r3);
            for (Feature feature : availableFeatures) {
                arrayMap.put(feature.zza, Long.valueOf(feature.getVersion()));
            }
            for (Feature feature2 : featureArr) {
                Long l = (Long) arrayMap.get(feature2.zza);
                if (l == null || l.longValue() < feature2.getVersion()) {
                    return feature2;
                }
            }
        }
        return null;
    }

    public final void zaC(ConnectionResult connectionResult) {
        Iterator it = this.zaf.iterator();
        if (it.hasNext()) {
            zal zal2 = (zal) it.next();
            if (Objects.equal(connectionResult, ConnectionResult.RESULT_SUCCESS)) {
                this.zac.getEndpointPackageName();
            }
            if (zal2 != null) {
                throw null;
            }
            throw null;
        }
        this.zaf.clear();
    }

    public final void zaD(Status status) {
        Preconditions.checkHandlerThread(this.zaa.zat);
        zaE(status, null, false);
    }

    public final void zaE(Status status, Exception exc, boolean z) {
        Preconditions.checkHandlerThread(this.zaa.zat);
        boolean z2 = false;
        boolean z3 = status == null;
        if (exc == null) {
            z2 = true;
        }
        if (z3 != z2) {
            Iterator it = this.zab.iterator();
            while (it.hasNext()) {
                zai zai2 = (zai) it.next();
                if (!z || zai2.zac == 2) {
                    if (status != null) {
                        zai2.zad(status);
                    } else {
                        zai2.zae(exc);
                    }
                    it.remove();
                }
            }
            return;
        }
        throw new IllegalArgumentException("Status XOR exception should be null");
    }

    public final void zaF() {
        ArrayList arrayList = new ArrayList(this.zab);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            zai zai2 = (zai) arrayList.get(i);
            if (this.zac.isConnected()) {
                if (zaL(zai2)) {
                    this.zab.remove(zai2);
                }
                i++;
            } else {
                return;
            }
        }
    }

    public final void zaG() {
        zan();
        zaC(ConnectionResult.RESULT_SUCCESS);
        zaK();
        Iterator it = this.zag.values().iterator();
        while (it.hasNext()) {
            zaci zaci = (zaci) it.next();
            if (zaB(zaci.zaa.zab) != null) {
                it.remove();
            } else {
                try {
                    RegisterListenerMethod registerListenerMethod = zaci.zaa;
                    ((zack) registerListenerMethod).zaa.zaa.accept(this.zac, new TaskCompletionSource());
                } catch (DeadObjectException unused) {
                    onConnectionSuspended(3);
                    this.zac.disconnect("DeadObjectException thrown while calling register listener method.");
                } catch (RemoteException unused2) {
                    it.remove();
                }
            }
        }
        zaF();
        zaI();
    }

    public final void zaH(int i) {
        zan();
        this.zaj = true;
        zaad zaad = this.zae;
        String lastDisconnectMessage = this.zac.getLastDisconnectMessage();
        if (zaad != null) {
            StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
            if (i == 1) {
                sb.append(" due to service disconnection.");
            } else if (i == 3) {
                sb.append(" due to dead object exception.");
            }
            if (lastDisconnectMessage != null) {
                sb.append(" Last reason for disconnect: ");
                sb.append(lastDisconnectMessage);
            }
            zaad.zah(true, new Status(20, sb.toString()));
            Handler handler = this.zaa.zat;
            handler.sendMessageDelayed(Message.obtain(handler, 9, this.zad), this.zaa.zae);
            Handler handler2 = this.zaa.zat;
            handler2.sendMessageDelayed(Message.obtain(handler2, 11, this.zad), this.zaa.zaf);
            this.zaa.zam.zaa.clear();
            for (zaci zaci : this.zag.values()) {
                zaci.zac.run();
            }
            return;
        }
        throw null;
    }

    public final void zaI() {
        this.zaa.zat.removeMessages(12, this.zad);
        Handler handler = this.zaa.zat;
        handler.sendMessageDelayed(handler.obtainMessage(12, this.zad), this.zaa.zag);
    }

    public final void zaJ(zai zai2) {
        zai2.zag(this.zae, zaz());
        try {
            zai2.zaf(this);
        } catch (DeadObjectException unused) {
            onConnectionSuspended(1);
            this.zac.disconnect("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    public final void zaK() {
        if (this.zaj) {
            this.zaa.zat.removeMessages(11, this.zad);
            this.zaa.zat.removeMessages(9, this.zad);
            this.zaj = false;
        }
    }

    public final boolean zaL(zai zai2) {
        if (!(zai2 instanceof zac)) {
            zaJ(zai2);
            return true;
        }
        zac zac2 = (zac) zai2;
        Feature zaB = zaB(zac2.zab(this));
        if (zaB == null) {
            zaJ(zai2);
            return true;
        }
        this.zac.getClass().getName();
        if (!this.zaa.zau || !zac2.zaa(this)) {
            zac2.zae(new UnsupportedApiCallException(zaB));
            return true;
        }
        zabs zabs = new zabs(this.zad, zaB);
        int indexOf = this.zak.indexOf(zabs);
        if (indexOf >= 0) {
            zabs zabs2 = (zabs) this.zak.get(indexOf);
            this.zaa.zat.removeMessages(15, zabs2);
            Handler handler = this.zaa.zat;
            handler.sendMessageDelayed(Message.obtain(handler, 15, zabs2), this.zaa.zae);
        } else {
            this.zak.add(zabs);
            Handler handler2 = this.zaa.zat;
            handler2.sendMessageDelayed(Message.obtain(handler2, 15, zabs), this.zaa.zae);
            Handler handler3 = this.zaa.zat;
            handler3.sendMessageDelayed(Message.obtain(handler3, 16, zabs), this.zaa.zaf);
            ConnectionResult connectionResult = new ConnectionResult(2, null);
            if (!zaM(connectionResult)) {
                this.zaa.zaG(connectionResult, this.zah);
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zaM(com.google.android.gms.common.ConnectionResult r4) {
        /*
            r3 = this;
            java.lang.Object r0 = com.google.android.gms.common.api.internal.GoogleApiManager.zac
            monitor-enter(r0)
            com.google.android.gms.common.api.internal.GoogleApiManager r1 = r3.zaa     // Catch:{ all -> 0x0022 }
            com.google.android.gms.common.api.internal.zaae r2 = r1.zaq     // Catch:{ all -> 0x0022 }
            if (r2 == 0) goto L_0x001f
            java.util.Set r1 = r1.zar     // Catch:{ all -> 0x0022 }
            com.google.android.gms.common.api.internal.ApiKey r2 = r3.zad     // Catch:{ all -> 0x0022 }
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x001f
            com.google.android.gms.common.api.internal.GoogleApiManager r1 = r3.zaa     // Catch:{ all -> 0x0022 }
            com.google.android.gms.common.api.internal.zaae r1 = r1.zaq     // Catch:{ all -> 0x0022 }
            int r2 = r3.zah     // Catch:{ all -> 0x0022 }
            r1.zah(r4, r2)     // Catch:{ all -> 0x0022 }
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            r4 = 1
            return r4
        L_0x001f:
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            r4 = 0
            return r4
        L_0x0022:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zabq.zaM(com.google.android.gms.common.ConnectionResult):boolean");
    }

    public final boolean zaN(boolean z) {
        Preconditions.checkHandlerThread(this.zaa.zat);
        if (!this.zac.isConnected() || this.zag.size() != 0) {
            return false;
        }
        zaad zaad = this.zae;
        if (!zaad.zaa.isEmpty() || !zaad.zab.isEmpty()) {
            if (z) {
                zaI();
            }
            return false;
        }
        this.zac.disconnect("Timing out service connection.");
        return true;
    }

    public final void zaa(ConnectionResult connectionResult, Api api, boolean z) {
        throw null;
    }

    public final void zan() {
        Preconditions.checkHandlerThread(this.zaa.zat);
        this.zal = null;
    }

    /* JADX WARNING: type inference failed for: r3v5, types: [com.google.android.gms.common.api.Api$Client, com.google.android.gms.signin.zae] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v5, types: [com.google.android.gms.common.api.Api$Client, com.google.android.gms.signin.zae]
      assigns: [com.google.android.gms.common.api.Api$Client]
      uses: [com.google.android.gms.signin.zae]
      mth insns count: 69
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zao() {
        /*
            r10 = this;
            com.google.android.gms.common.api.internal.GoogleApiManager r0 = r10.zaa
            android.os.Handler r0 = r0.zat
            com.google.android.gms.common.internal.Preconditions.checkHandlerThread(r0)
            com.google.android.gms.common.api.Api$Client r0 = r10.zac
            boolean r0 = r0.isConnected()
            if (r0 != 0) goto L_0x00b6
            com.google.android.gms.common.api.Api$Client r0 = r10.zac
            boolean r0 = r0.isConnecting()
            if (r0 == 0) goto L_0x0019
            goto L_0x00b6
        L_0x0019:
            r0 = 10
            com.google.android.gms.common.api.internal.GoogleApiManager r1 = r10.zaa     // Catch:{ IllegalStateException -> 0x00ad }
            com.google.android.gms.common.internal.zal r2 = r1.zam     // Catch:{ IllegalStateException -> 0x00ad }
            android.content.Context r1 = r1.zak     // Catch:{ IllegalStateException -> 0x00ad }
            com.google.android.gms.common.api.Api$Client r3 = r10.zac     // Catch:{ IllegalStateException -> 0x00ad }
            int r1 = r2.zab(r1, r3)     // Catch:{ IllegalStateException -> 0x00ad }
            if (r1 == 0) goto L_0x003f
            com.google.android.gms.common.ConnectionResult r2 = new com.google.android.gms.common.ConnectionResult     // Catch:{ IllegalStateException -> 0x00ad }
            r3 = 0
            r2.<init>(r1, r3)     // Catch:{ IllegalStateException -> 0x00ad }
            com.google.android.gms.common.api.Api$Client r1 = r10.zac     // Catch:{ IllegalStateException -> 0x00ad }
            java.lang.Class r1 = r1.getClass()     // Catch:{ IllegalStateException -> 0x00ad }
            r1.getName()     // Catch:{ IllegalStateException -> 0x00ad }
            r2.toString()     // Catch:{ IllegalStateException -> 0x00ad }
            r10.zar(r2, r3)     // Catch:{ IllegalStateException -> 0x00ad }
            return
        L_0x003f:
            com.google.android.gms.common.api.internal.zabu r1 = new com.google.android.gms.common.api.internal.zabu
            com.google.android.gms.common.api.internal.GoogleApiManager r2 = r10.zaa
            com.google.android.gms.common.api.Api$Client r3 = r10.zac
            com.google.android.gms.common.api.internal.ApiKey r4 = r10.zad
            r1.<init>(r2, r3, r4)
            boolean r2 = r3.requiresSignIn()
            if (r2 == 0) goto L_0x009d
            com.google.android.gms.common.api.internal.zact r2 = r10.zai
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)
            com.google.android.gms.common.api.internal.zact r2 = (com.google.android.gms.common.api.internal.zact) r2
            com.google.android.gms.signin.zae r3 = r2.zag
            if (r3 == 0) goto L_0x005e
            r3.disconnect()
        L_0x005e:
            com.google.android.gms.common.internal.ClientSettings r3 = r2.zaf
            int r4 = java.lang.System.identityHashCode(r2)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3.zaj = r4
            com.google.android.gms.common.api.Api$AbstractClientBuilder r3 = r2.zad
            android.content.Context r4 = r2.zab
            android.os.Handler r5 = r2.zac
            android.os.Looper r5 = r5.getLooper()
            com.google.android.gms.common.internal.ClientSettings r6 = r2.zaf
            com.google.android.gms.signin.SignInOptions r7 = r6.zai
            r8 = r2
            r9 = r2
            com.google.android.gms.common.api.Api$Client r3 = r3.buildClient(r4, r5, r6, r7, r8, r9)
            r2.zag = r3
            r2.zah = r1
            java.util.Set r3 = r2.zae
            if (r3 == 0) goto L_0x0093
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x008d
            goto L_0x0093
        L_0x008d:
            com.google.android.gms.signin.zae r2 = r2.zag
            r2.zab()
            goto L_0x009d
        L_0x0093:
            android.os.Handler r3 = r2.zac
            com.google.android.gms.common.api.internal.zacq r4 = new com.google.android.gms.common.api.internal.zacq
            r4.<init>(r2)
            r3.post(r4)
        L_0x009d:
            com.google.android.gms.common.api.Api$Client r2 = r10.zac     // Catch:{ SecurityException -> 0x00a3 }
            r2.connect(r1)     // Catch:{ SecurityException -> 0x00a3 }
            return
        L_0x00a3:
            r1 = move-exception
            com.google.android.gms.common.ConnectionResult r2 = new com.google.android.gms.common.ConnectionResult
            r2.<init>(r0)
            r10.zar(r2, r1)
            return
        L_0x00ad:
            r1 = move-exception
            com.google.android.gms.common.ConnectionResult r2 = new com.google.android.gms.common.ConnectionResult
            r2.<init>(r0)
            r10.zar(r2, r1)
        L_0x00b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zabq.zao():void");
    }

    public final void zap(zai zai2) {
        Preconditions.checkHandlerThread(this.zaa.zat);
        if (!this.zac.isConnected()) {
            this.zab.add(zai2);
            ConnectionResult connectionResult = this.zal;
            if (connectionResult == null || !connectionResult.hasResolution()) {
                zao();
            } else {
                zar(this.zal, null);
            }
        } else if (zaL(zai2)) {
            zaI();
        } else {
            this.zab.add(zai2);
        }
    }

    public final void zar(ConnectionResult connectionResult, Exception exc) {
        Preconditions.checkHandlerThread(this.zaa.zat);
        zact zact = this.zai;
        if (zact != null) {
            zae zae2 = zact.zag;
            if (zae2 != null) {
                zae2.disconnect();
            }
        }
        zan();
        this.zaa.zam.zaa.clear();
        zaC(connectionResult);
        if ((this.zac instanceof zap) && connectionResult.zzb != 24) {
            GoogleApiManager googleApiManager = this.zaa;
            googleApiManager.zah = true;
            Handler handler = googleApiManager.zat;
            handler.sendMessageDelayed(handler.obtainMessage(19), 300000);
        }
        if (connectionResult.zzb == 4) {
            zaD(GoogleApiManager.zab);
        } else if (this.zab.isEmpty()) {
            this.zal = connectionResult;
        } else if (exc != null) {
            Preconditions.checkHandlerThread(this.zaa.zat);
            zaE(null, exc, false);
        } else if (this.zaa.zau) {
            zaE(GoogleApiManager.zaH(this.zad, connectionResult), null, true);
            if (!this.zab.isEmpty() && !zaM(connectionResult) && !this.zaa.zaG(connectionResult, this.zah)) {
                if (connectionResult.zzb == 18) {
                    this.zaj = true;
                }
                if (this.zaj) {
                    Handler handler2 = this.zaa.zat;
                    handler2.sendMessageDelayed(Message.obtain(handler2, 9, this.zad), this.zaa.zae);
                    return;
                }
                Status zaH = GoogleApiManager.zaH(this.zad, connectionResult);
                Preconditions.checkHandlerThread(this.zaa.zat);
                zaE(zaH, null, false);
            }
        } else {
            Status zaH2 = GoogleApiManager.zaH(this.zad, connectionResult);
            Preconditions.checkHandlerThread(this.zaa.zat);
            zaE(zaH2, null, false);
        }
    }

    public final void zav() {
        Preconditions.checkHandlerThread(this.zaa.zat);
        zaD(GoogleApiManager.zaa);
        zaad zaad = this.zae;
        if (zaad != null) {
            zaad.zah(false, GoogleApiManager.zaa);
            for (ListenerKey zah2 : (ListenerKey[]) this.zag.keySet().toArray(new ListenerKey[0])) {
                zap(new zah(zah2, new TaskCompletionSource()));
            }
            zaC(new ConnectionResult(4));
            if (this.zac.isConnected()) {
                this.zac.onUserSignOut(new zabp(this));
                return;
            }
            return;
        }
        throw null;
    }

    public final boolean zaz() {
        return this.zac.requiresSignIn();
    }
}
