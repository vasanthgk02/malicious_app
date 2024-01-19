package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser;

/* renamed from: com.google.firebase.crashlytics.internal.model.serialization.-$$Lambda$PcYtebWm8LLEihGxNBWQex7movQ  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$PcYtebWm8LLEihGxNBWQex7movQ implements ObjectParser {
    public static final /* synthetic */ $$Lambda$PcYtebWm8LLEihGxNBWQex7movQ INSTANCE = new $$Lambda$PcYtebWm8LLEihGxNBWQex7movQ();

    private /* synthetic */ $$Lambda$PcYtebWm8LLEihGxNBWQex7movQ() {
    }

    public final Object parse(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.parseFile(jsonReader);
    }
}
