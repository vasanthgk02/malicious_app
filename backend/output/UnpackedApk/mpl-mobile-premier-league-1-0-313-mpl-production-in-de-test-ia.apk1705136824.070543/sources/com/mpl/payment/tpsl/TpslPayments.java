package com.mpl.payment.tpsl;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.paynimo.android.payment.PaymentActivity;
import com.paynimo.android.payment.PaymentModesActivity.Factory;
import com.paynimo.android.payment.PaymentModesActivity.Settings;
import com.paynimo.android.payment.model.Checkout;
import com.paynimo.android.payment.util.Constant;
import org.apache.pdfbox.pdfparser.BaseParser;

public class TpslPayments {
    public static final String TAG = "pineapple";
    public static final String TPSL_CARDS_BANK_CODE_KILLSWITCH = "no_bank_code_mpl";
    public static final String TPSL_TRANSACTION_TYPE_CARD = "cards";
    public static final String TPSL_TRANSACTION_TYPE_NETBANKING = "netbanking";
    public static final String TPSL_TRANSACTION_TYPE_UPI = "upi";
    public static final String TPSL_TRANSACTION_TYPE_WALLET = "wallet";
    public Activity activity;
    public String cardCvv;
    public String cardHolderName;
    public String cardInstrumentationToken;
    public String cardMonth;
    public String cardNumber;
    public String cardYear;
    public String commisionAmount = IdManager.DEFAULT_VERSION_NAME;
    public String consumerAccountNo;
    public String consumerEmailID;
    public String consumerIdentifier;
    public String consumerMobileNumber;
    public String merchantIdentifier;
    public String paymentMethodToken;
    public String paymentMethodTypeFromReact;
    public String productAmount;
    public String productDescriptor = "";
    public String productID;
    public String productProviderIdentifier = "";
    public String productReference = "";
    public String productSKU = "";
    public String productSurchargeOrDiscountAmount = IdManager.DEFAULT_VERSION_NAME;
    public String savedPaymentTypeFromReact;
    public String shouldSaveCard;
    public TpslPaymentsListener tpslPaymentsListener;
    public int tpslRequestCode;
    public String transactionAmount;
    public String transactionCurrency;
    public String transactionDateTime;
    public String transactionIdentifier;
    public String transactionReference;
    public String transactionSubType = PaymentActivity.TRANSACTION_SUBTYPE_DEBIT;
    public String transactionType = PaymentActivity.TRANSACTION_TYPE_SALE;

    public static class TpslPaymentsBuilder {
        public TpslPayments tpslPayments = new TpslPayments();

