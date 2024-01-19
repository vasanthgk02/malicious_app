package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser;

/* renamed from: com.google.firebase.crashlytics.internal.model.serialization.-$$Lambda$NcslUolmMJ2rhykSKHnzkuM2hYY  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$NcslUolmMJ2rhykSKHnzkuM2hYY implements ObjectParser {
    public static final /* synthetic */ $$Lambda$NcslUolmMJ2rhykSKHnzkuM2hYY INSTANCE = new $$Lambda$NcslUolmMJ2rhykSKHnzkuM2hYY();

    private /* synthetic */ $$Lambda$NcslUolmMJ2rhykSKHnzkuM2hYY() {
    }

    public final Object parse(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.parseEventThread(jsonReader);
    }
}
