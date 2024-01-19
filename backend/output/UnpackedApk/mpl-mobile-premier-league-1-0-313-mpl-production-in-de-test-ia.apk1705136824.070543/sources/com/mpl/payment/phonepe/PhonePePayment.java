package com.mpl.payment.phonepe;

import android.app.Activity;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.Constant;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.payment.common.AuthTokenProvider;
import com.mpl.payment.common.TransactionParamsCreator;
import com.mpl.payment.routing.PaymentResultListener;
import com.mpl.payment.routing.RoutingConstants;
import com.squareup.moshi.Moshi;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001+BM\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020)R\u0014\u0010\u0012\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u001a\u0010 \u001a\u00020!X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0014¨\u0006,"}, d2 = {"Lcom/mpl/payment/phonepe/PhonePePayment;", "", "phonePeMoneyInPayloadString", "", "phonePeReactPayloadString", "paymentResultListener", "Lcom/mpl/payment/routing/PaymentResultListener;", "moshi", "Lcom/squareup/moshi/Moshi;", "activity", "Landroid/app/Activity;", "headers", "", "Lcom/mpl/network/modules/engine/MHeader;", "phonePeVersionCode", "authTokenProvider", "Lcom/mpl/payment/common/AuthTokenProvider;", "(Ljava/lang/String;Ljava/lang/String;Lcom/mpl/payment/routing/PaymentResultListener;Lcom/squareup/moshi/Moshi;Landroid/app/Activity;Ljava/util/List;Ljava/lang/String;Lcom/mpl/payment/common/AuthTokenProvider;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getActivity", "()Landroid/app/Activity;", "getAuthTokenProvider", "()Lcom/mpl/payment/common/AuthTokenProvider;", "getHeaders", "()Ljava/util/List;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "getPaymentResultListener", "()Lcom/mpl/payment/routing/PaymentResultListener;", "getPhonePeMoneyInPayloadString", "phonePePaymentHandler", "Lcom/mpl/payment/phonepe/PhonePePaymentHandler;", "getPhonePePaymentHandler", "()Lcom/mpl/payment/phonepe/PhonePePaymentHandler;", "setPhonePePaymentHandler", "(Lcom/mpl/payment/phonepe/PhonePePaymentHandler;)V", "getPhonePeReactPayloadString", "getPhonePeVersionCode", "doPhonePePayment", "", "onActivityResultForwarder", "Builder", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: PhonePePayment.kt */
public final class PhonePePayment {
    public final String TAG;
    public final Activity activity;
    public final AuthTokenProvider authTokenProvider;
    public final List<MHeader> headers;
    public final Moshi moshi;
    public final PaymentResultListener paymentResultListener;
    public final String phonePeMoneyInPayloadString;
    public PhonePePaymentHandler phonePePaymentHandler;
    public final String phonePeReactPayloadString;
    public final String phonePeVersionCode;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u00101\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u0014\u00102\u001a\u00020\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u000e\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u00020#J\u000e\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u00020\u0017J\u000e\u00107\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u00108\u001a\u00020\u00002\u0006\u0010+\u001a\u00020#J\u000e\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020#R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u001c\u0010+\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'¨\u0006;"}, d2 = {"Lcom/mpl/payment/phonepe/PhonePePayment$Builder;", "", "()V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "authTokenProvider", "Lcom/mpl/payment/common/AuthTokenProvider;", "getAuthTokenProvider", "()Lcom/mpl/payment/common/AuthTokenProvider;", "setAuthTokenProvider", "(Lcom/mpl/payment/common/AuthTokenProvider;)V", "headers", "", "Lcom/mpl/network/modules/engine/MHeader;", "getHeaders", "()Ljava/util/List;", "setHeaders", "(Ljava/util/List;)V", "moshi", "Lcom/squareup/moshi/Moshi;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "setMoshi", "(Lcom/squareup/moshi/Moshi;)V", "paymentResultListener", "Lcom/mpl/payment/routing/PaymentResultListener;", "getPaymentResultListener", "()Lcom/mpl/payment/routing/PaymentResultListener;", "setPaymentResultListener", "(Lcom/mpl/payment/routing/PaymentResultListener;)V", "phonePeMoneyInPayloadString", "", "getPhonePeMoneyInPayloadString", "()Ljava/lang/String;", "setPhonePeMoneyInPayloadString", "(Ljava/lang/String;)V", "phonePeReactPayloadString", "getPhonePeReactPayloadString", "setPhonePeReactPayloadString", "phonePeVersionCode", "getPhonePeVersionCode", "setPhonePeVersionCode", "build", "Lcom/mpl/payment/phonepe/PhonePePayment;", "withActivity", "withAuthTokenProvider", "withHeaders", "withMoneyInPaload", "moneyInPayload", "withMoshiInstance", "moshiInstance", "withPaymentResultListener", "withPhonePeVersionCode", "withReactPayload", "reactPayload", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PhonePePayment.kt */
    public static final class Builder {
        public Activity activity;
        public AuthTokenProvider authTokenProvider;
        public List<MHeader> headers;
        public Moshi moshi;
        public PaymentResultListener paymentResultListener;
        public String phonePeMoneyInPayloadString;
        public String phonePeReactPayloadString;
        public String phonePeVersionCode;

        public final PhonePePayment build() {
            String str = this.phonePeMoneyInPayloadString;
            if (str != null) {
                String str2 = this.phonePeReactPayloadString;
                if (str2 != null) {
                    PaymentResultListener paymentResultListener2 = this.paymentResultListener;
                    if (paymentResultListener2 != null) {
                        Moshi moshi2 = this.moshi;
                        if (moshi2 != null) {
                            Activity activity2 = this.activity;
                            if (activity2 != null) {
                                List<MHeader> list = this.headers;
                                if (list != null) {
                                    String str3 = this.phonePeVersionCode;
                                    if (str3 != null) {
                                        AuthTokenProvider authTokenProvider2 = this.authTokenProvider;
                                        if (authTokenProvider2 != null) {
                                            PhonePePayment phonePePayment = new PhonePePayment(str, str2, paymentResultListener2, moshi2, activity2, list, str3, authTokenProvider2, null);
                                            return phonePePayment;
                                        }
                                        throw new Exception(GeneratedOutlineSupport.outline50("authTokenProvider is mandatory when instantiating ", "PhonePePaymentDelegate"));
                                    }
                                    throw new Exception(GeneratedOutlineSupport.outline50("PaymentResultlistener is mandatory when instantiating ", "PhonePePaymentDelegate"));
                                }
                                throw new Exception(GeneratedOutlineSupport.outline50("Headers List is mandatory when instantiating ", "PhonePePaymentDelegate"));
                            }
                            throw new Exception(GeneratedOutlineSupport.outline50("Activity is mandatory when instantiating ", "PhonePePaymentDelegate"));
                        }
                        throw new Exception(GeneratedOutlineSupport.outline50("MoshiInstance is mandatory when instantiating ", "PhonePePaymentDelegate"));
                    }
                    throw new Exception(GeneratedOutlineSupport.outline50("PaymentResultListener is mandatory when instantiating ", "PhonePePaymentDelegate"));
                }
                throw new Exception(GeneratedOutlineSupport.outline50("ReactPayload is mandatory when instantiating ", "PhonePePaymentDelegate"));
            }
            throw new Exception(GeneratedOutlineSupport.outline50("MoneyInPayload is mandatory when instantiating ", "PhonePePaymentDelegate"));
        }

        public final Activity getActivity() {
            return this.activity;
        }

        public final AuthTokenProvider getAuthTokenProvider() {
            return this.authTokenProvider;
        }

        public final List<MHeader> getHeaders() {
            return this.headers;
        }

        public final Moshi getMoshi() {
            return this.moshi;
        }

        public final PaymentResultListener getPaymentResultListener() {
            return this.paymentResultListener;
        }

        public final String getPhonePeMoneyInPayloadString() {
            return this.phonePeMoneyInPayloadString;
        }

        public final String getPhonePeReactPayloadString() {
            return this.phonePeReactPayloadString;
        }

        public final String getPhonePeVersionCode() {
            return this.phonePeVersionCode;
        }

        public final void setActivity(Activity activity2) {
            this.activity = activity2;
        }

        public final void setAuthTokenProvider(AuthTokenProvider authTokenProvider2) {
            this.authTokenProvider = authTokenProvider2;
        }

        public final void setHeaders(List<MHeader> list) {
            this.headers = list;
        }

        public final void setMoshi(Moshi moshi2) {
            this.moshi = moshi2;
        }

        public final void setPaymentResultListener(PaymentResultListener paymentResultListener2) {
            this.paymentResultListener = paymentResultListener2;
        }

        public final void setPhonePeMoneyInPayloadString(String str) {
            this.phonePeMoneyInPayloadString = str;
        }

        public final void setPhonePeReactPayloadString(String str) {
            this.phonePeReactPayloadString = str;
        }

        public final void setPhonePeVersionCode(String str) {
            this.phonePeVersionCode = str;
        }

        public final Builder withActivity(Activity activity2) {
            Intrinsics.checkNotNullParameter(activity2, "activity");
            this.activity = activity2;
            return this;
        }

        public final Builder withAuthTokenProvider(AuthTokenProvider authTokenProvider2) {
            Intrinsics.checkNotNullParameter(authTokenProvider2, "authTokenProvider");
            this.authTokenProvider = authTokenProvider2;
            return this;
        }

        public final Builder withHeaders(List<MHeader> list) {
            Intrinsics.checkNotNullParameter(list, Constant.HEADER);
            this.headers = list;
            return this;
        }

        public final Builder withMoneyInPaload(String str) {
            Intrinsics.checkNotNullParameter(str, RoutingConstants.MI_RESPONSE_MONEY_IN_PAYLOAD);
            this.phonePeMoneyInPayloadString = str;
            return this;
        }

        public final Builder withMoshiInstance(Moshi moshi2) {
            Intrinsics.checkNotNullParameter(moshi2, "moshiInstance");
            this.moshi = moshi2;
            return this;
        }

        public final Builder withPaymentResultListener(PaymentResultListener paymentResultListener2) {
            Intrinsics.checkNotNullParameter(paymentResultListener2, "paymentResultListener");
            this.paymentResultListener = paymentResultListener2;
            return this;
        }

        public final Builder withPhonePeVersionCode(String str) {
            Intrinsics.checkNotNullParameter(str, "phonePeVersionCode");
            this.phonePeVersionCode = str;
            return this;
        }

        public final Builder withReactPayload(String str) {
            Intrinsics.checkNotNullParameter(str, "reactPayload");
            this.phonePeReactPayloadString = str;
            return this;
        }
    }

    public PhonePePayment(String str, String str2, PaymentResultListener paymentResultListener2, Moshi moshi2, Activity activity2, List<MHeader> list, String str3, AuthTokenProvider authTokenProvider2) {
        this.phonePeMoneyInPayloadString = str;
        this.phonePeReactPayloadString = str2;
        this.paymentResultListener = paymentResultListener2;
        this.moshi = moshi2;
        this.activity = activity2;
        this.headers = list;
        this.phonePeVersionCode = str3;
        this.authTokenProvider = authTokenProvider2;
        this.TAG = "PhonePePaymentDelegate";
    }

    public final void doPhonePePayment() {
        try {
            PhonePePaymentHandler phonePePaymentHandler2 = new PhonePePaymentHandler(this.paymentResultListener, this.activity, this.moshi, this.phonePeMoneyInPayloadString, this.phonePeReactPayloadString, this.headers, this.authTokenProvider, this.phonePeVersionCode);
            this.phonePePaymentHandler = phonePePaymentHandler2;
            if (phonePePaymentHandler2 != null) {
                TransactionParamsCreator transactionParamsCreator = phonePePaymentHandler2.getTransactionParamsCreator();
                PhonePePaymentHandler phonePePaymentHandler3 = this.phonePePaymentHandler;
                if (phonePePaymentHandler3 != null) {
                    phonePePaymentHandler3.processPayment(transactionParamsCreator);
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("phonePePaymentHandler");
                    throw null;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("phonePePaymentHandler");
                throw null;
            }
        } catch (Exception e2) {
            String message = e2.getMessage();
            if (message == null) {
                message = "An exception occured when parsing PhonePayMoneyInPayload";
            }
            this.paymentResultListener.onMoneyInFailed(message);
        }
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final AuthTokenProvider getAuthTokenProvider() {
        return this.authTokenProvider;
    }

    public final List<MHeader> getHeaders() {
        return this.headers;
    }

    public final Moshi getMoshi() {
        return this.moshi;
    }

    public final PaymentResultListener getPaymentResultListener() {
        return this.paymentResultListener;
    }

    public final String getPhonePeMoneyInPayloadString() {
        return this.phonePeMoneyInPayloadString;
    }

    public final PhonePePaymentHandler getPhonePePaymentHandler() {
        PhonePePaymentHandler phonePePaymentHandler2 = this.phonePePaymentHandler;
        if (phonePePaymentHandler2 != null) {
            return phonePePaymentHandler2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("phonePePaymentHandler");
        throw null;
    }

    public final String getPhonePeReactPayloadString() {
        return this.phonePeReactPayloadString;
    }

    public final String getPhonePeVersionCode() {
        return this.phonePeVersionCode;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final void onActivityResultForwarder() {
        PhonePePaymentHandler phonePePaymentHandler2 = this.phonePePaymentHandler;
        if (phonePePaymentHandler2 != null) {
            phonePePaymentHandler2.completePayment();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("phonePePaymentHandler");
            throw null;
        }
    }

    public final void setPhonePePaymentHandler(PhonePePaymentHandler phonePePaymentHandler2) {
        Intrinsics.checkNotNullParameter(phonePePaymentHandler2, "<set-?>");
        this.phonePePaymentHandler = phonePePaymentHandler2;
    }

    public /* synthetic */ PhonePePayment(String str, String str2, PaymentResultListener paymentResultListener2, Moshi moshi2, Activity activity2, List list, String str3, AuthTokenProvider authTokenProvider2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, paymentResultListener2, moshi2, activity2, list, str3, authTokenProvider2);
    }
}
