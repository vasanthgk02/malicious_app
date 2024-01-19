package com.RNFetchBlob;

import android.content.res.AssetFileDescriptor;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.GL20;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.PromiseImpl;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RNFetchBlobFS {
    public static HashMap<String, RNFetchBlobFS> fileStreams = new HashMap<>();
    public RCTDeviceEventEmitter emitter;
    public String encoding = "base64";
    public ReactApplicationContext mCtx;
    public OutputStream writeStreamInstance = null;

    public RNFetchBlobFS(ReactApplicationContext reactApplicationContext) {
        this.mCtx = reactApplicationContext;
        this.emitter = (RCTDeviceEventEmitter) reactApplicationContext.getJSModule(RCTDeviceEventEmitter.class);
    }

    public static void closeStream(String str, Callback callback) {
        try {
            OutputStream outputStream = fileStreams.get(str).writeStreamInstance;
            fileStreams.remove(str);
            outputStream.close();
            callback.invoke(new Object[0]);
        } catch (Exception e2) {
            callback.invoke(e2.getLocalizedMessage());
        }
    }

    public static void createFile(String str, String str2, String str3, Promise promise) {
        try {
            File file = new File(str);
            boolean createNewFile = file.createNewFile();
            if (str3.equals("uri")) {
                File file2 = new File(str2.replace("RNFetchBlob-file://", ""));
                if (!file2.exists()) {
                    promise.reject((String) "ENOENT", "Source file : " + str2 + " does not exist");
                    return;
                }
                FileInputStream fileInputStream = new FileInputStream(file2);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[GL20.GL_TEXTURE_MAG_FILTER];
                for (int read = fileInputStream.read(bArr); read > 0; read = fileInputStream.read(bArr)) {
                    fileOutputStream.write(bArr, 0, read);
                }
                fileInputStream.close();
                fileOutputStream.close();
            } else if (!createNewFile) {
                promise.reject((String) "EEXIST", "File `" + str + "` already exists");
                return;
            } else {
                new FileOutputStream(file).write(stringToBytes(str2, str3));
            }
            promise.resolve(str);
        } catch (Exception e2) {
            promise.reject((String) PromiseImpl.ERROR_DEFAULT_CODE, e2.getLocalizedMessage());
        }
    }

    public static void createFileASCII(String str, ReadableArray readableArray, Promise promise) {
        try {
            File file = new File(str);
            if (!file.createNewFile()) {
                promise.reject((String) "EEXIST", "File at path `" + str + "` already exists");
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                bArr[i] = (byte) readableArray.getInt(i);
            }
            fileOutputStream.write(bArr);
            promise.resolve(str);
        } catch (Exception e2) {
            promise.reject((String) PromiseImpl.ERROR_DEFAULT_CODE, e2.getLocalizedMessage());
        }
    }

    public static void deleteRecursive(File file) throws IOException {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File deleteRecursive : listFiles) {
                    deleteRecursive(deleteRecursive);
                }
            } else {
                throw new NullPointerException("Received null trying to list files of directory '" + file + "'");
            }
        }
        if (!file.delete()) {
            throw new IOException("Failed to delete '" + file + "'");
        }
    }

    public static void df(Callback callback) {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        WritableMap createMap = Arguments.createMap();
        createMap.putString("internal_free", String.valueOf(statFs.getFreeBytes()));
        createMap.putString("internal_total", String.valueOf(statFs.getTotalBytes()));
        StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getPath());
        createMap.putString("external_free", String.valueOf(statFs2.getFreeBytes()));
        createMap.putString("external_total", String.valueOf(statFs2.getTotalBytes()));
        callback.invoke(null, createMap);
    }

    public static void getSDCardApplicationDir(ReactApplicationContext reactApplicationContext, Promise promise) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                promise.resolve(reactApplicationContext.getExternalFilesDir(null).getParentFile().getAbsolutePath());
            } catch (Exception e2) {
                promise.reject((String) "RNFetchBlob.getSDCardApplicationDir", e2.getLocalizedMessage());
            }
        } else {
            promise.reject((String) "RNFetchBlob.getSDCardApplicationDir", (String) "External storage not mounted");
        }
    }

    public static void getSDCardDir(Promise promise) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            promise.resolve(Environment.getExternalStorageDirectory().getAbsolutePath());
        } else {
            promise.reject((String) "RNFetchBlob.getSDCardDir", (String) "External storage not mounted");
        }
    }

    public static Map<String, Object> getSystemfolders(ReactApplicationContext reactApplicationContext) {
        HashMap hashMap = new HashMap();
        hashMap.put("DocumentDir", reactApplicationContext.getFilesDir().getAbsolutePath());
        hashMap.put("CacheDir", reactApplicationContext.getCacheDir().getAbsolutePath());
        hashMap.put("DCIMDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath());
        hashMap.put("PictureDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath());
        hashMap.put("MusicDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getAbsolutePath());
        hashMap.put("DownloadDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath());
        hashMap.put("MovieDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath());
        hashMap.put("RingtoneDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES).getAbsolutePath());
        if (Environment.getExternalStorageState().equals("mounted")) {
            hashMap.put("SDCardDir", Environment.getExternalStorageDirectory().getAbsolutePath());
            File externalFilesDir = reactApplicationContext.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                hashMap.put("SDCardApplicationDir", externalFilesDir.getParentFile().getAbsolutePath());
            } else {
                hashMap.put("SDCardApplicationDir", "");
            }
        }
        hashMap.put("MainBundleDir", reactApplicationContext.getApplicationInfo().dataDir);
        return hashMap;
    }

    public static String getTmpPath(String str) {
        return RNFetchBlob.RCTContext.getFilesDir() + "/RNFetchBlobTmp_" + str;
    }

    public static void hash(String str, String str2, Promise promise) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("md5", "MD5");
            hashMap.put("sha1", CommonUtils.SHA1_INSTANCE);
            hashMap.put("sha224", "SHA-224");
            hashMap.put("sha256", "SHA-256");
            hashMap.put("sha384", "SHA-384");
            hashMap.put("sha512", "SHA-512");
            if (!hashMap.containsKey(str2)) {
                promise.reject((String) "EINVAL", "Invalid algorithm '" + str2 + "', must be one of md5, sha1, sha224, sha256, sha384, sha512");
                return;
            }
            File file = new File(str);
            if (file.isDirectory()) {
                promise.reject((String) "EISDIR", "Expecting a file but '" + str + "' is a directory");
            } else if (!file.exists()) {
                promise.reject((String) "ENOENT", "No such file '" + str + "'");
            } else {
                MessageDigest instance = MessageDigest.getInstance((String) hashMap.get(str2));
                FileInputStream fileInputStream = new FileInputStream(str);
                byte[] bArr = new byte[1048576];
                if (file.length() != 0) {
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        instance.update(bArr, 0, read);
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (byte valueOf : instance.digest()) {
                    sb.append(String.format("%02x", new Object[]{Byte.valueOf(valueOf)}));
                }
                promise.resolve(sb.toString());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            promise.reject((String) PromiseImpl.ERROR_DEFAULT_CODE, e2.getLocalizedMessage());
        }
    }

    public static InputStream inputStreamFromPath(String str) throws IOException {
        if (str.startsWith("bundle-assets://")) {
            return RNFetchBlob.RCTContext.getAssets().open(str.replace("bundle-assets://", ""));
        }
        return new FileInputStream(new File(str));
    }

    public static boolean isAsset(String str) {
        return str != null && str.startsWith("bundle-assets://");
    }

    public static boolean isPathExists(String str) {
        if (!str.startsWith("bundle-assets://")) {
            return new File(str).exists();
        }
        try {
            RNFetchBlob.RCTContext.getAssets().open(str.replace("bundle-assets://", ""));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static void ls(String str, Promise promise) {
        try {
            String normalizePath = normalizePath(str);
            File file = new File(normalizePath);
            if (!file.exists()) {
                promise.reject((String) "ENOENT", "No such file '" + normalizePath + "'");
            } else if (!file.isDirectory()) {
                promise.reject((String) "ENOTDIR", "Not a directory '" + normalizePath + "'");
            } else {
                String[] list = new File(normalizePath).list();
                WritableArray createArray = Arguments.createArray();
                for (String pushString : list) {
                    createArray.pushString(pushString);
                }
                promise.resolve(createArray);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            promise.reject((String) PromiseImpl.ERROR_DEFAULT_CODE, e2.getLocalizedMessage());
        }
    }

    public static void mkdir(String str, Promise promise) {
        File file = new File(str);
        if (file.exists()) {
            StringBuilder sb = new StringBuilder();
            sb.append(file.isDirectory() ? "Folder" : "File");
            sb.append(" '");
            sb.append(str);
            sb.append("' already exists");
            promise.reject((String) "EEXIST", sb.toString());
            return;
        }
        try {
            if (!file.mkdirs()) {
                promise.reject((String) PromiseImpl.ERROR_DEFAULT_CODE, "mkdir failed to create some or all directories in '" + str + "'");
                return;
            }
            promise.resolve(Boolean.TRUE);
        } catch (Exception e2) {
            promise.reject((String) PromiseImpl.ERROR_DEFAULT_CODE, e2.getLocalizedMessage());
        }
    }

    public static void mv(String str, String str2, Callback callback) {
        File file = new File(str);
        if (!file.exists()) {
            callback.invoke(GeneratedOutlineSupport.outline52("Source file at path `", str, "` does not exist"));
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    fileOutputStream.flush();
                    file.delete();
                    callback.invoke(new Object[0]);
                    return;
                }
            }
        } catch (FileNotFoundException unused) {
            callback.invoke("Source file not found.");
        } catch (Exception e2) {
            callback.invoke(e2.toString());
        }
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v4, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v5, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v6, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v7, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v8, types: [android.net.Uri] */
    /* JADX WARNING: type inference failed for: r0v9, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v10, types: [android.net.Uri] */
    /* JADX WARNING: type inference failed for: r0v11, types: [android.net.Uri] */
    /* JADX WARNING: type inference failed for: r0v12, types: [android.net.Uri] */
    /* JADX WARNING: type inference failed for: r0v13, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v14, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v16, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v17 */
    /* JADX WARNING: type inference failed for: r0v18 */
    /* JADX WARNING: type inference failed for: r0v19 */
    /* JADX WARNING: type inference failed for: r0v20 */
    /* JADX WARNING: type inference failed for: r0v21 */
    /* JADX WARNING: type inference failed for: r0v22 */
    /* JADX WARNING: type inference failed for: r0v23 */
    /* JADX WARNING: type inference failed for: r0v24 */
    /* JADX WARNING: type inference failed for: r0v25 */
    /* JADX WARNING: type inference failed for: r0v26 */
    /* JADX WARNING: type inference failed for: r0v27 */
    /* JADX WARNING: type inference failed for: r0v28 */
    /* JADX WARNING: type inference failed for: r0v29 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], java.lang.String, android.net.Uri]
      uses: [java.lang.String, android.net.Uri]
      mth insns count: 129
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String normalizePath(java.lang.String r9) {
        /*
            r0 = 0
            if (r9 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "\\w+\\:.*"
            boolean r1 = r9.matches(r1)
            if (r1 != 0) goto L_0x000d
            return r9
        L_0x000d:
            java.lang.String r1 = "file://"
            boolean r2 = r9.startsWith(r1)
            if (r2 == 0) goto L_0x001c
            java.lang.String r0 = ""
            java.lang.String r9 = r9.replace(r1, r0)
            return r9
        L_0x001c:
            android.net.Uri r2 = android.net.Uri.parse(r9)
            java.lang.String r1 = "bundle-assets://"
            boolean r1 = r9.startsWith(r1)
            if (r1 == 0) goto L_0x0029
            return r9
        L_0x0029:
            com.facebook.react.bridge.ReactApplicationContext r9 = com.RNFetchBlob.RNFetchBlob.RCTContext
            java.lang.String r1 = "com.google.android.apps.photos.content"
            java.lang.String r3 = "content"
            r4 = 1
            boolean r5 = android.provider.DocumentsContract.isDocumentUri(r9, r2)
            if (r5 == 0) goto L_0x016f
            java.lang.String r5 = r2.getAuthority()
            java.lang.String r6 = "com.android.externalstorage.documents"
            boolean r5 = r6.equals(r5)
            java.lang.String r6 = ":"
            r7 = 0
            if (r5 == 0) goto L_0x0073
            java.lang.String r9 = android.provider.DocumentsContract.getDocumentId(r2)
            java.lang.String[] r9 = r9.split(r6)
            r1 = r9[r7]
            java.lang.String r2 = "primary"
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x019d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()
            r0.append(r1)
            java.lang.String r1 = "/"
            r0.append(r1)
            r9 = r9[r4]
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            goto L_0x019d
        L_0x0073:
            java.lang.String r5 = r2.getAuthority()
            java.lang.String r8 = "com.android.providers.downloads.documents"
            boolean r5 = r8.equals(r5)
            if (r5 == 0) goto L_0x00af
            java.lang.String r1 = android.provider.DocumentsContract.getDocumentId(r2)     // Catch:{ Exception -> 0x019d }
            if (r1 == 0) goto L_0x0097
            java.lang.String r2 = "raw:/"
            boolean r2 = r1.startsWith(r2)     // Catch:{ Exception -> 0x019d }
            if (r2 == 0) goto L_0x0097
            android.net.Uri r9 = android.net.Uri.parse(r1)     // Catch:{ Exception -> 0x019d }
            java.lang.String r0 = r9.getPath()     // Catch:{ Exception -> 0x019d }
            goto L_0x019d
        L_0x0097:
            java.lang.String r2 = "content://downloads/public_downloads"
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x019d }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ Exception -> 0x019d }
            long r3 = r1.longValue()     // Catch:{ Exception -> 0x019d }
            android.net.Uri r1 = android.content.ContentUris.withAppendedId(r2, r3)     // Catch:{ Exception -> 0x019d }
            java.lang.String r0 = co.hyperverge.hypersnapsdk.c.k.getDataColumn(r9, r1, r0, r0)     // Catch:{ Exception -> 0x019d }
            goto L_0x019d
        L_0x00af:
            java.lang.String r5 = r2.getAuthority()
            java.lang.String r8 = "com.android.providers.media.documents"
            boolean r5 = r8.equals(r5)
            if (r5 == 0) goto L_0x00f3
            java.lang.String r1 = android.provider.DocumentsContract.getDocumentId(r2)
            java.lang.String[] r1 = r1.split(r6)
            r2 = r1[r7]
            java.lang.String r3 = "image"
            boolean r3 = r3.equals(r2)
            if (r3 == 0) goto L_0x00d0
            android.net.Uri r0 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            goto L_0x00e5
        L_0x00d0:
            java.lang.String r3 = "video"
            boolean r3 = r3.equals(r2)
            if (r3 == 0) goto L_0x00db
            android.net.Uri r0 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI
            goto L_0x00e5
        L_0x00db:
            java.lang.String r3 = "audio"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x00e5
            android.net.Uri r0 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        L_0x00e5:
            java.lang.String[] r2 = new java.lang.String[r4]
            r1 = r1[r4]
            r2[r7] = r1
            java.lang.String r1 = "_id=?"
            java.lang.String r0 = co.hyperverge.hypersnapsdk.c.k.getDataColumn(r9, r0, r1, r2)
            goto L_0x019d
        L_0x00f3:
            java.lang.String r4 = r2.getScheme()
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x0113
            java.lang.String r3 = r2.getAuthority()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x010d
            java.lang.String r0 = r2.getLastPathSegment()
            goto L_0x019d
        L_0x010d:
            java.lang.String r0 = co.hyperverge.hypersnapsdk.c.k.getDataColumn(r9, r2, r0, r0)
            goto L_0x019d
        L_0x0113:
            android.content.ContentResolver r1 = r9.getContentResolver()     // Catch:{ Exception -> 0x0166 }
            java.io.InputStream r7 = r1.openInputStream(r2)     // Catch:{ Exception -> 0x0166 }
            if (r7 == 0) goto L_0x019d
            android.content.ContentResolver r1 = r9.getContentResolver()     // Catch:{ Exception -> 0x0166 }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0166 }
            r1.moveToFirst()     // Catch:{ Exception -> 0x0166 }
            java.lang.String r2 = "_display_name"
            int r2 = r1.getColumnIndex(r2)     // Catch:{ Exception -> 0x0166 }
            if (r2 < 0) goto L_0x013c
            java.lang.String r2 = r1.getString(r2)     // Catch:{ Exception -> 0x0166 }
            r1.close()     // Catch:{ Exception -> 0x0166 }
            goto L_0x013d
        L_0x013c:
            r2 = r0
        L_0x013d:
            if (r2 == 0) goto L_0x019d
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0166 }
            java.io.File r9 = r9.getCacheDir()     // Catch:{ Exception -> 0x0166 }
            r1.<init>(r9, r2)     // Catch:{ Exception -> 0x0166 }
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0166 }
            r9.<init>(r1)     // Catch:{ Exception -> 0x0166 }
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x0166 }
        L_0x0151:
            int r3 = r7.read(r2)     // Catch:{ Exception -> 0x0166 }
            if (r3 <= 0) goto L_0x015b
            r9.write(r2)     // Catch:{ Exception -> 0x0166 }
            goto L_0x0151
        L_0x015b:
            r9.close()     // Catch:{ Exception -> 0x0166 }
            r7.close()     // Catch:{ Exception -> 0x0166 }
            java.lang.String r0 = r1.getAbsolutePath()     // Catch:{ Exception -> 0x0166 }
            goto L_0x019d
        L_0x0166:
            r9 = move-exception
            java.lang.String r9 = r9.toString()
            co.hyperverge.hypersnapsdk.c.k.emitWarningEvent(r9)
            goto L_0x019d
        L_0x016f:
            java.lang.String r4 = r2.getScheme()
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x018d
            java.lang.String r3 = r2.getAuthority()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0188
            java.lang.String r0 = r2.getLastPathSegment()
            goto L_0x019d
        L_0x0188:
            java.lang.String r0 = co.hyperverge.hypersnapsdk.c.k.getDataColumn(r9, r2, r0, r0)
            goto L_0x019d
        L_0x018d:
            java.lang.String r9 = r2.getScheme()
            java.lang.String r1 = "file"
            boolean r9 = r1.equalsIgnoreCase(r9)
            if (r9 == 0) goto L_0x019d
            java.lang.String r0 = r2.getPath()
        L_0x019d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.RNFetchBlobFS.normalizePath(java.lang.String):java.lang.String");
    }

    public static void removeSession(ReadableArray readableArray, final Callback callback) {
        new AsyncTask<ReadableArray, Integer, Integer>() {
            public Object doInBackground(Object[] objArr) {
                ReadableArray[] readableArrayArr = (ReadableArray[]) objArr;
                try {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < readableArrayArr[0].size(); i++) {
                        String string = readableArrayArr[0].getString(i);
                        File file = new File(string);
                        if (file.exists() && !file.delete()) {
                            arrayList.add(string);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        Callback.this.invoke(null, Boolean.TRUE);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Failed to delete: ");
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            sb.append((String) it.next());
                            sb.append(", ");
                        }
                        Callback.this.invoke(sb.toString());
                    }
                } catch (Exception e2) {
                    Callback.this.invoke(e2.getLocalizedMessage());
                }
                return Integer.valueOf(readableArrayArr[0].size());
            }
        }.execute(new ReadableArray[]{readableArray});
    }

    public static void slice(String str, String str2, int i, int i2, Promise promise) {
        try {
            String normalizePath = normalizePath(str);
            File file = new File(normalizePath);
            if (file.isDirectory()) {
                promise.reject((String) "EISDIR", "Expecting a file but '" + normalizePath + "' is a directory");
            } else if (!file.exists()) {
                promise.reject((String) "ENOENT", "No such file '" + normalizePath + "'");
            } else {
                int length = (int) file.length();
                int min = Math.min(length, i2) - i;
                FileInputStream fileInputStream = new FileInputStream(new File(normalizePath));
                FileOutputStream fileOutputStream = new FileOutputStream(new File(str2));
                int skip = (int) fileInputStream.skip((long) i);
                if (skip != i) {
                    promise.reject((String) PromiseImpl.ERROR_DEFAULT_CODE, "Skipped " + skip + " instead of the specified " + i + " bytes, size is " + length);
                    return;
                }
                byte[] bArr = new byte[GL20.GL_TEXTURE_MAG_FILTER];
                int i3 = 0;
                while (true) {
                    if (i3 >= min) {
                        break;
                    }
                    int read = fileInputStream.read(bArr, 0, GL20.GL_TEXTURE_MAG_FILTER);
                    int i4 = min - i3;
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, Math.min(i4, read));
                    i3 += read;
                }
                fileInputStream.close();
                fileOutputStream.flush();
                fileOutputStream.close();
                promise.resolve(str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            promise.reject((String) PromiseImpl.ERROR_DEFAULT_CODE, e2.getLocalizedMessage());
        }
    }

    public static void stat(String str, Callback callback) {
        try {
            String normalizePath = normalizePath(str);
            WritableMap statFile = statFile(normalizePath);
            if (statFile == null) {
                callback.invoke("failed to stat path `" + normalizePath + "` because it does not exist or it is not a folder", null);
                return;
            }
            callback.invoke(null, statFile);
        } catch (Exception e2) {
            callback.invoke(e2.getLocalizedMessage());
        }
    }

    public static WritableMap statFile(String str) {
        try {
            String normalizePath = normalizePath(str);
            WritableMap createMap = Arguments.createMap();
            if (isAsset(normalizePath)) {
                String replace = normalizePath.replace("bundle-assets://", "");
                AssetFileDescriptor openFd = RNFetchBlob.RCTContext.getAssets().openFd(replace);
                createMap.putString("filename", replace);
                createMap.putString("path", normalizePath);
                createMap.putString("type", "asset");
                createMap.putString(Response.SIZE, String.valueOf(openFd.getLength()));
                createMap.putInt("lastModified", 0);
            } else {
                File file = new File(normalizePath);
                if (!file.exists()) {
                    return null;
                }
                createMap.putString("filename", file.getName());
                createMap.putString("path", file.getPath());
                createMap.putString("type", file.isDirectory() ? "directory" : "file");
                createMap.putString(Response.SIZE, String.valueOf(file.length()));
                createMap.putString("lastModified", String.valueOf(file.lastModified()));
            }
            return createMap;
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] stringToBytes(String str, String str2) {
        if (str2.equalsIgnoreCase("ascii")) {
            return str.getBytes(Charset.forName("US-ASCII"));
        }
        if (str2.toLowerCase().contains("base64")) {
            return Base64.decode(str, 2);
        }
        if (str2.equalsIgnoreCase("utf8")) {
            return str.getBytes(Charset.forName("UTF-8"));
        }
        return str.getBytes(Charset.forName("US-ASCII"));
    }

    public static void unlink(String str, Callback callback) {
        try {
            deleteRecursive(new File(normalizePath(str)));
            callback.invoke(null, Boolean.TRUE);
        } catch (Exception e2) {
            callback.invoke(e2.getLocalizedMessage(), Boolean.FALSE);
        }
    }

    public static void writeArrayChunk(String str, ReadableArray readableArray, Callback callback) {
        try {
            OutputStream outputStream = fileStreams.get(str).writeStreamInstance;
            byte[] bArr = new byte[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                bArr[i] = (byte) readableArray.getInt(i);
            }
            outputStream.write(bArr);
            callback.invoke(new Object[0]);
        } catch (Exception e2) {
            callback.invoke(e2.getLocalizedMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c1 A[Catch:{ all -> 0x00e2, FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c6 A[Catch:{ all -> 0x00e2, FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeFile(java.lang.String r6, java.lang.String r7, java.lang.String r8, boolean r9, com.facebook.react.bridge.Promise r10) {
        /*
            java.lang.String r0 = "EUNSPECIFIED"
            java.lang.String r1 = "File '"
            java.lang.String r2 = "ENOENT"
            java.io.File r3 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            r3.<init>(r6)     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            java.io.File r4 = r3.getParentFile()     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            boolean r5 = r3.exists()     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            if (r5 != 0) goto L_0x005b
            if (r4 == 0) goto L_0x003d
            boolean r5 = r4.exists()     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            if (r5 != 0) goto L_0x003d
            boolean r4 = r4.mkdirs()     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            if (r4 != 0) goto L_0x003d
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            r7.<init>()     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            java.lang.String r8 = "Failed to create parent directory of '"
            r7.append(r8)     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            r7.append(r6)     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            java.lang.String r8 = "'"
            r7.append(r8)     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            java.lang.String r7 = r7.toString()     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            r10.reject(r0, r7)     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            return
        L_0x003d:
            boolean r4 = r3.createNewFile()     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            if (r4 != 0) goto L_0x005b
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            r7.<init>()     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            r7.append(r1)     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            r7.append(r6)     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            java.lang.String r8 = "' does not exist and could not be created"
            r7.append(r8)     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            java.lang.String r7 = r7.toString()     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            r10.reject(r2, r7)     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            return
        L_0x005b:
            java.lang.String r4 = "uri"
            boolean r4 = r7.equalsIgnoreCase(r4)     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            if (r4 == 0) goto L_0x00ca
            java.lang.String r7 = normalizePath(r8)     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            java.io.File r8 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            r8.<init>(r7)     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            boolean r4 = r8.exists()     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            if (r4 != 0) goto L_0x0094
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            r8.<init>()     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            java.lang.String r9 = "No such file '"
            r8.append(r9)     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            r8.append(r6)     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            java.lang.String r9 = "' ('"
            r8.append(r9)     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            r8.append(r7)     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            java.lang.String r7 = "')"
            r8.append(r7)     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            java.lang.String r7 = r8.toString()     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            r10.reject(r2, r7)     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            return
        L_0x0094:
            r7 = 10240(0x2800, float:1.4349E-41)
            byte[] r7 = new byte[r7]     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            r4 = 0
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ all -> 0x00bd }
            r5.<init>(r8)     // Catch:{ all -> 0x00bd }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ all -> 0x00b9 }
            r8.<init>(r3, r9)     // Catch:{ all -> 0x00b9 }
            r9 = 0
            r3 = 0
        L_0x00a5:
            int r4 = r5.read(r7)     // Catch:{ all -> 0x00b7 }
            if (r4 <= 0) goto L_0x00b0
            r8.write(r7, r9, r4)     // Catch:{ all -> 0x00b7 }
            int r3 = r3 + r4
            goto L_0x00a5
        L_0x00b0:
            r5.close()     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            r8.close()     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            goto L_0x00da
        L_0x00b7:
            r7 = move-exception
            goto L_0x00bb
        L_0x00b9:
            r7 = move-exception
            r8 = r4
        L_0x00bb:
            r4 = r5
            goto L_0x00bf
        L_0x00bd:
            r7 = move-exception
            r8 = r4
        L_0x00bf:
            if (r4 == 0) goto L_0x00c4
            r4.close()     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
        L_0x00c4:
            if (r8 == 0) goto L_0x00c9
            r8.close()     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
        L_0x00c9:
            throw r7     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
        L_0x00ca:
            byte[] r7 = stringToBytes(r8, r7)     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            r8.<init>(r3, r9)     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            r8.write(r7)     // Catch:{ all -> 0x00e2 }
            int r3 = r7.length     // Catch:{ all -> 0x00e2 }
            r8.close()     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
        L_0x00da:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            r10.resolve(r7)     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            goto L_0x0107
        L_0x00e2:
            r7 = move-exception
            r8.close()     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
            throw r7     // Catch:{ FileNotFoundException -> 0x00f0, Exception -> 0x00e7 }
        L_0x00e7:
            r6 = move-exception
            java.lang.String r6 = r6.getLocalizedMessage()
            r10.reject(r0, r6)
            goto L_0x0107
        L_0x00f0:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r1)
            r7.append(r6)
            java.lang.String r6 = "' does not exist and could not be created, or it is a directory"
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r10.reject(r2, r6)
        L_0x0107:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.RNFetchBlobFS.writeFile(java.lang.String, java.lang.String, java.lang.String, boolean, com.facebook.react.bridge.Promise):void");
    }

    public final void emitStreamEvent(String str, String str2, String str3) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("event", str2);
        createMap.putString("detail", str3);
        this.emitter.emit(str, createMap);
    }

    public final void emitStreamEvent(String str, String str2, String str3, String str4) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("event", str2);
        createMap.putString("code", str3);
        createMap.putString("detail", str4);
        this.emitter.emit(str, createMap);
    }

    public static void writeFile(String str, ReadableArray readableArray, boolean z, Promise promise) {
        FileOutputStream fileOutputStream;
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (!file.exists()) {
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                    promise.reject((String) "ENOTDIR", "Failed to create parent directory of '" + str + "'");
                    return;
                } else if (!file.createNewFile()) {
                    promise.reject((String) "ENOENT", "File '" + str + "' does not exist and could not be created");
                    return;
                }
            }
            fileOutputStream = new FileOutputStream(file, z);
            byte[] bArr = new byte[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                bArr[i] = (byte) readableArray.getInt(i);
            }
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            promise.resolve(Integer.valueOf(readableArray.size()));
        } catch (FileNotFoundException unused) {
            promise.reject((String) "ENOENT", "File '" + str + "' does not exist and could not be created");
        } catch (Exception e2) {
            promise.reject((String) PromiseImpl.ERROR_DEFAULT_CODE, e2.getLocalizedMessage());
        } catch (Throwable th) {
            fileOutputStream.close();
            throw th;
        }
    }
}
