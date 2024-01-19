package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.zae;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zaaw implements zabf {
    public final zabi zaa;
    public final Lock zab;
    public final Context zac;
    public final GoogleApiAvailabilityLight zad;
    public ConnectionResult zae;
    public int zaf;
    public int zag = 0;
    public int zah;
    public final Bundle zai = new Bundle();
    public final Set zaj = new HashSet();
    public zae zak;
    public boolean zal;
    public boolean zam;
    public boolean zan;
    public IAccountAccessor zao;
    public boolean zap;
    public boolean zaq;
    public final ClientSettings zar;
    public final Map zas;
    public final AbstractClientBuilder zat;
    public final ArrayList zau = new ArrayList();

    public zaaw(zabi zabi, ClientSettings clientSettings, Map map, GoogleApiAvailabilityLight googleApiAvailabilityLight, AbstractClientBuilder abstractClientBuilder, Lock lock, Context context) {
        this.zaa = zabi;
        this.zar = clientSettings;
        this.zas = map;
        this.zad = googleApiAvailabilityLight;
        this.zat = abstractClientBuilder;
        this.zab = lock;
        this.zac = context;
    }

    public final void zaA() {
        this.zam = false;
        this.zaa.zag.zad = Collections.emptySet();
        for (AnyClientKey anyClientKey : this.zaj) {
            if (!this.zaa.zab.containsKey(anyClientKey)) {
                this.zaa.zab.put(anyClientKey, new ConnectionResult(17, null));
            }
        }
    }

    public final void zaB(boolean z) {
        zae zae2 = this.zak;
        if (zae2 != null) {
            if (zae2.isConnected() && z) {
                zae2.zaa();
            }
            zae2.disconnect();
            ClientSettings clientSettings = this.zar;
            Preconditions.checkNotNull(clientSettings);
            ClientSettings clientSettings2 = clientSettings;
            this.zao = null;
        }
    }

    /* JADX INFO: finally extract failed */
    public final void zaC() {
        Bundle bundle;
        zabi zabi = this.zaa;
        zabi.zai.lock();
        try {
            zabi.zag.zak();
            zabi.zan = new zaaj(zabi);
            zabi.zan.zad();
            zabi.zaj.signalAll();
            zabi.zai.unlock();
            zabj.zaa.execute(new zaak(this));
            zae zae2 = this.zak;
            if (zae2 != null) {
                if (this.zap) {
                    IAccountAccessor iAccountAccessor = this.zao;
                    Preconditions.checkNotNull(iAccountAccessor);
                    zae2.zac(iAccountAccessor, this.zaq);
                }
                zaB(false);
            }
            for (AnyClientKey anyClientKey : this.zaa.zab.keySet()) {
                Client client = (Client) this.zaa.zaa.get(anyClientKey);
                Preconditions.checkNotNull(client);
                client.disconnect();
            }
            if (this.zai.isEmpty()) {
                bundle = null;
            } else {
                bundle = this.zai;
            }
            this.zaa.zah.zab(bundle);
        } catch (Throwable th) {
            zabi.zai.unlock();
            throw th;
        }
    }

    public final void zaD(ConnectionResult connectionResult) {
        zaz();
        zaB(!connectionResult.hasResolution());
        this.zaa.zak(connectionResult);
        this.zaa.zah.zaa(connectionResult);
    }

    public final void zaE(ConnectionResult connectionResult, Api api, boolean z) {
        int priority = api.zaa.getPriority();
        if ((!z || connectionResult.hasResolution() || this.zad.getErrorResolutionIntent(null, connectionResult.zzb, null) != null) && (this.zae == null || priority < this.zaf)) {
            this.zae = connectionResult;
            this.zaf = priority;
        }
        this.zaa.zab.put(api.zab, connectionResult);
    }

    public final void zaF() {
        if (this.zah == 0) {
            if (!this.zam || this.zan) {
                ArrayList arrayList = new ArrayList();
                this.zag = 1;
                this.zah = this.zaa.zaa.size();
                for (AnyClientKey anyClientKey : this.zaa.zaa.keySet()) {
                    if (!this.zaa.zab.containsKey(anyClientKey)) {
                        arrayList.add((Client) this.zaa.zaa.get(anyClientKey));
                    } else if (zaH()) {
                        zaC();
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.zau.add(zabj.zaa.submit(new zaap(this, arrayList)));
                }
            }
        }
    }

    public final boolean zaG(int i) {
        if (this.zag == i) {
            return true;
        }
        zabe zabe = this.zaa.zag;
        if (zabe != null) {
            StringWriter stringWriter = new StringWriter();
            zabe.dump("", null, new PrintWriter(stringWriter), null);
            stringWriter.toString();
            "Unexpected callback in ".concat(toString());
            new Exception();
            zaD(new ConnectionResult(8, null));
            return false;
        }
        throw null;
    }

    public final boolean zaH() {
        int i = this.zah - 1;
        this.zah = i;
        if (i > 0) {
            return false;
        }
        if (i < 0) {
            zabe zabe = this.zaa.zag;
            if (zabe != null) {
                StringWriter stringWriter = new StringWriter();
                zabe.dump("", null, new PrintWriter(stringWriter), null);
                stringWriter.toString();
                Log.wtf("GACConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
                zaD(new ConnectionResult(8, null));
                return false;
            }
            throw null;
        }
        ConnectionResult connectionResult = this.zae;
        if (connectionResult == null) {
            return true;
        }
        this.zaa.zaf = this.zaf;
        zaD(connectionResult);
        return false;
    }

    public final ApiMethodImpl zaa(ApiMethodImpl apiMethodImpl) {
        this.zaa.zag.zaa.add(apiMethodImpl);
        return apiMethodImpl;
    }

    public final ApiMethodImpl zab(ApiMethodImpl apiMethodImpl) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    /* JADX WARNING: type inference failed for: r0v13, types: [com.google.android.gms.common.api.Api$Client, com.google.android.gms.signin.zae] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v13, types: [com.google.android.gms.common.api.Api$Client, com.google.android.gms.signin.zae]
      assigns: [com.google.android.gms.common.api.Api$Client]
      uses: [com.google.android.gms.signin.zae]
      mth insns count: 79
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zad() {
        /*
            r10 = this;
            com.google.android.gms.common.api.internal.zabi r0 = r10.zaa
            java.util.Map r0 = r0.zab
            r0.clear()
            r0 = 0
            r10.zam = r0
            r1 = 0
            r10.zae = r1
            r10.zag = r0
            r1 = 1
            r10.zal = r1
            r10.zan = r0
            r10.zap = r0
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.util.Map r3 = r10.zas
            java.util.Set r3 = r3.keySet()
            java.util.Iterator r3 = r3.iterator()
            r4 = 0
        L_0x0026:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0076
            java.lang.Object r5 = r3.next()
            com.google.android.gms.common.api.Api r5 = (com.google.android.gms.common.api.Api) r5
            com.google.android.gms.common.api.internal.zabi r6 = r10.zaa
            java.util.Map r6 = r6.zaa
            com.google.android.gms.common.api.Api$ClientKey r7 = r5.zab
            java.lang.Object r6 = r6.get(r7)
            com.google.android.gms.common.api.Api$Client r6 = (com.google.android.gms.common.api.Api.Client) r6
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)
            com.google.android.gms.common.api.Api$AbstractClientBuilder r7 = r5.zaa
            int r7 = r7.getPriority()
            if (r7 != r1) goto L_0x004b
            r7 = 1
            goto L_0x004c
        L_0x004b:
            r7 = 0
        L_0x004c:
            r4 = r4 | r7
            java.util.Map r7 = r10.zas
            java.lang.Object r7 = r7.get(r5)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            boolean r8 = r6.requiresSignIn()
            if (r8 == 0) goto L_0x006d
            r10.zam = r1
            if (r7 == 0) goto L_0x006b
            java.util.Set r8 = r10.zaj
            com.google.android.gms.common.api.Api$ClientKey r9 = r5.zab
            r8.add(r9)
            goto L_0x006d
        L_0x006b:
            r10.zal = r0
        L_0x006d:
            com.google.android.gms.common.api.internal.zaal r8 = new com.google.android.gms.common.api.internal.zaal
            r8.<init>(r10, r5, r7)
            r2.put(r6, r8)
            goto L_0x0026
        L_0x0076:
            if (r4 == 0) goto L_0x007a
            r10.zam = r0
        L_0x007a:
            boolean r0 = r10.zam
            if (r0 == 0) goto L_0x00b2
            com.google.android.gms.common.internal.ClientSettings r0 = r10.zar
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            com.google.android.gms.common.api.Api$AbstractClientBuilder r0 = r10.zat
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            com.google.android.gms.common.internal.ClientSettings r0 = r10.zar
            com.google.android.gms.common.api.internal.zabi r1 = r10.zaa
            com.google.android.gms.common.api.internal.zabe r1 = r1.zag
            int r1 = java.lang.System.identityHashCode(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.zaj = r1
            com.google.android.gms.common.api.internal.zaat r9 = new com.google.android.gms.common.api.internal.zaat
            r9.<init>(r10)
            com.google.android.gms.common.api.Api$AbstractClientBuilder r3 = r10.zat
            android.content.Context r4 = r10.zac
            com.google.android.gms.common.api.internal.zabi r0 = r10.zaa
            com.google.android.gms.common.api.internal.zabe r0 = r0.zag
            android.os.Looper r5 = r0.zao
            com.google.android.gms.common.internal.ClientSettings r6 = r10.zar
            com.google.android.gms.signin.SignInOptions r7 = r6.zai
            r8 = r9
            com.google.android.gms.common.api.Api$Client r0 = r3.buildClient(r4, r5, r6, r7, r8, r9)
            r10.zak = r0
        L_0x00b2:
            com.google.android.gms.common.api.internal.zabi r0 = r10.zaa
            java.util.Map r0 = r0.zaa
            int r0 = r0.size()
            r10.zah = r0
            java.util.ArrayList r0 = r10.zau
            java.util.concurrent.ExecutorService r1 = com.google.android.gms.common.api.internal.zabj.zaa
            com.google.android.gms.common.api.internal.zaao r3 = new com.google.android.gms.common.api.internal.zaao
            r3.<init>(r10, r2)
            java.util.concurrent.Future r1 = r1.submit(r3)
            r0.add(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zaaw.zad():void");
    }

    public final void zae() {
    }

    public final void zag(Bundle bundle) {
        if (zaG(1)) {
            if (bundle != null) {
                this.zai.putAll(bundle);
            }
            if (zaH()) {
                zaC();
            }
        }
    }

    public final void zah(ConnectionResult connectionResult, Api api, boolean z) {
        if (zaG(1)) {
            zaE(connectionResult, api, z);
            if (zaH()) {
                zaC();
            }
        }
    }

    public final void zai(int i) {
        zaD(new ConnectionResult(8, null));
    }

    public final boolean zaj() {
        zaz();
        zaB(true);
        this.zaa.zak(null);
        return true;
    }

    public final void zaz() {
        ArrayList arrayList = this.zau;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Future) arrayList.get(i)).cancel(true);
        }
        this.zau.clear();
    }
}
