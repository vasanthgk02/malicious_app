package io.reactivex.internal.operators.observable;

import com.twitter.sdk.android.tweetui.TweetUtils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.schedulers.TrampolineScheduler;

public final class ObservableObserveOn<T> extends AbstractObservableWithUpstream<T, T> {
    public final int bufferSize;
    public final boolean delayError;
    public final Scheduler scheduler;

    public static final class ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T>, Runnable {
        public static final long serialVersionUID = 6576896619930983584L;
        public final int bufferSize;
        public final boolean delayError;
        public volatile boolean disposed;
        public volatile boolean done;
        public final Observer<? super T> downstream;
        public Throwable error;
        public boolean outputFused;
        public SimpleQueue<T> queue;
        public int sourceMode;
        public Disposable upstream;
        public final Worker worker;

        public ObserveOnObserver(Observer<? super T> observer, Worker worker2, boolean z, int i) {
            this.downstream = observer;
            this.worker = worker2;
            this.delayError = z;
            this.bufferSize = i;
        }

        public boolean checkTerminated(boolean z, boolean z2, Observer<? super T> observer) {
            if (this.disposed) {
                this.queue.clear();
                return true;
            }
            if (z) {
                Throwable th = this.error;
                if (this.delayError) {
                    if (z2) {
                        this.disposed = true;
                        if (th != null) {
                            observer.onError(th);
                        } else {
                            observer.onComplete();
                        }
                        this.worker.dispose();
                        return true;
                    }
                } else if (th != null) {
                    this.disposed = true;
                    this.queue.clear();
                    observer.onError(th);
                    this.worker.dispose();
                    return true;
                } else if (z2) {
                    this.disposed = true;
                    observer.onComplete();
                    this.worker.dispose();
                    return true;
                }
            }
            return false;
        }

        public void clear() {
            this.queue.clear();
        }

        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.upstream.dispose();
                this.worker.dispose();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                schedule();
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                TweetUtils.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            schedule();
        }

        public void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode != 2) {
                    this.queue.offer(t);
                }
                schedule();
            }
        }

        /* JADX WARNING: type inference failed for: r3v1, types: [io.reactivex.internal.queue.SpscLinkedArrayQueue, io.reactivex.internal.fuseable.SimpleQueue<T>] */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v1, types: [io.reactivex.internal.queue.SpscLinkedArrayQueue, io.reactivex.internal.fuseable.SimpleQueue<T>]
          assigns: [io.reactivex.internal.queue.SpscLinkedArrayQueue]
          uses: [io.reactivex.internal.fuseable.SimpleQueue<T>]
          mth insns count: 28
        	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onSubscribe(io.reactivex.disposables.Disposable r3) {
            /*
                r2 = this;
                io.reactivex.disposables.Disposable r0 = r2.upstream
                boolean r0 = io.reactivex.internal.disposables.DisposableHelper.validate(r0, r3)
                if (r0 == 0) goto L_0x0042
                r2.upstream = r3
                boolean r0 = r3 instanceof io.reactivex.internal.fuseable.QueueDisposable
                if (r0 == 0) goto L_0x0034
                io.reactivex.internal.fuseable.QueueDisposable r3 = (io.reactivex.internal.fuseable.QueueDisposable) r3
                r0 = 7
                int r0 = r3.requestFusion(r0)
                r1 = 1
                if (r0 != r1) goto L_0x0027
                r2.sourceMode = r0
                r2.queue = r3
                r2.done = r1
                io.reactivex.Observer<? super T> r3 = r2.downstream
                r3.onSubscribe(r2)
                r2.schedule()
                return
            L_0x0027:
                r1 = 2
                if (r0 != r1) goto L_0x0034
                r2.sourceMode = r0
                r2.queue = r3
                io.reactivex.Observer<? super T> r3 = r2.downstream
                r3.onSubscribe(r2)
                return
            L_0x0034:
                io.reactivex.internal.queue.SpscLinkedArrayQueue r3 = new io.reactivex.internal.queue.SpscLinkedArrayQueue
                int r0 = r2.bufferSize
                r3.<init>(r0)
                r2.queue = r3
                io.reactivex.Observer<? super T> r3 = r2.downstream
                r3.onSubscribe(r2)
            L_0x0042:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableObserveOn.ObserveOnObserver.onSubscribe(io.reactivex.disposables.Disposable):void");
        }

        public T poll() throws Exception {
            return this.queue.poll();
        }

        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        public void run() {
            if (this.outputFused) {
                int i = 1;
                while (!this.disposed) {
                    boolean z = this.done;
                    Throwable th = this.error;
                    if (this.delayError || !z || th == null) {
                        this.downstream.onNext(null);
                        if (z) {
                            this.disposed = true;
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                this.downstream.onError(th2);
                            } else {
                                this.downstream.onComplete();
                            }
                            this.worker.dispose();
                            return;
                        }
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        this.disposed = true;
                        this.downstream.onError(this.error);
                        this.worker.dispose();
                        return;
                    }
                }
                return;
            }
            SimpleQueue<T> simpleQueue = this.queue;
            Observer<? super T> observer = this.downstream;
            int i2 = 1;
            while (!checkTerminated(this.done, simpleQueue.isEmpty(), observer)) {
                while (true) {
                    boolean z2 = this.done;
                    try {
                        Object poll = simpleQueue.poll();
                        boolean z3 = poll == null;
                        if (!checkTerminated(z2, z3, observer)) {
                            if (z3) {
                                i2 = addAndGet(-i2);
                                if (i2 == 0) {
                                    return;
                                }
                            } else {
                                observer.onNext(poll);
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th3) {
                        TweetUtils.throwIfFatal(th3);
                        this.disposed = true;
                        this.upstream.dispose();
                        simpleQueue.clear();
                        observer.onError(th3);
                        this.worker.dispose();
                        return;
                    }
                }
            }
        }

        public void schedule() {
            if (getAndIncrement() == 0) {
                this.worker.schedule(this);
            }
        }
    }

    public ObservableObserveOn(Observable<T> observable, Scheduler scheduler2, boolean z, int i) {
        super(observable);
        this.scheduler = scheduler2;
        this.delayError = z;
        this.bufferSize = i;
    }

    public void subscribeActual(Observer<? super T> observer) {
        Scheduler scheduler2 = this.scheduler;
        if (scheduler2 instanceof TrampolineScheduler) {
            this.source.subscribe(observer);
            return;
        }
        this.source.subscribe(new ObserveOnObserver(observer, scheduler2.createWorker(), this.delayError, this.bufferSize));
    }
}
