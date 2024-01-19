package com.freshchat.consumer.sdk.exception;

import com.android.tools.r8.GeneratedOutlineSupport;

public class PermissionNotGrantedException extends SecurityException {
    public PermissionNotGrantedException(String str) {
        super(GeneratedOutlineSupport.outline52("Permission required by Freshchat SDK not granted (Is ", str, " permission present in your manifest? )"));
    }
}
