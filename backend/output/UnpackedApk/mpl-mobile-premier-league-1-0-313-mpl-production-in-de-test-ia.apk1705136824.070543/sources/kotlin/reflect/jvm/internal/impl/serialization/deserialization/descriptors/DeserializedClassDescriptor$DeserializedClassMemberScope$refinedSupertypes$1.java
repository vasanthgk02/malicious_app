package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner.Default;

/* compiled from: DeserializedClassDescriptor.kt */
public final class DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1 extends Lambda implements Function0<Collection<? extends KotlinType>> {
    public final /* synthetic */ DeserializedClassMemberScope this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1(DeserializedClassMemberScope deserializedClassMemberScope) {
        // this.this$0 = deserializedClassMemberScope;
        super(0);
    }

    public Object invoke() {
        DeserializedClassMemberScope deserializedClassMemberScope = this.this$0;
        KotlinTypeRefiner kotlinTypeRefiner = deserializedClassMemberScope.kotlinTypeRefiner;
        DeserializedClassDescriptor deserializedClassDescriptor = deserializedClassMemberScope.this$0;
        if (((Default) kotlinTypeRefiner) != null) {
            Intrinsics.checkNotNullParameter(deserializedClassDescriptor, "classDescriptor");
            Collection supertypes = ((AbstractTypeConstructor) deserializedClassDescriptor.getTypeConstructor()).getSupertypes();
            Intrinsics.checkNotNullExpressionValue(supertypes, "classDescriptor.typeConstructor.supertypes");
            return supertypes;
        }
        throw null;
    }
}
