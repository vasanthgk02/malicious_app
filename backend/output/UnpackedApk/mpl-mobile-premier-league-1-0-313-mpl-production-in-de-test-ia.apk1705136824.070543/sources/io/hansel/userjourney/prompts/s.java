package io.hansel.userjourney.prompts;

import android.os.Build;
import android.os.Build.VERSION;
import com.mpl.androidapp.onesignal.OneSingnalConstant;
import com.netcore.android.preference.SMTPreferenceConstants;
import com.razorpay.AnalyticsConstants;
import io.hansel.core.HSLBuildConfig;
import io.hansel.core.base.utils.HSLInternalUtils;
import io.hansel.core.filters.HSLFiltersInternal;
import java.util.HashMap;

public class s {

    /* renamed from: a  reason: collision with root package name */
    public String f5688a = "_hsl_page_load";

    /* renamed from: b  reason: collision with root package name */
    public String f5689b = "hsl";

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, Object> f5690c = b();

    /* renamed from: d  reason: collision with root package name */
    public String f5691d;

    /* renamed from: e  reason: collision with root package name */
    public String f5692e;

    public s(String str, String str2) {
        this.f5691d = str;
        this.f5692e = str2;
    }

    private HashMap<String, Object> b() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("screen_name", this.f5691d);
        hashMap.put("app_version", this.f5692e);
        hashMap.put(SMTPreferenceConstants.SMT_SDK_VERSION, HSLBuildConfig.SDK_VERSION);
        hashMap.put("os_version", VERSION.RELEASE);
        hashMap.put(OneSingnalConstant.TAG_DEVICE_MODEL, Build.MODEL);
        hashMap.put("user_id", HSLFiltersInternal.getInstance().getUniqueId());
        hashMap.put("device_language", HSLInternalUtils.getDeviceLanguageCode());
        hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        return hashMap;
    }

    public HashMap<String, Object> a() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("event_name", this.f5688a);
        hashMap.put("vendor", this.f5689b);
        hashMap.put(AnalyticsConstants.PROPERTIES, this.f5690c);
        return hashMap;
    }
}
