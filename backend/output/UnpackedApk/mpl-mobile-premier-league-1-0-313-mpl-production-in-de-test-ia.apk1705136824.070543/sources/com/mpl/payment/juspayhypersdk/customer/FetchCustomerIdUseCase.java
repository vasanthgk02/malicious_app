package com.mpl.payment.juspayhypersdk.customer;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.Constant;
import com.mpl.network.modules.MClient;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.network.modules.request.MOkHttpGetRequest;
import com.mpl.network.modules.request.MOkHttpGetRequest.Builder;
import com.mpl.network.modules.request.RequestPriority;
import com.mpl.payment.common.AuthTokenProvider;
import com.mpl.payment.common.models.MPLEndpointResultStatus;
import com.mpl.payment.juspayhypersdk.customer.model.CustomerDetailsPayload;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0017J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u0003H\u0002J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u0003H\u0002R\u001a\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006$"}, d2 = {"Lcom/mpl/payment/juspayhypersdk/customer/FetchCustomerIdUseCase;", "", "fetchCustomerIdUrl", "", "headers", "", "Lcom/mpl/network/modules/engine/MHeader;", "authTokenProvider", "Lcom/mpl/payment/common/AuthTokenProvider;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Ljava/lang/String;Ljava/util/List;Lcom/mpl/payment/common/AuthTokenProvider;Lcom/squareup/moshi/Moshi;)V", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "getAuthTokenProvider", "()Lcom/mpl/payment/common/AuthTokenProvider;", "getFetchCustomerIdUrl", "getHeaders", "()Ljava/util/List;", "listener", "Lcom/mpl/payment/juspayhypersdk/customer/FetchCustomerIdUseCaseResultListener;", "getListener", "()Lcom/mpl/payment/juspayhypersdk/customer/FetchCustomerIdUseCaseResultListener;", "setListener", "(Lcom/mpl/payment/juspayhypersdk/customer/FetchCustomerIdUseCaseResultListener;)V", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "fetchCustomerId", "", "fetchCustomerIdUseCaseResultListener", "processPayload", "response", "processResponse", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: FetchCustomerIdUseCase.kt */
public final class FetchCustomerIdUseCase {
    public String TAG = "FetchCustomerIdUseCase";
    public final AuthTokenProvider authTokenProvider;
    public final String fetchCustomerIdUrl;
    public final List<MHeader> headers;
    public FetchCustomerIdUseCaseResultListener listener;
    public final Moshi moshi;

    public FetchCustomerIdUseCase(String str, List<MHeader> list, AuthTokenProvider authTokenProvider2, Moshi moshi2) {
        Intrinsics.checkNotNullParameter(str, "fetchCustomerIdUrl");
        Intrinsics.checkNotNullParameter(list, Constant.HEADER);
        Intrinsics.checkNotNullParameter(authTokenProvider2, "authTokenProvider");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        this.fetchCustomerIdUrl = str;
        this.headers = list;
        this.authTokenProvider = authTokenProvider2;
        this.moshi = moshi2;
    }

    private final void processPayload(String str) {
        JsonAdapter<CustomerDetailsPayload> adapter = this.moshi.adapter(CustomerDetailsPayload.class);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(CustomerDetailsPayload::class.java)");
        CustomerDetailsPayload customerDetailsPayload = (CustomerDetailsPayload) adapter.fromJson(str);
        if (customerDetailsPayload != null) {
            FetchCustomerIdUseCaseResultListener fetchCustomerIdUseCaseResultListener = this.listener;
            if (fetchCustomerIdUseCaseResultListener != null) {
                fetchCustomerIdUseCaseResultListener.onSuccess(customerDetailsPayload.getPayload().getPartnerCustomerDetailList().get(0).getCustomerId());
                return;
            }
            return;
        }
        throw new Exception(GeneratedOutlineSupport.outline62(new StringBuilder(), this.TAG, " payload object null wile parsing"));
    }

    /* access modifiers changed from: private */
    public final void processResponse(String str) {
        JsonAdapter<MPLEndpointResultStatus> adapter = this.moshi.adapter(MPLEndpointResultStatus.class);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(MPLEndpointResultStatus::class.java)");
        MPLEndpointResultStatus mPLEndpointResultStatus = (MPLEndpointResultStatus) adapter.fromJson(str);
        if (mPLEndpointResultStatus == null) {
            throw new Exception(GeneratedOutlineSupport.outline62(new StringBuilder(), this.TAG, " status object null wile parsing"));
        } else if (mPLEndpointResultStatus.getStatus().getCode() == 200) {
            processPayload(str);
        } else {
            FetchCustomerIdUseCaseResultListener fetchCustomerIdUseCaseResultListener = this.listener;
            if (fetchCustomerIdUseCaseResultListener != null) {
                fetchCustomerIdUseCaseResultListener.onError(this.TAG + " check status code for /partnerCustomerDetails " + str);
            }
        }
    }

    public final void fetchCustomerId(FetchCustomerIdUseCaseResultListener fetchCustomerIdUseCaseResultListener) {
        Intrinsics.checkNotNullParameter(fetchCustomerIdUseCaseResultListener, "fetchCustomerIdUseCaseResultListener");
        this.listener = fetchCustomerIdUseCaseResultListener;
        MOkHttpGetRequest build = new Builder().setUrl(this.fetchCustomerIdUrl).setHeaders(ArraysKt___ArraysJvmKt.toMutableList((Collection<? extends T>) this.headers)).addHeader(this.authTokenProvider.getAuthHeader()).setRequestPriority(RequestPriority.HIGH).setRetryOnConnectionFailure(true).addQueryParam("partners", "JUSPAY").setResponseListener(new FetchCustomerIdUseCase$fetchCustomerId$serverRequest$1(this)).build();
        Intrinsics.checkNotNullExpressionValue(build, "MOkHttpGetRequest.Builde…\n                .build()");
        MClient.executeAsync(build);
    }

    public final AuthTokenProvider getAuthTokenProvider() {
        return this.authTokenProvider;
    }

    public final String getFetchCustomerIdUrl() {
        return this.fetchCustomerIdUrl;
    }

    public final List<MHeader> getHeaders() {
        return this.headers;
    }

    public final FetchCustomerIdUseCaseResultListener getListener() {
        return this.listener;
    }

    public final Moshi getMoshi() {
        return this.moshi;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final void setListener(FetchCustomerIdUseCaseResultListener fetchCustomerIdUseCaseResultListener) {
        this.listener = fetchCustomerIdUseCaseResultListener;
    }

    public final void setTAG(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.TAG = str;
    }
}