        public TpslPayments build() throws Exception {
            if (this.tpslPayments.tpslRequestCode != 0) {
                String str = this.tpslPayments.merchantIdentifier;
                if (str == null || TextUtils.isEmpty(str)) {
                    throw new Exception("Merchent Identifier Cant be null or empty");
                }
                String str2 = this.tpslPayments.transactionIdentifier;
                if (str2 == null || TextUtils.isEmpty(str2)) {
                    throw new Exception("transactionIdentifier Cant be null or empty");
                }
                String str3 = this.tpslPayments.transactionReference;
                if (str3 == null || TextUtils.isEmpty(str3)) {
                    throw new Exception("transactionReference Cant be null or empty");
                }
                String str4 = this.tpslPayments.transactionCurrency;
                if (str4 == null || TextUtils.isEmpty(str4)) {
                    throw new Exception("transactionCurrency Cant be null or empty");
                }
                String str5 = this.tpslPayments.transactionAmount;
                if (str5 == null || TextUtils.isEmpty(str5)) {
                    throw new Exception("transactionAmount Cant be null or empty");
                }
                String str6 = this.tpslPayments.transactionDateTime;
                if (str6 == null || TextUtils.isEmpty(str6)) {
                    throw new Exception("transactionDateTime Cant be null or empty");
                }
                String str7 = this.tpslPayments.consumerIdentifier;
                if (str7 == null || TextUtils.isEmpty(str7)) {
                    throw new Exception("consumerIdentifier Cant be null or empty");
                }
                String str8 = this.tpslPayments.consumerEmailID;
                if (str8 == null || TextUtils.isEmpty(str8)) {
                    throw new Exception("consumerEmailID Cant be null or empty");
                }
                String str9 = this.tpslPayments.consumerMobileNumber;
                if (str9 == null || TextUtils.isEmpty(str9)) {
                    throw new Exception("consumerMobileNumber Cant be null or empty");
                }
                TpslPayments tpslPayments2 = this.tpslPayments;
                if (tpslPayments2.consumerAccountNo != null) {
                    String str10 = tpslPayments2.productID;
                    if (str10 == null || TextUtils.isEmpty(str10)) {
                        throw new Exception("productID  Cant be null or empty");
                    }
                    String str11 = this.tpslPayments.productAmount;
                    if (str11 == null || TextUtils.isEmpty(str11)) {
                        throw new Exception("productAmount Cant be null or empty");
                    }
                    String str12 = this.tpslPayments.paymentMethodTypeFromReact;
                    if (str12 == null || TextUtils.isEmpty(str12)) {
                        throw new Exception("paymentMethodTypeFromReact Cant be null or empty");
                    }
                    String str13 = this.tpslPayments.savedPaymentTypeFromReact;
                    if (str13 == null || TextUtils.isEmpty(str13)) {
                        throw new Exception("savedPaymentTypeFromReact Cant be null or empty");
                    }
                    String str14 = this.tpslPayments.paymentMethodToken;
                    if (str14 == null || TextUtils.isEmpty(str14)) {
                        throw new Exception("paymentMethodToken Cant be null or empty");
                    }
                    if ("cards".equalsIgnoreCase(this.tpslPayments.paymentMethodTypeFromReact)) {
                        if (BaseParser.FALSE.equalsIgnoreCase(this.tpslPayments.savedPaymentTypeFromReact)) {
                            String str15 = this.tpslPayments.cardNumber;
                            if (str15 == null || TextUtils.isEmpty(str15)) {
                                throw new Exception("cardNumber Cant be null or empty");
                            }
                            String str16 = this.tpslPayments.cardMonth;
                            if (str16 == null || TextUtils.isEmpty(str16)) {
                                throw new Exception("cardMonth Cant be null or empty");
                            }
                            String str17 = this.tpslPayments.cardYear;
                            if (str17 == null || TextUtils.isEmpty(str17)) {
                                throw new Exception("cardYear Cant be null or empty");
                            }
                            String str18 = this.tpslPayments.cardHolderName;
                            if (str18 == null || TextUtils.isEmpty(str18)) {
                                throw new Exception("cardHolderName Cant be null or empty");
                            }
                            String str19 = this.tpslPayments.cardCvv;
                            if (str19 == null || TextUtils.isEmpty(str19)) {
                                throw new Exception("cardCvv Cant be null or empty");
                            }
                            String str20 = this.tpslPayments.shouldSaveCard;
                            if (str20 == null || TextUtils.isEmpty(str20)) {
                                throw new Exception("shouldSaveCard Cant be null or empty");
                            }
                        } else if (BaseParser.TRUE.equalsIgnoreCase(this.tpslPayments.savedPaymentTypeFromReact)) {
                            String str21 = this.tpslPayments.cardCvv;
                            if (str21 == null || TextUtils.isEmpty(str21)) {
                                throw new Exception("cardCvv Cant be null or empty");
                            }
                            String str22 = this.tpslPayments.cardInstrumentationToken;
                            if (str22 == null || TextUtils.isEmpty(str22)) {
                                throw new Exception("cardInstrumentationToken Cant be null or empty");
                            }
                        }
                    }
                    TpslPayments tpslPayments3 = this.tpslPayments;
                    if (tpslPayments3.activity == null) {
                        throw new Exception("activity Cant be null");
                    } else if (tpslPayments3.tpslPaymentsListener != null) {
                        return tpslPayments3;
                    } else {
                        throw new Exception("tpslPaymentsListener Cant be null");
                    }
                } else {
                    throw new Exception("consumerAccountNo Cant be null");
                }
            } else {
                throw new Exception("Tpsl request code not set");
            }
        }

        public TpslPaymentsBuilder setActivity(Activity activity) {
            this.tpslPayments.activity = activity;
            return this;
        }

        public TpslPaymentsBuilder setCardCvv(String str) {
            this.tpslPayments.cardCvv = str;
            return this;
        }

        public TpslPaymentsBuilder setCardHolderName(String str) {
            this.tpslPayments.cardHolderName = str;
            return this;
        }

        public TpslPaymentsBuilder setCardInstrumentationToken(String str) {
            this.tpslPayments.cardInstrumentationToken = str;
            return this;
        }

        public TpslPaymentsBuilder setCardMonth(String str) {
            this.tpslPayments.cardMonth = str;
            return this;
        }

        public TpslPaymentsBuilder setCardNumber(String str) {
            this.tpslPayments.cardNumber = str;
            return this;
        }

        public TpslPaymentsBuilder setCardYear(String str) {
            this.tpslPayments.cardYear = str;
            return this;
        }

        public TpslPaymentsBuilder setConsumerAccountNo(String str) {
            this.tpslPayments.consumerAccountNo = str;
            return this;
        }

