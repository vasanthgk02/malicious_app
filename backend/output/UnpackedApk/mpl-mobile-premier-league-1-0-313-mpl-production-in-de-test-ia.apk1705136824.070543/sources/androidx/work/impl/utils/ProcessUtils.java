package androidx.work.impl.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.impl.background.greedy.GreedyScheduler;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public class ProcessUtils {
    public static final String TAG = Logger.tagWithPrefix("ProcessUtils");

    public static boolean isDefaultProcess(Context context, Configuration configuration) {
        String str;
        if (VERSION.SDK_INT >= 28) {
            str = Application.getProcessName();
        } else {
            str = null;
            try {
                Method declaredMethod = Class.forName("android.app.ActivityThread", false, GreedyScheduler.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, new Object[0]);
                if (invoke instanceof String) {
                    str = (String) invoke;
                }
            } catch (Throwable th) {
                Logger.get().debug(TAG, "Unable to check ActivityThread for processName", th);
            }
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
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
                }
            }
        }
        if (!TextUtils.isEmpty(configuration.mDefaultProcessName)) {
            return TextUtils.equals(str, configuration.mDefaultProcessName);
        }
        return TextUtils.equals(str, context.getApplicationInfo().processName);
    }
}
