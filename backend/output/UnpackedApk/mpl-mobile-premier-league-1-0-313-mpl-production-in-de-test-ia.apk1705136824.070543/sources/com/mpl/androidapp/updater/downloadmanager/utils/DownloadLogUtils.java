package com.mpl.androidapp.updater.downloadmanager.utils;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.MLogger;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u001d\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\r"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/utils/DownloadLogUtils;", "", "()V", "printDataBytes", "", "bytesDownloaded", "", "totalSize", "printProgressToDisplayedProgressBar", "progress", "internalProgress", "(ILjava/lang/Integer;)V", "printProgressToProgressBar", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DownloadLogUtils.kt */
public final class DownloadLogUtils {
    public static final DownloadLogUtils INSTANCE = new DownloadLogUtils();

    public final void printDataBytes(int i, int i2) {
        MLogger.d("DownloadOfAssets", GeneratedOutlineSupport.outline43("BYTES_DOWNLOADED-", i, "<-AND->TOTAL_SIZE-", i2));
    }

    public final void printProgressToDisplayedProgressBar(int i, Integer num) {
        MLogger.d("DownloadOfAssets", "Publish is invoked for react withprogress: " + i + "-internalProgress: " + num);
    }

    public final void printProgressToProgressBar(int i, int i2) {
        MLogger.d("DownloadOfAssets", GeneratedOutlineSupport.outline43("Publish is invoked for react withbytes downloaded ", i, "-total size ", i2));
    }
}
