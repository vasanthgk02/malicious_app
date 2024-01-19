package com.mpl.payment.razorpay;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.WebView;
import com.razorpay.AnalyticsConstants;
import com.razorpay.BaseConstants;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultWithDataListener;
import com.razorpay.Razorpay;
import in.juspay.hypersdk.core.PaymentConstants;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.json.JSONObject;

public class RazorpayPayments {
    public static final String TAG = "RzpCustomPayment";
    public static final String TRANSACTION_TYPE_GPAY_HALFPAGEUPI = "gpayUpiHsTxn";
    public static final String TRANSACTION_TYPE_NETBANKING = "nbTxn";
    public static final String TRANSACTION_TYPE_NEW_CARDS = "newCardsTxn";
    public static final String TRANSACTION_TYPE_SAVED_CARDS = "savedCardsTxn";
    public String cardCvv;
    public String cardExpMonth;
    public String cardExpYear;
    public String cardHolderName;
    public String cardNo;
    public String cardToken;
    public Activity mActivity;
    public String mAmountFromMoneyIn;
    public String mCurrency;
    public String mEmail;
    public String mNumber;
    public String mRazorpayOrderId;
    public String mRzpKey;
    public String mSelectedBank;
    public WebView mWebView;
    public String mtransactionType;
    public Razorpay razorpay;
    public RazorpaymentsListener razorpaymentsListener;
    public String rzpCustomerId;
    public String shouldSaveCard;

    public static class RazorpayPaymentsBuilder {
        public RazorpayPayments razorpayPayments = new RazorpayPayments();

        public RazorpayPayments build() throws Exception {
            if (this.razorpayPayments.mtransactionType == null || TextUtils.isEmpty(this.razorpayPayments.mtransactionType)) {
                throw new Exception("mtransactionType can't be null or empty");
            } else if (this.razorpayPayments.mActivity == null) {
                throw new Exception("mActivity can't be null");
            } else if (this.razorpayPayments.mRzpKey == null || TextUtils.isEmpty(this.razorpayPayments.mRzpKey)) {
                throw new Exception("mRzpKey can't be null or empty");
            } else if (this.razorpayPayments.mWebView == null) {
                throw new Exception("mWebView can't be null");
            } else if (this.razorpayPayments.mAmountFromMoneyIn == null || TextUtils.isEmpty(this.razorpayPayments.mAmountFromMoneyIn)) {
                throw new Exception("mAmountFromMoneyIn can't be null or empty");
            } else if (this.razorpayPayments.mRazorpayOrderId == null || TextUtils.isEmpty(this.razorpayPayments.mRazorpayOrderId)) {
                throw new Exception("mRazorpayOrderId can't be null or empty");
            } else if (this.razorpayPayments.mEmail == null || TextUtils.isEmpty(this.razorpayPayments.mEmail)) {
                throw new Exception("mEmail can't be null or empty");
            } else if (this.razorpayPayments.mNumber == null || TextUtils.isEmpty(this.razorpayPayments.mNumber)) {
                throw new Exception("mNumber can't be null or empty");
            } else if (this.razorpayPayments.mCurrency == null || TextUtils.isEmpty(this.razorpayPayments.mCurrency)) {
                throw new Exception("mCurrency can't be null or empty");
            } else if (!"nbTxn".equals(this.razorpayPayments.mtransactionType) || (this.razorpayPayments.mSelectedBank != null && !TextUtils.isEmpty(this.razorpayPayments.mSelectedBank))) {
                if (RazorpayPayments.TRANSACTION_TYPE_NEW_CARDS.equals(this.razorpayPayments.mtransactionType)) {
                    if (this.razorpayPayments.cardHolderName == null || TextUtils.isEmpty(this.razorpayPayments.cardHolderName)) {
                        throw new Exception("cardHolderName can't be null or empty");
                    } else if (this.razorpayPayments.cardNo == null || TextUtils.isEmpty(this.razorpayPayments.cardNo)) {
                        throw new Exception("cardNo can't be null or empty");
                    } else if (this.razorpayPayments.cardExpMonth == null || TextUtils.isEmpty(this.razorpayPayments.cardExpMonth)) {
                        throw new Exception("cardExpMonth can't be null or empty");
                    } else if (this.razorpayPayments.cardExpYear == null || TextUtils.isEmpty(this.razorpayPayments.cardExpYear)) {
                        throw new Exception("cardExpYear can't be null or empty");
                    } else if (this.razorpayPayments.cardCvv == null || TextUtils.isEmpty(this.razorpayPayments.cardCvv)) {
                        throw new Exception("cardCvv can't be null or empty");
                    } else if (this.razorpayPayments.shouldSaveCard == null || TextUtils.isEmpty(this.razorpayPayments.shouldSaveCard)) {
                        throw new Exception("shouldSaveCard can't be null or empty");
                    } else if (this.razorpayPayments.rzpCustomerId == null || TextUtils.isEmpty(this.razorpayPayments.rzpCustomerId)) {
                        throw new Exception("rzpCustomerId can't be null or empty");
                    }
                }
                if (RazorpayPayments.TRANSACTION_TYPE_SAVED_CARDS.equals(this.razorpayPayments.mtransactionType)) {
                    if (this.razorpayPayments.cardCvv == null || TextUtils.isEmpty(this.razorpayPayments.cardCvv)) {
                        throw new Exception("cardCvv can't be null or empty");
                    } else if (this.razorpayPayments.rzpCustomerId == null || TextUtils.isEmpty(this.razorpayPayments.rzpCustomerId)) {
                        throw new Exception("rzpCustomerId can't be null or empty");
                    } else if (this.razorpayPayments.cardToken == null || TextUtils.isEmpty(this.razorpayPayments.cardToken)) {
                        throw new Exception("cardToken can't be null or empty");
                    }
                }
                return this.razorpayPayments;
            } else {
                throw new Exception("mSelectedBankType can't be null or empty");
            }
        }

