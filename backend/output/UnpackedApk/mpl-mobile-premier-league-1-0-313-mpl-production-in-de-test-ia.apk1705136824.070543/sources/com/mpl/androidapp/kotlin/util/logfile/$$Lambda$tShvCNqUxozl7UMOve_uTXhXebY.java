package com.mpl.androidapp.kotlin.util.logfile;

import java.io.File;
import java.util.Comparator;

/* renamed from: com.mpl.androidapp.kotlin.util.logfile.-$$Lambda$tShvCNqUxozl7UMOve_uTXhXebY  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$tShvCNqUxozl7UMOve_uTXhXebY implements Comparator {
    public static final /* synthetic */ $$Lambda$tShvCNqUxozl7UMOve_uTXhXebY INSTANCE = new $$Lambda$tShvCNqUxozl7UMOve_uTXhXebY();

    private /* synthetic */ $$Lambda$tShvCNqUxozl7UMOve_uTXhXebY() {
    }

    public final int compare(Object obj, Object obj2) {
        return DeleteLogFile.m12deleteFiles$lambda1$lambda0((File) obj, (File) obj2);
    }
}
