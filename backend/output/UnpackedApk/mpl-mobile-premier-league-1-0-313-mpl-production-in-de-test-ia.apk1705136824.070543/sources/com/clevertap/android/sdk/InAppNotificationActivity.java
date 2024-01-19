package com.clevertap.android.sdk;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.inapp.CTInAppBaseFullFragment;
import com.clevertap.android.sdk.inapp.CTInAppHtmlCoverFragment;
import com.clevertap.android.sdk.inapp.CTInAppHtmlHalfInterstitialFragment;
import com.clevertap.android.sdk.inapp.CTInAppHtmlInterstitialFragment;
import com.clevertap.android.sdk.inapp.CTInAppNativeCoverFragment;
import com.clevertap.android.sdk.inapp.CTInAppNativeCoverImageFragment;
import com.clevertap.android.sdk.inapp.CTInAppNativeHalfInterstitialFragment;
import com.clevertap.android.sdk.inapp.CTInAppNativeHalfInterstitialImageFragment;
import com.clevertap.android.sdk.inapp.CTInAppNativeInterstitialFragment;
import com.clevertap.android.sdk.inapp.CTInAppNativeInterstitialImageFragment;
import com.clevertap.android.sdk.inapp.CTInAppNotification;
import com.clevertap.android.sdk.inapp.InAppListener;
import com.inca.security.Proxy.iIiIiIiIii;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class InAppNotificationActivity extends FragmentActivity implements InAppListener {
    public static boolean isAlertVisible;
    public CleverTapInstanceConfig config;
    public CTInAppNotification inAppNotification;
    public WeakReference<InAppListener> listenerWeakReference;

    public final CTInAppBaseFullFragment createContentFragment() {
        AlertDialog alertDialog;
        switch (this.inAppNotification.inAppType.ordinal()) {
            case 1:
                return new CTInAppHtmlCoverFragment();
            case 2:
                return new CTInAppHtmlInterstitialFragment();
            case 5:
                return new CTInAppHtmlHalfInterstitialFragment();
            case 6:
                return new CTInAppNativeCoverFragment();
            case 7:
                return new CTInAppNativeInterstitialFragment();
            case 8:
                return new CTInAppNativeHalfInterstitialFragment();
            case 11:
                if (this.inAppNotification.buttons.size() > 0) {
                    alertDialog = new Builder(this, 16974394).setCancelable(false).setTitle(this.inAppNotification.title).setMessage(this.inAppNotification.message).setPositiveButton(this.inAppNotification.buttons.get(0).text, new OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Bundle bundle = new Bundle();
                            bundle.putString("wzrk_id", InAppNotificationActivity.this.inAppNotification.campaignId);
                            bundle.putString("wzrk_c2a", InAppNotificationActivity.this.inAppNotification.buttons.get(0).text);
                            InAppNotificationActivity inAppNotificationActivity = InAppNotificationActivity.this;
                            InAppListener listener = inAppNotificationActivity.getListener();
                            if (listener != null) {
                                listener.inAppNotificationDidClick(inAppNotificationActivity.inAppNotification, bundle, null);
                            }
                            String str = InAppNotificationActivity.this.inAppNotification.buttons.get(0).actionUrl;
                            if (str != null) {
                                InAppNotificationActivity.this.fireUrlThroughIntent(str, bundle);
                            } else {
                                InAppNotificationActivity.this.didDismiss(bundle);
                            }
                        }
                    }).create();
                    if (this.inAppNotification.buttons.size() == 2) {
                        alertDialog.setButton(-2, this.inAppNotification.buttons.get(1).text, new OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Bundle bundle = new Bundle();
                                bundle.putString("wzrk_id", InAppNotificationActivity.this.inAppNotification.campaignId);
                                bundle.putString("wzrk_c2a", InAppNotificationActivity.this.inAppNotification.buttons.get(1).text);
                                InAppNotificationActivity inAppNotificationActivity = InAppNotificationActivity.this;
                                InAppListener listener = inAppNotificationActivity.getListener();
                                if (listener != null) {
                                    listener.inAppNotificationDidClick(inAppNotificationActivity.inAppNotification, bundle, null);
                                }
                                String str = InAppNotificationActivity.this.inAppNotification.buttons.get(1).actionUrl;
                                if (str != null) {
                                    InAppNotificationActivity.this.fireUrlThroughIntent(str, bundle);
                                } else {
                                    InAppNotificationActivity.this.didDismiss(bundle);
                                }
                            }
                        });
                    }
                    if (this.inAppNotification.buttons.size() > 2) {
                        alertDialog.setButton(-3, this.inAppNotification.buttons.get(2).text, new OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Bundle bundle = new Bundle();
                                bundle.putString("wzrk_id", InAppNotificationActivity.this.inAppNotification.campaignId);
                                bundle.putString("wzrk_c2a", InAppNotificationActivity.this.inAppNotification.buttons.get(2).text);
                                InAppNotificationActivity inAppNotificationActivity = InAppNotificationActivity.this;
                                InAppListener listener = inAppNotificationActivity.getListener();
                                if (listener != null) {
                                    listener.inAppNotificationDidClick(inAppNotificationActivity.inAppNotification, bundle, null);
                                }
                                String str = InAppNotificationActivity.this.inAppNotification.buttons.get(2).actionUrl;
                                if (str != null) {
                                    InAppNotificationActivity.this.fireUrlThroughIntent(str, bundle);
                                } else {
                                    InAppNotificationActivity.this.didDismiss(bundle);
                                }
                            }
                        });
                    }
                } else {
                    alertDialog = null;
                }
                if (alertDialog != null) {
                    alertDialog.show();
                    isAlertVisible = true;
                    InAppListener listener = getListener();
                    if (listener == null) {
                        return null;
                    }
                    listener.inAppNotificationDidShow(this.inAppNotification, null);
                    return null;
                }
                this.config.getLogger().debug("InAppNotificationActivity: Alert Dialog is null, not showing Alert InApp");
                return null;
            case 12:
                return new CTInAppNativeCoverImageFragment();
            case 13:
                return new CTInAppNativeInterstitialImageFragment();
            case 14:
                return new CTInAppNativeHalfInterstitialImageFragment();
            default:
                this.config.getLogger().verbose("InAppNotificationActivity: Unhandled InApp Type: " + r0);
                return null;
        }
    }

    public void didClick(Bundle bundle, HashMap<String, String> hashMap) {
        InAppListener listener = getListener();
        if (listener != null) {
            listener.inAppNotificationDidClick(this.inAppNotification, bundle, hashMap);
        }
    }

    public void didDismiss(Bundle bundle) {
        if (isAlertVisible) {
            isAlertVisible = false;
        }
        finish();
        InAppListener listener = getListener();
        if (listener != null && getBaseContext() != null) {
            listener.inAppNotificationDidDismiss(getBaseContext(), this.inAppNotification, bundle);
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(17432576, 17432577);
    }

    public void fireUrlThroughIntent(String str, Bundle bundle) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str.replace("\n", "").replace("\r", ""))));
        } catch (Throwable unused) {
        }
        didDismiss(bundle);
    }

    public InAppListener getListener() {
        InAppListener inAppListener;
        try {
            inAppListener = (InAppListener) this.listenerWeakReference.get();
        } catch (Throwable unused) {
            inAppListener = null;
        }
        if (inAppListener == null) {
            Logger logger = this.config.getLogger();
            String str = this.config.accountId;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("InAppActivityListener is null for notification: ");
            outline73.append(this.inAppNotification.jsonDescription);
            logger.verbose(str, outline73.toString());
        }
        return inAppListener;
    }

    public void inAppNotificationDidClick(CTInAppNotification cTInAppNotification, Bundle bundle, HashMap<String, String> hashMap) {
        didClick(bundle, hashMap);
    }

    public void inAppNotificationDidDismiss(Context context, CTInAppNotification cTInAppNotification, Bundle bundle) {
        didDismiss(bundle);
    }

    public void inAppNotificationDidShow(CTInAppNotification cTInAppNotification, Bundle bundle) {
        InAppListener listener = getListener();
        if (listener != null) {
            listener.inAppNotificationDidShow(this.inAppNotification, bundle);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(17432576, 17432577);
        finish();
        didDismiss(null);
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, -1894233358, bundle);
    }

    public void setTheme(int i) {
        super.setTheme(16973840);
    }
}
