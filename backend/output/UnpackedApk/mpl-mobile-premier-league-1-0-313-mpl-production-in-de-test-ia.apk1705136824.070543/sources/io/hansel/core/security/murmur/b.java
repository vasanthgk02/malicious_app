package io.hansel.core.security.murmur;

import org.apache.fontbox.ttf.GlyfDescript;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f5224a;

    /* renamed from: b  reason: collision with root package name */
    public static final b f5225b;

    /* renamed from: io.hansel.core.security.murmur.b$b  reason: collision with other inner class name */
    public static class C0078b extends b {
        public C0078b() {
        }

        public int a(byte[] bArr, int i) {
            return (bArr[i + 3] << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << GlyfDescript.X_DUAL);
        }
    }

    static {
        C0078b bVar = new C0078b();
        f5225b = bVar;
        f5224a = bVar;
    }

    public static b a() {
        return f5224a;
    }

    public abstract int a(byte[] bArr, int i);
}
