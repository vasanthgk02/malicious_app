package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AnyClient;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public class RegistrationMethods<A extends AnyClient, L> {
    @KeepForSdk
    public final RegisterListenerMethod<A, L> register;
    public final UnregisterListenerMethod zaa;
    public final Runnable zab;

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    public static class Builder<A extends AnyClient, L> {
        public RemoteCall zaa;
        public RemoteCall zab;
        public Runnable zac = zacj.zaa;
        public ListenerHolder zad;
        public boolean zaf = true;
        public int zag;

        public Builder() {
        }

        public /* synthetic */ Builder(zacm zacm) {
        }
    }

    public /* synthetic */ RegistrationMethods(RegisterListenerMethod registerListenerMethod, UnregisterListenerMethod unregisterListenerMethod, Runnable runnable) {
        this.register = registerListenerMethod;
        this.zaa = unregisterListenerMethod;
        this.zab = runnable;
    }
}
