package com.mpl.payment.razorpay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.mpl.payment.R;
import com.mpl.payment.razorpay.RazorPayCustomPayments.RazorPayCustomPaymentBuilder;
import com.mpl.payment.razorpay.RazorpayPayments.RazorpayPaymentsBuilder;
import com.razorpay.PaymentData;

public class RazorPayGpayUpiActivity extends Activity {
    public static final String OUTSTATE_HAS_PAYMENT_STARTED = "OUTSTATE_HAS_ACTIVITY_STARTED";
    public static final String TAG = "RazorPayGpayUpiActivity";
    public boolean hasPaymentStarted = false;
    public WebView paymentWebview;
    public RazorPayCustomPayments razorPayCustomPayments;
    public RazorpayPayments razorpayPayments;

    private void startPaymentV1() {
        final Intent intent = new Intent();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            try {
                this.razorPayCustomPayments = RazorPayCustomPaymentBuilder.buildRazorPayCustomPayment().setAmountFromReact(extras.getString(RazorpayConstants.BUNDLE_RP_WV_ACTIVITY_AMOUNT)).setPaymentGateway(extras.getString(RazorpayConstants.BUNDLE_RP_WV_ACTIVITY_PG)).setUrl(extras.getString(RazorpayConstants.BUNDLE_RP_WV_URL)).setNumber("").setActivity(this).setBank(extras.getString(RazorpayConstants.BUNDLE_RP_WV_BANK)).setWebview(this.paymentWebview).addHeader("Accept", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE).addHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE).addHeader("Authorization", extras.getString(RazorpayConstants.BUNDLE_RP_WV_AUTH)).isLogEnabled(extras.getBoolean(RazorpayConstants.BUNDLE_RP_WV_ISLOGENABLED)).setCurrency("INR").setTransactionType(extras.getString(RazorpayConstants.BUNDLE_RP_WV_TRANSACTION_TYPE)).setRazorPayMoneyInStatusListener(new RazorPayPaymentStatusListener() {
                    public void onMoneyInError(int i, String str) {
                        intent.putExtra(RazorpayConstants.RESULT_RP_WV_RESULT_TYPE, 1);
                        Intent intent = intent;
                        intent.putExtra(RazorpayConstants.RESULT_RP_WV_RESULT_STRING, "code-> " + i + " message-> " + str);
                        RazorPayGpayUpiActivity.this.setResult(-1, intent);
                        RazorPayGpayUpiActivity.this.finish();
                    }

                    public void onRazorPayPaymentFailed(int i, String str, PaymentData paymentData, String str2) {
                        intent.putExtra(RazorpayConstants.RESULT_RP_WV_RESULT_TYPE, 2);
                        Intent intent = intent;
                        intent.putExtra(RazorpayConstants.RESULT_RP_WV_RESULT_STRING, "code-> " + i + " message-> " + str);
                        intent.putExtra(RazorpayConstants.RESULT_RP_WV_RESULT_MPL_ORDER_ID, str2);
                        RazorPayGpayUpiActivity.this.setResult(-1, intent);
                        RazorPayGpayUpiActivity.this.finish();
                    }

                    public void onRazorPayPaymentSuccessful(String str, PaymentData paymentData, String str2) {
                        intent.putExtra(RazorpayConstants.RESULT_RP_WV_RESULT_TYPE, 3);
                        intent.putExtra(RazorpayConstants.RESULT_RP_WV_RESULT_STRING, paymentData.getData().toString());
                        intent.putExtra(RazorpayConstants.RESULT_RP_WV_RESULT_MPL_ORDER_ID, str2);
                        RazorPayGpayUpiActivity.this.setResult(-1, intent);
                        RazorPayGpayUpiActivity.this.finish();
                    }
                }).build();
                String string = extras.getString(RazorpayConstants.BUNDLE_RP_WV_COUPON_DATA, "");
                if (TextUtils.isEmpty(string)) {
                    this.razorPayCustomPayments.initiatePayment();
                } else {
                    this.razorPayCustomPayments.initiatePayment(string);
                }
            } catch (Exception e2) {
                String message = e2.getMessage();
                intent.putExtra(RazorpayConstants.RESULT_RP_WV_RESULT_TYPE, 1);
                intent.putExtra(RazorpayConstants.RESULT_RP_WV_RESULT_STRING, message);
                setResult(-1, intent);
                finish();
            }
        } else {
            intent.putExtra(RazorpayConstants.RESULT_RP_WV_RESULT_TYPE, 1);
            intent.putExtra(RazorpayConstants.RESULT_RP_WV_RESULT_STRING, "Extra is null");
            setResult(-1, intent);
            finish();
        }
    }

    private void startPaymentV2() {
        final Intent intent = new Intent();
        final Bundle extras = getIntent().getExtras();
        if (extras != null) {
            try {
                RazorpayPayments build = new RazorpayPaymentsBuilder().setTransactionType(extras.getString(RazorpayConstants.BUNDLE_RP_WV_TRANSACTION_TYPE, "")).setActivity(this).setRzpKey(extras.getString(RazorpayConstants.BUNDLE_RP_WV_RZP_KEY, "")).setWebView(this.paymentWebview).setAmountFromMoneyIn(extras.getString(RazorpayConstants.BUNDLE_RP_WV_ACTIVITY_AMOUNT_FRM_MI, "")).setRazorPayOrderId(extras.getString(RazorpayConstants.BUNDLE_RP_WV_RZP_ORDER_ID, "")).setEmail(extras.getString(RazorpayConstants.BUNDLE_RP_WV_EMAIL, "")).setNumber(extras.getString(RazorpayConstants.BUNDLE_RP_WV_NUMBER, "")).setCurrency(extras.getString(RazorpayConstants.BUNDLE_RP_WV_CURRENCY, "")).setRazorpaymentsListener(new RazorpaymentsListener() {
                    public void onPaymentFail(int i, String str, PaymentData paymentData) {
                        intent.putExtra(RazorpayConstants.RESULT_RP_WV_RESULT_TYPE, 2);
                        Intent intent = intent;
                        intent.putExtra(RazorpayConstants.RESULT_RP_WV_RESULT_STRING, "code-> " + i + " message-> " + str);
                        intent.putExtra(RazorpayConstants.RESULT_RP_WV_RESULT_MPL_ORDER_ID, extras.getString(RazorpayConstants.BUNDLE_RP_WV_MPL_ID, ""));
                        RazorPayGpayUpiActivity.this.setResult(-1, intent);
                        RazorPayGpayUpiActivity.this.finish();
                    }

                    public void onSuccessfulPayment(String str, PaymentData paymentData) {
                        intent.putExtra(RazorpayConstants.RESULT_RP_WV_RESULT_TYPE, 3);
                        intent.putExtra(RazorpayConstants.RESULT_RP_WV_RESULT_STRING, paymentData.getData().toString());
                        intent.putExtra(RazorpayConstants.RESULT_RP_WV_RESULT_MPL_ORDER_ID, extras.getString(RazorpayConstants.BUNDLE_RP_WV_MPL_ID, ""));
                        RazorPayGpayUpiActivity.this.setResult(-1, intent);
                        RazorPayGpayUpiActivity.this.finish();
                    }
                }).build();
                this.razorpayPayments = build;
                build.doRazorPayPayment();
            } catch (Exception e2) {
                String message = e2.getMessage();
                intent.putExtra(RazorpayConstants.RESULT_RP_WV_RESULT_TYPE, 1);
                intent.putExtra(RazorpayConstants.RESULT_RP_WV_RESULT_STRING, message);
                setResult(-1, intent);
                finish();
            }
        } else {
            intent.putExtra(RazorpayConstants.RESULT_RP_WV_RESULT_TYPE, 1);
            intent.putExtra(RazorpayConstants.RESULT_RP_WV_RESULT_STRING, "Extra is null");
            setResult(-1, intent);
            finish();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        RazorPayCustomPayments razorPayCustomPayments2 = this.razorPayCustomPayments;
        if (razorPayCustomPayments2 != null) {
            razorPayCustomPayments2.submitOnActivityResultsToRazorpay(i, i2, intent);
        }
        RazorpayPayments razorpayPayments2 = this.razorpayPayments;
        if (razorpayPayments2 != null) {
            razorpayPayments2.submitOnActivityResultsToRazorpay(i, i2, intent);
        }
    }

    public void onBackPressed() {
        RazorPayCustomPayments razorPayCustomPayments2 = this.razorPayCustomPayments;
        if (razorPayCustomPayments2 != null) {
            razorPayCustomPayments2.submitOnBackPressed();
        }
        RazorpayPayments razorpayPayments2 = this.razorpayPayments;
        if (razorpayPayments2 != null) {
            razorpayPayments2.submitOnBackPressed();
        }
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_razor_pay_gpay_web_view);
        WebView webView = (WebView) findViewById(R.id.payment_webview);
        this.paymentWebview = webView;
        webView.setVisibility(8);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.hasPaymentStarted = bundle.getBoolean("OUTSTATE_HAS_ACTIVITY_STARTED");
    }

    public void onResume() {
        super.onResume();
        if (!this.hasPaymentStarted) {
            this.hasPaymentStarted = true;
            if (getIntent().getBooleanExtra(RazorpayConstants.BUNDLE_RP_WV_IS_V2_PAYMENT, false)) {
                startPaymentV2();
            } else {
                startPaymentV1();
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("OUTSTATE_HAS_ACTIVITY_STARTED", this.hasPaymentStarted);
    }
}
