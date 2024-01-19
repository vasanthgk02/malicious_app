package defpackage;

import android.content.ContentValues;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;
import org.json.JSONObject;

/* renamed from: ag  reason: default package */
public class ag extends af {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f2704a = {"rowid", "AppFamilyId", "PackageName", "AllowedScopes", "GrantedPermissions", "ClientId", "AppVariantId", "AuthzHost", "ExchangeHost", "Payload"};

    /* renamed from: a  reason: collision with other field name */
    public JSONObject f30a;

    /* renamed from: b  reason: collision with root package name */
    public String f2705b;

    /* renamed from: b  reason: collision with other field name */
    public String[] f31b;

    /* renamed from: c  reason: collision with root package name */
    public String f2706c;

    /* renamed from: c  reason: collision with other field name */
    public String[] f32c;

    /* renamed from: d  reason: collision with root package name */
    public String f2707d;

    /* renamed from: e  reason: collision with root package name */
    public String f2708e;

    /* renamed from: f  reason: collision with root package name */
    public String f2709f;
    public String g;

    /* renamed from: ag$a */
    public enum a {
        ROW_ID(0),
        APP_FAMILY_ID(1),
        PACKAGE_NAME(2),
        ALLOWED_SCOPES(3),
        GRANTED_PERMISSIONS(4),
        CLIENT_ID(5),
        APP_VARIANT_ID(6),
        AUTHZ_HOST(7),
        EXCHANGE_HOST(8),
        PAYLOAD(9);
        

        /* renamed from: a  reason: collision with other field name */
        public final int f34a;

        /* access modifiers changed from: public */
        a(int i) {
            this.f34a = i;
        }
    }

    public ag() {
    }

    public ag(String str, String str2, String str3, String[] strArr, String[] strArr2, String str4, String str5, String str6, JSONObject jSONObject) {
        this.f2705b = str;
        this.f2706c = str2;
        this.f2707d = str3;
        this.f31b = strArr;
        this.f32c = strArr2;
        this.f2708e = str4;
        this.f30a = jSONObject;
        this.f2709f = str5;
        this.g = str6;
    }

