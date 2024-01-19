package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.AuthError.ERROR_TYPE;
import com.amazon.identity.auth.device.api.authorization.AuthorizationManager;
import com.amazon.identity.auth.device.api.authorization.AuthorizeRequest;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import in.juspay.hypersdk.core.PaymentConstants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* renamed from: aa  reason: default package */
public class aa extends n {

    /* renamed from: a  reason: collision with root package name */
    public ac f2691a;

    /* renamed from: a  reason: collision with other field name */
    public r f11a;

    public aa() {
        ac acVar = new ac();
        if (r.f3326a == null) {
            r.f3326a = new r();
        }
        this.f11a = r.f3326a;
        this.f2691a = acVar;
    }

    public final Bundle a(Bundle bundle) throws AuthError {
        Bundle bundle2;
        if (bundle.getBoolean(ch$b.GET_AUTH_CODE.f89a, false)) {
            String string = bundle.getString(ch$b.CODE_CHALLENGE.f89a);
            String string2 = bundle.getString(ch$b.CODE_CHALLENGE_METHOD.f89a);
            if (!TextUtils.isEmpty(string)) {
                bundle2 = new Bundle();
                bundle2.putString("code_challenge", string);
                bundle2.putString("code_challenge_method", string2);
            } else {
                throw new AuthError("Must provide code challenge parameter.", ERROR_TYPE.ERROR_MISSING_CODE_CHALLENGE);
            }
        } else {
            r rVar = this.f11a;
            if (rVar != null) {
                byte[] bArr = new byte[32];
                new SecureRandom().nextBytes(bArr);
                String encodeToString = Base64.encodeToString(bArr, 11);
                rVar.f3327b = encodeToString;
                try {
                    rVar.f3328c = "S256";
                    rVar.f3329d = Base64.encodeToString(MessageDigest.getInstance("SHA-256").digest(encodeToString.getBytes()), 11);
                } catch (NoSuchAlgorithmException e2) {
                    cp.a((String) "r", (String) "Error generating Proof Key parmeter", (Throwable) e2);
                    rVar.f3328c = "plain";
                    rVar.f3329d = rVar.f3327b;
                }
                bundle2 = new Bundle();
                bundle2.putString("code_challenge_method", rVar.f3328c);
                bundle2.putString("code_challenge", rVar.f3329d);
            } else {
                throw null;
            }
        }
        if (bundle.getString(ch$b.SCOPE_DATA.f89a) != null) {
            bundle2.putString("scope_data", bundle.getString(ch$b.SCOPE_DATA.f89a));
        }
        bundle2.putString(PaymentConstants.CLIENT_ID, bundle.getString(ch$b.CLIENT_ID.f89a));
        return bundle2;
    }

