package in.juspay.hypersdk.core;

import android.content.Intent;

public interface ResultAwaitingDuiHook extends JuspayDuiHook {
    boolean onActivityResult(int i, int i2, Intent intent);
}