        public TpslPaymentsBuilder setConsumerEmailID(String str) {
            this.tpslPayments.consumerEmailID = str;
            return this;
        }

        public TpslPaymentsBuilder setConsumerIdentifier(String str) {
            this.tpslPayments.consumerIdentifier = str;
            return this;
        }

        public TpslPaymentsBuilder setConsumerMobileNumber(String str) {
            this.tpslPayments.consumerMobileNumber = str;
            return this;
        }

        public TpslPaymentsBuilder setMerchantIdentifier(String str) {
            this.tpslPayments.merchantIdentifier = str;
            return this;
        }

        public TpslPaymentsBuilder setPaymentMethodToken(String str) {
            this.tpslPayments.paymentMethodToken = str;
            return this;
        }

        public TpslPaymentsBuilder setPaymentMethodTypeFromReact(String str) {
            this.tpslPayments.paymentMethodTypeFromReact = str;
            return this;
        }

        public TpslPaymentsBuilder setProductAmount(String str) {
            this.tpslPayments.productAmount = str;
            return this;
        }

        public TpslPaymentsBuilder setProductID(String str) {
            this.tpslPayments.productID = str;
            return this;
        }

        public TpslPaymentsBuilder setSavedPaymentTypeFromReact(String str) {
            this.tpslPayments.savedPaymentTypeFromReact = str;
            return this;
        }

        public TpslPaymentsBuilder setShouldSaveCard(String str) {
            this.tpslPayments.shouldSaveCard = str;
            return this;
        }

        public TpslPaymentsBuilder setTpslPaymentsListener(TpslPaymentsListener tpslPaymentsListener) {
            this.tpslPayments.tpslPaymentsListener = tpslPaymentsListener;
            return this;
        }

        public TpslPaymentsBuilder setTpslRequescode(int i) {
            this.tpslPayments.tpslRequestCode = i;
            return this;
        }

        public TpslPaymentsBuilder setTransactionAmount(String str) {
            this.tpslPayments.transactionAmount = str;
            return this;
        }

        public TpslPaymentsBuilder setTransactionCurrency(String str) {
            this.tpslPayments.transactionCurrency = str;
            return this;
        }

        public TpslPaymentsBuilder setTransactionDateTime(String str) {
            this.tpslPayments.transactionDateTime = str;
            return this;
        }

        public TpslPaymentsBuilder setTransactionIdentifier(String str) {
            this.tpslPayments.transactionIdentifier = str;
            return this;
        }

        public TpslPaymentsBuilder setTransactionReference(String str) {
            this.tpslPayments.transactionReference = str;
            return this;
        }
    }

