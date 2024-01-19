package c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.widget.CompoundButtonCompat;
import com.amazon.apay.hardened.external.model.APayError;
import com.amazon.apay.hardened.external.model.APayError.ErrorType;
import com.amazon.apay.hardened.external.model.APayRequestContext;
import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.List;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;
import timber.log.Timber;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f2809b;

    /* renamed from: a  reason: collision with root package name */
    public b f2810a;

    public interface b {
        void a(String str, APayRequestContext aPayRequestContext) throws APayError;
    }

    public static class c implements b {
        public void a(String str, APayRequestContext aPayRequestContext) throws APayError {
            CompoundButtonCompat.a("CustomTabInvoked");
            try {
                Context context = aPayRequestContext.getContext();
                CustomTabsIntent customTabsIntent = aPayRequestContext.getCustomTabsIntent();
                customTabsIntent.intent.setPackage("com.android.chrome");
                a.a(customTabsIntent.intent);
                customTabsIntent.launchUrl(context, Uri.parse(str));
            } catch (NoSuchMethodError e2) {
                throw new APayError(ErrorType.BROWSING_EXPERIENCE, "CustomTabNoSuchMethodError", "The current version of chrome custom tabs being used by your application is not compatible with the sdk. Please use version 25+.", e2);
            } catch (Exception e3) {
                Timber.TREE_OF_SOULS.e(e3, "Unable to launch url on custom tab: %s", e3.getMessage());
                throw new APayError(ErrorType.BROWSING_EXPERIENCE, "CustomTabError", "Unable to launch url on custom tab.", e3);
            }
        }

        public static /* synthetic */ boolean a(Context context) {
            Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
            intent.setPackage("com.android.chrome");
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices == null || queryIntentServices.size() <= 0) {
                return false;
            }
            return true;
        }
    }

    public static class d implements b {
        public void a(String str, APayRequestContext aPayRequestContext) throws APayError {
            CompoundButtonCompat.a("ExternalBrowserInvoked");
            try {
                Context context = aPayRequestContext.getContext();
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
                intent.addFlags(1073741824);
                intent.putExtra("com.android.browser.application_id", context.getPackageName() + ".amazon.apay");
                a.a(intent);
                context.startActivity(intent);
            } catch (Exception e2) {
                Timber.TREE_OF_SOULS.e(e2, "Unable to launch url on browser: %s", e2.getMessage());
                throw new APayError(ErrorType.BROWSING_EXPERIENCE, "ExternalBrowserError", "Unable to launch url on browser.", e2);
            }
        }
    }

    public a(b bVar) {
        this.f2810a = bVar;
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f2809b == null) {
                if (c.a(context)) {
                    CompoundButtonCompat.a("ChromeCustomTabsSupported");
                    f2809b = new a(new c());
                } else {
                    CompoundButtonCompat.a("ChromeCustomTabsNotSupported");
                    f2809b = new a(new d());
                }
            }
            aVar = f2809b;
        }
        return aVar;
    }

    public boolean a(APayRequestContext aPayRequestContext, String str) throws APayError {
        if (aPayRequestContext.getCustomTabsIntent() == null || !c.a(aPayRequestContext.getContext())) {
            this.f2810a = new d();
        } else if (!(this.f2810a instanceof c)) {
            this.f2810a = new c();
        }
        try {
            this.f2810a.a(str, aPayRequestContext);
            CompoundButtonCompat.a("OpenUrlSuccess");
            return this.f2810a instanceof c;
        } catch (APayError e2) {
            if (this.f2810a instanceof c) {
                Timber.TREE_OF_SOULS.w(e2, "Error while opening chrome custom tab, proceeding in device browser.", new Object[0]);
                CompoundButtonCompat.a("ExternalBrowserFallback");
                CompoundButtonCompat.a("ExternalBrowserInvoked");
                try {
                    Context context = aPayRequestContext.getContext();
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
                    intent.addFlags(1073741824);
                    intent.putExtra("com.android.browser.application_id", context.getPackageName() + ".amazon.apay");
                    a(intent);
                    context.startActivity(intent);
                    return false;
                } catch (Exception e3) {
                    Timber.TREE_OF_SOULS.e(e3, "Unable to launch url on browser: %s", e3.getMessage());
                    throw new APayError(ErrorType.BROWSING_EXPERIENCE, "ExternalBrowserError", "Unable to launch url on browser.", e3);
                }
            } else {
                throw e2;
            }
        }
    }

    public static /* synthetic */ void a(Intent intent) {
        Bundle outline14 = GeneratedOutlineSupport.outline14("x-amz-sdk-version", "H.1.0.3");
        outline14.putString("x-amz-sdk-request-id", CompoundButtonCompat.b("operationId"));
        outline14.putString("x-amz-sdk-client-id", CompoundButtonCompat.b(PaymentConstants.CLIENT_ID_CAMEL));
        intent.putExtra("com.android.browser.headers", outline14);
    }
}
