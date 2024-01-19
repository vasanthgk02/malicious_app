package in.juspay.hypersdk.analytics;

import android.support.v4.media.session.PlaybackStateCompat;
import in.juspay.hypersdk.core.SdkTracker;
import in.juspay.hypersdk.services.SdkConfigService;
import org.json.JSONObject;

public class LogConstants {
    public static final String CRASH_LOGS_FILE = "juspay-crash-logs.dat";
    public static final String LOGS_FILE = "juspay-pre-logs-queue-";
    public static final String LOGS_FILE_EXTENSION = ".dat";
    public static final String LOGS_READING_FILE = "LOGS_READING_FILE";
    public static final String LOGS_WRITING_FILE = "LOGS_WRITING_FILE";
    public static final String LOG_DELIMITER = "DELIMITER_LOG";
    public static final String PERSISTENT_LOGS_FILE = "juspay-logs-queue-";
    public static final String PERSISTENT_LOGS_FILE_EXTENSION = ".dat";
    public static final String PERSISTENT_LOGS_READING_FILE = "PERSISTENT_LOGS_READING_FILE";
    public static final String PERSISTENT_LOGS_WRITING_FILE = "PERSISTENT_LOGS_WRITING_FILE";
    public static final String TEMP_LOGS_FILE = "temp-logs-queue-";
    public static final String TEMP_LOGS_FILE_EXTENSION = ".dat";
    public static final String TEMP_LOGS_READING_FILE = "TEMP_LOGS_READING_FILE";
    public static final String TEMP_LOGS_WRITING_FILE = "TEMP_LOGS_WRITING_FILE";
    public static long dontPushIfFileIsLastModifiedBeforeInHours = 168;
    public static int maxFilesAllowed = 7;
    public static long maxLogFileSize = 20971520;
    public static long maxLogLineSize = 20971520;
    public static long maxLogValueSize = 32768;
    public static long minMemoryRequired = 16384;
    public static int numFilesToLeaveIfMaxFilesExceeded = 5;

    static {
        JSONObject cachedSdkConfig = SdkConfigService.getCachedSdkConfig();
        try {
            maxLogLineSize = cachedSdkConfig.getJSONObject(SdkTracker.logsConfig).optLong("maxLogLineSize", 20971520);
            maxLogFileSize = cachedSdkConfig.getJSONObject(SdkTracker.logsConfig).optLong("maxLogFileSize", 20971520);
            minMemoryRequired = cachedSdkConfig.getJSONObject(SdkTracker.logsConfig).optLong("minMemoryRequired", 16384);
            maxFilesAllowed = cachedSdkConfig.getJSONObject(SdkTracker.logsConfig).optInt("maxFilesAllowed", 7);
            maxLogValueSize = cachedSdkConfig.getJSONObject(SdkTracker.logsConfig).optLong("maxLogValueSize", PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID);
            numFilesToLeaveIfMaxFilesExceeded = cachedSdkConfig.getJSONObject(SdkTracker.logsConfig).optInt("numFilesToLeaveIfMaxFilesExceeded", 5);
            dontPushIfFileIsLastModifiedBeforeInHours = cachedSdkConfig.getJSONObject(SdkTracker.logsConfig).optLong("dontPushIfFileIsLastModifiedBeforeInHours", 168);
        } catch (Exception unused) {
        }
    }
}
