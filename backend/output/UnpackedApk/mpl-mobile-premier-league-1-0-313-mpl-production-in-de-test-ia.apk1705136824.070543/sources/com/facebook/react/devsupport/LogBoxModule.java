package com.facebook.react.devsupport;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeLogBoxSpec;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "LogBox")
public class LogBoxModule extends NativeLogBoxSpec {
    public static final String NAME = "LogBox";
    public final DevSupportManager mDevSupportManager;
    public LogBoxDialog mLogBoxDialog;
    public View mReactRootView;

    public LogBoxModule(ReactApplicationContext reactApplicationContext, DevSupportManager devSupportManager) {
        super(reactApplicationContext);
        this.mDevSupportManager = devSupportManager;
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (LogBoxModule.this.mReactRootView == null && LogBoxModule.this.mDevSupportManager != null) {
                    LogBoxModule logBoxModule = LogBoxModule.this;
                    logBoxModule.mReactRootView = logBoxModule.mDevSupportManager.createRootView(LogBoxModule.NAME);
                    if (LogBoxModule.this.mReactRootView == null) {
                        FLog.e((String) "ReactNative", (String) "Unable to launch logbox because react was unable to create the root view");
                    }
                }
            }
        });
    }

    public String getName() {
        return NAME;
    }

    public void hide() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (LogBoxModule.this.mLogBoxDialog != null) {
                    if (!(LogBoxModule.this.mReactRootView == null || LogBoxModule.this.mReactRootView.getParent() == null)) {
                        ((ViewGroup) LogBoxModule.this.mReactRootView.getParent()).removeView(LogBoxModule.this.mReactRootView);
                    }
                    LogBoxModule.this.mLogBoxDialog.dismiss();
                    LogBoxModule.this.mLogBoxDialog = null;
                }
            }
        });
    }

    public void onCatalystInstanceDestroy() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (LogBoxModule.this.mReactRootView != null) {
                    LogBoxModule.this.mDevSupportManager.destroyRootView(LogBoxModule.this.mReactRootView);
                    LogBoxModule.this.mReactRootView = null;
                }
            }
        });
    }

    public void show() {
        if (this.mReactRootView != null) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    if (LogBoxModule.this.mLogBoxDialog == null && LogBoxModule.this.mReactRootView != null) {
                        Activity access$300 = LogBoxModule.this.getCurrentActivity();
                        if (access$300 == null || access$300.isFinishing()) {
                            FLog.e((String) "ReactNative", (String) "Unable to launch logbox because react activity is not available, here is the error that logbox would've displayed: ");
                            return;
                        }
                        LogBoxModule.this.mLogBoxDialog = new LogBoxDialog(access$300, LogBoxModule.this.mReactRootView);
                        LogBoxModule.this.mLogBoxDialog.setCancelable(false);
                        LogBoxModule.this.mLogBoxDialog.show();
                    }
                }
            });
        }
    }
}
