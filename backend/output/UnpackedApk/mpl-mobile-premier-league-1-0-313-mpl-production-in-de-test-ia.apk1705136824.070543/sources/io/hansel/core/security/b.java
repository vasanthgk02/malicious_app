package io.hansel.core.security;

import io.hansel.core.security.murmur.a;
import io.hansel.core.utils.HSLUtils;
import java.util.Objects;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final c f5217a;

    public b(String str) {
        this.f5217a = (!Objects.equals(str, "AES/GCM/NoPadding") || HSLUtils.isAndroidOSLessThanVersion(23)) ? null : new a();
    }

    public static b a(String str) {
        return new b(str);
    }

    public static long b(String str) {
        a aVar = new a();
        aVar.a(str.getBytes());
        return aVar.getValue();
    }

    public c a() {
        return this.f5217a;
    }
}
