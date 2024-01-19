package com.userexperior.e;

import java.lang.ref.SoftReference;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>> f4001a = new ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>>() {
        public final /* synthetic */ Object initialValue() {
            return new SoftReference(new HashMap());
        }
    };

    public static SimpleDateFormat a(String str) {
        Map map = (Map) f4001a.get().get();
        if (map == null) {
            map = new HashMap();
            f4001a.set(new SoftReference(map));
        }
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) map.get(str);
        if (simpleDateFormat != null) {
            return simpleDateFormat;
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT"));
        map.put(str, simpleDateFormat2);
        return simpleDateFormat2;
    }
}
