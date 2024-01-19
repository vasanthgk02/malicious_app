package com.reactnativecommunity.webview;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.webkit.MimeTypeMap;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.mpl.androidapp.utils.Constant;
import com.netcore.android.SMTConfigConstants;
import com.netcore.android.notification.SMTNotificationConstants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

@ReactModule(name = "RNCWebView")
public class RNCWebViewModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    public static final int FILE_DOWNLOAD_PERMISSION_REQUEST = 1;
    public static final String MODULE_NAME = "RNCWebView";
    public static final int PICKER = 1;
    public static final int PICKER_LEGACY = 3;
    public static final ShouldOverrideUrlLoadingLock shouldOverrideUrlLoadingLock = new ShouldOverrideUrlLoadingLock();
    public Request downloadRequest;
    public ValueCallback<Uri[]> filePathCallback;
    public ValueCallback<Uri> filePathCallbackLegacy;
    public File outputImage;
    public File outputVideo;
    public PermissionListener webviewFileDownloaderPermissionListener = new PermissionListener() {
        public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
            if (i != 1) {
                return false;
            }
            if (iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(RNCWebViewModule.this.getCurrentActivity().getApplicationContext(), "Cannot download files as permission was denied. Please provide permission to write to storage, in order to download files.", 1).show();
            } else if (RNCWebViewModule.this.downloadRequest != null) {
                RNCWebViewModule.this.downloadFile();
            }
            return true;
        }
    };

    public enum MimeType {
        DEFAULT("*/*"),
        IMAGE(SMTNotificationConstants.NOTIF_IMAGE_URL_KEY),
        VIDEO("video");
        
        public final String value;

        /* access modifiers changed from: public */
        MimeType(String str) {
            this.value = str;
        }
    }

    public static class ShouldOverrideUrlLoadingLock {
        public int nextLockIdentifier = 1;
        public final HashMap<Integer, AtomicReference<ShouldOverrideCallbackState>> shouldOverrideLocks = new HashMap<>();

        public enum ShouldOverrideCallbackState {
            UNDECIDED,
            SHOULD_OVERRIDE,
            DO_NOT_OVERRIDE
        }

        public synchronized void removeLock(Integer num) {
            this.shouldOverrideLocks.remove(num);
        }
    }

    public RNCWebViewModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(this);
    }

    private Boolean acceptsImages(String str) {
        if (str.matches("\\.\\w+")) {
            str = getMimeTypeFromExtension(str.replace(".", ""));
        }
        return Boolean.valueOf(str.isEmpty() || str.toLowerCase().contains(MimeType.IMAGE.value));
    }

    private Boolean acceptsVideo(String str) {
        if (VERSION.SDK_INT < 23) {
            return Boolean.FALSE;
        }
        if (str.matches("\\.\\w+")) {
            str = getMimeTypeFromExtension(str.replace(".", ""));
        }
        return Boolean.valueOf(str.isEmpty() || str.toLowerCase().contains(MimeType.VIDEO.value));
    }

    private Boolean arrayContainsString(String[] strArr, String str) {
        for (String contains : strArr) {
            if (contains.contains(str)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private String[] getAcceptedMimeType(String[] strArr) {
        if (noAcceptTypesSet(strArr).booleanValue()) {
            return new String[]{MimeType.DEFAULT.value};
        }
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            if (str.matches("\\.\\w+")) {
                String mimeTypeFromExtension = getMimeTypeFromExtension(str.replace(".", ""));
                if (mimeTypeFromExtension != null) {
                    strArr2[i] = mimeTypeFromExtension;
                } else {
                    strArr2[i] = str;
                }
            } else {
                strArr2[i] = str;
            }
        }
        return strArr2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.File getCapturedFile(com.reactnativecommunity.webview.RNCWebViewModule.MimeType r7) throws java.io.IOException {
        /*
            r6 = this;
            int r7 = r7.ordinal()
            r0 = 1
            java.lang.String r1 = ""
            if (r7 == r0) goto L_0x0016
            r0 = 2
            if (r7 == r0) goto L_0x000f
            r7 = r1
            r0 = r7
            goto L_0x0022
        L_0x000f:
            java.lang.String r7 = android.os.Environment.DIRECTORY_MOVIES
            java.lang.String r0 = "video-"
            java.lang.String r1 = ".mp4"
            goto L_0x001c
        L_0x0016:
            java.lang.String r7 = android.os.Environment.DIRECTORY_PICTURES
            java.lang.String r0 = "image-"
            java.lang.String r1 = ".jpg"
        L_0x001c:
            r5 = r1
            r1 = r7
            r7 = r5
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x0022:
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            long r3 = java.lang.System.currentTimeMillis()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r2.append(r3)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 23
            if (r3 >= r4) goto L_0x0048
            java.io.File r7 = android.os.Environment.getExternalStoragePublicDirectory(r0)
            java.io.File r0 = new java.io.File
            r0.<init>(r7, r2)
            goto L_0x0055
        L_0x0048:
            com.facebook.react.bridge.ReactApplicationContext r0 = r6.getReactApplicationContext()
            r2 = 0
            java.io.File r0 = r0.getExternalFilesDir(r2)
            java.io.File r0 = java.io.File.createTempFile(r1, r7, r0)
        L_0x0055:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.webview.RNCWebViewModule.getCapturedFile(com.reactnativecommunity.webview.RNCWebViewModule$MimeType):java.io.File");
    }

    private Intent getFileChooserIntent(String str) {
        String access$200 = str.isEmpty() ? MimeType.DEFAULT.value : str;
        if (str.matches("\\.\\w+")) {
            access$200 = getMimeTypeFromExtension(str.replace(".", ""));
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(access$200);
        return intent;
    }

    private String getMimeTypeFromExtension(String str) {
        if (str != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        }
        return null;
    }

    private Uri getOutputUri(File file) {
        if (VERSION.SDK_INT < 23) {
            return Uri.fromFile(file);
        }
        String packageName = getReactApplicationContext().getPackageName();
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        return FileProvider.getUriForFile(reactApplicationContext, packageName + ".fileprovider", file);
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

    private Intent getPhotoIntent() {
        Intent intent;
        Exception e2;
        try {
            File capturedFile = getCapturedFile(MimeType.IMAGE);
            this.outputImage = capturedFile;
            Uri outputUri = getOutputUri(capturedFile);
            intent = new Intent("android.media.action.IMAGE_CAPTURE");
            try {
                intent.putExtra("output", outputUri);
            } catch (IOException | IllegalArgumentException e3) {
                e2 = e3;
            }
        } catch (IOException | IllegalArgumentException e4) {
            intent = null;
            e2 = e4;
            e2.printStackTrace();
            return intent;
        }
        return intent;
    }

    private Uri[] getSelectedFiles(Intent intent, int i) {
        if (intent == null) {
            return null;
        }
        if (intent.getClipData() != null) {
            int itemCount = intent.getClipData().getItemCount();
            Uri[] uriArr = new Uri[itemCount];
            for (int i2 = 0; i2 < itemCount; i2++) {
                uriArr[i2] = intent.getClipData().getItemAt(i2).getUri();
            }
            return uriArr;
        } else if (intent.getData() == null || i != -1) {
            return null;
        } else {
            return FileChooserParams.parseResult(i, intent);
        }
    }

    private Intent getVideoIntent() {
        Intent intent;
        Exception e2;
        try {
            File capturedFile = getCapturedFile(MimeType.VIDEO);
            this.outputVideo = capturedFile;
            Uri outputUri = getOutputUri(capturedFile);
            intent = new Intent("android.media.action.VIDEO_CAPTURE");
            try {
                intent.putExtra("output", outputUri);
            } catch (IOException | IllegalArgumentException e3) {
                e2 = e3;
            }
        } catch (IOException | IllegalArgumentException e4) {
            intent = null;
            e2 = e4;
            e2.printStackTrace();
            return intent;
        }
        return intent;
    }

    private Boolean noAcceptTypesSet(String[] strArr) {
        boolean z = true;
        if (!(strArr.length == 0 || (strArr.length == 1 && strArr[0] != null && strArr[0].length() == 0))) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public void downloadFile() {
        ((DownloadManager) getCurrentActivity().getBaseContext().getSystemService(Constant.DOWNLOAD)).enqueue(this.downloadRequest);
        Toast.makeText(getCurrentActivity().getApplicationContext(), "Downloading", 1).show();
    }

    public String getName() {
        return "RNCWebView";
    }

    public boolean grantFileDownloaderPermissions() {
        if (VERSION.SDK_INT > 28) {
            return true;
        }
        boolean z = ContextCompat.checkSelfPermission(getCurrentActivity(), SMTConfigConstants.WRITE_STORAGE_PERMISSION_MF_KEY) == 0;
        if (!z && VERSION.SDK_INT >= 23) {
            getPermissionAwareActivity().requestPermissions(new String[]{SMTConfigConstants.WRITE_STORAGE_PERMISSION_MF_KEY}, 1, this.webviewFileDownloaderPermissionListener);
        }
        return z;
    }

    @ReactMethod
    public void isFileUploadSupported(Promise promise) {
        promise.resolve(Boolean.TRUE);
    }

    public boolean needsCameraPermission() {
        try {
            if (!Arrays.asList(getCurrentActivity().getPackageManager().getPackageInfo(getReactApplicationContext().getPackageName(), 4096).requestedPermissions).contains("android.permission.CAMERA") || ContextCompat.checkSelfPermission(getCurrentActivity(), "android.permission.CAMERA") == 0) {
                return false;
            }
            return true;
        } catch (NameNotFoundException unused) {
            return true;
        }
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        if (this.filePathCallback != null || this.filePathCallbackLegacy != null) {
            File file = this.outputImage;
            boolean z = file != null && file.length() > 0;
            File file2 = this.outputVideo;
            boolean z2 = file2 != null && file2.length() > 0;
            if (i != 1) {
                if (i == 3) {
                    if (i2 != -1) {
                        this.filePathCallbackLegacy.onReceiveValue(null);
                    } else if (z) {
                        this.filePathCallbackLegacy.onReceiveValue(getOutputUri(this.outputImage));
                    } else if (z2) {
                        this.filePathCallbackLegacy.onReceiveValue(getOutputUri(this.outputVideo));
                    } else {
                        this.filePathCallbackLegacy.onReceiveValue(intent.getData());
                    }
                }
            } else if (i2 != -1) {
                ValueCallback<Uri[]> valueCallback = this.filePathCallback;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
            } else if (z) {
                this.filePathCallback.onReceiveValue(new Uri[]{getOutputUri(this.outputImage)});
            } else if (z2) {
                this.filePathCallback.onReceiveValue(new Uri[]{getOutputUri(this.outputVideo)});
            } else {
                this.filePathCallback.onReceiveValue(getSelectedFiles(intent, i2));
            }
            File file3 = this.outputImage;
            if (file3 != null && !z) {
                file3.delete();
            }
            File file4 = this.outputVideo;
            if (file4 != null && !z2) {
                file4.delete();
            }
            this.filePathCallback = null;
            this.filePathCallbackLegacy = null;
            this.outputImage = null;
            this.outputVideo = null;
        }
    }

    public void onNewIntent(Intent intent) {
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public void onShouldStartLoadWithRequestCallback(boolean z, int i) {
        AtomicReference atomicReference;
        ShouldOverrideUrlLoadingLock shouldOverrideUrlLoadingLock2 = shouldOverrideUrlLoadingLock;
        Integer valueOf = Integer.valueOf(i);
        synchronized (shouldOverrideUrlLoadingLock2) {
            atomicReference = shouldOverrideUrlLoadingLock2.shouldOverrideLocks.get(valueOf);
        }
        if (atomicReference != null) {
            synchronized (atomicReference) {
                atomicReference.set(z ? ShouldOverrideCallbackState.DO_NOT_OVERRIDE : ShouldOverrideCallbackState.SHOULD_OVERRIDE);
                atomicReference.notify();
            }
        }
    }

    public void setDownloadRequest(Request request) {
        this.downloadRequest = request;
    }

    public void startPhotoPickerIntent(ValueCallback<Uri> valueCallback, String str) {
        this.filePathCallbackLegacy = valueCallback;
        Intent createChooser = Intent.createChooser(getFileChooserIntent(str), "");
        ArrayList arrayList = new ArrayList();
        if (acceptsImages(str).booleanValue()) {
            Intent photoIntent = getPhotoIntent();
            if (photoIntent != null) {
                arrayList.add(photoIntent);
            }
        }
        if (acceptsVideo(str).booleanValue()) {
            Intent videoIntent = getVideoIntent();
            if (videoIntent != null) {
                arrayList.add(videoIntent);
            }
        }
        createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
        if (createChooser.resolveActivity(getCurrentActivity().getPackageManager()) != null) {
            getCurrentActivity().startActivityForResult(createChooser, 3);
        }
    }

    private Boolean acceptsImages(String[] strArr) {
        String[] acceptedMimeType = getAcceptedMimeType(strArr);
        return Boolean.valueOf(arrayContainsString(acceptedMimeType, MimeType.DEFAULT.value).booleanValue() || arrayContainsString(acceptedMimeType, MimeType.IMAGE.value).booleanValue());
    }

    private Boolean acceptsVideo(String[] strArr) {
        if (VERSION.SDK_INT < 23) {
            return Boolean.FALSE;
        }
        String[] acceptedMimeType = getAcceptedMimeType(strArr);
        return Boolean.valueOf(arrayContainsString(acceptedMimeType, MimeType.DEFAULT.value).booleanValue() || arrayContainsString(acceptedMimeType, MimeType.VIDEO.value).booleanValue());
    }

    private Intent getFileChooserIntent(String[] strArr, boolean z) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(MimeType.DEFAULT.value);
        intent.putExtra("android.intent.extra.MIME_TYPES", getAcceptedMimeType(strArr));
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", z);
        return intent;
    }

    public boolean startPhotoPickerIntent(ValueCallback<Uri[]> valueCallback, String[] strArr, boolean z) {
        this.filePathCallback = valueCallback;
        ArrayList arrayList = new ArrayList();
        if (!needsCameraPermission()) {
            if (acceptsImages(strArr).booleanValue()) {
                Intent photoIntent = getPhotoIntent();
                if (photoIntent != null) {
                    arrayList.add(photoIntent);
                }
            }
            if (acceptsVideo(strArr).booleanValue()) {
                Intent videoIntent = getVideoIntent();
                if (videoIntent != null) {
                    arrayList.add(videoIntent);
                }
            }
        }
        Intent fileChooserIntent = getFileChooserIntent(strArr, z);
        Intent intent = new Intent("android.intent.action.CHOOSER");
        intent.putExtra("android.intent.extra.INTENT", fileChooserIntent);
        intent.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
        if (intent.resolveActivity(getCurrentActivity().getPackageManager()) != null) {
            getCurrentActivity().startActivityForResult(intent, 1);
        }
        return true;
    }
}
