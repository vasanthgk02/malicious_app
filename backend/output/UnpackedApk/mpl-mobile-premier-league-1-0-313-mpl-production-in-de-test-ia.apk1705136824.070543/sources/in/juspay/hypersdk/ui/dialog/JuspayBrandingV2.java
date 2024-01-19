package in.juspay.hypersdk.ui.dialog;

import android.app.Dialog;
import androidx.annotation.Keep;

@Deprecated
@Keep
public abstract class JuspayBrandingV2 implements JuspayBranding {
    public abstract int createEndWaitingDialogWithLayout();

    public abstract int createStartWaitingDialogWithLayout();

    public abstract void onEndWaitingDialogCreated(Dialog dialog);

    public abstract void onStartWaitingDialogCreated(Dialog dialog);
}
