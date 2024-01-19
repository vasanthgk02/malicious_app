package com.rudderstack.android.sdk.core.ecomm;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Arrays;

public class ECommerceOrder {
    @SerializedName("affiliation")
    public String affiliation;
    @SerializedName("coupon")
    public String coupon;
    @SerializedName("currency")
    public String currency;
    @SerializedName("discount")
    public float discount;
    @SerializedName("order_id")
    public String orderId;
    @SerializedName("products")
    public ArrayList<ECommerceProduct> products;
    @SerializedName("revenue")
    public float revenue;
    @SerializedName("shipping")
    public float shippingCost;
    @SerializedName("tax")
    public float tax;
    @SerializedName("total")
    public float total;
    @SerializedName("value")
    public float value;

    public static class Builder {
        public String affiliation;
        public String coupon;
        public String currency;
        public float discount;
        public String orderId;
        public ArrayList<ECommerceProduct> products;
        public float revenue;
        public float shippingCost;
        public float tax;
        public float total;
        public float value;

        public ECommerceOrder build() {
            ECommerceOrder eCommerceOrder = new ECommerceOrder(this.orderId, this.affiliation, this.total, this.value, this.revenue, this.shippingCost, this.tax, this.discount, this.coupon, this.currency, this.products);
            return eCommerceOrder;
        }

        public Builder withAffiliation(String str) {
            this.affiliation = str;
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

        public Builder withDiscount(float f2) {
            this.discount = f2;
            return this;
        }

        public Builder withOrderId(String str) {
            this.orderId = str;
            return this;
        }

        public Builder withProduct(ECommerceProduct eCommerceProduct) {
            if (this.products == null) {
                this.products = new ArrayList<>();
            }
            this.products.add(eCommerceProduct);
            return this;
        }

        public Builder withProducts(ArrayList<ECommerceProduct> arrayList) {
            if (this.products == null) {
                this.products = new ArrayList<>();
            }
            this.products.addAll(arrayList);
            return this;
        }

        public Builder withRevenue(float f2) {
            this.revenue = f2;
            return this;
        }

        public Builder withShippingCost(float f2) {
            this.shippingCost = f2;
            return this;
        }

        public Builder withTax(float f2) {
            this.tax = f2;
            return this;
        }

        public Builder withTotal(float f2) {
            this.total = f2;
            return this;
        }

        public Builder withValue(float f2) {
            this.value = f2;
            return this;
        }

        public Builder withProducts(ECommerceProduct... eCommerceProductArr) {
            if (this.products == null) {
                this.products = new ArrayList<>();
            }
            this.products.addAll(Arrays.asList(eCommerceProductArr));
            return this;
        }
    }

    public ECommerceOrder(String str) {
        this.orderId = str;
    }

    public String getAffiliation() {
        return this.affiliation;
    }

    public String getCoupon() {
        return this.coupon;
    }

    public String getCurrency() {
        return this.currency;
    }

    public float getDiscount() {
        return this.discount;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public ArrayList<ECommerceProduct> getProducts() {
        return this.products;
    }

    public float getRevenue() {
        return this.revenue;
    }

    public float getShippingCost() {
        return this.shippingCost;
    }

    public float getTax() {
        return this.tax;
    }

    public float getTotal() {
        return this.total;
    }

    public float getValue() {
        return this.value;
    }

    public void setAffiliation(String str) {
        this.affiliation = str;
    }

    public void setCoupon(String str) {
        this.coupon = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setDiscount(float f2) {
        this.discount = f2;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setProduct(ECommerceProduct eCommerceProduct) {
        this.products.add(eCommerceProduct);
    }

    public void setProducts(ArrayList<ECommerceProduct> arrayList) {
        this.products = arrayList;
    }

    public void setRevenue(float f2) {
        this.revenue = f2;
    }

    public void setShippingCost(float f2) {
        this.shippingCost = f2;
    }

    public void setTax(float f2) {
        this.tax = f2;
    }

    public void setTotal(float f2) {
        this.total = f2;
    }

    public void setValue(float f2) {
        this.value = f2;
    }

    public ECommerceOrder(String str, String str2, float f2, float f3, float f4, float f5, float f6, float f7, String str3, String str4) {
        this.orderId = str;
        this.affiliation = str2;
        this.total = f2;
        this.value = f3;
        this.revenue = f4;
        this.shippingCost = f5;
        this.tax = f6;
        this.discount = f7;
        this.coupon = str3;
        this.currency = str4;
        this.products = new ArrayList<>();
    }

    public ECommerceOrder(String str, String str2, float f2, float f3, float f4, float f5, float f6, float f7, String str3, String str4, ArrayList<ECommerceProduct> arrayList) {
        this.orderId = str;
        this.affiliation = str2;
        this.total = f2;
        this.value = f3;
        this.revenue = f4;
        this.shippingCost = f5;
        this.tax = f6;
        this.discount = f7;
        this.coupon = str3;
        this.currency = str4;
        this.products = arrayList;
    }
}
