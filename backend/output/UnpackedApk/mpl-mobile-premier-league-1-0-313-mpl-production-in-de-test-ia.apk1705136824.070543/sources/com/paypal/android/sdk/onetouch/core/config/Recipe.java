package com.paypal.android.sdk.onetouch.core.config;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import co.hyperverge.hypersnapsdk.c.k;
import com.braintreepayments.api.internal.SignatureVerification;
import com.paypal.android.sdk.onetouch.core.config.Recipe;
import com.paypal.android.sdk.onetouch.core.enums.Protocol;
import com.paypal.android.sdk.onetouch.core.enums.RequestTarget;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

public abstract class Recipe<T extends Recipe<T>> {
    public Protocol mProtocol;
    public Collection<String> mSupportedLocales = new HashSet();
    public RequestTarget mTarget;
    public String mTargetIntentAction;
    public List<String> mTargetPackagesInReversePriorityOrder = new ArrayList();

    public static Intent getBrowserIntent(Context context, String str, String str2) {
        Intent addFlags = new Intent("android.intent.action.VIEW", Uri.parse(str)).addFlags(ClientDefaults.MAX_MSG_SIZE);
        if (!"*".equals(str2)) {
            addFlags.setPackage(str2);
        }
        k.addChromeCustomTabsExtras(context, addFlags);
        return addFlags;
    }

    public List<String> getTargetPackagesInReversePriorityOrder() {
        return new ArrayList(this.mTargetPackagesInReversePriorityOrder);
    }

    public abstract T getThis();

    public boolean isValidAppTarget(Context context) {
        String packageName = context.getApplicationContext().getPackageName();
        if (!packageName.equals(packageName.toLowerCase(Locale.ROOT).replace("_", ""))) {
            return false;
        }
        Iterator it = ((ArrayList) getTargetPackagesInReversePriorityOrder()).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            boolean isIntentAvailable = k.isIntentAvailable(context, new Intent(this.mTargetIntentAction).setPackage(str));
            boolean z = this.mSupportedLocales.isEmpty() || this.mSupportedLocales.contains(Locale.getDefault().toString());
            boolean isSignatureValid = SignatureVerification.isSignatureValid(context, str, "O=Paypal", "O=Paypal", 34172764);
            if (isIntentAvailable && z && isSignatureValid) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidBrowserTarget(Context context, String str) {
        Iterator it = ((ArrayList) getTargetPackagesInReversePriorityOrder()).iterator();
        while (it.hasNext()) {
            if (isValidBrowserTarget(context, str, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidBrowserTarget(Context context, String str, String str2) {
        return getBrowserIntent(context, str, str2).resolveActivity(context.getPackageManager()) != null;
    }
}
