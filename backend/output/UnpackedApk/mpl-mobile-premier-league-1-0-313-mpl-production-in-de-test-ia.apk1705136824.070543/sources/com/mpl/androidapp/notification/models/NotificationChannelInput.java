package com.mpl.androidapp.notification.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0005\"\u0004\b\u0006\u0010\u0004¨\u0006\u000f"}, d2 = {"Lcom/mpl/androidapp/notification/models/NotificationChannelInput;", "", "isGamePlayStarted", "", "(Z)V", "()Z", "setGamePlayStarted", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NotificationChannelInput.kt */
public final class NotificationChannelInput {
    public boolean isGamePlayStarted;

    public NotificationChannelInput(boolean z) {
        this.isGamePlayStarted = z;
    }

    public static /* synthetic */ NotificationChannelInput copy$default(NotificationChannelInput notificationChannelInput, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = notificationChannelInput.isGamePlayStarted;
        }
        return notificationChannelInput.copy(z);
    }

    public final boolean component1() {
        return this.isGamePlayStarted;
    }

    public final NotificationChannelInput copy(boolean z) {
        return new NotificationChannelInput(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NotificationChannelInput) && this.isGamePlayStarted == ((NotificationChannelInput) obj).isGamePlayStarted;
    }

    public int hashCode() {
        boolean z = this.isGamePlayStarted;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public final boolean isGamePlayStarted() {
        return this.isGamePlayStarted;
    }

    public final void setGamePlayStarted(boolean z) {
        this.isGamePlayStarted = z;
    }

    public String toString() {
        return GeneratedOutlineSupport.outline65(GeneratedOutlineSupport.outline73("NotificationChannelInput(isGamePlayStarted="), this.isGamePlayStarted, ')');
    }
}
