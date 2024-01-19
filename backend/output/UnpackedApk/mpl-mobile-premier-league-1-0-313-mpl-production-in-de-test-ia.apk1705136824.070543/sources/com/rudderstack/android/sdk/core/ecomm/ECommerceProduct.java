package com.rudderstack.android.sdk.core.ecomm;

import com.google.gson.annotations.SerializedName;

public class ECommerceProduct {
    @SerializedName("brand")
    public String brand;
    @SerializedName("category")
    public String category;
    @SerializedName("coupon")
    public String coupon;
    @SerializedName("currency")
    public String currency;
    @SerializedName("image_url")
    public String imageUrl;
    @SerializedName("name")
    public String name;
    @SerializedName("position")
    public int position;
    @SerializedName("price")
    public float price;
    @SerializedName("product_id")
    public String productId;
    @SerializedName("quantity")
    public float quantity;
    @SerializedName("sku")
    public String sku;
    @SerializedName("url")
    public String url;
    @SerializedName("variant")
    public String variant;

    public static class Builder {
        public String brand;
        public String category;
        public String coupon;
        public String currency;
        public String imageUrl;
        public String name;
        public int position;
        public float price;
        public String productId;
        public float quantity;
        public String sku;
        public String url;
        public String variant;

        public ECommerceProduct build() {
            ECommerceProduct eCommerceProduct = new ECommerceProduct(this.productId, this.sku, this.category, this.name, this.brand, this.variant, this.price, this.currency, this.quantity, this.coupon, this.position, this.url, this.imageUrl);
            return eCommerceProduct;
        }

        public Builder withBrand(String str) {
            this.brand = str;
            return this;
        }

        public Builder withCategory(String str) {
            this.category = str;
            return this;
        }

        public Builder withCoupon(String str) {
            this.coupon = str;
            return this;
        }

        public Builder withCurrency(String str) {
            this.currency = str;
            return this;
        }

        public Builder withImageUrl(String str) {
            this.imageUrl = str;
            return this;
        }

        public Builder withName(String str) {
            this.name = str;
            return this;
        }

        public Builder withPosition(int i) {
            this.position = i;
            return this;
        }

        public Builder withPrice(float f2) {
            this.price = f2;
            return this;
        }

        public Builder withProductId(String str) {
            this.productId = str;
            return this;
        }

        public Builder withQuantity(float f2) {
            this.quantity = f2;
            return this;
        }

        public Builder withSku(String str) {
            this.sku = str;
            return this;
        }

        public Builder withUrl(String str) {
            this.url = str;
            return this;
        }

        public Builder withVariant(String str) {
            this.variant = str;
            return this;
        }
    }

    public ECommerceProduct(String str, String str2, String str3, String str4, String str5, String str6, float f2, String str7, float f3, String str8, int i, String str9, String str10) {
        this.productId = str;
        this.sku = str2;
        this.category = str3;
        this.name = str4;
        this.brand = str5;
        this.variant = str6;
        this.price = f2;
        this.currency = str7;
        this.quantity = f3;
        this.coupon = str8;
        this.position = i;
        this.url = str9;
        this.imageUrl = str10;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getCategory() {
        return this.category;
    }

    public String getCoupon() {
        return this.coupon;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public float getPrice() {
        return this.price;
    }

    public String getProductId() {
        return this.productId;
    }

    public float getQuantity() {
        return this.quantity;
    }

    public String getSku() {
        return this.sku;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVariant() {
        return this.variant;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setCoupon(String str) {
        this.coupon = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public void setPrice(float f2) {
        this.price = f2;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setQuantity(float f2) {
        this.quantity = f2;
    }

    public void setSku(String str) {
        this.sku = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVariant(String str) {
        this.variant = str;
    }
}
