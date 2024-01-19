package com.mpl.androidapp.other.appusage;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.Constraints.Builder;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkManagerImpl;
import com.mpl.androidapp.other.appusage.worker.AppUsageWorker;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/mpl/androidapp/other/appusage/AppUsageWorkRequest;", "", "()V", "scheduleAppUsageDataForServer", "", "context", "Landroid/content/Context;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AppUsageWorkRequest.kt */
public final class AppUsageWorkRequest {
    public static final AppUsageWorkRequest INSTANCE = new AppUsageWorkRequest();

    public final void scheduleAppUsageDataForServer(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Builder builder = new Builder();
        builder.mRequiredNetworkType = NetworkType.CONNECTED;
        Constraints constraints = new Constraints(builder);
        Intrinsics.checkNotNullExpressionValue(constraints, "Builder()\n            .s…TED)\n            .build()");
        PeriodicWorkRequest.Builder builder2 = new PeriodicWorkRequest.Builder(AppUsageWorker.class, 24, TimeUnit.HOURS);
        builder2.mWorkSpec.constraints = constraints;
        WorkRequest build = builder2.build();
        Intrinsics.checkNotNullExpressionValue(build, "PeriodicWorkRequestBuild…nts)\n            .build()");
        WorkManagerImpl.getInstance(context).enqueueUniquePeriodicWork("AppUsageWorkRequest", ExistingPeriodicWorkPolicy.KEEP, (PeriodicWorkRequest) build);
    }
}
