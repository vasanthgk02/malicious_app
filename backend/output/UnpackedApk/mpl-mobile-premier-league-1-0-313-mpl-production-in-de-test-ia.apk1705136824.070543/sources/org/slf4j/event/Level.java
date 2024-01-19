package org.slf4j.event;

import io.antmedia.android.broadcaster.LiveVideoBroadcaster;

public enum Level {
    ERROR(40, "ERROR"),
    WARN(30, "WARN"),
    INFO(20, LiveVideoBroadcaster.INFO),
    DEBUG(10, "DEBUG"),
    TRACE(0, "TRACE");
    
    public int levelInt;
    public String levelStr;

    /* access modifiers changed from: public */
    Level(int i, String str) {
        this.levelInt = i;
        this.levelStr = str;
    }

    public int toInt() {
        return this.levelInt;
    }

    public String toString() {
        return this.levelStr;
    }
}
