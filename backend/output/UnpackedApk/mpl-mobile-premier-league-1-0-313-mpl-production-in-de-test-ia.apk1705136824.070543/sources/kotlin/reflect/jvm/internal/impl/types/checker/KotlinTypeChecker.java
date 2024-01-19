package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker.Companion;

public interface KotlinTypeChecker {
    public static final KotlinTypeChecker DEFAULT = Companion.Default;

    public interface TypeConstructorEquality {
        boolean equals(TypeConstructor typeConstructor, TypeConstructor typeConstructor2);
    }

    static {
        if (NewKotlinTypeChecker.Companion != null) {
            return;
        }
        throw null;
    }

    boolean equalTypes(KotlinType kotlinType, KotlinType kotlinType2);

    boolean isSubtypeOf(KotlinType kotlinType, KotlinType kotlinType2);
}
