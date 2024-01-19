package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: AbstractTypeAliasDescriptor.kt */
public final class AbstractTypeAliasDescriptor$computeDefaultType$1 extends Lambda implements Function1<KotlinTypeRefiner, SimpleType> {
    public final /* synthetic */ AbstractTypeAliasDescriptor this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public AbstractTypeAliasDescriptor$computeDefaultType$1(AbstractTypeAliasDescriptor abstractTypeAliasDescriptor) {
        // this.this$0 = abstractTypeAliasDescriptor;
        super(1);
    }

    public Object invoke(Object obj) {
        ((KotlinTypeRefiner) obj).refineDescriptor(this.this$0);
        return null;
    }
}
