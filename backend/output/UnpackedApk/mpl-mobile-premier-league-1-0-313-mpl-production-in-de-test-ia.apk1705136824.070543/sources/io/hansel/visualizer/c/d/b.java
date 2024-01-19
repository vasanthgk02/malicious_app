package io.hansel.visualizer.c.d;

import android.app.Activity;
import io.hansel.core.module.EventsConstants;
import io.hansel.core.module.IMessageBroker;

public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final b f5785b = new b();

    /* renamed from: a  reason: collision with root package name */
    public IMessageBroker f5786a;

    public static b a() {
        return f5785b;
    }

    public void a(IMessageBroker iMessageBroker) {
        this.f5786a = iMessageBroker;
    }

    public Activity b() {
        Object returnEventData = this.f5786a.returnEventData(EventsConstants.GET_TOP_ACTIVITY.name(), null);
        if (returnEventData instanceof Activity) {
            return (Activity) returnEventData;
        }
        return null;
    }
}
