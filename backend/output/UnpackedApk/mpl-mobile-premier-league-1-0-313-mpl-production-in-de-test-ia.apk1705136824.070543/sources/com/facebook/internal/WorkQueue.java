package com.facebook.internal;

import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.WorkQueue.WorkNode;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0003\u001a\u001b\u001cB\u001b\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007J\u0014\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\bR\u00020\u0000H\u0002J\u0016\u0010\u0016\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0018\u00010\bR\u00020\u0000H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\u0006\u0010\u0019\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0018\u00010\bR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0018\u00010\bR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/facebook/internal/WorkQueue;", "", "maxConcurrent", "", "executor", "Ljava/util/concurrent/Executor;", "(ILjava/util/concurrent/Executor;)V", "pendingJobs", "Lcom/facebook/internal/WorkQueue$WorkNode;", "runningCount", "runningJobs", "workLock", "Ljava/util/concurrent/locks/ReentrantLock;", "addActiveWorkItem", "Lcom/facebook/internal/WorkQueue$WorkItem;", "callback", "Ljava/lang/Runnable;", "addToFront", "", "execute", "", "node", "finishItemAndStartNew", "finished", "startItem", "validate", "Companion", "WorkItem", "WorkNode", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: WorkQueue.kt */
public final class WorkQueue {
    public static final Companion Companion = new Companion(null);
    public final Executor executor;
    public final int maxConcurrent;
    public WorkNode pendingJobs;
    public int runningCount;
    public WorkNode runningJobs;
    public final ReentrantLock workLock;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/facebook/internal/WorkQueue$Companion;", "", "()V", "DEFAULT_MAX_CONCURRENT", "", "assert", "", "condition", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: WorkQueue.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/facebook/internal/WorkQueue$WorkItem;", "", "isRunning", "", "()Z", "cancel", "moveToFront", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: WorkQueue.kt */
    public interface WorkItem {
        boolean cancel();

        void moveToFront();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0012\u001a\u00060\u0000R\u00020\r2\f\u0010\u0013\u001a\b\u0018\u00010\u0000R\u00020\r2\u0006\u0010\u0014\u001a\u00020\bJ\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\b\u0018\u00010\u0000R\u00020\r2\f\u0010\u0013\u001a\b\u0018\u00010\u0000R\u00020\rJ\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\u000e\u001a\b\u0018\u00010\u0000R\u00020\r2\f\u0010\f\u001a\b\u0018\u00010\u0000R\u00020\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0018\u00010\u0000R\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/facebook/internal/WorkQueue$WorkNode;", "Lcom/facebook/internal/WorkQueue$WorkItem;", "callback", "Ljava/lang/Runnable;", "(Lcom/facebook/internal/WorkQueue;Ljava/lang/Runnable;)V", "getCallback", "()Ljava/lang/Runnable;", "isRunning", "", "()Z", "setRunning", "(Z)V", "<set-?>", "Lcom/facebook/internal/WorkQueue;", "next", "getNext", "()Lcom/facebook/internal/WorkQueue$WorkNode;", "prev", "addToList", "list", "addToFront", "cancel", "moveToFront", "", "removeFromList", "verify", "shouldBeRunning", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: WorkQueue.kt */
    public final class WorkNode implements WorkItem {
        public final Runnable callback;
        public boolean isRunning;
        public WorkNode next;
        public WorkNode prev;
        public final /* synthetic */ WorkQueue this$0;

        public WorkNode(WorkQueue workQueue, Runnable runnable) {
            Intrinsics.checkNotNullParameter(workQueue, "this$0");
            Intrinsics.checkNotNullParameter(runnable, "callback");
            this.this$0 = workQueue;
            this.callback = runnable;
        }

