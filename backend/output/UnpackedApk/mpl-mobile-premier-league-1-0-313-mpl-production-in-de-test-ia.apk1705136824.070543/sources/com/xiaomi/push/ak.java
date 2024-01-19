package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.razorpay.AnalyticsConstants;
import com.xiaomi.channel.commonutils.android.Region;
import com.xiaomi.mipush.sdk.Constants;
import io.antmedia.android.broadcaster.LiveVideoBroadcaster;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import okhttp3.internal.http2.Http2ExchangeCodec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sfs2x.client.requests.game.CreateSFSGameRequest;

public class ak {

    /* renamed from: a  reason: collision with root package name */
    public static Context f4404a;

    /* renamed from: a  reason: collision with other field name */
    public static a f247a;

    /* renamed from: a  reason: collision with other field name */
    public static ak f248a;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f249a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, ag> f4405b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static String f4406c;

    /* renamed from: d  reason: collision with root package name */
    public static String f4407d;

    /* renamed from: a  reason: collision with other field name */
    public long f250a;

    /* renamed from: a  reason: collision with other field name */
    public aj f251a;

    /* renamed from: a  reason: collision with other field name */
    public b f252a;

    /* renamed from: a  reason: collision with other field name */
    public String f253a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<String, ah> f254a;

    /* renamed from: b  reason: collision with other field name */
    public final long f255b;

    /* renamed from: b  reason: collision with other field name */
    public String f256b;

    /* renamed from: c  reason: collision with other field name */
    public long f257c;

    public interface a {
        ak a(Context context, aj ajVar, b bVar, String str);
    }

    public interface b {
        String a(String str);
    }

    public ak(Context context, aj ajVar, b bVar, String str) {
        this(context, ajVar, bVar, str, null, null);
    }

    public ak(Context context, aj ajVar, b bVar, String str, String str2, String str3) {
        this.f254a = new HashMap();
        this.f253a = "0";
        this.f250a = 0;
        this.f255b = 15;
        this.f257c = 0;
        this.f256b = "isp_prov_city_country_ip";
        this.f252a = bVar;
        this.f251a = ajVar == null ? new al(this) : ajVar;
        this.f253a = str;
        f4406c = str2 == null ? context.getPackageName() : str2;
        f4407d = str3 == null ? f() : str3;
    }

