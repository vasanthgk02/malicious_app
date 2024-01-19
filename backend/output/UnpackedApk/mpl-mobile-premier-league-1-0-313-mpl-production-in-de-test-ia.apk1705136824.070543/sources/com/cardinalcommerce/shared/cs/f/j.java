package com.cardinalcommerce.shared.cs.f;

import android.content.Context;
import android.os.Build;
import android.os.Debug;
import com.cardinalcommerce.shared.cs.b.d;
import com.cardinalcommerce.shared.cs.utils.a;
import com.cardinalcommerce.shared.models.Warning;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import io.sentry.android.core.DefaultAndroidEventProcessor;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f2146a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f2147b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f2148c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f2149d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2150e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f2151f;

    public j(boolean z, Context context) {
        this.f2146a = (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || Build.FINGERPRINT.startsWith("generic") || Build.FINGERPRINT.startsWith("unknown") || Build.HARDWARE.contains(CommonUtils.GOLDFISH) || Build.HARDWARE.contains(CommonUtils.RANCHU) || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || Build.PRODUCT.contains("sdk_google") || Build.PRODUCT.contains("google_sdk") || Build.PRODUCT.contains("sdk") || Build.PRODUCT.contains("sdk_x86") || Build.PRODUCT.contains("vbox86p") || Build.PRODUCT.contains(DefaultAndroidEventProcessor.EMULATOR) || Build.PRODUCT.contains("simulator");
        this.f2149d = true;
        this.f2148c = Debug.isDebuggerConnected();
        this.f2147b = a();
        this.f2150e = z;
        this.f2151f = new ArrayList<String>(this) {
            {
                add("com.android.vending");
                add("com.amazon.venezia");
                add("com.sec.android.app.samsungapps");
                add("com.amazon.mshop.android");
            }
        }.contains(context.getPackageManager().getInstallerPackageName(context.getPackageName()));
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList = new ArrayList();
        if (this.f2147b) {
            jSONArray.put("SW01");
            arrayList.add(new Warning("SW01", "The device is jailbroken.", d.HIGH));
        }
        if (this.f2150e) {
            jSONArray.put("SW02");
            arrayList.add(new Warning("SW02", "The integrity of the SDK has been tampered.", d.HIGH));
        }
        if (this.f2146a) {
            jSONArray.put("SW03");
            arrayList.add(new Warning("SW03", "An emulator is being used to run the App.", d.HIGH));
        }
        if (this.f2148c) {
            jSONArray.put("SW04");
            arrayList.add(new Warning("SW04", "A debugger is attached to the App.", d.MEDIUM));
        }
        if (!this.f2149d) {
            jSONArray.put("SW05");
            arrayList.add(new Warning("SW05", "The OS or the OS version is not supported.", d.HIGH));
        }
        if (!this.f2151f) {
            jSONArray.put("SW06");
            arrayList.add(new Warning("SW06", "The App is not installed from trusted source.", d.HIGH));
        }
    }

    public static boolean a() {
        boolean z;
        boolean z2;
        String str = Build.TAGS;
        if (str != null && str.contains("test-keys")) {
            return true;
        }
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        int i = 0;
        while (true) {
            if (i >= 10) {
                z = false;
                break;
            } else if (new File(strArr[i]).exists()) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return true;
        }
        Process process = null;
        try {
            Process exec = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", "su"});
            z2 = new BufferedReader(new InputStreamReader(exec.getInputStream())).readLine() != null;
            exec.destroy();
        } catch (Throwable unused) {
            if (process != null) {
                process.destroy();
            }
            z2 = false;
        }
        if (z2) {
            return true;
        }
        return false;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("IsAppTrusted", Boolean.valueOf(this.f2151f));
            jSONObject.putOpt("IsJailbroken", Boolean.valueOf(this.f2147b));
            jSONObject.putOpt("IsSDKTempered", Boolean.valueOf(this.f2150e));
            jSONObject.putOpt("IsEmulator", Boolean.valueOf(this.f2146a));
            jSONObject.putOpt("IsDebuggerAttached", Boolean.valueOf(this.f2148c));
            jSONObject.putOpt("IsOSSupported", Boolean.valueOf(this.f2149d));
        } catch (JSONException e2) {
            a.e().b(String.valueOf(13101), e2.getLocalizedMessage(), null);
        }
        return jSONObject;
    }
}
