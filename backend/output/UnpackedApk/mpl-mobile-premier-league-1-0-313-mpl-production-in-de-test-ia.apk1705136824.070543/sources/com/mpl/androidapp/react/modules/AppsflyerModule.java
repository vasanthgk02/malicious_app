package com.mpl.androidapp.react.modules;

import android.text.TextUtils;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.mpl.androidapp.react.UserInfo;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.Constant.EventsConstants;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import java.util.HashMap;

@ReactModule(name = "AppsflyerModule")
public class AppsflyerModule extends ReactContextBaseJavaModule {
    public static final String TAG = "AppsflyerModule";

    public AppsflyerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void createAppsFlyerBattleShareLink(String str, String str2, Promise promise) {
        String str3;
        MLogger.d(TAG, "createAppsFlyerBattleShareLink: ");
        if (getCurrentActivity() != null) {
            UserInfo userInfo = MSharedPreferencesUtils.getUserInfo();
            if (userInfo == null || TextUtils.isEmpty(userInfo.getReferralCode())) {
                MLogger.d(Constant.APPS_FLYER_TAG, "createAppsFlyerBattleShareLink: user data is null or referral code is empty");
                str3 = "";
            } else {
                str3 = userInfo.getReferralCode();
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = MSharedPreferencesUtils.getUserReferralCode();
            }
            if (TextUtils.isEmpty(str3)) {
                promise.reject((String) "fail", (String) "Referral code is Empty");
            } else {
                CommonUtils.createAppsFlyerBattleShareLink(getReactApplicationContext(), str, str2, promise);
            }
        } else {
            promise.reject((String) "fail", (String) "Activity is Null");
        }
    }

    @ReactMethod
    public void createAppsFlyerFantasyLink(String str, Promise promise) {
        String str2;
        MLogger.d(TAG, "createAppsFlyerFantasyLink: ");
        if (getCurrentActivity() != null) {
            UserInfo userInfo = MSharedPreferencesUtils.getUserInfo();
            if (userInfo == null || TextUtils.isEmpty(userInfo.getReferralCode())) {
                MLogger.d(Constant.APPS_FLYER_TAG, "createAppsFlyerTournamentShareLink: user data is null or referral code is empty");
                str2 = "";
            } else {
                str2 = userInfo.getReferralCode();
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = MSharedPreferencesUtils.getUserReferralCode();
            }
            if (TextUtils.isEmpty(str2)) {
                promise.reject((String) "fail", (String) "Referral code is Empty");
            } else {
                CommonUtils.createAppsFlyerFantasyLink(getReactApplicationContext(), str, promise);
            }
        } else {
            promise.reject((String) "fail", (String) "Activity is Null");
        }
    }

    @ReactMethod
    public void createAppsFlyerRedirectLink(ReadableMap readableMap, Promise promise) {
        MLogger.d(TAG, "createAppsFlyerRedirectLink: ");
        promise.resolve(CommonUtils.createAppsFlyerRedirectUrl(readableMap));
    }

    @ReactMethod
    public void createAppsFlyerTournamentShareLink(String str, String str2, Promise promise) {
        String str3;
        MLogger.d(TAG, "createAppsFlyerTournamentShareLink: ");
        if (getCurrentActivity() != null) {
            UserInfo userInfo = MSharedPreferencesUtils.getUserInfo();
            if (userInfo == null || TextUtils.isEmpty(userInfo.getReferralCode())) {
                MLogger.d(Constant.APPS_FLYER_TAG, "createAppsFlyerTournamentShareLink: user data is null or referral code is empty");
                str3 = "";
            } else {
                str3 = userInfo.getReferralCode();
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = MSharedPreferencesUtils.getUserReferralCode();
            }
            if (TextUtils.isEmpty(str3)) {
                promise.reject((String) "fail", (String) "Referral code is Empty");
            } else {
                CommonUtils.createAppsFlyerTournamentShareLink(getReactApplicationContext(), str, str2, promise);
            }
        } else {
            promise.reject((String) "fail", (String) "Activity is Null");
        }
    }

    @ReactMethod
    public void getGeneralReferralUrl(String str, Promise promise) {
        String str2;
        if (str == null || TextUtils.isEmpty(str)) {
            MLogger.d(TAG, "getGeneralReferralUrl: ");
        } else {
            MLogger.d(TAG, "getGeneralReferralUrl: ", str);
        }
        if (getCurrentActivity() != null) {
            UserInfo userInfo = MSharedPreferencesUtils.getUserInfo();
            if (userInfo == null || TextUtils.isEmpty(userInfo.getReferralCode())) {
                MLogger.d(Constant.APPS_FLYER_TAG, "getGeneralReferralUrl: user data is null or referral code is empty");
                str2 = "";
            } else {
                str2 = userInfo.getReferralCode();
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = MSharedPreferencesUtils.getUserReferralCode();
            }
            if (TextUtils.isEmpty(str2)) {
                promise.reject((String) "fail", (String) "Referral code is Empty");
                HashMap hashMap = new HashMap();
                hashMap.put(EventsConstants.FAIL_REASON, "MPL Referral Code is Empty");
                CleverTapAnalyticsUtils.sendEvent((String) "AppsFlyer Link Creation Failed", hashMap);
                return;
            }
            CommonUtils.createAppsFlyerReferralLink(getCurrentActivity(), str, promise);
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put(EventsConstants.FAIL_REASON, "Activity is null");
        CleverTapAnalyticsUtils.sendEvent((String) "AppsFlyer Link Creation Failed", hashMap2);
        promise.reject((String) "fail", (String) "Activity is Null");
    }

    public String getName() {
        return TAG;
    }
}
