package in.juspay.hypersdk.core;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.amazon.apay.hardened.external.model.APayError;
import com.inca.security.Proxy.iIiIiIiIii;

public class CompletionActivity extends Activity {
    public static final String TAG = "CompletionActivity";

    /* renamed from: in.juspay.hypersdk.core.CompletionActivity$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$amazon$apay$hardened$external$model$APayError$ErrorType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        static {
            /*
                com.amazon.apay.hardened.external.model.APayError$ErrorType[] r0 = com.amazon.apay.hardened.external.model.APayError.ErrorType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$amazon$apay$hardened$external$model$APayError$ErrorType = r0
                r1 = 1
                com.amazon.apay.hardened.external.model.APayError$ErrorType r2 = com.amazon.apay.hardened.external.model.APayError.ErrorType.AUTH_ERROR     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = $SwitchMap$com$amazon$apay$hardened$external$model$APayError$ErrorType     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.amazon.apay.hardened.external.model.APayError$ErrorType r3 = com.amazon.apay.hardened.external.model.APayError.ErrorType.PAYMENT_ERROR     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r1 = $SwitchMap$com$amazon$apay$hardened$external$model$APayError$ErrorType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.amazon.apay.hardened.external.model.APayError$ErrorType r2 = com.amazon.apay.hardened.external.model.APayError.ErrorType.BROWSING_EXPERIENCE     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.CompletionActivity.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: 0000 */
    public String getErrorInfo(APayError aPayError) {
        int ordinal = aPayError.getType().ordinal();
        if (ordinal == 0) {
            return String.format("Auth Error type: %s\nError Message: %s", new Object[]{"AUTH_ERROR", aPayError});
        } else if (ordinal == 1) {
            return String.format("Payment Error type: %s\nError Message: %s", new Object[]{"PAYMENT_ERROR", aPayError});
        } else if (ordinal != 2) {
            return "Unknown Apay Error";
        } else {
            return String.format("Low memory Error type: %s\nError Message: %s", new Object[]{"Low memory Error", aPayError});
        }
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, 733544805, bundle);
    }

    /* access modifiers changed from: 0000 */
    public void sendEmptyResponse(String str) {
        Intent intent = new Intent("amazonpay-result");
        intent.putExtra("status", str);
        intent.putExtra("signature", "");
        intent.putExtra("transactionId", "");
        intent.putExtra("orderTotalAmount", "");
        intent.putExtra("reasonCode", "");
        intent.putExtra("description", str);
        intent.putExtra("transactionDate", "");
        intent.putExtra("sellerOrderId", "");
        intent.putExtra("customInformation", "");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        finish();
    }
}