        public final WorkNode addToList(WorkNode workNode, boolean z) {
            boolean z2 = true;
            if (this.next == null) {
                if (this.prev != null) {
                    z2 = false;
                }
                if (z2) {
                    if (workNode == null) {
                        this.prev = this;
                        this.next = this;
                        workNode = this;
                    } else {
                        this.next = workNode;
                        WorkNode workNode2 = workNode.prev;
                        this.prev = workNode2;
                        if (workNode2 != null) {
                            workNode2.next = this;
                        }
                        WorkNode workNode3 = this.next;
                        if (workNode3 != null) {
                            WorkNode workNode4 = this.prev;
                            workNode3.prev = workNode4 == null ? null : workNode4.next;
                        }
                    }
                    return z ? this : workNode;
                }
                throw new FacebookException((String) "Validation failed");
            }
            throw new FacebookException((String) "Validation failed");
        }

        public boolean cancel() {
            WorkQueue workQueue = this.this$0;
            ReentrantLock reentrantLock = workQueue.workLock;
            reentrantLock.lock();
            try {
                if (!this.isRunning) {
                    workQueue.pendingJobs = removeFromList(workQueue.pendingJobs);
                    return true;
                }
                reentrantLock.unlock();
                return false;
            } finally {
                reentrantLock.unlock();
            }
        }

        public void moveToFront() {
            WorkQueue workQueue = this.this$0;
            ReentrantLock reentrantLock = workQueue.workLock;
            reentrantLock.lock();
            try {
                if (!this.isRunning) {
                    WorkNode removeFromList = removeFromList(workQueue.pendingJobs);
                    workQueue.pendingJobs = removeFromList;
                    workQueue.pendingJobs = addToList(removeFromList, true);
                }
            } finally {
                reentrantLock.unlock();
            }
        }

        public final WorkNode removeFromList(WorkNode workNode) {
            boolean z = true;
            if (this.next != null) {
                if (this.prev == null) {
                    z = false;
                }
                if (z) {
                    if (workNode == this) {
                        workNode = this.next;
                        if (workNode == this) {
                            workNode = null;
                        }
                    }
                    WorkNode workNode2 = this.next;
                    if (workNode2 != null) {
                        workNode2.prev = this.prev;
                    }
                    WorkNode workNode3 = this.prev;
                    if (workNode3 != null) {
                        workNode3.next = this.next;
                    }
                    this.prev = null;
                    this.next = null;
                    return workNode;
                }
                throw new FacebookException((String) "Validation failed");
            }
            throw new FacebookException((String) "Validation failed");
        }
    }

    public WorkQueue(int i, Executor executor2, int i2) {
        Executor executor3;
        i = (i2 & 1) != 0 ? 8 : i;
        if ((i2 & 2) != 0) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            executor3 = FacebookSdk.getExecutor();
        } else {
            executor3 = null;
        }
        Intrinsics.checkNotNullParameter(executor3, "executor");
        this.maxConcurrent = i;
        this.executor = executor3;
        this.workLock = new ReentrantLock();
    }

    /* renamed from: execute$lambda-2  reason: not valid java name */
    public static final void m211execute$lambda2(WorkNode workNode, WorkQueue workQueue) {
        Intrinsics.checkNotNullParameter(workNode, "$node");
        Intrinsics.checkNotNullParameter(workQueue, "this$0");
        try {
            workNode.callback.run();
        } finally {
            workQueue.finishItemAndStartNew(workNode);
        }
    }

    public final void finishItemAndStartNew(WorkNode workNode) {
        WorkNode workNode2;
        this.workLock.lock();
        if (workNode != null) {
            this.runningJobs = workNode.removeFromList(this.runningJobs);
            this.runningCount--;
        }
        if (this.runningCount < this.maxConcurrent) {
            workNode2 = this.pendingJobs;
            if (workNode2 != null) {
                this.pendingJobs = workNode2.removeFromList(workNode2);
                this.runningJobs = workNode2.addToList(this.runningJobs, false);
                this.runningCount++;
                workNode2.isRunning = true;
            }
        } else {
            workNode2 = null;
        }
        this.workLock.unlock();
        if (workNode2 != null) {
            this.executor.execute(new Runnable(this) {
                public final /* synthetic */ WorkQueue f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    WorkQueue.m211execute$lambda2(WorkNode.this, this.f$1);
                }
            });
        }
    }
}
