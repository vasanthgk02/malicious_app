package lib.android.paypal.com.magnessdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import com.razorpay.AnalyticsConstants;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.regex.Pattern;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import lib.android.paypal.com.magnessdk.c$d.c;
import lib.android.paypal.com.magnessdk.c$d.d;
import lib.android.paypal.com.magnessdk.c$d.f;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class h extends g {
    public String bA;
    public String bB;
    public String bC;
    public String bD;
    public String bE;
    public String bF;
    public String bG;
    public String bH;
    public String bI;
    public String bJ;
    public String bK;
    public int bL;
    public boolean bM;
    public boolean bN;
    public String bO;
    public boolean bP;
    public String bQ;
    public long bR = -1;
    public long bS = -1;
    public long bT = -1;
    public JSONObject bU;
    public JSONObject bV;
    public JSONObject bW;
    public JSONObject bX;
    public JSONObject bY;
    public JSONArray bZ;
    public String bx;
    public String by;
    public String bz;
    public JSONObject ca;
    public JSONArray cb;
    public e cc;

    /* renamed from: lib.android.paypal.com.magnessdk.h$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f6101a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0031 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0015 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0023 */
        static {
            /*
                lib.android.paypal.com.magnessdk.c$k$b[] r0 = lib.android.paypal.com.magnessdk.c$k.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6101a = r0
                lib.android.paypal.com.magnessdk.c$k$b r1 = lib.android.paypal.com.magnessdk.c$k.b.f6089b     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r0 = f6101a     // Catch:{ NoSuchFieldError -> 0x0015 }
                lib.android.paypal.com.magnessdk.c$k$b r1 = lib.android.paypal.com.magnessdk.c$k.b.f6090c     // Catch:{ NoSuchFieldError -> 0x0015 }
                r1 = 2
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                int[] r0 = f6101a     // Catch:{ NoSuchFieldError -> 0x001c }
                lib.android.paypal.com.magnessdk.c$k$b r1 = lib.android.paypal.com.magnessdk.c$k.b.f6091d     // Catch:{ NoSuchFieldError -> 0x001c }
                r1 = 3
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                int[] r0 = f6101a     // Catch:{ NoSuchFieldError -> 0x0023 }
                lib.android.paypal.com.magnessdk.c$k$b r1 = lib.android.paypal.com.magnessdk.c$k.b.f6092e     // Catch:{ NoSuchFieldError -> 0x0023 }
                r1 = 4
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                int[] r0 = f6101a     // Catch:{ NoSuchFieldError -> 0x002a }
                lib.android.paypal.com.magnessdk.c$k$b r1 = lib.android.paypal.com.magnessdk.c$k.b.f6093f     // Catch:{ NoSuchFieldError -> 0x002a }
                r1 = 5
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f6101a     // Catch:{ NoSuchFieldError -> 0x0031 }
                lib.android.paypal.com.magnessdk.c$k$b r1 = lib.android.paypal.com.magnessdk.c$k.b.g     // Catch:{ NoSuchFieldError -> 0x0031 }
                r1 = 6
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0031 }
            L_0x0031:
                int[] r0 = f6101a     // Catch:{ NoSuchFieldError -> 0x0038 }
                lib.android.paypal.com.magnessdk.c$k$b r1 = lib.android.paypal.com.magnessdk.c$k.b.h     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1 = 7
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: lib.android.paypal.com.magnessdk.h.AnonymousClass2.<clinit>():void");
        }
    }

    public static final class a {

        /* renamed from: b  reason: collision with root package name */
        public static Boolean[] f6102b;

        public static String b(Context context) {
            if (f6102b == null) {
                f6102b = new Boolean[5];
                for (int i = 0; i < 5; i++) {
                    boolean z = true;
                    if (i == 0) {
                        if (!(Build.MANUFACTURER.equals(c.n.toString()) || Build.MANUFACTURER.equals(c.j.toString()) || Build.MANUFACTURER.contains(c.f5996d.toString()))) {
                            if (!(Build.BRAND.equals(c.h.toString()) || Build.BRAND.equals(c.i.toString()) || Build.BRAND.equals("Android") || Build.BRAND.equals(c.f5996d.toString()))) {
                                if (!(Build.DEVICE.equals(c.f5997e.toString()) || Build.DEVICE.equals(c.g.toString()) || Build.DEVICE.equals(c.h.toString()) || Build.DEVICE.equals(c.i.toString()) || Build.DEVICE.equals(c.p.toString()))) {
                                    if (!(Build.HARDWARE.equals(c.k.toString()) || Build.HARDWARE.equals(c.o.toString()) || Build.HARDWARE.equals(c.f5995c.toString()) || Build.HARDWARE.equals(c.q.toString()) || Build.HARDWARE.equals(c.s.toString()) || Build.HARDWARE.equals(c.f5994b.toString()))) {
                                        if (!(Build.MODEL.equals(c.m.toString()) || Build.MODEL.equals(c.l.toString()) || Build.MODEL.equals(c.f5993a.toString())) && !Build.FINGERPRINT.startsWith(c.h.toString())) {
                                            if (Build.PRODUCT.matches(".*_?sdk_?.*") || Build.PRODUCT.equals(c.p.toString()) || Build.PRODUCT.equals(c.j.toString()) || Build.PRODUCT.equals(c.f5998f.toString()) || Build.PRODUCT.equals(c.f5997e.toString()) || Build.PRODUCT.equals(c.r.toString())) {
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        f6102b[i] = Boolean.valueOf(z);
                    } else if (i != 1) {
                        if (i == 2) {
                            z = lib.android.paypal.com.magnessdk.a.c.a(c$f.f6041b, (String) "");
                        } else if (i == 3) {
                            z = TypeUtilsKt.a(context, new ArrayList(Arrays.asList(c$f.f6040a)));
                        } else if (i == 4) {
                            if (!lib.android.paypal.com.magnessdk.a.c.a(c$f.f6043d, (String) "")) {
                                if (!lib.android.paypal.com.magnessdk.a.c.a(c$f.f6044e, (String) "")) {
                                    if (lib.android.paypal.com.magnessdk.a.c.a(c$f.f6042c, (String) "")) {
                                    }
                                }
                            }
                        }
                        f6102b[i] = Boolean.valueOf(z);
                    } else {
                        String[] strArr = c$f.f6045f;
                        if (!new File(Environment.getExternalStorageDirectory().toString() + File.separatorChar + "windows" + File.separatorChar + "BstSharedFolder").exists()) {
                            if (lib.android.paypal.com.magnessdk.a.c.a(strArr, (String) "")) {
                            }
                        }
                        f6102b[i] = Boolean.valueOf(z);
                    }
                    z = false;
                    f6102b[i] = Boolean.valueOf(z);
                }
            }
            return f.a(f6102b);
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static int f6103a = lib.android.paypal.com.magnessdk.c$k.b.f6088a.a();

        /* renamed from: b  reason: collision with root package name */
        public static Boolean[] f6104b = null;

        public static boolean a(String str) {
            return lib.android.paypal.com.magnessdk.a.c.a(c$k.SU_PATHS.a(), str);
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.String b(android.content.Context r6) {
            /*
                java.lang.Class<lib.android.paypal.com.magnessdk.h$b> r0 = lib.android.paypal.com.magnessdk.h.b.class
                java.lang.Boolean[] r1 = f6104b
                if (r1 != 0) goto L_0x0093
                int r1 = f6103a
                java.lang.Boolean[] r1 = new java.lang.Boolean[r1]
                f6104b = r1
                r1 = 0
                r2 = 0
            L_0x000e:
                int r3 = f6103a
                if (r2 >= r3) goto L_0x0093
                lib.android.paypal.com.magnessdk.c$k$b r3 = lib.android.paypal.com.magnessdk.c$k.b.a(r2)
                if (r3 != 0) goto L_0x001a
                r6 = 0
                return r6
            L_0x001a:
                int[] r4 = lib.android.paypal.com.magnessdk.h.AnonymousClass2.f6101a
                int r3 = r3.ordinal()
                r3 = r4[r3]
                r4 = 3
                switch(r3) {
                    case 1: goto L_0x0079;
                    case 2: goto L_0x0063;
                    case 3: goto L_0x004d;
                    case 4: goto L_0x0039;
                    case 5: goto L_0x002e;
                    case 6: goto L_0x002b;
                    case 7: goto L_0x0028;
                    default: goto L_0x0026;
                }
            L_0x0026:
                r3 = 0
                goto L_0x0087
            L_0x0028:
                lib.android.paypal.com.magnessdk.c$k$a r3 = lib.android.paypal.com.magnessdk.c$k.a.f6085c
                goto L_0x0030
            L_0x002b:
                lib.android.paypal.com.magnessdk.c$k$a r3 = lib.android.paypal.com.magnessdk.c$k.a.f6084b
                goto L_0x0030
            L_0x002e:
                lib.android.paypal.com.magnessdk.c$k$a r3 = lib.android.paypal.com.magnessdk.c$k.a.f6083a
            L_0x0030:
                java.lang.String r3 = r3.toString()
                boolean r3 = a(r3)
                goto L_0x0087
            L_0x0039:
                java.util.ArrayList r3 = new java.util.ArrayList
                lib.android.paypal.com.magnessdk.c$k r4 = lib.android.paypal.com.magnessdk.c$k.KNOWN_ROOT_APPS_PACKAGES
                java.lang.String[] r4 = r4.a()
                java.util.List r4 = java.util.Arrays.asList(r4)
                r3.<init>(r4)
                boolean r3 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.a(r6, r3)
                goto L_0x0087
            L_0x004d:
                java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x005e }
                java.lang.String r5 = "superUserApk"
                java.lang.String r5 = b(r5)     // Catch:{ Exception -> 0x005e }
                r3.<init>(r5)     // Catch:{ Exception -> 0x005e }
                boolean r3 = r3.exists()     // Catch:{ Exception -> 0x005e }
                goto L_0x0087
            L_0x005e:
                r3 = move-exception
                lib.android.paypal.com.magnessdk.b.a.a(r0, r4, r3)
                goto L_0x0026
            L_0x0063:
                java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0074 }
                java.lang.String r5 = "suFileName"
                java.lang.String r5 = b(r5)     // Catch:{ Exception -> 0x0074 }
                r3.<init>(r5)     // Catch:{ Exception -> 0x0074 }
                boolean r3 = r3.exists()     // Catch:{ Exception -> 0x0074 }
                goto L_0x0087
            L_0x0074:
                r3 = move-exception
                lib.android.paypal.com.magnessdk.b.a.a(r0, r4, r3)
                goto L_0x0026
            L_0x0079:
                java.lang.String r3 = android.os.Build.TAGS
                if (r3 == 0) goto L_0x0026
                java.lang.String r4 = "test-keys"
                boolean r3 = r3.contains(r4)
                if (r3 == 0) goto L_0x0026
                r3 = 1
            L_0x0087:
                java.lang.Boolean[] r4 = f6104b
                java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
                r4[r2] = r3
                int r2 = r2 + 1
                goto L_0x000e
            L_0x0093:
                java.lang.Boolean[] r6 = f6104b
                java.lang.String r6 = lib.android.paypal.com.magnessdk.f.a(r6)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: lib.android.paypal.com.magnessdk.h.b.b(android.content.Context):java.lang.String");
        }

        public static String b(String str) throws IOException {
            Properties properties = new Properties();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("suFileName=/system/xbin/su\nsuperUserApk=/system/app/Superuser.apk\nemptyIp=0.0.0.0".getBytes("UTF-8"));
            try {
                properties.load(byteArrayInputStream);
            } catch (Exception e2) {
                lib.android.paypal.com.magnessdk.b.a.a(b.class, 3, (Throwable) e2);
            } catch (Throwable th) {
                byteArrayInputStream.close();
                throw th;
            }
            byteArrayInputStream.close();
            return properties.getProperty(str);
        }
    }

    public final JSONArray a(MagnesSettings magnesSettings) {
        try {
            JSONArray jSONArray = new JSONArray();
            SensorManager sensorManager = (SensorManager) magnesSettings.context.getSystemService("sensor");
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            Sensor defaultSensor2 = sensorManager.getDefaultSensor(4);
            Sensor defaultSensor3 = sensorManager.getDefaultSensor(2);
            if (defaultSensor != null) {
                JSONObject a2 = f.a(defaultSensor);
                a2.put(c$a.SENSOR_TYPE.toString(), c$l.AC.toString());
                jSONArray.put(a2);
            }
            if (defaultSensor2 != null) {
                JSONObject a3 = f.a(defaultSensor2);
                a3.put(c$a.SENSOR_TYPE.toString(), c$l.GY.toString());
                jSONArray.put(a3);
            }
            if (defaultSensor3 != null) {
                JSONObject a4 = f.a(defaultSensor3);
                a4.put(c$a.SENSOR_TYPE.toString(), c$l.MG.toString());
                jSONArray.put(a4);
            }
            return jSONArray;
        } catch (Exception e2) {
            lib.android.paypal.com.magnessdk.b.a.a(h.class, 3, (Throwable) e2);
            return null;
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(c$d.APP_GUID.toString(), this.bx);
            jSONObject.put(c$d.APP_ID.toString(), this.by);
            jSONObject.put(c$d.ANDROID_ID.toString(), this.bD);
            jSONObject.put(c$d.APP_VERSION.toString(), this.bz);
            Long l = null;
            jSONObject.put(c$d.APP_FIRST_INSTALL_TIME.toString(), this.bS == -1 ? null : Long.valueOf(this.bS));
            jSONObject.put(c$d.APP_LAST_UPDATE_TIME.toString(), this.bT == -1 ? null : Long.valueOf(this.bT));
            jSONObject.put(c$d.CONF_URL.toString(), this.bJ);
            jSONObject.put(c$d.COMP_VERSION.toString(), this.bK);
            jSONObject.put(c$d.DEVICE_MODEL.toString(), this.bA);
            jSONObject.put(c$d.DEVICE_NAME.toString(), this.bB);
            jSONObject.put(c$d.GSF_ID.toString(), this.bE);
            jSONObject.put(c$d.IS_EMULATOR.toString(), this.bN);
            jSONObject.put(c$d.EMULATOR_FLAGS.toString(), this.bO);
            jSONObject.put(c$d.IS_ROOTED.toString(), this.bP);
            jSONObject.put(c$d.ROOTED_FLAGS.toString(), this.bQ);
            jSONObject.put(c$d.OS_TYPE.toString(), "Android");
            jSONObject.put(c$d.OS_VERSION.toString(), this.bC);
            jSONObject.put(c$d.PAYLOAD_TYPE.toString(), this.bG);
            jSONObject.put(c$d.SMS_ENABLED.toString(), this.bM);
            jSONObject.put(c$d.MAC_ADDRS.toString(), this.bF);
            jSONObject.put(c$d.MAGNES_GUID.toString(), this.bU);
            jSONObject.put(c$d.MAGNES_SOURCE.toString(), this.bL == 0 ? null : Integer.valueOf(this.bL));
            jSONObject.put(c$d.NOTIF_TOKEN.toString(), this.bI);
            jSONObject.put(c$d.SOURCE_APP_VERSION.toString(), this.bH);
            String c_d = c$d.TOTAL_STORAGE_SPACE.toString();
            if (this.bR != -1) {
                l = Long.valueOf(this.bR);
            }
            jSONObject.put(c_d, l);
            jSONObject.put(c$d.NOT_COLLECTIBLE_LIST.toString(), this.bZ);
            jSONObject.put(c$d.SENSOR_METADATA.toString(), this.cb);
            jSONObject.put(c$d.SCREEN.toString(), this.bV);
            jSONObject.put(c$d.CPU.toString(), this.bW);
            jSONObject.put(c$d.DISK.toString(), this.bX);
            jSONObject.put(c$d.SYSTEM.toString(), this.bY);
            jSONObject.put(c$d.USER_AGENT.toString(), this.ca);
            jSONObject.put(c$d.IN_TREATMENT.toString(), g.bj);
            return jSONObject;
        } catch (JSONException e2) {
            lib.android.paypal.com.magnessdk.b.a.a(h.class, 3, (Throwable) e2);
            return jSONObject;
        }
    }

    public final int b(int i) {
        int i2;
        File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new FileFilter(this) {
            public boolean accept(File file) {
                return Pattern.matches("cpu[0-9]+", file.getName());
            }
        });
        int i3 = -403;
        if (i == 3) {
            i3 = listFiles.length;
        } else {
            int i4 = 0;
            if (i == 2) {
                int length = listFiles.length;
                i2 = Integer.MAX_VALUE;
                while (true) {
                    if (i4 >= length) {
                        break;
                    }
                    File file = listFiles[i4];
                    String b2 = lib.android.paypal.com.magnessdk.a.c.b(new File(file.getPath() + "/cpufreq/cpuinfo_min_freq"));
                    if (b2 == null || b2.equals("-403")) {
                        break;
                    }
                    int parseInt = Integer.parseInt(b2);
                    if (parseInt < i2) {
                        i2 = parseInt;
                    }
                    i4++;
                }
            } else if (i == 1) {
                int length2 = listFiles.length;
                i2 = 0;
                while (true) {
                    if (i4 >= length2) {
                        break;
                    }
                    File file2 = listFiles[i4];
                    File file3 = new File(file2.getPath() + "/cpufreq/cpuinfo_max_freq");
                    String b3 = lib.android.paypal.com.magnessdk.a.c.b(file3);
                    if (b3 == null || b3.equals("-403")) {
                        break;
                    }
                    int parseInt2 = Integer.parseInt(lib.android.paypal.com.magnessdk.a.c.b(file3));
                    if (parseInt2 > i2) {
                        i2 = parseInt2;
                    }
                    i4++;
                }
            } else {
                i3 = 12345;
            }
            i3 = i2;
        }
        if (i3 == 0 || i3 == Integer.MAX_VALUE) {
            return 12345;
        }
        return i3;
    }

    public final String d(Context context) {
        Uri uri;
        try {
            uri = Uri.parse("content://com.google.android.gsf.gservices");
        } catch (Exception unused) {
            uri = null;
        }
        if (uri == null || !a(context, (String) "com.google.android.providers.gsf.permission.READ_GSERVICES")) {
            return null;
        }
        Cursor query = context.getContentResolver().query(uri, null, null, new String[]{"android_id"}, null);
        if (query == null) {
            return null;
        }
        try {
            if (query.moveToFirst()) {
                if (query.getColumnCount() >= 2) {
                    String hexString = Long.toHexString(Long.parseLong(query.getString(1)));
                    query.close();
                    return hexString;
                }
            }
            return null;
        } catch (NumberFormatException e2) {
            lib.android.paypal.com.magnessdk.b.a.a(getClass(), 3, (Throwable) e2);
            return null;
        } finally {
            query.close();
        }
    }

    public final JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
        try {
            jSONObject.put(lib.android.paypal.com.magnessdk.c$d.b.f5989a.toString(), a((Object) Long.valueOf(a(601))));
            jSONObject.put(lib.android.paypal.com.magnessdk.c$d.b.f5990b.toString(), a((Object) Long.valueOf(blockSize)));
        } catch (JSONException e2) {
            lib.android.paypal.com.magnessdk.b.a.a(h.class, 3, (Throwable) e2);
        }
        return jSONObject;
    }

    public final JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            int b2 = b(3);
            int b3 = b(2);
            int b4 = b(1);
            jSONObject.put(lib.android.paypal.com.magnessdk.c$d.a.f5986c.toString(), a((Object) Integer.valueOf(b3)));
            jSONObject.put(lib.android.paypal.com.magnessdk.c$d.a.f5985b.toString(), a((Object) Integer.valueOf(b4)));
            jSONObject.put(lib.android.paypal.com.magnessdk.c$d.a.f5984a.toString(), a((Object) Integer.valueOf(b2)));
        } catch (JSONException e2) {
            lib.android.paypal.com.magnessdk.b.a.a(h.class, 3, (Throwable) e2);
        }
        return jSONObject;
    }

    public final JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            String property = System.getProperty("os.name");
            String property2 = System.getProperty("os.version");
            Object[] objArr = new Object[2];
            if (TextUtils.isEmpty(property)) {
                property = "";
            }
            objArr[0] = property;
            if (TextUtils.isEmpty(property2)) {
                property2 = "";
            }
            objArr[1] = property2;
            String format = String.format("%s %s", objArr);
            if (!TextUtils.isEmpty(format)) {
                jSONObject.put(f.f6011a.toString(), a((Object) format.trim()));
            }
            jSONObject.put(f.f6012b.toString(), a((Object) Build.BOARD));
            jSONObject.put(f.f6013c.toString(), a((Object) Build.BOOTLOADER));
            jSONObject.put(f.f6014d.toString(), a((Object) Build.SUPPORTED_ABIS[0]));
            jSONObject.put(f.f6015e.toString(), a((Object) Build.DISPLAY));
            jSONObject.put(f.f6016f.toString(), a((Object) Build.getRadioVersion()));
            jSONObject.put(f.g.toString(), a((Object) Build.FINGERPRINT));
            jSONObject.put(f.h.toString(), a((Object) Build.HARDWARE));
            jSONObject.put(f.i.toString(), a((Object) Build.MANUFACTURER));
            jSONObject.put(f.j.toString(), a((Object) Build.PRODUCT));
            jSONObject.put(f.k.toString(), a((Object) Long.valueOf(Build.TIME)));
            jSONObject.put(f.l.toString(), a((Object) System.getProperty("os.arch")));
        } catch (JSONException e2) {
            lib.android.paypal.com.magnessdk.b.a.a(h.class, 3, (Throwable) e2);
        }
        return jSONObject;
    }

    public final JSONObject i(Context context) {
        float f2;
        float f3;
        float f4;
        int i;
        float f5;
        int i2;
        JSONObject jSONObject = new JSONObject();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        int i3 = 12345;
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            int i4 = point.x;
            i2 = point.y;
            f5 = displayMetrics.density;
            i = displayMetrics.densityDpi;
            f4 = displayMetrics.scaledDensity;
            f3 = displayMetrics.xdpi;
            float f6 = displayMetrics.ydpi;
            i3 = i4;
            f2 = f6;
        } else {
            f2 = 12345.0f;
            i2 = 12345;
            f5 = 12345.0f;
            i = 12345;
            f4 = 12345.0f;
            f3 = 12345.0f;
        }
        try {
            jSONObject.put(d.f6003e.toString(), a((Object) Integer.valueOf(i3)));
            jSONObject.put(d.f6001c.toString(), a((Object) Integer.valueOf(i2)));
            jSONObject.put(d.f5999a.toString(), a((Object) Float.valueOf(f5)));
            jSONObject.put(d.f6000b.toString(), a((Object) Integer.valueOf(i)));
            jSONObject.put(d.f6002d.toString(), a((Object) Float.valueOf(f4)));
            jSONObject.put(d.f6004f.toString(), a((Object) Float.valueOf(f3)));
            jSONObject.put(d.g.toString(), a((Object) Float.valueOf(f2)));
        } catch (Exception e2) {
            lib.android.paypal.com.magnessdk.b.a.a(h.class, 3, (Throwable) e2);
        }
        return jSONObject;
    }

    public JSONObject a(MagnesSettings magnesSettings, d dVar, e eVar) {
        this.cc = eVar;
        lib.android.paypal.com.magnessdk.b.a.a(h.class, 0, (String) "collecting RiskBlobCoreData");
        a(1, magnesSettings);
        a(2, magnesSettings);
        a(3, magnesSettings);
        a(65, magnesSettings);
        a(66, magnesSettings);
        a(69, magnesSettings);
        a(8, magnesSettings);
        a(9, magnesSettings);
        a(14, magnesSettings);
        a(15, magnesSettings);
        a(70, magnesSettings);
        a(59, magnesSettings);
        a(103, magnesSettings);
        a(60, magnesSettings);
        a(100, magnesSettings);
        a(32, magnesSettings);
        a(86, magnesSettings);
        a(62, magnesSettings);
        a(34, magnesSettings);
        a(37, magnesSettings);
        a(38, magnesSettings);
        a(63, magnesSettings);
        a(47, magnesSettings);
        a(52, magnesSettings);
        a(88, magnesSettings);
        g.bj = false;
        if (a(dVar, magnesSettings.magnesSource, g.bk, "hw", magnesSettings.context)) {
            a(91, magnesSettings);
            a(90, magnesSettings);
            a(93, magnesSettings);
            a(94, magnesSettings);
            a(95, magnesSettings);
            a(101, magnesSettings);
        }
        return a();
    }

    public void a(int i, MagnesSettings magnesSettings) {
        Class<h> cls = h.class;
        try {
            Context context = magnesSettings.context;
            boolean z = true;
            String str = null;
            boolean z2 = false;
            switch (i) {
                case 1:
                    String str2 = magnesSettings.appGuid;
                    SharedPreferences sharedPreferences = context.getSharedPreferences("RiskManagerAG", 0);
                    String string = sharedPreferences.getString("RiskManagerAG", "");
                    Editor edit = sharedPreferences.edit();
                    if (str2 == null || str2.equals(string)) {
                        if (string.equals("")) {
                            str2 = f.a(true);
                        }
                        this.bx = string;
                        return;
                    }
                    edit.putString("RiskManagerAG", str2);
                    edit.apply();
                    string = str2;
                    this.bx = string;
                    return;
                case 2:
                    this.by = context.getPackageName();
                    return;
                case 3:
                    if (this.cc.a(i)) {
                        this.bz = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                        return;
                    }
                    return;
                case 8:
                    this.bK = "5.1.1.release";
                    return;
                case 9:
                    if (this.cc.a(i)) {
                        this.bJ = c$h$d.REMOTE_CONFIG_URL.toString();
                        return;
                    }
                    return;
                case 14:
                    if (this.cc.a(i)) {
                        this.bA = Build.MODEL;
                        return;
                    }
                    return;
                case 15:
                    if (this.cc.a(i)) {
                        this.bB = Build.DEVICE;
                        return;
                    }
                    return;
                case 32:
                    if (this.cc.a(i)) {
                        WifiInfo connectionInfo = a(context, (String) "android.permission.ACCESS_WIFI_STATE") ? ((WifiManager) context.getApplicationContext().getSystemService(AnalyticsConstants.WIFI)).getConnectionInfo() : null;
                        if (connectionInfo != null) {
                            str = connectionInfo.getMacAddress();
                        }
                        this.bF = str;
                        return;
                    }
                    return;
                case 34:
                    if (this.cc.a(i)) {
                        this.bI = magnesSettings.notificationToken;
                        return;
                    }
                    return;
                case 37:
                    if (this.cc.a(i)) {
                        this.bC = VERSION.RELEASE;
                        return;
                    }
                    return;
                case 38:
                    if (this.cc.a(i)) {
                        this.bG = "full";
                        return;
                    }
                    return;
                case 47:
                    if (this.cc.a(i)) {
                        this.bM = context.getPackageManager().hasSystemFeature("android.hardware.telephony");
                        return;
                    }
                    return;
                case 52:
                    if (this.cc.a(i)) {
                        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                        this.bR = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
                        return;
                    }
                    return;
                case 59:
                    if (this.cc.a(i)) {
                        String b2 = a.b(context);
                        if (b2 == null || !b2.contains("1")) {
                            z = false;
                        }
                        this.bN = z;
                        return;
                    }
                    return;
                case 60:
                    if (this.cc.a(i)) {
                        String b3 = b.b(context);
                        if (b3 != null) {
                            z2 = b3.contains("1");
                        }
                        this.bP = z2;
                        return;
                    }
                    return;
                case 62:
                    if (this.cc.a(i)) {
                        this.bL = magnesSettings.magnesSource;
                        return;
                    }
                    return;
                case 63:
                    if (this.cc.a(i)) {
                        this.bH = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                        return;
                    }
                    return;
                case 65:
                    if (this.cc.a(i)) {
                        this.bS = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
                        return;
                    }
                    return;
                case 66:
                    if (this.cc.a(i)) {
                        this.bT = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
                        return;
                    }
                    return;
                case 69:
                    if (this.cc.a(i)) {
                        this.bD = Secure.getString(context.getContentResolver(), "android_id");
                        return;
                    }
                    return;
                case 70:
                    if (this.cc.a(i)) {
                        this.bE = d(context);
                        return;
                    }
                    return;
                case 86:
                    JSONObject b4 = b(context);
                    this.bU = b4;
                    g.bk = b4.optString("id");
                    return;
                case 88:
                    if (this.cc == null) {
                        throw null;
                    } else if (!e.o) {
                        return;
                    } else {
                        if (this.cc != null) {
                            this.bZ = e.p;
                            return;
                        }
                        throw null;
                    }
                case 90:
                    if (this.cc.a(i)) {
                        this.bW = e();
                        return;
                    }
                    return;
                case 91:
                    if (this.cc.a(i)) {
                        this.bV = i(context);
                        return;
                    }
                    return;
                case 93:
                    if (this.cc.a(i)) {
                        this.bX = d();
                        return;
                    }
                    return;
                case 94:
                    if (this.cc.a(i)) {
                        this.bY = f();
                        return;
                    }
                    return;
                case 95:
                    if (this.cc.a(i)) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("dua", a((Object) WebSettings.getDefaultUserAgent(context)));
                        } catch (Exception e2) {
                            lib.android.paypal.com.magnessdk.b.a.a(cls, 3, (Throwable) e2);
                        }
                        this.ca = jSONObject;
                        return;
                    }
                    return;
                case 100:
                    if (this.cc.a(i)) {
                        this.bQ = b.b(context);
                        return;
                    }
                    return;
                case 101:
                    if (this.cc.a(i)) {
                        this.cb = a(magnesSettings);
                        return;
                    }
                    return;
                case 103:
                    if (this.cc.a(i)) {
                        this.bO = a.b(context);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } catch (Exception e3) {
            lib.android.paypal.com.magnessdk.b.a.a(cls, 3, (Throwable) e3);
        }
        lib.android.paypal.com.magnessdk.b.a.a(cls, 3, (Throwable) e3);
    }
}
