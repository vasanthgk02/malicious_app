package com.clevertap.android.sdk;

import android.content.Context;
import com.clevertap.android.sdk.events.BaseEventQueueManager;

public class LocationManager {
    public int lastLocationPingTime = 0;
    public int lastLocationPingTimeForGeofence = 0;
    public final BaseEventQueueManager mBaseEventQueueManager;
    public final CleverTapInstanceConfig mConfig;
    public final Context mContext;
    public final CoreMetaData mCoreMetaData;
    public final Logger mLogger;

    public LocationManager(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, CoreMetaData coreMetaData, BaseEventQueueManager baseEventQueueManager) {
        this.mContext = context;
        this.mConfig = cleverTapInstanceConfig;
        this.mLogger = cleverTapInstanceConfig.getLogger();
        this.mCoreMetaData = coreMetaData;
        this.mBaseEventQueueManager = baseEventQueueManager;
    }
}
