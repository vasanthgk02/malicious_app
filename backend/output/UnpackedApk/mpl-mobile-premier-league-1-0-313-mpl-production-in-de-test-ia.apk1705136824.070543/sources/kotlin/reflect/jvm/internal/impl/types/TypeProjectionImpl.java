package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner.Default;

public class TypeProjectionImpl extends TypeProjectionBase {
    public final Variance projection;
    public final KotlinType type;

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 4 || i == 5) ? 2 : 3)];
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "type";
                break;
            case 4:
            case 5:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
                break;
            case 6:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "projection";
                break;
        }
        if (i == 4) {
            objArr[1] = "getProjectionKind";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        } else {
            objArr[1] = "getType";
        }
        if (i == 3) {
            objArr[2] = "replaceType";
        } else if (!(i == 4 || i == 5)) {
            if (i != 6) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "refine";
            }
        }
        String format = String.format(str, objArr);
        throw ((i == 4 || i == 5) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    public TypeProjectionImpl(Variance variance, KotlinType kotlinType) {
        if (variance == null) {
            $$$reportNull$$$0(0);
            throw null;
        } else if (kotlinType != null) {
            this.projection = variance;
            this.type = kotlinType;
        } else {
            $$$reportNull$$$0(1);
            throw null;
        }
    }

    public Variance getProjectionKind() {
        Variance variance = this.projection;
        if (variance != null) {
            return variance;
        }
        $$$reportNull$$$0(4);
        throw null;
    }

    public KotlinType getType() {
        KotlinType kotlinType = this.type;
        if (kotlinType != null) {
            return kotlinType;
        }
        $$$reportNull$$$0(5);
        throw null;
    }

    public boolean isStarProjection() {
        return false;
    }

    public TypeProjection refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Variance variance = this.projection;
        KotlinType kotlinType = this.type;
        Default defaultR = (Default) kotlinTypeRefiner;
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        return new TypeProjectionImpl(variance, kotlinType);
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TypeProjectionImpl(kotlin.reflect.jvm.internal.impl.types.KotlinType r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0008
            kotlin.reflect.jvm.internal.impl.types.Variance r0 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
            r1.<init>(r0, r2)
            return
        L_0x0008:
            r2 = 2
            $$$reportNull$$$0(r2)
            r2 = 0
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl.<init>(kotlin.reflect.jvm.internal.impl.types.KotlinType):void");
    }
}
