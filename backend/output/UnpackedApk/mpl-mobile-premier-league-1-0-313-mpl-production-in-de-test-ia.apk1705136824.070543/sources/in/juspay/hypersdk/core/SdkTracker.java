package in.juspay.hypersdk.core;

import android.app.ActivityManager.MemoryInfo;
import android.util.Log;
import androidx.core.app.NotificationCompatJellybean;
import com.paynimo.android.payment.util.Constant;
import com.razorpay.AnalyticsConstants;
import in.juspay.hypersdk.analytics.LogPusher;
import in.juspay.hypersdk.analytics.LogSessioniser;
import in.juspay.hypersdk.core.Labels.Device;
import in.juspay.hypersdk.core.Labels.System;
import in.juspay.hypersdk.core.PaymentConstants.LogCategory;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.LifeCycle;
import in.juspay.hypersdk.data.SessionInfo;
import in.juspay.hypersdk.utils.Utils;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.paho.android.service.MqttServiceConstants;
import org.json.JSONException;
import org.json.JSONObject;

public final class SdkTracker {
    public static final String LOG_TAG = "SdkTracker";
    public static final int MAX_LOG_SIZE = 22528;
    public static final Queue<JSONObject> bootLogs = new ConcurrentLinkedQueue();
    public static final String logsConfig = "logsConfig";
    public static final String shouldPush = "shouldPush";
    public final JuspayServices juspayServices;
    public final AtomicInteger serialNumberCounter = new AtomicInteger(1);

    public SdkTracker(JuspayServices juspayServices2) {
        this.juspayServices = juspayServices2;
    }

    public static void addToBootLogs(String str) {
        JuspayLogger.log(LOG_TAG, "DEBUG", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("at", System.currentTimeMillis());
            bootLogs.add(jSONObject);
        } catch (Exception e2) {
            JuspayLogger.e(LOG_TAG, "addToBootLogs", e2);
        }
    }

