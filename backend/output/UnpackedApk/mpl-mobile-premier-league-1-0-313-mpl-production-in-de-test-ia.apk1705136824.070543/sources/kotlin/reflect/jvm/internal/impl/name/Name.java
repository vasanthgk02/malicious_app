package kotlin.reflect.jvm.internal.impl.name;

import com.android.tools.r8.GeneratedOutlineSupport;

public final class Name implements Comparable<Name> {
    public final String name;
    public final boolean special;

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 1 || i == 2) ? 2 : 3)];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[0] = "name";
        }
        if (i == 1) {
            objArr[1] = "asString";
        } else if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[1] = "getIdentifier";
        }
        switch (i) {
            case 1:
            case 2:
                break;
            case 3:
                objArr[2] = "identifier";
                break;
            case 4:
                objArr[2] = "isValidIdentifier";
                break;
            case 5:
                objArr[2] = "special";
                break;
            case 6:
                objArr[2] = "guessByFirstCharacter";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        throw ((i == 1 || i == 2) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    public Name(String str, boolean z) {
        if (str != null) {
            this.name = str;
            this.special = z;
            return;
        }
        $$$reportNull$$$0(0);
        throw null;
    }

    public static Name guessByFirstCharacter(String str) {
        if (str == null) {
            $$$reportNull$$$0(6);
            throw null;
        } else if (str.startsWith("<")) {
            return special(str);
        } else {
            return identifier(str);
        }
    }

    public static Name identifier(String str) {
        if (str != null) {
            return new Name(str, false);
        }
        $$$reportNull$$$0(3);
        throw null;
    }

    public static boolean isValidIdentifier(String str) {
        if (str == null) {
            $$$reportNull$$$0(4);
            throw null;
        } else if (str.isEmpty() || str.startsWith("<")) {
            return false;
        } else {
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (charAt == '.' || charAt == '/' || charAt == '\\') {
                    return false;
                }
            }
            return true;
        }
    }

    public static Name special(String str) {
        if (str == null) {
            $$$reportNull$$$0(5);
            throw null;
        } else if (str.startsWith("<")) {
            return new Name(str, true);
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("special name must start with '<': ", str));
        }
    }

    public String asString() {
        String str = this.name;
        if (str != null) {
            return str;
        }
        $$$reportNull$$$0(1);
        throw null;
    }

    public int compareTo(Object obj) {
        return this.name.compareTo(((Name) obj).name);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Name)) {
            return false;
        }
        Name name2 = (Name) obj;
        return this.special == name2.special && this.name.equals(name2.name);
    }

    public String getIdentifier() {
        if (!this.special) {
            String asString = asString();
            if (asString != null) {
                return asString;
            }
            $$$reportNull$$$0(2);
            throw null;
        }
        throw new IllegalStateException("not identifier: " + this);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + (this.special ? 1 : 0);
    }

    public String toString() {
        return this.name;
    }
}
