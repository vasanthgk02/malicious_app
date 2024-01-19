package com.facebook.react.modules.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeDialogManagerAndroidSpec;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = "DialogManagerAndroid")
public class DialogModule extends NativeDialogManagerAndroidSpec implements LifecycleEventListener {
    public static final String ACTION_BUTTON_CLICKED = "buttonClicked";
    public static final String ACTION_DISMISSED = "dismissed";
    public static final Map<String, Object> CONSTANTS;
    public static final String FRAGMENT_TAG = "com.facebook.catalyst.react.dialog.DialogModule";
    public static final String KEY_BUTTON_NEGATIVE = "buttonNegative";
    public static final String KEY_BUTTON_NEUTRAL = "buttonNeutral";
    public static final String KEY_BUTTON_POSITIVE = "buttonPositive";
    public static final String KEY_CANCELABLE = "cancelable";
    public static final String KEY_ITEMS = "items";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_TITLE = "title";
    public static final String NAME = "DialogManagerAndroid";
    public boolean mIsInForeground;

    public class AlertFragmentListener implements OnClickListener, OnDismissListener {
        public final Callback mCallback;
        public boolean mCallbackConsumed = false;

        public AlertFragmentListener(Callback callback) {
            this.mCallback = callback;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (!this.mCallbackConsumed && DialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                this.mCallback.invoke(DialogModule.ACTION_BUTTON_CLICKED, Integer.valueOf(i));
                this.mCallbackConsumed = true;
            }
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (!this.mCallbackConsumed && DialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                this.mCallback.invoke(DialogModule.ACTION_DISMISSED);
                this.mCallbackConsumed = true;
            }
        }
    }

    public class FragmentManagerHelper {
        public final FragmentManager mFragmentManager;
        public Object mFragmentToShow;

        public FragmentManagerHelper(FragmentManager fragmentManager) {
            this.mFragmentManager = fragmentManager;
        }

        public final void dismissExisting() {
            if (DialogModule.this.mIsInForeground) {
                AlertFragment alertFragment = (AlertFragment) this.mFragmentManager.findFragmentByTag(DialogModule.FRAGMENT_TAG);
                if (alertFragment != null && alertFragment.isResumed()) {
                    alertFragment.dismiss();
                }
            }
        }
    }

    static {
        Integer valueOf = Integer.valueOf(-1);
        Integer valueOf2 = Integer.valueOf(-2);
        Integer valueOf3 = Integer.valueOf(-3);
        HashMap outline88 = GeneratedOutlineSupport.outline88(ACTION_BUTTON_CLICKED, ACTION_BUTTON_CLICKED, ACTION_DISMISSED, ACTION_DISMISSED);
        outline88.put(KEY_BUTTON_POSITIVE, valueOf);
        outline88.put(KEY_BUTTON_NEGATIVE, valueOf2);
        outline88.put(KEY_BUTTON_NEUTRAL, valueOf3);
        CONSTANTS = outline88;
    }

    public DialogModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private FragmentManagerHelper getFragmentManagerHelper() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null || !(currentActivity instanceof FragmentActivity)) {
            return null;
        }
        return new FragmentManagerHelper(((FragmentActivity) currentActivity).getSupportFragmentManager());
    }

    public String getName() {
        return NAME;
    }

    public Map<String, Object> getTypedExportedConstants() {
        return CONSTANTS;
    }

    public void initialize() {
        getReactApplicationContext().addLifecycleEventListener(this);
    }

    public void onHostDestroy() {
    }

    public void onHostPause() {
        this.mIsInForeground = false;
    }

    public void onHostResume() {
        this.mIsInForeground = true;
        FragmentManagerHelper fragmentManagerHelper = getFragmentManagerHelper();
        if (fragmentManagerHelper != null) {
            UiThreadUtil.assertOnUiThread();
            SoftAssertions.assertCondition(DialogModule.this.mIsInForeground, "showPendingAlert() called in background");
            if (fragmentManagerHelper.mFragmentToShow != null) {
                fragmentManagerHelper.dismissExisting();
                ((AlertFragment) fragmentManagerHelper.mFragmentToShow).show(fragmentManagerHelper.mFragmentManager, (String) FRAGMENT_TAG);
                fragmentManagerHelper.mFragmentToShow = null;
                return;
            }
            return;
        }
        FLog.w(DialogModule.class, (String) "onHostResume called but no FragmentManager found");
    }

    public void showAlert(ReadableMap readableMap, Callback callback, final Callback callback2) {
        final FragmentManagerHelper fragmentManagerHelper = getFragmentManagerHelper();
        if (fragmentManagerHelper == null) {
            callback.invoke("Tried to show an alert while not attached to an Activity");
            return;
        }
        final Bundle bundle = new Bundle();
        if (readableMap.hasKey("title")) {
            bundle.putString("title", readableMap.getString("title"));
        }
        if (readableMap.hasKey("message")) {
            bundle.putString("message", readableMap.getString("message"));
        }
        if (readableMap.hasKey(KEY_BUTTON_POSITIVE)) {
            bundle.putString("button_positive", readableMap.getString(KEY_BUTTON_POSITIVE));
        }
        if (readableMap.hasKey(KEY_BUTTON_NEGATIVE)) {
            bundle.putString("button_negative", readableMap.getString(KEY_BUTTON_NEGATIVE));
        }
        if (readableMap.hasKey(KEY_BUTTON_NEUTRAL)) {
            bundle.putString("button_neutral", readableMap.getString(KEY_BUTTON_NEUTRAL));
        }
        if (readableMap.hasKey(KEY_ITEMS)) {
            ReadableArray array = readableMap.getArray(KEY_ITEMS);
            CharSequence[] charSequenceArr = new CharSequence[array.size()];
            for (int i = 0; i < array.size(); i++) {
                charSequenceArr[i] = array.getString(i);
            }
            bundle.putCharSequenceArray(KEY_ITEMS, charSequenceArr);
        }
        if (readableMap.hasKey(KEY_CANCELABLE)) {
            bundle.putBoolean(KEY_CANCELABLE, readableMap.getBoolean(KEY_CANCELABLE));
        }
        UiThreadUtil.runOnUiThread(new Runnable(this) {
            public void run() {
                FragmentManagerHelper fragmentManagerHelper = fragmentManagerHelper;
                Bundle bundle = bundle;
                Callback callback = callback2;
                AlertFragmentListener alertFragmentListener = null;
                if (fragmentManagerHelper != null) {
                    UiThreadUtil.assertOnUiThread();
                    fragmentManagerHelper.dismissExisting();
                    if (callback != null) {
                        alertFragmentListener = new AlertFragmentListener(callback);
                    }
                    AlertFragment alertFragment = new AlertFragment(alertFragmentListener, bundle);
                    if (!DialogModule.this.mIsInForeground || fragmentManagerHelper.mFragmentManager.isStateSaved()) {
                        fragmentManagerHelper.mFragmentToShow = alertFragment;
                        return;
                    }
                    if (bundle.containsKey(DialogModule.KEY_CANCELABLE)) {
                        alertFragment.setCancelable(bundle.getBoolean(DialogModule.KEY_CANCELABLE));
                    }
                    alertFragment.show(fragmentManagerHelper.mFragmentManager, (String) DialogModule.FRAGMENT_TAG);
                    return;
                }
                throw null;
            }
        });
    }
}
