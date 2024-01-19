package com.razorpay;

import proguard.annotation.Keep;
import proguard.annotation.KeepClassMembers;

@Keep
@KeepClassMembers
public interface RzpPluginRegisterCallback {
    void onResponse(boolean z);
}
