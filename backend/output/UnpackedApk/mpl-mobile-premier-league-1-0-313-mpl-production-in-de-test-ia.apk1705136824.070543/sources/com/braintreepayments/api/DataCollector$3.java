package com.braintreepayments.api;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.braintreepayments.api.interfaces.ConfigurationListener;
import com.braintreepayments.api.models.Authorization;
import com.braintreepayments.api.models.ClientToken;
import com.braintreepayments.api.models.Configuration;
import com.braintreepayments.api.models.PaymentMethodNonce;
import com.google.android.material.resources.TextAppearanceConfig;
import com.netcore.android.SMTEventParamKeys;
import in.juspay.hypersdk.core.InflateView;
import java.util.HashMap;
import lib.android.paypal.com.magnessdk.Environment;
import lib.android.paypal.com.magnessdk.InvalidInputException;
import lib.android.paypal.com.magnessdk.MagnesSDK;
import lib.android.paypal.com.magnessdk.MagnesSettings.Builder;
import lib.android.paypal.com.magnessdk.MagnesSource;
import lib.android.paypal.com.magnessdk.c$b$b;

public final class DataCollector$3 implements ConfigurationListener {
    public final /* synthetic */ BraintreeFragment val$fragment;
    public final /* synthetic */ PaymentMethodNonce val$paymentMethodNonce;

    public DataCollector$3(BraintreeFragment braintreeFragment, PaymentMethodNonce paymentMethodNonce) {
        this.val$fragment = braintreeFragment;
        this.val$paymentMethodNonce = paymentMethodNonce;
    }

    public void onConfigurationFetched(Configuration configuration) {
        String str;
        if (configuration.mCardConfiguration.mCollectFraudData) {
            HashMap outline87 = GeneratedOutlineSupport.outline87("rda_tenant", "bt_card");
            outline87.put(SMTEventParamKeys.SMT_MID, configuration.mMerchantId);
            Authorization authorization = this.val$fragment.mAuthorization;
            if (authorization instanceof ClientToken) {
                String[] split = ((ClientToken) authorization).mAuthorizationFingerprint.split("&");
                int length = split.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        str = null;
                        break;
                    }
                    String str2 = split[i];
                    if (str2.contains("customer_id=")) {
                        String[] split2 = str2.split(InflateView.SETTER_EQUALS);
                        if (split2.length > 1) {
                            str = split2[1];
                            break;
                        }
                    }
                    i++;
                }
                if (str != null) {
                    outline87.put("cid", str);
                }
            }
            String installationGUID = TextAppearanceConfig.getInstallationGUID(this.val$fragment.mContext);
            String str3 = this.val$paymentMethodNonce.mNonce;
            String substring = str3.substring(0, Math.min(str3.length(), 32));
            Context context = this.val$fragment.mContext;
            if (context != null) {
                try {
                    MagnesSDK instance = MagnesSDK.getInstance();
                    Builder builder = new Builder(context);
                    builder.sourceFlow = MagnesSource.BRAINTREE.getVersion();
                    builder.disableBeacon = true;
                    builder.environment = Environment.LIVE;
                    if (installationGUID.length() <= 36) {
                        builder.appGuid = installationGUID;
                        instance.setUp(builder.build());
                        instance.collectAndSubmit(context, substring, outline87);
                        return;
                    }
                    throw new InvalidInputException(c$b$b.APPGUID_EXCEPTION_MESSAGE.toString());
                } catch (InvalidInputException unused) {
                }
            }
        }
    }
}
