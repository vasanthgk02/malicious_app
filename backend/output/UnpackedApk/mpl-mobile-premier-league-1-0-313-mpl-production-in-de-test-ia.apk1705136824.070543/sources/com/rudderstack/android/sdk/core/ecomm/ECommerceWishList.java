package com.rudderstack.android.sdk.core.ecomm;

import com.google.gson.annotations.SerializedName;

public class ECommerceWishList {
    @SerializedName("wishlist_id")
    public String wishListId;
    @SerializedName("wishlist_name")
    public String wishListName;

    public static class Builder {
        public String wishListId;
        public String wishListName;

        public ECommerceWishList build() {
            return new ECommerceWishList(this.wishListId, this.wishListName);
        }

        public Builder withWishListId(String str) {
            this.wishListId = str;
            return this;
        }

        public Builder withWishListName(String str) {
            this.wishListName = str;
            return this;
        }
    }

    public ECommerceWishList(String str, String str2) {
        this.wishListId = str;
        this.wishListName = str2;
    }

    public String getWishListId() {
        return this.wishListId;
    }

    public String getWishListName() {
        return this.wishListName;
    }

    public void setWishListId(String str) {
        this.wishListId = str;
    }

    public void setWishListName(String str) {
        this.wishListName = str;
    }
}
