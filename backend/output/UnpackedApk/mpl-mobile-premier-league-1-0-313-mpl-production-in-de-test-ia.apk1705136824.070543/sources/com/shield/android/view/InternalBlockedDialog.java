package com.shield.android.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.inca.security.Proxy.iIiIiIiIii;

public class InternalBlockedDialog extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1692a = true;

    public void onBackPressed() {
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, 775222658, bundle);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("quit", false)) {
            finish();
        }
    }

    public void onStop() {
        iIiIiIiIii.IiiiIiiiII(this, -1234731919, new Object[0]);
    }
}
