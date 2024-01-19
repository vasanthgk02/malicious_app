package com.microsoft.codepush.react;

public enum CodePushInstallMode {
    IMMEDIATE(0),
    ON_NEXT_RESTART(1),
    ON_NEXT_RESUME(2),
    ON_NEXT_SUSPEND(3);
    
    public final int value;

    /* access modifiers changed from: public */
    CodePushInstallMode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
