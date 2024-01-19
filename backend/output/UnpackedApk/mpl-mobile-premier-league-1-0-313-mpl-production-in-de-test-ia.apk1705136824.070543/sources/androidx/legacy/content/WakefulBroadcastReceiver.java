package androidx.legacy.content;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.PowerManager.WakeLock;
import android.util.SparseArray;

@Deprecated
public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {
    public static int mNextId = 1;
    public static final SparseArray<WakeLock> sActiveWakeLocks = new SparseArray<>();

    public static boolean completeWakefulIntent(Intent intent) {
        int intExtra = intent.getIntExtra("androidx.contentpager.content.wakelockid", 0);
        if (intExtra == 0) {
            return false;
        }
        synchronized (sActiveWakeLocks) {
            WakeLock wakeLock = sActiveWakeLocks.get(intExtra);
            if (wakeLock == null) {
                return true;
            }
            wakeLock.release();
            sActiveWakeLocks.remove(intExtra);
            return true;
        }
    }
}
