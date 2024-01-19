package com.appsflyer.internal;

public class bk {
    public final long AFKeystoreWrapper;

    public bk(long j) {
        this.AFKeystoreWrapper = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && bk.class == obj.getClass() && this.AFKeystoreWrapper == ((bk) obj).AFKeystoreWrapper;
    }

    public int hashCode() {
        long j = this.AFKeystoreWrapper;
        return (int) (j ^ (j >>> 32));
    }
}
