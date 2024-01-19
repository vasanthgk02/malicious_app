package in.juspay.hypersdk.analytics;

import android.content.Context;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import in.juspay.hypersdk.R;
import in.juspay.hypersdk.core.JuspayCoreLib;
import in.juspay.hypersdk.core.JuspayLogger;
import in.juspay.hypersdk.core.Labels.System;
import in.juspay.hypersdk.core.SdkTracker;
import in.juspay.hypersdk.security.EncryptionHelper;
import in.juspay.hypersdk.security.JOSEUtils;
import in.juspay.hypersdk.services.SdkConfigService;
import in.juspay.hypersdk.utils.Utils;
import in.juspay.hypersdk.utils.network.JuspayHttpResponse;
import in.juspay.hypersdk.utils.network.NetUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LogPusher {
    public static final int LOGS_FLUSH_INTERVAL = 2000;
    public static final int LOGS_POST_INTERVAL = 10000;
    public static final long MAX_LOGS_PER_PUSH = 75;
    public static final Object PERSISTED_LOGS_IO_LOCK = new Object();
    public static final String TAG = "LogPusher";
    public static int getLogsToPushErrorCounter = 0;
    public static Map<String, String> headers = new HashMap();
    public static boolean isSandboxEnv = false;
    public static int logFlushTimerTaskErrorCounter = 0;
    public static Timer logPushTimer = new Timer();
    public static TimerTask logPushTimerTask;
    public static int logPushTimerTaskErrorCounter = 0;
    public static final ConcurrentLinkedQueue<byte[]> logsQueue = new ConcurrentLinkedQueue<>();
    public static boolean stopPushingLogs = false;

    public static class IterableJSONArray implements Iterable<JSONObject> {
        public JSONArray original;

        public IterableJSONArray(JSONArray jSONArray) {
            this.original = jSONArray;
        }

        public Iterator<JSONObject> iterator() {
            return new Iterator<JSONObject>() {
                public int curr = 0;

                public boolean hasNext() {
                    return this.curr < IterableJSONArray.this.original.length();
                }

                public JSONObject next() {
                    try {
                        JSONArray jSONArray = IterableJSONArray.this.original;
                        int i = this.curr;
                        this.curr = i + 1;
                        return jSONArray.optJSONObject(i);
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        return null;
                    }
                }

                public void remove() {
                }
            };
        }
    }

    public static class LogPushTimerTask extends TimerTask {
        public static final String TAG = "LogPushTimerTask";
        public static boolean isExceptionTracked;

        public LogPushTimerTask() {
        }

        public void run() {
            if (LogUtils.isMinMemoryAvailable().booleanValue()) {
                synchronized (LogPusher.PERSISTED_LOGS_IO_LOCK) {
                    int fromSharedPreference = LogUtils.getFromSharedPreference(LogConstants.PERSISTENT_LOGS_READING_FILE);
                    int fromSharedPreference2 = LogUtils.getFromSharedPreference(LogConstants.PERSISTENT_LOGS_WRITING_FILE);
                    if (JuspayCoreLib.getApplicationContext() != null && (fromSharedPreference2 - fromSharedPreference) + 1 > LogConstants.maxFilesAllowed) {
                        while ((fromSharedPreference2 - fromSharedPreference) + 1 > LogConstants.numFilesToLeaveIfMaxFilesExceeded) {
                            File file = LogUtils.getFile(LogConstants.PERSISTENT_LOGS_FILE + fromSharedPreference + ".dat");
                            if (file != null) {
                                try {
                                    file.delete();
                                } catch (Exception unused) {
                                }
                            }
                            fromSharedPreference++;
                        }
                        LogUtils.writeToSharedPreference(LogConstants.PERSISTENT_LOGS_READING_FILE, String.valueOf(fromSharedPreference));
                    }
                    while (LogPusher.logsQueue.size() > 0) {
                        try {
                            JSONArray access$500 = LogPusher.getLogsToPush();
                            if (access$500.length() > 0) {
                                int pushLogsToServer = LogPusher.pushLogsToServer(access$500);
                                if (pushLogsToServer != 200) {
                                    SdkTracker.trackBootAction("system", "error", System.LOG_PUSHER, "error_response", "" + pushLogsToServer);
                                    return;
                                }
                                LogPusher.acknowledgeLogsPushed(access$500.length());
                            }
                        } catch (Exception e2) {
                            Exception exc = e2;
                            if (!isExceptionTracked) {
                                SdkTracker.trackAndLogBootException(TAG, "action", "system", System.LOG_PUSHER, "Error while creating the payload to post", exc);
                            }
                            isExceptionTracked = true;
                        }
                    }
                    int fromSharedPreference3 = LogUtils.getFromSharedPreference(LogConstants.PERSISTENT_LOGS_WRITING_FILE);
                    if (JuspayCoreLib.getApplicationContext() != null) {
                        for (int fromSharedPreference4 = LogUtils.getFromSharedPreference(LogConstants.PERSISTENT_LOGS_READING_FILE); fromSharedPreference4 <= fromSharedPreference3; fromSharedPreference4++) {
                            File cacheDir = JuspayCoreLib.getApplicationContext().getCacheDir();
                            new File(cacheDir, LogConstants.PERSISTENT_LOGS_FILE + fromSharedPreference4 + ".dat").delete();
                        }
                    }
                    LogUtils.writeToSharedPreference(LogConstants.PERSISTENT_LOGS_READING_FILE, String.valueOf(0));
                    LogUtils.writeToSharedPreference(LogConstants.PERSISTENT_LOGS_WRITING_FILE, String.valueOf(0));
                }
            }
        }
    }

    static {
        int i = 0;
        int fromSharedPreference = LogUtils.getFromSharedPreference(LogConstants.PERSISTENT_LOGS_READING_FILE);
        if (fromSharedPreference == -1) {
            LogUtils.writeToSharedPreference(LogConstants.PERSISTENT_LOGS_READING_FILE, String.valueOf(0));
            fromSharedPreference = 0;
        }
        int fromSharedPreference2 = LogUtils.getFromSharedPreference(LogConstants.PERSISTENT_LOGS_WRITING_FILE);
        if (fromSharedPreference2 == -1) {
            LogUtils.writeToSharedPreference(LogConstants.PERSISTENT_LOGS_WRITING_FILE, String.valueOf(0));
        } else {
            i = fromSharedPreference2;
        }
        pushAllFiles(fromSharedPreference, i);
    }

    public static void acknowledgeLogsPushed(int i) {
        while (i > 0) {
            try {
                logsQueue.poll();
                i--;
            } catch (Exception e2) {
                Exception exc = e2;
                int i2 = logPushTimerTaskErrorCounter + 1;
                logPushTimerTaskErrorCounter = i2;
                if (i2 <= 2) {
                    SdkTracker.trackAndLogBootException(TAG, "action", "system", System.LOG_PUSHER, "Exception in removal of logs from persisted Queue file", exc);
                    return;
                } else {
                    JuspayLogger.e(TAG, "Exception in removal of logs from persisted Queue file", exc);
                    return;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00eb A[Catch:{ Exception -> 0x0104 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void addLogLines(java.lang.Iterable<org.json.JSONObject> r12) {
        /*
            boolean r0 = stopPushingLogs
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 2
            r1 = 1
            java.lang.Object r2 = PERSISTED_LOGS_IO_LOCK     // Catch:{ Exception -> 0x0104 }
            monitor-enter(r2)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r3 = "PERSISTENT_LOGS_WRITING_FILE"
            int r3 = in.juspay.hypersdk.analytics.LogUtils.getFromSharedPreference(r3)     // Catch:{ all -> 0x0101 }
            r4 = -1
            if (r3 != r4) goto L_0x0014
            r3 = 0
        L_0x0014:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0101 }
            r4.<init>()     // Catch:{ all -> 0x0101 }
            java.lang.String r5 = "juspay-logs-queue-"
            r4.append(r5)     // Catch:{ all -> 0x0101 }
            r4.append(r3)     // Catch:{ all -> 0x0101 }
            java.lang.String r5 = ".dat"
            r4.append(r5)     // Catch:{ all -> 0x0101 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0101 }
            java.io.File r4 = in.juspay.hypersdk.analytics.LogUtils.getFile(r4)     // Catch:{ all -> 0x0101 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ all -> 0x0101 }
            r5.<init>(r4, r1)     // Catch:{ all -> 0x0101 }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ all -> 0x0101 }
        L_0x0037:
            boolean r4 = r12.hasNext()     // Catch:{ all -> 0x0101 }
            if (r4 == 0) goto L_0x00fc
            java.lang.Object r4 = r12.next()     // Catch:{ all -> 0x0101 }
            org.json.JSONObject r4 = (org.json.JSONObject) r4     // Catch:{ all -> 0x0101 }
            if (r4 == 0) goto L_0x0037
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e1 }
            r6.<init>()     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r7 = r4.toString()     // Catch:{ Exception -> 0x00e1 }
            r6.append(r7)     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r7 = "DELIMITER_LOG"
            r6.append(r7)     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00e1 }
            java.nio.charset.Charset r7 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ Exception -> 0x00e1 }
            byte[] r6 = r6.getBytes(r7)     // Catch:{ Exception -> 0x00e1 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e1 }
            r7.<init>()     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r8 = "juspay-logs-queue-"
            r7.append(r8)     // Catch:{ Exception -> 0x00e1 }
            r7.append(r3)     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r8 = ".dat"
            r7.append(r8)     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x00e1 }
            long r7 = in.juspay.hypersdk.analytics.LogUtils.getFileLength(r7)     // Catch:{ Exception -> 0x00e1 }
            int r9 = r6.length     // Catch:{ Exception -> 0x00e1 }
            long r9 = (long) r9     // Catch:{ Exception -> 0x00e1 }
            long r7 = r7 + r9
            long r9 = in.juspay.hypersdk.analytics.LogConstants.maxLogFileSize     // Catch:{ Exception -> 0x00e1 }
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 > 0) goto L_0x0096
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00e1 }
            java.nio.charset.Charset r7 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ Exception -> 0x00e1 }
            byte[] r4 = r4.getBytes(r7)     // Catch:{ Exception -> 0x00e1 }
            java.util.concurrent.ConcurrentLinkedQueue<byte[]> r7 = logsQueue     // Catch:{ Exception -> 0x00e1 }
            r7.add(r4)     // Catch:{ Exception -> 0x00e1 }
            r5.write(r6)     // Catch:{ Exception -> 0x00e1 }
            goto L_0x0037
        L_0x0096:
            int r7 = r6.length     // Catch:{ Exception -> 0x00e1 }
            long r7 = (long) r7     // Catch:{ Exception -> 0x00e1 }
            long r9 = in.juspay.hypersdk.analytics.LogConstants.maxLogLineSize     // Catch:{ Exception -> 0x00e1 }
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 > 0) goto L_0x0037
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00e1 }
            java.nio.charset.Charset r7 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ Exception -> 0x00e1 }
            byte[] r4 = r4.getBytes(r7)     // Catch:{ Exception -> 0x00e1 }
            java.util.concurrent.ConcurrentLinkedQueue<byte[]> r7 = logsQueue     // Catch:{ Exception -> 0x00e1 }
            r7.add(r4)     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r4 = "PERSISTENT_LOGS_WRITING_FILE"
            int r3 = r3 + 1
            java.lang.String r7 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x00e1 }
            in.juspay.hypersdk.analytics.LogUtils.writeToSharedPreference(r4, r7)     // Catch:{ Exception -> 0x00e1 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e1 }
            r4.<init>()     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r7 = "juspay-logs-queue-"
            r4.append(r7)     // Catch:{ Exception -> 0x00e1 }
            r4.append(r3)     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r7 = ".dat"
            r4.append(r7)     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00e1 }
            java.io.File r4 = in.juspay.hypersdk.analytics.LogUtils.getFile(r4)     // Catch:{ Exception -> 0x00e1 }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00e1 }
            r7.<init>(r4, r1)     // Catch:{ Exception -> 0x00e1 }
            r7.write(r6)     // Catch:{ Exception -> 0x00dd }
            r5 = r7
            goto L_0x0037
        L_0x00dd:
            r4 = move-exception
            r9 = r4
            r10 = r7
            goto L_0x00e4
        L_0x00e1:
            r4 = move-exception
            r9 = r4
            r10 = r5
        L_0x00e4:
            int r4 = logFlushTimerTaskErrorCounter     // Catch:{ all -> 0x0101 }
            int r4 = r4 + r1
            logFlushTimerTaskErrorCounter = r4     // Catch:{ all -> 0x0101 }
            if (r4 > r0) goto L_0x00f9
            java.lang.String r4 = "LogPusher"
            java.lang.String r5 = "action"
            java.lang.String r6 = "system"
            java.lang.String r7 = "log_pusher"
            java.lang.String r8 = "Exception while flushing the logs to persisted queue file"
            in.juspay.hypersdk.core.SdkTracker.trackAndLogBootException(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0101 }
        L_0x00f9:
            r5 = r10
            goto L_0x0037
        L_0x00fc:
            r5.close()     // Catch:{ all -> 0x0101 }
            monitor-exit(r2)     // Catch:{ all -> 0x0101 }
            goto L_0x011b
        L_0x0101:
            r12 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0101 }
            throw r12     // Catch:{ Exception -> 0x0104 }
        L_0x0104:
            r12 = move-exception
            r7 = r12
            int r12 = logFlushTimerTaskErrorCounter
            int r12 = r12 + r1
            logFlushTimerTaskErrorCounter = r12
            if (r12 > r0) goto L_0x011b
            java.lang.String r2 = "LogPusher"
            java.lang.String r3 = "action"
            java.lang.String r4 = "system"
            java.lang.String r5 = "log_pusher"
            java.lang.String r6 = "Exception while flushing the logs to persisted queue file"
            in.juspay.hypersdk.core.SdkTracker.trackAndLogBootException(r2, r3, r4, r5, r6, r7)
        L_0x011b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.analytics.LogPusher.addLogLines(java.lang.Iterable):void");
    }

    public static void addLogLines(JSONArray jSONArray) {
        if (!stopPushingLogs) {
            addLogLines((Iterable<JSONObject>) new IterableJSONArray<JSONObject>(jSONArray));
        }
    }

    public static void addLogsFromSessioniser(ArrayList<JSONObject> arrayList) {
        Iterator<JSONObject> it = arrayList.iterator();
        while (it.hasNext()) {
            byte[] bytes = it.next().toString().getBytes(StandardCharsets.UTF_8);
            if (((long) bytes.length) <= LogConstants.maxLogLineSize) {
                logsQueue.add(bytes);
            }
        }
    }

    public static synchronized void addLogsToPersistedQueue(String str) {
        synchronized (LogPusher.class) {
            try {
                synchronized (PERSISTED_LOGS_IO_LOCK) {
                    if (JuspayCoreLib.getApplicationContext() != null) {
                        File file = new File(JuspayCoreLib.getApplicationContext().getCacheDir(), LogConstants.CRASH_LOGS_FILE);
                        byte[] bytes = (str + LogConstants.LOG_DELIMITER).getBytes(StandardCharsets.UTF_8);
                        if (((long) bytes.length) < LogConstants.maxLogLineSize) {
                            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                            fileOutputStream.write(bytes);
                            fileOutputStream.close();
                        }
                    }
                }
            } catch (Exception e2) {
                JuspayLogger.e(TAG, "addLogsToPersistedQueue failed", e2);
            }
        }
        return;
    }

    public static void flushLogPush() {
        logPushTimerTask.run();
    }

    public static String getEndPoint() {
        Context applicationContext = JuspayCoreLib.getApplicationContext();
        if (applicationContext == null) {
            return "https://logs.juspay.in/godel/analytics";
        }
        String string = applicationContext.getResources().getString(isSandboxEnv ? R.string.juspay_analytics_endpoint_sandbox : R.string.juspay_analytics_endpoint);
        JSONObject cachedSdkConfig = SdkConfigService.getCachedSdkConfig();
        if (cachedSdkConfig != null) {
            try {
                return isSandboxEnv ? cachedSdkConfig.getJSONObject(SdkTracker.logsConfig).optString("logsUrlKeySandbox", string) : cachedSdkConfig.getJSONObject(SdkTracker.logsConfig).optString("logsUrlKey", string);
            } catch (Exception unused) {
                SdkTracker.trackBootAction("system", "warning", System.LOG_PUSHER, "sdk_config", "unable to fetch log endpoint from sdk config");
            }
        }
        return string;
    }

    public static RSAPublicKey getLogEncryptionKey() {
        JSONObject jSONObject;
        String str;
        JSONObject cachedSdkConfig = SdkConfigService.getCachedSdkConfig();
        if (cachedSdkConfig != null) {
            try {
                if (isSandboxEnv) {
                    jSONObject = cachedSdkConfig.getJSONObject(SdkTracker.logsConfig);
                    str = "publicKeySandbox";
                } else {
                    jSONObject = cachedSdkConfig.getJSONObject(SdkTracker.logsConfig);
                    str = "publicKey";
                }
                return JOSEUtils.JWKtoRSAPublicKey(jSONObject.getJSONObject(str));
            } catch (Exception e2) {
                SdkTracker.trackBootException("system", "warning", System.LOG_PUSHER, "sdk_config", e2);
            }
        } else {
            SdkTracker.trackBootAction("system", "warning", System.LOG_PUSHER, "sdk_config", "unable to fetch analytics public key from sdk config");
            return null;
        }
    }

    public static String getLogEncryptionLevel() {
        JSONObject cachedSdkConfig = SdkConfigService.getCachedSdkConfig();
        if (cachedSdkConfig != null) {
            try {
                return cachedSdkConfig.getJSONObject(SdkTracker.logsConfig).optString("encryptionLevelKey", "gzip");
            } catch (Exception unused) {
                SdkTracker.trackBootAction("system", "warning", System.LOG_PUSHER, "sdk_config", "unable to log encryption level from sdk config");
            }
        }
        return "gzip";
    }

    public static JSONArray getLogsToPush() {
        JSONArray jSONArray = new JSONArray();
        Iterator<byte[]> it = logsQueue.iterator();
        while (((long) jSONArray.length()) < 75 && it.hasNext()) {
            try {
                jSONArray.put(new JSONObject(new String(it.next())));
            } catch (JSONException e2) {
                JSONException jSONException = e2;
                it.remove();
                int i = getLogsToPushErrorCounter + 1;
                getLogsToPushErrorCounter = i;
                if (i <= 2) {
                    SdkTracker.trackAndLogBootException(TAG, "action", "system", System.LOG_PUSHER, "Bad JSON while reading the Persisted Queue for Logs", jSONException);
                } else {
                    JuspayLogger.e(TAG, "Bad JSON while reading the Persisted Queue for Logs", jSONException);
                }
            }
        }
        return jSONArray;
    }

    public static void pushAllFiles(int i, int i2) {
        synchronized (PERSISTED_LOGS_IO_LOCK) {
            while (i <= i2) {
                File file = LogUtils.getFile(LogConstants.PERSISTENT_LOGS_FILE + i + ".dat");
                if (file != null) {
                    if (!file.exists() || !LogUtils.isFileEligibleToPush(file)) {
                        file.delete();
                    } else {
                        pushFileContentToServer(file);
                    }
                }
                i++;
            }
            if (JuspayCoreLib.getApplicationContext() != null) {
                File file2 = new File(JuspayCoreLib.getApplicationContext().getCacheDir(), LogConstants.CRASH_LOGS_FILE);
                if (!file2.exists() || !LogUtils.isFileEligibleToPush(file2)) {
                    file2.delete();
                } else {
                    pushFileContentToServer(file2);
                }
            }
        }
    }

    public static void pushFileContentToServer(final File file) {
        if (file != null) {
            new Thread(new Runnable() {
                public void run() {
                    ArrayList<JSONObject> logsFromFile = LogUtils.getLogsFromFile(file);
                    boolean z = true;
                    try {
                        JSONArray jSONArray = new JSONArray();
                        while (logsFromFile.size() > 0) {
                            while (((long) jSONArray.length()) < 75 && logsFromFile.size() > 0) {
                                jSONArray.put(logsFromFile.remove(0));
                            }
                            if (LogPusher.pushLogsToServer(jSONArray) != 200) {
                                z = false;
                            }
                            jSONArray = new JSONArray();
                        }
                        if (z) {
                            file.delete();
                        }
                    } catch (Exception unused) {
                    }
                }
            }).start();
        }
    }

    public static int pushLogsToServer(JSONArray jSONArray) {
        JuspayHttpResponse juspayHttpResponse;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", jSONArray);
        byte[] bytes = jSONObject.toString().getBytes(StandardCharsets.UTF_8);
        String logEncryptionLevel = getLogEncryptionLevel();
        RSAPublicKey logEncryptionKey = getLogEncryptionKey();
        NetUtils netUtils = new NetUtils(10000, 10000);
        if ("encryption".equals(logEncryptionLevel) && logEncryptionKey != null) {
            juspayHttpResponse = new JuspayHttpResponse(netUtils.doPost(new URL(getEndPoint()), EncryptionHelper.gzipThenEncrypt(bytes, logEncryptionKey), "application/x-godel-gzip-pubkey-encrypted", headers));
        } else if ("gzip".equals(logEncryptionLevel)) {
            byte[] gzipContent = Utils.gzipContent(bytes);
            headers.put("Content-Encoding", "gzip");
            juspayHttpResponse = new JuspayHttpResponse(netUtils.doPost(new URL(getEndPoint()), gzipContent, "application/gzip", headers));
        } else {
            juspayHttpResponse = new JuspayHttpResponse(netUtils.doPost(new URL(getEndPoint()), bytes, DefaultSettingsSpiCall.ACCEPT_JSON_VALUE, headers));
        }
        return juspayHttpResponse.responseCode;
    }

    public static void setEndPointSandbox(Boolean bool) {
        isSandboxEnv = bool.booleanValue();
    }

    public static void setHeaders(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                headers.put(next, jSONObject.getString(next));
            } catch (JSONException unused) {
            }
        }
    }

    public static void startLogPusherTimer() {
        stopPushingLogs = false;
        LogSessioniser.startLogSessioniser();
        logPushTimer = new Timer();
        LogPushTimerTask logPushTimerTask2 = new LogPushTimerTask();
        logPushTimerTask = logPushTimerTask2;
        logPushTimer.scheduleAtFixedRate(logPushTimerTask2, MqttAsyncClient.DISCONNECT_TIMEOUT, MqttAsyncClient.DISCONNECT_TIMEOUT);
    }

    public static void stopLogPusherOnTerminate() {
        LogSessioniser.stopLogSessioniserOnTerminate();
        logPushTimer.cancel();
        logPushTimer = new Timer();
        logPushTimerTask = new LogPushTimerTask();
        new Thread(new Runnable() {
            public void run() {
                LogPusher.logPushTimerTask.run();
                LogPusher.stopPushingLogs = true;
            }
        }).start();
    }
}
