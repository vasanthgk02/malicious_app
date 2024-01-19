package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public abstract class GmsClient<T extends IInterface> extends BaseGmsClient<T> implements Client, zaj {
    public static volatile Executor zaa;
    public final ClientSettings zab;
    public final Set zac;
    public final Account zad;

    @KeepForSdk
    @VisibleForTesting
    public GmsClient(Context context, Handler handler, int i, ClientSettings clientSettings) {
        super(context, handler, GmsClientSupervisor.getInstance(context), GoogleApiAvailability.zab, i, null, null);
        Preconditions.checkNotNull(clientSettings);
        this.zab = clientSettings;
        this.zad = clientSettings.zaa;
        this.zac = zaa(clientSettings.zac);
    }

    private final Set zaa(Set set) {
        Set<Scope> validateScopes = validateScopes(set);
        for (Scope contains : validateScopes) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return validateScopes;
    }

    public final Account getAccount() {
        return this.zad;
    }

    public final Executor getBindServiceExecutor() {
        return null;
    }

    @KeepForSdk
    public final ClientSettings getClientSettings() {
        return this.zab;
    }

    @KeepForSdk
    public Feature[] getRequiredFeatures() {
        return new Feature[0];
    }

    @KeepForSdk
    public final Set<Scope> getScopes() {
        return this.zac;
    }

    @KeepForSdk
    public Set<Scope> getScopesForConnectionlessNonSignIn() {
        return requiresSignIn() ? this.zac : Collections.emptySet();
    }

    @KeepForSdk
    public Set<Scope> validateScopes(Set<Scope> set) {
        return set;
    }

    @KeepForSdk
    public GmsClient(Context context, Looper looper, int i, ClientSettings clientSettings) {
        this(context, looper, GmsClientSupervisor.getInstance(context), GoogleApiAvailability.zab, i, clientSettings, null, null);
    }

    @KeepForSdk
    @Deprecated
    public GmsClient(Context context, Looper looper, int i, ClientSettings clientSettings, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, i, clientSettings, (com.google.android.gms.common.api.internal.ConnectionCallbacks) connectionCallbacks, (com.google.android.gms.common.api.internal.OnConnectionFailedListener) onConnectionFailedListener);
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GmsClient(android.content.Context r10, android.os.Looper r11, int r12, com.google.android.gms.common.internal.ClientSettings r13, com.google.android.gms.common.api.internal.ConnectionCallbacks r14, com.google.android.gms.common.api.internal.OnConnectionFailedListener r15) {
        /*
            r9 = this;
            com.google.android.gms.common.internal.GmsClientSupervisor r3 = com.google.android.gms.common.internal.GmsClientSupervisor.getInstance(r10)
            com.google.android.gms.common.GoogleApiAvailability r4 = com.google.android.gms.common.GoogleApiAvailability.zab
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)
            r7 = r14
            com.google.android.gms.common.api.internal.ConnectionCallbacks r7 = (com.google.android.gms.common.api.internal.ConnectionCallbacks) r7
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r15)
            r8 = r15
            com.google.android.gms.common.api.internal.OnConnectionFailedListener r8 = (com.google.android.gms.common.api.internal.OnConnectionFailedListener) r8
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.GmsClient.<init>(android.content.Context, android.os.Looper, int, com.google.android.gms.common.internal.ClientSettings, com.google.android.gms.common.api.internal.ConnectionCallbacks, com.google.android.gms.common.api.internal.OnConnectionFailedListener):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GmsClient(android.content.Context r12, android.os.Looper r13, com.google.android.gms.common.internal.GmsClientSupervisor r14, com.google.android.gms.common.GoogleApiAvailability r15, int r16, com.google.android.gms.common.internal.ClientSettings r17, com.google.android.gms.common.api.internal.ConnectionCallbacks r18, com.google.android.gms.common.api.internal.OnConnectionFailedListener r19) {
        /*
            r11 = this;
            r9 = r11
            r10 = r17
            r0 = r18
            r1 = r19
            r2 = 0
            if (r0 != 0) goto L_0x000c
            r6 = r2
            goto L_0x0012
        L_0x000c:
            com.google.android.gms.common.internal.zah r3 = new com.google.android.gms.common.internal.zah
            r3.<init>(r0)
            r6 = r3
        L_0x0012:
            if (r1 != 0) goto L_0x0016
            r7 = r2
            goto L_0x001c
        L_0x0016:
            com.google.android.gms.common.internal.zai r0 = new com.google.android.gms.common.internal.zai
            r0.<init>(r1)
            r7 = r0
        L_0x001c:
            java.lang.String r8 = r10.zah
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r9.zab = r10
            android.accounts.Account r0 = r10.zaa
            r9.zad = r0
            java.util.Set r0 = r10.zac
            java.util.Set r0 = r11.zaa(r0)
            r9.zac = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.GmsClient.<init>(android.content.Context, android.os.Looper, com.google.android.gms.common.internal.GmsClientSupervisor, com.google.android.gms.common.GoogleApiAvailability, int, com.google.android.gms.common.internal.ClientSettings, com.google.android.gms.common.api.internal.ConnectionCallbacks, com.google.android.gms.common.api.internal.OnConnectionFailedListener):void");
    }
}
