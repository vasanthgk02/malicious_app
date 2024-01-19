package com.braintreepayments.browserswitch;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class BrowserSwitchActivity extends Activity {
    public BrowserSwitchClient browserSwitchClient = new BrowserSwitchClient(new BrowserSwitchConfig(), new ActivityFinder(), BrowserSwitchPersistentStore.INSTANCE, null);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BrowserSwitchClient browserSwitchClient2 = this.browserSwitchClient;
        Intent intent = getIntent();
        if (browserSwitchClient2 != null) {
            if (intent != null) {
                Uri data = intent.getData();
                BrowserSwitchRequest activeRequest = browserSwitchClient2.persistentStore.getActiveRequest(this);
                if (!(activeRequest == null || data == null)) {
                    activeRequest.uri = data;
                    activeRequest.state = "SUCCESS";
                    browserSwitchClient2.persistentStore.putActiveRequest(activeRequest, this);
                }
            }
            finish();
            return;
        }
        throw null;
    }
}
