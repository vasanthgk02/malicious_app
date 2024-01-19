package com.mpl.androidapp.react.modules;

import android.content.Context;
import android.widget.Toast;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.mpl.androidapp.R;
import com.mpl.androidapp.utils.FileUtils;
import java.io.File;

@ReactModule(name = "FileHelperModule")
public class FileHelperModule extends ReactContextBaseJavaModule {
    public static final String TAG = "FileHelperModule";
    public final Context mContext;

    public FileHelperModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mContext = reactApplicationContext.getBaseContext();
    }

    private void showToast() {
        Context context = this.mContext;
        Toast.makeText(context, context.getString(R.string.apk_integrity_install_fail), 1).show();
    }

    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void isFileAvailable(String str, Promise promise) {
        promise.resolve(Boolean.valueOf(new File(str).exists()));
    }

    @ReactMethod
    public void isFileAvailableInAppExternalPath(String str, Promise promise) {
        promise.resolve(Boolean.valueOf(new File(FileUtils.getAppExternalDownloadStoragePath(this.mContext), str).exists()));
    }

    @ReactMethod
    public void isFileAvailableInAppInternalPath(String str, Promise promise) {
        promise.resolve(Boolean.valueOf(new File(this.mContext.getFilesDir(), str).exists()));
    }
}
