package com.google.android.datatransport.runtime;

import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class ExecutionModule_ExecutorFactory implements Object<Executor> {

    public static final class InstanceHolder {
        public static final ExecutionModule_ExecutorFactory INSTANCE = new ExecutionModule_ExecutorFactory();
    }

    public Object get() {
        SafeLoggingExecutor safeLoggingExecutor = new SafeLoggingExecutor(Executors.newSingleThreadExecutor());
        ImageOriginUtils.checkNotNull(safeLoggingExecutor, "Cannot return null from a non-@Nullable @Provides method");
        return safeLoggingExecutor;
    }
}
