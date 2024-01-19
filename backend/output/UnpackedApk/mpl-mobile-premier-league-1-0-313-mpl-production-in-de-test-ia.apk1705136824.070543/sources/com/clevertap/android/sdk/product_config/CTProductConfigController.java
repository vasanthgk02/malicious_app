package com.clevertap.android.sdk.product_config;

import android.content.Context;
import android.text.TextUtils;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.BaseAnalyticsManager;
import com.clevertap.android.sdk.BaseCallbackManager;
import com.clevertap.android.sdk.CallbackManager;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.CoreMetaData;
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
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CTProductConfigController {
    public final Map<String, String> activatedConfigs = Collections.synchronizedMap(new HashMap());
    public final BaseCallbackManager callbackManager;
    public final CleverTapInstanceConfig config;
    public final Context context;
    public final Map<String, String> defaultConfigs = Collections.synchronizedMap(new HashMap());
    public final FileUtils fileUtils;
    public final AtomicBoolean isFetchAndActivating = new AtomicBoolean(false);
    public AtomicBoolean isInitialized = new AtomicBoolean(false);
    public final ProductConfigSettings settings;
    public final Map<String, String> waitingTobeActivatedConfig = Collections.synchronizedMap(new HashMap());

    public enum PROCESSING_STATE {
        INIT,
        FETCHED,
        ACTIVATED
    }

    public CTProductConfigController(Context context2, CleverTapInstanceConfig cleverTapInstanceConfig, BaseAnalyticsManager baseAnalyticsManager, CoreMetaData coreMetaData, BaseCallbackManager baseCallbackManager, ProductConfigSettings productConfigSettings, FileUtils fileUtils2) {
        this.context = context2;
        this.config = cleverTapInstanceConfig;
        this.callbackManager = baseCallbackManager;
        this.settings = productConfigSettings;
        this.fileUtils = fileUtils2;
        initAsync();
    }

    public static HashMap access$100(CTProductConfigController cTProductConfigController, String str) {
        if (cTProductConfigController != null) {
            HashMap hashMap = new HashMap();
            try {
                String readFromFile = cTProductConfigController.fileUtils.readFromFile(str);
                Logger logger = cTProductConfigController.config.getLogger();
                String logTag = k.getLogTag(cTProductConfigController.config);
                logger.verbose(logTag, "GetStoredValues reading file success:[ " + str + "]--[Content]" + readFromFile);
                if (!TextUtils.isEmpty(readFromFile)) {
                    try {
                        JSONObject jSONObject = new JSONObject(readFromFile);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                try {
                                    String valueOf = String.valueOf(jSONObject.get(next));
                                    if (!TextUtils.isEmpty(valueOf)) {
                                        hashMap.put(next, valueOf);
                                    }
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    Logger logger2 = cTProductConfigController.config.getLogger();
                                    String logTag2 = k.getLogTag(cTProductConfigController.config);
                                    StringBuilder outline80 = GeneratedOutlineSupport.outline80("GetStoredValues for key ", next, " while parsing json: ");
                                    outline80.append(e2.getLocalizedMessage());
                                    logger2.verbose(logTag2, outline80.toString());
                                }
                            }
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        Logger logger3 = cTProductConfigController.config.getLogger();
                        String logTag3 = k.getLogTag(cTProductConfigController.config);
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("GetStoredValues failed due to malformed json: ");
                        outline73.append(e3.getLocalizedMessage());
                        logger3.verbose(logTag3, outline73.toString());
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                Logger logger4 = cTProductConfigController.config.getLogger();
                String logTag4 = k.getLogTag(cTProductConfigController.config);
                StringBuilder outline732 = GeneratedOutlineSupport.outline73("GetStoredValues reading file failed: ");
                outline732.append(e4.getLocalizedMessage());
                logger4.verbose(logTag4, outline732.toString());
            }
            return hashMap;
        }
        throw null;
    }

    public void activate() {
        if (!TextUtils.isEmpty(this.settings.guid)) {
            Task ioTask = CTExecutorFactory.executors(this.config).ioTask();
            AnonymousClass2 r1 = new OnSuccessListener<Void>() {
                public void onSuccess(Object obj) {
                    Void voidR = (Void) obj;
                    CTProductConfigController.this.sendCallback(PROCESSING_STATE.ACTIVATED);
                }
            };
            ioTask.successExecutables.add(new SuccessExecutable(ioTask.defaultCallbackExecutor, r1));
            ioTask.executor.execute(new Runnable("activateProductConfigs", new Callable<Void>() {
                public Object call() throws Exception {
                    synchronized (this) {
                        try {
                            HashMap hashMap = new HashMap();
                            if (!CTProductConfigController.this.waitingTobeActivatedConfig.isEmpty()) {
                                hashMap.putAll(CTProductConfigController.this.waitingTobeActivatedConfig);
                                CTProductConfigController.this.waitingTobeActivatedConfig.clear();
                            } else {
                                hashMap = CTProductConfigController.access$100(CTProductConfigController.this, CTProductConfigController.this.getActivatedFullPath());
                            }
                            CTProductConfigController.this.activatedConfigs.clear();
                            if (!CTProductConfigController.this.defaultConfigs.isEmpty()) {
                                CTProductConfigController.this.activatedConfigs.putAll(CTProductConfigController.this.defaultConfigs);
                            }
                            CTProductConfigController.this.activatedConfigs.putAll(hashMap);
                            Logger logger = CTProductConfigController.this.config.getLogger();
                            String logTag = k.getLogTag(CTProductConfigController.this.config);
                            logger.verbose(logTag, "Activated successfully with configs: " + CTProductConfigController.this.activatedConfigs);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            Logger logger2 = CTProductConfigController.this.config.getLogger();
                            String logTag2 = k.getLogTag(CTProductConfigController.this.config);
                            logger2.verbose(logTag2, "Activate failed: " + e2.getLocalizedMessage());
                        }
                    }
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
    }

    public final HashMap<String, String> convertServerJsonToMap(JSONObject jSONObject) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("kv");
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                        if (jSONObject2 != null) {
                            String string = jSONObject2.getString("n");
                            String string2 = jSONObject2.getString("v");
                            if (!TextUtils.isEmpty(string)) {
                                hashMap.put(string, string2);
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        Logger logger = this.config.getLogger();
                        String logTag = k.getLogTag(this.config);
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ConvertServerJsonToMap failed: ");
                        outline73.append(e2.getLocalizedMessage());
                        logger.verbose(logTag, outline73.toString());
                    }
                }
            }
            return hashMap;
        } catch (JSONException e3) {
            e3.printStackTrace();
            Logger logger2 = this.config.getLogger();
            String logTag2 = k.getLogTag(this.config);
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("ConvertServerJsonToMap failed - ");
            outline732.append(e3.getLocalizedMessage());
            logger2.verbose(logTag2, outline732.toString());
            return hashMap;
        }
    }

    public String getActivatedFullPath() {
        return getProductConfigDirName() + "/" + "activated.json";
    }

    public String getProductConfigDirName() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Product_Config_");
        outline73.append(this.config.accountId);
        outline73.append("_");
        outline73.append(this.settings.guid);
        return outline73.toString();
    }

    public void initAsync() {
        if (!TextUtils.isEmpty(this.settings.guid)) {
            Task ioTask = CTExecutorFactory.executors(this.config).ioTask();
            AnonymousClass8 r1 = new OnSuccessListener<Boolean>() {
                public void onSuccess(Object obj) {
                    Boolean bool = (Boolean) obj;
                    CTProductConfigController.this.sendCallback(PROCESSING_STATE.INIT);
                }
            };
            ioTask.successExecutables.add(new SuccessExecutable(ioTask.defaultCallbackExecutor, r1));
            ioTask.executor.execute(new Runnable("ProductConfig#initAsync", new Callable<Boolean>() {
                public Object call() throws Exception {
                    Boolean bool;
                    synchronized (this) {
                        try {
                            if (!CTProductConfigController.this.defaultConfigs.isEmpty()) {
                                CTProductConfigController.this.activatedConfigs.putAll(CTProductConfigController.this.defaultConfigs);
                            }
                            HashMap access$100 = CTProductConfigController.access$100(CTProductConfigController.this, CTProductConfigController.this.getActivatedFullPath());
                            if (!access$100.isEmpty()) {
                                CTProductConfigController.this.waitingTobeActivatedConfig.putAll(access$100);
                            }
                            Logger logger = CTProductConfigController.this.config.getLogger();
                            String logTag = k.getLogTag(CTProductConfigController.this.config);
                            logger.verbose(logTag, "Loaded configs ready to be applied: " + CTProductConfigController.this.waitingTobeActivatedConfig);
                            CTProductConfigController.this.settings.loadSettings(CTProductConfigController.this.fileUtils);
                            CTProductConfigController.this.isInitialized.set(true);
                            bool = Boolean.TRUE;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            Logger logger2 = CTProductConfigController.this.config.getLogger();
                            String logTag2 = k.getLogTag(CTProductConfigController.this.config);
                            logger2.verbose(logTag2, "InitAsync failed - " + e2.getLocalizedMessage());
                            bool = Boolean.FALSE;
                        } catch (Throwable th) {
                            throw th;
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

    public final synchronized void parseFetchedResponse(JSONObject jSONObject) {
        HashMap<String, String> convertServerJsonToMap = convertServerJsonToMap(jSONObject);
        this.waitingTobeActivatedConfig.clear();
        this.waitingTobeActivatedConfig.putAll(convertServerJsonToMap);
        Logger logger = this.config.getLogger();
        String logTag = k.getLogTag(this.config);
        logger.verbose(logTag, "Product Config: Fetched response:" + jSONObject);
        Integer num = null;
        try {
            num = (Integer) jSONObject.get("ts");
        } catch (Exception e2) {
            e2.printStackTrace();
            Logger logger2 = this.config.getLogger();
            String logTag2 = k.getLogTag(this.config);
            logger2.verbose(logTag2, "ParseFetchedResponse failed: " + e2.getLocalizedMessage());
        }
        if (num != null) {
            ProductConfigSettings productConfigSettings = this.settings;
            long intValue = ((long) num.intValue()) * 1000;
            synchronized (productConfigSettings) {
                long lastFetchTimeStampInMillis = productConfigSettings.getLastFetchTimeStampInMillis();
                if (intValue >= 0 && lastFetchTimeStampInMillis != intValue) {
                    productConfigSettings.settingsMap.put("ts", String.valueOf(intValue));
                    productConfigSettings.updateConfigToFile();
                }
            }
        }
    }

    public final void sendCallback(PROCESSING_STATE processing_state) {
        if (processing_state != null) {
            int ordinal = processing_state.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal == 2 && ((CallbackManager) this.callbackManager) == null) {
                        throw null;
                    }
                } else if (((CallbackManager) this.callbackManager) == null) {
                    throw null;
                }
            } else if (((CallbackManager) this.callbackManager) == null) {
                throw null;
            }
        }
    }

    public void setArpValue(JSONObject jSONObject) {
        ProductConfigSettings productConfigSettings = this.settings;
        if (productConfigSettings != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    if (!TextUtils.isEmpty(next)) {
                        Object obj = jSONObject.get(next);
                        if (obj instanceof Number) {
                            int doubleValue = (int) ((Number) obj).doubleValue();
                            if ("rc_n".equalsIgnoreCase(next) || "rc_w".equalsIgnoreCase(next)) {
                                productConfigSettings.setProductConfigValuesFromARP(next, doubleValue);
                            }
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    Logger logger = productConfigSettings.config.getLogger();
                    String logTag = k.getLogTag(productConfigSettings.config);
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Product Config setARPValue failed ");
                    outline73.append(e2.getLocalizedMessage());
                    logger.verbose(logTag, outline73.toString());
                }
            }
            return;
        }
        throw null;
    }
}
