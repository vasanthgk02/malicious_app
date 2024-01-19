package com.rudderstack.android.sdk.core.ecomm;

import com.google.gson.annotations.SerializedName;

public class ECommerceCoupon {
    @SerializedName("cart_id")
    public String cartId;
    @SerializedName("coupon_id")
    public String couponId;
    @SerializedName("coupon_name")
    public String couponName;
    @SerializedName("discount")
    public float discount;
    @SerializedName("order_id")
    public String orderId;
    @SerializedName("reason")
    public String reason;

    public static class Builder {
        public String cartId;
        public String couponId;
        public String couponName;
        public float discount;
        public String orderId;
        public String reason;

        public ECommerceCoupon build() {
            ECommerceCoupon eCommerceCoupon = new ECommerceCoupon(this.cartId, this.orderId, this.couponId, this.couponName, this.discount, this.reason);
            return eCommerceCoupon;
        }

        public Builder withCartId(String str) {
            this.cartId = str;
            return this;
        }

        public Builder withCouponId(String str) {
            this.couponId = str;
            return this;
        }

        public Builder withCouponName(String str) {
            this.couponName = str;
            return this;
        }

        public Builder withDiscount(float f2) {
            this.discount = f2;
            return this;
        }

        public Builder withOrderId(String str) {
            this.orderId = str;
            return this;
        }

        public Builder withReason(String str) {
            this.reason = str;
            return this;
        }
    }

    public ECommerceCoupon(String str, String str2, String str3) {
        this.cartId = str;
        this.orderId = str2;
        this.couponId = str3;
    }

    public String getCartId() {
        return this.cartId;
    }

    public String getCouponId() {
        return this.couponId;
    }

    public String getCouponName() {
        return this.couponName;
    }

    public float getDiscount() {
        return this.discount;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getReason() {
        return this.reason;
    }

    public void setCartId(String str) {
        this.cartId = str;
    }

    public void setCouponId(String str) {
        this.couponId = str;
    }

    public void setCouponName(String str) {
        this.couponName = str;
    }

    public void setDiscount(float f2) {
        this.discount = f2;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public ECommerceCoupon(String str, String str2, String str3, String str4, float f2, String str5) {
        this.cartId = str;
        this.orderId = str2;
        this.couponId = str3;
        this.couponName = str4;
        this.discount = f2;
        this.reason = str5;
    }
}
