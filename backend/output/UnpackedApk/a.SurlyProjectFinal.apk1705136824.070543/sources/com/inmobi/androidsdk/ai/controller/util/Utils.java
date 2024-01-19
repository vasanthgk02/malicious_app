package com.inmobi.androidsdk.ai.controller.util;

import android.os.Bundle;
import android.util.Log;
import com.inmobi.androidsdk.IMAdRequest;
import com.inmobi.androidsdk.IMAdRequest.IMIDType;
import com.inmobi.androidsdk.ai.controller.JSAssetController;
import com.inmobi.androidsdk.impl.ConfigConstants;
import com.inmobi.androidsdk.impl.Constants;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Properties;
import java.util.jar.JarFile;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

public class Utils {
    private static final String CHAR_SET = "ISO-8859-1";
    private static final String RSA_PUBLIC_KEY_EXPONENT = "010001";
    private static final String RSA_PUBLIC_KEY_MODULUS = "C10F7968CFE2C76AC6F0650C877806D4514DE58FC239592D2385BCE5609A84B2A0FBDAF29B05505EAD1FDFEF3D7209ACBF34B5D0A806DF18147EA9C0337D6B5B";
    private static int baseUrlInteger = 0;

    public static String byteToHex(byte b) {
        char[] hexDigit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        return new String(new char[]{hexDigit[(b >> 4) & 15], hexDigit[b & 15]});
    }

    public static String convert(String str) {
        try {
            byte[] array = str.getBytes();
            StringBuffer buffer = new StringBuffer();
            for (int k = 0; k < array.length; k++) {
                if ((array[k] & 128) > 0) {
                    buffer.append("%" + byteToHex(array[k]));
                } else {
                    buffer.append((char) array[k]);
                }
            }
            return new String(buffer.toString().getBytes(), CHAR_SET);
        } catch (Exception e) {
            return null;
        }
    }

    public static String getData(String key, Bundle data) {
        return data.getString(key);
    }

