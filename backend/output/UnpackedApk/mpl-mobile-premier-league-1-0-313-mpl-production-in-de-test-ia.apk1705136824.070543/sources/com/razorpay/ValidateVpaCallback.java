package com.razorpay;

public interface ValidateVpaCallback {
    void onFailure();

    void onResponse(boolean z);
}
