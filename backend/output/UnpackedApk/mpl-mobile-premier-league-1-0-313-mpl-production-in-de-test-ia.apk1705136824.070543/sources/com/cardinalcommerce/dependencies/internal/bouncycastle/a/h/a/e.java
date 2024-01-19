package com.cardinalcommerce.dependencies.internal.bouncycastle.a.h.a;

import co.hyperverge.hypersnapsdk.c.k;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f1909a;

    /* renamed from: b  reason: collision with root package name */
    public long[][] f1910b;

    public void b(byte[] bArr) {
        byte[] bArr2 = bArr;
        long[] jArr = this.f1910b[bArr2[15] & 255];
        long j = jArr[0];
        long j2 = jArr[1];
        for (int i = 14; i >= 0; i--) {
            long[] jArr2 = this.f1910b[bArr2[i] & 255];
            long j3 = j2 << 56;
            j2 = ((j2 >>> 8) | (j << 56)) ^ jArr2[1];
            j = (((((j >>> 8) ^ jArr2[0]) ^ j3) ^ (j3 >>> 1)) ^ (j3 >>> 2)) ^ (j3 >>> 7);
        }
        k.a(j, bArr2, 0);
        k.a(j2, bArr2, 8);
    }
}
