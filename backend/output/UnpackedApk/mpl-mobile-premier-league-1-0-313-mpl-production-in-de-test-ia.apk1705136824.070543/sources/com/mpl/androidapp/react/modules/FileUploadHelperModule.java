package com.mpl.androidapp.react.modules;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.mpl.androidapp.utils.MLogger;
import java.util.ArrayList;
import java.util.List;

@ReactModule(name = "FileUploadHelperModule")
public class FileUploadHelperModule extends ReactContextBaseJavaModule {
    public static final String TAG = "FileUploadHelperModule";
    public static final List<String> uploadingPaths = new ArrayList();

    public FileUploadHelperModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void uploadFile(String str, Promise promise) {
        MLogger.d(TAG, "uploadFile: ", str);
        promise.resolve(Boolean.TRUE);
    }
}
