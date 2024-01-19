package defpackage;

import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.AuthError.ERROR_TYPE;
import com.amazon.identity.auth.device.shared.APIListener;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: ad  reason: default package */
public final class ad {

    /* renamed from: a  reason: collision with root package name */
    public static bi f2701a = new bi();

    public static String a(Context context, final String str, final String[] strArr, ag agVar, Bundle bundle) throws AuthError {
        try {
            String a2 = f2701a.a(null, strArr, context, bundle, agVar);
            if (a2 == null) {
                a2 = (String) new ci<String>() {
                    /* JADX WARNING: CFG modification limit reached, blocks count: 125 */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public java.lang.Object a(android.content.Context r5, defpackage.k r6) throws com.amazon.identity.auth.device.AuthError, android.os.RemoteException {
                        /*
                            r4 = this;
                            java.lang.String[] r0 = r9
                            java.lang.String r1 = r8
                            defpackage.ao.a(r5)
                            ap r2 = defpackage.ap.a(r5)
                            r2.a()
                            r2 = 0
                            android.os.Bundle r6 = r6.b(r2, r1, r0)
                            if (r6 == 0) goto L_0x005e
                            java.lang.ClassLoader r0 = r5.getClassLoader()
                            r6.setClassLoader(r0)
                            java.lang.String r0 = "accessAtzToken"
                            java.lang.String r0 = r6.getString(r0)
                            boolean r1 = android.text.TextUtils.isEmpty(r0)
                            if (r1 != 0) goto L_0x002a
                            r2 = r0
                            goto L_0x005e
                        L_0x002a:
                            java.lang.String r0 = "AUTH_ERROR_EXECEPTION"
                            android.os.Parcelable r6 = r6.getParcelable(r0)
                            com.amazon.identity.auth.device.AuthError r6 = (com.amazon.identity.auth.device.AuthError) r6
                            if (r6 == 0) goto L_0x005e
                            com.amazon.identity.auth.device.AuthError$ERROR_TYPE r0 = com.amazon.identity.auth.device.AuthError.ERROR_TYPE.ERROR_INVALID_TOKEN
                            com.amazon.identity.auth.device.AuthError$ERROR_TYPE r1 = r6.getType()
                            if (r0 != r1) goto L_0x0044
                            ap r5 = defpackage.ap.a(r5)
                            r5.a()
                            goto L_0x005e
                        L_0x0044:
                            r6.getMessage()
                            java.lang.Object r0 = defpackage.ac.f2697a
                            monitor-enter(r0)
                            ac$b r1 = defpackage.ac.a.f24a     // Catch:{ all -> 0x005c }
                            if (r1 == 0) goto L_0x0058
                            ab r3 = r1.f2700a     // Catch:{ all -> 0x005c }
                            android.content.Intent r1 = r1.f25a     // Catch:{ all -> 0x005c }
                            defpackage.ac.a(r5, r3, r1)     // Catch:{ all -> 0x005c }
                            defpackage.ac.a.a(r2)     // Catch:{ all -> 0x005c }
                        L_0x0058:
                            monitor-exit(r0)     // Catch:{ all -> 0x005c }
                            throw r6
                        L_0x005a:
                            monitor-exit(r0)     // Catch:{ all -> 0x005c }
                            throw r5
                        L_0x005c:
                            r5 = move-exception
                            goto L_0x005a
                        L_0x005e:
                            return r2
                        */
                        throw new UnsupportedOperationException("Method not decompiled: defpackage.ad.AnonymousClass1.a(android.content.Context, k):java.lang.Object");
                    }
                }.a(context, new ac());
            }
            cp.a((String) "ad", (String) "GetToken", " appid=" + agVar.f2705b + " atzToken=" + a2);
            return a2;
        } catch (IOException e2) {
            cp.a((String) "ad", e2.getMessage(), (Throwable) e2);
            throw new AuthError("Error communicating with server", e2, ERROR_TYPE.ERROR_IO);
        }
    }

    public static void a(Context context, ag agVar, Bundle bundle) throws AuthError {
        try {
            f2701a.a(context, agVar);
        } catch (IOException e2) {
            cp.a((String) "ad", e2.getMessage(), (Throwable) e2);
            throw new AuthError(e2.getMessage(), ERROR_TYPE.ERROR_IO);
        }
    }

    public static void a(Context context, String str, String str2, String[] strArr, APIListener aPIListener, j jVar, Bundle bundle) throws AuthError {
        Bundle bundle2;
        StringBuilder outline82 = GeneratedOutlineSupport.outline82("clientId=", str2, "GetToken pkg=", str, " scopes=");
        outline82.append(Arrays.toString(strArr));
        cp.c("ad", outline82.toString());
        ag a2 = jVar.a(str, context);
        if (a2 == null) {
            aPIListener.onError(new AuthError(GeneratedOutlineSupport.outline50("APIKey info is unavailable for ", str), null, ERROR_TYPE.ERROR_ACCESS_DENIED));
            return;
        }
        try {
            String a3 = a(context, str, strArr, a2, bundle);
            if (a3 == null) {
                bundle2 = new Bundle();
            } else {
                String str3 = ch$b.TOKEN.f89a;
                Bundle bundle3 = new Bundle();
                bundle3.putString(str3, a3);
                bundle2 = bundle3;
            }
            aPIListener.onSuccess(bundle2);
        } catch (AuthError e2) {
            aPIListener.onError(e2);
        }
    }
}
