package defpackage;

import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.AuthError.ERROR_TYPE;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import sfs2x.client.requests.buddylist.GoOnlineRequest;

/* renamed from: bi  reason: default package */
public class bi {

    /* renamed from: a  reason: collision with root package name */
    public bh f2787a = new bh();

    public Bundle a(String str, String str2, String str3, String[] strArr, String str4, Context context, ag agVar, Bundle bundle) throws IOException, AuthError {
        String[] strArr2 = strArr;
        Context context2 = context;
        Bundle bundle2 = bundle;
        if (strArr2 == null || strArr2.length == 0) {
            throw new AuthError("No scopes provided in parameters", ERROR_TYPE.ERROR_BAD_API_PARAM);
        }
        cp.c(GoOnlineRequest.KEY_BUDDY_ID, "Vending new tokens from Code");
        if (this.f2787a != null) {
            Arrays.toString(strArr);
            bh.a(context);
            az azVar = new az(str, str2, str3, str4, agVar, context);
            ba baVar = (ba) azVar.a();
            baVar.a();
            ah[] ahVarArr = {baVar.f2781a, baVar.f68a};
            cb cbVar = (cb) ahVarArr[0];
            if (cbVar != null) {
                a(context2, (ah) cbVar);
                cc ccVar = (cc) ahVarArr[1];
                if (ccVar != null) {
                    a(context2, (ah) ccVar);
                    a(agVar.f2705b, strArr, context, cbVar, ccVar, str4);
                    Bundle bundle3 = new Bundle();
                    bundle3.putString(ch$b.AUTHORIZE.f89a, "authorized");
                    if (bundle2 != null && bundle2.getBoolean(ch$a.RETURN_ACCESS_TOKEN.f87a)) {
                        bundle3.putString(ch$b.TOKEN.f89a, cbVar.f2717b);
                    }
                    return bundle3;
                }
                throw new AuthError("Refresh Atz token was null from server communication", ERROR_TYPE.ERROR_SERVER_REPSONSE);
            }
            throw new AuthError("Access Atz token was null from server communication", ERROR_TYPE.ERROR_SERVER_REPSONSE);
        }
        throw null;
    }

