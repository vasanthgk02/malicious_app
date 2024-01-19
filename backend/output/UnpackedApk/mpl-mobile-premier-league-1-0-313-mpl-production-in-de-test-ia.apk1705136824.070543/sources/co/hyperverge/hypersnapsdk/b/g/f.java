package co.hyperverge.hypersnapsdk.b.g;

import android.util.Base64;
import co.hyperverge.hypersnapsdk.HyperSnapSDK;
import co.hyperverge.hypersnapsdk.c.n;
import co.hyperverge.hypersnapsdk.f.i;
import co.hyperverge.hypersnapsdk.service.HVSignatureService;
import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.security.SecurityHelper;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.TreeMap;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.Headers;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SignatureHelper */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f3060b = "0123456789abcdef".toCharArray();

    public static boolean a(String str, Headers headers, String str2) {
        String str3 = null;
        if (HyperSnapSDK.getInstance() == null) {
            throw null;
        } else if (!HyperSnapSDK.f2946b.isShouldUseSignature() || str2 == null) {
            return true;
        } else {
            if (headers != null) {
                str3 = headers.get("X-Response-Signature");
            }
            return a(str, str3, str2);
        }
    }

    public static boolean b(String str, Headers headers, String str2) {
        TreeMap treeMap;
        String str3 = null;
        try {
            treeMap = HVSignatureService.convertJSONObjToMap(new JSONObject(str));
        } catch (JSONException e2) {
            i.a((Throwable) e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
            treeMap = null;
        }
        String sortJSONKeysAlphabetically = HVSignatureService.sortJSONKeysAlphabetically(treeMap);
        if (sortJSONKeysAlphabetically != null) {
            str = sortJSONKeysAlphabetically;
        }
        if (HyperSnapSDK.getInstance() == null) {
            throw null;
        } else if (!HyperSnapSDK.f2946b.isShouldUseSignature() || str2 == null) {
            return true;
        } else {
            if (headers != null) {
                str3 = headers.get("X-Response-Signature");
            }
            return a(str, str3, str2);
        }
    }

    public static String c(String str) {
        MessageDigest messageDigest;
        InputStream inputStream;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e2) {
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
            messageDigest = null;
        }
        if (messageDigest == null) {
            return null;
        }
        try {
            inputStream = new FileInputStream(str);
        } catch (FileNotFoundException e3) {
            if (n.m().i != null) {
                n.m().i.a(e3);
            }
            inputStream = null;
        }
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[8192];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            } catch (Exception e4) {
                if (n.m().i != null) {
                    n.m().i.a(e4);
                }
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    if (n.m().i != null) {
                        n.m().i.a(e5);
                    }
                }
                return null;
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                    if (n.m().i != null) {
                        n.m().i.a(e6);
                    }
                }
                throw th;
            }
        }
        String sb = b(messageDigest.digest()).toString();
        try {
            inputStream.close();
        } catch (IOException e7) {
            if (n.m().i != null) {
                n.m().i.a(e7);
            }
        }
        return sb;
    }

    public static boolean a(String str, String str2, String str3) {
        String str4;
        if (str == null || str2 == null) {
            return false;
        }
        Object obj = null;
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDFusF4/wCAVrq6m0uomaGHD9O2YpwBZulbyaSb5s8WMyyy/xT4zMGrghJEsQV8REAH9pAqZk06YvkT01fMP8mTr9uUwW3CngVdjgrxGKfL1YZACS93SfvAXXX95w/EYkUiDr3sby7YV7NaqlcmTeRFDzJLFRPkDLxzAj+l3QCdkQIDAQAB", 0)));
            byte[] decode = Base64.decode(str2, 0);
            Cipher instance = Cipher.getInstance(SecurityHelper.RSA_TRANSFORM);
            instance.init(2, generatePublic);
            str4 = new String(instance.doFinal(decode));
        } catch (Exception e2) {
            i.a((Throwable) e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
            str4 = null;
        }
        try {
            Mac instance2 = Mac.getInstance("HmacSHA256");
            instance2.init(new SecretKeySpec(str3.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            byte[] doFinal = instance2.doFinal(str.getBytes(StandardCharsets.UTF_8));
            char[] cArr = new char[(doFinal.length * 2)];
            for (int i = 0; i < doFinal.length; i++) {
                byte b2 = doFinal[i] & 255;
                int i2 = i * 2;
                char[] cArr2 = f3060b;
                cArr[i2] = cArr2[b2 >>> 4];
                cArr[i2 + 1] = cArr2[b2 & 15];
            }
            obj = new String(cArr);
        } catch (Exception e3) {
            i.a((Throwable) e3);
            if (n.m().i != null) {
                n.m().i.a(e3);
            }
        }
        if (str4 == null || obj == null || !str4.equals(obj)) {
            return false;
        }
        return true;
    }

    public static StringBuilder b(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        "SHA_256: " + sb + " textlength: " + sb.length();
        return sb;
    }

    public static String a(String str, String str2, JSONObject jSONObject) {
        if (HyperSnapSDK.getInstance() == null) {
            throw null;
        } else if (!HyperSnapSDK.f2946b.isShouldUseSignature()) {
            return null;
        } else {
            if (jSONObject.has("uuid")) {
                try {
                    return jSONObject.getString("uuid");
                } catch (JSONException e2) {
                    i.a((Throwable) e2);
                }
            }
            String c2 = c(str);
            String c3 = c(str2);
            if (c2 == null || c3 == null) {
                return null;
            }
            return GeneratedOutlineSupport.outline50(c2, c3);
        }
    }

    public static String a(String str, JSONObject jSONObject) {
        if (HyperSnapSDK.getInstance() == null) {
            throw null;
        } else if (!HyperSnapSDK.f2946b.isShouldUseSignature()) {
            return null;
        } else {
            if (jSONObject.has("uuid")) {
                try {
                    return jSONObject.getString("uuid");
                } catch (JSONException e2) {
                    i.a((Throwable) e2);
                }
            }
            return c(str);
        }
    }
}
