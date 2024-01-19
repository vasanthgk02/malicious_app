package com.cardinalcommerce.dependencies.internal.bouncycastle.a.j;

import com.cardinalcommerce.dependencies.internal.bouncycastle.a.g;

public class ay implements g {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f1917a;

    public ay(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        this.f1917a = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, length);
    }
}
