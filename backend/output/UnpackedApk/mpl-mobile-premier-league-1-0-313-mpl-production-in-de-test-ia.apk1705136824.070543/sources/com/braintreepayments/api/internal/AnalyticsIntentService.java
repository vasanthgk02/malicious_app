package com.braintreepayments.api.internal;

import android.app.IntentService;
import android.content.Intent;
import co.hyperverge.hypersnapsdk.c.k;
import com.braintreepayments.api.exceptions.InvalidArgumentException;
import com.braintreepayments.api.models.Authorization;
import com.braintreepayments.api.models.Configuration;
import org.json.JSONException;

public class AnalyticsIntentService extends IntentService {
    public AnalyticsIntentService() {
        super(AnalyticsIntentService.class.getSimpleName());
        setIntentRedelivery(true);
    }

    public void onHandleIntent(Intent intent) {
        if (intent != null) {
            try {
                Authorization fromString = Authorization.fromString(intent.getStringExtra("com.braintreepayments.api.internal.AnalyticsIntentService.EXTRA_AUTHORIZATION"));
                k.send(this, fromString, new BraintreeHttpClient(fromString), new Configuration(intent.getStringExtra("com.braintreepayments.api.internal.AnalyticsIntentService.EXTRA_CONFIGURATION")).mAnalyticsConfiguration.mUrl, true);
            } catch (InvalidArgumentException | JSONException unused) {
            }
        }
    }
}
