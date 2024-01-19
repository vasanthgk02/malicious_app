package androidx.work.impl.utils;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import androidx.work.Logger;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.HashMap;
import java.util.WeakHashMap;

public class WakeLocks {
    public static final String TAG = Logger.tagWithPrefix("WakeLocks");
    public static final WeakHashMap<WakeLock, String> sWakeLocks = new WeakHashMap<>();

    public static void checkWakeLocks() {
        HashMap hashMap = new HashMap();
        synchronized (sWakeLocks) {
            hashMap.putAll(sWakeLocks);
        }
        for (WakeLock wakeLock : hashMap.keySet()) {
            if (wakeLock != null && wakeLock.isHeld()) {
                Logger.get().warning(TAG, String.format("WakeLock held for %s", new Object[]{hashMap.get(wakeLock)}), new Throwable[0]);
            }
        }
    }

    public static WakeLock newWakeLock(Context context, String str) {
        String outline50 = GeneratedOutlineSupport.outline50("WorkManager: ", str);
        WakeLock newWakeLock = ((PowerManager) context.getApplicationContext().getSystemService("power")).newWakeLock(1, outline50);
        synchronized (sWakeLocks) {
            try {
                sWakeLocks.put(newWakeLock, outline50);
            }
        }
        return newWakeLock;
    }
}
