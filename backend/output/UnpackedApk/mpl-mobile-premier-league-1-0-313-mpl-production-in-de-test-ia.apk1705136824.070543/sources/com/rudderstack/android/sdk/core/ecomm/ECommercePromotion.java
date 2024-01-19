package com.rudderstack.android.sdk.core.ecomm;

import com.google.gson.annotations.SerializedName;

public class ECommercePromotion {
    @SerializedName("creative")
    public String creative;
    @SerializedName("name")
    public String name;
    @SerializedName("position")
    public String position;
    @SerializedName("promotion_id")
    public String promotionId;

    public static class Builder {
        public String creative;
        public String name;
        public String position;
        public String promotionId;

        public ECommercePromotion build() {
            return new ECommercePromotion(this.promotionId, this.creative, this.name, this.position);
        }

        public Builder withCreative(String str) {
            this.creative = str;
            return this;
        }

        public Builder withName(String str) {
            this.name = str;
            return this;
        }

        public Builder withPosition(String str) {
            this.position = str;
            return this;
        }

        public Builder withPromotionId(String str) {
            this.promotionId = str;
            return this;
        }
    }

    public ECommercePromotion(String str, String str2, String str3, String str4) {
        this.promotionId = str;
        this.creative = str2;
        this.name = str3;
        this.position = str4;
    }

    public String getCreative() {
        return this.creative;
    }

    public String getName() {
        return this.name;
    }

    public String getPosition() {
        return this.position;
    }

    public String getPromotionId() {
        return this.promotionId;
    }

    public void setCreative(String str) {
        this.creative = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public void setPromotionId(String str) {
        this.promotionId = str;
    }
}
