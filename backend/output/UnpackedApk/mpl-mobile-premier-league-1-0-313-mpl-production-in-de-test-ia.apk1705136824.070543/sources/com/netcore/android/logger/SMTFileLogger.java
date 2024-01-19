package com.netcore.android.logger;

import android.util.Log;
import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bF\u0010\u001bJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ1\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\b\u0010\fJ\u001f\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\rJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\b\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\b\u0010\u0011J%\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001bJ\u001d\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ%\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u001d\u0010\u001fJ\u001d\u0010 \u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b \u0010\u001eJ%\u0010 \u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b \u0010\u001fJ\u001d\u0010!\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b!\u0010\u001eJ%\u0010!\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b!\u0010\u001fJ\u001d\u0010\"\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\"\u0010\u001eJ%\u0010\"\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\"\u0010\u001fJ\u001d\u0010\"\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\"\u0010#J\u001d\u0010$\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b$\u0010\u001eJ%\u0010$\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b$\u0010\u001fJ\u0015\u0010%\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b%\u0010&R$\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u000f\"\u0004\b*\u0010+R\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u0010\u0019R\u001c\u00102\u001a\u00020\u00048\u0006@\u0006XD¢\u0006\f\n\u0004\b\u000e\u0010(\u001a\u0004\b1\u0010\u000fR$\u00109\u001a\u0004\u0018\u0001038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b$\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010@\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b \u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bA\u0010-\u001a\u0004\bB\u0010/\"\u0004\bC\u0010\u0019R\u001c\u0010E\u001a\u00020\u00048\u0006@\u0006XD¢\u0006\f\n\u0004\b\b\u0010(\u001a\u0004\bD\u0010\u000f¨\u0006G"}, d2 = {"Lcom/netcore/android/logger/SMTFileLogger;", "", "", "priority", "", "tag", "msg", "", "a", "(ILjava/lang/String;Ljava/lang/String;)V", "", "tr", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "()Z", "sLogFilePath", "sCurrentPriority", "sFileSizeLimit", "init", "(Ljava/lang/String;II)V", "currentPriority", "setCurrentPriority", "(I)V", "close", "()V", "delete", "v", "(Ljava/lang/String;Ljava/lang/String;)I", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I", "d", "i", "w", "(Ljava/lang/String;Ljava/lang/Throwable;)I", "e", "getStackTraceString", "(Ljava/lang/Throwable;)Ljava/lang/String;", "c", "Ljava/lang/String;", "getSLogFilePath", "setSLogFilePath", "(Ljava/lang/String;)V", "g", "I", "getSFileSizeLimit", "()I", "setSFileSizeLimit", "getMSG_FORMAT", "MSG_FORMAT", "Ljava/io/BufferedWriter;", "Ljava/io/BufferedWriter;", "getSBufferedWriter", "()Ljava/io/BufferedWriter;", "setSBufferedWriter", "(Ljava/io/BufferedWriter;)V", "sBufferedWriter", "Ljava/io/File;", "Ljava/io/File;", "getSTheLogFile", "()Ljava/io/File;", "setSTheLogFile", "(Ljava/io/File;)V", "sTheLogFile", "f", "getSCurrentPriority", "setSCurrentPriority", "getTIMESTAMP_FORMAT", "TIMESTAMP_FORMAT", "<init>", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTFileLogger.kt */
public final class SMTFileLogger {
    public static final SMTFileLogger INSTANCE = new SMTFileLogger();

    /* renamed from: a  reason: collision with root package name */
    public static final String f1258a = "yyyy-MM-dd HH:mm:ss.SSS";

    /* renamed from: b  reason: collision with root package name */
    public static final String f1259b = "%s: %s - %s";

    /* renamed from: c  reason: collision with root package name */
    public static String f1260c = null;

    /* renamed from: d  reason: collision with root package name */
    public static File f1261d = null;

    /* renamed from: e  reason: collision with root package name */
    public static BufferedWriter f1262e = null;

    /* renamed from: f  reason: collision with root package name */
    public static int f1263f = 0;
    public static int g = 1000000;

    private final void a(int i, String str, String str2) {
        a(i, str, str2, null);
    }

    private final String b() {
        try {
            return new SimpleDateFormat(f1258a, Locale.getDefault()).format(new Date());
        } catch (Exception e2) {
            Log.getStackTraceString(e2);
            return null;
        }
    }

    public final void close() {
        try {
            BufferedWriter bufferedWriter = f1262e;
            if (bufferedWriter != null) {
                bufferedWriter.newLine();
                BufferedWriter bufferedWriter2 = f1262e;
                if (bufferedWriter2 != null) {
                    bufferedWriter2.flush();
                }
                BufferedWriter bufferedWriter3 = f1262e;
                if (bufferedWriter3 != null) {
                    bufferedWriter3.close();
                }
            }
        } catch (IOException e2) {
            Log.getStackTraceString(e2);
        }
    }

    public final int d(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        Intrinsics.checkNotNullParameter(str2, "msg");
        a(3, str, str2);
        return Log.d(str, str2);
    }

    public final void delete() {
        close();
        File file = f1261d;
        if (file != null) {
            file.delete();
        }
    }

    public final int e(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        Intrinsics.checkNotNullParameter(str2, "msg");
        a(6, str, str2);
        return Log.e(str, str2);
    }

    public final String getMSG_FORMAT() {
        return f1259b;
    }

    public final BufferedWriter getSBufferedWriter() {
        return f1262e;
    }

    public final int getSCurrentPriority() {
        return f1263f;
    }

    public final int getSFileSizeLimit() {
        return g;
    }

    public final String getSLogFilePath() {
        return f1260c;
    }

    public final File getSTheLogFile() {
        return f1261d;
    }

    public final String getStackTraceString(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "tr");
        String stackTraceString = Log.getStackTraceString(th);
        Intrinsics.checkNotNullExpressionValue(stackTraceString, "Log.getStackTraceString(tr)");
        return stackTraceString;
    }

    public final String getTIMESTAMP_FORMAT() {
        return f1258a;
    }

    public final int i(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        Intrinsics.checkNotNullParameter(str2, "msg");
        a(4, str, str2);
        return Log.i(str, str2);
    }

    public final void init(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "sLogFilePath");
        f1260c = str;
        f1263f = i;
        g = i2;
        File file = new File(str);
        f1261d = file;
        if (!file.exists()) {
            try {
                File file2 = f1261d;
                if (file2 != null) {
                    file2.createNewFile();
                }
            } catch (IOException e2) {
                Log.getStackTraceString(e2);
            }
        }
        a();
        try {
            f1262e = new BufferedWriter(new FileWriter(f1261d, true));
        } catch (IOException e3) {
            Log.getStackTraceString(e3);
        }
    }

    public final void setCurrentPriority(int i) {
        f1263f = i;
    }

    public final void setSBufferedWriter(BufferedWriter bufferedWriter) {
        f1262e = bufferedWriter;
    }

    public final void setSCurrentPriority(int i) {
        f1263f = i;
    }

    public final void setSFileSizeLimit(int i) {
        g = i;
    }

    public final void setSLogFilePath(String str) {
        f1260c = str;
    }

    public final void setSTheLogFile(File file) {
        f1261d = file;
    }

    public final int v(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        Intrinsics.checkNotNullParameter(str2, "msg");
        a(2, str, str2);
        return Log.v(str, str2);
    }

    public final int w(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        Intrinsics.checkNotNullParameter(str2, "msg");
        a(5, str, str2);
        return Log.w(str, str2);
    }

    private final void a(int i, String str, String str2, Throwable th) {
        if (f1262e == null) {
            init("sdcard/netcoreLog.txt", 2, 1000000);
        }
        if (i >= f1263f && f1262e != null) {
            try {
                if (a()) {
                    f1262e = new BufferedWriter(new FileWriter(f1261d, true));
                }
                BufferedWriter bufferedWriter = f1262e;
                if (bufferedWriter != null) {
                    bufferedWriter.write(a(str, str2));
                }
                BufferedWriter bufferedWriter2 = f1262e;
                if (bufferedWriter2 != null) {
                    bufferedWriter2.newLine();
                }
                if (th != null) {
                    BufferedWriter bufferedWriter3 = f1262e;
                    if (bufferedWriter3 != null) {
                        bufferedWriter3.write(Log.getStackTraceString(th));
                    }
                    BufferedWriter bufferedWriter4 = f1262e;
                    if (bufferedWriter4 != null) {
                        bufferedWriter4.newLine();
                    }
                }
                BufferedWriter bufferedWriter5 = f1262e;
                if (bufferedWriter5 != null) {
                    bufferedWriter5.flush();
                }
            } catch (IOException e2) {
                Log.getStackTraceString(e2);
            }
        }
        BufferedWriter bufferedWriter6 = f1262e;
    }

    public final int d(String str, String str2, Throwable th) {
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        Intrinsics.checkNotNullParameter(str2, "msg");
        Intrinsics.checkNotNullParameter(th, "tr");
        a(3, str, str2, th);
        return Log.d(str, str2, th);
    }

    public final int e(String str, String str2, Throwable th) {
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        Intrinsics.checkNotNullParameter(str2, "msg");
        Intrinsics.checkNotNullParameter(th, "tr");
        a(6, str, str2, th);
        return Log.e(str, str2, th);
    }

    public final int i(String str, String str2, Throwable th) {
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        Intrinsics.checkNotNullParameter(str2, "msg");
        Intrinsics.checkNotNullParameter(th, "tr");
        a(4, str, str2, th);
        return Log.i(str, str2, th);
    }

    public final int v(String str, String str2, Throwable th) {
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        Intrinsics.checkNotNullParameter(str2, "msg");
        Intrinsics.checkNotNullParameter(th, "tr");
        a(2, str, str2, th);
        return Log.v(str, str2, th);
    }

    public final int w(String str, String str2, Throwable th) {
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        Intrinsics.checkNotNullParameter(str2, "msg");
        Intrinsics.checkNotNullParameter(th, "tr");
        a(5, str, str2, th);
        return Log.w(str, str2, th);
    }

    public final int w(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        Intrinsics.checkNotNullParameter(th, "tr");
        a(5, str, "", th);
        return Log.w(str, th);
    }

    private final String a(String str, String str2) {
        String str3 = f1259b;
        return GeneratedOutlineSupport.outline70(new Object[]{b(), str, str2}, 3, str3, "java.lang.String.format(format, *args)");
    }

    private final boolean a() {
        try {
            File file = f1261d;
            Long valueOf = file != null ? Long.valueOf(file.length()) : null;
            Intrinsics.checkNotNull(valueOf);
            if (valueOf.longValue() > ((long) g)) {
                File file2 = new File(Intrinsics.stringPlus(f1260c, ".old"));
                if (file2.exists()) {
                    file2.delete();
                }
                File file3 = f1261d;
                if (file3 != null) {
                    file3.renameTo(file2);
                }
                File file4 = new File(f1260c);
                f1261d = file4;
                file4.createNewFile();
                return true;
            }
        } catch (IOException e2) {
            Log.getStackTraceString(e2);
        }
        return false;
    }
}
