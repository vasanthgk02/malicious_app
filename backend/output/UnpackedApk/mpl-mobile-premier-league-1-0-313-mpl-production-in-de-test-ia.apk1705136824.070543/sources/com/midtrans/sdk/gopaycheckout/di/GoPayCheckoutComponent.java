package com.midtrans.sdk.gopaycheckout.di;

import android.content.Context;
import com.midtrans.sdk.gopaycheckout.core.GoPayCheckoutClient;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/di/GoPayCheckoutComponent;", "", "inject", "", "goPayCheckoutClient", "Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutClient;", "Builder", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public interface GoPayCheckoutComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0012\u0010\u0007\u001a\u00020\u00002\b\b\u0001\u0010\b\u001a\u00020\tH'J\u0012\u0010\n\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\fH'¨\u0006\r"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/di/GoPayCheckoutComponent$Builder;", "", "build", "Lcom/midtrans/sdk/gopaycheckout/di/GoPayCheckoutComponent;", "setApplicationContext", "context", "Landroid/content/Context;", "setEnableLogging", "enabled", "", "setMerchantUrl", "url", "", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
    public interface Builder {
        GoPayCheckoutComponent build();

        Builder setApplicationContext(Context context);

        Builder setEnableLogging(boolean z);

        Builder setMerchantUrl(String str);
    }

    void inject(GoPayCheckoutClient goPayCheckoutClient);
}
