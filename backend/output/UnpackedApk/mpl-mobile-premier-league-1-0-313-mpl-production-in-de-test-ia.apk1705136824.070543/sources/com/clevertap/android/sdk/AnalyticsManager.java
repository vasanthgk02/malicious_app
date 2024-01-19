package com.clevertap.android.sdk;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.events.BaseEventQueueManager;
import com.clevertap.android.sdk.inapp.CTInAppNotification;
import com.clevertap.android.sdk.inbox.CTInboxMessage;
import com.clevertap.android.sdk.pushnotification.CTPushNotificationListener;
import com.clevertap.android.sdk.response.CleverTapResponseHelper;
import com.clevertap.android.sdk.response.DisplayUnitResponse;
import com.clevertap.android.sdk.response.InAppResponse;
import com.clevertap.android.sdk.response.InboxResponse;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.Task;
import com.clevertap.android.sdk.validation.ValidationResult;
import com.clevertap.android.sdk.validation.ValidationResultStack;
import com.clevertap.android.sdk.validation.Validator;
import com.clevertap.android.sdk.validation.Validator.RestrictedMultiValueFields;
import com.clevertap.android.sdk.validation.Validator.ValidationContext;
import com.mpl.androidapp.MPLApplicationLifeCycleCallback;
import com.mpl.androidapp.utils.Constant.EventsConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AnalyticsManager extends BaseAnalyticsManager {
    public final BaseEventQueueManager baseEventQueueManager;
    public final BaseCallbackManager callbackManager;
    public final CleverTapInstanceConfig config;
    public final Context context;
    public final ControllerManager controllerManager;
    public final CoreMetaData coreMetaData;
    public final CTLockManager ctLockManager;
    public final DeviceInfo deviceInfo;
    public final HashMap<String, Integer> installReferrerMap = new HashMap<>(8);
    public final LocalDataStore localDataStore;
    public final HashMap<String, Object> notificationIdTagMap = new HashMap<>();
    public final Object notificationMapLock = new Object();
    public final HashMap<String, Object> notificationViewedIdTagMap = new HashMap<>();
    public NumberValueType numberValueType;
    public final ValidationResultStack validationResultStack;
    public final Validator validator;

    public enum NumberValueType {
        INT_NUMBER,
        FLOAT_NUMBER,
        DOUBLE_NUMBER
    }

    public AnalyticsManager(Context context2, CleverTapInstanceConfig cleverTapInstanceConfig, BaseEventQueueManager baseEventQueueManager2, Validator validator2, ValidationResultStack validationResultStack2, CoreMetaData coreMetaData2, LocalDataStore localDataStore2, DeviceInfo deviceInfo2, BaseCallbackManager baseCallbackManager, ControllerManager controllerManager2, CTLockManager cTLockManager) {
        this.context = context2;
        this.config = cleverTapInstanceConfig;
        this.baseEventQueueManager = baseEventQueueManager2;
        this.validator = validator2;
        this.validationResultStack = validationResultStack2;
        this.coreMetaData = coreMetaData2;
        this.localDataStore = localDataStore2;
        this.deviceInfo = deviceInfo2;
        this.callbackManager = baseCallbackManager;
        this.ctLockManager = cTLockManager;
        this.controllerManager = controllerManager2;
    }

    public static void access$100(AnalyticsManager analyticsManager, ArrayList arrayList, String str, String str2) {
        String str3 = null;
        if (analyticsManager == null) {
            throw null;
        } else if (str != null) {
            if (arrayList == null || arrayList.isEmpty()) {
                analyticsManager._generateEmptyMultiValueError(str);
                return;
            }
            ValidationResult cleanObjectKey = analyticsManager.validator.cleanObjectKey(str);
            String str4 = (String) cleanObjectKey.object;
            try {
                if (RestrictedMultiValueFields.valueOf(str4) != null) {
                    ValidationResult create = k.create(523, 24, str4);
                    cleanObjectKey.errorDesc = create.errorDesc;
                    cleanObjectKey.errorCode = create.errorCode;
                    cleanObjectKey.object = null;
                }
            } catch (Throwable unused) {
            }
            if (cleanObjectKey.errorCode != 0) {
                analyticsManager.validationResultStack.pushValidationResult(cleanObjectKey);
            }
            Object obj = cleanObjectKey.object;
            if (obj != null) {
                str3 = obj.toString();
            }
            if (str3 == null || str3.isEmpty()) {
                analyticsManager.validationResultStack.pushValidationResult(k.create(523, 23, str));
                Logger logger = analyticsManager.config.getLogger();
                String str5 = analyticsManager.config.accountId;
                logger.debug(str5, "Invalid multi-value property key " + str + " profile multi value operation aborted");
                return;
            }
            try {
                analyticsManager._validateAndPushMultiValue(analyticsManager._constructExistingMultiValue(str3, str2), analyticsManager._cleanMultiValues(arrayList, str3), arrayList, str3, str2);
            } catch (Throwable th) {
                Logger logger2 = analyticsManager.config.getLogger();
                String str6 = analyticsManager.config.accountId;
                logger2.verbose(str6, "Error handling multi value operation for key " + str3, th);
            }
        }
    }

    public final JSONArray _cleanMultiValues(ArrayList<String> arrayList, String str) {
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next == null) {
                        next = "";
                    }
                    ValidationResult cleanMultiValuePropertyValue = this.validator.cleanMultiValuePropertyValue(next);
                    if (cleanMultiValuePropertyValue.errorCode != 0) {
                        this.validationResultStack.pushValidationResult(cleanMultiValuePropertyValue);
                    }
                    String obj = cleanMultiValuePropertyValue.object != null ? cleanMultiValuePropertyValue.object.toString() : null;
                    if (obj != null) {
                        if (!obj.isEmpty()) {
                            jSONArray.put(obj);
                        }
                    }
                    _generateEmptyMultiValueError(str);
                    return null;
                }
                return jSONArray;
            } catch (Throwable th) {
                Logger logger = this.config.getLogger();
                String str2 = this.config.accountId;
                logger.verbose(str2, "Error cleaning multi values for key " + str, th);
                _generateEmptyMultiValueError(str);
            }
        }
        return null;
    }

    public final JSONArray _constructExistingMultiValue(String str, String str2) {
        String str3;
        boolean equals = str2.equals("$remove");
        boolean equals2 = str2.equals("$add");
        if (!equals && !equals2) {
            return new JSONArray();
        }
        Object profileValueForKey = this.localDataStore.getProfileValueForKey(str);
        String str4 = null;
        if (profileValueForKey == null) {
            if (equals) {
                return null;
            }
            return new JSONArray();
        } else if (profileValueForKey instanceof JSONArray) {
            return (JSONArray) profileValueForKey;
        } else {
            JSONArray jSONArray = equals2 ? new JSONArray() : null;
            try {
                str3 = profileValueForKey.toString();
            } catch (Exception unused) {
                str3 = null;
            }
            if (str3 != null) {
                ValidationResult cleanMultiValuePropertyValue = this.validator.cleanMultiValuePropertyValue(str3);
                if (cleanMultiValuePropertyValue.errorCode != 0) {
                    this.validationResultStack.pushValidationResult(cleanMultiValuePropertyValue);
                }
                Object obj = cleanMultiValuePropertyValue.object;
                if (obj != null) {
                    str4 = obj.toString();
                }
                str3 = str4;
            }
            if (str3 != null) {
                jSONArray = new JSONArray().put(str3);
            }
            return jSONArray;
        }
    }

    public final void _constructIncrementDecrementValues(Number number, String str, String str2) {
        if (!(str == null || number == null)) {
            try {
                ValidationResult cleanObjectKey = this.validator.cleanObjectKey(str);
                String obj = cleanObjectKey.object.toString();
                if (obj.isEmpty()) {
                    ValidationResult create = k.create(512, 2, obj);
                    this.validationResultStack.pushValidationResult(create);
                    this.config.getLogger().debug(this.config.accountId, create.errorDesc);
                    return;
                }
                if (number.intValue() >= 0 && number.doubleValue() >= 0.0d) {
                    if (number.floatValue() >= 0.0f) {
                        if (cleanObjectKey.errorCode != 0) {
                            this.validationResultStack.pushValidationResult(cleanObjectKey);
                        }
                        this.localDataStore.setProfileField(obj, _handleIncrementDecrementValues(obj, number, str2), Boolean.FALSE, true);
                        this.baseEventQueueManager.pushBasicProfile(new JSONObject().put(obj, new JSONObject().put(str2, number)), false);
                    }
                }
                ValidationResult create2 = k.create(512, 25, obj);
                this.validationResultStack.pushValidationResult(create2);
                this.config.getLogger().debug(this.config.accountId, create2.errorDesc);
            } catch (Throwable th) {
                Logger logger = this.config.getLogger();
                String str3 = this.config.accountId;
                logger.verbose(str3, "Failed to update profile value for key " + str, th);
            }
        }
    }

    public void _generateEmptyMultiValueError(String str) {
        ValidationResult create = k.create(512, 1, str);
        this.validationResultStack.pushValidationResult(create);
        this.config.getLogger().debug(this.config.accountId, create.errorDesc);
    }

    public final Number _handleIncrementDecrementValues(String str, Number number, String str2) {
        Number number2 = (Number) this.localDataStore.getProfileValueForKey(str);
        Number number3 = null;
        if (number2 == null) {
            int ordinal = getNumberValueType(number).ordinal();
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (str2.equals("$incr")) {
                        number3 = Integer.valueOf(number.intValue());
                    } else if (str2.equals("$decr")) {
                        number3 = Integer.valueOf(-number.intValue());
                    }
                } else if (str2.equals("$incr")) {
                    number3 = Double.valueOf(number.doubleValue());
                } else if (str2.equals("$decr")) {
                    number3 = Double.valueOf(-number.doubleValue());
                }
            } else if (str2.equals("$incr")) {
                number3 = Float.valueOf(number.floatValue());
            } else if (str2.equals("$decr")) {
                number3 = Float.valueOf(-number.floatValue());
            }
            return number3;
        }
        int ordinal2 = getNumberValueType(number2).ordinal();
        if (ordinal2 != 1) {
            if (ordinal2 != 2) {
                if (str2.equals("$incr")) {
                    number3 = Integer.valueOf(number.intValue() + number2.intValue());
                } else if (str2.equals("$decr")) {
                    number3 = Integer.valueOf(number2.intValue() - number.intValue());
                }
            } else if (str2.equals("$incr")) {
                number3 = Double.valueOf(number.doubleValue() + number2.doubleValue());
            } else if (str2.equals("$decr")) {
                number3 = Double.valueOf(number2.doubleValue() - number.doubleValue());
            }
        } else if (str2.equals("$incr")) {
            number3 = Float.valueOf(number.floatValue() + number2.floatValue());
        } else if (str2.equals("$decr")) {
            number3 = Float.valueOf(number2.floatValue() - number.floatValue());
        }
        return number3;
    }

    public final void _validateAndPushMultiValue(JSONArray jSONArray, JSONArray jSONArray2, ArrayList<String> arrayList, String str, String str2) {
        if (jSONArray != null && jSONArray2 != null && str != null) {
            try {
                ValidationResult mergeMultiValuePropertyForKey = this.validator.mergeMultiValuePropertyForKey(jSONArray, jSONArray2, str2.equals("$remove") ? "multiValuePropertyRemoveValues" : "multiValuePropertyAddValues", str);
                if (mergeMultiValuePropertyForKey.errorCode != 0) {
                    this.validationResultStack.pushValidationResult(mergeMultiValuePropertyForKey);
                }
                JSONArray jSONArray3 = (JSONArray) mergeMultiValuePropertyForKey.object;
                if (jSONArray3 != null) {
                    if (jSONArray3.length() > 0) {
                        this.localDataStore.setProfileField(str, jSONArray3, Boolean.FALSE, true);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(str2, new JSONArray(arrayList));
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(str, jSONObject);
                        this.baseEventQueueManager.pushBasicProfile(jSONObject2, false);
                        Logger logger = this.config.getLogger();
                        String str3 = this.config.accountId;
                        logger.verbose(str3, "Constructed multi-value profile push: " + jSONObject2.toString());
                    }
                }
                this.localDataStore.removeProfileField(str, Boolean.FALSE, true);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(str2, new JSONArray(arrayList));
                JSONObject jSONObject22 = new JSONObject();
                jSONObject22.put(str, jSONObject3);
                this.baseEventQueueManager.pushBasicProfile(jSONObject22, false);
                Logger logger2 = this.config.getLogger();
                String str32 = this.config.accountId;
                logger2.verbose(str32, "Constructed multi-value profile push: " + jSONObject22.toString());
            } catch (Throwable th) {
                Logger logger3 = this.config.getLogger();
                String str4 = this.config.accountId;
                logger3.verbose(str4, "Error pushing multiValue for key " + str, th);
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean checkDuplicateNotificationIds(android.os.Bundle r9, java.util.HashMap<java.lang.String, java.lang.Object> r10, int r11) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.notificationMapLock
            monitor-enter(r0)
            r1 = 0
            java.lang.String r2 = "wzrk_id"
            java.lang.String r9 = r9.getString(r2)     // Catch:{ all -> 0x002e }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x002e }
            boolean r4 = r10.containsKey(r9)     // Catch:{ all -> 0x002e }
            if (r4 == 0) goto L_0x0027
            java.lang.Object r4 = r10.get(r9)     // Catch:{ all -> 0x002e }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ all -> 0x002e }
            long r4 = r4.longValue()     // Catch:{ all -> 0x002e }
            long r4 = r2 - r4
            long r6 = (long) r11     // Catch:{ all -> 0x002e }
            int r11 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r11 >= 0) goto L_0x0027
            r11 = 1
            r1 = 1
        L_0x0027:
            java.lang.Long r11 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x002e }
            r10.put(r9, r11)     // Catch:{ all -> 0x002e }
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return r1
        L_0x0030:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.AnalyticsManager.checkDuplicateNotificationIds(android.os.Bundle, java.util.HashMap, int):boolean");
    }

    public void fetchFeatureFlags() {
        if (!this.config.analyticsOnly) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("t", 1);
                jSONObject.put("evtName", "wzrk_fetch");
                jSONObject.put("evtData", jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.baseEventQueueManager.queueEvent(this.context, jSONObject, 7);
        }
    }

    public final NumberValueType getNumberValueType(Number number) {
        if (number.equals(Integer.valueOf(number.intValue()))) {
            this.numberValueType = NumberValueType.INT_NUMBER;
        } else if (number.equals(Double.valueOf(number.doubleValue()))) {
            this.numberValueType = NumberValueType.DOUBLE_NUMBER;
        } else if (number.equals(Float.valueOf(number.floatValue()))) {
            this.numberValueType = NumberValueType.FLOAT_NUMBER;
        }
        return this.numberValueType;
    }

    public void pushAppLaunchedEvent() {
        if (this.config.disableAppLaunchedEvent) {
            this.coreMetaData.setAppLaunchPushed(true);
            this.config.getLogger().debug(this.config.accountId, "App Launched Events disabled in the Android Manifest file");
        } else if (this.coreMetaData.isAppLaunchPushed()) {
            this.config.getLogger().verbose(this.config.accountId, (String) "App Launched has already been triggered. Will not trigger it ");
        } else {
            this.config.getLogger().verbose(this.config.accountId, (String) "Firing App Launched event");
            this.coreMetaData.setAppLaunchPushed(true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("evtName", "App Launched");
                jSONObject.put("evtData", this.deviceInfo.getAppLaunchedFields());
            } catch (Throwable unused) {
            }
            this.baseEventQueueManager.queueEvent(this.context, jSONObject, 4);
        }
    }

    public synchronized void pushDeepLink(Uri uri, boolean z) {
        if (uri != null) {
            JSONObject urchinFromUri = k.getUrchinFromUri(uri);
            if (urchinFromUri.has("us")) {
                CoreMetaData coreMetaData2 = this.coreMetaData;
                String obj = urchinFromUri.get("us").toString();
                synchronized (coreMetaData2) {
                    if (coreMetaData2.source == null) {
                        coreMetaData2.source = obj;
                    }
                    try {
                    } catch (Throwable th) {
                        this.config.getLogger().verbose(this.config.accountId, "Failed to push deep link", th);
                    }
                }
            }
            if (urchinFromUri.has("um")) {
                CoreMetaData coreMetaData3 = this.coreMetaData;
                String obj2 = urchinFromUri.get("um").toString();
                synchronized (coreMetaData3) {
                    if (coreMetaData3.medium == null) {
                        coreMetaData3.medium = obj2;
                    }
                }
            }
            if (urchinFromUri.has("uc")) {
                CoreMetaData coreMetaData4 = this.coreMetaData;
                String obj3 = urchinFromUri.get("uc").toString();
                synchronized (coreMetaData4) {
                    if (coreMetaData4.campaign == null) {
                        coreMetaData4.campaign = obj3;
                    }
                }
            }
            urchinFromUri.put("referrer", uri.toString());
            if (z) {
                urchinFromUri.put("install", true);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                if (urchinFromUri.length() > 0) {
                    Iterator<String> keys = urchinFromUri.keys();
                    while (keys.hasNext()) {
                        try {
                            String next = keys.next();
                            jSONObject.put(next, urchinFromUri.getString(next));
                        } catch (ClassCastException unused) {
                        }
                    }
                }
                this.baseEventQueueManager.queueEvent(this.context, jSONObject, 1);
            } catch (Throwable unused2) {
            }
        } else {
            return;
        }
        return;
    }

    public void pushInAppNotificationStateEvent(boolean z, CTInAppNotification cTInAppNotification, Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = cTInAppNotification.jsonDescription;
            Iterator<String> keys = jSONObject3.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.startsWith("wzrk_")) {
                    jSONObject2.put(next, jSONObject3.get(next));
                }
            }
            if (bundle != null) {
                for (String str : bundle.keySet()) {
                    Object obj = bundle.get(str);
                    if (obj != null) {
                        jSONObject2.put(str, obj);
                    }
                }
            }
            if (z) {
                try {
                    this.coreMetaData.setWzrkParams(jSONObject2);
                } catch (Throwable unused) {
                }
                jSONObject.put("evtName", "Notification Clicked");
            } else {
                jSONObject.put("evtName", "Notification Viewed");
            }
            jSONObject.put("evtData", jSONObject2);
            this.baseEventQueueManager.queueEvent(this.context, jSONObject, 4);
        } catch (Throwable unused2) {
        }
    }

    public void pushInboxMessageStateEvent(boolean z, CTInboxMessage cTInboxMessage, Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject wzrkParams = cTInboxMessage.getWzrkParams();
            if (bundle != null) {
                for (String str : bundle.keySet()) {
                    Object obj = bundle.get(str);
                    if (obj != null) {
                        wzrkParams.put(str, obj);
                    }
                }
            }
            if (z) {
                try {
                    this.coreMetaData.setWzrkParams(wzrkParams);
                } catch (Throwable unused) {
                }
                jSONObject.put("evtName", "Notification Clicked");
            } else {
                jSONObject.put("evtName", "Notification Viewed");
            }
            jSONObject.put("evtData", wzrkParams);
            this.baseEventQueueManager.queueEvent(this.context, jSONObject, 4);
        } catch (Throwable unused2) {
        }
    }

    public void pushInstallReferrer(String str) {
        try {
            Logger logger = this.config.getLogger();
            String str2 = this.config.accountId;
            logger.verbose(str2, "Referrer received: " + str);
            if (str != null) {
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (!this.installReferrerMap.containsKey(str) || currentTimeMillis - this.installReferrerMap.get(str).intValue() >= 10) {
                    this.installReferrerMap.put(str, Integer.valueOf(currentTimeMillis));
                    pushDeepLink(Uri.parse("wzrk://track?install=true&" + str), true);
                    return;
                }
                this.config.getLogger().verbose(this.config.accountId, (String) "Skipping install referrer due to duplicate within 10 seconds");
            }
        } catch (Throwable unused) {
        }
    }

    public void pushNotificationClickedEvent(final Bundle bundle) {
        String str;
        Object obj;
        CleverTapInstanceConfig cleverTapInstanceConfig = this.config;
        if (cleverTapInstanceConfig.analyticsOnly) {
            cleverTapInstanceConfig.getLogger().debug(this.config.accountId, "is Analytics Only - will not process Notification Clicked event.");
        } else if (bundle == null || bundle.isEmpty() || bundle.get("wzrk_pn") == null) {
            Logger logger = this.config.getLogger();
            String str2 = this.config.accountId;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Push notification: ");
            if (bundle == null) {
                str = "NULL";
            } else {
                str = bundle.toString();
            }
            outline73.append(str);
            outline73.append(" not from CleverTap - will not process Notification Clicked event.");
            logger.debug(str2, outline73.toString());
        } else {
            try {
                obj = bundle.getString(MPLApplicationLifeCycleCallback.WZRK_ACCT_ID_KEY);
            } catch (Throwable unused) {
                obj = null;
            }
            if (!((obj == null && this.config.isDefaultInstance) || this.config.accountId.equals(obj))) {
                this.config.getLogger().debug(this.config.accountId, "Push notification not targeted at this instance, not processing Notification Clicked Event");
            } else if (bundle.containsKey("wzrk_inapp")) {
                Task postAsyncSafelyTask = CTExecutorFactory.executors(this.config).postAsyncSafelyTask();
                postAsyncSafelyTask.executor.execute(new Runnable("testInappNotification", new Callable<Void>() {
                    public Object call() throws Exception {
                        try {
                            Logger.v("Received in-app via push payload: " + bundle.getString("wzrk_inapp"));
                            JSONObject jSONObject = new JSONObject();
                            JSONArray jSONArray = new JSONArray();
                            jSONObject.put("inapp_notifs", jSONArray);
                            jSONArray.put(new JSONObject(bundle.getString("wzrk_inapp")));
                            new InAppResponse(new CleverTapResponseHelper(), AnalyticsManager.this.config, AnalyticsManager.this.controllerManager, true).processResponse(jSONObject, null, AnalyticsManager.this.context);
                        } catch (Throwable th) {
                            Logger.v((String) "Failed to display inapp notification from push notification payload", th);
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
            } else if (bundle.containsKey("wzrk_inbox")) {
                Task postAsyncSafelyTask2 = CTExecutorFactory.executors(this.config).postAsyncSafelyTask();
                postAsyncSafelyTask2.executor.execute(new Runnable("testInboxNotification", new Callable<Void>() {
                    public Object call() throws Exception {
                        try {
                            Logger.v("Received inbox via push payload: " + bundle.getString("wzrk_inbox"));
                            JSONObject jSONObject = new JSONObject();
                            JSONArray jSONArray = new JSONArray();
                            jSONObject.put("inbox_notifs", jSONArray);
                            JSONObject jSONObject2 = new JSONObject(bundle.getString("wzrk_inbox"));
                            jSONObject2.put("_id", String.valueOf(System.currentTimeMillis() / 1000));
                            jSONArray.put(jSONObject2);
                            InboxResponse inboxResponse = new InboxResponse(new CleverTapResponseHelper(), AnalyticsManager.this.config, AnalyticsManager.this.ctLockManager, AnalyticsManager.this.callbackManager, AnalyticsManager.this.controllerManager);
                            inboxResponse.processResponse(jSONObject, null, AnalyticsManager.this.context);
                        } catch (Throwable th) {
                            Logger.v((String) "Failed to process inbox message from push notification payload", th);
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
            } else if (bundle.containsKey("wzrk_adunit")) {
                try {
                    new DisplayUnitResponse(new CleverTapResponseHelper(), this.config, this.callbackManager, this.controllerManager).processResponse(k.displayUnitFromExtras(bundle), null, this.context);
                } catch (Throwable th) {
                    Logger.v((String) "Failed to process Display Unit from push notification payload", th);
                }
            } else if (!bundle.containsKey("wzrk_id") || bundle.getString("wzrk_id") == null) {
                Logger logger2 = this.config.getLogger();
                String str3 = this.config.accountId;
                StringBuilder outline732 = GeneratedOutlineSupport.outline73("Push notification ID Tag is null, not processing Notification Clicked event for:  ");
                outline732.append(bundle.toString());
                logger2.debug(str3, outline732.toString());
            } else if (checkDuplicateNotificationIds(bundle, this.notificationIdTagMap, 5000)) {
                Logger logger3 = this.config.getLogger();
                String str4 = this.config.accountId;
                StringBuilder outline733 = GeneratedOutlineSupport.outline73("Already processed Notification Clicked event for ");
                outline733.append(bundle.toString());
                outline733.append(", dropping duplicate.");
                logger3.debug(str4, outline733.toString());
            } else {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    for (String str5 : bundle.keySet()) {
                        if (str5.startsWith("wzrk_")) {
                            jSONObject2.put(str5, bundle.get(str5));
                        }
                    }
                    jSONObject.put("evtName", "Notification Clicked");
                    jSONObject.put("evtData", jSONObject2);
                    this.baseEventQueueManager.queueEvent(this.context, jSONObject, 4);
                    this.coreMetaData.setWzrkParams(k.getWzrkFields(bundle));
                } catch (Throwable unused2) {
                }
                CTPushNotificationListener cTPushNotificationListener = ((CallbackManager) this.callbackManager).pushNotificationListener;
                if (cTPushNotificationListener != null) {
                    cTPushNotificationListener.onNotificationClickedPayloadReceived(Utils.convertBundleObjectToHashMap(bundle));
                } else {
                    Logger.d("CTPushNotificationListener is not set");
                }
            }
        }
    }

    public void pushNotificationViewedEvent(Bundle bundle) {
        String str;
        if (bundle == null || bundle.isEmpty() || bundle.get("wzrk_pn") == null) {
            Logger logger = this.config.getLogger();
            String str2 = this.config.accountId;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Push notification: ");
            if (bundle == null) {
                str = "NULL";
            } else {
                str = bundle.toString();
            }
            outline73.append(str);
            outline73.append(" not from CleverTap - will not process Notification Viewed event.");
            logger.debug(str2, outline73.toString());
        } else if (!bundle.containsKey("wzrk_id") || bundle.getString("wzrk_id") == null) {
            Logger logger2 = this.config.getLogger();
            String str3 = this.config.accountId;
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Push notification ID Tag is null, not processing Notification Viewed event for:  ");
            outline732.append(bundle.toString());
            logger2.debug(str3, outline732.toString());
        } else if (checkDuplicateNotificationIds(bundle, this.notificationViewedIdTagMap, 2000)) {
            Logger logger3 = this.config.getLogger();
            String str4 = this.config.accountId;
            StringBuilder outline733 = GeneratedOutlineSupport.outline73("Already processed Notification Viewed event for ");
            outline733.append(bundle.toString());
            outline733.append(", dropping duplicate.");
            logger3.debug(str4, outline733.toString());
        } else {
            Logger logger4 = this.config.getLogger();
            StringBuilder outline734 = GeneratedOutlineSupport.outline73("Recording Notification Viewed event for notification:  ");
            outline734.append(bundle.toString());
            logger4.debug(outline734.toString());
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject wzrkFields = k.getWzrkFields(bundle);
                jSONObject.put("evtName", "Notification Viewed");
                jSONObject.put("evtData", wzrkFields);
            } catch (Throwable unused) {
            }
            this.coreMetaData.lastNotificationId = bundle.getString("wzrk_pid");
            this.baseEventQueueManager.queueEvent(this.context, jSONObject, 6);
        }
    }

    public void pushProfile(final Map<String, Object> map) {
        if (map != null && !map.isEmpty()) {
            Task postAsyncSafelyTask = CTExecutorFactory.executors(this.config).postAsyncSafelyTask();
            postAsyncSafelyTask.executor.execute(new Runnable("profilePush", new Callable<Void>() {
                public Object call() throws Exception {
                    AnalyticsManager analyticsManager = AnalyticsManager.this;
                    Map map = map;
                    if (analyticsManager != null) {
                        if (map != null && !map.isEmpty()) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                JSONObject jSONObject2 = new JSONObject();
                                for (String str : map.keySet()) {
                                    Object obj = map.get(str);
                                    ValidationResult cleanObjectKey = analyticsManager.validator.cleanObjectKey(str);
                                    String obj2 = cleanObjectKey.object.toString();
                                    if (cleanObjectKey.errorCode != 0) {
                                        analyticsManager.validationResultStack.pushValidationResult(cleanObjectKey);
                                    }
                                    if (obj2.isEmpty()) {
                                        ValidationResult create = k.create(512, 2, new String[0]);
                                        analyticsManager.validationResultStack.pushValidationResult(create);
                                        analyticsManager.config.getLogger().debug(analyticsManager.config.accountId, create.errorDesc);
                                    } else {
                                        try {
                                            ValidationResult cleanObjectValue = analyticsManager.validator.cleanObjectValue(obj, ValidationContext.Profile);
                                            Object obj3 = cleanObjectValue.object;
                                            if (cleanObjectValue.errorCode != 0) {
                                                analyticsManager.validationResultStack.pushValidationResult(cleanObjectValue);
                                            }
                                            if (obj2.equalsIgnoreCase(EventsConstants.USER_PHONE_CLEVER_TAP)) {
                                                String obj4 = obj3.toString();
                                                String countryCode = analyticsManager.deviceInfo.getCountryCode();
                                                if ((countryCode == null || countryCode.isEmpty()) && !obj4.startsWith(MqttTopic.SINGLE_LEVEL_WILDCARD)) {
                                                    ValidationResult create2 = k.create(512, 4, obj4);
                                                    analyticsManager.validationResultStack.pushValidationResult(create2);
                                                    analyticsManager.config.getLogger().debug(analyticsManager.config.accountId, create2.errorDesc);
                                                }
                                                Logger logger = analyticsManager.config.getLogger();
                                                String str2 = analyticsManager.config.accountId;
                                                StringBuilder sb = new StringBuilder();
                                                sb.append("Profile phone is: ");
                                                sb.append(obj4);
                                                sb.append(" device country code is: ");
                                                if (countryCode == null) {
                                                    countryCode = "null";
                                                }
                                                sb.append(countryCode);
                                                logger.verbose(str2, sb.toString());
                                                obj3 = obj4;
                                            }
                                            jSONObject2.put(obj2, obj3);
                                            jSONObject.put(obj2, obj3);
                                        } catch (Throwable unused) {
                                            String[] strArr = new String[2];
                                            strArr[0] = obj != null ? obj.toString() : "";
                                            strArr[1] = obj2;
                                            ValidationResult create3 = k.create(512, 3, strArr);
                                            analyticsManager.validationResultStack.pushValidationResult(create3);
                                            analyticsManager.config.getLogger().debug(analyticsManager.config.accountId, create3.errorDesc);
                                        }
                                    }
                                }
                                Logger logger2 = analyticsManager.config.getLogger();
                                String str3 = analyticsManager.config.accountId;
                                logger2.verbose(str3, "Constructed custom profile: " + jSONObject.toString());
                                if (jSONObject2.length() > 0) {
                                    analyticsManager.localDataStore.setProfileFields(jSONObject2, Boolean.FALSE);
                                }
                                analyticsManager.baseEventQueueManager.pushBasicProfile(jSONObject, false);
                            } catch (Exception e2) {
                                analyticsManager.validationResultStack.pushValidationResult(k.create(512, 5, new String[0]));
                                Logger logger3 = analyticsManager.config.getLogger();
                                String str4 = analyticsManager.config.accountId;
                                logger3.debug(str4, "Invalid phone number: " + e2.getLocalizedMessage());
                            } catch (Throwable th) {
                                analyticsManager.config.getLogger().verbose(analyticsManager.config.accountId, "Failed to push profile", th);
                            }
                        }
                        return null;
                    }
                    throw null;
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

    public synchronized void pushInstallReferrer(String str, String str2, String str3) {
        if (str != null || str2 != null || str3 != null) {
            try {
                if (k.getInt(this.context, "app_install_status", 0) != 0) {
                    Logger.d("Install referrer has already been set. Will not override it");
                    return;
                }
                k.putInt(this.context, "app_install_status", 1);
                if (str != null) {
                    str = Uri.encode(str);
                }
                if (str2 != null) {
                    str2 = Uri.encode(str2);
                }
                if (str3 != null) {
                    str3 = Uri.encode(str3);
                }
                String str4 = "wzrk://track?install=true";
                if (str != null) {
                    str4 = str4 + "&utm_source=" + str;
                }
                if (str2 != null) {
                    str4 = str4 + "&utm_medium=" + str2;
                }
                if (str3 != null) {
                    str4 = str4 + "&utm_campaign=" + str3;
                }
                pushDeepLink(Uri.parse(str4), true);
            } catch (Throwable th) {
                Logger.v((String) "Failed to push install referrer", th);
            }
        } else {
            return;
        }
        return;
    }
}
