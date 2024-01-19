package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Set;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.OptimizedImplementation;

/* compiled from: DeserializedMemberScope.kt */
public final class DeserializedMemberScope$OptimizedImplementation$functionNames$2 extends Lambda implements Function0<Set<? extends Name>> {
    public final /* synthetic */ OptimizedImplementation this$0;
    public final /* synthetic */ DeserializedMemberScope this$1;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeserializedMemberScope$OptimizedImplementation$functionNames$2(OptimizedImplementation optimizedImplementation, DeserializedMemberScope deserializedMemberScope) {
        // this.this$0 = optimizedImplementation;
        // this.this$1 = deserializedMemberScope;
        super(0);
    }

    public Object invoke() {
        return ArraysKt___ArraysJvmKt.plus(this.this$0.functionProtosBytes.keySet(), (Iterable<? extends T>) this.this$1.getNonDeclaredFunctionNames());
    }
}
