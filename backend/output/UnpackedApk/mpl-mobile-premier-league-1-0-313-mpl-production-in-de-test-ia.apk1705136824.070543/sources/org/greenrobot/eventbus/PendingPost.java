package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;

public final class PendingPost {
    public static final List<PendingPost> pendingPostPool = new ArrayList();
    public Object event;
    public PendingPost next;
    public Subscription subscription;

    public PendingPost(Object obj, Subscription subscription2) {
        this.event = obj;
        this.subscription = subscription2;
    }

    public static PendingPost obtainPendingPost(Subscription subscription2, Object obj) {
        synchronized (pendingPostPool) {
            try {
                int size = pendingPostPool.size();
                if (size <= 0) {
                    return new PendingPost(obj, subscription2);
                }
                PendingPost remove = pendingPostPool.remove(size - 1);
                remove.event = obj;
                remove.subscription = subscription2;
                remove.next = null;
                return remove;
            }
        }
    }
}
