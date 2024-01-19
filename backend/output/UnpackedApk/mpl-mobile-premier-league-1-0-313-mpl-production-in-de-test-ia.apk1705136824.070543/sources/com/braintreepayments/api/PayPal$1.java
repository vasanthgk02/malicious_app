package com.braintreepayments.api;

import com.braintreepayments.api.interfaces.HttpResponseCallback;
import com.braintreepayments.api.interfaces.PayPalApprovalHandler;
import com.braintreepayments.api.interfaces.QueuedCallback;
import com.braintreepayments.api.models.PayPalRequest;

public final class PayPal$1 implements HttpResponseCallback {
    public final /* synthetic */ BraintreeFragment val$fragment;
    public final /* synthetic */ PayPalApprovalHandler val$handler;
    public final /* synthetic */ boolean val$isBillingAgreement;
    public final /* synthetic */ PayPalRequest val$paypalRequest;

    public PayPal$1(BraintreeFragment braintreeFragment, PayPalRequest payPalRequest, boolean z, PayPalApprovalHandler payPalApprovalHandler) {
        this.val$fragment = braintreeFragment;
        this.val$paypalRequest = payPalRequest;
        this.val$isBillingAgreement = z;
        this.val$handler = payPalApprovalHandler;
    }

    public void failure(Exception exc) {
        BraintreeFragment braintreeFragment = this.val$fragment;
        braintreeFragment.postOrQueueCallback(new QueuedCallback(exc) {
            public void run() {
                BraintreeFragment.this.mErrorListener.onError(exc);
            }

            public boolean shouldRun() {
                return BraintreeFragment.this.mErrorListener != null;
            }
        });
    }

