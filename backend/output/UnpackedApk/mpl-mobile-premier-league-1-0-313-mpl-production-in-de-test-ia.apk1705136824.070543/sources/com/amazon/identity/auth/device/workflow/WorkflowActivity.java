package com.amazon.identity.auth.device.workflow;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.AuthError.ERROR_TYPE;
import com.amazon.identity.auth.device.api.workflow.RequestContext;
import com.inca.security.Proxy.iIiIiIiIii;

@SuppressLint({"Registered"})
public final class WorkflowActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3297a = WorkflowActivity.class.getName();

    /* access modifiers changed from: 0000 */
    public RequestContext a(String str) throws AuthError {
        a aVar = e.a((Context) this).f128a.get(str);
        if (aVar != null) {
            return aVar.f4a.getRequestContext();
        }
        throw new AuthError(String.format("Could not find request id: %s in active requests", new Object[]{str}), ERROR_TYPE.ERROR_UNKNOWN);
    }

    /* access modifiers changed from: 0000 */
    public void a(Intent intent) {
        if (intent != null) {
            intent.setFlags(603979776);
            startActivity(intent);
        }
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, 792564195, bundle);
    }

    public static void a(Uri uri, Activity activity, String str, String str2) {
        if (uri == null) {
            cp.c(str2, "uri is null onCreate - closing activity");
            return;
        }
        try {
            if (e.a(uri)) {
                cp.a(str2, (String) "Receiving response for interactive request");
                f.a().a(str, uri);
                return;
            }
            cp.a(str2, (String) "Receiving response for auth request");
            if (!e.a(activity.getApplicationContext()).a(uri, activity.getApplicationContext(), null)) {
                cp.a(str2, (String) "Could not find active request for redirect URI", uri.toString());
            }
        } catch (AuthError e2) {
            cp.a(str2, "Could not handle response URI", uri.toString(), e2);
        }
    }
}
