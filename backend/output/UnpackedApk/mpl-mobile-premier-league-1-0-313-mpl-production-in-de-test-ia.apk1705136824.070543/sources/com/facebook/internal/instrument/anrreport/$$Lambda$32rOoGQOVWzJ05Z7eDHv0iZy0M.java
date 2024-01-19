package com.facebook.internal.instrument.anrreport;

import com.facebook.internal.instrument.InstrumentData;
import java.util.Comparator;

/* renamed from: com.facebook.internal.instrument.anrreport.-$$Lambda$32rOoGQOVWzJ05Z7-eDHv0iZy0M  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$32rOoGQOVWzJ05Z7eDHv0iZy0M implements Comparator {
    public static final /* synthetic */ $$Lambda$32rOoGQOVWzJ05Z7eDHv0iZy0M INSTANCE = new $$Lambda$32rOoGQOVWzJ05Z7eDHv0iZy0M();

    private /* synthetic */ $$Lambda$32rOoGQOVWzJ05Z7eDHv0iZy0M() {
    }

    public final int compare(Object obj, Object obj2) {
        return ANRHandler.m220sendANRReports$lambda2((InstrumentData) obj, (InstrumentData) obj2);
    }
}
