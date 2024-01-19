package kotlin.reflect.jvm.internal.impl.types;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypeSubstitution.kt */
public final class TypeConstructorSubstitution$Companion$createByConstructorsMap$1 extends TypeConstructorSubstitution {
    public final /* synthetic */ boolean $approximateCapturedTypes;
    public final /* synthetic */ Map<TypeConstructor, TypeProjection> $map;

    public TypeConstructorSubstitution$Companion$createByConstructorsMap$1(Map<TypeConstructor, ? extends TypeProjection> map, boolean z) {
        this.$map = map;
        this.$approximateCapturedTypes = z;
    }

    public boolean approximateCapturedTypes() {
        return this.$approximateCapturedTypes;
    }

    public TypeProjection get(TypeConstructor typeConstructor) {
        Intrinsics.checkNotNullParameter(typeConstructor, "key");
        return this.$map.get(typeConstructor);
    }

    public boolean isEmpty() {
        return this.$map.isEmpty();
    }
}