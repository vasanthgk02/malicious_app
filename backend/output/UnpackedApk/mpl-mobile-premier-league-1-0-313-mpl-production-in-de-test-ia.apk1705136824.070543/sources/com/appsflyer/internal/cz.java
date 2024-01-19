package com.appsflyer.internal;

import android.content.Context;
import java.util.Map;

public abstract class cz extends dd {
    public cz(String str, Runnable runnable) {
        super(str, runnable);
    }

    public final void values(Context context, aw<Map<String, Object>> awVar) {
        if (ac.AFInAppEventParameterName().valueOf(ac.AFInAppEventType(context), false) <= 0 && awVar.values()) {
            new Thread(awVar.AFInAppEventType).start();
            values();
        }
    }
}
