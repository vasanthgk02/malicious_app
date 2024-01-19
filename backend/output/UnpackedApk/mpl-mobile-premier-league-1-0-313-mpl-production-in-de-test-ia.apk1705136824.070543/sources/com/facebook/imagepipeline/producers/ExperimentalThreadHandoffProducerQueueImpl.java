package com.facebook.imagepipeline.producers;

import java.util.concurrent.Executor;

public class ExperimentalThreadHandoffProducerQueueImpl implements ThreadHandoffProducerQueue {
    public final Executor mExecutor;

    public ExperimentalThreadHandoffProducerQueueImpl(Executor executor) {
        if (executor != null) {
            this.mExecutor = executor;
            return;
        }
        throw null;
    }

    public void addToQueueOrExecute(Runnable runnable) {
        this.mExecutor.execute(runnable);
    }

    public boolean isQueueing() {
        return false;
    }

    public void remove(Runnable runnable) {
    }

    public void startQueueing() {
        throw new UnsupportedOperationException();
    }

    public void stopQueuing() {
        throw new UnsupportedOperationException();
    }
}
