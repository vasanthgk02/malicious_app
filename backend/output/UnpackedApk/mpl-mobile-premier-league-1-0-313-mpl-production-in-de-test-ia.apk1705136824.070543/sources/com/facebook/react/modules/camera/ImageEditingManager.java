package com.facebook.react.modules.camera;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.fbreact.specs.NativeImageEditorSpec;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;

@ReactModule(name = "ImageEditingManager")
public class ImageEditingManager extends NativeImageEditorSpec {
    public static final int COMPRESS_QUALITY = 90;
    @SuppressLint({"InlinedApi"})
    public static final String[] EXIF_ATTRIBUTES = {"FNumber", "DateTime", "DateTimeDigitized", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "ImageLength", "ImageWidth", "ISOSpeedRatings", "Make", "Model", "Orientation", "SubSecTime", "SubSecTimeDigitized", "SubSecTimeOriginal", "WhiteBalance"};
    public static final List<String> LOCAL_URI_PREFIXES = Arrays.asList(new String[]{"file://", "content://"});
    public static final String NAME = "ImageEditingManager";
    public static final String TEMP_FILE_PREFIX = "ReactNative_cropped_image_";

    public static class CleanTask extends GuardedAsyncTask<Void, Void> {
        public final Context mContext;

        public CleanTask(ReactContext reactContext, AnonymousClass1 r2) {
            super(reactContext);
            this.mContext = reactContext;
        }

        public final void cleanDirectory(File file) {
            File[] listFiles = file.listFiles(new FilenameFilter(this) {
                public boolean accept(File file, String str) {
                    return str.startsWith(ImageEditingManager.TEMP_FILE_PREFIX);
                }
            });
            if (listFiles != null) {
                for (File delete : listFiles) {
                    delete.delete();
                }
            }
        }

        public void doInBackgroundGuarded(Object[] objArr) {
            Void[] voidArr = (Void[]) objArr;
            cleanDirectory(this.mContext.getCacheDir());
            File externalCacheDir = this.mContext.getExternalCacheDir();
            if (externalCacheDir != null) {
                cleanDirectory(externalCacheDir);
            }
        }
    }

    public static class CropTask extends GuardedAsyncTask<Void, Void> {
        public final boolean mAllowExternalStorage;
        public final Context mContext;
        public final Callback mError;
        public final int mHeight;
        public final Callback mSuccess;
        public int mTargetHeight = 0;
        public int mTargetWidth = 0;
        public final String mUri;
        public final int mWidth;
        public final int mX;
        public final int mY;

