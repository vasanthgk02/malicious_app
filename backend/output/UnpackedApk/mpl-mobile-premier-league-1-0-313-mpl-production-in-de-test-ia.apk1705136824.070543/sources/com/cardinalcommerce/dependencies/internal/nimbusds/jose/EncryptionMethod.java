package com.cardinalcommerce.dependencies.internal.nimbusds.jose;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;

public final class EncryptionMethod extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final EncryptionMethod f1944b = new EncryptionMethod("A128CBC-HS256", m.REQUIRED, 256);

    /* renamed from: c  reason: collision with root package name */
    public static final EncryptionMethod f1945c = new EncryptionMethod("A192CBC-HS384", m.OPTIONAL, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT);

    /* renamed from: d  reason: collision with root package name */
    public static final EncryptionMethod f1946d = new EncryptionMethod("A256CBC-HS512", m.REQUIRED, 512);

    /* renamed from: e  reason: collision with root package name */
    public static final EncryptionMethod f1947e = new EncryptionMethod("A128CBC+HS256", m.OPTIONAL, 256);

    /* renamed from: f  reason: collision with root package name */
    public static final EncryptionMethod f1948f = new EncryptionMethod("A256CBC+HS512", m.OPTIONAL, 512);
    public static final EncryptionMethod g = new EncryptionMethod("A128GCM", m.RECOMMENDED, 128);
    public static final EncryptionMethod h = new EncryptionMethod("A192GCM", m.OPTIONAL, 192);
    public static final EncryptionMethod i = new EncryptionMethod("A256GCM", m.RECOMMENDED, 256);
    public final int j;

    public EncryptionMethod(String str) {
        super(str, null);
        this.j = 0;
    }

    public EncryptionMethod(String str, m mVar, int i2) {
        super(str, mVar);
        this.j = i2;
    }
}
