package com.mpl.androidapp.updater.downloadmanager.downloadModules;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.OneTimeWorkRequest.Builder;
import androidx.work.WorkManager;
import androidx.work.impl.WorkManagerImpl;
import com.google.gson.Gson;
import com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/downloadModules/DownloadProgressAssets;", "Lcom/mpl/androidapp/updater/downloadmanager/downloadModules/DownloadProgress;", "context", "Landroid/content/Context;", "gson", "Lcom/google/gson/Gson;", "(Landroid/content/Context;Lcom/google/gson/Gson;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getGson", "()Lcom/google/gson/Gson;", "setGson", "(Lcom/google/gson/Gson;)V", "workManager", "Landroidx/work/WorkManager;", "serializeDownloadParams", "", "downloadTaskParams", "Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;", "startProgress", "", "isWebViewFlow", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DownloadAssetsProgress.kt */
public final class DownloadProgressAssets implements DownloadProgress {
    public Context context;
    public Gson gson;
    public final WorkManager workManager;

    public DownloadProgressAssets(Context context2, Gson gson2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(gson2, "gson");
        this.context = context2;
        this.gson = gson2;
        WorkManagerImpl instance = WorkManagerImpl.getInstance(context2);
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(context)");
        this.workManager = instance;
    }

    private final String serializeDownloadParams(DownloadTaskParams downloadTaskParams) {
        String json = this.gson.toJson((Object) downloadTaskParams);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(downloadTaskParams)");
        return json;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Gson getGson() {
        return this.gson;
    }

    public final void setContext(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }

    public final void setGson(Gson gson2) {
        Intrinsics.checkNotNullParameter(gson2, "<set-?>");
        this.gson = gson2;
    }

    public void startProgress(DownloadTaskParams downloadTaskParams, boolean z) {
        Intrinsics.checkNotNullParameter(downloadTaskParams, "downloadTaskParams");
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.WORK_MANAGER_PARAM_GAME_DOWNLOAD_PARAMS, serializeDownloadParams(downloadTaskParams));
        hashMap.put(Constants.IS_WEB_VIEW_FLOW, Boolean.valueOf(z));
        Data data = new Data((Map<String, ?>) hashMap);
        Data.toByteArrayInternal(data);
        Intrinsics.checkNotNullExpressionValue(data, "Builder()\n            .p…low)\n            .build()");
        WorkManager workManager2 = this.workManager;
        ExistingWorkPolicy existingWorkPolicy = ExistingWorkPolicy.REPLACE;
        Builder builder = (Builder) new Builder(DownloadProgressWorker.class).addTag(downloadTaskParams.getFileName());
        builder.mWorkSpec.input = data;
        Constraints.Builder builder2 = new Constraints.Builder();
        builder2.mRequiredNetworkType = NetworkType.CONNECTED;
        builder.mWorkSpec.constraints = new Constraints(builder2);
        workManager2.beginUniqueWork(Constants.DownloadWorkerName, existingWorkPolicy, (OneTimeWorkRequest) builder.build()).enqueue();
    }
}
