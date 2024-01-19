package com.firebase.jobdispatcher;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.firebase.jobdispatcher.JobInvocation.Builder;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;

@TargetApi(21)
public class GooglePlayMessageHandler extends Handler {
    public final GooglePlayReceiver googlePlayReceiver;

    public GooglePlayMessageHandler(Looper looper, GooglePlayReceiver googlePlayReceiver2) {
        super(looper);
        this.googlePlayReceiver = googlePlayReceiver2;
    }

    public void handleMessage(Message message) {
        if (message != null) {
            try {
                ((AppOpsManager) this.googlePlayReceiver.getApplicationContext().getSystemService("appops")).checkPackage(message.sendingUid, "com.google.android.gms");
                int i = message.what;
                if (i == 1) {
                    Bundle data = message.getData();
                    Messenger messenger = message.replyTo;
                    String string = data.getString(InlineAnimation.TAG);
                    if (messenger == null || string == null) {
                        Log.isLoggable("FJD.GooglePlayReceiver", 3);
                    } else {
                        this.googlePlayReceiver.getExecutionDelegator().executeJob(this.googlePlayReceiver.prepareJob(new GooglePlayMessengerCallback(messenger, string), data));
                    }
                } else if (i == 2) {
                    Builder decode = GooglePlayReceiver.prefixedCoder.decode(message.getData());
                    if (decode == null) {
                        Log.isLoggable("FJD.GooglePlayReceiver", 3);
                    } else {
                        ExecutionDelegator.stopJob(decode.build(), true);
                    }
                } else if (i != 4) {
                    "Unrecognized message received: " + message;
                }
            } catch (SecurityException unused) {
            }
        }
    }
}
