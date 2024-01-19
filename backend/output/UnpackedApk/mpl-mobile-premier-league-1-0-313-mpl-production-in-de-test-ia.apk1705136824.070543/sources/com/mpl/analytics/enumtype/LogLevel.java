package com.mpl.analytics.enumtype;

public enum LogLevel {
    OFF(-1),
    INFO(0),
    DEBUG(2);
    
    public final int value;

    /* access modifiers changed from: public */
    LogLevel(int i) {
        this.value = i;
    }

    public int intValue() {
        return this.value;
    }
}
