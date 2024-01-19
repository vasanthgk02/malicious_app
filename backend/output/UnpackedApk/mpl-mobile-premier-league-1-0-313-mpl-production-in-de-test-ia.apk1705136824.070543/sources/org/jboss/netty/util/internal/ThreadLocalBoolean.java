package org.jboss.netty.util.internal;

public class ThreadLocalBoolean extends ThreadLocal<Boolean> {
    public final boolean defaultValue;

    public ThreadLocalBoolean() {
        this(false);
    }

    public ThreadLocalBoolean(boolean z) {
        this.defaultValue = z;
    }

    public Boolean initialValue() {
        return this.defaultValue ? Boolean.TRUE : Boolean.FALSE;
    }
}
