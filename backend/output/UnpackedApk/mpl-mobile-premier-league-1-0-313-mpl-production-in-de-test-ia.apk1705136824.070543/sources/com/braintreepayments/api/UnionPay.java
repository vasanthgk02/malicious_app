package com.braintreepayments.api;

import android.net.Uri;
import co.hyperverge.hypersnapsdk.c.k;
import com.braintreepayments.api.exceptions.ConfigurationException;
import com.braintreepayments.api.interfaces.ConfigurationListener;
import com.braintreepayments.api.interfaces.HttpResponseCallback;
import com.braintreepayments.api.interfaces.PaymentMethodNonceCallback;
import com.braintreepayments.api.interfaces.QueuedCallback;
import com.braintreepayments.api.models.Configuration;
import com.braintreepayments.api.models.PaymentMethodNonce;
import com.braintreepayments.api.models.UnionPayCapabilities;
import com.braintreepayments.api.models.UnionPayCardBuilder;
import org.json.JSONException;
import org.json.JSONObject;

public class UnionPay {
    public static final String UNIONPAY_CAPABILITIES_PATH = k.versionedPath("payment_methods/credit_cards/capabilities");
    public static final String UNIONPAY_ENROLLMENT_PATH = k.versionedPath("union_pay_enrollments");

    public static void enroll(final BraintreeFragment braintreeFragment, final UnionPayCardBuilder unionPayCardBuilder) {
        AnonymousClass2 r0 = new ConfigurationListener() {
            public void onConfigurationFetched(Configuration configuration) {
                if (!configuration.mUnionPayConfiguration.mEnabled) {
                    braintreeFragment.postCallback(new ConfigurationException("UnionPay is not enabled"));
                    return;
                }
                try {
                    braintreeFragment.mHttpClient.post(UnionPay.UNIONPAY_ENROLLMENT_PATH, unionPayCardBuilder.buildEnrollment().toString(), new HttpResponseCallback() {
                        public void failure(Exception exc) {
                            BraintreeFragment braintreeFragment = braintreeFragment;
                            braintreeFragment.postOrQueueCallback(new QueuedCallback(exc) {
                                public void run() {
                                    BraintreeFragment.this.mErrorListener.onError(exc);
                                }

                                public boolean shouldRun() {
                                    return BraintreeFragment.this.mErrorListener != null;
                                }
                            });
                            braintreeFragment.sendAnalyticsEvent("union-pay.enrollment-failed");
                        }

                        public void success(String str) {
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                String string = jSONObject.getString("unionPayEnrollmentId");
                                boolean z = jSONObject.getBoolean("smsCodeRequired");
                                BraintreeFragment braintreeFragment = braintreeFragment;
                                braintreeFragment.postOrQueueCallback(new QueuedCallback(string, z) {
                                    public final /* synthetic */ String val$enrollmentId;
                                    public final /* synthetic */ boolean val$smsCodeRequired;

                                    {
                                        this.val$enrollmentId = r2;
                                        this.val$smsCodeRequired = r3;
                                    }

                                    public void run() {
                                        BraintreeFragment.this.mUnionPayListener.onSmsCodeSent(this.val$enrollmentId, this.val$smsCodeRequired);
                                    }

                                    public boolean shouldRun() {
                                        return BraintreeFragment.this.mUnionPayListener != null;
                                    }
                                });
                                braintreeFragment.sendAnalyticsEvent("union-pay.enrollment-succeeded");
                            } catch (JSONException e2) {
                                BraintreeFragment braintreeFragment2 = braintreeFragment;
                                braintreeFragment2.postOrQueueCallback(new QueuedCallback(e2) {
                                    public void run() {
                                        BraintreeFragment.this.mErrorListener.onError(exc);
                                    }

                                    public boolean shouldRun() {
                                        return BraintreeFragment.this.mErrorListener != null;
                                    }
                                });
                                braintreeFragment.sendAnalyticsEvent("union-pay.enrollment-failed");
                            }
                        }
                    });
                } catch (JSONException e2) {
                    braintreeFragment.postCallback(e2);
                }
            }
        };
        braintreeFragment.fetchConfiguration();
        braintreeFragment.postOrQueueCallback(new QueuedCallback(r0) {
            public void run() {
                r5.onConfigurationFetched(BraintreeFragment.this.mConfiguration);
            }

            public boolean shouldRun() {
                BraintreeFragment braintreeFragment = BraintreeFragment.this;
                return braintreeFragment.mConfiguration != null && braintreeFragment.isAdded();
            }
        });
    }

    public static void fetchCapabilities(final BraintreeFragment braintreeFragment, final String str) {
        AnonymousClass1 r0 = new ConfigurationListener() {
            public void onConfigurationFetched(Configuration configuration) {
                if (!configuration.mUnionPayConfiguration.mEnabled) {
                    braintreeFragment.postCallback(new ConfigurationException("UnionPay is not enabled"));
                    return;
                }
                braintreeFragment.mHttpClient.get(Uri.parse(UnionPay.UNIONPAY_CAPABILITIES_PATH).buildUpon().appendQueryParameter("creditCard[number]", str).build().toString(), new HttpResponseCallback() {
                    public void failure(Exception exc) {
                        BraintreeFragment braintreeFragment = braintreeFragment;
                        braintreeFragment.postOrQueueCallback(new QueuedCallback(exc) {
                            public void run() {
                                BraintreeFragment.this.mErrorListener.onError(exc);
                            }

                            public boolean shouldRun() {
                                return BraintreeFragment.this.mErrorListener != null;
                            }
                        });
                        braintreeFragment.sendAnalyticsEvent("union-pay.capabilities-failed");
                    }

                    public void success(String str) {
                        BraintreeFragment braintreeFragment = braintreeFragment;
                        UnionPayCapabilities unionPayCapabilities = new UnionPayCapabilities();
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            unionPayCapabilities.mIsUnionPay = jSONObject.optBoolean("isUnionPay");
                            unionPayCapabilities.mIsDebit = jSONObject.optBoolean("isDebit");
                            if (jSONObject.has("unionPay")) {
                                JSONObject jSONObject2 = jSONObject.getJSONObject("unionPay");
                                unionPayCapabilities.mSupportsTwoStepAuthAndCapture = jSONObject2.optBoolean("supportsTwoStepAuthAndCapture");
                                unionPayCapabilities.mIsSupported = jSONObject2.optBoolean("isSupported");
                            }
                        } catch (JSONException unused) {
                        }
                        braintreeFragment.postOrQueueCallback(new QueuedCallback(unionPayCapabilities) {
                            public final /* synthetic */ UnionPayCapabilities val$capabilities;

                            {
                                this.val$capabilities = r2;
                            }

                            public void run() {
                                BraintreeFragment.this.mUnionPayListener.onCapabilitiesFetched(this.val$capabilities);
                            }

                            public boolean shouldRun() {
                                return BraintreeFragment.this.mUnionPayListener != null;
                            }
                        });
                        braintreeFragment.sendAnalyticsEvent("union-pay.capabilities-received");
                    }
                });
            }
        };
        braintreeFragment.fetchConfiguration();
        braintreeFragment.postOrQueueCallback(new QueuedCallback(r0) {
            public void run() {
                r5.onConfigurationFetched(BraintreeFragment.this.mConfiguration);
            }

            public boolean shouldRun() {
                BraintreeFragment braintreeFragment = BraintreeFragment.this;
                return braintreeFragment.mConfiguration != null && braintreeFragment.isAdded();
            }
        });
    }

    public static void tokenize(final BraintreeFragment braintreeFragment, UnionPayCardBuilder unionPayCardBuilder) {
        k.tokenize(braintreeFragment, unionPayCardBuilder, new PaymentMethodNonceCallback() {
            public void failure(Exception exc) {
                braintreeFragment.postCallback(exc);
                braintreeFragment.sendAnalyticsEvent("union-pay.nonce-failed");
            }

            public void success(PaymentMethodNonce paymentMethodNonce) {
                BraintreeFragment braintreeFragment = braintreeFragment;
                braintreeFragment.mCachedPaymentMethodNonces.add(0, paymentMethodNonce);
                braintreeFragment.postOrQueueCallback(new QueuedCallback(paymentMethodNonce) {
                    public void run() {
                        BraintreeFragment.this.mPaymentMethodNonceCreatedListener.onPaymentMethodNonceCreated(r4);
                    }

                    public boolean shouldRun() {
                        return BraintreeFragment.this.mPaymentMethodNonceCreatedListener != null;
                    }
                });
                braintreeFragment.sendAnalyticsEvent("union-pay.nonce-received");
            }
        });
    }
}