    public static synchronized ak a() {
        ak akVar;
        synchronized (ak.class) {
            try {
                if (f248a != null) {
                    akVar = f248a;
                } else {
                    throw new IllegalStateException("the host manager is not initialized yet.");
                }
            }
        }
        return akVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m401a() {
        Context context = f4404a;
        if (context == null) {
            return "unknown";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return "unknown";
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "unknown";
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI-UNKNOWN";
            }
            return activeNetworkInfo.getTypeName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + activeNetworkInfo.getSubtypeName();
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static String a(String str) {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes("UTF-8");
            for (int i = 0; i < bytes.length; i++) {
                byte b2 = bytes[i];
                byte b3 = b2 & 240;
                if (b3 != 240) {
                    bytes[i] = (byte) (((b2 & 15) ^ ((byte) (((b2 >> 4) + length) & 15))) | b3);
                }
            }
            return new String(bytes);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    private ArrayList<ag> a(ArrayList<String> arrayList) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        ArrayList<String> arrayList2 = arrayList;
        f();
        synchronized (this.f254a) {
            a();
            for (String next : this.f254a.keySet()) {
                if (!arrayList2.contains(next)) {
                    arrayList2.add(next);
                }
            }
        }
        synchronized (f4405b) {
            for (Object obj : f4405b.values().toArray()) {
                ag agVar = (ag) obj;
                if (!agVar.b()) {
                    f4405b.remove(agVar.f244b);
                }
            }
        }
        if (!arrayList2.contains(b())) {
            arrayList2.add(b());
        }
        ArrayList<ag> arrayList3 = new ArrayList<>(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList3.add(null);
        }
        try {
            String str = y.d(f4404a) ? AnalyticsConstants.WIFI : "wap";
            String a2 = a(arrayList2, str, this.f253a, true);
            if (!TextUtils.isEmpty(a2)) {
                JSONObject jSONObject3 = new JSONObject(a2);
                com.xiaomi.channel.commonutils.logger.b.b(a2);
                if (LiveVideoBroadcaster.OK.equalsIgnoreCase(jSONObject3.getString("S"))) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("R");
                    String string = jSONObject4.getString("province");
                    String string2 = jSONObject4.getString("city");
                    String string3 = jSONObject4.getString("isp");
                    String string4 = jSONObject4.getString(CreateSFSGameRequest.KEY_INVITATION_PARAMS);
                    String string5 = jSONObject4.getString("country");
                    JSONObject jSONObject5 = jSONObject4.getJSONObject(str);
                    com.xiaomi.channel.commonutils.logger.b.c("get bucket: net=" + string3 + ", hosts=" + jSONObject5.toString());
                    int i2 = 0;
                    while (i2 < arrayList.size()) {
                        String str2 = arrayList2.get(i2);
                        JSONArray optJSONArray = jSONObject5.optJSONArray(str2);
                        if (optJSONArray == null) {
                            com.xiaomi.channel.commonutils.logger.b.a("no bucket found for " + str2);
                            jSONObject = jSONObject5;
                        } else {
                            ag agVar2 = new ag(str2);
                            int i3 = 0;
                            while (i3 < optJSONArray.length()) {
                                String string6 = optJSONArray.getString(i3);
                                if (!TextUtils.isEmpty(string6)) {
                                    jSONObject2 = jSONObject5;
                                    agVar2.a(new ap(string6, optJSONArray.length() - i3));
                                } else {
                                    jSONObject2 = jSONObject5;
                                }
                                i3++;
                                jSONObject5 = jSONObject2;
                            }
                            jSONObject = jSONObject5;
                            arrayList3.set(i2, agVar2);
                            agVar2.g = string5;
                            agVar2.f4398c = string;
                            agVar2.f4400e = string3;
                            agVar2.f4401f = string4;
                            agVar2.f4399d = string2;
                            if (jSONObject4.has("stat-percent")) {
                                agVar2.a(jSONObject4.getDouble("stat-percent"));
                            }
                            if (jSONObject4.has("stat-domain")) {
                                agVar2.b(jSONObject4.getString("stat-domain"));
                            }
                            if (jSONObject4.has("ttl")) {
                                agVar2.a(((long) jSONObject4.getInt("ttl")) * 1000);
                            }
                            a(agVar2.a());
                        }
                        i2++;
                        jSONObject5 = jSONObject;
                    }
                    JSONObject optJSONObject = jSONObject4.optJSONObject("reserved");
                    if (optJSONObject != null) {
                        long j = 604800000;
                        if (jSONObject4.has("reserved-ttl")) {
                            j = ((long) jSONObject4.getInt("reserved-ttl")) * 1000;
                        }
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next2 = keys.next();
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray(next2);
                            if (optJSONArray2 == null) {
                                com.xiaomi.channel.commonutils.logger.b.a("no bucket found for " + next2);
                            } else {
                                ag agVar3 = new ag(next2);
                                agVar3.a(j);
                                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                                    String string7 = optJSONArray2.getString(i4);
                                    if (!TextUtils.isEmpty(string7)) {
                                        agVar3.a(new ap(string7, optJSONArray2.length() - i4));
                                    }
                                }
                                synchronized (f4405b) {
                                    if (this.f251a.a(next2)) {
                                        f4405b.put(next2, agVar3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("failed to get bucket ");
            outline73.append(e2.getMessage());
            com.xiaomi.channel.commonutils.logger.b.a(outline73.toString());
        }
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            ag agVar4 = arrayList3.get(i5);
            if (agVar4 != null) {
                a(arrayList2.get(i5), agVar4);
            }
        }
        d();
        return arrayList3;
    }

    public static synchronized void a(Context context, aj ajVar, b bVar, String str, String str2, String str3) {
        synchronized (ak.class) {
            Context applicationContext = context.getApplicationContext();
            f4404a = applicationContext;
            if (applicationContext == null) {
                f4404a = context;
            }
            if (f248a == null) {
                if (f247a == null) {
                    ak akVar = new ak(context, ajVar, bVar, str, str2, str3);
                    f248a = akVar;
                } else {
                    f248a = f247a.a(context, ajVar, bVar, str);
                }
            }
        }
    }

    public static synchronized void a(a aVar) {
        synchronized (ak.class) {
            f247a = aVar;
            f248a = null;
        }
    }

    public static void a(String str, String str2) {
        ag agVar = f4405b.get(str);
        synchronized (f4405b) {
            if (agVar == null) {
                ag agVar2 = new ag(str);
                agVar2.a(604800000);
                agVar2.a(str2);
                f4405b.put(str, agVar2);
            } else {
                agVar.a(str2);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private byte[] m402a() {
        return ac.a(f4404a.getPackageName() + "_key_salt");
    }

    public static void b() {
        ak a2 = a();
        a2.g();
        a2.a();
        a2.d();
        com.xiaomi.channel.commonutils.logger.b.a((String) "region changed so clear cached hosts");
    }

    private String e() {
        return "host_fallbacks";
    }

    private String f() {
        try {
            PackageInfo packageInfo = f4404a.getPackageManager().getPackageInfo(f4404a.getPackageName(), 16384);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
        } catch (Exception unused) {
        }
        return "0";
    }

    private void g() {
        synchronized (f4405b) {
            f4405b.clear();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public ag m403a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return a(new URL(str).getHost(), true);
        }
        throw new IllegalArgumentException("the url is empty");
    }

    public ag a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        } else if (!this.f251a.a(str)) {
            return null;
        } else {
            ag c2 = c(str);
            if (c2 != null && c2.b()) {
                return c2;
            }
            if (z && y.a(f4404a)) {
                ag e2 = e(str);
                if (e2 != null) {
                    return e2;
                }
            }
            return new am(this, str, c2);
        }
    }

    public String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        if (str.equals("wap")) {
            arrayList3.add(new v("conpt", a(y.a(f4404a))));
        }
        if (z) {
            arrayList3.add(new v("reserved", "1"));
        }
        arrayList3.add(new v("list", ad.a((Collection<?>) arrayList, (String) ",")));
        arrayList3.add(new v("countrycode", com.xiaomi.push.service.a.a(f4404a).b()));
        arrayList3.add(new v("push_sdk_vc", String.valueOf(BuildConfig.VERSION_CODE)));
        ag c2 = c(b());
        String format = String.format(Locale.US, "https://%1$s/gslb/?ver=5.0", new Object[]{b()});
        if (c2 == null) {
            arrayList2.add(format);
            synchronized (f4405b) {
                ag agVar = f4405b.get(b());
                if (agVar != null) {
                    Iterator<String> it = agVar.a(true).iterator();
                    while (it.hasNext()) {
                        arrayList2.add(String.format(Locale.US, "https://%1$s/gslb/?ver=5.0", new Object[]{it.next()}));
                    }
                }
            }
        } else {
            arrayList2 = c2.a(format);
        }
        Iterator<String> it2 = arrayList2.iterator();
        IOException e2 = null;
        while (it2.hasNext()) {
            Builder buildUpon = Uri.parse(it2.next()).buildUpon();
            Iterator it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                x xVar = (x) it3.next();
                buildUpon.appendQueryParameter(xVar.a(), xVar.b());
            }
            try {
                return this.f252a == null ? y.a(f4404a, new URL(buildUpon.toString())) : this.f252a.a(buildUpon.toString());
            } catch (IOException e3) {
                e2 = e3;
            }
        }
        if (e2 == null) {
            return null;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("network exception: ");
        outline73.append(e2.getMessage());
        com.xiaomi.channel.commonutils.logger.b.a(outline73.toString());
        throw e2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m404a() {
        JSONObject jSONObject;
        synchronized (this.f254a) {
            jSONObject = new JSONObject();
            jSONObject.put("ver", 2);
            JSONArray jSONArray = new JSONArray();
            for (ah a2 : this.f254a.values()) {
                jSONArray.put(a2.a());
            }
            jSONObject.put("data", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (ag a3 : f4405b.values()) {
                jSONArray2.put(a3.a());
            }
            jSONObject.put("reserved", jSONArray2);
        }
        return jSONObject;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m405a() {
        synchronized (this.f254a) {
            this.f254a.clear();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m406a(String str) {
        this.f256b = str;
    }

    public void a(String str, ag agVar) {
        if (TextUtils.isEmpty(str) || agVar == null) {
            throw new IllegalArgumentException("the argument is invalid " + str + ", " + agVar);
        } else if (this.f251a.a(str)) {
            synchronized (this.f254a) {
                a();
                if (this.f254a.containsKey(str)) {
                    this.f254a.get(str).a(agVar);
                } else {
                    ah ahVar = new ah(str);
                    ahVar.a(agVar);
                    this.f254a.put(str, ahVar);
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m407a() {
        synchronized (this.f254a) {
            if (f249a) {
                return true;
            }
            f249a = true;
            this.f254a.clear();
            try {
                String c2 = c();
                if (!TextUtils.isEmpty(c2)) {
                    b(c2);
                    com.xiaomi.channel.commonutils.logger.b.b("loading the new hosts succeed");
                    return true;
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a("load bucket failure: " + th.getMessage());
            }
        }
        return false;
    }

    public ag b(String str) {
        return a(str, true);
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m408b() {
        String a2 = com.xiaomi.push.service.a.a(f4404a).a();
        return (!TextUtils.isEmpty(a2) && !Region.Global.name().equals(a2)) ? Region.Europe.name().equals(a2) ? "fr.resolver.msg.global.xiaomi.net" : Region.Russia.name().equals(a2) ? "ru.resolver.msg.global.xiaomi.net" : Region.India.name().equals(a2) ? "mb.resolver.msg.global.xiaomi.net" : "resolver.msg.global.xiaomi.net" : "resolver.msg.global.xiaomi.net";
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m409b(String str) {
        synchronized (this.f254a) {
            this.f254a.clear();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("ver") == 2) {
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ah a2 = new ah().a(optJSONArray.getJSONObject(i));
                        this.f254a.put(a2.a(), a2);
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("reserved");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                        String optString = jSONObject2.optString(Http2ExchangeCodec.HOST);
                        if (!TextUtils.isEmpty(optString)) {
                            try {
                                ag a3 = new ag(optString).a(jSONObject2);
                                f4405b.put(a3.f244b, a3);
                                com.xiaomi.channel.commonutils.logger.b.a("load local reserved host for " + a3.f244b);
                            } catch (JSONException unused) {
                                com.xiaomi.channel.commonutils.logger.b.a((String) "parse reserved host fail.");
                            }
                        }
                    }
                }
            } else {
                throw new JSONException("Bad version");
            }
        }
    }

    public ag c(String str) {
        ah ahVar;
        synchronized (this.f254a) {
            a();
            ahVar = this.f254a.get(str);
        }
        if (ahVar != null) {
            ag a2 = ahVar.a();
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    public String c() {
        InputStream inputStream;
        InputStream inputStream2;
        String str;
        try {
            File file = new File(f4404a.getFilesDir(), e());
            if (file.isFile()) {
                inputStream = new FileInputStream(file);
                try {
                    inputStream2 = new BufferedInputStream(inputStream);
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = null;
                    try {
                        com.xiaomi.channel.commonutils.logger.b.a("load host exception " + th.getMessage());
                        return null;
                    } finally {
                        h.a((Closeable) inputStream2);
                        h.a((Closeable) inputStream);
                    }
                }
                try {
                    com.xiaomi.channel.commonutils.logger.b.b("load host fallbacks = " + str);
                    h.a((Closeable) inputStream2);
                    h.a((Closeable) inputStream);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    com.xiaomi.channel.commonutils.logger.b.a("load host exception " + th.getMessage());
                    return null;
                }
            } else {
                h.a((Closeable) null);
                h.a((Closeable) null);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream2 = null;
            inputStream = inputStream2;
            com.xiaomi.channel.commonutils.logger.b.a("load host exception " + th.getMessage());
            return null;
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m410c() {
        ArrayList arrayList;
        synchronized (this.f254a) {
            a();
            arrayList = new ArrayList(this.f254a.keySet());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ah ahVar = this.f254a.get(arrayList.get(size));
                if (!(ahVar == null || ahVar.a() == null)) {
                    arrayList.remove(size);
                }
            }
        }
        ArrayList<ag> a2 = a(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            if (a2.get(i) != null) {
                a((String) arrayList.get(i), a2.get(i));
            }
        }
    }

    public ag d(String str) {
        ag agVar;
        synchronized (f4405b) {
            agVar = f4405b.get(str);
        }
        return agVar;
    }

    public String d() {
        return "com.xiaomi.xmsf".equals(f4406c) ? f4406c : GeneratedOutlineSupport.outline62(new StringBuilder(), f4406c, ":pushservice");
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:18:0x0055=Splitter:B:18:0x0055, B:27:0x0065=Splitter:B:27:0x0065} */
    /* renamed from: d  reason: collision with other method in class */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m411d() {
        /*
            r6 = this;
            java.util.Map<java.lang.String, com.xiaomi.push.ah> r0 = r6.f254a
            monitor-enter(r0)
            r1 = 0
            org.json.JSONObject r2 = r6.a()     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            r3.<init>()     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            java.lang.String r4 = "persist host fallbacks = "
            r3.append(r4)     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            r3.append(r2)     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            com.xiaomi.channel.commonutils.logger.b.b(r3)     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            if (r3 != 0) goto L_0x0054
            android.content.Context r3 = f4404a     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            java.lang.String r4 = r6.e()     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            r5 = 0
            java.io.FileOutputStream r3 = r3.openFileOutput(r4, r5)     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0051, all -> 0x004e }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0051, all -> 0x004e }
            byte[] r1 = r6.a()     // Catch:{ Exception -> 0x004c }
            java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ Exception -> 0x004c }
            byte[] r2 = r2.getBytes(r5)     // Catch:{ Exception -> 0x004c }
            byte[] r1 = com.xiaomi.channel.commonutils.android.b.b(r1, r2)     // Catch:{ Exception -> 0x004c }
            r4.write(r1)     // Catch:{ Exception -> 0x004c }
            r4.flush()     // Catch:{ Exception -> 0x004c }
            r1 = r4
            goto L_0x0055
        L_0x004c:
            r1 = move-exception
            goto L_0x0065
        L_0x004e:
            r2 = move-exception
            r4 = r1
            goto L_0x005f
        L_0x0051:
            r2 = move-exception
            r4 = r1
            goto L_0x0064
        L_0x0054:
            r3 = r1
        L_0x0055:
            com.xiaomi.push.h.a(r1)     // Catch:{ all -> 0x008b }
        L_0x0058:
            com.xiaomi.push.h.a(r3)     // Catch:{ all -> 0x008b }
            goto L_0x0081
        L_0x005c:
            r2 = move-exception
            r3 = r1
            r4 = r3
        L_0x005f:
            r1 = r2
            goto L_0x0084
        L_0x0061:
            r2 = move-exception
            r3 = r1
            r4 = r3
        L_0x0064:
            r1 = r2
        L_0x0065:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0083 }
            r2.<init>()     // Catch:{ all -> 0x0083 }
            java.lang.String r5 = "persist bucket failure: "
            r2.append(r5)     // Catch:{ all -> 0x0083 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0083 }
            r2.append(r1)     // Catch:{ all -> 0x0083 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0083 }
            com.xiaomi.channel.commonutils.logger.b.a(r1)     // Catch:{ all -> 0x0083 }
            com.xiaomi.push.h.a(r4)     // Catch:{ all -> 0x008b }
            goto L_0x0058
        L_0x0081:
            monitor-exit(r0)     // Catch:{ all -> 0x008b }
            return
        L_0x0083:
            r1 = move-exception
        L_0x0084:
            com.xiaomi.push.h.a(r4)     // Catch:{ all -> 0x008b }
            com.xiaomi.push.h.a(r3)     // Catch:{ all -> 0x008b }
            throw r1     // Catch:{ all -> 0x008b }
        L_0x008b:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008b }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ak.m411d():void");
    }

    public ag e(String str) {
        if (System.currentTimeMillis() - this.f257c > this.f250a * 60 * 1000) {
            this.f257c = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            ag agVar = a(arrayList).get(0);
            if (agVar != null) {
                this.f250a = 0;
                return agVar;
            }
            long j = this.f250a;
            if (j < 15) {
                this.f250a = j + 1;
            }
        }
        return null;
    }

    /* renamed from: e  reason: collision with other method in class */
    public void m412e() {
        String d2 = d();
        try {
            File file = new File(f4404a.getFilesDir(), d2);
            if (file.exists()) {
                boolean delete = file.delete();
                StringBuilder sb = new StringBuilder();
                sb.append("Delete old host fallbacks file ");
                sb.append(d2);
                sb.append(delete ? " successful." : " failed.");
                com.xiaomi.channel.commonutils.logger.b.a(sb.toString());
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.b("Old host fallbacks file " + d2 + " does not exist.");
        } catch (Exception e2) {
            StringBuilder outline80 = GeneratedOutlineSupport.outline80("Delete old host fallbacks file ", d2, " error: ");
            outline80.append(e2.getMessage());
            com.xiaomi.channel.commonutils.logger.b.a(outline80.toString());
        }
    }

    /* renamed from: f  reason: collision with other method in class */
    public void m413f() {
        synchronized (this.f254a) {
            for (ah a2 : this.f254a.values()) {
                a2.a(true);
            }
            while (true) {
                for (boolean z = false; !z; z = true) {
                    for (String next : this.f254a.keySet()) {
                        if (this.f254a.get(next).a().isEmpty()) {
                            this.f254a.remove(next);
                        }
                    }
                }
            }
        }
    }
}
