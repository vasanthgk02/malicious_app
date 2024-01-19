package com.clevertap.android.sdk.db;

import android.content.Context;

public abstract class BaseDatabaseManager {
    public abstract void clearQueues(Context context);

    public abstract DBAdapter loadDBAdapter(Context context);
}
