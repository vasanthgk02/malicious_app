package com.braintreepayments.api.internal;

public class SignatureVerification {
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006f A[SYNTHETIC, Splitter:B:37:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0076 A[SYNTHETIC, Splitter:B:43:0x0076] */
    @android.annotation.SuppressLint({"PackageManagerGetSignatures"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isSignatureValid(android.content.Context r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12) {
        /*
            android.content.pm.PackageManager r8 = r8.getPackageManager()
            r0 = 0
            r1 = 64
            android.content.pm.PackageInfo r8 = r8.getPackageInfo(r9, r1)     // Catch:{ NameNotFoundException -> 0x007b }
            android.content.pm.Signature[] r8 = r8.signatures     // Catch:{ NameNotFoundException -> 0x007b }
            r9 = 0
            int r1 = r8.length
            r2 = 1
            if (r1 == 0) goto L_0x0014
            r1 = 1
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            int r3 = r8.length
            r4 = 0
        L_0x0017:
            if (r4 >= r3) goto L_0x007a
            r5 = r8[r4]
            java.io.ByteArrayInputStream r6 = new java.io.ByteArrayInputStream     // Catch:{ CertificateException -> 0x0073, all -> 0x006c }
            byte[] r5 = r5.toByteArray()     // Catch:{ CertificateException -> 0x0073, all -> 0x006c }
            r6.<init>(r5)     // Catch:{ CertificateException -> 0x0073, all -> 0x006c }
            java.lang.String r9 = "X509"
            java.security.cert.CertificateFactory r9 = java.security.cert.CertificateFactory.getInstance(r9)     // Catch:{ CertificateException -> 0x006a, all -> 0x0067 }
            java.security.cert.Certificate r9 = r9.generateCertificate(r6)     // Catch:{ CertificateException -> 0x006a, all -> 0x0067 }
            java.security.cert.X509Certificate r9 = (java.security.cert.X509Certificate) r9     // Catch:{ CertificateException -> 0x006a, all -> 0x0067 }
            javax.security.auth.x500.X500Principal r5 = r9.getSubjectX500Principal()     // Catch:{ CertificateException -> 0x006a, all -> 0x0067 }
            java.lang.String r5 = r5.getName()     // Catch:{ CertificateException -> 0x006a, all -> 0x0067 }
            javax.security.auth.x500.X500Principal r7 = r9.getIssuerX500Principal()     // Catch:{ CertificateException -> 0x006a, all -> 0x0067 }
            java.lang.String r7 = r7.getName()     // Catch:{ CertificateException -> 0x006a, all -> 0x0067 }
            java.security.PublicKey r9 = r9.getPublicKey()     // Catch:{ CertificateException -> 0x006a, all -> 0x0067 }
            int r9 = r9.hashCode()     // Catch:{ CertificateException -> 0x006a, all -> 0x0067 }
            boolean r5 = r10.equals(r5)     // Catch:{ CertificateException -> 0x006a, all -> 0x0067 }
            if (r5 == 0) goto L_0x0058
            boolean r5 = r11.equals(r7)     // Catch:{ CertificateException -> 0x006a, all -> 0x0067 }
            if (r5 == 0) goto L_0x0058
            if (r12 != r9) goto L_0x0058
            r9 = 1
            goto L_0x0059
        L_0x0058:
            r9 = 0
        L_0x0059:
            r1 = r1 & r9
            if (r1 != 0) goto L_0x0060
            r6.close()     // Catch:{ IOException -> 0x005f }
        L_0x005f:
            return r0
        L_0x0060:
            r6.close()     // Catch:{ IOException -> 0x0063 }
        L_0x0063:
            int r4 = r4 + 1
            r9 = r6
            goto L_0x0017
        L_0x0067:
            r8 = move-exception
            r9 = r6
            goto L_0x006d
        L_0x006a:
            r9 = r6
            goto L_0x0074
        L_0x006c:
            r8 = move-exception
        L_0x006d:
            if (r9 == 0) goto L_0x0072
            r9.close()     // Catch:{ IOException -> 0x0072 }
        L_0x0072:
            throw r8
        L_0x0073:
        L_0x0074:
            if (r9 == 0) goto L_0x0079
            r9.close()     // Catch:{ IOException -> 0x0079 }
        L_0x0079:
            return r0
        L_0x007a:
            return r1
        L_0x007b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braintreepayments.api.internal.SignatureVerification.isSignatureValid(android.content.Context, java.lang.String, java.lang.String, java.lang.String, int):boolean");
    }
}
