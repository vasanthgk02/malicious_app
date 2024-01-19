package com.microsoft.codepush.react;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class CodePushDialog extends ReactContextBaseJavaModule {
    public CodePushDialog(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* access modifiers changed from: private */
    public void showDialogInternal(String str, String str2, String str3, String str4, final Callback callback, Activity activity) {
        Builder builder = new Builder(activity);
        builder.setCancelable(false);
        AnonymousClass2 r7 = new OnClickListener(this) {
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    dialogInterface.cancel();
                    if (i == -2) {
                        callback.invoke(Integer.valueOf(1));
                    } else if (i == -1) {
                        callback.invoke(Integer.valueOf(0));
                    } else {
                        throw new CodePushUnknownException("Unknown button ID pressed.");
                    }
                } catch (Throwable unused) {
                }
            }
        };
        if (str != null) {
            builder.setTitle(str);
        }
        if (str2 != null) {
            builder.setMessage(str2);
        }
        if (str3 != null) {
            builder.setPositiveButton(str3, r7);
        }
        if (str4 != null) {
            builder.setNegativeButton(str4, r7);
        }
        builder.create().show();
    }

    public String getName() {
        return "CodePushDialog";
    }

    @ReactMethod
    public void showDialog(String str, String str2, String str3, String str4, Callback callback, Callback callback2) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null || currentActivity.isFinishing()) {
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            final String str5 = str;
            final String str6 = str2;
            final String str7 = str3;
            final String str8 = str4;
            final Callback callback3 = callback;
            AnonymousClass1 r0 = new LifecycleEventListener() {
                public void onHostDestroy() {
                }

                public void onHostPause() {
                }

                public void onHostResume() {
                    Activity access$000 = CodePushDialog.this.getCurrentActivity();
                    if (access$000 != null) {
                        CodePushDialog.this.getReactApplicationContext().removeLifecycleEventListener(this);
                        CodePushDialog.this.showDialogInternal(str5, str6, str7, str8, callback3, access$000);
                    }
                }
            };
            reactApplicationContext.addLifecycleEventListener(r0);
            return;
        }
        showDialogInternal(str, str2, str3, str4, callback, currentActivity);
    }
}
