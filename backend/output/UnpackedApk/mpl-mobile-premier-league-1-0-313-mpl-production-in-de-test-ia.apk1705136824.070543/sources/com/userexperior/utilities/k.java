package com.userexperior.utilities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class k {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4287a = "k";

    public static void a(ZipOutputStream zipOutputStream, File file, int i) throws IOException {
        b.a(Level.INFO, "zsf");
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                a(zipOutputStream, file2, i);
            } else {
                byte[] bArr = new byte[2048];
                String path = file2.getPath();
                String substring = path.substring(i);
                FileInputStream fileInputStream = new FileInputStream(path);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 2048);
                zipOutputStream.putNextEntry(new ZipEntry(substring));
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, 2048);
                    if (read == -1) {
                        break;
                    }
                    zipOutputStream.write(bArr, 0, read);
                }
                bufferedInputStream.close();
                fileInputStream.close();
            }
        }
    }

    public static boolean a(String str, String str2) {
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            Bitmap decodeFile2 = BitmapFactory.decodeFile(str2);
            return (decodeFile == null || decodeFile2 == null || !decodeFile.sameAs(decodeFile2)) ? false : true;
        } catch (Exception e2) {
            Level level = Level.SEVERE;
            b.a(level, "Ex : RZSU - isSame : " + e2.getMessage());
            e2.getMessage();
            return false;
        } catch (OutOfMemoryError e3) {
            Level level2 = Level.SEVERE;
            b.a(level2, "Ex : RZSU - isSame : " + e3.getMessage());
            e3.getMessage();
            return false;
        }
    }

    public static boolean b(String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles.length <= 0) {
            return false;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(fileOutputStream));
            for (File file2 : listFiles) {
                if (file2 == null || !file2.exists() || !file2.isDirectory()) {
                    byte[] bArr = new byte[2048];
                    FileInputStream fileInputStream = new FileInputStream(file2.getPath());
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(fileInputStream, 2048);
                    zipOutputStream.putNextEntry(new ZipEntry(file2.getName()));
                    while (true) {
                        int read = bufferedInputStream2.read(bArr, 0, 2048);
                        if (read == -1) {
                            break;
                        }
                        zipOutputStream.write(bArr, 0, read);
                    }
                    fileInputStream.close();
                    bufferedInputStream = bufferedInputStream2;
                } else {
                    a(zipOutputStream, file2, file2.getParent().length());
                }
            }
            zipOutputStream.close();
            fileOutputStream.close();
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            return true;
        } catch (Exception e2) {
            b.a(Level.SEVERE, "Ex : RZSU - zAP 2 : " + e2.getMessage());
            e2.printStackTrace();
            return false;
        }
    }
}
