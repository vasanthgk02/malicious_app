package com.facebook.imagepipeline.producers;

import com.facebook.common.executors.StatefulRunnable;
import java.util.Map;

public abstract class StatefulProducerRunnable<T> extends StatefulRunnable<T> {
    public final Consumer<T> mConsumer;
    public final ProducerContext mProducerContext;
    public final ProducerListener2 mProducerListener;
    public final String mProducerName;

    public StatefulProducerRunnable(Consumer<T> consumer, ProducerListener2 producerListener2, ProducerContext producerContext, String str) {
        this.mConsumer = consumer;
        this.mProducerListener = producerListener2;
        this.mProducerName = str;
        this.mProducerContext = producerContext;
        producerListener2.onProducerStart(producerContext, str);
    }

    public abstract void disposeResult(T t);

    public Map<String, String> getExtraMapOnCancellation() {
        return null;
    }

    public Map<String, String> getExtraMapOnFailure(Exception exc) {
        return null;
    }

    public Map<String, String> getExtraMapOnSuccess(T t) {
        return null;
    }

    public void onCancellation() {
        ProducerListener2 producerListener2 = this.mProducerListener;
        ProducerContext producerContext = this.mProducerContext;
        String str = this.mProducerName;
        producerListener2.onProducerFinishWithCancellation(producerContext, str, producerListener2.requiresExtraMap(producerContext, str) ? getExtraMapOnCancellation() : null);
        this.mConsumer.onCancellation();
    }

    public void onFailure(Exception exc) {
        ProducerListener2 producerListener2 = this.mProducerListener;
        ProducerContext producerContext = this.mProducerContext;
        String str = this.mProducerName;
        producerListener2.onProducerFinishWithFailure(producerContext, str, exc, producerListener2.requiresExtraMap(producerContext, str) ? getExtraMapOnFailure(exc) : null);
        this.mConsumer.onFailure(exc);
    }

    public void onSuccess(T t) {
        ProducerListener2 producerListener2 = this.mProducerListener;
        ProducerContext producerContext = this.mProducerContext;
        String str = this.mProducerName;
        producerListener2.onProducerFinishWithSuccess(producerContext, str, producerListener2.requiresExtraMap(producerContext, str) ? getExtraMapOnSuccess(t) : null);
        this.mConsumer.onNewResult(t, 1);
    }
}
