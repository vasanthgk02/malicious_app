package in.juspay.hypersdk.core;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import in.juspay.hypersdk.core.Labels.System;

public class GodelServiceConnection implements ServiceConnection {
    public static final String TAG = "GodelServiceConnection";
    public boolean isBound = false;
    public final JuspayServices juspayServices;
    public Messenger messenger = null;
    public Message pendingMsg = null;

    public GodelServiceConnection(JuspayServices juspayServices2) {
        this.juspayServices = juspayServices2;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            sdkTracker.trackAction("system", "info", System.GODEL_SERVICE_CONNECTION, "gsc_on_service_connected", "Successfully connected to " + componentName.getPackageName() + "/" + componentName.getClassName());
            this.messenger = new Messenger(iBinder);
            this.isBound = true;
            request(this.pendingMsg);
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(TAG, "action", "system", System.MPIN_UTIL, "Exception while trying to send message", e2);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.messenger = null;
        this.isBound = false;
    }

    public void request(int i, Bundle bundle, Handler handler) {
        this.juspayServices.getSdkTracker().trackAction("system", "info", System.GODEL_SERVICE_CONNECTION, "gsc_request", "Sending request to MPIN SDK");
        Message obtain = Message.obtain(null, i);
        obtain.setData(bundle);
        obtain.replyTo = new Messenger(handler);
        request(obtain);
    }

    public void request(Message message) {
        if (this.isBound) {
            this.messenger.send(message);
        } else {
            this.pendingMsg = message;
        }
    }
}
