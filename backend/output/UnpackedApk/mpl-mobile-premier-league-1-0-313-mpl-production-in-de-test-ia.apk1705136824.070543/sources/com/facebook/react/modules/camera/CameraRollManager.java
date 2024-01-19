package com.facebook.react.modules.camera;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore.Files;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeCameraRollManagerSpec;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import com.netcore.android.notification.SMTNotificationConstants;
import java.io.IOException;
import java.util.ArrayList;

@ReactModule(name = "CameraRollManager")
public class CameraRollManager extends NativeCameraRollManagerSpec {
    public static final String ASSET_TYPE_ALL = "All";
    public static final String ASSET_TYPE_PHOTOS = "Photos";
    public static final String ASSET_TYPE_VIDEOS = "Videos";
    public static final String ERROR_UNABLE_TO_FILTER = "E_UNABLE_TO_FILTER";
    public static final String ERROR_UNABLE_TO_LOAD = "E_UNABLE_TO_LOAD";
    public static final String ERROR_UNABLE_TO_LOAD_PERMISSION = "E_UNABLE_TO_LOAD_PERMISSION";
    public static final String ERROR_UNABLE_TO_SAVE = "E_UNABLE_TO_SAVE";
    public static final String NAME = "CameraRollManager";
    public static final String[] PROJECTION = {"_id", "mime_type", "bucket_display_name", "datetaken", "width", "height", "longitude", "latitude", "_data"};
    public static final String SELECTION_BUCKET = "bucket_display_name = ?";
    public static final String SELECTION_DATE_TAKEN = "datetaken < ?";
    public static final String SELECTION_MEDIA_SIZE = "_size < ?";

    public static class GetMediaTask extends GuardedAsyncTask<Void, Void> {
        public final String mAfter;
        public final String mAssetType;
        public final Context mContext;
        public final int mFirst;
        public final String mGroupName;
        public final Integer mMaxSize;
        public final ReadableArray mMimeTypes;
        public final Promise mPromise;

        public GetMediaTask(ReactContext reactContext, int i, String str, String str2, ReadableArray readableArray, String str3, Integer num, Promise promise, AnonymousClass1 r9) {
            super(reactContext);
            this.mContext = reactContext;
            this.mFirst = i;
            this.mAfter = str;
            this.mGroupName = str2;
            this.mMimeTypes = readableArray;
            this.mPromise = promise;
            this.mAssetType = str3;
            this.mMaxSize = num;
        }

