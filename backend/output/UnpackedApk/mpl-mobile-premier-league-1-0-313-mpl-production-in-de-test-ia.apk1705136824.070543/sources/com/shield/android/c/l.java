package com.shield.android.c;

import com.shield.android.internal.NativeUtils;
import com.shield.android.internal.f;
import org.json.JSONObject;

public class l extends f {

    /* renamed from: b  reason: collision with root package name */
    public final NativeUtils f1532b;

    public l(NativeUtils nativeUtils) {
        this.f1532b = nativeUtils;
    }

    public final String b() {
        boolean z;
        if (this.f1532b.a()) {
            try {
                boolean isFridaDetected = this.f1532b.isFridaDetected();
                boolean isSandHookDetected = this.f1532b.isSandHookDetected();
                boolean isFoundSubstrate = this.f1532b.isFoundSubstrate();
                boolean isVirtualXposedDetected = this.f1532b.isVirtualXposedDetected();
                boolean isVirtualAndroidDetected = this.f1532b.isVirtualAndroidDetected();
                boolean isTaichiDetected = this.f1532b.isTaichiDetected();
                JSONObject jSONObject = new JSONObject();
                if (!isFridaDetected) {
                    try {
                        if (!this.f1532b.isFridaDetected()) {
                            z = false;
                            jSONObject.put("is_found_frida", z);
                            jSONObject.put("is_found_substrate", isFoundSubstrate);
                            jSONObject.put("is_found_sandhook", isSandHookDetected);
                            jSONObject.put("is_found_virtual_xposed", isVirtualXposedDetected);
                            jSONObject.put("is_found_virtual_android", isVirtualAndroidDetected);
                            jSONObject.put("is_found_taichi", isTaichiDetected);
                            jSONObject.put("suspicious_packages", "");
                            return jSONObject.toString();
                        }
                    } catch (Exception e2) {
                        if (f.a().f1677b && e2.getMessage() != null) {
                            e2.getLocalizedMessage();
                        }
                    }
                }
                z = true;
                jSONObject.put("is_found_frida", z);
                jSONObject.put("is_found_substrate", isFoundSubstrate);
                jSONObject.put("is_found_sandhook", isSandHookDetected);
                jSONObject.put("is_found_virtual_xposed", isVirtualXposedDetected);
                jSONObject.put("is_found_virtual_android", isVirtualAndroidDetected);
                jSONObject.put("is_found_taichi", isTaichiDetected);
                jSONObject.put("suspicious_packages", "");
                return jSONObject.toString();
            } catch (Exception e3) {
                if (f.a().f1677b && e3.getMessage() != null) {
                    e3.getLocalizedMessage();
                }
            }
        }
        return "";
    }
}
