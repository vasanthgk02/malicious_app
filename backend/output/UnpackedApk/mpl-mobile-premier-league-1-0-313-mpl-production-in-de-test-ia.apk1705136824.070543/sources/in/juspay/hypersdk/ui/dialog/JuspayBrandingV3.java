package in.juspay.hypersdk.ui.dialog;

import android.app.Dialog;
import androidx.annotation.Keep;

@Deprecated
@Keep
public abstract class JuspayBrandingV3 implements JuspayBranding {
    public abstract int createWaitingDialogWithLayout();

    public abstract void onWaitingDialogCreated(Dialog dialog);
}
