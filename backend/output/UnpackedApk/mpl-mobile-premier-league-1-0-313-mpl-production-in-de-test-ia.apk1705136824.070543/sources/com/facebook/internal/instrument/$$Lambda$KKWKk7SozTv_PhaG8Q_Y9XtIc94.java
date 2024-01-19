package com.facebook.internal.instrument;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.facebook.internal.instrument.-$$Lambda$KKWKk7SozTv_PhaG8Q_Y9XtIc94  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$KKWKk7SozTv_PhaG8Q_Y9XtIc94 implements FilenameFilter {
    public static final /* synthetic */ $$Lambda$KKWKk7SozTv_PhaG8Q_Y9XtIc94 INSTANCE = new $$Lambda$KKWKk7SozTv_PhaG8Q_Y9XtIc94();

    private /* synthetic */ $$Lambda$KKWKk7SozTv_PhaG8Q_Y9XtIc94() {
    }

    public final boolean accept(File file, String str) {
        return InstrumentUtility.m217listExceptionAnalysisReportFiles$lambda2(file, str);
    }
}
