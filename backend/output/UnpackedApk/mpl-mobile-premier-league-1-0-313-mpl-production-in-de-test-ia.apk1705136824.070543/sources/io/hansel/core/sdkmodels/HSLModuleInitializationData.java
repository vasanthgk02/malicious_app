package io.hansel.core.sdkmodels;

import android.app.Application;
import io.hansel.core.base.task.HSLTaskHandler;
import io.hansel.hanselsdk.HanselSyncStateListenerInternal;

public class HSLModuleInitializationData {
    public Application app;
    public HanselSyncStateListenerInternal hanselSyncStateListenerInternal;
    public boolean hasAppVersionChanged = false;
    public boolean isDeviceIdLogEnabled = true;
    public HSLTaskHandler networkTaskHandler;
    public HSLSDKIdentifiers sdkIdentifiers;
    public boolean shouldEnableEncryption = false;
}
