package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public class zaag extends GoogleApiClient {
    public final String zaa = "Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.";

    public final ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException(this.zaa);
    }

    public final void connect() {
        throw new UnsupportedOperationException(this.zaa);
    }

    public final void disconnect() {
        throw new UnsupportedOperationException(this.zaa);
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        throw new UnsupportedOperationException(this.zaa);
    }

    public final boolean isConnected() {
        throw new UnsupportedOperationException(this.zaa);
    }

    public final boolean isConnecting() {
        throw new UnsupportedOperationException(this.zaa);
    }

    public final void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.zaa);
    }
}
