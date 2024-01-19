package com.clevertap.android.sdk.task;

import com.clevertap.android.sdk.CleverTapInstanceConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class Task<TResult> {
    public final CleverTapInstanceConfig config;
    public final Executor defaultCallbackExecutor;
    public final Executor executor;
    public final List<FailureExecutable<Exception>> failureExecutables = new ArrayList();
    public TResult result;
    public final List<SuccessExecutable<TResult>> successExecutables = new ArrayList();
    public final String taskName;

    public enum STATE {
        FAILED,
        SUCCESS,
        READY_TO_RUN,
        RUNNING
    }

    public Task(CleverTapInstanceConfig cleverTapInstanceConfig, Executor executor2, Executor executor3, String str) {
        STATE state = STATE.READY_TO_RUN;
        this.executor = executor2;
        this.defaultCallbackExecutor = executor3;
        this.config = cleverTapInstanceConfig;
        this.taskName = str;
    }
}
