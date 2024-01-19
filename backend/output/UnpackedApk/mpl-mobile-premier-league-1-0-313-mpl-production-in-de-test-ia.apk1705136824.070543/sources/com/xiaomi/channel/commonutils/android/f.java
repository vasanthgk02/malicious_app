package com.xiaomi.channel.commonutils.android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.mpl.androidapp.utils.Constant;
import com.razorpay.BaseConstants;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.z;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.fontbox.afm.AFMParser;
import org.apache.fontbox.cmap.CMap;
import org.apache.fontbox.cmap.CMapParser;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.StandardStructureTypes;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f4311a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static Map<String, Region> f175a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f4312b = -1;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0024 A[Catch:{ all -> 0x0029 }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025 A[Catch:{ all -> 0x0029 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a() {
        /*
            int r0 = f4311a
            if (r0 != 0) goto L_0x0043
            r0 = 0
            java.lang.String r1 = "ro.miui.ui.version.code"
            java.lang.String r1 = a(r1)     // Catch:{ all -> 0x0029 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0029 }
            r2 = 1
            if (r1 == 0) goto L_0x0021
            java.lang.String r1 = "ro.miui.ui.version.name"
            java.lang.String r1 = a(r1)     // Catch:{ all -> 0x0029 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0029 }
            if (r1 != 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            r1 = 0
            goto L_0x0022
        L_0x0021:
            r1 = 1
        L_0x0022:
            if (r1 == 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r2 = 2
        L_0x0026:
            f4311a = r2     // Catch:{ all -> 0x0029 }
            goto L_0x0031
        L_0x0029:
            r1 = move-exception
            java.lang.String r2 = "get isMIUI failed"
            com.xiaomi.channel.commonutils.logger.b.a(r2, r1)
            f4311a = r0
        L_0x0031:
            java.lang.String r0 = "isMIUI's value is: "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            int r1 = f4311a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.b.b(r0)
        L_0x0043:
            int r0 = f4311a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.android.f.a():int");
    }

    public static int a(Context context) {
        String a2 = a((String) "ro.miui.ui.version.code");
        if (TextUtils.isEmpty(a2) || !TextUtils.isDigitsOnly(a2)) {
            return 0;
        }
        return Integer.parseInt(a2);
    }

    public static Region a(String str) {
        a();
        return f175a.get(str.toUpperCase());
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m322a() {
        int a2 = j.a();
        return (!a() || a2 <= 0) ? "" : a2 < 2 ? "alpha" : a2 < 3 ? BaseConstants.DEVELOPMENT : "stable";
    }

    public static String a(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.toString() + CMap.SPACE + a(intent.getExtras());
    }

    public static String a(Bundle bundle) {
        String a2;
        StringBuilder sb = new StringBuilder("Bundle[");
        if (bundle == null) {
            sb.append("null");
        } else {
            boolean z = true;
            for (String str : bundle.keySet()) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append('=');
                Object obj = bundle.get(str);
                if (obj instanceof int[]) {
                    a2 = Arrays.toString((int[]) obj);
                } else if (obj instanceof byte[]) {
                    a2 = Arrays.toString((byte[]) obj);
                } else if (obj instanceof boolean[]) {
                    a2 = Arrays.toString((boolean[]) obj);
                } else if (obj instanceof short[]) {
                    a2 = Arrays.toString((short[]) obj);
                } else if (obj instanceof long[]) {
                    a2 = Arrays.toString((long[]) obj);
                } else if (obj instanceof float[]) {
                    a2 = Arrays.toString((float[]) obj);
                } else if (obj instanceof double[]) {
                    a2 = Arrays.toString((double[]) obj);
                } else if (obj instanceof String[]) {
                    a2 = Arrays.toString((String[]) obj);
                } else if (obj instanceof CharSequence[]) {
                    a2 = Arrays.toString((CharSequence[]) obj);
                } else if (obj instanceof Parcelable[]) {
                    a2 = Arrays.toString((Parcelable[]) obj);
                } else if (obj instanceof Bundle) {
                    a2 = a((Bundle) obj);
                } else {
                    sb.append(obj);
                    z = false;
                }
                sb.append(a2);
                z = false;
            }
        }
        sb.append(CMapParser.MARK_END_OF_ARRAY);
        return sb.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m323a(String str) {
        try {
            return (String) z.a((String) "android.os.SystemProperties", (String) Constant.GET, str, "");
        } catch (Exception e2) {
            b.d("fail to get property. " + e2);
        } catch (Throwable unused) {
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m324a() {
        if (f175a == null) {
            HashMap hashMap = new HashMap();
            f175a = hashMap;
            hashMap.put("FI", Region.Europe);
            f175a.put("SE", Region.Europe);
            f175a.put("NO", Region.Europe);
            f175a.put("FO", Region.Europe);
            f175a.put("EE", Region.Europe);
            f175a.put("LV", Region.Europe);
            f175a.put("LT", Region.Europe);
            f175a.put("BY", Region.Europe);
            f175a.put("MD", Region.Europe);
            f175a.put("UA", Region.Europe);
            f175a.put("PL", Region.Europe);
            f175a.put("CZ", Region.Europe);
            f175a.put("SK", Region.Europe);
            f175a.put("HU", Region.Europe);
            f175a.put("DE", Region.Europe);
            f175a.put("AT", Region.Europe);
            f175a.put(AFMParser.CHARMETRICS_CH, Region.Europe);
            f175a.put(StandardStructureTypes.LI, Region.Europe);
            f175a.put("GB", Region.Europe);
            f175a.put("IE", Region.Europe);
            f175a.put("NL", Region.Europe);
            f175a.put("BE", Region.Europe);
            f175a.put("LU", Region.Europe);
            f175a.put("FR", Region.Europe);
            f175a.put("RO", Region.Europe);
            f175a.put("BG", Region.Europe);
            f175a.put("RS", Region.Europe);
            f175a.put("MK", Region.Europe);
            f175a.put("AL", Region.Europe);
            f175a.put("GR", Region.Europe);
            f175a.put("SI", Region.Europe);
            f175a.put("HR", Region.Europe);
            f175a.put("IT", Region.Europe);
            f175a.put("SM", Region.Europe);
            f175a.put("MT", Region.Europe);
            f175a.put("ES", Region.Europe);
            f175a.put("PT", Region.Europe);
            f175a.put("AD", Region.Europe);
            f175a.put("CY", Region.Europe);
            f175a.put("DK", Region.Europe);
            f175a.put("IS", Region.Europe);
            f175a.put("EL", Region.Europe);
            f175a.put("UK", Region.Europe);
            f175a.put("RU", Region.Russia);
            f175a.put("IN", Region.India);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m325a() {
        return a() == 1;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m326a(Context context) {
        return context != null && a(context.getPackageName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m327a(String str) {
        return "com.xiaomi.xmsf".equals(str);
    }

    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String b() {
        String a2 = i.a("ro.miui.region", "");
        if (TextUtils.isEmpty(a2)) {
            a2 = i.a("persist.sys.oppo.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = i.a("ro.oppo.regionmark", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = i.a("ro.vendor.oplus.regionmark", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = i.a("ro.hw.country", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = i.a("ro.csc.countryiso_code", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = d(i.a("ro.product.country.region", ""));
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = i.a("gsm.vivo.countrycode", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = i.a("persist.sys.oem.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = i.a("ro.product.locale.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = i.a("persist.sys.country", "");
        }
        if (!TextUtils.isEmpty(a2)) {
            b.a("get region from system, region = " + a2);
        }
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        String country = Locale.getDefault().getCountry();
        b.a("locale.default.country = " + country);
        return country;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            b.a((String) "The country code of null is unexpected.");
            return Region.Global.name();
        } else if ("CN".equalsIgnoreCase(str)) {
            b.a((String) "The country code of CN is unexpected.");
            return "China";
        } else {
            Region a2 = a(str);
            if (a2 == null) {
                b.a("Unmatched country code: " + str);
                a2 = Region.Global;
            }
            return a2.name();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m328b() {
        if (f4312b < 0) {
            f4312b = d() ^ true ? 1 : 0;
        }
        return f4312b > 0;
    }

    public static String c() {
        return a((String) "ro.miui.ui.version.name");
    }

    public static String c(String str) {
        return Region.Global.name().equals(str) ? "SG" : Region.Europe.name().equals(str) ? "DE" : Region.Russia.name().equals(str) ? "RU" : Region.India.name().equals(str) ? "IN" : "";
    }

    /* renamed from: c  reason: collision with other method in class */
    public static boolean m329c() {
        return true;
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        return split.length > 0 ? split[0] : str;
    }

    public static boolean d() {
        String str = "";
        try {
            str = i.a("ro.miui.ui.version.code", str);
        } catch (Exception unused) {
        }
        return !TextUtils.isEmpty(str);
    }
}
