package com.mpl.securepreferences;

import android.os.Build;
import android.os.Process;
import android.util.Base64;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import in.juspay.hypersdk.security.EncryptionHelper;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.SecureRandomSpi;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AesCbcWithIntegrity */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f968a = new AtomicBoolean(false);

    /* renamed from: com.mpl.securepreferences.a$a  reason: collision with other inner class name */
    /* compiled from: AesCbcWithIntegrity */
    public static class C0000a {

        /* renamed from: a  reason: collision with root package name */
        public final byte[] f969a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f970b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f971c;

        public C0000a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            byte[] bArr4 = new byte[bArr.length];
            this.f969a = bArr4;
            System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
            byte[] bArr5 = new byte[bArr2.length];
            this.f970b = bArr5;
            System.arraycopy(bArr2, 0, bArr5, 0, bArr2.length);
            byte[] bArr6 = new byte[bArr3.length];
            this.f971c = bArr6;
            System.arraycopy(bArr3, 0, bArr6, 0, bArr3.length);
        }

        public static byte[] a(byte[] bArr, byte[] bArr2) {
            byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
            return bArr3;
        }

        public byte[] b() {
            return this.f970b;
        }

        public byte[] c() {
            return this.f971c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0000a.class != obj.getClass()) {
                return false;
            }
            C0000a aVar = (C0000a) obj;
            if (Arrays.equals(this.f969a, aVar.f969a) && Arrays.equals(this.f970b, aVar.f970b)) {
                return Arrays.equals(this.f971c, aVar.f971c);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = Arrays.hashCode(this.f970b);
            return Arrays.hashCode(this.f971c) + ((hashCode + ((Arrays.hashCode(this.f969a) + 31) * 31)) * 31);
        }

        public String toString() {
            return String.format(GeneratedOutlineSupport.outline54(Base64.encodeToString(this.f970b, 2), ":", Base64.encodeToString(this.f971c, 2), ":", Base64.encodeToString(this.f969a, 2)), new Object[0]);
        }

        public byte[] a() {
            return this.f969a;
        }

        public C0000a(String str) {
            String[] split = str.split(":");
            if (split.length == 3) {
                this.f970b = Base64.decode(split[0], 2);
                this.f971c = Base64.decode(split[1], 2);
                this.f969a = Base64.decode(split[2], 2);
                return;
            }
            throw new IllegalArgumentException("Cannot parse iv:ciphertext:mac");
        }
    }

    /* compiled from: AesCbcWithIntegrity */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final byte[] f972a = g();

        /* renamed from: com.mpl.securepreferences.a$b$a  reason: collision with other inner class name */
        /* compiled from: AesCbcWithIntegrity */
        public static class C0001a extends SecureRandomSpi {

            /* renamed from: a  reason: collision with root package name */
            public static final File f973a = new File("/dev/urandom");

            /* renamed from: b  reason: collision with root package name */
            public static final Object f974b = new Object();

            /* renamed from: c  reason: collision with root package name */
            public static DataInputStream f975c;

            /* renamed from: d  reason: collision with root package name */
            public static OutputStream f976d;

            /* renamed from: e  reason: collision with root package name */
            public boolean f977e;

            private DataInputStream a() {
                DataInputStream dataInputStream;
                synchronized (f974b) {
                    if (f975c == null) {
                        try {
                            f975c = new DataInputStream(new FileInputStream(f973a));
                        } catch (IOException e2) {
                            throw new SecurityException("Failed to open " + f973a + " for reading", e2);
                        }
                    }
                    dataInputStream = f975c;
                }
                return dataInputStream;
            }

            private OutputStream b() {
                OutputStream outputStream;
                synchronized (f974b) {
                    if (f976d == null) {
                        f976d = new FileOutputStream(f973a);
                    }
                    outputStream = f976d;
                }
                return outputStream;
            }

            public byte[] engineGenerateSeed(int i) {
                byte[] bArr = new byte[i];
                engineNextBytes(bArr);
                return bArr;
            }

            public void engineNextBytes(byte[] bArr) {
                DataInputStream a2;
                if (!this.f977e) {
                    engineSetSeed(b.e());
                }
                try {
                    synchronized (f974b) {
                        a2 = a();
                    }
                    synchronized (a2) {
                        a2.readFully(bArr);
                    }
                } catch (IOException e2) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Failed to read from ");
                    outline73.append(f973a);
                    throw new SecurityException(outline73.toString(), e2);
                }
            }

            /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0017 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void engineSetSeed(byte[] r4) {
                /*
                    r3 = this;
                    r0 = 1
                    java.lang.Object r1 = f974b     // Catch:{ IOException -> 0x0017 }
                    monitor-enter(r1)     // Catch:{ IOException -> 0x0017 }
                    java.io.OutputStream r2 = r3.b()     // Catch:{ all -> 0x0012 }
                    monitor-exit(r1)     // Catch:{ all -> 0x0012 }
                    r2.write(r4)     // Catch:{ IOException -> 0x0017 }
                    r2.flush()     // Catch:{ IOException -> 0x0017 }
                L_0x000f:
                    r3.f977e = r0
                    goto L_0x002a
                L_0x0012:
                    r4 = move-exception
                    monitor-exit(r1)     // Catch:{ all -> 0x0012 }
                    throw r4     // Catch:{ IOException -> 0x0017 }
                L_0x0015:
                    r4 = move-exception
                    goto L_0x002b
                L_0x0017:
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0015 }
                    r4.<init>()     // Catch:{ all -> 0x0015 }
                    java.lang.String r1 = "Failed to mix seed into "
                    r4.append(r1)     // Catch:{ all -> 0x0015 }
                    java.io.File r1 = f973a     // Catch:{ all -> 0x0015 }
                    r4.append(r1)     // Catch:{ all -> 0x0015 }
                    r4.toString()     // Catch:{ all -> 0x0015 }
                    goto L_0x000f
                L_0x002a:
                    return
                L_0x002b:
                    r3.f977e = r0
                    throw r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mpl.securepreferences.a.b.C0001a.engineSetSeed(byte[]):void");
            }
        }

        /* renamed from: com.mpl.securepreferences.a$b$b  reason: collision with other inner class name */
        /* compiled from: AesCbcWithIntegrity */
        public static class C0002b extends Provider {
            public C0002b() {
                super("LinuxPRNG", 1.0d, "A Linux-specific random number provider that uses /dev/urandom");
                put("SecureRandom.SHA1PRNG", C0001a.class.getName());
                put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
            }
        }

        public static void a() {
            c();
            d();
        }

        public static void c() {
        }

        public static void d() {
        }

        public static byte[] e() {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeLong(System.currentTimeMillis());
                dataOutputStream.writeLong(System.nanoTime());
                dataOutputStream.writeInt(Process.myPid());
                dataOutputStream.writeInt(Process.myUid());
                dataOutputStream.write(f972a);
                dataOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e2) {
                throw new SecurityException("Failed to generate seed", e2);
            }
        }

        public static String f() {
            try {
                return (String) Build.class.getField("SERIAL").get(null);
            } catch (Exception unused) {
                return null;
            }
        }

        public static byte[] g() {
            StringBuilder sb = new StringBuilder();
            String str = Build.FINGERPRINT;
            if (str != null) {
                sb.append(str);
            }
            String f2 = f();
            if (f2 != null) {
                sb.append(f2);
            }
            return sb.toString().getBytes(StandardCharsets.UTF_8);
        }
    }

    /* compiled from: AesCbcWithIntegrity */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public SecretKey f978a;

        /* renamed from: b  reason: collision with root package name */
        public SecretKey f979b;

        public c(SecretKey secretKey, SecretKey secretKey2) {
            a(secretKey);
            b(secretKey2);
        }

        public SecretKey a() {
            return this.f978a;
        }

        public SecretKey b() {
            return this.f979b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (!this.f979b.equals(cVar.f979b)) {
                return false;
            }
            return this.f978a.equals(cVar.f978a);
        }

        public int hashCode() {
            return this.f979b.hashCode() + ((this.f978a.hashCode() + 31) * 31);
        }

        public String toString() {
            return Base64.encodeToString(a().getEncoded(), 2) + ":" + Base64.encodeToString(b().getEncoded(), 2);
        }

        public void a(SecretKey secretKey) {
            this.f978a = secretKey;
        }

        public void b(SecretKey secretKey) {
            this.f979b = secretKey;
        }
    }

    public static c a(String str) {
        String[] split = str.split(":");
        if (split.length == 2) {
            byte[] decode = Base64.decode(split[0], 2);
            if (decode.length == 16) {
                byte[] decode2 = Base64.decode(split[1], 2);
                if (decode2.length == 32) {
                    return new c(new SecretKeySpec(decode, 0, decode.length, EncryptionHelper.algorithm), new SecretKeySpec(decode2, "HmacSHA256"));
                }
                throw new InvalidKeyException("Base64 decoded key is not 256 bytes");
            }
            throw new InvalidKeyException("Base64 decoded key is not 128 bytes");
        }
        throw new IllegalArgumentException("Cannot parse aesKey:hmacKey");
    }

    public static byte[] b() {
        return a(16);
    }

    public static void c() {
        if (!f968a.get()) {
            synchronized (b.class) {
                if (!f968a.get()) {
                    b.a();
                    f968a.set(true);
                }
            }
        }
    }

    public static byte[] b(C0000a aVar, c cVar) {
        if (a(a(C0000a.a(aVar.b(), aVar.a()), cVar.b()), aVar.c())) {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, cVar.a(), new IvParameterSpec(aVar.b()));
            return instance.doFinal(aVar.a());
        }
        throw new GeneralSecurityException("MAC stored in civ does not match computed MAC.");
    }

    public static c a() {
        c();
        KeyGenerator instance = KeyGenerator.getInstance(EncryptionHelper.algorithm);
        instance.init(128);
        return new c(instance.generateKey(), new SecretKeySpec(a(32), "HmacSHA256"));
    }

    public static c a(String str, byte[] bArr, int i) {
        c();
        byte[] encoded = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(str.toCharArray(), bArr, i, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT)).getEncoded();
        return new c(new SecretKeySpec(a(encoded, 0, 16), EncryptionHelper.algorithm), new SecretKeySpec(a(encoded, 16, 48), "HmacSHA256"));
    }

    public static byte[] a(int i) {
        c();
        byte[] bArr = new byte[i];
        SecureRandom.getInstance("SHA1PRNG").nextBytes(bArr);
        return bArr;
    }

    public static C0000a a(String str, c cVar) {
        return a(str, cVar, (String) "UTF-8");
    }

    public static C0000a a(String str, c cVar, String str2) {
        return a(str.getBytes(str2), cVar);
    }

    public static C0000a a(byte[] bArr, c cVar) {
        byte[] b2 = b();
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, cVar.a(), new IvParameterSpec(b2));
        byte[] iv = instance.getIV();
        byte[] doFinal = instance.doFinal(bArr);
        return new C0000a(doFinal, iv, a(C0000a.a(iv, doFinal), cVar.b()));
    }

    public static String a(C0000a aVar, c cVar, String str) {
        return new String(b(aVar, cVar), str);
    }

    public static String a(C0000a aVar, c cVar) {
        return a(aVar, cVar, (String) "UTF-8");
    }

    public static byte[] a(byte[] bArr, SecretKey secretKey) {
        Mac instance = Mac.getInstance("HmacSHA256");
        instance.init(secretKey);
        return instance.doFinal(bArr);
    }

    public static boolean a(byte[] bArr, byte[] bArr2) {
        boolean z = false;
        if (bArr.length != bArr2.length) {
            return false;
        }
        byte b2 = 0;
        for (int i = 0; i < bArr.length; i++) {
            b2 |= bArr[i] ^ bArr2[i];
        }
        if (b2 == 0) {
            z = true;
        }
        return z;
    }

    public static byte[] a(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, i3);
        return bArr2;
    }
}
