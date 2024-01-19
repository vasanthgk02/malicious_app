package com.firebase.jobdispatcher;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public final class GooglePlayDriver {
    public final Context context;
    public final PendingIntent token;
    public final JobValidator validator;
    public final GooglePlayJobWriter writer = new GooglePlayJobWriter();

    public GooglePlayDriver(Context context2) {
        this.context = context2;
        this.token = PendingIntent.getBroadcast(context2, 0, new Intent(), 0);
        this.validator = new DefaultJobValidator(context2);
    }
}
