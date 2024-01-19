package com.braintreepayments.browserswitch;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

public class BrowserSwitchClient {
    public final ActivityFinder activityFinder;
    public final BrowserSwitchConfig config;
    public final BrowserSwitchPersistentStore persistentStore;
    public final String returnUrlScheme;

    public BrowserSwitchClient(BrowserSwitchConfig browserSwitchConfig, ActivityFinder activityFinder2, BrowserSwitchPersistentStore browserSwitchPersistentStore, String str) {
        this.config = browserSwitchConfig;
        this.activityFinder = activityFinder2;
        this.persistentStore = browserSwitchPersistentStore;
        this.returnUrlScheme = str;
    }

    public void start(BrowserSwitchOptions browserSwitchOptions, Fragment fragment) {
        String str;
        BrowserSwitchListener browserSwitchListener = (BrowserSwitchListener) fragment;
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            Context applicationContext = activity.getApplicationContext();
            Intent intent = browserSwitchOptions.intent;
            if (intent == null) {
                BrowserSwitchConfig browserSwitchConfig = this.config;
                Uri uri = browserSwitchOptions.url;
                if (browserSwitchConfig != null) {
                    intent = new Intent("android.intent.action.VIEW", uri);
                    intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
                    Context applicationContext2 = applicationContext.getApplicationContext();
                    if (k.isAvailable(applicationContext2)) {
                        k.addChromeCustomTabsExtras(applicationContext2, intent);
                    }
                } else {
                    throw null;
                }
            }
            int i = browserSwitchOptions.requestCode;
            if (!(i != Integer.MIN_VALUE)) {
                str = "Request code cannot be Integer.MIN_VALUE";
            } else {
                BrowserSwitchConfig browserSwitchConfig2 = this.config;
                String str2 = this.returnUrlScheme;
                if (browserSwitchConfig2 != null) {
                    Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("%s://", new Object[]{str2})));
                    intent2.addCategory("android.intent.category.DEFAULT");
                    intent2.addCategory("android.intent.category.BROWSABLE");
                    if (this.activityFinder == null) {
                        throw null;
                    } else if (!(!GeneratedOutlineSupport.outline106(applicationContext, intent2, 0))) {
                        str = "The return url scheme was not set up, incorrectly set up, or more than one Activity on this device defines the same url scheme in it's Android Manifest. See https://github.com/braintree/browser-switch-android for more information on setting up a return url scheme.";
                    } else if (this.activityFinder == null) {
                        throw null;
                    } else if (!(!GeneratedOutlineSupport.outline106(applicationContext, intent, 0))) {
                        StringBuilder sb = new StringBuilder("No installed activities can open this URL");
                        Uri data = intent.getData();
                        if (data != null) {
                            sb.append(String.format(": %s", new Object[]{data.toString()}));
                        }
                        str = sb.toString();
                    } else {
                        str = null;
                    }
                } else {
                    throw null;
                }
            }
            if (str == null) {
                this.persistentStore.putActiveRequest(new BrowserSwitchRequest(i, intent.getData(), "PENDING", null), applicationContext);
                applicationContext.startActivity(intent);
                return;
            }
            browserSwitchListener.onBrowserSwitchResult(i, new BrowserSwitchResult(3, str), null);
            return;
        }
        throw new IllegalStateException("Fragment must be attached to an activity.");
    }
}
