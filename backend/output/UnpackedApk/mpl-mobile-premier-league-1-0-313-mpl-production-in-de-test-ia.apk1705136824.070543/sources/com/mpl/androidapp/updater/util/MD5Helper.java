package com.mpl.androidapp.updater.util;

import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.MLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Helper {
    public static final String TAG = "com.mpl.androidapp.updater.util.MD5Helper";

    public static String calculateMD5(File file) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
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
                        throw new RuntimeException("Unable to process file for MD5", e2);
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            MLogger.e(TAG, "Exception on closing MD5 input stream", e3);
                        }
                        throw th;
                    }
                }
                String replace = String.format("%32s", new Object[]{new BigInteger(1, instance.digest()).toString(16)}).replace(' ', '0');
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    MLogger.e(TAG, "Exception on closing MD5 input stream", e4);
                }
                return replace;
            } catch (FileNotFoundException e5) {
                MLogger.e(TAG, "Exception while getting FileInputStream", e5);
                return null;
            }
        } catch (NoSuchAlgorithmException e6) {
            MLogger.e(TAG, "Exception while getting digest", e6);
            return null;
        }
    }

    public static boolean checkMD5(String str, File file) {
        if (TextUtils.isEmpty(str) || file == null) {
            MLogger.e(TAG, "MD5 string empty or updateFile null");
            return false;
        }
        String calculateMD5 = calculateMD5(file);
        if (calculateMD5 == null) {
            MLogger.e(TAG, "calculatedDigest null");
            return false;
        }
        MLogger.d(TAG, GeneratedOutlineSupport.outline50("Calculated digest: ", calculateMD5));
        MLogger.d(TAG, GeneratedOutlineSupport.outline50("Provided digest: ", str));
        return calculateMD5.equalsIgnoreCase(str);
    }
}
