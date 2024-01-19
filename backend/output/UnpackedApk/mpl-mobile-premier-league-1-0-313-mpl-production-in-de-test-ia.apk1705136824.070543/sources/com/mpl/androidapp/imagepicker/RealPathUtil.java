package com.mpl.androidapp.imagepicker;

import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.notification.SMTNotificationConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class RealPathUtil {
    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r8v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: type inference failed for: r8v3 */
    /* JADX WARNING: type inference failed for: r8v4, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r8v5 */
    /* JADX WARNING: type inference failed for: r8v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0052  */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getDataColumn(android.content.Context r9, android.net.Uri r10, java.lang.String r11, java.lang.String[] r12) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String r1 = "_display_name"
            java.lang.String[] r4 = new java.lang.String[]{r0, r1}
            r8 = 0
            android.content.ContentResolver r2 = r9.getContentResolver()     // Catch:{ all -> 0x004f }
            r7 = 0
            r3 = r10
            r5 = r11
            r6 = r12
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x004f }
            if (r11 == 0) goto L_0x0049
            boolean r12 = r11.moveToFirst()     // Catch:{ all -> 0x0046 }
            if (r12 == 0) goto L_0x0049
            int r12 = r11.getColumnIndex(r0)     // Catch:{ all -> 0x0046 }
            r0 = -1
            if (r12 <= r0) goto L_0x0028
            java.lang.String r8 = r11.getString(r12)     // Catch:{ all -> 0x0046 }
        L_0x0028:
            if (r8 == 0) goto L_0x0032
            java.lang.String r9 = r11.getString(r12)     // Catch:{ all -> 0x0046 }
            r11.close()
            return r9
        L_0x0032:
            int r12 = r11.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x0046 }
            java.lang.String r12 = r11.getString(r12)     // Catch:{ all -> 0x0046 }
            java.io.File r9 = writeToFile(r9, r12, r10)     // Catch:{ all -> 0x0046 }
            java.lang.String r9 = r9.getAbsolutePath()     // Catch:{ all -> 0x0046 }
            r11.close()
            return r9
        L_0x0046:
            r9 = move-exception
            r8 = r11
            goto L_0x0050
        L_0x0049:
            if (r11 == 0) goto L_0x004e
            r11.close()
        L_0x004e:
            return r8
        L_0x004f:
            r9 = move-exception
        L_0x0050:
            if (r8 == 0) goto L_0x0055
            r8.close()
        L_0x0055:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.imagepicker.RealPathUtil.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    @TargetApi(19)
    public static String getPathToNonPrimaryVolume(Context context, String str) {
        File[] externalCacheDirs = context.getExternalCacheDirs();
        if (externalCacheDirs != null) {
            for (File file : externalCacheDirs) {
                if (file != null) {
                    String absolutePath = file.getAbsolutePath();
                    if (absolutePath != null) {
                        if (absolutePath.indexOf(str) != -1) {
                            return absolutePath.substring(0, r4) + str;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    @TargetApi(19)
    public static String getRealPathFromURI(Context context, Uri uri) throws IOException {
        Uri uri2 = null;
        if (0 == 0 || !DocumentsContract.isDocumentUri(context, uri)) {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                if (isGooglePhotosUri(uri)) {
                    return uri.getLastPathSegment();
                }
                return getDataColumn(context, uri, null, null);
            } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        } else if (isExternalStorageDocument(uri)) {
            String documentId = DocumentsContract.getDocumentId(uri);
            String[] split = documentId.split(":");
            if ("primary".equalsIgnoreCase(split[0])) {
                return Environment.getExternalStorageDirectory() + "/" + split[1];
            }
            int indexOf = documentId.indexOf(58, 1);
            String substring = documentId.substring(0, indexOf);
            String substring2 = documentId.substring(indexOf + 1);
            String pathToNonPrimaryVolume = getPathToNonPrimaryVolume(context, substring);
            if (pathToNonPrimaryVolume != null) {
                String outline52 = GeneratedOutlineSupport.outline52(pathToNonPrimaryVolume, "/", substring2);
                File file = new File(outline52);
                if (!file.exists() || !file.canRead()) {
                    return null;
                }
                return outline52;
            }
        } else if (isDownloadsDocument(uri)) {
            return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
        } else if (isMediaDocument(uri)) {
            String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
            String str = split2[0];
            if (SMTNotificationConstants.NOTIF_IMAGE_URL_KEY.equals(str)) {
                uri2 = Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(str)) {
                uri2 = Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(str)) {
                uri2 = Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return getDataColumn(context, uri2, "_id=?", new String[]{split2[1]});
        }
        return null;
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static File writeToFile(Context context, String str, Uri uri) {
        String str2 = context.getCacheDir() + "/react-native-image-crop-picker";
        new File(str2).mkdir();
        File file = new File(new File(str2), str.substring(str.lastIndexOf(47) + 1));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[8192];
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            while (true) {
                int read = openInputStream.read(bArr, 0, 8192);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
                fileOutputStream.flush();
            }
            fileOutputStream.close();
            openInputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return file;
    }
}
