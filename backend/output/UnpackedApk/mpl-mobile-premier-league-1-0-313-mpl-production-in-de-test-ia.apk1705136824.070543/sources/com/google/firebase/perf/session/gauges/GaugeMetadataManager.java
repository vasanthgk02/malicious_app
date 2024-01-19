package com.google.firebase.perf.session.gauges;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import com.google.firebase.perf.logging.AndroidLogger;
import java.util.Iterator;
import java.util.List;

public class GaugeMetadataManager {
    public static final AndroidLogger logger = AndroidLogger.getInstance();
    public final ActivityManager activityManager;
    public final Context appContext;
    public final String currentProcessName;
    public final MemoryInfo memoryInfo;
    public final Runtime runtime = Runtime.getRuntime();

    public GaugeMetadataManager(Context context) {
        String str;
        this.appContext = context;
        this.activityManager = (ActivityManager) context.getSystemService("activity");
        MemoryInfo memoryInfo2 = new MemoryInfo();
        this.memoryInfo = memoryInfo2;
        this.activityManager.getMemoryInfo(memoryInfo2);
        int myPid = Process.myPid();
        List<RunningAppProcessInfo> runningAppProcesses = this.activityManager.getRunningAppProcesses();
        if (runningAppProcesses != null) {
            Iterator<RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                RunningAppProcessInfo next = it.next();
                if (next.pid == myPid) {
                    str = next.processName;
                    break;
                }
            }
            this.currentProcessName = str;
        }
        str = this.appContext.getPackageName();
        this.currentProcessName = str;
    }
}
