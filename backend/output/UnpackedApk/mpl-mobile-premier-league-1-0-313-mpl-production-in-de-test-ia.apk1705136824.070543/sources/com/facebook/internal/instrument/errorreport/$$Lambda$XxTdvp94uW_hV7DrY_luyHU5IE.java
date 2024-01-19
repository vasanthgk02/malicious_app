package com.facebook.internal.instrument.errorreport;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.facebook.internal.instrument.errorreport.-$$Lambda$-XxTdvp94uW_hV7DrY_luyHU5IE  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$XxTdvp94uW_hV7DrY_luyHU5IE implements FilenameFilter {
    public static final /* synthetic */ $$Lambda$XxTdvp94uW_hV7DrY_luyHU5IE INSTANCE = new $$Lambda$XxTdvp94uW_hV7DrY_luyHU5IE();

    private /* synthetic */ $$Lambda$XxTdvp94uW_hV7DrY_luyHU5IE() {
    }

    public final boolean accept(File file, String str) {
        return ErrorReportHandler.m224listErrorReportFiles$lambda3(file, str);
    }
}
