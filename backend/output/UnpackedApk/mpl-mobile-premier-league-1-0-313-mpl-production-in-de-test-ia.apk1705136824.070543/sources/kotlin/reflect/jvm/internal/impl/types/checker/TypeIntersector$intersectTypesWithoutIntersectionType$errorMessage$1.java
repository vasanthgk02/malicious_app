package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Set;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: IntersectionType.kt */
public final class TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1 extends Lambda implements Function0<String> {
    public final /* synthetic */ Set<SimpleType> $inputTypes;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1(Set<? extends SimpleType> set) {
        // this.$inputTypes = set;
        super(0);
    }

    public Object invoke() {
        return Intrinsics.stringPlus("This collections cannot be empty! input types: ", ArraysKt___ArraysJvmKt.joinToString$default(this.$inputTypes, null, null, null, 0, null, null, 63));
    }
}
