package com.freshchat.consumer.sdk.service.c;

import android.content.Context;
import com.freshchat.consumer.sdk.JwtTokenStatus;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.beans.User;
import com.freshchat.consumer.sdk.beans.reqres.UserRequest;
import com.freshchat.consumer.sdk.beans.reqres.UserResponse;
import com.freshchat.consumer.sdk.exception.DeletedException;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ab;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.b;
import com.freshchat.consumer.sdk.j.d;
import com.freshchat.consumer.sdk.j.o;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.service.e.a;
import com.freshchat.consumer.sdk.service.e.k;
import java.util.HashMap;
import java.util.Map;

public class c extends a<a, k> {
    public static final String TAG = "com.freshchat.consumer.sdk.service.c.c";

    public static User a(Context context, a aVar, com.freshchat.consumer.sdk.c.k kVar) {
        e i = e.i(context);
        a(context, aVar.getUser(), kVar, false);
        if (kVar.bV() && !aVar.cY()) {
            return null;
        }
        User a2 = kVar.a(false, true);
        String C = d.C(context);
        a2.setAlias(C);
        String jwtIdToken = kVar.a(true, true).getJwtIdToken();
        if (as.a(jwtIdToken)) {
            return new User().setAlias(C).setJwtIdToken(jwtIdToken);
        }
        if (as.isEmpty(i.bI()) && as.isEmpty(a2.getExternalId()) && as.a(i.bk())) {
            a2.setExternalId(i.bk());
        }
        return a2;
    }

    private User a(User user, String str) throws DeletedException {
        e i = e.i(getContext());
        try {
            UserRequest userRequest = new UserRequest();
            userRequest.setUser(user.setJwtIdToken(null));
            userRequest.setJwtIdToken(str);
            UserResponse a2 = new com.freshchat.consumer.sdk.e.a(getContext()).a(userRequest);
            if (a2 == null) {
                return null;
            }
            if (a2.getStatusCode() == 409) {
                d.bG(getContext());
                return null;
            } else if (a2.getUser() == null) {
                return null;
            } else {
                User user2 = a2.getUser();
                f(user2);
                return user2;
            }
        } catch (Exception e2) {
            i.c(false);
            i.t(user.getAlias());
            throw new RuntimeException(e2);
        }
    }

    private User a(User user, String str, com.freshchat.consumer.sdk.c.k kVar) throws DeletedException {
        UserResponse userResponse;
        boolean a2 = as.a(str);
        User user2 = null;
        if (a2) {
            UserRequest userRequest = new UserRequest();
            userRequest.setUser(user.setJwtIdToken(null));
            userRequest.setJwtIdToken(str);
            userResponse = new com.freshchat.consumer.sdk.e.a(getContext()).c(userRequest);
        } else {
            userResponse = new com.freshchat.consumer.sdk.e.a(getContext()).n(user.getExternalId(), user.getRestoreId());
        }
        if (userResponse.getStatusCode() == 200) {
            user2 = userResponse.getUser();
            if (user2 != null) {
                if (as.a(str)) {
                    user2.setJwtIdToken(str);
                }
                f(user2);
                Context context = getContext();
                if (!a2) {
                    b.u(context);
                } else {
                    com.freshchat.consumer.sdk.b.a.cn(context);
                }
                b.a(getContext(), 1, com.freshchat.consumer.sdk.service.e.d.a.IMMEDIATE);
            }
        } else if ((!a2 && userResponse.getStatusCode() == 418) || (a2 && userResponse.getStatusCode() == 404)) {
            if (a2) {
                o.a(getContext(), JwtTokenStatus.TOKEN_VALID, str);
            }
            user.setAlias(null);
            user.setRestoreId(null);
            dw().is();
            kVar.iu();
            b.a(getContext(), user, w.aB(getContext()));
        }
        return user2;
    }

