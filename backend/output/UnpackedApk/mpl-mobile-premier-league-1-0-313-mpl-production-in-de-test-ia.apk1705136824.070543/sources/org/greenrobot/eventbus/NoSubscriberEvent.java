package org.greenrobot.eventbus;

public final class NoSubscriberEvent {
    public final Object originalEvent;

    public NoSubscriberEvent(EventBus eventBus, Object obj) {
        this.originalEvent = obj;
    }
}
