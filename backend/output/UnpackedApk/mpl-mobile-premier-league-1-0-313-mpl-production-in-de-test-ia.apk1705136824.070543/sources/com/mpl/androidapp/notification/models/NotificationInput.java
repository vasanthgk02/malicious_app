package com.mpl.androidapp.notification.models;

import android.app.Notification;
import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/mpl/androidapp/notification/models/NotificationInput;", "", "notification", "Landroid/app/Notification;", "notificationId", "", "(Landroid/app/Notification;I)V", "getNotification", "()Landroid/app/Notification;", "getNotificationId", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NotificationInput.kt */
public final class NotificationInput {
    public final Notification notification;
    public final int notificationId;

    public NotificationInput(Notification notification2, int i) {
        Intrinsics.checkNotNullParameter(notification2, "notification");
        this.notification = notification2;
        this.notificationId = i;
    }

    public static /* synthetic */ NotificationInput copy$default(NotificationInput notificationInput, Notification notification2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            notification2 = notificationInput.notification;
        }
        if ((i2 & 2) != 0) {
            i = notificationInput.notificationId;
        }
        return notificationInput.copy(notification2, i);
    }

    public final Notification component1() {
        return this.notification;
    }

    public final int component2() {
        return this.notificationId;
    }

    public final NotificationInput copy(Notification notification2, int i) {
        Intrinsics.checkNotNullParameter(notification2, "notification");
        return new NotificationInput(notification2, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotificationInput)) {
            return false;
        }
        NotificationInput notificationInput = (NotificationInput) obj;
        return Intrinsics.areEqual(this.notification, notificationInput.notification) && this.notificationId == notificationInput.notificationId;
    }

    public final Notification getNotification() {
        return this.notification;
    }

    public final int getNotificationId() {
        return this.notificationId;
    }

    public int hashCode() {
        return (this.notification.hashCode() * 31) + this.notificationId;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("NotificationInput(notification=");
        outline73.append(this.notification);
        outline73.append(", notificationId=");
        return GeneratedOutlineSupport.outline56(outline73, this.notificationId, ')');
    }
}
