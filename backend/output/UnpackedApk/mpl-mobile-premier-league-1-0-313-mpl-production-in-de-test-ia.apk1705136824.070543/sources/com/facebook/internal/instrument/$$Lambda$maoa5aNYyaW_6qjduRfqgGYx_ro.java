package com.facebook.internal.instrument;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.facebook.internal.instrument.-$$Lambda$maoa5aNYyaW_6qjduRfqgGYx_ro  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$maoa5aNYyaW_6qjduRfqgGYx_ro implements FilenameFilter {
    public static final /* synthetic */ $$Lambda$maoa5aNYyaW_6qjduRfqgGYx_ro INSTANCE = new $$Lambda$maoa5aNYyaW_6qjduRfqgGYx_ro();

    private /* synthetic */ $$Lambda$maoa5aNYyaW_6qjduRfqgGYx_ro() {
    }

    public final boolean accept(File file, String str) {
        return InstrumentUtility.m216listAnrReportFiles$lambda1(file, str);
    }
}
