package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Companion;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope;

/* compiled from: DeserializedClassDescriptor.kt */
public final class DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1 extends Lambda implements Function0<Collection<? extends DeclarationDescriptor>> {
    public final /* synthetic */ DeserializedClassMemberScope this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1(DeserializedClassMemberScope deserializedClassMemberScope) {
        // this.this$0 = deserializedClassMemberScope;
        super(0);
    }

    public Object invoke() {
        DeserializedClassMemberScope deserializedClassMemberScope = this.this$0;
        DescriptorKindFilter descriptorKindFilter = DescriptorKindFilter.ALL;
        if (MemberScope.Companion != null) {
            return deserializedClassMemberScope.computeDescriptors(descriptorKindFilter, Companion.ALL_NAME_FILTER, NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
        }
        throw null;
    }
}
