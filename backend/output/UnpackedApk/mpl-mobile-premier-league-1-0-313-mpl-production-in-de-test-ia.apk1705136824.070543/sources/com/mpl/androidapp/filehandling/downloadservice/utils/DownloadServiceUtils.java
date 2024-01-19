package com.mpl.androidapp.filehandling.downloadservice.utils;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.database.Cursor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ$\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\r¨\u0006\u0011"}, d2 = {"Lcom/mpl/androidapp/filehandling/downloadservice/utils/DownloadServiceUtils;", "", "()V", "prepCursor", "Landroid/database/Cursor;", "downloadManager", "Landroid/app/DownloadManager;", "query", "Landroid/app/DownloadManager$Query;", "prepQuery", "downloadId", "", "urlConstruction", "", "baseUrl", "path", "fileName", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"Range"})
/* compiled from: DownloadServiceUtils.kt */
public final class DownloadServiceUtils {
    public static final DownloadServiceUtils INSTANCE = new DownloadServiceUtils();

    public final Cursor prepCursor(DownloadManager downloadManager, Query query) {
        Intrinsics.checkNotNullParameter(downloadManager, "downloadManager");
        Intrinsics.checkNotNullParameter(query, "query");
        Cursor query2 = downloadManager.query(query);
        query2.moveToFirst();
        return query2;
    }

    public final Query prepQuery(long j) {
        Query filterByStatus = new Query().setFilterById(new long[]{j}).setFilterByStatus(31);
        Intrinsics.checkNotNullExpressionValue(filterByStatus, "Query()\n        .setFilt…ATUS_SUCCESSFUL\n        )");
        return filterByStatus;
    }

    public final String urlConstruction(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            throw new IllegalArgumentException("Parameters contain null value:-> BASE-URL:->" + str + " \n PATH:->" + str2 + " \n FILE-NAME:->" + str3);
        }
        return str + str2 + str3;
    }
}
