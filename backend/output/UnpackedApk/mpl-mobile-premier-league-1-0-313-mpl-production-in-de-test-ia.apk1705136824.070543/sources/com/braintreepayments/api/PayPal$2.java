package com.braintreepayments.api;

import android.content.Context;
import android.os.Parcel;
import android.util.Base64;
import co.hyperverge.hypersnapsdk.c.k;
import com.braintreepayments.api.exceptions.BraintreeException;
import com.braintreepayments.api.interfaces.ConfigurationListener;
import com.braintreepayments.api.interfaces.HttpResponseCallback;
import com.braintreepayments.api.interfaces.QueuedCallback;
import com.braintreepayments.api.internal.ManifestValidator;
import com.braintreepayments.api.models.Configuration;
import com.braintreepayments.api.models.PayPalRequest;
import org.json.JSONException;

public final class PayPal$2 implements ConfigurationListener {
    public final /* synthetic */ HttpResponseCallback val$callback;
    public final /* synthetic */ BraintreeFragment val$fragment;
    public final /* synthetic */ boolean val$isBillingAgreement;
    public final /* synthetic */ PayPalRequest val$paypalRequest;

    public PayPal$2(BraintreeFragment braintreeFragment, PayPalRequest payPalRequest, boolean z, HttpResponseCallback httpResponseCallback) {
        this.val$fragment = braintreeFragment;
        this.val$paypalRequest = payPalRequest;
        this.val$isBillingAgreement = z;
        this.val$callback = httpResponseCallback;
    }

    public void onConfigurationFetched(Configuration configuration) {
        if (!configuration.mPaypalEnabled) {
            BraintreeFragment braintreeFragment = this.val$fragment;
            braintreeFragment.postOrQueueCallback(new QueuedCallback(new BraintreeException("PayPal is not enabled. See https://developers.braintreepayments.com/guides/paypal/overview/android/ for more information.")) {
                public void run() {
                    BraintreeFragment.this.mErrorListener.onError(r2);
                }

                public boolean shouldRun() {
                    return BraintreeFragment.this.mErrorListener != null;
                }
            });
            return;
        }
        BraintreeFragment braintreeFragment2 = this.val$fragment;
        if (!ManifestValidator.isUrlSchemeDeclaredInAndroidManifest(braintreeFragment2.mContext, braintreeFragment2.mReturnUrlScheme, BraintreeBrowserSwitchActivity.class)) {
            this.val$fragment.sendAnalyticsEvent("paypal.invalid-manifest");
            BraintreeFragment braintreeFragment3 = this.val$fragment;
            braintreeFragment3.postOrQueueCallback(new QueuedCallback(new BraintreeException("BraintreeBrowserSwitchActivity missing, incorrectly configured in AndroidManifest.xml or another app defines the same browser switch url as this app. See https://developers.braintreepayments.com/guides/client-sdk/android/#browser-switch for the correct configuration")) {
                public void run() {
                    BraintreeFragment.this.mErrorListener.onError(r2);
                }

                public boolean shouldRun() {
                    return BraintreeFragment.this.mErrorListener != null;
                }
            });
            return;
        }
        try {
            Context context = this.val$fragment.mContext;
            PayPalRequest payPalRequest = this.val$paypalRequest;
            Parcel obtain = Parcel.obtain();
            payPalRequest.writeToParcel(obtain, 0);
            context.getApplicationContext().getSharedPreferences("BraintreeApi", 0).edit().putString("com.braintreepayments.api.PayPal.PAYPAL_REQUEST_KEY", Base64.encodeToString(obtain.marshall(), 0)).apply();
            k.access$200(this.val$fragment, this.val$paypalRequest, this.val$isBillingAgreement, this.val$callback);
        } catch (JSONException e2) {
            BraintreeFragment braintreeFragment4 = this.val$fragment;
            braintreeFragment4.postOrQueueCallback(new QueuedCallback(e2) {
                public void run() {
                    BraintreeFragment.this.mErrorListener.onError(r2);
                }

                public boolean shouldRun() {
                    return BraintreeFragment.this.mErrorListener != null;
                }
            });
        }
    }
}
