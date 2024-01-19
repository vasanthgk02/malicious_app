package com.rudderstack.android.sdk.core.ecomm;

import com.google.gson.annotations.SerializedName;

public class ECommerceCheckout {
    @SerializedName("checkout_id")
    public String checkoutId;
    @SerializedName("order_id")
    public String orderId;
    @SerializedName("payment_method")
    public String paymentMethod;
    @SerializedName("shipping_method")
    public String shippingMethod;
    @SerializedName("step")
    public int step;

    public static class Builder {
        public String checkoutId;
        public String orderId;
        public String paymentMethod;
        public String shippingMethod;
        public int step;

        public ECommerceCheckout build() {
            ECommerceCheckout eCommerceCheckout = new ECommerceCheckout(this.checkoutId, this.orderId, this.step, this.shippingMethod, this.paymentMethod);
            return eCommerceCheckout;
        }

        public Builder withCheckoutId(String str) {
            this.checkoutId = str;
            return this;
        }

        public Builder withOrderId(String str) {
            this.orderId = str;
            return this;
        }

        public Builder withPaymentMethod(String str) {
            this.paymentMethod = str;
            return this;
        }

        public Builder withShippingMethod(String str) {
            this.shippingMethod = str;
            return this;
        }

        public Builder withStep(int i) {
            this.step = i;
            return this;
        }
    }

    public ECommerceCheckout(String str, String str2) {
        this.checkoutId = str;
        this.orderId = str2;
    }

    public String getCheckoutId() {
        return this.checkoutId;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public String getShippingMethod() {
        return this.shippingMethod;
    }

    public int getStep() {
        return this.step;
    }

    public void setCheckoutId(String str) {
        this.checkoutId = str;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setPaymentMethod(String str) {
        this.paymentMethod = str;
    }

    public void setShippingMethod(String str) {
        this.shippingMethod = str;
    }

    public void setStep(int i) {
        this.step = i;
    }

    public ECommerceCheckout(String str, String str2, int i, String str3, String str4) {
        this.checkoutId = str;
        this.orderId = str2;
        this.step = i;
        this.shippingMethod = str3;
        this.paymentMethod = str4;
    }
}
