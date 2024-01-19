package com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.services;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.domain.feature.SendUnityCrashFeature;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B-\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0011\u0010\u0011\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/local/services/UnityCrashSyncService;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "parameters", "Landroidx/work/WorkerParameters;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "features", "Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/domain/feature/SendUnityCrashFeature;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/domain/feature/SendUnityCrashFeature;)V", "getContext", "()Landroid/content/Context;", "getFeatures", "()Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/domain/feature/SendUnityCrashFeature;", "getIoDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnityCrashSyncService.kt */
public final class UnityCrashSyncService extends CoroutineWorker {
    public static final String CRASH_SERVICE_NAME = "UnityCrashSyncService";
    public static final Companion Companion = new Companion(null);
    public final Context context;
    public final SendUnityCrashFeature features;
    public final CoroutineDispatcher ioDispatcher;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/local/services/UnityCrashSyncService$Companion;", "", "()V", "CRASH_SERVICE_NAME", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UnityCrashSyncService.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public UnityCrashSyncService(Context context2, WorkerParameters workerParameters, @IoDispatcher CoroutineDispatcher coroutineDispatcher, SendUnityCrashFeature sendUnityCrashFeature) {
        // Intrinsics.checkNotNullParameter(context2, "context");
        // Intrinsics.checkNotNullParameter(workerParameters, BreadcrumbAnalyticsEventReceiver.BREADCRUMB_PARAMS_KEY);
        // Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        // Intrinsics.checkNotNullParameter(sendUnityCrashFeature, SettingsJsonConstants.FEATURES_KEY);
        super(context2, workerParameters);
        this.context = context2;
        this.ioDispatcher = coroutineDispatcher;
        this.features = sendUnityCrashFeature;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object doWork(kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.services.UnityCrashSyncService$doWork$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.services.UnityCrashSyncService$doWork$1 r0 = (com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.services.UnityCrashSyncService$doWork$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.services.UnityCrashSyncService$doWork$1 r0 = new com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.services.UnityCrashSyncService$doWork$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x002f
            if (r2 != r3) goto L_0x0027
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r6)
            goto L_0x0045
        L_0x0027:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x002f:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r6)
            kotlinx.coroutines.CoroutineDispatcher r6 = r5.getIoDispatcher()
            com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.services.UnityCrashSyncService$doWork$2 r2 = new com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.services.UnityCrashSyncService$doWork$2
            r4 = 0
            r2.<init>(r5, r4)
            r0.label = r3
            java.lang.Object r6 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.withContext(r6, r2, r0)
            if (r6 != r1) goto L_0x0045
            return r1
        L_0x0045:
            java.lang.String r0 = "override suspend fun doW…failure()\n        }\n    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.services.UnityCrashSyncService.doWork(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Context getContext() {
        return this.context;
    }

    public final SendUnityCrashFeature getFeatures() {
        return this.features;
    }

    public final CoroutineDispatcher getIoDispatcher() {
        return this.ioDispatcher;
    }
}
