package com.braintreepayments.api;

import android.net.Uri;
import com.braintreepayments.api.interfaces.ConfigurationListener;
import com.braintreepayments.api.interfaces.HttpResponseCallback;
import com.braintreepayments.api.interfaces.QueuedCallback;
import com.braintreepayments.api.models.Configuration;
import com.braintreepayments.api.models.PaymentMethodNonce;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class PaymentMethod$1 implements ConfigurationListener {
    public final /* synthetic */ BraintreeFragment val$fragment;
    public final /* synthetic */ Uri val$uri;

    public PaymentMethod$1(BraintreeFragment braintreeFragment, Uri uri) {
        this.val$fragment = braintreeFragment;
        this.val$uri = uri;
    }

    public void onConfigurationFetched(Configuration configuration) {
        this.val$fragment.mHttpClient.get(this.val$uri.toString(), new HttpResponseCallback() {
            public void failure(Exception exc) {
                BraintreeFragment braintreeFragment = PaymentMethod$1.this.val$fragment;
                braintreeFragment.postOrQueueCallback(new QueuedCallback(exc) {
                    public void run() {
                        BraintreeFragment.this.mErrorListener.onError(exc);
                    }

                    public boolean shouldRun() {
                        return BraintreeFragment.this.mErrorListener != null;
                    }
                });
                PaymentMethod$1.this.val$fragment.sendAnalyticsEvent("get-payment-methods.failed");
            }

            public void success(String str) {
                List list;
                try {
                    BraintreeFragment braintreeFragment = PaymentMethod$1.this.val$fragment;
                    JSONArray jSONArray = new JSONObject(str).getJSONArray("paymentMethods");
                    if (jSONArray == null) {
                        list = Collections.emptyList();
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            PaymentMethodNonce parsePaymentMethodNonces = PaymentMethodNonce.parsePaymentMethodNonces(jSONObject, jSONObject.getString("type"));
                            if (parsePaymentMethodNonces != null) {
                                arrayList.add(parsePaymentMethodNonces);
                            }
                        }
                        list = arrayList;
                    }
                    braintreeFragment.mCachedPaymentMethodNonces.clear();
                    braintreeFragment.mCachedPaymentMethodNonces.addAll(list);
                    braintreeFragment.mHasFetchedPaymentMethodNonces = true;
                    braintreeFragment.postOrQueueCallback(new QueuedCallback(list) {
                        public final /* synthetic */ List val$paymentMethodNonceList;

                        {
                            this.val$paymentMethodNonceList = r2;
                        }

                        public void run() {
                            BraintreeFragment.this.mPaymentMethodNoncesUpdatedListener.onPaymentMethodNoncesUpdated(this.val$paymentMethodNonceList);
                        }

                        public boolean shouldRun() {
                            return BraintreeFragment.this.mPaymentMethodNoncesUpdatedListener != null;
                        }
                    });
                    PaymentMethod$1.this.val$fragment.sendAnalyticsEvent("get-payment-methods.succeeded");
                } catch (JSONException e2) {
                    BraintreeFragment braintreeFragment2 = PaymentMethod$1.this.val$fragment;
                    braintreeFragment2.postOrQueueCallback(new QueuedCallback(e2) {
                        public void run() {
                            BraintreeFragment.this.mErrorListener.onError(exc);
                        }

                        public boolean shouldRun() {
                            return BraintreeFragment.this.mErrorListener != null;
                        }
                    });
                    PaymentMethod$1.this.val$fragment.sendAnalyticsEvent("get-payment-methods.failed");
                }
            }
        });
    }
}
