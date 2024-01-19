package com.paypal.android.sdk.onetouch.core.config;

import java.util.ArrayList;

public class OtcConfiguration {
    public final ArrayList<BillingAgreementRecipe> mBillingAgreementRecipesInDecreasingPriorityOrder = new ArrayList<>();
    public final ArrayList<CheckoutRecipe> mCheckoutRecipesInDecreasingPriorityOrder = new ArrayList<>();
    public final ArrayList<OAuth2Recipe> mOauth2RecipesInDecreasingPriorityOrder = new ArrayList<>();
}
