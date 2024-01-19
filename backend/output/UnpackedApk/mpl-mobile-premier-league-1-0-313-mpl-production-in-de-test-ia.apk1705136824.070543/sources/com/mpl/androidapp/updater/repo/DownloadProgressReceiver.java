package com.mpl.androidapp.updater.repo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

public class DownloadProgressReceiver extends ResultReceiver {
    public static final String TAG = "DownloadProgressReceiver";
    public Receiver mReceiver;

    public interface Receiver {
        void onReceiveResult(int i, Bundle bundle);
    }

    @SuppressLint({"RestrictedApi"})
    public DownloadProgressReceiver(Handler handler) {
        super(handler);
    }

    public void onReceiveResult(int i, Bundle bundle) {
        Receiver receiver = this.mReceiver;
        if (receiver != null) {
            receiver.onReceiveResult(i, bundle);
        }
    }

    public void setReceiver(Receiver receiver) {
        this.mReceiver = receiver;
    }
}
