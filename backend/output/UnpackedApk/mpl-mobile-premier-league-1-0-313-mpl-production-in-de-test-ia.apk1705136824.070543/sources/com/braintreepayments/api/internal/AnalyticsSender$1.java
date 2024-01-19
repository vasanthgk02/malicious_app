package com.braintreepayments.api.internal;

import com.braintreepayments.api.interfaces.HttpResponseCallback;
import java.util.List;

public final class AnalyticsSender$1 implements HttpResponseCallback {
    public final /* synthetic */ AnalyticsDatabase val$db;
    public final /* synthetic */ List val$innerEvents;

    public AnalyticsSender$1(AnalyticsDatabase analyticsDatabase, List list) {
        this.val$db = analyticsDatabase;
        this.val$innerEvents = list;
    }

    public void failure(Exception exc) {
    }

    public void success(String str) {
        this.val$db.removeEvents(this.val$innerEvents);
    }
}
