package com.clevertap.android.sdk.pushnotification;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.interfaces.ActionButtonClickHandler;
import com.clevertap.android.sdk.pushnotification.PushNotificationHandler.SingletonNotificationHandler;
import com.mpl.androidapp.utils.Constant;

@Deprecated
public class CTNotificationIntentService extends IntentService {
    public static final String MAIN_ACTION = "com.clevertap.PUSH_EVENT";
    public static final String TYPE_BUTTON_CLICK = "com.clevertap.ACTION_BUTTON_CLICK";
    public ActionButtonClickHandler mActionButtonClickHandler;

    public CTNotificationIntentService() {
        super("CTNotificationIntentService");
    }

    @SuppressLint({"MissingPermission"})
    private void handleActionButtonClick(Bundle bundle) {
        Intent intent;
        try {
            boolean z = bundle.getBoolean("autoCancel", false);
            int i = bundle.getInt(Constant.NOTIFICATION_ID, -1);
            String string = bundle.getString("dl");
            Context applicationContext = getApplicationContext();
            if (!this.mActionButtonClickHandler.onActionButtonClick(applicationContext, bundle, i) && VERSION.SDK_INT < 31) {
                if (string != null) {
                    intent = new Intent("android.intent.action.VIEW", Uri.parse(string));
                    Utils.setPackageNameFromResolveInfoList(applicationContext, intent);
                } else {
                    intent = applicationContext.getPackageManager().getLaunchIntentForPackage(applicationContext.getPackageName());
                }
                if (intent == null) {
                    Logger.v("CTNotificationService: create launch intent.");
                    return;
                }
                intent.setFlags(872415232);
                intent.putExtras(bundle);
                intent.removeExtra("dl");
                String string2 = bundle.getString("pt_dismiss_on_click", "");
                if (z && i > -1 && string2.isEmpty()) {
                    NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService("notification");
                    if (notificationManager != null) {
                        notificationManager.cancel(i);
                    }
                }
                sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
                startActivity(intent);
            }
        } catch (Throwable th) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("CTNotificationService: unable to process action button click:  ");
            outline73.append(th.getLocalizedMessage());
            Logger.v(outline73.toString());
        }
    }

    public void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            ActionButtonClickHandler actionButtonClickHandler = CleverTapAPI.sNotificationHandler;
            if (!PushNotificationHandler.isForPushTemplates(extras) || actionButtonClickHandler == null) {
                this.mActionButtonClickHandler = SingletonNotificationHandler.INSTANCE;
            } else {
                this.mActionButtonClickHandler = actionButtonClickHandler;
            }
            if (TYPE_BUTTON_CLICK.equals(extras.getString("ct_type"))) {
                Logger.v("CTNotificationIntentService handling com.clevertap.ACTION_BUTTON_CLICK");
                handleActionButtonClick(extras);
            } else {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("CTNotificationIntentService: unhandled intent ");
                outline73.append(intent.getAction());
                Logger.v(outline73.toString());
            }
        }
    }
}
