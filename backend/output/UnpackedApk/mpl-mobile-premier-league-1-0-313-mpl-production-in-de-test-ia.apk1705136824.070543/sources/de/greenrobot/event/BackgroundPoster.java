package de.greenrobot.event;

public final class BackgroundPoster implements Runnable {
    public final EventBus eventBus;
    public volatile boolean executorRunning;
    public final PendingPostQueue queue = new PendingPostQueue();

    public BackgroundPoster(EventBus eventBus2) {
        this.eventBus = eventBus2;
    }

    public void enqueue(Subscription subscription, Object obj) {
        PendingPost obtainPendingPost = PendingPost.obtainPendingPost(subscription, obj);
        synchronized (this) {
            this.queue.enqueue(obtainPendingPost);
            if (!this.executorRunning) {
                this.executorRunning = true;
                this.eventBus.getExecutorService().execute(this);
            }
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r3 = this;
        L_0x0000:
            r0 = 0
            de.greenrobot.event.PendingPostQueue r1 = r3.queue     // Catch:{ InterruptedException -> 0x0027 }
            r2 = 1000(0x3e8, float:1.401E-42)
            de.greenrobot.event.PendingPost r1 = r1.poll(r2)     // Catch:{ InterruptedException -> 0x0027 }
            if (r1 != 0) goto L_0x001f
            monitor-enter(r3)     // Catch:{ InterruptedException -> 0x0027 }
            de.greenrobot.event.PendingPostQueue r1 = r3.queue     // Catch:{ all -> 0x001c }
            de.greenrobot.event.PendingPost r1 = r1.poll()     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x001a
            r3.executorRunning = r0     // Catch:{ all -> 0x001c }
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            r3.executorRunning = r0
            return
        L_0x001a:
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            goto L_0x001f
        L_0x001c:
            r1 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            throw r1     // Catch:{ InterruptedException -> 0x0027 }
        L_0x001f:
            de.greenrobot.event.EventBus r2 = r3.eventBus     // Catch:{ InterruptedException -> 0x0027 }
            r2.invokeSubscriber(r1)     // Catch:{ InterruptedException -> 0x0027 }
            goto L_0x0000
        L_0x0025:
            r1 = move-exception
            goto L_0x0031
        L_0x0027:
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0025 }
            r1.getName()     // Catch:{ all -> 0x0025 }
            r3.executorRunning = r0
            return
        L_0x0031:
            r3.executorRunning = r0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: de.greenrobot.event.BackgroundPoster.run():void");
    }
}
