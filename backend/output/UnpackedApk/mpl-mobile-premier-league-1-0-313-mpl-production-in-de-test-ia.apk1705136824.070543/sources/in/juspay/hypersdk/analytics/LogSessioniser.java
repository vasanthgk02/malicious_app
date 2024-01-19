package in.juspay.hypersdk.analytics;

import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.core.JuspayCoreLib;
import in.juspay.hypersdk.core.JuspayLogger;
import in.juspay.services.HyperServices;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LogSessioniser {
    public static final Object IO_LOCK = new Object();
    public static ArrayList activeRequestIDs = new ArrayList();
    public static JSONObject logs = new JSONObject();
    public static TimerTask moveToPusher;
    public static Timer moveToPusherTimer = new Timer();
    public static JSONObject rawLogs = new JSONObject();
    public static boolean stopPushingLogs = false;
    public static int timerModulus = 0;
    public static boolean timerStopped = false;

    public static class LogSessioniserTimerTask extends TimerTask {
        public LogSessioniserTimerTask() {
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(10:9|10|(1:12)|13|(1:15)(3:16|17|18)|19|20|(5:22|23|(1:25)|26|27)|28|29) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x00b8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x00d7 */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x00be  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r8 = this;
                java.lang.Boolean r0 = in.juspay.hypersdk.analytics.LogUtils.isMinMemoryAvailable()
                boolean r0 = r0.booleanValue()
                if (r0 != 0) goto L_0x000b
                return
            L_0x000b:
                int r0 = in.juspay.hypersdk.analytics.LogSessioniser.timerModulus
                r1 = 1
                r2 = 0
                if (r0 != r1) goto L_0x0015
                r0 = 1
                goto L_0x0016
            L_0x0015:
                r0 = 0
            L_0x0016:
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                java.lang.String r3 = "LOGS_READING_FILE"
                java.lang.String r4 = "LOGS_WRITING_FILE"
                java.lang.String r5 = "juspay-pre-logs-queue-"
                java.lang.String r6 = ".dat"
                in.juspay.hypersdk.analytics.LogSessioniser.deleteOldFileIfNecessary(r3, r4, r5, r6)
                java.lang.String r3 = "TEMP_LOGS_READING_FILE"
                java.lang.String r4 = "TEMP_LOGS_WRITING_FILE"
                java.lang.String r5 = "temp-logs-queue-"
                java.lang.String r6 = ".dat"
                in.juspay.hypersdk.analytics.LogSessioniser.deleteOldFileIfNecessary(r3, r4, r5, r6)
                java.lang.Object r3 = in.juspay.hypersdk.analytics.LogSessioniser.IO_LOCK
                monitor-enter(r3)
                boolean r4 = r0.booleanValue()     // Catch:{ all -> 0x00fe }
                if (r4 == 0) goto L_0x0070
                java.util.ArrayList r4 = in.juspay.hypersdk.analytics.LogSessioniser.activeRequestIDs     // Catch:{ all -> 0x00fe }
                r4.clear()     // Catch:{ all -> 0x00fe }
                org.json.JSONObject r4 = in.juspay.hypersdk.analytics.LogSessioniser.logs     // Catch:{ all -> 0x00fe }
                in.juspay.hypersdk.analytics.LogSessioniser.pushLogsFromJsonToPusher(r4)     // Catch:{ all -> 0x00fe }
                java.lang.String r4 = "TEMP_LOGS_READING_FILE"
                int r4 = in.juspay.hypersdk.analytics.LogUtils.getFromSharedPreference(r4)     // Catch:{ all -> 0x00fe }
                java.lang.String r5 = "TEMP_LOGS_WRITING_FILE"
                int r5 = in.juspay.hypersdk.analytics.LogUtils.getFromSharedPreference(r5)     // Catch:{ all -> 0x00fe }
                java.lang.String r6 = "temp-logs-queue-"
                java.lang.String r7 = ".dat"
                in.juspay.hypersdk.analytics.LogSessioniser.clearAllLogFiles(r6, r7, r4, r5)     // Catch:{ all -> 0x00fe }
                java.lang.String r4 = "TEMP_LOGS_READING_FILE"
                java.lang.String r5 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x00fe }
                in.juspay.hypersdk.analytics.LogUtils.writeToSharedPreference(r4, r5)     // Catch:{ all -> 0x00fe }
                java.lang.String r4 = "TEMP_LOGS_WRITING_FILE"
                java.lang.String r5 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x00fe }
                in.juspay.hypersdk.analytics.LogUtils.writeToSharedPreference(r4, r5)     // Catch:{ all -> 0x00fe }
            L_0x0070:
                boolean r4 = r0.booleanValue()     // Catch:{ all -> 0x00fe }
                if (r4 == 0) goto L_0x0086
                org.json.JSONObject r4 = in.juspay.hypersdk.analytics.LogSessioniser.rawLogs     // Catch:{ all -> 0x00fe }
                in.juspay.hypersdk.analytics.LogSessioniser.logs = r4     // Catch:{ all -> 0x00fe }
                org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x00fe }
                r4.<init>()     // Catch:{ all -> 0x00fe }
                in.juspay.hypersdk.analytics.LogSessioniser.rawLogs = r4     // Catch:{ all -> 0x00fe }
                goto L_0x00b8
            L_0x0086:
                java.lang.String r4 = "LOGS_READING_FILE"
                int r4 = in.juspay.hypersdk.analytics.LogUtils.getFromSharedPreference(r4)     // Catch:{ all -> 0x00fe }
                java.lang.String r5 = "LOGS_WRITING_FILE"
                int r5 = in.juspay.hypersdk.analytics.LogUtils.getFromSharedPreference(r5)     // Catch:{ all -> 0x00fe }
                java.lang.String r6 = "juspay-pre-logs-queue-"
                java.lang.String r7 = ".dat"
                in.juspay.hypersdk.analytics.LogSessioniser.clearAllLogFiles(r6, r7, r4, r5)     // Catch:{ all -> 0x00fe }
                java.lang.String r4 = "LOGS_READING_FILE"
                java.lang.String r5 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x00fe }
                in.juspay.hypersdk.analytics.LogUtils.writeToSharedPreference(r4, r5)     // Catch:{ all -> 0x00fe }
                java.lang.String r4 = "LOGS_WRITING_FILE"
                java.lang.String r5 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x00fe }
                in.juspay.hypersdk.analytics.LogUtils.writeToSharedPreference(r4, r5)     // Catch:{ all -> 0x00fe }
                org.json.JSONObject r4 = in.juspay.hypersdk.analytics.LogSessioniser.rawLogs     // Catch:{ Exception -> 0x00b8 }
                java.lang.String r5 = "juspay-pre-logs-queue-"
                java.lang.String r6 = ".dat"
                java.lang.String r7 = "LOGS_WRITING_FILE"
                in.juspay.hypersdk.analytics.LogSessioniser.pushJsonToFile(r4, r5, r6, r7, r2)     // Catch:{ Exception -> 0x00b8 }
            L_0x00b8:
                boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00fe }
                if (r0 == 0) goto L_0x00d7
                java.lang.String r0 = "TEMP_LOGS_WRITING_FILE"
                int r0 = in.juspay.hypersdk.analytics.LogUtils.getFromSharedPreference(r0)     // Catch:{ all -> 0x00fe }
                r4 = -1
                if (r0 != r4) goto L_0x00c8
                goto L_0x00c9
            L_0x00c8:
                r2 = r0
            L_0x00c9:
                org.json.JSONObject r0 = in.juspay.hypersdk.analytics.LogSessioniser.logs     // Catch:{ Exception -> 0x00d7 }
                java.lang.String r4 = "temp-logs-queue-"
                java.lang.String r5 = ".dat"
                java.lang.String r6 = "TEMP_LOGS_WRITING_FILE"
                in.juspay.hypersdk.analytics.LogSessioniser.pushJsonToFile(r0, r4, r5, r6, r2)     // Catch:{ Exception -> 0x00d7 }
            L_0x00d7:
                monitor-exit(r3)     // Catch:{ all -> 0x00fe }
                org.json.JSONObject r0 = in.juspay.hypersdk.analytics.LogSessioniser.logs
                int r0 = r0.length()
                if (r0 != 0) goto L_0x00f6
                org.json.JSONObject r0 = in.juspay.hypersdk.analytics.LogSessioniser.rawLogs
                int r0 = r0.length()
                if (r0 != 0) goto L_0x00f6
                in.juspay.hypersdk.analytics.LogSessioniser.timerStopped = r1
                java.util.Timer r0 = in.juspay.hypersdk.analytics.LogSessioniser.moveToPusherTimer
                r0.cancel()
            L_0x00f6:
                in.juspay.hypersdk.analytics.LogSessioniser.access$104()
                r0 = 5
                in.juspay.hypersdk.analytics.LogSessioniser.access$144(r0)
                return
            L_0x00fe:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x00fe }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.analytics.LogSessioniser.LogSessioniserTimerTask.run():void");
        }
    }

    static {
        int fromSharedPreference = LogUtils.getFromSharedPreference(LogConstants.LOGS_WRITING_FILE);
        int fromSharedPreference2 = LogUtils.getFromSharedPreference(LogConstants.LOGS_READING_FILE);
        if (fromSharedPreference == -1) {
            LogUtils.writeToSharedPreference(LogConstants.LOGS_WRITING_FILE, String.valueOf(0));
            fromSharedPreference = 0;
        }
        if (fromSharedPreference2 == -1) {
            LogUtils.writeToSharedPreference(LogConstants.LOGS_READING_FILE, String.valueOf(0));
            fromSharedPreference2 = 0;
        }
        int fromSharedPreference3 = LogUtils.getFromSharedPreference(LogConstants.TEMP_LOGS_WRITING_FILE);
        int fromSharedPreference4 = LogUtils.getFromSharedPreference(LogConstants.TEMP_LOGS_READING_FILE);
        if (fromSharedPreference3 == -1) {
            LogUtils.writeToSharedPreference(LogConstants.TEMP_LOGS_WRITING_FILE, String.valueOf(0));
            fromSharedPreference3 = 0;
        }
        if (fromSharedPreference4 == -1) {
            LogUtils.writeToSharedPreference(LogConstants.TEMP_LOGS_READING_FILE, String.valueOf(0));
            fromSharedPreference4 = 0;
        }
        deleteOldFileIfNecessary(LogConstants.LOGS_READING_FILE, LogConstants.LOGS_WRITING_FILE, LogConstants.LOGS_FILE, ".dat");
        deleteOldFileIfNecessary(LogConstants.TEMP_LOGS_READING_FILE, LogConstants.TEMP_LOGS_WRITING_FILE, LogConstants.TEMP_LOGS_FILE, ".dat");
        while (fromSharedPreference4 <= fromSharedPreference3) {
            try {
                String str = LogConstants.TEMP_LOGS_FILE + fromSharedPreference4 + ".dat";
                if (JuspayCoreLib.getApplicationContext() != null) {
                    File file = new File(JuspayCoreLib.getApplicationContext().getCacheDir(), str);
                    if (file.length() <= LogConstants.maxLogFileSize && file.exists() && LogUtils.isFileEligibleToPush(file)) {
                        LogPusher.addLogsFromSessioniser(LogUtils.getLogsFromFile(file));
                    }
                    file.delete();
                }
            } catch (Exception unused) {
            }
            fromSharedPreference4++;
        }
        LogUtils.writeToSharedPreference(LogConstants.TEMP_LOGS_READING_FILE, String.valueOf(0));
        LogUtils.writeToSharedPreference(LogConstants.TEMP_LOGS_WRITING_FILE, String.valueOf(0));
        while (fromSharedPreference2 <= fromSharedPreference) {
            try {
                String str2 = LogConstants.LOGS_FILE + fromSharedPreference2 + ".dat";
                if (JuspayCoreLib.getApplicationContext() != null) {
                    File file2 = new File(JuspayCoreLib.getApplicationContext().getCacheDir(), str2);
                    if (file2.length() <= LogConstants.maxLogFileSize && file2.exists() && LogUtils.isFileEligibleToPush(file2)) {
                        LogPusher.addLogsFromSessioniser(LogUtils.getLogsFromFile(file2));
                    }
                    file2.delete();
                }
            } catch (Exception unused2) {
            }
            fromSharedPreference2++;
        }
        LogUtils.writeToSharedPreference(LogConstants.LOGS_READING_FILE, String.valueOf(0));
        LogUtils.writeToSharedPreference(LogConstants.LOGS_WRITING_FILE, String.valueOf(0));
    }

    public static /* synthetic */ int access$104() {
        int i = timerModulus + 1;
        timerModulus = i;
        return i;
    }

    public static /* synthetic */ int access$144(int i) {
        int i2 = timerModulus % i;
        timerModulus = i2;
        return i2;
    }

    public static void addLogLine(String str, JSONObject jSONObject) {
        if (!stopPushingLogs) {
            try {
                if (((long) jSONObject.getJSONObject(HSLCriteriaBuilder.VALUE).toString().getBytes().length) > LogConstants.maxLogValueSize) {
                    jSONObject.put(HSLCriteriaBuilder.VALUE, "Filtered");
                    JuspayLogger.i("LogSessioniser", "Filtering the value of log as the size of value is greater than 32 KB");
                }
                startLogSessioniserOnLogCount();
                if (!rawLogs.has(str)) {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject);
                    rawLogs.put(str, jSONArray);
                } else {
                    rawLogs.accumulate(str, jSONObject);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void clearAllLogFiles(String str, String str2, int i, int i2) {
        while (i <= i2) {
            try {
                File file = LogUtils.getFile(str + i + str2);
                if (file != null) {
                    file.delete();
                }
            } catch (Exception unused) {
            }
            i++;
        }
    }

    public static String constructErrorMessage(String str, String str2) {
        return GeneratedOutlineSupport.outline54("{\"requestId\":\"", str2, "\",\"error\":true,\"logs\":{},\"errorMessage\":\"", str, "\"}");
    }

    public static void deleteOldFileIfNecessary(String str, String str2, String str3, String str4) {
        int fromSharedPreference = LogUtils.getFromSharedPreference(str);
        int fromSharedPreference2 = LogUtils.getFromSharedPreference(str2);
        if (JuspayCoreLib.getApplicationContext() != null && (fromSharedPreference2 - fromSharedPreference) + 1 > LogConstants.maxFilesAllowed) {
            while ((fromSharedPreference2 - fromSharedPreference) + 1 > LogConstants.numFilesToLeaveIfMaxFilesExceeded) {
                File file = LogUtils.getFile(str3 + fromSharedPreference + str4);
                if (file != null) {
                    try {
                        file.delete();
                    } catch (Exception unused) {
                    }
                }
                fromSharedPreference++;
            }
            LogUtils.writeToSharedPreference(str, String.valueOf(fromSharedPreference));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getLogsFromSessionId(org.json.JSONObject r6) {
        /*
            java.lang.String r0 = "requestId"
            java.lang.String r1 = ""
            if (r6 == 0) goto L_0x0056
            java.lang.String r2 = r6.getString(r0)     // Catch:{ JSONException -> 0x0043 }
            java.lang.String r3 = "sessionId"
            java.lang.String r6 = r6.getString(r3)     // Catch:{ JSONException -> 0x0041 }
            java.util.ArrayList r3 = activeRequestIDs     // Catch:{ JSONException -> 0x003f }
            r3.add(r2)     // Catch:{ JSONException -> 0x003f }
            org.json.JSONObject r3 = logs     // Catch:{ JSONException -> 0x003f }
            org.json.JSONArray r3 = r3.optJSONArray(r6)     // Catch:{ JSONException -> 0x003f }
            if (r3 == 0) goto L_0x0038
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x003f }
            r4.<init>()     // Catch:{ JSONException -> 0x003f }
            org.json.JSONObject r0 = r4.put(r0, r2)     // Catch:{ JSONException -> 0x003f }
            java.lang.String r4 = "error"
            r5 = 0
            org.json.JSONObject r0 = r0.put(r4, r5)     // Catch:{ JSONException -> 0x003f }
            java.lang.String r4 = "logs"
            org.json.JSONObject r0 = r0.put(r4, r3)     // Catch:{ JSONException -> 0x003f }
            java.lang.String r6 = r0.toString()     // Catch:{ JSONException -> 0x003f }
            return r6
        L_0x0038:
            java.lang.String r6 = "No logs saved to file"
            java.lang.String r6 = constructErrorMessage(r6, r2)
            return r6
        L_0x003f:
            goto L_0x0045
        L_0x0041:
            r6 = r1
            goto L_0x0045
        L_0x0043:
            r6 = r1
            r2 = r6
        L_0x0045:
            if (r2 != r1) goto L_0x004a
            java.lang.String r6 = "RequestId not sent"
            goto L_0x0051
        L_0x004a:
            if (r6 != r1) goto L_0x004f
            java.lang.String r6 = "SessionId not sent"
            goto L_0x0051
        L_0x004f:
            java.lang.String r6 = "Request invalid"
        L_0x0051:
            java.lang.String r6 = constructErrorMessage(r6, r2)
            return r6
        L_0x0056:
            java.lang.String r6 = "Request Invalid"
            java.lang.String r6 = constructErrorMessage(r6, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.analytics.LogSessioniser.getLogsFromSessionId(org.json.JSONObject):java.lang.String");
    }

    public static void pushJsonToFile(JSONObject jSONObject, String str, String str2, String str3, int i) {
        String str4 = str;
        String str5 = str2;
        Iterator<String> keys = jSONObject.keys();
        StringBuilder sb = new StringBuilder();
        sb.append(str4);
        int i2 = i;
        sb.append(i2);
        sb.append(str5);
        FileOutputStream fileOutputStream = new FileOutputStream(LogUtils.getFile(sb.toString()), true);
        while (keys.hasNext()) {
            JSONArray jSONArray = jSONObject.getJSONArray(keys.next());
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                byte[] bytes = (jSONObject2.toString() + LogConstants.LOG_DELIMITER).getBytes(StandardCharsets.UTF_8);
                long length = (long) bytes.length;
                if (LogUtils.getFileLength(str4 + i2 + str5) + length <= LogConstants.maxLogFileSize) {
                    fileOutputStream.write(bytes);
                } else if (length <= LogConstants.maxLogLineSize) {
                    i2++;
                    LogUtils.writeToSharedPreference(str3, String.valueOf(i2));
                    FileOutputStream fileOutputStream2 = new FileOutputStream(LogUtils.getFile(str4 + i2 + str5), true);
                    fileOutputStream2.write(bytes);
                    fileOutputStream = fileOutputStream2;
                }
                String str6 = str3;
            }
            String str7 = str3;
        }
        fileOutputStream.close();
    }

    public static boolean pushLogsFromJsonToPusher(JSONObject jSONObject) {
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                LogPusher.addLogLines(jSONObject.getJSONArray(keys.next()));
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static synchronized void sessioniseLogs(JSONObject jSONObject) {
        synchronized (LogSessioniser.class) {
            if (!stopPushingLogs) {
                try {
                    String string = jSONObject.getString("sessionId");
                    String string2 = jSONObject.getString(HyperServices.REQUEST_ID);
                    JSONArray jSONArray = jSONObject.getJSONArray("logs");
                    if (activeRequestIDs.indexOf(string2) != -1 && ((long) jSONArray.toString().getBytes().length) <= LogConstants.maxLogLineSize) {
                        startLogSessioniserOnLogCount();
                        logs.put(string, jSONArray);
                    }
                } catch (JSONException unused) {
                }
            }
        }
    }

    public static void startLogSessioniser() {
        stopPushingLogs = false;
        timerStopped = false;
        moveToPusherTimer = new Timer();
        LogSessioniserTimerTask logSessioniserTimerTask = new LogSessioniserTimerTask();
        moveToPusher = logSessioniserTimerTask;
        moveToPusherTimer.scheduleAtFixedRate(logSessioniserTimerTask, 0, 2000);
    }

    public static synchronized void startLogSessioniserOnLogCount() {
        synchronized (LogSessioniser.class) {
            if (timerStopped) {
                timerStopped = false;
                moveToPusherTimer = new Timer();
                LogSessioniserTimerTask logSessioniserTimerTask = new LogSessioniserTimerTask();
                moveToPusher = logSessioniserTimerTask;
                moveToPusherTimer.scheduleAtFixedRate(logSessioniserTimerTask, 0, 2000);
            }
        }
    }

    public static void stopLogSessioniserOnTerminate() {
        moveToPusherTimer.cancel();
        synchronized (IO_LOCK) {
            if (pushLogsFromJsonToPusher(logs)) {
                logs = new JSONObject();
                clearAllLogFiles(LogConstants.TEMP_LOGS_FILE, ".dat", LogUtils.getFromSharedPreference(LogConstants.TEMP_LOGS_READING_FILE), LogUtils.getFromSharedPreference(LogConstants.TEMP_LOGS_WRITING_FILE));
                LogUtils.writeToSharedPreference(LogConstants.TEMP_LOGS_READING_FILE, String.valueOf(0));
                LogUtils.writeToSharedPreference(LogConstants.TEMP_LOGS_WRITING_FILE, String.valueOf(0));
            }
            if (pushLogsFromJsonToPusher(rawLogs)) {
                rawLogs = new JSONObject();
                clearAllLogFiles(LogConstants.LOGS_FILE, ".dat", LogUtils.getFromSharedPreference(LogConstants.LOGS_READING_FILE), LogUtils.getFromSharedPreference(LogConstants.LOGS_WRITING_FILE));
                LogUtils.writeToSharedPreference(LogConstants.LOGS_READING_FILE, String.valueOf(0));
                LogUtils.writeToSharedPreference(LogConstants.LOGS_WRITING_FILE, String.valueOf(0));
            }
        }
        timerStopped = true;
        stopPushingLogs = true;
    }
}
