package com.midtrans.sdk.gopaycheckout.core.utils;

import com.paynimo.android.payment.util.Constant;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\u0006\b\u0000\u0010\b\u0018\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\b¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/utils/ErrorResponseUtils;", "", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "parseResponse", "T", "response", "Lretrofit2/Response;", "(Lretrofit2/Response;)Ljava/lang/Object;", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class ErrorResponseUtils {
    public final Moshi moshi;

    public ErrorResponseUtils(Moshi moshi2) {
        Intrinsics.checkParameterIsNotNull(moshi2, "moshi");
        this.moshi = moshi2;
    }

    public final Moshi getMoshi() {
        return this.moshi;
    }

    public final <T> T parseResponse(Response<T> response) {
        Intrinsics.checkParameterIsNotNull(response, Constant.TAG_RESPONSE);
        ResponseBody responseBody = response.errorBody;
        if (responseBody != null) {
            responseBody.string();
        }
        getMoshi();
        Intrinsics.reifiedOperationMarker();
        throw null;
    }
}
