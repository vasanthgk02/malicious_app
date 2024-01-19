package com.bumptech.glide.request;

import com.bumptech.glide.request.RequestCoordinator.RequestState;

public class ThumbnailRequestCoordinator implements RequestCoordinator, Request {
    public volatile Request full;
    public RequestState fullState;
    public boolean isRunningDuringBegin;
    public final RequestCoordinator parent;
    public final Object requestLock;
    public volatile Request thumb;
    public RequestState thumbState;

    public ThumbnailRequestCoordinator(Object obj, RequestCoordinator requestCoordinator) {
        RequestState requestState = RequestState.CLEARED;
        this.fullState = requestState;
        this.thumbState = requestState;
        this.requestLock = obj;
        this.parent = requestCoordinator;
    }

    public void begin() {
        synchronized (this.requestLock) {
            this.isRunningDuringBegin = true;
            try {
                if (!(this.fullState == RequestState.SUCCESS || this.thumbState == RequestState.RUNNING)) {
                    this.thumbState = RequestState.RUNNING;
                    this.thumb.begin();
                }
                if (this.isRunningDuringBegin && this.fullState != RequestState.RUNNING) {
                    this.fullState = RequestState.RUNNING;
                    this.full.begin();
                }
            } finally {
                this.isRunningDuringBegin = false;
            }
        }
    }

    public boolean canNotifyCleared(Request request) {
        boolean z;
        boolean z2;
        synchronized (this.requestLock) {
            RequestCoordinator requestCoordinator = this.parent;
            z = true;
            if (requestCoordinator != null) {
                if (!requestCoordinator.canNotifyCleared(this)) {
                    z2 = false;
                    if (z2 || !request.equals(this.full) || this.fullState == RequestState.PAUSED) {
                        z = false;
                    }
                }
            }
            z2 = true;
            if (z2) {
            }
            z = false;
        }
        return z;
    }

