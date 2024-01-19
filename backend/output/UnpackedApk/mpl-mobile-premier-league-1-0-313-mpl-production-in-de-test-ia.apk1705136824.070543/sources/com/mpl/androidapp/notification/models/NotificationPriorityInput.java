package com.mpl.androidapp.notification.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/mpl/androidapp/notification/models/NotificationPriorityInput;", "", "isUserPlayingGame", "", "deviceOsVersion", "", "(ZI)V", "getDeviceOsVersion", "()I", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NotificationPriorityInput.kt */
public final class NotificationPriorityInput {
    public final int deviceOsVersion;
    public final boolean isUserPlayingGame;

    public NotificationPriorityInput(boolean z, int i) {
        this.isUserPlayingGame = z;
        this.deviceOsVersion = i;
    }

    public static /* synthetic */ NotificationPriorityInput copy$default(NotificationPriorityInput notificationPriorityInput, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = notificationPriorityInput.isUserPlayingGame;
        }
        if ((i2 & 2) != 0) {
            i = notificationPriorityInput.deviceOsVersion;
        }
        return notificationPriorityInput.copy(z, i);
    }

    public final boolean component1() {
        return this.isUserPlayingGame;
    }

    public final int component2() {
        return this.deviceOsVersion;
    }

    public final NotificationPriorityInput copy(boolean z, int i) {
        return new NotificationPriorityInput(z, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotificationPriorityInput)) {
            return false;
        }
        NotificationPriorityInput notificationPriorityInput = (NotificationPriorityInput) obj;
        return this.isUserPlayingGame == notificationPriorityInput.isUserPlayingGame && this.deviceOsVersion == notificationPriorityInput.deviceOsVersion;
    }

    public final int getDeviceOsVersion() {
        return this.deviceOsVersion;
    }

    public int hashCode() {
        boolean z = this.isUserPlayingGame;
        if (z) {
            z = true;
        }
        return ((z ? 1 : 0) * true) + this.deviceOsVersion;
    }

    public final boolean isUserPlayingGame() {
        return this.isUserPlayingGame;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("NotificationPriorityInput(isUserPlayingGame=");
        outline73.append(this.isUserPlayingGame);
        outline73.append(", deviceOsVersion=");
        return GeneratedOutlineSupport.outline56(outline73, this.deviceOsVersion, ')');
    }
}
