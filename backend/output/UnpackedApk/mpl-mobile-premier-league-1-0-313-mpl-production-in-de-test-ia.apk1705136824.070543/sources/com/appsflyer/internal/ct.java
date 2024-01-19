package com.appsflyer.internal;

import android.content.Context;

public abstract class ct extends cm {
    public ct() {
        this(null, null, null);
    }

    public ct(String str, Boolean bool, Context context) {
        super(str, null, Boolean.FALSE, null, bool, context);
    }
}
