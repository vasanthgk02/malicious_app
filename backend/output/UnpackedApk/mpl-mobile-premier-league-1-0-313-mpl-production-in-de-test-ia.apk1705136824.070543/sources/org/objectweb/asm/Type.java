package org.objectweb.asm;

import com.smartfoxserver.v2.protocol.serialization.DefaultObjectDumpFormatter;
import java.lang.reflect.Method;

public class Type {
    public static final Type BOOLEAN_TYPE = new Type(1, null, 1509950721, 1);
    public static final Type BYTE_TYPE = new Type(3, null, 1107297537, 1);
    public static final Type CHAR_TYPE = new Type(2, null, 1124075009, 1);
    public static final Type DOUBLE_TYPE = new Type(8, null, 1141048066, 1);
    public static final Type FLOAT_TYPE = new Type(6, null, 1174536705, 1);
    public static final Type INT_TYPE = new Type(5, null, 1224736769, 1);
    public static final Type LONG_TYPE = new Type(7, null, 1241579778, 1);
    public static final Type SHORT_TYPE = new Type(4, null, 1392510721, 1);
    public static final Type VOID_TYPE = new Type(0, null, 1443168256, 1);

    /* renamed from: a  reason: collision with root package name */
    public final int f6241a;

    /* renamed from: b  reason: collision with root package name */
    public final char[] f6242b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6243c;

    /* renamed from: d  reason: collision with root package name */
    public final int f6244d;

    public Type(int i, char[] cArr, int i2, int i3) {
        this.f6241a = i;
        this.f6242b = cArr;
        this.f6243c = i2;
        this.f6244d = i3;
    }

    public static Type a(char[] cArr, int i) {
        int i2;
        char c2 = cArr[i];
        if (c2 == 'F') {
            return FLOAT_TYPE;
        }
        if (c2 == 'L') {
            int i3 = 1;
            while (cArr[i + i3] != ';') {
                i3++;
            }
            return new Type(10, cArr, i + 1, i3 - 1);
        } else if (c2 == 'S') {
            return SHORT_TYPE;
        } else {
            if (c2 == 'V') {
                return VOID_TYPE;
            }
            if (c2 == 'I') {
                return INT_TYPE;
            }
            if (c2 == 'J') {
                return LONG_TYPE;
            }
            if (c2 == 'Z') {
                return BOOLEAN_TYPE;
            }
            if (c2 != '[') {
                switch (c2) {
                    case 'B':
                        return BYTE_TYPE;
                    case 'C':
                        return CHAR_TYPE;
                    case 'D':
                        return DOUBLE_TYPE;
                    default:
                        return new Type(11, cArr, i, cArr.length - i);
                }
            } else {
                int i4 = 1;
                while (true) {
                    i2 = i + i4;
                    if (cArr[i2] != '[') {
                        break;
                    }
                    i4++;
                }
                if (cArr[i2] == 'L') {
                    do {
                        i4++;
                    } while (cArr[i + i4] != ';');
                }
                return new Type(9, cArr, i, i4 + 1);
            }
        }
    }

    public static void a(StringBuffer stringBuffer, Class<?> cls) {
        while (!cls.isPrimitive()) {
            if (cls.isArray()) {
                stringBuffer.append('[');
                cls = cls.getComponentType();
            } else {
                stringBuffer.append('L');
                String name = cls.getName();
                int length = name.length();
                for (int i = 0; i < length; i++) {
                    char charAt = name.charAt(i);
                    if (charAt == '.') {
                        charAt = '/';
                    }
                    stringBuffer.append(charAt);
                }
                stringBuffer.append(DefaultObjectDumpFormatter.TOKEN_DIVIDER);
                return;
            }
        }
        stringBuffer.append(cls == Integer.TYPE ? 'I' : cls == Void.TYPE ? 'V' : cls == Boolean.TYPE ? 'Z' : cls == Byte.TYPE ? 'B' : cls == Character.TYPE ? 'C' : cls == Short.TYPE ? 'S' : cls == Double.TYPE ? 'D' : cls == Float.TYPE ? 'F' : 'J');
    }

    public static Type[] getArgumentTypes(String str) {
        char[] charArray = str.toCharArray();
        int i = 1;
        int i2 = 1;
        int i3 = 0;
        while (true) {
            int i4 = i2 + 1;
            char c2 = charArray[i2];
            if (c2 == ')') {
                break;
            } else if (c2 == 'L') {
                while (true) {
                    i2 = i4 + 1;
                    if (charArray[i4] == ';') {
                        break;
                    }
                    i4 = i2;
                }
                i3++;
            } else {
                if (c2 != '[') {
                    i3++;
                }
                i2 = i4;
            }
        }
        Type[] typeArr = new Type[i3];
        int i5 = 0;
        while (charArray[i] != ')') {
            typeArr[i5] = a(charArray, i);
            i += typeArr[i5].f6244d + (typeArr[i5].f6241a == 10 ? 2 : 0);
            i5++;
        }
        return typeArr;
    }

