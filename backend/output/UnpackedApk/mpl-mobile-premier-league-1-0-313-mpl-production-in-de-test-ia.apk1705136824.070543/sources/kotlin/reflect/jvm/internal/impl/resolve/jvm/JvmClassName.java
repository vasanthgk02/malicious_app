package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

public class JvmClassName {
    public final String internalName;

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 3 || i == 6 || i == 7 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 3 || i == 6 || i == 7 || i == 8) ? 2 : 3)];
        switch (i) {
            case 1:
                objArr[0] = "classId";
                break;
            case 2:
            case 4:
                objArr[0] = "fqName";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
                break;
            default:
                objArr[0] = "internalName";
                break;
        }
        if (i == 3) {
            objArr[1] = "byFqNameWithoutInnerClasses";
        } else if (i == 6) {
            objArr[1] = "getFqNameForClassNameWithoutDollars";
        } else if (i == 7) {
            objArr[1] = "getPackageFqName";
        } else if (i != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
        } else {
            objArr[1] = "getInternalName";
        }
        switch (i) {
            case 1:
                objArr[2] = "byClassId";
                break;
            case 2:
            case 4:
                objArr[2] = "byFqNameWithoutInnerClasses";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                break;
            case 5:
                objArr[2] = "<init>";
                break;
            default:
                objArr[2] = "byInternalName";
                break;
        }
        String format = String.format(str, objArr);
        throw ((i == 3 || i == 6 || i == 7 || i == 8) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    public JvmClassName(String str) {
        if (str != null) {
            this.internalName = str;
        } else {
            $$$reportNull$$$0(5);
            throw null;
        }
    }

    public static JvmClassName byClassId(ClassId classId) {
        if (classId != null) {
            FqName packageFqName = classId.getPackageFqName();
            String replace = classId.getRelativeClassName().asString().replace('.', '$');
            if (packageFqName.isRoot()) {
                return new JvmClassName(replace);
            }
            return new JvmClassName(packageFqName.asString().replace('.', '/') + "/" + replace);
        }
        $$$reportNull$$$0(1);
        throw null;
    }

    public static JvmClassName byFqNameWithoutInnerClasses(FqName fqName) {
        if (fqName != null) {
            return new JvmClassName(fqName.asString().replace('.', '/'));
        }
        $$$reportNull$$$0(2);
        throw null;
    }

    public static JvmClassName byInternalName(String str) {
        if (str != null) {
            return new JvmClassName(str);
        }
        $$$reportNull$$$0(0);
        throw null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || JvmClassName.class != obj.getClass()) {
            return false;
        }
        return this.internalName.equals(((JvmClassName) obj).internalName);
    }

    public String getInternalName() {
        String str = this.internalName;
        if (str != null) {
            return str;
        }
        $$$reportNull$$$0(8);
        throw null;
    }

    public int hashCode() {
        return this.internalName.hashCode();
    }

    public String toString() {
        return this.internalName;
    }
}
