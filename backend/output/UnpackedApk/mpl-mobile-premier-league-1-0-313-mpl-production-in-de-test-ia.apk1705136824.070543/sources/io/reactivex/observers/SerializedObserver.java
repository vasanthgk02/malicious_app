package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;

public final class SerializedObserver<T> implements Observer<T>, Disposable {
    public final boolean delayError = false;
    public volatile boolean done;
    public final Observer<? super T> downstream;
    public boolean emitting;
    public AppendOnlyLinkedArrayList<Object> queue;
    public Disposable upstream;

    public SerializedObserver(Observer<? super T> observer) {
        this.downstream = observer;
    }

    public void dispose() {
        this.upstream.dispose();
    }

    public void onComplete() {
        if (!this.done) {
            synchronized (this) {
                if (!this.done) {
                    if (this.emitting) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.queue;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.queue = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.complete());
                        return;
                    }
                    this.done = true;
                    this.emitting = true;
                    this.downstream.onComplete();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
        if (r1 == false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003c, code lost:
        com.twitter.sdk.android.tweetui.TweetUtils.onError(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
        r3.downstream.onError(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0045, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r4) {
        /*
            r3 = this;
            boolean r0 = r3.done
            if (r0 == 0) goto L_0x0008
            com.twitter.sdk.android.tweetui.TweetUtils.onError(r4)
            return
        L_0x0008:
            monitor-enter(r3)
            boolean r0 = r3.done     // Catch:{ all -> 0x0046 }
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0011
            r1 = 1
            goto L_0x0039
        L_0x0011:
            boolean r0 = r3.emitting     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x0035
            r3.done = r2     // Catch:{ all -> 0x0046 }
            io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r3.queue     // Catch:{ all -> 0x0046 }
            if (r0 != 0) goto L_0x0023
            io.reactivex.internal.util.AppendOnlyLinkedArrayList r0 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0046 }
            r2 = 4
            r0.<init>(r2)     // Catch:{ all -> 0x0046 }
            r3.queue = r0     // Catch:{ all -> 0x0046 }
        L_0x0023:
            java.lang.Object r4 = io.reactivex.internal.util.NotificationLite.error(r4)     // Catch:{ all -> 0x0046 }
            boolean r2 = r3.delayError     // Catch:{ all -> 0x0046 }
            if (r2 == 0) goto L_0x002f
            r0.add(r4)     // Catch:{ all -> 0x0046 }
            goto L_0x0033
        L_0x002f:
            java.lang.Object[] r0 = r0.head     // Catch:{ all -> 0x0046 }
            r0[r1] = r4     // Catch:{ all -> 0x0046 }
        L_0x0033:
            monitor-exit(r3)     // Catch:{ all -> 0x0046 }
            return
        L_0x0035:
            r3.done = r2     // Catch:{ all -> 0x0046 }
            r3.emitting = r2     // Catch:{ all -> 0x0046 }
        L_0x0039:
            monitor-exit(r3)     // Catch:{ all -> 0x0046 }
            if (r1 == 0) goto L_0x0040
            com.twitter.sdk.android.tweetui.TweetUtils.onError(r4)
            return
        L_0x0040:
            io.reactivex.Observer<? super T> r0 = r3.downstream
            r0.onError(r4)
            return
        L_0x0046:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0046 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.observers.SerializedObserver.onError(java.lang.Throwable):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003b, code lost:
        r6.downstream.onNext(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0040, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r7 = r6.queue;
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0044, code lost:
        if (r7 != null) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0046, code lost:
        r6.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0048, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004a, code lost:
        r6.queue = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004d, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004e, code lost:
        r2 = r6.downstream;
        r3 = r7.head;
        r7 = r7.capacity;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0054, code lost:
        if (r3 == null) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0056, code lost:
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0057, code lost:
        if (r4 >= r7) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0059, code lost:
        r5 = r3[r4];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x005b, code lost:
        if (r5 != null) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0062, code lost:
        if (io.reactivex.internal.util.NotificationLite.acceptFull((java.lang.Object) r5, r2) == false) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0064, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0066, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0069, code lost:
        r3 = r3[r7];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006e, code lost:
        if (r1 == false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0070, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onNext(T r7) {
        /*
            r6 = this;
            boolean r0 = r6.done
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            if (r7 != 0) goto L_0x0017
            io.reactivex.disposables.Disposable r7 = r6.upstream
            r7.dispose()
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r0 = "onNext called with null. Null values are generally not allowed in 2.x operators and sources."
            r7.<init>(r0)
            r6.onError(r7)
            return
        L_0x0017:
            monitor-enter(r6)
            boolean r0 = r6.done     // Catch:{ all -> 0x0074 }
            if (r0 == 0) goto L_0x001e
            monitor-exit(r6)     // Catch:{ all -> 0x0074 }
            return
        L_0x001e:
            boolean r0 = r6.emitting     // Catch:{ all -> 0x0074 }
            if (r0 == 0) goto L_0x0037
            io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r6.queue     // Catch:{ all -> 0x0074 }
            if (r0 != 0) goto L_0x002e
            io.reactivex.internal.util.AppendOnlyLinkedArrayList r0 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0074 }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x0074 }
            r6.queue = r0     // Catch:{ all -> 0x0074 }
        L_0x002e:
            java.lang.Object r7 = io.reactivex.internal.util.NotificationLite.next(r7)     // Catch:{ all -> 0x0074 }
            r0.add(r7)     // Catch:{ all -> 0x0074 }
            monitor-exit(r6)     // Catch:{ all -> 0x0074 }
            return
        L_0x0037:
            r0 = 1
            r6.emitting = r0     // Catch:{ all -> 0x0074 }
            monitor-exit(r6)     // Catch:{ all -> 0x0074 }
            io.reactivex.Observer<? super T> r1 = r6.downstream
            r1.onNext(r7)
        L_0x0040:
            monitor-enter(r6)
            io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r7 = r6.queue     // Catch:{ all -> 0x0071 }
            r1 = 0
            if (r7 != 0) goto L_0x004a
            r6.emitting = r1     // Catch:{ all -> 0x0071 }
            monitor-exit(r6)     // Catch:{ all -> 0x0071 }
            goto L_0x0070
        L_0x004a:
            r2 = 0
            r6.queue = r2     // Catch:{ all -> 0x0071 }
            monitor-exit(r6)     // Catch:{ all -> 0x0071 }
            io.reactivex.Observer<? super T> r2 = r6.downstream
            java.lang.Object[] r3 = r7.head
            int r7 = r7.capacity
        L_0x0054:
            if (r3 == 0) goto L_0x006e
            r4 = 0
        L_0x0057:
            if (r4 >= r7) goto L_0x0069
            r5 = r3[r4]
            if (r5 != 0) goto L_0x005e
            goto L_0x0069
        L_0x005e:
            boolean r5 = io.reactivex.internal.util.NotificationLite.acceptFull(r5, r2)
            if (r5 == 0) goto L_0x0066
            r1 = 1
            goto L_0x006e
        L_0x0066:
            int r4 = r4 + 1
            goto L_0x0057
        L_0x0069:
            r3 = r3[r7]
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            goto L_0x0054
        L_0x006e:
            if (r1 == 0) goto L_0x0040
        L_0x0070:
            return
        L_0x0071:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0071 }
            throw r7
        L_0x0074:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0074 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.observers.SerializedObserver.onNext(java.lang.Object):void");
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.upstream, disposable)) {
            this.upstream = disposable;
            this.downstream.onSubscribe(this);
        }
    }
}
