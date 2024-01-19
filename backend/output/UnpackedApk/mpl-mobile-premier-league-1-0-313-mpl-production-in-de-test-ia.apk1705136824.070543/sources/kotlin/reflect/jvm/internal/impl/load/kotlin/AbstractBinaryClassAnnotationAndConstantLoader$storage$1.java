package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.HashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader.Storage;

/* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
public final class AbstractBinaryClassAnnotationAndConstantLoader$storage$1 extends Lambda implements Function1<KotlinJvmBinaryClass, Storage<? extends A, ? extends C>> {
    public final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public AbstractBinaryClassAnnotationAndConstantLoader$storage$1(AbstractBinaryClassAnnotationAndConstantLoader<A, C> abstractBinaryClassAnnotationAndConstantLoader) {
        // this.this$0 = abstractBinaryClassAnnotationAndConstantLoader;
        super(1);
    }

    public Object invoke(Object obj) {
        KotlinJvmBinaryClass kotlinJvmBinaryClass = (KotlinJvmBinaryClass) obj;
        Intrinsics.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinClass");
        AbstractBinaryClassAnnotationAndConstantLoader<A, C> abstractBinaryClassAnnotationAndConstantLoader = this.this$0;
        if (abstractBinaryClassAnnotationAndConstantLoader != null) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 = new AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1(abstractBinaryClassAnnotationAndConstantLoader, hashMap, hashMap2);
            Intrinsics.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinClass");
            kotlinJvmBinaryClass.visitMembers(abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1, null);
            return new Storage(hashMap, hashMap2);
        }
        throw null;
    }
}
