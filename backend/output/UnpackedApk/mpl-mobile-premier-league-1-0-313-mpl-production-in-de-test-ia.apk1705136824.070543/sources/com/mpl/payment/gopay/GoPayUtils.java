package com.mpl.payment.gopay;

import com.midtrans.sdk.gopaycheckout.core.GoPayCheckoutError;
import com.midtrans.sdk.gopaycheckout.core.account.AccountResponse;
import com.midtrans.sdk.gopaycheckout.core.transaction.TransactionResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/mpl/payment/gopay/GoPayUtils;", "", "()V", "Companion", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoPayUtils.kt */
public final class GoPayUtils {
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\t¨\u0006\n"}, d2 = {"Lcom/mpl/payment/gopay/GoPayUtils$Companion;", "", "()V", "getErrorMessage", "", "error", "Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutError;", "errorResponse", "Lcom/midtrans/sdk/gopaycheckout/core/account/AccountResponse;", "Lcom/midtrans/sdk/gopaycheckout/core/transaction/TransactionResponse;", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoPayUtils.kt */
    public static final class Companion {
        public Companion() {
        }

        public final String getErrorMessage(GoPayCheckoutError goPayCheckoutError, AccountResponse accountResponse) {
            Intrinsics.checkNotNullParameter(goPayCheckoutError, "error");
            StringBuilder sb = new StringBuilder();
            String message = goPayCheckoutError.getMessage();
            if (message == null) {
                message = "No runtime error message";
            }
            sb.append(message);
            sb.append("___");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Status code--> ");
            List<String> list = null;
            sb2.append(accountResponse != null ? accountResponse.getStatusCode() : null);
            sb.append(sb2.toString());
            sb.append("___");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Status message--> ");
            sb3.append(accountResponse != null ? accountResponse.getStatusMessage() : null);
            sb.append(sb3.toString());
            Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder().append(e…esponse?.statusMessage}\")");
            if (accountResponse != null) {
                list = accountResponse.getValidationMessages();
            }
            if (list != null) {
                for (String append : list) {
                    sb.append("___");
                    sb.append(append);
                }
            }
            String sb4 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "errorBuilder.toString()");
            return sb4;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getErrorMessage(GoPayCheckoutError goPayCheckoutError, TransactionResponse transactionResponse) {
            Intrinsics.checkNotNullParameter(goPayCheckoutError, "error");
            StringBuilder sb = new StringBuilder();
            String message = goPayCheckoutError.getMessage();
            if (message == null) {
                message = "No runtime error message";
            }
            sb.append(message);
            sb.append("___");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Status code--> ");
            List<String> list = null;
            sb2.append(transactionResponse != null ? transactionResponse.getStatusCode() : null);
            sb.append(sb2.toString());
            sb.append("___");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Status message--> ");
            sb3.append(transactionResponse != null ? transactionResponse.getStatusMessage() : null);
            sb.append(sb3.toString());
            Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder().append(e…esponse?.statusMessage}\")");
            if (transactionResponse != null) {
                list = transactionResponse.getValidationMessages();
            }
            if (list != null) {
                for (String append : list) {
                    sb.append("___");
                    sb.append(append);
                }
            }
            String sb4 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "errorBuilder.toString()");
            return sb4;
        }
    }
}
