package io.sentry;

import java.net.InetAddress;
import java.util.concurrent.Callable;

/* renamed from: io.sentry.-$$Lambda$HostnameCache$0Rf2wMKlMTm1paSpRhBPXF4RBZk  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$HostnameCache$0Rf2wMKlMTm1paSpRhBPXF4RBZk implements Callable {
    public static final /* synthetic */ $$Lambda$HostnameCache$0Rf2wMKlMTm1paSpRhBPXF4RBZk INSTANCE = new $$Lambda$HostnameCache$0Rf2wMKlMTm1paSpRhBPXF4RBZk();

    private /* synthetic */ $$Lambda$HostnameCache$0Rf2wMKlMTm1paSpRhBPXF4RBZk() {
    }

    public final Object call() {
        return InetAddress.getLocalHost();
    }
}
