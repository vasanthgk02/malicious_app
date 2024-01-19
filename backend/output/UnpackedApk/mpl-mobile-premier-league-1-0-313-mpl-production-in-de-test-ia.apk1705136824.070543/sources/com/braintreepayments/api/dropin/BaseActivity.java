package com.braintreepayments.api.dropin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.braintreepayments.api.BraintreeFragment;
import com.braintreepayments.api.dropin.utils.PaymentMethodType;
import com.braintreepayments.api.exceptions.InvalidArgumentException;
import com.braintreepayments.api.models.Authorization;
import com.braintreepayments.api.models.ClientToken;
import com.braintreepayments.api.models.Configuration;
import com.braintreepayments.api.models.PaymentMethodNonce;
import com.braintreepayments.api.models.ThreeDSecureRequest;
import org.json.JSONException;

public class BaseActivity extends AppCompatActivity {
    public BraintreeFragment mBraintreeFragment;
    public boolean mClientTokenPresent;
    public Configuration mConfiguration;
    public DropInRequest mDropInRequest;

    public void finish(PaymentMethodNonce paymentMethodNonce, String str) {
        DropInResult dropInResult = new DropInResult();
        if (paymentMethodNonce != null) {
            dropInResult.mPaymentMethodType = PaymentMethodType.forType(paymentMethodNonce.getTypeLabel());
        }
        dropInResult.mPaymentMethodNonce = paymentMethodNonce;
        dropInResult.mDeviceData = str;
        setResult(-1, new Intent().putExtra("com.braintreepayments.api.dropin.EXTRA_DROP_IN_RESULT", dropInResult));
        finish();
    }

    public BraintreeFragment getBraintreeFragment() throws InvalidArgumentException {
        if (!TextUtils.isEmpty(this.mDropInRequest.mAuthorization)) {
            try {
                this.mClientTokenPresent = Authorization.fromString(this.mDropInRequest.mAuthorization) instanceof ClientToken;
            } catch (InvalidArgumentException unused) {
                this.mClientTokenPresent = false;
            }
            return BraintreeFragment.newInstance(this, this.mDropInRequest.mAuthorization);
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("A client token or tokenization key must be specified in the ");
        outline73.append(DropInRequest.class.getSimpleName());
        throw new InvalidArgumentException(outline73.toString());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            try {
                this.mConfiguration = new Configuration(bundle.getString("com.braintreepayments.api.EXTRA_CONFIGURATION_DATA"));
            } catch (JSONException unused) {
            }
        }
        this.mDropInRequest = (DropInRequest) getIntent().getParcelableExtra("com.braintreepayments.api.EXTRA_CHECKOUT_REQUEST");
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Configuration configuration = this.mConfiguration;
        if (configuration != null) {
            bundle.putString("com.braintreepayments.api.EXTRA_CONFIGURATION_DATA", configuration.mConfigurationString);
        }
    }

    public boolean shouldRequestThreeDSecureVerification() {
        boolean z;
        if (TextUtils.isEmpty(this.mDropInRequest.mAmount)) {
            ThreeDSecureRequest threeDSecureRequest = this.mDropInRequest.mThreeDSecureRequest;
            if (threeDSecureRequest == null || TextUtils.isEmpty(threeDSecureRequest.mAmount)) {
                z = false;
                if (this.mDropInRequest.mRequestThreeDSecureVerification || !this.mConfiguration.mThreeDSecureEnabled || !z) {
                    return false;
                }
                return true;
            }
        }
        z = true;
        if (this.mDropInRequest.mRequestThreeDSecureVerification) {
        }
        return false;
    }

    public void finish(Exception exc) {
        setResult(1, new Intent().putExtra("com.braintreepayments.api.dropin.EXTRA_ERROR", exc));
        finish();
    }
}
