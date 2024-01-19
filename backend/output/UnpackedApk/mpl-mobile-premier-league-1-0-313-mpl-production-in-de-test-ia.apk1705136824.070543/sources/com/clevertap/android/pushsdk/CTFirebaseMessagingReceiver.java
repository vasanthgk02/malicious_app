package com.clevertap.android.pushsdk;

import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.CallbackManager;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.interfaces.NotificationRenderedListener;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Map.Entry;
import java.util.Objects;
import org.apache.pdfbox.pdfparser.BaseParser;

public class CTFirebaseMessagingReceiver extends BroadcastReceiver implements NotificationRenderedListener {
    public CountDownTimer countDownTimer;
    public boolean isPRFinished;
    public PendingResult pendingResult;

    public final void finishReceiverAndCancelTimer() {
        Logger.v("CTFirebaseMessagingReceiver :: finishReceiverAndCancelTimer() called");
        PendingResult pendingResult2 = this.pendingResult;
        if (pendingResult2 != null && !this.isPRFinished) {
            pendingResult2.finish();
            this.isPRFinished = true;
            try {
                if (this.countDownTimer != null) {
                    this.countDownTimer.cancel();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        this.pendingResult = goAsync();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CTFirebaseMessagingReceiver :: broadcast received for message");
        outline73.append(intent.getExtras().toString());
        Logger.d(outline73.toString());
        RemoteMessage remoteMessage = new RemoteMessage(intent.getExtras());
        Bundle bundle = new Bundle();
        try {
            for (Entry next : remoteMessage.getData().entrySet()) {
                bundle.putString((String) next.getKey(), (String) next.getValue());
            }
            Logger.d("AMPFcmNotificationParser", "Found Valid Notification Message ");
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.d("AMPFcmNotificationParser", "Invalid Notification Message ", th);
        }
        if (!CleverTapAPI.getNotificationInfo(bundle).fromCleverTap) {
            finishReceiverAndCancelTimer();
        } else if (Utils.isRenderFallback(remoteMessage)) {
            AnonymousClass1 r2 = new CountDownTimer(4500, 1000) {
                public void onFinish() {
                    try {
                        if (CTFirebaseMessagingReceiver.this.pendingResult != null && !CTFirebaseMessagingReceiver.this.isPRFinished) {
                            CTFirebaseMessagingReceiver.this.pendingResult.finish();
                            CTFirebaseMessagingReceiver.this.isPRFinished = true;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }

                public void onTick(long j) {
                }
            };
            this.countDownTimer = r2;
            r2.start();
            try {
                FallbackNotificationRenderer fallbackNotificationRenderer = new FallbackNotificationRenderer();
                CleverTapAPI fromAccountId = CleverTapAPI.fromAccountId(context, k.getAccountIdFromNotificationBundle(bundle));
                ((CallbackManager) ((CleverTapAPI) Objects.requireNonNull(fromAccountId)).coreState.callbackManager).notificationRenderedListener = this;
                fromAccountId.coreState.coreMetaData.customSdkVersions.put("ctpsdkversion", Integer.valueOf(1));
                bundle.putString("wzrk_pn_h", BaseParser.FALSE);
                bundle.putString("nh_source", "CTFirebaseMessagingReceiver");
                fromAccountId.renderPushNotification(fallbackNotificationRenderer, context, bundle);
            } catch (Throwable unused) {
                Logger.v("CTFirebaseMessagingReceiver :: Error parsing FCM payload");
            }
        } else {
            finishReceiverAndCancelTimer();
        }
    }
}
