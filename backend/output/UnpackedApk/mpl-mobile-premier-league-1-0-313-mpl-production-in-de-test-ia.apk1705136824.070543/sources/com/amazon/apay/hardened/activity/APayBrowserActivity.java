package com.amazon.apay.hardened.activity;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.CompoundButtonCompat;
import androidx.fragment.app.FragmentActivity;
import com.amazon.apay.hardened.R;
import com.amazon.apay.hardened.external.AmazonPayManager;
import com.amazon.apay.hardened.external.model.APayAuthResponse.Status;
import com.amazon.apay.hardened.external.model.APayError;
import com.amazon.apay.hardened.external.model.APayError.ErrorType;
import com.amazon.apay.hardened.external.model.APayRequestContext;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.api.authorization.AuthCancellation;
import com.amazon.identity.auth.device.api.authorization.AuthCancellation.Cause;
import com.amazon.identity.auth.device.api.authorization.AuthorizationManager;
import com.amazon.identity.auth.device.api.authorization.AuthorizeListener;
import com.amazon.identity.auth.device.api.authorization.AuthorizeRequest;
import com.amazon.identity.auth.device.api.authorization.AuthorizeRequest.Builder;
import com.amazon.identity.auth.device.api.authorization.AuthorizeRequest.GrantType;
import com.amazon.identity.auth.device.api.authorization.AuthorizeResult;
import com.amazon.identity.auth.device.api.workflow.RequestContext;
import com.google.android.gms.security.ProviderInstaller.ProviderInstallListener;
import com.inca.security.Proxy.iIiIiIiIii;
import in.juspay.hypersdk.core.PaymentConstants;
import timber.log.Timber;

public class APayBrowserActivity extends AppCompatActivity implements ProviderInstallListener {

    /* renamed from: a  reason: collision with root package name */
    public f.a f3235a;

