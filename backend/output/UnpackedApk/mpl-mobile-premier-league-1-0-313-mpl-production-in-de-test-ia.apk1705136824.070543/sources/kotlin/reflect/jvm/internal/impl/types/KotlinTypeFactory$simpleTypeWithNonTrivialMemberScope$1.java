package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: KotlinTypeFactory.kt */
public final class KotlinTypeFactory$simpleTypeWithNonTrivialMemberScope$1 extends Lambda implements Function1<KotlinTypeRefiner, SimpleType> {
    public final /* synthetic */ Annotations $annotations;
    public final /* synthetic */ List<TypeProjection> $arguments;
    public final /* synthetic */ TypeConstructor $constructor;
    public final /* synthetic */ MemberScope $memberScope;
    public final /* synthetic */ boolean $nullable;
    public final /* synthetic */ KotlinTypeFactory this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KotlinTypeFactory$simpleTypeWithNonTrivialMemberScope$1(KotlinTypeFactory kotlinTypeFactory, TypeConstructor typeConstructor, List<? extends TypeProjection> list, Annotations annotations, boolean z, MemberScope memberScope) {
        // this.this$0 = kotlinTypeFactory;
        // this.$constructor = typeConstructor;
        // this.$arguments = list;
        // this.$annotations = annotations;
        // this.$nullable = z;
        // this.$memberScope = memberScope;
        super(1);
    }

    public Object invoke(Object obj) {
        KotlinTypeRefiner kotlinTypeRefiner = (KotlinTypeRefiner) obj;
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        KotlinTypeFactory kotlinTypeFactory = this.this$0;
        TypeConstructor typeConstructor = this.$constructor;
        if (kotlinTypeFactory != null) {
            ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
            if (declarationDescriptor != null) {
                kotlinTypeRefiner.refineDescriptor(declarationDescriptor);
            }
            return null;
        }
        throw null;
    }
}