    public static void a(Context context, User user, com.freshchat.consumer.sdk.c.k kVar, boolean z) {
        if (user == null) {
            user = d.bF(context);
        }
        d.a(e.i(context), user);
        if (z) {
            kVar.b(user);
        } else {
            kVar.a(user);
        }
    }

    public static void a(Context context, a aVar) {
        ab abVar = new ab(new ab.a());
        com.freshchat.consumer.sdk.service.a.a m = com.freshchat.consumer.sdk.service.a.c.m(context, 1);
        com.freshchat.consumer.sdk.service.a.a aVar2 = new com.freshchat.consumer.sdk.service.a.a(1);
        if (m != null) {
            Map<String, String> meta = m.getMeta();
            a aVar3 = (a) abVar.fromJson(com.freshchat.consumer.sdk.j.k.d(meta) ? meta.get("fc_create_or_update_user") : "{}", a.class);
            if (aVar3 != null) {
                if (aVar3.cN()) {
                    aVar.n(true);
                }
                if (aVar3.cY()) {
                    aVar.o(true);
                }
            }
        }
        String json = abVar.toJson(aVar);
        HashMap hashMap = new HashMap();
        hashMap.put("fc_create_or_update_user", json);
        aVar2.b(hashMap);
        aa.c(context, aVar2);
    }

    public static boolean a(JwtTokenStatus jwtTokenStatus, String str, String str2, boolean z) {
        if (z) {
            return false;
        }
        if (!(as.a(str2) && o.ba(str2) && jwtTokenStatus == JwtTokenStatus.TOKEN_NOT_PROCESSED)) {
            return false;
        }
        return (!o.bc(str) || !o.bc(str2)) ? as.p(str, str2) : o.u(str, str2);
    }

    private boolean a(a aVar, User user) {
        boolean bl = dw().bl();
        boolean z = true;
        if (!as.a(user.getJwtIdToken())) {
            if (bl || !aVar.cN()) {
                z = false;
            }
            return z;
        } else if (o.bz(getContext()) != JwtTokenStatus.TOKEN_VALID && o.bz(getContext()) != JwtTokenStatus.TOKEN_NOT_PROCESSED) {
            return false;
        } else {
            if (bl || !aVar.cN()) {
                z = false;
            }
            return z;
        }
    }

    private boolean a(String str, User user) {
        if (user == null) {
            return false;
        }
        return a(o.bz(getContext()), str, user.getJwtIdToken(), dw().bl());
    }

    private boolean a(String str, String str2, User user) {
        if (user == null) {
            return false;
        }
        String externalId = user.getExternalId();
        String restoreId = user.getRestoreId();
        boolean z = true;
        boolean z2 = as.a(externalId) && as.a(restoreId);
        if (z2) {
            if (!as.o(str, externalId) || !as.o(str2, restoreId)) {
                z = false;
            }
            if (z) {
                return false;
            }
        }
        return z2;
    }

    private User b(User user, String str) throws DeletedException {
        if (as.a(str)) {
            JwtTokenStatus bz = o.bz(getContext());
            if (bz != JwtTokenStatus.TOKEN_NOT_PROCESSED) {
                if (bz != JwtTokenStatus.TOKEN_VALID) {
                    ai.e("FreshchatTest", "Stopping user update");
                    return null;
                } else if (o.P(getContext(), str)) {
                    return null;
                }
            }
        }
        UserRequest userRequest = new UserRequest();
        userRequest.setUser(user.setJwtIdToken(null));
        userRequest.setJwtIdToken(str);
        UserResponse b2 = new com.freshchat.consumer.sdk.e.a(getContext()).b(userRequest);
        if (b2.getStatusCode() == 409) {
            o.bA(getContext());
        } else if (b2.getUser() != null) {
            if (com.freshchat.consumer.sdk.service.a.c.bd(getContext())) {
                b.M(getContext());
            }
            if (as.a(str)) {
                b.bJ(getContext());
            }
        }
        return b2.getUser();
    }

