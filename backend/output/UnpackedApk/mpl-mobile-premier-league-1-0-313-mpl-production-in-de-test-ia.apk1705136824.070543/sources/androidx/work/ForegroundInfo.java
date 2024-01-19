package androidx.work;

import android.app.Notification;
import com.android.tools.r8.GeneratedOutlineSupport;

public final class ForegroundInfo {
    public final int mForegroundServiceType;
    public final Notification mNotification;
    public final int mNotificationId;

    public ForegroundInfo(int i, Notification notification, int i2) {
        this.mNotificationId = i;
        this.mNotification = notification;
        this.mForegroundServiceType = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ForegroundInfo.class != obj.getClass()) {
            return false;
        }
        ForegroundInfo foregroundInfo = (ForegroundInfo) obj;
        if (this.mNotificationId == foregroundInfo.mNotificationId && this.mForegroundServiceType == foregroundInfo.mForegroundServiceType) {
            return this.mNotification.equals(foregroundInfo.mNotification);
        }
        return false;
    }

    public int hashCode() {
        return this.mNotification.hashCode() + (((this.mNotificationId * 31) + this.mForegroundServiceType) * 31);
    }

    public String toString() {
        StringBuilder outline77 = GeneratedOutlineSupport.outline77("ForegroundInfo{", "mNotificationId=");
        outline77.append(this.mNotificationId);
        outline77.append(", mForegroundServiceType=");
        outline77.append(this.mForegroundServiceType);
        outline77.append(", mNotification=");
        outline77.append(this.mNotification);
        outline77.append('}');
        return outline77.toString();
    }
}
