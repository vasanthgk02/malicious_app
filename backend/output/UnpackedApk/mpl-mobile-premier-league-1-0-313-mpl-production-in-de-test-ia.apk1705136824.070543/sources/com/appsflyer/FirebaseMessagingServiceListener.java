package com.appsflyer;

import com.appsflyer.internal.cd;
import com.google.firebase.messaging.FirebaseMessagingService;

public class FirebaseMessagingServiceListener extends FirebaseMessagingService {
    public void onNewToken(String str) {
        new cd(getApplicationContext()).AFInAppEventParameterName(str);
    }
}
