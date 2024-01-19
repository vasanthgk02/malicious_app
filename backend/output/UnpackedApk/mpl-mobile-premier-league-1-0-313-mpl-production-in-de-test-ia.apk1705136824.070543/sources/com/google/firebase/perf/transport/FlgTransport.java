package com.google.firebase.perf.transport;

import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.inject.Provider;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.v1.PerfMetric;

public final class FlgTransport {
    public static final AndroidLogger logger = AndroidLogger.getInstance();
    public Transport<PerfMetric> flgTransport;
    public final Provider<TransportFactory> flgTransportFactoryProvider;
    public final String logSourceName;

    public FlgTransport(Provider<TransportFactory> provider, String str) {
        this.logSourceName = str;
        this.flgTransportFactoryProvider = provider;
    }
}