    public void doTpslPayment() {
        Checkout checkout = new Checkout();
        checkout.setMerchantIdentifier(this.merchantIdentifier);
        checkout.setTransactionIdentifier(this.transactionIdentifier);
        checkout.setTransactionReference(this.transactionReference);
        checkout.setTransactionType(this.transactionType);
        checkout.setTransactionSubType(this.transactionSubType);
        checkout.setTransactionCurrency(this.transactionCurrency);
        checkout.setTransactionAmount(this.transactionAmount);
        checkout.setTransactionDateTime(this.transactionDateTime);
        checkout.setConsumerIdentifier(this.consumerIdentifier);
        checkout.setConsumerEmailID(this.consumerEmailID);
        checkout.setConsumerMobileNumber(this.consumerMobileNumber);
        checkout.setConsumerAccountNo(this.consumerAccountNo);
        checkout.addCartItem(this.productID, this.productAmount, this.productSurchargeOrDiscountAmount, this.commisionAmount, this.productSKU, this.productReference, this.productDescriptor, this.productProviderIdentifier);
        String str = "Y";
        checkout.setTransactionMerchantInitiated(str);
        boolean equalsIgnoreCase = "cards".equalsIgnoreCase(this.paymentMethodTypeFromReact);
        String str2 = PaymentActivity.PAYMENT_METHOD_CARDS;
        if (equalsIgnoreCase) {
            if (BaseParser.FALSE.equalsIgnoreCase(this.savedPaymentTypeFromReact)) {
                checkout.setPaymentInstrumentIdentifier(this.cardNumber);
                checkout.setPaymentInstrumentExpiryMonth(this.cardMonth);
                checkout.setPaymentInstrumentExpiryYear(this.cardYear);
                checkout.setPaymentInstrumentVerificationCode(this.cardCvv);
                checkout.setPaymentInstrumentHolderName(this.cardHolderName);
                if (!BaseParser.TRUE.equalsIgnoreCase(this.shouldSaveCard)) {
                    str = "N";
                }
                checkout.setTransactionIsRegistration(str);
                if (!TPSL_CARDS_BANK_CODE_KILLSWITCH.equalsIgnoreCase(this.paymentMethodToken)) {
                    checkout.setPaymentMethodToken(this.paymentMethodToken);
                }
            } else {
                checkout.setPaymentInstrumentToken(this.cardInstrumentationToken);
                checkout.setPaymentInstrumentVerificationCode(this.cardCvv);
                if (!TPSL_CARDS_BANK_CODE_KILLSWITCH.equalsIgnoreCase(this.paymentMethodToken)) {
                    checkout.setPaymentMethodToken(this.paymentMethodToken);
                }
            }
        } else if ("netbanking".equalsIgnoreCase(this.paymentMethodTypeFromReact)) {
            checkout.setPaymentMethodToken(this.paymentMethodToken);
            str2 = PaymentActivity.PAYMENT_METHOD_NETBANKING;
        } else if ("wallet".equalsIgnoreCase(this.paymentMethodTypeFromReact)) {
            checkout.setPaymentMethodToken(this.paymentMethodToken);
            str2 = PaymentActivity.PAYMENT_METHOD_WALLETS;
        } else if ("upi".equalsIgnoreCase(this.paymentMethodTypeFromReact)) {
            checkout.setPaymentMethodToken(this.paymentMethodToken);
            str2 = "UPI";
        } else {
            str2 = "";
        }
        Intent authorizationIntent = Factory.getAuthorizationIntent(this.activity.getBaseContext(), true);
        authorizationIntent.putExtra(Constant.ARGUMENT_DATA_CHECKOUT, checkout);
        authorizationIntent.putExtra(PaymentActivity.EXTRA_PUBLIC_KEY, "1234-6666-6789-56");
        authorizationIntent.putExtra(PaymentActivity.EXTRA_REQUESTED_PAYMENT_MODE, str2);
        authorizationIntent.putExtra(Constant.ARGUMENT_DATA_SETTING, new Settings());
        this.activity.startActivityForResult(authorizationIntent, this.tpslRequestCode);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != this.tpslRequestCode) {
            return;
        }
        if (i2 == -1) {
            if (intent != null) {
                try {
                    Checkout checkout = (Checkout) intent.getSerializableExtra(Constant.ARGUMENT_DATA_CHECKOUT);
                    if (checkout != null) {
                        checkout.getMerchantRequestPayload().getTransaction().getSubType();
                        if (!checkout.getMerchantResponsePayload().getPaymentMethod().getPaymentTransaction().getStatusCode().equalsIgnoreCase("0300")) {
                            this.tpslPaymentsListener.onTpslPaymentFailed("code 300 not received from tpsl");
                        } else if (!"cards".equals(this.paymentMethodTypeFromReact) || !BaseParser.FALSE.equals(this.savedPaymentTypeFromReact) || !BaseParser.TRUE.equals(this.shouldSaveCard)) {
                            this.tpslPaymentsListener.onTpslPaymentSuccess();
                        } else {
                            this.tpslPaymentsListener.onTpslSaveCardPaymentSuccessful(checkout.getMerchantResponsePayload().getPaymentMethod().getInstrumentAliasName(), checkout.getMerchantResponsePayload().getPaymentMethod().getInstrumentToken());
                        }
                    } else {
                        this.tpslPaymentsListener.onTpslPaymentFailed("checkout object was null in onActivityResult");
                    }
                } catch (Exception e2) {
                    this.tpslPaymentsListener.onTpslPaymentFailed(e2.getMessage());
                    this.tpslPaymentsListener.onTpslPaymentFailed("An exception occoured when parsing tpsl RESULT_OK");
                }
            } else {
                this.tpslPaymentsListener.onTpslPaymentFailed("Tpsl data is null onActivityResult");
            }
        } else if (i2 == -2) {
            if (intent.hasExtra(PaymentActivity.RETURN_ERROR_CODE) && intent.hasExtra("error_description")) {
                String stringExtra = intent.getStringExtra(PaymentActivity.RETURN_ERROR_CODE);
                String stringExtra2 = intent.getStringExtra("error_description");
                TpslPaymentsListener tpslPaymentsListener2 = this.tpslPaymentsListener;
                tpslPaymentsListener2.onTpslPaymentFailed(" Code=>" + stringExtra + " Desc=> " + stringExtra2);
            }
        } else if (i2 == 0) {
            this.tpslPaymentsListener.onTpslPaymentFailed("RESULT_CANCELED---->User pressed back button");
        } else if (i2 == -3) {
            this.tpslPaymentsListener.onTpslPaymentFailed("RESULT_BACKPRESSED---->User pressed back button");
        } else if (i2 == -4) {
            this.tpslPaymentsListener.onTpslTransactionPending();
        }
    }
}
