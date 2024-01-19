package e;

import android.util.Base64;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Mac f5004a;

    static {
        try {
            f5004a = Mac.getInstance("HmacSHA384");
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static String a(String str, d.a aVar) throws JSONException {
        String str2;
        String valueOf = String.valueOf(aVar.f5002d.get("x-amz-date"));
        String str3 = valueOf.split("T")[0];
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.f5002d.get("x-amz-algorithm"));
        sb.append("\n");
        sb.append(valueOf);
        sb.append("\n");
        StringBuilder sb2 = new StringBuilder();
        GeneratedOutlineSupport.outline103(sb2, str3, "/", "eu-west-1", "/");
        sb2.append("AmazonPay");
        sb2.append("/");
        sb2.append("aws4_request");
        sb.append(sb2.toString());
        sb.append("\n");
        StringBuilder sb3 = new StringBuilder();
        sb3.append(aVar.f4999a);
        sb3.append("\n");
        sb3.append(aVar.f5000b);
        GeneratedOutlineSupport.outline102(sb3, aVar.f5001c, "\n", "\n");
        sb3.append(TweetUtils.a(aVar.f5002d));
        sb3.append("\n");
        JSONObject jSONObject = aVar.f5003e;
        if (jSONObject == null) {
            str2 = "";
        } else {
            str2 = TweetUtils.a(TweetUtils.a(jSONObject));
        }
        sb3.append(str2);
        String sb4 = sb3.toString();
        Timber.TREE_OF_SOULS.i("AWS4 Canonical request: %s", sb4);
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-384");
            instance.reset();
            instance.update(sb4.getBytes());
            sb.append(new String(Hex.encodeHex(instance.digest())));
            String sb5 = sb.toString();
            String str4 = valueOf.split("T")[0];
            new String(b.a(str));
            return new String(Base64.encode(a(a(a(a(a(("AWS4" + r1).getBytes(), str4), (String) "eu-west-1"), (String) "AmazonPay"), (String) "aws4_request"), sb5), 9));
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("Exception occurred while creating digest of request:{}", sb4), e2);
        }
    }

    public static byte[] a(byte[] bArr, String str) {
        try {
            f5004a.init(new SecretKeySpec(bArr, "HmacSHA384"));
            return f5004a.doFinal(str.getBytes());
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("Invalid key exception while mac init:", str), e2);
        }
    }
}
