package com.clevertap.android.sdk.network;

import android.content.Context;
import com.clevertap.android.sdk.events.EventGroup;

public abstract class BaseNetworkManager {
    public abstract void flushDBQueue(Context context, EventGroup eventGroup);

    public abstract boolean needsHandshakeForDomain(EventGroup eventGroup);
}
