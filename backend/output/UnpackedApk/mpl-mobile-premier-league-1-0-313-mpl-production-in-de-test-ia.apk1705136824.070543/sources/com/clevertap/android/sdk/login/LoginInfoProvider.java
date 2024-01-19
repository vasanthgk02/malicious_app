package com.clevertap.android.sdk.login;

import android.content.Context;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.DeviceInfo;
import com.clevertap.android.sdk.Logger;
import java.util.Iterator;
import org.apache.fontbox.cmap.CMapParser;
import org.json.JSONObject;

public class LoginInfoProvider {
    public final CleverTapInstanceConfig config;
    public final Context context;
    public final DeviceInfo deviceInfo;

    public LoginInfoProvider(Context context2, CleverTapInstanceConfig cleverTapInstanceConfig, DeviceInfo deviceInfo2) {
        this.context = context2;
        this.config = cleverTapInstanceConfig;
        this.deviceInfo = deviceInfo2;
    }

    public void cacheGUIDForIdentifier(String str, String str2, String str3) {
        if (!isErrorDeviceId() && str != null && str2 != null && str3 != null) {
            String outline52 = GeneratedOutlineSupport.outline52(str2, "_", str3);
            JSONObject cachedGUIDs = getCachedGUIDs();
            try {
                cachedGUIDs.put(outline52, str);
                setCachedGUIDs(cachedGUIDs);
            } catch (Throwable th) {
                Logger logger = this.config.getLogger();
                String str4 = this.config.accountId;
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error caching guid: ");
                outline73.append(th.toString());
                logger.verbose(str4, outline73.toString());
            }
        }
    }

    public boolean deviceIsMultiUser() {
        boolean z = true;
        if (getCachedGUIDs().length() <= 1) {
            z = false;
        }
        CleverTapInstanceConfig cleverTapInstanceConfig = this.config;
        cleverTapInstanceConfig.logger.verbose(cleverTapInstanceConfig.getDefaultSuffix("ON_USER_LOGIN"), "deviceIsMultiUser:[" + z + CMapParser.MARK_END_OF_ARRAY);
        return z;
    }

