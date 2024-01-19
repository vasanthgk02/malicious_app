package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser;

/* renamed from: com.google.firebase.crashlytics.internal.model.serialization.-$$Lambda$Ckb34QcYctmy_Q7QdvSnBmK1U98  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$Ckb34QcYctmy_Q7QdvSnBmK1U98 implements ObjectParser {
    public static final /* synthetic */ $$Lambda$Ckb34QcYctmy_Q7QdvSnBmK1U98 INSTANCE = new $$Lambda$Ckb34QcYctmy_Q7QdvSnBmK1U98();

    private /* synthetic */ $$Lambda$Ckb34QcYctmy_Q7QdvSnBmK1U98() {
    }

    public final Object parse(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.parseEvent(jsonReader);
    }
}
