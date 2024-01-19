package com.netcore.android.notification;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/netcore/android/notification/SMTNotificationActionBtnType;", "", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "NORMAL", "COPY", "DISMISS", "SNOOZE", "REPLY", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTNotificationType.kt */
public enum SMTNotificationActionBtnType {
    NORMAL(1),
    COPY(2),
    DISMISS(3),
    SNOOZE(4),
    REPLY(5);
    
    public final int value;

    /* access modifiers changed from: public */
    SMTNotificationActionBtnType(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
