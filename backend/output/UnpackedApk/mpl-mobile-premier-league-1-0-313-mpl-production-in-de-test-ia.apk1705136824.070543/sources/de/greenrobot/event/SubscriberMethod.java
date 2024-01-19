package de.greenrobot.event;

import java.lang.reflect.Method;

public final class SubscriberMethod {
    public final Class<?> eventType;
    public final Method method;
    public String methodString;
    public final int priority;
    public final boolean sticky;
    public final ThreadMode threadMode;

    public SubscriberMethod(Method method2, Class<?> cls, ThreadMode threadMode2, int i, boolean z) {
        this.method = method2;
        this.threadMode = threadMode2;
        this.eventType = cls;
        this.priority = i;
        this.sticky = z;
    }

    private synchronized void checkMethodString() {
        if (this.methodString == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.method.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.method.getName());
            sb.append('(');
            sb.append(this.eventType.getName());
            this.methodString = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SubscriberMethod)) {
            return false;
        }
        checkMethodString();
        SubscriberMethod subscriberMethod = (SubscriberMethod) obj;
        subscriberMethod.checkMethodString();
        return this.methodString.equals(subscriberMethod.methodString);
    }

    public int hashCode() {
        return this.method.hashCode();
    }
}
