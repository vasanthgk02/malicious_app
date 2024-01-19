package org.spongycastle.crypto.digests;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.apache.fontbox.ttf.GlyfDescript;

public class SHA1Digest extends GeneralDigest {
    public int H1;
    public int H2;
    public int H3;
    public int H4;
    public int H5;
    public int[] X = new int[80];
    public int xOff;

    public SHA1Digest() {
        reset();
    }

    public int doFinal(byte[] bArr, int i) {
        finish();
        TypeUtilsKt.intToBigEndian(this.H1, bArr, i);
        TypeUtilsKt.intToBigEndian(this.H2, bArr, i + 4);
        TypeUtilsKt.intToBigEndian(this.H3, bArr, i + 8);
        TypeUtilsKt.intToBigEndian(this.H4, bArr, i + 12);
        TypeUtilsKt.intToBigEndian(this.H5, bArr, i + 16);
        reset();
        return 20;
    }

    public final int f(int i, int i2, int i3) {
        return ((~i) & i3) | (i2 & i);
    }

    public final int g(int i, int i2, int i3) {
        return (i & i3) | (i & i2) | (i2 & i3);
    }

    public int getDigestSize() {
        return 20;
    }

    public void processBlock() {
        for (int i = 16; i < 80; i++) {
            int[] iArr = this.X;
            int i2 = ((iArr[i - 3] ^ iArr[i - 8]) ^ iArr[i - 14]) ^ iArr[i - 16];
            iArr[i] = (i2 >>> 31) | (i2 << 1);
        }
        int i3 = this.H1;
        int i4 = this.H2;
        int i5 = this.H3;
        int i6 = this.H4;
        int i7 = this.H5;
        int i8 = 0;
        int i9 = 0;
        while (i8 < 4) {
            int i10 = i9 + 1;
            int outline6 = GeneratedOutlineSupport.outline6(f(i4, i5, i6) + ((i3 << 5) | (i3 >>> 27)), this.X[i9], 1518500249, i7);
            int i11 = (i4 >>> 2) | (i4 << 30);
            int i12 = i10 + 1;
            int outline62 = GeneratedOutlineSupport.outline6(f(i3, i11, i5) + ((outline6 << 5) | (outline6 >>> 27)), this.X[i10], 1518500249, i6);
            int i13 = (i3 >>> 2) | (i3 << 30);
            int i14 = i12 + 1;
            int outline63 = GeneratedOutlineSupport.outline6(f(outline6, i13, i11) + ((outline62 << 5) | (outline62 >>> 27)), this.X[i12], 1518500249, i5);
            i7 = (outline6 >>> 2) | (outline6 << 30);
            int i15 = i14 + 1;
            i4 = GeneratedOutlineSupport.outline6(f(outline62, i7, i13) + ((outline63 << 5) | (outline63 >>> 27)), this.X[i14], 1518500249, i11);
            i6 = (outline62 >>> 2) | (outline62 << 30);
            i3 = GeneratedOutlineSupport.outline6(f(outline63, i6, i7) + ((i4 << 5) | (i4 >>> 27)), this.X[i15], 1518500249, i13);
            i5 = (outline63 >>> 2) | (outline63 << 30);
            i8++;
            i9 = i15 + 1;
        }
        int i16 = 0;
        while (i16 < 4) {
            int[] iArr2 = this.X;
            int i17 = i9 + 1;
            int outline64 = GeneratedOutlineSupport.outline6(((i3 << 5) | (i3 >>> 27)) + ((i4 ^ i5) ^ i6), iArr2[i9], 1859775393, i7);
            int i18 = (i4 >>> 2) | (i4 << 30);
            int i19 = i17 + 1;
            int outline65 = GeneratedOutlineSupport.outline6(((outline64 << 5) | (outline64 >>> 27)) + ((i3 ^ i18) ^ i5), iArr2[i17], 1859775393, i6);
            int i20 = (i3 >>> 2) | (i3 << 30);
            int i21 = i19 + 1;
            int outline66 = GeneratedOutlineSupport.outline6(((outline65 << 5) | (outline65 >>> 27)) + ((outline64 ^ i20) ^ i18), iArr2[i19], 1859775393, i5);
            i7 = (outline64 >>> 2) | (outline64 << 30);
            int i22 = i21 + 1;
            i4 = GeneratedOutlineSupport.outline6(((outline66 << 5) | (outline66 >>> 27)) + ((outline65 ^ i7) ^ i20), iArr2[i21], 1859775393, i18);
            i6 = (outline65 >>> 2) | (outline65 << 30);
            i3 = GeneratedOutlineSupport.outline6(((i4 << 5) | (i4 >>> 27)) + ((outline66 ^ i6) ^ i7), iArr2[i22], 1859775393, i20);
            i5 = (outline66 >>> 2) | (outline66 << 30);
            i16++;
            i9 = i22 + 1;
        }
        int i23 = 0;
        while (i23 < 4) {
            int i24 = i9 + 1;
            int outline67 = GeneratedOutlineSupport.outline6(g(i4, i5, i6) + ((i3 << 5) | (i3 >>> 27)), this.X[i9], -1894007588, i7);
            int i25 = (i4 >>> 2) | (i4 << 30);
            int i26 = i24 + 1;
            int outline68 = GeneratedOutlineSupport.outline6(g(i3, i25, i5) + ((outline67 << 5) | (outline67 >>> 27)), this.X[i24], -1894007588, i6);
            int i27 = (i3 >>> 2) | (i3 << 30);
            int i28 = i26 + 1;
            int outline69 = GeneratedOutlineSupport.outline6(g(outline67, i27, i25) + ((outline68 << 5) | (outline68 >>> 27)), this.X[i26], -1894007588, i5);
            i7 = (outline67 >>> 2) | (outline67 << 30);
            int i29 = i28 + 1;
            i4 = GeneratedOutlineSupport.outline6(g(outline68, i7, i27) + ((outline69 << 5) | (outline69 >>> 27)), this.X[i28], -1894007588, i25);
            i6 = (outline68 >>> 2) | (outline68 << 30);
            i3 = GeneratedOutlineSupport.outline6(g(outline69, i6, i7) + ((i4 << 5) | (i4 >>> 27)), this.X[i29], -1894007588, i27);
            i5 = (outline69 >>> 2) | (outline69 << 30);
            i23++;
            i9 = i29 + 1;
        }
        int i30 = 0;
        while (i30 <= 3) {
            int[] iArr3 = this.X;
            int i31 = i9 + 1;
            int outline610 = GeneratedOutlineSupport.outline6(((i3 << 5) | (i3 >>> 27)) + ((i4 ^ i5) ^ i6), iArr3[i9], -899497514, i7);
            int i32 = (i4 >>> 2) | (i4 << 30);
            int i33 = i31 + 1;
            int outline611 = GeneratedOutlineSupport.outline6(((outline610 << 5) | (outline610 >>> 27)) + ((i3 ^ i32) ^ i5), iArr3[i31], -899497514, i6);
            int i34 = (i3 >>> 2) | (i3 << 30);
            int i35 = i33 + 1;
            int outline612 = GeneratedOutlineSupport.outline6(((outline611 << 5) | (outline611 >>> 27)) + ((outline610 ^ i34) ^ i32), iArr3[i33], -899497514, i5);
            i7 = (outline610 >>> 2) | (outline610 << 30);
            int i36 = i35 + 1;
            i4 = GeneratedOutlineSupport.outline6(((outline612 << 5) | (outline612 >>> 27)) + ((outline611 ^ i7) ^ i34), iArr3[i35], -899497514, i32);
            i6 = (outline611 >>> 2) | (outline611 << 30);
            i3 = GeneratedOutlineSupport.outline6(((i4 << 5) | (i4 >>> 27)) + ((outline612 ^ i6) ^ i7), iArr3[i36], -899497514, i34);
            i5 = (outline612 >>> 2) | (outline612 << 30);
            i30++;
            i9 = i36 + 1;
        }
        this.H1 += i3;
        this.H2 += i4;
        this.H3 += i5;
        this.H4 += i6;
        this.H5 += i7;
        this.xOff = 0;
        for (int i37 = 0; i37 < 16; i37++) {
            this.X[i37] = 0;
        }
    }

    public void processLength(long j) {
        if (this.xOff > 14) {
            processBlock();
        }
        int[] iArr = this.X;
        iArr[14] = (int) (j >>> 32);
        iArr[15] = (int) (j & -1);
    }

    public void processWord(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i3 + 1] & 255) | (bArr[i] << 24) | ((bArr[i2] & 255) << GlyfDescript.X_DUAL) | ((bArr[i3] & 255) << 8);
        int[] iArr = this.X;
        int i5 = this.xOff;
        iArr[i5] = i4;
        int i6 = i5 + 1;
        this.xOff = i6;
        if (i6 == 16) {
            processBlock();
        }
    }

    public void reset() {
        super.reset();
        this.H1 = 1732584193;
        this.H2 = -271733879;
        this.H3 = -1732584194;
        this.H4 = 271733878;
        this.H5 = -1009589776;
        this.xOff = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.X;
            if (i != iArr.length) {
                iArr[i] = 0;
                i++;
            } else {
                return;
            }
        }
    }
}
