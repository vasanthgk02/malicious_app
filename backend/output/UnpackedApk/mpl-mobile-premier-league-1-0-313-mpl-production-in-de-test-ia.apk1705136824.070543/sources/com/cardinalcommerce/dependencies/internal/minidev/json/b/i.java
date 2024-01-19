package com.cardinalcommerce.dependencies.internal.minidev.json.b;

public class i extends Exception {

    /* renamed from: b  reason: collision with root package name */
    public Object f1927b;

    public i(int i, int i2, Object obj) {
        super(a(i, i2, obj));
        this.f1927b = obj;
    }

    public i(int i, Throwable th) {
        super(a(i, 2, th), th);
    }

    public static String a(int i, int i2, Object obj) {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        if (i2 == 0) {
            sb.append("Unexpected character (");
            sb.append(obj);
            str = ") at position ";
        } else {
            if (i2 == 1) {
                str2 = "Unexpected token ";
            } else if (i2 == 2) {
                sb.append("Unexpected exception ");
                sb.append(obj);
                str = " occur at position ";
            } else if (i2 == 3) {
                sb.append("Unexpected End Of File position ");
                sb.append(i);
                sb.append(": ");
                sb.append(obj);
                return sb.toString();
            } else if (i2 == 4) {
                str2 = "Unexpected unicode escape sequence ";
            } else if (i2 == 5) {
                str2 = "Unexpected duplicate key:";
            } else if (i2 == 6) {
                str2 = "Unexpected leading 0 in digit for token:";
            } else {
                str = "Unkown error at position ";
            }
            sb.append(str2);
            sb.append(obj);
            sb.append(" at position ");
            sb.append(i);
            sb.append(".");
            return sb.toString();
        }
        sb.append(str);
        sb.append(i);
        sb.append(".");
        return sb.toString();
    }
}
