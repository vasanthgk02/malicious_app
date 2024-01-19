package com.facebook.imagepipeline.producers;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.NetworkFetcher.Callback;
import com.mpl.payment.gopay.GopayLinkingHandler;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PriorityNetworkFetcher<FETCH_STATE extends FetchState> implements NetworkFetcher<PriorityFetchState<FETCH_STATE>> {
    public static final String TAG = "PriorityNetworkFetcher";
    public final MonotonicClock mClock;
    public final HashSet<PriorityFetchState<FETCH_STATE>> mCurrentlyFetching;
    public final NetworkFetcher<FETCH_STATE> mDelegate;
    public final LinkedList<PriorityFetchState<FETCH_STATE>> mHiPriQueue;
    public final boolean mIsHiPriFifo;
    public final Object mLock;
    public final LinkedList<PriorityFetchState<FETCH_STATE>> mLowPriQueue;
    public final int mMaxOutstandingHiPri;
    public final int mMaxOutstandingLowPri;

    public static class PriorityFetchState<FETCH_STATE extends FetchState> extends FetchState {
        public Callback callback;
        public final FETCH_STATE delegatedState;
        public long dequeuedTimestamp;
        public final long enqueuedTimestamp;
        public final int hiPriCountWhenCreated;
        public final int lowPriCountWhenCreated;

        public PriorityFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext, FETCH_STATE fetch_state, long j, int i, int i2) {
            super(consumer, producerContext);
            this.delegatedState = fetch_state;
            this.enqueuedTimestamp = j;
            this.hiPriCountWhenCreated = i;
            this.lowPriCountWhenCreated = i2;
        }
    }

    public PriorityNetworkFetcher(NetworkFetcher<FETCH_STATE> networkFetcher, boolean z, int i, int i2) {
        this(networkFetcher, z, i, i2, RealtimeSinceBootClock.get());
    }

    /* access modifiers changed from: private */
    public void changePriority(PriorityFetchState<FETCH_STATE> priorityFetchState, boolean z) {
        LinkedList<PriorityFetchState<FETCH_STATE>> linkedList;
        synchronized (this.mLock) {
            if (z) {
                linkedList = this.mLowPriQueue;
            } else {
                linkedList = this.mHiPriQueue;
            }
            if (linkedList.remove(priorityFetchState)) {
                FLog.v(TAG, (String) "change-pri: %s %s", (Object) z ? "HIPRI" : "LOWPRI", (Object) priorityFetchState.getUri());
                putInQueue(priorityFetchState, z);
                dequeueIfAvailableSlots();
            }
        }
    }

    private void delegateFetch(final PriorityFetchState<FETCH_STATE> priorityFetchState) {
        try {
            this.mDelegate.fetch(priorityFetchState.delegatedState, new Callback() {
                public void onCancellation() {
                    PriorityNetworkFetcher.this.removeFromQueue(priorityFetchState, "CANCEL");
                    priorityFetchState.callback.onCancellation();
                }

                public void onFailure(Throwable th) {
                    PriorityNetworkFetcher.this.removeFromQueue(priorityFetchState, GopayLinkingHandler.STATUS_FAIL);
                    priorityFetchState.callback.onFailure(th);
                }

                public void onResponse(InputStream inputStream, int i) throws IOException {
                    priorityFetchState.callback.onResponse(inputStream, i);
                }
            });
        } catch (Exception unused) {
            removeFromQueue(priorityFetchState, GopayLinkingHandler.STATUS_FAIL);
        }
    }

    private void dequeueIfAvailableSlots() {
        synchronized (this.mLock) {
            int size = this.mCurrentlyFetching.size();
            PriorityFetchState pollFirst = size < this.mMaxOutstandingHiPri ? this.mHiPriQueue.pollFirst() : null;
            if (pollFirst == null && size < this.mMaxOutstandingLowPri) {
                pollFirst = this.mLowPriQueue.pollFirst();
            }
            if (pollFirst != null) {
                pollFirst.dequeuedTimestamp = this.mClock.now();
                this.mCurrentlyFetching.add(pollFirst);
                FLog.v(TAG, (String) "fetching: %s (concurrent: %s hi-pri queue: %s low-pri queue: %s)", (Object) pollFirst.getUri(), (Object) Integer.valueOf(size), (Object) Integer.valueOf(this.mHiPriQueue.size()), (Object) Integer.valueOf(this.mLowPriQueue.size()));
                delegateFetch(pollFirst);
            }
        }
    }

    private void putInQueue(PriorityFetchState<FETCH_STATE> priorityFetchState, boolean z) {
        if (!z) {
            this.mLowPriQueue.addLast(priorityFetchState);
        } else if (this.mIsHiPriFifo) {
            this.mHiPriQueue.addLast(priorityFetchState);
        } else {
            this.mHiPriQueue.addFirst(priorityFetchState);
        }
    }

    /* access modifiers changed from: private */
    public void removeFromQueue(PriorityFetchState<FETCH_STATE> priorityFetchState, String str) {
        synchronized (this.mLock) {
            FLog.v(TAG, (String) "remove: %s %s", (Object) str, (Object) priorityFetchState.getUri());
            this.mCurrentlyFetching.remove(priorityFetchState);
            if (!this.mHiPriQueue.remove(priorityFetchState)) {
                this.mLowPriQueue.remove(priorityFetchState);
            }
        }
        dequeueIfAvailableSlots();
    }

    public HashSet<PriorityFetchState<FETCH_STATE>> getCurrentlyFetching() {
        return this.mCurrentlyFetching;
    }

    public List<PriorityFetchState<FETCH_STATE>> getHiPriQueue() {
        return this.mHiPriQueue;
    }

    public List<PriorityFetchState<FETCH_STATE>> getLowPriQueue() {
        return this.mLowPriQueue;
    }

    public PriorityFetchState<FETCH_STATE> createFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        PriorityFetchState priorityFetchState = new PriorityFetchState(consumer, producerContext, this.mDelegate.createFetchState(consumer, producerContext), this.mClock.now(), this.mHiPriQueue.size(), this.mLowPriQueue.size());
        return priorityFetchState;
    }

    public void fetch(final PriorityFetchState<FETCH_STATE> priorityFetchState, final Callback callback) {
        priorityFetchState.getContext().addCallbacks(new BaseProducerContextCallbacks() {
            public void onCancellationRequested() {
                PriorityNetworkFetcher.this.removeFromQueue(priorityFetchState, "CANCEL");
                callback.onCancellation();
            }

            public void onPriorityChanged() {
                PriorityNetworkFetcher priorityNetworkFetcher = PriorityNetworkFetcher.this;
                PriorityFetchState priorityFetchState = priorityFetchState;
                priorityNetworkFetcher.changePriority(priorityFetchState, priorityFetchState.getContext().getPriority() == Priority.HIGH);
            }
        });
        synchronized (this.mLock) {
            if (this.mCurrentlyFetching.contains(priorityFetchState)) {
                String str = TAG;
                FLog.e(str, "fetch state was enqueued twice: " + priorityFetchState);
                return;
            }
            boolean z = priorityFetchState.getContext().getPriority() == Priority.HIGH;
            FLog.v(TAG, (String) "enqueue: %s %s", (Object) z ? "HI-PRI" : "LOW-PRI", (Object) priorityFetchState.getUri());
            priorityFetchState.callback = callback;
            putInQueue(priorityFetchState, z);
            dequeueIfAvailableSlots();
        }
    }

    public Map<String, String> getExtraMap(PriorityFetchState<FETCH_STATE> priorityFetchState, int i) {
        HashMap hashMap;
        Map<String, String> extraMap = this.mDelegate.getExtraMap(priorityFetchState.delegatedState, i);
        if (extraMap != null) {
            hashMap = new HashMap(extraMap);
        } else {
            hashMap = new HashMap();
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("");
        outline73.append(priorityFetchState.dequeuedTimestamp - priorityFetchState.enqueuedTimestamp);
        hashMap.put("pri_queue_time", outline73.toString());
        hashMap.put("hipri_queue_size", "" + priorityFetchState.hiPriCountWhenCreated);
        hashMap.put("lowpri_queue_size", "" + priorityFetchState.lowPriCountWhenCreated);
        return hashMap;
    }

    public void onFetchCompletion(PriorityFetchState<FETCH_STATE> priorityFetchState, int i) {
        removeFromQueue(priorityFetchState, "SUCCESS");
        this.mDelegate.onFetchCompletion(priorityFetchState.delegatedState, i);
    }

    public boolean shouldPropagate(PriorityFetchState<FETCH_STATE> priorityFetchState) {
        return this.mDelegate.shouldPropagate(priorityFetchState.delegatedState);
    }

    public PriorityNetworkFetcher(NetworkFetcher<FETCH_STATE> networkFetcher, boolean z, int i, int i2, MonotonicClock monotonicClock) {
        this.mLock = new Object();
        this.mHiPriQueue = new LinkedList<>();
        this.mLowPriQueue = new LinkedList<>();
        this.mCurrentlyFetching = new HashSet<>();
        this.mDelegate = networkFetcher;
        this.mIsHiPriFifo = z;
        this.mMaxOutstandingHiPri = i;
        this.mMaxOutstandingLowPri = i2;
        if (i > i2) {
            this.mClock = monotonicClock;
            return;
        }
        throw new IllegalArgumentException("maxOutstandingHiPri should be > maxOutstandingLowPri");
    }
}
