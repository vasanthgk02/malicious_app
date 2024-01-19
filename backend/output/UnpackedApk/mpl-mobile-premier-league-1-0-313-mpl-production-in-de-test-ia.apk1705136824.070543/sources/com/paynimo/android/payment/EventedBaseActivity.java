package com.paynimo.android.payment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Toast;
import com.paynimo.android.payment.event.g;
import com.paynimo.android.payment.util.Constant;
import de.greenrobot.event.EventBus;

public abstract class EventedBaseActivity extends BaseActivity {
    public static final String TAG = "EventedBaseActivity";
    public static AlertDialog mLoading;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
        Constant.showOutputLog("==>>EventedBaseActivity", "onCreate");
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        Constant.showOutputLog("==>>EventedBaseActivity", "onPause");
    }

    public void onEventMainThread(g gVar) {
        if (!gVar.isInternetConnected()) {
            Toast.makeText(this, "No Internet connection!", 0).show();
            Constant.showOutputLog(TAG, "No Internet connection!");
        }
    }

    public void onPause() {
        super.onPause();
        Constant.showOutputLog("==>>EventedBaseActivity", "onPause");
    }

    public void onResume() {
        super.onResume();
        Constant.showOutputLog("==>>EventedBaseActivity", "onResume");
    }
}
