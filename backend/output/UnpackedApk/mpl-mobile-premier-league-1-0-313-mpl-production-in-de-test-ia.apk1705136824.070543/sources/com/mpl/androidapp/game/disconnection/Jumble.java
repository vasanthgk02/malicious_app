package com.mpl.androidapp.game.disconnection;

import android.util.Base64;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.utils.MLogger;
import in.juspay.hypersdk.security.EncryptionHelper;
import java.io.PrintStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

public class Jumble {
    public static String aesKey;
    public static String iv;
    public static byte[] key;
    public static SecretKeySpec secretKey;

    public static String decrypt(String str) {
        try {
            JSONObject platformConfig = ConfigManager.getPlatformConfig();
            if (platformConfig != null) {
                aesKey = platformConfig.optString("game.gameDataBackupModuleKey", "");
                iv = platformConfig.optString("game.gameDataBackupModuleIv", "");
            }
            setKey(aesKey);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(Base64.decode(iv, 0));
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            instance.init(2, secretKey, ivParameterSpec);
            return new String(instance.doFinal(Base64.decode(str, 0)));
        } catch (Exception e2) {
            PrintStream printStream = System.out;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error while decrypting: ");
            outline73.append(e2.toString());
            printStream.println(outline73.toString());
            MLogger.e("GameDisconnectionHandling", GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("Error in decrypting: ")));
            return null;
        }
    }

    public static String encrypt(String str) {
        try {
            JSONObject platformConfig = ConfigManager.getPlatformConfig();
            if (platformConfig != null) {
                aesKey = platformConfig.optString("game.gameDataBackupModuleKey", "");
                iv = platformConfig.optString("game.gameDataBackupModuleIv", "");
            }
            setKey(aesKey);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(Base64.decode(iv, 0));
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, secretKey, ivParameterSpec);
            return Base64.encodeToString(instance.doFinal(str.getBytes("UTF-8")), 0);
        } catch (Exception e2) {
            PrintStream printStream = System.out;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error while encrypting: ");
            outline73.append(e2.toString());
            printStream.println(outline73.toString());
            MLogger.e("GameDisconnectionHandling", GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("Error in encrypting: ")));
            return null;
        }
    }

    public static void setKey(String str) {
        try {
            key = Base64.decode(str, 0);
            secretKey = new SecretKeySpec(key, EncryptionHelper.algorithm);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