        public void doInBackgroundGuarded(Object[] objArr) {
            Cursor query;
            Void[] voidArr = (Void[]) objArr;
            StringBuilder sb = new StringBuilder("1");
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(this.mAfter)) {
                sb.append(" AND datetaken < ?");
                arrayList.add(this.mAfter);
            }
            if (!TextUtils.isEmpty(this.mGroupName)) {
                sb.append(" AND bucket_display_name = ?");
                arrayList.add(this.mGroupName);
            }
            if (this.mMaxSize != null) {
                sb.append(" AND _size < ?");
                arrayList.add(this.mMaxSize.toString());
            }
            String str = this.mAssetType;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1905167199) {
                if (hashCode != -1732810888) {
                    if (hashCode == 65921 && str.equals("All")) {
                        c2 = 2;
                    }
                } else if (str.equals(CameraRollManager.ASSET_TYPE_VIDEOS)) {
                    c2 = 1;
                }
            } else if (str.equals(CameraRollManager.ASSET_TYPE_PHOTOS)) {
                c2 = 0;
            }
            if (c2 == 0) {
                sb.append(" AND media_type = 1");
            } else if (c2 == 1) {
                sb.append(" AND media_type = 3");
            } else if (c2 != 2) {
                Promise promise = this.mPromise;
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Invalid filter option: '");
                GeneratedOutlineSupport.outline103(outline73, this.mAssetType, "'. Expected one of '", CameraRollManager.ASSET_TYPE_PHOTOS, "', '");
                outline73.append(CameraRollManager.ASSET_TYPE_VIDEOS);
                outline73.append("' or '");
                outline73.append("All");
                outline73.append("'.");
                promise.reject((String) CameraRollManager.ERROR_UNABLE_TO_FILTER, outline73.toString());
                return;
            } else {
                sb.append(" AND media_type IN (3,1)");
            }
            ReadableArray readableArray = this.mMimeTypes;
            if (readableArray != null && readableArray.size() > 0) {
                sb.append(" AND mime_type IN (");
                for (int i = 0; i < this.mMimeTypes.size(); i++) {
                    sb.append("?,");
                    arrayList.add(this.mMimeTypes.getString(i));
                }
                sb.replace(sb.length() - 1, sb.length(), ")");
            }
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            ContentResolver contentResolver = this.mContext.getContentResolver();
            try {
                query = contentResolver.query(Files.getContentUri("external"), CameraRollManager.PROJECTION, sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]), "datetaken DESC, date_modified DESC LIMIT " + (this.mFirst + 1));
                if (query == null) {
                    this.mPromise.reject((String) CameraRollManager.ERROR_UNABLE_TO_LOAD, (String) "Could not get media");
                    return;
                }
                CameraRollManager.putEdges(contentResolver, query, writableNativeMap, this.mFirst);
                CameraRollManager.putPageInfo(query, writableNativeMap, this.mFirst);
                query.close();
                this.mPromise.resolve(writableNativeMap);
            } catch (SecurityException e2) {
                this.mPromise.reject((String) CameraRollManager.ERROR_UNABLE_TO_LOAD_PERMISSION, (String) "Could not get media: need READ_EXTERNAL_STORAGE permission", (Throwable) e2);
            } catch (Throwable th) {
                query.close();
                this.mPromise.resolve(writableNativeMap);
                throw th;
            }
        }
    }

    public static class SaveToCameraRoll extends GuardedAsyncTask<Void, Void> {
        public final Context mContext;
        public final Promise mPromise;
        public final Uri mUri;

        public SaveToCameraRoll(ReactContext reactContext, Uri uri, Promise promise) {
            super(reactContext);
            this.mContext = reactContext;
            this.mUri = uri;
            this.mPromise = promise;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0057 A[Catch:{ IOException -> 0x0126, all -> 0x0121 }] */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0073 A[SYNTHETIC, Splitter:B:20:0x0073] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void doInBackgroundGuarded(java.lang.Object[] r14) {
            /*
                r13 = this;
                java.lang.Void[] r14 = (java.lang.Void[]) r14
                java.lang.String r14 = "Could not close output channel"
                java.lang.String r0 = "Could not close input channel"
                java.lang.String r1 = "ReactNative"
                java.io.File r2 = new java.io.File
                android.net.Uri r3 = r13.mUri
                java.lang.String r3 = r3.getPath()
                r2.<init>(r3)
                r3 = 0
                android.net.Uri r4 = r13.mUri     // Catch:{ IOException -> 0x012f, all -> 0x012b }
                java.lang.String r4 = r4.getScheme()     // Catch:{ IOException -> 0x012f, all -> 0x012b }
                java.lang.String r5 = "http"
                boolean r5 = r4.equals(r5)     // Catch:{ IOException -> 0x012f, all -> 0x012b }
                if (r5 != 0) goto L_0x0035
                java.lang.String r5 = "https"
                boolean r4 = r4.equals(r5)     // Catch:{ IOException -> 0x012f, all -> 0x012b }
                if (r4 == 0) goto L_0x002b
                goto L_0x0035
            L_0x002b:
                java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ IOException -> 0x012f, all -> 0x012b }
                r4.<init>(r2)     // Catch:{ IOException -> 0x012f, all -> 0x012b }
                java.nio.channels.FileChannel r4 = r4.getChannel()     // Catch:{ IOException -> 0x012f, all -> 0x012b }
                goto L_0x0048
            L_0x0035:
                java.net.URL r4 = new java.net.URL     // Catch:{ IOException -> 0x012f, all -> 0x012b }
                android.net.Uri r5 = r13.mUri     // Catch:{ IOException -> 0x012f, all -> 0x012b }
                java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x012f, all -> 0x012b }
                r4.<init>(r5)     // Catch:{ IOException -> 0x012f, all -> 0x012b }
                java.io.InputStream r4 = com.google.firebase.perf.network.FirebasePerfUrlConnection.openStream(r4)     // Catch:{ IOException -> 0x012f, all -> 0x012b }
                java.nio.channels.ReadableByteChannel r4 = java.nio.channels.Channels.newChannel(r4)     // Catch:{ IOException -> 0x012f, all -> 0x012b }
            L_0x0048:
                java.lang.String r5 = android.os.Environment.DIRECTORY_DCIM     // Catch:{ IOException -> 0x0126, all -> 0x0121 }
                java.io.File r5 = android.os.Environment.getExternalStoragePublicDirectory(r5)     // Catch:{ IOException -> 0x0126, all -> 0x0121 }
                r5.mkdirs()     // Catch:{ IOException -> 0x0126, all -> 0x0121 }
                boolean r6 = r5.isDirectory()     // Catch:{ IOException -> 0x0126, all -> 0x0121 }
                if (r6 != 0) goto L_0x0073
                com.facebook.react.bridge.Promise r2 = r13.mPromise     // Catch:{ IOException -> 0x0126, all -> 0x0121 }
                java.lang.String r5 = "E_UNABLE_TO_LOAD"
                java.lang.String r6 = "External media storage directory not available"
                r2.reject(r5, r6)     // Catch:{ IOException -> 0x0126, all -> 0x0121 }
                if (r4 == 0) goto L_0x0158
                boolean r14 = r4.isOpen()
                if (r14 == 0) goto L_0x0158
                r4.close()     // Catch:{ IOException -> 0x006d }
                goto L_0x0158
            L_0x006d:
                r14 = move-exception
                com.facebook.common.logging.FLog.e(r1, r0, r14)
                goto L_0x0158
            L_0x0073:
                java.io.File r6 = new java.io.File     // Catch:{ IOException -> 0x0126, all -> 0x0121 }
                java.lang.String r7 = r2.getName()     // Catch:{ IOException -> 0x0126, all -> 0x0121 }
                r6.<init>(r5, r7)     // Catch:{ IOException -> 0x0126, all -> 0x0121 }
                java.lang.String r2 = r2.getName()     // Catch:{ IOException -> 0x0126, all -> 0x0121 }
                r7 = 46
                int r8 = r2.indexOf(r7)     // Catch:{ IOException -> 0x0126, all -> 0x0121 }
                r9 = 0
                if (r8 < 0) goto L_0x009c
                int r8 = r2.lastIndexOf(r7)     // Catch:{ IOException -> 0x0126, all -> 0x0121 }
                java.lang.String r8 = r2.substring(r9, r8)     // Catch:{ IOException -> 0x0126, all -> 0x0121 }
                int r7 = r2.lastIndexOf(r7)     // Catch:{ IOException -> 0x0126, all -> 0x0121 }
                java.lang.String r2 = r2.substring(r7)     // Catch:{ IOException -> 0x0126, all -> 0x0121 }
                r7 = r2
                r2 = r8
                goto L_0x009e
            L_0x009c:
                java.lang.String r7 = ""
            L_0x009e:
                r8 = 0
            L_0x009f:
                boolean r10 = r6.createNewFile()     // Catch:{ IOException -> 0x0126, all -> 0x0121 }
                if (r10 != 0) goto L_0x00c5
                java.io.File r6 = new java.io.File     // Catch:{ IOException -> 0x0126, all -> 0x0121 }
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0126, all -> 0x0121 }
                r10.<init>()     // Catch:{ IOException -> 0x0126, all -> 0x0121 }
                r10.append(r2)     // Catch:{ IOException -> 0x0126, all -> 0x0121 }
                java.lang.String r11 = "_"
                r10.append(r11)     // Catch:{ IOException -> 0x0126, all -> 0x0121 }
                int r11 = r8 + 1
                r10.append(r8)     // Catch:{ IOException -> 0x0126, all -> 0x0121 }
                r10.append(r7)     // Catch:{ IOException -> 0x0126, all -> 0x0121 }
                java.lang.String r8 = r10.toString()     // Catch:{ IOException -> 0x0126, all -> 0x0121 }
                r6.<init>(r5, r8)     // Catch:{ IOException -> 0x0126, all -> 0x0121 }
                r8 = r11
                goto L_0x009f
            L_0x00c5:
                java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0126, all -> 0x0121 }
                r2.<init>(r6)     // Catch:{ IOException -> 0x0126, all -> 0x0121 }
                java.nio.channels.FileChannel r2 = r2.getChannel()     // Catch:{ IOException -> 0x0126, all -> 0x0121 }
                r5 = 1048576(0x100000, float:1.469368E-39)
                java.nio.ByteBuffer r5 = java.nio.ByteBuffer.allocate(r5)     // Catch:{ IOException -> 0x011f }
            L_0x00d4:
                int r7 = r4.read(r5)     // Catch:{ IOException -> 0x011f }
                if (r7 <= 0) goto L_0x00e4
                r5.flip()     // Catch:{ IOException -> 0x011f }
                r2.write(r5)     // Catch:{ IOException -> 0x011f }
                r5.compact()     // Catch:{ IOException -> 0x011f }
                goto L_0x00d4
            L_0x00e4:
                r5.flip()     // Catch:{ IOException -> 0x011f }
            L_0x00e7:
                boolean r7 = r5.hasRemaining()     // Catch:{ IOException -> 0x011f }
                if (r7 == 0) goto L_0x00f1
                r2.write(r5)     // Catch:{ IOException -> 0x011f }
                goto L_0x00e7
            L_0x00f1:
                r4.close()     // Catch:{ IOException -> 0x011f }
                r2.close()     // Catch:{ IOException -> 0x011f }
                android.content.Context r5 = r13.mContext     // Catch:{ IOException -> 0x011f }
                r7 = 1
                java.lang.String[] r7 = new java.lang.String[r7]     // Catch:{ IOException -> 0x011f }
                java.lang.String r6 = r6.getAbsolutePath()     // Catch:{ IOException -> 0x011f }
                r7[r9] = r6     // Catch:{ IOException -> 0x011f }
                com.facebook.react.modules.camera.CameraRollManager$SaveToCameraRoll$1 r6 = new com.facebook.react.modules.camera.CameraRollManager$SaveToCameraRoll$1     // Catch:{ IOException -> 0x011f }
                r6.<init>()     // Catch:{ IOException -> 0x011f }
                android.media.MediaScannerConnection.scanFile(r5, r7, r3, r6)     // Catch:{ IOException -> 0x011f }
                boolean r3 = r4.isOpen()
                if (r3 == 0) goto L_0x0118
                r4.close()     // Catch:{ IOException -> 0x0114 }
                goto L_0x0118
            L_0x0114:
                r3 = move-exception
                com.facebook.common.logging.FLog.e(r1, r0, r3)
            L_0x0118:
                boolean r0 = r2.isOpen()
                if (r0 == 0) goto L_0x0158
                goto L_0x0150
            L_0x011f:
                r3 = move-exception
                goto L_0x0133
            L_0x0121:
                r2 = move-exception
                r12 = r3
                r3 = r2
                r2 = r12
                goto L_0x015a
            L_0x0126:
                r2 = move-exception
                r12 = r3
                r3 = r2
                r2 = r12
                goto L_0x0133
            L_0x012b:
                r2 = move-exception
                r4 = r2
                r2 = r3
                goto L_0x015d
            L_0x012f:
                r2 = move-exception
                r4 = r3
                r3 = r2
                r2 = r4
            L_0x0133:
                com.facebook.react.bridge.Promise r5 = r13.mPromise     // Catch:{ all -> 0x0159 }
                r5.reject(r3)     // Catch:{ all -> 0x0159 }
                if (r4 == 0) goto L_0x0148
                boolean r3 = r4.isOpen()
                if (r3 == 0) goto L_0x0148
                r4.close()     // Catch:{ IOException -> 0x0144 }
                goto L_0x0148
            L_0x0144:
                r3 = move-exception
                com.facebook.common.logging.FLog.e(r1, r0, r3)
            L_0x0148:
                if (r2 == 0) goto L_0x0158
                boolean r0 = r2.isOpen()
                if (r0 == 0) goto L_0x0158
            L_0x0150:
                r2.close()     // Catch:{ IOException -> 0x0154 }
                goto L_0x0158
            L_0x0154:
                r0 = move-exception
                com.facebook.common.logging.FLog.e(r1, r14, r0)
            L_0x0158:
                return
            L_0x0159:
                r3 = move-exception
            L_0x015a:
                r12 = r4
                r4 = r3
                r3 = r12
            L_0x015d:
                if (r3 == 0) goto L_0x016d
                boolean r5 = r3.isOpen()
                if (r5 == 0) goto L_0x016d
                r3.close()     // Catch:{ IOException -> 0x0169 }
                goto L_0x016d
            L_0x0169:
                r3 = move-exception
                com.facebook.common.logging.FLog.e(r1, r0, r3)
            L_0x016d:
                if (r2 == 0) goto L_0x017d
                boolean r0 = r2.isOpen()
                if (r0 == 0) goto L_0x017d
                r2.close()     // Catch:{ IOException -> 0x0179 }
                goto L_0x017d
            L_0x0179:
                r0 = move-exception
                com.facebook.common.logging.FLog.e(r1, r14, r0)
            L_0x017d:
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.camera.CameraRollManager.SaveToCameraRoll.doInBackgroundGuarded(java.lang.Object[]):void");
        }
    }

    public CameraRollManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public static void putBasicNodeInfo(Cursor cursor, WritableMap writableMap, int i, int i2, int i3) {
        writableMap.putString("type", cursor.getString(i));
        writableMap.putString("group_name", cursor.getString(i2));
        writableMap.putDouble("timestamp", ((double) cursor.getLong(i3)) / 1000.0d);
    }

    public static void putEdges(ContentResolver contentResolver, Cursor cursor, WritableMap writableMap, int i) {
        int i2;
        WritableNativeArray writableNativeArray;
        Cursor cursor2 = cursor;
        WritableNativeArray writableNativeArray2 = new WritableNativeArray();
        cursor.moveToFirst();
        int columnIndex = cursor2.getColumnIndex("_id");
        int columnIndex2 = cursor2.getColumnIndex("mime_type");
        int columnIndex3 = cursor2.getColumnIndex("bucket_display_name");
        int columnIndex4 = cursor2.getColumnIndex("datetaken");
        int columnIndex5 = cursor2.getColumnIndex("width");
        int columnIndex6 = cursor2.getColumnIndex("height");
        int columnIndex7 = cursor2.getColumnIndex("longitude");
        int columnIndex8 = cursor2.getColumnIndex("latitude");
        int columnIndex9 = cursor2.getColumnIndex("_data");
        int i3 = i;
        int i4 = 0;
        while (i4 < i3 && !cursor.isAfterLast()) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            WritableNativeMap writableNativeMap2 = new WritableNativeMap();
            WritableNativeMap writableNativeMap3 = writableNativeMap2;
            WritableNativeArray writableNativeArray3 = writableNativeArray2;
            WritableNativeMap writableNativeMap4 = writableNativeMap;
            int i5 = i4;
            int i6 = columnIndex;
            int i7 = columnIndex8;
            int i8 = columnIndex5;
            int i9 = columnIndex7;
            if (putImageInfo(contentResolver, cursor, writableNativeMap2, columnIndex, columnIndex5, columnIndex6, columnIndex9, columnIndex2)) {
                WritableNativeMap writableNativeMap5 = writableNativeMap3;
                putBasicNodeInfo(cursor2, writableNativeMap5, columnIndex2, columnIndex3, columnIndex4);
                putLocationInfo(cursor2, writableNativeMap5, i9, i7);
                writableNativeMap4.putMap("node", writableNativeMap5);
                writableNativeArray = writableNativeArray3;
                writableNativeArray.pushMap(writableNativeMap4);
                i2 = i5;
            } else {
                writableNativeArray = writableNativeArray3;
                i2 = i5 - 1;
            }
            cursor.moveToNext();
            i4 = i2 + 1;
            i3 = i;
            writableNativeArray2 = writableNativeArray;
            columnIndex8 = i7;
            columnIndex7 = i9;
            columnIndex = i6;
            columnIndex5 = i8;
        }
        writableMap.putArray("edges", writableNativeArray2);
    }

    public static boolean putImageInfo(ContentResolver contentResolver, Cursor cursor, WritableMap writableMap, int i, int i2, int i3, int i4, int i5) {
        AssetFileDescriptor openAssetFileDescriptor;
        MediaMetadataRetriever mediaMetadataRetriever;
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("file://");
        outline73.append(cursor.getString(i4));
        Uri parse = Uri.parse(outline73.toString());
        writableNativeMap.putString("uri", parse.toString());
        float f2 = (float) cursor.getInt(i2);
        float f3 = (float) cursor.getInt(i3);
        String string = cursor.getString(i5);
        if (string != null && string.startsWith("video")) {
            try {
                openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(parse, "r");
                mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(openAssetFileDescriptor.getFileDescriptor());
                if (f2 <= 0.0f || f3 <= 0.0f) {
                    try {
                        f2 = (float) Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                        f3 = (float) Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                    } catch (NumberFormatException e2) {
                        FLog.e((String) "ReactNative", "Number format exception occurred while trying to fetch video metadata for " + parse.toString(), (Throwable) e2);
                        mediaMetadataRetriever.release();
                        openAssetFileDescriptor.close();
                        return false;
                    }
                }
                writableNativeMap.putInt("playableDuration", Integer.parseInt(mediaMetadataRetriever.extractMetadata(9)) / 1000);
                mediaMetadataRetriever.release();
                openAssetFileDescriptor.close();
            } catch (Exception e3) {
                StringBuilder outline732 = GeneratedOutlineSupport.outline73("Could not get video metadata for ");
                outline732.append(parse.toString());
                FLog.e((String) "ReactNative", outline732.toString(), (Throwable) e3);
                return false;
            } catch (Throwable th) {
                mediaMetadataRetriever.release();
                openAssetFileDescriptor.close();
                throw th;
            }
        }
        if (f2 <= 0.0f || f3 <= 0.0f) {
            try {
                AssetFileDescriptor openAssetFileDescriptor2 = contentResolver.openAssetFileDescriptor(parse, "r");
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFileDescriptor(openAssetFileDescriptor2.getFileDescriptor(), null, options);
                float f4 = (float) options.outWidth;
                float f5 = (float) options.outHeight;
                openAssetFileDescriptor2.close();
                float f6 = f4;
                f3 = f5;
                f2 = f6;
            } catch (IOException e4) {
                StringBuilder outline733 = GeneratedOutlineSupport.outline73("Could not get width/height for ");
                outline733.append(parse.toString());
                FLog.e((String) "ReactNative", outline733.toString(), (Throwable) e4);
                return false;
            }
        }
        writableNativeMap.putDouble("width", (double) f2);
        writableNativeMap.putDouble("height", (double) f3);
        writableMap.putMap(SMTNotificationConstants.NOTIF_IMAGE_URL_KEY, writableNativeMap);
        return true;
    }

    public static void putLocationInfo(Cursor cursor, WritableMap writableMap, int i, int i2) {
        double d2 = cursor.getDouble(i);
        double d3 = cursor.getDouble(i2);
        if (d2 > 0.0d || d3 > 0.0d) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putDouble("longitude", d2);
            writableNativeMap.putDouble("latitude", d3);
            writableMap.putMap("location", writableNativeMap);
        }
    }

    public static void putPageInfo(Cursor cursor, WritableMap writableMap, int i) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putBoolean("has_next_page", i < cursor.getCount());
        if (i < cursor.getCount()) {
            cursor.moveToPosition(i - 1);
            writableNativeMap.putString("end_cursor", cursor.getString(cursor.getColumnIndex("datetaken")));
        }
        writableMap.putMap("page_info", writableNativeMap);
    }

    public void deletePhotos(ReadableArray readableArray, Promise promise) {
    }

    public String getName() {
        return NAME;
    }

    public void getPhotos(ReadableMap readableMap, Promise promise) {
        int i = readableMap.getInt("first");
        String string = readableMap.hasKey("after") ? readableMap.getString("after") : null;
        String string2 = readableMap.hasKey("groupName") ? readableMap.getString("groupName") : null;
        String string3 = readableMap.hasKey("assetType") ? readableMap.getString("assetType") : ASSET_TYPE_PHOTOS;
        Integer valueOf = readableMap.hasKey("maxSize") ? Integer.valueOf(readableMap.getInt("maxSize")) : null;
        ReadableArray array = readableMap.hasKey("mimeTypes") ? readableMap.getArray("mimeTypes") : null;
        if (!readableMap.hasKey("groupTypes")) {
            GetMediaTask getMediaTask = new GetMediaTask(getReactApplicationContext(), i, string, string2, array, string3, valueOf, promise, null);
            getMediaTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        throw new JSApplicationIllegalArgumentException("groupTypes is not supported on Android");
    }

    public void saveToCameraRoll(String str, String str2, Promise promise) {
        new SaveToCameraRoll(getReactApplicationContext(), Uri.parse(str), promise).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
