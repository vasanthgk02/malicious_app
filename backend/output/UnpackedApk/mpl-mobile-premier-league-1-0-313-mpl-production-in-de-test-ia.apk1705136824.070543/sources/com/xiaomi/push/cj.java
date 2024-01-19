package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import io.sentry.DateUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class cj {

    /* renamed from: a  reason: collision with root package name */
    public static long f4553a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static final String f418a = Locale.getDefault().getLanguage().toLowerCase();

    /* renamed from: a  reason: collision with other field name */
    public static final DateFormat f419a;

    /* renamed from: b  reason: collision with root package name */
    public static String f4554b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f4555c = (cu.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);

    /* renamed from: a  reason: collision with other field name */
    public cn f420a = null;

    /* renamed from: a  reason: collision with other field name */
    public List<cg> f421a = new CopyOnWriteArrayList();

    /* renamed from: a  reason: collision with other field name */
    public final Map<String, Object> f422a = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public String f4556d = f4554b;

    /* renamed from: e  reason: collision with root package name */
    public String f4557e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f4558f = null;
    public String g = null;
    public String h = null;
    public String i = null;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtils.ISO_FORMAT_WITH_MILLIS);
        f419a = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public cj() {
    }

    public cj(Bundle bundle) {
        this.f4558f = bundle.getString("ext_to");
        this.g = bundle.getString("ext_from");
        this.h = bundle.getString("ext_chid");
        this.f4557e = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f421a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                cg a2 = cg.a((Bundle) parcelable);
                if (a2 != null) {
                    this.f421a.add(a2);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.f420a = new cn(bundle2);
        }
    }

    public static synchronized String i() {
        String sb;
        synchronized (cj.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(f4555c);
            long j = f4553a;
            f4553a = 1 + j;
            sb2.append(Long.toString(j));
            sb = sb2.toString();
        }
        return sb;
    }

    public static String q() {
        return f418a;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.f4556d)) {
            bundle.putString("ext_ns", this.f4556d);
        }
        if (!TextUtils.isEmpty(this.g)) {
            bundle.putString("ext_from", this.g);
        }
        if (!TextUtils.isEmpty(this.f4558f)) {
            bundle.putString("ext_to", this.f4558f);
        }
        if (!TextUtils.isEmpty(this.f4557e)) {
            bundle.putString("ext_pkt_id", this.f4557e);
        }
        if (!TextUtils.isEmpty(this.h)) {
            bundle.putString("ext_chid", this.h);
        }
        cn cnVar = this.f420a;
        if (cnVar != null) {
            bundle.putBundle("ext_ERROR", cnVar.a());
        }
        List<cg> list = this.f421a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i2 = 0;
            for (cg a2 : this.f421a) {
                Bundle a3 = a2.a();
                if (a3 != null) {
                    bundleArr[i2] = a3;
                    i2++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    public cg a(String str) {
        return a(str, null);
    }

    public cg a(String str, String str2) {
        for (cg next : this.f421a) {
            if ((str2 == null || str2.equals(next.b())) && str.equals(next.a())) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public cn m574a() {
        return this.f420a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Object m575a(String str) {
        if (this.f422a == null) {
            return null;
        }
        return this.f422a.get(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public abstract String m576a();

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Collection<cg> m577a() {
        if (this.f421a == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(this.f421a));
    }

    public void a(cg cgVar) {
        this.f421a.add(cgVar);
    }

    public void a(cn cnVar) {
        this.f420a = cnVar;
    }

    public synchronized Collection<String> b() {
        if (this.f422a == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(this.f422a.keySet()));
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        cj cjVar = (cj) obj;
        cn cnVar = this.f420a;
        if (cnVar == null ? cjVar.f420a != null : !cnVar.equals(cjVar.f420a)) {
            return false;
        }
        String str = this.g;
        if (str == null ? cjVar.g != null : !str.equals(cjVar.g)) {
            return false;
        }
        if (!this.f421a.equals(cjVar.f421a)) {
            return false;
        }
        String str2 = this.f4557e;
        if (str2 == null ? cjVar.f4557e != null : !str2.equals(cjVar.f4557e)) {
            return false;
        }
        String str3 = this.h;
        if (str3 == null ? cjVar.h != null : !str3.equals(cjVar.h)) {
            return false;
        }
        Map<String, Object> map = this.f422a;
        if (map == null ? cjVar.f422a != null : !map.equals(cjVar.f422a)) {
            return false;
        }
        String str4 = this.f4558f;
        if (str4 == null ? cjVar.f4558f != null : !str4.equals(cjVar.f4558f)) {
            return false;
        }
        String str5 = this.f4556d;
        String str6 = cjVar.f4556d;
        if (str5 == null ? str6 != null : !str5.equals(str6)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        String str = this.f4556d;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f4557e;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f4558f;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.g;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.h;
        int hashCode5 = (this.f422a.hashCode() + ((this.f421a.hashCode() + ((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31)) * 31)) * 31;
        cn cnVar = this.f420a;
        if (cnVar != null) {
            i2 = cnVar.hashCode();
        }
        return hashCode5 + i2;
    }

    public String j() {
        if ("ID_NOT_AVAILABLE".equals(this.f4557e)) {
            return null;
        }
        if (this.f4557e == null) {
            this.f4557e = i();
        }
        return this.f4557e;
    }

    public String k() {
        return this.h;
    }

    public void k(String str) {
        this.f4557e = str;
    }

    public String l() {
        return this.f4558f;
    }

    public void l(String str) {
        this.h = str;
    }

    public String m() {
        return this.g;
    }

    public void m(String str) {
        this.f4558f = str;
    }

    public String n() {
        return this.i;
    }

    public void n(String str) {
        this.g = str;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:63|64|(0)|(0)|72|73) */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0111, code lost:
        if (r4 == null) goto L_0x0114;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00f5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:72:0x0129 */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x010c A[SYNTHETIC, Splitter:B:55:0x010c] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x011f A[SYNTHETIC, Splitter:B:66:0x011f] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0126 A[SYNTHETIC, Splitter:B:70:0x0126] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String o() {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0135 }
            r0.<init>()     // Catch:{ all -> 0x0135 }
            java.util.Collection r1 = r6.a()     // Catch:{ all -> 0x0135 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0135 }
        L_0x000e:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0135 }
            if (r2 == 0) goto L_0x0022
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0135 }
            com.xiaomi.push.ck r2 = (com.xiaomi.push.ck) r2     // Catch:{ all -> 0x0135 }
            java.lang.String r2 = r2.d()     // Catch:{ all -> 0x0135 }
            r0.append(r2)     // Catch:{ all -> 0x0135 }
            goto L_0x000e
        L_0x0022:
            java.util.Map<java.lang.String, java.lang.Object> r1 = r6.f422a     // Catch:{ all -> 0x0135 }
            if (r1 == 0) goto L_0x012f
            java.util.Map<java.lang.String, java.lang.Object> r1 = r6.f422a     // Catch:{ all -> 0x0135 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0135 }
            if (r1 != 0) goto L_0x012f
            java.lang.String r1 = "PHByb3BlcnRpZXMgeG1sbnM9Imh0dHA6Ly93d3cuaml2ZXNvZnR3YXJlLmNvbS94bWxucy94bXBwL3Byb3BlcnRpZXMiPg=="
            java.lang.String r1 = com.xiaomi.push.aa.a(r1)     // Catch:{ all -> 0x0135 }
            r0.append(r1)     // Catch:{ all -> 0x0135 }
            java.util.Collection r1 = r6.b()     // Catch:{ all -> 0x0135 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0135 }
        L_0x003f:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0135 }
            if (r2 == 0) goto L_0x012a
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0135 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0135 }
            java.lang.Object r3 = r6.a(r2)     // Catch:{ all -> 0x0135 }
            java.lang.String r4 = "<property>"
            r0.append(r4)     // Catch:{ all -> 0x0135 }
            java.lang.String r4 = "<name>"
            r0.append(r4)     // Catch:{ all -> 0x0135 }
            java.lang.String r2 = com.xiaomi.push.cu.a(r2)     // Catch:{ all -> 0x0135 }
            r0.append(r2)     // Catch:{ all -> 0x0135 }
            java.lang.String r2 = "</name>"
            r0.append(r2)     // Catch:{ all -> 0x0135 }
            java.lang.String r2 = "<value type=\""
            r0.append(r2)     // Catch:{ all -> 0x0135 }
            boolean r2 = r3 instanceof java.lang.Integer     // Catch:{ all -> 0x0135 }
            if (r2 == 0) goto L_0x007d
            java.lang.String r2 = "integer\">"
            r0.append(r2)     // Catch:{ all -> 0x0135 }
            r0.append(r3)     // Catch:{ all -> 0x0135 }
            java.lang.String r2 = "</value>"
        L_0x0078:
            r0.append(r2)     // Catch:{ all -> 0x0135 }
            goto L_0x0114
        L_0x007d:
            boolean r2 = r3 instanceof java.lang.Long     // Catch:{ all -> 0x0135 }
            if (r2 == 0) goto L_0x008c
            java.lang.String r2 = "long\">"
            r0.append(r2)     // Catch:{ all -> 0x0135 }
            r0.append(r3)     // Catch:{ all -> 0x0135 }
            java.lang.String r2 = "</value>"
            goto L_0x0078
        L_0x008c:
            boolean r2 = r3 instanceof java.lang.Float     // Catch:{ all -> 0x0135 }
            if (r2 == 0) goto L_0x009b
            java.lang.String r2 = "float\">"
            r0.append(r2)     // Catch:{ all -> 0x0135 }
            r0.append(r3)     // Catch:{ all -> 0x0135 }
            java.lang.String r2 = "</value>"
            goto L_0x0078
        L_0x009b:
            boolean r2 = r3 instanceof java.lang.Double     // Catch:{ all -> 0x0135 }
            if (r2 == 0) goto L_0x00aa
            java.lang.String r2 = "double\">"
            r0.append(r2)     // Catch:{ all -> 0x0135 }
            r0.append(r3)     // Catch:{ all -> 0x0135 }
            java.lang.String r2 = "</value>"
            goto L_0x0078
        L_0x00aa:
            boolean r2 = r3 instanceof java.lang.Boolean     // Catch:{ all -> 0x0135 }
            if (r2 == 0) goto L_0x00b9
            java.lang.String r2 = "boolean\">"
            r0.append(r2)     // Catch:{ all -> 0x0135 }
            r0.append(r3)     // Catch:{ all -> 0x0135 }
            java.lang.String r2 = "</value>"
            goto L_0x0078
        L_0x00b9:
            boolean r2 = r3 instanceof java.lang.String     // Catch:{ all -> 0x0135 }
            if (r2 == 0) goto L_0x00cf
            java.lang.String r2 = "string\">"
            r0.append(r2)     // Catch:{ all -> 0x0135 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0135 }
            java.lang.String r2 = com.xiaomi.push.cu.a(r3)     // Catch:{ all -> 0x0135 }
            r0.append(r2)     // Catch:{ all -> 0x0135 }
            java.lang.String r2 = "</value>"
            goto L_0x0078
        L_0x00cf:
            r2 = 0
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0103, all -> 0x0100 }
            r4.<init>()     // Catch:{ Exception -> 0x0103, all -> 0x0100 }
            java.io.ObjectOutputStream r5 = new java.io.ObjectOutputStream     // Catch:{ Exception -> 0x00fd, all -> 0x00fb }
            r5.<init>(r4)     // Catch:{ Exception -> 0x00fd, all -> 0x00fb }
            r5.writeObject(r3)     // Catch:{ Exception -> 0x00f9 }
            java.lang.String r2 = "java-object\">"
            r0.append(r2)     // Catch:{ Exception -> 0x00f9 }
            byte[] r2 = r4.toByteArray()     // Catch:{ Exception -> 0x00f9 }
            java.lang.String r2 = com.xiaomi.push.cu.a(r2)     // Catch:{ Exception -> 0x00f9 }
            r0.append(r2)     // Catch:{ Exception -> 0x00f9 }
            java.lang.String r2 = "</value>"
            r0.append(r2)     // Catch:{ Exception -> 0x00f9 }
            r5.close()     // Catch:{ Exception -> 0x00f5 }
        L_0x00f5:
            r4.close()     // Catch:{ Exception -> 0x0114 }
            goto L_0x0114
        L_0x00f9:
            r2 = move-exception
            goto L_0x0107
        L_0x00fb:
            r0 = move-exception
            goto L_0x011d
        L_0x00fd:
            r3 = move-exception
            r5 = r2
            goto L_0x0106
        L_0x0100:
            r0 = move-exception
            r4 = r2
            goto L_0x011d
        L_0x0103:
            r3 = move-exception
            r4 = r2
            r5 = r4
        L_0x0106:
            r2 = r3
        L_0x0107:
            r2.printStackTrace()     // Catch:{ all -> 0x011b }
            if (r5 == 0) goto L_0x0111
            r5.close()     // Catch:{ Exception -> 0x0110 }
            goto L_0x0111
        L_0x0110:
        L_0x0111:
            if (r4 == 0) goto L_0x0114
            goto L_0x00f5
        L_0x0114:
            java.lang.String r2 = "</property>"
            r0.append(r2)     // Catch:{ all -> 0x0135 }
            goto L_0x003f
        L_0x011b:
            r0 = move-exception
            r2 = r5
        L_0x011d:
            if (r2 == 0) goto L_0x0124
            r2.close()     // Catch:{ Exception -> 0x0123 }
            goto L_0x0124
        L_0x0123:
        L_0x0124:
            if (r4 == 0) goto L_0x0129
            r4.close()     // Catch:{ Exception -> 0x0129 }
        L_0x0129:
            throw r0     // Catch:{ all -> 0x0135 }
        L_0x012a:
            java.lang.String r1 = "</properties>"
            r0.append(r1)     // Catch:{ all -> 0x0135 }
        L_0x012f:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0135 }
            monitor-exit(r6)
            return r0
        L_0x0135:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.cj.o():java.lang.String");
    }

    public void o(String str) {
        this.i = str;
    }

    public String p() {
        return this.f4556d;
    }
}
