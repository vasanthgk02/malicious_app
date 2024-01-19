package com.netcore.android.mediadownloader;

import android.content.Context;
import android.content.ContextWrapper;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.notification.SMTNotificationType;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b/\u00100J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u0004\u0018\u00010\t2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b \u0010!J/\u0010\"\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\t8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\t8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b*\u0010)R\u0019\u0010+\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010)\u001a\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\t8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b.\u0010)¨\u00061"}, d2 = {"Lcom/netcore/android/mediadownloader/SMTDownloaderUtility;", "", "Landroid/content/Context;", "context", "", "isInbox", "Ljava/io/File;", "getDirectory", "(Landroid/content/Context;Z)Ljava/io/File;", "", "url", "type", "getFileName", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "getFileExtensionFromUrl", "extension", "isExtValid", "(Ljava/lang/String;)Z", "", "width", "height", "reqWidth", "reqHeight", "calculateInSampleSize", "(IIII)I", "Landroid/graphics/Bitmap;", "bitmapImage", "file", "saveBitmapToInternalStorage", "(Landroid/graphics/Bitmap;Ljava/io/File;)Ljava/lang/String;", "Ljava/io/InputStream;", "ins", "saveFileToInternalStorage", "(Ljava/io/InputStream;Ljava/io/File;)Ljava/lang/String;", "getDownloadFile", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Ljava/io/File;", "mMediaLocalPath", "", "getGifBytes", "(Ljava/lang/String;)[B", "filePrefix", "Ljava/lang/String;", "fileDirectory", "TAG", "getTAG", "()Ljava/lang/String;", "mInboxDirectory", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTDownloaderUtility.kt */
public final class SMTDownloaderUtility {
    public static final SMTDownloaderUtility INSTANCE = new SMTDownloaderUtility();
    public static final String TAG;
    public static final String fileDirectory = "SmarTechDirectory";
    public static final String filePrefix = "SmtFile";
    public static final String mInboxDirectory = "SmtInboxDirectory";

    static {
        String simpleName = SMTDownloaderUtility.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "SMTDownloaderUtility::class.java.simpleName");
        TAG = simpleName;
    }

    private final File getDirectory(Context context, boolean z) {
        ContextWrapper contextWrapper = new ContextWrapper(context.getApplicationContext());
        if (z) {
            File dir = contextWrapper.getDir(mInboxDirectory, 0);
            Intrinsics.checkNotNullExpressionValue(dir, "cw.getDir(mInboxDirectory, Context.MODE_PRIVATE)");
            return dir;
        }
        File dir2 = contextWrapper.getDir(fileDirectory, 0);
        Intrinsics.checkNotNullExpressionValue(dir2, "cw.getDir(fileDirectory, Context.MODE_PRIVATE)");
        return dir2;
    }

    public static /* synthetic */ File getDownloadFile$default(SMTDownloaderUtility sMTDownloaderUtility, Context context, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return sMTDownloaderUtility.getDownloadFile(context, str, str2, z);
    }

    private final String getFileExtensionFromUrl(String str, String str2) {
        String str3;
        if (CharsKt__CharKt.contains$default((CharSequence) str, (CharSequence) ".", false, 2)) {
            str3 = str.substring(CharsKt__CharKt.lastIndexOf$default((CharSequence) str, (String) ".", 0, false, 6));
            Intrinsics.checkNotNullExpressionValue(str3, "(this as java.lang.String).substring(startIndex)");
        } else {
            str3 = null;
        }
        if (str3 == null || !isExtValid(str3)) {
            if (Intrinsics.areEqual(str2, SMTNotificationType.BIG_IMAGE.getType()) || Intrinsics.areEqual(str2, SMTNotificationType.CAROUSEL_PORTRAIT.getType()) || Intrinsics.areEqual(str2, SMTNotificationType.CAROUSEL_LANDSCAPE.getType()) || Intrinsics.areEqual(str2, SMTNotificationType.SIMPLE.getType())) {
                str3 = ".jpg";
            } else if (Intrinsics.areEqual(str2, SMTNotificationType.GIF.getType())) {
                str3 = ".gif";
            } else if (Intrinsics.areEqual(str2, SMTNotificationType.VIDEO.getType())) {
                str3 = ".mp4";
            } else if (Intrinsics.areEqual(str2, SMTNotificationType.AUDIO.getType())) {
                str3 = ".mp3";
            }
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str4 = TAG;
            sMTLogger.d(str4, "File extension from notification type " + str3);
            return str3;
        }
        SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
        String str5 = TAG;
        sMTLogger2.d(str5, "File extension from url " + str3);
        return str3;
    }

    private final String getFileName(String str, String str2) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(GeneratedOutlineSupport.outline50(filePrefix, "_"));
        outline73.append(System.currentTimeMillis());
        StringBuilder outline732 = GeneratedOutlineSupport.outline73(outline73.toString());
        outline732.append(getFileExtensionFromUrl(str, str2));
        return outline732.toString();
    }

    private final boolean isExtValid(String str) {
        boolean contains = TweetUtils.contains(new String[]{".jpg", ".JPG", ".JPEG", ".jpeg", ".png", ".PNG", ".gif", ".GIF", ".mp3", ".MP3", ".mp4", ".MP4", ".3gp", ".3GP", ".wma", ".WMA", ".wav", ".WAV"}, str);
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str2 = TAG;
        sMTLogger.d(str2, "Validating the url extension " + contains);
        return contains;
    }

    public final int calculateInSampleSize(int i, int i2, int i3, int i4) {
        SMTLogger.INSTANCE.d(TAG, "Calculating In sample size");
        int i5 = 1;
        if (i2 > i4 || i > i3) {
            int i6 = i2 / 2;
            int i7 = i / 2;
            while (i6 / i5 >= i4 && i7 / i5 >= i3) {
                i5 *= 2;
            }
        }
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = TAG;
        sMTLogger.d(str, "Calulated In sample size " + i5);
        return i5;
    }

    public final File getDownloadFile(Context context, String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "type");
        SMTLogger.INSTANCE.d(TAG, "Creating file");
        return new File(getDirectory(context, z), getFileName(str, str2));
    }

    public final byte[] getGifBytes(String str) {
        File file = new File(str);
        int length = (int) file.length();
        byte[] bArr = new byte[length];
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            bufferedInputStream.read(bArr, 0, length);
            bufferedInputStream.close();
        } catch (FileNotFoundException e2) {
            SMTLogger.INSTANCE.e(TAG, String.valueOf(e2.getMessage()));
        } catch (IOException e3) {
            SMTLogger.INSTANCE.e(TAG, String.valueOf(e3.getMessage()));
        }
        return bArr;
    }

    public final String getTAG() {
        return TAG;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String saveBitmapToInternalStorage(android.graphics.Bitmap r8, java.io.File r9) {
        /*
            r7 = this;
            java.lang.String r0 = "bitmapImage"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "file"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            com.netcore.android.logger.SMTLogger r0 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r1 = TAG
            java.lang.String r2 = "Saving Bitmap Image"
            r0.d(r1, r2)
            r0 = 0
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x002c, all -> 0x002a }
            r2.<init>(r9)     // Catch:{ Exception -> 0x002c, all -> 0x002a }
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x0028 }
            r4 = 100
            r8.compress(r3, r4, r2)     // Catch:{ Exception -> 0x0028 }
            r1 = 1
            r2.close()     // Catch:{ IOException -> 0x0026 }
            goto L_0x0060
        L_0x0026:
            r8 = move-exception
            goto L_0x0051
        L_0x0028:
            r8 = move-exception
            goto L_0x002e
        L_0x002a:
            r8 = move-exception
            goto L_0x0081
        L_0x002c:
            r8 = move-exception
            r2 = r0
        L_0x002e:
            com.netcore.android.logger.SMTLogger r3 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ all -> 0x007f }
            java.lang.String r4 = TAG     // Catch:{ all -> 0x007f }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x007f }
            r5.<init>()     // Catch:{ all -> 0x007f }
            java.lang.String r6 = "Image bitmap saving error "
            r5.append(r6)     // Catch:{ all -> 0x007f }
            java.lang.String r8 = r8.getLocalizedMessage()     // Catch:{ all -> 0x007f }
            r5.append(r8)     // Catch:{ all -> 0x007f }
            java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x007f }
            r3.e(r4, r8)     // Catch:{ all -> 0x007f }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)     // Catch:{ IOException -> 0x0026 }
            r2.close()     // Catch:{ IOException -> 0x0026 }
            goto L_0x0060
        L_0x0051:
            com.netcore.android.logger.SMTLogger r2 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r3 = TAG
            java.lang.String r8 = r8.getMessage()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r2.e(r3, r8)
        L_0x0060:
            com.netcore.android.logger.SMTLogger r8 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r2 = TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Is Image file saved "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            r8.d(r2, r3)
            if (r1 == 0) goto L_0x007e
            java.lang.String r0 = r9.getAbsolutePath()
        L_0x007e:
            return r0
        L_0x007f:
            r8 = move-exception
            r0 = r2
        L_0x0081:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ IOException -> 0x0088 }
            r0.close()     // Catch:{ IOException -> 0x0088 }
            goto L_0x0098
        L_0x0088:
            r9 = move-exception
            com.netcore.android.logger.SMTLogger r0 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r1 = TAG
            java.lang.String r9 = r9.getMessage()
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r0.e(r1, r9)
        L_0x0098:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.mediadownloader.SMTDownloaderUtility.saveBitmapToInternalStorage(android.graphics.Bitmap, java.io.File):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0093 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String saveFileToInternalStorage(java.io.InputStream r8, java.io.File r9) {
        /*
            r7 = this;
            java.lang.String r0 = "ins"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "file"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            com.netcore.android.logger.SMTLogger r0 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r1 = TAG
            java.lang.String r2 = "Saving Media file"
            r0.d(r1, r2)
            r0 = 0
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0040, all -> 0x003e }
            r2.<init>(r9)     // Catch:{ Exception -> 0x0040, all -> 0x003e }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x003c }
        L_0x001e:
            int r4 = r8.read(r3)     // Catch:{ Exception -> 0x003c }
            r5 = -1
            if (r4 != r5) goto L_0x0038
            r2.flush()     // Catch:{ Exception -> 0x003c }
            r1 = 1
            com.netcore.android.logger.SMTLogger r8 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ Exception -> 0x003c }
            java.lang.String r3 = TAG     // Catch:{ Exception -> 0x003c }
            java.lang.String r4 = "Is file saved true"
            r8.d(r3, r4)     // Catch:{ Exception -> 0x003c }
            r2.close()     // Catch:{ Exception -> 0x0036 }
            goto L_0x0074
        L_0x0036:
            r8 = move-exception
            goto L_0x0065
        L_0x0038:
            r2.write(r3, r1, r4)     // Catch:{ Exception -> 0x003c }
            goto L_0x001e
        L_0x003c:
            r8 = move-exception
            goto L_0x0042
        L_0x003e:
            r8 = move-exception
            goto L_0x0096
        L_0x0040:
            r8 = move-exception
            r2 = r0
        L_0x0042:
            com.netcore.android.logger.SMTLogger r3 = com.netcore.android.logger.SMTLogger.INSTANCE     // Catch:{ all -> 0x0094 }
            java.lang.String r4 = TAG     // Catch:{ all -> 0x0094 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0094 }
            r5.<init>()     // Catch:{ all -> 0x0094 }
            java.lang.String r6 = "Saving media file save failed "
            r5.append(r6)     // Catch:{ all -> 0x0094 }
            java.lang.String r8 = r8.getLocalizedMessage()     // Catch:{ all -> 0x0094 }
            r5.append(r8)     // Catch:{ all -> 0x0094 }
            java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x0094 }
            r3.d(r4, r8)     // Catch:{ all -> 0x0094 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)     // Catch:{ Exception -> 0x0036 }
            r2.close()     // Catch:{ Exception -> 0x0036 }
            goto L_0x0074
        L_0x0065:
            com.netcore.android.logger.SMTLogger r2 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r3 = TAG
            java.lang.String r8 = r8.getMessage()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r2.e(r3, r8)
        L_0x0074:
            if (r1 == 0) goto L_0x0093
            com.netcore.android.logger.SMTLogger r8 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r0 = TAG
            java.lang.String r1 = "File saved "
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            java.lang.String r2 = r9.getAbsolutePath()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r8.d(r0, r1)
            java.lang.String r8 = r9.getAbsolutePath()
            return r8
        L_0x0093:
            return r0
        L_0x0094:
            r8 = move-exception
            r0 = r2
        L_0x0096:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ Exception -> 0x009d }
            r0.close()     // Catch:{ Exception -> 0x009d }
            goto L_0x00ad
        L_0x009d:
            r9 = move-exception
            com.netcore.android.logger.SMTLogger r0 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r1 = TAG
            java.lang.String r9 = r9.getMessage()
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r0.e(r1, r9)
        L_0x00ad:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.mediadownloader.SMTDownloaderUtility.saveFileToInternalStorage(java.io.InputStream, java.io.File):java.lang.String");
    }
}
