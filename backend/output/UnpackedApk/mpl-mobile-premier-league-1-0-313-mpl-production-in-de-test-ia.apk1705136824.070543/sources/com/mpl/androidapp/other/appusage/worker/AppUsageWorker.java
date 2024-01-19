package com.mpl.androidapp.other.appusage.worker;

import android.content.Context;
import androidx.work.ListenableWorker.Result;
import androidx.work.ListenableWorker.Result.Success;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.mpl.androidapp.analytics.ExternalAnalytics;
import com.mpl.androidapp.other.appusage.UserStats;
import com.mpl.androidapp.other.appusage.model.Usage;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.razorpay.AnalyticsConstants;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/mpl/androidapp/other/appusage/worker/AppUsageWorker;", "Landroidx/work/Worker;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getAppContext", "()Landroid/content/Context;", "doWork", "Landroidx/work/ListenableWorker$Result;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AppUsageWorker.kt */
public final class AppUsageWorker extends Worker {
    public final String TAG = "usageStats";
    public final Context appContext;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public AppUsageWorker(Context context, WorkerParameters workerParameters) {
        // Intrinsics.checkNotNullParameter(context, "appContext");
        // Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
        super(context, workerParameters);
        this.appContext = context;
    }

    public Result doWork() {
        Context context = this.appContext;
        List<Usage> usageStats = UserStats.getUsageStats(context, String.valueOf(MSharedPreferencesUtils.getUserIdInNormalPref(context)));
        try {
            MLogger.d(this.TAG, "sendKafkaEvent(): ", AnalyticsConstants.INIT);
            for (Usage next : usageStats) {
                HashMap hashMap = new HashMap();
                hashMap.putAll(CleverTapAnalyticsUtils.commonPropertiesForEvents(false));
                hashMap.put("Package Name", next.getPackageName());
                hashMap.put("Last Day Usage", next.getLastDayUsage());
                hashMap.put("Last 7 Days Usage", next.getLast7DaysUsage());
                hashMap.put("Last 30 Days Usage", next.getLast30DaysUsage());
                ExternalAnalytics.INSTANCE.sendKafkaEvent("competitor_app_usage", hashMap);
            }
            MLogger.d(this.TAG, "sendKafkaEvent(): ", "Done");
        } catch (Exception e2) {
            MLogger.e(this.TAG, "sendKafkaEvent(): ", e2.getMessage());
        }
        Success success = new Success();
        Intrinsics.checkNotNullExpressionValue(success, "success()");
        return success;
    }

    public final Context getAppContext() {
        return this.appContext;
    }

    public final String getTAG() {
        return this.TAG;
    }
}
