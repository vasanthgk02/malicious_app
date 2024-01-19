package com.freshchat.consumer.sdk.i;

import android.os.CountDownTimer;

public abstract class d extends CountDownTimer {
    public boolean isRunning;

    public d(long j) {
        super(j, j);
    }

    public abstract void execute();

    public void onFinish() {
        execute();
        this.isRunning = false;
    }

    public void onTick(long j) {
    }

    public void run() {
        if (!this.isRunning) {
            start();
            this.isRunning = true;
        }
    }
}
