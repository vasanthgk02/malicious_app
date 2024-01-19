package io.hansel.ujmtracker;

import android.os.Build;
import android.os.Build.VERSION;
import com.mpl.androidapp.onesignal.OneSingnalConstant;
import com.netcore.android.preference.SMTPreferenceConstants;
import io.hansel.core.HSLBuildConfig;
import io.hansel.core.base.utils.HSLInternalUtils;
import io.hansel.core.filters.HSLFiltersInternal;
import io.hansel.core.sdkmodels.HSLSDKIdentifiers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class c {

    /* renamed from: c  reason: collision with root package name */
    public static c f5314c;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<HashMap<String, Object>> f5315a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f5316b = new Object();

    public static c b() {
        if (f5314c == null) {
            synchronized (c.class) {
                try {
                    if (f5314c == null) {
                        c cVar = new c();
                        f5314c = cVar;
                        cVar.f5315a = new ArrayList<>();
                    }
                }
            }
        }
        return f5314c;
    }

    public void a() {
        synchronized (this.f5316b) {
            Iterator<HashMap<String, Object>> it = this.f5315a.iterator();
            while (it.hasNext()) {
                h.a().c("_hsl_onAppLoad", "hsl", it.next(), null, true);
            }
            this.f5315a.clear();
        }
    }

    public void a(Boolean bool, HSLSDKIdentifiers hSLSDKIdentifiers) {
        String str;
        String str2;
        HashMap hashMap = new HashMap();
        hashMap.put("app_version", hSLSDKIdentifiers.getAppVersion().versionName);
        hashMap.put(SMTPreferenceConstants.SMT_SDK_VERSION, HSLBuildConfig.SDK_VERSION);
        hashMap.put("os_version", VERSION.RELEASE);
        hashMap.put(OneSingnalConstant.TAG_DEVICE_MODEL, Build.MODEL);
        hashMap.put("user_id", HSLFiltersInternal.getInstance().getUniqueId());
        hashMap.put("device_language", HSLInternalUtils.getDeviceLanguageCode());
        hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        if (bool.booleanValue()) {
            str2 = "Type";
            str = "Fresh Launch";
        } else {
            str2 = "Type";
            str = "background/foreground";
        }
        hashMap.put(str2, str);
        synchronized (this.f5316b) {
            this.f5315a.add(hashMap);
        }
    }
}
