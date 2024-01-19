package sfs2x.client.util;

import com.smartfoxserver.v2.exceptions.SFSRuntimeException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {
    public static String MD5Password(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bytes = str.getBytes();
            instance.update(bytes, 0, bytes.length);
            return String.format("%1$032x", new Object[]{new BigInteger(1, instance.digest())});
        } catch (NoSuchAlgorithmException unused) {
            throw new SFSRuntimeException((String) "Unexpected: No MD5 hash algorithm found. Is this running on an a proper Sun/Oracle JRE?!");
        }
    }
}
