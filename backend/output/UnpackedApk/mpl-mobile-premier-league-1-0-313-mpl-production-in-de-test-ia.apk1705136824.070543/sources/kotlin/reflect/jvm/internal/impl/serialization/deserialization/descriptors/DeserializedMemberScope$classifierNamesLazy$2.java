package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Set;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: DeserializedMemberScope.kt */
public final class DeserializedMemberScope$classifierNamesLazy$2 extends Lambda implements Function0<Set<? extends Name>> {
    public final /* synthetic */ DeserializedMemberScope this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeserializedMemberScope$classifierNamesLazy$2(DeserializedMemberScope deserializedMemberScope) {
        // this.this$0 = deserializedMemberScope;
        super(0);
    }

    public Object invoke() {
        Set<Name> nonDeclaredClassifierNames = this.this$0.getNonDeclaredClassifierNames();
        if (nonDeclaredClassifierNames == null) {
            return null;
        }
        return ArraysKt___ArraysJvmKt.plus(ArraysKt___ArraysJvmKt.plus(this.this$0.getClassNames$deserialization(), (Iterable<? extends T>) this.this$0.impl.getTypeAliasNames()), (Iterable<? extends T>) nonDeclaredClassifierNames);
    }
}
