package com.mpl.androidapp.updater.repo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.Promise;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.google.gson.Gson;
import com.mpl.androidapp.DownloadActivity;
import com.mpl.androidapp.EventPublishHelper;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.appsanity.APIHealthChecker;
import com.mpl.androidapp.appsanity.APIHealthCheckerImpl;
import com.mpl.androidapp.appsanity.APPSanityModel;
import com.mpl.androidapp.config.ConfigConstant;
import com.mpl.androidapp.config.ConfigHelper;
import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.deviceinfo.DeviceInfo;
import com.mpl.androidapp.okhttp3.MemoryLruCache;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.react.modules.NetworkModule;
import com.mpl.androidapp.updater.util.ResponseUtil;
import com.mpl.androidapp.updater.util.StatusType;
import com.mpl.androidapp.updater.util.UpdaterConstant;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.Constant.ApiEndPoints;
import com.mpl.androidapp.utils.Constant.EventsConstants;
import com.mpl.androidapp.utils.IPAddressConversion;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.androidapp.utils.NetworkCallParams;
import com.mpl.androidapp.utils.NetworkUtils;
import com.mpl.androidapp.utils.Util;
import com.mpl.network.modules.MClient;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.network.modules.listeners.IResponseListener;
import com.mpl.network.modules.request.MOKHttpPostRequest;
import com.mpl.network.modules.request.MOkHttpGetRequest.Builder;
import com.mpl.network.modules.request.RequestPriority;
import com.mpl.network.modules.utils.MException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadHelper {
    public static DownloadHelper INSTANCE = null;
    public static final String TAG = "DownloadHelper";
    public static ArrayList<String> mylist = new ArrayList<>();

    /* access modifiers changed from: private */
    public void addCertificatePinning(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = new JSONArray(jSONObject.optString("security.network.certificates"));
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                String string = jSONObject2.getString("domain");
                JSONArray jSONArray2 = jSONObject2.getJSONArray("signatures");
                String[] strArr = new String[jSONArray2.length()];
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    strArr[i2] = (String) jSONArray2.get(i2);
                }
                linkedHashMap.put(string, strArr);
            }
            MClient.createAddMultipleCertificatePinners(linkedHashMap);
        } catch (JSONException e2) {
            MLogger.e(TAG, "addCertificatePinning: ", e2);
        }
    }

    /* access modifiers changed from: private */
    public void addPasswordForPreferences(Context context, JSONObject jSONObject) {
        MemoryLruCache.setPreferencesPassword(context.getApplicationContext(), jSONObject.optString(ConfigConstant.ROOT_MASK));
    }

    public static DownloadHelper getInstance() {
        DownloadHelper downloadHelper;
        DownloadHelper downloadHelper2 = INSTANCE;
        if (downloadHelper2 != null) {
            return downloadHelper2;
        }
        synchronized (DownloadHelper.class) {
            try {
                downloadHelper = new DownloadHelper();
                INSTANCE = downloadHelper;
            }
        }
        return downloadHelper;
    }

    /* access modifiers changed from: private */
    public void getUpdaterV2Config(Context context, JSONObject jSONObject) {
        boolean updaterV2Enabled = MSharedPreferencesUtils.getUpdaterV2Enabled();
        MLogger.d(TAG, "getUpdaterV2Config called ", "Is Updater V2 Enabled: ", Boolean.valueOf(updaterV2Enabled));
        if (!updaterV2Enabled) {
            MLogger.d(TAG, "getUpdaterV2Config: Updater V2 is not Enabled");
            summaryResponseFail();
        } else if (!jSONObject.has(ConfigConstant.UPDATER_V2_CONFIG) || jSONObject.optJSONObject(ConfigConstant.UPDATER_V2_CONFIG) == null) {
            summaryResponseFail();
        } else {
            boolean optBoolean = jSONObject.optJSONObject(ConfigConstant.UPDATER_V2_CONFIG).optBoolean(ConfigConstant.AVAILABLE_V2);
            MSharedPreferencesUtils.setUpdateCriticalInUpdaterV2(jSONObject.optJSONObject(ConfigConstant.UPDATER_V2_CONFIG).optBoolean("critical"));
            HashMap hashMap = new HashMap();
            hashMap.put(EventsConstants.IS_MANUAL, Boolean.FALSE);
            hashMap.put("Entry Point", "Splash Screen");
            hashMap.put(EventsConstants.CURRENT_VERSION, Integer.valueOf(MBuildConfigUtils.getInstalledAppVersionCode()));
            hashMap.put(EventsConstants.UPDATER_VERSION, Integer.valueOf(2));
            CleverTapAnalyticsUtils.sendEvent((String) EventsConstants.APP_UPDATE_CHECKED, hashMap);
            MLogger.d(TAG, "getUpdaterV2Config available " + optBoolean);
            if (optBoolean) {
                MSharedPreferencesUtils.setEntryPoint("Splash Screen");
                getUpdateSummary(new ResponseListener() {
                    public void onFailure(String str) {
                        if (!TextUtils.isEmpty(str)) {
                            MLogger.d(DownloadHelper.TAG, "Failure", str);
                            return;
                        }
                        MLogger.d(DownloadHelper.TAG, "Failure");
                    }

                    public void onSuccess(String str) {
                        MLogger.d(DownloadHelper.TAG, "Success ");
                        HashMap hashMap = new HashMap();
                        hashMap.put(EventsConstants.IS_CRITICAL, Boolean.valueOf(MSharedPreferencesUtils.isUpdateCriticalInUpdaterV2()));
                        hashMap.put(EventsConstants.UPDATE_VERSION, Integer.valueOf(MSharedPreferencesUtils.getUpdater2Version()));
                        hashMap.put(EventsConstants.DOWNLOAD_URL, MSharedPreferencesUtils.getApkUrl());
                        hashMap.put(EventsConstants.IS_SKIPPABLE, Boolean.valueOf(MSharedPreferencesUtils.canSkipPopup()));
                        hashMap.put("Entry Point", "Splash Screen");
                        hashMap.put(EventsConstants.ELIGIBILITY_CRITERIA, MSharedPreferencesUtils.getEligibilityCriteria());
                        hashMap.put(EventsConstants.UPDATER_VERSION, Integer.valueOf(2));
                        CleverTapAnalyticsUtils.sendEvent((String) "App Update Available", hashMap);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void processConfigResponse(Context context, StatusType statusType, JSONObject jSONObject, String str, boolean z) {
        MLogger.d(TAG, "processConfigResponse: ");
        Util.changeToMilliSecond();
        String stringPref = MSharedPreferencesUtils.getStringPref("isProAppDownloadRequired", BaseParser.FALSE, true);
        if (!TextUtils.isEmpty(stringPref) && Boolean.parseBoolean(stringPref)) {
            Intent intent = new Intent(context, DownloadActivity.class);
            intent.putExtra("configData", jSONObject.toString());
            context.startActivity(intent);
        } else if (!str.equals("LIVE")) {
            EventPublishHelper.publishInitialStatusEvent(context, StatusType.ROOT_STATUS);
        } else if (!ConfigHelper.getInstance().isApiMocked(jSONObject)) {
            EventPublishHelper.publishInitialStatusEvent(context, StatusType.INSTALLED_APK_INTEGRITY_FAIL);
        } else if (MBuildConfigUtils.getInstalledAppVersionCode() < MSharedPreferencesUtils.getRootMinVersion()) {
            EventPublishHelper.publishInitialStatusEvent(context, StatusType.MIN_ROOT_VERSION_FAILED);
        } else {
            MLogger.d(Constant.LOADING_TAG, TAG, "processConfigResponse: ", Boolean.valueOf(z));
            if (z) {
                String accessUserToken = MSharedPreferencesUtils.getAccessUserToken();
                MLogger.d(TAG, "processConfigResponse: ", accessUserToken);
                if (TextUtils.isEmpty(accessUserToken)) {
                    EventPublishHelper.publishInitialStatusEvent(context, StatusType.PROCEED);
                    return;
                }
                processPostLoginCall(context, StatusType.CHECKING_UPDATE, jSONObject, null, accessUserToken);
                return;
            }
            ResponseUtil.parseResponse(context, statusType);
        }
    }

    private void processPostLoginCall(Context context, StatusType statusType, JSONObject jSONObject, Promise promise, String str) {
        MLogger.d(TAG, "processPostLoginCall start ");
        checkUpdateAvailable(context, statusType, true, promise, false);
    }

    /* access modifiers changed from: private */
    public void processPreLoginConfig(Context context, JSONObject jSONObject, StatusType statusType, IResponseListener<String> iResponseListener) {
        Context context2 = context;
        JSONObject jSONObject2 = jSONObject;
        StatusType statusType2 = statusType;
        IResponseListener<String> iResponseListener2 = iResponseListener;
        MLogger.d(TAG, "processConfig: ");
        if (jSONObject2 == null || jSONObject2.optJSONObject("status") == null || jSONObject2.optJSONObject("payload") == null) {
            MLogger.d(TAG, UpdaterConstant.FAILURE);
            if (statusType2 != StatusType.BACKGROUND_API_CALL) {
                EventPublishHelper.publishInitialStatusEvent(context, StatusType.GENERIC_CONNECTION_ERROR);
            } else if (iResponseListener2 != null) {
                iResponseListener2.onResponseFail(new MException((String) "Config call fail"));
            }
        } else if (jSONObject2.optJSONObject("status").optInt("code") == 200) {
            JSONObject optJSONObject = jSONObject2.optJSONObject("payload").optJSONObject("config");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString(ConfigConstant.ROOT_STATUS, "LIVE");
                if (optJSONObject.has(Constant.IP_TO_ADDRESS_CONV_ENABLED)) {
                    ConfigManager.setIpToAddressConvEnabled(optJSONObject.optBoolean(Constant.IP_TO_ADDRESS_CONV_ENABLED));
                }
                addCertificatePinning(optJSONObject);
                addPasswordForPreferences(context, optJSONObject);
                JSONObject optJSONObject2 = jSONObject2.optJSONObject("payload").optJSONObject(ConfigConstant.PLATFORM_CONFIG);
                MSharedPreferencesUtils.saveBooleanInNormalPref(context, Constant.IS_FIRST_CONFIG_CALL_SUCCESS, true);
                if (optJSONObject2 != null) {
                    ConfigManager.setConfig(optJSONObject, optJSONObject2, false);
                } else {
                    ConfigManager.setConfig(optJSONObject);
                }
                if (statusType2 != StatusType.BACKGROUND_API_CALL) {
                    processConfigResponse(context, statusType, optJSONObject, optString, true);
                } else if (iResponseListener2 != null) {
                    iResponseListener2.onResponseSuccess("Success");
                }
            } else {
                MLogger.d(TAG, UpdaterConstant.FAILURE, jSONObject2);
                if (statusType2 != StatusType.BACKGROUND_API_CALL) {
                    EventPublishHelper.publishInitialStatusEvent(context, StatusType.GENERIC_CONNECTION_ERROR);
                } else if (iResponseListener2 != null) {
                    iResponseListener2.onResponseFail(new MException((String) "Config call fail"));
                }
            }
        } else {
            MLogger.d(TAG, UpdaterConstant.FAILURE, jSONObject2);
            if (statusType2 != StatusType.BACKGROUND_API_CALL) {
                EventPublishHelper.publishInitialStatusEvent(context, StatusType.GENERIC_CONNECTION_ERROR);
            } else if (iResponseListener2 != null) {
                iResponseListener2.onResponseFail(new MException((String) "Config call fail"));
            }
        }
    }

    /* access modifiers changed from: private */
    public void sendFailureStatusToEventPublisher(Context context) {
        try {
            if (new DeviceInfo(context).isInternetAvailable(context)) {
                EventPublishHelper.publishInitialStatusEvent(context, StatusType.GENERIC_CONNECTION_ERROR);
            } else {
                EventPublishHelper.publishInitialStatusEvent(context, StatusType.INTERNET_ABSENT);
            }
        } catch (Exception e2) {
            MLogger.e(TAG, GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("sendFailureStatusToEventPublisher :")));
        }
    }

    /* access modifiers changed from: private */
    public void showLogoutAuthorize() {
        MLogger.d(TAG, "User Logged out from MPL");
        DownloadProgressReceiver downloadProgressReceiver = MPLReactContainerActivity.resultReceiver;
        if (downloadProgressReceiver != null) {
            downloadProgressReceiver.send(17, null);
        }
    }

    /* access modifiers changed from: private */
    public void summaryResponseFail() {
        MSharedPreferencesUtils.setSkipPopup(false);
        MSharedPreferencesUtils.setUpdater2Version(MBuildConfigUtils.getInstalledAppVersionCode());
        MSharedPreferencesUtils.setUpdateAvailableInUpdaterV2(false);
        MSharedPreferencesUtils.setShowPopup(false);
        MSharedPreferencesUtils.setApkUrl("");
        MSharedPreferencesUtils.setUpdateSha("");
        MSharedPreferencesUtils.setEligibilityCriteria("");
        MSharedPreferencesUtils.setReleaseNotesV2("{}");
        MSharedPreferencesUtils.setReleasePoints("");
    }

    public void checkCTFilterEvent(final Context context) {
        try {
            System.currentTimeMillis();
            List<MHeader> commonHeaders = CommonUtils.getCommonHeaders();
            Builder requestPriority = new Builder().setRequestPriority(RequestPriority.HIGH);
            MClient.executeAsync(requestPriority.setUrl(MBuildConfigUtils.getMainUrl() + "/ct/events").setConnectTimeout(10000).setReadTimeout(10000).setWriteTimeout(10000).setPingInterval(10000).setHeaders(commonHeaders).setRetryOnConnectionFailure(true).setResponseListener(new IResponseListener<JSONObject>() {
                public void onProcessHeader(ArrayList<MHeader> arrayList) {
                }

                public void onResponseFail(Exception exc) {
                }

                public void progressResponse(long j, long j2, boolean z) {
                }

                public void onResponseSuccess(JSONObject jSONObject) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(jSONObject.optString("payload"));
                        MSharedPreferencesUtils.saveStringInNormalPref(context, "ctEventFilteringEnabled", jSONObject2.optString("ctEventFilteringEnabled"));
                        JSONArray jSONArray = new JSONArray(jSONObject2.optString("filteredCTEvents"));
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            String optString = jSONArray.optString(i);
                            if (!TextUtils.isEmpty(optString)) {
                                DownloadHelper.mylist.add(optString.toLowerCase());
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }).build());
        } catch (Exception unused) {
        }
    }

    public void checkUpdateAvailable(Context context, StatusType statusType, boolean z, Promise promise, boolean z2) {
        MLogger.d(TAG, "checkUpdateAvailable:isPostLogin ", Boolean.valueOf(z));
        if (z && ConfigManager.isIpToAddressConvEnabled()) {
            IPAddressConversion.INSTANCE.getIPLocation();
        }
        if (TextUtils.isEmpty(MemoryLruCache.getDeviceIdForPreferences(context.getApplicationContext()))) {
            MemoryLruCache.setDeviceIdForPreferences(context.getApplicationContext());
        }
        final long currentTimeMillis = System.currentTimeMillis();
        List<MHeader> commonHeaders = CommonUtils.getCommonHeaders();
        if (z) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Bearer ");
            outline73.append(MSharedPreferencesUtils.getAccessUserToken());
            commonHeaders.add(new MHeader("Authorization", outline73.toString()));
        }
        String str = z ? ConfigConstant.CONFIG_POST_LOGIN : ConfigConstant.CONFIG_URL;
        final APIHealthCheckerImpl aPIHealthCheckerImpl = new APIHealthCheckerImpl();
        final APPSanityModel initAppSanity = aPIHealthCheckerImpl.initAppSanity(str);
        MOKHttpPostRequest.Builder tag = new MOKHttpPostRequest.Builder().setRequestPriority(RequestPriority.HIGH).setUrl(str).setConnectTimeout(10000).setReadTimeout(10000).setWriteTimeout(10000).setPingInterval(10000).setHeaders(commonHeaders).setRetryOnConnectionFailure(true).setPostJsonObject(ConfigManager.getJSONBody(context).toString()).setTag(ConfigConstant.CONFIG_REQUEST_TAG);
        final Promise promise2 = promise;
        final Context context2 = context;
        final boolean z3 = z2;
        final StatusType statusType2 = statusType;
        AnonymousClass2 r3 = new IResponseListener<JSONObject>() {
            public void onProcessHeader(ArrayList<MHeader> arrayList) {
                try {
                    if (statusType2 != StatusType.BACKGROUND_API_CALL && arrayList != null && arrayList.size() > 0) {
                        Iterator<MHeader> it = arrayList.iterator();
                        while (it.hasNext()) {
                            MHeader next = it.next();
                            MLogger.d(IResponseListener.TAG, "onProcessHeader: " + next.toString());
                            if (next.getKey().equalsIgnoreCase("x-mpl-downtime") && CommonUtils.isJSONValid(next.getValue())) {
                                JSONObject jSONObject = new JSONObject(next.getValue());
                                MLogger.d(IResponseListener.TAG, jSONObject.optString("title", ""));
                                MLogger.d(IResponseListener.TAG, jSONObject.optString("message", ""));
                                Bundle bundle = new Bundle();
                                bundle.putString("title", jSONObject.optString("title", ""));
                                bundle.putString("message", jSONObject.optString("message", ""));
                                if (MPLReactContainerActivity.resultReceiver != null) {
                                    MPLReactContainerActivity.resultReceiver.send(15, bundle);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                } catch (Exception e2) {
                    MLogger.e(IResponseListener.TAG, "onProcessHeader: ", e2);
                }
            }

            public void onResponseFail(Exception exc) {
                MLogger.d(IResponseListener.TAG, UpdaterConstant.FAILURE);
                APIHealthChecker aPIHealthChecker = aPIHealthCheckerImpl;
                if (aPIHealthChecker != null) {
                    aPIHealthChecker.setEndAppSanityParams(initAppSanity);
                }
                Promise promise = promise2;
                if (promise != null) {
                    if (exc != null) {
                        try {
                            if (exc instanceof MException) {
                                MException mException = (MException) exc;
                                promise2.reject(String.valueOf(mException.getErrorCode()), mException.getMessage());
                            } else {
                                promise.reject(String.valueOf(1000), exc.toString());
                            }
                        } catch (Exception unused) {
                            MLogger.e(IResponseListener.TAG, "onResponseFail: ");
                            promise2.reject(String.valueOf(1000), (String) "Error in Fetching Response");
                        }
                    } else {
                        promise.reject(String.valueOf(1000), (String) "Error in Fetching Response");
                    }
                }
                try {
                    if (exc instanceof MException) {
                        MException mException2 = (MException) exc;
                        String message = mException2.getMessage();
                        DownloadHelper.this.processHeader(mException2.getHeaders());
                        if (!TextUtils.isEmpty(message) && CommonUtils.isJSONValid(message)) {
                            JSONObject optJSONObject = new JSONObject(message).optJSONObject("status");
                            if (context2 != null && optJSONObject != null && optJSONObject.has("code") && optJSONObject.optInt("code") == 401) {
                                DownloadHelper.this.showLogoutAuthorize();
                            }
                        }
                    }
                } catch (Exception unused2) {
                }
                if (statusType2 != StatusType.BACKGROUND_API_CALL) {
                    DownloadHelper.this.sendFailureStatusToEventPublisher(context2);
                }
                APIHealthChecker aPIHealthChecker2 = aPIHealthCheckerImpl;
                if (aPIHealthChecker2 != null) {
                    aPIHealthChecker2.processAPIHealthStatusFromFailedResponse(initAppSanity, exc);
                }
            }

            public void progressResponse(long j, long j2, boolean z) {
            }

            public void onResponseSuccess(JSONObject jSONObject) {
                Promise promise = promise2;
                if (promise != null) {
                    promise.resolve(jSONObject.toString());
                }
                APIHealthChecker aPIHealthChecker = aPIHealthCheckerImpl;
                if (aPIHealthChecker != null) {
                    aPIHealthChecker.setEndAppSanityParams(initAppSanity);
                }
                if (jSONObject == null || jSONObject.optJSONObject("status") == null || jSONObject.optJSONObject("payload") == null) {
                    MLogger.d(IResponseListener.TAG, UpdaterConstant.FAILURE);
                    if (statusType2 != StatusType.BACKGROUND_API_CALL) {
                        EventPublishHelper.publishInitialStatusEvent(context2, StatusType.GENERIC_CONNECTION_ERROR);
                    }
                } else if (jSONObject.optJSONObject("status").optInt("code") == 200) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("payload").optJSONObject("config");
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("payload").optJSONObject(ConfigConstant.PLATFORM_CONFIG);
                    if (jSONObject.optJSONObject("payload").has("state")) {
                        ConfigManager.setState(jSONObject.optJSONObject("payload").optString("state"));
                    }
                    DownloadHelper.this.addCertificatePinning(optJSONObject);
                    DownloadHelper.this.addPasswordForPreferences(context2, optJSONObject);
                    String optString = optJSONObject.optString(ConfigConstant.ROOT_STATUS, "LIVE");
                    ConfigManager.setConfig(optJSONObject, optJSONObject2, z3);
                    DownloadHelper.this.getUpdaterV2Config(context2, optJSONObject);
                    StatusType statusType = statusType2;
                    if (statusType != StatusType.BACKGROUND_API_CALL) {
                        DownloadHelper.this.processConfigResponse(context2, statusType, optJSONObject, optString, false);
                        MLogger.d(Constant.LOADING_TAG, "onResponseSuccess:time taken in checking all condition before launching react from config requested ", IResponseListener.TAG, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    }
                } else {
                    MLogger.d(IResponseListener.TAG, UpdaterConstant.FAILURE, jSONObject);
                    if (statusType2 != StatusType.BACKGROUND_API_CALL) {
                        EventPublishHelper.publishInitialStatusEvent(context2, StatusType.GENERIC_CONNECTION_ERROR);
                    }
                }
                if (jSONObject != null) {
                    NetworkModule.processResponse(null, jSONObject.toString());
                    APIHealthChecker aPIHealthChecker2 = aPIHealthCheckerImpl;
                    if (aPIHealthChecker2 != null) {
                        aPIHealthChecker2.processAPIHealthStatusFromSuccessFullResponse(initAppSanity, jSONObject.toString());
                    }
                }
            }
        };
        MClient.executeAsync(tag.setResponseListener(r3).build());
    }

    public void getDownloadUrl(String str, String str2, final ResponseListener responseListener) {
        try {
            String accessUserToken = MSharedPreferencesUtils.getAccessUserToken();
            final APIHealthCheckerImpl aPIHealthCheckerImpl = new APIHealthCheckerImpl();
            final APPSanityModel initAppSanity = aPIHealthCheckerImpl.initAppSanity(str);
            Builder tag = new Builder().setUrl(str).setTag(str2);
            MClient.executeAsync(tag.addHeader(new MHeader("Authorization", "Bearer " + accessUserToken)).setHeaders(CommonUtils.getCommonHeaders()).setRequestPriority(RequestPriority.HIGH).setRetryOnConnectionFailure(true).setResponseListener(new IResponseListener<String>() {
                public void onResponseFail(Exception exc) {
                    MLogger.e(IResponseListener.TAG, "GEInteractor", "onResponseFail: apk download url", exc);
                    APIHealthChecker aPIHealthChecker = aPIHealthCheckerImpl;
                    if (aPIHealthChecker != null) {
                        aPIHealthChecker.setEndAppSanityParams(initAppSanity);
                    }
                    responseListener.onFailure(UpdaterConstant.FAILURE);
                    APIHealthChecker aPIHealthChecker2 = aPIHealthCheckerImpl;
                    if (aPIHealthChecker2 != null) {
                        aPIHealthChecker2.processAPIHealthStatusFromFailedResponse(initAppSanity, exc);
                    }
                }

                public void progressResponse(long j, long j2, boolean z) {
                }

                public void onResponseSuccess(String str) {
                    APIHealthChecker aPIHealthChecker = aPIHealthCheckerImpl;
                    if (aPIHealthChecker != null) {
                        aPIHealthChecker.setEndAppSanityParams(initAppSanity);
                    }
                    responseListener.onSuccess(str);
                    NetworkModule.processResponse(null, str);
                    APIHealthChecker aPIHealthChecker2 = aPIHealthCheckerImpl;
                    if (aPIHealthChecker2 != null) {
                        aPIHealthChecker2.processAPIHealthStatusFromSuccessFullResponse(initAppSanity, str);
                    }
                }
            }).build());
        } catch (Exception e2) {
            if (!TextUtils.isEmpty(e2.getMessage())) {
                MLogger.e(TAG, "getDownloadUrl: ", e2.getMessage());
            }
        }
    }

    public void getUpdateSummary(final ResponseListener responseListener) {
        MLogger.d("UpdateNetworkCall", "@@@ Update Summary Called ");
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new MHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE));
            arrayList.add(new MHeader("Authorization", "Bearer " + MSharedPreferencesUtils.getAccessUserToken()));
            IdentityHashMap identityHashMap = new IdentityHashMap();
            identityHashMap.put("type", "APK");
            identityHashMap.put("version", String.valueOf(MBuildConfigUtils.getInstalledAppVersionCode()));
            identityHashMap.put("subversion", "1");
            MLogger.d(TAG, "UpdateNetworkCall", "@@@ Update version " + MBuildConfigUtils.getInstalledAppVersionCode());
            NetworkCallParams.Builder builder = new NetworkCallParams.Builder();
            NetworkUtils.doGetRequest(builder.setUrl(MBuildConfigUtils.getMainUrl() + ApiEndPoints.UPDATES_V2_SUMMARY).setMQueryParams(identityHashMap).setMHeaders(arrayList).build(), new IResponseListener<String>() {
                public void onResponseFail(Exception exc) {
                    DownloadHelper.this.summaryResponseFail();
                    responseListener.onFailure(exc.getLocalizedMessage());
                    MLogger.d(IResponseListener.TAG, GeneratedOutlineSupport.outline39(exc, GeneratedOutlineSupport.outline73("@@@ Update Summary fail")));
                }

                public void progressResponse(long j, long j2, boolean z) {
                    MLogger.d(IResponseListener.TAG, GeneratedOutlineSupport.outline45("@@@ Update Summary progress ", j2));
                }

                public void onResponseSuccess(String str) {
                    MLogger.d(IResponseListener.TAG, GeneratedOutlineSupport.outline50("@@@ Update Summary ", str));
                    if (str != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.optJSONObject("status") == null || jSONObject.optJSONObject("status").optInt("code") != 200) {
                                MLogger.d(IResponseListener.TAG, "@@@ Update Summary fail3");
                                DownloadHelper.this.summaryResponseFail();
                                responseListener.onFailure("no_update_found");
                                return;
                            }
                            CheckUpdateResponse checkUpdateResponse = (CheckUpdateResponse) new Gson().fromJson(str, CheckUpdateResponse.class);
                            if (checkUpdateResponse.getPayload() != null) {
                                MSharedPreferencesUtils.setSkipPopup(checkUpdateResponse.getPayload().getCanSkipPopup().booleanValue());
                                MSharedPreferencesUtils.setUpdater2Version(checkUpdateResponse.getPayload().getUpdate().getVersion().intValue());
                                MSharedPreferencesUtils.setUpdateAvailableInUpdaterV2(checkUpdateResponse.getPayload().getUpdateAvailable().booleanValue());
                                MSharedPreferencesUtils.setShowPopup(checkUpdateResponse.getPayload().getShowPopup().booleanValue());
                                MSharedPreferencesUtils.setApkUrl(checkUpdateResponse.getPayload().getUpdate().getBinary().getUrl());
                                MSharedPreferencesUtils.setUpdateSha(checkUpdateResponse.getPayload().getUpdate().getBinary().getSha());
                                MSharedPreferencesUtils.setEligibilityCriteria(checkUpdateResponse.getPayload().getEligibilityCriteria());
                                String json = new Gson().toJson((Object) checkUpdateResponse.getPayload().getUpdate().getReleaseNotes());
                                MSharedPreferencesUtils.setReleaseNotesV2(json);
                                if (!TextUtils.isEmpty(json)) {
                                    MSharedPreferencesUtils.saveStringInNormalPref(MPLApplication.getInstance(), Response.RELEASE_NOTES, json);
                                }
                                responseListener.onSuccess(str);
                                if (checkUpdateResponse.getPayload().getUpdate().getReleaseNotes() != null && checkUpdateResponse.getPayload().getUpdate().getReleaseNotes().getReleasePoints() != null && !checkUpdateResponse.getPayload().getUpdate().getReleaseNotes().getReleasePoints().isEmpty()) {
                                    MSharedPreferencesUtils.setReleasePoints(new Gson().toJson((Object) checkUpdateResponse.getPayload().getUpdate().getReleaseNotes().getReleasePoints()));
                                }
                            }
                        } catch (JSONException e2) {
                            StringBuilder outline73 = GeneratedOutlineSupport.outline73("@@@ Update Summary fail");
                            outline73.append(e2.getLocalizedMessage());
                            MLogger.d(IResponseListener.TAG, outline73.toString());
                            DownloadHelper.this.summaryResponseFail();
                            responseListener.onFailure(e2.getLocalizedMessage());
                        }
                    } else {
                        DownloadHelper.this.summaryResponseFail();
                        responseListener.onFailure("no_update_found");
                    }
                }
            }, "updateV2_summary");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void preLoginCall(final Context context, final StatusType statusType) {
        MLogger.d(TAG, "preLoginCall: ");
        if (TextUtils.isEmpty(MemoryLruCache.getDeviceIdForPreferences(context.getApplicationContext()))) {
            MemoryLruCache.setDeviceIdForPreferences(context.getApplicationContext());
        }
        final ArrayList arrayList = new ArrayList();
        arrayList.add(new MHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE));
        NetworkUtils.doGetRequest(new NetworkCallParams.Builder().setPriority(0).setUrl(ConfigManager.getConfigUrl()).setConnectionTimeOut(10000).setWriteTimeOut(10000).setReadTimeOut(10000).setMHeaders(arrayList).setRetryOption(true).build(), new IResponseListener<String>() {
            public void onResponseFail(Exception exc) {
                MLogger.d(IResponseListener.TAG, UpdaterConstant.FAILURE);
                if (statusType != StatusType.BACKGROUND_API_CALL) {
                    DownloadHelper.this.sendFailureStatusToEventPublisher(context);
                }
            }

            public void progressResponse(long j, long j2, boolean z) {
                try {
                    if (statusType != StatusType.BACKGROUND_API_CALL && arrayList != null && arrayList.size() > 0) {
                        for (MHeader mHeader : arrayList) {
                            MLogger.d(IResponseListener.TAG, "onProcessHeader: " + mHeader.toString());
                            if (mHeader.getKey().equalsIgnoreCase("x-mpl-downtime") && CommonUtils.isJSONValid(mHeader.getValue())) {
                                JSONObject jSONObject = new JSONObject(mHeader.getValue());
                                MLogger.d(IResponseListener.TAG, jSONObject.optString("title", ""));
                                MLogger.d(IResponseListener.TAG, jSONObject.optString("message", ""));
                                Bundle bundle = new Bundle();
                                bundle.putString("title", jSONObject.optString("title", ""));
                                bundle.putString("message", jSONObject.optString("message", ""));
                                if (MPLReactContainerActivity.resultReceiver != null) {
                                    MPLReactContainerActivity.resultReceiver.send(15, bundle);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                } catch (Exception e2) {
                    MLogger.e(IResponseListener.TAG, "onProcessHeader: ", e2);
                }
            }

            public void onResponseSuccess(String str) {
                try {
                    DownloadHelper.this.processPreLoginConfig(context, new JSONObject(str), statusType, null);
                } catch (Exception e2) {
                    MLogger.e(IResponseListener.TAG, "onResponseSuccess: ", e2);
                    if (statusType != StatusType.BACKGROUND_API_CALL) {
                        EventPublishHelper.publishInitialStatusEvent(context, StatusType.GENERIC_CONNECTION_ERROR);
                    }
                }
            }
        }, "config_call_v2");
    }

    public void preLoginCallWithListener(Context context, StatusType statusType, IResponseListener<String> iResponseListener) {
        MLogger.d(TAG, "preLoginCallWithListener: ");
        if (TextUtils.isEmpty(MemoryLruCache.getDeviceIdForPreferences(context.getApplicationContext()))) {
            MemoryLruCache.setDeviceIdForPreferences(context.getApplicationContext());
        }
        final ArrayList arrayList = new ArrayList();
        arrayList.add(new MHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE));
        NetworkCallParams build = new NetworkCallParams.Builder().setPriority(0).setUrl(ConfigManager.getConfigUrl()).setConnectionTimeOut(10000).setWriteTimeOut(10000).setReadTimeOut(10000).setMHeaders(arrayList).setRetryOption(true).build();
        final Context context2 = context;
        final StatusType statusType2 = statusType;
        final IResponseListener<String> iResponseListener2 = iResponseListener;
        AnonymousClass5 r4 = new IResponseListener<String>() {
            public void onResponseFail(Exception exc) {
                MLogger.d(IResponseListener.TAG, UpdaterConstant.FAILURE);
                if (statusType2 != StatusType.BACKGROUND_API_CALL) {
                    DownloadHelper.this.sendFailureStatusToEventPublisher(context2);
                    return;
                }
                IResponseListener iResponseListener = iResponseListener2;
                if (iResponseListener != null) {
                    iResponseListener.onResponseSuccess(UpdaterConstant.FAILURE);
                }
            }

            public void progressResponse(long j, long j2, boolean z) {
                try {
                    if (statusType2 != StatusType.BACKGROUND_API_CALL && arrayList != null && arrayList.size() > 0) {
                        for (MHeader mHeader : arrayList) {
                            MLogger.d(IResponseListener.TAG, "onProcessHeader: " + mHeader.toString());
                            if (mHeader.getKey().equalsIgnoreCase("x-mpl-downtime") && CommonUtils.isJSONValid(mHeader.getValue())) {
                                JSONObject jSONObject = new JSONObject(mHeader.getValue());
                                MLogger.d(IResponseListener.TAG, jSONObject.optString("title", ""));
                                MLogger.d(IResponseListener.TAG, jSONObject.optString("message", ""));
                                Bundle bundle = new Bundle();
                                bundle.putString("title", jSONObject.optString("title", ""));
                                bundle.putString("message", jSONObject.optString("message", ""));
                                if (MPLReactContainerActivity.resultReceiver != null) {
                                    MPLReactContainerActivity.resultReceiver.send(15, bundle);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                } catch (Exception e2) {
                    MLogger.e(IResponseListener.TAG, "onProcessHeader: ", e2);
                }
            }

            public void onResponseSuccess(String str) {
                try {
                    DownloadHelper.this.processPreLoginConfig(context2, new JSONObject(str), statusType2, iResponseListener2);
                } catch (Exception e2) {
                    MLogger.e(IResponseListener.TAG, "onResponseSuccess: ", e2);
                    if (statusType2 != StatusType.BACKGROUND_API_CALL) {
                        EventPublishHelper.publishInitialStatusEvent(context2, StatusType.GENERIC_CONNECTION_ERROR);
                        return;
                    }
                    IResponseListener iResponseListener = iResponseListener2;
                    if (iResponseListener != null) {
                        iResponseListener.onResponseSuccess(UpdaterConstant.FAILURE);
                    }
                }
            }
        };
        NetworkUtils.doGetRequest(build, r4, "config_call_v2");
    }

    public void processHeader(ArrayList<MHeader> arrayList) {
        if (arrayList != null) {
            try {
                if (arrayList.size() > 0) {
                    Iterator<MHeader> it = arrayList.iterator();
                    while (it.hasNext()) {
                        MHeader next = it.next();
                        MLogger.d(TAG, "onProcessHeader:downtime " + next.toString());
                        if (!next.getKey().equalsIgnoreCase("x-mpl-downtime") || !CommonUtils.isJSONValid(next.getValue())) {
                            MLogger.d(TAG, "onProcessHeader: JSON is not valid");
                        } else {
                            JSONObject jSONObject = new JSONObject(next.getValue());
                            MLogger.d(TAG, jSONObject.optString("title", ""));
                            MLogger.d(TAG, jSONObject.optString("message", ""));
                            Bundle bundle = new Bundle();
                            bundle.putString("title", jSONObject.optString("title", ""));
                            bundle.putString("message", jSONObject.optString("message", ""));
                            if (MPLReactContainerActivity.resultReceiver != null) {
                                MPLReactContainerActivity.resultReceiver.send(15, bundle);
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                MLogger.e(TAG, "onProcessHeader: ", e2);
            }
        }
    }

    public ArrayList<String> sendData() {
        return mylist;
    }

    public void getDownloadUrl(String str, String str2, String str3, final ResponseListener responseListener) {
        try {
            final APIHealthCheckerImpl aPIHealthCheckerImpl = new APIHealthCheckerImpl();
            final APPSanityModel initAppSanity = aPIHealthCheckerImpl.initAppSanity(str);
            Builder url = new Builder().setUrl(str);
            MClient.executeAsync(url.addHeader(new MHeader("Authorization", "Bearer " + str2)).setHeaders(CommonUtils.getCommonHeaders()).setRequestPriority(RequestPriority.HIGH).setRetryOnConnectionFailure(true).setTag(str3).setResponseListener(new IResponseListener<String>() {
                public void onResponseFail(Exception exc) {
                    MLogger.d(IResponseListener.TAG, "onResponseFail: apk download url");
                    APIHealthChecker aPIHealthChecker = aPIHealthCheckerImpl;
                    if (aPIHealthChecker != null) {
                        aPIHealthChecker.setEndAppSanityParams(initAppSanity);
                    }
                    responseListener.onFailure(UpdaterConstant.FAILURE);
                    APIHealthChecker aPIHealthChecker2 = aPIHealthCheckerImpl;
                    if (aPIHealthChecker2 != null) {
                        aPIHealthChecker2.processAPIHealthStatusFromFailedResponse(initAppSanity, exc);
                    }
                }

                public void progressResponse(long j, long j2, boolean z) {
                }

                public void onResponseSuccess(String str) {
                    APIHealthChecker aPIHealthChecker = aPIHealthCheckerImpl;
                    if (aPIHealthChecker != null) {
                        aPIHealthChecker.setEndAppSanityParams(initAppSanity);
                    }
                    responseListener.onSuccess(str);
                    NetworkModule.processResponse(null, str);
                    APIHealthChecker aPIHealthChecker2 = aPIHealthCheckerImpl;
                    if (aPIHealthChecker2 != null) {
                        aPIHealthChecker2.processAPIHealthStatusFromSuccessFullResponse(initAppSanity, str);
                    }
                }
            }).build());
        } catch (Exception unused) {
        }
    }
}
