package com.netcore.android.module;

public interface IDataPublisher {
    IMessageBroker getLinkedMessageBroker();

    String[] getPublishingEvents();

    void setMessageBroker(IMessageBroker iMessageBroker);
}
