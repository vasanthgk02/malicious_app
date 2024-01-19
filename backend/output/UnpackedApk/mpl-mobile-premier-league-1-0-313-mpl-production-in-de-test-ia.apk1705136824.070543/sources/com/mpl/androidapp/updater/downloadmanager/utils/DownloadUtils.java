package com.mpl.androidapp.updater.downloadmanager.utils;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.NotificationManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.Environment;
import com.mpl.androidapp.R;
import com.mpl.androidapp.notification.NotificationBuilder;
import com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams;
import com.mpl.androidapp.utils.MLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\u000bH\u0002J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a¨\u0006\u001b"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/utils/DownloadUtils;", "", "()V", "getFilePath", "", "context", "Landroid/content/Context;", "fileName", "getNotificationManager", "Landroid/app/NotificationManager;", "isDownloadManagerEqualOrAboveNougat", "", "isNotificationChannelValid", "notificationBuilderUtil", "", "isError", "downloadTaskParams", "Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;", "prepareCursor", "Landroid/database/Cursor;", "downloadManager", "Landroid/app/DownloadManager;", "query", "Landroid/app/DownloadManager$Query;", "prepareQuery", "downloadId", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"Range"})
/* compiled from: DownloadUtils.kt */
public final class DownloadUtils {
    public static final DownloadUtils INSTANCE = new DownloadUtils();

    private final boolean isNotificationChannelValid() {
        return VERSION.SDK_INT >= 26;
    }

    public final String getFilePath(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, Constants.DOWNLOADER_FILE_NAME);
        if (str.length() == 0) {
            return "";
        }
        return context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + '/' + str;
    }

    public final NotificationManager getNotificationManager(Context context) {
        if (!isNotificationChannelValid() || context == null) {
            return null;
        }
        return (NotificationManager) context.getSystemService(NotificationManager.class);
    }

    public final boolean isDownloadManagerEqualOrAboveNougat() {
        return VERSION.SDK_INT >= 24;
    }

    public final void notificationBuilderUtil(boolean z, Context context, DownloadTaskParams downloadTaskParams) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(downloadTaskParams, "downloadTaskParams");
        MLogger.d("DownloadOfAssets", "Notification published to notification channel");
        String gameName = downloadTaskParams.getGameAssets().getGameName();
        int gameId = downloadTaskParams.getGameId();
        int tournamentId = downloadTaskParams.getTournamentId();
        if (z) {
            new NotificationBuilder(context).buildNotification(gameName, context.getString(R.string.asset_download_failed), gameId, tournamentId);
        } else {
            new NotificationBuilder(context).buildNotification(gameName, context.getString(R.string.asset_download_success), gameId, tournamentId);
        }
    }

    public final Cursor prepareCursor(DownloadManager downloadManager, Query query) {
        Intrinsics.checkNotNullParameter(downloadManager, "downloadManager");
        Intrinsics.checkNotNullParameter(query, "query");
        Cursor query2 = downloadManager.query(query);
        query2.moveToFirst();
        return query2;
    }

    public final Query prepareQuery(long j) {
        Query filterByStatus = new Query().setFilterById(new long[]{j}).setFilterByStatus(31);
        Intrinsics.checkNotNullExpressionValue(filterByStatus, "Query()\n        .setFilt…ATUS_SUCCESSFUL\n        )");
        return filterByStatus;
    }
}
