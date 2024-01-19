package com.midtrans.sdk.gopaycheckout.core;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0003\b\t\nB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutError;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "ClientError", "NoContent", "UnknownError", "Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutError$ClientError;", "Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutError$UnknownError;", "Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutError$NoContent;", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public abstract class GoPayCheckoutError extends RuntimeException {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutError$ClientError;", "Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutError;", "errorCode", "", "(I)V", "getErrorCode", "()I", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
    public static final class ClientError extends GoPayCheckoutError {
        public final int errorCode;

        public ClientError(int i) {
            super(GeneratedOutlineSupport.outline41("Http Error: ", i), null, 2, null);
            this.errorCode = i;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutError$NoContent;", "Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutError;", "code", "", "(I)V", "getCode", "()I", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
    public static final class NoContent extends GoPayCheckoutError {
        public final int code;

        public NoContent(int i) {
            super(GeneratedOutlineSupport.outline42("HTTP error code: ", i, " but no response"), null, 2, null);
            this.code = i;
        }

        public final int getCode() {
            return this.code;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutError$UnknownError;", "Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutError;", "throwable", "", "(Ljava/lang/Throwable;)V", "getThrowable", "()Ljava/lang/Throwable;", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
    public static final class UnknownError extends GoPayCheckoutError {
        public final Throwable throwable;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public UnknownError(Throwable th) {
            // Intrinsics.checkParameterIsNotNull(th, "throwable");
            super(th.getMessage() == null ? "" : th.getMessage(), th, null);
            this.throwable = th;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }
    }

    public GoPayCheckoutError(String str, Throwable th) {
        super(str, th);
    }

    public /* synthetic */ GoPayCheckoutError(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : th);
    }

    public /* synthetic */ GoPayCheckoutError(String str, Throwable th, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, th);
    }
}
