package io.hansel.core.module;

public interface IMessageBroker {
    void enqueue(Runnable runnable);

    void publishBlockingEvent(String str, Object obj);

    void publishEvent(String str, Object obj);

    Object returnEventData(String str, Object obj);

    void setSubscriber(String str, a aVar);
}
