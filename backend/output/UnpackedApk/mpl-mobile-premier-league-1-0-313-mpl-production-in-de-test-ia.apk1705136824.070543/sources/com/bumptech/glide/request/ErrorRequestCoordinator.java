package com.bumptech.glide.request;

import com.bumptech.glide.request.RequestCoordinator.RequestState;

public final class ErrorRequestCoordinator implements RequestCoordinator, Request {
    public volatile Request error;
    public RequestState errorState;
    public final RequestCoordinator parent;
    public volatile Request primary;
    public RequestState primaryState;
    public final Object requestLock;

    public ErrorRequestCoordinator(Object obj, RequestCoordinator requestCoordinator) {
        RequestState requestState = RequestState.CLEARED;
        this.primaryState = requestState;
        this.errorState = requestState;
        this.requestLock = obj;
        this.parent = requestCoordinator;
    }

    public void begin() {
        synchronized (this.requestLock) {
            if (this.primaryState != RequestState.RUNNING) {
                this.primaryState = RequestState.RUNNING;
                this.primary.begin();
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
                    if (z2 || !isValidRequest(request)) {
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
                    if (z2 || !isValidRequest(request)) {
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

    public boolean canSetImage(Request request) {
        boolean z;
        boolean z2;
        synchronized (this.requestLock) {
            RequestCoordinator requestCoordinator = this.parent;
            z = true;
            if (requestCoordinator != null) {
                if (!requestCoordinator.canSetImage(this)) {
                    z2 = false;
                    if (z2 || !isValidRequest(request)) {
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

    public void clear() {
        synchronized (this.requestLock) {
            this.primaryState = RequestState.CLEARED;
            this.primary.clear();
            if (this.errorState != RequestState.CLEARED) {
                this.errorState = RequestState.CLEARED;
                this.error.clear();
            }
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
            if (!this.primary.isAnyResourceSet()) {
                if (!this.error.isAnyResourceSet()) {
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
            z = this.primaryState == RequestState.CLEARED && this.errorState == RequestState.CLEARED;
        }
        return z;
    }

    public boolean isComplete() {
        boolean z;
        synchronized (this.requestLock) {
            if (this.primaryState != RequestState.SUCCESS) {
                if (this.errorState != RequestState.SUCCESS) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public boolean isEquivalentTo(Request request) {
        if (!(request instanceof ErrorRequestCoordinator)) {
            return false;
        }
        ErrorRequestCoordinator errorRequestCoordinator = (ErrorRequestCoordinator) request;
        if (!this.primary.isEquivalentTo(errorRequestCoordinator.primary) || !this.error.isEquivalentTo(errorRequestCoordinator.error)) {
            return false;
        }
        return true;
    }

    public boolean isRunning() {
        boolean z;
        synchronized (this.requestLock) {
            if (this.primaryState != RequestState.RUNNING) {
                if (this.errorState != RequestState.RUNNING) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public final boolean isValidRequest(Request request) {
        return request.equals(this.primary) || (this.primaryState == RequestState.FAILED && request.equals(this.error));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRequestFailed(com.bumptech.glide.request.Request r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.requestLock
            monitor-enter(r0)
            com.bumptech.glide.request.Request r1 = r2.error     // Catch:{ all -> 0x002f }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x002f }
            if (r3 != 0) goto L_0x0020
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x002f }
            r2.primaryState = r3     // Catch:{ all -> 0x002f }
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = r2.errorState     // Catch:{ all -> 0x002f }
            com.bumptech.glide.request.RequestCoordinator$RequestState r1 = com.bumptech.glide.request.RequestCoordinator.RequestState.RUNNING     // Catch:{ all -> 0x002f }
            if (r3 == r1) goto L_0x001e
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.RUNNING     // Catch:{ all -> 0x002f }
            r2.errorState = r3     // Catch:{ all -> 0x002f }
            com.bumptech.glide.request.Request r3 = r2.error     // Catch:{ all -> 0x002f }
            r3.begin()     // Catch:{ all -> 0x002f }
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return
        L_0x0020:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x002f }
            r2.errorState = r3     // Catch:{ all -> 0x002f }
            com.bumptech.glide.request.RequestCoordinator r3 = r2.parent     // Catch:{ all -> 0x002f }
            if (r3 == 0) goto L_0x002d
            com.bumptech.glide.request.RequestCoordinator r3 = r2.parent     // Catch:{ all -> 0x002f }
            r3.onRequestFailed(r2)     // Catch:{ all -> 0x002f }
        L_0x002d:
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return
        L_0x002f:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ErrorRequestCoordinator.onRequestFailed(com.bumptech.glide.request.Request):void");
    }

    public void onRequestSuccess(Request request) {
        synchronized (this.requestLock) {
            if (request.equals(this.primary)) {
                this.primaryState = RequestState.SUCCESS;
            } else if (request.equals(this.error)) {
                this.errorState = RequestState.SUCCESS;
            }
            if (this.parent != null) {
                this.parent.onRequestSuccess(this);
            }
        }
    }

    public void pause() {
        synchronized (this.requestLock) {
            if (this.primaryState == RequestState.RUNNING) {
                this.primaryState = RequestState.PAUSED;
                this.primary.pause();
            }
            if (this.errorState == RequestState.RUNNING) {
                this.errorState = RequestState.PAUSED;
                this.error.pause();
            }
        }
    }
}