    public boolean canNotifyStatusChanged(Request request) {
        boolean z;
        boolean z2;
        synchronized (this.requestLock) {
            RequestCoordinator requestCoordinator = this.parent;
            z = true;
            if (requestCoordinator != null) {
                if (!requestCoordinator.canNotifyStatusChanged(this)) {
                    z2 = false;
                    if (z2 || !request.equals(this.full) || isAnyResourceSet()) {
                        z = false;
                    }
                }
            }
            z2 = true;
            if (z2) {
            }
            z = false;
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0015  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean canSetImage(com.bumptech.glide.request.Request r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.requestLock
            monitor-enter(r0)
            com.bumptech.glide.request.RequestCoordinator r1 = r4.parent     // Catch:{ all -> 0x0027 }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0012
            boolean r1 = r1.canSetImage(r4)     // Catch:{ all -> 0x0027 }
            if (r1 == 0) goto L_0x0010
            goto L_0x0012
        L_0x0010:
            r1 = 0
            goto L_0x0013
        L_0x0012:
            r1 = 1
        L_0x0013:
            if (r1 == 0) goto L_0x0024
            com.bumptech.glide.request.Request r1 = r4.full     // Catch:{ all -> 0x0027 }
            boolean r5 = r5.equals(r1)     // Catch:{ all -> 0x0027 }
            if (r5 != 0) goto L_0x0025
            com.bumptech.glide.request.RequestCoordinator$RequestState r5 = r4.fullState     // Catch:{ all -> 0x0027 }
            com.bumptech.glide.request.RequestCoordinator$RequestState r1 = com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS     // Catch:{ all -> 0x0027 }
            if (r5 == r1) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r2 = 0
        L_0x0025:
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return r2
        L_0x0027:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ThumbnailRequestCoordinator.canSetImage(com.bumptech.glide.request.Request):boolean");
    }

    public void clear() {
        synchronized (this.requestLock) {
            this.isRunningDuringBegin = false;
            this.fullState = RequestState.CLEARED;
            this.thumbState = RequestState.CLEARED;
            this.thumb.clear();
            this.full.clear();
        }
    }

    public RequestCoordinator getRoot() {
        RequestCoordinator root;
        synchronized (this.requestLock) {
            root = this.parent != null ? this.parent.getRoot() : this;
        }
        return root;
    }

    public boolean isAnyResourceSet() {
        boolean z;
        synchronized (this.requestLock) {
            if (!this.thumb.isAnyResourceSet()) {
                if (!this.full.isAnyResourceSet()) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public boolean isCleared() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.fullState == RequestState.CLEARED;
        }
        return z;
    }

    public boolean isComplete() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.fullState == RequestState.SUCCESS;
        }
        return z;
    }

    public boolean isEquivalentTo(Request request) {
        if (!(request instanceof ThumbnailRequestCoordinator)) {
            return false;
        }
        ThumbnailRequestCoordinator thumbnailRequestCoordinator = (ThumbnailRequestCoordinator) request;
        if (this.full == null) {
            if (thumbnailRequestCoordinator.full != null) {
                return false;
            }
        } else if (!this.full.isEquivalentTo(thumbnailRequestCoordinator.full)) {
            return false;
        }
        if (this.thumb == null) {
            if (thumbnailRequestCoordinator.thumb != null) {
                return false;
            }
        } else if (!this.thumb.isEquivalentTo(thumbnailRequestCoordinator.thumb)) {
            return false;
        }
        return true;
    }

    public boolean isRunning() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.fullState == RequestState.RUNNING;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRequestFailed(com.bumptech.glide.request.Request r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.requestLock
            monitor-enter(r0)
            com.bumptech.glide.request.Request r1 = r2.full     // Catch:{ all -> 0x0020 }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x0020 }
            if (r3 != 0) goto L_0x0011
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x0020 }
            r2.thumbState = r3     // Catch:{ all -> 0x0020 }
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return
        L_0x0011:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x0020 }
            r2.fullState = r3     // Catch:{ all -> 0x0020 }
            com.bumptech.glide.request.RequestCoordinator r3 = r2.parent     // Catch:{ all -> 0x0020 }
            if (r3 == 0) goto L_0x001e
            com.bumptech.glide.request.RequestCoordinator r3 = r2.parent     // Catch:{ all -> 0x0020 }
            r3.onRequestFailed(r2)     // Catch:{ all -> 0x0020 }
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return
        L_0x0020:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ThumbnailRequestCoordinator.onRequestFailed(com.bumptech.glide.request.Request):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRequestSuccess(com.bumptech.glide.request.Request r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.requestLock
            monitor-enter(r0)
            com.bumptech.glide.request.Request r1 = r2.thumb     // Catch:{ all -> 0x002d }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x002d }
            if (r3 == 0) goto L_0x0011
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS     // Catch:{ all -> 0x002d }
            r2.thumbState = r3     // Catch:{ all -> 0x002d }
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return
        L_0x0011:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS     // Catch:{ all -> 0x002d }
            r2.fullState = r3     // Catch:{ all -> 0x002d }
            com.bumptech.glide.request.RequestCoordinator r3 = r2.parent     // Catch:{ all -> 0x002d }
            if (r3 == 0) goto L_0x001e
            com.bumptech.glide.request.RequestCoordinator r3 = r2.parent     // Catch:{ all -> 0x002d }
            r3.onRequestSuccess(r2)     // Catch:{ all -> 0x002d }
        L_0x001e:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = r2.thumbState     // Catch:{ all -> 0x002d }
            boolean r3 = r3.isComplete()     // Catch:{ all -> 0x002d }
            if (r3 != 0) goto L_0x002b
            com.bumptech.glide.request.Request r3 = r2.thumb     // Catch:{ all -> 0x002d }
            r3.clear()     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return
        L_0x002d:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ThumbnailRequestCoordinator.onRequestSuccess(com.bumptech.glide.request.Request):void");
    }

    public void pause() {
        synchronized (this.requestLock) {
            if (!this.thumbState.isComplete()) {
                this.thumbState = RequestState.PAUSED;
                this.thumb.pause();
            }
            if (!this.fullState.isComplete()) {
                this.fullState = RequestState.PAUSED;
                this.full.pause();
            }
        }
    }
}
