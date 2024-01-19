package org.greenrobot.eventbus;

public final class PendingPostQueue {
    public PendingPost head;
    public PendingPost tail;

    public synchronized void enqueue(PendingPost pendingPost) {
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
}
