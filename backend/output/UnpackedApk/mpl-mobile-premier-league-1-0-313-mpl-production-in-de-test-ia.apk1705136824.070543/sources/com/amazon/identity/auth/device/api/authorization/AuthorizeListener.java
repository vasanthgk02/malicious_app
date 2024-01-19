package com.amazon.identity.auth.device.api.authorization;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.AuthError.ERROR_TYPE;
import com.amazon.identity.auth.device.api.Listener;
import com.amazon.identity.auth.device.interactive.InteractiveListener;
import com.amazon.identity.auth.device.interactive.InteractiveRequestRecord;

public abstract class AuthorizeListener implements InteractiveListener<AuthorizeResult, AuthCancellation, AuthError> {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3273a = "com.amazon.identity.auth.device.api.authorization.AuthorizeListener";

    public static void a(Context context, final Bundle bundle, final InteractiveListener<AuthorizeResult, AuthCancellation, AuthError> interactiveListener) {
        cp.c(f3273a, "Fetching User as part of authorize request");
        User.fetch(context, new Listener<User, AuthError>() {
            /* renamed from: a */
            public void onError(AuthError authError) {
                interactiveListener.onError(authError);
            }

            /* renamed from: a */
            public void onSuccess(User user) {
                interactiveListener.onSuccess(new AuthorizeResult(bundle, user));
            }
        });
    }

    public static void a(Context context, Bundle bundle, InteractiveListener<AuthorizeResult, AuthCancellation, AuthError> interactiveListener, boolean z) {
        if (bundle.getString(ch$b.AUTHORIZATION_CODE.f89a) != null || !z) {
            interactiveListener.onSuccess(new AuthorizeResult(bundle));
        } else {
            a(context, bundle, interactiveListener);
        }
    }

    public final String getRequestType() {
        return "com.amazon.identity.auth.device.authorization.request.authorize";
    }

    public abstract void onCancel(AuthCancellation authCancellation);

    public abstract void onError(AuthError authError);

    public final void onRequestCancel(Context context, InteractiveRequestRecord interactiveRequestRecord, co coVar) {
        cp.b(f3273a, "Unexpected invocation of onRequestCancel");
    }

    public final void onRequestCompletion(final Context context, InteractiveRequestRecord interactiveRequestRecord, Uri uri) {
        Bundle requestExtras = interactiveRequestRecord.getRequestExtras();
        String[] stringArray = requestExtras.getStringArray("requestedScopes");
        final boolean z = requestExtras.getBoolean("shouldReturnUserData");
        q.a(context, uri, stringArray, true, new ae() {
            /* renamed from: a */
            public void onCancel(Bundle bundle) {
                AuthorizeListener.this.onCancel(new AuthCancellation(bundle));
            }

            public void onError(AuthError authError) {
                AuthorizeListener.this.onError(authError);
            }

            public void onSuccess(Bundle bundle) {
                AuthorizeListener.a(context, bundle, AuthorizeListener.this, z);
            }
        });
    }

    public final void onRequestError(Context context, InteractiveRequestRecord interactiveRequestRecord, Exception exc) {
        if (exc instanceof AuthError) {
            onError((AuthError) exc);
        } else {
            onError(new AuthError("Could not complete the authorization request", exc, ERROR_TYPE.ERROR_UNKNOWN));
        }
    }

    public abstract void onSuccess(AuthorizeResult authorizeResult);
}
