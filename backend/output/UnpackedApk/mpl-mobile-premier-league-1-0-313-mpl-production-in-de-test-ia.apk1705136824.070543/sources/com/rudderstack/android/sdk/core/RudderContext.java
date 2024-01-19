package com.rudderstack.android.sdk.core;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.mpl.androidapp.utils.Constant;
import com.rudderstack.android.sdk.core.util.RudderTraitsSerializer;
import com.rudderstack.android.sdk.core.util.Utils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class RudderContext {
    public static transient String _anonymousId;
    @SerializedName("app")
    public RudderApp app;
    public Map<String, Object> customContextMap = null;
    @SerializedName("device")
    public RudderDeviceInfo deviceInfo;
    @SerializedName("externalId")
    public List<Map<String, Object>> externalIds = null;
    @SerializedName("library")
    public RudderLibraryInfo libraryInfo;
    @SerializedName("locale")
    public String locale;
    @SerializedName("network")
    public RudderNetwork networkInfo;
    @SerializedName("os")
    public RudderOSInfo osInfo;
    @SerializedName("screen")
    public RudderScreenInfo screenInfo;
    @SerializedName("timezone")
    public String timezone;
    @SerializedName("traits")
    public Map<String, Object> traits;
    @SerializedName("userAgent")
    public String userAgent;

    public RudderContext() {
    }

    /* access modifiers changed from: private */
    public boolean getAmazonFireAdvertisingID() throws Exception {
        if (RudderClient.getApplication() == null) {
            return false;
        }
        ContentResolver contentResolver = RudderClient.getApplication().getContentResolver();
        if (Secure.getInt(contentResolver, "limit_ad_tracking") != 0) {
            RudderLogger.logDebug("Not collecting advertising ID because limit_ad_tracking (Amazon Fire OS) is true.");
            this.deviceInfo.setAdTrackingEnabled(false);
            return false;
        }
        if (TextUtils.isEmpty(this.deviceInfo.getAdvertisingId())) {
            this.deviceInfo.setAdvertisingId(Secure.getString(contentResolver, Constant.ADVERTISIING_ID));
            this.deviceInfo.setAdTrackingEnabled(true);
        }
        return true;
    }

    public static String getAnonymousId() {
        return _anonymousId;
    }

    /* access modifiers changed from: private */
    public boolean getGooglePlayServicesAdvertisingID() throws Exception {
        if (RudderClient.getApplication() == null) {
            return false;
        }
        Object invoke = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke(null, new Object[]{RudderClient.getApplication()});
        if (invoke == null) {
            return false;
        }
        Boolean bool = (Boolean) invoke.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(invoke, new Object[0]);
        if (bool == null || bool.booleanValue()) {
            RudderLogger.logDebug("Not collecting advertising ID because isLimitAdTrackingEnabled (Google Play Services) is true.");
            this.deviceInfo.setAdTrackingEnabled(false);
            return false;
        }
        if (TextUtils.isEmpty(this.deviceInfo.getAdvertisingId())) {
            this.deviceInfo.setAdvertisingId((String) invoke.getClass().getMethod("getId", new Class[0]).invoke(invoke, new Object[0]));
            this.deviceInfo.setAdTrackingEnabled(true);
        }
        return true;
    }

    public static void updateAnonymousId(String str) {
        _anonymousId = str;
    }

    public RudderContext copy() {
        RudderContext rudderContext = new RudderContext();
        rudderContext.app = this.app;
        if (this.traits != null) {
            rudderContext.traits = new HashMap(this.traits);
        }
        rudderContext.libraryInfo = this.libraryInfo;
        rudderContext.osInfo = this.osInfo;
        rudderContext.screenInfo = this.screenInfo;
        rudderContext.userAgent = this.userAgent;
        rudderContext.locale = this.locale;
        rudderContext.deviceInfo = this.deviceInfo;
        rudderContext.networkInfo = this.networkInfo;
        rudderContext.timezone = this.timezone;
        if (this.externalIds != null) {
            rudderContext.externalIds = new ArrayList(this.externalIds);
        }
        return rudderContext;
    }

    public String getAdvertisingId() {
        RudderDeviceInfo rudderDeviceInfo = this.deviceInfo;
        if (rudderDeviceInfo == null) {
            return null;
        }
        return rudderDeviceInfo.getAdvertisingId();
    }

    public String getDeviceId() {
        return this.deviceInfo.getDeviceId();
    }

    public List<Map<String, Object>> getExternalIds() {
        return this.externalIds;
    }

    public Map<String, Object> getTraits() {
        return this.traits;
    }

    public boolean isAdTrackingEnabled() {
        RudderDeviceInfo rudderDeviceInfo = this.deviceInfo;
        if (rudderDeviceInfo == null) {
            return false;
        }
        return rudderDeviceInfo.isAdTrackingEnabled();
    }

    public void persistExternalIds() {
        try {
            if (RudderClient.getApplication() != null) {
                RudderPreferenceManager.getInstance(RudderClient.getApplication()).saveExternalIds(new Gson().toJson((Object) this.externalIds));
            }
        } catch (NullPointerException e2) {
            RudderLogger.logError((Exception) e2);
        }
    }

    public void persistTraits() {
        try {
            if (RudderClient.getApplication() != null) {
                RudderPreferenceManager.getInstance(RudderClient.getApplication()).saveTraits(new Gson().toJson((Object) this.traits));
            }
        } catch (NullPointerException e2) {
            RudderLogger.logError((Exception) e2);
        }
    }

    public void putDeviceToken(String str) {
        if (str != null && !str.isEmpty()) {
            this.deviceInfo.setToken(str);
        }
    }

    public void resetExternalIds() {
        this.externalIds = null;
        try {
            if (RudderClient.getApplication() != null) {
                RudderPreferenceManager.getInstance(RudderClient.getApplication()).clearExternalIds();
            }
        } catch (NullPointerException e2) {
            RudderLogger.logError((Exception) e2);
        }
    }

    public void resetTraits() {
        this.traits = Utils.convertToMap(new GsonBuilder().registerTypeAdapter(RudderTraits.class, new RudderTraitsSerializer()).create().toJson((Object) new RudderTraits()));
    }

    public void setCustomContexts(Map<String, Object> map) {
        if (map != null) {
            if (this.customContextMap == null) {
                this.customContextMap = new HashMap();
            }
            this.customContextMap.putAll(map);
        }
    }

    public void updateAnonymousIdTraits() {
        this.traits.put(RudderTraits.ANONYMOUSID_KEY, _anonymousId);
    }

    public void updateDeviceWithAdId() {
        if (Utils.isOnClassPath("com.google.android.gms.ads.identifier.AdvertisingIdClient")) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        boolean access$000 = RudderContext.this.getGooglePlayServicesAdvertisingID();
                        if (!access$000) {
                            access$000 = RudderContext.this.getAmazonFireAdvertisingID();
                        }
                        if (!access$000) {
                            RudderLogger.logDebug("Unable to collect advertising ID from Amazon Fire OS and Google Play Services.");
                        }
                    } catch (Exception unused) {
                        RudderLogger.logError((String) "Unable to collect advertising ID from Google Play Services or Amazon Fire OS.");
                    }
                }
            }).start();
        } else {
            RudderLogger.logDebug("Not collecting advertising ID because com.google.android.gms.ads.identifier.AdvertisingIdClient was not found on the classpath.");
        }
    }

    public void updateExternalIds(List<Map<String, Object>> list) {
        if (this.externalIds == null) {
            ArrayList arrayList = new ArrayList();
            this.externalIds = arrayList;
            arrayList.addAll(list);
            return;
        }
        for (Map next : list) {
            String str = (String) next.get("type");
            boolean z = false;
            if (str != null) {
                for (Map next2 : this.externalIds) {
                    String str2 = (String) next2.get("type");
                    if (str2 != null && str2.equals(str)) {
                        z = true;
                        next2.put("id", next.get("id"));
                    }
                }
                if (!z) {
                    this.externalIds.add(next);
                }
            }
        }
    }

    public void updateTraits(RudderTraits rudderTraits) {
        if (rudderTraits == null) {
            rudderTraits = new RudderTraits();
        }
        Map<String, Object> convertToMap = Utils.convertToMap(new GsonBuilder().registerTypeAdapter(RudderTraits.class, new RudderTraitsSerializer()).create().toJson((Object) rudderTraits));
        String str = (String) this.traits.get("id");
        String str2 = (String) convertToMap.get("id");
        if (str == null || str2 == null || str.equals(str2)) {
            this.traits.putAll(convertToMap);
            return;
        }
        this.traits = convertToMap;
        resetExternalIds();
    }

    public void updateTraitsMap(Map<String, Object> map) {
        this.traits = map;
    }

    public void updateWithAdvertisingId(String str) {
        if (str == null || str.isEmpty()) {
            this.deviceInfo.setAdTrackingEnabled(false);
            return;
        }
        this.deviceInfo.setAdTrackingEnabled(true);
        this.deviceInfo.setAdvertisingId(str);
    }

    public RudderContext(Application application, String str, String str2, String str3) {
        RudderPreferenceManager instance = RudderPreferenceManager.getInstance(application);
        if (TextUtils.isEmpty(str)) {
            str = instance.getAnonymousId() != null ? instance.getAnonymousId() : Utils.getDeviceId(application);
        } else {
            instance.saveAnonymousId(str);
        }
        _anonymousId = str;
        this.app = new RudderApp(application);
        String traits2 = instance.getTraits();
        RudderLogger.logDebug(String.format(Locale.US, "Traits from persistence storage%s", new Object[]{traits2}));
        if (traits2 == null) {
            this.traits = Utils.convertToMap(new Gson().toJson((Object) new RudderTraits(str)));
            persistTraits();
            RudderLogger.logDebug("New traits has been saved");
        } else {
            this.traits = Utils.convertToMap(traits2);
            RudderLogger.logDebug("Using old traits from persistence");
        }
        String externalIds2 = instance.getExternalIds();
        RudderLogger.logDebug(String.format(Locale.US, "ExternalIds from persistence storage%s", new Object[]{externalIds2}));
        if (externalIds2 != null) {
            this.externalIds = Utils.convertToList(externalIds2);
            RudderLogger.logDebug("Using old externalIds from persistence");
        }
        this.screenInfo = new RudderScreenInfo(application);
        this.userAgent = System.getProperty("http.agent");
        this.deviceInfo = new RudderDeviceInfo(str2, str3);
        this.networkInfo = new RudderNetwork(application);
        this.osInfo = new RudderOSInfo();
        this.libraryInfo = new RudderLibraryInfo();
        this.locale = Locale.getDefault().getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Locale.getDefault().getCountry();
        this.timezone = Utils.getTimeZone();
    }
}
