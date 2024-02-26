package com.inmobi.androidsdk.impl;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

final class AdRetrievalFuture extends FutureTask<Boolean> {
    public AdRetrievalFuture(Callable<Boolean> callable) {
        super(callable);
    }

    public boolean cancel(boolean forceCancel) {
        return false;
    }

    public boolean isCancelled() {
        return false;
    }
}
