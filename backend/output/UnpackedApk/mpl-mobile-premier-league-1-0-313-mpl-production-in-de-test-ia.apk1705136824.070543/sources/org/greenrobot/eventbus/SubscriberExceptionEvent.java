package org.greenrobot.eventbus;

public final class SubscriberExceptionEvent {
    public final Object causingEvent;
    public final Object causingSubscriber;
    public final Throwable throwable;

    public SubscriberExceptionEvent(EventBus eventBus, Throwable th, Object obj, Object obj2) {
        this.throwable = th;
        this.causingEvent = obj;
        this.causingSubscriber = obj2;
    }
}
