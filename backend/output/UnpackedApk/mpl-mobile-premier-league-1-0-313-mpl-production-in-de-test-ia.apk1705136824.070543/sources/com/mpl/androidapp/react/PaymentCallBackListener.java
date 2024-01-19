package com.mpl.androidapp.react;

import android.app.Activity;
import android.content.Intent;

public interface PaymentCallBackListener {
    boolean onBackPressed();

    void processResponce(Activity activity, int i, int i2, Intent intent);
}
