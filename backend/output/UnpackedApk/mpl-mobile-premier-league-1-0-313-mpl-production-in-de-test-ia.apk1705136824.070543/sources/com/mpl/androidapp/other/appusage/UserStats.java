package com.mpl.androidapp.other.appusage;

import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import com.mpl.androidapp.other.appusage.model.Usage;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.Util;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/mpl/androidapp/other/appusage/UserStats;", "", "()V", "TAG", "", "dateFormat", "Ljava/text/SimpleDateFormat;", "getUsageStats", "", "Lcom/mpl/androidapp/other/appusage/model/Usage;", "context", "Landroid/content/Context;", "userId", "getUsageStatsManager", "Landroid/app/usage/UsageStatsManager;", "isPermissionGranted", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserStats.kt */
public final class UserStats {
    public static final UserStats INSTANCE = new UserStats();
    public static final String TAG = "usageStats";
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("d-M-yyyy HH:mm:ss");

    public static final List<Usage> getUsageStats(Context context, String str) {
        String str2;
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(str, "userId");
        MLogger.d("usageStats", "getUsageStats() init: ");
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        UsageStatsManager usageStatsManager = INSTANCE.getUsageStatsManager(context2);
        Calendar instance = Calendar.getInstance();
        long timeInMillis = instance.getTimeInMillis();
        instance.add(5, -1);
        long timeInMillis2 = instance.getTimeInMillis();
        MLogger.d("usageStats", Intrinsics.stringPlus("Range start(Day): ", dateFormat.format(Long.valueOf(timeInMillis2))));
        MLogger.d("usageStats", Intrinsics.stringPlus("Range end(Day): ", dateFormat.format(Long.valueOf(timeInMillis))));
        Map<String, UsageStats> queryAndAggregateUsageStats = usageStatsManager.queryAndAggregateUsageStats(timeInMillis2, timeInMillis);
        Intrinsics.checkNotNullExpressionValue(queryAndAggregateUsageStats, "mapLastDay");
        Iterator<Entry<String, UsageStats>> it = queryAndAggregateUsageStats.entrySet().iterator();
        while (true) {
            str2 = "key";
            if (!it.hasNext()) {
                break;
            }
            Entry next = it.next();
            String str3 = (String) next.getKey();
            Intrinsics.checkNotNullExpressionValue(str3, str2);
            String convertToTime = Util.convertToTime(Long.valueOf(((UsageStats) next.getValue()).getTotalTimeInForeground()));
            Intrinsics.checkNotNullExpressionValue(convertToTime, "convertToTime(value.totalTimeInForeground)");
            hashMap.put(str3, convertToTime);
        }
        Calendar instance2 = Calendar.getInstance();
        instance2.add(4, -1);
        long timeInMillis3 = instance2.getTimeInMillis();
        MLogger.d("usageStats", Intrinsics.stringPlus("Range start(7 Days): ", dateFormat.format(Long.valueOf(timeInMillis3))));
        MLogger.d("usageStats", Intrinsics.stringPlus("Range end(7 Days): ", dateFormat.format(Long.valueOf(timeInMillis))));
        Map<String, UsageStats> queryAndAggregateUsageStats2 = usageStatsManager.queryAndAggregateUsageStats(timeInMillis3, timeInMillis);
        Intrinsics.checkNotNullExpressionValue(queryAndAggregateUsageStats2, "mapLastWeek");
        for (Entry next2 : queryAndAggregateUsageStats2.entrySet()) {
            String str4 = (String) next2.getKey();
            Intrinsics.checkNotNullExpressionValue(str4, str2);
            String convertToTime2 = Util.convertToTime(Long.valueOf(((UsageStats) next2.getValue()).getTotalTimeInForeground()));
            Intrinsics.checkNotNullExpressionValue(convertToTime2, "convertToTime(value.totalTimeInForeground)");
            hashMap2.put(str4, convertToTime2);
        }
        Calendar instance3 = Calendar.getInstance();
        instance3.add(2, -1);
        long timeInMillis4 = instance3.getTimeInMillis();
        MLogger.d("usageStats", Intrinsics.stringPlus("Range start(30 Days): ", dateFormat.format(Long.valueOf(timeInMillis4))));
        MLogger.d("usageStats", Intrinsics.stringPlus("Range end(30 Days): ", dateFormat.format(Long.valueOf(timeInMillis))));
        Map<String, UsageStats> queryAndAggregateUsageStats3 = usageStatsManager.queryAndAggregateUsageStats(timeInMillis4, timeInMillis);
        Intrinsics.checkNotNullExpressionValue(queryAndAggregateUsageStats3, "mapLastMonth");
        for (Entry next3 : queryAndAggregateUsageStats3.entrySet()) {
            String str5 = (String) next3.getKey();
            String format = dateFormat.format(Long.valueOf(timeInMillis4));
            Intrinsics.checkNotNullExpressionValue(format, "dateFormat.format(startTime)");
            Intrinsics.checkNotNullExpressionValue(str5, str2);
            String valueOf = String.valueOf(hashMap.get(str5));
            String valueOf2 = String.valueOf(hashMap2.get(str5));
            String convertToTime3 = Util.convertToTime(Long.valueOf(((UsageStats) next3.getValue()).getTotalTimeInForeground()));
            Intrinsics.checkNotNullExpressionValue(convertToTime3, "convertToTime(value.totalTimeInForeground)");
            Usage usage = r2;
            Usage usage2 = new Usage(str, format, str5, valueOf, valueOf2, convertToTime3);
            arrayList.add(usage);
            str2 = str2;
            timeInMillis4 = timeInMillis4;
        }
        MLogger.d("usageStats", Intrinsics.stringPlus("Usage List size: ", arrayList));
        return arrayList;
    }

    private final UsageStatsManager getUsageStatsManager(Context context) {
        Object systemService = context.getSystemService("usagestats");
        if (systemService != null) {
            return (UsageStatsManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.usage.UsageStatsManager");
    }

    public static final boolean isPermissionGranted(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        UsageStatsManager usageStatsManager = INSTANCE.getUsageStatsManager(context);
        Calendar instance = Calendar.getInstance();
        long timeInMillis = instance.getTimeInMillis();
        instance.add(1, -1);
        List<UsageStats> queryUsageStats = usageStatsManager.queryUsageStats(3, instance.getTimeInMillis(), timeInMillis);
        Object[] objArr = new Object[1];
        objArr[0] = Intrinsics.stringPlus("isPermissionGranted: ", Boolean.valueOf((queryUsageStats == null || queryUsageStats.size() == 0) ? false : true));
        MLogger.d("usageStats", objArr);
        if (queryUsageStats == null || queryUsageStats.size() == 0) {
            return false;
        }
        return true;
    }
}
