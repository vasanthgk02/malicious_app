package com.mpl.androidapp.updater.util;

import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.MLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Helper {
    public static final String TAG = "com.mpl.androidapp.updater.util.SHA256Helper";

    public static String calculateSHA256(File file) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[8192];
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        instance.update(bArr, 0, read);
                    } catch (IOException e2) {
                        throw new RuntimeException("Unable to process file for sha256", e2);
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            MLogger.e(TAG, "Exception on closing MD5 input stream", e3);
                        }
                        throw th;
                    }
                }
                byte[] digest = instance.digest();
                StringBuilder sb = new StringBuilder();
                for (byte valueOf : digest) {
                    sb.append(String.format("%02x", new Object[]{Byte.valueOf(valueOf)}));
                }
                String sb2 = sb.toString();
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    MLogger.e(TAG, "Exception on closing MD5 input stream", e4);
                }
                return sb2;
            } catch (FileNotFoundException e5) {
                MLogger.e(TAG, "Exception while getting FileInputStream", e5);
                return null;
            }
        } catch (NoSuchAlgorithmException e6) {
            MLogger.e(TAG, "Exception while getting digest", e6);
            return null;
        }
    }

    public static boolean checkSHA256(String str, File file) {
        if (TextUtils.isEmpty(str) || file == null) {
            MLogger.e(TAG, "SHA256 string empty or updateFile null");
            return false;
        }
        String calculateSHA256 = calculateSHA256(file);
        if (calculateSHA256 == null) {
            MLogger.e(TAG, "calculatedDigest null");
            return false;
        }
        MLogger.d(TAG, GeneratedOutlineSupport.outline50("Calculated digest: ", calculateSHA256));
        MLogger.d(TAG, GeneratedOutlineSupport.outline50("Provided digest: ", str));
        return calculateSHA256.equalsIgnoreCase(str);
    }
}