        public CropTask(ReactContext reactContext, String str, int i, int i2, int i3, int i4, boolean z, Callback callback, Callback callback2, AnonymousClass1 r10) {
            super(reactContext);
            if (i < 0 || i2 < 0 || i3 <= 0 || i4 <= 0) {
                throw new JSApplicationIllegalArgumentException(String.format("Invalid crop rectangle: [%d, %d, %d, %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}));
            }
            this.mContext = reactContext;
            this.mUri = str;
            this.mX = i;
            this.mY = i2;
            this.mWidth = i3;
            this.mHeight = i4;
            this.mAllowExternalStorage = z;
            this.mSuccess = callback;
            this.mError = callback2;
        }

        public final Bitmap crop(Options options) throws IOException {
            InputStream openBitmapInputStream = openBitmapInputStream();
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(openBitmapInputStream, false);
            try {
                return newInstance.decodeRegion(new Rect(this.mX, this.mY, this.mX + this.mWidth, this.mY + this.mHeight), options);
            } finally {
                openBitmapInputStream.close();
                newInstance.recycle();
            }
        }

        /* JADX INFO: finally extract failed */
        public final Bitmap cropAndResize(int i, int i2, Options options) throws IOException {
            float f2;
            float f3;
            float f4;
            float f5;
            int i3 = i;
            int i4 = i2;
            Options options2 = options;
            ImageOriginUtils.assertNotNull(options);
            Options options3 = new Options();
            options3.inJustDecodeBounds = true;
            InputStream openBitmapInputStream = openBitmapInputStream();
            try {
                BitmapFactory.decodeStream(openBitmapInputStream, null, options3);
                openBitmapInputStream.close();
                float f6 = (float) this.mWidth;
                float f7 = (float) this.mHeight;
                float f8 = (float) i3;
                float f9 = (float) i4;
                float f10 = f8 / f9;
                if (f6 / f7 > f10) {
                    f2 = f10 * f7;
                    f5 = ((f6 - f2) / 2.0f) + ((float) this.mX);
                    f4 = (float) this.mY;
                    f3 = f9 / f7;
                } else {
                    float f11 = f6 / f10;
                    float f12 = ((f7 - f11) / 2.0f) + ((float) this.mY);
                    float f13 = f8 / f6;
                    f2 = f6;
                    f5 = (float) this.mX;
                    f3 = f13;
                    float f14 = f11;
                    f4 = f12;
                    f7 = f14;
                }
                options2.inSampleSize = ImageEditingManager.getDecodeSampleSize(this.mWidth, this.mHeight, i3, i4);
                options3.inJustDecodeBounds = false;
                InputStream openBitmapInputStream2 = openBitmapInputStream();
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(openBitmapInputStream2, null, options2);
                    if (decodeStream != null) {
                        openBitmapInputStream2.close();
                        float f15 = f3 * ((float) options2.inSampleSize);
                        Matrix matrix = new Matrix();
                        matrix.setScale(f15, f15);
                        return Bitmap.createBitmap(decodeStream, (int) Math.floor((double) (f5 / ((float) options2.inSampleSize))), (int) Math.floor((double) (f4 / ((float) options2.inSampleSize))), (int) Math.floor((double) (f2 / ((float) options2.inSampleSize))), (int) Math.floor((double) (f7 / ((float) options2.inSampleSize))), matrix, true);
                    }
                    throw new IOException("Cannot decode bitmap: " + this.mUri);
                } catch (Throwable th) {
                    openBitmapInputStream2.close();
                    throw th;
                }
            } catch (Throwable th2) {
                Throwable th3 = th2;
                openBitmapInputStream.close();
                throw th3;
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:17|18|(1:20)(2:25|26)) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
            if (r4.mAllowExternalStorage != false) goto L_0x0038;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
            r2 = com.facebook.react.modules.camera.ImageEditingManager.access$400(r4.mContext, r2, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x006a, code lost:
            throw new java.lang.SecurityException("We couldn't create file in internal cache and external cache is disabled. Did you forget to pass allowExternalStorage=true?");
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0034 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void doInBackgroundGuarded(java.lang.Object[] r5) {
            /*
                r4 = this;
                java.lang.Void[] r5 = (java.lang.Void[]) r5
                r5 = 1
                r0 = 0
                android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x0073 }
                r1.<init>()     // Catch:{ Exception -> 0x0073 }
                int r2 = r4.mTargetWidth     // Catch:{ Exception -> 0x0073 }
                if (r2 <= 0) goto L_0x0013
                int r2 = r4.mTargetHeight     // Catch:{ Exception -> 0x0073 }
                if (r2 <= 0) goto L_0x0013
                r2 = 1
                goto L_0x0014
            L_0x0013:
                r2 = 0
            L_0x0014:
                if (r2 == 0) goto L_0x001f
                int r2 = r4.mTargetWidth     // Catch:{ Exception -> 0x0073 }
                int r3 = r4.mTargetHeight     // Catch:{ Exception -> 0x0073 }
                android.graphics.Bitmap r2 = r4.cropAndResize(r2, r3, r1)     // Catch:{ Exception -> 0x0073 }
                goto L_0x0023
            L_0x001f:
                android.graphics.Bitmap r2 = r4.crop(r1)     // Catch:{ Exception -> 0x0073 }
            L_0x0023:
                java.lang.String r1 = r1.outMimeType     // Catch:{ Exception -> 0x0073 }
                if (r1 == 0) goto L_0x006b
                boolean r3 = r1.isEmpty()     // Catch:{ Exception -> 0x0073 }
                if (r3 != 0) goto L_0x006b
                android.content.Context r3 = r4.mContext     // Catch:{ Exception -> 0x0034 }
                java.io.File r2 = com.facebook.react.modules.camera.ImageEditingManager.writeBitmapToInternalCache(r3, r2, r1)     // Catch:{ Exception -> 0x0034 }
                goto L_0x003e
            L_0x0034:
                boolean r3 = r4.mAllowExternalStorage     // Catch:{ Exception -> 0x0073 }
                if (r3 == 0) goto L_0x0063
                android.content.Context r3 = r4.mContext     // Catch:{ Exception -> 0x0073 }
                java.io.File r2 = com.facebook.react.modules.camera.ImageEditingManager.writeBitmapToExternalCache(r3, r2, r1)     // Catch:{ Exception -> 0x0073 }
            L_0x003e:
                java.lang.String r3 = "image/jpeg"
                boolean r1 = r1.equals(r3)     // Catch:{ Exception -> 0x0073 }
                if (r1 == 0) goto L_0x0051
                android.content.Context r1 = r4.mContext     // Catch:{ Exception -> 0x0073 }
                java.lang.String r3 = r4.mUri     // Catch:{ Exception -> 0x0073 }
                android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x0073 }
                com.facebook.react.modules.camera.ImageEditingManager.copyExif(r1, r3, r2)     // Catch:{ Exception -> 0x0073 }
            L_0x0051:
                com.facebook.react.bridge.Callback r1 = r4.mSuccess     // Catch:{ Exception -> 0x0073 }
                java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0073 }
                android.net.Uri r2 = android.net.Uri.fromFile(r2)     // Catch:{ Exception -> 0x0073 }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0073 }
                r3[r0] = r2     // Catch:{ Exception -> 0x0073 }
                r1.invoke(r3)     // Catch:{ Exception -> 0x0073 }
                goto L_0x0081
            L_0x0063:
                java.lang.SecurityException r1 = new java.lang.SecurityException     // Catch:{ Exception -> 0x0073 }
                java.lang.String r2 = "We couldn't create file in internal cache and external cache is disabled. Did you forget to pass allowExternalStorage=true?"
                r1.<init>(r2)     // Catch:{ Exception -> 0x0073 }
                throw r1     // Catch:{ Exception -> 0x0073 }
            L_0x006b:
                java.io.IOException r1 = new java.io.IOException     // Catch:{ Exception -> 0x0073 }
                java.lang.String r2 = "Could not determine MIME type"
                r1.<init>(r2)     // Catch:{ Exception -> 0x0073 }
                throw r1     // Catch:{ Exception -> 0x0073 }
            L_0x0073:
                r1 = move-exception
                com.facebook.react.bridge.Callback r2 = r4.mError
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.String r1 = r1.getMessage()
                r5[r0] = r1
                r2.invoke(r5)
            L_0x0081:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.camera.ImageEditingManager.CropTask.doInBackgroundGuarded(java.lang.Object[]):void");
        }

        public final InputStream openBitmapInputStream() throws IOException {
            InputStream inputStream;
            if (ImageEditingManager.isLocalUri(this.mUri)) {
                inputStream = this.mContext.getContentResolver().openInputStream(Uri.parse(this.mUri));
            } else {
                inputStream = ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(this.mUri).openConnection())).getInputStream();
            }
            if (inputStream != null) {
                return inputStream;
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Cannot open bitmap: ");
            outline73.append(this.mUri);
            throw new IOException(outline73.toString());
        }
    }

    public ImageEditingManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        new CleanTask(getReactApplicationContext(), null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public static void copyExif(Context context, Uri uri, File file) throws IOException {
        File fileFromUri = getFileFromUri(context, uri);
        if (fileFromUri == null) {
            FLog.w((String) "ReactNative", "Couldn't get real path for uri: " + uri);
            return;
        }
        ExifInterface exifInterface = new ExifInterface(fileFromUri.getAbsolutePath());
        ExifInterface exifInterface2 = new ExifInterface(file.getAbsolutePath());
        for (String str : EXIF_ATTRIBUTES) {
            String attribute = exifInterface.getAttribute(str);
            if (attribute != null) {
                exifInterface2.setAttribute(str, attribute);
            }
        }
        exifInterface2.saveAttributes();
    }

    public static File createTempFile(File file, String str) throws IOException {
        if (file != null) {
            return File.createTempFile(TEMP_FILE_PREFIX, getFileExtensionForType(str), file);
        }
        throw new IOException("No cache directory available");
    }

    public static CompressFormat getCompressFormatForType(String str) {
        if ("image/png".equals(str)) {
            return CompressFormat.PNG;
        }
        if ("image/webp".equals(str)) {
            return CompressFormat.WEBP;
        }
        return CompressFormat.JPEG;
    }

    public static int getDecodeSampleSize(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i2 > i3 || i > i4) {
            int i6 = i2 / 2;
            int i7 = i / 2;
            while (i7 / i5 >= i3 && i6 / i5 >= i4) {
                i5 *= 2;
            }
        }
        return i5;
    }

    public static String getFileExtensionForType(String str) {
        if ("image/png".equals(str)) {
            return ".png";
        }
        return "image/webp".equals(str) ? ".webp" : ".jpg";
    }

    public static File getFileFromUri(Context context, Uri uri) {
        if (uri.getScheme().equals("file")) {
            return new File(uri.getPath());
        }
        if (uri.getScheme().equals("content")) {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(0);
                        if (!TextUtils.isEmpty(string)) {
                            return new File(string);
                        }
                    }
                    query.close();
                } finally {
                    query.close();
                }
            }
        }
        return null;
    }

    public static boolean isLocalUri(String str) {
        for (String startsWith : LOCAL_URI_PREFIXES) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    public static File writeBitmapToExternalCache(Context context, Bitmap bitmap, String str) throws IOException {
        File createTempFile = createTempFile(context.getExternalCacheDir(), str);
        writeCompressedBitmapToFile(bitmap, str, createTempFile);
        return createTempFile;
    }

    public static File writeBitmapToInternalCache(Context context, Bitmap bitmap, String str) throws IOException {
        File createTempFile = createTempFile(context.getCacheDir(), str);
        writeCompressedBitmapToFile(bitmap, str, createTempFile);
        return createTempFile;
    }

    public static void writeCompressedBitmapToFile(Bitmap bitmap, String str, File file) throws IOException {
        bitmap.compress(getCompressFormatForType(str), 90, new FileOutputStream(file));
    }

    public void cropImage(String str, ReadableMap readableMap, Callback callback, Callback callback2) {
        ReadableMap readableMap2 = readableMap;
        ReadableMap readableMap3 = null;
        ReadableMap map = readableMap2.hasKey("offset") ? readableMap2.getMap("offset") : null;
        if (readableMap2.hasKey(Response.SIZE)) {
            readableMap3 = readableMap2.getMap(Response.SIZE);
        }
        boolean z = readableMap2.hasKey("allowExternalStorage") ? readableMap2.getBoolean("allowExternalStorage") : true;
        if (map == null || readableMap3 == null || !map.hasKey("x") || !map.hasKey("y") || !readableMap3.hasKey("width") || !readableMap3.hasKey("height")) {
            throw new JSApplicationIllegalArgumentException("Please specify offset and size");
        } else if (str == null || str.isEmpty()) {
            throw new JSApplicationIllegalArgumentException("Please specify a URI");
        } else {
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            int i = (int) map.getDouble("x");
            int i2 = (int) map.getDouble("y");
            int i3 = (int) readableMap3.getDouble("width");
            CropTask cropTask = r6;
            int i4 = (int) readableMap3.getDouble("height");
            String str2 = "height";
            String str3 = "width";
            CropTask cropTask2 = new CropTask(reactApplicationContext, str, i, i2, i3, i4, z, callback, callback2, null);
            if (readableMap2.hasKey("displaySize")) {
                ReadableMap map2 = readableMap2.getMap("displaySize");
                int i5 = (int) map2.getDouble(str3);
                int i6 = (int) map2.getDouble(str2);
                if (i5 <= 0 || i6 <= 0) {
                    throw new JSApplicationIllegalArgumentException(String.format("Invalid target size: [%d, %d]", new Object[]{Integer.valueOf(i5), Integer.valueOf(i6)}));
                }
                cropTask.mTargetWidth = i5;
                cropTask.mTargetHeight = i6;
            }
            cropTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public String getName() {
        return NAME;
    }

    public void onCatalystInstanceDestroy() {
        new CleanTask(getReactApplicationContext(), null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