    public void a(AuthorizeRequest authorizeRequest, Context context, String str, String str2, String str3, String[] strArr, boolean z, bi biVar, ae aeVar, Bundle bundle) throws AuthError {
        Context context2 = context;
        String str4 = str2;
        final ae aeVar2 = aeVar;
        Bundle bundle2 = bundle;
        if (!ca.a()) {
            final ag a2 = new j().a(str, context2);
            if (biVar != null) {
                List a3 = aq.a(context).a((String[]) null, (String[]) null);
                List asList = Arrays.asList(strArr);
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(asList);
                ArrayList arrayList2 = (ArrayList) a3;
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    String str5 = ((ak) it.next()).f50b;
                    if (!arrayList.contains(str5)) {
                        arrayList.add(str5);
                    }
                }
                final String[] strArr2 = (String[]) arrayList.toArray(new String[arrayList.size()]);
                final boolean z2 = bundle2.getBoolean(ch$b.SANDBOX.f89a, false);
                if (bundle2 == Bundle.EMPTY) {
                    bundle2 = new Bundle();
                }
                final Bundle bundle3 = bundle2;
                bundle3.putBoolean(ch$b.CHECK_API_KEY.f89a, false);
                bundle3.putBoolean(ch$b.RETURN_CODE.f89a, true);
                bundle3.putString(ch$a.REGION.f87a, AuthorizationManager.getRegion(context).getStringValue());
                bundle3.putString(ch$b.CLIENT_ID.f89a, str4);
                bundle3.putString(ch$b.SDK_VERSION.f89a, "LWAAndroidSDK3.0.1");
                try {
                    bundle3.putBundle(ch$b.EXTRA_URL_PARAMS.f89a, a(bundle3));
                    Bundle bundle4 = Bundle.EMPTY;
                    if (!z2 && (context2.getSharedPreferences("com.amazon.lwa.LWASharedPreferences", 0).getBoolean("com.amazon.lwa.isTokenObtainedFromSSO", false) || arrayList2.size() == 0)) {
                        bundle4 = (Bundle) new ci<Bundle>(this) {
                            public Object a(Context context, k kVar) throws AuthError, RemoteException {
                                Bundle a2 = kVar.a(bundle3, context.getPackageName(), strArr2);
                                if (a2 != null) {
                                    a2.setClassLoader(context.getClassLoader());
                                }
                                return a2;
                            }
                        }.a(context2, this.f2691a);
                        if (bundle4 == null) {
                            bundle4 = new Bundle();
                        }
                    }
                    Bundle bundle5 = bundle4;
                    if (!bundle5.containsKey("code") || TextUtils.isEmpty(bundle5.getString("code"))) {
                        if (bundle5.containsKey(AuthError.AUTH_ERROR_EXECEPTION) || bundle5.containsKey(ch$b.AUTHORIZE.f89a) || bundle5.containsKey(ch$b.CAUSE_ID.f89a)) {
                            bundle5.setClassLoader(context.getClassLoader());
                            if (bundle5.containsKey(ch$b.CAUSE_ID.f89a)) {
                                aeVar2.a(bundle5);
                            } else if (bundle5.containsKey(AuthError.AUTH_ERROR_EXECEPTION)) {
                                aeVar2.onError(AuthError.extractError(bundle5));
                            } else {
                                ao.a(context);
                                Bundle bundle6 = new Bundle();
                                bundle6.putString(ch$b.AUTHORIZE.f89a, "authorized via service");
                                aeVar2.onSuccess(bundle6);
                            }
                        } else {
                            ap.a(context).a();
                            Handler handler = new Handler(Looper.getMainLooper());
                            final boolean z3 = z;
                            final AuthorizeRequest authorizeRequest2 = authorizeRequest;
                            final Context context3 = context;
                            final String str6 = str2;
                            final ae aeVar3 = aeVar;
                            AnonymousClass1 r1 = new Runnable() {
                                public void run() {
                                    try {
                                        if (!z3) {
                                            if (!z2) {
                                                aeVar3.onError(new AuthError("WebView is not allowed for Authorization", ERROR_TYPE.ERROR_BAD_PARAM));
                                                return;
                                            }
                                        }
                                        aa aaVar = aa.this;
                                        AuthorizeRequest authorizeRequest = authorizeRequest2;
                                        Context context = context3;
                                        String str = str6;
                                        String[] strArr = strArr2;
                                        ae aeVar = aeVar3;
                                        Bundle bundle = bundle3;
                                        ag agVar = a2;
                                        if (aaVar != null) {
                                            bundle.getBundle(ch$b.EXTRA_URL_PARAMS.f89a).remove(PaymentConstants.CLIENT_ID);
                                            o oVar = new o(authorizeRequest, str, strArr, bundle, agVar, aeVar);
                                            e.a(context).a(oVar, context);
                                            TweetUtils.a(context3, false);
                                            return;
                                        }
                                        throw null;
                                    } catch (AuthError e2) {
                                        aeVar3.onError(e2);
                                    }
                                }
                            };
                            handler.post(r1);
                        }
                    } else if (bundle3.getBoolean(ch$b.GET_AUTH_CODE.f89a, false)) {
                        n.a(bundle5.getString("code"), str4, str3, aeVar2);
                    } else {
                        a(context, str, this.f11a.f3327b, bundle5, false, null, new bi(), new j(), bundle3, new ae(this) {
                            /* renamed from: a */
                            public void onCancel(Bundle bundle) {
                                cp.d("aa", "Code for Token Exchange Cancel");
                                ae aeVar = aeVar2;
                                if (aeVar != null) {
                                    aeVar.a(bundle);
                                }
                            }

                            public void onError(AuthError authError) {
                                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Code for Token Exchange Error. ");
                                outline73.append(authError.getMessage());
                                cp.b("aa", outline73.toString());
                                ae aeVar = aeVar2;
                                if (aeVar != null) {
                                    aeVar.onError(authError);
                                }
                            }

                            public void onSuccess(Bundle bundle) {
                                cp.c("aa", "Code for Token Exchange success");
                                ae aeVar = aeVar2;
                                if (aeVar != null) {
                                    aeVar.onSuccess(bundle);
                                }
                            }
                        });
                        TweetUtils.a(context2, true);
                    }
                } catch (AuthError e2) {
                    aeVar2.onError(e2);
                }
            } else {
                throw null;
            }
        } else {
            cp.b("aa", "authorize started on main thread");
            throw new IllegalStateException("authorize started on main thread");
        }
    }
}
