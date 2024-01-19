package com.xiaomi.push;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class bm {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f4499a = {80, 85, 83, 72};

    /* renamed from: a  reason: collision with other field name */
    public byte f369a;

    /* renamed from: a  reason: collision with other field name */
    public int f370a;

    /* renamed from: a  reason: collision with other field name */
    public short f371a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f4500b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f4501a = new c();

        /* renamed from: a  reason: collision with other field name */
        public static final d f372a = new d();

        public static byte[] a(byte[] bArr) {
            return a(bArr, f372a);
        }

        public static byte[] a(byte[] bArr, b bVar) {
            if (bm.a(bArr)) {
                bm a2 = bm.a(bArr);
                if (bm.a(a2) != 0 && bm.a(a2) == bVar.a()) {
                    return bVar.a(bm.a(a2), bm.a(a2));
                }
                bArr = bm.a(a2);
            }
            return bArr;
        }
    }

    public interface b {
        byte a();

        byte[] a(byte[] bArr, int i);
    }

    public static final class c {
    }

    public static final class d implements b {
        public byte a() {
            return 2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x001c A[SYNTHETIC, Splitter:B:15:0x001c] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0023 A[SYNTHETIC, Splitter:B:21:0x0023] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public byte[] a(byte[] r4, int r5) {
            /*
                r3 = this;
                r0 = 0
                java.util.zip.GZIPInputStream r1 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0020, all -> 0x0019 }
                java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0020, all -> 0x0019 }
                r2.<init>(r4)     // Catch:{ IOException -> 0x0020, all -> 0x0019 }
                r1.<init>(r2, r5)     // Catch:{ IOException -> 0x0020, all -> 0x0019 }
                byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x0017, all -> 0x0014 }
                r1.read(r5)     // Catch:{ IOException -> 0x0017, all -> 0x0014 }
                r1.close()     // Catch:{ IOException -> 0x0013 }
            L_0x0013:
                return r5
            L_0x0014:
                r4 = move-exception
                r0 = r1
                goto L_0x001a
            L_0x0017:
                r0 = r1
                goto L_0x0021
            L_0x0019:
                r4 = move-exception
            L_0x001a:
                if (r0 == 0) goto L_0x001f
                r0.close()     // Catch:{ IOException -> 0x001f }
            L_0x001f:
                throw r4
            L_0x0020:
            L_0x0021:
                if (r0 == 0) goto L_0x0026
                r0.close()     // Catch:{ IOException -> 0x0026 }
            L_0x0026:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.bm.d.a(byte[], int):byte[]");
        }
    }

    public bm(byte b2, int i, byte[] bArr) {
        this(1, b2, i, bArr);
    }

    public bm(short s, byte b2, int i, byte[] bArr) {
        this.f371a = 1;
        this.f371a = s;
        this.f369a = b2;
        this.f370a = i;
        this.f4500b = bArr;
    }

    public static bm a(byte b2, int i, byte[] bArr) {
        return new bm(b2, i, bArr);
    }

    public static bm a(short s, byte b2, int i, byte[] bArr) {
        return new bm(s, b2, i, bArr);
    }

    public static bm a(byte[] bArr) {
        if (!a(bArr)) {
            return a(0, bArr.length, bArr);
        }
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
        order.getInt();
        short s = order.getShort();
        byte b2 = order.get();
        int i = order.getInt();
        byte[] bArr2 = new byte[order.getInt()];
        order.get(bArr2);
        return a(s, b2, i, bArr2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m527a(byte[] bArr) {
        byte[] bArr2 = f4499a;
        return a(bArr2, bArr, bArr2.length);
    }

    public static boolean a(byte[] bArr, byte[] bArr2, int i) {
        if (bArr.length < i || bArr2.length < i) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