    public static cb a(ak[] akVarArr, Context context) {
        cp.c(GoOnlineRequest.KEY_BUDDY_ID, "Try finding a common access token for requested scopes");
        if (akVarArr == null || akVarArr.length == 0) {
            return null;
        }
        an a2 = an.a(context);
        cb cbVar = (cb) a2.a(akVarArr[0].f49a);
        if (cbVar == null) {
            return null;
        }
        for (int i = 1; i < akVarArr.length; i++) {
            ah a3 = a2.a(akVarArr[i].f49a);
            if (a3 == null || a3.f2703a != cbVar.f2703a) {
                return null;
            }
        }
        cp.a((String) GoOnlineRequest.KEY_BUDDY_ID, (String) "Common access token found.", "accessAtzToken=" + cbVar);
        return cbVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(java.lang.String r18, java.lang.String[] r19, android.content.Context r20, android.os.Bundle r21, defpackage.ag r22) throws java.io.IOException, com.amazon.identity.auth.device.AuthError {
        /*
            r17 = this;
            r8 = r17
            r0 = r19
            r9 = r20
            r1 = r21
            r2 = r22
            java.lang.String r3 = "Vending out token: appId="
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            java.lang.String r4 = r2.f2705b
            r3.append(r4)
            java.lang.String r4 = ", scopes="
            r3.append(r4)
            java.lang.String r4 = java.util.Arrays.toString(r19)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "bi"
            java.lang.String r5 = "directedId=null"
            defpackage.cp.a(r4, r3, r5)
            java.lang.String r3 = r2.f2705b
            r5 = 0
            ak[] r3 = r8.a(r5, r3, r0, r9)
            cb r5 = a(r3, r9)
            int r6 = r3.length
            r7 = 0
            if (r6 != 0) goto L_0x003c
            goto L_0x0067
        L_0x003c:
            an r6 = defpackage.an.a(r20)
            r10 = r3[r7]
            long r10 = r10.f2735b
            ah r10 = r6.a(r10)
            cc r10 = (defpackage.cc) r10
            if (r10 != 0) goto L_0x004d
            goto L_0x0067
        L_0x004d:
            r11 = 1
        L_0x004e:
            int r12 = r3.length
            if (r11 >= r12) goto L_0x0069
            r12 = r3[r11]
            long r12 = r12.f2735b
            ah r12 = r6.a(r12)
            if (r12 == 0) goto L_0x0067
            long r12 = r12.f2703a
            long r14 = r10.f2703a
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 == 0) goto L_0x0064
            goto L_0x0067
        L_0x0064:
            int r11 = r11 + 1
            goto L_0x004e
        L_0x0067:
            r10 = 0
            goto L_0x007f
        L_0x0069:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = "refreshAtzToken="
            r3.append(r6)
            r3.append(r10)
            java.lang.String r3 = r3.toString()
            java.lang.String r6 = "Common refresh token found."
            defpackage.cp.a(r4, r6, r3)
        L_0x007f:
            r3 = 300(0x12c, float:4.2E-43)
            if (r1 == 0) goto L_0x008b
            ch$b r6 = defpackage.ch$b.MINIMUM_TOKEN_LIFETIME
            java.lang.String r6 = r6.f89a
            int r3 = r1.getInt(r6, r3)
        L_0x008b:
            if (r5 == 0) goto L_0x00aa
            java.util.Date r1 = r5.f39b
            long r11 = r1.getTime()
            java.util.Calendar r1 = java.util.Calendar.getInstance()
            long r13 = r1.getTimeInMillis()
            long r11 = r11 - r13
            int r3 = r3 * 1000
            long r13 = (long) r3
            int r1 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r1 < 0) goto L_0x00a5
            r1 = 1
            goto L_0x00a6
        L_0x00a5:
            r1 = 0
        L_0x00a6:
            if (r1 == 0) goto L_0x00aa
            r1 = 1
            goto L_0x00ab
        L_0x00aa:
            r1 = 0
        L_0x00ab:
            if (r1 == 0) goto L_0x00b0
            java.lang.String r0 = r5.f2717b
            return r0
        L_0x00b0:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "token="
            r1.append(r3)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            java.lang.String r6 = "Updating existing token"
            defpackage.cp.a(r4, r6, r1)
            if (r10 == 0) goto L_0x017d
            int r1 = r0.length     // Catch:{ all -> 0x0178 }
            if (r1 != 0) goto L_0x00d0
            defpackage.ac.a(r20)
            goto L_0x0186
        L_0x00d0:
            bh r1 = r8.f2787a     // Catch:{ all -> 0x0178 }
            ah[] r1 = r1.a(r10, r0, r9, r2)     // Catch:{ all -> 0x0178 }
            r11 = r1[r7]     // Catch:{ all -> 0x0178 }
            r6 = 1
            r6 = r1[r6]     // Catch:{ all -> 0x0178 }
            java.lang.String r12 = "Updating token failed unexpectedly!"
            if (r6 == 0) goto L_0x0117
            java.lang.String r6 = "Refresh token"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0178 }
            r13.<init>()     // Catch:{ all -> 0x0178 }
            r13.append(r3)     // Catch:{ all -> 0x0178 }
            r13.append(r10)     // Catch:{ all -> 0x0178 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0178 }
            defpackage.cp.a(r4, r6, r13)     // Catch:{ all -> 0x0178 }
            r6 = 1
            r6 = r1[r6]     // Catch:{ all -> 0x0178 }
            long r13 = r10.f2703a     // Catch:{ all -> 0x0178 }
            r6.f2703a = r13     // Catch:{ all -> 0x0178 }
            an r10 = defpackage.an.a(r20)     // Catch:{ all -> 0x0178 }
            long r13 = r6.f2703a     // Catch:{ all -> 0x0178 }
            android.content.ContentValues r6 = r6.a()     // Catch:{ all -> 0x0178 }
            boolean r6 = r10.a(r13, r6)     // Catch:{ all -> 0x0178 }
            if (r6 == 0) goto L_0x0111
            r6 = 1
            r1 = r1[r6]     // Catch:{ all -> 0x0178 }
            cc r1 = (defpackage.cc) r1     // Catch:{ all -> 0x0178 }
            r6 = r1
            goto L_0x0118
        L_0x0111:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0178 }
            r0.<init>(r12)     // Catch:{ all -> 0x0178 }
            throw r0     // Catch:{ all -> 0x0178 }
        L_0x0117:
            r6 = r10
        L_0x0118:
            if (r11 == 0) goto L_0x017e
            java.lang.String r1 = "Refreshed token"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0178 }
            r10.<init>()     // Catch:{ all -> 0x0178 }
            r10.append(r3)     // Catch:{ all -> 0x0178 }
            r10.append(r5)     // Catch:{ all -> 0x0178 }
            java.lang.String r3 = r10.toString()     // Catch:{ all -> 0x0178 }
            defpackage.cp.a(r4, r1, r3)     // Catch:{ all -> 0x0178 }
            if (r5 == 0) goto L_0x0136
            long r3 = r5.f2703a     // Catch:{ all -> 0x0178 }
            r11.f2703a = r3     // Catch:{ all -> 0x0178 }
            r1 = 0
            goto L_0x0137
        L_0x0136:
            r1 = 1
        L_0x0137:
            ap r3 = defpackage.ap.a(r20)     // Catch:{ all -> 0x0178 }
            r3.a()     // Catch:{ all -> 0x0178 }
            long r3 = r11.f2703a     // Catch:{ all -> 0x0178 }
            r13 = -1
            int r5 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            an r3 = defpackage.an.a(r20)     // Catch:{ all -> 0x0178 }
            if (r5 != 0) goto L_0x0154
            long r3 = r3.a(r11)     // Catch:{ all -> 0x0178 }
            int r5 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r5 == 0) goto L_0x015e
            r7 = 1
            goto L_0x015e
        L_0x0154:
            long r4 = r11.f2703a     // Catch:{ all -> 0x0178 }
            android.content.ContentValues r7 = r11.a()     // Catch:{ all -> 0x0178 }
            boolean r7 = r3.a(r4, r7)     // Catch:{ all -> 0x0178 }
        L_0x015e:
            if (r7 == 0) goto L_0x0172
            if (r1 == 0) goto L_0x017e
            java.lang.String r2 = r2.f2705b     // Catch:{ all -> 0x0178 }
            r5 = r11
            cb r5 = (defpackage.cb) r5     // Catch:{ all -> 0x0178 }
            r7 = 0
            r1 = r17
            r3 = r19
            r4 = r20
            r1.a(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0178 }
            goto L_0x017e
        L_0x0172:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0178 }
            r0.<init>(r12)     // Catch:{ all -> 0x0178 }
            throw r0     // Catch:{ all -> 0x0178 }
        L_0x0178:
            r0 = move-exception
            defpackage.ac.a(r20)
            throw r0
        L_0x017d:
            r11 = 0
        L_0x017e:
            defpackage.ac.a(r20)
            if (r11 == 0) goto L_0x0186
            java.lang.String r0 = r11.f2717b
            goto L_0x0187
        L_0x0186:
            r0 = 0
        L_0x0187:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bi.a(java.lang.String, java.lang.String[], android.content.Context, android.os.Bundle, ag):java.lang.String");
    }

    public void a(Context context, ag agVar) throws AuthError, IOException {
        ArrayList arrayList = (ArrayList) aq.a(context).a((String[]) null, (String[]) null);
        if (!arrayList.isEmpty()) {
            cb a2 = a((ak[]) arrayList.toArray(new ak[arrayList.size()]), context);
            if (a2 != null) {
                bh bhVar = this.f2787a;
                ax axVar = new ax(context, agVar, a2.f2717b);
                if (bhVar != null) {
                    bh.a(context);
                    ar arVar = (ar) axVar.a();
                    arVar.a();
                    ay ayVar = (ay) arVar;
                } else {
                    throw null;
                }
            }
        }
    }

    public final void a(Context context, ah ahVar) throws AuthError {
        if (an.a(context).a(ahVar) == -1) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unable to insert ");
            outline73.append(ahVar.c());
            outline73.append(" token into db");
            throw new AuthError(outline73.toString(), ERROR_TYPE.ERROR_DATA_STORAGE);
        }
    }

    public final void a(String str, String[] strArr, Context context, cb cbVar, cc ccVar, String str2) {
        StringBuilder sb;
        for (ak akVar : a(str2, str, strArr, context)) {
            if (akVar.f2703a == -1) {
                akVar.f49a = cbVar.f2703a;
                akVar.f2735b = ccVar.f2703a;
                sb = new StringBuilder();
                sb.append("Inserting ");
                sb.append(akVar);
                sb.append(" : rowid=");
                sb.append(aq.a(context).a(akVar));
            } else {
                if (((ah) an.a(context).a(akVar.f49a)) != null) {
                    cp.a((String) GoOnlineRequest.KEY_BUDDY_ID, (String) "Deleting old access token.", "accessAtzToken=" + r2 + " : " + r2.c(context));
                }
                akVar.f49a = cbVar.f2703a;
                if (ccVar != null) {
                    if (((ah) an.a(context).a(akVar.f2735b)) != null) {
                        cp.a((String) GoOnlineRequest.KEY_BUDDY_ID, (String) "Deleting old refresh token ", "refreshAtzToken=" + r1 + " : " + r1.c(context));
                    }
                    akVar.f2735b = ccVar.f2703a;
                    sb = new StringBuilder();
                    sb.append("Updating ");
                    sb.append(akVar);
                    sb.append(" : ");
                    sb.append(aq.a(context).a(akVar.f2703a, akVar.a()));
                } else {
                    throw null;
                }
            }
            cp.c(GoOnlineRequest.KEY_BUDDY_ID, sb.toString());
        }
    }

    public ak[] a(String str, String str2, String[] strArr, Context context) {
        int length = strArr.length;
        ak[] akVarArr = new ak[length];
        int i = 0;
        while (i < length) {
            aq a2 = aq.a(context);
            String str3 = strArr[i];
            if (a2 != null) {
                ak akVar = (ak) a2.a(new String[]{aq.f61a[a.SCOPE.f52a], aq.f61a[a.APP_FAMILY_ID.f52a], aq.f61a[a.DIRECTED_ID.f52a]}, new String[]{str3, str2, str});
                if (akVar != null) {
                    akVarArr[i] = akVar;
                } else {
                    cp.d(GoOnlineRequest.KEY_BUDDY_ID, "RequestedScope shouldn't be null!!!! - " + akVar + ", but continuing anyway...");
                    akVarArr[i] = new ak(strArr[i], str2, str);
                }
                i++;
            } else {
                throw null;
            }
        }
        return akVarArr;
    }
}
