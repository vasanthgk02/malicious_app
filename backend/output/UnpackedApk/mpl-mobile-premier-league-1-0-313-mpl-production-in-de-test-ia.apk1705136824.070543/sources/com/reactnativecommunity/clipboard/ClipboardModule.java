package com.reactnativecommunity.clipboard;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import com.facebook.react.bridge.ContextBaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "RNCClipboard")
public class ClipboardModule extends ContextBaseJavaModule {
    public static final String NAME = "RNCClipboard";

    public ClipboardModule(Context context) {
        super(context);
    }

    private ClipboardManager getClipboardService() {
        Context context = getContext();
        getContext();
        return (ClipboardManager) context.getSystemService("clipboard");
    }

    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void getString(Promise promise) {
        try {
            ClipboardManager clipboardService = getClipboardService();
            ClipData primaryClip = clipboardService.getPrimaryClip();
            if (primaryClip != null) {
                if (primaryClip.getItemCount() >= 1) {
                    Item itemAt = clipboardService.getPrimaryClip().getItemAt(0);
                    promise.resolve("" + itemAt.getText());
                    return;
                }
            }
            promise.resolve("");
        } catch (Exception e2) {
            promise.reject((Throwable) e2);
        }
    }

    @ReactMethod
    public void hasString(Promise promise) {
        try {
            ClipData primaryClip = getClipboardService().getPrimaryClip();
            boolean z = true;
            if (primaryClip == null || primaryClip.getItemCount() < 1) {
                z = false;
            }
            promise.resolve(Boolean.valueOf(z));
        } catch (Exception e2) {
            promise.reject((Throwable) e2);
        }
    }

    @ReactMethod
    public void setString(String str) {
        getClipboardService().setPrimaryClip(ClipData.newPlainText(null, str));
    }
}
