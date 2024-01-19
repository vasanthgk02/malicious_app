package com.braintreepayments.api;

import com.braintreepayments.api.interfaces.BraintreeResponseListener;
import com.braintreepayments.api.interfaces.ConfigurationListener;
import com.braintreepayments.api.models.Configuration;
import com.kount.api.DataCollector;
import com.kount.api.DataCollector.CompletionHandler;
import com.kount.api.DataCollector.LocationConfig;

public final class DataCollector$2 implements ConfigurationListener {
    public final /* synthetic */ String val$deviceSessionId;
    public final /* synthetic */ BraintreeFragment val$fragment;
    public final /* synthetic */ String val$merchantId;

    public DataCollector$2(BraintreeFragment braintreeFragment, String str, String str2, BraintreeResponseListener braintreeResponseListener) {
        this.val$fragment = braintreeFragment;
        this.val$merchantId = str;
        this.val$deviceSessionId = str2;
    }

    public void onConfigurationFetched(Configuration configuration) {
        DataCollector instance = DataCollector.getInstance();
        instance.setContext(this.val$fragment.mContext);
        instance.setMerchantID(Integer.parseInt(this.val$merchantId));
        instance.setLocationCollectorConfig(LocationConfig.COLLECT);
        instance.setEnvironment("production".equalsIgnoreCase(configuration.mEnvironment) ? 2 : 1);
        instance.collectForSession(this.val$deviceSessionId, new CompletionHandler(this) {
        });
    }
}
