package org.greenrobot.eventbus;

public final class Subscription {
    public volatile boolean active = true;
    public final Object subscriber;
    public final SubscriberMethod subscriberMethod;

    public Subscription(Object obj, SubscriberMethod subscriberMethod2) {
        this.subscriber = obj;
        this.subscriberMethod = subscriberMethod2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Subscription)) {
            return false;
        }
        Subscription subscription = (Subscription) obj;
        if (this.subscriber != subscription.subscriber || !this.subscriberMethod.equals(subscription.subscriberMethod)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.subscriberMethod.methodString.hashCode() + this.subscriber.hashCode();
    }
}