    public static JSONObject createApiLog(String str, String str2, String str3, Integer num, String str4, Long l, Long l2, Object obj, Object obj2, String str5) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("url", str4);
            jSONObject2.put("status_code", num);
            jSONObject2.put("start_time", l);
            jSONObject2.put("end_time", l2);
            if (obj == null) {
                obj = JSONObject.NULL;
            }
            jSONObject2.put("payload", obj);
            jSONObject2.put(Constant.TAG_RESPONSE, obj2);
            jSONObject2.put(AnalyticsConstants.METHOD, str5);
            jSONObject.put("category", LogCategory.API_CALL);
            jSONObject.put("subcategory", str);
            jSONObject.put("level", str2);
            jSONObject.put(NotificationCompatJellybean.KEY_LABEL, str3);
            jSONObject.put(HSLCriteriaBuilder.VALUE, jSONObject2);
            jSONObject.put("at", System.currentTimeMillis());
            jSONObject.put("service", "sdk");
        } catch (JSONException e2) {
            JuspayLogger.e(LOG_TAG, "Error while adding boot log: ", e2);
        }
        return jSONObject;
    }

    public static JSONObject createExceptionLog(String str, String str2, String str3, String str4, Throwable th) {
        return createExceptionLog(str, str2, str3, str4, th, false);
    }

    public static JSONObject createExceptionLog(String str, String str2, String str3, String str4, Throwable th, boolean z) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("message", str4 + ". " + th.getLocalizedMessage());
            jSONObject2.put("stacktrace", Log.getStackTraceString(th));
            jSONObject2.put("stacktrace", z ? formatThrowable(th) : Log.getStackTraceString(th));
            jSONObject.put("category", str);
            jSONObject.put("subcategory", str2);
            jSONObject.put("level", MqttServiceConstants.TRACE_EXCEPTION);
            jSONObject.put(NotificationCompatJellybean.KEY_LABEL, str3 + "_" + Utils.getLogLevelFromThrowable(th));
            jSONObject.put(HSLCriteriaBuilder.VALUE, jSONObject2);
            jSONObject.put("service", "sdk");
            jSONObject.put("at", System.currentTimeMillis());
        } catch (JSONException e2) {
            JuspayLogger.e(LOG_TAG, "Error while adding log: ", e2);
        }
        return jSONObject;
    }

    public static JSONObject createLog(String str, String str2, String str3, String str4, String str5, Object obj) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (obj == null) {
            try {
                obj = JSONObject.NULL;
            } catch (JSONException e2) {
                JuspayLogger.e(LOG_TAG, "Error while adding boot log: ", e2);
            }
        }
        jSONObject2.put(str5, obj);
        jSONObject.put("category", str);
        jSONObject.put("subcategory", str2);
        jSONObject.put("level", str3);
        jSONObject.put(NotificationCompatJellybean.KEY_LABEL, str4);
        jSONObject.put(HSLCriteriaBuilder.VALUE, jSONObject2);
        jSONObject.put("at", System.currentTimeMillis());
        jSONObject.put("service", "sdk");
        return jSONObject;
    }

    public static JSONObject createLogWithValue(String str, String str2, String str3, String str4, Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", str);
            jSONObject.put("subcategory", str2);
            jSONObject.put("level", str3);
            jSONObject.put(NotificationCompatJellybean.KEY_LABEL, str4);
            jSONObject.put(HSLCriteriaBuilder.VALUE, obj);
            jSONObject.put("at", System.currentTimeMillis());
            jSONObject.put("service", "sdk");
        } catch (JSONException e2) {
            JuspayLogger.e(LOG_TAG, "Error while adding boot log: ", e2);
        }
        return jSONObject;
    }

    public static String formatThrowable(Throwable th) {
        StringBuilder sb = new StringBuilder(getStackTraceAsString(th));
        while (true) {
            th = th.getCause();
            if (th == null) {
                return sb.toString();
            }
            sb.append("\nCaused by ");
            sb.append(getStackTraceAsString(th));
        }
    }

    private JSONObject getConfig() {
        try {
            return this.juspayServices.getSdkConfigService().getSdkConfig().getJSONObject(logsConfig);
        } catch (Exception e2) {
            trackBootException(LogCategory.LIFECYCLE, LifeCycle.HYPER_SDK, "sdk_meta", "Exception while fetching analytics config", e2);
            return null;
        }
    }

    public static String getStackTraceAsString(Throwable th) {
        StringBuilder sb = new StringBuilder(th.toString());
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            sb.append("\n\tat ");
            sb.append(stackTraceElement.toString());
        }
        return sb.toString();
    }

    private synchronized void processBootLogs() {
        while (!bootLogs.isEmpty()) {
            JSONObject poll = bootLogs.poll();
            if (poll != null) {
                try {
                    signLog(poll);
                    LogSessioniser.addLogLine(this.juspayServices.getSessionInfo().getSessionId(), poll);
                } catch (Exception e2) {
                    trackException("action", "system", System.LOG_PUSHER, "Exception while signing log line", e2);
                }
            }
        }
    }

    private void signLog(JSONObject jSONObject) {
        SessionInfo sessionInfo = this.juspayServices.getSessionInfo();
        jSONObject.put("session_id", sessionInfo.getSessionId());
        String clientId = sessionInfo.getClientId();
        if (!clientId.equals("")) {
            jSONObject.put(PaymentConstants.CLIENT_ID, clientId);
        }
        jSONObject.put("package_name", sessionInfo.getPackageName());
        jSONObject.put("log_version", PaymentConstants.LOG_VERSION);
        synchronized (this) {
            jSONObject.put("sn", this.serialNumberCounter.getAndIncrement());
        }
    }

    public static String trackAndGetExceptionLog(String str, String str2, String str3, String str4, Throwable th) {
        JSONObject createExceptionLog = createExceptionLog(str, str2, str3, str4, th, true);
        try {
            createExceptionLog.put("session_id", SessionInfo.getNewSessionId());
            createExceptionLog.put("log_version", PaymentConstants.LOG_VERSION);
        } catch (Exception e2) {
            JuspayLogger.e(LOG_TAG, "trackAndGetExceptionLog failed", e2);
        }
        return createExceptionLog.toString();
    }

    public static void trackAndLogBootException(String str, String str2, String str3, String str4, String str5, Throwable th) {
        JuspayLogger.e(str, str5, th);
        bootLogs.add(createExceptionLog(str2, str3, str4, str5, th));
    }

    public static void trackBootAction(String str, String str2, String str3, String str4, Object obj) {
        bootLogs.add(createLog("action", str, str2, str3, str4, obj));
    }

    public static void trackBootException(String str, String str2, String str3, String str4, Throwable th) {
        bootLogs.add(createExceptionLog(str, str2, str3, str4, th));
    }

    public static void trackBootLifecycle(String str, String str2, String str3, String str4, Object obj) {
        bootLogs.add(createLog(LogCategory.LIFECYCLE, str, str2, str3, str4, obj));
    }

    private JSONObject truncateLog(JSONObject jSONObject) {
        Object truncateLog;
        if (jSONObject.toString().length() > 22528) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.length() > 22528) {
                        truncateLog = str.substring(0, MAX_LOG_SIZE);
                        jSONObject.put(next, truncateLog);
                    }
                }
                if ((obj instanceof JSONObject) && obj.toString().length() > 22528) {
                    truncateLog = truncateLog((JSONObject) obj);
                    jSONObject.put(next, truncateLog);
                }
            }
        }
        return jSONObject;
    }

    public String getExceptionLog(String str, String str2, String str3, String str4, Throwable th) {
        JSONObject createExceptionLog = createExceptionLog(str, str2, str3, str4, th, true);
        try {
            signLog(createExceptionLog);
        } catch (Exception e2) {
            JuspayLogger.e(LOG_TAG, "getExceptionLog failed", e2);
        }
        return createExceptionLog.toString();
    }

    public void setEndPointSandbox(Boolean bool) {
        LogPusher.setEndPointSandbox(bool);
    }

    public void track(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("at", System.currentTimeMillis());
            track(jSONObject);
        } catch (JSONException e2) {
            trackException("action", "system", System.LOG_PUSHER, "Exception while parsing the JSON", e2);
        }
    }

    public void track(JSONObject jSONObject) {
        try {
            JSONObject config = getConfig();
            if (config == null || config.getBoolean(shouldPush)) {
                JSONObject truncateLog = truncateLog(jSONObject);
                signLog(truncateLog);
                this.juspayServices.sdkDebug(LOG_TAG, truncateLog.toString());
                LogSessioniser.addLogLine(this.juspayServices.getSessionInfo().getSessionId(), truncateLog);
                processBootLogs();
                return;
            }
            bootLogs.clear();
        } catch (Exception e2) {
            trackException("action", "system", System.LOG_PUSHER, "Exception while signing log line", e2);
        }
    }

    public void trackAction(String str, String str2, String str3, String str4, Object obj) {
        JSONObject createLog = createLog("action", str, str2, str3, str4, obj);
        if (this.juspayServices.getSessionInfo().getSessionId() != null) {
            track(createLog);
        } else {
            bootLogs.add(createLog);
        }
    }

    public void trackAndLogException(String str, String str2, String str3, String str4, String str5, Throwable th) {
        JuspayLogger.e(str, str5, th);
        SessionInfo sessionInfo = this.juspayServices.getSessionInfo();
        JSONObject jSONObject = new JSONObject();
        try {
            MemoryInfo memoryInfo = Utils.getMemoryInfo(JuspayCoreLib.getApplicationContext());
            if (memoryInfo != null) {
                jSONObject.put("available_memory", memoryInfo.availMem);
                jSONObject.put("threshold_memory", memoryInfo.threshold);
                jSONObject.put("total_memory", memoryInfo.totalMem);
            }
            jSONObject.put("network_info", sessionInfo.getNetworkInfo());
            jSONObject.put("network_type", String.valueOf(sessionInfo.getNetworkType()));
            jSONObject.put("ip_address", Utils.getIPAddress(this.juspayServices));
        } catch (Exception e2) {
            trackException("action", "system", "session_info", "Exception while logging phone state", e2);
        }
        trackContext("device", "info", Device.PHONE_STATE, jSONObject);
        JSONObject createExceptionLog = createExceptionLog(str2, str3, str4, str5, th);
        if (this.juspayServices.getSessionInfo().getSessionId() != null) {
            track(createExceptionLog);
        } else {
            bootLogs.add(createExceptionLog);
        }
    }

    public void trackApiCalls(String str, String str2, String str3, Integer num, String str4, Long l, Long l2, Object obj, Object obj2, String str5) {
        JSONObject createApiLog = createApiLog(str, str2, str3, num, str4, l, l2, obj, obj2, str5);
        if (this.juspayServices.getSessionInfo().getSessionId() != null) {
            track(createApiLog);
        } else {
            bootLogs.add(createApiLog);
        }
    }

    public void trackContext(String str, String str2, String str3, Object obj) {
        JSONObject createLogWithValue = createLogWithValue("context", str, str2, str3, obj);
        if (this.juspayServices.getSessionInfo().getSessionId() != null) {
            track(createLogWithValue);
        } else {
            bootLogs.add(createLogWithValue);
        }
    }

    public void trackContext(String str, String str2, String str3, String str4, Object obj) {
        JSONObject createLog = createLog("context", str, str2, str3, str4, obj);
        if (this.juspayServices.getSessionInfo().getSessionId() != null) {
            track(createLog);
        } else {
            bootLogs.add(createLog);
        }
    }

    public void trackException(String str, String str2, String str3, String str4, Throwable th) {
        JSONObject createExceptionLog = createExceptionLog(str, str2, str3, str4, th);
        if (this.juspayServices.getSessionInfo().getSessionId() != null) {
            track(createExceptionLog);
        } else {
            bootLogs.add(createExceptionLog);
        }
    }

    public void trackLifecycle(String str, String str2, String str3, String str4, Object obj) {
        JSONObject createLog = createLog(LogCategory.LIFECYCLE, str, str2, str3, str4, obj);
        if (this.juspayServices.getSessionInfo().getSessionId() != null) {
            track(createLog);
        } else {
            bootLogs.add(createLog);
        }
    }
}