    /* JADX WARNING: type inference failed for: r1v13, types: [com.paypal.android.sdk.onetouch.core.CheckoutRequest] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void success(java.lang.String r11) {
        /*
            r10 = this;
            com.braintreepayments.api.models.PayPalPaymentResource r11 = com.braintreepayments.api.models.PayPalPaymentResource.fromJson(r11)     // Catch:{ JSONException -> 0x023a }
            java.lang.String r11 = r11.mRedirectUrl
            android.net.Uri r11 = android.net.Uri.parse(r11)
            android.net.Uri$Builder r11 = r11.buildUpon()
            com.braintreepayments.api.models.PayPalRequest r0 = r10.val$paypalRequest
            java.lang.String r0 = r0.mUserAction
            java.lang.String r1 = "useraction"
            android.net.Uri$Builder r11 = r11.appendQueryParameter(r1, r0)
            java.lang.String r11 = r11.toString()
            boolean r0 = r10.val$isBillingAgreement
            if (r0 == 0) goto L_0x0046
            com.braintreepayments.api.BraintreeFragment r0 = r10.val$fragment
            com.paypal.android.sdk.onetouch.core.BillingAgreementRequest r1 = new com.paypal.android.sdk.onetouch.core.BillingAgreementRequest
            r1.<init>()
            co.hyperverge.hypersnapsdk.c.k.populateRequestData(r0, r1)
            r1.mApprovalUrl = r11
            java.lang.String r2 = "token"
            r1.mTokenQueryParamKey = r2
            java.lang.String r2 = "ba_token"
            r1.mTokenQueryParamKey = r2
            if (r11 == 0) goto L_0x004c
            android.net.Uri r11 = android.net.Uri.parse(r11)
            java.lang.String r11 = r11.getQueryParameter(r2)
            if (r11 == 0) goto L_0x004c
            android.content.Context r0 = r0.mContext
            r1.pairingId(r0, r11)
            goto L_0x004c
        L_0x0046:
            com.braintreepayments.api.BraintreeFragment r0 = r10.val$fragment
            com.paypal.android.sdk.onetouch.core.CheckoutRequest r1 = co.hyperverge.hypersnapsdk.c.k.getCheckoutRequest(r0, r11)
        L_0x004c:
            com.braintreepayments.api.BraintreeFragment r11 = r10.val$fragment
            com.braintreepayments.api.interfaces.PayPalApprovalHandler r0 = r10.val$handler
            android.content.Context r2 = r11.mContext
            android.os.Parcel r3 = android.os.Parcel.obtain()
            r4 = 0
            r1.writeToParcel(r3, r4)
            android.content.Context r2 = r2.getApplicationContext()
            java.lang.String r5 = "BraintreeApi"
            android.content.SharedPreferences r2 = r2.getSharedPreferences(r5, r4)
            android.content.SharedPreferences$Editor r2 = r2.edit()
            byte[] r3 = r3.marshall()
            java.lang.String r3 = android.util.Base64.encodeToString(r3, r4)
            java.lang.String r5 = "com.braintreepayments.api.PayPal.REQUEST_KEY"
            android.content.SharedPreferences$Editor r2 = r2.putString(r5, r3)
            java.lang.Class r3 = r1.getClass()
            java.lang.String r3 = r3.getSimpleName()
            java.lang.String r5 = "com.braintreepayments.api.PayPal.REQUEST_TYPE_KEY"
            android.content.SharedPreferences$Editor r2 = r2.putString(r5, r3)
            r2.apply()
            if (r0 != 0) goto L_0x008e
            com.braintreepayments.api.PayPal$4 r0 = new com.braintreepayments.api.PayPal$4
            r0.<init>(r11)
        L_0x008e:
            com.braintreepayments.api.PayPal$4 r0 = (com.braintreepayments.api.PayPal$4) r0
            com.braintreepayments.api.BraintreeFragment r11 = r0.val$fragment
            boolean r11 = r11.isAdded()
            if (r11 != 0) goto L_0x009a
            goto L_0x0239
        L_0x009a:
            com.braintreepayments.api.BraintreeFragment r11 = r0.val$fragment
            android.content.Context r11 = r11.mContext
            com.paypal.android.sdk.onetouch.core.PayPalOneTouchCore.initService(r11)
            com.paypal.android.sdk.onetouch.core.PayPalOneTouchCore.isWalletAppInstalled(r11)
            com.paypal.android.sdk.onetouch.core.config.ConfigManager r2 = com.paypal.android.sdk.onetouch.core.PayPalOneTouchCore.sConfigManager
            com.paypal.android.sdk.onetouch.core.config.OtcConfiguration r2 = r2.getConfig()
            com.paypal.android.sdk.onetouch.core.config.Recipe r2 = r1.getRecipeToExecute(r11, r2)
            r3 = 0
            if (r2 != 0) goto L_0x00b8
            com.paypal.android.sdk.onetouch.core.sdk.PendingRequest r11 = new com.paypal.android.sdk.onetouch.core.sdk.PendingRequest
            r11.<init>(r4, r3, r3, r3)
            goto L_0x01ba
        L_0x00b8:
            com.paypal.android.sdk.onetouch.core.enums.RequestTarget r5 = com.paypal.android.sdk.onetouch.core.enums.RequestTarget.wallet
            com.paypal.android.sdk.onetouch.core.enums.RequestTarget r6 = r2.mTarget
            r7 = 1
            if (r5 != r6) goto L_0x0151
            com.paypal.android.sdk.onetouch.core.fpti.TrackingPoint r4 = com.paypal.android.sdk.onetouch.core.fpti.TrackingPoint.SwitchToWallet
            com.paypal.android.sdk.onetouch.core.enums.Protocol r5 = r2.mProtocol
            r1.trackFpti(r11, r4, r5)
            com.paypal.android.sdk.onetouch.core.sdk.PendingRequest r11 = new com.paypal.android.sdk.onetouch.core.sdk.PendingRequest
            com.paypal.android.sdk.onetouch.core.enums.RequestTarget r4 = com.paypal.android.sdk.onetouch.core.enums.RequestTarget.wallet
            java.lang.String r5 = r1.mClientMetadataId
            com.paypal.android.sdk.onetouch.core.base.ContextInspector r6 = com.paypal.android.sdk.onetouch.core.PayPalOneTouchCore.sContextInspector
            java.lang.String r8 = r2.mTargetIntentAction
            android.content.Intent r9 = new android.content.Intent
            r9.<init>(r8)
            java.lang.String r8 = "com.paypal.android.p2pmobile"
            android.content.Intent r8 = r9.setPackage(r8)
            com.paypal.android.sdk.onetouch.core.enums.Protocol r2 = r2.mProtocol
            java.lang.String r2 = r2.getVersion()
            java.lang.String r9 = "version"
            android.content.Intent r2 = r8.putExtra(r9, r2)
            android.content.Context r8 = r6.mContext
            java.lang.String r8 = com.google.android.material.resources.TextAppearanceConfig.getInstallationGUID(r8)
            java.lang.String r9 = "app_guid"
            android.content.Intent r2 = r2.putExtra(r9, r8)
            java.lang.String r8 = r1.mClientMetadataId
            java.lang.String r9 = "client_metadata_id"
            android.content.Intent r2 = r2.putExtra(r9, r8)
            java.lang.String r8 = r1.mClientId
            java.lang.String r9 = "client_id"
            android.content.Intent r2 = r2.putExtra(r9, r8)
            android.content.Context r6 = r6.mContext
            java.lang.String r6 = com.google.android.material.resources.TextAppearanceConfig.getApplicationInfoName(r6)
            java.lang.String r8 = "app_name"
            android.content.Intent r2 = r2.putExtra(r8, r6)
            java.lang.String r6 = r1.mEnvironment
            java.lang.String r8 = "environment"
            android.content.Intent r2 = r2.putExtra(r8, r6)
            java.lang.String r6 = r1.mEnvironment
            java.lang.String r8 = "live"
            boolean r8 = r6.equals(r8)
            if (r8 == 0) goto L_0x0124
            java.lang.String r6 = "https://api-m.paypal.com/v1/"
            goto L_0x0138
        L_0x0124:
            java.lang.String r8 = "sandbox"
            boolean r8 = r6.equals(r8)
            if (r8 == 0) goto L_0x012f
            java.lang.String r6 = "https://api-m.sandbox.paypal.com/v1/"
            goto L_0x0138
        L_0x012f:
            java.lang.String r8 = "mock"
            boolean r8 = r6.equals(r8)
            if (r8 == 0) goto L_0x0138
            r6 = r3
        L_0x0138:
            java.lang.String r8 = "environment_url"
            android.content.Intent r2 = r2.putExtra(r8, r6)
            java.lang.String r6 = r1.mApprovalUrl
            java.lang.String r8 = "response_type"
            java.lang.String r9 = "web"
            android.content.Intent r8 = r2.putExtra(r8, r9)
            java.lang.String r9 = "webURL"
            r8.putExtra(r9, r6)
            r11.<init>(r7, r4, r5, r2)
            goto L_0x01ba
        L_0x0151:
            com.paypal.android.sdk.onetouch.core.base.ContextInspector r11 = com.paypal.android.sdk.onetouch.core.PayPalOneTouchCore.sContextInspector
            com.paypal.android.sdk.onetouch.core.config.ConfigManager r2 = com.paypal.android.sdk.onetouch.core.PayPalOneTouchCore.sConfigManager
            com.paypal.android.sdk.onetouch.core.config.OtcConfiguration r2 = r2.getConfig()
            java.lang.String r5 = r1.mApprovalUrl
            java.util.ArrayList<com.paypal.android.sdk.onetouch.core.config.CheckoutRecipe> r2 = r2.mCheckoutRecipesInDecreasingPriorityOrder
            java.util.Iterator r2 = r2.iterator()
        L_0x0161:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x0174
            java.lang.Object r6 = r2.next()
            com.paypal.android.sdk.onetouch.core.config.CheckoutRecipe r6 = (com.paypal.android.sdk.onetouch.core.config.CheckoutRecipe) r6
            com.paypal.android.sdk.onetouch.core.enums.RequestTarget r8 = r6.mTarget
            com.paypal.android.sdk.onetouch.core.enums.RequestTarget r9 = com.paypal.android.sdk.onetouch.core.enums.RequestTarget.browser
            if (r8 != r9) goto L_0x0161
            goto L_0x0175
        L_0x0174:
            r6 = r3
        L_0x0175:
            java.util.List r2 = r6.getTargetPackagesInReversePriorityOrder()
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x017f:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L_0x01a3
            java.lang.Object r8 = r2.next()
            java.lang.String r8 = (java.lang.String) r8
            android.content.Context r9 = r11.mContext
            boolean r9 = com.paypal.android.sdk.onetouch.core.config.Recipe.isValidBrowserTarget(r9, r5, r8)
            if (r9 == 0) goto L_0x017f
            android.content.Context r2 = r11.mContext
            com.paypal.android.sdk.onetouch.core.fpti.TrackingPoint r9 = com.paypal.android.sdk.onetouch.core.fpti.TrackingPoint.SwitchToBrowser
            com.paypal.android.sdk.onetouch.core.enums.Protocol r6 = r6.mProtocol
            r1.trackFpti(r2, r9, r6)
            android.content.Context r11 = r11.mContext
            android.content.Intent r11 = com.paypal.android.sdk.onetouch.core.config.Recipe.getBrowserIntent(r11, r5, r8)
            goto L_0x01a4
        L_0x01a3:
            r11 = r3
        L_0x01a4:
            if (r11 == 0) goto L_0x01b1
            com.paypal.android.sdk.onetouch.core.sdk.PendingRequest r2 = new com.paypal.android.sdk.onetouch.core.sdk.PendingRequest
            com.paypal.android.sdk.onetouch.core.enums.RequestTarget r4 = com.paypal.android.sdk.onetouch.core.enums.RequestTarget.browser
            java.lang.String r5 = r1.mClientMetadataId
            r2.<init>(r7, r4, r5, r11)
            r11 = r2
            goto L_0x01ba
        L_0x01b1:
            com.paypal.android.sdk.onetouch.core.sdk.PendingRequest r11 = new com.paypal.android.sdk.onetouch.core.sdk.PendingRequest
            com.paypal.android.sdk.onetouch.core.enums.RequestTarget r2 = com.paypal.android.sdk.onetouch.core.enums.RequestTarget.browser
            java.lang.String r5 = r1.mClientMetadataId
            r11.<init>(r4, r2, r5, r3)
        L_0x01ba:
            boolean r1 = r1 instanceof com.paypal.android.sdk.onetouch.core.BillingAgreementRequest
            if (r1 == 0) goto L_0x01c1
            java.lang.String r1 = "paypal.billing-agreement"
            goto L_0x01c3
        L_0x01c1:
            java.lang.String r1 = "paypal.single-payment"
        L_0x01c3:
            boolean r2 = r11.mSuccess
            r4 = 13591(0x3517, float:1.9045E-41)
            if (r2 == 0) goto L_0x01ed
            com.paypal.android.sdk.onetouch.core.enums.RequestTarget r2 = r11.mRequestTarget
            com.paypal.android.sdk.onetouch.core.enums.RequestTarget r5 = com.paypal.android.sdk.onetouch.core.enums.RequestTarget.wallet
            if (r2 != r5) goto L_0x01ed
            com.braintreepayments.api.BraintreeFragment r2 = r0.val$fragment
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r1 = ".app-switch.started"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.sendAnalyticsEvent(r1)
            com.braintreepayments.api.BraintreeFragment r0 = r0.val$fragment
            android.content.Intent r11 = r11.mIntent
            r0.startActivityForResult(r11, r4)
            goto L_0x0239
        L_0x01ed:
            boolean r2 = r11.mSuccess
            if (r2 == 0) goto L_0x0223
            com.paypal.android.sdk.onetouch.core.enums.RequestTarget r2 = r11.mRequestTarget
            com.paypal.android.sdk.onetouch.core.enums.RequestTarget r5 = com.paypal.android.sdk.onetouch.core.enums.RequestTarget.browser
            if (r2 != r5) goto L_0x0223
            com.braintreepayments.api.BraintreeFragment r2 = r0.val$fragment
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r1)
            java.lang.String r1 = ".browser-switch.started"
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            r2.sendAnalyticsEvent(r1)
            com.braintreepayments.api.BraintreeFragment r0 = r0.val$fragment
            android.content.Intent r11 = r11.mIntent
            if (r0 == 0) goto L_0x0222
            com.braintreepayments.browserswitch.BrowserSwitchOptions r1 = new com.braintreepayments.browserswitch.BrowserSwitchOptions
            r1.<init>()
            r1.intent = r11
            r1.requestCode = r4
            com.braintreepayments.browserswitch.BrowserSwitchClient r11 = r0.browserSwitchClient
            r11.start(r1, r0)
            goto L_0x0239
        L_0x0222:
            throw r3
        L_0x0223:
            com.braintreepayments.api.BraintreeFragment r11 = r0.val$fragment
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r1 = ".initiate.failed"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r11.sendAnalyticsEvent(r0)
        L_0x0239:
            return
        L_0x023a:
            r11 = move-exception
            com.braintreepayments.api.BraintreeFragment r0 = r10.val$fragment
            com.braintreepayments.api.BraintreeFragment$11 r1 = new com.braintreepayments.api.BraintreeFragment$11
            r1.<init>(r11)
            r0.postOrQueueCallback(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braintreepayments.api.PayPal$1.success(java.lang.String):void");
    }
}
