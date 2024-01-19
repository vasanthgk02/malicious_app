package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.resolve.CliSealedClassInheritorsProvider;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;

/* compiled from: DeserializedClassDescriptor.kt */
public final class DeserializedClassDescriptor$sealedSubclasses$1 extends Lambda implements Function0<Collection<? extends ClassDescriptor>> {
    public final /* synthetic */ DeserializedClassDescriptor this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeserializedClassDescriptor$sealedSubclasses$1(DeserializedClassDescriptor deserializedClassDescriptor) {
        // this.this$0 = deserializedClassDescriptor;
        super(0);
    }

    public Object invoke() {
        Object obj;
        DeserializedClassDescriptor deserializedClassDescriptor = this.this$0;
        if (deserializedClassDescriptor.modality != Modality.SEALED) {
            return EmptyList.INSTANCE;
        }
        List<Integer> list = deserializedClassDescriptor.classProto.sealedSubclassFqName_;
        Intrinsics.checkNotNullExpressionValue(list, "fqNames");
        if (!list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Integer num : list) {
                DeserializationContext deserializationContext = deserializedClassDescriptor.f5950c;
                DeserializationComponents deserializationComponents = deserializationContext.components;
                NameResolver nameResolver = deserializationContext.nameResolver;
                Intrinsics.checkNotNullExpressionValue(num, "index");
                ClassDescriptor deserializeClass = deserializationComponents.deserializeClass(TweetUtils.getClassId(nameResolver, num.intValue()));
                if (deserializeClass != null) {
                    arrayList.add(deserializeClass);
                }
            }
            obj = arrayList;
        } else {
            Intrinsics.checkNotNullParameter(deserializedClassDescriptor, "sealedClass");
            if (deserializedClassDescriptor.getModality() != Modality.SEALED) {
                return EmptyList.INSTANCE;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            DeclarationDescriptor containingDeclaration = deserializedClassDescriptor.getContainingDeclaration();
            if (containingDeclaration instanceof PackageFragmentDescriptor) {
                CliSealedClassInheritorsProvider.computeSealedSubclasses$collectSubclasses(deserializedClassDescriptor, linkedHashSet, ((PackageFragmentDescriptor) containingDeclaration).getMemberScope(), false);
            }
            MemberScope unsubstitutedInnerClassesScope = deserializedClassDescriptor.getUnsubstitutedInnerClassesScope();
            Intrinsics.checkNotNullExpressionValue(unsubstitutedInnerClassesScope, "sealedClass.unsubstitutedInnerClassesScope");
            CliSealedClassInheritorsProvider.computeSealedSubclasses$collectSubclasses(deserializedClassDescriptor, linkedHashSet, unsubstitutedInnerClassesScope, true);
            obj = linkedHashSet;
        }
        return obj;
    }
}
