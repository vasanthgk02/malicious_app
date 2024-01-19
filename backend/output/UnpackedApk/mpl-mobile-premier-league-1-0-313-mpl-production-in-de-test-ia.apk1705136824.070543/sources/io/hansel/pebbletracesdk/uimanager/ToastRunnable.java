package io.hansel.pebbletracesdk.uimanager;

import android.content.Context;
import android.widget.Toast;

public class ToastRunnable implements Runnable {
    public Context mContext;
    public boolean mLongDuration;
    public String mText;

    public ToastRunnable(Context context, String str, boolean z) {
        this.mContext = context;
        this.mText = str;
        this.mLongDuration = z;
    }

    public void run() {
        String str = this.mText;
        if (str != null) {
            Toast.makeText(this.mContext, str, this.mLongDuration ? 1 : 0).show();
        }
    }
}
