package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.amazon.identity.auth.device.AuthError;
import com.android.tools.r8.GeneratedOutlineSupport;
import sfs2x.client.requests.mmo.SetUserPositionRequest;

/* renamed from: q  reason: default package */
public final class q {
    public static void a(Context context, Uri uri, String[] strArr, boolean z, ae aeVar) {
        final ae aeVar2 = aeVar;
        p pVar = new p();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("response=");
        outline73.append(uri.toString());
        cp.a((String) SetUserPositionRequest.KEY_PLUS_ITEM_LIST, (String) "Received response from WebBroswer for OAuth2 flow", outline73.toString());
        Uri uri2 = uri;
        String[] strArr2 = strArr;
        try {
            Bundle a2 = pVar.a(uri, strArr);
            if (a2.containsKey(ch$b.CAUSE_ID.f89a)) {
                aeVar2.a(a2);
            } else if (a2.getBoolean(ch$b.GET_AUTH_CODE.f89a, false)) {
                Context context2 = context;
                n.a(a2.getString("code"), t.a(context).f3333b, t.a(context).a(context), aeVar2);
            } else {
                Context context3 = context;
                Bundle bundle = new Bundle();
                bundle.putBoolean(ch$a.RETURN_ACCESS_TOKEN.f87a, z);
                n nVar = new n();
                if (r.f3326a == null) {
                    r.f3326a = new r();
                }
                Context context4 = context;
                nVar.a(context4, context.getPackageName(), r.f3326a.f3327b, a2, false, null, new bi(), new j(), bundle, new ae() {
                    /* renamed from: a */
                    public void onCancel(Bundle bundle) {
                        cp.d(SetUserPositionRequest.KEY_PLUS_ITEM_LIST, "Code for Token Exchange Cancel");
                        ae aeVar = aeVar2;
                        if (aeVar != null) {
                            aeVar.a(bundle);
                        }
                    }

                    public void onError(AuthError authError) {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Code for Token Exchange Error. ");
                        outline73.append(authError.getMessage());
                        cp.d(SetUserPositionRequest.KEY_PLUS_ITEM_LIST, outline73.toString());
                        ae aeVar = aeVar2;
                        if (aeVar != null) {
                            aeVar.onError(authError);
                        }
                    }

                    public void onSuccess(Bundle bundle) {
                        cp.d(SetUserPositionRequest.KEY_PLUS_ITEM_LIST, "Code for Token Exchange success");
                        ae aeVar = aeVar2;
                        if (aeVar != null) {
                            aeVar.onSuccess(bundle);
                        }
                    }
                });
            }
        } catch (AuthError e2) {
            if (aeVar2 != null) {
                aeVar2.onError(e2);
            }
        }
    }
}
