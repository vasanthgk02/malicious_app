package com.clevertap.android.sdk.task;

import java.util.concurrent.Executor;

public abstract class Executable<TResult> {
    public final Executor executor;

    public Executable(Executor executor2) {
        this.executor = executor2;
    }

    public abstract void execute(TResult tresult);
}
