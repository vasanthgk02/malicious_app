package com.facebook.react.modules.blob;

import android.util.Base64;
import com.facebook.fbreact.specs.NativeFileReaderModuleSpec;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import io.sentry.Attachment;

@ReactModule(name = "FileReaderModule")
public class FileReaderModule extends NativeFileReaderModuleSpec {
    public static final String ERROR_INVALID_BLOB = "ERROR_INVALID_BLOB";
    public static final String NAME = "FileReaderModule";

    public FileReaderModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private BlobModule getBlobModule(String str) {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            return (BlobModule) reactApplicationContextIfActiveOrWarn.getNativeModule(BlobModule.class);
        }
        return null;
    }

    public String getName() {
        return NAME;
    }

    public void readAsDataURL(ReadableMap readableMap, Promise promise) {
        BlobModule blobModule = getBlobModule("readAsDataURL");
        if (blobModule == null) {
            promise.reject((Throwable) new IllegalStateException("Could not get BlobModule from ReactApplicationContext"));
            return;
        }
        byte[] resolve = blobModule.resolve(readableMap.getString("blobId"), readableMap.getInt("offset"), readableMap.getInt(Response.SIZE));
        if (resolve == null) {
            promise.reject((String) ERROR_INVALID_BLOB, (String) "The specified blob is invalid");
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("data:");
            if (!readableMap.hasKey("type") || readableMap.getString("type").isEmpty()) {
                sb.append(Attachment.DEFAULT_CONTENT_TYPE);
            } else {
                sb.append(readableMap.getString("type"));
            }
            sb.append(";base64,");
            sb.append(Base64.encodeToString(resolve, 2));
            promise.resolve(sb.toString());
        } catch (Exception e2) {
            promise.reject((Throwable) e2);
        }
    }

    public void readAsText(ReadableMap readableMap, String str, Promise promise) {
        BlobModule blobModule = getBlobModule("readAsText");
        if (blobModule == null) {
            promise.reject((Throwable) new IllegalStateException("Could not get BlobModule from ReactApplicationContext"));
            return;
        }
        byte[] resolve = blobModule.resolve(readableMap.getString("blobId"), readableMap.getInt("offset"), readableMap.getInt(Response.SIZE));
        if (resolve == null) {
            promise.reject((String) ERROR_INVALID_BLOB, (String) "The specified blob is invalid");
            return;
        }
        try {
            promise.resolve(new String(resolve, str));
        } catch (Exception e2) {
            promise.reject((Throwable) e2);
        }
    }
}
