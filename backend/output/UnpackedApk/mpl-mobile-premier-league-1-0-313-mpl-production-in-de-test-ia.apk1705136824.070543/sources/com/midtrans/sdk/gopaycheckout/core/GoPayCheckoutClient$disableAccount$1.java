package com.midtrans.sdk.gopaycheckout.core;

import com.midtrans.sdk.gopaycheckout.analytics.AnalyticsEvent;
import com.midtrans.sdk.gopaycheckout.analytics.AnalyticsTracker;
import com.midtrans.sdk.gopaycheckout.core.GoPayCheckoutError.ClientError;
import com.midtrans.sdk.gopaycheckout.core.GoPayCheckoutError.NoContent;
import com.midtrans.sdk.gopaycheckout.core.GoPayCheckoutError.UnknownError;
import com.midtrans.sdk.gopaycheckout.core.account.AccountResponse;
import com.midtrans.sdk.gopaycheckout.core.utils.ErrorResponseUtils;
import com.paynimo.android.payment.util.Constant;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001e\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J$\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/midtrans/sdk/gopaycheckout/core/GoPayCheckoutClient$disableAccount$1", "Lretrofit2/Callback;", "Lcom/midtrans/sdk/gopaycheckout/core/account/AccountResponse;", "onFailure", "", "call", "Lretrofit2/Call;", "t", "", "onResponse", "response", "Lretrofit2/Response;", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class GoPayCheckoutClient$disableAccount$1 implements Callback<AccountResponse> {
    public final /* synthetic */ GoPayCheckoutCallback $internalCallback;
    public final /* synthetic */ GoPayCheckoutClient this$0;

    public GoPayCheckoutClient$disableAccount$1(GoPayCheckoutClient goPayCheckoutClient, GoPayCheckoutCallback goPayCheckoutCallback) {
        this.this$0 = goPayCheckoutClient;
        this.$internalCallback = goPayCheckoutCallback;
    }

    public void onFailure(Call<AccountResponse> call, Throwable th) {
        Intrinsics.checkParameterIsNotNull(call, "call");
        Intrinsics.checkParameterIsNotNull(th, "t");
        UnknownError unknownError = new UnknownError(th);
        this.this$0.getAnalyticsTracker$gopay_checkout_release().trackEvent(AnalyticsEvent.UNLINK_ACCOUNT_ERROR, this.this$0.mapAnalyticsProperties(unknownError));
        this.$internalCallback.onFailure(unknownError, null);
    }

    public void onResponse(Call<AccountResponse> call, Response<AccountResponse> response) {
        GoPayCheckoutError clientError;
        Intrinsics.checkParameterIsNotNull(call, "call");
        Intrinsics.checkParameterIsNotNull(response, Constant.TAG_RESPONSE);
        GoPayCheckoutClient goPayCheckoutClient = this.this$0;
        GoPayCheckoutCallback goPayCheckoutCallback = this.$internalCallback;
        Object obj = null;
        if (response.isSuccessful()) {
            T t = response.body;
            if (t != null) {
                AnalyticsTracker.trackEvent$default(this.this$0.getAnalyticsTracker$gopay_checkout_release(), AnalyticsEvent.UNLINK_ACCOUNT_SUCCESS, null, 2, null);
                this.$internalCallback.onResponse((AccountResponse) t);
                GoPayCheckoutState.INSTANCE.setExecutable(true);
            }
            clientError = new NoContent(response.code());
        } else {
            ErrorResponseUtils errorResponseUtils$gopay_checkout_release = goPayCheckoutClient.getErrorResponseUtils$gopay_checkout_release();
            ResponseBody responseBody = response.errorBody;
            String string = responseBody != null ? responseBody.string() : null;
            JsonAdapter lenient = errorResponseUtils$gopay_checkout_release.getMoshi().adapter(AccountResponse.class).lenient();
            if (string == null) {
                string = "";
            }
            try {
                obj = lenient.fromJson(string);
            } catch (JsonDataException unused) {
            }
            clientError = new ClientError(response.code());
            AccountResponse accountResponse = (AccountResponse) obj;
        }
        this.this$0.getAnalyticsTracker$gopay_checkout_release().trackEvent(AnalyticsEvent.UNLINK_ACCOUNT_ERROR, this.this$0.mapAnalyticsProperties(clientError));
        goPayCheckoutCallback.onFailure(clientError, obj);
        GoPayCheckoutState.INSTANCE.setExecutable(true);
    }
}
