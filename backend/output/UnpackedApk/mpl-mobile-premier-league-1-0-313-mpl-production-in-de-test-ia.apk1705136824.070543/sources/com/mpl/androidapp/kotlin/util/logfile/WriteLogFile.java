package com.mpl.androidapp.kotlin.util.logfile;

import com.mpl.androidapp.MPLApplication;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/mpl/androidapp/kotlin/util/logfile/WriteLogFile;", "", "()V", "getOutputPath", "Ljava/io/File;", "date", "Ljava/util/Date;", "writeLog", "", "logs", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WriteLogFile.kt */
public final class WriteLogFile {
    public static final WriteLogFile INSTANCE = new WriteLogFile();

    private final File getOutputPath(Date date) {
        try {
            String format = new SimpleDateFormat("yyyy-MM-dd").format(date);
            File file = new File(MPLApplication.getInstance().getFilesDir(), "MPL_log");
            if (!file.exists()) {
                file.mkdir();
            }
            return new File(file, Intrinsics.stringPlus(format, ".txt"));
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0075, code lost:
        com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r0, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0078, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0074, code lost:
        r1 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void writeLog(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = "logs"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.sql.Timestamp r0 = new java.sql.Timestamp
            long r1 = java.lang.System.currentTimeMillis()
            r0.<init>(r1)
            java.util.Date r1 = new java.util.Date
            long r2 = r0.getTime()
            r1.<init>(r2)
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.lang.String r2 = "yyyy-MM-dd HH:mm:ss.SSS"
            r0.<init>(r2)
            java.lang.String r0 = r0.format(r1)
            java.io.File r1 = r4.getOutputPath(r1)
            if (r1 != 0) goto L_0x0029
            goto L_0x0071
        L_0x0029:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = "   ::   "
            r2.append(r0)
            r2.append(r5)
            java.lang.String r5 = " \n"
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            java.nio.charset.Charset r0 = kotlin.text.Charsets.UTF_8
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r3 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r3)
            java.lang.String r3 = "charset"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            byte[] r5 = r5.getBytes(r0)
            java.lang.String r0 = "this as java.lang.String).getBytes(charset)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r0 = "array"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.io.FileOutputStream r0 = new java.io.FileOutputStream
            r2 = 1
            r0.<init>(r1, r2)
            r0.write(r5)     // Catch:{ all -> 0x0072 }
            r5 = 0
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r0, r5)
        L_0x0071:
            return
        L_0x0072:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0074 }
        L_0x0074:
            r1 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r0, r5)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.kotlin.util.logfile.WriteLogFile.writeLog(java.lang.String):void");
    }
}
