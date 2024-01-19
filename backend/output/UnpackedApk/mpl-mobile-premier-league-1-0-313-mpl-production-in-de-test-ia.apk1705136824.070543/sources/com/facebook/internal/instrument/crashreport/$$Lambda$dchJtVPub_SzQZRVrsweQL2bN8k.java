package com.facebook.internal.instrument.crashreport;

import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.crashreport.CrashHandler.Companion;
import java.util.Comparator;

/* renamed from: com.facebook.internal.instrument.crashreport.-$$Lambda$dchJtVPub_SzQZRVrsweQL2bN8k  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$dchJtVPub_SzQZRVrsweQL2bN8k implements Comparator {
    public static final /* synthetic */ $$Lambda$dchJtVPub_SzQZRVrsweQL2bN8k INSTANCE = new $$Lambda$dchJtVPub_SzQZRVrsweQL2bN8k();

    private /* synthetic */ $$Lambda$dchJtVPub_SzQZRVrsweQL2bN8k() {
    }

    public final int compare(Object obj, Object obj2) {
        return Companion.m222sendExceptionReports$lambda2((InstrumentData) obj, (InstrumentData) obj2);
    }
}
