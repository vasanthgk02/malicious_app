package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser;

/* renamed from: com.google.firebase.crashlytics.internal.model.serialization.-$$Lambda$CDavwmIaUoxPoo5Upyr-1hcsJXE  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$CDavwmIaUoxPoo5Upyr1hcsJXE implements ObjectParser {
    public static final /* synthetic */ $$Lambda$CDavwmIaUoxPoo5Upyr1hcsJXE INSTANCE = new $$Lambda$CDavwmIaUoxPoo5Upyr1hcsJXE();

    private /* synthetic */ $$Lambda$CDavwmIaUoxPoo5Upyr1hcsJXE() {
    }

    public final Object parse(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.parseEventBinaryImage(jsonReader);
    }
}
