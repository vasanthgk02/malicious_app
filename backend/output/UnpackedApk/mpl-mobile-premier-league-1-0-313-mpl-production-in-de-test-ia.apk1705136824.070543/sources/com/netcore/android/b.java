package com.netcore.android;

import com.netcore.android.module.IDataSubscriber;
import com.netcore.android.module.IMessageBroker;
import com.netcore.android.module.MessageBroker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SmartechActionImpl.kt */
public final class b implements IMessageBroker {

    /* renamed from: a  reason: collision with root package name */
    public final MessageBroker f1015a = new MessageBroker();

    public void publishBlockingEvent(String str, Object obj) {
        this.f1015a.publishBlockingEvent(str, obj);
    }

    public void publishEvent(String str, Object obj) {
        this.f1015a.publishEvent(str, obj);
    }

    public Object returnEventData(String str, Object obj) {
        Object publishBlockingEventForReturn = this.f1015a.publishBlockingEventForReturn(str, obj);
        Intrinsics.checkNotNullExpressionValue(publishBlockingEventForReturn, "messageBroker.publishBlo…entForReturn(event, data)");
        return publishBlockingEventForReturn;
    }

    public void setSubscriber(String str, IDataSubscriber iDataSubscriber) {
        this.f1015a.setSubscriber(str, iDataSubscriber);
    }
}
