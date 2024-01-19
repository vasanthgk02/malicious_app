package com.facebook.internal.instrument;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.facebook.internal.instrument.-$$Lambda$aOD1jvtU6JCTaH0LS4rXzlhizxo  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$aOD1jvtU6JCTaH0LS4rXzlhizxo implements FilenameFilter {
    public static final /* synthetic */ $$Lambda$aOD1jvtU6JCTaH0LS4rXzlhizxo INSTANCE = new $$Lambda$aOD1jvtU6JCTaH0LS4rXzlhizxo();

    private /* synthetic */ $$Lambda$aOD1jvtU6JCTaH0LS4rXzlhizxo() {
    }

    public final boolean accept(File file, String str) {
        return InstrumentUtility.m218listExceptionReportFiles$lambda3(file, str);
    }
}
