package com.clevertap.android.sdk.task;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.squareup.picasso.Utils;
import java.util.HashMap;
import java.util.concurrent.Executor;

public class CTExecutors {
    public final MainThreadExecutor DEFAULT_CALLBACK_EXECUTOR;
    public final IOExecutor IO_EXECUTOR = new IOExecutor();
    public final MainThreadExecutor MAIN_EXECUTOR;
    public final CleverTapInstanceConfig config;
    public final HashMap<String, PostAsyncSafelyExecutor> postAsyncSafelyTasks;

    public CTExecutors(CleverTapInstanceConfig cleverTapInstanceConfig) {
        MainThreadExecutor mainThreadExecutor = new MainThreadExecutor();
        this.MAIN_EXECUTOR = mainThreadExecutor;
        this.DEFAULT_CALLBACK_EXECUTOR = mainThreadExecutor;
        this.postAsyncSafelyTasks = new HashMap<>();
        this.config = cleverTapInstanceConfig;
    }

    public <TResult> Task<TResult> ioTask() {
        return taskOnExecutorWithName(this.IO_EXECUTOR, this.DEFAULT_CALLBACK_EXECUTOR, "ioTask");
    }

    public <TResult> Task<TResult> mainTask() {
        return taskOnExecutorWithName(this.MAIN_EXECUTOR, this.DEFAULT_CALLBACK_EXECUTOR, Utils.OWNER_MAIN);
    }

    public <TResult> Task<TResult> postAsyncSafelyTask(String str) {
        if (str != null) {
            PostAsyncSafelyExecutor postAsyncSafelyExecutor = this.postAsyncSafelyTasks.get(str);
            if (postAsyncSafelyExecutor == null) {
                postAsyncSafelyExecutor = new PostAsyncSafelyExecutor();
                this.postAsyncSafelyTasks.put(str, postAsyncSafelyExecutor);
            }
            return taskOnExecutorWithName(postAsyncSafelyExecutor, this.DEFAULT_CALLBACK_EXECUTOR, "PostAsyncSafely");
        }
        throw new IllegalArgumentException("Tag can't be null");
    }

    public <TResult> Task<TResult> taskOnExecutorWithName(Executor executor, Executor executor2, String str) {
        if (executor != null && executor2 != null) {
            return new Task<>(this.config, executor, executor2, str);
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline52("Can't create task ", str, " with null executors"));
    }

    public <TResult> Task<TResult> postAsyncSafelyTask() {
        return postAsyncSafelyTask(this.config.accountId);
    }
}
