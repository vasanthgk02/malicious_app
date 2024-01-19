package com.freshchat.consumer.sdk.beans;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.j.k;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public class User {
    public static final String DEVICE_META_APP_VERSION_CODE = "app_version_code";
    public static final String DEVICE_META_APP_VERSION_NAME = "app_version";
    public static final String DEVICE_META_MANUFACTURER = "manufacturer";
    public static final String DEVICE_META_MODEL = "model";
    public static final String DEVICE_META_OS_NAME = "os";
    public static final String DEVICE_META_OS_VERSION_CODE = "os_version_code";
    public static final String DEVICE_META_OS_VERSION_NAME = "os_version";
    public static final String DEVICE_META_SDK_VERSION_CODE = "sdk_version_code";
    public static final int NOTIFICATION_TYPE_ANDROID = 1;
    public static final int NOTIFICATION_TYPE_IPHONE = 2;
    public static final int USER_TYPE_AGENT = 2;
    public static final int USER_TYPE_MOBILE = 0;
    public static final int USER_TYPE_OWNER = 1;
    public static final int USER_TYPE_SYSTEM42_SERVICE_ACCOUNT = 4;
    public String alias;
    @SerializedName("deviceAndroidMeta")
    public Map<String, String> androidDeviceMeta = new HashMap();
    public String email;
    @SerializedName("identifier")
    public String externalId;
    public String firstName;
    @SerializedName("jwtUserAuthToken")
    public String jwtIdToken;
    public String lastName;
    public String locale;
    public Map<String, String> meta = new HashMap();
    public String phone;
    public String phoneCountry;
    public String restoreId;

    public String getAlias() {
        return this.alias;
    }

    public Map<String, String> getAndroidDeviceMeta() {
        return this.androidDeviceMeta;
    }

    public String getEmail() {
        return this.email;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getJwtIdToken() {
        return this.jwtIdToken;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getLocale() {
        return this.locale;
    }

    public Map<String, String> getMeta() {
        return this.meta;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getPhoneCountry() {
        return this.phoneCountry;
    }

    public String getRestoreId() {
        return this.restoreId;
    }

    public User setAlias(String str) {
        this.alias = str;
        return this;
    }

    public User setAndroidDeviceMeta(Map<String, String> map) {
        this.androidDeviceMeta = map;
        return this;
    }

    public User setEmail(String str) {
        this.email = str;
        return this;
    }

    public User setExternalId(String str) {
        this.externalId = str;
        return this;
    }

    public User setFirstName(String str) {
        this.firstName = str;
        return this;
    }

    public User setJwtIdToken(String str) {
        this.jwtIdToken = str;
        return this;
    }

    public User setLastName(String str) {
        this.lastName = str;
        return this;
    }

    public User setLocale(String str) {
        this.locale = str;
        return this;
    }

    public User setMeta(Map<String, String> map) {
        this.meta.clear();
        if (k.d(map)) {
            this.meta.putAll(map);
        }
        return this;
    }

    public User setPhone(String str) {
        this.phone = str;
        return this;
    }

    public User setPhoneCountry(String str) {
        this.phoneCountry = str;
        return this;
    }

    public User setRestoreId(String str) {
        this.restoreId = str;
        return this;
    }

    public String toString() {
        StringBuilder outline77 = GeneratedOutlineSupport.outline77("User{", "alias='");
        GeneratedOutlineSupport.outline99(outline77, this.alias, ExtendedMessageFormat.QUOTE, ", firstName='");
        GeneratedOutlineSupport.outline99(outline77, this.firstName, ExtendedMessageFormat.QUOTE, ", lastName='");
        GeneratedOutlineSupport.outline99(outline77, this.lastName, ExtendedMessageFormat.QUOTE, ", email='");
        GeneratedOutlineSupport.outline99(outline77, this.email, ExtendedMessageFormat.QUOTE, ", phone='");
        GeneratedOutlineSupport.outline99(outline77, this.phone, ExtendedMessageFormat.QUOTE, ", phoneCountry='");
        GeneratedOutlineSupport.outline99(outline77, this.phoneCountry, ExtendedMessageFormat.QUOTE, ", externalId='");
        GeneratedOutlineSupport.outline99(outline77, this.externalId, ExtendedMessageFormat.QUOTE, ", restoreId='");
        GeneratedOutlineSupport.outline99(outline77, this.restoreId, ExtendedMessageFormat.QUOTE, ", androidDeviceMeta='");
        outline77.append(this.androidDeviceMeta);
        outline77.append(ExtendedMessageFormat.QUOTE);
        outline77.append(", meta=");
        outline77.append(this.meta);
        outline77.append(ExtendedMessageFormat.QUOTE);
        outline77.append(", locale=");
        GeneratedOutlineSupport.outline99(outline77, this.locale, ExtendedMessageFormat.QUOTE, ", jwtIdToken=");
        return GeneratedOutlineSupport.outline59(outline77, this.jwtIdToken, '}');
    }
}
