package com.mpl.androidapp.react.modules;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.PermissionListener;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.Constant;
import java.util.HashMap;

@ReactModule(name = "PermissionsModule")
public class PermissionsModule extends ReactContextBaseJavaModule {
    public static final String TAG = "PermissionsModule";

    public PermissionsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    private void request(final Promise promise) {
        if (getCurrentActivity() != null) {
            ((MPLReactContainerActivity) getCurrentActivity()).requestPermissions(new String[]{"android.permission.READ_PHONE_STATE"}, Constant.REQUEST_ID_READ_PHONE_STATE, new PermissionListener() {
                public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                    boolean z = false;
                    if (i == 2001) {
                        if (iArr.length > 0) {
                            int i2 = iArr[0];
                            HashMap hashMap = new HashMap();
                            hashMap.put("Is Phone State", Boolean.valueOf(i2 == 0));
                            CleverTapAnalyticsUtils.pushProfileEvent(hashMap);
                            Promise promise = promise;
                            if (i2 == 0) {
                                z = true;
                            }
                            promise.resolve(Boolean.valueOf(z));
                        }
                        return true;
                    }
                    promise.reject((String) "fail", String.valueOf(false));
                    return true;
                }
            });
        }
    }

    @ReactMethod
    public void check(Promise promise) {
        if (getCurrentActivity() != null) {
            promise.resolve(Boolean.valueOf(getCurrentActivity().checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0));
        }
    }

    public String getName() {
        return TAG;
    }
}
