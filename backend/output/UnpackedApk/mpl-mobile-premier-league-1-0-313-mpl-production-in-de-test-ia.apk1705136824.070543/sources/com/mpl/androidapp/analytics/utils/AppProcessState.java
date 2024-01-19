package com.mpl.androidapp.analytics.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/mpl/androidapp/analytics/utils/AppProcessState;", "Lcom/mpl/androidapp/analytics/utils/ProcessState;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "tag", "", "doesProcessExist", "", "processType", "Lcom/mpl/androidapp/analytics/utils/ProcessType;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AppProcessState.kt */
public final class AppProcessState implements ProcessState {
    public final Context context;
    public final String tag;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AppProcessState.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProcessType.values().length];
            ProcessType processType = ProcessType.MAIN;
            iArr[0] = 1;
            ProcessType processType2 = ProcessType.UNITY;
            iArr[1] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AppProcessState(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        String simpleName = AppProcessState.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "this.javaClass.simpleName");
        this.tag = simpleName;
    }

    public boolean doesProcessExist(ProcessType processType) {
        String str;
        Intrinsics.checkNotNullParameter(processType, "processType");
        Object systemService = this.context.getSystemService("activity");
        if (systemService != null) {
            List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            int ordinal = processType.ordinal();
            if (ordinal == 0) {
                str = "com.mpl.androidapp";
            } else if (ordinal == 1) {
                str = "com.mpl.androidapp:unityPlay";
            } else {
                throw new NoWhenBranchMatchedException();
            }
            ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(runningAppProcesses, 10));
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                arrayList.add(runningAppProcessInfo.processName);
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object next : arrayList) {
                if (Intrinsics.areEqual((String) next, str)) {
                    arrayList2.add(next);
                }
            }
            boolean z = !arrayList2.isEmpty();
            Intrinsics.stringPlus("AppStatus3: is required process exist? ", Boolean.valueOf(z));
            return z;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
    }
}
