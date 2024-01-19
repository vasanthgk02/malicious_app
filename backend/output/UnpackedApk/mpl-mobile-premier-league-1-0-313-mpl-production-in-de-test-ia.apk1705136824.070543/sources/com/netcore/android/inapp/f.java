package com.netcore.android.inapp;

import com.netcore.android.SMTEventParamKeys;
import com.netcore.android.inapp.h.b.C0012b;
import com.netcore.android.inapp.h.b.c;
import com.netcore.android.inapp.h.b.d;
import com.netcore.android.utility.b;
import com.rudderstack.android.sdk.core.ecomm.ECommerceParamNames;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SMTInAppRuleParser.kt */
public final class f {
    private final c b(JSONObject jSONObject) {
        c cVar = new c();
        try {
            String optString = jSONObject.optString(SMTEventParamKeys.SMT_EVENT_ID);
            Intrinsics.checkNotNullExpressionValue(optString, "rulesObject.optString(\"eventId\")");
            cVar.a(optString);
        } catch (Exception unused) {
        }
        try {
            String optString2 = jSONObject.optString("eventName");
            Intrinsics.checkNotNullExpressionValue(optString2, "rulesObject.optString(\"eventName\")");
            cVar.b(optString2);
        } catch (Exception unused2) {
        }
        try {
            cVar.a(jSONObject.optLong("waitUntil"));
        } catch (Exception unused3) {
        }
        try {
            String optString3 = jSONObject.optString("performed");
            Intrinsics.checkNotNullExpressionValue(optString3, "rulesObject.optString(\"performed\")");
            cVar.e(optString3);
        } catch (Exception unused4) {
        }
        try {
            String optString4 = jSONObject.optString("filterType");
            Intrinsics.checkNotNullExpressionValue(optString4, "rulesObject.optString(\"filterType\")");
            cVar.d(optString4);
        } catch (Exception unused5) {
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray(ECommerceParamNames.FILTERS);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                cVar.a(new ArrayList<>());
                int i = 0;
                int length = optJSONArray.length();
                while (i < length) {
                    Object opt = optJSONArray.opt(i);
                    if (opt != null) {
                        cVar.d().add(a((JSONObject) opt));
                        i++;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                }
            }
        } catch (Exception unused6) {
        }
        return cVar;
    }

