package com.mpl.androidapp.imagepicker;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Environment;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.PromiseImpl;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.react.PaymentCallBackListener;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import com.mpl.androidapp.utils.MLogger;
import com.netcore.android.SMTConfigConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import org.apache.pdfbox.pdmodel.interactive.form.PDChoice;

@ReactModule(name = "ImagePickerModule")
public class ImagePickerModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    public static final int CAMERA_PICKER_REQUEST = 61111;
    public static final String E_ACTIVITY_DOES_NOT_EXIST = "E_ACTIVITY_DOES_NOT_EXIST";
    public static final String E_CALLBACK_ERROR = "E_CALLBACK_ERROR";
    public static final String E_CAMERA_IS_NOT_AVAILABLE = "E_CAMERA_IS_NOT_AVAILABLE";
    public static final String E_CANNOT_LAUNCH_CAMERA = "E_CANNOT_LAUNCH_CAMERA";
    public static final String E_ERROR_WHILE_CLEANING_FILES = "E_ERROR_WHILE_CLEANING_FILES";
    public static final String E_FAILED_TO_OPEN_CAMERA = "E_FAILED_TO_OPEN_CAMERA";
    public static final String E_FAILED_TO_SHOW_PICKER = "E_FAILED_TO_SHOW_PICKER";
    public static final String E_NO_IMAGE_DATA_FOUND = "E_NO_IMAGE_DATA_FOUND";
    public static final String E_PERMISSIONS_MISSING = "E_PERMISSION_MISSING";
    public static final String E_PICKER_CANCELLED_KEY = "E_PICKER_CANCELLED";
    public static final String E_PICKER_CANCELLED_MSG = "User cancelled image selection";
    public static final int IMAGE_PICKER_REQUEST = 61110;
    public static final String TAG = "ImagePickerModule";
    public final String DEFAULT_TINT = "#424242";
    public final String DEFAULT_WIDGET_COLOR = "#03A9F4";
    public Compression compression = new Compression();
    public String cropperActiveWidgetColor = "#424242";
    public boolean cropperCircleOverlay = false;
    public String cropperStatusBarColor = "#424242";
    public String cropperToolbarColor = "#424242";
    public String cropperToolbarTitle = null;
    public boolean cropping = false;
    public boolean disableCropperColorSetters = false;
    public boolean enableRotationGesture = false;
    public boolean freeStyleCropEnabled = false;
    public int height = 0;
    public boolean hideBottomControls = false;
    public boolean includeBase64 = false;
    public boolean includeExif = false;
    public Uri mCameraCaptureURI;
    public String mCurrentMediaPath;
    public String mediaType = "any";
    public boolean multiple = false;
    public ReadableMap options;
    public PaymentCallBackListener paymentCallBackListener = new PaymentCallBackListener() {
        public boolean onBackPressed() {
            return false;
        }

        public void processResponce(Activity activity, int i, int i2, Intent intent) {
            MLogger.d(ImagePickerModule.TAG, "processResponce: ", Integer.valueOf(i), Integer.valueOf(i2));
            ImagePickerModule.this.processOnActivityResult(activity, i, i2, intent);
        }
    };
    public ReactApplicationContext reactContext;
    public ResultCollector resultCollector = new ResultCollector();
    public boolean showCropFrame = true;
    public boolean showCropGuidelines = true;
    public boolean useFrontCamera = false;
    public int width = 0;

    public ImagePickerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(this);
        this.reactContext = reactApplicationContext;
    }

    private void cameraPickerResult(Activity activity, int i, int i2, Intent intent) {
        MLogger.d(TAG, "cameraPickerResult: ");
        if (i2 == 0) {
            this.resultCollector.notifyProblem((String) "E_PICKER_CANCELLED", (String) "User cancelled image selection");
        } else if (i2 == -1) {
            Uri uri = this.mCameraCaptureURI;
            if (uri == null) {
                this.resultCollector.notifyProblem((String) "E_NO_IMAGE_DATA_FOUND", (String) "Cannot resolve image url");
                return;
            }
            try {
                this.resultCollector.setWaitCount(1);
                WritableMap selection = getSelection(activity, uri, true);
                if (selection != null) {
                    this.resultCollector.notifySuccess(selection);
                }
            } catch (Exception e2) {
                this.resultCollector.notifyProblem((String) "E_NO_IMAGE_DATA_FOUND", e2.getMessage());
            }
        }
    }

    private File createImageFile() throws IOException {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("image-");
        outline73.append(UUID.randomUUID().toString());
        String sb = outline73.toString();
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (!externalStoragePublicDirectory.exists() && !externalStoragePublicDirectory.isDirectory()) {
            externalStoragePublicDirectory.mkdirs();
        }
        File createTempFile = File.createTempFile(sb, ".jpg", externalStoragePublicDirectory);
        StringBuilder outline732 = GeneratedOutlineSupport.outline73("file:");
        outline732.append(createTempFile.getAbsolutePath());
        this.mCurrentMediaPath = outline732.toString();
        return createTempFile;
    }

    private File createVideoFile() throws IOException {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("video-");
        outline73.append(UUID.randomUUID().toString());
        String sb = outline73.toString();
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (!externalStoragePublicDirectory.exists() && !externalStoragePublicDirectory.isDirectory()) {
            externalStoragePublicDirectory.mkdirs();
        }
        File createTempFile = File.createTempFile(sb, ".mp4", externalStoragePublicDirectory);
        StringBuilder outline732 = GeneratedOutlineSupport.outline73("file:");
        outline732.append(createTempFile.getAbsolutePath());
        this.mCurrentMediaPath = outline732.toString();
        return createTempFile;
    }

    /* access modifiers changed from: private */
    public void deleteRecursive(File file) {
        if (file.isDirectory()) {
            for (File deleteRecursive : file.listFiles()) {
                deleteRecursive(deleteRecursive);
            }
        }
        file.delete();
    }

    private void getAsyncSelection(Activity activity, Uri uri, boolean z) throws Exception {
        String resolveRealPath = resolveRealPath(activity, uri, z);
        if (resolveRealPath == null || resolveRealPath.isEmpty()) {
            this.resultCollector.notifyProblem((String) "E_NO_IMAGE_DATA_FOUND", (String) "Cannot resolve asset path.");
            return;
        }
        String mimeType = getMimeType(resolveRealPath);
        if (mimeType == null || !mimeType.startsWith("video/")) {
            this.resultCollector.notifySuccess(getImage(activity, resolveRealPath));
        } else {
            getVideo(activity, resolveRealPath, mimeType);
        }
    }

    private String getBase64StringFromFile(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            byte[] bArr = new byte[8192];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                try {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private WritableMap getImage(Activity activity, String str) throws Exception {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        if (str.startsWith("http://") || str.startsWith("https://")) {
            throw new Exception("Cannot select remote files");
        }
        String path = this.compression.compressImage(this.options, str, validateImage(str)).getPath();
        Options validateImage = validateImage(path);
        long lastModified = new File(str).lastModified();
        writableNativeMap.putString("path", "file://" + path);
        writableNativeMap.putInt("width", validateImage.outWidth);
        writableNativeMap.putInt("height", validateImage.outHeight);
        writableNativeMap.putString("mime", validateImage.outMimeType);
        writableNativeMap.putInt(Response.SIZE, (int) new File(path).length());
        writableNativeMap.putString("modificationDate", String.valueOf(lastModified));
        if (this.includeBase64) {
            writableNativeMap.putString("data", getBase64StringFromFile(path));
        }
        if (this.includeExif) {
            try {
                writableNativeMap.putMap("exif", ExifExtractor.extract(str));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return writableNativeMap;
    }

    private String getMimeType(String str) {
        Uri fromFile = Uri.fromFile(new File(str));
        if (fromFile.getScheme().equals("content")) {
            return this.reactContext.getContentResolver().getType(fromFile);
        }
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(fromFile.toString());
        if (fileExtensionFromUrl != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl.toLowerCase());
        }
        return null;
    }

    private WritableMap getSelection(Activity activity, Uri uri, boolean z) throws Exception {
        String resolveRealPath = resolveRealPath(activity, uri, z);
        if (resolveRealPath == null || resolveRealPath.isEmpty()) {
            throw new Exception("Cannot resolve asset path.");
        }
        String mimeType = getMimeType(resolveRealPath);
        if (mimeType == null || !mimeType.startsWith("video/")) {
            return getImage(activity, resolveRealPath);
        }
        getVideo(activity, resolveRealPath, mimeType);
        return null;
    }

    /* access modifiers changed from: private */
    public String getTmpDir(Activity activity) {
        String str = activity.getCacheDir() + "/react-native-image-crop-picker";
        new File(str).mkdir();
        return str;
    }

    private void getVideo(Activity activity, String str, String str2) throws Exception {
        validateVideo(str);
        final String str3 = getTmpDir(activity) + "/" + UUID.randomUUID().toString() + ".mp4";
        final Activity activity2 = activity;
        final String str4 = str;
        final String str5 = str2;
        AnonymousClass7 r2 = new Runnable() {
            public void run() {
                ImagePickerModule.this.compression.compressVideo(activity2, ImagePickerModule.this.options, str4, str3, new PromiseImpl(new Callback() {
                    public void invoke(Object... objArr) {
                        String str = objArr[0];
                        try {
                            Bitmap access$500 = ImagePickerModule.this.validateVideo(str);
                            long lastModified = new File(str).lastModified();
                            WritableNativeMap writableNativeMap = new WritableNativeMap();
                            writableNativeMap.putInt("width", access$500.getWidth());
                            writableNativeMap.putInt("height", access$500.getHeight());
                            writableNativeMap.putString("mime", str5);
                            writableNativeMap.putInt(Response.SIZE, (int) new File(str).length());
                            writableNativeMap.putString("path", "file://" + str);
                            writableNativeMap.putString("modificationDate", String.valueOf(lastModified));
                            ImagePickerModule.this.resultCollector.notifySuccess(writableNativeMap);
                        } catch (Exception e2) {
                            ImagePickerModule.this.resultCollector.notifyProblem((String) "E_NO_IMAGE_DATA_FOUND", (Throwable) e2);
                        }
                    }
                }, new Callback() {
                    public void invoke(Object... objArr) {
                        WritableNativeMap writableNativeMap = objArr[0];
                        ImagePickerModule.this.resultCollector.notifyProblem(writableNativeMap.getString("code"), writableNativeMap.getString("message"));
                    }
                }));
            }
        };
        new Thread(r2).run();
    }

    private void imagePickerResult(Activity activity, int i, int i2, Intent intent) {
        MLogger.d(TAG, "imagePickerResult: ");
        if (i2 == 0) {
            this.resultCollector.notifyProblem((String) "E_PICKER_CANCELLED", (String) "User cancelled image selection");
        } else if (i2 == -1) {
            if (this.multiple) {
                ClipData clipData = intent.getClipData();
                if (clipData == null) {
                    try {
                        this.resultCollector.setWaitCount(1);
                        getAsyncSelection(activity, intent.getData(), false);
                    } catch (Exception e2) {
                        this.resultCollector.notifyProblem((String) "E_NO_IMAGE_DATA_FOUND", e2.getMessage());
                    }
                } else {
                    this.resultCollector.setWaitCount(clipData.getItemCount());
                    for (int i3 = 0; i3 < clipData.getItemCount(); i3++) {
                        getAsyncSelection(activity, clipData.getItemAt(i3).getUri(), false);
                    }
                }
            } else {
                Uri data = intent.getData();
                if (data == null) {
                    this.resultCollector.notifyProblem((String) "E_NO_IMAGE_DATA_FOUND", (String) "Cannot resolve image url");
                    return;
                }
                try {
                    getAsyncSelection(activity, data, false);
                } catch (Exception e3) {
                    this.resultCollector.notifyProblem((String) "E_NO_IMAGE_DATA_FOUND", e3.getMessage());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void initiateCamera(Activity activity) {
        File file;
        String str;
        try {
            if (this.mediaType.equals("video")) {
                str = "android.media.action.VIDEO_CAPTURE";
                file = createVideoFile();
            } else {
                str = "android.media.action.IMAGE_CAPTURE";
                file = createImageFile();
            }
            Intent intent = new Intent(str);
            Uri uriForFile = FileProvider.getUriForFile(activity, activity.getApplicationContext().getPackageName() + ".provider", file);
            this.mCameraCaptureURI = uriForFile;
            intent.putExtra("output", uriForFile);
            if (this.useFrontCamera) {
                intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
                intent.putExtra("android.intent.extras.LENS_FACING_FRONT", 1);
                intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
            }
            if (intent.resolveActivity(activity.getPackageManager()) == null) {
                this.resultCollector.notifyProblem((String) "E_CANNOT_LAUNCH_CAMERA", (String) "Cannot launch camera");
                return;
            }
            createListener();
            activity.startActivityForResult(intent, 61111);
        } catch (Exception e2) {
            this.resultCollector.notifyProblem((String) "E_FAILED_TO_OPEN_CAMERA", (Throwable) e2);
        }
    }

    /* access modifiers changed from: private */
    public void initiatePicker(Activity activity) {
        try {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            if (!this.cropping) {
                if (!this.mediaType.equals("photo")) {
                    if (this.mediaType.equals("video")) {
                        intent.setType("video/*");
                    } else {
                        intent.setType("*/*");
                        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
                    }
                    intent.setFlags(PDChoice.FLAG_COMMIT_ON_SEL_CHANGE);
                    intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", this.multiple);
                    intent.addCategory("android.intent.category.OPENABLE");
                    Intent createChooser = Intent.createChooser(intent, "Pick an image");
                    createListener();
                    activity.startActivityForResult(createChooser, 61110);
                }
            }
            intent.setType("image/*");
            intent.setFlags(PDChoice.FLAG_COMMIT_ON_SEL_CHANGE);
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", this.multiple);
            intent.addCategory("android.intent.category.OPENABLE");
            Intent createChooser2 = Intent.createChooser(intent, "Pick an image");
            createListener();
            activity.startActivityForResult(createChooser2, 61110);
        } catch (Exception e2) {
            this.resultCollector.notifyProblem((String) "E_FAILED_TO_SHOW_PICKER", (Throwable) e2);
        }
    }

    private boolean isCameraAvailable(Activity activity) {
        return activity.getPackageManager().hasSystemFeature("android.hardware.camera") || activity.getPackageManager().hasSystemFeature("android.hardware.camera.any");
    }

    public static boolean isValidRequestCode(int i) {
        switch (i) {
            case 61110:
            case 61111:
                return true;
            default:
                return false;
        }
    }

    private void permissionsCheck(Activity activity, final Promise promise, List<String> list, final Callable<Void> callable) {
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            if (ContextCompat.checkSelfPermission(activity, next) != 0) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            ((PermissionAwareActivity) activity).requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), 1, new PermissionListener() {
                public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                    if (i == 1) {
                        for (int i2 : iArr) {
                            if (i2 == -1) {
                                promise.reject((String) "E_PERMISSION_MISSING", (String) "Required permission missing");
                                return true;
                            }
                        }
                        try {
                            callable.call();
                        } catch (Exception e2) {
                            promise.reject((String) "E_CALLBACK_ERROR", (String) "Unknown error", (Throwable) e2);
                        }
                    }
                    return true;
                }
            });
            return;
        }
        try {
            callable.call();
        } catch (Exception e2) {
            promise.reject((String) "E_CALLBACK_ERROR", (String) "Unknown error", (Throwable) e2);
        }
    }

    /* access modifiers changed from: private */
    public void processOnActivityResult(Activity activity, int i, int i2, Intent intent) {
        if (i == 61110) {
            imagePickerResult(activity, i, i2, intent);
        } else if (i == 61111) {
            cameraPickerResult(activity, i, i2, intent);
        }
    }

    private String resolveRealPath(Activity activity, Uri uri, boolean z) throws IOException {
        if (z) {
            return Uri.parse(this.mCurrentMediaPath).getPath();
        }
        return RealPathUtil.getRealPathFromURI(activity, uri);
    }

    private void setConfiguration(ReadableMap readableMap) {
        this.mediaType = readableMap.hasKey("mediaType") ? readableMap.getString("mediaType") : "any";
        boolean z = true;
        this.multiple = readableMap.hasKey("multiple") && readableMap.getBoolean("multiple");
        this.includeBase64 = readableMap.hasKey("includeBase64") && readableMap.getBoolean("includeBase64");
        this.includeExif = readableMap.hasKey("includeExif") && readableMap.getBoolean("includeExif");
        this.width = readableMap.hasKey("width") ? readableMap.getInt("width") : 0;
        this.height = readableMap.hasKey("height") ? readableMap.getInt("height") : 0;
        this.cropping = readableMap.hasKey("cropping") && readableMap.getBoolean("cropping");
        String str = "#424242";
        this.cropperActiveWidgetColor = readableMap.hasKey("cropperActiveWidgetColor") ? readableMap.getString("cropperActiveWidgetColor") : str;
        this.cropperStatusBarColor = readableMap.hasKey("cropperStatusBarColor") ? readableMap.getString("cropperStatusBarColor") : str;
        if (readableMap.hasKey("cropperToolbarColor")) {
            str = readableMap.getString("cropperToolbarColor");
        }
        this.cropperToolbarColor = str;
        this.cropperToolbarTitle = readableMap.hasKey("cropperToolbarTitle") ? readableMap.getString("cropperToolbarTitle") : null;
        this.cropperCircleOverlay = readableMap.hasKey("cropperCircleOverlay") && readableMap.getBoolean("cropperCircleOverlay");
        this.freeStyleCropEnabled = readableMap.hasKey("freeStyleCropEnabled") && readableMap.getBoolean("freeStyleCropEnabled");
        this.showCropGuidelines = !readableMap.hasKey("showCropGuidelines") || readableMap.getBoolean("showCropGuidelines");
        this.showCropFrame = !readableMap.hasKey("showCropFrame") || readableMap.getBoolean("showCropFrame");
        this.hideBottomControls = readableMap.hasKey("hideBottomControls") && readableMap.getBoolean("hideBottomControls");
        this.enableRotationGesture = readableMap.hasKey("enableRotationGesture") && readableMap.getBoolean("enableRotationGesture");
        this.disableCropperColorSetters = readableMap.hasKey("disableCropperColorSetters") && readableMap.getBoolean("disableCropperColorSetters");
        if (!readableMap.hasKey("useFrontCamera") || !readableMap.getBoolean("useFrontCamera")) {
            z = false;
        }
        this.useFrontCamera = z;
        this.options = readableMap;
    }

    private Options validateImage(String str) throws Exception {
        Options options2 = new Options();
        options2.inJustDecodeBounds = true;
        options2.inPreferredConfig = Config.RGB_565;
        options2.inDither = true;
        BitmapFactory.decodeFile(str, options2);
        if (options2.outMimeType != null && options2.outWidth != 0 && options2.outHeight != 0) {
            return options2;
        }
        throw new Exception("Invalid image selected");
    }

    /* access modifiers changed from: private */
    public Bitmap validateVideo(String str) throws Exception {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
        if (frameAtTime != null) {
            return frameAtTime;
        }
        throw new Exception("Cannot retrieve video data");
    }

    @ReactMethod
    public void clean(final Promise promise) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject((String) "E_ACTIVITY_DOES_NOT_EXIST", (String) "Activity doesn't exist");
        } else {
            permissionsCheck(currentActivity, promise, Collections.singletonList(SMTConfigConstants.WRITE_STORAGE_PERMISSION_MF_KEY), new Callable<Void>() {
                public Void call() {
                    try {
                        File file = new File(this.getTmpDir(currentActivity));
                        if (file.exists()) {
                            this.deleteRecursive(file);
                            promise.resolve(null);
                            return null;
                        }
                        throw new Exception("File does not exist");
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        promise.reject((String) "E_ERROR_WHILE_CLEANING_FILES", e2.getMessage());
                    }
                }
            });
        }
    }

    @ReactMethod
    public void cleanSingle(final String str, final Promise promise) {
        if (str == null) {
            promise.reject((String) "E_ERROR_WHILE_CLEANING_FILES", (String) "Cannot cleanup empty path");
            return;
        }
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject((String) "E_ACTIVITY_DOES_NOT_EXIST", (String) "Activity doesn't exist");
        } else {
            permissionsCheck(currentActivity, promise, Collections.singletonList(SMTConfigConstants.WRITE_STORAGE_PERMISSION_MF_KEY), new Callable<Void>() {
                public Void call() throws Exception {
                    try {
                        String str = str;
                        if (str.startsWith("file://")) {
                            str = str.substring(7);
                        }
                        File file = new File(str);
                        if (file.exists()) {
                            this.deleteRecursive(file);
                            promise.resolve(null);
                            return null;
                        }
                        throw new Exception("File does not exist. Path: " + str);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        promise.reject((String) "E_ERROR_WHILE_CLEANING_FILES", e2.getMessage());
                    }
                }
            });
        }
    }

    public void createListener() {
        if (getCurrentActivity() != null && (getCurrentActivity() instanceof MPLReactContainerActivity) && ((MPLReactContainerActivity) getCurrentActivity()).getImagePickerCallBackListener() == null) {
            MLogger.d(TAG, "createListener:Setting listener ");
            ((MPLReactContainerActivity) getCurrentActivity()).setImagePickerListener(this.paymentCallBackListener);
        }
    }

    public String getName() {
        return TAG;
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        processOnActivityResult(activity, i, i2, intent);
    }

    public void onNewIntent(Intent intent) {
    }

    @ReactMethod
    public void openCamera(ReadableMap readableMap, Promise promise) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject((String) "E_ACTIVITY_DOES_NOT_EXIST", (String) "Activity doesn't exist");
        } else if (!isCameraAvailable(currentActivity)) {
            promise.reject((String) "E_CAMERA_IS_NOT_AVAILABLE", (String) "Camera not available");
        } else {
            setConfiguration(readableMap);
            this.resultCollector.setup(promise, false);
            permissionsCheck(currentActivity, promise, Arrays.asList(new String[]{"android.permission.CAMERA", SMTConfigConstants.WRITE_STORAGE_PERMISSION_MF_KEY}), new Callable<Void>() {
                public Void call() {
                    ImagePickerModule.this.initiateCamera(currentActivity);
                    return null;
                }
            });
        }
    }

    @ReactMethod
    public void openCropper(ReadableMap readableMap, Promise promise) {
        MLogger.d(TAG, "openCropper: ");
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject((String) "E_ACTIVITY_DOES_NOT_EXIST", (String) "Activity doesn't exist");
            return;
        }
        setConfiguration(readableMap);
        this.resultCollector.setup(promise, false);
        Uri.parse(readableMap.getString("path"));
        permissionsCheck(currentActivity, promise, Collections.singletonList(SMTConfigConstants.WRITE_STORAGE_PERMISSION_MF_KEY), new Callable<Void>() {
            public Void call() {
                return null;
            }
        });
    }

    @ReactMethod
    public void openPicker(ReadableMap readableMap, Promise promise) {
        MLogger.d(TAG, "openPicker: ");
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject((String) "E_ACTIVITY_DOES_NOT_EXIST", (String) "Activity doesn't exist");
            return;
        }
        setConfiguration(readableMap);
        this.resultCollector.setup(promise, this.multiple);
        permissionsCheck(currentActivity, promise, Collections.singletonList(SMTConfigConstants.WRITE_STORAGE_PERMISSION_MF_KEY), new Callable<Void>() {
            public Void call() {
                ImagePickerModule.this.initiatePicker(currentActivity);
                return null;
            }
        });
    }
}
