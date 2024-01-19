package com.facebook.appevents.codeless;

import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.appevents.codeless.ViewIndexer.Companion;

/* renamed from: com.facebook.appevents.codeless.-$$Lambda$cEX9Z2yPsmYT9RtCEpi7naJzBYw  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$cEX9Z2yPsmYT9RtCEpi7naJzBYw implements Callback {
    public static final /* synthetic */ $$Lambda$cEX9Z2yPsmYT9RtCEpi7naJzBYw INSTANCE = new $$Lambda$cEX9Z2yPsmYT9RtCEpi7naJzBYw();

    private /* synthetic */ $$Lambda$cEX9Z2yPsmYT9RtCEpi7naJzBYw() {
    }

    public final void onCompleted(GraphResponse graphResponse) {
        Companion.m166buildAppIndexingRequest$lambda0(graphResponse);
    }
}
