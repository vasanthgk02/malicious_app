package com.mpl.payment.juspayhypersdk;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.mpl.payment.PaymentUtils;
import com.mpl.payment.juspayhypersdk.customer.FetchCustomerIdUseCase;
import com.mpl.payment.routing.PaymentResultListener;
import com.mpl.payment.routing.RoutingConstants;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JuspayHyperPaymentsBuilder {
    public String amazonSellerId;
    public String cardExpMonth;
    public String cardExpYear;
    public String cardNumber;
    public String cardSecurityCode;
    public String cardToken;
    public String clientId;
    public Activity currentActivity;
    public String directWalletToken;
    public JSONArray endUrls;
    public String environment;
    public FetchCustomerIdUseCase fetchCustomerIdUseCase;
    public String merchantId;
    public JSONObject moneyInPayload;
    public PaymentResultListener paymentResultListener;
    public JSONObject reactJson;
    public boolean saveToLocker;
    public String savedPaymentType;
    public String upiAppPackageName;

    public JuspayHyperPayment createJuspayHyperPayments() throws Exception {
        JSONObject jSONObject = this.reactJson;
        if (jSONObject == null) {
            throw new Exception("ReactJson Can't be null");
        } else if (this.moneyInPayload == null) {
            throw new Exception("MoneyINPayload Can't be null");
        } else if (this.paymentResultListener != null) {
            Activity activity = this.currentActivity;
            if (activity == null) {
                throw new Exception("currentFragmentActivity can't be null");
            } else if (!(activity instanceof FragmentActivity)) {
                throw new Exception("currentActivity should be an instance of FragmentActivity");
            } else if (this.fetchCustomerIdUseCase != null) {
                String optString = jSONObject.optString(RoutingConstants.ANDROID_REACT_JUSPAY_MERCHANT_ID, "");
                this.merchantId = optString;
                if (!PaymentUtils.isEmptyOrNull(optString)) {
                    String optString2 = this.reactJson.optString(RoutingConstants.ANDROID_REACT_JUSPAY_CLIENT_ID, "");
                    this.clientId = optString2;
                    if (!PaymentUtils.isEmptyOrNull(optString2)) {
                        String optString3 = this.reactJson.optString(RoutingConstants.ANDROID_REACT_JUSPAY_ENVIRONMENT, "");
                        this.environment = optString3;
                        if (!PaymentUtils.isEmptyOrNull(optString3)) {
                            String optString4 = this.reactJson.optString("paymentMode");
                            if (!PaymentUtils.isEmptyOrNull(optString4)) {
                                String optString5 = this.reactJson.optString("paymentMethodType");
                                if (!PaymentUtils.isEmptyOrNull(optString5)) {
                                    try {
                                        JSONArray jSONArray = this.reactJson.getJSONArray("endUrls");
                                        this.endUrls = jSONArray;
                                        if (jSONArray == null || jSONArray.length() == 0) {
                                            throw new Exception("endUrl array can't be null or empty");
                                        }
                                        String optString6 = this.moneyInPayload.optString("orderId");
                                        if (!PaymentUtils.isEmptyOrNull(optString6)) {
                                            String optString7 = this.moneyInPayload.optString(RoutingConstants.KILLBILL_JUSPAY_CLIENT_AUTH_TOKEN);
                                            if (!PaymentUtils.isEmptyOrNull(optString6)) {
                                                if (optString5.equals("cards")) {
                                                    String optString8 = this.reactJson.optString("savedPaymentType");
                                                    this.savedPaymentType = optString8;
                                                    if (PaymentUtils.isEmptyOrNull(optString8)) {
                                                        throw new Exception("savedPayment from react Can't be null or empty");
                                                    } else if (this.savedPaymentType.equalsIgnoreCase(BaseParser.FALSE)) {
                                                        JSONObject optJSONObject = this.reactJson.optJSONObject(RoutingConstants.MI_REACT_NEW_CARD_DETAILS);
                                                        if (optJSONObject != null) {
                                                            this.cardNumber = optJSONObject.optString(RoutingConstants.MI_REACT_CARD_NO);
                                                            this.cardExpMonth = optJSONObject.optString(RoutingConstants.MI_REACT_CARD_MONTH);
                                                            this.cardExpYear = optJSONObject.optString(RoutingConstants.MI_REACT_CARD_YEAR_SHORT);
                                                            this.cardSecurityCode = optJSONObject.optString(RoutingConstants.MI_REACT_CARD_CVV);
                                                            this.saveToLocker = optJSONObject.optBoolean(RoutingConstants.MI_REACT_CARD_SHOULD_SAVE);
                                                        } else {
                                                            throw new Exception("newCardDetails from react either not present or not parsable");
                                                        }
                                                    } else if (this.savedPaymentType.equalsIgnoreCase(BaseParser.TRUE)) {
                                                        JSONObject optJSONObject2 = this.reactJson.optJSONObject("savedPaymentDetails");
                                                        if (optJSONObject2 != null) {
                                                            this.cardToken = optJSONObject2.optString(RoutingConstants.MI_REACT_CARD_TOKEN);
                                                            this.cardSecurityCode = optJSONObject2.optString(RoutingConstants.MI_REACT_CARD_CVV);
                                                        } else {
                                                            throw new Exception("savedPaymentDetails from react either not present or not parsable");
                                                        }
                                                    } else {
                                                        throw new Exception("Saved PaymentType can be either true or false!");
                                                    }
                                                } else if ("wallet".equalsIgnoreCase(optString5)) {
                                                    if ("PAYTM".equalsIgnoreCase(optString4)) {
                                                        String optString9 = this.reactJson.optString("savedPaymentType");
                                                        this.savedPaymentType = optString9;
                                                        if (BaseParser.TRUE.equalsIgnoreCase(optString9)) {
                                                            JSONObject optJSONObject3 = this.reactJson.optJSONObject("savedPaymentDetails");
                                                            if (optJSONObject3 != null) {
                                                                JSONObject optJSONObject4 = optJSONObject3.optJSONObject(RoutingConstants.MI_REACT_ADDITIONAL_DETAILS);
                                                                if (optJSONObject4 != null) {
                                                                    this.directWalletToken = optJSONObject4.optString("token", "");
                                                                } else {
                                                                    throw new Exception("additionalDetails from react either not present or not parsable");
                                                                }
                                                            } else {
                                                                throw new Exception("savedPaymentDetails from react either not present or not parsable");
                                                            }
                                                        } else {
                                                            throw new Exception("Saved PaymentType has to be true when doing a juspay paytm payment");
                                                        }
                                                    } else if (RoutingConstants.PAYMENT_MODE_AMAZONPAY.equalsIgnoreCase(optString4)) {
                                                        String optString10 = this.reactJson.optString("savedPaymentType");
                                                        this.savedPaymentType = optString10;
                                                        if (BaseParser.TRUE.equalsIgnoreCase(optString10)) {
                                                            JSONObject optJSONObject5 = this.reactJson.optJSONObject("savedPaymentDetails");
                                                            if (optJSONObject5 != null) {
                                                                JSONObject optJSONObject6 = optJSONObject5.optJSONObject(RoutingConstants.MI_REACT_ADDITIONAL_DETAILS);
                                                                if (optJSONObject6 != null) {
                                                                    String optString11 = optJSONObject6.optString("token", "");
                                                                    this.directWalletToken = optString11;
                                                                    if (!PaymentUtils.isEmptyOrNull(optString11)) {
                                                                        String optString12 = this.moneyInPayload.optString(RoutingConstants.KILLBILL_JUSPAY_AMAZONPAY_AMAZON_SELLER_ID);
                                                                        this.amazonSellerId = optString12;
                                                                        if (PaymentUtils.isEmptyOrNull(optString12)) {
                                                                            throw new Exception("AmazonsellerId empty or missing in moneyInPayload");
                                                                        }
                                                                    } else {
                                                                        throw new Exception("token can't be null or empty in amazon pay non tokenised payment");
                                                                    }
                                                                } else {
                                                                    throw new Exception("additionalDetails from react either not present or not parsable");
                                                                }
                                                            } else {
                                                                throw new Exception("savedPaymentDetails from react either not present or not parsable");
                                                            }
                                                        } else if (BaseParser.FALSE.equalsIgnoreCase(this.savedPaymentType)) {
                                                            String optString13 = this.moneyInPayload.optString(RoutingConstants.KILLBILL_JUSPAY_AMAZONPAY_AMAZON_SELLER_ID);
                                                            this.amazonSellerId = optString13;
                                                            if (PaymentUtils.isEmptyOrNull(optString13)) {
                                                                throw new Exception("AmazonsellerId empty or missing in moneyInPayload");
                                                            }
                                                        } else {
                                                            throw new Exception("Saved PaymentType has to be true or false when doing an amazonpay payment");
                                                        }
                                                    }
                                                } else if (RoutingConstants.PAYMENT_METHOD_TYPE_BNPL.equalsIgnoreCase(optString5)) {
                                                    if (RoutingConstants.PAYMENT_MODE_TYPE_LAZYPAY.equalsIgnoreCase(optString4)) {
                                                        String optString14 = this.reactJson.optString("savedPaymentType");
                                                        this.savedPaymentType = optString14;
                                                        if (BaseParser.TRUE.equalsIgnoreCase(optString14)) {
                                                            JSONObject optJSONObject7 = this.reactJson.optJSONObject("savedPaymentDetails");
                                                            if (optJSONObject7 != null) {
                                                                JSONObject optJSONObject8 = optJSONObject7.optJSONObject(RoutingConstants.MI_REACT_ADDITIONAL_DETAILS);
                                                                if (optJSONObject8 != null) {
                                                                    this.directWalletToken = optJSONObject8.optString("token", "");
                                                                } else {
                                                                    throw new Exception("additionalDetails from react either not present or not parsable");
                                                                }
                                                            } else {
                                                                throw new Exception("savedPaymentDetails from react either not present or not parsable");
                                                            }
                                                        } else {
                                                            throw new Exception("Saved PaymentType has to be true when doing a juspay lazypay payment");
                                                        }
                                                    }
                                                } else if ("upi".equalsIgnoreCase(optString5)) {
                                                    String optString15 = this.reactJson.optString(RoutingConstants.MI_REACT_UPI_APP_PACKAGE_NAME, "");
                                                    if (!optString15.isEmpty()) {
                                                        this.upiAppPackageName = optString15;
                                                    }
                                                }
                                                JuspayHyperPayment juspayHyperPayment = new JuspayHyperPayment(this.reactJson, this.moneyInPayload, this.paymentResultListener, optString4, optString5, optString6, this.endUrls, optString7, this.cardNumber, this.cardExpMonth, this.cardExpYear, this.cardSecurityCode, this.cardToken, this.saveToLocker, this.savedPaymentType, this.directWalletToken, this.amazonSellerId, (FragmentActivity) this.currentActivity, this.merchantId, this.clientId, this.environment, this.upiAppPackageName);
                                                return juspayHyperPayment;
                                            }
                                            throw new Exception("clientAuthToken from moneyIN Can't be null or empty");
                                        }
                                        throw new Exception("orderId from moneyIN Can't be null");
                                    } catch (JSONException unused) {
                                        throw new Exception("Exception when parsing endUrls from react");
                                    }
                                } else {
                                    throw new Exception("paymentMethodType from react Can't be null");
                                }
                            } else {
                                throw new Exception("paymentMode from react Can't be null or empty");
                            }
                        } else {
                            throw new Exception("environment can't be null or empty");
                        }
                    } else {
                        throw new Exception("clientId can't be null or empty");
                    }
                } else {
                    throw new Exception("merchantId can't be null or empty");
                }
            } else {
                throw new Exception("fetchCustomerIdUseCase can't be null");
            }
        } else {
            throw new Exception("paymentResultListener Can't be null");
        }
    }

    public JuspayHyperPaymentsBuilder setCurrentActivity(Activity activity) {
        this.currentActivity = activity;
        return this;
    }

    public JuspayHyperPaymentsBuilder setFetchCustomerIdUseCase(FetchCustomerIdUseCase fetchCustomerIdUseCase2) {
        this.fetchCustomerIdUseCase = fetchCustomerIdUseCase2;
        return this;
    }

    public JuspayHyperPaymentsBuilder setMoneyInPayload(JSONObject jSONObject) {
        this.moneyInPayload = jSONObject;
        return this;
    }

    public JuspayHyperPaymentsBuilder setPaymentResultListener(PaymentResultListener paymentResultListener2) {
        this.paymentResultListener = paymentResultListener2;
        return this;
    }

    public JuspayHyperPaymentsBuilder setReactJson(JSONObject jSONObject) {
        this.reactJson = jSONObject;
        return this;
    }
}
