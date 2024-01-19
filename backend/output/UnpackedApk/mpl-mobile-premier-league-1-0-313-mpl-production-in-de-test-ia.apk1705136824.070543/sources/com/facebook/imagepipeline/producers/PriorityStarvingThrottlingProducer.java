package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Executor;

public class PriorityStarvingThrottlingProducer<T> implements Producer<T> {
    public static final String PRODUCER_NAME = "PriorityStarvingThrottlingProducer";
    public final Executor mExecutor;
    public final Producer<T> mInputProducer;
    public final int mMaxSimultaneousRequests;
    public int mNumCurrentRequests;
    public final Queue<Item<T>> mPendingRequests;

    public static class Item<T> {
        public final Consumer<T> consumer;
        public final ProducerContext producerContext;
        public final long time;

        public Item(Consumer<T> consumer2, ProducerContext producerContext2, long j) {
            this.consumer = consumer2;
            this.producerContext = producerContext2;
            this.time = j;
        }
    }

    public static class PriorityComparator<T> implements Comparator<Item<T>> {
        public int compare(Item<T> item, Item<T> item2) {
            Priority priority = item.producerContext.getPriority();
            Priority priority2 = item2.producerContext.getPriority();
            if (priority == priority2) {
                return Double.compare((double) item.time, (double) item2.time);
            }
            return priority.ordinal() > priority2.ordinal() ? -1 : 1;
        }
    }

    public class ThrottlerConsumer extends DelegatingConsumer<T, T> {
        private void onRequestFinished() {
            final Item item;
            synchronized (PriorityStarvingThrottlingProducer.this) {
                item = (Item) PriorityStarvingThrottlingProducer.this.mPendingRequests.poll();
                if (item == null) {
                    PriorityStarvingThrottlingProducer.access$210(PriorityStarvingThrottlingProducer.this);
                }
            }
            if (item != null) {
                PriorityStarvingThrottlingProducer.this.mExecutor.execute(new Runnable() {
                    public void run() {
                        PriorityStarvingThrottlingProducer.this.produceResultsInternal(item);
                    }
                });
            }
        }

        public void onCancellationImpl() {
            getConsumer().onCancellation();
            onRequestFinished();
        }

        public void onFailureImpl(Throwable th) {
            getConsumer().onFailure(th);
            onRequestFinished();
        }

        public void onNewResultImpl(T t, int i) {
            getConsumer().onNewResult(t, i);
            if (BaseConsumer.isLast(i)) {
                onRequestFinished();
            }
        }

        public ThrottlerConsumer(Consumer<T> consumer) {
            super(consumer);
        }
    }

    public PriorityStarvingThrottlingProducer(int i, Executor executor, Producer<T> producer) {
        this.mMaxSimultaneousRequests = i;
        if (executor != null) {
            this.mExecutor = executor;
            if (producer != null) {
                this.mInputProducer = producer;
                this.mPendingRequests = new PriorityQueue(11, new PriorityComparator());
                this.mNumCurrentRequests = 0;
                return;
            }
            throw null;
        }
        throw null;
    }

    public static /* synthetic */ int access$210(PriorityStarvingThrottlingProducer priorityStarvingThrottlingProducer) {
        int i = priorityStarvingThrottlingProducer.mNumCurrentRequests;
        priorityStarvingThrottlingProducer.mNumCurrentRequests = i - 1;
        return i;
    }

    /* access modifiers changed from: private */
    public void produceResultsInternal(Item<T> item) {
        item.producerContext.getProducerListener().onProducerFinishWithSuccess(item.producerContext, PRODUCER_NAME, null);
        this.mInputProducer.produceResults(new ThrottlerConsumer(item.consumer), item.producerContext);
    }

    public void produceResults(Consumer<T> consumer, ProducerContext producerContext) {
        boolean z;
        long nanoTime = System.nanoTime();
        producerContext.getProducerListener().onProducerStart(producerContext, PRODUCER_NAME);
        synchronized (this) {
            z = true;
            if (this.mNumCurrentRequests >= this.mMaxSimultaneousRequests) {
                this.mPendingRequests.add(new Item(consumer, producerContext, nanoTime));
            } else {
                this.mNumCurrentRequests++;
                z = false;
            }
        }
        if (!z) {
            produceResultsInternal(new Item(consumer, producerContext, nanoTime));
        }
    }
}
