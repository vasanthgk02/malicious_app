package com.facebook.react;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.appcompat.app.AppCompatActivity;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.ReactActivityDelegate.AnonymousClass1;
import com.facebook.react.bridge.Callback;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;

public abstract class ReactActivity extends AppCompatActivity implements DefaultHardwareBackBtnHandler, PermissionAwareActivity {
    public final ReactActivityDelegate mDelegate = createReactActivityDelegate();

    public ReactActivityDelegate createReactActivityDelegate() {
        return new ReactActivityDelegate(this, getMainComponentName());
    }

    public String getMainComponentName() {
        return null;
    }

    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.mDelegate.mReactDelegate != null) {
            throw null;
        }
        throw null;
    }

    public void onBackPressed() {
        if (this.mDelegate.mReactDelegate != null) {
            throw null;
        }
        throw null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ReactActivityDelegate reactActivityDelegate = this.mDelegate;
        String str = reactActivityDelegate.mMainComponentName;
        Activity activity = reactActivityDelegate.mActivity;
        ImageOriginUtils.assertNotNull(activity);
        reactActivityDelegate.getReactNativeHost();
        AnonymousClass1 r1 = new ReactDelegate(activity, str, null) {
            public ReactRootView createRootView() {
                ReactActivityDelegate reactActivityDelegate = ReactActivityDelegate.this;
                if (reactActivityDelegate != null) {
                    Activity activity = reactActivityDelegate.mActivity;
                    ImageOriginUtils.assertNotNull(activity);
                    return new ReactRootView(activity);
                }
                throw null;
            }
        };
        reactActivityDelegate.mReactDelegate = r1;
        if (reactActivityDelegate.mMainComponentName == null) {
            return;
        }
        if (r1.mReactRootView != null) {
            throw new IllegalStateException("Cannot loadApp while app is already running.");
        }
        r1.mReactRootView = r1.createRootView();
        throw null;
    }

    public void onDestroy() {
        super.onDestroy();
        ReactDelegate reactDelegate = this.mDelegate.mReactDelegate;
        ReactRootView reactRootView = reactDelegate.mReactRootView;
        if (reactRootView != null) {
            reactRootView.unmountReactApplication();
            reactDelegate.mReactRootView = null;
        }
        throw null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        this.mDelegate.getReactNativeHost();
        throw null;
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        this.mDelegate.getReactNativeHost();
        throw null;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.mDelegate.mReactDelegate != null) {
            throw null;
        }
        throw null;
    }

    public void onNewIntent(Intent intent) {
        this.mDelegate.getReactNativeHost();
        throw null;
    }

    public void onPause() {
        super.onPause();
        if (this.mDelegate.mReactDelegate != null) {
            throw null;
        }
        throw null;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        ReactActivityDelegate reactActivityDelegate = this.mDelegate;
        reactActivityDelegate.mPermissionsCallback = new Callback(i, strArr, iArr) {
            public final /* synthetic */ int[] val$grantResults;
            public final /* synthetic */ String[] val$permissions;
            public final /* synthetic */ int val$requestCode;

            {
                this.val$requestCode = r2;
                this.val$permissions = r3;
                this.val$grantResults = r4;
            }

            public void invoke(Object... objArr) {
                PermissionListener permissionListener = ReactActivityDelegate.this.mPermissionListener;
                if (permissionListener != null && permissionListener.onRequestPermissionsResult(this.val$requestCode, this.val$permissions, this.val$grantResults)) {
                    ReactActivityDelegate.this.mPermissionListener = null;
                }
            }
        };
    }

    public void onResume() {
        super.onResume();
        if (this.mDelegate.mReactDelegate != null) {
            throw null;
        }
        throw null;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.mDelegate.getReactNativeHost();
        throw null;
    }

    public void requestPermissions(String[] strArr, int i, PermissionListener permissionListener) {
        ReactActivityDelegate reactActivityDelegate = this.mDelegate;
        reactActivityDelegate.mPermissionListener = permissionListener;
        Activity activity = reactActivityDelegate.mActivity;
        ImageOriginUtils.assertNotNull(activity);
        activity.requestPermissions(strArr, i);
    }
}
