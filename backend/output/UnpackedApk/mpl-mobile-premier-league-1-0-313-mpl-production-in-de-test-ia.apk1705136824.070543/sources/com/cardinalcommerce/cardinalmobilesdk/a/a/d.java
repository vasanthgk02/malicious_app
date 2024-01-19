package com.cardinalcommerce.cardinalmobilesdk.a.a;

public enum d {
    New(0),
    Configured(1),
    InitStarted(2),
    InitCompleted(3),
    ProcessBinStarted(4),
    ProcessBinCompleted(5),
    Continue(6),
    Validated(9);
    
    public final int index;

    /* access modifiers changed from: public */
    d(int i) {
        this.index = i;
    }

    public int a() {
        return this.index;
    }
}