    public static int getArgumentsAndReturnSizes(String str) {
        int i;
        char charAt;
        int i2 = 1;
        int i3 = 1;
        int i4 = 1;
        while (true) {
            i = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 == ')') {
                break;
            } else if (charAt2 == 'L') {
                while (true) {
                    i3 = i + 1;
                    if (str.charAt(i) == ';') {
                        break;
                    }
                    i = i3;
                }
                i4++;
            } else {
                if (charAt2 == '[') {
                    while (true) {
                        charAt = str.charAt(i);
                        if (charAt != '[') {
                            break;
                        }
                        i++;
                    }
                    if (charAt == 'D' || charAt == 'J') {
                        i4--;
                    }
                } else {
                    i4 = (charAt2 == 'D' || charAt2 == 'J') ? i4 + 2 : i4 + 1;
                }
                i3 = i;
            }
        }
        char charAt3 = str.charAt(i);
        int i5 = i4 << 2;
        if (charAt3 == 'V') {
            i2 = 0;
        } else if (charAt3 == 'D' || charAt3 == 'J') {
            i2 = 2;
        }
        return i5 | i2;
    }

    public static String getInternalName(Class cls) {
        return cls.getName().replace('.', '/');
    }

    public static String getMethodDescriptor(Method method) {
        Class[] parameterTypes = method.getParameterTypes();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(');
        for (Class a2 : parameterTypes) {
            a(stringBuffer, a2);
        }
        stringBuffer.append(')');
        a(stringBuffer, (Class) method.getReturnType());
        return stringBuffer.toString();
    }

    public static Type getType(Class cls) {
        if (!cls.isPrimitive()) {
            StringBuffer stringBuffer = new StringBuffer();
            a(stringBuffer, cls);
            return a(stringBuffer.toString().toCharArray(), 0);
        } else if (cls == Integer.TYPE) {
            return INT_TYPE;
        } else {
            if (cls == Void.TYPE) {
                return VOID_TYPE;
            }
            if (cls == Boolean.TYPE) {
                return BOOLEAN_TYPE;
            }
            if (cls == Byte.TYPE) {
                return BYTE_TYPE;
            }
            if (cls == Character.TYPE) {
                return CHAR_TYPE;
            }
            if (cls == Short.TYPE) {
                return SHORT_TYPE;
            }
            if (cls == Double.TYPE) {
                return DOUBLE_TYPE;
            }
            return cls == Float.TYPE ? FLOAT_TYPE : LONG_TYPE;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Type)) {
            return false;
        }
        Type type = (Type) obj;
        int i = this.f6241a;
        if (i != type.f6241a) {
            return false;
        }
        if (i >= 9) {
            int i2 = this.f6244d;
            if (i2 != type.f6244d) {
                return false;
            }
            int i3 = this.f6243c;
            int i4 = type.f6243c;
            int i5 = i2 + i3;
            while (i3 < i5) {
                if (this.f6242b[i3] != type.f6242b[i4]) {
                    return false;
                }
                i3++;
                i4++;
            }
        }
        return true;
    }

    public String getDescriptor() {
        char c2;
        StringBuffer stringBuffer = new StringBuffer();
        char[] cArr = this.f6242b;
        if (cArr == null) {
            c2 = (char) ((this.f6243c & -16777216) >>> 24);
        } else if (this.f6241a == 10) {
            stringBuffer.append('L');
            stringBuffer.append(this.f6242b, this.f6243c, this.f6244d);
            c2 = DefaultObjectDumpFormatter.TOKEN_DIVIDER;
        } else {
            stringBuffer.append(cArr, this.f6243c, this.f6244d);
            return stringBuffer.toString();
        }
        stringBuffer.append(c2);
        return stringBuffer.toString();
    }

    public int hashCode() {
        int i = this.f6241a;
        int i2 = i * 13;
        if (i >= 9) {
            int i3 = this.f6243c;
            int i4 = this.f6244d + i3;
            while (i3 < i4) {
                i2 = (i2 + this.f6242b[i3]) * 17;
                i3++;
            }
        }
        return i2;
    }

    public String toString() {
        return getDescriptor();
    }
}
