package com.clevertap.android.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import androidx.core.app.NotificationManagerCompat;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.inapp.CTInAppNotification;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.Task;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

public class InAppFCManager {
    public final CleverTapInstanceConfig config;
    public final Context context;
    public final SimpleDateFormat ddMMyyyy = new SimpleDateFormat("ddMMyyyy", Locale.US);
    public String deviceId;
    public final ArrayList<String> mDismissedThisSession = new ArrayList<>();
    public final HashMap<String, Integer> mShownThisSession = new HashMap<>();
    public int mShownThisSessionCount = 0;

    public InAppFCManager(Context context2, CleverTapInstanceConfig cleverTapInstanceConfig, String str) {
        this.config = cleverTapInstanceConfig;
        this.context = context2;
        this.deviceId = str;
        Task postAsyncSafelyTask = CTExecutorFactory.executors(cleverTapInstanceConfig).postAsyncSafelyTask();
        postAsyncSafelyTask.executor.execute(new Runnable("initInAppFCManager", new Callable<Void>() {
            public Object call() throws Exception {
                InAppFCManager inAppFCManager = InAppFCManager.this;
                inAppFCManager.init(inAppFCManager.deviceId);
                return null;
            }
        }) {
            public final /* synthetic */ Callable val$callable;
            public final /* synthetic */ String val$logTag;

            {
                this.val$logTag = r2;
                this.val$callable = r3;
            }

            public void run() {
                try {
                    Logger logger = Task.this.config.getLogger();
                    logger.verbose(Task.this.taskName + " Task: " + this.val$logTag + " starting on..." + Thread.currentThread().getName());
                    TResult call = this.val$callable.call();
                    Logger logger2 = Task.this.config.getLogger();
                    logger2.verbose(Task.this.taskName + " Task: " + this.val$logTag + " executed successfully on..." + Thread.currentThread().getName());
                    Task task = Task.this;
                    if (task != null) {
                        STATE state = STATE.SUCCESS;
                        task.result = call;
                        for (SuccessExecutable<TResult> execute : task.successExecutables) {
                            execute.execute(task.result);
                        }
                        return;
                    }
                    throw null;
                } catch (Exception e2) {
                    Task task2 = Task.this;
                    if (task2 != null) {
                        STATE state2 = STATE.FAILED;
                        for (FailureExecutable<Exception> execute2 : task2.failureExecutables) {
                            execute2.execute(e2);
                        }
                        Logger logger3 = Task.this.config.getLogger();
                        logger3.verbose(Task.this.taskName + " Task: " + this.val$logTag + " failed to execute on..." + Thread.currentThread().getName(), (Throwable) e2);
                        e2.printStackTrace();
                        return;
                    }
                    throw null;
                }
            }
        });
    }

    public void attachToHeader(Context context2, JSONObject jSONObject) {
        try {
            jSONObject.put("imp", getIntFromPrefs(getKeyWithDeviceId("istc_inapp", this.deviceId), 0));
            JSONArray jSONArray = new JSONArray();
            Map<String, ?> all = k.getPreferences(context2, getKeyWithDeviceId("counts_per_inapp", this.deviceId)).getAll();
            for (String next : all.keySet()) {
                Object obj = all.get(next);
                if (obj instanceof String) {
                    String[] split = ((String) obj).split(",");
                    if (split.length == 2) {
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(0, next);
                        jSONArray2.put(1, Integer.parseInt(split[0]));
                        jSONArray2.put(2, Integer.parseInt(split[1]));
                        jSONArray.put(jSONArray2);
                    }
                }
            }
            jSONObject.put("tlc", jSONArray);
        } catch (Throwable th) {
            Logger.v((String) "Failed to attach FC to header", th);
        }
    }

    public final Logger getConfigLogger() {
        return this.config.getLogger();
    }

