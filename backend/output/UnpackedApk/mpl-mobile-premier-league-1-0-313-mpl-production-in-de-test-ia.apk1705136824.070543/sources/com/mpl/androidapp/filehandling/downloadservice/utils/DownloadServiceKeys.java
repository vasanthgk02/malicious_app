package com.mpl.androidapp.filehandling.downloadservice.utils;

import android.os.Environment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/mpl/androidapp/filehandling/downloadservice/utils/DownloadServiceKeys;", "", "()V", "FILE_PATH_INTERNAL", "", "getFILE_PATH_INTERNAL", "()Ljava/lang/String;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DownloadServiceKeys.kt */
public final class DownloadServiceKeys {
    public static final String FILE_PATH_INTERNAL;
    public static final DownloadServiceKeys INSTANCE = new DownloadServiceKeys();

    static {
        String str = Environment.DIRECTORY_DOWNLOADS;
        Intrinsics.checkNotNullExpressionValue(str, "DIRECTORY_DOWNLOADS");
        FILE_PATH_INTERNAL = str;
    }

    public final String getFILE_PATH_INTERNAL() {
        return FILE_PATH_INTERNAL;
    }
}
