package com.clevertap.android.sdk.featureFlags;

import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.BaseAnalyticsManager;
import com.clevertap.android.sdk.BaseCallbackManager;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.OnSuccessListener;
import com.clevertap.android.sdk.task.SuccessExecutable;
import com.clevertap.android.sdk.task.Task;
import com.clevertap.android.sdk.utils.FileUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import org.apache.fontbox.cmap.CMap;
import org.apache.fontbox.cmap.CMapParser;
import org.json.JSONArray;
import org.json.JSONObject;

public class CTFeatureFlagsController {
    public final CleverTapInstanceConfig config;
    public String guid;
    public boolean isInitialized = false;
    public final BaseAnalyticsManager mAnalyticsManager;
    public final BaseCallbackManager mCallbackManager;
    public FileUtils mFileUtils;
    public final Map<String, Boolean> store = Collections.synchronizedMap(new HashMap());

    public CTFeatureFlagsController(String str, CleverTapInstanceConfig cleverTapInstanceConfig, BaseCallbackManager baseCallbackManager, BaseAnalyticsManager baseAnalyticsManager, FileUtils fileUtils) {
        this.guid = str;
        this.config = cleverTapInstanceConfig;
        this.mCallbackManager = baseCallbackManager;
        this.mAnalyticsManager = baseAnalyticsManager;
        this.mFileUtils = fileUtils;
        init();
    }

    public final synchronized void archiveData(JSONObject jSONObject) {
        try {
            this.mFileUtils.writeJsonToFile(getCachedDirName(), "ff_cache.json", jSONObject);
            Logger configLogger = getConfigLogger();
            String logTag = getLogTag();
            configLogger.verbose(logTag, "Feature flags saved into file-[" + getCachedFullPath() + CMapParser.MARK_END_OF_ARRAY + this.store);
        } catch (Exception e2) {
            e2.printStackTrace();
            Logger configLogger2 = getConfigLogger();
            String logTag2 = getLogTag();
            configLogger2.verbose(logTag2, "ArchiveData failed - " + e2.getLocalizedMessage());
        }
        return;
    }

    public String getCachedDirName() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Feature_Flag_");
        outline73.append(this.config.accountId);
        outline73.append("_");
        outline73.append(this.guid);
        return outline73.toString();
    }

    public String getCachedFullPath() {
        return getCachedDirName() + "/" + "ff_cache.json";
    }

    public final Logger getConfigLogger() {
        return this.config.getLogger();
    }

    public final String getLogTag() {
        return GeneratedOutlineSupport.outline62(new StringBuilder(), this.config.accountId, "[Feature Flag]");
    }

    public void init() {
        if (!TextUtils.isEmpty(this.guid)) {
            Task ioTask = CTExecutorFactory.executors(this.config).ioTask();
            AnonymousClass2 r1 = new OnSuccessListener<Boolean>() {
                public void onSuccess(Object obj) {
                    CTFeatureFlagsController.this.isInitialized = ((Boolean) obj).booleanValue();
                }
            };
            ioTask.successExecutables.add(new SuccessExecutable(ioTask.defaultCallbackExecutor, r1));
            ioTask.executor.execute(new Runnable("initFeatureFlags", new Callable<Boolean>() {
                public Object call() throws Exception {
                    Boolean bool;
                    synchronized (this) {
                        CTFeatureFlagsController.this.getConfigLogger().verbose(CTFeatureFlagsController.this.getLogTag(), (String) "Feature flags init is called");
                        String cachedFullPath = CTFeatureFlagsController.this.getCachedFullPath();
                        try {
                            CTFeatureFlagsController.this.store.clear();
                            String readFromFile = CTFeatureFlagsController.this.mFileUtils.readFromFile(cachedFullPath);
                            if (!TextUtils.isEmpty(readFromFile)) {
                                JSONArray jSONArray = new JSONObject(readFromFile).getJSONArray("kv");
                                if (jSONArray != null && jSONArray.length() > 0) {
                                    for (int i = 0; i < jSONArray.length(); i++) {
                                        JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                                        if (jSONObject != null) {
                                            String string = jSONObject.getString("n");
                                            String string2 = jSONObject.getString("v");
                                            if (!TextUtils.isEmpty(string)) {
                                                CTFeatureFlagsController.this.store.put(string, Boolean.valueOf(Boolean.parseBoolean(string2)));
                                            }
                                        }
                                    }
                                }
                                Logger configLogger = CTFeatureFlagsController.this.getConfigLogger();
                                String logTag = CTFeatureFlagsController.this.getLogTag();
                                configLogger.verbose(logTag, "Feature flags initialized from file " + cachedFullPath + " with configs  " + CTFeatureFlagsController.this.store);
                            } else {
                                Logger configLogger2 = CTFeatureFlagsController.this.getConfigLogger();
                                String logTag2 = CTFeatureFlagsController.this.getLogTag();
                                configLogger2.verbose(logTag2, "Feature flags file is empty-" + cachedFullPath);
                            }
                            bool = Boolean.TRUE;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            Logger configLogger3 = CTFeatureFlagsController.this.getConfigLogger();
                            String logTag3 = CTFeatureFlagsController.this.getLogTag();
                            configLogger3.verbose(logTag3, "UnArchiveData failed file- " + cachedFullPath + CMap.SPACE + e2.getLocalizedMessage());
                            bool = Boolean.FALSE;
                        }
                    }
                    return bool;
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
}
