package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.zada;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

@Deprecated
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public abstract class GoogleApiClient {
    public static final Set zaa = Collections.newSetFromMap(new WeakHashMap());

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    public static final class Builder {
        public final Set zab = new HashSet();
        public final Set zac = new HashSet();
        public String zaf;
        public String zag;
        public final Map zah = new ArrayMap();
        public final Context zai;
        public final Map zaj = new ArrayMap();
        public int zal = -1;
        public Looper zan;
        public GoogleApiAvailability zao = GoogleApiAvailability.zab;
        public AbstractClientBuilder zap = zad.zac;
        public final ArrayList zaq = new ArrayList();
        public final ArrayList zar = new ArrayList();

        public Builder(Context context) {
            this.zai = context;
            this.zan = context.getMainLooper();
            this.zaf = context.getPackageName();
            this.zag = context.getClass().getName();
        }

        @VisibleForTesting
        public final ClientSettings zaa() {
            SignInOptions signInOptions = SignInOptions.zaa;
            if (this.zaj.containsKey(zad.zag)) {
                signInOptions = (SignInOptions) this.zaj.get(zad.zag);
            }
            ClientSettings clientSettings = new ClientSettings(null, this.zab, this.zah, 0, null, this.zaf, this.zag, signInOptions);
            return clientSettings;
        }
    }

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    public interface ConnectionCallbacks extends com.google.android.gms.common.api.internal.ConnectionCallbacks {
    }

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    public interface OnConnectionFailedListener extends com.google.android.gms.common.api.internal.OnConnectionFailedListener {
    }

    @KeepForSdk
    public static Set<GoogleApiClient> getAllClients() {
        Set<GoogleApiClient> set;
        synchronized (zaa) {
            set = zaa;
        }
        return set;
    }

    public abstract ConnectionResult blockingConnect(long j, TimeUnit timeUnit);

    public abstract void connect();

    public abstract void disconnect();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @KeepForSdk
    public <A extends AnyClient, R extends Result, T extends ApiMethodImpl<R, A>> T enqueue(T t) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T execute(T t) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public <C extends Client> C getClient(AnyClientKey<C> anyClientKey) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public Context getContext() {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public Looper getLooper() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    @KeepForSdk
    public boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public void maybeSignOut() {
        throw new UnsupportedOperationException();
    }

    public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    public void zao(zada zada) {
        throw new UnsupportedOperationException();
    }

    public void zap(zada zada) {
        throw new UnsupportedOperationException();
    }
}
