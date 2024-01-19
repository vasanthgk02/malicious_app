package com.cardinalcommerce.shared.cs.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f2213a;

    /* renamed from: b  reason: collision with root package name */
    public static String f2214b;

    /* renamed from: c  reason: collision with root package name */
    public static String f2215c;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f2216e;

    /* renamed from: d  reason: collision with root package name */
    public final String f2217d = a.class.getSimpleName();

    /* renamed from: com.cardinalcommerce.shared.cs.utils.a$a  reason: collision with other inner class name */
    public static class C0032a extends com.cardinalcommerce.shared.cs.d.a {
        public C0032a(String str, String str2) {
            super.a(str2, str, 10000);
        }

        public void a(Exception exc, com.cardinalcommerce.shared.cs.b.a aVar) {
        }

        public void a(String str) {
            a.e().c();
        }

        public void a(String str, int i) {
        }
    }

    public a() {
        f2213a = true;
    }

    public static a e() {
        if (f2216e == null) {
            synchronized (a.class) {
                try {
                    if (f2216e == null) {
                        f2216e = new a();
                    }
                }
            }
        }
        return f2216e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:74:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x013f A[Catch:{ JSONException -> 0x0143 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.cardinalcommerce.shared.cs.utils.c r20) {
        /*
            r19 = this;
            r1 = r20
            boolean r0 = f2213a
            if (r0 == 0) goto L_0x0173
            java.lang.String r2 = f2214b
            java.lang.String r3 = f2215c
            if (r0 == 0) goto L_0x0173
            android.content.Context r4 = com.cardinalcommerce.shared.cs.utils.CCInitProvider.f2212a
            com.cardinalcommerce.shared.cs.utils.b r5 = r19.b()
            java.lang.String r6 = "mutator"
            java.lang.String r7 = "identifier"
            java.util.HashMap r0 = com.android.tools.r8.GeneratedOutlineSupport.outline88(r6, r3, r7, r2)
            java.lang.String r8 = r1.f2220b
            java.lang.String r9 = "sessionid"
            r0.put(r9, r8)
            if (r5 == 0) goto L_0x0171
            r8 = 0
        L_0x0024:
            int r10 = r5.length()     // Catch:{ JSONException -> 0x006c }
            if (r8 >= r10) goto L_0x006c
            org.json.JSONObject r10 = r5.getJSONObject(r8)     // Catch:{ JSONException -> 0x006c }
            java.util.Set r11 = r0.keySet()     // Catch:{ JSONException -> 0x006c }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ JSONException -> 0x006c }
            r12 = 0
        L_0x0037:
            boolean r13 = r11.hasNext()     // Catch:{ JSONException -> 0x006c }
            if (r13 == 0) goto L_0x0066
            java.lang.Object r12 = r11.next()     // Catch:{ JSONException -> 0x006c }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ JSONException -> 0x006c }
            boolean r13 = r10.has(r12)     // Catch:{ JSONException -> 0x006c }
            if (r13 == 0) goto L_0x0057
            java.lang.String r13 = r10.getString(r12)     // Catch:{ JSONException -> 0x006c }
            java.lang.Object r14 = r0.get(r12)     // Catch:{ JSONException -> 0x006c }
            boolean r13 = r13.equals(r14)     // Catch:{ JSONException -> 0x006c }
            if (r13 != 0) goto L_0x0063
        L_0x0057:
            boolean r13 = r10.has(r12)     // Catch:{ JSONException -> 0x006c }
            if (r13 != 0) goto L_0x0065
            boolean r12 = r12.equals(r9)     // Catch:{ JSONException -> 0x006c }
            if (r12 == 0) goto L_0x0065
        L_0x0063:
            r12 = 1
            goto L_0x0037
        L_0x0065:
            r12 = 0
        L_0x0066:
            if (r12 == 0) goto L_0x0069
            goto L_0x006d
        L_0x0069:
            int r8 = r8 + 1
            goto L_0x0024
        L_0x006c:
            r10 = 0
        L_0x006d:
            java.lang.String r8 = "data"
            java.lang.String r11 = "version"
            java.lang.String r12 = "application"
            if (r10 == 0) goto L_0x0100
            java.lang.String r0 = r10.getString(r12)     // Catch:{ JSONException -> 0x00f5 }
            java.lang.String r13 = r10.getString(r11)     // Catch:{ JSONException -> 0x00f5 }
            java.lang.String r14 = r10.getString(r7)     // Catch:{ JSONException -> 0x00f5 }
            java.lang.String r15 = r10.getString(r6)     // Catch:{ JSONException -> 0x00f5 }
            boolean r16 = r10.has(r8)     // Catch:{ JSONException -> 0x00f5 }
            if (r16 == 0) goto L_0x0090
            org.json.JSONArray r16 = r10.getJSONArray(r8)     // Catch:{ JSONException -> 0x00f5 }
            goto L_0x0095
        L_0x0090:
            org.json.JSONArray r16 = new org.json.JSONArray     // Catch:{ JSONException -> 0x00f5 }
            r16.<init>()     // Catch:{ JSONException -> 0x00f5 }
        L_0x0095:
            r17 = r4
            r4 = r16
            boolean r16 = r10.has(r9)     // Catch:{ JSONException -> 0x00ef }
            if (r16 == 0) goto L_0x00a2
            r10.getString(r9)     // Catch:{ JSONException -> 0x00ef }
        L_0x00a2:
            r16 = r3
            java.lang.String r3 = r1.f2220b     // Catch:{ JSONException -> 0x00eb }
            r18 = r2
            org.json.JSONObject r2 = r20.b()     // Catch:{ JSONException -> 0x00e9 }
            r4.put(r2)     // Catch:{ JSONException -> 0x00e9 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00e9 }
            r2.<init>()     // Catch:{ JSONException -> 0x00e9 }
            r2.put(r12, r0)     // Catch:{ JSONException -> 0x00c9 }
            r2.put(r11, r13)     // Catch:{ JSONException -> 0x00c9 }
            r2.put(r7, r14)     // Catch:{ JSONException -> 0x00c9 }
            r2.put(r6, r15)     // Catch:{ JSONException -> 0x00c9 }
            r2.put(r8, r4)     // Catch:{ JSONException -> 0x00c9 }
            if (r3 == 0) goto L_0x00ca
            r2.put(r9, r3)     // Catch:{ JSONException -> 0x00c9 }
            goto L_0x00ca
        L_0x00c9:
            r2 = 0
        L_0x00ca:
            r0 = 0
        L_0x00cb:
            int r3 = r5.length()     // Catch:{ JSONException -> 0x00e4 }
            if (r0 >= r3) goto L_0x0147
            org.json.JSONObject r3 = r5.getJSONObject(r0)     // Catch:{ JSONException -> 0x00e4 }
            if (r3 != r10) goto L_0x00e1
            if (r2 == 0) goto L_0x00e1
            r5.remove(r0)     // Catch:{ JSONException -> 0x00e4 }
            r5.put(r2)     // Catch:{ JSONException -> 0x00e4 }
            goto L_0x0147
        L_0x00e1:
            int r0 = r0 + 1
            goto L_0x00cb
        L_0x00e4:
            r0 = move-exception
            r0.getLocalizedMessage()     // Catch:{ JSONException -> 0x00e9 }
            goto L_0x0147
        L_0x00e9:
            r0 = move-exception
            goto L_0x00fc
        L_0x00eb:
            r0 = move-exception
            r18 = r2
            goto L_0x00fc
        L_0x00ef:
            r0 = move-exception
            r18 = r2
            r16 = r3
            goto L_0x00fc
        L_0x00f5:
            r0 = move-exception
            r18 = r2
            r16 = r3
            r17 = r4
        L_0x00fc:
            r0.getLocalizedMessage()
            goto L_0x0106
        L_0x0100:
            r18 = r2
            r16 = r3
            r17 = r4
        L_0x0106:
            int r0 = r5.length()
            r2 = 100
            if (r0 != r2) goto L_0x0113
            com.cardinalcommerce.shared.cs.utils.b r5 = new com.cardinalcommerce.shared.cs.utils.b
            r5.<init>()
        L_0x0113:
            java.lang.String r0 = r1.f2220b
            java.lang.String r2 = "CardinalMobileSdk_Android"
            java.lang.String r3 = "2.2.5-2"
            org.json.JSONArray r4 = new org.json.JSONArray
            r4.<init>()
            org.json.JSONObject r1 = r20.b()
            r4.put(r1)
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            r1.put(r12, r2)     // Catch:{ JSONException -> 0x0143 }
            r1.put(r11, r3)     // Catch:{ JSONException -> 0x0143 }
            r2 = r18
            r1.put(r7, r2)     // Catch:{ JSONException -> 0x0143 }
            r2 = r16
            r1.put(r6, r2)     // Catch:{ JSONException -> 0x0143 }
            r1.put(r8, r4)     // Catch:{ JSONException -> 0x0143 }
            if (r0 == 0) goto L_0x0144
            r1.put(r9, r0)     // Catch:{ JSONException -> 0x0143 }
            goto L_0x0144
        L_0x0143:
            r1 = 0
        L_0x0144:
            r5.put(r1)
        L_0x0147:
            java.lang.String r0 = r5.toString()
            java.io.OutputStreamWriter r1 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x016c }
            java.lang.String r2 = "cca_logs.txt"
            r3 = 0
            r4 = r17
            java.io.FileOutputStream r2 = r4.openFileOutput(r2, r3)     // Catch:{ IOException -> 0x016c }
            r1.<init>(r2)     // Catch:{ IOException -> 0x016c }
            r1.append(r0)     // Catch:{ all -> 0x0160 }
            r1.close()     // Catch:{ IOException -> 0x016c }
            goto L_0x0173
        L_0x0160:
            r0 = move-exception
            r2 = r0
            r1.close()     // Catch:{ all -> 0x0166 }
            goto L_0x016b
        L_0x0166:
            r0 = move-exception
            r1 = r0
            r2.addSuppressed(r1)     // Catch:{ IOException -> 0x016c }
        L_0x016b:
            throw r2     // Catch:{ IOException -> 0x016c }
        L_0x016c:
            r0 = move-exception
            r0.getLocalizedMessage()
            goto L_0x0173
        L_0x0171:
            r0 = 0
            throw r0
        L_0x0173:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.shared.cs.utils.a.a(com.cardinalcommerce.shared.cs.utils.c):void");
    }

    public b b() {
        BufferedReader bufferedReader;
        String str = "";
        try {
            FileInputStream openFileInput = CCInitProvider.f2212a.openFileInput("cca_logs.txt");
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(openFileInput);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    if (openFileInput != null) {
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                            sb.append("\n");
                        }
                        str = sb.toString();
                    }
                    bufferedReader.close();
                    inputStreamReader.close();
                    if (openFileInput != null) {
                        openFileInput.close();
                    }
                    String trim = str.trim();
                    if (!trim.isEmpty()) {
                        try {
                            return new b(trim);
                        } catch (JSONException e2) {
                            e2.getLocalizedMessage();
                        }
                    }
                    return new b();
                } catch (Throwable th) {
                    inputStreamReader.close();
                    throw th;
                }
                throw th;
            } catch (Throwable th2) {
                if (openFileInput != null) {
                    openFileInput.close();
                }
                throw th2;
            }
        } catch (IOException e3) {
            e3.getLocalizedMessage();
        } catch (Throwable th3) {
            th2.addSuppressed(th3);
        }
    }

    public void c() {
        OutputStreamWriter outputStreamWriter;
        if (f2213a) {
            try {
                outputStreamWriter = new OutputStreamWriter(CCInitProvider.f2212a.openFileOutput("cca_logs.txt", 0));
                outputStreamWriter.append("");
                outputStreamWriter.close();
                return;
            } catch (IOException e2) {
                e2.getLocalizedMessage();
                return;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            return;
        }
        throw th;
    }

    public void b(String str, String str2, String str3) {
        c cVar = new c();
        cVar.f2223e = str;
        cVar.f2219a = str2;
        cVar.f2220b = str3;
        cVar.f2221c = String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
        cVar.f2224f = true;
        a(cVar);
    }

    public void a(String str, String str2, String str3) {
        c cVar = new c();
        cVar.f2222d = str;
        cVar.f2219a = str2;
        cVar.f2220b = str3;
        cVar.f2221c = String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
        a(cVar);
    }
}
