package com.mpl.analytics.event;

import android.location.Location;
import android.os.Bundle;
import com.mpl.analytics.MPLEventDetail;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface IMPLCleverTapEvent {
    int getCount(String str);

    int getCountV2(String str);

    MPLEventDetail getDetails(String str);

    int getFirstTime(String str);

    int getFirstTimeV2(String str);

    Map<String, MPLEventDetail> getHistory();

    Map<String, MPLEventDetail> getHistoryV2();

    int getLastTime(String str);

    int getLastTimeV2(String str);

    void pushChargedEvent(HashMap<String, Object> hashMap, ArrayList<HashMap<String, Object>> arrayList);

    void pushChargedEventV2(HashMap<String, Object> hashMap, ArrayList<HashMap<String, Object>> arrayList);

    void pushEvent(String str);

    void pushEvent(String str, HashMap<String, Object> hashMap);

    void pushEventV2(String str);

    void pushEventV2(String str, HashMap<String, Object> hashMap);

    void pushLocation(Location location);

    void pushLocationV2(Location location);

    void pushNotificationClickedEvent(Bundle bundle);

    void pushNotificationClickedEventV2(Bundle bundle);

    void pushNotificationViewedEvent(Bundle bundle);

    void pushNotificationViewedEventV2(Bundle bundle);
}
