package com.mpl.androidapp.notification.features.implementations;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature", f = "NotificationUgcFeature.kt", l = {106, 114, 117}, m = "checkNotificationPriority")
/* compiled from: NotificationUgcFeature.kt */
public final class NotificationUgcFeature$checkNotificationPriority$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ NotificationUgcFeature this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public NotificationUgcFeature$checkNotificationPriority$1(NotificationUgcFeature notificationUgcFeature, Continuation<? super NotificationUgcFeature$checkNotificationPriority$1> continuation) {
        // this.this$0 = notificationUgcFeature;
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LinearLayoutManager.INVALID_OFFSET;
        return this.this$0.checkNotificationPriority(this);
    }
}