    /* renamed from: b  reason: collision with root package name */
    public RequestContext f3236b;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            try {
                c.a.a((Context) APayBrowserActivity.this).a(APayRequestContext.create(APayBrowserActivity.this, CompoundButtonCompat.b(PaymentConstants.CLIENT_ID_CAMEL), AmazonPayManager.customTabsIntent), APayBrowserActivity.this.f3235a.f5008d);
            } catch (APayError e2) {
                CompoundButtonCompat.a("PAYMENT_FAILURE");
                APayBrowserActivity.this.a(ErrorType.BROWSING_EXPERIENCE, "START_BROWSING_ERROR", e2.getMessage(), e2);
                APayBrowserActivity.this.finish();
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f3238a;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                if (APayBrowserActivity.this.c()) {
                    b bVar = b.this;
                    APayBrowserActivity.this.a(ErrorType.AUTH_ERROR, bVar.f3238a, "Operation cancelled", null);
                } else {
                    b bVar2 = b.this;
                    APayBrowserActivity.this.a(ErrorType.PAYMENT_ERROR, bVar2.f3238a, "Operation cancelled", null);
                }
                APayBrowserActivity.this.finish();
            }
        }

        public b(String str) {
            this.f3238a = str;
        }

        public void run() {
            APayBrowserActivity.a(APayBrowserActivity.this);
            new Handler().postDelayed(new a(), 1000);
        }
    }

    public final class c extends AuthorizeListener {
        public c() {
        }

        public void onCancel(AuthCancellation authCancellation) {
            Timber.TREE_OF_SOULS.i("LWAAuthorizeListener: onCancel called %s", authCancellation.toString());
            CompoundButtonCompat.a("AuthCancelled");
            if (authCancellation.getCause() == Cause.FAILED_AUTHENTICATION) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("AUTH_STATUS", Status.DENIED);
                intent.putExtras(bundle);
                APayBrowserActivity.this.a(intent, -1);
                return;
            }
            APayBrowserActivity.this.a((String) "OPERATION_CANCELLED");
        }

        public void onError(AuthError authError) {
            Timber.TREE_OF_SOULS.e(authError, "LWAAuthorizeListener:onError invoked", new Object[0]);
            CompoundButtonCompat.a("AuthError");
            APayBrowserActivity.this.a(ErrorType.AUTH_ERROR, "START_BROWSING_ERROR", authError.getMessage(), authError);
        }

        public void onSuccess(AuthorizeResult authorizeResult) {
            Timber.TREE_OF_SOULS.i("LWAAuthorizeListener:onSuccess invoked: %s", authorizeResult);
            CompoundButtonCompat.a("AuthSuccess");
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("AUTH_STATUS", Status.GRANTED);
            bundle.putSerializable("authCode", authorizeResult.getAuthorizationCode());
            bundle.putSerializable("lwaClientId", authorizeResult.getClientId());
            bundle.putSerializable("redirectUri", authorizeResult.getRedirectURI());
            intent.putExtras(bundle);
            intent.putExtras(bundle);
            APayBrowserActivity.this.a(intent, -1);
            APayBrowserActivity.this.finish();
        }
    }

    public final boolean c() {
        b.c cVar = this.f3235a.f5005a;
        return cVar != null && (cVar.equals(b.c.GET_AUTHORIZATION_INTENT) || this.f3235a.f5005a.equals(b.c.AUTHORIZE));
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, -8428929, bundle);
    }

    public void onDestroy() {
        iIiIiIiIii.IiiiIiiiII(this, 338198606, new Object[0]);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Timber.TREE_OF_SOULS.d("ApayBrowserActivity:onNewIntent invoked", new Object[0]);
        setIntent(intent);
        this.f3235a.g = true;
    }

    public void onProviderInstallFailed(int i, Intent intent) {
    }

    public void onProviderInstalled() {
    }

    public void onResume() {
        iIiIiIiIii.IiiiIiiiII(this, 896626920, new Object[0]);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        CompoundButtonCompat.a("SaveStateSuccess");
        Timber.TREE_OF_SOULS.i("APayBrowserActivity:onSaveInstanceState invoked for operation: %s", this.f3235a.f5005a);
        bundle.putBoolean("HAS_BROWSER_LAUNCHED", this.f3235a.f5010f);
        bundle.putBoolean("HAS_ON_NEW_INTENT_CALLED", this.f3235a.g);
        bundle.putParcelable("COMPLETION_INTENT", this.f3235a.f5006b);
        bundle.putParcelable("CANCEL_INTENT", this.f3235a.f5007c);
        bundle.putSerializable("operation", this.f3235a.f5005a);
        bundle.putSerializable("PAY_URL", this.f3235a.f5008d);
        bundle.putSerializable("codeChallenge", this.f3235a.f5009e);
    }

    public void b() {
        new Handler().postDelayed(new a(), 200);
    }

    public final void a(Bundle bundle) {
        if (bundle != null) {
            CompoundButtonCompat.a("ExtractStateSuccess");
            Timber.TREE_OF_SOULS.i("APayBrowserActivity:extractState invoked for operation: %s", this.f3235a.f5005a);
            this.f3235a.f5005a = (b.c) bundle.getSerializable("operation");
            this.f3235a.f5006b = (PendingIntent) bundle.getParcelable("COMPLETION_INTENT");
            this.f3235a.f5007c = (PendingIntent) bundle.getParcelable("CANCEL_INTENT");
            this.f3235a.f5010f = bundle.getBoolean("HAS_BROWSER_LAUNCHED", false);
            this.f3235a.g = bundle.getBoolean("HAS_ON_NEW_INTENT_CALLED", false);
            this.f3235a.f5009e = bundle.getString("codeChallenge");
            if (bundle.containsKey("PAY_URL")) {
                this.f3235a.f5008d = bundle.getString("PAY_URL");
                Timber.TREE_OF_SOULS.i("extractState: with payUrl : %s", this.f3235a.f5008d);
            }
        }
    }

    public final void a(String str) {
        runOnUiThread(new b(str));
    }

    public static /* synthetic */ void a(APayBrowserActivity aPayBrowserActivity) {
        if (aPayBrowserActivity.c()) {
            ((TextView) aPayBrowserActivity.findViewById(R.id.loading_text)).setText("Canceling your Amazon Pay authorization");
        } else {
            ((TextView) aPayBrowserActivity.findViewById(R.id.loading_text)).setText("Canceling your Amazon Pay transaction");
        }
    }

    public final void a(Intent intent, int i) {
        Timber.TREE_OF_SOULS.i("ApayBrowserActivity:handleOperationComplete invoked with data : %s", intent.toString());
        f.a aVar = this.f3235a;
        PendingIntent pendingIntent = aVar.f5006b;
        if (i == 0) {
            PendingIntent pendingIntent2 = aVar.f5007c;
            if (pendingIntent2 != null) {
                pendingIntent = pendingIntent2;
            }
            CompoundButtonCompat.a("OperationCancelled");
        } else {
            CompoundButtonCompat.a("OperationCompleted");
        }
        if (pendingIntent != null) {
            try {
                Timber.TREE_OF_SOULS.d("Sending data through PendingIntent: %s", Integer.valueOf(i));
                pendingIntent.send(this, i, intent);
            } catch (CanceledException e2) {
                Timber.TREE_OF_SOULS.e(e2, "Error sending results through PendingIntent", new Object[0]);
            }
        } else {
            Timber.TREE_OF_SOULS.d("Sending data through onActivityResult: %s", Integer.valueOf(i));
            setResult(i, intent);
        }
        finish();
    }

    public void a() {
        Timber.TREE_OF_SOULS.i("ApayBrowserActivity:initAuthorize invoked", new Object[0]);
        CompoundButtonCompat.a("AuthInitialize");
        RequestContext create = RequestContext.create((FragmentActivity) this, getIntent(), AmazonPayManager.customTabsIntent);
        this.f3236b = create;
        create.registerListener(new c());
        AuthorizeRequest build = new Builder(this.f3236b).addScopes(b.a.f2771b).shouldReturnUserData(false).forGrantType(GrantType.AUTHORIZATION_CODE).withProofKeyParameters(this.f3235a.f5009e, "S256").build();
        AuthorizationManager.setRegion(this, b.a.f2770a);
        AuthorizationManager.authorize(build);
    }

    public final void a(ErrorType errorType, String str, String str2, Exception exc) {
        Timber.TREE_OF_SOULS.e(exc, "ApayBrowserActivity:handleError invoked with error: %s", str);
        CompoundButtonCompat.a(str);
        a(new APayError(errorType, str, str2, exc).getApayErrorIntent(), 0);
    }
}
