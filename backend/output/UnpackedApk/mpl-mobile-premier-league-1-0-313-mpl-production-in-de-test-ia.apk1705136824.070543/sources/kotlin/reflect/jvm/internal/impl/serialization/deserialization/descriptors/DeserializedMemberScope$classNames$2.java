package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: DeserializedMemberScope.kt */
public final class DeserializedMemberScope$classNames$2 extends Lambda implements Function0<Set<? extends Name>> {
    public final /* synthetic */ Function0<Collection<Name>> $classNames;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeserializedMemberScope$classNames$2(Function0<? extends Collection<Name>> function0) {
        // this.$classNames = function0;
        super(0);
    }

    public Object invoke() {
        return ArraysKt___ArraysJvmKt.toSet((Iterable) this.$classNames.invoke());
    }
}
