package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFInAppEventType;

public final class cu extends ct {
    public cu(Context context) {
        super(AFInAppEventType.PURCHASE, Boolean.TRUE, context);
    }

    public final i AFInAppEventType(String str) {
        return super.AFInAppEventType(values(str));
    }
}
