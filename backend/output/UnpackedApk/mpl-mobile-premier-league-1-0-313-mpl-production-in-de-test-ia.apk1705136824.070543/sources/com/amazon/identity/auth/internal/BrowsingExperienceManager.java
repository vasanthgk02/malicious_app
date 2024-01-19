package com.amazon.identity.auth.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.AuthError.ERROR_TYPE;
import com.amazon.identity.auth.device.api.workflow.RequestContext;
import java.util.List;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

public class BrowsingExperienceManager {

    /* renamed from: a  reason: collision with root package name */
    public static BrowsingExperienceManager f3298a = null;

    /* renamed from: a  reason: collision with other field name */
    public static final String f122a = "com.amazon.identity.auth.internal.BrowsingExperienceManager";

    /* renamed from: a  reason: collision with other field name */
    public a f123a;

    public interface a {
        void a(String str, RequestContext requestContext) throws AuthError;
    }

    public static class b implements a {

        /* renamed from: a  reason: collision with root package name */
        public static final String f3299a = "com.amazon.identity.auth.internal.BrowsingExperienceManager$b";

        public b() {
        }

        private CustomTabsIntent a(RequestContext requestContext) {
            CustomTabsIntent customTabsIntent = requestContext.getCustomTabsIntent();
            customTabsIntent.intent.setPackage("com.android.chrome");
            return customTabsIntent;
        }

        public static boolean b(Context context) {
            Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
            intent.setPackage("com.android.chrome");
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            return queryIntentServices != null && !queryIntentServices.isEmpty();
        }

        public void a(String str, RequestContext requestContext) throws AuthError {
            cp.c(f3299a, "Starting custom tab");
            try {
                a(requestContext).launchUrl(requestContext.getContext(), Uri.parse(str));
            } catch (NoSuchMethodError e2) {
                throw new AuthError("The current version of chrome custom tabs being used by your application is not compatible with the sdk. Please use version 25+.", e2, ERROR_TYPE.ERROR_UNKNOWN);
            } catch (Exception e3) {
                throw new AuthError("Unable to Launch custom tab.", e3, ERROR_TYPE.ERROR_UNKNOWN);
            }
        }
    }

    public static class c implements a {

        /* renamed from: a  reason: collision with root package name */
        public static final String f3300a = "com.amazon.identity.auth.internal.BrowsingExperienceManager$c";

        public c() {
        }

        private Intent a(String str, Context context) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
            intent.addFlags(1073741824);
            intent.putExtra("com.android.browser.application_id", context.getPackageName() + ".amazon.auth");
            return intent;
        }

        public void a(String str, RequestContext requestContext) throws AuthError {
            cp.c(f3300a, "Starting External Browser");
            try {
                Context context = requestContext.getContext();
                context.startActivity(a(str, context));
            } catch (Exception e2) {
                e2.getMessage();
                throw new AuthError("Unable to Launch Browser.", e2, ERROR_TYPE.ERROR_UNKNOWN);
            }
        }
    }

    public BrowsingExperienceManager(a aVar) {
        this.f123a = aVar;
    }

    public static synchronized BrowsingExperienceManager getInstance(Context context) {
        BrowsingExperienceManager browsingExperienceManager;
        synchronized (BrowsingExperienceManager.class) {
            try {
                if (f3298a == null) {
                    f3298a = b.b(context) ? new BrowsingExperienceManager(new b()) : new BrowsingExperienceManager(new c());
                }
                browsingExperienceManager = f3298a;
            }
        }
        return browsingExperienceManager;
    }

    public void openUrl(RequestContext requestContext, String str) throws AuthError {
        a aVar;
        if (requestContext.getCustomTabsIntent() == null || requestContext.getInvokingIntent() == null || !b.b(requestContext.getContext())) {
            aVar = new c();
        } else {
            if (!(this.f123a instanceof b)) {
                aVar = new b();
            }
            this.f123a.a(str, requestContext);
        }
        this.f123a = aVar;
        try {
            this.f123a.a(str, requestContext);
        } catch (AuthError e2) {
            if (this.f123a instanceof b) {
                cp.a(f122a, (String) "Error while opening chrome custom tab, Proceeding in device browser", (Throwable) e2);
                c cVar = new c();
                this.f123a = cVar;
                cVar.a(str, requestContext);
                return;
            }
            throw e2;
        }
    }
}