    private void c(a aVar) {
        com.freshchat.consumer.sdk.service.a.a m = com.freshchat.consumer.sdk.service.a.c.m(getContext(), 1);
        if (m != null) {
            ab abVar = new ab(new ab.a());
            Map<String, String> meta = m.getMeta();
            a aVar2 = (a) abVar.fromJson(com.freshchat.consumer.sdk.j.k.d(meta) ? meta.get("fc_create_or_update_user") : "{}", a.class);
            if (aVar2 != null) {
                if (aVar2.cN()) {
                    aVar.n(true);
                }
                if (aVar2.cY()) {
                    aVar.o(true);
                }
            }
        }
    }

    private void f(User user) {
        if (user != null) {
            String alias = user.getAlias();
            String str = TAG;
            ai.d(str, "Result for create user is " + alias);
            e i = e.i(getContext());
            i.t(alias);
            i.c(true);
            b.Q(getContext(), i.bP());
            b.U(getContext());
            b.T(getContext());
            b.S(getContext());
            if (com.freshchat.consumer.sdk.service.a.c.s(getContext())) {
                b.M(getContext());
            }
        }
    }

    private void g(User user) {
        if (!com.freshchat.consumer.sdk.j.k.c(user.getAndroidDeviceMeta())) {
            e i = e.i(getContext());
            Map<String, String> androidDeviceMeta = user.getAndroidDeviceMeta();
            if (androidDeviceMeta.containsKey("app_version_code")) {
                String str = androidDeviceMeta.get("app_version_code");
                if (as.a(str) && !str.equals(i.bm())) {
                    i.v(str);
                }
            }
            if (androidDeviceMeta.containsKey(User.DEVICE_META_SDK_VERSION_CODE)) {
                i.k(Integer.parseInt(androidDeviceMeta.get(User.DEVICE_META_SDK_VERSION_CODE)));
            }
        }
    }

