package com.netcore.android.module;

public abstract class SMTModule implements IDataPublisher, IDataSubscriber {
    public String TAG = SMTModule.class.getSimpleName();
    public IMessageBroker messageBroker;
    public SMTModuleInitializationData smtModuleInitializationData;

    public abstract String getCode();

    public IMessageBroker getLinkedMessageBroker() {
        return this.messageBroker;
    }

    public void init(SMTModuleInitializationData sMTModuleInitializationData, IMessageBroker iMessageBroker) {
        this.messageBroker = iMessageBroker;
        this.smtModuleInitializationData = sMTModuleInitializationData;
        subscribe(iMessageBroker);
    }

    public Object returnEventData(String str, Object obj) {
        return null;
    }

    public void setMessageBroker(IMessageBroker iMessageBroker) {
        this.messageBroker = iMessageBroker;
    }

    public void subscribe(IMessageBroker iMessageBroker) {
        for (String subscriber : getSubscribingEvents()) {
            iMessageBroker.setSubscriber(subscriber, this);
        }
    }
}
