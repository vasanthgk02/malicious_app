package com.clevertap.android.sdk.pushnotification;

import com.android.tools.r8.GeneratedOutlineSupport;

public final class NotificationInfo {
    public final boolean fromCleverTap;
    public final boolean shouldRender;

    public NotificationInfo(boolean z, boolean z2) {
        this.fromCleverTap = z;
        this.shouldRender = z2;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("NotificationInfo{fromCleverTap=");
        outline73.append(this.fromCleverTap);
        outline73.append(", shouldRender=");
        return GeneratedOutlineSupport.outline65(outline73, this.shouldRender, '}');
    }
}
