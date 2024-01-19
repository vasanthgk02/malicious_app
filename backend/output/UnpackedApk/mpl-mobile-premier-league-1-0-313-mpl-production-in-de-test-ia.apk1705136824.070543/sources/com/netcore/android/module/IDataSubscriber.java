package com.netcore.android.module;

public interface IDataSubscriber {
    String[] getSubscribingEvents();

    boolean handleEventData(String str, Object obj);

    Object returnEventData(String str, Object obj);

    void subscribe(IMessageBroker iMessageBroker);
}