    public boolean a(a aVar) {
        return w.ay(getContext()) && w.aA(getContext()) && e.i(getContext()).bl();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0188, code lost:
        if (com.freshchat.consumer.sdk.j.as.a(r10.dr()) != false) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x018a, code lost:
        com.freshchat.consumer.sdk.j.aa.l(getContext(), r10.dr());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01cc, code lost:
        if (com.freshchat.consumer.sdk.j.as.a(r10.dr()) != false) goto L_0x018a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01d9  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:81:0x01a7=Splitter:B:81:0x01a7, B:76:0x019a=Splitter:B:76:0x019a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.freshchat.consumer.sdk.service.e.k b(com.freshchat.consumer.sdk.service.e.a r10) {
        /*
            r9 = this;
            com.freshchat.consumer.sdk.c.k r0 = new com.freshchat.consumer.sdk.c.k
            android.content.Context r1 = r9.getContext()
            r0.<init>(r1)
            r1 = 0
            r2 = 1
            android.content.Context r3 = r9.getContext()     // Catch:{ DeletedException -> 0x01a5, Exception -> 0x0198, all -> 0x0196 }
            com.freshchat.consumer.sdk.b.e r3 = com.freshchat.consumer.sdk.b.e.i(r3)     // Catch:{ DeletedException -> 0x01a5, Exception -> 0x0198, all -> 0x0196 }
            r9.c(r10)     // Catch:{ DeletedException -> 0x01a5, Exception -> 0x0198, all -> 0x0196 }
            java.lang.String r4 = r3.bk()     // Catch:{ DeletedException -> 0x01a5, Exception -> 0x0198, all -> 0x0196 }
            java.lang.String r3 = r3.bI()     // Catch:{ DeletedException -> 0x01a5, Exception -> 0x0198, all -> 0x0196 }
            com.freshchat.consumer.sdk.beans.User r5 = r0.a(r2, r1)     // Catch:{ DeletedException -> 0x01a5, Exception -> 0x0198, all -> 0x0196 }
            java.lang.String r5 = r5.getJwtIdToken()     // Catch:{ DeletedException -> 0x01a5, Exception -> 0x0198, all -> 0x0196 }
            android.content.Context r6 = r9.getContext()     // Catch:{ DeletedException -> 0x01a5, Exception -> 0x0198, all -> 0x0196 }
            com.freshchat.consumer.sdk.beans.User r6 = a(r6, r10, r0)     // Catch:{ DeletedException -> 0x01a5, Exception -> 0x0198, all -> 0x0196 }
            if (r6 != 0) goto L_0x0065
            com.freshchat.consumer.sdk.service.e.h r3 = new com.freshchat.consumer.sdk.service.e.h     // Catch:{ DeletedException -> 0x01a5, Exception -> 0x0198, all -> 0x0196 }
            r3.<init>(r1)     // Catch:{ DeletedException -> 0x01a5, Exception -> 0x0198, all -> 0x0196 }
            boolean r10 = r0.bV()
            if (r10 == 0) goto L_0x0064
            android.content.Context r10 = r9.getContext()
            boolean r10 = com.freshchat.consumer.sdk.service.a.c.t(r10)
            if (r10 == 0) goto L_0x0064
            android.content.Context r10 = r9.getContext()
            com.freshchat.consumer.sdk.service.a.a r10 = com.freshchat.consumer.sdk.service.a.c.m(r10, r2)
            if (r10 == 0) goto L_0x0064
            java.lang.String r0 = r10.dr()
            boolean r0 = com.freshchat.consumer.sdk.j.as.a(r0)
            if (r0 == 0) goto L_0x0064
            android.content.Context r0 = r9.getContext()
            java.lang.String r10 = r10.dr()
            com.freshchat.consumer.sdk.j.aa.l(r0, r10)
        L_0x0064:
            return r3
        L_0x0065:
            android.content.Context r7 = r9.getContext()     // Catch:{ DeletedException -> 0x01a5, Exception -> 0x0198, all -> 0x0196 }
            java.util.Map r7 = com.freshchat.consumer.sdk.j.p.av(r7)     // Catch:{ DeletedException -> 0x01a5, Exception -> 0x0198, all -> 0x0196 }
            r6.setAndroidDeviceMeta(r7)     // Catch:{ DeletedException -> 0x01a5, Exception -> 0x0198, all -> 0x0196 }
            android.content.Context r7 = r9.getContext()     // Catch:{ DeletedException -> 0x01a5, Exception -> 0x0198, all -> 0x0196 }
            java.lang.String r7 = com.freshchat.consumer.sdk.j.ah.bc(r7)     // Catch:{ DeletedException -> 0x01a5, Exception -> 0x0198, all -> 0x0196 }
            r6.setLocale(r7)     // Catch:{ DeletedException -> 0x01a5, Exception -> 0x0198, all -> 0x0196 }
            boolean r7 = r9.a(r10, r6)     // Catch:{ DeletedException -> 0x01a5, Exception -> 0x0198, all -> 0x0196 }
            boolean r3 = r9.a(r4, r3, r6)     // Catch:{ DeletedException -> 0x01a5, Exception -> 0x0198, all -> 0x0196 }
            if (r3 != 0) goto L_0x008e
            boolean r3 = r9.a(r5, r6)     // Catch:{ DeletedException -> 0x01a5, Exception -> 0x0198, all -> 0x0196 }
            if (r3 == 0) goto L_0x008c
            goto L_0x008e
        L_0x008c:
            r3 = 0
            goto L_0x008f
        L_0x008e:
            r3 = 1
        L_0x008f:
            if (r7 != 0) goto L_0x009c
            if (r3 != 0) goto L_0x009c
            boolean r4 = r9.a(r10)     // Catch:{ DeletedException -> 0x01a5, Exception -> 0x0198, all -> 0x0196 }
            if (r4 == 0) goto L_0x009a
            goto L_0x009c
        L_0x009a:
            r4 = 0
            goto L_0x009d
        L_0x009c:
            r4 = 1
        L_0x009d:
            r5 = r4 ^ 1
            if (r4 == 0) goto L_0x0163
            if (r3 == 0) goto L_0x00b2
            java.lang.String r3 = r6.getJwtIdToken()     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            com.freshchat.consumer.sdk.beans.User r3 = r9.a(r6, r3, r0)     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            goto L_0x00c5
        L_0x00ac:
            r3 = move-exception
            goto L_0x019a
        L_0x00af:
            r3 = move-exception
            goto L_0x01a7
        L_0x00b2:
            if (r7 == 0) goto L_0x00bd
            java.lang.String r3 = r6.getJwtIdToken()     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            com.freshchat.consumer.sdk.beans.User r3 = r9.a(r6, r3)     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            goto L_0x00c5
        L_0x00bd:
            java.lang.String r3 = r6.getJwtIdToken()     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            com.freshchat.consumer.sdk.beans.User r3 = r9.b(r6, r3)     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
        L_0x00c5:
            if (r3 == 0) goto L_0x010e
            android.content.Context r4 = r9.getContext()     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            a(r4, r3, r0, r2)     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            r9.g(r3)     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            com.freshchat.consumer.sdk.j.by r4 = com.freshchat.consumer.sdk.j.by.gN()     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            android.content.Context r7 = r9.getContext()     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            r4.d(r7, r2)     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            java.lang.String r4 = r3.getJwtIdToken()     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            boolean r4 = com.freshchat.consumer.sdk.j.as.a(r4)     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            if (r4 == 0) goto L_0x00f3
            android.content.Context r4 = r9.getContext()     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            com.freshchat.consumer.sdk.JwtTokenStatus r7 = com.freshchat.consumer.sdk.JwtTokenStatus.TOKEN_VALID     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            java.lang.String r8 = r3.getJwtIdToken()     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            com.freshchat.consumer.sdk.j.o.a(r4, r7, r8)     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
        L_0x00f3:
            java.lang.String r4 = r6.getExternalId()     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            boolean r4 = com.freshchat.consumer.sdk.j.as.a(r4)     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            if (r4 == 0) goto L_0x010e
            java.lang.String r4 = r3.getRestoreId()     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            boolean r4 = com.freshchat.consumer.sdk.j.as.a(r4)     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            if (r4 == 0) goto L_0x010e
            android.content.Context r4 = r9.getContext()     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            com.freshchat.consumer.sdk.b.a.ai(r4)     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
        L_0x010e:
            java.lang.String r4 = TAG     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            r6.<init>()     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            java.lang.String r7 = "Updated user "
            r6.append(r7)     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            r6.append(r3)     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            java.lang.String r3 = r6.toString()     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            com.freshchat.consumer.sdk.j.ai.d(r4, r3)     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            com.freshchat.consumer.sdk.service.e.h r3 = new com.freshchat.consumer.sdk.service.e.h     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            r3.<init>(r2)     // Catch:{ DeletedException -> 0x00af, Exception -> 0x00ac }
            if (r5 == 0) goto L_0x0133
            android.content.Context r0 = r9.getContext()
            a(r0, r10)
            goto L_0x0162
        L_0x0133:
            boolean r10 = r0.bV()
            if (r10 == 0) goto L_0x0162
            android.content.Context r10 = r9.getContext()
            boolean r10 = com.freshchat.consumer.sdk.service.a.c.t(r10)
            if (r10 == 0) goto L_0x0162
            android.content.Context r10 = r9.getContext()
            com.freshchat.consumer.sdk.service.a.a r10 = com.freshchat.consumer.sdk.service.a.c.m(r10, r2)
            if (r10 == 0) goto L_0x0162
            java.lang.String r0 = r10.dr()
            boolean r0 = com.freshchat.consumer.sdk.j.as.a(r0)
            if (r0 == 0) goto L_0x0162
            android.content.Context r0 = r9.getContext()
            java.lang.String r10 = r10.dr()
            com.freshchat.consumer.sdk.j.aa.l(r0, r10)
        L_0x0162:
            return r3
        L_0x0163:
            if (r5 == 0) goto L_0x0166
            goto L_0x019d
        L_0x0166:
            boolean r10 = r0.bV()
            if (r10 == 0) goto L_0x01cf
            android.content.Context r10 = r9.getContext()
            boolean r10 = com.freshchat.consumer.sdk.service.a.c.t(r10)
            if (r10 == 0) goto L_0x01cf
            android.content.Context r10 = r9.getContext()
            com.freshchat.consumer.sdk.service.a.a r10 = com.freshchat.consumer.sdk.service.a.c.m(r10, r2)
            if (r10 == 0) goto L_0x01cf
            java.lang.String r0 = r10.dr()
            boolean r0 = com.freshchat.consumer.sdk.j.as.a(r0)
            if (r0 == 0) goto L_0x01cf
        L_0x018a:
            android.content.Context r0 = r9.getContext()
            java.lang.String r10 = r10.dr()
            com.freshchat.consumer.sdk.j.aa.l(r0, r10)
            goto L_0x01cf
        L_0x0196:
            r3 = move-exception
            goto L_0x01d7
        L_0x0198:
            r3 = move-exception
            r5 = 0
        L_0x019a:
            com.freshchat.consumer.sdk.j.q.a(r3)     // Catch:{ all -> 0x01d5 }
        L_0x019d:
            android.content.Context r0 = r9.getContext()
            a(r0, r10)
            goto L_0x01cf
        L_0x01a5:
            r3 = move-exception
            r5 = 0
        L_0x01a7:
            com.freshchat.consumer.sdk.j.q.a(r3)     // Catch:{ all -> 0x01d5 }
            boolean r10 = r0.bV()
            if (r10 == 0) goto L_0x01cf
            android.content.Context r10 = r9.getContext()
            boolean r10 = com.freshchat.consumer.sdk.service.a.c.t(r10)
            if (r10 == 0) goto L_0x01cf
            android.content.Context r10 = r9.getContext()
            com.freshchat.consumer.sdk.service.a.a r10 = com.freshchat.consumer.sdk.service.a.c.m(r10, r2)
            if (r10 == 0) goto L_0x01cf
            java.lang.String r0 = r10.dr()
            boolean r0 = com.freshchat.consumer.sdk.j.as.a(r0)
            if (r0 == 0) goto L_0x01cf
            goto L_0x018a
        L_0x01cf:
            com.freshchat.consumer.sdk.service.e.h r10 = new com.freshchat.consumer.sdk.service.e.h
            r10.<init>(r1)
            return r10
        L_0x01d5:
            r3 = move-exception
            r1 = r5
        L_0x01d7:
            if (r1 != 0) goto L_0x0209
            boolean r10 = r0.bV()
            if (r10 == 0) goto L_0x0210
            android.content.Context r10 = r9.getContext()
            boolean r10 = com.freshchat.consumer.sdk.service.a.c.t(r10)
            if (r10 == 0) goto L_0x0210
            android.content.Context r10 = r9.getContext()
            com.freshchat.consumer.sdk.service.a.a r10 = com.freshchat.consumer.sdk.service.a.c.m(r10, r2)
            if (r10 == 0) goto L_0x0210
            java.lang.String r0 = r10.dr()
            boolean r0 = com.freshchat.consumer.sdk.j.as.a(r0)
            if (r0 == 0) goto L_0x0210
            android.content.Context r0 = r9.getContext()
            java.lang.String r10 = r10.dr()
            com.freshchat.consumer.sdk.j.aa.l(r0, r10)
            goto L_0x0210
        L_0x0209:
            android.content.Context r0 = r9.getContext()
            a(r0, r10)
        L_0x0210:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.service.c.c.b(com.freshchat.consumer.sdk.service.e.a):com.freshchat.consumer.sdk.service.e.k");
    }
}
