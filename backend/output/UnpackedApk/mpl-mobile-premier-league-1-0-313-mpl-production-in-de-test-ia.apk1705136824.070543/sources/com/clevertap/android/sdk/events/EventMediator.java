package com.clevertap.android.sdk.events;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.CoreMetaData;

public class EventMediator {
    public final CoreMetaData cleverTapMetaData;
    public final CleverTapInstanceConfig config;
    public final Context context;

    public EventMediator(Context context2, CleverTapInstanceConfig cleverTapInstanceConfig, CoreMetaData coreMetaData) {
        this.context = context2;
        this.config = cleverTapInstanceConfig;
        this.cleverTapMetaData = coreMetaData;
    }
}
