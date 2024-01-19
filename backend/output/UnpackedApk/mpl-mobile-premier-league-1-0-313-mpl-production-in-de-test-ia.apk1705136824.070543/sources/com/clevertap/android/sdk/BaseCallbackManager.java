package com.clevertap.android.sdk;

public abstract class BaseCallbackManager {
    public abstract void _notifyInboxMessagesDidUpdate();

    public abstract InAppNotificationButtonListener getInAppNotificationButtonListener();

    public abstract void notifyUserProfileInitialized(String str);
}
