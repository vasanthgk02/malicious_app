package com.mpl.androidapp.react.modules;

import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.backgroundmanager.BackgroundTaskHandler;
import com.mpl.androidapp.cleverTap.AssetsAnalytics;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.Constant.EventsConstants;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.androidapp.utils.Util;
import com.mpl.androidapp.utils.VideoRecordingUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.fontbox.cmap.CMapParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ReactModule(name = "AnalyticsHelper")
public class AnalyticsHelper extends ReactContextBaseJavaModule {
    public static final String TAG = "AnalyticsHelper";

    public AnalyticsHelper(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public static HashMap<String, Object> jsonToMap(JSONObject jSONObject) throws JSONException {
        return jSONObject != JSONObject.NULL ? toMap(jSONObject) : new HashMap<>();
    }

    @ReactMethod
    public static void pushProfileEvent(final String str) {
        BackgroundTaskHandler.execute(new Runnable() {
            public void run() {
                try {
                    CleverTapAnalyticsUtils.pushProfileEvent(AnalyticsHelper.jsonToMap(new JSONObject(str)));
                } catch (JSONException e2) {
                    MLogger.e(AnalyticsHelper.TAG, "", e2);
                }
            }
        });
    }

    public static List<Object> toList(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                obj = toList((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = toMap((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    public static HashMap<String, Object> toMap(JSONObject jSONObject) throws JSONException {
        HashMap<String, Object> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONArray) {
                obj = toList((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = toMap((JSONObject) obj);
            }
            hashMap.put(next, obj);
        }
        return hashMap;
    }

    @ReactMethod
    public void changeCredentials() {
    }

    @ReactMethod
    public void disableNetworkInfoReporting() {
        MPLApplication.getMplAnalytics().disableNetworkInfoReporting();
    }

    @ReactMethod
    public void enableNetworkInfoReporting() {
        MPLApplication.getMplAnalytics().enableNetworkInfoReporting();
    }

    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void pushAppseeEvent(String str) {
    }

    @ReactMethod
    public void pushAppseeEventWithProp(String str, String str2) {
    }

    @ReactMethod
    public void pushBranchEvent(final String str) {
        MLogger.d(TAG, "pushBranchEvent: ");
        BackgroundTaskHandler.execute(new Runnable() {
            public void run() {
                if (EventsConstants.USER_PLAYED_GAME.equalsIgnoreCase(str) && !MSharedPreferencesUtils.isBranchEventPushed()) {
                    Util.pushBranchEvent(str);
                    MSharedPreferencesUtils.setIsBranchEventPushed(true);
                } else if (CleverTapAnalyticsUtils.isBranchEvents(str)) {
                    Util.pushBranchEvent(str);
                }
            }
        });
    }

    @ReactMethod
    public void pushBranchEventWithProp(final String str, final String str2) {
        MLogger.d(TAG, "pushBranchEventWithProp");
        BackgroundTaskHandler.execute(new Runnable() {
            public void run() {
                if (EventsConstants.MONEY_IN_EVENT.equalsIgnoreCase(str)) {
                    Util.pushBranchEventWithProp(str);
                    if (!MSharedPreferencesUtils.isMoneyInBranchEventPushed()) {
                        MSharedPreferencesUtils.setMoneyInBranchEventPushed(true);
                        Util.pushBranchEventWithPropWithoutStandard(str);
                    }
                } else if (EventsConstants.MONEY_OUT_EVENT.equalsIgnoreCase(str)) {
                    Util.pushBranchEventWithProp(str);
                    if (!MSharedPreferencesUtils.isMoneyOutBranchEventPushed()) {
                        MSharedPreferencesUtils.setMoneyOutBranchEventPushed(true);
                        Util.pushBranchEventWithPropWithoutStandard(str);
                    }
                } else if (EventsConstants.RANKED_FETCHED.equalsIgnoreCase(str)) {
                    if (VideoRecordingUtils.getTotalUserPlayedGame(AnalyticsHelper.this.getCurrentActivity() == null ? MPLApplication.getInstance() : AnalyticsHelper.this.getCurrentActivity()) == 3 && !MSharedPreferencesUtils.isGamePlayedBranchEventPushed()) {
                        MSharedPreferencesUtils.setGamePlayedBranchEventPushed(true);
                        Util.pushBranchEventWithPropWithoutStandard(str);
                    }
                    Util.pushBranchEventWithoutStandard(AssetsAnalytics.PROP_GAME_PLAYED);
                    try {
                        String optString = new JSONObject(str2).optString("Tournament Name", "");
                        if (optString != null && "Welcome To MPL".equalsIgnoreCase(optString) && !MSharedPreferencesUtils.isWTMEventSent()) {
                            MSharedPreferencesUtils.setWTMEventSent(true);
                            Util.pushBranchEventWithProp("WTM");
                        }
                    } catch (JSONException e2) {
                        MLogger.printStackTrace(e2);
                    }
                } else if (EventsConstants.USER_LOGGED_ID.equalsIgnoreCase(str)) {
                    try {
                        boolean optBoolean = new JSONObject(str2).optBoolean("Is new user", false);
                        boolean isUserLoggedInEventSent = MSharedPreferencesUtils.isUserLoggedInEventSent();
                        if (optBoolean && !isUserLoggedInEventSent) {
                            MSharedPreferencesUtils.setUserLoggedInEventSent(true);
                            Util.pushBranchEventWithProp(str);
                        }
                    } catch (JSONException e3) {
                        MLogger.printStackTrace(e3);
                    }
                } else {
                    Util.pushBranchEventWithProp(str);
                }
            }
        });
    }

    @ReactMethod
    public void pushChargedEvent(final HashMap<String, Object> hashMap, final ArrayList<HashMap<String, Object>> arrayList) {
        BackgroundTaskHandler.execute(new Runnable() {
            public void run() {
                MPLApplication.getMplAnalytics().pushChargedEvent(hashMap, arrayList);
            }
        });
    }

    @ReactMethod
    public void pushEvent(final String str) {
        BackgroundTaskHandler.execute(new Runnable() {
            public void run() {
                if (CleverTapAnalyticsUtils.isBranchEvents(str)) {
                    Util.pushBranchEvent(str);
                }
                CleverTapAnalyticsUtils.sendEvent(str);
            }
        });
    }

    @ReactMethod
    public void pushEventtokafka(final String str, String str2) {
        try {
            final JSONObject jSONObject = new JSONObject(str2);
            BackgroundTaskHandler.execute(new Runnable() {
                public void run() {
                    try {
                        CleverTapAnalyticsUtils.sendEventToKafka(str, Util.jsonToMap(jSONObject));
                    } catch (Exception unused) {
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    @ReactMethod
    public void pushFacebookEventWithProp(final String str, final String str2) {
        MLogger.d(TAG, "pushFacebookEventWithProp");
        BackgroundTaskHandler.execute(new Runnable() {
            public void run() {
                Util.pushFacebookEventWithProp(str, str2);
            }
        });
    }

    @ReactMethod
    public void pushFireBaseEvents(final String str, String str2) {
        MLogger.d(TAG, "pushFireBaseEvents");
        BackgroundTaskHandler.execute(new Runnable() {
            public void run() {
                String str = str;
                if (str != null) {
                    CleverTapAnalyticsUtils.pushFireBaseEvents(str);
                }
            }
        });
    }

    @ReactMethod
    public void setFireBaseUserProperty(String str, String str2) {
        MLogger.d(TAG, GeneratedOutlineSupport.outline54("setFireBaseUserProperty() called with: key = [", str, "], value = [", str2, CMapParser.MARK_END_OF_ARRAY));
        CleverTapAnalyticsUtils.setFireBaseUserProperty(str, str2);
    }

    @ReactMethod
    public void startLoggingEvent() {
        MPLApplication.getMplAnalytics().startLoggingEvent();
    }

    @ReactMethod
    public void stopLoggingEvent() {
        MPLApplication.getMplAnalytics().stopLoggingEvent();
    }

    @ReactMethod
    public void pushEvent(String str, String str2) {
        try {
            if (CleverTapAnalyticsUtils.isBranchEvents(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    if (str2 != null) {
                        pushBranchEventWithProp(str, str2);
                    }
                }
                Util.pushBranchEvent(str);
            }
            CleverTapAnalyticsUtils.sendEvent(str, str2);
        } catch (Exception unused) {
        }
    }
}
