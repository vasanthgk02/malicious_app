package com.microsoft.codepush.react;

public enum CodePushUpdateState {
    RUNNING(0),
    PENDING(1),
    LATEST(2);
    
    public final int value;

    /* access modifiers changed from: public */
    CodePushUpdateState(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
