package kotlin.reflect.jvm.internal.impl.name;

import java.util.regex.Pattern;
import kotlin.jvm.functions.Function1;

public final class FqNameUnsafe {
    public static final Name ROOT_NAME = Name.special("<root>");
    public static final Pattern SPLIT_BY_DOTS = Pattern.compile("\\.");
    public static final Function1<String, Name> STRING_TO_NAME = new Function1<String, Name>() {
        public Object invoke(Object obj) {
            return Name.guessByFirstCharacter((String) obj);
        }
    };
    public final String fqName;
    public transient FqNameUnsafe parent;
    public transient FqName safe;
    public transient Name shortName;

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        Throwable th;
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        if (i != 1) {
            switch (i) {
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 17:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                    break;
                case 9:
                    objArr[0] = "name";
                    break;
                case 15:
                    objArr[0] = "segment";
                    break;
                case 16:
                    objArr[0] = "shortName";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
        } else {
            objArr[0] = "safe";
        }
        switch (i) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
            case 6:
                objArr[1] = "toSafe";
                break;
            case 7:
            case 8:
                objArr[1] = "parent";
                break;
            case 10:
            case 11:
                objArr[1] = "shortName";
                break;
            case 12:
            case 13:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 14:
                objArr[1] = "pathSegments";
                break;
            case 17:
                objArr[1] = "toString";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                break;
            case 9:
                objArr[2] = "child";
                break;
            case 15:
                objArr[2] = "startsWith";
                break;
            case 16:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                th = new IllegalStateException(format);
                break;
            default:
                th = new IllegalArgumentException(format);
                break;
        }
        throw th;
    }

    public FqNameUnsafe(String str, FqName fqName2) {
        if (str != null) {
            this.fqName = str;
            this.safe = fqName2;
            return;
        }
        $$$reportNull$$$0(0);
        throw null;
    }

    public String asString() {
        String str = this.fqName;
        if (str != null) {
            return str;
        }
        $$$reportNull$$$0(4);
        throw null;
    }

    public FqNameUnsafe child(Name name) {
        String str;
        if (name != null) {
            if (isRoot()) {
                str = name.asString();
            } else {
                str = this.fqName + "." + name.asString();
            }
            return new FqNameUnsafe(str, this, name);
        }
        $$$reportNull$$$0(9);
        throw null;
    }

    public final void compute() {
        int lastIndexOf = this.fqName.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            this.shortName = Name.guessByFirstCharacter(this.fqName.substring(lastIndexOf + 1));
            this.parent = new FqNameUnsafe(this.fqName.substring(0, lastIndexOf));
            return;
        }
        this.shortName = Name.guessByFirstCharacter(this.fqName);
        this.parent = FqName.ROOT.toUnsafe();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FqNameUnsafe) && this.fqName.equals(((FqNameUnsafe) obj).fqName);
    }

    public int hashCode() {
        return this.fqName.hashCode();
    }

    public boolean isRoot() {
        return this.fqName.isEmpty();
    }

    public boolean isSafe() {
        return this.safe != null || asString().indexOf(60) < 0;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [java.util.List<kotlin.reflect.jvm.internal.impl.name.Name>] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<kotlin.reflect.jvm.internal.impl.name.Name> pathSegments() {
        /*
            r6 = this;
            boolean r0 = r6.isRoot()
            if (r0 == 0) goto L_0x000b
            java.util.List r0 = java.util.Collections.emptyList()
            goto L_0x0037
        L_0x000b:
            java.util.regex.Pattern r0 = SPLIT_BY_DOTS
            java.lang.String r1 = r6.fqName
            java.lang.String[] r0 = r0.split(r1)
            kotlin.jvm.functions.Function1<java.lang.String, kotlin.reflect.jvm.internal.impl.name.Name> r1 = STRING_TO_NAME
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.lang.String r2 = "transform"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r0.length
            r2.<init>(r3)
            int r3 = r0.length
            r4 = 0
        L_0x0028:
            if (r4 >= r3) goto L_0x0036
            r5 = r0[r4]
            java.lang.Object r5 = r1.invoke(r5)
            r2.add(r5)
            int r4 = r4 + 1
            goto L_0x0028
        L_0x0036:
            r0 = r2
        L_0x0037:
            if (r0 == 0) goto L_0x003a
            return r0
        L_0x003a:
            r0 = 14
            $$$reportNull$$$0(r0)
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe.pathSegments():java.util.List");
    }

    public Name shortName() {
        Name name = this.shortName;
        if (name != null) {
            if (name != null) {
                return name;
            }
            $$$reportNull$$$0(10);
            throw null;
        } else if (!isRoot()) {
            compute();
            Name name2 = this.shortName;
            if (name2 != null) {
                return name2;
            }
            $$$reportNull$$$0(11);
            throw null;
        } else {
            throw new IllegalStateException("root");
        }
    }

    public FqName toSafe() {
        FqName fqName2 = this.safe;
        if (fqName2 == null) {
            FqName fqName3 = new FqName(this);
            this.safe = fqName3;
            if (fqName3 != null) {
                return fqName3;
            }
            $$$reportNull$$$0(6);
            throw null;
        } else if (fqName2 != null) {
            return fqName2;
        } else {
            $$$reportNull$$$0(5);
            throw null;
        }
    }

    public String toString() {
        String asString = isRoot() ? ROOT_NAME.asString() : this.fqName;
        if (asString != null) {
            return asString;
        }
        $$$reportNull$$$0(17);
        throw null;
    }

    public FqNameUnsafe(String str) {
        if (str != null) {
            this.fqName = str;
        } else {
            $$$reportNull$$$0(2);
            throw null;
        }
    }

    public FqNameUnsafe(String str, FqNameUnsafe fqNameUnsafe, Name name) {
        if (str != null) {
            this.fqName = str;
            this.parent = fqNameUnsafe;
            this.shortName = name;
            return;
        }
        $$$reportNull$$$0(3);
        throw null;
    }
}
