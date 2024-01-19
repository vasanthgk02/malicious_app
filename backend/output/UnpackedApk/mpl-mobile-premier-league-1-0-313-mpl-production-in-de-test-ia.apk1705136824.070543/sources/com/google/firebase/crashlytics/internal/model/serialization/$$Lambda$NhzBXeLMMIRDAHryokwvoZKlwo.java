package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser;

/* renamed from: com.google.firebase.crashlytics.internal.model.serialization.-$$Lambda$NhzBXeLMMIRDAHr-yokwvoZKlwo  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$NhzBXeLMMIRDAHryokwvoZKlwo implements ObjectParser {
    public static final /* synthetic */ $$Lambda$NhzBXeLMMIRDAHryokwvoZKlwo INSTANCE = new $$Lambda$NhzBXeLMMIRDAHryokwvoZKlwo();

    private /* synthetic */ $$Lambda$NhzBXeLMMIRDAHryokwvoZKlwo() {
    }

    public final Object parse(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.parseCustomAttribute(jsonReader);
    }
}