        public RazorpayPaymentsBuilder setActivity(Activity activity) {
            this.razorpayPayments.mActivity = activity;
            return this;
        }

        public RazorpayPaymentsBuilder setAmountFromMoneyIn(String str) {
            this.razorpayPayments.mAmountFromMoneyIn = str;
            return this;
        }

        public RazorpayPaymentsBuilder setCardCvv(String str) {
            this.razorpayPayments.cardCvv = str;
            return this;
        }

        public RazorpayPaymentsBuilder setCardExpMonth(String str) {
            this.razorpayPayments.cardExpMonth = str;
            return this;
        }

        public RazorpayPaymentsBuilder setCardExpYear(String str) {
            this.razorpayPayments.cardExpYear = str;
            return this;
        }

        public RazorpayPaymentsBuilder setCardHolderName(String str) {
            this.razorpayPayments.cardHolderName = str;
            return this;
        }

        public RazorpayPaymentsBuilder setCardNo(String str) {
            this.razorpayPayments.cardNo = str;
            return this;
        }

        public RazorpayPaymentsBuilder setCardToken(String str) {
            this.razorpayPayments.cardToken = str;
            return this;
        }

        public RazorpayPaymentsBuilder setCurrency(String str) {
            this.razorpayPayments.mCurrency = str;
            return this;
        }

        public RazorpayPaymentsBuilder setEmail(String str) {
            this.razorpayPayments.mEmail = str;
            return this;
        }

        public RazorpayPaymentsBuilder setNumber(String str) {
            this.razorpayPayments.mNumber = str;
            return this;
        }

        public RazorpayPaymentsBuilder setRazorPayOrderId(String str) {
            this.razorpayPayments.mRazorpayOrderId = str;
            return this;
        }

        public RazorpayPaymentsBuilder setRazorpaymentsListener(RazorpaymentsListener razorpaymentsListener) {
            this.razorpayPayments.razorpaymentsListener = razorpaymentsListener;
            return this;
        }

        public RazorpayPaymentsBuilder setRzpCustomerId(String str) {
            this.razorpayPayments.rzpCustomerId = str;
            return this;
        }

