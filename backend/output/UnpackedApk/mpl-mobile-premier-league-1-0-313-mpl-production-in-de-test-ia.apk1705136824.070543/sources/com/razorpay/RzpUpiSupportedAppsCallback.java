package com.razorpay;

import java.util.List;

public interface RzpUpiSupportedAppsCallback {
    void onReceiveUpiSupportedApps(List<ApplicationDetails> list);
}
