package lib.android.paypal.com.magnessdk;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings.Global;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import lib.android.paypal.com.magnessdk.b.a;
import lib.android.paypal.com.magnessdk.c$e.b;
import lib.android.paypal.com.magnessdk.c$e.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class i extends g {
    public int bG = -1;
    public int bH = -1;
    public int bI = -1;
    public int bJ = -1;
    public int bK = -1;
    public int bL = -1;
    public String bM;
    public String bN;
    public String bO;
    public String bP;
    public String bQ;
    public String bR;
    public String bS;
    public String bT;
    public String bU;
    public String bV;
    public String bW;
    public String bX;
    public String bY;
    public String bZ;
    public Map<String, String> cA;
    public NetworkInfo cB;
    public WifiInfo cC;
    public GsmCellLocation cD;
    public CdmaCellLocation cE;
    public TelephonyManager cF;
    public WifiManager cG;
    public ConnectivityManager cH;
    public BatteryManager cI;
    public LocationManager cJ;
    public PowerManager cK;
    public PackageManager cL;
    public Location cM;
    public JSONObject cN;
    public JSONObject cO;
    public JSONObject cP;
    public JSONObject cQ;
    public JSONObject cR;
    public boolean cT;
    public e cU;
    public j cV;
    public String ca;
    public String cb;
    public String cc;
    public String cd;
    public String ce;
    public String cf;
    public String cg;
    public String ch;
    public String ci;
    public String cj;
    public String ck;
    public List<String> cl;
    public List<String> cm;
    public List<String> cn;

    /* renamed from: co  reason: collision with root package name */
    public long f6105co = -1;
    public long cp = -1;
    public boolean cq;
    public boolean cr;
    public boolean cs;
    public boolean ct;
    public boolean cu;
    public boolean cv;
    public boolean cw;
    public boolean cx;
    public boolean cy;
    public boolean cz;

    public i(boolean z) {
        j jVar;
        synchronized (j.class) {
            if (j.bx == null) {
                j.bx = new j();
            }
            jVar = j.bx;
        }
        this.cV = jVar;
        this.cT = z;
    }

    @SuppressLint({"MissingPermission"})
    public final Location a(LocationManager locationManager) {
        Location location = null;
        if (locationManager == null) {
            return null;
        }
        try {
            List<String> providers = locationManager.getProviders(true);
            for (int size = providers.size() - 1; size >= 0; size--) {
                location = locationManager.getLastKnownLocation(providers.get(size));
                if (location != null) {
                    break;
                }
            }
        } catch (Exception e2) {
            a.a(i.class, 3, (Throwable) e2);
        }
        return location;
    }

    public final String a(String str, String str2, long j, String str3) throws Exception {
        String str4;
        String str5;
        StringBuilder sb;
        if (!f.a((Object) str) || !f.a((Object) str2) || !f.a((Object) Long.valueOf(j))) {
            if (f.a((Object) str)) {
                str = "";
            }
            if (f.a((Object) str2)) {
                str2 = "";
            }
            if (f.a((Object) Long.valueOf(j))) {
                sb = GeneratedOutlineSupport.outline73(str);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(j);
                sb = sb2;
            }
            sb.append(str2);
            str4 = sb.toString();
        } else {
            str4 = "invalid_input";
        }
        String a2 = f.a((String) "SG1hY1NIQTI1Ng==");
        if (f.a((Object) Long.valueOf(j))) {
            str5 = f.a(str3);
        } else {
            str5 = f.a(str3) + j;
        }
        Mac instance = Mac.getInstance(a2);
        instance.init(new SecretKeySpec(str5.getBytes(), a2));
        byte[] doFinal = instance.doFinal(str4.getBytes());
        StringBuilder sb3 = new StringBuilder();
        for (byte b2 : doFinal) {
            sb3.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
        }
        return sb3.toString().substring(0, 32);
    }

    @SuppressLint({"MissingPermission"})
    public final ArrayList<String> a(WifiManager wifiManager) {
        if (wifiManager == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        List<ScanResult> scanResults = wifiManager.getScanResults();
        if (!(scanResults == null || scanResults.size() == 0)) {
            int i = LinearLayoutManager.INVALID_OFFSET;
            String bssid = wifiManager.getConnectionInfo().getBSSID();
            if (bssid != null && !bssid.equals("00:00:00:00:00:00")) {
                int i2 = -1;
                for (int i3 = 0; i3 < scanResults.size(); i3++) {
                    if (!bssid.equals(scanResults.get(i3).BSSID)) {
                        int i4 = scanResults.get(i3).level;
                        if (i < i4) {
                            i2 = i3;
                            i = i4;
                        }
                    }
                }
                arrayList.add(bssid);
                if (i2 != -1) {
                    arrayList.add(scanResults.get(i2).BSSID);
                }
                return arrayList;
            }
        }
        return null;
    }

    public final List<String> a(boolean z) {
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            while (networkInterfaces != null && networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses != null && inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (z || !nextElement.isLinkLocalAddress())) {
                        String hostAddress = nextElement.getHostAddress();
                        if (nextElement instanceof Inet6Address) {
                            arrayList3.add(hostAddress);
                        } else {
                            arrayList2.add(hostAddress);
                        }
                    }
                }
            }
            if (!arrayList2.isEmpty()) {
                arrayList.addAll(arrayList2);
            }
            if (!arrayList3.isEmpty()) {
                arrayList.addAll(arrayList3);
            }
        } catch (Exception e2) {
            a.a(i.class, 3, (Throwable) e2);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public JSONObject a() {
        Class<i> cls = i.class;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pairing_id", this.bO);
            Integer num = null;
            jSONObject.put(c$e.BASE_STATION_ID.toString(), this.bG == -1 ? null : Integer.valueOf(this.bG));
            jSONObject.put(c$e.BSSID.toString(), this.bM);
            jSONObject.put(c$e.BSSID_ARRAY.toString(), this.cn == null ? null : new JSONArray(this.cn));
            jSONObject.put(c$e.CELL_ID.toString(), this.bH == -1 ? null : Integer.valueOf(this.bH));
            jSONObject.put(c$e.CONN_TYPE.toString(), this.bU);
            jSONObject.put(c$e.CONF_VERSION.toString(), this.cf);
            jSONObject.put(c$e.IS_DEV_MODE_ON.toString(), this.cz);
            jSONObject.put(c$e.DEVICE_ID.toString(), this.bV);
            jSONObject.put(c$e.DC_ID.toString(), this.bT);
            jSONObject.put(c$e.DEVICE_UPTIME.toString(), this.cp == -1 ? null : Long.valueOf(this.cp));
            jSONObject.put(c$e.IP_ADDRS.toString(), this.bW);
            jSONObject.put(c$e.IP_ADDRESSES.toString(), this.cl == null ? null : new JSONArray(this.cl));
            jSONObject.put(c$e.KNOWN_APPS.toString(), this.cm == null ? null : new JSONArray(this.cm));
            jSONObject.put(c$e.LOCALE_COUNTRY.toString(), this.bY);
            jSONObject.put(c$e.LOCALE_LANG.toString(), this.bZ);
            jSONObject.put(c$e.LOCATION.toString(), a(this.cM));
            jSONObject.put(c$e.LOCATION_AREA_CODE.toString(), this.bL == -1 ? null : Integer.valueOf(this.bL));
            jSONObject.put(c$e.PHONE_TYPE.toString(), this.ca);
            jSONObject.put(c$e.RISK_COMP_SESSION_ID.toString(), this.cb);
            jSONObject.put(c$e.ROAMING.toString(), this.cq);
            jSONObject.put(c$e.SIM_OPERATOR_NAME.toString(), this.ci);
            jSONObject.put(c$e.SIM_SERIAL_NUMBER.toString(), this.cc);
            jSONObject.put(c$e.SSID.toString(), this.cd);
            jSONObject.put(c$e.CDMA_NETWORK_ID.toString(), this.bK == -1 ? null : Integer.valueOf(this.bK));
            jSONObject.put(c$e.CDMA_SYSTEM_ID.toString(), this.bJ == -1 ? null : Integer.valueOf(this.bJ));
            jSONObject.put(c$e.SUBSCRIBER_ID.toString(), this.ce);
            jSONObject.put(c$e.TIMESTAMP.toString(), this.f6105co == -1 ? null : Long.valueOf(this.f6105co));
            jSONObject.put(c$e.TZ_NAME.toString(), this.bX);
            jSONObject.put(c$e.DS.toString(), this.cr);
            String c_e = c$e.TZ.toString();
            if (this.bI != -1) {
                num = Integer.valueOf(this.bI);
            }
            jSONObject.put(c_e, num);
            jSONObject.put(c$e.NETWORK_OPERATOR.toString(), this.bN);
            jSONObject.put(c$e.SERIAL_NUMBER.toString(), this.bP);
            jSONObject.put(c$e.VPN_SETTING.toString(), this.bR);
            jSONObject.put(c$e.PROXY_SETTING.toString(), this.bQ);
            jSONObject.put(c$e.C.toString(), this.bS);
            jSONObject.put(c$e.MG_ID.toString(), this.cg);
            jSONObject.put(c$e.LINKER_ID.toString(), this.ch);
            jSONObject.put(c$e.PL.toString(), this.cj);
            jSONObject.put(c$e.BATTERY.toString(), this.cN);
            jSONObject.put(c$e.MEMORY.toString(), this.cO);
            jSONObject.put(c$e.DISK.toString(), this.cP);
            jSONObject.put(c$e.SCREEN.toString(), this.cQ);
            jSONObject.put(c$e.SR.toString(), this.cR);
            jSONObject.put(c$e.T.toString(), g.bj);
            Map<String, String> map = this.cA;
            if (map != null) {
                for (Entry next : map.entrySet()) {
                    try {
                        jSONObject.put((String) next.getKey(), next.getValue());
                    } catch (Exception e2) {
                        a.a(cls, 3, (Throwable) e2);
                    }
                }
            }
            return jSONObject;
        } catch (Exception e3) {
            a.a(cls, 3, (Throwable) e3);
            return jSONObject;
        }
    }

    public final JSONObject a(Context context, BatteryManager batteryManager, PowerManager powerManager) {
        int i;
        int i2;
        int i3;
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        JSONObject jSONObject = new JSONObject();
        double d2 = 12345.0d;
        int i4 = 12345;
        if (registerReceiver != null) {
            double intExtra = (double) registerReceiver.getIntExtra("level", 12345);
            int intExtra2 = registerReceiver.getIntExtra("scale", 12345);
            i3 = registerReceiver.getIntExtra("temperature", 12345);
            i2 = registerReceiver.getIntExtra("voltage", 12345);
            i = registerReceiver.getIntExtra("status", 12345);
            int intExtra3 = registerReceiver.getIntExtra("plugged", 12345);
            if (intExtra == 12345.0d || intExtra2 == 12345) {
                i4 = intExtra3;
                d2 = intExtra;
            } else {
                d2 = intExtra / ((double) intExtra2);
                i4 = intExtra3;
            }
        } else {
            i3 = 12345;
            i2 = 12345;
            i = 12345;
        }
        int intProperty = batteryManager.getIntProperty(2);
        boolean isPowerSaveMode = powerManager.isPowerSaveMode();
        try {
            jSONObject.put(c$e.a.f6023a.toString(), a((Object) Integer.valueOf(intProperty)));
            jSONObject.put(c$e.a.f6024b.toString(), new DecimalFormat(".##").format(a((Object) Double.valueOf(d2))));
            jSONObject.put(c$e.a.f6025c.toString(), a((Object) Integer.valueOf(i4)));
            jSONObject.put(c$e.a.f6026d.toString(), a((Object) Integer.valueOf(isPowerSaveMode ? 1 : 0)));
            jSONObject.put(c$e.a.f6027e.toString(), a((Object) Integer.valueOf(i)));
            jSONObject.put(c$e.a.f6028f.toString(), a((Object) Integer.valueOf(i3)));
            jSONObject.put(c$e.a.g.toString(), a((Object) Integer.valueOf(i2)));
        } catch (JSONException e2) {
            a.a(i.class, 3, (Throwable) e2);
        }
        return jSONObject;
    }

    public final JSONObject a(Location location) {
        if (location != null) {
            try {
                return new JSONObject("{\"lat\":" + location.getLatitude() + ",\"lng\":" + location.getLongitude() + ",\"acc\":" + location.getAccuracy() + ",\"timestamp\":" + location.getTime() + "}");
            } catch (Exception e2) {
                a.a(i.class, 3, (Throwable) e2);
            }
        }
        return null;
    }

    public final String b(TelephonyManager telephonyManager) {
        try {
            return telephonyManager.getSimOperatorName();
        } catch (Exception e2) {
            a.a(i.class, 3, (Throwable) e2);
            return null;
        }
    }

    public final String b(String str) throws Exception {
        if (str == null || str.isEmpty()) {
            str = "invalid input in dc method";
        }
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        instance.update(str.getBytes());
        byte[] digest = instance.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b2 : digest) {
            sb.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
        }
        return sb.toString().substring(0, 32);
    }

    public final List<String> b() {
        ArrayList arrayList = new ArrayList();
        try {
            e eVar = this.cU;
            if (eVar != null) {
                ArrayList arrayList2 = new ArrayList();
                JSONArray optJSONArray = eVar.k.optJSONArray(c$j.ANDROID_APPS_TO_CHECK.toString());
                int i = 0;
                while (optJSONArray != null && i < optJSONArray.length()) {
                    arrayList2.add(optJSONArray.getString(i));
                    i++;
                }
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    List<ResolveInfo> queryIntentActivities = this.cL.queryIntentActivities(new Intent().setComponent(ComponentName.unflattenFromString(str)), 65536);
                    if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                        arrayList.add(str);
                    }
                }
                return arrayList;
            }
            throw null;
        } catch (Exception e2) {
            a.a(i.class, 3, (Throwable) e2);
        }
    }

    public final boolean c(Context context) {
        return Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0;
    }

    public final String d() {
        String property = System.getProperty("http.proxyHost");
        if (property != null) {
            String property2 = System.getProperty("http.proxyPort");
            if (property2 != null) {
                return GeneratedOutlineSupport.outline53("host=", property, ",port=", property2);
            }
        }
        return null;
    }

    public final JSONObject d(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        JSONObject jSONObject = new JSONObject();
        try {
            boolean z = false;
            jSONObject.put(c$l.AC.toString(), (sensorManager == null || sensorManager.getDefaultSensor(1) == null) ? false : true);
            jSONObject.put(c$l.GY.toString(), (sensorManager == null || sensorManager.getDefaultSensor(4) == null) ? false : true);
            String c_l = c$l.MG.toString();
            if (!(sensorManager == null || sensorManager.getDefaultSensor(2) == null)) {
                z = true;
            }
            jSONObject.put(c_l, z);
        } catch (JSONException e2) {
            a.a(i.class, 3, (Throwable) e2);
        }
        return jSONObject;
    }

    public final String e() {
        try {
            Iterator<T> it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (networkInterface.isUp()) {
                    if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                        String name = networkInterface.getName();
                        if (name.startsWith("ppp") || name.startsWith("tun") || name.startsWith("tap")) {
                            return name;
                        }
                    }
                }
            }
        } catch (Exception e2) {
            a.a(i.class, 3, (Throwable) e2);
        }
        return null;
    }

    public final JSONObject e(Context context) {
        int i;
        Class<i> cls = i.class;
        JSONObject jSONObject = new JSONObject();
        try {
            i = System.getInt(context.getContentResolver(), "screen_brightness");
        } catch (SettingNotFoundException e2) {
            a.a(cls, 3, (Throwable) e2);
            i = -403;
        }
        try {
            jSONObject.put("brightness", a((Object) Integer.valueOf(i)));
        } catch (JSONException e3) {
            a.a(cls, 3, (Throwable) e3);
        }
        return jSONObject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0062 A[Catch:{ FileNotFoundException -> 0x00a3, IOException -> 0x009b, all -> 0x00d5, all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006c A[SYNTHETIC, Splitter:B:25:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String f() throws java.io.IOException {
        /*
            r15 = this;
            java.lang.String r0 = "UTF-8"
            java.lang.Class<lib.android.paypal.com.magnessdk.a.a> r1 = lib.android.paypal.com.magnessdk.a.a.class
            java.lang.String r2 = android.os.Environment.getExternalStorageState()
            int r3 = r2.hashCode()
            r4 = 1242932856(0x4a15a678, float:2451870.0)
            r5 = -1
            r6 = 1
            r7 = 0
            if (r3 == r4) goto L_0x0024
            r4 = 1299749220(0x4d789964, float:2.6067514E8)
            if (r3 == r4) goto L_0x001a
            goto L_0x002e
        L_0x001a:
            java.lang.String r3 = "mounted_ro"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x002e
            r2 = 1
            goto L_0x002f
        L_0x0024:
            java.lang.String r3 = "mounted"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x002e
            r2 = 0
            goto L_0x002f
        L_0x002e:
            r2 = -1
        L_0x002f:
            if (r2 == 0) goto L_0x0038
            if (r2 == r6) goto L_0x0035
            r2 = 0
            goto L_0x0036
        L_0x0035:
            r2 = 1
        L_0x0036:
            r3 = 0
            goto L_0x003a
        L_0x0038:
            r2 = 1
            r3 = 1
        L_0x003a:
            android.os.Environment.getExternalStorageDirectory()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.io.File r8 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r8 = r8.getAbsolutePath()
            r4.append(r8)
            java.lang.String r8 = "/Android/data/com.ebay.lid/"
            r4.append(r8)
            java.lang.String r4 = r4.toString()
            java.io.File r8 = new java.io.File
            r8.<init>(r4)
            java.lang.String r4 = "fb.bin"
            r9 = 0
            boolean r10 = r15.cw     // Catch:{ FileNotFoundException -> 0x00a3, IOException -> 0x009b }
            if (r10 != 0) goto L_0x0066
            boolean r10 = r15.cv     // Catch:{ FileNotFoundException -> 0x00a3, IOException -> 0x009b }
            if (r10 == 0) goto L_0x00db
        L_0x0066:
            r10 = 1024(0x400, float:1.435E-42)
            byte[] r11 = new byte[r10]     // Catch:{ FileNotFoundException -> 0x00a3, IOException -> 0x009b }
            if (r3 == 0) goto L_0x00db
            java.io.File r12 = new java.io.File     // Catch:{ all -> 0x0095 }
            r12.<init>(r8, r4)     // Catch:{ all -> 0x0095 }
            java.io.FileInputStream r13 = new java.io.FileInputStream     // Catch:{ all -> 0x0095 }
            r13.<init>(r12)     // Catch:{ all -> 0x0095 }
            java.io.ByteArrayOutputStream r12 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0093 }
            r12.<init>()     // Catch:{ all -> 0x0093 }
        L_0x007b:
            int r14 = r13.read(r11, r7, r10)     // Catch:{ all -> 0x0093 }
            if (r14 == r5) goto L_0x0085
            r12.write(r11, r7, r14)     // Catch:{ all -> 0x0093 }
            goto L_0x007b
        L_0x0085:
            byte[] r5 = r12.toByteArray()     // Catch:{ all -> 0x0093 }
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x0093 }
            r7.<init>(r5, r0)     // Catch:{ all -> 0x0093 }
            lib.android.paypal.com.magnessdk.f.a(r1, r13)     // Catch:{ FileNotFoundException -> 0x00a3, IOException -> 0x009b }
            r9 = r7
            goto L_0x00db
        L_0x0093:
            r5 = move-exception
            goto L_0x0097
        L_0x0095:
            r5 = move-exception
            r13 = r9
        L_0x0097:
            lib.android.paypal.com.magnessdk.f.a(r1, r13)     // Catch:{ FileNotFoundException -> 0x00a3, IOException -> 0x009b }
            throw r5     // Catch:{ FileNotFoundException -> 0x00a3, IOException -> 0x009b }
        L_0x009b:
            r0 = move-exception
            java.lang.Class<lib.android.paypal.com.magnessdk.i> r1 = lib.android.paypal.com.magnessdk.i.class
            r2 = 3
            lib.android.paypal.com.magnessdk.b.a.a(r1, r2, r0)
            goto L_0x00db
        L_0x00a3:
            boolean r5 = r15.cw
            if (r5 == 0) goto L_0x00db
            java.lang.String r5 = lib.android.paypal.com.magnessdk.f.a(r6)
            byte[] r0 = r5.getBytes(r0)
            if (r2 == 0) goto L_0x00da
            if (r3 == 0) goto L_0x00da
            boolean r2 = r8.mkdirs()     // Catch:{ all -> 0x00d5 }
            if (r2 != 0) goto L_0x00c0
            boolean r2 = r8.isDirectory()     // Catch:{ all -> 0x00d5 }
            if (r2 == 0) goto L_0x00ce
        L_0x00c0:
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x00d5 }
            r2.<init>(r8, r4)     // Catch:{ all -> 0x00d5 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x00d5 }
            r3.<init>(r2)     // Catch:{ all -> 0x00d5 }
            r3.write(r0)     // Catch:{ all -> 0x00d2 }
            r9 = r3
        L_0x00ce:
            lib.android.paypal.com.magnessdk.f.a(r1, r9)
            goto L_0x00da
        L_0x00d2:
            r0 = move-exception
            r9 = r3
            goto L_0x00d6
        L_0x00d5:
            r0 = move-exception
        L_0x00d6:
            lib.android.paypal.com.magnessdk.f.a(r1, r9)
            throw r0
        L_0x00da:
            r9 = r5
        L_0x00db:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: lib.android.paypal.com.magnessdk.i.f():java.lang.String");
    }

    public final String f(Context context) {
        int i = context.getSharedPreferences("RiskManagerCT", 0).getInt("RiskManagerCT", 0);
        return i + "";
    }

    public final String g() {
        return (this.ct ? 1 : 0) + (this.cu ? 1 : 0) + (this.cx ? 1 : 0) + (this.cy ? 1 : 0) + (this.cv ? 1 : 0) + (this.cw ? 1 : 0);
    }

    public final void g(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("RiskManagerCT", 0);
        int i = sharedPreferences.getInt("RiskManagerCT", 0);
        Editor edit = sharedPreferences.edit();
        int i2 = 1;
        if (i > 0 && i < Integer.MAX_VALUE) {
            i2 = 1 + i;
        }
        edit.putInt("RiskManagerCT", i2);
        edit.apply();
    }

    public final JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        boolean z = Environment.isExternalStorageRemovable() && "mounted".equals(Environment.getExternalStorageState());
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        long a2 = super.a(600);
        try {
            jSONObject.put(b.f6031c.toString(), z);
            jSONObject.put(b.f6029a.toString(), a((Object) Long.valueOf(a2)));
            jSONObject.put(b.f6030b.toString(), a((Object) Long.valueOf(blockSize)));
        } catch (Exception e2) {
            a.a(i.class, 3, (Throwable) e2);
        }
        return jSONObject;
    }

    public final JSONObject h(Context context) {
        long j;
        JSONObject jSONObject = new JSONObject();
        MemoryInfo memoryInfo = new MemoryInfo();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        long j2 = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long j3 = 12345;
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
            j3 = memoryInfo.availMem;
            j = memoryInfo.totalMem;
        } else {
            j = 12345;
        }
        try {
            jSONObject.put(c.f6034a.toString(), a((Object) Long.valueOf(j3)));
            jSONObject.put(c.f6037d.toString(), a((Object) Long.valueOf(j)));
            jSONObject.put(c.f6035b.toString(), a((Object) Long.valueOf(freeMemory)));
            jSONObject.put(c.f6038e.toString(), a((Object) Long.valueOf(j2)));
            jSONObject.put(c.f6036c.toString(), a((Object) Long.valueOf(maxMemory)));
        } catch (Exception e2) {
            a.a(i.class, 3, (Throwable) e2);
        }
        return jSONObject;
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v3, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v4, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v5, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v6, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v7, types: [java.util.List<java.lang.String>] */
    /* JADX WARNING: type inference failed for: r3v8, types: [java.util.ArrayList] */
    /* JADX WARNING: type inference failed for: r3v10, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v11, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v12, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v14, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r8v72, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r9v24 */
    /* JADX WARNING: type inference failed for: r3v15, types: [java.util.List<java.lang.String>] */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: type inference failed for: r3v17, types: [android.location.Location] */
    /* JADX WARNING: type inference failed for: r3v18, types: [android.location.Location] */
    /* JADX WARNING: type inference failed for: r3v19, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v20, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v21 */
    /* JADX WARNING: type inference failed for: r3v22 */
    /* JADX WARNING: type inference failed for: r3v23 */
    /* JADX WARNING: type inference failed for: r3v24 */
    /* JADX WARNING: type inference failed for: r3v25 */
    /* JADX WARNING: type inference failed for: r3v26 */
    /* JADX WARNING: type inference failed for: r3v27 */
    /* JADX WARNING: type inference failed for: r3v28 */
    /* JADX WARNING: type inference failed for: r3v29 */
    /* JADX WARNING: type inference failed for: r3v30 */
    /* JADX WARNING: type inference failed for: r3v31 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], java.lang.String, java.util.ArrayList<java.lang.String>, ?[OBJECT, ARRAY], android.location.Location]
      uses: [java.util.List<java.lang.String>, java.lang.String, android.location.Location]
      mth insns count: 500
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 2 */
    @android.annotation.SuppressLint({"MissingPermission,HardwareIds"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r8, lib.android.paypal.com.magnessdk.MagnesSettings r9) {
        /*
            r7 = this;
            java.lang.Class<lib.android.paypal.com.magnessdk.i> r0 = lib.android.paypal.com.magnessdk.i.class
            android.content.Context r9 = r9.context     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r1 = 4
            r2 = -1
            if (r8 == r1) goto L_0x03e8
            r1 = 5
            r3 = 0
            if (r8 == r1) goto L_0x03d2
            r1 = 6
            if (r8 == r1) goto L_0x03bc
            r1 = 42
            r4 = 1
            if (r8 == r1) goto L_0x03ad
            r1 = 43
            if (r8 == r1) goto L_0x0399
            r1 = 45
            if (r8 == r1) goto L_0x0382
            r1 = 46
            r5 = 29
            if (r8 == r1) goto L_0x0360
            r1 = 48
            if (r8 == r1) goto L_0x0349
            r1 = 49
            if (r8 == r1) goto L_0x0327
            r1 = 71
            if (r8 == r1) goto L_0x0317
            r1 = 72
            if (r8 == r1) goto L_0x0307
            r1 = 84
            if (r8 == r1) goto L_0x02f1
            r1 = 85
            if (r8 == r1) goto L_0x02d2
            r1 = 26
            switch(r8) {
                case 11: goto L_0x01d0;
                case 13: goto L_0x018b;
                case 16: goto L_0x017b;
                case 21: goto L_0x0160;
                case 23: goto L_0x0145;
                case 25: goto L_0x0135;
                case 27: goto L_0x0121;
                case 28: goto L_0x010d;
                case 29: goto L_0x00f7;
                case 30: goto L_0x00e0;
                case 53: goto L_0x00bd;
                case 68: goto L_0x0096;
                case 75: goto L_0x0086;
                case 87: goto L_0x007e;
                case 89: goto L_0x006a;
                case 98: goto L_0x005a;
                case 99: goto L_0x004a;
                default: goto L_0x003f;
            }     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
        L_0x003f:
            switch(r8) {
                case 56: goto L_0x0215;
                case 57: goto L_0x01fe;
                case 58: goto L_0x01e7;
                default: goto L_0x0042;
            }     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
        L_0x0042:
            switch(r8) {
                case 79: goto L_0x0289;
                case 80: goto L_0x026c;
                case 81: goto L_0x0251;
                case 82: goto L_0x022c;
                default: goto L_0x0045;
            }     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
        L_0x0045:
            switch(r8) {
                case 91: goto L_0x02c2;
                case 92: goto L_0x02b2;
                case 93: goto L_0x02a2;
                default: goto L_0x0048;
            }     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
        L_0x0048:
            goto L_0x0405
        L_0x004a:
            lib.android.paypal.com.magnessdk.e r1 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r1.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            boolean r8 = r7.c(r9)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r7.cz = r8     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x005a:
            lib.android.paypal.com.magnessdk.e r1 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r1.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            org.json.JSONObject r8 = r7.d(r9)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r7.cR = r8     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x006a:
            lib.android.paypal.com.magnessdk.e r1 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r1.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            android.os.BatteryManager r8 = r7.cI     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            android.os.PowerManager r1 = r7.cK     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            org.json.JSONObject r8 = r7.a(r9, r8, r1)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r7.cN = r8     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x007e:
            java.lang.String r8 = r7.g()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r7.cj = r8     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x0086:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            java.util.List r8 = r7.a(r4)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r7.cl = r8     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x0096:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            boolean r8 = r7.cu     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            android.telephony.TelephonyManager r8 = r7.cF     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 < r1) goto L_0x00b7
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 < r5) goto L_0x00b2
            boolean r8 = r7.cs     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
        L_0x00b2:
            java.lang.String r8 = android.os.Build.getSerial()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x00b9
        L_0x00b7:
            java.lang.String r8 = android.os.Build.SERIAL     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
        L_0x00b9:
            r7.bP = r8     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x00bd:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            java.util.TimeZone r8 = java.util.TimeZone.getDefault()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            java.util.TimeZone r9 = java.util.TimeZone.getDefault()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            java.util.Date r1 = new java.util.Date     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r1.<init>()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r9 = r9.inDaylightTime(r1)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            java.util.Locale r1 = java.util.Locale.ENGLISH     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            java.lang.String r8 = r8.getDisplayName(r9, r4, r1)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r7.bX = r8     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x00e0:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            android.telephony.gsm.GsmCellLocation r8 = r7.cD     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 != 0) goto L_0x00ed
            goto L_0x00f3
        L_0x00ed:
            android.telephony.gsm.GsmCellLocation r8 = r7.cD     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            int r2 = r8.getLac()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
        L_0x00f3:
            r7.bL = r2     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x00f7:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            boolean r8 = r7.ct     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0109
            android.location.LocationManager r8 = r7.cJ     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            android.location.Location r3 = r7.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
        L_0x0109:
            r7.cM = r3     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x010d:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            java.util.Locale r8 = java.util.Locale.getDefault()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            java.lang.String r8 = r8.getLanguage()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r7.bZ = r8     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x0121:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            java.util.Locale r8 = java.util.Locale.getDefault()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            java.lang.String r8 = r8.getCountry()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r7.bY = r8     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x0135:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            java.lang.String r8 = r7.f()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r7.ch = r8     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x0145:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            java.util.List r8 = r7.b()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r9 = r8
            java.util.ArrayList r9 = (java.util.ArrayList) r9
            boolean r9 = r9.isEmpty()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r9 == 0) goto L_0x015b
            goto L_0x015c
        L_0x015b:
            r3 = r8
        L_0x015c:
            r7.cm = r3     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x0160:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            r8 = 0
            java.util.List r9 = r7.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r9 != 0) goto L_0x0170
            goto L_0x0177
        L_0x0170:
            java.lang.Object r8 = r9.get(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r3 = r8
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
        L_0x0177:
            r7.bW = r3     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x017b:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            long r8 = android.os.SystemClock.uptimeMillis()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r7.cp = r8     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x018b:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            boolean r8 = r7.cu     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            android.telephony.TelephonyManager r8 = r7.cF     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 < r1) goto L_0x01c6
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 < r5) goto L_0x01a7
            boolean r8 = r7.cs     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
        L_0x01a7:
            android.telephony.TelephonyManager r8 = r7.cF     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            int r8 = r8.getPhoneType()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 != r4) goto L_0x01b6
            android.telephony.TelephonyManager r8 = r7.cF     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            java.lang.String r8 = r8.getImei()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x01cc
        L_0x01b6:
            android.telephony.TelephonyManager r8 = r7.cF     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            int r8 = r8.getPhoneType()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r9 = 2
            if (r8 != r9) goto L_0x0405
            android.telephony.TelephonyManager r8 = r7.cF     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            java.lang.String r8 = r8.getMeid()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x01cc
        L_0x01c6:
            android.telephony.TelephonyManager r8 = r7.cF     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            java.lang.String r8 = r8.getDeviceId()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
        L_0x01cc:
            r7.bV = r8     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x01d0:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            android.net.NetworkInfo r8 = r7.cB     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 != 0) goto L_0x01dd
            goto L_0x01e3
        L_0x01dd:
            android.net.NetworkInfo r8 = r7.cB     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            java.lang.String r3 = r8.getTypeName()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
        L_0x01e3:
            r7.bU = r3     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x01e7:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            android.telephony.cdma.CdmaCellLocation r8 = r7.cE     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 != 0) goto L_0x01f4
            goto L_0x01fa
        L_0x01f4:
            android.telephony.cdma.CdmaCellLocation r8 = r7.cE     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            int r2 = r8.getSystemId()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
        L_0x01fa:
            r7.bJ = r2     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x01fe:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            android.telephony.cdma.CdmaCellLocation r8 = r7.cE     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 != 0) goto L_0x020b
            goto L_0x0211
        L_0x020b:
            android.telephony.cdma.CdmaCellLocation r8 = r7.cE     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            int r2 = r8.getNetworkId()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
        L_0x0211:
            r7.bK = r2     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x0215:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            android.telephony.TelephonyManager r8 = r7.cF     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 != 0) goto L_0x0222
            goto L_0x0228
        L_0x0222:
            android.telephony.TelephonyManager r8 = r7.cF     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            java.lang.String r3 = r8.getNetworkOperator()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
        L_0x0228:
            r7.bN = r3     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x022c:
            lib.android.paypal.com.magnessdk.e r1 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r1.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            lib.android.paypal.com.magnessdk.MagnesSDK r8 = lib.android.paypal.com.magnessdk.MagnesSDK.getInstance()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            lib.android.paypal.com.magnessdk.MagnesSettings r8 = r8.f5958b     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            int r8 = r8.getMagnesSource()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            lib.android.paypal.com.magnessdk.MagnesSource r1 = lib.android.paypal.com.magnessdk.MagnesSource.PAYPAL     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            int r1 = r1.getVersion()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 != r1) goto L_0x0405
            r7.g(r9)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            java.lang.String r8 = r7.f(r9)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r7.bS = r8     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x0251:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r8.<init>()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            java.lang.String r9 = r7.ck     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r8.append(r9)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            long r1 = r7.f6105co     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r8.append(r1)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            java.lang.String r8 = r8.toString()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            java.lang.String r8 = r7.b(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r7.bT = r8     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x026c:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            java.util.TimeZone r8 = java.util.TimeZone.getDefault()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            java.util.Date r9 = new java.util.Date     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r9.<init>()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            long r1 = r9.getTime()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            int r8 = r8.getOffset(r1)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r7.bI = r8     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x0289:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            java.util.TimeZone r8 = java.util.TimeZone.getDefault()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            java.util.Date r9 = new java.util.Date     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r9.<init>()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r8.inDaylightTime(r9)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r7.cr = r8     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x02a2:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            org.json.JSONObject r8 = r7.h()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r7.cP = r8     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x02b2:
            lib.android.paypal.com.magnessdk.e r1 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r1.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            org.json.JSONObject r8 = r7.h(r9)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r7.cO = r8     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x02c2:
            lib.android.paypal.com.magnessdk.e r1 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r1.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            org.json.JSONObject r8 = r7.e(r9)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r7.cQ = r8     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x02d2:
            java.lang.String r2 = r7.ck     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            java.lang.String r3 = r7.bO     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            long r4 = r7.f6105co     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            lib.android.paypal.com.magnessdk.e r8 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            org.json.JSONObject r8 = r8.k     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            lib.android.paypal.com.magnessdk.c$j r9 = lib.android.paypal.com.magnessdk.c$j.MG_ID     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            java.lang.String r9 = r9.toString()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            java.lang.String r1 = "QW5kcm9pZE1hZ25lcw=="
            java.lang.String r6 = r8.optString(r9, r1)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r1 = r7
            java.lang.String r8 = r1.a(r2, r3, r4, r6)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r7.cg = r8     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x02f1:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            boolean r8 = r7.ct     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0303
            android.net.wifi.WifiManager r8 = r7.cG     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            java.util.ArrayList r3 = r7.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
        L_0x0303:
            r7.cn = r3     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x0307:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            java.lang.String r8 = r7.d()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r7.bQ = r8     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x0317:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            java.lang.String r8 = r7.e()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r7.bR = r8     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x0327:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x033b
            boolean r8 = r7.cu     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x033b
            android.telephony.TelephonyManager r8 = r7.cF     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x033b
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 < r5) goto L_0x033f
        L_0x033b:
            boolean r8 = r7.cs     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
        L_0x033f:
            android.telephony.TelephonyManager r8 = r7.cF     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            java.lang.String r8 = r8.getSubscriberId()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r7.ce = r8     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x0349:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            android.net.wifi.WifiInfo r8 = r7.cC     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 != 0) goto L_0x0356
            goto L_0x035c
        L_0x0356:
            android.net.wifi.WifiInfo r8 = r7.cC     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            java.lang.String r3 = r8.getSSID()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
        L_0x035c:
            r7.cd = r3     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x0360:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0374
            boolean r8 = r7.cu     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0374
            android.telephony.TelephonyManager r8 = r7.cF     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0374
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 < r5) goto L_0x0378
        L_0x0374:
            boolean r8 = r7.cs     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
        L_0x0378:
            android.telephony.TelephonyManager r8 = r7.cF     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            java.lang.String r8 = r8.getSimSerialNumber()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r7.cc = r8     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x0382:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            android.telephony.TelephonyManager r8 = r7.cF     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 != 0) goto L_0x038f
            goto L_0x0395
        L_0x038f:
            android.telephony.TelephonyManager r8 = r7.cF     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            java.lang.String r3 = r7.b(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
        L_0x0395:
            r7.ci = r3     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x0399:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            android.telephony.ServiceState r8 = new android.telephony.ServiceState     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r8.<init>()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r8.getRoaming()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r7.cq = r8     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x03ad:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            java.lang.String r8 = lib.android.paypal.com.magnessdk.f.a(r4)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            r7.cb = r8     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x03bc:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            android.telephony.gsm.GsmCellLocation r8 = r7.cD     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 != 0) goto L_0x03c9
            goto L_0x03cf
        L_0x03c9:
            android.telephony.gsm.GsmCellLocation r8 = r7.cD     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            int r2 = r8.getCid()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
        L_0x03cf:
            r7.bH = r2     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x03d2:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            android.net.wifi.WifiInfo r8 = r7.cC     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 != 0) goto L_0x03df
            goto L_0x03e5
        L_0x03df:
            android.net.wifi.WifiInfo r8 = r7.cC     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            java.lang.String r3 = r8.getBSSID()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
        L_0x03e5:
            r7.bM = r3     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x03e8:
            lib.android.paypal.com.magnessdk.e r9 = r7.cU     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            boolean r8 = r9.a(r8)     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 == 0) goto L_0x0405
            android.telephony.cdma.CdmaCellLocation r8 = r7.cE     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            if (r8 != 0) goto L_0x03f5
            goto L_0x03fb
        L_0x03f5:
            android.telephony.cdma.CdmaCellLocation r8 = r7.cE     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            int r2 = r8.getBaseStationId()     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
        L_0x03fb:
            r7.bG = r2     // Catch:{ AssertionError -> 0x0400, Exception -> 0x03fe }
            goto L_0x0405
        L_0x03fe:
            r8 = move-exception
            goto L_0x0401
        L_0x0400:
            r8 = move-exception
        L_0x0401:
            r9 = 3
            lib.android.paypal.com.magnessdk.b.a.a(r0, r9, r8)
        L_0x0405:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: lib.android.paypal.com.magnessdk.i.a(int, lib.android.paypal.com.magnessdk.MagnesSettings):void");
    }
}
