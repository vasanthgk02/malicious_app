package com.userexperior.a.a;

import com.userexperior.a.a.b.a;
import com.userexperior.a.a.b.i;
import java.math.BigInteger;

public final class q extends l {

    /* renamed from: b  reason: collision with root package name */
    public static final Class<?>[] f3760b = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};

    /* renamed from: a  reason: collision with root package name */
    public Object f3761a;

    public q(Boolean bool) {
        a((Object) bool);
    }

    public q(Number number) {
        a((Object) number);
    }

    public q(String str) {
        a((Object) str);
    }

    private void a(Object obj) {
        if (obj instanceof Character) {
            obj = String.valueOf(((Character) obj).charValue());
        } else {
            a.a((obj instanceof Number) || b(obj));
        }
        this.f3761a = obj;
    }

    public static boolean a(q qVar) {
        Object obj = qVar.f3761a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public static boolean b(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> isAssignableFrom : f3760b) {
            if (isAssignableFrom.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public final Number a() {
        Object obj = this.f3761a;
        return obj instanceof String ? new i((String) this.f3761a) : (Number) obj;
    }

    public final String b() {
        Object obj = this.f3761a;
        return obj instanceof Number ? a().toString() : obj instanceof Boolean ? ((Boolean) obj).toString() : (String) obj;
    }

    public final double c() {
        return this.f3761a instanceof Number ? a().doubleValue() : Double.parseDouble(b());
    }

    public final long d() {
        return this.f3761a instanceof Number ? a().longValue() : Long.parseLong(b());
    }

    public final int e() {
        return this.f3761a instanceof Number ? a().intValue() : Integer.parseInt(b());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q.class != obj.getClass()) {
            return false;
        }
        q qVar = (q) obj;
        if (this.f3761a == null) {
            return qVar.f3761a == null;
        }
        if (a(this) && a(qVar)) {
            return a().longValue() == qVar.a().longValue();
        }
        if (!(this.f3761a instanceof Number) || !(qVar.f3761a instanceof Number)) {
            return this.f3761a.equals(qVar.f3761a);
        }
        double doubleValue = a().doubleValue();
        double doubleValue2 = qVar.a().doubleValue();
        return doubleValue == doubleValue2 || (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2));
    }

    public final boolean f() {
        Object obj = this.f3761a;
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean(b());
    }

    public final int hashCode() {
        long doubleToLongBits;
        if (this.f3761a == null) {
            return 31;
        }
        if (a(this)) {
            doubleToLongBits = a().longValue();
        } else {
            Object obj = this.f3761a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(a().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }
}