    public static String createMessageDigest(String s, String algo) {
        try {
            MessageDigest digest = MessageDigest.getInstance(algo);
            digest.update(s.getBytes());
            byte[] messageDigest = digest.digest();
            StringBuffer hexString = new StringBuffer();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(b & 255);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            if (Constants.DEBUG) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static String getODIN1(String androidId) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(androidId.getBytes());
            byte[] byteData = md.digest();
            StringBuffer sb = new StringBuffer();
            for (byte b : byteData) {
                sb.append(Integer.toString((b & 255) + 256, 16).substring(1));
            }
            return sb.toString();
        } catch (Exception e) {
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "Exception in getting ODIN-1", e);
            }
            return null;
        }
    }

    public static String getUIDMap(IMAdRequest mIMAdRequest, String odinValue, String randomkey, boolean isHttpTracker) {
        String loginId = null;
        String sessionId = null;
        int dflag = 2;
        if (mIMAdRequest != null) {
            loginId = mIMAdRequest.getIDType(IMIDType.ID_LOGIN);
            sessionId = mIMAdRequest.getIDType(IMIDType.ID_SESSION);
            dflag = mIMAdRequest.getDeviceIdMask();
        }
        StringBuilder uidMapValueBuilder = new StringBuilder();
        int tflag = 0;
        uidMapValueBuilder.append("{");
        if (loginId != null) {
            String loginIdXor = xorWithKey(loginId, randomkey);
            uidMapValueBuilder.append("LID:'");
            uidMapValueBuilder.append(loginIdXor);
            uidMapValueBuilder.append("'");
            tflag = 1;
        }
        if (sessionId != null) {
            if (tflag == 1) {
                uidMapValueBuilder.append(",");
            }
            String sessionIdXor = xorWithKey(sessionId, randomkey);
            uidMapValueBuilder.append("SID:'");
            uidMapValueBuilder.append(sessionIdXor);
            uidMapValueBuilder.append("'");
            tflag = 1;
        }
        if (mIMAdRequest == null) {
            if (odinValue != null) {
                if (tflag == 1) {
                    uidMapValueBuilder.append(",");
                }
                String odinValueXor = xorWithKey(odinValue, randomkey);
                uidMapValueBuilder.append("O1:'");
                uidMapValueBuilder.append(odinValueXor);
                uidMapValueBuilder.append("'");
                tflag = 1;
            }
        } else if (!(odinValue == null || (dflag & 1) == 1 || (dflag & 2) != 2)) {
            if (tflag == 1) {
                uidMapValueBuilder.append(",");
            }
            String odinValueXor2 = xorWithKey(odinValue, randomkey);
            uidMapValueBuilder.append("O1:'");
            uidMapValueBuilder.append(odinValueXor2);
            uidMapValueBuilder.append("'");
            tflag = 1;
        }
        uidMapValueBuilder.append("}");
        if (tflag == 1) {
            return encryptRSA(uidMapValueBuilder.toString());
        }
        return null;
    }

    private static String xorWithKey(String value, String randomkey) {
        try {
            byte[] valuebyte = value.getBytes("UTF-8");
            byte[] valuexor = new byte[valuebyte.length];
            byte[] key = randomkey.getBytes("UTF-8");
            for (int i = 0; i < valuebyte.length; i++) {
                valuexor[i] = (byte) (valuebyte[i] ^ key[i % key.length]);
            }
            return new String(Base64.encode(valuexor, 2), "UTF-8");
        } catch (Exception e) {
            if (!Constants.DEBUG) {
                return Constants.QA_SERVER_URL;
            }
            Log.d(Constants.LOGGING_TAG, "Exception in xor with random integer", e);
            return Constants.QA_SERVER_URL;
        }
    }

    private static String encryptRSA(String uidMapValue) {
        try {
            BigInteger modulus = new BigInteger(RSA_PUBLIC_KEY_MODULUS, 16);
            BigInteger pubExp = new BigInteger(RSA_PUBLIC_KEY_EXPONENT, 16);
            Cipher cipher = Cipher.getInstance("RSA/ECB/nopadding");
            cipher.init(1, (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(modulus, pubExp)));
            return new String(Base64.encode(blockCipher(uidMapValue.getBytes("UTF-8"), 1, cipher), 0));
        } catch (Exception e) {
            if (!Constants.DEBUG) {
                return null;
            }
            Log.d(Constants.LOGGING_TAG, "Exception in encryptRSA", e);
            return null;
        }
    }

    private static byte[] blockCipher(byte[] bytes, int mode, Cipher cipher) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr = new byte[0];
        byte[] toReturn = new byte[0];
        if (mode == 1) {
        }
        int actualLength = bytes.length;
        byte[] buffer = new byte[64];
        for (int i = 0; i < actualLength; i++) {
            if (i > 0 && i % 64 == 0) {
                toReturn = append(toReturn, cipher.doFinal(buffer));
                int newlength = 64;
                if (i + 64 > actualLength) {
                    newlength = actualLength - i;
                }
                buffer = new byte[newlength];
            }
            buffer[i % 64] = bytes[i];
        }
        return append(toReturn, cipher.doFinal(buffer));
    }

    private static byte[] append(byte[] prefix, byte[] suffix) {
        byte[] toReturn = new byte[(prefix.length + suffix.length)];
        for (int i = 0; i < prefix.length; i++) {
            toReturn[i] = prefix[i];
        }
        for (int i2 = 0; i2 < suffix.length; i2++) {
            toReturn[prefix.length + i2] = suffix[i2];
        }
        return toReturn;
    }

    public static synchronized int incrementBaseUrl() {
        int i;
        synchronized (Utils.class) {
            try {
                baseUrlInteger++;
                i = baseUrlInteger;
            }
        }
        return i;
    }

    public static boolean validateAppId(String mAppId) {
        if (mAppId == null) {
            Log.v(Constants.LOGGING_TAG, ConfigConstants.MSG_APP_ID_2);
            return false;
        } else if (!mAppId.matches("(x)+")) {
            return true;
        } else {
            Log.v(Constants.LOGGING_TAG, ConfigConstants.MSG_APP_ID_2);
            return false;
        }
    }

    public static Properties readFileFromJar(String source) {
        InputStream in = null;
        Properties pErrorLogs = new Properties();
        try {
            String file = JSAssetController.class.getClassLoader().getResource(source).getFile();
            if (file.startsWith("file:")) {
                file = file.substring(5);
            }
            int pos = file.indexOf("!");
            if (pos > 0) {
                file = file.substring(0, pos);
            }
            JarFile jf = new JarFile(file);
            InputStream in2 = jf.getInputStream(jf.getJarEntry(source));
            pErrorLogs.load(in2);
            if (in2 == null) {
                return pErrorLogs;
            }
            try {
                in2.close();
            } catch (Exception e) {
            }
            return pErrorLogs;
        } catch (Exception e2) {
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "Exception in reading File from JAR", e2);
            }
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e3) {
                }
            }
            return null;
        } catch (Throwable th) {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e4) {
                }
            }
            throw th;
        }
    }
}
