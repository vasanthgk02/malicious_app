package com.clevertap.android.sdk.product_config;

import android.text.TextUtils;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.OnSuccessListener;
import com.clevertap.android.sdk.task.SuccessExecutable;
import com.clevertap.android.sdk.task.Task;
import com.clevertap.android.sdk.utils.FileUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

public class ProductConfigSettings {
    public final CleverTapInstanceConfig config;
    public final FileUtils fileUtils;
    public String guid;
    public final Map<String, String> settingsMap = Collections.synchronizedMap(new HashMap());

    public ProductConfigSettings(String str, CleverTapInstanceConfig cleverTapInstanceConfig, FileUtils fileUtils2) {
        this.guid = str;
        this.config = cleverTapInstanceConfig;
        this.fileUtils = fileUtils2;
        initDefaults();
    }

    public String getDirName() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Product_Config_");
        outline73.append(this.config.accountId);
        outline73.append("_");
        outline73.append(this.guid);
        return outline73.toString();
    }

    public String getFullPath() {
        return getDirName() + "/" + "config_settings.json";
    }

    public JSONObject getJsonObject(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str);
            } catch (JSONException e2) {
                e2.printStackTrace();
                Logger logger = this.config.getLogger();
                String logTag = k.getLogTag(this.config);
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("LoadSettings failed: ");
                outline73.append(e2.getLocalizedMessage());
                logger.verbose(logTag, outline73.toString());
            }
        }
        return null;
    }

    public synchronized long getLastFetchTimeStampInMillis() {
        long j;
        j = 0;
        String str = this.settingsMap.get("ts");
        try {
            if (!TextUtils.isEmpty(str)) {
                j = (long) Double.parseDouble(str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Logger logger = this.config.getLogger();
            String logTag = k.getLogTag(this.config);
            logger.verbose(logTag, "GetLastFetchTimeStampInMillis failed: " + e2.getLocalizedMessage());
        }
        return j;
    }

    public final synchronized int getNoOfCallsInAllowedWindow() {
        int i;
        i = 5;
        String str = this.settingsMap.get("rc_n");
        try {
            if (!TextUtils.isEmpty(str)) {
                i = (int) Double.parseDouble(str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Logger logger = this.config.getLogger();
            String logTag = k.getLogTag(this.config);
            logger.verbose(logTag, "GetNoOfCallsInAllowedWindow failed: " + e2.getLocalizedMessage());
        }
        return i;
    }

    public final synchronized int getWindowIntervalInMinutes() {
        int i;
        i = 60;
        String str = this.settingsMap.get("rc_w");
        try {
            if (!TextUtils.isEmpty(str)) {
                i = (int) Double.parseDouble(str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Logger logger = this.config.getLogger();
            String logTag = k.getLogTag(this.config);
            logger.verbose(logTag, "GetWindowIntervalInMinutes failed: " + e2.getLocalizedMessage());
        }
        return i;
    }

    public void initDefaults() {
        this.settingsMap.put("rc_n", String.valueOf(5));
        this.settingsMap.put("rc_w", String.valueOf(60));
        this.settingsMap.put("ts", String.valueOf(0));
        this.settingsMap.put("fetch_min_interval_seconds", String.valueOf(CTProductConfigConstants.DEFAULT_MIN_FETCH_INTERVAL_SECONDS));
        Logger logger = this.config.getLogger();
        String logTag = k.getLogTag(this.config);
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Settings loaded with default values: ");
        outline73.append(this.settingsMap);
        logger.verbose(logTag, outline73.toString());
    }

    public synchronized void loadSettings(FileUtils fileUtils2) {
        if (fileUtils2 != null) {
            try {
                populateMapWithJson(getJsonObject(fileUtils2.readFromFile(getFullPath())));
            } catch (Exception e2) {
                e2.printStackTrace();
                Logger logger = this.config.getLogger();
                String logTag = k.getLogTag(this.config);
                logger.verbose(logTag, "LoadSettings failed while reading file: " + e2.getLocalizedMessage());
            }
        } else {
            throw new IllegalArgumentException("fileutils can't be null");
        }
        return;
    }

    public synchronized void populateMapWithJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    try {
                        String valueOf = String.valueOf(jSONObject.get(next));
                        if (!TextUtils.isEmpty(valueOf)) {
                            this.settingsMap.put(next, valueOf);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        Logger logger = this.config.getLogger();
                        String logTag = k.getLogTag(this.config);
                        logger.verbose(logTag, "Failed loading setting for key " + next + " Error: " + e2.getLocalizedMessage());
                    }
                }
            }
            Logger logger2 = this.config.getLogger();
            String logTag2 = k.getLogTag(this.config);
            logger2.verbose(logTag2, "LoadSettings completed with settings: " + this.settingsMap);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setProductConfigValuesFromARP(java.lang.String r5, int r6) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = 3494368(0x3551e0, float:4.896653E-39)
            r2 = 1
            if (r0 == r1) goto L_0x001a
            r1 = 3494377(0x3551e9, float:4.896665E-39)
            if (r0 == r1) goto L_0x0010
            goto L_0x0024
        L_0x0010:
            java.lang.String r0 = "rc_w"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0024
            r5 = 1
            goto L_0x0025
        L_0x001a:
            java.lang.String r0 = "rc_n"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0024
            r5 = 0
            goto L_0x0025
        L_0x0024:
            r5 = -1
        L_0x0025:
            if (r5 == 0) goto L_0x0046
            if (r5 == r2) goto L_0x002a
            goto L_0x0062
        L_0x002a:
            monitor-enter(r4)
            int r5 = r4.getWindowIntervalInMinutes()     // Catch:{ all -> 0x0043 }
            if (r6 <= 0) goto L_0x0041
            if (r5 == r6) goto L_0x0041
            java.util.Map<java.lang.String, java.lang.String> r5 = r4.settingsMap     // Catch:{ all -> 0x0043 }
            java.lang.String r0 = "rc_w"
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0043 }
            r5.put(r0, r6)     // Catch:{ all -> 0x0043 }
            r4.updateConfigToFile()     // Catch:{ all -> 0x0043 }
        L_0x0041:
            monitor-exit(r4)
            goto L_0x0062
        L_0x0043:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        L_0x0046:
            monitor-enter(r4)
            int r5 = r4.getNoOfCallsInAllowedWindow()     // Catch:{ all -> 0x0063 }
            long r0 = (long) r5     // Catch:{ all -> 0x0063 }
            if (r6 <= 0) goto L_0x0061
            long r2 = (long) r6     // Catch:{ all -> 0x0063 }
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x0061
            java.util.Map<java.lang.String, java.lang.String> r5 = r4.settingsMap     // Catch:{ all -> 0x0063 }
            java.lang.String r0 = "rc_n"
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0063 }
            r5.put(r0, r6)     // Catch:{ all -> 0x0063 }
            r4.updateConfigToFile()     // Catch:{ all -> 0x0063 }
        L_0x0061:
            monitor-exit(r4)
        L_0x0062:
            return
        L_0x0063:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.product_config.ProductConfigSettings.setProductConfigValuesFromARP(java.lang.String, int):void");
    }

    public final synchronized void updateConfigToFile() {
        Task ioTask = CTExecutorFactory.executors(this.config).ioTask();
        AnonymousClass3 r1 = new OnSuccessListener<Boolean>() {
            public void onSuccess(Object obj) {
                if (((Boolean) obj).booleanValue()) {
                    Logger logger = ProductConfigSettings.this.config.getLogger();
                    String logTag = k.getLogTag(ProductConfigSettings.this.config);
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Product Config settings: writing Success ");
                    outline73.append(ProductConfigSettings.this.settingsMap);
                    logger.verbose(logTag, outline73.toString());
                    return;
                }
                ProductConfigSettings.this.config.getLogger().verbose(k.getLogTag(ProductConfigSettings.this.config), (String) "Product Config settings: writing Failed");
            }
        };
        ioTask.successExecutables.add(new SuccessExecutable(ioTask.defaultCallbackExecutor, r1));
        ioTask.executor.execute(new Runnable("ProductConfigSettings#updateConfigToFile", new Callable<Boolean>() {
            public Object call() throws Exception {
                try {
                    HashMap hashMap = new HashMap(ProductConfigSettings.this.settingsMap);
                    hashMap.remove("fetch_min_interval_seconds");
                    ProductConfigSettings.this.fileUtils.writeJsonToFile(ProductConfigSettings.this.getDirName(), "config_settings.json", new JSONObject(hashMap));
                    return Boolean.TRUE;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    Logger logger = ProductConfigSettings.this.config.getLogger();
                    String logTag = k.getLogTag(ProductConfigSettings.this.config);
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("UpdateConfigToFile failed: ");
                    outline73.append(e2.getLocalizedMessage());
                    logger.verbose(logTag, outline73.toString());
                    return Boolean.FALSE;
                }
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
}
