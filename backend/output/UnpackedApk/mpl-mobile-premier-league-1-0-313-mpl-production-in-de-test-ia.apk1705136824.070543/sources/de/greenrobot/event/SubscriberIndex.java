package de.greenrobot.event;

import java.util.HashMap;
import java.util.Map;

public abstract class SubscriberIndex {
    public Map<Class<?>, SubscriberMethod[]> map = new HashMap();

    public SubscriberMethod createSubscriberMethod(Class<?> cls, String str, Class<?> cls2, ThreadMode threadMode, int i, boolean z) {
        try {
            SubscriberMethod subscriberMethod = new SubscriberMethod(cls.getDeclaredMethod(str, new Class[]{cls2}), cls2, threadMode, i, z);
            return subscriberMethod;
        } catch (NoSuchMethodException e2) {
            throw new EventBusException("Could not find subscriber method in " + cls + ". Maybe a missing ProGuard rule?", e2);
        }
    }

    public abstract SubscriberMethod[] createSubscribersFor(Class<?> cls);

    public SubscriberMethod[] getSubscribersFor(Class<?> cls) {
        SubscriberMethod[] subscriberMethodArr = this.map.get(cls);
        if (subscriberMethodArr == null) {
            subscriberMethodArr = createSubscribersFor(cls);
            if (subscriberMethodArr != null) {
                this.map.put(cls, subscriberMethodArr);
            }
        }
        return subscriberMethodArr;
    }
}
