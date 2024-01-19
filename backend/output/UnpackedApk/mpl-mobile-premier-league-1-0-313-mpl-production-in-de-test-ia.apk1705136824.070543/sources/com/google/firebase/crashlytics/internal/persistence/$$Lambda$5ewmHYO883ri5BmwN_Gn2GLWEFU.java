package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.google.firebase.crashlytics.internal.persistence.-$$Lambda$5ewmHYO883ri5BmwN_Gn2GLWEFU  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$5ewmHYO883ri5BmwN_Gn2GLWEFU implements FilenameFilter {
    public static final /* synthetic */ $$Lambda$5ewmHYO883ri5BmwN_Gn2GLWEFU INSTANCE = new $$Lambda$5ewmHYO883ri5BmwN_Gn2GLWEFU();

    private /* synthetic */ $$Lambda$5ewmHYO883ri5BmwN_Gn2GLWEFU() {
    }

    public final boolean accept(File file, String str) {
        return CrashlyticsReportPersistence.isNormalPriorityEventFile(file, str);
    }
}
