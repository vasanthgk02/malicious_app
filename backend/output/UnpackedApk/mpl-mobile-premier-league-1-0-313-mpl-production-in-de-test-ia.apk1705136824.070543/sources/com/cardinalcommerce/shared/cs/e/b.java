package com.cardinalcommerce.shared.cs.e;

import java.io.Serializable;
import java.util.ArrayList;

public class b implements Serializable {
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public boolean G;
    public String H;

    /* renamed from: a  reason: collision with root package name */
    public i f2085a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2086b = false;

    /* renamed from: c  reason: collision with root package name */
    public String f2087c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f2088d;

    /* renamed from: e  reason: collision with root package name */
    public String f2089e;

    /* renamed from: f  reason: collision with root package name */
    public String f2090f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public ArrayList<h> n;
    public String o;
    public String p;
    public f q;
    public String s;
    public String t;
    public String u;
    public String w;
    public f x;
    public String y;
    public String z;

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0083, code lost:
        r5 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x01f5 A[SYNTHETIC, Splitter:B:39:0x01f5] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b(java.lang.String r17) {
        /*
            r16 = this;
            r0 = r16
            r16.<init>()
            r1 = 0
            r0.f2086b = r1
            java.lang.String r2 = ""
            r0.f2087c = r2
            org.json.JSONObject r3 = new org.json.JSONObject
            r4 = r17
            r3.<init>(r4)
            com.cardinalcommerce.shared.cs.e.i r4 = new com.cardinalcommerce.shared.cs.e.i
            r4.<init>()
            r0.f2085a = r4
            java.lang.String r4 = "threeDSServerTransID"
            java.lang.String r5 = r3.optString(r4)
            r6 = 36
            r7 = 1
            boolean r8 = co.hyperverge.hypersnapsdk.c.k.a(r5, r6, r7)
            r0.G = r8
            com.cardinalcommerce.shared.cs.e.i r9 = r0.f2085a
            r9.a(r8, r4)
            r0.f2088d = r5
            java.lang.String r4 = "acsCounterAtoS"
            java.lang.String r5 = r3.optString(r4)
            r8 = 3
            boolean r8 = co.hyperverge.hypersnapsdk.c.k.d(r5, r8)
            r0.G = r8
            com.cardinalcommerce.shared.cs.e.i r9 = r0.f2085a
            r9.a(r8, r4)
            r0.E = r5
            java.lang.String r4 = "acsTransID"
            java.lang.String r5 = r3.optString(r4)
            boolean r8 = co.hyperverge.hypersnapsdk.c.k.a(r5, r6, r7)
            r0.G = r8
            com.cardinalcommerce.shared.cs.e.i r9 = r0.f2085a
            r9.a(r8, r4)
            r0.f2089e = r5
            java.lang.String r4 = "acsHTML"
            java.lang.String r4 = r3.optString(r4)
            r0.f2090f = r4
            java.lang.String r4 = "acsHTMLRefresh"
            java.lang.String r4 = r3.optString(r4)
            r0.H = r4
            java.lang.String r4 = "acsUiType"
            java.lang.String r4 = r3.optString(r4, r2)
            boolean r5 = r4.equalsIgnoreCase(r2)
            r8 = 2
            if (r5 != 0) goto L_0x0085
            boolean r5 = co.hyperverge.hypersnapsdk.c.k.a(r4, r8)
            if (r5 == 0) goto L_0x0086
            int r9 = java.lang.Integer.parseInt(r4)
            if (r9 < 0) goto L_0x0083
            r10 = 5
            if (r9 <= r10) goto L_0x0086
        L_0x0083:
            r5 = 0
            goto L_0x0086
        L_0x0085:
            r5 = 1
        L_0x0086:
            r0.G = r5
            com.cardinalcommerce.shared.cs.e.i r9 = r0.f2085a
            java.lang.String r10 = "uiType"
            r9.a(r5, r10)
            r0.g = r4
            java.lang.String r4 = "challengeAddInfo"
            java.lang.String r5 = r3.optString(r4)
            r9 = 256(0x100, float:3.59E-43)
            boolean r10 = co.hyperverge.hypersnapsdk.c.k.b(r5, r9)
            r0.G = r10
            com.cardinalcommerce.shared.cs.e.i r11 = r0.f2085a
            r11.a(r10, r4)
            r0.h = r5
            java.lang.String r5 = "challengeCompletionInd"
            java.lang.String r10 = r3.optString(r5)
            java.lang.String r11 = "Y"
            java.lang.String r12 = "N"
            java.lang.String[] r11 = new java.lang.String[]{r11, r12}
            boolean r12 = co.hyperverge.hypersnapsdk.c.k.d(r10, r7)
            if (r12 == 0) goto L_0x00c9
            r12 = 0
            r13 = 0
        L_0x00bc:
            if (r12 >= r8) goto L_0x00ca
            r14 = r11[r12]
            if (r13 != 0) goto L_0x00c6
            boolean r13 = r10.equalsIgnoreCase(r14)
        L_0x00c6:
            int r12 = r12 + 1
            goto L_0x00bc
        L_0x00c9:
            r13 = 0
        L_0x00ca:
            r0.G = r13
            com.cardinalcommerce.shared.cs.e.i r8 = r0.f2085a
            r8.a(r13, r5)
            r0.i = r10
            java.lang.String r5 = "challengeInfoHeader"
            java.lang.String r8 = r3.optString(r5)
            r10 = 45
            boolean r11 = co.hyperverge.hypersnapsdk.c.k.b(r8, r10)
            r0.G = r11
            com.cardinalcommerce.shared.cs.e.i r12 = r0.f2085a
            r12.a(r11, r5)
            r0.j = r8
            java.lang.String r5 = "challengeInfoLabel"
            java.lang.String r8 = r3.optString(r5)
            boolean r11 = co.hyperverge.hypersnapsdk.c.k.b(r8, r10)
            r0.G = r11
            com.cardinalcommerce.shared.cs.e.i r12 = r0.f2085a
            r12.a(r11, r5)
            r0.k = r8
            java.lang.String r5 = "challengeInfoText"
            java.lang.String r8 = r3.optString(r5, r2)
            r11 = 350(0x15e, float:4.9E-43)
            boolean r11 = co.hyperverge.hypersnapsdk.c.k.b(r8, r11)
            r0.G = r11
            com.cardinalcommerce.shared.cs.e.i r12 = r0.f2085a
            r12.a(r11, r5)
            java.lang.String r5 = "line.separator"
            java.lang.String r5 = java.lang.System.getProperty(r5)
            java.lang.Object r5 = java.util.Objects.requireNonNull(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.String r11 = "\\n"
            java.lang.String r5 = r8.replace(r11, r5)
            r0.l = r5
            java.lang.String r5 = "challengeInfoTextIndicator"
            java.lang.String r8 = r3.optString(r5, r2)
            boolean r11 = co.hyperverge.hypersnapsdk.c.k.c(r8, r7)
            r0.G = r11
            com.cardinalcommerce.shared.cs.e.i r12 = r0.f2085a
            r12.a(r11, r5)
            r0.m = r8
            java.lang.String r5 = "challengeSelectInfo"
            java.lang.String r5 = r3.optString(r5)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            int r11 = r5.length()
            if (r11 <= 0) goto L_0x0153
            org.json.JSONArray r11 = new org.json.JSONArray     // Catch:{ JSONException -> 0x014c }
            r11.<init>(r5)     // Catch:{ JSONException -> 0x014c }
            goto L_0x0154
        L_0x014c:
            com.cardinalcommerce.shared.cs.e.i r5 = r0.f2085a
            java.lang.String r11 = "ChallengeSelectInfo"
            r5.a(r1, r11)
        L_0x0153:
            r11 = 0
        L_0x0154:
            if (r11 == 0) goto L_0x01a9
            int r5 = r11.length()
            if (r5 <= 0) goto L_0x01a9
            r5 = 0
        L_0x015d:
            int r12 = r11.length()
            if (r5 >= r12) goto L_0x01a9
            org.json.JSONObject r12 = r11.getJSONObject(r5)
            java.util.Iterator r13 = r12.keys()
        L_0x016b:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x01a2
            java.lang.Object r14 = r13.next()
            java.lang.String r14 = (java.lang.String) r14
            com.cardinalcommerce.shared.cs.e.i r15 = r0.f2085a
            boolean r6 = co.hyperverge.hypersnapsdk.c.k.b(r14, r10)
            java.lang.String r7 = "challengeSelectInfo name"
            r15.a(r6, r7)
            java.lang.Object r6 = r12.get(r14)
            java.lang.String r6 = java.lang.String.valueOf(r6)
            com.cardinalcommerce.shared.cs.e.i r7 = r0.f2085a
            boolean r15 = co.hyperverge.hypersnapsdk.c.k.b(r6, r10)
            java.lang.String r1 = "challengeSelectInfo value"
            r7.a(r15, r1)
            com.cardinalcommerce.shared.cs.e.h r1 = new com.cardinalcommerce.shared.cs.e.h
            r1.<init>(r14, r6)
            r8.add(r1)
            r1 = 0
            r6 = 36
            r7 = 1
            goto L_0x016b
        L_0x01a2:
            int r5 = r5 + 1
            r1 = 0
            r6 = 36
            r7 = 1
            goto L_0x015d
        L_0x01a9:
            r0.n = r8
            java.lang.String r1 = "expandInfoLabel"
            java.lang.String r5 = r3.optString(r1)
            boolean r6 = co.hyperverge.hypersnapsdk.c.k.b(r5, r10)
            r0.G = r6
            com.cardinalcommerce.shared.cs.e.i r7 = r0.f2085a
            r7.a(r6, r1)
            r0.o = r5
            java.lang.String r1 = "expandInfoText"
            java.lang.String r5 = r3.optString(r1)
            boolean r6 = co.hyperverge.hypersnapsdk.c.k.b(r5, r9)
            r0.G = r6
            com.cardinalcommerce.shared.cs.e.i r7 = r0.f2085a
            r7.a(r6, r1)
            r0.p = r5
            com.cardinalcommerce.shared.cs.e.f r1 = new com.cardinalcommerce.shared.cs.e.f
            java.lang.String r5 = "issuerImage"
            java.lang.String r6 = r3.optString(r5)
            r1.<init>(r6)
            boolean r6 = r1.f2103a
            r0.G = r6
            com.cardinalcommerce.shared.cs.e.i r7 = r0.f2085a
            r7.a(r6, r5)
            r0.q = r1
            java.lang.String r1 = "messageExtension"
            java.lang.String r1 = r3.optString(r1)
            boolean r5 = r1.equals(r2)
            r6 = 64
            if (r5 != 0) goto L_0x028a
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0282 }
            r5.<init>(r1)     // Catch:{ JSONException -> 0x0282 }
            int r7 = r5.length()     // Catch:{ JSONException -> 0x0282 }
            r8 = 10
            if (r7 <= r8) goto L_0x020a
            com.cardinalcommerce.shared.cs.e.i r5 = r0.f2085a     // Catch:{ JSONException -> 0x0282 }
            r7 = 0
            r5.a(r7, r1)     // Catch:{ JSONException -> 0x0282 }
            goto L_0x028a
        L_0x020a:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ JSONException -> 0x0282 }
            r1.<init>()     // Catch:{ JSONException -> 0x0282 }
            r7 = 0
        L_0x0210:
            int r1 = r5.length()     // Catch:{ JSONException -> 0x0282 }
            if (r7 >= r1) goto L_0x028a
            org.json.JSONObject r1 = r5.getJSONObject(r7)     // Catch:{ JSONException -> 0x0282 }
            java.lang.String r8 = "name"
            java.lang.String r8 = r1.optString(r8)     // Catch:{ JSONException -> 0x0282 }
            java.lang.String r11 = "id"
            java.lang.String r11 = r1.optString(r11)     // Catch:{ JSONException -> 0x0282 }
            java.lang.String r12 = "criticalityIndicator"
            r13 = 1
            boolean r12 = r1.optBoolean(r12, r13)     // Catch:{ JSONException -> 0x0282 }
            java.lang.String r13 = "data"
            java.lang.String r1 = r1.optString(r13)     // Catch:{ JSONException -> 0x0282 }
            com.cardinalcommerce.shared.cs.e.i r13 = r0.f2085a     // Catch:{ JSONException -> 0x0282 }
            boolean r8 = co.hyperverge.hypersnapsdk.c.k.b(r8, r6)     // Catch:{ JSONException -> 0x0282 }
            java.lang.String r14 = "Message Extension Name"
            r13.a(r8, r14)     // Catch:{ JSONException -> 0x0282 }
            com.cardinalcommerce.shared.cs.e.i r8 = r0.f2085a     // Catch:{ JSONException -> 0x0282 }
            boolean r13 = co.hyperverge.hypersnapsdk.c.k.b(r11, r6)     // Catch:{ JSONException -> 0x0282 }
            java.lang.String r14 = "Message Extension ID"
            r8.a(r13, r14)     // Catch:{ JSONException -> 0x0282 }
            com.cardinalcommerce.shared.cs.e.i r8 = r0.f2085a     // Catch:{ JSONException -> 0x0282 }
            r13 = 8059(0x1f7b, float:1.1293E-41)
            boolean r1 = co.hyperverge.hypersnapsdk.c.k.b(r1, r13)     // Catch:{ JSONException -> 0x0282 }
            java.lang.String r13 = "Message Extension Data"
            r8.a(r1, r13)     // Catch:{ JSONException -> 0x0282 }
            com.cardinalcommerce.shared.cs.e.i r1 = r0.f2085a     // Catch:{ JSONException -> 0x0282 }
            if (r12 != 0) goto L_0x025c
            r8 = 1
            goto L_0x025d
        L_0x025c:
            r8 = 0
        L_0x025d:
            java.lang.String r13 = "Message Extension criticality Indicator"
            r1.a(r8, r13)     // Catch:{ JSONException -> 0x0282 }
            if (r12 == 0) goto L_0x027f
            r1 = 1
            r0.f2086b = r1     // Catch:{ JSONException -> 0x0282 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0282 }
            r1.<init>()     // Catch:{ JSONException -> 0x0282 }
            r1.append(r11)     // Catch:{ JSONException -> 0x0282 }
            java.lang.String r8 = ","
            r1.append(r8)     // Catch:{ JSONException -> 0x0282 }
            java.lang.String r8 = r0.f2087c     // Catch:{ JSONException -> 0x0282 }
            r1.append(r8)     // Catch:{ JSONException -> 0x0282 }
            java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x0282 }
            r0.f2087c = r1     // Catch:{ JSONException -> 0x0282 }
        L_0x027f:
            int r7 = r7 + 1
            goto L_0x0210
        L_0x0282:
            com.cardinalcommerce.shared.cs.e.i r1 = r0.f2085a
            java.lang.String r5 = "Message Extension"
            r7 = 0
            r1.a(r7, r5)
        L_0x028a:
            java.lang.String r1 = "messageType"
            java.lang.String r5 = r3.optString(r1)
            r7 = 4
            boolean r7 = co.hyperverge.hypersnapsdk.c.k.d(r5, r7)
            r0.G = r7
            com.cardinalcommerce.shared.cs.e.i r8 = r0.f2085a
            r8.a(r7, r1)
            r0.s = r5
            java.lang.String r1 = "messageVersion"
            java.lang.String r5 = r3.optString(r1)
            r7 = 8
            boolean r7 = co.hyperverge.hypersnapsdk.c.k.b(r5, r7)
            r0.G = r7
            com.cardinalcommerce.shared.cs.e.i r8 = r0.f2085a
            r8.a(r7, r1)
            r0.t = r5
            java.lang.String r1 = "oobAppURL"
            java.lang.String r5 = r3.optString(r1)
            boolean r7 = co.hyperverge.hypersnapsdk.c.k.b(r5, r9)
            r0.G = r7
            com.cardinalcommerce.shared.cs.e.i r8 = r0.f2085a
            r8.a(r7, r1)
            r0.u = r5
            java.lang.String r1 = "oobAppLabel"
            r3.optString(r1)
            java.lang.String r5 = r0.u
            boolean r5 = co.hyperverge.hypersnapsdk.c.k.b(r5, r9)
            r0.G = r5
            com.cardinalcommerce.shared.cs.e.i r7 = r0.f2085a
            r7.a(r5, r1)
            java.lang.String r1 = "oobContinueLabel"
            java.lang.String r5 = r3.optString(r1)
            boolean r7 = co.hyperverge.hypersnapsdk.c.k.b(r5, r9)
            r0.G = r7
            com.cardinalcommerce.shared.cs.e.i r8 = r0.f2085a
            r8.a(r7, r1)
            r0.w = r5
            com.cardinalcommerce.shared.cs.e.f r1 = new com.cardinalcommerce.shared.cs.e.f
            java.lang.String r5 = "psImage"
            java.lang.String r7 = r3.optString(r5)
            r1.<init>(r7)
            boolean r7 = r1.f2103a
            r0.G = r7
            com.cardinalcommerce.shared.cs.e.i r8 = r0.f2085a
            r8.a(r7, r5)
            r0.x = r1
            java.lang.String r1 = "resendInformationLabel"
            java.lang.String r5 = r3.optString(r1, r2)
            boolean r7 = co.hyperverge.hypersnapsdk.c.k.c(r5, r10)
            r0.G = r7
            com.cardinalcommerce.shared.cs.e.i r8 = r0.f2085a
            r8.a(r7, r1)
            r0.y = r5
            java.lang.String r1 = "sdkTransID"
            java.lang.String r5 = r3.optString(r1)
            r7 = 36
            r8 = 1
            boolean r7 = co.hyperverge.hypersnapsdk.c.k.a(r5, r7, r8)
            r0.G = r7
            com.cardinalcommerce.shared.cs.e.i r8 = r0.f2085a
            r8.a(r7, r1)
            r0.z = r5
            java.lang.String r1 = "submitAuthenticationLabel"
            java.lang.String r5 = r3.optString(r1, r2)
            boolean r7 = co.hyperverge.hypersnapsdk.c.k.b(r5, r10)
            r0.G = r7
            com.cardinalcommerce.shared.cs.e.i r8 = r0.f2085a
            r8.a(r7, r1)
            r0.A = r5
            java.lang.String r1 = "transStatus"
            java.lang.String r5 = r3.optString(r1)
            r7 = 1
            boolean r7 = co.hyperverge.hypersnapsdk.c.k.b(r5, r7)
            r0.G = r7
            com.cardinalcommerce.shared.cs.e.i r8 = r0.f2085a
            r8.a(r7, r1)
            r0.B = r5
            java.lang.String r1 = "whyInfoLabel"
            java.lang.String r5 = r3.optString(r1)
            boolean r7 = co.hyperverge.hypersnapsdk.c.k.b(r5, r10)
            r0.G = r7
            com.cardinalcommerce.shared.cs.e.i r8 = r0.f2085a
            r8.a(r7, r1)
            r0.C = r5
            java.lang.String r1 = "whyInfoText"
            java.lang.String r5 = r3.optString(r1)
            boolean r7 = co.hyperverge.hypersnapsdk.c.k.b(r5, r9)
            r0.G = r7
            com.cardinalcommerce.shared.cs.e.i r8 = r0.f2085a
            r8.a(r7, r1)
            r0.D = r5
            java.lang.String r1 = r0.t
            if (r1 == 0) goto L_0x03ad
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x03ad
            java.lang.String r1 = r0.t
            java.lang.String r5 = "2.1.0"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x03ad
            java.lang.String r1 = "whitelistingInfoText"
            java.lang.String r3 = r3.optString(r1)
            boolean r5 = co.hyperverge.hypersnapsdk.c.k.b(r3, r6)
            r0.G = r5
            com.cardinalcommerce.shared.cs.e.i r6 = r0.f2085a
            r6.a(r5, r1)
            r0.F = r3
            r0.H = r2
            boolean r1 = co.hyperverge.hypersnapsdk.c.k.b(r2, r9)
            r0.G = r1
            com.cardinalcommerce.shared.cs.e.i r3 = r0.f2085a
            r3.a(r1, r4)
            r0.h = r2
        L_0x03ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.shared.cs.e.b.<init>(java.lang.String):void");
    }
}
