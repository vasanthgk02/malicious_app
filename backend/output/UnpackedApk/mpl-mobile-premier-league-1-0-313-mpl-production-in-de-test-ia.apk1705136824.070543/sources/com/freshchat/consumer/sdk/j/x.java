package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.beans.Message;
import java.io.File;
import java.io.IOException;

public class x {
    public static File a(Context context, File file, String str) {
        if (context == null || file == null || as.isEmpty(str)) {
            return null;
        }
        File file2 = new File(file, str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public static File aE(Context context) {
        File file;
        try {
            file = context.getExternalCacheDir();
            if (file != null) {
                try {
                    if (file.canWrite()) {
                        return file;
                    }
                } catch (Exception e2) {
                    e = e2;
                    q.a(e);
                    return file;
                }
            }
            return context.getCacheDir();
        } catch (Exception e3) {
            e = e3;
            file = null;
            q.a(e);
            return file;
        }
    }

    public static File aF(Context context) throws IOException {
        return c(context, "JPEG_", ".jpg");
    }

    public static File b(Context context, Message message) {
        if (context == null || message == null || message.getChannelId() <= 0 || as.isEmpty(message.getAlias())) {
            return null;
        }
        return new File(j(context, Long.toString(message.getChannelId())), message.getAlias());
    }

    public static void bs(String str) {
        try {
            f(new File(str));
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static File c(Context context, String str, String str2) throws IOException {
        File file = null;
        try {
            String str3 = str + System.currentTimeMillis();
            File ck = ck(context);
            if (ck == null) {
                return null;
            }
            file = File.createTempFile(str3, str2, ck);
            return file;
        } catch (IOException e2) {
            throw e2;
        } catch (Exception e3) {
            q.a(e3);
        }
    }

    public static File ck(Context context) {
        File aE = aE(context);
        if (aE != null && aE.canWrite()) {
            File a2 = a(context, aE, "freshchat");
            if (a2 == null) {
                return null;
            }
            File a3 = a(context, a2, "tmp");
            if (a3 == null || !a3.canWrite()) {
                return null;
            }
            return a3;
        }
        return null;
    }

    public static void cl(Context context) {
        try {
            File ck = ck(context);
            if (ck != null && ck.exists() && ck.isDirectory()) {
                e(ck);
            }
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    public static void e(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i = 0;
            while (i < length) {
                File file2 = listFiles[i];
                if (file2.isDirectory()) {
                    e(file2);
                }
                if (file2.delete()) {
                    i++;
                } else {
                    throw new IOException("failed to delete file: " + file2);
                }
            }
            return;
        }
        throw new IllegalArgumentException("not a directory: " + file);
    }

    public static void f(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static File j(Context context, String str) {
        File externalFilesDir = aa.aL(context) ? context.getExternalFilesDir(null) : context.getCacheDir();
        StringBuilder sb = new StringBuilder();
        sb.append(externalFilesDir.getAbsolutePath());
        sb.append(File.separator);
        sb.append("freshchat");
        File file = new File(GeneratedOutlineSupport.outline62(sb, File.separator, str));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
