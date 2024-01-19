package com.facebook.imagepipeline.producers;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.imagepipeline.instrumentation.FrescoInstrumenter;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

public class ThreadHandoffProducer<T> implements Producer<T> {
    public static final String PRODUCER_NAME = "BackgroundThreadHandoffProducer";
    public final Producer<T> mInputProducer;
    public final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

    public ThreadHandoffProducer(Producer<T> producer, ThreadHandoffProducerQueue threadHandoffProducerQueue) {
        if (producer != null) {
            this.mInputProducer = producer;
            this.mThreadHandoffProducerQueue = threadHandoffProducerQueue;
            return;
        }
        throw null;
    }

    public static String getInstrumentationTag(ProducerContext producerContext) {
        if (!FrescoInstrumenter.isTracing()) {
            return null;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ThreadHandoffProducer_produceResults_");
        outline73.append(producerContext.getId());
        return outline73.toString();
    }

    public void produceResults(Consumer<T> consumer, ProducerContext producerContext) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ThreadHandoffProducer#produceResults");
            }
            final ProducerListener2 producerListener = producerContext.getProducerListener();
            final ProducerContext producerContext2 = producerContext;
            final Consumer<T> consumer2 = consumer;
            final AnonymousClass1 r0 = new StatefulProducerRunnable<T>(consumer, producerListener, producerContext, PRODUCER_NAME) {
                public void disposeResult(T t) {
                }

                public T getResult() throws Exception {
                    return null;
                }

                public void onSuccess(T t) {
                    producerListener.onProducerFinishWithSuccess(producerContext2, ThreadHandoffProducer.PRODUCER_NAME, null);
                    ThreadHandoffProducer.this.mInputProducer.produceResults(consumer2, producerContext2);
                }
            };
            producerContext.addCallbacks(new BaseProducerContextCallbacks() {
                public void onCancellationRequested() {
                    r0.cancel();
                    ThreadHandoffProducer.this.mThreadHandoffProducerQueue.remove(r0);
                }
            });
            this.mThreadHandoffProducerQueue.addToQueueOrExecute(FrescoInstrumenter.decorateRunnable(r0, getInstrumentationTag(producerContext)));
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }
}
