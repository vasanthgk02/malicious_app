package io.hansel.pebbletracesdk.uimanager;

import android.os.Handler;
import android.os.Looper;

public class UIHandler extends Handler {
    public UIHandler() {
        super(Looper.getMainLooper());
    }
}
