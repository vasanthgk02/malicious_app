package com.midtrans.sdk.gopaycheckout.di;

import com.midtrans.sdk.gopaycheckout.core.utils.ErrorResponseUtils;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/di/UtilsModule;", "", "()V", "provideErrorResponseUtils", "Lcom/midtrans/sdk/gopaycheckout/core/utils/ErrorResponseUtils;", "moshi", "Lcom/squareup/moshi/Moshi;", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class UtilsModule {
    public final ErrorResponseUtils provideErrorResponseUtils(Moshi moshi) {
        Intrinsics.checkParameterIsNotNull(moshi, "moshi");
        return new ErrorResponseUtils(moshi);
    }
}
