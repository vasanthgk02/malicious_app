package io.hansel.core.module;

import io.hansel.core.sdkmodels.HSLModuleInitializationData;
import io.hansel.core.security.ICrypto;

public abstract class HSLModule implements a {
    public ICrypto crypto;
    public IMessageBroker messageBroker;
    public HSLModuleInitializationData moduleInitializationData;

    public abstract String getCode();

    public ICrypto getCrypto() {
        return this.crypto;
    }

    public IMessageBroker getLinkedMessageBroker() {
        return this.messageBroker;
    }

    public abstract /* synthetic */ String[] getPublishingEvents();

    public abstract /* synthetic */ String[] getSubscribingEvents();

    public abstract /* synthetic */ boolean handleEventData(String str, Object obj);

    public void init(HSLModuleInitializationData hSLModuleInitializationData, IMessageBroker iMessageBroker, ICrypto iCrypto) {
        this.moduleInitializationData = hSLModuleInitializationData;
        this.crypto = iCrypto;
        this.messageBroker = iMessageBroker;
        subscribe(iMessageBroker);
    }

    public Object returnEventData(String str, Object obj) {
        return null;
    }

    public void setCrypto(ICrypto iCrypto) {
        this.crypto = iCrypto;
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