    private final d c(JSONObject jSONObject) {
        d dVar = new d();
        try {
            String optString = jSONObject.optString("from");
            Intrinsics.checkNotNullExpressionValue(optString, "timeObject.optString(\"from\")");
            dVar.a(b.a(optString));
        } catch (Exception unused) {
        }
        try {
            String optString2 = jSONObject.optString("to");
            Intrinsics.checkNotNullExpressionValue(optString2, "timeObject.optString(\"to\")");
            dVar.b(b.a(optString2));
        } catch (Exception unused2) {
        }
        return dVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:53|54|55|(2:56|57)|58|60|61|(11:63|64|65|66|67|68|69|70|72|73|(2:77|(2:79|(1:81)(3:146|82|83))))|84|85) */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:63|64|65|66|67|68|69|70|72|73|(2:77|(2:79|(1:81)(3:146|82|83)))) */
    /* JADX WARNING: Can't wrap try/catch for region: R(17:88|89|90|(3:91|92|(3:96|(2:98|99)|147))|100|(3:102|103|(3:107|(2:109|110)|148))|111|(2:113|114)|115|(2:117|118)|119|121|122|(7:124|125|126|127|129|130|(2:134|(2:136|(1:138)(3:149|139|140))))|141|142|150) */
    /* JADX WARNING: Can't wrap try/catch for region: R(41:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|19|20|21|23|24|25|(3:26|27|(3:31|(2:33|34)|144))|35|37|38|(2:42|(2:44|(1:46)(3:145|47|48)))|49|50|51|53|54|55|56|57|58|60|61|(11:63|64|65|66|67|68|69|70|72|73|(2:77|(2:79|(1:81)(3:146|82|83))))|84|85|86|(23:88|89|90|91|92|(3:96|(2:98|99)|147)|100|102|103|(3:107|(2:109|110)|148)|111|113|114|115|117|118|119|121|122|(7:124|125|126|127|129|130|(2:134|(2:136|(1:138)(3:149|139|140))))|141|142|150)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(43:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|19|20|21|23|24|25|26|27|(3:31|(2:33|34)|144)|35|37|38|(2:42|(2:44|(1:46)(3:145|47|48)))|49|50|51|53|54|55|56|57|58|60|61|(11:63|64|65|66|67|68|69|70|72|73|(2:77|(2:79|(1:81)(3:146|82|83))))|84|85|86|(23:88|89|90|91|92|(3:96|(2:98|99)|147)|100|102|103|(3:107|(2:109|110)|148)|111|113|114|115|117|118|119|121|122|(7:124|125|126|127|129|130|(2:134|(2:136|(1:138)(3:149|139|140))))|141|142|150)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:141:0x027f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0043 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0108 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:66:0x013f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x014a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:84:0x019d */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01f3 A[Catch:{ Exception -> 0x0201 }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0225 A[Catch:{ Exception -> 0x027f }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c1 A[Catch:{ Exception -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ec A[Catch:{ Exception -> 0x0108 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x012c A[Catch:{ Exception -> 0x019d }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x017d A[Catch:{ Exception -> 0x019d }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01c8 A[Catch:{ Exception -> 0x01d6 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r10, com.netcore.android.inapp.h.b r11) {
        /*
            r9 = this;
            java.lang.String r0 = "null cannot be cast to non-null type org.json.JSONObject"
            java.lang.String r1 = "payload"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)
            java.lang.String r1 = "inAppRule"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r1)
            r11.h(r10)
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>(r10)
            java.lang.String r10 = "contentType"
            int r10 = r1.optInt(r10)     // Catch:{ Exception -> 0x001d }
            r11.b(r10)     // Catch:{ Exception -> 0x001d }
        L_0x001d:
            java.lang.String r10 = "controlGroup"
            r2 = -1
            int r10 = r1.optInt(r10, r2)     // Catch:{ Exception -> 0x0027 }
            r11.c(r10)     // Catch:{ Exception -> 0x0027 }
        L_0x0027:
            java.lang.String r10 = "frequency"
            java.lang.String r10 = r1.optString(r10)     // Catch:{ Exception -> 0x0035 }
            java.lang.String r2 = "rule.optString(\"frequency\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r2)     // Catch:{ Exception -> 0x0035 }
            r11.c(r10)     // Catch:{ Exception -> 0x0035 }
        L_0x0035:
            java.lang.String r10 = "frequencyType"
            java.lang.String r10 = r1.optString(r10)     // Catch:{ Exception -> 0x0043 }
            java.lang.String r2 = "rule.optString(\"frequencyType\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r2)     // Catch:{ Exception -> 0x0043 }
            r11.d(r10)     // Catch:{ Exception -> 0x0043 }
        L_0x0043:
            com.netcore.android.inapp.g$a r10 = com.netcore.android.inapp.g.f1213b     // Catch:{ Exception -> 0x0057 }
            java.lang.String r2 = "modifiedDate"
            java.lang.String r2 = r1.optString(r2)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r3 = "rule.optString(\"modifiedDate\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r10 = r10.b(r2)     // Catch:{ Exception -> 0x0057 }
            r11.g(r10)     // Catch:{ Exception -> 0x0057 }
        L_0x0057:
            java.lang.String r10 = "whatTo"
            org.json.JSONObject r10 = r1.optJSONObject(r10)     // Catch:{ Exception -> 0x0098 }
            com.netcore.android.inapp.h.b$e r2 = new com.netcore.android.inapp.h.b$e     // Catch:{ Exception -> 0x0098 }
            r2.<init>()     // Catch:{ Exception -> 0x0098 }
            java.lang.String r3 = "url"
            java.lang.String r3 = r10.optString(r3)     // Catch:{ Exception -> 0x0098 }
            java.lang.String r4 = "whatToObject.optString(\"url\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ Exception -> 0x0098 }
            r2.c(r3)     // Catch:{ Exception -> 0x0098 }
            java.lang.String r3 = "nativeImageUrl"
            java.lang.String r3 = r10.optString(r3)     // Catch:{ Exception -> 0x0098 }
            java.lang.String r4 = "whatToObject.optString(\"nativeImageUrl\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ Exception -> 0x0098 }
            r2.b(r3)     // Catch:{ Exception -> 0x0098 }
            java.lang.String r3 = "deeplink"
            java.lang.String r3 = r10.optString(r3)     // Catch:{ Exception -> 0x0098 }
            java.lang.String r4 = "whatToObject.optString(\"deeplink\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ Exception -> 0x0098 }
            r2.a(r3)     // Catch:{ Exception -> 0x0098 }
            java.lang.String r3 = "isNative"
            boolean r10 = r10.optBoolean(r3)     // Catch:{ Exception -> 0x0098 }
            r2.a(r10)     // Catch:{ Exception -> 0x0098 }
            r11.a(r2)     // Catch:{ Exception -> 0x0098 }
        L_0x0098:
            r10 = 0
            java.lang.String r2 = "whenTo"
            org.json.JSONObject r2 = r1.optJSONObject(r2)     // Catch:{ Exception -> 0x010b }
            com.netcore.android.inapp.h.b$f r3 = new com.netcore.android.inapp.h.b$f     // Catch:{ Exception -> 0x010b }
            r3.<init>()     // Catch:{ Exception -> 0x010b }
            java.lang.String r4 = "days"
            org.json.JSONArray r4 = r2.optJSONArray(r4)     // Catch:{ Exception -> 0x00cf }
            if (r4 == 0) goto L_0x00cf
            int r5 = r4.length()     // Catch:{ Exception -> 0x00cf }
            if (r5 <= 0) goto L_0x00cf
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x00cf }
            r5.<init>()     // Catch:{ Exception -> 0x00cf }
            r3.a(r5)     // Catch:{ Exception -> 0x00cf }
            int r5 = r4.length()     // Catch:{ Exception -> 0x00cf }
            r6 = 0
        L_0x00bf:
            if (r6 >= r5) goto L_0x00cf
            java.lang.String r7 = r4.optString(r6)     // Catch:{ Exception -> 0x00cf }
            java.util.ArrayList r8 = r3.a()     // Catch:{ Exception -> 0x00cf }
            r8.add(r7)     // Catch:{ Exception -> 0x00cf }
            int r6 = r6 + 1
            goto L_0x00bf
        L_0x00cf:
            java.lang.String r4 = "time"
            org.json.JSONArray r2 = r2.optJSONArray(r4)     // Catch:{ Exception -> 0x0108 }
            if (r2 == 0) goto L_0x0108
            int r4 = r2.length()     // Catch:{ Exception -> 0x0108 }
            if (r4 <= 0) goto L_0x0108
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x0108 }
            r4.<init>()     // Catch:{ Exception -> 0x0108 }
            r3.b(r4)     // Catch:{ Exception -> 0x0108 }
            int r4 = r2.length()     // Catch:{ Exception -> 0x0108 }
            r5 = 0
        L_0x00ea:
            if (r5 >= r4) goto L_0x0108
            java.lang.Object r6 = r2.opt(r5)     // Catch:{ Exception -> 0x0108 }
            if (r6 == 0) goto L_0x0102
            org.json.JSONObject r6 = (org.json.JSONObject) r6     // Catch:{ Exception -> 0x0108 }
            java.util.ArrayList r7 = r3.b()     // Catch:{ Exception -> 0x0108 }
            com.netcore.android.inapp.h.b$d r6 = r9.c(r6)     // Catch:{ Exception -> 0x0108 }
            r7.add(r6)     // Catch:{ Exception -> 0x0108 }
            int r5 = r5 + 1
            goto L_0x00ea
        L_0x0102:
            java.lang.NullPointerException r2 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x0108 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0108 }
            throw r2     // Catch:{ Exception -> 0x0108 }
        L_0x0108:
            r11.a(r3)     // Catch:{ Exception -> 0x010b }
        L_0x010b:
            java.lang.String r2 = "whereTo"
            org.json.JSONObject r2 = r1.optJSONObject(r2)     // Catch:{ Exception -> 0x01a0 }
            com.netcore.android.inapp.h.b$g r3 = new com.netcore.android.inapp.h.b$g     // Catch:{ Exception -> 0x01a0 }
            r3.<init>()     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r4 = "position"
            java.lang.String r4 = r2.optString(r4)     // Catch:{ Exception -> 0x0124 }
            java.lang.String r5 = "whereToObject.optString(\"position\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ Exception -> 0x0124 }
            r3.a(r4)     // Catch:{ Exception -> 0x0124 }
        L_0x0124:
            java.lang.String r4 = "trigger"
            org.json.JSONObject r2 = r2.optJSONObject(r4)     // Catch:{ Exception -> 0x019d }
            if (r2 == 0) goto L_0x019d
            com.netcore.android.inapp.h.b$c r4 = new com.netcore.android.inapp.h.b$c     // Catch:{ Exception -> 0x019d }
            r4.<init>()     // Catch:{ Exception -> 0x019d }
            r3.a(r4)     // Catch:{ Exception -> 0x019d }
            com.netcore.android.inapp.h.b$c r4 = r3.b()     // Catch:{ Exception -> 0x013f }
            java.lang.String r5 = r11.d()     // Catch:{ Exception -> 0x013f }
            r4.b(r5)     // Catch:{ Exception -> 0x013f }
        L_0x013f:
            com.netcore.android.inapp.h.b$c r4 = r3.b()     // Catch:{ Exception -> 0x014a }
            java.lang.String r5 = r11.c()     // Catch:{ Exception -> 0x014a }
            r4.a(r5)     // Catch:{ Exception -> 0x014a }
        L_0x014a:
            com.netcore.android.inapp.h.b$c r4 = r3.b()     // Catch:{ Exception -> 0x015c }
            java.lang.String r5 = "filterType"
            java.lang.String r5 = r2.optString(r5)     // Catch:{ Exception -> 0x015c }
            java.lang.String r6 = "triggerObject.optString(\"filterType\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ Exception -> 0x015c }
            r4.d(r5)     // Catch:{ Exception -> 0x015c }
        L_0x015c:
            java.lang.String r4 = "filters"
            org.json.JSONArray r2 = r2.optJSONArray(r4)     // Catch:{ Exception -> 0x019d }
            if (r2 == 0) goto L_0x019d
            int r4 = r2.length()     // Catch:{ Exception -> 0x019d }
            if (r4 <= 0) goto L_0x019d
            com.netcore.android.inapp.h.b$c r4 = r3.b()     // Catch:{ Exception -> 0x019d }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x019d }
            r5.<init>()     // Catch:{ Exception -> 0x019d }
            r4.a(r5)     // Catch:{ Exception -> 0x019d }
            int r4 = r2.length()     // Catch:{ Exception -> 0x019d }
            r5 = 0
        L_0x017b:
            if (r5 >= r4) goto L_0x019d
            java.lang.Object r6 = r2.opt(r5)     // Catch:{ Exception -> 0x019d }
            if (r6 == 0) goto L_0x0197
            org.json.JSONObject r6 = (org.json.JSONObject) r6     // Catch:{ Exception -> 0x019d }
            com.netcore.android.inapp.h.b$c r7 = r3.b()     // Catch:{ Exception -> 0x019d }
            java.util.ArrayList r7 = r7.d()     // Catch:{ Exception -> 0x019d }
            com.netcore.android.inapp.h.b$b r6 = r9.a(r6)     // Catch:{ Exception -> 0x019d }
            r7.add(r6)     // Catch:{ Exception -> 0x019d }
            int r5 = r5 + 1
            goto L_0x017b
        L_0x0197:
            java.lang.NullPointerException r2 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x019d }
            r2.<init>(r0)     // Catch:{ Exception -> 0x019d }
            throw r2     // Catch:{ Exception -> 0x019d }
        L_0x019d:
            r11.a(r3)     // Catch:{ Exception -> 0x01a0 }
        L_0x01a0:
            java.lang.String r2 = "whomTo"
            org.json.JSONObject r1 = r1.optJSONObject(r2)     // Catch:{ Exception -> 0x0282 }
            com.netcore.android.inapp.h.b$h r2 = new com.netcore.android.inapp.h.b$h     // Catch:{ Exception -> 0x0282 }
            r2.<init>()     // Catch:{ Exception -> 0x0282 }
            java.lang.String r3 = "segIds"
            org.json.JSONArray r3 = r1.optJSONArray(r3)     // Catch:{ Exception -> 0x01d6 }
            if (r3 == 0) goto L_0x01d6
            int r4 = r3.length()     // Catch:{ Exception -> 0x01d6 }
            if (r4 <= 0) goto L_0x01d6
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x01d6 }
            r4.<init>()     // Catch:{ Exception -> 0x01d6 }
            r2.b(r4)     // Catch:{ Exception -> 0x01d6 }
            int r4 = r3.length()     // Catch:{ Exception -> 0x01d6 }
            r5 = 0
        L_0x01c6:
            if (r5 >= r4) goto L_0x01d6
            java.lang.String r6 = r3.optString(r5)     // Catch:{ Exception -> 0x01d6 }
            java.util.ArrayList r7 = r2.c()     // Catch:{ Exception -> 0x01d6 }
            r7.add(r6)     // Catch:{ Exception -> 0x01d6 }
            int r5 = r5 + 1
            goto L_0x01c6
        L_0x01d6:
            java.lang.String r3 = "listIds"
            org.json.JSONArray r3 = r1.optJSONArray(r3)     // Catch:{ Exception -> 0x0201 }
            if (r3 == 0) goto L_0x0201
            int r4 = r3.length()     // Catch:{ Exception -> 0x0201 }
            if (r4 <= 0) goto L_0x0201
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x0201 }
            r4.<init>()     // Catch:{ Exception -> 0x0201 }
            r2.a(r4)     // Catch:{ Exception -> 0x0201 }
            int r4 = r3.length()     // Catch:{ Exception -> 0x0201 }
            r5 = 0
        L_0x01f1:
            if (r5 >= r4) goto L_0x0201
            java.lang.String r6 = r3.optString(r5)     // Catch:{ Exception -> 0x0201 }
            java.util.ArrayList r7 = r2.b()     // Catch:{ Exception -> 0x0201 }
            r7.add(r6)     // Catch:{ Exception -> 0x0201 }
            int r5 = r5 + 1
            goto L_0x01f1
        L_0x0201:
            java.lang.String r3 = "visitor"
            java.lang.String r3 = r1.optString(r3)     // Catch:{ Exception -> 0x020f }
            java.lang.String r4 = "whomToObject.optString(\"visitor\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ Exception -> 0x020f }
            r2.a(r3)     // Catch:{ Exception -> 0x020f }
        L_0x020f:
            java.lang.String r3 = "visitorType"
            java.lang.String r3 = r1.optString(r3)     // Catch:{ Exception -> 0x021d }
            java.lang.String r4 = "whomToObject.optString(\"visitorType\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ Exception -> 0x021d }
            r2.b(r3)     // Catch:{ Exception -> 0x021d }
        L_0x021d:
            java.lang.String r3 = "events"
            org.json.JSONObject r1 = r1.optJSONObject(r3)     // Catch:{ Exception -> 0x027f }
            if (r1 == 0) goto L_0x027f
            com.netcore.android.inapp.h.b$a r3 = new com.netcore.android.inapp.h.b$a     // Catch:{ Exception -> 0x027f }
            r3.<init>()     // Catch:{ Exception -> 0x027f }
            r2.a(r3)     // Catch:{ Exception -> 0x027f }
            com.netcore.android.inapp.h.b$a r3 = r2.a()     // Catch:{ Exception -> 0x023f }
            java.lang.String r4 = "targetRule"
            java.lang.String r4 = r1.optString(r4)     // Catch:{ Exception -> 0x023f }
            java.lang.String r5 = "eventsObject.optString(\"targetRule\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ Exception -> 0x023f }
            r3.a(r4)     // Catch:{ Exception -> 0x023f }
        L_0x023f:
            java.lang.String r3 = "rules"
            org.json.JSONArray r1 = r1.optJSONArray(r3)     // Catch:{ Exception -> 0x027f }
            if (r1 == 0) goto L_0x027f
            int r3 = r1.length()     // Catch:{ Exception -> 0x027f }
            if (r3 <= 0) goto L_0x027f
            com.netcore.android.inapp.h.b$a r3 = r2.a()     // Catch:{ Exception -> 0x027f }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x027f }
            r4.<init>()     // Catch:{ Exception -> 0x027f }
            r3.a(r4)     // Catch:{ Exception -> 0x027f }
            int r3 = r1.length()     // Catch:{ Exception -> 0x027f }
        L_0x025d:
            if (r10 >= r3) goto L_0x027f
            java.lang.Object r4 = r1.opt(r10)     // Catch:{ Exception -> 0x027f }
            if (r4 == 0) goto L_0x0279
            org.json.JSONObject r4 = (org.json.JSONObject) r4     // Catch:{ Exception -> 0x027f }
            com.netcore.android.inapp.h.b$a r5 = r2.a()     // Catch:{ Exception -> 0x027f }
            java.util.ArrayList r5 = r5.a()     // Catch:{ Exception -> 0x027f }
            com.netcore.android.inapp.h.b$c r4 = r9.b(r4)     // Catch:{ Exception -> 0x027f }
            r5.add(r4)     // Catch:{ Exception -> 0x027f }
            int r10 = r10 + 1
            goto L_0x025d
        L_0x0279:
            java.lang.NullPointerException r10 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x027f }
            r10.<init>(r0)     // Catch:{ Exception -> 0x027f }
            throw r10     // Catch:{ Exception -> 0x027f }
        L_0x027f:
            r11.a(r2)     // Catch:{ Exception -> 0x0282 }
        L_0x0282:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.inapp.f.a(java.lang.String, com.netcore.android.inapp.h.b):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:382|383|384|385|386|387|388|389|390|(3:394|(2:396|(1:398)(3:421|399|400))|420)|401|427) */
    /* JADX WARNING: Can't wrap try/catch for region: R(13:249|250|251|252|253|254|255|256|257|258|260|261|(47:276|277|281|283|284|285|286|287|288|289|290|291|292|293|294|295|296|297|298|299|300|301|302|303|304|305|306|307|308|309|310|311|312|313|314|315|316|317|318|319|320|321|322|323|324|325|326)(51:265|266|267|268|(3:270|271|(1:273)(3:418|274|275))|419|281|283|284|285|286|287|288|289|290|291|292|293|294|295|296|297|298|299|300|301|302|303|304|305|306|307|308|309|310|311|312|313|314|315|316|317|318|319|320|321|322|323|324|325|326)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(32:195|196|197|198|199|200|201|202|203|204|205|208|210|211|(20:215|216|217|218|(3:220|221|(1:223)(3:412|224|225))|416|230|232|233|238|239|(12:241|242|243|244|245|246|247|(13:249|250|251|252|253|254|255|256|257|258|260|261|(47:276|277|281|283|284|285|286|287|288|289|290|291|292|293|294|295|296|297|298|299|300|301|302|303|304|305|306|307|308|309|310|311|312|313|314|315|316|317|318|319|320|321|322|323|324|325|326)(51:265|266|267|268|(3:270|271|(1:273)(3:418|274|275))|419|281|283|284|285|286|287|288|289|290|291|292|293|294|295|296|297|298|299|300|301|302|303|304|305|306|307|308|309|310|311|312|313|314|315|316|317|318|319|320|321|322|323|324|325|326))(1:359)|360|361|362|363)|417|366|368|370|371|373|374|(2:380|(12:382|383|384|385|386|387|388|389|390|(3:394|(2:396|(1:398)(3:421|399|400))|420)|401|427)(1:426))(1:425))|228|230|232|233|238|239|(0)|417|366|368|370|371|373|374|(2:376|378)|380|(0)(0)) */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x02f5, code lost:
        r35 = r2;
        r2 = r24;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:199:0x02dc */
    /* JADX WARNING: Missing exception handler attribute for start block: B:201:0x02e6 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:238:0x037b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:254:0x03ca */
    /* JADX WARNING: Missing exception handler attribute for start block: B:256:0x03de */
    /* JADX WARNING: Missing exception handler attribute for start block: B:385:0x0593 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:387:0x05ae */
    /* JADX WARNING: Missing exception handler attribute for start block: B:389:0x05c2 */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0184 A[Catch:{ Exception -> 0x01a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01ce A[Catch:{ Exception -> 0x01e6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0246 A[Catch:{ Exception -> 0x02aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x02b6 A[SYNTHETIC, Splitter:B:190:0x02b6] */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x031a A[SYNTHETIC, Splitter:B:220:0x031a] */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x0386 A[Catch:{ Exception -> 0x0537 }] */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x03f0 A[Catch:{ Exception -> 0x0434 }] */
    /* JADX WARNING: Removed duplicated region for block: B:376:0x0551 A[Catch:{ Exception -> 0x0661 }] */
    /* JADX WARNING: Removed duplicated region for block: B:382:0x056c A[Catch:{ Exception -> 0x0661 }] */
    /* JADX WARNING: Removed duplicated region for block: B:396:0x05e5 A[Catch:{ Exception -> 0x0661 }] */
    /* JADX WARNING: Removed duplicated region for block: B:426:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x014f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<com.netcore.android.inapp.h.b> d(org.json.JSONObject r41) {
        /*
            r40 = this;
            r0 = r40
            r1 = r41
            java.lang.String r2 = "whereToObject.optString(…TInAppConst.KEY_POSITION)"
            java.lang.String r3 = "position"
            java.lang.String r4 = "multiTriggerObject.optSt…AppConst.KEY_FILTER_TYPE)"
            java.lang.String r5 = "trigger"
            java.lang.String r6 = "whereTo"
            java.lang.String r7 = "filters"
            java.lang.String r8 = "filterType"
            java.lang.String r9 = "multiTriggerObject.optSt…TInAppConst.KEY_EVENT_ID)"
            java.lang.String r10 = "multiTriggerObject.optSt…nAppConst.KEY_EVENT_NAME)"
            java.lang.String r11 = "eventId"
            java.lang.String r12 = "eventName"
            java.lang.String r13 = "null cannot be cast to non-null type org.json.JSONObject"
            java.lang.String r14 = "multiTrigger"
            java.lang.String r15 = ""
            r16 = r15
            java.lang.String r15 = "rule"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r15)
            com.netcore.android.inapp.h.b$e r15 = new com.netcore.android.inapp.h.b$e
            r15.<init>()
            r17 = r2
            com.netcore.android.inapp.h.b$f r2 = new com.netcore.android.inapp.h.b$f
            r2.<init>()
            r18 = r3
            com.netcore.android.inapp.h.b$h r3 = new com.netcore.android.inapp.h.b$h
            r3.<init>()
            r19 = r5
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r20 = r5
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r21 = r5
            java.lang.String r5 = "id"
            java.lang.String r5 = r1.optString(r5)     // Catch:{ Exception -> 0x065f }
            r22 = r7
            java.lang.String r7 = "rule.optString(SMTInAppConst.KEY_ID)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)     // Catch:{ Exception -> 0x065f }
            com.netcore.android.inapp.g$a r7 = com.netcore.android.inapp.g.f1213b     // Catch:{ Exception -> 0x0070 }
            r23 = r5
            java.lang.String r5 = "toDate"
            java.lang.String r5 = r1.optString(r5)     // Catch:{ Exception -> 0x006d }
            r24 = r4
            java.lang.String r4 = "rule.optString(SMTInAppConst.KEY_TO_DATE)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)     // Catch:{ Exception -> 0x0074 }
            java.lang.String r4 = r7.b(r5)     // Catch:{ Exception -> 0x0074 }
            goto L_0x0076
        L_0x006d:
            r24 = r4
            goto L_0x0074
        L_0x0070:
            r24 = r4
            r23 = r5
        L_0x0074:
            r4 = r16
        L_0x0076:
            com.netcore.android.inapp.g$a r5 = com.netcore.android.inapp.g.f1213b     // Catch:{ Exception -> 0x008a }
            java.lang.String r7 = "fromDate"
            java.lang.String r7 = r1.optString(r7)     // Catch:{ Exception -> 0x008a }
            r25 = r4
            java.lang.String r4 = "rule.optString(SMTInAppConst.KEY_FROM_DATE)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)     // Catch:{ Exception -> 0x008c }
            java.lang.String r4 = r5.b(r7)     // Catch:{ Exception -> 0x008c }
            goto L_0x008e
        L_0x008a:
            r25 = r4
        L_0x008c:
            r4 = r16
        L_0x008e:
            java.lang.String r7 = "contentType"
            int r7 = r1.optInt(r7)     // Catch:{ Exception -> 0x0095 }
            goto L_0x0096
        L_0x0095:
            r7 = 0
        L_0x0096:
            r5 = -1
            r26 = r7
            java.lang.String r7 = "controlGroup"
            int r5 = r1.optInt(r7, r5)     // Catch:{ Exception -> 0x009f }
        L_0x009f:
            java.lang.String r7 = "frequency"
            java.lang.String r7 = r1.optString(r7)     // Catch:{ Exception -> 0x00ad }
            r27 = r5
            java.lang.String r5 = "rule.optString(SMTInAppConst.KEY_FREQUENCY)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r5)     // Catch:{ Exception -> 0x00af }
            goto L_0x00b1
        L_0x00ad:
            r27 = r5
        L_0x00af:
            r7 = r16
        L_0x00b1:
            java.lang.String r5 = "frequencyType"
            java.lang.String r5 = r1.optString(r5)     // Catch:{ Exception -> 0x00bf }
            r28 = r7
            java.lang.String r7 = "rule.optString(SMTInAppConst.KEY_FREQUENCY_TYPE)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)     // Catch:{ Exception -> 0x00c1 }
            goto L_0x00c3
        L_0x00bf:
            r28 = r7
        L_0x00c1:
            r5 = r16
        L_0x00c3:
            com.netcore.android.inapp.g$a r7 = com.netcore.android.inapp.g.f1213b     // Catch:{ Exception -> 0x00dc }
            r29 = r5
            java.lang.String r5 = "modifiedDate"
            java.lang.String r5 = r1.optString(r5)     // Catch:{ Exception -> 0x00d9 }
            r30 = r4
            java.lang.String r4 = "rule.optString(SMTInAppConst.KEY_MODIFIED_DATE)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r4 = r7.b(r5)     // Catch:{ Exception -> 0x00e0 }
            goto L_0x00e2
        L_0x00d9:
            r30 = r4
            goto L_0x00e0
        L_0x00dc:
            r30 = r4
            r29 = r5
        L_0x00e0:
            r4 = r16
        L_0x00e2:
            java.lang.String r5 = "whatTo"
            org.json.JSONObject r5 = r1.optJSONObject(r5)     // Catch:{ Exception -> 0x0123 }
            java.lang.String r7 = "rule.optJSONObject(SMTInAppConst.KEY_WHAT_TO)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)     // Catch:{ Exception -> 0x0123 }
            java.lang.String r7 = "url"
            java.lang.String r7 = r5.optString(r7)     // Catch:{ Exception -> 0x0123 }
            r16 = r4
            java.lang.String r4 = "whatToObject.optString(SMTInAppConst.KEY_URL)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)     // Catch:{ Exception -> 0x0125 }
            r15.c(r7)     // Catch:{ Exception -> 0x0125 }
            java.lang.String r4 = "nativeImageUrl"
            java.lang.String r4 = r5.optString(r4)     // Catch:{ Exception -> 0x0125 }
            java.lang.String r7 = "whatToObject.optString(S…nst.KEY_NATIVE_IMAGE_URL)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)     // Catch:{ Exception -> 0x0125 }
            r15.b(r4)     // Catch:{ Exception -> 0x0125 }
            java.lang.String r4 = "deeplink"
            java.lang.String r4 = r5.optString(r4)     // Catch:{ Exception -> 0x0125 }
            java.lang.String r7 = "whatToObject.optString(SMTInAppConst.KEY_DEEPLINK)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)     // Catch:{ Exception -> 0x0125 }
            r15.a(r4)     // Catch:{ Exception -> 0x0125 }
            java.lang.String r4 = "isNative"
            boolean r4 = r5.optBoolean(r4)     // Catch:{ Exception -> 0x0125 }
            r15.a(r4)     // Catch:{ Exception -> 0x0125 }
            goto L_0x0125
        L_0x0123:
            r16 = r4
        L_0x0125:
            java.lang.String r4 = "whenTo"
            org.json.JSONObject r4 = r1.optJSONObject(r4)     // Catch:{ Exception -> 0x01a4 }
            java.lang.String r5 = "rule.optJSONObject(SMTInAppConst.KEY_WHEN_TO)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ Exception -> 0x01a4 }
            java.lang.String r5 = "days"
            org.json.JSONArray r5 = r4.optJSONArray(r5)     // Catch:{ Exception -> 0x0165 }
            if (r5 == 0) goto L_0x0165
            int r7 = r5.length()     // Catch:{ Exception -> 0x0165 }
            if (r7 <= 0) goto L_0x0165
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x0165 }
            r7.<init>()     // Catch:{ Exception -> 0x0165 }
            r2.a(r7)     // Catch:{ Exception -> 0x0165 }
            int r7 = r5.length()     // Catch:{ Exception -> 0x0165 }
            r31 = r15
            r15 = 0
        L_0x014d:
            if (r15 >= r7) goto L_0x0167
            r32 = r7
            java.lang.String r7 = r5.optString(r15)     // Catch:{ Exception -> 0x0167 }
            r33 = r5
            java.util.ArrayList r5 = r2.a()     // Catch:{ Exception -> 0x0167 }
            r5.add(r7)     // Catch:{ Exception -> 0x0167 }
            int r15 = r15 + 1
            r7 = r32
            r5 = r33
            goto L_0x014d
        L_0x0165:
            r31 = r15
        L_0x0167:
            java.lang.String r5 = "time"
            org.json.JSONArray r4 = r4.optJSONArray(r5)     // Catch:{ Exception -> 0x01a6 }
            if (r4 == 0) goto L_0x01a6
            int r5 = r4.length()     // Catch:{ Exception -> 0x01a6 }
            if (r5 <= 0) goto L_0x01a6
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x01a6 }
            r5.<init>()     // Catch:{ Exception -> 0x01a6 }
            r2.b(r5)     // Catch:{ Exception -> 0x01a6 }
            int r5 = r4.length()     // Catch:{ Exception -> 0x01a6 }
            r7 = 0
        L_0x0182:
            if (r7 >= r5) goto L_0x01a6
            java.lang.Object r15 = r4.opt(r7)     // Catch:{ Exception -> 0x01a6 }
            if (r15 == 0) goto L_0x019e
            org.json.JSONObject r15 = (org.json.JSONObject) r15     // Catch:{ Exception -> 0x01a6 }
            r32 = r4
            java.util.ArrayList r4 = r2.b()     // Catch:{ Exception -> 0x01a6 }
            com.netcore.android.inapp.h.b$d r15 = r0.c(r15)     // Catch:{ Exception -> 0x01a6 }
            r4.add(r15)     // Catch:{ Exception -> 0x01a6 }
            int r7 = r7 + 1
            r4 = r32
            goto L_0x0182
        L_0x019e:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x01a6 }
            r4.<init>(r13)     // Catch:{ Exception -> 0x01a6 }
            throw r4     // Catch:{ Exception -> 0x01a6 }
        L_0x01a4:
            r31 = r15
        L_0x01a6:
            java.lang.String r4 = "whomTo"
            org.json.JSONObject r4 = r1.optJSONObject(r4)     // Catch:{ Exception -> 0x02af }
            java.lang.String r5 = "rule.optJSONObject(SMTInAppConst.KEY_WHOM_TO)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ Exception -> 0x02af }
            java.lang.String r7 = "listIds"
            org.json.JSONArray r7 = r4.optJSONArray(r7)     // Catch:{ Exception -> 0x01e6 }
            if (r7 == 0) goto L_0x01e6
            int r15 = r7.length()     // Catch:{ Exception -> 0x01e6 }
            if (r15 <= 0) goto L_0x01e6
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ Exception -> 0x01e6 }
            r15.<init>()     // Catch:{ Exception -> 0x01e6 }
            r3.a(r15)     // Catch:{ Exception -> 0x01e6 }
            int r15 = r7.length()     // Catch:{ Exception -> 0x01e6 }
            r5 = 0
        L_0x01cc:
            if (r5 >= r15) goto L_0x01e4
            r33 = r15
            java.lang.String r15 = r7.optString(r5)     // Catch:{ Exception -> 0x01e6 }
            r34 = r7
            java.util.ArrayList r7 = r3.b()     // Catch:{ Exception -> 0x01e6 }
            r7.add(r15)     // Catch:{ Exception -> 0x01e6 }
            int r5 = r5 + 1
            r15 = r33
            r7 = r34
            goto L_0x01cc
        L_0x01e4:
            r5 = 1
            goto L_0x01e7
        L_0x01e6:
            r5 = 0
        L_0x01e7:
            java.lang.String r7 = "segIds"
            org.json.JSONArray r7 = r4.optJSONArray(r7)     // Catch:{ Exception -> 0x021e }
            if (r7 == 0) goto L_0x021e
            int r15 = r7.length()     // Catch:{ Exception -> 0x021e }
            if (r15 <= 0) goto L_0x021e
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ Exception -> 0x021e }
            r15.<init>()     // Catch:{ Exception -> 0x021e }
            r3.b(r15)     // Catch:{ Exception -> 0x021e }
            int r15 = r7.length()     // Catch:{ Exception -> 0x021e }
            r33 = r5
            r5 = 0
        L_0x0204:
            if (r5 >= r15) goto L_0x021c
            r34 = r15
            java.lang.String r15 = r7.optString(r5)     // Catch:{ Exception -> 0x0220 }
            r35 = r7
            java.util.ArrayList r7 = r3.c()     // Catch:{ Exception -> 0x0220 }
            r7.add(r15)     // Catch:{ Exception -> 0x0220 }
            int r5 = r5 + 1
            r15 = r34
            r7 = r35
            goto L_0x0204
        L_0x021c:
            r5 = 1
            goto L_0x0222
        L_0x021e:
            r33 = r5
        L_0x0220:
            r5 = r33
        L_0x0222:
            java.lang.String r7 = "visitor"
            java.lang.String r7 = r4.optString(r7)     // Catch:{ Exception -> 0x0230 }
            java.lang.String r15 = "whomToObject.optString(SMTInAppConst.KEY_VISITOR)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r15)     // Catch:{ Exception -> 0x0230 }
            r3.a(r7)     // Catch:{ Exception -> 0x0230 }
        L_0x0230:
            java.lang.String r7 = "visitorType"
            java.lang.String r7 = r4.optString(r7)     // Catch:{ Exception -> 0x023e }
            java.lang.String r15 = "whomToObject.optString(S…ppConst.KEY_VISITOR_TYPE)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r15)     // Catch:{ Exception -> 0x023e }
            r3.b(r7)     // Catch:{ Exception -> 0x023e }
        L_0x023e:
            java.lang.String r7 = "events"
            org.json.JSONObject r4 = r4.optJSONObject(r7)     // Catch:{ Exception -> 0x02aa }
            if (r4 == 0) goto L_0x02aa
            com.netcore.android.inapp.h.b$a r7 = new com.netcore.android.inapp.h.b$a     // Catch:{ Exception -> 0x02aa }
            r7.<init>()     // Catch:{ Exception -> 0x02aa }
            r3.a(r7)     // Catch:{ Exception -> 0x02aa }
            com.netcore.android.inapp.h.b$a r7 = r3.a()     // Catch:{ Exception -> 0x0263 }
            java.lang.String r15 = "targetRule"
            java.lang.String r15 = r4.optString(r15)     // Catch:{ Exception -> 0x0263 }
            r32 = r5
            java.lang.String r5 = "eventsObject.optString(S…ppConst.KEY_TARGET_RULES)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r5)     // Catch:{ Exception -> 0x0265 }
            r7.a(r15)     // Catch:{ Exception -> 0x0265 }
            goto L_0x0265
        L_0x0263:
            r32 = r5
        L_0x0265:
            java.lang.String r5 = "rules"
            org.json.JSONArray r4 = r4.optJSONArray(r5)     // Catch:{ Exception -> 0x02ac }
            if (r4 == 0) goto L_0x02ac
            int r5 = r4.length()     // Catch:{ Exception -> 0x02ac }
            if (r5 <= 0) goto L_0x02ac
            com.netcore.android.inapp.h.b$a r5 = r3.a()     // Catch:{ Exception -> 0x02ac }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x02ac }
            r7.<init>()     // Catch:{ Exception -> 0x02ac }
            r5.a(r7)     // Catch:{ Exception -> 0x02ac }
            int r5 = r4.length()     // Catch:{ Exception -> 0x02ac }
            r7 = 0
        L_0x0284:
            if (r7 >= r5) goto L_0x02ac
            java.lang.Object r15 = r4.opt(r7)     // Catch:{ Exception -> 0x02ac }
            if (r15 == 0) goto L_0x02a4
            org.json.JSONObject r15 = (org.json.JSONObject) r15     // Catch:{ Exception -> 0x02ac }
            com.netcore.android.inapp.h.b$a r33 = r3.a()     // Catch:{ Exception -> 0x02ac }
            r34 = r4
            java.util.ArrayList r4 = r33.a()     // Catch:{ Exception -> 0x02ac }
            com.netcore.android.inapp.h.b$c r15 = r0.b(r15)     // Catch:{ Exception -> 0x02ac }
            r4.add(r15)     // Catch:{ Exception -> 0x02ac }
            int r7 = r7 + 1
            r4 = r34
            goto L_0x0284
        L_0x02a4:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x02ac }
            r4.<init>(r13)     // Catch:{ Exception -> 0x02ac }
            throw r4     // Catch:{ Exception -> 0x02ac }
        L_0x02aa:
            r32 = r5
        L_0x02ac:
            r5 = r32
            goto L_0x02b0
        L_0x02af:
            r5 = 0
        L_0x02b0:
            org.json.JSONObject r4 = r1.optJSONObject(r6)     // Catch:{ Exception -> 0x065f }
            if (r4 == 0) goto L_0x065f
            org.json.JSONArray r7 = r4.optJSONArray(r14)     // Catch:{ Exception -> 0x036f }
            int r15 = r7.length()     // Catch:{ Exception -> 0x036f }
            r1 = 0
        L_0x02bf:
            if (r1 >= r15) goto L_0x036f
            r32 = r15
            org.json.JSONObject r15 = r7.getJSONObject(r1)     // Catch:{ Exception -> 0x036f }
            if (r15 == 0) goto L_0x034d
            r33 = r7
            com.netcore.android.inapp.h.b$c r7 = new com.netcore.android.inapp.h.b$c     // Catch:{ Exception -> 0x036f }
            r7.<init>()     // Catch:{ Exception -> 0x036f }
            r34 = r3
            java.lang.String r3 = r15.optString(r12)     // Catch:{ Exception -> 0x02dc }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r10)     // Catch:{ Exception -> 0x02dc }
            r7.b(r3)     // Catch:{ Exception -> 0x02dc }
        L_0x02dc:
            java.lang.String r3 = r15.optString(r11)     // Catch:{ Exception -> 0x02e6 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r9)     // Catch:{ Exception -> 0x02e6 }
            r7.a(r3)     // Catch:{ Exception -> 0x02e6 }
        L_0x02e6:
            java.lang.String r3 = r15.optString(r8)     // Catch:{ Exception -> 0x02f5 }
            r35 = r2
            r2 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)     // Catch:{ Exception -> 0x02f9 }
            r7.d(r3)     // Catch:{ Exception -> 0x02f9 }
            goto L_0x02f9
        L_0x02f5:
            r35 = r2
            r2 = r24
        L_0x02f9:
            r3 = r22
            org.json.JSONArray r15 = r15.optJSONArray(r3)     // Catch:{ Exception -> 0x0343 }
            if (r15 == 0) goto L_0x0343
            int r22 = r15.length()     // Catch:{ Exception -> 0x0343 }
            if (r22 <= 0) goto L_0x0343
            r22 = r5
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x0340 }
            r5.<init>()     // Catch:{ Exception -> 0x0340 }
            r7.a(r5)     // Catch:{ Exception -> 0x0340 }
            int r5 = r15.length()     // Catch:{ Exception -> 0x0340 }
            r24 = r3
            r3 = 0
        L_0x0318:
            if (r3 >= r5) goto L_0x0347
            java.lang.Object r36 = r15.opt(r3)     // Catch:{ Exception -> 0x0347 }
            if (r36 == 0) goto L_0x033a
            r37 = r5
            r5 = r36
            org.json.JSONObject r5 = (org.json.JSONObject) r5     // Catch:{ Exception -> 0x0347 }
            r36 = r15
            java.util.ArrayList r15 = r7.d()     // Catch:{ Exception -> 0x0347 }
            com.netcore.android.inapp.h.b$b r5 = r0.a(r5)     // Catch:{ Exception -> 0x0347 }
            r15.add(r5)     // Catch:{ Exception -> 0x0347 }
            int r3 = r3 + 1
            r15 = r36
            r5 = r37
            goto L_0x0318
        L_0x033a:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x0347 }
            r3.<init>(r13)     // Catch:{ Exception -> 0x0347 }
            throw r3     // Catch:{ Exception -> 0x0347 }
        L_0x0340:
            r24 = r3
            goto L_0x0347
        L_0x0343:
            r24 = r3
            r22 = r5
        L_0x0347:
            r3 = r20
            r3.add(r7)     // Catch:{ Exception -> 0x037b }
            goto L_0x035b
        L_0x034d:
            r35 = r2
            r34 = r3
            r33 = r7
            r3 = r20
            r2 = r24
            r24 = r22
            r22 = r5
        L_0x035b:
            int r1 = r1 + 1
            r20 = r3
            r5 = r22
            r22 = r24
            r15 = r32
            r7 = r33
            r3 = r34
            r24 = r2
            r2 = r35
            goto L_0x02bf
        L_0x036f:
            r35 = r2
            r34 = r3
            r3 = r20
            r2 = r24
            r24 = r22
            r22 = r5
        L_0x037b:
            org.json.JSONArray r1 = r4.optJSONArray(r14)     // Catch:{ Exception -> 0x0537 }
            int r5 = r1.length()     // Catch:{ Exception -> 0x0537 }
            r7 = 0
        L_0x0384:
            if (r7 >= r5) goto L_0x0537
            com.netcore.android.inapp.h.b r15 = new com.netcore.android.inapp.h.b     // Catch:{ Exception -> 0x0537 }
            r15.<init>()     // Catch:{ Exception -> 0x0537 }
            r20 = r5
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x0537 }
            r32 = r14
            java.lang.String r14 = r41.toString()     // Catch:{ Exception -> 0x0539 }
            r5.<init>(r14)     // Catch:{ Exception -> 0x0539 }
            org.json.JSONObject r14 = r5.optJSONObject(r6)     // Catch:{ Exception -> 0x0539 }
            r33 = r6
            org.json.JSONObject r6 = r1.getJSONObject(r7)     // Catch:{ Exception -> 0x0539 }
            r36 = r5
            r5 = r19
            r14.put(r5, r6)     // Catch:{ Exception -> 0x0534 }
            org.json.JSONObject r6 = r1.getJSONObject(r7)     // Catch:{ Exception -> 0x0534 }
            if (r6 == 0) goto L_0x04f5
            com.netcore.android.inapp.h.b$c r14 = new com.netcore.android.inapp.h.b$c     // Catch:{ Exception -> 0x04e5 }
            r14.<init>()     // Catch:{ Exception -> 0x04e5 }
            r19 = r1
            java.lang.String r1 = r6.optString(r12)     // Catch:{ Exception -> 0x03ca }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r10)     // Catch:{ Exception -> 0x03ca }
            r15.b(r1)     // Catch:{ Exception -> 0x03ca }
            java.lang.String r1 = r6.optString(r12)     // Catch:{ Exception -> 0x03ca }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r10)     // Catch:{ Exception -> 0x03ca }
            r14.b(r1)     // Catch:{ Exception -> 0x03ca }
        L_0x03ca:
            java.lang.String r1 = r6.optString(r11)     // Catch:{ Exception -> 0x03de }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r9)     // Catch:{ Exception -> 0x03de }
            r15.a(r1)     // Catch:{ Exception -> 0x03de }
            java.lang.String r1 = r6.optString(r11)     // Catch:{ Exception -> 0x03de }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r9)     // Catch:{ Exception -> 0x03de }
            r14.a(r1)     // Catch:{ Exception -> 0x03de }
        L_0x03de:
            java.lang.String r1 = r6.optString(r8)     // Catch:{ Exception -> 0x03e8 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ Exception -> 0x03e8 }
            r14.d(r1)     // Catch:{ Exception -> 0x03e8 }
        L_0x03e8:
            r1 = r24
            org.json.JSONArray r6 = r6.optJSONArray(r1)     // Catch:{ Exception -> 0x0434 }
            if (r6 == 0) goto L_0x042f
            int r24 = r6.length()     // Catch:{ Exception -> 0x0434 }
            if (r24 <= 0) goto L_0x042f
            r24 = r2
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x0431 }
            r2.<init>()     // Catch:{ Exception -> 0x0431 }
            r14.a(r2)     // Catch:{ Exception -> 0x0431 }
            int r2 = r6.length()     // Catch:{ Exception -> 0x0431 }
            r37 = r9
            r9 = 0
        L_0x0407:
            if (r9 >= r2) goto L_0x0437
            java.lang.Object r38 = r6.opt(r9)     // Catch:{ Exception -> 0x0437 }
            if (r38 == 0) goto L_0x0429
            r39 = r2
            r2 = r38
            org.json.JSONObject r2 = (org.json.JSONObject) r2     // Catch:{ Exception -> 0x0437 }
            r38 = r6
            java.util.ArrayList r6 = r14.d()     // Catch:{ Exception -> 0x0437 }
            com.netcore.android.inapp.h.b$b r2 = r0.a(r2)     // Catch:{ Exception -> 0x0437 }
            r6.add(r2)     // Catch:{ Exception -> 0x0437 }
            int r9 = r9 + 1
            r6 = r38
            r2 = r39
            goto L_0x0407
        L_0x0429:
            java.lang.NullPointerException r2 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x0437 }
            r2.<init>(r13)     // Catch:{ Exception -> 0x0437 }
            throw r2     // Catch:{ Exception -> 0x0437 }
        L_0x042f:
            r24 = r2
        L_0x0431:
            r37 = r9
            goto L_0x0437
        L_0x0434:
            r24 = r2
            goto L_0x0431
        L_0x0437:
            r2 = r23
            r15.f(r2)     // Catch:{ Exception -> 0x04e2 }
            r6 = r25
            r15.i(r6)     // Catch:{ Exception -> 0x04db }
            r9 = r30
            r15.e(r9)     // Catch:{ Exception -> 0x04d8 }
            r23 = r10
            r10 = r26
            r15.b(r10)     // Catch:{ Exception -> 0x04d6 }
            r26 = r10
            r10 = r27
            r15.c(r10)     // Catch:{ Exception -> 0x04d3 }
            r27 = r10
            r10 = r28
            r15.c(r10)     // Catch:{ Exception -> 0x04d0 }
            r28 = r10
            r10 = r29
            r15.d(r10)     // Catch:{ Exception -> 0x04cd }
            r29 = r10
            r10 = r16
            r15.g(r10)     // Catch:{ Exception -> 0x04ca }
            r16 = r10
            r10 = r22
            r15.a(r10)     // Catch:{ Exception -> 0x04c7 }
            r22 = r10
            r10 = r31
            r15.a(r10)     // Catch:{ Exception -> 0x04c4 }
            r31 = r10
            r10 = r35
            r15.a(r10)     // Catch:{ Exception -> 0x04c1 }
            r35 = r10
            r10 = r34
            r15.a(r10)     // Catch:{ Exception -> 0x04be }
            r34 = r10
            com.netcore.android.inapp.h.b$g r10 = r15.p()     // Catch:{ Exception -> 0x04d8 }
            r10.a(r3)     // Catch:{ Exception -> 0x04d8 }
            com.netcore.android.inapp.h.b$g r10 = r15.p()     // Catch:{ Exception -> 0x04d8 }
            r10.a(r14)     // Catch:{ Exception -> 0x04d8 }
            com.netcore.android.inapp.h.b$g r10 = r15.p()     // Catch:{ Exception -> 0x04d8 }
            r14 = r18
            r18 = r3
            java.lang.String r3 = r4.optString(r14)     // Catch:{ Exception -> 0x04b9 }
            r25 = r14
            r14 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r14)     // Catch:{ Exception -> 0x04f1 }
            r10.a(r3)     // Catch:{ Exception -> 0x04f1 }
            java.lang.String r3 = r36.toString()     // Catch:{ Exception -> 0x04f1 }
            java.lang.String r10 = "copyPayload.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r10)     // Catch:{ Exception -> 0x04f1 }
            r15.h(r3)     // Catch:{ Exception -> 0x04f1 }
            goto L_0x050b
        L_0x04b9:
            r25 = r14
            r14 = r17
            goto L_0x04f1
        L_0x04be:
            r34 = r10
            goto L_0x04d8
        L_0x04c1:
            r35 = r10
            goto L_0x04d8
        L_0x04c4:
            r31 = r10
            goto L_0x04d8
        L_0x04c7:
            r22 = r10
            goto L_0x04d8
        L_0x04ca:
            r16 = r10
            goto L_0x04d8
        L_0x04cd:
            r29 = r10
            goto L_0x04d8
        L_0x04d0:
            r28 = r10
            goto L_0x04d8
        L_0x04d3:
            r27 = r10
            goto L_0x04d8
        L_0x04d6:
            r26 = r10
        L_0x04d8:
            r14 = r17
            goto L_0x04ef
        L_0x04db:
            r14 = r17
            r25 = r18
            r9 = r30
            goto L_0x04f1
        L_0x04e2:
            r14 = r17
            goto L_0x04eb
        L_0x04e5:
            r14 = r17
            r2 = r23
            r1 = r24
        L_0x04eb:
            r6 = r25
            r9 = r30
        L_0x04ef:
            r25 = r18
        L_0x04f1:
            r3 = r21
            goto L_0x0549
        L_0x04f5:
            r19 = r1
            r37 = r9
            r14 = r17
            r1 = r24
            r6 = r25
            r9 = r30
            r24 = r2
            r25 = r18
            r2 = r23
            r18 = r3
            r23 = r10
        L_0x050b:
            r3 = r21
            r3.add(r15)     // Catch:{ Exception -> 0x0549 }
            int r7 = r7 + 1
            r21 = r3
            r30 = r9
            r17 = r14
            r3 = r18
            r10 = r23
            r18 = r25
            r14 = r32
            r9 = r37
            r23 = r2
            r25 = r6
            r2 = r24
            r6 = r33
            r24 = r1
            r1 = r19
            r19 = r5
            r5 = r20
            goto L_0x0384
        L_0x0534:
            r14 = r17
            goto L_0x053d
        L_0x0537:
            r32 = r14
        L_0x0539:
            r14 = r17
            r5 = r19
        L_0x053d:
            r3 = r21
            r2 = r23
            r1 = r24
            r6 = r25
            r9 = r30
            r25 = r18
        L_0x0549:
            r7 = r32
            org.json.JSONArray r10 = r4.optJSONArray(r7)     // Catch:{ Exception -> 0x0661 }
            if (r10 == 0) goto L_0x0561
            org.json.JSONArray r10 = r4.optJSONArray(r7)     // Catch:{ Exception -> 0x0661 }
            if (r10 == 0) goto L_0x0661
            org.json.JSONArray r7 = r4.optJSONArray(r7)     // Catch:{ Exception -> 0x0661 }
            int r7 = r7.length()     // Catch:{ Exception -> 0x0661 }
            if (r7 != 0) goto L_0x0661
        L_0x0561:
            com.netcore.android.inapp.h.b r7 = new com.netcore.android.inapp.h.b     // Catch:{ Exception -> 0x0661 }
            r7.<init>()     // Catch:{ Exception -> 0x0661 }
            org.json.JSONObject r5 = r4.optJSONObject(r5)     // Catch:{ Exception -> 0x0661 }
            if (r5 == 0) goto L_0x0661
            com.netcore.android.inapp.h.b$g r10 = r7.p()     // Catch:{ Exception -> 0x0661 }
            com.netcore.android.inapp.h.b$c r15 = new com.netcore.android.inapp.h.b$c     // Catch:{ Exception -> 0x0661 }
            r15.<init>()     // Catch:{ Exception -> 0x0661 }
            r10.a(r15)     // Catch:{ Exception -> 0x0661 }
            java.lang.String r10 = r5.optString(r12)     // Catch:{ Exception -> 0x0593 }
            java.lang.String r12 = "triggerObject.optString(…nAppConst.KEY_EVENT_NAME)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r12)     // Catch:{ Exception -> 0x0593 }
            r7.b(r10)     // Catch:{ Exception -> 0x0593 }
            com.netcore.android.inapp.h.b$g r10 = r7.p()     // Catch:{ Exception -> 0x0593 }
            com.netcore.android.inapp.h.b$c r10 = r10.b()     // Catch:{ Exception -> 0x0593 }
            java.lang.String r12 = r7.d()     // Catch:{ Exception -> 0x0593 }
            r10.b(r12)     // Catch:{ Exception -> 0x0593 }
        L_0x0593:
            java.lang.String r10 = r5.optString(r11)     // Catch:{ Exception -> 0x05ae }
            java.lang.String r11 = "triggerObject.optString(…TInAppConst.KEY_EVENT_ID)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)     // Catch:{ Exception -> 0x05ae }
            r7.a(r10)     // Catch:{ Exception -> 0x05ae }
            com.netcore.android.inapp.h.b$g r10 = r7.p()     // Catch:{ Exception -> 0x05ae }
            com.netcore.android.inapp.h.b$c r10 = r10.b()     // Catch:{ Exception -> 0x05ae }
            java.lang.String r11 = r7.c()     // Catch:{ Exception -> 0x05ae }
            r10.a(r11)     // Catch:{ Exception -> 0x05ae }
        L_0x05ae:
            com.netcore.android.inapp.h.b$g r10 = r7.p()     // Catch:{ Exception -> 0x05c2 }
            com.netcore.android.inapp.h.b$c r10 = r10.b()     // Catch:{ Exception -> 0x05c2 }
            java.lang.String r8 = r5.optString(r8)     // Catch:{ Exception -> 0x05c2 }
            java.lang.String r11 = "triggerObject.optString(…AppConst.KEY_FILTER_TYPE)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r11)     // Catch:{ Exception -> 0x05c2 }
            r10.d(r8)     // Catch:{ Exception -> 0x05c2 }
        L_0x05c2:
            org.json.JSONArray r1 = r5.optJSONArray(r1)     // Catch:{ Exception -> 0x0661 }
            if (r1 == 0) goto L_0x0609
            int r5 = r1.length()     // Catch:{ Exception -> 0x0661 }
            if (r5 <= 0) goto L_0x0609
            com.netcore.android.inapp.h.b$g r5 = r7.p()     // Catch:{ Exception -> 0x0661 }
            com.netcore.android.inapp.h.b$c r5 = r5.b()     // Catch:{ Exception -> 0x0661 }
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ Exception -> 0x0661 }
            r8.<init>()     // Catch:{ Exception -> 0x0661 }
            r5.a(r8)     // Catch:{ Exception -> 0x0661 }
            int r5 = r1.length()     // Catch:{ Exception -> 0x0661 }
            r8 = 0
        L_0x05e3:
            if (r8 >= r5) goto L_0x0609
            java.lang.Object r10 = r1.opt(r8)     // Catch:{ Exception -> 0x0661 }
            if (r10 == 0) goto L_0x0603
            org.json.JSONObject r10 = (org.json.JSONObject) r10     // Catch:{ Exception -> 0x0661 }
            com.netcore.android.inapp.h.b$g r11 = r7.p()     // Catch:{ Exception -> 0x0661 }
            com.netcore.android.inapp.h.b$c r11 = r11.b()     // Catch:{ Exception -> 0x0661 }
            java.util.ArrayList r11 = r11.d()     // Catch:{ Exception -> 0x0661 }
            com.netcore.android.inapp.h.b$b r10 = r0.a(r10)     // Catch:{ Exception -> 0x0661 }
            r11.add(r10)     // Catch:{ Exception -> 0x0661 }
            int r8 = r8 + 1
            goto L_0x05e3
        L_0x0603:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x0661 }
            r1.<init>(r13)     // Catch:{ Exception -> 0x0661 }
            throw r1     // Catch:{ Exception -> 0x0661 }
        L_0x0609:
            r7.f(r2)     // Catch:{ Exception -> 0x0661 }
            r7.i(r6)     // Catch:{ Exception -> 0x0661 }
            r7.e(r9)     // Catch:{ Exception -> 0x0661 }
            r5 = r26
            r7.b(r5)     // Catch:{ Exception -> 0x0661 }
            r5 = r27
            r7.c(r5)     // Catch:{ Exception -> 0x0661 }
            r1 = r28
            r7.c(r1)     // Catch:{ Exception -> 0x0661 }
            r5 = r29
            r7.d(r5)     // Catch:{ Exception -> 0x0661 }
            r1 = r16
            r7.g(r1)     // Catch:{ Exception -> 0x0661 }
            r5 = r22
            r7.a(r5)     // Catch:{ Exception -> 0x0661 }
            r1 = r31
            r7.a(r1)     // Catch:{ Exception -> 0x0661 }
            r1 = r35
            r7.a(r1)     // Catch:{ Exception -> 0x0661 }
            r1 = r34
            r7.a(r1)     // Catch:{ Exception -> 0x0661 }
            com.netcore.android.inapp.h.b$g r1 = r7.p()     // Catch:{ Exception -> 0x0661 }
            r2 = r25
            java.lang.String r2 = r4.optString(r2)     // Catch:{ Exception -> 0x0661 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r14)     // Catch:{ Exception -> 0x0661 }
            r1.a(r2)     // Catch:{ Exception -> 0x0661 }
            java.lang.String r1 = r41.toString()     // Catch:{ Exception -> 0x0661 }
            java.lang.String r2 = "rule.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ Exception -> 0x0661 }
            r7.h(r1)     // Catch:{ Exception -> 0x0661 }
            r3.add(r7)     // Catch:{ Exception -> 0x0661 }
            goto L_0x0661
        L_0x065f:
            r3 = r21
        L_0x0661:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.inapp.f.d(org.json.JSONObject):java.util.ArrayList");
    }

    private final C0012b a(JSONObject jSONObject) {
        C0012b bVar = new C0012b();
        try {
            String optString = jSONObject.optString("key");
            Intrinsics.checkNotNullExpressionValue(optString, "filterObject.optString(\"key\")");
            bVar.b(b.a(optString));
        } catch (Exception unused) {
        }
        try {
            String optString2 = jSONObject.optString(HSLCriteriaBuilder.OPERATOR);
            Intrinsics.checkNotNullExpressionValue(optString2, "filterObject.optString(\"operator\")");
            bVar.c(b.a(optString2));
        } catch (Exception unused2) {
        }
        try {
            String optString3 = jSONObject.optString("dataType");
            Intrinsics.checkNotNullExpressionValue(optString3, "filterObject.optString(\"dataType\")");
            bVar.a(b.a(optString3));
        } catch (Exception unused3) {
        }
        try {
            String optString4 = jSONObject.optString(HSLCriteriaBuilder.VALUE);
            Intrinsics.checkNotNullExpressionValue(optString4, "filterObject.optString(\"value\")");
            bVar.d(b.a(optString4));
        } catch (Exception unused4) {
        }
        return bVar;
    }
}
