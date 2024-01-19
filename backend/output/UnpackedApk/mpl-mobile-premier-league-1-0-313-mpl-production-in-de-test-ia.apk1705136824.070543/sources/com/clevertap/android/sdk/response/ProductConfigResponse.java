package com.clevertap.android.sdk.response;

import android.content.Context;
import android.text.TextUtils;
import co.hyperverge.hypersnapsdk.c.k;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.ControllerManager;
import com.clevertap.android.sdk.CoreMetaData;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.product_config.CTProductConfigController;
import com.clevertap.android.sdk.product_config.CTProductConfigController.PROCESSING_STATE;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.Task;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

public class ProductConfigResponse extends CleverTapResponseDecorator {
    public final CleverTapResponse cleverTapResponse;
    public final CleverTapInstanceConfig config;
    public final ControllerManager controllerManager;
    public final CoreMetaData coreMetaData;
    public final Logger logger;

    public ProductConfigResponse(CleverTapResponse cleverTapResponse2, CleverTapInstanceConfig cleverTapInstanceConfig, CoreMetaData coreMetaData2, ControllerManager controllerManager2) {
        this.cleverTapResponse = cleverTapResponse2;
        this.config = cleverTapInstanceConfig;
        this.logger = cleverTapInstanceConfig.getLogger();
        this.coreMetaData = coreMetaData2;
        this.controllerManager = controllerManager2;
    }

    public final void onProductConfigFailed() {
        if (this.coreMetaData.isProductConfigRequested) {
            CTProductConfigController cTProductConfigController = this.controllerManager.ctProductConfigController;
            if (cTProductConfigController != null) {
                cTProductConfigController.isFetchAndActivating.compareAndSet(true, false);
                cTProductConfigController.config.getLogger().verbose(k.getLogTag(cTProductConfigController.config), (String) "Fetch Failed");
            }
            this.coreMetaData.isProductConfigRequested = false;
        }
    }

    public final void parseProductConfigs(JSONObject jSONObject) throws JSONException {
        if (jSONObject.getJSONArray("kv") != null) {
            CTProductConfigController cTProductConfigController = this.controllerManager.ctProductConfigController;
            if (cTProductConfigController != null) {
                if (!TextUtils.isEmpty(cTProductConfigController.settings.guid)) {
                    synchronized (cTProductConfigController) {
                        try {
                            cTProductConfigController.parseFetchedResponse(jSONObject);
                            cTProductConfigController.fileUtils.writeJsonToFile(cTProductConfigController.getProductConfigDirName(), "activated.json", new JSONObject(cTProductConfigController.waitingTobeActivatedConfig));
                            Logger logger2 = cTProductConfigController.config.getLogger();
                            String logTag = k.getLogTag(cTProductConfigController.config);
                            logger2.verbose(logTag, "Fetch file-[" + cTProductConfigController.getActivatedFullPath() + "] write success: " + cTProductConfigController.waitingTobeActivatedConfig);
                            Task mainTask = CTExecutorFactory.executors(cTProductConfigController.config).mainTask();
                            mainTask.executor.execute(new Runnable("sendPCFetchSuccessCallback", new Callable<Void>() {
                                public Object call() throws Exception {
                                    CTProductConfigController.this.config.getLogger().verbose(k.getLogTag(CTProductConfigController.this.config), (String) "Product Config: fetch Success");
                                    CTProductConfigController.this.sendCallback(PROCESSING_STATE.FETCHED);
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
                            if (cTProductConfigController.isFetchAndActivating.getAndSet(false)) {
                                cTProductConfigController.activate();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            cTProductConfigController.config.getLogger().verbose(k.getLogTag(cTProductConfigController.config), (String) "Product Config: fetch Failed");
                            cTProductConfigController.sendCallback(PROCESSING_STATE.FETCHED);
                            cTProductConfigController.isFetchAndActivating.compareAndSet(true, false);
                        }
                    }
                    return;
                }
                return;
            }
        }
        onProductConfigFailed();
    }

    public void processResponse(JSONObject jSONObject, String str, Context context) {
        this.logger.verbose(this.config.accountId, (String) "Processing Product Config response...");
        CleverTapInstanceConfig cleverTapInstanceConfig = this.config;
        if (cleverTapInstanceConfig.analyticsOnly) {
            this.logger.verbose(cleverTapInstanceConfig.accountId, (String) "CleverTap instance is configured to analytics only, not processing Product Config response");
            this.cleverTapResponse.processResponse(jSONObject, str, context);
        } else if (jSONObject == null) {
            this.logger.verbose(cleverTapInstanceConfig.accountId, (String) "Product Config : Can't parse Product Config Response, JSON response object is null");
            onProductConfigFailed();
        } else if (!jSONObject.has("pc_notifs")) {
            this.logger.verbose(this.config.accountId, (String) "Product Config : JSON object doesn't contain the Product Config key");
            onProductConfigFailed();
            this.cleverTapResponse.processResponse(jSONObject, str, context);
        } else {
            try {
                this.logger.verbose(this.config.accountId, (String) "Product Config : Processing Product Config response");
                parseProductConfigs(jSONObject.getJSONObject("pc_notifs"));
            } catch (Throwable th) {
                onProductConfigFailed();
                this.logger.verbose(this.config.accountId, "Product Config : Failed to parse Product Config response", th);
            }
            this.cleverTapResponse.processResponse(jSONObject, str, context);
        }
    }
}
