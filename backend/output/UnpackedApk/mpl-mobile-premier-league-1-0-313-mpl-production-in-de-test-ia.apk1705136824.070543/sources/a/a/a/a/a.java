package a.a.a.a;

import android.util.Base64;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.pdfbox.pdfparser.BaseParser;

public class a {
    public static a k;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f2386a = {91, -84, 75, -124, -122, -82, -53, -72, 98, BaseParser.ASCII_ZERO, 52, 32, 108, 8, -83, -87};

    /* renamed from: b  reason: collision with root package name */
    public Mac f2387b;

    /* renamed from: c  reason: collision with root package name */
    public String f2388c = "V1.";

    /* renamed from: d  reason: collision with root package name */
    public long f2389d;

    /* renamed from: e  reason: collision with root package name */
    public Random f2390e = new SecureRandom();

    /* renamed from: f  reason: collision with root package name */
    public MessageDigest f2391f;
    public boolean g;
    public boolean h;
    public long i;
    public String j;

    public a() {
        try {
            this.f2391f = MessageDigest.getInstance("MD5");
            this.g = true;
            this.f2388c += "1";
        } catch (NoSuchAlgorithmException e2) {
            this.f2388c = GeneratedOutlineSupport.outline62(new StringBuilder(), this.f2388c, "0");
            e2.printStackTrace();
        }
        try {
            int length = this.f2386a.length * 2;
            byte[] bArr = new byte[length];
            int i2 = 0;
            for (byte b2 : this.f2386a) {
                int i3 = i2 + 1;
                bArr[i2] = b2;
                i2 = i3 + 1;
                bArr[length - i3] = (byte) (~b2);
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "HmacSHA1");
            Mac instance = Mac.getInstance("HmacSHA1");
            this.f2387b = instance;
            instance.init(secretKeySpec);
            this.h = true;
            this.f2388c += "1";
        } catch (Exception e3) {
            this.f2388c = GeneratedOutlineSupport.outline62(new StringBuilder(), this.f2388c, "0");
            e3.printStackTrace();
        }
    }

    public String a() {
        String str;
        byte[] bArr;
        long j2;
        Object[] objArr = new Object[2];
        objArr[0] = this.f2388c;
        long currentTimeMillis = (((System.currentTimeMillis() - 1033410600000L) + this.f2389d) / 1000) / 60;
        if (currentTimeMillis > this.i) {
            byte[] bArr2 = new byte[16];
            this.f2390e.nextBytes(bArr2);
            if (!this.h) {
                str = GeneratedOutlineSupport.outline45("", currentTimeMillis);
            } else {
                byte[] bArr3 = new byte[8];
                int i2 = 7;
                long j3 = currentTimeMillis;
                while (true) {
                    j2 = 0;
                    if (j3 <= 0) {
                        break;
                    }
                    bArr3[i2] = (byte) ((int) (255 & j3));
                    j3 >>= 8;
                    i2--;
                }
                byte[] doFinal = this.f2387b.doFinal(bArr3);
                byte b2 = doFinal[doFinal.length - 1] & 15;
                for (int i3 = b2; i3 < b2 + 4; i3++) {
                    j2 = (j2 << 8) | ((long) (doFinal[i3] & 255));
                }
                str = GeneratedOutlineSupport.outline45("", (2147483647L & j2) % 1000000);
            }
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            if (!this.g) {
                bArr = new byte[16];
                int length = bytes.length;
                int i4 = 0;
                int i5 = 0;
                while (i4 < length) {
                    bArr[i5] = bytes[i4];
                    i4++;
                    i5++;
                }
            } else {
                byte[] bArr4 = new byte[(bytes.length + 16)];
                int i6 = 0;
                int i7 = 0;
                while (i6 < 16) {
                    bArr4[i7] = bArr2[i6];
                    i6++;
                    i7++;
                }
                int length2 = bytes.length;
                int i8 = 0;
                while (i8 < length2) {
                    bArr4[i7] = bytes[i8];
                    i8++;
                    i7++;
                }
                bArr = this.f2391f.digest(bArr4);
            }
            byte[] bArr5 = new byte[(bArr.length + 16)];
            int i9 = 0;
            int i10 = 0;
            while (i9 < 16) {
                bArr5[i10] = bArr2[i9];
                i9++;
                i10++;
            }
            int length3 = bArr.length;
            int i11 = 0;
            while (i11 < length3) {
                bArr5[i10] = bArr[i11];
                i11++;
                i10++;
            }
            this.i = currentTimeMillis;
            this.j = Base64.encodeToString(bArr5, 2);
        }
        objArr[1] = this.j;
        return String.format("%s%s", objArr);
    }
}
