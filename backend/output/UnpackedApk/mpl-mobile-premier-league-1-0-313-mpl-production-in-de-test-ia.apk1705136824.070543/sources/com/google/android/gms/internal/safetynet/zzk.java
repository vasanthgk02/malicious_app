package com.google.android.gms.internal.safetynet;

import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.HarmfulAppsData;
import com.google.android.gms.safetynet.SafeBrowsingData;
import com.google.android.gms.safetynet.SafeBrowsingThreat;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.safetynet.SafetyNetApi.RecaptchaTokenResult;
import com.google.android.gms.safetynet.SafetyNetApi.SafeBrowsingResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class zzk implements SafetyNetApi {
    public static final String TAG = "zzk";

    public static class zza implements com.google.android.gms.safetynet.SafetyNetApi.zza {
        public final Status zzad;
        public final com.google.android.gms.safetynet.zza zzae;

        public zza(Status status, com.google.android.gms.safetynet.zza zza) {
            this.zzad = status;
            this.zzae = zza;
        }

        public final String getJwsResult() {
            com.google.android.gms.safetynet.zza zza = this.zzae;
            if (zza == null) {
                return null;
            }
            return zza.zze;
        }

        public final Status getStatus() {
            return this.zzad;
        }
    }

    public static abstract class zzb extends zzf<com.google.android.gms.safetynet.SafetyNetApi.zza> {
        public zzg zzaf = new zzs(this);

        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return new zza(status, null);
        }
    }

    public static abstract class zzc extends zzf<com.google.android.gms.safetynet.SafetyNetApi.zzc> {
        public zzg zzaf = new zzt(this);

        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return new zzj(status, false);
        }
    }

    public static abstract class zzd extends zzf<com.google.android.gms.safetynet.SafetyNetApi.zzb> {
        public final zzg zzaf = new zzu(this);

        public zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return new zzg(status, null);
        }
    }

    public static abstract class zze extends zzf<RecaptchaTokenResult> {
        public zzg zzaf = new zzv(this);

        public zze(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return new zzh(status, null);
        }
    }

    public static abstract class zzf extends zzf<SafeBrowsingResult> {
        public zzg zzaf = new zzw(this);

        public zzf(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return new zzi(status, null);
        }
    }

    public static class zzg implements com.google.android.gms.safetynet.SafetyNetApi.zzb {
        public final Status zzad;
        public final com.google.android.gms.safetynet.zzd zzal;

        public zzg(Status status, com.google.android.gms.safetynet.zzd zzd) {
            this.zzad = status;
            this.zzal = zzd;
        }

        public final List<HarmfulAppsData> getHarmfulAppsList() {
            com.google.android.gms.safetynet.zzd zzd = this.zzal;
            return zzd == null ? Collections.emptyList() : Arrays.asList(zzd.zzg);
        }

        public final int getHoursSinceLastScanWithHarmfulApp() {
            com.google.android.gms.safetynet.zzd zzd = this.zzal;
            if (zzd == null) {
                return -1;
            }
            return zzd.zzh;
        }

        public final long getLastScanTimeMs() {
            com.google.android.gms.safetynet.zzd zzd = this.zzal;
            if (zzd == null) {
                return 0;
            }
            return zzd.zzf;
        }

        public final Status getStatus() {
            return this.zzad;
        }
    }

    public static class zzh implements RecaptchaTokenResult {
        public final Status zzad;
        public final com.google.android.gms.safetynet.zzf zzam;

        public zzh(Status status, com.google.android.gms.safetynet.zzf zzf) {
            this.zzad = status;
            this.zzam = zzf;
        }

        public final Status getStatus() {
            return this.zzad;
        }

        public final String getTokenResult() {
            com.google.android.gms.safetynet.zzf zzf = this.zzam;
            if (zzf == null) {
                return null;
            }
            return zzf.zzj;
        }
    }

    public static class zzi implements SafeBrowsingResult {
        public Status zzad;
        public final SafeBrowsingData zzan;
        public String zzm = null;
        public long zzp;
        public byte[] zzq;

        public zzi(Status status, SafeBrowsingData safeBrowsingData) {
            this.zzad = status;
            this.zzan = safeBrowsingData;
            if (safeBrowsingData != null) {
                this.zzm = safeBrowsingData.zzm;
                this.zzp = safeBrowsingData.zzp;
                this.zzq = safeBrowsingData.zzq;
                return;
            }
            if (status.isSuccess()) {
                this.zzad = new Status(8, null);
            }
        }

        public final List<SafeBrowsingThreat> getDetectedThreats() {
            ArrayList arrayList = new ArrayList();
            if (this.zzm == null) {
                return arrayList;
            }
            try {
                JSONArray jSONArray = new JSONObject(this.zzm).getJSONArray("matches");
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        arrayList.add(new SafeBrowsingThreat(Integer.parseInt(jSONArray.getJSONObject(i).getString("threat_type"))));
                    } catch (NumberFormatException | JSONException unused) {
                    }
                }
            } catch (JSONException unused2) {
            }
            return arrayList;
        }

        public final long getLastUpdateTimeMs() {
            return this.zzp;
        }

        public final String getMetadata() {
            return this.zzm;
        }

        public final byte[] getState() {
            return this.zzq;
        }

        public final Status getStatus() {
            return this.zzad;
        }
    }

    public static class zzj implements com.google.android.gms.safetynet.SafetyNetApi.zzc {
        public Status zzad;
        public boolean zzao;

        public zzj() {
        }

        public zzj(Status status, boolean z) {
            this.zzad = status;
            this.zzao = z;
        }

        public final Status getStatus() {
            return this.zzad;
        }

        public final boolean isVerifyAppsEnabled() {
            Status status = this.zzad;
            if (status == null || !status.isSuccess()) {
                return false;
            }
            return this.zzao;
        }
    }

    public static PendingResult<SafeBrowsingResult> zza(GoogleApiClient googleApiClient, String str, int i, String str2, int... iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException("Null threatTypes in lookupUri");
        } else if (!TextUtils.isEmpty(str)) {
            zzn zzn = new zzn(googleApiClient, iArr, i, str, str2);
            return googleApiClient.enqueue(zzn);
        } else {
            throw new IllegalArgumentException("Null or empty uri in lookupUri");
        }
    }

    public static PendingResult<com.google.android.gms.safetynet.SafetyNetApi.zza> zza(GoogleApiClient googleApiClient, byte[] bArr, String str) {
        return googleApiClient.enqueue(new zzl(googleApiClient, bArr, str));
    }

    public PendingResult<com.google.android.gms.safetynet.SafetyNetApi.zza> attest(GoogleApiClient googleApiClient, byte[] bArr) {
        return zza(googleApiClient, bArr, null);
    }

    public PendingResult<com.google.android.gms.safetynet.SafetyNetApi.zzc> enableVerifyApps(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new zzp(this, googleApiClient));
    }

    public PendingResult<com.google.android.gms.safetynet.SafetyNetApi.zzc> isVerifyAppsEnabled(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new zzo(this, googleApiClient));
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0179, code lost:
        r0 = th;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isVerifyAppsEnabled(android.content.Context r22) {
        /*
            r21 = this;
            com.google.android.gms.common.api.GoogleApiClient$Builder r0 = new com.google.android.gms.common.api.GoogleApiClient$Builder
            r1 = r22
            r0.<init>(r1)
            com.google.android.gms.common.api.Api<com.google.android.gms.common.api.Api$ApiOptions$NoOptions> r1 = com.google.android.gms.safetynet.SafetyNet.API
            java.lang.String r2 = "Api must not be null"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r1, r2)
            java.util.Map r2 = r0.zaj
            r3 = 0
            r2.put(r1, r3)
            com.google.android.gms.common.api.Api$AbstractClientBuilder r1 = r1.zaa
            java.lang.String r2 = "Base client builder must not be null"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r1, r2)
            java.util.List r1 = r1.getImpliedScopes(r3)
            java.util.Set r2 = r0.zac
            r2.addAll(r1)
            java.util.Set r2 = r0.zab
            r2.addAll(r1)
            java.util.Map r1 = r0.zaj
            boolean r1 = r1.isEmpty()
            r2 = 1
            r1 = r1 ^ r2
            java.lang.String r4 = "must call addApi() to add at least one API"
            com.google.android.gms.common.internal.Preconditions.checkArgument(r1, r4)
            com.google.android.gms.common.internal.ClientSettings r1 = r0.zaa()
            java.util.Map r4 = r1.zad
            androidx.collection.ArrayMap r12 = new androidx.collection.ArrayMap
            r12.<init>()
            androidx.collection.ArrayMap r15 = new androidx.collection.ArrayMap
            r15.<init>()
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.Map r5 = r0.zaj
            java.util.Set r5 = r5.keySet()
            java.util.Iterator r13 = r5.iterator()
            r19 = 0
            r5 = 0
            r16 = 0
        L_0x005a:
            boolean r5 = r13.hasNext()
            if (r5 == 0) goto L_0x00ce
            java.lang.Object r5 = r13.next()
            r11 = r5
            com.google.android.gms.common.api.Api r11 = (com.google.android.gms.common.api.Api) r11
            java.util.Map r5 = r0.zaj
            java.lang.Object r17 = r5.get(r11)
            java.lang.Object r5 = r4.get(r11)
            if (r5 == 0) goto L_0x0075
            r5 = 1
            goto L_0x0076
        L_0x0075:
            r5 = 0
        L_0x0076:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r5)
            r12.put(r11, r6)
            com.google.android.gms.common.api.internal.zat r10 = new com.google.android.gms.common.api.internal.zat
            r10.<init>(r11, r5)
            r14.add(r10)
            com.google.android.gms.common.api.Api$AbstractClientBuilder r9 = r11.zaa
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)
            android.content.Context r6 = r0.zai
            android.os.Looper r7 = r0.zan
            r5 = r9
            r8 = r1
            r18 = r9
            r9 = r17
            r20 = r10
            r2 = r11
            r11 = r20
            com.google.android.gms.common.api.Api$Client r5 = r5.buildClient(r6, r7, r8, r9, r10, r11)
            com.google.android.gms.common.api.Api$ClientKey r6 = r2.zab
            r15.put(r6, r5)
            int r6 = r18.getPriority()
            r7 = 1
            if (r6 != r7) goto L_0x00b2
            if (r17 == 0) goto L_0x00af
            r6 = 1
            r16 = 1
            goto L_0x00b2
        L_0x00af:
            r6 = 0
            r16 = 0
        L_0x00b2:
            boolean r5 = r5.providesSignIn()
            if (r5 == 0) goto L_0x00cc
            if (r3 != 0) goto L_0x00bc
            r3 = r2
            goto L_0x00cc
        L_0x00bc:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = r2.zac
            java.lang.String r2 = r3.zac
            java.lang.String r3 = " cannot be used with "
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r1, r3, r2)
            r0.<init>(r1)
            throw r0
        L_0x00cc:
            r2 = 1
            goto L_0x005a
        L_0x00ce:
            if (r3 == 0) goto L_0x0102
            if (r16 != 0) goto L_0x00f2
            r2 = 1
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.lang.String r5 = r3.zac
            r4[r19] = r5
            java.lang.String r5 = "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead"
            com.google.android.gms.common.internal.Preconditions.checkState(r2, r5, r4)
            java.util.Set r4 = r0.zab
            java.util.Set r5 = r0.zac
            boolean r4 = r4.equals(r5)
            java.lang.Object[] r5 = new java.lang.Object[r2]
            java.lang.String r2 = r3.zac
            r5[r19] = r2
            java.lang.String r2 = "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead."
            com.google.android.gms.common.internal.Preconditions.checkState(r4, r2, r5)
            goto L_0x0102
        L_0x00f2:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = r3.zac
            java.lang.String r2 = "With using "
            java.lang.String r3 = ", GamesOptions can only be specified within GoogleSignInOptions.Builder"
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r2, r1, r3)
            r0.<init>(r1)
            throw r0
        L_0x0102:
            java.util.Collection r2 = r15.values()
            r3 = 1
            int r17 = com.google.android.gms.common.api.internal.zabe.zad(r2, r3)
            com.google.android.gms.common.api.internal.zabe r2 = new com.google.android.gms.common.api.internal.zabe
            android.content.Context r6 = r0.zai
            java.util.concurrent.locks.ReentrantLock r7 = new java.util.concurrent.locks.ReentrantLock
            r7.<init>()
            android.os.Looper r8 = r0.zan
            com.google.android.gms.common.GoogleApiAvailability r10 = r0.zao
            com.google.android.gms.common.api.Api$AbstractClientBuilder r11 = r0.zap
            java.util.ArrayList r13 = r0.zaq
            java.util.ArrayList r4 = r0.zar
            int r9 = r0.zal
            r5 = r2
            r16 = r9
            r9 = r1
            r1 = r14
            r14 = r4
            r18 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            java.util.Set r1 = com.google.android.gms.common.api.GoogleApiClient.zaa
            monitor-enter(r1)
            java.util.Set r4 = com.google.android.gms.common.api.GoogleApiClient.zaa     // Catch:{ all -> 0x0174 }
            r4.add(r2)     // Catch:{ all -> 0x0174 }
            monitor-exit(r1)     // Catch:{ all -> 0x0174 }
            int r0 = r0.zal
            if (r0 >= 0) goto L_0x0170
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x0169 }
            r4 = 3
            com.google.android.gms.common.ConnectionResult r0 = r2.blockingConnect(r4, r0)     // Catch:{ all -> 0x0169 }
            boolean r0 = r0.isSuccess()     // Catch:{ all -> 0x0169 }
            r6 = r21
            if (r0 == 0) goto L_0x0165
            com.google.android.gms.common.api.PendingResult r0 = r6.isVerifyAppsEnabled(r2)     // Catch:{ all -> 0x0163 }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x0163 }
            com.google.android.gms.common.api.Result r0 = r0.await(r4, r1)     // Catch:{ all -> 0x0163 }
            com.google.android.gms.safetynet.SafetyNetApi$zzc r0 = (com.google.android.gms.safetynet.SafetyNetApi.zzc) r0     // Catch:{ all -> 0x0163 }
            if (r0 == 0) goto L_0x015e
            boolean r0 = r0.isVerifyAppsEnabled()     // Catch:{ all -> 0x0163 }
            if (r0 == 0) goto L_0x015e
            r0 = 1
            goto L_0x015f
        L_0x015e:
            r0 = 0
        L_0x015f:
            r2.disconnect()
            return r0
        L_0x0163:
            r0 = move-exception
            goto L_0x016c
        L_0x0165:
            r2.disconnect()
            return r19
        L_0x0169:
            r0 = move-exception
            r6 = r21
        L_0x016c:
            r2.disconnect()
            throw r0
        L_0x0170:
            r6 = r21
            r0 = 0
            throw r0
        L_0x0174:
            r0 = move-exception
            r6 = r21
        L_0x0177:
            monitor-exit(r1)     // Catch:{ all -> 0x0179 }
            throw r0
        L_0x0179:
            r0 = move-exception
            goto L_0x0177
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.safetynet.zzk.isVerifyAppsEnabled(android.content.Context):boolean");
    }

    public PendingResult<com.google.android.gms.safetynet.SafetyNetApi.zzb> listHarmfulApps(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new zzq(this, googleApiClient));
    }

    public PendingResult<SafeBrowsingResult> lookupUri(GoogleApiClient googleApiClient, String str, String str2, int... iArr) {
        return zza(googleApiClient, str, 1, str2, iArr);
    }

    public PendingResult<SafeBrowsingResult> lookupUri(GoogleApiClient googleApiClient, List<Integer> list, String str) {
        if (list == null) {
            throw new IllegalArgumentException("Null threatTypes in lookupUri");
        } else if (!TextUtils.isEmpty(str)) {
            zzm zzm = new zzm(this, googleApiClient, list, str, null);
            return googleApiClient.enqueue(zzm);
        } else {
            throw new IllegalArgumentException("Null or empty uri in lookupUri");
        }
    }

    public PendingResult<RecaptchaTokenResult> verifyWithRecaptcha(GoogleApiClient googleApiClient, String str) {
        if (!TextUtils.isEmpty(str)) {
            return googleApiClient.enqueue(new zzr(this, googleApiClient, str));
        }
        throw new IllegalArgumentException("Null or empty site key in verifyWithRecaptcha");
    }
}