    public final int[] getInAppCountsFromPersistentStore(String str) {
        String string = k.getPreferences(this.context, getKeyWithDeviceId("counts_per_inapp", this.deviceId)).getString(str, null);
        if (string == null) {
            return new int[]{0, 0};
        }
        try {
            String[] split = string.split(",");
            if (split.length != 2) {
                return new int[]{0, 0};
            }
            return new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1])};
        } catch (Throwable unused) {
            return new int[]{0, 0};
        }
    }

    public final String getInAppID(CTInAppNotification cTInAppNotification) {
        String str = cTInAppNotification.id;
        if (str != null && !str.isEmpty()) {
            try {
                return cTInAppNotification.id;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public final int getIntFromPrefs(String str, int i) {
        if (!this.config.isDefaultInstance) {
            return k.getInt(this.context, storageKeyWithSuffix(str), i);
        }
        int i2 = k.getInt(this.context, storageKeyWithSuffix(str), NotificationManagerCompat.IMPORTANCE_UNSPECIFIED);
        if (i2 == -1000) {
            i2 = k.getInt(this.context, str, i);
        }
        return i2;
    }

    public final String getKeyWithDeviceId(String str, String str2) {
        return GeneratedOutlineSupport.outline52(str, ":", str2);
    }

    public final String getStringFromPrefs(String str, String str2) {
        if (!this.config.isDefaultInstance) {
            return k.getString(this.context, storageKeyWithSuffix(str), str2);
        }
        String string = k.getString(this.context, storageKeyWithSuffix(str), str2);
        if (string == null) {
            string = k.getString(this.context, str, str2);
        }
        return string;
    }

    public final void init(String str) {
        GeneratedOutlineSupport.outline101(new StringBuilder(), this.config.accountId, ":async_deviceID", getConfigLogger(), "InAppFCManager init() called");
        try {
            migrateToNewPrefsKey(str);
            String format = this.ddMMyyyy.format(new Date());
            if (!format.equals(getStringFromPrefs(getKeyWithDeviceId("ict_date", str), "20140428"))) {
                k.putString(this.context, storageKeyWithSuffix(getKeyWithDeviceId("ict_date", str)), format);
                k.putInt(this.context, storageKeyWithSuffix(getKeyWithDeviceId("istc_inapp", str)), 0);
                SharedPreferences preferences = k.getPreferences(this.context, getKeyWithDeviceId("counts_per_inapp", str));
                Editor edit = preferences.edit();
                Map<String, ?> all = preferences.getAll();
                for (String next : all.keySet()) {
                    Object obj = all.get(next);
                    if (!(obj instanceof String)) {
                        edit.remove(next);
                    } else {
                        String[] split = ((String) obj).split(",");
                        if (split.length != 2) {
                            edit.remove(next);
                        } else {
                            try {
                                edit.putString(next, "0," + split[1]);
                            } catch (Throwable th) {
                                Logger configLogger = getConfigLogger();
                                String str2 = this.config.accountId;
                                configLogger.verbose(str2, "Failed to reset todayCount for inapp " + next, th);
                            }
                        }
                    }
                }
                k.persist(edit);
            }
        } catch (Exception e2) {
            Logger configLogger2 = getConfigLogger();
            String str3 = this.config.accountId;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Failed to init inapp manager ");
            outline73.append(e2.getLocalizedMessage());
            configLogger2.verbose(str3, outline73.toString());
        }
    }

    public final void migrateToNewPrefsKey(String str) {
        if (getStringFromPrefs(storageKeyWithSuffix(getKeyWithDeviceId("ict_date", str)), null) == null && getStringFromPrefs("ict_date", null) != null) {
            Logger.v("Migrating InAppFC Prefs");
            k.putString(this.context, storageKeyWithSuffix(getKeyWithDeviceId("ict_date", str)), getStringFromPrefs("ict_date", "20140428"));
            k.putInt(this.context, storageKeyWithSuffix(getKeyWithDeviceId("istc_inapp", str)), getIntFromPrefs(storageKeyWithSuffix("istc_inapp"), 0));
            SharedPreferences preferences = k.getPreferences(this.context, "counts_per_inapp");
            Editor edit = preferences.edit();
            Editor edit2 = k.getPreferences(this.context, getKeyWithDeviceId("counts_per_inapp", str)).edit();
            Map<String, ?> all = preferences.getAll();
            for (String next : all.keySet()) {
                Object obj = all.get(next);
                if (!(obj instanceof String)) {
                    edit.remove(next);
                } else if (((String) obj).split(",").length != 2) {
                    edit.remove(next);
                } else {
                    edit2.putString(next, obj.toString());
                }
            }
            k.persist(edit2);
            edit.clear().apply();
        }
    }

    public void processResponse(Context context2, JSONObject jSONObject) {
        try {
            if (jSONObject.has("inapp_stale")) {
                JSONArray jSONArray = jSONObject.getJSONArray("inapp_stale");
                Editor edit = k.getPreferences(context2, getKeyWithDeviceId("counts_per_inapp", this.deviceId)).edit();
                for (int i = 0; i < jSONArray.length(); i++) {
                    Object obj = jSONArray.get(i);
                    if (obj instanceof Integer) {
                        edit.remove("" + obj);
                        Logger.d("Purged stale in-app - " + obj);
                    } else if (obj instanceof String) {
                        edit.remove((String) obj);
                        Logger.d("Purged stale in-app - " + obj);
                    }
                }
                k.persist(edit);
            }
        } catch (Throwable th) {
            Logger.v((String) "Failed to purge out stale targets", th);
        }
    }

    public final String storageKeyWithSuffix(String str) {
        StringBuilder outline78 = GeneratedOutlineSupport.outline78(str, ":");
        outline78.append(this.config.accountId);
        return outline78.toString();
    }
}
