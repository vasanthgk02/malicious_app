package com.razorpay;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.fontbox.cmap.CMap;

public class AppSignatureHelper extends ContextWrapper {
    public static final int NUM_BASE64_CHAR = 11;
    public static final int NUM_HASHED_BYTES = 9;
    public static final String TAG = AppSignatureHelper.class.getSimpleName();

    public AppSignatureHelper(Context context) {
        super(context);
    }

    public static String Q_$2$(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(CMap.SPACE);
        sb.append(str2);
        String obj = sb.toString();
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(obj.getBytes(StandardCharsets.UTF_8));
            String substring = Base64.encodeToString(Arrays.copyOfRange(instance.digest(), 0, 9), 3).substring(0, 11);
            String.format("pkg: %s -- hash: %s", new Object[]{str, substring});
            return substring;
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public ArrayList<String> getAppSignatures() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            String packageName = getPackageName();
            for (Signature charsString : getPackageManager().getPackageInfo(packageName, 64).signatures) {
                String Q_$2$ = Q_$2$(packageName, charsString.toCharsString());
                if (Q_$2$ != null) {
                    arrayList.add(String.format("%s", new Object[]{Q_$2$}));
                }
            }
        } catch (NameNotFoundException unused) {
        }
        return arrayList;
    }
}
