package com.clevertap.android.sdk.response;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import co.hyperverge.hypersnapsdk.c.k;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.ControllerManager;
import com.clevertap.android.sdk.InAppFCManager;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.Task;
import java.util.concurrent.Callable;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InAppResponse extends CleverTapResponseDecorator {
    public final CleverTapResponse cleverTapResponse;
    public final CleverTapInstanceConfig config;
    public final ControllerManager controllerManager;
    public final boolean isSendTest;
    public final Logger logger;

    public InAppResponse(CleverTapResponse cleverTapResponse2, CleverTapInstanceConfig cleverTapInstanceConfig, ControllerManager controllerManager2, boolean z) {
        this.cleverTapResponse = cleverTapResponse2;
        this.config = cleverTapInstanceConfig;
        this.logger = cleverTapInstanceConfig.getLogger();
        this.controllerManager = controllerManager2;
        this.isSendTest = z;
    }

    public void processResponse(JSONObject jSONObject, String str, final Context context) {
        try {
            if (this.config.analyticsOnly) {
                this.logger.verbose(this.config.accountId, (String) "CleverTap instance is configured to analytics only, not processing inapp messages");
                this.cleverTapResponse.processResponse(jSONObject, str, context);
                return;
            }
            this.logger.verbose(this.config.accountId, (String) "InApp: Processing response");
            if (!jSONObject.has("inapp_notifs")) {
                this.logger.verbose(this.config.accountId, (String) "InApp: Response JSON object doesn't contain the inapp key, failing");
                this.cleverTapResponse.processResponse(jSONObject, str, context);
                return;
            }
            int i = 10;
            int i2 = (!jSONObject.has("imc") || !(jSONObject.get("imc") instanceof Integer)) ? 10 : jSONObject.getInt("imc");
            if (jSONObject.has("imp") && (jSONObject.get("imp") instanceof Integer)) {
                i = jSONObject.getInt("imp");
            }
            if (this.isSendTest || this.controllerManager.inAppFCManager == null) {
                this.logger.verbose(this.config.accountId, (String) "controllerManager.getInAppFCManager() is NULL, not Updating InAppFC Limits");
            } else {
                Logger.v("Updating InAppFC Limits");
                InAppFCManager inAppFCManager = this.controllerManager.inAppFCManager;
                synchronized (inAppFCManager) {
                    k.putInt(context, inAppFCManager.storageKeyWithSuffix(inAppFCManager.getKeyWithDeviceId("istmcd_inapp", inAppFCManager.deviceId)), i);
                    k.putInt(context, inAppFCManager.storageKeyWithSuffix(inAppFCManager.getKeyWithDeviceId("imc", inAppFCManager.deviceId)), i2);
                }
                this.controllerManager.inAppFCManager.processResponse(context, jSONObject);
            }
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("inapp_notifs");
                Editor edit = k.getPreferences(context).edit();
                try {
                    JSONArray jSONArray2 = new JSONArray(k.getStringFromPrefs(context, this.config, "inApp", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI));
                    if (jSONArray != null && jSONArray.length() > 0) {
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            jSONArray2.put(jSONArray.getJSONObject(i3));
                        }
                    }
                    edit.putString(k.storageKeyWithSuffix(this.config, "inApp"), jSONArray2.toString());
                    k.persist(edit);
                } catch (JSONException unused) {
                    Logger.v("InAppManager: Malformed inapp notification");
                } catch (Throwable th) {
                    this.logger.verbose(this.config.accountId, (String) "InApp: Failed to parse the in-app notifications properly");
                    Logger logger2 = this.logger;
                    String str2 = this.config.accountId;
                    logger2.verbose(str2, "InAppManager: Reason: " + th.getMessage(), th);
                }
                Task postAsyncSafelyTask = CTExecutorFactory.executors(this.config).postAsyncSafelyTask("TAG_FEATURE_IN_APPS");
                postAsyncSafelyTask.executor.execute(new Runnable("InAppResponse#processResponse", new Callable<Void>() {
                    public Object call() throws Exception {
                        InAppResponse.this.controllerManager.inAppController.showNotificationIfAvailable(context);
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
                this.cleverTapResponse.processResponse(jSONObject, str, context);
            } catch (JSONException unused2) {
                this.logger.debug(this.config.accountId, "InApp: In-app key didn't contain a valid JSON array");
                this.cleverTapResponse.processResponse(jSONObject, str, context);
            }
        } catch (Throwable th2) {
            Logger.v((String) "InAppManager: Failed to parse response", th2);
        }
    }
}
