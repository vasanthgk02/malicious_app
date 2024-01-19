package com.braintreepayments.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse;
import com.cardinalcommerce.cardinalmobilesdk.services.CardinalValidateReceiver;
import com.inca.security.Proxy.iIiIiIiIii;

public class ThreeDSecureActivity extends AppCompatActivity implements CardinalValidateReceiver {
    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, -240378819, bundle);
    }

    public void onValidated(Context context, ValidateResponse validateResponse, String str) {
        Intent intent = new Intent();
        intent.putExtra("com.braintreepayments.api.ThreeDSecureActivity.EXTRA_JWT", str);
        intent.putExtra("com.braintreepayments.api.ThreeDSecureActivity.EXTRA_THREE_D_SECURE_LOOKUP", getIntent().getExtras().getParcelable("com.braintreepayments.api.ThreeDSecureActivity.EXTRA_THREE_D_SECURE_LOOKUP"));
        intent.putExtra("com.braintreepayments.api.ThreeDSecureActivity.EXTRA_VALIDATION_RESPONSE", validateResponse);
        setResult(-1, intent);
        finish();
    }
}
