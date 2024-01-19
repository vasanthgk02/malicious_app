package com.clevertap.android.sdk.interfaces;

import android.content.Context;
import android.os.Bundle;
import androidx.core.app.NotificationCompat.Builder;
import com.clevertap.android.sdk.CleverTapInstanceConfig;

public interface AudibleNotification {
    Builder setSound(Context context, Bundle bundle, Builder builder, CleverTapInstanceConfig cleverTapInstanceConfig);
}
