package com.clevertap.android.sdk.interfaces;

import android.content.Context;
import android.os.Bundle;

public interface ActionButtonClickHandler {
    boolean onActionButtonClick(Context context, Bundle bundle, int i);

    boolean onMessageReceived(Context context, Bundle bundle, String str);
}
