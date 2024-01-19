package com.netcore.android.notification;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/netcore/android/notification/SMTNotificationEventType;", "", "", "type", "I", "getType", "()I", "setType", "(I)V", "<init>", "(Ljava/lang/String;II)V", "OPEN", "DELIVERY", "DISSMISS", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTNotificationType.kt */
public enum SMTNotificationEventType {
    OPEN(1),
    DELIVERY(2),
    DISSMISS(3);
    
    public int type;

    /* access modifiers changed from: public */
    SMTNotificationEventType(int i) {
        this.type = i;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }
}
