package com.mpl.androidapp.updater.downloadmanager.downloadModules;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.Data;
import androidx.work.WorkerParameters;
import com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver;
import com.google.gson.Gson;
import com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.MainDispatcher;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B?\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ\u0011\u0010#\u001a\u00020$H@ø\u0001\u0000¢\u0006\u0002\u0010%J\u0011\u0010&\u001a\u00020'H@ø\u0001\u0000¢\u0006\u0002\u0010%J\u0010\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020*H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/downloadModules/DownloadProgressWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "parameters", "Landroidx/work/WorkerParameters;", "gson", "Lcom/google/gson/Gson;", "queryDownload", "Lcom/mpl/androidapp/updater/downloadmanager/downloadModules/QueryDownload;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "mainDispatcher", "(Landroid/content/Context;Landroidx/work/WorkerParameters;Lcom/google/gson/Gson;Lcom/mpl/androidapp/updater/downloadmanager/downloadModules/QueryDownload;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getContext", "()Landroid/content/Context;", "downloadTaskParams", "Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;", "getDownloadTaskParams", "()Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;", "setDownloadTaskParams", "(Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;)V", "getGson", "()Lcom/google/gson/Gson;", "isWebViewFlow", "", "()Z", "setWebViewFlow", "(Z)V", "status", "", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "displayDebugLog", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doWork", "Landroidx/work/ListenableWorker$Result;", "getInputParamsData", "inputData", "Landroidx/work/Data;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DownloadProgressWorker.kt */
public final class DownloadProgressWorker extends CoroutineWorker {
    public final Context context;
    public DownloadTaskParams downloadTaskParams;
    public final Gson gson;
    public final CoroutineDispatcher ioDispatcher;
    public boolean isWebViewFlow;
    public final CoroutineDispatcher mainDispatcher;
    public final QueryDownload queryDownload;
    public String status = "";

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DownloadProgressWorker(Context context2, WorkerParameters workerParameters, Gson gson2, QueryDownload queryDownload2, @IoDispatcher CoroutineDispatcher coroutineDispatcher, @MainDispatcher CoroutineDispatcher coroutineDispatcher2) {
        // Intrinsics.checkNotNullParameter(context2, "context");
        // Intrinsics.checkNotNullParameter(workerParameters, BreadcrumbAnalyticsEventReceiver.BREADCRUMB_PARAMS_KEY);
        // Intrinsics.checkNotNullParameter(gson2, "gson");
        // Intrinsics.checkNotNullParameter(queryDownload2, "queryDownload");
        // Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        // Intrinsics.checkNotNullParameter(coroutineDispatcher2, "mainDispatcher");
        super(context2, workerParameters);
        this.context = context2;
        this.gson = gson2;
        this.queryDownload = queryDownload2;
        this.ioDispatcher = coroutineDispatcher;
        this.mainDispatcher = coroutineDispatcher2;
    }

    /* access modifiers changed from: private */
    public final Object displayDebugLog(Continuation<? super Unit> continuation) {
        if (!MBuildConfigUtils.isLogEnabled()) {
            return Unit.INSTANCE;
        }
        Object withContext = TypeUtilsKt.withContext(this.mainDispatcher, new DownloadProgressWorker$displayDebugLog$2(this, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void getInputParamsData(Data data) {
        Object fromJson = this.gson.fromJson(String.valueOf(data.getString(Constants.WORK_MANAGER_PARAM_GAME_DOWNLOAD_PARAMS)), DownloadTaskParams.class);
        Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(data, Down…adTaskParams::class.java)");
        setDownloadTaskParams((DownloadTaskParams) fromJson);
        Object obj = data.mValues.get(Constants.IS_WEB_VIEW_FLOW);
        this.isWebViewFlow = obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object doWork(kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadProgressWorker$doWork$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadProgressWorker$doWork$1 r0 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadProgressWorker$doWork$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadProgressWorker$doWork$1 r0 = new com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadProgressWorker$doWork$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x002f
            if (r2 != r3) goto L_0x0027
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r6)
            goto L_0x0043
        L_0x0027:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x002f:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r6)
            kotlinx.coroutines.CoroutineDispatcher r6 = r5.ioDispatcher
            com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadProgressWorker$doWork$2 r2 = new com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadProgressWorker$doWork$2
            r4 = 0
            r2.<init>(r5, r4)
            r0.label = r3
            java.lang.Object r6 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.withContext(r6, r2, r0)
            if (r6 != r1) goto L_0x0043
            return r1
        L_0x0043:
            java.lang.String r0 = "override suspend fun doW…t.retry()\n        }\n    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadProgressWorker.doWork(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Context getContext() {
        return this.context;
    }

    public final DownloadTaskParams getDownloadTaskParams() {
        DownloadTaskParams downloadTaskParams2 = this.downloadTaskParams;
        if (downloadTaskParams2 != null) {
            return downloadTaskParams2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("downloadTaskParams");
        throw null;
    }

    public final Gson getGson() {
        return this.gson;
    }

    public final String getStatus() {
        return this.status;
    }

    public final boolean isWebViewFlow() {
        return this.isWebViewFlow;
    }

    public final void setDownloadTaskParams(DownloadTaskParams downloadTaskParams2) {
        Intrinsics.checkNotNullParameter(downloadTaskParams2, "<set-?>");
        this.downloadTaskParams = downloadTaskParams2;
    }

    public final void setStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.status = str;
    }

    public final void setWebViewFlow(boolean z) {
        this.isWebViewFlow = z;
    }
}
