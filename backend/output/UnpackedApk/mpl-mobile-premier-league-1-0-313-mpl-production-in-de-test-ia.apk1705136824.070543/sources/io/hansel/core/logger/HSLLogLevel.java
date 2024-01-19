package io.hansel.core.logger;

public enum HSLLogLevel {
    min(true),
    mid(false),
    debug(false),
    all(false);
    
    public boolean isEnabled;

    /* access modifiers changed from: public */
    HSLLogLevel(boolean z) {
        this.isEnabled = z;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void setEnabled(boolean z) {
        this.isEnabled = z;
    }
}
