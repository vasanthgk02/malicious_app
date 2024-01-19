package com.braintreepayments.api;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.inca.security.Proxy.iIiIiIiIii;

public class GooglePaymentActivity extends AppCompatActivity {
    public void finish() {
        super.finish();
        overridePendingTransition(17432576, 17432577);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        setResult(i2, intent);
        finish();
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, -901788856, bundle);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.braintreepayments.api.EXTRA_RECREATING", true);
    }
}
