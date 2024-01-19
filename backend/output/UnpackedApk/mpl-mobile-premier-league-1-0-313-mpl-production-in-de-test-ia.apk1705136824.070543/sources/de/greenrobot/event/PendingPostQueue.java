package de.greenrobot.event;

public final class PendingPostQueue {
    public PendingPost head;
    public PendingPost tail;

    public synchronized void enqueue(PendingPost pendingPost) {
        if (pendingPost != null) {
            try {
                if (this.tail != null) {
                    this.tail.next = pendingPost;
                    this.tail = pendingPost;
                } else if (this.head == null) {
                    this.tail = pendingPost;
                    this.head = pendingPost;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new NullPointerException("null cannot be enqueued");
        }
    }

    public synchronized PendingPost poll() {
        PendingPost pendingPost;
        try {
            pendingPost = this.head;
            if (this.head != null) {
                PendingPost pendingPost2 = this.head.next;
                this.head = pendingPost2;
                if (pendingPost2 == null) {
                    this.tail = null;
                }
            }
        }
        return pendingPost;
    }

    public synchronized PendingPost poll(int i) throws InterruptedException {
        try {
            if (this.head == null) {
                wait((long) i);
            }
        }
        return poll();
    }
}
