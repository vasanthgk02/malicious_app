package com.mpl.analytics;

import com.clevertap.android.sdk.events.EventDetail;

public class MPLEventDetail extends EventDetail {
    public MPLEventDetail(EventDetail eventDetail) {
        super(eventDetail.getCount(), eventDetail.getFirstTime(), eventDetail.getLastTime(), eventDetail.getName());
    }
}
