package kotlin.reflect.jvm.internal.impl.name;

public class SpecialNames {
    public static final Name DEFAULT_NAME_FOR_COMPANION_OBJECT = Name.identifier("Companion");
    public static final Name NO_NAME_PROVIDED = Name.special("<no name provided>");
    public static final Name SAFE_IDENTIFIER_FOR_NO_NAME = Name.identifier("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = i != 1 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i != 1 ? 2 : 3)];
        if (i != 1) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/SpecialNames";
        } else {
            objArr[0] = "name";
        }
        if (i != 1) {
            objArr[1] = "safeIdentifier";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/SpecialNames";
        }
        if (i == 1) {
            objArr[2] = "isSafeIdentifier";
        }
        String format = String.format(str, objArr);
        throw (i != 1 ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    static {
        Name.special("<root package>");
        Name.special("<anonymous>");
    }

    public static boolean isSafeIdentifier(Name name) {
        if (name == null) {
            $$$reportNull$$$0(1);
            throw null;
        } else if (name.asString().isEmpty() || name.special) {
            return false;
        } else {
            return true;
        }
    }

    public static Name safeIdentifier(Name name) {
        if (name == null || name.special) {
            name = SAFE_IDENTIFIER_FOR_NO_NAME;
        }
        if (name != null) {
            return name;
        }
        $$$reportNull$$$0(0);
        throw null;
    }
}
