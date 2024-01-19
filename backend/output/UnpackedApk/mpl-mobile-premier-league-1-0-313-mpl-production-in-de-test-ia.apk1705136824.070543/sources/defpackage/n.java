package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.AuthError.ERROR_TYPE;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import com.xiaomi.mipush.sdk.Constants;
import in.juspay.hypersdk.core.InflateView;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.core.PaymentConstants.ENVIRONMENT;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Executor;
import org.apache.fontbox.cmap.CMap;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: n  reason: default package */
public class n {
    public static String a(Context context, String str, String str2, String[] strArr, String str3, boolean z, boolean z2, Bundle bundle) {
        String outline50;
        String str4;
        String str5;
        StringBuffer stringBuffer = new StringBuffer(ColorPropConverter.PREFIX_ATTR);
        cp.a((String) "n", (String) "Generating Redirect URI", "rediectUri=" + outline50);
        stringBuffer.append(a("response_type", "code"));
        stringBuffer.append("&");
        stringBuffer.append(a("redirect_uri", outline50));
        if (str2 != null) {
            stringBuffer.append("&");
            stringBuffer.append(a(PaymentConstants.CLIENT_ID, str2));
        }
        stringBuffer.append("&");
        if (z) {
            stringBuffer.append(a("amzn_respectRmrMeAuthState", "1"));
            stringBuffer.append("&");
            stringBuffer.append(a("amzn_showRmrMe", "1"));
            stringBuffer.append("&");
            stringBuffer.append(a("amzn_rmrMeDefaultSelected", "1"));
            stringBuffer.append("&");
        }
        if (z2) {
            stringBuffer.append(a("skipSignIn", "1"));
            stringBuffer.append("&");
        }
        if (bundle.getBoolean(ch$b.SANDBOX.f89a, false)) {
            stringBuffer.append(a(ENVIRONMENT.SANDBOX, BaseParser.TRUE));
            stringBuffer.append("&");
        }
        if (str2 == null) {
            str2 = str3;
        }
        boolean z3 = bundle.getBoolean(ch$b.GET_AUTH_CODE.f89a, false);
        StringBuilder sb = new StringBuilder();
        sb.append("clientId=" + str2 + "&");
        sb.append("redirectUri=" + outline50 + "&");
        sb.append("clientRequestId=" + str3 + "&");
        if (bundle.containsKey("InteractiveRequestType")) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("InteractiveRequestType=");
            outline73.append(bundle.getString("InteractiveRequestType"));
            outline73.append("&");
            sb.append(outline73.toString());
        }
        sb.append(ch$b.GET_AUTH_CODE.f89a + InflateView.SETTER_EQUALS + String.valueOf(z3));
        stringBuffer.append(a("state", sb.toString()));
        stringBuffer.append("&");
        stringBuffer.append(a("scope", TextUtils.join(CMap.SPACE, strArr)));
        stringBuffer.append("&");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("package", str);
            for (ce ceVar : ce.values()) {
                jSONObject.put(ceVar.a(), new JSONArray(cl.a(str, ceVar, context)));
            }
            str4 = Base64.encodeToString(jSONObject.toString().getBytes(), 0);
        } catch (JSONException unused) {
            str4 = null;
        }
        stringBuffer.append(a("appIdentifier", str4));
        if (bundle.containsKey(ch$b.SDK_VERSION.f89a) || bundle.containsKey(ch$b.SSO_VERSION.f89a)) {
            stringBuffer.append("&");
            StringBuilder sb2 = new StringBuilder();
            if (bundle.containsKey(ch$b.SDK_VERSION.f89a)) {
                sb2.append(bundle.getString(ch$b.SDK_VERSION.f89a));
                if (bundle.containsKey(ch$b.SSO_VERSION.f89a)) {
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                }
            }
            if (bundle.containsKey(ch$b.SSO_VERSION.f89a)) {
                sb2.append(bundle.getString(ch$b.SSO_VERSION.f89a));
            }
            stringBuffer.append(a("sw_ver", sb2.toString()));
        }
        stringBuffer.append("&");
        Bundle bundle2 = bundle.getBundle(ch$b.EXTRA_URL_PARAMS.f89a);
        if (bundle2 == null) {
            str5 = "";
        } else {
            StringBuilder sb3 = new StringBuilder();
            Iterator it = bundle2.keySet().iterator();
            while (true) {
                boolean z4 = true;
                if (!it.hasNext()) {
                    break;
                }
                String str6 = (String) it.next();
                String string = bundle2.getString(str6);
                ch$b[] values = ch$b.values();
                int length = values.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z4 = false;
                        break;
                    } else if (values[i].f89a.equalsIgnoreCase(str6)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (!z4) {
                    sb3.append(a(str6, string));
                    sb3.append("&");
                }
            }
            if (sb3.length() > 0) {
                sb3.deleteCharAt(sb3.length() - 1);
            }
            str5 = sb3.toString();
        }
        stringBuffer.append(str5);
        return stringBuffer.toString();
    }

    public static String a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("authzParams");
        StringBuffer stringBuffer = new StringBuffer("");
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                stringBuffer.append('&');
                stringBuffer.append(a(str, bundle2.getString(str)));
            }
        }
        return stringBuffer.toString();
    }

    public static String a(String str, String str2) {
        StringBuilder outline77 = GeneratedOutlineSupport.outline77(URLEncoder.encode(str), InflateView.SETTER_EQUALS);
        if (str2 != null) {
            outline77.append(URLEncoder.encode(str2));
        }
        return outline77.toString();
    }

    public static void a(String str, String str2, String str3, ae aeVar) {
        try {
            if (!TextUtils.isEmpty(str)) {
                Bundle bundle = new Bundle();
                bundle.putString(ch$b.AUTHORIZATION_CODE.f89a, str);
                bundle.putString(ch$b.CLIENT_ID.f89a, str2);
                bundle.putString(ch$b.REDIRECT_URI.f89a, str3);
                cp.c("n", "Return auth code success");
                if (aeVar != null) {
                    aeVar.onSuccess(bundle);
                    return;
                }
                return;
            }
            throw new AuthError("Response bundle from Authorization does not contain authorization code", ERROR_TYPE.ERROR_SERVER_REPSONSE);
        } catch (AuthError e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Return auth code error. ");
            outline73.append(e2.getMessage());
            cp.b("n", outline73.toString());
            if (aeVar != null) {
                aeVar.onError(e2);
            }
        }
    }

    public void a(Context context, String str, String str2, Bundle bundle, boolean z, String str3, bi biVar, j jVar, Bundle bundle2, ae aeVar) {
        Executor executor = ca.f81a;
        final Bundle bundle3 = bundle;
        final Context context2 = context;
        final String str4 = str;
        final String str5 = str2;
        final bi biVar2 = biVar;
        final j jVar2 = jVar;
        final boolean z2 = z;
        final Bundle bundle4 = bundle2;
        final ae aeVar2 = aeVar;
        AnonymousClass1 r1 = new Runnable(null) {
            public void run() {
                ae aeVar;
                Bundle a2;
                Bundle bundle = bundle3;
                if (bundle != null) {
                    n nVar = n.this;
                    Context context = context2;
                    String str = str4;
                    String str2 = str5;
                    String str3 = null;
                    bi biVar = biVar2;
                    j jVar = jVar2;
                    boolean z = z2;
                    Bundle bundle2 = bundle4;
                    ae aeVar2 = aeVar2;
                    if (nVar == null) {
                        throw null;
                    } else if (!ca.a()) {
                        String string = bundle.getString("code");
                        if (!TextUtils.isEmpty(string)) {
                            String string2 = bundle.getString(PaymentConstants.CLIENT_ID_CAMEL);
                            String string3 = bundle.getString("redirectUri");
                            String[] stringArray = bundle.getStringArray("scope");
                            ae aeVar3 = aeVar2;
                            String string4 = bundle.getString("responseUrl");
                            String str4 = "responseUrl";
                            StringBuilder outline82 = GeneratedOutlineSupport.outline82("code=", string, "clientId=", string2, " redirectUri=");
                            GeneratedOutlineSupport.outline103(outline82, string3, " directedId=", str3, " scopes=");
                            outline82.append(Arrays.toString(stringArray));
                            cp.a((String) "n", (String) "Params extracted from OAuth2 response", outline82.toString());
                            ag a3 = jVar.a(str, context);
                            if (a3 != null) {
                                try {
                                    a2 = biVar.a(string, str2, string3, stringArray, str3, context, a3, bundle2);
                                    if (z) {
                                        a2.putString(str4, string4);
                                    }
                                    aeVar = aeVar3;
                                } catch (IOException e2) {
                                    e = e2;
                                    aeVar = aeVar3;
                                    aeVar.onError(new AuthError("Failed to exchange code for token", e, ERROR_TYPE.ERROR_IO));
                                } catch (AuthError e3) {
                                    e = e3;
                                    aeVar = aeVar3;
                                    e.getMessage();
                                    aeVar.onError(e);
                                }
                                try {
                                    aeVar.onSuccess(a2);
                                } catch (IOException e4) {
                                    e = e4;
                                } catch (AuthError e5) {
                                    e = e5;
                                    e.getMessage();
                                    aeVar.onError(e);
                                }
                            }
                            aeVar = aeVar3;
                            e = new AuthError("Unable to extract AppInfo", ERROR_TYPE.ERROR_UNKNOWN);
                        } else {
                            aeVar = aeVar2;
                            e = new AuthError("Response bundle from Authorization was empty", ERROR_TYPE.ERROR_SERVER_REPSONSE);
                        }
                        aeVar.onError(e);
                    } else {
                        cp.b("n", "code for token exchange started on main thread");
                        throw new IllegalStateException("authorize started on main thread");
                    }
                } else {
                    aeVar2.onError(new AuthError("Response bundle from Authorization was null", ERROR_TYPE.ERROR_SERVER_REPSONSE));
                }
            }
        };
        executor.execute(r1);
    }
}
