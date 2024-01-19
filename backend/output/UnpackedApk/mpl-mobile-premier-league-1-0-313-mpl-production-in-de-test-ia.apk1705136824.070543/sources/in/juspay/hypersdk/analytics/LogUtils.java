package in.juspay.hypersdk.analytics;

import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import in.juspay.hypersdk.core.JuspayCoreLib;
import in.juspay.hypersdk.data.KeyValueStore;
import in.juspay.hypersdk.utils.IntegrationUtils;
import in.juspay.hypersdk.utils.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.json.JSONObject;

public class LogUtils {
    public static File getFile(String str) {
        if (JuspayCoreLib.getApplicationContext() == null) {
            return null;
        }
        return new File(JuspayCoreLib.getApplicationContext().getCacheDir(), str);
    }

    public static long getFileLength(String str) {
        if (JuspayCoreLib.getApplicationContext() != null) {
            return new File(JuspayCoreLib.getApplicationContext().getCacheDir(), str).length();
        }
        return 0;
    }

    public static int getFromSharedPreference(String str) {
        Context applicationContext = JuspayCoreLib.getApplicationContext();
        if (applicationContext != null) {
            return Integer.parseInt(KeyValueStore.read(applicationContext, IntegrationUtils.getAppName(applicationContext), str, "-1"));
        }
        return -1;
    }

    public static ArrayList<JSONObject> getLogsFromFile(File file) {
        ArrayList<JSONObject> arrayList = new ArrayList<>();
        byte[] bArr = new byte[((int) file.length())];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bArr);
            fileInputStream.close();
            for (String jSONObject : new String(bArr, StandardCharsets.UTF_8).split(LogConstants.LOG_DELIMITER)) {
                try {
                    arrayList.add(new JSONObject(jSONObject));
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
        }
        return arrayList;
    }

    public static boolean isFileEligibleToPush(File file) {
        if (file == null) {
            return false;
        }
        return ((System.currentTimeMillis() - file.lastModified()) / 1000) / 3600 < LogConstants.dontPushIfFileIsLastModifiedBeforeInHours;
    }

    public static Boolean isMinMemoryAvailable() {
        Context applicationContext = JuspayCoreLib.getApplicationContext();
        if (applicationContext != null) {
            try {
                MemoryInfo memoryInfo = Utils.getMemoryInfo(applicationContext);
                if (memoryInfo != null) {
                    return Boolean.valueOf(memoryInfo.availMem >= LogConstants.minMemoryRequired);
                }
            } catch (Exception unused) {
            }
        }
        return Boolean.TRUE;
    }

    public static void writeToSharedPreference(String str, String str2) {
        Context applicationContext = JuspayCoreLib.getApplicationContext();
        if (applicationContext != null) {
            KeyValueStore.write(applicationContext, IntegrationUtils.getAppName(applicationContext), str, str2, true);
        }
    }
}
