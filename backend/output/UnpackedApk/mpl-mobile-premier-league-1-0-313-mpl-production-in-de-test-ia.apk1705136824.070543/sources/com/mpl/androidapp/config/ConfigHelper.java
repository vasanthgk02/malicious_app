package com.mpl.androidapp.config;

import android.util.Base64;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.okhttp3.MemoryLruCache;
import com.mpl.androidapp.utils.MLogger;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import org.json.JSONObject;

public class ConfigHelper {
    public static ConfigHelper INSTANCE = null;
    public static final String TAG = "ConfigHelper";

    public static ConfigHelper getInstance() {
        ConfigHelper configHelper;
        ConfigHelper configHelper2 = INSTANCE;
        if (configHelper2 != null) {
            return configHelper2;
        }
        synchronized (ConfigHelper.class) {
            configHelper = new ConfigHelper();
            INSTANCE = configHelper;
        }
        return configHelper;
    }

    private byte[] md5(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            return instance.digest();
        } catch (NoSuchAlgorithmException e2) {
            MLogger.e(TAG, "", e2);
            return null;
        }
    }

    public boolean isApiMocked(JSONObject jSONObject) {
        String optString = jSONObject.optString(ConfigConstant.SECURITY_APK_KEY, "");
        String optString2 = jSONObject.optString("security.network.certificates", "");
        String optString3 = jSONObject.optString(ConfigConstant.ROOT_MASK, "");
        return isValidSignature(jSONObject.optString(ConfigConstant.ROOT_SIGNATURE, ""), getInstance().md5(GeneratedOutlineSupport.outline52(optString, optString2, optString3)), getInstance().reconstructKey(ConfigConstant.P1, MemoryLruCache.getCacheLru2()));
    }

    public boolean isValidSignature(String str, byte[] bArr, byte[] bArr2) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr2));
            Signature instance = Signature.getInstance("SHA1WithRSA");
            instance.initVerify(generatePublic);
            instance.update(bArr);
            return instance.verify(Base64.decode(str, 2));
        } catch (Exception unused) {
            return false;
        }
    }

    public byte[] reconstructKey(String str, String str2) {
        byte[] decode = Base64.decode(str, 2);
        byte[] decode2 = Base64.decode(str2, 2);
        byte[] bArr = new byte[81];
        for (int i = 0; i < decode.length; i++) {
            bArr[i] = (byte) (decode[i] ^ decode2[i]);
        }
        byte[] bArr2 = new byte[(decode.length + decode2.length)];
        System.arraycopy(decode, 0, bArr2, 0, decode.length);
        System.arraycopy(bArr, 0, bArr2, decode.length, 81);
        return bArr2;
    }
}
