package com.mpl.payment.upoint;

public class UpointPaymentBuilder {
    public String clientKey;
    public String paymentType;
    public String phoneNumber;
    public String token;
    public UpointResultListener upointResultListener;

    public UpointPayment build() throws Exception {
        String str = this.paymentType;
        if (str == null || str.isEmpty()) {
            throw new Exception("payment type can't be null or empty");
        }
        String str2 = this.phoneNumber;
        if (str2 == null || str2.isEmpty()) {
            throw new Exception("PhoneNumber can't be null or empty");
        }
        String str3 = this.clientKey;
        if (str3 == null || str3.isEmpty()) {
            throw new Exception("clientkey can't be null or empty");
        }
        String str4 = this.token;
        if (str4 == null || str4.isEmpty()) {
            throw new Exception("token can't be null or empty");
        }
        UpointResultListener upointResultListener2 = this.upointResultListener;
        if (upointResultListener2 != null) {
            UpointPayment upointPayment = new UpointPayment(this.phoneNumber, this.clientKey, this.token, this.paymentType, upointResultListener2);
            return upointPayment;
        }
        throw new Exception("upointResultListener can't be null");
    }

    public UpointPayment createUpointPayment() {
        UpointPayment upointPayment = new UpointPayment(this.phoneNumber, this.clientKey, this.token, this.paymentType, this.upointResultListener);
        return upointPayment;
    }

    public UpointPaymentBuilder setClientKey(String str) {
        this.clientKey = str;
        return this;
    }

    public UpointPaymentBuilder setPaymentType(String str) {
        this.paymentType = str;
        return this;
    }

    public UpointPaymentBuilder setPhoneNumber(String str) {
        this.phoneNumber = str;
        return this;
    }

    public UpointPaymentBuilder setToken(String str) {
        this.token = str;
        return this;
    }

    public UpointPaymentBuilder setUpointResultListener(UpointResultListener upointResultListener2) {
        this.upointResultListener = upointResultListener2;
        return this;
    }
}
