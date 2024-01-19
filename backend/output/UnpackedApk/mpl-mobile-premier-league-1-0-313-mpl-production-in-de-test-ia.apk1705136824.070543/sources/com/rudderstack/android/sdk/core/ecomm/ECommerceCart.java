package com.rudderstack.android.sdk.core.ecomm;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class ECommerceCart {
    @SerializedName("cart_id")
    public String cartId;
    @SerializedName("products")
    public ArrayList<ECommerceProduct> products;

    public static class Builder {
        public String cartId;
        public ArrayList<ECommerceProduct> products;

        public ECommerceCart build() {
            return new ECommerceCart(this.cartId, this.products);
        }

        public Builder withCartId(String str) {
            this.cartId = str;
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
    }

    public ECommerceCart(String str, ArrayList<ECommerceProduct> arrayList) {
        this.cartId = str;
        this.products = arrayList;
    }

    public String getCartId() {
        return this.cartId;
    }

    public ArrayList<ECommerceProduct> getProducts() {
        return this.products;
    }

    public void setCartId(String str) {
        this.cartId = str;
    }

    public void setProducts(ArrayList<ECommerceProduct> arrayList) {
        this.products = arrayList;
    }

    public ECommerceCart(String str) {
        this.cartId = str;
    }
}
