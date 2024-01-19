package in.juspay.hypersdk.core;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.content.Context;
import in.juspay.hypersdk.core.Labels.System;
import java.util.ArrayList;
import org.json.JSONObject;

public class ClipboardListener implements OnPrimaryClipChangedListener, JuspayDuiHook {
    public static final String LOG_TAG = "ClipboardListener";
    public final Context context;
    public final JuspayServices juspayServices;
    public final OnClipboardChangeListener listener;

    public interface OnClipboardChangeListener {
        void onClipboardChange(ArrayList<String> arrayList);
    }

    public ClipboardListener(OnClipboardChangeListener onClipboardChangeListener, JuspayServices juspayServices2) {
        this.listener = onClipboardChangeListener;
        this.context = juspayServices2.getContext();
        this.juspayServices = juspayServices2;
    }

    public static ArrayList<String> getClipboardItems(ClipboardManager clipboardManager, JuspayServices juspayServices2) {
        Context context2 = juspayServices2.getContext();
        SdkTracker sdkTracker = juspayServices2.getSdkTracker();
        try {
            ClipData primaryClip = clipboardManager.getPrimaryClip();
            ArrayList<String> arrayList = new ArrayList<>();
            if (primaryClip == null) {
                sdkTracker.trackAction("system", "warning", System.CLIPBOARD, "missing", "clipdata");
                return new ArrayList<>();
            }
            for (int i = 0; i < primaryClip.getItemCount(); i++) {
                arrayList.add(String.valueOf(primaryClip.getItemAt(i).coerceToText(context2)));
            }
            return arrayList;
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.CLIPBOARD, "Error while trying to get clipboard items", e2);
            return new ArrayList<>();
        }
    }

    private ClipboardManager getClipboardManager() {
        return (ClipboardManager) this.context.getSystemService("clipboard");
    }

    public void attach(Activity activity) {
        if (getClipboardManager() != null) {
            getClipboardManager().addPrimaryClipChangedListener(this);
        }
    }

    public void detach(Activity activity) {
        ClipboardManager clipboardManager = getClipboardManager();
        if (clipboardManager != null) {
            clipboardManager.removePrimaryClipChangedListener(this);
        }
    }

    public String execute(Activity activity, String str, JSONObject jSONObject, String str2) {
        return null;
    }

    public void onPrimaryClipChanged() {
        ClipboardManager clipboardManager = getClipboardManager();
        if (clipboardManager != null) {
            this.listener.onClipboardChange(getClipboardItems(clipboardManager, this.juspayServices));
        }
    }
}
