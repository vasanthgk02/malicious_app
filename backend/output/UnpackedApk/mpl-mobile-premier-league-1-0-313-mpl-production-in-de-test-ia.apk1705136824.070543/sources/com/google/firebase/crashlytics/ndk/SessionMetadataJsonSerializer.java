package com.google.firebase.crashlytics.ndk;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.netcore.android.preference.SMTPreferenceConstants;
import java.util.HashMap;
import org.json.JSONObject;

public class SessionMetadataJsonSerializer {
    public static String emptyIfNull(String str) {
        return str == null ? "" : str;
    }

    public static String serializeBeginSession(String str, String str2, long j) {
        HashMap outline88 = GeneratedOutlineSupport.outline88("session_id", str, "generator", str2);
        outline88.put("started_at_seconds", Long.valueOf(j));
        return new JSONObject(outline88).toString();
    }

    public static String serializeSessionApp(String str, String str2, String str3, String str4, int i, String str5, String str6) {
        HashMap outline88 = GeneratedOutlineSupport.outline88("app_identifier", str, SMTPreferenceConstants.SMT_APP_VERSION_CODE, str2);
        outline88.put("version_name", str3);
        outline88.put("install_uuid", str4);
        outline88.put("delivery_mechanism", Integer.valueOf(i));
        outline88.put("development_platform", emptyIfNull(str5));
        outline88.put("development_platform_version", emptyIfNull(str6));
        return new JSONObject(outline88).toString();
    }

    public static String serializeSessionDevice(int i, String str, int i2, long j, long j2, boolean z, int i3, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("arch", Integer.valueOf(i));
        hashMap.put("build_model", str);
        hashMap.put("available_processors", Integer.valueOf(i2));
        hashMap.put("total_ram", Long.valueOf(j));
        hashMap.put("disk_space", Long.valueOf(j2));
        hashMap.put("is_emulator", Boolean.valueOf(z));
        hashMap.put("state", Integer.valueOf(i3));
        hashMap.put("build_manufacturer", str2);
        hashMap.put("build_product", str3);
        return new JSONObject(hashMap).toString();
    }

    public static String serializeSessionOs(String str, String str2, boolean z) {
        HashMap outline88 = GeneratedOutlineSupport.outline88("version", str, DefaultSettingsSpiCall.BUILD_VERSION_PARAM, str2);
        outline88.put("is_rooted", Boolean.valueOf(z));
        return new JSONObject(outline88).toString();
    }
}
