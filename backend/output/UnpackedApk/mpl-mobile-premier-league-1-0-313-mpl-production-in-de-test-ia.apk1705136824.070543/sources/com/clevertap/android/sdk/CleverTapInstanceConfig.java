package com.clevertap.android.sdk;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.CleverTapAPI.LogLevel;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.fontbox.cmap.CMapParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CleverTapInstanceConfig implements Parcelable {
    public static final Creator<CleverTapInstanceConfig> CREATOR = new Creator<CleverTapInstanceConfig>() {
        public Object createFromParcel(Parcel parcel) {
            return new CleverTapInstanceConfig(parcel, null);
        }

        public Object[] newArray(int i) {
            return new CleverTapInstanceConfig[i];
        }
    };
    public String accountId;
    public String accountRegion;
    public String accountToken;
    public ArrayList<String> allowedPushTypes = k.getAll();
    public boolean analyticsOnly;
    public boolean backgroundSync;
    public boolean beta;
    public boolean createdPostAppLaunch;
    public int debugLevel;
    public boolean disableAppLaunchedEvent;
    public boolean enableCustomCleverTapId;
    public String fcmSenderId;
    public String[] identityKeys = Constants.NULL_STRING_ARRAY;
    public boolean isDefaultInstance;
    public Logger logger;
    public String packageName;
    public boolean personalization;
    public boolean sslPinning;
    public boolean useGoogleAdId;

    public CleverTapInstanceConfig(CleverTapInstanceConfig cleverTapInstanceConfig) {
        this.accountId = cleverTapInstanceConfig.accountId;
        this.accountToken = cleverTapInstanceConfig.accountToken;
        this.accountRegion = cleverTapInstanceConfig.accountRegion;
        this.isDefaultInstance = cleverTapInstanceConfig.isDefaultInstance;
        this.analyticsOnly = cleverTapInstanceConfig.analyticsOnly;
        this.personalization = cleverTapInstanceConfig.personalization;
        this.debugLevel = cleverTapInstanceConfig.debugLevel;
        this.logger = cleverTapInstanceConfig.logger;
        this.useGoogleAdId = cleverTapInstanceConfig.useGoogleAdId;
        this.disableAppLaunchedEvent = cleverTapInstanceConfig.disableAppLaunchedEvent;
        this.createdPostAppLaunch = cleverTapInstanceConfig.createdPostAppLaunch;
        this.sslPinning = cleverTapInstanceConfig.sslPinning;
        this.backgroundSync = cleverTapInstanceConfig.backgroundSync;
        this.enableCustomCleverTapId = cleverTapInstanceConfig.enableCustomCleverTapId;
        this.fcmSenderId = cleverTapInstanceConfig.fcmSenderId;
        this.packageName = cleverTapInstanceConfig.packageName;
        this.beta = cleverTapInstanceConfig.beta;
        this.allowedPushTypes = cleverTapInstanceConfig.allowedPushTypes;
        this.identityKeys = cleverTapInstanceConfig.identityKeys;
    }

    public int describeContents() {
        return 0;
    }

    public final String getDefaultSuffix(String str) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("[");
        outline73.append(!TextUtils.isEmpty(str) ? GeneratedOutlineSupport.outline50(":", str) : "");
        outline73.append(":");
        return GeneratedOutlineSupport.outline62(outline73, this.accountId, CMapParser.MARK_END_OF_ARRAY);
    }

    public Logger getLogger() {
        if (this.logger == null) {
            this.logger = new Logger(this.debugLevel);
        }
        return this.logger;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.accountId);
        parcel.writeString(this.accountToken);
        parcel.writeString(this.accountRegion);
        parcel.writeByte(this.analyticsOnly ? (byte) 1 : 0);
        parcel.writeByte(this.isDefaultInstance ? (byte) 1 : 0);
        parcel.writeByte(this.useGoogleAdId ? (byte) 1 : 0);
        parcel.writeByte(this.disableAppLaunchedEvent ? (byte) 1 : 0);
        parcel.writeByte(this.personalization ? (byte) 1 : 0);
        parcel.writeInt(this.debugLevel);
        parcel.writeByte(this.createdPostAppLaunch ? (byte) 1 : 0);
        parcel.writeByte(this.sslPinning ? (byte) 1 : 0);
        parcel.writeByte(this.backgroundSync ? (byte) 1 : 0);
        parcel.writeByte(this.enableCustomCleverTapId ? (byte) 1 : 0);
        parcel.writeString(this.fcmSenderId);
        parcel.writeString(this.packageName);
        parcel.writeByte(this.beta ? (byte) 1 : 0);
        parcel.writeList(this.allowedPushTypes);
        parcel.writeStringArray(this.identityKeys);
    }

    public CleverTapInstanceConfig(Context context, String str, String str2, String str3, boolean z) {
        this.accountId = str;
        this.accountToken = str2;
        this.accountRegion = str3;
        this.isDefaultInstance = z;
        this.analyticsOnly = false;
        this.personalization = true;
        int intValue = LogLevel.INFO.intValue();
        this.debugLevel = intValue;
        this.logger = new Logger(intValue);
        this.createdPostAppLaunch = false;
        ManifestInfo instance = ManifestInfo.getInstance(context);
        if (instance != null) {
            this.useGoogleAdId = ManifestInfo.useADID;
            this.disableAppLaunchedEvent = ManifestInfo.appLaunchedDisabled;
            this.sslPinning = ManifestInfo.sslPinning;
            this.backgroundSync = ManifestInfo.backgroundSync;
            this.fcmSenderId = ManifestInfo.fcmSenderId;
            this.packageName = ManifestInfo.packageName;
            this.enableCustomCleverTapId = ManifestInfo.useCustomID;
            this.beta = ManifestInfo.beta;
            if (this.isDefaultInstance) {
                this.identityKeys = instance.profileKeys;
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Setting Profile Keys from Manifest: ");
                outline73.append(Arrays.toString(this.identityKeys));
                this.logger.verbose(getDefaultSuffix("ON_USER_LOGIN"), outline73.toString());
                return;
            }
            return;
        }
        throw null;
    }

    public CleverTapInstanceConfig(String str) throws Throwable {
        String str2 = str;
        String str3 = "identityTypes";
        String str4 = "allowedPushTypes";
        String str5 = "beta";
        String str6 = "fcmSenderId";
        String str7 = "getEnableCustomCleverTapId";
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.has("accountId")) {
                this.accountId = jSONObject.getString("accountId");
            }
            if (jSONObject.has("accountToken")) {
                this.accountToken = jSONObject.getString("accountToken");
            }
            if (jSONObject.has("accountRegion")) {
                this.accountRegion = jSONObject.getString("accountRegion");
            }
            if (jSONObject.has("analyticsOnly")) {
                this.analyticsOnly = jSONObject.getBoolean("analyticsOnly");
            }
            if (jSONObject.has("isDefaultInstance")) {
                this.isDefaultInstance = jSONObject.getBoolean("isDefaultInstance");
            }
            if (jSONObject.has("useGoogleAdId")) {
                this.useGoogleAdId = jSONObject.getBoolean("useGoogleAdId");
            }
            if (jSONObject.has("disableAppLaunchedEvent")) {
                this.disableAppLaunchedEvent = jSONObject.getBoolean("disableAppLaunchedEvent");
            }
            if (jSONObject.has("personalization")) {
                this.personalization = jSONObject.getBoolean("personalization");
            }
            if (jSONObject.has("debugLevel")) {
                this.debugLevel = jSONObject.getInt("debugLevel");
            }
            this.logger = new Logger(this.debugLevel);
            if (jSONObject.has("packageName")) {
                this.packageName = jSONObject.getString("packageName");
            }
            if (jSONObject.has("createdPostAppLaunch")) {
                this.createdPostAppLaunch = jSONObject.getBoolean("createdPostAppLaunch");
            }
            if (jSONObject.has("sslPinning")) {
                this.sslPinning = jSONObject.getBoolean("sslPinning");
            }
            if (jSONObject.has("backgroundSync")) {
                this.backgroundSync = jSONObject.getBoolean("backgroundSync");
            }
            String str8 = str7;
            if (jSONObject.has(str8)) {
                this.enableCustomCleverTapId = jSONObject.getBoolean(str8);
            }
            String str9 = str6;
            if (jSONObject.has(str9)) {
                this.fcmSenderId = jSONObject.getString(str9);
            }
            String str10 = str5;
            if (jSONObject.has(str10)) {
                this.beta = jSONObject.getBoolean(str10);
            }
            String str11 = str4;
            int i = 0;
            if (jSONObject.has(str11)) {
                JSONArray jSONArray = jSONObject.getJSONArray(str11);
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    arrayList.add(jSONArray.get(i2));
                }
                this.allowedPushTypes = arrayList;
            }
            String str12 = str3;
            if (jSONObject.has(str12)) {
                JSONArray jSONArray2 = jSONObject.getJSONArray(str12);
                Object[] objArr = new Object[jSONArray2.length()];
                while (i < jSONArray2.length()) {
                    try {
                        objArr[i] = jSONArray2.get(i);
                        i++;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                this.identityKeys = (String[]) objArr;
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        } catch (Throwable th) {
            Logger.v(GeneratedOutlineSupport.outline52("Error constructing CleverTapInstanceConfig from JSON: ", str2, ": "), th.getCause());
            throw th;
        }
    }

    public CleverTapInstanceConfig(Parcel parcel, AnonymousClass1 r5) {
        this.accountId = parcel.readString();
        this.accountToken = parcel.readString();
        this.accountRegion = parcel.readString();
        boolean z = false;
        this.analyticsOnly = parcel.readByte() != 0;
        this.isDefaultInstance = parcel.readByte() != 0;
        this.useGoogleAdId = parcel.readByte() != 0;
        this.disableAppLaunchedEvent = parcel.readByte() != 0;
        this.personalization = parcel.readByte() != 0;
        this.debugLevel = parcel.readInt();
        this.createdPostAppLaunch = parcel.readByte() != 0;
        this.sslPinning = parcel.readByte() != 0;
        this.backgroundSync = parcel.readByte() != 0;
        this.enableCustomCleverTapId = parcel.readByte() != 0;
        this.fcmSenderId = parcel.readString();
        this.packageName = parcel.readString();
        this.logger = new Logger(this.debugLevel);
        this.beta = parcel.readByte() != 0 ? true : z;
        ArrayList<String> arrayList = new ArrayList<>();
        this.allowedPushTypes = arrayList;
        parcel.readList(arrayList, String.class.getClassLoader());
        this.identityKeys = parcel.createStringArray();
    }
}
