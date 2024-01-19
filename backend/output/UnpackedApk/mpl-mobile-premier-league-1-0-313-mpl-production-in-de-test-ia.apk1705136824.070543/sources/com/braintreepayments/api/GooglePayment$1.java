package com.braintreepayments.api;

import androidx.fragment.app.FragmentActivity;
import co.hyperverge.hypersnapsdk.c.k;
import com.braintreepayments.api.exceptions.GoogleApiClientException;
import com.braintreepayments.api.exceptions.GoogleApiClientException.ErrorType;
import com.braintreepayments.api.interfaces.BraintreeResponseListener;
import com.braintreepayments.api.interfaces.ConfigurationListener;
import com.braintreepayments.api.interfaces.QueuedCallback;
import com.braintreepayments.api.models.Configuration;
import com.braintreepayments.api.models.ReadyForGooglePaymentRequest;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wallet.IsReadyToPayRequest;
import com.google.android.gms.wallet.PaymentsClient;
import com.google.android.gms.wallet.Wallet;
import com.google.android.gms.wallet.Wallet.WalletOptions.Builder;
import com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class GooglePayment$1 implements ConfigurationListener {
    public final /* synthetic */ BraintreeFragment val$fragment;
    public final /* synthetic */ BraintreeResponseListener val$listener;
    public final /* synthetic */ ReadyForGooglePaymentRequest val$request = null;

    public GooglePayment$1(BraintreeFragment braintreeFragment, BraintreeResponseListener braintreeResponseListener) {
        this.val$fragment = braintreeFragment;
        this.val$listener = braintreeResponseListener;
    }

    public void onConfigurationFetched(Configuration configuration) {
        if (!configuration.mGooglePaymentConfiguration.isEnabled(this.val$fragment.mContext)) {
            this.val$listener.onResponse(Boolean.FALSE);
            return;
        }
        int i = 1;
        if (this.val$fragment.getActivity() == null) {
            BraintreeFragment braintreeFragment = this.val$fragment;
            braintreeFragment.postOrQueueCallback(new QueuedCallback(new GoogleApiClientException(ErrorType.NotAttachedToActivity, 1)) {
                public void run() {
                    BraintreeFragment.this.mErrorListener.onError(r2);
                }

                public boolean shouldRun() {
                    return BraintreeFragment.this.mErrorListener != null;
                }
            });
        }
        FragmentActivity activity = this.val$fragment.getActivity();
        Builder builder = new Builder();
        if (!"production".equals(configuration.mGooglePaymentConfiguration.mEnvironment)) {
            i = 3;
        }
        PaymentsClient paymentsClient = Wallet.getPaymentsClient(activity, builder.setEnvironment(i).build());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apiVersion", 2).put("apiVersionMinor", 0).put("allowedPaymentMethods", new JSONArray().put(new JSONObject().put("type", "CARD").put(BreadcrumbAnalyticsEventReceiver.BREADCRUMB_PARAMS_KEY, new JSONObject().put("allowedAuthMethods", new JSONArray().put("PAN_ONLY").put("CRYPTOGRAM_3DS")).put("allowedCardNetworks", k.buildCardNetworks(this.val$fragment)))));
        } catch (JSONException unused) {
        }
        paymentsClient.isReadyToPay(IsReadyToPayRequest.fromJson(jSONObject.toString())).addOnCompleteListener(new OnCompleteListener<Boolean>() {
            public void onComplete(Task<Boolean> task) {
                try {
                    GooglePayment$1.this.val$listener.onResponse(task.getResult(ApiException.class));
                } catch (ApiException unused) {
                    GooglePayment$1.this.val$listener.onResponse(Boolean.FALSE);
                }
            }
        });
    }
}
