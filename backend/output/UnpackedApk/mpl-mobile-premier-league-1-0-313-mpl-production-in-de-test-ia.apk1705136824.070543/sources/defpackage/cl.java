package defpackage;

import android.content.pm.Signature;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

/* renamed from: cl  reason: default package */
public class cl {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2830a;

    /* renamed from: a  reason: collision with other field name */
    public static final /* synthetic */ boolean f92a;

    static {
        Class<cl> cls = cl.class;
        f92a = !cls.desiredAssertionStatus();
        f2830a = cls.getName();
    }

    public static String a(Signature signature, ce ceVar) throws IOException, CertificateException, NoSuchAlgorithmException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
        Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream);
        byteArrayInputStream.close();
        byte[] encoded = generateCertificate.getEncoded();
        if (f92a || encoded != null) {
            byte[] digest = MessageDigest.getInstance(ceVar.a()).digest(encoded);
            if (digest == null) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString();
        }
        throw new AssertionError();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.lang.String> a(java.lang.String r7, defpackage.ce r8, android.content.Context r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.content.pm.PackageManager r9 = r9.getPackageManager()
            r1 = 0
            if (r9 != 0) goto L_0x000d
            goto L_0x002d
        L_0x000d:
            r2 = 64
            android.content.pm.PackageInfo r9 = r9.getPackageInfo(r7, r2)     // Catch:{ NameNotFoundException -> 0x0014 }
            goto L_0x002b
        L_0x0014:
            java.lang.String r9 = f2830a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "packageName not found for package "
            r2.append(r3)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            defpackage.cp.a(r9, r2)
            r9 = r1
        L_0x002b:
            if (r9 != 0) goto L_0x0036
        L_0x002d:
            java.lang.String r9 = f2830a
            java.lang.String r2 = "Can't find app signatures as pkgMgr is null "
            defpackage.cp.a(r9, r2)
            r9 = r1
            goto L_0x0038
        L_0x0036:
            android.content.pm.Signature[] r9 = r9.signatures
        L_0x0038:
            if (r9 != 0) goto L_0x0051
            java.lang.String r8 = f2830a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r1 = " appSignature is null. pkg="
            r9.append(r1)
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            defpackage.cp.a(r8, r7)
            return r0
        L_0x0051:
            java.lang.String r7 = f2830a
            java.lang.String r2 = "num sigs = "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            int r3 = r9.length
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            defpackage.cp.c(r7, r2)
            int r7 = r9.length
            r2 = 0
        L_0x0066:
            if (r2 >= r7) goto L_0x0094
            r3 = r9[r2]
            java.lang.String r3 = a(r3, r8)     // Catch:{ Exception -> 0x0078 }
            java.util.Locale r4 = java.util.Locale.US     // Catch:{ Exception -> 0x0079 }
            java.lang.String r4 = r3.toLowerCase(r4)     // Catch:{ Exception -> 0x0079 }
            r0.add(r4)     // Catch:{ Exception -> 0x0079 }
            goto L_0x0079
        L_0x0078:
            r3 = r1
        L_0x0079:
            java.lang.String r4 = f2830a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "fingerprint = "
            r5.append(r6)
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            java.lang.String r5 = "Fingerprint checking"
            defpackage.cp.a(r4, r5, r3)
            int r2 = r2 + 1
            goto L_0x0066
        L_0x0094:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cl.a(java.lang.String, ce, android.content.Context):java.util.List");
    }
}
