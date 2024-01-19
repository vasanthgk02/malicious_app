package com.mpl.androidapp.responsiblegaming;

import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.config.ConfigConstant;
import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.MLogger;
import java.util.Random;
import java.util.UUID;
import org.joda.time.Duration;
import org.joda.time.Instant;
import org.json.JSONObject;

public class RgSessionManager {
    public static long HEARTBEAT_INTERVAL_MILLIS = 30000;
    public static int MAX_WARNING_COUNT = 3;
    public static int PRIMARY_WARNING_INTERVAL_MIN = 300;
    public static int SECONDARY_WARNING_INTERVAL_MIN = 60;
    public static int SESSION_TIMEOUT_MIN = 15;
    public static final String TAG = "ResponsibleGamingTimer";
    public static boolean isConfigInitdone = false;
    public static boolean isProviderResolving = true;
    public static RgWarningListener mRgWarningListener = null;
    public static String processName = "???";
    public ContentResolver contentResolver;
    public Handler hardCloseHandler;
    public Runnable hardCloseRunnable = new Runnable() {
        public void run() {
            RgSessionManager.logSeperator("START: Hard Close Runnable");
            if (RgSessionManager.mRgWarningListener != null) {
                JSONObject jSONObject = new JSONObject();
                RgSessionInfo access$100 = RgSessionManager.this.getSavedSessionInfo();
                Duration duration = new Duration(new Instant(access$100.getRgSessionEnd()), new Instant());
                try {
                    MLogger.d("ResponsibleGamingTimer", RgSessionManager.processName + "sending hardclose warning()");
                    jSONObject.put("isLastWarning", true);
                    jSONObject.put("secLeft", Long.toString(((RgSessionManager.this.minToMilli(RgSessionManager.SESSION_TIMEOUT_MIN) - duration.iMillis) + 1) / 1000));
                    jSONObject.put("sesDuration", Long.toString(access$100.getRgSessionDuration()));
                    RgSessionManager.mRgWarningListener.onShowWarning(jSONObject.toString());
                } catch (Exception unused) {
                    MLogger.d("ResponsibleGamingTimer", "Exception When giving HC warning");
                }
            } else {
                RgSessionManager rgSessionManager = RgSessionManager.this;
                rgSessionManager.hardCloseHandler.postDelayed(rgSessionManager.hardCloseRunnable, 2000);
            }
            RgSessionManager.logSeperator("END: Hard Close Runnable");
        }
    };
    public HandlerThread hardCloseThread;
    public Handler hearBeatHandler;
    public HandlerThread heartBeatHandlerThread;
    public Runnable runnable = new Runnable() {
        public void run() {
            RgSessionManager.logSeperator("START Heart Beat Runnable");
            if (RgSessionManager.isProviderResolving) {
                MLogger.d("ResponsibleGamingTimer", RgSessionManager.processName + " | onHeartBeat");
                RgSessionManager.this.addCurrentDurationToSession();
                RgSessionManager rgSessionManager = RgSessionManager.this;
                rgSessionManager.hearBeatHandler.postDelayed(rgSessionManager.runnable, RgSessionManager.HEARTBEAT_INTERVAL_MILLIS);
            }
            RgSessionManager.logSeperator("END Heart Beat Runnable");
        }
    };

    public RgSessionManager(ContentResolver contentResolver2) {
        this.contentResolver = contentResolver2;
        if (VERSION.SDK_INT >= 28) {
            processName = Application.getProcessName();
        }
    }

    /* access modifiers changed from: private */
    public void addCurrentDurationToSession() {
        logSeperator("START addCurrentDurationToSession");
        RgSessionInfo savedSessionInfo = getSavedSessionInfo();
        MLogger.d("ResponsibleGamingTimer", processName + " | in addCurrentDurationToSession() before adding-> " + savedSessionInfo.toString());
        long j = new Instant().iMillis;
        if (j > savedSessionInfo.getRgSessionEnd() && savedSessionInfo.getRgSessionEnd() != 0) {
            long rgSessionDuration = savedSessionInfo.getRgSessionDuration();
            MLogger.d("ResponsibleGamingTimer", processName + " | incrementing session duration by" + RgSessionInfo.milliToMinSec(j - savedSessionInfo.getRgSessionEnd()));
            savedSessionInfo.setRgSessionDuration((j - savedSessionInfo.getRgSessionEnd()) + rgSessionDuration);
            savedSessionInfo.setRgSessionEnd(j);
            MLogger.d("ResponsibleGamingTimer", processName + " | in addCurrentDurationToSession() after adding-> " + savedSessionInfo.toString());
            saveSessionInfo(savedSessionInfo);
        }
        logSeperator("END addCurrentDurationToSession");
    }

