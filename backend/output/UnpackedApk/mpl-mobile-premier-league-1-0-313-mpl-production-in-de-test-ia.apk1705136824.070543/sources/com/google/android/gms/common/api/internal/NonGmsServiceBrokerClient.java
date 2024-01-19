package com.google.android.gms.common.api.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Set;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class NonGmsServiceBrokerClient implements Client, ServiceConnection {
    public IBinder zai;
    public boolean zaj;
    public String zak;

    static {
        Class<NonGmsServiceBrokerClient> cls = NonGmsServiceBrokerClient.class;
    }

    public final void connect(ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        Thread.currentThread();
        throw null;
    }

    public final void disconnect() {
        Thread.currentThread();
        throw null;
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public final Feature[] getAvailableFeatures() {
        return new Feature[0];
    }

    public final String getEndpointPackageName() {
        Preconditions.checkNotNull(null);
        throw null;
    }

    public final String getLastDisconnectMessage() {
        return this.zak;
    }

    public final int getMinApkVersion() {
        return 0;
    }

    public final void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set) {
    }

    public final Set<Scope> getScopesForConnectionlessNonSignIn() {
        return Collections.emptySet();
    }

    public final Intent getSignInIntent() {
        return new Intent();
    }

    public final boolean isConnected() {
        Thread.currentThread();
        throw null;
    }

    public final boolean isConnecting() {
        Thread.currentThread();
        throw null;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        throw null;
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        throw null;
    }

    public final void onUserSignOut(SignOutCallbacks signOutCallbacks) {
    }

    public final boolean providesSignIn() {
        return false;
    }

    public final boolean requiresGooglePlayServices() {
        return false;
    }

    public final boolean requiresSignIn() {
        return false;
    }

    public final void disconnect(String str) {
        Thread.currentThread();
        throw null;
    }
}
