package io.hansel.core.logger;

public enum LogGroup {
    TG(true),
    DV(true),
    PT(true),
    GT(true),
    CS(true),
    CJ(true),
    WS(true),
    HC(true),
    AI(true),
    RC(true),
    OT(true);
    
    public boolean enabled;

    /* access modifiers changed from: public */
    LogGroup(boolean z) {
        this.enabled = z;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }
}
