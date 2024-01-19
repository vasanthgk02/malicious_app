package com.netcore.android.module;

public interface IMessageBroker {
    void publishBlockingEvent(String str, Object obj);

    void publishEvent(String str, Object obj);

    Object returnEventData(String str, Object obj);

    void setSubscriber(String str, IDataSubscriber iDataSubscriber);
}
