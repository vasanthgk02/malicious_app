package com.google.firebase.perf.metrics;

import com.freshchat.consumer.sdk.BuildConfig;
import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import com.google.firebase.perf.application.AppStateUpdateHandler;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.network.NetworkRequestMetricBuilderUtil;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.session.SessionAwareObject;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import com.google.firebase.perf.v1.NetworkRequestMetric.Builder;
import com.google.firebase.perf.v1.NetworkRequestMetric.HttpMethod;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal.ProtobufList;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import okhttp3.HttpUrl;

public final class NetworkRequestMetricBuilder extends AppStateUpdateHandler implements SessionAwareObject {
    public static final AndroidLogger logger = AndroidLogger.getInstance();
    public final Builder builder = ((Builder) NetworkRequestMetric.DEFAULT_INSTANCE.createBuilder());
    public final GaugeManager gaugeManager;
    public boolean isReportSent;
    public final List<PerfSession> sessions;
    public final TransportManager transportManager;
    public String userAgent;
    public final WeakReference<SessionAwareObject> weakReference = new WeakReference<>(this);

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public NetworkRequestMetricBuilder(com.google.firebase.perf.transport.TransportManager r3) {
        /*
            r2 = this;
            com.google.firebase.perf.application.AppStateMonitor r0 = com.google.firebase.perf.application.AppStateMonitor.getInstance()
            com.google.firebase.perf.session.gauges.GaugeManager r1 = com.google.firebase.perf.session.gauges.GaugeManager.getInstance()
            r2.<init>(r0)
            com.google.firebase.perf.v1.NetworkRequestMetric r0 = com.google.firebase.perf.v1.NetworkRequestMetric.DEFAULT_INSTANCE
            com.google.protobuf.GeneratedMessageLite$Builder r0 = r0.createBuilder()
            com.google.firebase.perf.v1.NetworkRequestMetric$Builder r0 = (com.google.firebase.perf.v1.NetworkRequestMetric.Builder) r0
            r2.builder = r0
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r2)
            r2.weakReference = r0
            r2.transportManager = r3
            r2.gaugeManager = r1
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.List r3 = java.util.Collections.synchronizedList(r3)
            r2.sessions = r3
            r2.registerForAppState()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.NetworkRequestMetricBuilder.<init>(com.google.firebase.perf.transport.TransportManager):void");
    }

    public NetworkRequestMetric build() {
        List unmodifiableList;
        SessionManager.getInstance().unregisterForSessionUpdates(this.weakReference);
        unregisterForAppState();
        synchronized (this.sessions) {
            ArrayList arrayList = new ArrayList();
            for (PerfSession next : this.sessions) {
                if (next != null) {
                    arrayList.add(next);
                }
            }
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        com.google.firebase.perf.v1.PerfSession[] buildAndSort = PerfSession.buildAndSort(unmodifiableList);
        if (buildAndSort != null) {
            Builder builder2 = this.builder;
            List asList = Arrays.asList(buildAndSort);
            builder2.copyOnWrite();
            NetworkRequestMetric networkRequestMetric = (NetworkRequestMetric) builder2.instance;
            ProtobufList<com.google.firebase.perf.v1.PerfSession> protobufList = networkRequestMetric.perfSessions_;
            if (!protobufList.isModifiable()) {
                networkRequestMetric.perfSessions_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            AbstractMessageLite.addAll(asList, networkRequestMetric.perfSessions_);
        }
        NetworkRequestMetric networkRequestMetric2 = (NetworkRequestMetric) this.builder.build();
        if (!NetworkRequestMetricBuilderUtil.isAllowedUserAgent(this.userAgent)) {
            logger.debug("Dropping network request from a 'User-Agent' that is not allowed");
            return networkRequestMetric2;
        }
        if (!this.isReportSent) {
            TransportManager transportManager2 = this.transportManager;
            transportManager2.executorService.execute(new Runnable(networkRequestMetric2, getAppState()) {
                public final /* synthetic */ NetworkRequestMetric f$1;
                public final /* synthetic */ ApplicationProcessState f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    TransportManager.this.lambda$log$3$TransportManager(this.f$1, this.f$2);
                }
            });
            this.isReportSent = true;
        }
        return networkRequestMetric2;
    }

    public NetworkRequestMetricBuilder setHttpMethod(String str) {
        HttpMethod httpMethod;
        if (str != null) {
            HttpMethod httpMethod2 = HttpMethod.HTTP_METHOD_UNKNOWN;
            String upperCase = str.toUpperCase();
            char c2 = 65535;
            switch (upperCase.hashCode()) {
                case -531492226:
                    if (upperCase.equals("OPTIONS")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 70454:
                    if (upperCase.equals(HttpGetRequest.METHOD_GET)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 79599:
                    if (upperCase.equals("PUT")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 2213344:
                    if (upperCase.equals(BuildConfig.SCM_BRANCH)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 2461856:
                    if (upperCase.equals(RNCWebViewManager.HTTP_METHOD_POST)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 75900968:
                    if (upperCase.equals("PATCH")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 80083237:
                    if (upperCase.equals("TRACE")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 1669334218:
                    if (upperCase.equals("CONNECT")) {
                        c2 = 8;
                        break;
                    }
                    break;
                case 2012838315:
                    if (upperCase.equals("DELETE")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    httpMethod = HttpMethod.GET;
                    break;
                case 1:
                    httpMethod = HttpMethod.PUT;
                    break;
                case 2:
                    httpMethod = HttpMethod.POST;
                    break;
                case 3:
                    httpMethod = HttpMethod.DELETE;
                    break;
                case 4:
                    httpMethod = HttpMethod.HEAD;
                    break;
                case 5:
                    httpMethod = HttpMethod.PATCH;
                    break;
                case 6:
                    httpMethod = HttpMethod.OPTIONS;
                    break;
                case 7:
                    httpMethod = HttpMethod.TRACE;
                    break;
                case 8:
                    httpMethod = HttpMethod.CONNECT;
                    break;
                default:
                    httpMethod = HttpMethod.HTTP_METHOD_UNKNOWN;
                    break;
            }
            Builder builder2 = this.builder;
            builder2.copyOnWrite();
            NetworkRequestMetric.access$400((NetworkRequestMetric) builder2.instance, httpMethod);
        }
        return this;
    }

    public NetworkRequestMetricBuilder setHttpResponseCode(int i) {
        Builder builder2 = this.builder;
        builder2.copyOnWrite();
        NetworkRequestMetric networkRequestMetric = (NetworkRequestMetric) builder2.instance;
        networkRequestMetric.bitField0_ |= 32;
        networkRequestMetric.httpResponseCode_ = i;
        return this;
    }

    public NetworkRequestMetricBuilder setRequestPayloadBytes(long j) {
        Builder builder2 = this.builder;
        builder2.copyOnWrite();
        NetworkRequestMetric networkRequestMetric = (NetworkRequestMetric) builder2.instance;
        networkRequestMetric.bitField0_ |= 4;
        networkRequestMetric.requestPayloadBytes_ = j;
        return this;
    }

    public NetworkRequestMetricBuilder setRequestStartTimeMicros(long j) {
        PerfSession perfSession = SessionManager.getInstance().perfSession();
        SessionManager.getInstance().registerForSessionUpdates(this.weakReference);
        Builder builder2 = this.builder;
        builder2.copyOnWrite();
        NetworkRequestMetric networkRequestMetric = (NetworkRequestMetric) builder2.instance;
        networkRequestMetric.bitField0_ |= 128;
        networkRequestMetric.clientStartTimeUs_ = j;
        updateSession(perfSession);
        if (perfSession.isGaugeAndEventCollectionEnabled) {
            this.gaugeManager.collectGaugeMetricOnce(perfSession.creationTime);
        }
        return this;
    }

    public NetworkRequestMetricBuilder setResponseContentType(String str) {
        if (str == null) {
            Builder builder2 = this.builder;
            builder2.copyOnWrite();
            NetworkRequestMetric networkRequestMetric = (NetworkRequestMetric) builder2.instance;
            networkRequestMetric.bitField0_ &= -65;
            networkRequestMetric.responseContentType_ = NetworkRequestMetric.DEFAULT_INSTANCE.responseContentType_;
            return this;
        }
        boolean z = false;
        if (str.length() <= 128) {
            int i = 0;
            while (true) {
                if (i >= str.length()) {
                    z = true;
                    break;
                }
                char charAt = str.charAt(i);
                if (charAt <= 31 || charAt > 127) {
                    break;
                }
                i++;
            }
        }
        if (z) {
            Builder builder3 = this.builder;
            builder3.copyOnWrite();
            NetworkRequestMetric.access$1400((NetworkRequestMetric) builder3.instance, str);
        } else {
            logger.warn("The content type of the response is not a valid content-type:" + str);
        }
        return this;
    }

    public NetworkRequestMetricBuilder setResponsePayloadBytes(long j) {
        Builder builder2 = this.builder;
        builder2.copyOnWrite();
        NetworkRequestMetric networkRequestMetric = (NetworkRequestMetric) builder2.instance;
        networkRequestMetric.bitField0_ |= 8;
        networkRequestMetric.responsePayloadBytes_ = j;
        return this;
    }

    public NetworkRequestMetricBuilder setTimeToResponseCompletedMicros(long j) {
        Builder builder2 = this.builder;
        builder2.copyOnWrite();
        NetworkRequestMetric networkRequestMetric = (NetworkRequestMetric) builder2.instance;
        networkRequestMetric.bitField0_ |= 1024;
        networkRequestMetric.timeToResponseCompletedUs_ = j;
        if (SessionManager.getInstance().perfSession().isGaugeAndEventCollectionEnabled) {
            this.gaugeManager.collectGaugeMetricOnce(SessionManager.getInstance().perfSession().creationTime);
        }
        return this;
    }

    public NetworkRequestMetricBuilder setTimeToResponseInitiatedMicros(long j) {
        Builder builder2 = this.builder;
        builder2.copyOnWrite();
        NetworkRequestMetric networkRequestMetric = (NetworkRequestMetric) builder2.instance;
        networkRequestMetric.bitField0_ |= 512;
        networkRequestMetric.timeToResponseInitiatedUs_ = j;
        return this;
    }

    public NetworkRequestMetricBuilder setUrl(String str) {
        if (str != null) {
            HttpUrl parse = HttpUrl.parse(str);
            if (parse != null) {
                str = parse.newBuilder().username("").password("").query(null).fragment(null).toString();
            }
            Builder builder2 = this.builder;
            if (str.length() > 2000) {
                if (str.charAt(2000) == '/') {
                    str = str.substring(0, 2000);
                } else {
                    HttpUrl parse2 = HttpUrl.parse(str);
                    if (parse2 == null) {
                        str = str.substring(0, 2000);
                    } else {
                        if (parse2.encodedPath().lastIndexOf(47) >= 0) {
                            int lastIndexOf = str.lastIndexOf(47, 1999);
                            if (lastIndexOf >= 0) {
                                str = str.substring(0, lastIndexOf);
                            }
                        }
                        str = str.substring(0, 2000);
                    }
                }
            }
            builder2.copyOnWrite();
            NetworkRequestMetric.access$100((NetworkRequestMetric) builder2.instance, str);
        }
        return this;
    }

    public void updateSession(PerfSession perfSession) {
        if (perfSession == null) {
            logger.warn("Unable to add new SessionId to the Network Trace. Continuing without it.");
            return;
        }
        if (((((NetworkRequestMetric) this.builder.instance).bitField0_ & 128) != 0) && !((NetworkRequestMetric) this.builder.instance).hasTimeToResponseCompletedUs()) {
            this.sessions.add(perfSession);
        }
    }
}