        public RazorpayPaymentsBuilder setRzpKey(String str) {
            this.razorpayPayments.mRzpKey = str;
            return this;
        }

        public RazorpayPaymentsBuilder setSelectedBank(String str) {
            this.razorpayPayments.mSelectedBank = str;
            return this;
        }

        public RazorpayPaymentsBuilder setShouldSaveCard(String str) {
            this.razorpayPayments.shouldSaveCard = str;
            return this;
        }

        public RazorpayPaymentsBuilder setTransactionType(String str) {
            this.razorpayPayments.mtransactionType = str;
            return this;
        }

        public RazorpayPaymentsBuilder setWebView(WebView webView) {
            this.razorpayPayments.mWebView = webView;
            return this;
        }
    }

    public void doRazorPayPayment() {
        Razorpay razorpay2 = new Razorpay(this.mActivity, this.mRzpKey);
        this.razorpay = razorpay2;
        razorpay2.setWebView(this.mWebView);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("amount", this.mAmountFromMoneyIn);
            jSONObject.put("order_id", this.mRazorpayOrderId);
            jSONObject.put("email", this.mEmail);
            jSONObject.put(AnalyticsConstants.CONTACT, this.mNumber);
            jSONObject.put("currency", this.mCurrency);
            if ("gpayUpiHsTxn".equals(this.mtransactionType)) {
                jSONObject.put(AnalyticsConstants.METHOD, "upi");
                jSONObject.put("_[flow]", AnalyticsConstants.INTENT);
                jSONObject.put(AnalyticsConstants.UPI_APP_PACKAGE_NAME, BaseConstants.GOOGLE_PAY_PKG);
            } else if ("nbTxn".equals(this.mtransactionType)) {
                jSONObject.put(AnalyticsConstants.METHOD, "netbanking");
                jSONObject.put("bank", this.mSelectedBank);
            } else if (TRANSACTION_TYPE_NEW_CARDS.equals(this.mtransactionType)) {
                jSONObject.put(AnalyticsConstants.METHOD, "card");
                jSONObject.put("card[name]", this.cardHolderName);
                jSONObject.put("card[number]", this.cardNo);
                jSONObject.put("card[expiry_month]", this.cardExpMonth);
                jSONObject.put("card[expiry_year]", this.cardExpYear);
                jSONObject.put("card[cvv]", this.cardCvv);
                if (BaseParser.TRUE.equalsIgnoreCase(this.shouldSaveCard)) {
                    jSONObject.put(PaymentConstants.CUSTOMER_ID, this.rzpCustomerId);
                    jSONObject.put("save", 1);
                }
            } else if (TRANSACTION_TYPE_SAVED_CARDS.equals(this.mtransactionType)) {
                jSONObject.put(AnalyticsConstants.METHOD, "card");
                jSONObject.put("card[cvv]", this.cardCvv);
                jSONObject.put(PaymentConstants.CUSTOMER_ID, this.rzpCustomerId);
                jSONObject.put("token", this.cardToken);
            }
            this.razorpay.submit(jSONObject, (PaymentResultWithDataListener) new PaymentResultWithDataListener() {
                public void onPaymentError(int i, String str, PaymentData paymentData) {
                    RazorpayPayments.this.razorpaymentsListener.onPaymentFail(i, str, paymentData);
                }

                public void onPaymentSuccess(String str, PaymentData paymentData) {
                    RazorpayPayments.this.razorpaymentsListener.onSuccessfulPayment(str, paymentData);
                }
            });
        } catch (Exception unused) {
        }
    }

    public void submitOnActivityResultsToRazorpay(int i, int i2, Intent intent) {
        Razorpay razorpay2 = this.razorpay;
        if (razorpay2 != null) {
            razorpay2.onActivityResult(i, i2, intent);
        }
    }

    public void submitOnBackPressed() {
        Razorpay razorpay2 = this.razorpay;
        if (razorpay2 != null) {
            razorpay2.onBackPressed();
        }
    }
}