    public JSONObject getCachedGUIDs() {
        JSONObject jSONObject = null;
        String stringFromPrefs = k.getStringFromPrefs(this.context, this.config, "cachedGUIDsKey", null);
        CleverTapInstanceConfig cleverTapInstanceConfig = this.config;
        cleverTapInstanceConfig.logger.verbose(cleverTapInstanceConfig.getDefaultSuffix("ON_USER_LOGIN"), GeneratedOutlineSupport.outline52("getCachedGUIDs:[", stringFromPrefs, CMapParser.MARK_END_OF_ARRAY));
        Logger logger = this.config.getLogger();
        String str = this.config.accountId;
        if (stringFromPrefs != null) {
            try {
                jSONObject = new JSONObject(stringFromPrefs);
            } catch (Throwable th) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error reading guid cache: ");
                outline73.append(th.toString());
                logger.verbose(str, outline73.toString());
            }
        }
        return jSONObject != null ? jSONObject : new JSONObject();
    }

    public String getCachedIdentityKeysForAccount() {
        String stringFromPrefs = k.getStringFromPrefs(this.context, this.config, "SP_KEY_PROFILE_IDENTITIES", "");
        CleverTapInstanceConfig cleverTapInstanceConfig = this.config;
        cleverTapInstanceConfig.logger.verbose(cleverTapInstanceConfig.getDefaultSuffix("ON_USER_LOGIN"), GeneratedOutlineSupport.outline50("getCachedIdentityKeysForAccount:", stringFromPrefs));
        return stringFromPrefs;
    }

    public String getGUIDForIdentifier(String str, String str2) {
        if (!(str == null || str2 == null)) {
            try {
                String string = getCachedGUIDs().getString(GeneratedOutlineSupport.outline52(str, "_", str2));
                CleverTapInstanceConfig cleverTapInstanceConfig = this.config;
                cleverTapInstanceConfig.logger.verbose(cleverTapInstanceConfig.getDefaultSuffix("ON_USER_LOGIN"), "getGUIDForIdentifier:[Key:" + str + ", value:" + string + CMapParser.MARK_END_OF_ARRAY);
                return string;
            } catch (Throwable th) {
                Logger logger = this.config.getLogger();
                String str3 = this.config.accountId;
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error reading guid cache: ");
                outline73.append(th.toString());
                logger.verbose(str3, outline73.toString());
            }
        }
        return null;
    }

    public boolean isAnonymousDevice() {
        boolean z = getCachedGUIDs().length() <= 0;
        CleverTapInstanceConfig cleverTapInstanceConfig = this.config;
        cleverTapInstanceConfig.logger.verbose(cleverTapInstanceConfig.getDefaultSuffix("ON_USER_LOGIN"), "isAnonymousDevice:[" + z + CMapParser.MARK_END_OF_ARRAY);
        return z;
    }

    public final boolean isErrorDeviceId() {
        boolean isErrorDeviceId = this.deviceInfo.isErrorDeviceId();
        CleverTapInstanceConfig cleverTapInstanceConfig = this.config;
        cleverTapInstanceConfig.logger.verbose(cleverTapInstanceConfig.getDefaultSuffix("ON_USER_LOGIN"), "isErrorDeviceId:[" + isErrorDeviceId + CMapParser.MARK_END_OF_ARRAY);
        return isErrorDeviceId;
    }

    public void removeCachedGuidFromSharedPrefs() {
        try {
            Context context2 = this.context;
            k.persist(k.getPreferences(context2).edit().remove(k.storageKeyWithSuffix(this.config, "cachedGUIDsKey")));
            CleverTapInstanceConfig cleverTapInstanceConfig = this.config;
            cleverTapInstanceConfig.logger.verbose(cleverTapInstanceConfig.getDefaultSuffix("ON_USER_LOGIN"), (String) "removeCachedGUIDs:[]");
        } catch (Throwable th) {
            Logger logger = this.config.getLogger();
            String str = this.config.accountId;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error removing guid cache: ");
            outline73.append(th.toString());
            logger.verbose(str, outline73.toString());
        }
    }

    public void removeValueFromCachedGUIDForIdentifier(String str, String str2) {
        if (!isErrorDeviceId() && str != null && str2 != null) {
            JSONObject cachedGUIDs = getCachedGUIDs();
            try {
                Iterator<String> keys = cachedGUIDs.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next.toLowerCase().contains(str2.toLowerCase()) && cachedGUIDs.getString(next).equals(str)) {
                        cachedGUIDs.remove(next);
                        if (cachedGUIDs.length() == 0) {
                            removeCachedGuidFromSharedPrefs();
                        } else {
                            setCachedGUIDs(cachedGUIDs);
                        }
                    }
                }
            } catch (Throwable th) {
                Logger logger = this.config.getLogger();
                String str3 = this.config.accountId;
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error removing cached key: ");
                outline73.append(th.toString());
                logger.verbose(str3, outline73.toString());
            }
        }
    }

    public void setCachedGUIDs(JSONObject jSONObject) {
        try {
            String jSONObject2 = jSONObject.toString();
            k.putString(this.context, k.storageKeyWithSuffix(this.config, "cachedGUIDsKey"), jSONObject2);
            CleverTapInstanceConfig cleverTapInstanceConfig = this.config;
            cleverTapInstanceConfig.logger.verbose(cleverTapInstanceConfig.getDefaultSuffix("ON_USER_LOGIN"), "setCachedGUIDs:[" + jSONObject2 + CMapParser.MARK_END_OF_ARRAY);
        } catch (Throwable th) {
            Logger logger = this.config.getLogger();
            String str = this.config.accountId;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error persisting guid cache: ");
            outline73.append(th.toString());
            logger.verbose(str, outline73.toString());
        }
    }
}
