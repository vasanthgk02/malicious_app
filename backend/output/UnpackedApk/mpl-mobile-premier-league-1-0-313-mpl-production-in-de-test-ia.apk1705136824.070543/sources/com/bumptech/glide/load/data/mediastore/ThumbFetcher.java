package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ThumbFetcher implements DataFetcher<InputStream> {
    public InputStream inputStream;
    public final Uri mediaStoreImageUri;
    public final ThumbnailStreamOpener opener;

    public static class ImageThumbnailQuery implements ThumbnailQuery {
        public static final String[] PATH_PROJECTION = {"_data"};
        public final ContentResolver contentResolver;

        public ImageThumbnailQuery(ContentResolver contentResolver2) {
            this.contentResolver = contentResolver2;
        }

        public Cursor query(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.contentResolver.query(Thumbnails.EXTERNAL_CONTENT_URI, PATH_PROJECTION, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, null);
        }
    }

    public static class VideoThumbnailQuery implements ThumbnailQuery {
        public static final String[] PATH_PROJECTION = {"_data"};
        public final ContentResolver contentResolver;

        public VideoThumbnailQuery(ContentResolver contentResolver2) {
            this.contentResolver = contentResolver2;
        }

        public Cursor query(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.contentResolver.query(Video.Thumbnails.EXTERNAL_CONTENT_URI, PATH_PROJECTION, "kind = 1 AND video_id = ?", new String[]{lastPathSegment}, null);
        }
    }

    public ThumbFetcher(Uri uri, ThumbnailStreamOpener thumbnailStreamOpener) {
        this.mediaStoreImageUri = uri;
        this.opener = thumbnailStreamOpener;
    }

    public static ThumbFetcher build(Context context, Uri uri, ThumbnailQuery thumbnailQuery) {
        return new ThumbFetcher(uri, new ThumbnailStreamOpener(Glide.get(context).getRegistry().getImageHeaderParsers(), thumbnailQuery, Glide.get(context).getArrayPool(), context.getContentResolver()));
    }

    public void cancel() {
    }

    public void cleanup() {
        InputStream inputStream2 = this.inputStream;
        if (inputStream2 != null) {
            try {
                inputStream2.close();
            } catch (IOException unused) {
            }
        }
    }

    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    public void loadData(Priority priority, DataCallback<? super InputStream> dataCallback) {
        try {
            InputStream openThumbInputStream = openThumbInputStream();
            this.inputStream = openThumbInputStream;
            dataCallback.onDataReady(openThumbInputStream);
        } catch (FileNotFoundException e2) {
            boolean isLoggable = Log.isLoggable("MediaStoreThumbFetcher", 3);
            dataCallback.onLoadFailed(e2);
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Throwable, java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v5, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r7v6 */
    /* JADX WARNING: type inference failed for: r6v4, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r6v6 */
    /* JADX WARNING: type inference failed for: r6v8, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v10, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r7v11 */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:17|18|(1:20)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:54|55|(1:57)|(2:59|60)) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        if (r6 != 0) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0030, code lost:
        if (android.util.Log.isLoggable("ThumbStreamOpener", 3) != false) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0032, code lost:
        "Failed to query for thumbnail for Uri: " + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0042, code lost:
        if (r6 != 0) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0047, code lost:
        r7 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00a0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a6, code lost:
        if (android.util.Log.isLoggable("ThumbStreamOpener", 3) != false) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00a8, code lost:
        "Failed to open uri: " + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00be, code lost:
        if (r3 != 0) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00c3, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00f9, code lost:
        r3.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x002c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x00a2 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v0, types: [java.lang.Throwable, java.io.InputStream]
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY]]
      uses: [java.lang.Throwable, ?[int, boolean, OBJECT, ARRAY, byte, short, char], java.io.InputStream, ?[OBJECT, ARRAY]]
      mth insns count: 101
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.io.InputStream openThumbInputStream() throws java.io.FileNotFoundException {
        /*
            r12 = this;
            java.lang.String r0 = "ThumbStreamOpener"
            com.bumptech.glide.load.data.mediastore.ThumbnailStreamOpener r1 = r12.opener
            android.net.Uri r2 = r12.mediaStoreImageUri
            r3 = 0
            if (r1 == 0) goto L_0x00fd
            r4 = 0
            r5 = 3
            com.bumptech.glide.load.data.mediastore.ThumbnailQuery r6 = r1.query     // Catch:{ SecurityException -> 0x002b, all -> 0x0028 }
            android.database.Cursor r6 = r6.query(r2)     // Catch:{ SecurityException -> 0x002b, all -> 0x0028 }
            if (r6 == 0) goto L_0x0025
            boolean r7 = r6.moveToFirst()     // Catch:{ SecurityException -> 0x002c }
            if (r7 == 0) goto L_0x0025
            java.lang.String r7 = r6.getString(r4)     // Catch:{ SecurityException -> 0x002c }
            r6.close()
            goto L_0x0048
        L_0x0021:
            r0 = move-exception
            r3 = r6
            goto L_0x00f7
        L_0x0025:
            if (r6 == 0) goto L_0x0047
            goto L_0x0044
        L_0x0028:
            r0 = move-exception
            goto L_0x00f7
        L_0x002b:
            r6 = r3
        L_0x002c:
            boolean r7 = android.util.Log.isLoggable(r0, r5)     // Catch:{ all -> 0x0021 }
            if (r7 == 0) goto L_0x0042
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0021 }
            r7.<init>()     // Catch:{ all -> 0x0021 }
            java.lang.String r8 = "Failed to query for thumbnail for Uri: "
            r7.append(r8)     // Catch:{ all -> 0x0021 }
            r7.append(r2)     // Catch:{ all -> 0x0021 }
            r7.toString()     // Catch:{ all -> 0x0021 }
        L_0x0042:
            if (r6 == 0) goto L_0x0047
        L_0x0044:
            r6.close()
        L_0x0047:
            r7 = r3
        L_0x0048:
            boolean r6 = android.text.TextUtils.isEmpty(r7)
            if (r6 == 0) goto L_0x0050
        L_0x004e:
            r1 = r3
            goto L_0x0081
        L_0x0050:
            com.bumptech.glide.load.data.mediastore.FileService r6 = r1.service
            if (r6 == 0) goto L_0x00f6
            java.io.File r6 = new java.io.File
            r6.<init>(r7)
            com.bumptech.glide.load.data.mediastore.FileService r7 = r1.service
            if (r7 == 0) goto L_0x00f5
            boolean r7 = r6.exists()
            if (r7 == 0) goto L_0x0074
            r7 = 0
            com.bumptech.glide.load.data.mediastore.FileService r9 = r1.service
            if (r9 == 0) goto L_0x0073
            long r9 = r6.length()
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 >= 0) goto L_0x0074
            r4 = 1
            goto L_0x0074
        L_0x0073:
            throw r3
        L_0x0074:
            if (r4 != 0) goto L_0x0077
            goto L_0x004e
        L_0x0077:
            android.net.Uri r4 = android.net.Uri.fromFile(r6)
            android.content.ContentResolver r1 = r1.contentResolver     // Catch:{ NullPointerException -> 0x00cf }
            java.io.InputStream r1 = r1.openInputStream(r4)     // Catch:{ NullPointerException -> 0x00cf }
        L_0x0081:
            r2 = -1
            if (r1 == 0) goto L_0x00c5
            com.bumptech.glide.load.data.mediastore.ThumbnailStreamOpener r4 = r12.opener
            android.net.Uri r6 = r12.mediaStoreImageUri
            if (r4 == 0) goto L_0x00c4
            android.content.ContentResolver r7 = r4.contentResolver     // Catch:{ IOException | NullPointerException -> 0x00a2 }
            java.io.InputStream r3 = r7.openInputStream(r6)     // Catch:{ IOException | NullPointerException -> 0x00a2 }
            java.util.List<com.bumptech.glide.load.ImageHeaderParser> r7 = r4.parsers     // Catch:{ IOException | NullPointerException -> 0x00a2 }
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r4 = r4.byteArrayPool     // Catch:{ IOException | NullPointerException -> 0x00a2 }
            int r0 = co.hyperverge.hypersnapsdk.c.k.getOrientation(r7, r3, r4)     // Catch:{ IOException | NullPointerException -> 0x00a2 }
            if (r3 == 0) goto L_0x00c6
            r3.close()     // Catch:{ IOException -> 0x009e }
            goto L_0x00c6
        L_0x009e:
            goto L_0x00c6
        L_0x00a0:
            r0 = move-exception
            goto L_0x00be
        L_0x00a2:
            boolean r0 = android.util.Log.isLoggable(r0, r5)     // Catch:{ all -> 0x00a0 }
            if (r0 == 0) goto L_0x00b8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a0 }
            r0.<init>()     // Catch:{ all -> 0x00a0 }
            java.lang.String r4 = "Failed to open uri: "
            r0.append(r4)     // Catch:{ all -> 0x00a0 }
            r0.append(r6)     // Catch:{ all -> 0x00a0 }
            r0.toString()     // Catch:{ all -> 0x00a0 }
        L_0x00b8:
            if (r3 == 0) goto L_0x00c5
            r3.close()     // Catch:{ IOException -> 0x00c5 }
            goto L_0x00c5
        L_0x00be:
            if (r3 == 0) goto L_0x00c3
            r3.close()     // Catch:{ IOException -> 0x00c3 }
        L_0x00c3:
            throw r0
        L_0x00c4:
            throw r3
        L_0x00c5:
            r0 = -1
        L_0x00c6:
            if (r0 == r2) goto L_0x00ce
            com.bumptech.glide.load.data.ExifOrientationStream r2 = new com.bumptech.glide.load.data.ExifOrientationStream
            r2.<init>(r1, r0)
            r1 = r2
        L_0x00ce:
            return r1
        L_0x00cf:
            r0 = move-exception
            java.io.FileNotFoundException r1 = new java.io.FileNotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "NPE opening uri: "
            r3.append(r5)
            r3.append(r2)
            java.lang.String r2 = " -> "
            r3.append(r2)
            r3.append(r4)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2)
            java.lang.Throwable r0 = r1.initCause(r0)
            java.io.FileNotFoundException r0 = (java.io.FileNotFoundException) r0
            throw r0
        L_0x00f5:
            throw r3
        L_0x00f6:
            throw r3
        L_0x00f7:
            if (r3 == 0) goto L_0x00fc
            r3.close()
        L_0x00fc:
            throw r0
        L_0x00fd:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.mediastore.ThumbFetcher.openThumbInputStream():java.io.InputStream");
    }
}
