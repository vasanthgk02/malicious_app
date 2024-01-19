package defpackage;

import android.util.Base64;
import in.juspay.hypersdk.security.SecurityHelper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

/* renamed from: cg  reason: default package */
public class cg {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2816a;

    /* renamed from: a  reason: collision with other field name */
    public static final /* synthetic */ boolean f84a;

    /* renamed from: cg$a */
    public enum a {
        HEADER,
        PAYLOAD,
        SIGNATURE
    }

    static {
        Class<cg> cls = cg.class;
        f84a = !cls.desiredAssertionStatus();
        f2816a = cls.getName();
    }

    public final String a(String str) throws UnsupportedEncodingException {
        return new String(Base64.decode(str.trim().getBytes("UTF-8"), 0), "UTF-8");
    }

    /* renamed from: a  reason: collision with other method in class */
    public final String[] m279a(String str) {
        if (f84a || str != null) {
            String[] split = str.split("[.]");
            if (split.length == 3) {
                return split;
            }
            throw new IllegalArgumentException("Invalid JWT format");
        }
        throw new AssertionError();
    }

    public final void a(String[] strArr) throws InvalidKeyException, NoSuchProviderException, SignatureException, NoSuchAlgorithmException, CertificateException, IOException {
        Certificate certificate;
        StringBuilder sb = new StringBuilder();
        a aVar = a.HEADER;
        sb.append(strArr[0].trim());
        sb.append(".");
        a aVar2 = a.PAYLOAD;
        sb.append(strArr[1].trim());
        byte[] bytes = sb.toString().getBytes("UTF-8");
        a aVar3 = a.SIGNATURE;
        byte[] decode = Base64.decode(strArr[2].trim().getBytes("UTF-8"), 0);
        synchronized (cm.class) {
            if (cm.f2831a == null) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("-----BEGIN CERTIFICATE-----\nMIIEiTCCA3GgAwIBAgIJANVIFteXvjkPMA0GCSqGSIb3DQEBBQUAMIGJMQswCQYD\nVQQGEwJVUzEQMA4GA1UEBxMHU2VhdHRsZTETMBEGA1UEChMKQW1hem9uLmNvbTEZ\nMBcGA1UECxMQSWRlbnRpdHkgYW5kIFRheDETMBEGA1UEAxMKQW1hem9uLmNvbTEj\nMCEGCSqGSIb3DQEJARYUYXV0aC10ZWFtQGFtYXpvbi5jb20wHhcNMTIwODE0MDY1\nMDM5WhcNNzYwNjE0MDAyMjIzWjCBiTELMAkGA1UEBhMCVVMxEDAOBgNVBAcTB1Nl\nYXR0bGUxEzARBgNVBAoTCkFtYXpvbi5jb20xGTAXBgNVBAsTEElkZW50aXR5IGFu\nZCBUYXgxEzARBgNVBAMTCkFtYXpvbi5jb20xIzAhBgkqhkiG9w0BCQEWFGF1dGgt\ndGVhbUBhbWF6b24uY29tMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA\nr4LlDpmlK1+mYGXqhvY3Kcd093eUwOQhQM0cb5Y9FjkXvJiCCoLSR9L8QYm2Jz06\nL/546eF/eMegvej93VGjz9JsW+guUIGkDuyCPwBn3u/PvTVKZD67Cep66qT3xnB3\nLfMFt5ln4T5LuoqJ95s8t9P0fULBU52kPR1hwdSo7G4KRVgyXtMmqjp3PK4EbrPB\ndvXCYxVeR31yDPS0BRENC3SGrzlVzrSWYFhxuxRcfyoMJYsOt/9T5QlO2KmJoTy2\nJQtqo7rlc6rORiJH7i2x+QW14bV3miJe/p4ZHWpOT5Z4hAqMBldc0FufaED1YH/Y\nnNCethI/GrXkgzCJRU5asQIDAQABo4HxMIHuMB0GA1UdDgQWBBQBvx8zbG7Sg/MZ\nOuZ31GeYDkhqozCBvgYDVR0jBIG2MIGzgBQBvx8zbG7Sg/MZOuZ31GeYDkhqo6GB\nj6SBjDCBiTELMAkGA1UEBhMCVVMxEDAOBgNVBAcTB1NlYXR0bGUxEzARBgNVBAoT\nCkFtYXpvbi5jb20xGTAXBgNVBAsTEElkZW50aXR5IGFuZCBUYXgxEzARBgNVBAMT\nCkFtYXpvbi5jb20xIzAhBgkqhkiG9w0BCQEWFGF1dGgtdGVhbUBhbWF6b24uY29t\nggkA1UgW15e+OQ8wDAYDVR0TBAUwAwEB/zANBgkqhkiG9w0BAQUFAAOCAQEAjOV/\nVDxeAuBqdPgoBGz8AyDtMR4Qyxpe7P0M9umtr8S0PmvYOVs5YuMbEAPUYGsBnWVJ\nn7ErwCF20bkd4x0gHzkOpEzQJnjlO9vJzJcnZH4ZwhVs5jF4IkPN8N68jawPvh5/\nLyWJuwyNY5nGvN5nEecTdUQqT1aa7+Vv3Y1ZQlTEKQtdaoXUjLG86jq9xpanNj/G\nX4VYW+m7mY7Kv7mdfAE4zeECqOY5yAqSfP1M/a5fSfHLQiCTt3mrZfOuj8Hd3Pp5\nVn1e4/UxQQCwZcvAFljEYie6CXD3U1AgzIFiv4/r2M+rDo0T7eqIqCsyG6VCgRAb\ndry4esK8/BdPhyuiZg==\n-----END CERTIFICATE-----\n".getBytes("UTF-8"));
                Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream);
                byteArrayInputStream.close();
                cm.f2831a = generateCertificate;
            }
            certificate = cm.f2831a;
        }
        Signature instance = Signature.getInstance(SecurityHelper.SHA_256_RSA);
        instance.initVerify(certificate);
        instance.update(bytes);
        if (!instance.verify(decode)) {
            throw new SecurityException("Decoding fails: signature mismatch!");
        }
    }
}
