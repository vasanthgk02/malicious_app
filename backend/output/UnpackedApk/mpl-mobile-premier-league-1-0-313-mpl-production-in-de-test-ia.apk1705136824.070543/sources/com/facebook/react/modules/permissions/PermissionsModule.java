package com.facebook.react.modules.permissions;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.SparseArray;
import com.facebook.fbreact.specs.NativePermissionsAndroidSpec;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import java.util.ArrayList;

@ReactModule(name = "PermissionsAndroid")
public class PermissionsModule extends NativePermissionsAndroidSpec implements PermissionListener {
    public static final String ERROR_INVALID_ACTIVITY = "E_INVALID_ACTIVITY";
    public static final String NAME = "PermissionsAndroid";
    public final String DENIED = "denied";
    public final String GRANTED = "granted";
    public final String NEVER_ASK_AGAIN = "never_ask_again";
    public final SparseArray<Callback> mCallbacks = new SparseArray<>();
    public int mRequestCode = 0;

    public PermissionsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private PermissionAwareActivity getPermissionAwareActivity() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            throw new IllegalStateException("Tried to use permissions API while not attached to an Activity.");
        } else if (currentActivity instanceof PermissionAwareActivity) {
            return (PermissionAwareActivity) currentActivity;
        } else {
            throw new IllegalStateException("Tried to use permissions API but the host Activity doesn't implement PermissionAwareActivity.");
        }
    }

    public void checkPermission(String str, Promise promise) {
        Context baseContext = getReactApplicationContext().getBaseContext();
        boolean z = true;
        if (VERSION.SDK_INT < 23) {
            if (baseContext.checkPermission(str, Process.myPid(), Process.myUid()) != 0) {
                z = false;
            }
            promise.resolve(Boolean.valueOf(z));
            return;
        }
        if (baseContext.checkSelfPermission(str) != 0) {
            z = false;
        }
        promise.resolve(Boolean.valueOf(z));
    }

    public String getName() {
        return NAME;
    }

    public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.mCallbacks.get(i).invoke(iArr, getPermissionAwareActivity());
        this.mCallbacks.remove(i);
        if (this.mCallbacks.size() == 0) {
            return true;
        }
        return false;
    }

    public void requestMultiplePermissions(ReadableArray readableArray, final Promise promise) {
        final WritableNativeMap writableNativeMap = new WritableNativeMap();
        final ArrayList arrayList = new ArrayList();
        Context baseContext = getReactApplicationContext().getBaseContext();
        int i = 0;
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            String string = readableArray.getString(i2);
            String str = "granted";
            if (VERSION.SDK_INT < 23) {
                if (baseContext.checkPermission(string, Process.myPid(), Process.myUid()) != 0) {
                    str = "denied";
                }
                writableNativeMap.putString(string, str);
            } else if (baseContext.checkSelfPermission(string) == 0) {
                writableNativeMap.putString(string, str);
            } else {
                arrayList.add(string);
            }
            i++;
        }
        if (readableArray.size() == i) {
            promise.resolve(writableNativeMap);
            return;
        }
        try {
            PermissionAwareActivity permissionAwareActivity = getPermissionAwareActivity();
            this.mCallbacks.put(this.mRequestCode, new Callback(this) {
                public void invoke(Object... objArr) {
                    int[] iArr = objArr[0];
                    PermissionAwareActivity permissionAwareActivity = objArr[1];
                    for (int i = 0; i < arrayList.size(); i++) {
                        String str = (String) arrayList.get(i);
                        if (iArr.length > 0 && iArr[i] == 0) {
                            writableNativeMap.putString(str, "granted");
                        } else if (permissionAwareActivity.shouldShowRequestPermissionRationale(str)) {
                            writableNativeMap.putString(str, "denied");
                        } else {
                            writableNativeMap.putString(str, "never_ask_again");
                        }
                    }
                    promise.resolve(writableNativeMap);
                }
            });
            permissionAwareActivity.requestPermissions((String[]) arrayList.toArray(new String[0]), this.mRequestCode, this);
            this.mRequestCode++;
        } catch (IllegalStateException e2) {
            promise.reject((String) ERROR_INVALID_ACTIVITY, (Throwable) e2);
        }
    }

    public void requestPermission(final String str, final Promise promise) {
        Context baseContext = getReactApplicationContext().getBaseContext();
        String str2 = "granted";
        if (VERSION.SDK_INT < 23) {
            if (baseContext.checkPermission(str, Process.myPid(), Process.myUid()) != 0) {
                str2 = "denied";
            }
            promise.resolve(str2);
        } else if (baseContext.checkSelfPermission(str) == 0) {
            promise.resolve(str2);
        } else {
            try {
                PermissionAwareActivity permissionAwareActivity = getPermissionAwareActivity();
                this.mCallbacks.put(this.mRequestCode, new Callback(this) {
                    public void invoke(Object... objArr) {
                        int[] iArr = objArr[0];
                        if (iArr.length > 0 && iArr[0] == 0) {
                            promise.resolve("granted");
                        } else if (objArr[1].shouldShowRequestPermissionRationale(str)) {
                            promise.resolve("denied");
                        } else {
                            promise.resolve("never_ask_again");
                        }
                    }
                });
                permissionAwareActivity.requestPermissions(new String[]{str}, this.mRequestCode, this);
                this.mRequestCode++;
            } catch (IllegalStateException e2) {
                promise.reject((String) ERROR_INVALID_ACTIVITY, (Throwable) e2);
            }
        }
    }

    public void shouldShowRequestPermissionRationale(String str, Promise promise) {
        if (VERSION.SDK_INT < 23) {
            promise.resolve(Boolean.FALSE);
            return;
        }
        try {
            promise.resolve(Boolean.valueOf(getPermissionAwareActivity().shouldShowRequestPermissionRationale(str)));
        } catch (IllegalStateException e2) {
            promise.reject((String) ERROR_INVALID_ACTIVITY, (Throwable) e2);
        }
    }
}