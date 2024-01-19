package com.xiaomi.mipush.sdk.help;

import android.app.IntentService;
import android.content.Intent;

public class HelpService extends IntentService {
    public HelpService() {
        super("intentService");
    }

    @Deprecated
    public void onHandleIntent(Intent intent) {
    }
}
