package com.firebase.jobdispatcher;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;

public class GooglePlayMessengerCallback implements JobCallback {
    public final Messenger messenger;
    public final String tag;

    public GooglePlayMessengerCallback(Messenger messenger2, String str) {
        this.messenger = messenger2;
        this.tag = str;
    }

    public void jobFinished(int i) {
        try {
            Messenger messenger2 = this.messenger;
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.arg1 = i;
            Bundle bundle = new Bundle();
            bundle.putString(InlineAnimation.TAG, this.tag);
            obtain.setData(bundle);
            messenger2.send(obtain);
        } catch (RemoteException e2) {
            throw new RuntimeException(e2);
        }
    }
}
