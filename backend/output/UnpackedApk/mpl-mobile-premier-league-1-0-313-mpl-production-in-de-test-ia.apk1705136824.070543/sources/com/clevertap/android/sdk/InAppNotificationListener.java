package com.clevertap.android.sdk;

import java.util.Map;

public interface InAppNotificationListener {
    boolean beforeShow(Map<String, Object> map);

    void onDismissed(Map<String, Object> map, Map<String, Object> map2);
}
