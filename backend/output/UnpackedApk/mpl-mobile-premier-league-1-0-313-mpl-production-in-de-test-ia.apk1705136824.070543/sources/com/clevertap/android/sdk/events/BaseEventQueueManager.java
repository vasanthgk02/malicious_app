package com.clevertap.android.sdk.events;

import android.content.Context;
import java.util.concurrent.Future;
import org.json.JSONObject;

public abstract class BaseEventQueueManager {
    public abstract void flushQueueSync(Context context, EventGroup eventGroup);

    public abstract void pushBasicProfile(JSONObject jSONObject, boolean z);

    public abstract void pushInitialEventsAsync();

    public abstract Future<?> queueEvent(Context context, JSONObject jSONObject, int i);
}
