package com.clevertap.android.sdk.task;

import java.util.concurrent.Executor;

public class FailureExecutable<TResult> extends Executable<TResult> {
    public final OnFailureListener<TResult> failureListener;

    public FailureExecutable(Executor executor, OnFailureListener<TResult> onFailureListener) {
        super(executor);
        this.failureListener = onFailureListener;
    }

    public void execute(final TResult tresult) {
        this.executor.execute(new Runnable() {
            public void run() {
                FailureExecutable.this.failureListener.onFailure(tresult);
            }
        });
    }
}
