package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;

public final class ax {
    public final Application valueOf;

    public ax(Context context) {
        this.valueOf = (Application) context.getApplicationContext();
    }
}
