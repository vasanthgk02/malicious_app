package com.clevertap.android.sdk.task;

import java.util.concurrent.Executor;

public class SuccessExecutable<TResult> extends Executable<TResult> {
    public final OnSuccessListener<TResult> successListener;

    public SuccessExecutable(Executor executor, OnSuccessListener onSuccessListener) {
        super(executor);
        this.successListener = onSuccessListener;
    }

    public void execute(final TResult tresult) {
        this.executor.execute(new Runnable() {
            public void run() {
                SuccessExecutable.this.successListener.onSuccess(tresult);
            }
        });
    }
}
