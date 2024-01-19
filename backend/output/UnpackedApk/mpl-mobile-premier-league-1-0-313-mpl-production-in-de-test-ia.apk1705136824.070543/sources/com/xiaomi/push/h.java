package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.channel.commonutils.logger.b;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f4788a = {"jpg", "png", "bmp", "gif", "webp"};

    public static String a(File file) {
        InputStreamReader inputStreamReader;
        StringWriter stringWriter = new StringWriter();
        InputStreamReader inputStreamReader2 = null;
        try {
            inputStreamReader = new InputStreamReader(new BufferedInputStream(new FileInputStream(file)));
            try {
                char[] cArr = new char[2048];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read != -1) {
                        stringWriter.write(cArr, 0, read);
                    } else {
                        String stringWriter2 = stringWriter.toString();
                        a((Closeable) inputStreamReader);
                        a((Closeable) stringWriter);
                        return stringWriter2;
                    }
                }
            } catch (IOException e2) {
                e = e2;
                try {
                    b.c("read file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
                    a((Closeable) inputStreamReader);
                    a((Closeable) stringWriter);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    inputStreamReader2 = inputStreamReader;
                    a((Closeable) inputStreamReader2);
                    a((Closeable) stringWriter);
                    throw th;
                }
            }
        } catch (IOException e3) {
            e = e3;
            inputStreamReader = null;
            b.c("read file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
            a((Closeable) inputStreamReader);
            a((Closeable) stringWriter);
            return null;
        } catch (Throwable th2) {
            th = th2;
            a((Closeable) inputStreamReader2);
            a((Closeable) stringWriter);
            throw th;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void a(File file, String str) {
        if (!file.exists()) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("mkdir ");
            outline73.append(file.getAbsolutePath());
            b.c(outline73.toString());
            file.getParentFile().mkdirs();
        }
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            try {
                bufferedWriter2.write(str);
                a((Closeable) bufferedWriter2);
            } catch (IOException e2) {
                e = e2;
                bufferedWriter = bufferedWriter2;
                try {
                    b.c("write file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
                    a((Closeable) bufferedWriter);
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter2 = bufferedWriter;
                    a((Closeable) bufferedWriter2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                a((Closeable) bufferedWriter2);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            b.c("write file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
            a((Closeable) bufferedWriter);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m747a(File file) {
        try {
            if (file.isDirectory()) {
                return false;
            }
            if (file.exists()) {
                return true;
            }
            File parentFile = file.getParentFile();
            if (parentFile.exists() || parentFile.mkdirs()) {
                return file.createNewFile();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static byte[] a(InputStream inputStream) {
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[8192];
        while (true) {
            try {
                int read = inputStream.read(bArr2, 0, 8192);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            } catch (Exception e2) {
                e2.printStackTrace();
                bArr = null;
            } catch (Throwable th) {
                a((Closeable) inputStream);
                a((Closeable) byteArrayOutputStream);
                throw th;
            }
        }
        bArr = byteArrayOutputStream.toByteArray();
        a((Closeable) inputStream);
        a((Closeable) byteArrayOutputStream);
        return bArr;
    }
}
