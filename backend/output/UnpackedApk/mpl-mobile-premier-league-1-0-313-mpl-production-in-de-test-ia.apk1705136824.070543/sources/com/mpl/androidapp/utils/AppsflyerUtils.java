package com.mpl.androidapp.utils;

import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.appsanity.APIHealthChecker;
import com.mpl.androidapp.appsanity.APIHealthCheckerImpl;
import com.mpl.androidapp.appsanity.APPSanityModel;
import com.mpl.androidapp.react.modules.NetworkModule;
import com.mpl.androidapp.updater.util.UpdaterConstant;
import com.mpl.network.modules.MClient;
import com.mpl.network.modules.listeners.IResponseListener;
import com.mpl.network.modules.request.MOkHttpGetRequest.Builder;
import com.mpl.network.modules.request.RequestPriority;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppsflyerUtils {
    public static final String TAG = "AppsflyerUtils";
    public static boolean mAppsflyerEventFilteringEnabled;
    public static List mAppsflyerWhitelistedEvents = new ArrayList();

    public static void fetchAndSavePlayWithFriendData(Map<String, Object> map) {
        if (map.containsKey("gn") && map.get("gn") != null) {
            MSharedPreferencesUtils.saveStringInNormalPref(MPLApplication.getInstance(), Constant.PWF_GROUP_NAME, String.valueOf(map.get("gn")));
        }
        if (map.containsKey("gi") && map.get("gi") != null) {
            MSharedPreferencesUtils.saveStringInNormalPref(MPLApplication.getInstance(), Constant.PWF_GROUP_ID, String.valueOf(map.get("gi")));
        }
        if (map.containsKey("ci") && map.get("ci") != null) {
            MSharedPreferencesUtils.saveStringInNormalPref(MPLApplication.getInstance(), Constant.PWF_CHALLENGE_ID, String.valueOf(map.get("ci")));
        }
    }

    public static void fetchAndSaveReferralRelatedInfo(Map<String, Object> map) {
        if (map.containsKey("Referral Source")) {
            CleverTapAnalyticsUtils.sendEvent((String) Constant.REFERRAL_ATTRIBUTION_DETECTED, new HashMap<>(map));
            if (map.containsKey("Feature")) {
                MSharedPreferencesUtils.setAFReferralFeature(MPLApplication.getInstance(), "Feature", String.valueOf(map.get("Feature")));
            }
        }
        if (map.containsKey("Entry Point") && map.get("Entry Point") != null && !TextUtils.isEmpty(String.valueOf(map.get("Entry Point")))) {
            MSharedPreferencesUtils.saveStringInNormalPref(MPLApplication.getInstance(), Constant.APPS_FLYER_ENTRY_POINT, String.valueOf(map.get("Entry Point")));
        }
        MSharedPreferencesUtils.putAFReferralData(new JSONObject(map));
        if (!map.containsKey("shouldSkipFTUE") || map.get("shouldSkipFTUE") == null || !Boolean.parseBoolean(String.valueOf(map.get("shouldSkipFTUE")))) {
            MLogger.d(TAG, "onConversionDataSuccess: shouldSkipFTUE is false");
        } else {
            MSharedPreferencesUtils.saveBooleanInNormalPref(MPLApplication.getInstance(), "shouldSkipFTUE", Boolean.parseBoolean(String.valueOf(map.get("shouldSkipFTUE"))));
        }
        if (map.containsKey("channel_url") && map.get("channel_url") != null && !TextUtils.isEmpty(String.valueOf(map.get("channel_url")))) {
            MSharedPreferencesUtils.saveStringInNormalPref(MPLApplication.getInstance(), "groupFtueUrl", String.valueOf(map.get("channel_url")));
        }
    }

    public static void getAppsflyerFilterEvents() {
        MLogger.d(TAG, "getAppsFlyerFilterEvents(): ");
        String outline62 = GeneratedOutlineSupport.outline62(new StringBuilder(), Constant.SET_BASE_URL, "/appsflyer/events");
        final APIHealthCheckerImpl aPIHealthCheckerImpl = new APIHealthCheckerImpl();
        final APPSanityModel initAppSanity = aPIHealthCheckerImpl.initAppSanity(outline62);
        MClient.executeAsync(new Builder().setRequestPriority(RequestPriority.HIGH).setUrl(outline62).setConnectTimeout(10000).setReadTimeout(10000).setWriteTimeout(10000).setPingInterval(10000).setHeaders(CommonUtils.getCommonHeaders()).setRetryOnConnectionFailure(true).setResponseListener(new IResponseListener<JSONObject>() {
            public void onResponseFail(Exception exc) {
                MLogger.d(IResponseListener.TAG, UpdaterConstant.FAILURE);
                APIHealthChecker aPIHealthChecker = APIHealthChecker.this;
                if (aPIHealthChecker != null) {
                    aPIHealthChecker.setEndAppSanityParams(initAppSanity);
                }
            }

            public void progressResponse(long j, long j2, boolean z) {
                MLogger.d(IResponseListener.TAG, "progressResponse() ");
            }

            public void onResponseSuccess(JSONObject jSONObject) {
                APIHealthChecker aPIHealthChecker = APIHealthChecker.this;
                if (aPIHealthChecker != null) {
                    aPIHealthChecker.setEndAppSanityParams(initAppSanity);
                }
                if (jSONObject.optJSONObject("status") == null || jSONObject.optJSONObject("payload") == null) {
                    MLogger.d(IResponseListener.TAG, UpdaterConstant.FAILURE);
                } else if (jSONObject.optJSONObject("status").optInt("code") == 200) {
                    try {
                        JSONObject optJSONObject = jSONObject.optJSONObject("payload");
                        if (optJSONObject != null && optJSONObject.has("appsflyerEvents")) {
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("appsflyerEvents");
                            if (optJSONObject2 != null && optJSONObject2.has("appsFlyerFilteringEnabled")) {
                                AppsflyerUtils.mAppsflyerEventFilteringEnabled = optJSONObject2.optBoolean("appsFlyerFilteringEnabled");
                                MLogger.d(IResponseListener.TAG, "appsFlyerFilteringEnabled: " + AppsflyerUtils.mAppsflyerEventFilteringEnabled);
                            }
                            if (optJSONObject2 != null && optJSONObject2.has("filteredAppsFlyerEvents")) {
                                JSONArray optJSONArray = optJSONObject2.optJSONArray("filteredAppsFlyerEvents");
                                if (optJSONArray != null && optJSONArray.length() > 0) {
                                    for (int i = 0; i < optJSONArray.length(); i++) {
                                        AppsflyerUtils.mAppsflyerWhitelistedEvents.add(optJSONArray.get(i).toString().toLowerCase());
                                    }
                                }
                                MLogger.d(IResponseListener.TAG, "filteredAppsFlyerEvents: " + AppsflyerUtils.mAppsflyerWhitelistedEvents);
                            }
                        }
                    } catch (JSONException e2) {
                        MLogger.e(IResponseListener.TAG, e2.getMessage());
                    } catch (Exception e3) {
                        MLogger.e(IResponseListener.TAG, e3.getMessage());
                    }
                } else {
                    MLogger.d(IResponseListener.TAG, UpdaterConstant.FAILURE, jSONObject);
                }
                NetworkModule.processResponse(null, jSONObject.toString());
                APIHealthChecker aPIHealthChecker2 = APIHealthChecker.this;
                if (aPIHealthChecker2 != null) {
                    aPIHealthChecker2.processAPIHealthStatusFromSuccessFullResponse(initAppSanity, jSONObject.toString());
                }
            }
        }).build());
    }

    public static String setIsAppsFlyerData(String str) {
        try {
            if (TextUtils.isEmpty(str) || !CommonUtils.isJSONValid(str)) {
                return str;
            }
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("isAppsFlyerData", true);
            return jSONObject.toString();
        } catch (Exception unused) {
            return str;
        }
    }
}
