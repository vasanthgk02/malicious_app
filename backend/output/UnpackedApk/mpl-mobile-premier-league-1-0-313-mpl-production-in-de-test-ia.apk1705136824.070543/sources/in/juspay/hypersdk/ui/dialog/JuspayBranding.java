package in.juspay.hypersdk.ui.dialog;

import androidx.annotation.Keep;

@Deprecated
@Keep
public interface JuspayBranding {

    public enum WaitingDialogType {
        V3_MERCHANT_DIALOG,
        V2_MERCHANT_SPECIFIC_DIALOG_START,
        V2_MERCHANT_SPECIFIC_DIALOG_END,
        V1_CUSTOM_WAITING_DIALOG,
        GENERIC_JUSPAY_DIALOG
    }
}
