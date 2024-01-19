package com.freshchat.consumer.sdk.exception;

import com.android.tools.r8.GeneratedOutlineSupport;

public class FreshchatComponentNotFoundException extends RuntimeException {
    public FreshchatComponentNotFoundException(String str) {
        super(GeneratedOutlineSupport.outline52("Component of Freshchat SDK not found in your app's AndroidManifest.xml + (", str, " missing!)"));
    }
}
