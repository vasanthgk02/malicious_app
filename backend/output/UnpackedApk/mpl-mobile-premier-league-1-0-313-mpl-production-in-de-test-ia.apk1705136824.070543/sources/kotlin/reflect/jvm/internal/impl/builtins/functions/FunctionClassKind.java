package kotlin.reflect.jvm.internal.impl.builtins.functions;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.CharsKt__CharKt;

/* compiled from: FunctionClassKind.kt */
public enum FunctionClassKind {
    Function(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, "Function"),
    SuspendFunction(StandardNames.COROUTINES_PACKAGE_FQ_NAME_RELEASE, "SuspendFunction"),
    KFunction(StandardNames.KOTLIN_REFLECT_FQ_NAME, "KFunction"),
    KSuspendFunction(StandardNames.KOTLIN_REFLECT_FQ_NAME, "KSuspendFunction");
    
    public static final Companion Companion = null;
    public final String classNamePrefix;
    public final FqName packageFqName;

    /* compiled from: FunctionClassKind.kt */
    public static final class Companion {

        /* compiled from: FunctionClassKind.kt */
        public static final class KindWithArity {
            public final int arity;
            public final FunctionClassKind kind;

            public KindWithArity(FunctionClassKind functionClassKind, int i) {
                Intrinsics.checkNotNullParameter(functionClassKind, "kind");
                this.kind = functionClassKind;
                this.arity = i;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof KindWithArity)) {
                    return false;
                }
                KindWithArity kindWithArity = (KindWithArity) obj;
                return this.kind == kindWithArity.kind && this.arity == kindWithArity.arity;
            }

            public int hashCode() {
                return (this.kind.hashCode() * 31) + this.arity;
            }

            public String toString() {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("KindWithArity(kind=");
                outline73.append(this.kind);
                outline73.append(", arity=");
                return GeneratedOutlineSupport.outline56(outline73, this.arity, ')');
            }
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final KindWithArity parseClassName(String str, FqName fqName) {
            FunctionClassKind functionClassKind;
            Integer num;
            Intrinsics.checkNotNullParameter(str, "className");
            Intrinsics.checkNotNullParameter(fqName, "packageFqName");
            Intrinsics.checkNotNullParameter(fqName, "packageFqName");
            Intrinsics.checkNotNullParameter(str, "className");
            FunctionClassKind[] values = FunctionClassKind.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    functionClassKind = null;
                    break;
                }
                functionClassKind = values[i];
                if (Intrinsics.areEqual(functionClassKind.getPackageFqName(), fqName) && CharsKt__CharKt.startsWith$default(str, functionClassKind.getClassNamePrefix(), false, 2)) {
                    break;
                }
                i++;
            }
            if (functionClassKind == null) {
                return null;
            }
            String substring = str.substring(functionClassKind.getClassNamePrefix().length());
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            if (!(substring.length() == 0)) {
                int length2 = substring.length();
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i2 >= length2) {
                        num = Integer.valueOf(i3);
                        break;
                    }
                    char charAt = substring.charAt(i2);
                    i2++;
                    int i4 = charAt - '0';
                    if (!(i4 >= 0 && i4 <= 9)) {
                        break;
                    }
                    i3 = (i3 * 10) + i4;
                }
            }
            num = null;
            if (num == null) {
                return null;
            }
            return new KindWithArity(functionClassKind, num.intValue());
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion(null);
    }

    /* access modifiers changed from: public */
    FunctionClassKind(FqName fqName, String str) {
        this.packageFqName = fqName;
        this.classNamePrefix = str;
    }

    public final String getClassNamePrefix() {
        return this.classNamePrefix;
    }

    public final FqName getPackageFqName() {
        return this.packageFqName;
    }

    public final Name numberedClassName(int i) {
        Name identifier = Name.identifier(Intrinsics.stringPlus(this.classNamePrefix, Integer.valueOf(i)));
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(\"$classNamePrefix$arity\")");
        return identifier;
    }
}
