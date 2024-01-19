package com.mpl.androidapp.notification.features;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/mpl/androidapp/notification/features/NotificationID;", "", "()V", "c", "Ljava/util/concurrent/atomic/AtomicInteger;", "getID", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NotificationID.kt */
public final class NotificationID {
    public static final NotificationID INSTANCE = new NotificationID();

    /* renamed from: c  reason: collision with root package name */
    public static final AtomicInteger f961c = new AtomicInteger(0);

    public final int getID() {
        return f961c.incrementAndGet();
    }
}