    private boolean checkForHardCloseWarning() {
        logSeperator("START: checkForHardCloseWarning");
        MLogger.d("ResponsibleGamingTimer", GeneratedOutlineSupport.outline62(new StringBuilder(), processName, " in checkForHardCloseWarning()"));
        RgSessionInfo savedSessionInfo = getSavedSessionInfo();
        if (savedSessionInfo.getRgWarningCount() >= MAX_WARNING_COUNT) {
            MLogger.d("ResponsibleGamingTimer", GeneratedOutlineSupport.outline62(new StringBuilder(), processName, "warning count >= maxwanrning count"));
            Duration duration = new Duration(new Instant(savedSessionInfo.getRgSessionEnd()), new Instant());
            MLogger.d("ResponsibleGamingTimer", processName + " time since last sessionEnd is " + RgSessionInfo.milliToMinSec(duration.iMillis));
            if (duration.iMillis > minToMilli(SESSION_TIMEOUT_MIN)) {
                MLogger.d("ResponsibleGamingTimer", GeneratedOutlineSupport.outline62(new StringBuilder(), processName, "session must have timeout"));
                logSeperator("END: checkForHardCloseWarning");
                return false;
            } else if (mRgWarningListener != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    MLogger.d("ResponsibleGamingTimer", processName + "sending hardclose warning()");
                    jSONObject.put("isLastWarning", true);
                    jSONObject.put("secLeft", Long.toString(((minToMilli(SESSION_TIMEOUT_MIN) - duration.iMillis) + 1) / 1000));
                    jSONObject.put("sesDuration", Long.toString(savedSessionInfo.getRgSessionDuration()));
                    mRgWarningListener.onShowWarning(jSONObject.toString());
                    logSeperator("END: checkForHardCloseWarning");
                    return true;
                } catch (Exception unused) {
                    MLogger.d("ResponsibleGamingTimer", "Exception When giving HC warning");
                    return false;
                }
            } else {
                MLogger.d("ResponsibleGamingTimer", "Can't send HC as listener is null");
                startHardCloseThread();
                logSeperator("END: checkForHardCloseWarning");
                return true;
            }
        } else {
            MLogger.d("ResponsibleGamingTimer", GeneratedOutlineSupport.outline62(new StringBuilder(), processName, "warning count < maxwanrning count, returning false"));
            logSeperator("END: checkForHardCloseWarning");
            return false;
        }
    }

    private void evalAndSendWarning(RgSessionInfo rgSessionInfo) {
        RgSessionInfo rgSessionInfo2 = rgSessionInfo;
        logSeperator("START: evalAndSendWarning");
        MLogger.d("ResponsibleGamingTimer", processName + " | In evalAndSendWarning beforeEval--->" + rgSessionInfo.toString());
        long rgSessionDuration = rgSessionInfo.getRgSessionDuration();
        if (rgSessionDuration <= minToMilli(PRIMARY_WARNING_INTERVAL_MIN)) {
            MLogger.d("ResponsibleGamingTimer", GeneratedOutlineSupport.outline62(new StringBuilder(), processName, " | No need to send warning"));
        } else if (rgSessionInfo.getRgWarningCount() == 0) {
            if (mRgWarningListener != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("isLastWarning", false);
                    mRgWarningListener.onShowWarning(jSONObject.toString());
                    rgSessionInfo2.setRgLastWarningDuration(rgSessionDuration);
                    rgSessionInfo2.setRgWarningCount(1);
                    MLogger.d("ResponsibleGamingTimer", processName + " | Sending first warning " + rgSessionInfo.toString());
                } catch (Exception unused) {
                    MLogger.d("ResponsibleGamingTimer", "Exception When giving RG warning");
                }
            } else {
                MLogger.d("ResponsibleGamingTimer", processName + " | Not sending first waring because there is no listener registered " + rgSessionInfo.toString());
            }
        } else if (rgSessionInfo.getRgWarningCount() < MAX_WARNING_COUNT - 1) {
            long rgLastWarningDuration = rgSessionInfo.getRgLastWarningDuration();
            long rgSessionDuration2 = rgSessionInfo.getRgSessionDuration();
            if (rgSessionDuration2 - rgLastWarningDuration > minToMilli(SECONDARY_WARNING_INTERVAL_MIN)) {
                if (mRgWarningListener != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("isLastWarning", false);
                        mRgWarningListener.onShowWarning(jSONObject2.toString());
                        rgSessionInfo2.setRgLastWarningDuration(rgSessionDuration2);
                        rgSessionInfo2.setRgWarningCount(rgSessionInfo.getRgWarningCount() + 1);
                        MLogger.d("ResponsibleGamingTimer", processName + " | Sending " + rgSessionInfo.getRgWarningCount() + " warning " + rgSessionInfo.toString());
                    } catch (Exception unused2) {
                        MLogger.d("ResponsibleGamingTimer", "Exception When giving RG warning");
                    }
                } else {
                    MLogger.d("ResponsibleGamingTimer", processName + " | Not sending secondary warning because there is no listener registered " + rgSessionInfo.toString());
                }
            }
        } else if (rgSessionInfo.getRgWarningCount() == MAX_WARNING_COUNT - 1) {
            long rgLastWarningDuration2 = rgSessionInfo.getRgLastWarningDuration();
            long rgSessionDuration3 = rgSessionInfo.getRgSessionDuration();
            if (rgSessionDuration3 - rgLastWarningDuration2 > minToMilli(SECONDARY_WARNING_INTERVAL_MIN)) {
                if (mRgWarningListener != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("isLastWarning", true);
                        jSONObject3.put("secLeft", Integer.toString(SESSION_TIMEOUT_MIN * 60));
                        jSONObject3.put("sesDuration", Long.toString(rgSessionDuration3));
                        mRgWarningListener.onShowWarning(jSONObject3.toString());
                        rgSessionInfo2.setRgLastWarningDuration(rgSessionDuration3);
                        rgSessionInfo2.setRgWarningCount(rgSessionInfo.getRgWarningCount() + 1);
                        MLogger.d("ResponsibleGamingTimer", processName + " | Sending " + rgSessionInfo.getRgWarningCount() + " LAST warning " + rgSessionInfo.toString());
                        if (this.heartBeatHandlerThread != null) {
                            MLogger.d("ResponsibleGamingTimer", processName + " Killing the heartbeat thread! " + this.heartBeatHandlerThread.getName());
                            this.hearBeatHandler.removeCallbacks(this.runnable);
                            this.heartBeatHandlerThread.quit();
                            this.heartBeatHandlerThread = null;
                        }
                    } catch (Exception unused3) {
                        MLogger.d("ResponsibleGamingTimer", "Exception When giving RG warning");
                    }
                } else {
                    MLogger.d("ResponsibleGamingTimer", processName + " | Not sending secondary warning because there is no listener registered " + rgSessionInfo.toString());
                }
            }
        } else {
            MLogger.d("ResponsibleGamingTimer", GeneratedOutlineSupport.outline62(new StringBuilder(), processName, " | Max warning count exceeded, not evaluating warnings!"));
        }
        logSeperator("END: evalAndSendWarning");
    }

    public static String getProcessName() {
        return VERSION.SDK_INT >= 28 ? Application.getProcessName() : "???";
    }

    /* access modifiers changed from: private */
    public RgSessionInfo getSavedSessionInfo() {
        logSeperator("START: getSavedSessionInfo");
        RgSessionInfo rgSessionInfo = new RgSessionInfo();
        Cursor cursor = null;
        try {
            Uri build = RgSessionContract.BASE_CONTENT_URI.buildUpon().appendPath("session").build();
            if (MPLApplication.getInstance() != null && !TextUtils.isEmpty(MPLApplication.getInstance().getPackageName())) {
                build = Uri.parse("content://" + MPLApplication.getInstance().getPackageName() + RgSessionContract.CONTENT_AUTHORITY_POST_FIX).buildUpon().appendPath("session").build();
            }
            cursor = this.contentResolver.query(build, null, null, null, null);
            if (cursor == null || !cursor.moveToFirst()) {
                MLogger.d("ResponsibleGamingTimer", "Cursor was null or cursor issue");
                logSeperator("END: getSavedSessionInfo");
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                return rgSessionInfo;
            }
            rgSessionInfo.setRgSessionId(cursor.getString(cursor.getColumnIndex(Constant.RG_SESSION_ID)));
            rgSessionInfo.setRgSessionEnd(cursor.getLong(cursor.getColumnIndex(Constant.RG_SESSION_END)));
            rgSessionInfo.setRgLastWarningDuration(cursor.getLong(cursor.getColumnIndex(Constant.RG_LAST_WARNING_DURATION)));
            rgSessionInfo.setRgWarningCount(cursor.getInt(cursor.getColumnIndex(Constant.RG_WARNING_COUNT)));
            rgSessionInfo.setRgSessionDuration(cursor.getLong(cursor.getColumnIndex(Constant.RG_SESSION_DURATION)));
            MLogger.d("ResponsibleGamingTimer", processName + " | got following SavedSessionInfo--->" + rgSessionInfo.toString());
            logSeperator("END: getSavedSessionInfo");
            if (!cursor.isClosed()) {
                cursor.close();
            }
            return rgSessionInfo;
        } catch (Exception e2) {
            MLogger.d("ResponsibleGamingTimer", "Exception occoured in getSavedSessionInfo info, setting isProviderResolving to false ");
            isProviderResolving = false;
            e2.printStackTrace();
            MLogger.d("ResponsibleGamingTimer", "Exception occoured in getsavedSession info" + Log.getStackTraceString(e2));
            logSeperator("END: getSavedSessionInfo");
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return rgSessionInfo;
        } catch (Throwable th) {
            if (cursor == null || cursor.isClosed()) {
                throw th;
            }
            cursor.close();
            return rgSessionInfo;
        }
    }

    private void incrementSessionCount() {
        logSeperator("START: incrementSessionCount");
        JSONObject normalConfig = ConfigManager.getNormalConfig();
        if (normalConfig == null || !normalConfig.has(ConfigConstant.RGT_SESSION_COUNTING_ENABLED) || !normalConfig.optBoolean(ConfigConstant.RGT_SESSION_COUNTING_ENABLED)) {
            MLogger.d("ResponsibleGamingTimer", GeneratedOutlineSupport.outline62(new StringBuilder(), processName, " | Session Counting is not enabled"));
        } else {
            try {
                ContentValues contentValues = new ContentValues();
                Uri build = RgSessionContract.BASE_CONTENT_URI.buildUpon().appendPath(RgSessionContract.PATH_SESSION_COUNT).build();
                if (MPLApplication.getInstance() != null && !TextUtils.isEmpty(MPLApplication.getInstance().getPackageName())) {
                    build = Uri.parse("content://" + MPLApplication.getInstance().getPackageName() + RgSessionContract.CONTENT_AUTHORITY_POST_FIX).buildUpon().appendPath(RgSessionContract.PATH_SESSION_COUNT).build();
                }
                this.contentResolver.update(build, contentValues, null, null);
                MLogger.d("ResponsibleGamingTimer", processName + " | Incremented Session count");
            } catch (Exception e2) {
                MLogger.d("ResponsibleGamingTimer", "Exception occoured in saveSession info, setting isProviderResolving to false ");
                e2.printStackTrace();
                MLogger.d("ResponsibleGamingTimer", Log.getStackTraceString(e2));
            }
        }
        logSeperator("END: incrementSessionCount");
    }

    private void initNewSession() {
        logSeperator("START: initNewSession");
        long j = new Instant().iMillis;
        RgSessionInfo rgSessionInfo = new RgSessionInfo();
        rgSessionInfo.setRgSessionId(UUID.randomUUID().toString());
        rgSessionInfo.setRgSessionEnd(j + 1000);
        rgSessionInfo.setRgLastWarningDuration(0);
        rgSessionInfo.setRgWarningCount(0);
        rgSessionInfo.setRgSessionDuration(1000);
        MLogger.d("ResponsibleGamingTimer", processName + " | New session initiated " + rgSessionInfo.toString());
        saveSessionInfo(rgSessionInfo);
        incrementSessionCount();
        logSeperator("END: initNewSession");
    }

    public static void logSeperator(String str) {
        MLogger.d("ResponsibleGamingTimer", GeneratedOutlineSupport.outline52("<---------------------------------", str, "--------------------------------->"));
    }

    /* access modifiers changed from: private */
    public long minToMilli(int i) {
        return (long) (i * 60 * 1000);
    }

    private void saveSessionInfo(RgSessionInfo rgSessionInfo) {
        logSeperator("START: saveSessionInfo");
        try {
            ContentValues contentValues = new ContentValues();
            evalAndSendWarning(rgSessionInfo);
            contentValues.put(Constant.RG_SESSION_ID, rgSessionInfo.getRgSessionId());
            contentValues.put(Constant.RG_SESSION_END, Long.valueOf(rgSessionInfo.getRgSessionEnd()));
            contentValues.put(Constant.RG_LAST_WARNING_DURATION, Long.valueOf(rgSessionInfo.getRgLastWarningDuration()));
            contentValues.put(Constant.RG_WARNING_COUNT, Integer.valueOf(rgSessionInfo.getRgWarningCount()));
            contentValues.put(Constant.RG_SESSION_DURATION, Long.valueOf(rgSessionInfo.getRgSessionDuration()));
            Uri build = RgSessionContract.BASE_CONTENT_URI.buildUpon().appendPath("session").build();
            if (MPLApplication.getInstance() != null && !TextUtils.isEmpty(MPLApplication.getInstance().getPackageName())) {
                build = Uri.parse("content://" + MPLApplication.getInstance().getPackageName() + RgSessionContract.CONTENT_AUTHORITY_POST_FIX).buildUpon().appendPath("session").build();
            }
            this.contentResolver.update(build, contentValues, null, null);
            MLogger.d("ResponsibleGamingTimer", processName + " | Saved the following RG--->" + rgSessionInfo.toString());
            logSeperator("END: saveSessionInfo");
        } catch (Exception e2) {
            MLogger.d("ResponsibleGamingTimer", "Exception occoured in saveSession info, setting isProviderResolving to false ");
            isProviderResolving = false;
            e2.printStackTrace();
            MLogger.d("ResponsibleGamingTimer", Log.getStackTraceString(e2));
            logSeperator("END: saveSessionInfo");
        }
    }

    private void startHardCloseThread() {
        logSeperator("START: startHardCloseThread");
        if (this.hardCloseThread == null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Hard_close_THREAD");
            outline73.append(new Random().nextInt(1000));
            HandlerThread handlerThread = new HandlerThread(outline73.toString());
            this.hardCloseThread = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(this.hardCloseThread.getLooper());
            this.hardCloseHandler = handler;
            handler.postDelayed(this.hardCloseRunnable, 1000);
            MLogger.d("ResponsibleGamingTimer", processName + "Started new hardclose thread with name " + this.hardCloseThread.getName());
        }
        logSeperator("END: startHardCloseThread");
    }

    private void startHeartbeatThread() {
        logSeperator("START startHeartbeatThread");
        if (this.heartBeatHandlerThread == null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("RES_GAMING_THREAD");
            outline73.append(new Random().nextInt(1000));
            HandlerThread handlerThread = new HandlerThread(outline73.toString());
            this.heartBeatHandlerThread = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(this.heartBeatHandlerThread.getLooper());
            this.hearBeatHandler = handler;
            handler.postDelayed(this.runnable, HEARTBEAT_INTERVAL_MILLIS);
            MLogger.d("ResponsibleGamingTimer", processName + "Started new heartbeat thread with name " + this.heartBeatHandlerThread.getName());
        }
        logSeperator("END startHeartbeatThread");
    }

    private void updateSession() {
        logSeperator("START: updateSession");
        RgSessionInfo savedSessionInfo = getSavedSessionInfo();
        MLogger.d("ResponsibleGamingTimer", processName + " | OnUpdateSession: Before update-->" + savedSessionInfo.toString());
        if (savedSessionInfo.getRgSessionId() != null) {
            if (TextUtils.isEmpty(savedSessionInfo.getRgSessionId()) || savedSessionInfo.getRgSessionEnd() <= 0) {
                MLogger.d("ResponsibleGamingTimer", GeneratedOutlineSupport.outline62(new StringBuilder(), processName, " | First Launch initiating new session"));
                initNewSession();
            } else {
                Duration duration = new Duration(new Instant(savedSessionInfo.getRgSessionEnd()), new Instant());
                MLogger.d("ResponsibleGamingTimer", processName + " | difference from lastEndTime  and current time is:-->" + RgSessionInfo.milliToMinSec(duration.iMillis));
                if (duration.iMillis > minToMilli(SESSION_TIMEOUT_MIN)) {
                    MLogger.d("ResponsibleGamingTimer", GeneratedOutlineSupport.outline62(new StringBuilder(), processName, " | Session timeout starting new session"));
                    initNewSession();
                } else {
                    savedSessionInfo.setRgSessionEnd(new Instant().iMillis);
                    MLogger.d("ResponsibleGamingTimer", processName + " | Continuing the same session " + savedSessionInfo.toString());
                    saveSessionInfo(savedSessionInfo);
                }
            }
        }
        logSeperator("END: updateSession");
    }

    public void initConfig(int i, int i2, int i3, int i4) {
        logSeperator("START: initConfig");
        if (!isConfigInitdone) {
            SESSION_TIMEOUT_MIN = i;
            PRIMARY_WARNING_INTERVAL_MIN = i2;
            SECONDARY_WARNING_INTERVAL_MIN = i3;
            MAX_WARNING_COUNT = i4;
            isConfigInitdone = true;
            MLogger.d("ResponsibleGamingTimer", GeneratedOutlineSupport.outline62(new StringBuilder(), processName, " RgSessionmanger init done"));
            logSeperator("END: initConfig");
        }
    }

    public void onAppBackground() {
        logSeperator("START: onAppBackground");
        MLogger.d("ResponsibleGamingTimer", GeneratedOutlineSupport.outline62(new StringBuilder(), processName, " | in onAppBackground()"));
        if (this.heartBeatHandlerThread != null) {
            MLogger.d("ResponsibleGamingTimer", processName + " Killing the heartbeat thread! " + this.heartBeatHandlerThread.getName());
            this.hearBeatHandler.removeCallbacks(this.runnable);
            this.heartBeatHandlerThread.quit();
            this.heartBeatHandlerThread = null;
        }
        if (this.hardCloseThread != null) {
            MLogger.d("ResponsibleGamingTimer", processName + " Killing the hard close thread! " + this.hardCloseThread.getName());
            this.hardCloseHandler.removeCallbacks(this.hardCloseRunnable);
            this.hardCloseThread.quit();
            this.hardCloseThread = null;
        }
        logSeperator("END: onAppBackground");
    }

    public void onAppForeground() {
        logSeperator("START: onAppForeground");
        MLogger.d("ResponsibleGamingTimer", GeneratedOutlineSupport.outline62(new StringBuilder(), processName, " | in onAppForeground()"));
        if (!isConfigInitdone) {
            MLogger.d("ResponsibleGamingTimer", GeneratedOutlineSupport.outline62(new StringBuilder(), processName, " | init not done skipping onAppForeground()"));
        } else if (isProviderResolving) {
            MLogger.d("ResponsibleGamingTimer", GeneratedOutlineSupport.outline62(new StringBuilder(), processName, " | init done and provider resolving- executing onAppForeground()"));
            if (checkForHardCloseWarning()) {
                MLogger.d("ResponsibleGamingTimer", GeneratedOutlineSupport.outline62(new StringBuilder(), processName, "checkforhardclose is true"));
                return;
            }
            updateSession();
            startHeartbeatThread();
        } else {
            MLogger.d("ResponsibleGamingTimer", GeneratedOutlineSupport.outline62(new StringBuilder(), processName, " | Provider not resolving skipping onAppForeground()"));
        }
        logSeperator("END: onAppForeground");
    }

    public void registerWarningListener(RgWarningListener rgWarningListener) {
        logSeperator("START: registerWarningListener");
        mRgWarningListener = rgWarningListener;
        MLogger.d("ResponsibleGamingTimer", GeneratedOutlineSupport.outline62(new StringBuilder(), processName, " Registering warning listener"));
        logSeperator("END: registerWarningListener");
    }

    public void unregisterWarningListener() {
        logSeperator("START: unregisterWarningListener");
        mRgWarningListener = null;
        MLogger.d("ResponsibleGamingTimer", GeneratedOutlineSupport.outline62(new StringBuilder(), processName, " UnRegistering warning listener"));
        logSeperator("END: unregisterWarningListener");
    }
}
