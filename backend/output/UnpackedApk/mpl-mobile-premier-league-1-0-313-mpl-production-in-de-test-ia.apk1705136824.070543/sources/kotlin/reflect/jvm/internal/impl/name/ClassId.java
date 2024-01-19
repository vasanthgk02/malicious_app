package kotlin.reflect.jvm.internal.impl.name;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

public final class ClassId {
    public final boolean local;
    public final FqName packageFqName;
    public final FqName relativeClassName;

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 5 || i == 6 || i == 7 || i == 9 || i == 13 || i == 14) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 5 || i == 6 || i == 7 || i == 9 || i == 13 || i == 14) ? 2 : 3)];
        switch (i) {
            case 1:
            case 3:
                objArr[0] = "packageFqName";
                break;
            case 2:
                objArr[0] = "relativeClassName";
                break;
            case 4:
                objArr[0] = "topLevelName";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
                break;
            case 8:
                objArr[0] = "name";
                break;
            case 10:
                objArr[0] = "segment";
                break;
            case 11:
            case 12:
                objArr[0] = NetworkingModule.REQUEST_BODY_KEY_STRING;
                break;
            default:
                objArr[0] = "topLevelFqName";
                break;
        }
        if (i == 5) {
            objArr[1] = "getPackageFqName";
        } else if (i == 6) {
            objArr[1] = "getRelativeClassName";
        } else if (i == 7) {
            objArr[1] = "getShortClassName";
        } else if (i == 9) {
            objArr[1] = "asSingleFqName";
        } else if (i == 13 || i == 14) {
            objArr[1] = "asString";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                objArr[2] = "<init>";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                break;
            case 8:
                objArr[2] = "createNestedClassId";
                break;
            case 10:
                objArr[2] = "startsWith";
                break;
            case 11:
            case 12:
                objArr[2] = "fromString";
                break;
            default:
                objArr[2] = "topLevel";
                break;
        }
        String format = String.format(str, objArr);
        throw ((i == 5 || i == 6 || i == 7 || i == 9 || i == 13 || i == 14) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    public ClassId(FqName fqName, FqName fqName2, boolean z) {
        if (fqName != null) {
            this.packageFqName = fqName;
            this.relativeClassName = fqName2;
            this.local = z;
            return;
        }
        $$$reportNull$$$0(1);
        throw null;
    }

    public static ClassId fromString(String str, boolean z) {
        if (str != null) {
            String str2 = "";
            Intrinsics.checkNotNullParameter(str, "<this>");
            Intrinsics.checkNotNullParameter(str2, "missingDelimiterValue");
            int lastIndexOf$default = CharsKt__CharKt.lastIndexOf$default((CharSequence) str, '/', 0, false, 6);
            if (lastIndexOf$default != -1) {
                str2 = str.substring(0, lastIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            return new ClassId(new FqName(str2.replace('/', '.')), new FqName(CharsKt__CharKt.substringAfterLast(str, '/', str)), z);
        }
        $$$reportNull$$$0(12);
        throw null;
    }

    public static ClassId topLevel(FqName fqName) {
        if (fqName != null) {
            return new ClassId(fqName.parent(), fqName.shortName());
        }
        $$$reportNull$$$0(0);
        throw null;
    }

    public FqName asSingleFqName() {
        if (this.packageFqName.isRoot()) {
            FqName fqName = this.relativeClassName;
            if (fqName != null) {
                return fqName;
            }
            $$$reportNull$$$0(9);
            throw null;
        }
        return new FqName(this.packageFqName.asString() + "." + this.relativeClassName.asString());
    }

    public String asString() {
        if (this.packageFqName.isRoot()) {
            String asString = this.relativeClassName.asString();
            if (asString != null) {
                return asString;
            }
            $$$reportNull$$$0(13);
            throw null;
        }
        String str = this.packageFqName.asString().replace('.', '/') + "/" + this.relativeClassName.asString();
        if (str != null) {
            return str;
        }
        $$$reportNull$$$0(14);
        throw null;
    }

    public ClassId createNestedClassId(Name name) {
        if (name != null) {
            return new ClassId(getPackageFqName(), this.relativeClassName.child(name), this.local);
        }
        $$$reportNull$$$0(8);
        throw null;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || ClassId.class != obj.getClass()) {
            return false;
        }
        ClassId classId = (ClassId) obj;
        if (!this.packageFqName.equals(classId.packageFqName) || !this.relativeClassName.equals(classId.relativeClassName) || this.local != classId.local) {
            z = false;
        }
        return z;
    }

    public ClassId getOuterClassId() {
        FqName parent = this.relativeClassName.parent();
        if (parent.isRoot()) {
            return null;
        }
        return new ClassId(getPackageFqName(), parent, this.local);
    }

    public FqName getPackageFqName() {
        FqName fqName = this.packageFqName;
        if (fqName != null) {
            return fqName;
        }
        $$$reportNull$$$0(5);
        throw null;
    }

    public FqName getRelativeClassName() {
        FqName fqName = this.relativeClassName;
        if (fqName != null) {
            return fqName;
        }
        $$$reportNull$$$0(6);
        throw null;
    }

    public Name getShortClassName() {
        Name shortName = this.relativeClassName.shortName();
        if (shortName != null) {
            return shortName;
        }
        $$$reportNull$$$0(7);
        throw null;
    }

    public int hashCode() {
        int hashCode = this.relativeClassName.hashCode();
        return Boolean.valueOf(this.local).hashCode() + ((hashCode + (this.packageFqName.hashCode() * 31)) * 31);
    }

    public boolean isNestedClass() {
        return !this.relativeClassName.parent().isRoot();
    }

    public String toString() {
        if (!this.packageFqName.isRoot()) {
            return asString();
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("/");
        outline73.append(asString());
        return outline73.toString();
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ClassId(kotlin.reflect.jvm.internal.impl.name.FqName r2, kotlin.reflect.jvm.internal.impl.name.Name r3) {
        /*
            r1 = this;
            r0 = 0
            if (r2 == 0) goto L_0x0013
            if (r3 == 0) goto L_0x000e
            kotlin.reflect.jvm.internal.impl.name.FqName r3 = kotlin.reflect.jvm.internal.impl.name.FqName.topLevel(r3)
            r0 = 0
            r1.<init>(r2, r3, r0)
            return
        L_0x000e:
            r2 = 4
            $$$reportNull$$$0(r2)
            throw r0
        L_0x0013:
            r2 = 3
            $$$reportNull$$$0(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.name.ClassId.<init>(kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.name.Name):void");
    }

    public static ClassId fromString(String str) {
        return fromString(str, false);
    }
}
