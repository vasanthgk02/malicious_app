package de.greenrobot.event;

public class AsyncPoster implements Runnable {
    public final EventBus eventBus;
    public final PendingPostQueue queue = new PendingPostQueue();

    public AsyncPoster(EventBus eventBus2) {
        this.eventBus = eventBus2;
    }

    public void enqueue(Subscription subscription, Object obj) {
        this.queue.enqueue(PendingPost.obtainPendingPost(subscription, obj));
        this.eventBus.getExecutorService().execute(this);
    }

    public void run() {
        PendingPost poll = this.queue.poll();
        if (poll != null) {
            this.eventBus.invokeSubscriber(poll);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