    public ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(f2704a[a.APP_FAMILY_ID.f34a], this.f2705b);
        contentValues.put(f2704a[a.PACKAGE_NAME.f34a], this.f2707d);
        contentValues.put(f2704a[a.ALLOWED_SCOPES.f34a], cj.a(this.f31b, (String) ","));
        contentValues.put(f2704a[a.GRANTED_PERMISSIONS.f34a], cj.a(this.f32c, (String) ","));
        contentValues.put(f2704a[a.CLIENT_ID.f34a], this.f2708e);
        contentValues.put(f2704a[a.APP_VARIANT_ID.f34a], this.f2706c);
        contentValues.put(f2704a[a.AUTHZ_HOST.f34a], this.f2709f);
        contentValues.put(f2704a[a.EXCHANGE_HOST.f34a], this.g);
        String str = f2704a[a.PAYLOAD.f34a];
        JSONObject jSONObject = this.f30a;
        contentValues.put(str, jSONObject != null ? jSONObject.toString() : null);
        return contentValues;
    }

    public Object clone() throws CloneNotSupportedException {
        long j = this.f2703a;
        ag agVar = new ag(this.f2705b, this.f2706c, this.f2707d, this.f31b, this.f32c, this.f2708e, this.f2709f, this.g, this.f30a);
        agVar.f2703a = j;
        return agVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0060, code lost:
        if (r8 == null) goto L_0x00ac;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof defpackage.ag
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x00b0
            ag r8 = (defpackage.ag) r8
            java.lang.String r0 = r7.f2705b
            java.lang.String r3 = r8.f2705b
            boolean r0 = android.text.TextUtils.equals(r0, r3)
            if (r0 == 0) goto L_0x00b0
            java.lang.String r0 = r7.f2706c
            java.lang.String r3 = r8.f2706c
            boolean r0 = android.text.TextUtils.equals(r0, r3)
            if (r0 == 0) goto L_0x00b0
            java.lang.String r0 = r7.f2707d
            java.lang.String r3 = r8.f2707d
            boolean r0 = android.text.TextUtils.equals(r0, r3)
            if (r0 == 0) goto L_0x00b0
            java.lang.String[] r0 = r7.f31b
            java.lang.String[] r3 = r8.f31b
            boolean r0 = java.util.Arrays.equals(r0, r3)
            if (r0 == 0) goto L_0x00b0
            java.lang.String[] r0 = r7.f32c
            java.lang.String[] r3 = r8.f32c
            boolean r0 = java.util.Arrays.equals(r0, r3)
            if (r0 == 0) goto L_0x00b0
            java.lang.String r0 = r7.f2708e
            java.lang.String r3 = r8.f2708e
            boolean r0 = android.text.TextUtils.equals(r0, r3)
            if (r0 == 0) goto L_0x00b0
            java.lang.String r0 = r7.f2709f
            java.lang.String r3 = r8.f2709f
            boolean r0 = android.text.TextUtils.equals(r0, r3)
            if (r0 == 0) goto L_0x00b0
            java.lang.String r0 = r7.g
            java.lang.String r3 = r8.g
            boolean r0 = android.text.TextUtils.equals(r0, r3)
            if (r0 == 0) goto L_0x00b0
            java.lang.String r0 = "ag"
            org.json.JSONObject r8 = r8.f30a
            org.json.JSONObject r3 = r7.f30a
            if (r3 != 0) goto L_0x0063
            if (r8 != 0) goto L_0x00aa
            goto L_0x00ac
        L_0x0063:
            if (r8 != 0) goto L_0x0066
            goto L_0x00aa
        L_0x0066:
            java.util.Iterator r3 = r3.keys()
        L_0x006a:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00ac
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            org.json.JSONObject r5 = r7.f30a     // Catch:{ JSONException -> 0x00a4, ClassCastException -> 0x00a0 }
            java.lang.String r5 = r5.getString(r4)     // Catch:{ JSONException -> 0x00a4, ClassCastException -> 0x00a0 }
            java.lang.String r6 = r8.getString(r4)     // Catch:{ JSONException -> 0x00a4, ClassCastException -> 0x00a0 }
            boolean r5 = r5.equals(r6)     // Catch:{ JSONException -> 0x00a4, ClassCastException -> 0x00a0 }
            if (r5 != 0) goto L_0x006a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00a4, ClassCastException -> 0x00a0 }
            r8.<init>()     // Catch:{ JSONException -> 0x00a4, ClassCastException -> 0x00a0 }
            java.lang.String r3 = "APIKeys not equal: key "
            r8.append(r3)     // Catch:{ JSONException -> 0x00a4, ClassCastException -> 0x00a0 }
            r8.append(r4)     // Catch:{ JSONException -> 0x00a4, ClassCastException -> 0x00a0 }
            java.lang.String r3 = " not equal"
            r8.append(r3)     // Catch:{ JSONException -> 0x00a4, ClassCastException -> 0x00a0 }
            java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x00a4, ClassCastException -> 0x00a0 }
            defpackage.cp.b(r0, r8)     // Catch:{ JSONException -> 0x00a4, ClassCastException -> 0x00a0 }
            goto L_0x00aa
        L_0x00a0:
            r8 = move-exception
            java.lang.String r3 = "APIKeys not equal: ClassCastExceptionException"
            goto L_0x00a7
        L_0x00a4:
            r8 = move-exception
            java.lang.String r3 = "APIKeys not equal: JSONException"
        L_0x00a7:
            defpackage.cp.a(r0, r3, r8)
        L_0x00aa:
            r8 = 0
            goto L_0x00ad
        L_0x00ac:
            r8 = 1
        L_0x00ad:
            if (r8 == 0) goto L_0x00b0
            goto L_0x00b1
        L_0x00b0:
            r1 = 0
        L_0x00b1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ag.equals(java.lang.Object):boolean");
    }

    public String toString() {
        try {
            return this.f30a.toString(4);
        } catch (Exception unused) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("{ rowid=");
            outline73.append(this.f2703a);
            outline73.append(", appFamilyId=");
            outline73.append(this.f2705b);
            outline73.append(", appVariantId=");
            outline73.append(this.f2706c);
            outline73.append(", packageName=");
            outline73.append(this.f2707d);
            outline73.append(", allowedScopes=");
            outline73.append(Arrays.toString(this.f31b));
            outline73.append(", grantedPermissions=");
            outline73.append(Arrays.toString(this.f32c));
            outline73.append(", clientId=");
            outline73.append(this.f2708e);
            outline73.append(", AuthzHost=");
            outline73.append(this.f2709f);
            outline73.append(", ExchangeHost=");
            return GeneratedOutlineSupport.outline62(outline73, this.g, " }");
        }
    }
}
