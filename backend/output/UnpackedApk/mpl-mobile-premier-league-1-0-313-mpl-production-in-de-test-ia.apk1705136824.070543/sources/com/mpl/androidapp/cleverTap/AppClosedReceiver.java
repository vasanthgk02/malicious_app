package com.mpl.androidapp.cleverTap;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.mpl.androidapp.miniprofile.ct.C.PlaybackWatched;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.MLogger;
import java.util.HashMap;
import org.apache.fontbox.cmap.CMapParser;

public class AppClosedReceiver extends BroadcastReceiver {
    public static final String TAG = "MPLApplicationLifeCycle";

    public void onReceive(Context context, Intent intent) {
        MLogger.d(TAG, "onReceive() called with: context = [" + context + "], intent = [" + intent + CMapParser.MARK_END_OF_ARRAY);
        if (intent != null) {
            long longExtra = intent.getLongExtra("session_time", 0);
            int intExtra = intent.getIntExtra("time_elapsed", 0);
            MLogger.d(TAG, "onReceive() called with: sessionTimeSeconds = [" + longExtra + "], timeElapsed = [" + intExtra + CMapParser.MARK_END_OF_ARRAY);
            HashMap hashMap = new HashMap();
            hashMap.put("Session Time", Long.valueOf(longExtra));
            hashMap.put("Time Elapsed", Integer.valueOf(intExtra));
            CleverTapAnalyticsUtils.sendEvent((String) PlaybackWatched.TRIGGER_MODE_APP_CLOSED, hashMap);
            MLogger.d(TAG, "App Closed Event  called with sessionTimeSeconds", Long.valueOf(longExtra), "timeElapsed", Integer.valueOf(intExtra));
        }
    }
}
