package io.reactivex.disposables;

import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.OpenHashSet;

public final class CompositeDisposable implements Disposable, DisposableContainer {
    public volatile boolean disposed;
    public OpenHashSet<Disposable> resources;

    public boolean add(Disposable disposable) {
        ObjectHelper.requireNonNull(disposable, "d is null");
        if (!this.disposed) {
            synchronized (this) {
                if (!this.disposed) {
                    OpenHashSet<Disposable> openHashSet = this.resources;
                    if (openHashSet == null) {
                        openHashSet = new OpenHashSet<>();
                        this.resources = openHashSet;
                    }
                    openHashSet.add(disposable);
                    return true;
                }
            }
        }
        disposable.dispose();
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004c, code lost:
        return false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0049 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean delete(io.reactivex.disposables.Disposable r8) {
        /*
            r7 = this;
            java.lang.String r0 = "Disposable item is null"
            io.reactivex.internal.functions.ObjectHelper.requireNonNull(r8, r0)
            boolean r0 = r7.disposed
            r1 = 0
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            monitor-enter(r7)
            boolean r0 = r7.disposed     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r7)     // Catch:{ all -> 0x004d }
            return r1
        L_0x0012:
            io.reactivex.internal.util.OpenHashSet<io.reactivex.disposables.Disposable> r0 = r7.resources     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x004b
            T[] r2 = r0.keys     // Catch:{ all -> 0x004d }
            int r3 = r0.mask     // Catch:{ all -> 0x004d }
            int r4 = r8.hashCode()     // Catch:{ all -> 0x004d }
            int r4 = io.reactivex.internal.util.OpenHashSet.mix(r4)     // Catch:{ all -> 0x004d }
            r4 = r4 & r3
            r5 = r2[r4]     // Catch:{ all -> 0x004d }
            r6 = 1
            if (r5 != 0) goto L_0x002a
        L_0x0028:
            r8 = 0
            goto L_0x0046
        L_0x002a:
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x004d }
            if (r5 == 0) goto L_0x0035
            r0.removeEntry(r4, r2, r3)     // Catch:{ all -> 0x004d }
        L_0x0033:
            r8 = 1
            goto L_0x0046
        L_0x0035:
            int r4 = r4 + r6
            r4 = r4 & r3
            r5 = r2[r4]     // Catch:{ all -> 0x004d }
            if (r5 != 0) goto L_0x003c
            goto L_0x0028
        L_0x003c:
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x004d }
            if (r5 == 0) goto L_0x0035
            r0.removeEntry(r4, r2, r3)     // Catch:{ all -> 0x004d }
            goto L_0x0033
        L_0x0046:
            if (r8 != 0) goto L_0x0049
            goto L_0x004b
        L_0x0049:
            monitor-exit(r7)     // Catch:{ all -> 0x004d }
            return r6
        L_0x004b:
            monitor-exit(r7)     // Catch:{ all -> 0x004d }
            return r1
        L_0x004d:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x004d }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.disposables.CompositeDisposable.delete(io.reactivex.disposables.Disposable):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
        if (r1 != null) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        r1 = r1.keys;
        r3 = r1.length;
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        if (r5 >= r3) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        r6 = r1[r5];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        if ((r6 instanceof io.reactivex.disposables.Disposable) == false) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        ((io.reactivex.disposables.Disposable) r6).dispose();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002c, code lost:
        com.twitter.sdk.android.tweetui.TweetUtils.throwIfFatal(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002f, code lost:
        if (r2 == null) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0031, code lost:
        r2 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0036, code lost:
        r2.add(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003c, code lost:
        if (r2 == null) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0042, code lost:
        if (r2.size() != 1) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004e, code lost:
        throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow((java.lang.Throwable) r2.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0054, code lost:
        throw new io.reactivex.exceptions.CompositeException(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0055, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispose() {
        /*
            r8 = this;
            boolean r0 = r8.disposed
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r8)
            boolean r0 = r8.disposed     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r8)     // Catch:{ all -> 0x0056 }
            return
        L_0x000c:
            r0 = 1
            r8.disposed = r0     // Catch:{ all -> 0x0056 }
            io.reactivex.internal.util.OpenHashSet<io.reactivex.disposables.Disposable> r1 = r8.resources     // Catch:{ all -> 0x0056 }
            r2 = 0
            r8.resources = r2     // Catch:{ all -> 0x0056 }
            monitor-exit(r8)     // Catch:{ all -> 0x0056 }
            if (r1 != 0) goto L_0x0018
            goto L_0x0055
        L_0x0018:
            T[] r1 = r1.keys
            int r3 = r1.length
            r4 = 0
            r5 = 0
        L_0x001d:
            if (r5 >= r3) goto L_0x003c
            r6 = r1[r5]
            boolean r7 = r6 instanceof io.reactivex.disposables.Disposable
            if (r7 == 0) goto L_0x0039
            io.reactivex.disposables.Disposable r6 = (io.reactivex.disposables.Disposable) r6     // Catch:{ all -> 0x002b }
            r6.dispose()     // Catch:{ all -> 0x002b }
            goto L_0x0039
        L_0x002b:
            r6 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.throwIfFatal(r6)
            if (r2 != 0) goto L_0x0036
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L_0x0036:
            r2.add(r6)
        L_0x0039:
            int r5 = r5 + 1
            goto L_0x001d
        L_0x003c:
            if (r2 == 0) goto L_0x0055
            int r1 = r2.size()
            if (r1 != r0) goto L_0x004f
            java.lang.Object r0 = r2.get(r4)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            java.lang.RuntimeException r0 = io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(r0)
            throw r0
        L_0x004f:
            io.reactivex.exceptions.CompositeException r0 = new io.reactivex.exceptions.CompositeException
            r0.<init>(r2)
            throw r0
        L_0x0055:
            return
        L_0x0056:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0056 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.disposables.CompositeDisposable.dispose():void");
    }

    public boolean remove(Disposable disposable) {
        if (!delete(disposable)) {
            return false;
        }
        disposable.dispose();
        return true;
    }
}
