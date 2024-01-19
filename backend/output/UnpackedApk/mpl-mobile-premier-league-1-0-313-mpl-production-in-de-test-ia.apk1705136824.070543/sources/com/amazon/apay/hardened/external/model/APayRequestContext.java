package com.amazon.apay.hardened.external.model;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import androidx.browser.customtabs.CustomTabsIntent;
import com.twitter.sdk.android.tweetui.TweetUtils;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.UUID;

public final class APayRequestContext {

    /* renamed from: a  reason: collision with root package name */
    public final UUID f3251a;

    /* renamed from: b  reason: collision with root package name */
    public final String f3252b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f3253c;

    /* renamed from: d  reason: collision with root package name */
    public final PendingIntent f3254d;

    /* renamed from: e  reason: collision with root package name */
    public final PendingIntent f3255e;

    /* renamed from: f  reason: collision with root package name */
    public final CustomTabsIntent f3256f;

    public APayRequestContext(Context context, String str, PendingIntent pendingIntent, PendingIntent pendingIntent2, CustomTabsIntent customTabsIntent) {
        TweetUtils.a(context, (String) "Context");
        if (context instanceof Activity) {
            TweetUtils.a(str, (String) PaymentConstants.CLIENT_ID_CAMEL);
            this.f3251a = UUID.randomUUID();
            this.f3253c = context;
            this.f3252b = str;
            this.f3254d = pendingIntent;
            this.f3255e = pendingIntent2;
            this.f3256f = customTabsIntent;
            return;
        }
        throw new IllegalArgumentException("Do not pass ApplicationContext. Pass activity context instead.");
    }

    public static APayRequestContext a(Context context, String str, PendingIntent pendingIntent, PendingIntent pendingIntent2, CustomTabsIntent customTabsIntent) {
        APayRequestContext aPayRequestContext = new APayRequestContext(context, str, pendingIntent, pendingIntent2, customTabsIntent);
        return aPayRequestContext;
    }

    public static APayRequestContext create(Context context, String str) {
        return a(context, str, null, null, null);
    }

    public PendingIntent getCancelIntent() {
        return this.f3255e;
    }

    public String getClientId() {
        return this.f3252b;
    }

    public PendingIntent getCompletionIntent() {
        return this.f3254d;
    }

    public Context getContext() {
        return this.f3253c;
    }

    public CustomTabsIntent getCustomTabsIntent() {
        return this.f3256f;
    }

    public String getId() {
        return this.f3251a.toString();
    }

    public static APayRequestContext create(Context context, String str, CustomTabsIntent customTabsIntent) {
        return a(context, str, null, null, customTabsIntent);
    }

    public static APayRequestContext create(Context context, String str, PendingIntent pendingIntent, CustomTabsIntent customTabsIntent) {
        return a(context, str, pendingIntent, null, customTabsIntent);
    }

    public static APayRequestContext create(Context context, String str, PendingIntent pendingIntent, PendingIntent pendingIntent2, CustomTabsIntent customTabsIntent) {
        return a(context, str, pendingIntent, pendingIntent2, customTabsIntent);
    }
}
