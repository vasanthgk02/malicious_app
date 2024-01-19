package com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.cardinalcommerce.dependencies.internal.bouncycastle.a.h.b;
import com.cardinalcommerce.dependencies.internal.bouncycastle.a.t;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEHeader;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.KeyLengthException;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.a.c;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.f;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.g;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.h;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.m;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.a;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.e;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.i;
import in.juspay.hypersdk.security.EncryptionHelper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class DirectDecrypter extends h {

    /* renamed from: c  reason: collision with root package name */
    public final boolean f1988c = false;

    /* renamed from: d  reason: collision with root package name */
    public final g f1989d = new g();

    public DirectDecrypter(byte[] bArr) {
        super(new SecretKeySpec(bArr, EncryptionHelper.algorithm));
    }

    public byte[] a(JWEHeader jWEHeader, Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, Base64URL base64URL4) {
        boolean z;
        byte[] bArr;
        SecretKeySpec secretKeySpec;
        SecretKeySpec secretKeySpec2;
        Cipher cipher;
        byte[] bArr2;
        byte[] bArr3;
        if (!this.f1988c) {
            if (!((JWEAlgorithm) jWEHeader.a$com$cardinalcommerce$dependencies$internal$nimbusds$jose$d).equals(JWEAlgorithm.h)) {
                Set<JWEAlgorithm> set = h.f1996a;
                throw new JOSEException("Unsupported JWE algorithm " + r0 + ", must be " + k.a((Collection) set));
            } else if (base64URL != null) {
                throw new JOSEException("Unexpected present JWE encrypted key");
            }
        }
        if (base64URL2 == null) {
            throw new JOSEException("Unexpected present JWE initialization vector (IV)");
        } else if (base64URL4 != null) {
            g gVar = this.f1989d;
            if (gVar != null) {
                Set<String> set2 = jWEHeader.d$com$cardinalcommerce$dependencies$internal$nimbusds$jose$d;
                if (set2 != null) {
                    Iterator<String> it = set2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        String next = it.next();
                        if (!Collections.singleton("b64").contains(next) && !Collections.unmodifiableSet(gVar.f1995a).contains(next)) {
                            z = false;
                            break;
                        }
                    }
                }
                z = true;
                if (z) {
                    SecretKey secretKey = this.f1998c;
                    c cVar = this.f1992c;
                    try {
                        if (jWEHeader.f1955b.j == k.b(secretKey.getEncoded())) {
                            byte[] bytes = jWEHeader.e().f2053a.getBytes(Charset.forName("ASCII"));
                            if (jWEHeader.f1955b.equals(EncryptionMethod.f1944b) || jWEHeader.f1955b.equals(EncryptionMethod.f1945c) || jWEHeader.f1955b.equals(EncryptionMethod.f1946d)) {
                                byte[] a2 = base64URL2.a();
                                byte[] a3 = base64URL3.a();
                                byte[] a4 = base64URL4.a();
                                Provider d2 = cVar.d();
                                Provider e2 = cVar.e();
                                byte[] encoded = secretKey.getEncoded();
                                int i = 32;
                                if (encoded.length == 32) {
                                    i = 16;
                                    secretKeySpec = new SecretKeySpec(encoded, 0, 16, "HMACSHA256");
                                    secretKeySpec2 = new SecretKeySpec(encoded, 16, 16, EncryptionHelper.algorithm);
                                } else if (encoded.length == 48) {
                                    i = 24;
                                    secretKeySpec = new SecretKeySpec(encoded, 0, 24, "HMACSHA384");
                                    secretKeySpec2 = new SecretKeySpec(encoded, 24, 24, EncryptionHelper.algorithm);
                                } else if (encoded.length == 64) {
                                    secretKeySpec = new SecretKeySpec(encoded, 0, 32, "HMACSHA512");
                                    secretKeySpec2 = new SecretKeySpec(encoded, 32, 32, EncryptionHelper.algorithm);
                                } else {
                                    throw new KeyLengthException("Unsupported AES/CBC/PKCS5Padding/HMAC-SHA2 key length, must be 256, 384 or 512 bits");
                                }
                                byte[] a5 = k.a(bytes);
                                if (k.a1(Arrays.copyOf(k.a((SecretKey) secretKeySpec, ByteBuffer.allocate(bytes.length + a2.length + a3.length + a5.length).put(bytes).put(a2).put(a3).put(a5).array(), e2), i), a4)) {
                                    bArr = k.b(secretKeySpec2, a2, a3, d2);
                                } else {
                                    throw new JOSEException("MAC check failed");
                                }
                            } else if (jWEHeader.f1955b.equals(EncryptionMethod.g) || jWEHeader.f1955b.equals(EncryptionMethod.h) || jWEHeader.f1955b.equals(EncryptionMethod.i)) {
                                byte[] a6 = base64URL2.a();
                                byte[] a7 = base64URL3.a();
                                byte[] a8 = base64URL4.a();
                                Provider d3 = cVar.d();
                                SecretKeySpec secretKeySpec3 = new SecretKeySpec(secretKey.getEncoded(), EncryptionHelper.algorithm);
                                if (d3 != null) {
                                    try {
                                        cipher = Cipher.getInstance("AES/GCM/NoPadding", d3);
                                    } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e3) {
                                        throw new JOSEException(GeneratedOutlineSupport.outline67(e3, GeneratedOutlineSupport.outline73("Couldn't create AES/GCM/NoPadding cipher: ")), e3);
                                    } catch (NoClassDefFoundError unused) {
                                        b a9 = k.a((SecretKey) secretKeySpec3, false, a6, bytes);
                                        int length = a7.length + a8.length;
                                        byte[] bArr4 = new byte[length];
                                        System.arraycopy(a7, 0, bArr4, 0, a7.length);
                                        System.arraycopy(a8, 0, bArr4, a7.length, a8.length);
                                        byte[] bArr5 = new byte[a9.a(length)];
                                        try {
                                            a9.a(bArr5, a9.a(bArr4, 0, length, bArr5, 0));
                                            bArr = bArr5;
                                        } catch (t e4) {
                                            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Couldn't validate GCM authentication tag: ");
                                            outline73.append(e4.getMessage());
                                            throw new JOSEException(outline73.toString(), e4);
                                        }
                                    }
                                } else {
                                    cipher = Cipher.getInstance("AES/GCM/NoPadding");
                                }
                                cipher.init(2, secretKeySpec3, new GCMParameterSpec(128, a6));
                                cipher.updateAAD(bytes);
                                try {
                                    bArr = cipher.doFinal(k.a(a7, a8));
                                } catch (BadPaddingException | IllegalBlockSizeException e5) {
                                    throw new JOSEException(GeneratedOutlineSupport.outline67(e5, GeneratedOutlineSupport.outline73("AES/GCM/NoPadding decryption failed: ")), e5);
                                }
                            } else if (jWEHeader.f1955b.equals(EncryptionMethod.f1947e) || jWEHeader.f1955b.equals(EncryptionMethod.f1948f)) {
                                cVar.d();
                                if (jWEHeader.e$com$cardinalcommerce$dependencies$internal$nimbusds$jose$d.get("epu") instanceof String) {
                                    String str = (String) jWEHeader.e$com$cardinalcommerce$dependencies$internal$nimbusds$jose$d.get("epu");
                                    if (str != null) {
                                        bArr2 = a.a(str);
                                    } else {
                                        throw new IllegalArgumentException("The Base64 value must not be null");
                                    }
                                } else {
                                    bArr2 = null;
                                }
                                if (jWEHeader.e$com$cardinalcommerce$dependencies$internal$nimbusds$jose$d.get("epv") instanceof String) {
                                    String str2 = (String) jWEHeader.e$com$cardinalcommerce$dependencies$internal$nimbusds$jose$d.get("epv");
                                    if (str2 != null) {
                                        bArr3 = a.a(str2);
                                    } else {
                                        throw new IllegalArgumentException("The Base64 value must not be null");
                                    }
                                } else {
                                    bArr3 = null;
                                }
                                EncryptionMethod encryptionMethod = jWEHeader.f1955b;
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                try {
                                    byteArrayOutputStream.write(m.f1999a);
                                    byte[] encoded2 = secretKey.getEncoded();
                                    byteArrayOutputStream.write(encoded2);
                                    int length2 = encoded2.length * 8;
                                    byteArrayOutputStream.write(k.a(length2));
                                    byteArrayOutputStream.write(encryptionMethod.f1977b.getBytes(i.f2055a));
                                    if (bArr2 != null) {
                                        byteArrayOutputStream.write(k.a(bArr2.length));
                                        byteArrayOutputStream.write(bArr2);
                                    } else {
                                        byteArrayOutputStream.write(m.f2000b);
                                    }
                                    if (bArr3 != null) {
                                        byteArrayOutputStream.write(k.a(bArr3.length));
                                        byteArrayOutputStream.write(bArr3);
                                    } else {
                                        byteArrayOutputStream.write(m.f2000b);
                                    }
                                    byteArrayOutputStream.write(m.f2002d);
                                    try {
                                        new SecretKeySpec(MessageDigest.getInstance("SHA-" + length2).digest(byteArrayOutputStream.toByteArray()), GeneratedOutlineSupport.outline41("HMACSHA", length2));
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(jWEHeader.e().f2053a);
                                        sb.append(".");
                                        throw null;
                                    } catch (NoSuchAlgorithmException e6) {
                                        throw new JOSEException(e6.getMessage(), e6);
                                    }
                                } catch (IOException e7) {
                                    throw new JOSEException(e7.getMessage(), e7);
                                }
                            } else {
                                throw new JOSEException(k.a(jWEHeader.f1955b, (Collection<EncryptionMethod>) f.f1993a));
                            }
                            com.cardinalcommerce.dependencies.internal.nimbusds.jose.c cVar2 = jWEHeader.f1957d;
                            if (cVar2 == null) {
                                return bArr;
                            }
                            if (cVar2.equals(com.cardinalcommerce.dependencies.internal.nimbusds.jose.c.f1986a)) {
                                try {
                                    return k.b1(bArr);
                                } catch (Exception e8) {
                                    throw new JOSEException(GeneratedOutlineSupport.outline39(e8, GeneratedOutlineSupport.outline73("Couldn't decompress plain text: ")), e8);
                                }
                            } else {
                                throw new JOSEException("Unsupported compression algorithm: " + cVar2);
                            }
                        } else {
                            throw new KeyLengthException("The Content Encryption Key (CEK) length for " + r4 + " must be " + r4.j + " bits");
                        }
                    } catch (e e9) {
                        StringBuilder outline732 = GeneratedOutlineSupport.outline73("The Content Encryption Key (CEK) is too long: ");
                        outline732.append(e9.getMessage());
                        throw new KeyLengthException(outline732.toString());
                    }
                } else {
                    throw new JOSEException("Unsupported critical header parameter(s)");
                }
            } else {
                throw null;
            }
        } else {
            throw new JOSEException("Missing JWE authentication tag");
        }
    }
}
