package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.config.ConfigConstant;
import com.razorpay.AnalyticsConstants;
import com.xiaomi.channel.commonutils.android.Region;
import com.xiaomi.channel.commonutils.android.c;
import com.xiaomi.push.bu;
import com.xiaomi.push.j;

public class r {

    /* renamed from: a  reason: collision with root package name */
    public static q f4973a;

    /* renamed from: a  reason: collision with other field name */
    public static a f937a;

    public interface a {
        void a();
    }

    public static int a(Context context) {
        return context.getSharedPreferences("mipush_account", 0).getInt("enc_req_fail_count", 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a7, code lost:
        return null;
     */
    /* renamed from: a  reason: collision with other method in class */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.xiaomi.push.service.q m868a(android.content.Context r12) {
        /*
            java.lang.Class<com.xiaomi.push.service.r> r0 = com.xiaomi.push.service.r.class
            monitor-enter(r0)
            com.xiaomi.push.service.q r1 = f4973a     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x000b
            com.xiaomi.push.service.q r12 = f4973a     // Catch:{ all -> 0x00a8 }
            monitor-exit(r0)
            return r12
        L_0x000b:
            java.lang.String r1 = "mipush_account"
            r2 = 0
            android.content.SharedPreferences r1 = r12.getSharedPreferences(r1, r2)     // Catch:{ all -> 0x00a8 }
            java.lang.String r2 = "uuid"
            r3 = 0
            java.lang.String r5 = r1.getString(r2, r3)     // Catch:{ all -> 0x00a8 }
            java.lang.String r2 = "token"
            java.lang.String r6 = r1.getString(r2, r3)     // Catch:{ all -> 0x00a8 }
            java.lang.String r2 = "security"
            java.lang.String r7 = r1.getString(r2, r3)     // Catch:{ all -> 0x00a8 }
            java.lang.String r2 = "app_id"
            java.lang.String r8 = r1.getString(r2, r3)     // Catch:{ all -> 0x00a8 }
            java.lang.String r2 = "app_token"
            java.lang.String r9 = r1.getString(r2, r3)     // Catch:{ all -> 0x00a8 }
            java.lang.String r2 = "package_name"
            java.lang.String r10 = r1.getString(r2, r3)     // Catch:{ all -> 0x00a8 }
            java.lang.String r2 = "device_id"
            java.lang.String r2 = r1.getString(r2, r3)     // Catch:{ all -> 0x00a8 }
            java.lang.String r4 = "env_type"
            r11 = 1
            int r11 = r1.getInt(r4, r11)     // Catch:{ all -> 0x00a8 }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00a8 }
            if (r4 != 0) goto L_0x0063
            boolean r4 = com.xiaomi.channel.commonutils.android.c.a(r2)     // Catch:{ all -> 0x00a8 }
            if (r4 == 0) goto L_0x0063
            java.lang.String r2 = com.xiaomi.channel.commonutils.android.c.d(r12)     // Catch:{ all -> 0x00a8 }
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ all -> 0x00a8 }
            java.lang.String r4 = "device_id"
            android.content.SharedPreferences$Editor r1 = r1.putString(r4, r2)     // Catch:{ all -> 0x00a8 }
            r1.commit()     // Catch:{ all -> 0x00a8 }
        L_0x0063:
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00a8 }
            if (r1 != 0) goto L_0x00a6
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00a8 }
            if (r1 != 0) goto L_0x00a6
            boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x00a8 }
            if (r1 != 0) goto L_0x00a6
            java.lang.String r1 = com.xiaomi.channel.commonutils.android.c.d(r12)     // Catch:{ all -> 0x00a8 }
            java.lang.String r3 = "com.xiaomi.xmsf"
            java.lang.String r12 = r12.getPackageName()     // Catch:{ all -> 0x00a8 }
            boolean r12 = r3.equals(r12)     // Catch:{ all -> 0x00a8 }
            if (r12 != 0) goto L_0x009c
            boolean r12 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00a8 }
            if (r12 != 0) goto L_0x009c
            boolean r12 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00a8 }
            if (r12 != 0) goto L_0x009c
            boolean r12 = r2.equals(r1)     // Catch:{ all -> 0x00a8 }
            if (r12 != 0) goto L_0x009c
            java.lang.String r12 = "read_phone_state permission changes."
            com.xiaomi.channel.commonutils.logger.b.a(r12)     // Catch:{ all -> 0x00a8 }
        L_0x009c:
            com.xiaomi.push.service.q r12 = new com.xiaomi.push.service.q     // Catch:{ all -> 0x00a8 }
            r4 = r12
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x00a8 }
            f4973a = r12     // Catch:{ all -> 0x00a8 }
            monitor-exit(r0)
            return r12
        L_0x00a6:
            monitor-exit(r0)
            return r3
        L_0x00a8:
            r12 = move-exception
            monitor-exit(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.r.m868a(android.content.Context):com.xiaomi.push.service.q");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0046 A[Catch:{ Exception -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051 A[Catch:{ Exception -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0055 A[Catch:{ Exception -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005d A[Catch:{ Exception -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0061 A[Catch:{ Exception -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0069 A[Catch:{ Exception -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006d A[Catch:{ Exception -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008d A[Catch:{ Exception -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0094 A[Catch:{ Exception -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d4 A[Catch:{ Exception -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f1 A[Catch:{ Exception -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0159 A[Catch:{ Exception -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01ac A[SYNTHETIC, Splitter:B:69:0x01ac] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.xiaomi.push.service.q a(android.content.Context r17, java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            r1 = r17
            java.lang.Class<com.xiaomi.push.service.r> r2 = com.xiaomi.push.service.r.class
            monitor-enter(r2)
            java.util.TreeMap r3 = new java.util.TreeMap     // Catch:{ all -> 0x02a0 }
            r3.<init>()     // Catch:{ all -> 0x02a0 }
            java.lang.String r0 = com.xiaomi.channel.commonutils.android.c.a(r17)     // Catch:{ all -> 0x02a0 }
            java.lang.String r4 = "devid"
            r3.put(r4, r0)     // Catch:{ all -> 0x02a0 }
            com.xiaomi.push.service.q r0 = f4973a     // Catch:{ all -> 0x02a0 }
            r4 = 1
            r5 = 0
            if (r0 == 0) goto L_0x003b
            com.xiaomi.push.service.q r0 = f4973a     // Catch:{ all -> 0x02a0 }
            java.lang.String r0 = r0.f936a     // Catch:{ all -> 0x02a0 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x02a0 }
            if (r0 != 0) goto L_0x003b
            com.xiaomi.push.service.q r0 = f4973a     // Catch:{ all -> 0x02a0 }
            java.lang.String r0 = r0.f936a     // Catch:{ all -> 0x02a0 }
            java.lang.String r6 = "/"
            int r0 = r0.lastIndexOf(r6)     // Catch:{ all -> 0x02a0 }
            r6 = -1
            if (r0 == r6) goto L_0x003b
            com.xiaomi.push.service.q r6 = f4973a     // Catch:{ all -> 0x02a0 }
            java.lang.String r6 = r6.f936a     // Catch:{ all -> 0x02a0 }
            int r0 = r0 + r4
            java.lang.String r0 = r6.substring(r0)     // Catch:{ all -> 0x02a0 }
            r6 = r0
            goto L_0x003c
        L_0x003b:
            r6 = r5
        L_0x003c:
            java.lang.String r0 = com.xiaomi.channel.commonutils.android.c.b(r17)     // Catch:{ all -> 0x02a0 }
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x02a0 }
            if (r7 != 0) goto L_0x004b
            java.lang.String r7 = "gaid"
            r3.put(r7, r0)     // Catch:{ all -> 0x02a0 }
        L_0x004b:
            boolean r0 = a(r17)     // Catch:{ all -> 0x02a0 }
            if (r0 == 0) goto L_0x0055
            java.lang.String r0 = "1000271"
            r11 = r0
            goto L_0x0057
        L_0x0055:
            r11 = r19
        L_0x0057:
            boolean r0 = a(r17)     // Catch:{ all -> 0x02a0 }
            if (r0 == 0) goto L_0x0061
            java.lang.String r0 = "420100086271"
            r12 = r0
            goto L_0x0063
        L_0x0061:
            r12 = r20
        L_0x0063:
            boolean r0 = a(r17)     // Catch:{ all -> 0x02a0 }
            if (r0 == 0) goto L_0x006d
            java.lang.String r0 = "com.xiaomi.xmsf"
            r13 = r0
            goto L_0x006f
        L_0x006d:
            r13 = r18
        L_0x006f:
            java.lang.String r0 = "appid"
            r3.put(r0, r11)     // Catch:{ all -> 0x02a0 }
            java.lang.String r0 = "apptoken"
            r3.put(r0, r12)     // Catch:{ all -> 0x02a0 }
            android.content.pm.PackageManager r0 = r17.getPackageManager()     // Catch:{ Exception -> 0x0084 }
            r7 = 16384(0x4000, float:2.2959E-41)
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r13, r7)     // Catch:{ Exception -> 0x0084 }
            goto L_0x0089
        L_0x0084:
            r0 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a(r0)     // Catch:{ all -> 0x02a0 }
            r0 = r5
        L_0x0089:
            java.lang.String r7 = "appversion"
            if (r0 == 0) goto L_0x0094
            int r0 = r0.versionCode     // Catch:{ all -> 0x02a0 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x02a0 }
            goto L_0x0096
        L_0x0094:
            java.lang.String r0 = "0"
        L_0x0096:
            r3.put(r7, r0)     // Catch:{ all -> 0x02a0 }
            java.lang.String r0 = "sdkversion"
            r7 = 50011(0xc35b, float:7.008E-41)
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x02a0 }
            r3.put(r0, r7)     // Catch:{ all -> 0x02a0 }
            java.lang.String r0 = "packagename"
            r3.put(r0, r13)     // Catch:{ all -> 0x02a0 }
            java.lang.String r0 = "model"
            java.lang.String r7 = android.os.Build.MODEL     // Catch:{ all -> 0x02a0 }
            r3.put(r0, r7)     // Catch:{ all -> 0x02a0 }
            java.lang.String r0 = "os"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a0 }
            r7.<init>()     // Catch:{ all -> 0x02a0 }
            java.lang.String r8 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x02a0 }
            r7.append(r8)     // Catch:{ all -> 0x02a0 }
            java.lang.String r8 = "-"
            r7.append(r8)     // Catch:{ all -> 0x02a0 }
            java.lang.String r8 = android.os.Build.VERSION.INCREMENTAL     // Catch:{ all -> 0x02a0 }
            r7.append(r8)     // Catch:{ all -> 0x02a0 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x02a0 }
            r3.put(r0, r7)     // Catch:{ all -> 0x02a0 }
            int r0 = com.xiaomi.channel.commonutils.android.c.a()     // Catch:{ all -> 0x02a0 }
            if (r0 < 0) goto L_0x00de
            java.lang.String r7 = "space_id"
            java.lang.String r0 = java.lang.Integer.toString(r0)     // Catch:{ all -> 0x02a0 }
            r3.put(r7, r0)     // Catch:{ all -> 0x02a0 }
        L_0x00de:
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ all -> 0x02a0 }
            r7.<init>()     // Catch:{ all -> 0x02a0 }
            java.util.Set r0 = r3.entrySet()     // Catch:{ all -> 0x02a0 }
            java.util.Iterator r8 = r0.iterator()     // Catch:{ all -> 0x02a0 }
        L_0x00eb:
            boolean r0 = r8.hasNext()     // Catch:{ all -> 0x02a0 }
            if (r0 == 0) goto L_0x0138
            java.lang.Object r0 = r8.next()     // Catch:{ all -> 0x02a0 }
            r9 = r0
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9     // Catch:{ all -> 0x02a0 }
            java.lang.Object r0 = r9.getKey()     // Catch:{ JSONException -> 0x0106 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ JSONException -> 0x0106 }
            java.lang.Object r10 = r9.getValue()     // Catch:{ JSONException -> 0x0106 }
            r7.put(r0, r10)     // Catch:{ JSONException -> 0x0106 }
            goto L_0x00eb
        L_0x0106:
            r0 = move-exception
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a0 }
            r10.<init>()     // Catch:{ all -> 0x02a0 }
            java.lang.String r14 = "failed to add data in json format: k="
            r10.append(r14)     // Catch:{ all -> 0x02a0 }
            java.lang.Object r14 = r9.getKey()     // Catch:{ all -> 0x02a0 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ all -> 0x02a0 }
            r10.append(r14)     // Catch:{ all -> 0x02a0 }
            java.lang.String r14 = ",v="
            r10.append(r14)     // Catch:{ all -> 0x02a0 }
            java.lang.Object r9 = r9.getValue()     // Catch:{ all -> 0x02a0 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x02a0 }
            r10.append(r9)     // Catch:{ all -> 0x02a0 }
            java.lang.String r9 = ". "
            r10.append(r9)     // Catch:{ all -> 0x02a0 }
            r10.append(r0)     // Catch:{ all -> 0x02a0 }
            java.lang.String r0 = r10.toString()     // Catch:{ all -> 0x02a0 }
            com.xiaomi.channel.commonutils.logger.b.d(r0)     // Catch:{ all -> 0x02a0 }
            goto L_0x00eb
        L_0x0138:
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x02a0 }
            java.lang.String r0 = com.xiaomi.push.service.bk.a(r0)     // Catch:{ all -> 0x02a0 }
            java.util.TreeMap r7 = new java.util.TreeMap     // Catch:{ all -> 0x02a0 }
            r7.<init>()     // Catch:{ all -> 0x02a0 }
            java.lang.String r8 = "requestData"
            r7.put(r8, r0)     // Catch:{ all -> 0x02a0 }
            java.lang.String r8 = "keyPairVer"
            java.lang.String r9 = "1"
            r7.put(r8, r9)     // Catch:{ all -> 0x02a0 }
            int r8 = a(r17)     // Catch:{ all -> 0x02a0 }
            r9 = 2
            r15 = 0
            if (r8 >= r9) goto L_0x0176
            boolean r8 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x02a0 }
            if (r8 == 0) goto L_0x0160
            goto L_0x0176
        L_0x0160:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a0 }
            r8.<init>()     // Catch:{ all -> 0x02a0 }
            java.lang.String r9 = "r.data = "
            r8.append(r9)     // Catch:{ all -> 0x02a0 }
            r8.append(r0)     // Catch:{ all -> 0x02a0 }
            java.lang.String r0 = r8.toString()     // Catch:{ all -> 0x02a0 }
            com.xiaomi.channel.commonutils.logger.b.a(r0)     // Catch:{ all -> 0x02a0 }
            r14 = 1
            goto L_0x0177
        L_0x0176:
            r14 = 0
        L_0x0177:
            java.lang.String r0 = a(r1, r14)     // Catch:{ all -> 0x02a0 }
            if (r14 == 0) goto L_0x017e
            r3 = r7
        L_0x017e:
            com.xiaomi.push.w r0 = com.xiaomi.push.y.a(r1, r0, r3)     // Catch:{ IOException -> 0x0183 }
            goto L_0x019a
        L_0x0183:
            r0 = move-exception
            r3 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a0 }
            r0.<init>()     // Catch:{ all -> 0x02a0 }
            java.lang.String r7 = "device registration request failed. "
            r0.append(r7)     // Catch:{ all -> 0x02a0 }
            r0.append(r3)     // Catch:{ all -> 0x02a0 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x02a0 }
            com.xiaomi.channel.commonutils.logger.b.d(r0)     // Catch:{ all -> 0x02a0 }
            r0 = r5
        L_0x019a:
            if (r0 == 0) goto L_0x0287
            int r3 = r0.f4991a     // Catch:{ all -> 0x02a0 }
            r7 = 200(0xc8, float:2.8E-43)
            if (r3 != r7) goto L_0x0287
            java.lang.String r0 = r0.a()     // Catch:{ all -> 0x02a0 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x02a0 }
            if (r3 != 0) goto L_0x0287
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0272, all -> 0x0259 }
            r3.<init>(r0)     // Catch:{ JSONException -> 0x0272, all -> 0x0259 }
            java.lang.String r7 = "code"
            int r7 = r3.getInt(r7)     // Catch:{ JSONException -> 0x0272, all -> 0x0259 }
            if (r7 != 0) goto L_0x022f
            java.lang.String r0 = "data"
            org.json.JSONObject r0 = r3.getJSONObject(r0)     // Catch:{ JSONException -> 0x0272, all -> 0x0259 }
            java.lang.String r3 = "ssecurity"
            java.lang.String r10 = r0.getString(r3)     // Catch:{ JSONException -> 0x0272, all -> 0x0259 }
            java.lang.String r3 = "token"
            java.lang.String r9 = r0.getString(r3)     // Catch:{ JSONException -> 0x0272, all -> 0x0259 }
            java.lang.String r3 = "userId"
            java.lang.String r0 = r0.getString(r3)     // Catch:{ JSONException -> 0x0272, all -> 0x0259 }
            boolean r3 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x0272, all -> 0x0259 }
            if (r3 == 0) goto L_0x01f0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0272, all -> 0x0259 }
            r3.<init>()     // Catch:{ JSONException -> 0x0272, all -> 0x0259 }
            java.lang.String r6 = "an"
            r3.append(r6)     // Catch:{ JSONException -> 0x0272, all -> 0x0259 }
            r6 = 6
            java.lang.String r6 = com.xiaomi.push.ad.a(r6)     // Catch:{ JSONException -> 0x0272, all -> 0x0259 }
            r3.append(r6)     // Catch:{ JSONException -> 0x0272, all -> 0x0259 }
            java.lang.String r6 = r3.toString()     // Catch:{ JSONException -> 0x0272, all -> 0x0259 }
        L_0x01f0:
            com.xiaomi.push.service.q r3 = new com.xiaomi.push.service.q     // Catch:{ JSONException -> 0x0272, all -> 0x0259 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0272, all -> 0x0259 }
            r7.<init>()     // Catch:{ JSONException -> 0x0272, all -> 0x0259 }
            r7.append(r0)     // Catch:{ JSONException -> 0x0272, all -> 0x0259 }
            java.lang.String r8 = "@xiaomi.com/"
            r7.append(r8)     // Catch:{ JSONException -> 0x0272, all -> 0x0259 }
            r7.append(r6)     // Catch:{ JSONException -> 0x0272, all -> 0x0259 }
            java.lang.String r8 = r7.toString()     // Catch:{ JSONException -> 0x0272, all -> 0x0259 }
            int r6 = com.xiaomi.push.j.a()     // Catch:{ JSONException -> 0x0272, all -> 0x0259 }
            r7 = r3
            r16 = r14
            r14 = r6
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ JSONException -> 0x0257, all -> 0x0255 }
            a(r1, r3)     // Catch:{ JSONException -> 0x0257, all -> 0x0255 }
            f4973a = r3     // Catch:{ JSONException -> 0x0257, all -> 0x0255 }
            a(r1, r15)     // Catch:{ JSONException -> 0x0257, all -> 0x0255 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0257, all -> 0x0255 }
            r6.<init>()     // Catch:{ JSONException -> 0x0257, all -> 0x0255 }
            java.lang.String r7 = "device registration is successful. "
            r6.append(r7)     // Catch:{ JSONException -> 0x0257, all -> 0x0255 }
            r6.append(r0)     // Catch:{ JSONException -> 0x0257, all -> 0x0255 }
            java.lang.String r0 = r6.toString()     // Catch:{ JSONException -> 0x0257, all -> 0x0255 }
            com.xiaomi.channel.commonutils.logger.b.a(r0)     // Catch:{ JSONException -> 0x0257, all -> 0x0255 }
            monitor-exit(r2)
            return r3
        L_0x022f:
            r16 = r14
            java.lang.String r6 = "code"
            int r6 = r3.getInt(r6)     // Catch:{ JSONException -> 0x0257, all -> 0x0255 }
            java.lang.String r7 = "description"
            java.lang.String r3 = r3.optString(r7)     // Catch:{ JSONException -> 0x0257, all -> 0x0255 }
            com.xiaomi.push.service.u.a(r1, r6, r3)     // Catch:{ JSONException -> 0x0257, all -> 0x0255 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0257, all -> 0x0255 }
            r3.<init>()     // Catch:{ JSONException -> 0x0257, all -> 0x0255 }
            java.lang.String r6 = "device registration resp: "
            r3.append(r6)     // Catch:{ JSONException -> 0x0257, all -> 0x0255 }
            r3.append(r0)     // Catch:{ JSONException -> 0x0257, all -> 0x0255 }
            java.lang.String r0 = r3.toString()     // Catch:{ JSONException -> 0x0257, all -> 0x0255 }
            com.xiaomi.channel.commonutils.logger.b.a(r0)     // Catch:{ JSONException -> 0x0257, all -> 0x0255 }
            goto L_0x0289
        L_0x0255:
            r0 = move-exception
            goto L_0x025c
        L_0x0257:
            r0 = move-exception
            goto L_0x0275
        L_0x0259:
            r0 = move-exception
            r16 = r14
        L_0x025c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a0 }
            r3.<init>()     // Catch:{ all -> 0x02a0 }
            java.lang.String r6 = "unknow throwable. "
            r3.append(r6)     // Catch:{ all -> 0x02a0 }
            r3.append(r0)     // Catch:{ all -> 0x02a0 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x02a0 }
        L_0x026e:
            com.xiaomi.channel.commonutils.logger.b.d(r0)     // Catch:{ all -> 0x02a0 }
            goto L_0x0289
        L_0x0272:
            r0 = move-exception
            r16 = r14
        L_0x0275:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a0 }
            r3.<init>()     // Catch:{ all -> 0x02a0 }
            java.lang.String r6 = "failed to parse respone json data. "
            r3.append(r6)     // Catch:{ all -> 0x02a0 }
            r3.append(r0)     // Catch:{ all -> 0x02a0 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x02a0 }
            goto L_0x026e
        L_0x0287:
            r16 = r14
        L_0x0289:
            if (r16 == 0) goto L_0x0299
            boolean r0 = com.xiaomi.push.y.b(r17)     // Catch:{ all -> 0x02a0 }
            if (r0 == 0) goto L_0x0299
            int r0 = a(r17)     // Catch:{ all -> 0x02a0 }
            int r0 = r0 + r4
            a(r1, r0)     // Catch:{ all -> 0x02a0 }
        L_0x0299:
            java.lang.String r0 = "fail to register push account. meet error."
            com.xiaomi.channel.commonutils.logger.b.a(r0)     // Catch:{ all -> 0x02a0 }
            monitor-exit(r2)
            return r5
        L_0x02a0:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.r.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String):com.xiaomi.push.service.q");
    }

    public static String a(Context context, boolean z) {
        StringBuilder sb;
        String str;
        String a2 = a.a(context).a();
        String str2 = z ? "/pass/v2/register/encrypt" : "/pass/v2/register";
        if (j.b()) {
            sb = GeneratedOutlineSupport.outline73("http://");
            sb.append(bu.f4515a);
            str = ":9085";
        } else if (Region.Global.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://register.xmpush.global.xiaomi.com";
        } else if (Region.Europe.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://fr.register.xmpush.global.xiaomi.com";
        } else if (Region.Russia.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://ru.register.xmpush.global.xiaomi.com";
        } else if (Region.India.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://idmb.register.xmpush.global.xiaomi.com";
        } else {
            sb = new StringBuilder();
            sb.append("https://");
            j.a();
            str = "";
        }
        return GeneratedOutlineSupport.outline62(sb, str, str2);
    }

    public static void a() {
        a aVar = f937a;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m869a(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        f4973a = null;
        a();
    }

    public static void a(Context context, int i) {
        Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putInt("enc_req_fail_count", i);
        edit.commit();
    }

    public static void a(Context context, q qVar) {
        Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putString("uuid", qVar.f936a);
        edit.putString("security", qVar.f4969c);
        edit.putString("token", qVar.f4968b);
        edit.putString("app_id", qVar.f4970d);
        edit.putString("package_name", qVar.f4972f);
        edit.putString(AnalyticsConstants.APP_TOKEN, qVar.f4971e);
        edit.putString(ConfigConstant.DEVICE_ID, c.d(context));
        edit.putInt("env_type", qVar.f4967a);
        edit.commit();
        a();
    }

    public static void a(a aVar) {
        f937a = aVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m870a(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }
}
