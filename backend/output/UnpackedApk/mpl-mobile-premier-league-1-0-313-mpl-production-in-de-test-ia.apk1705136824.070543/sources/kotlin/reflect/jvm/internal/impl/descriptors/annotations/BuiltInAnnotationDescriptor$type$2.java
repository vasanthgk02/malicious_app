package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: BuiltInAnnotationDescriptor.kt */
public final class BuiltInAnnotationDescriptor$type$2 extends Lambda implements Function0<SimpleType> {
    public final /* synthetic */ BuiltInAnnotationDescriptor this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public BuiltInAnnotationDescriptor$type$2(BuiltInAnnotationDescriptor builtInAnnotationDescriptor) {
        // this.this$0 = builtInAnnotationDescriptor;
        super(0);
    }

    public Object invoke() {
        BuiltInAnnotationDescriptor builtInAnnotationDescriptor = this.this$0;
        return builtInAnnotationDescriptor.builtIns.getBuiltInClassByFqName(builtInAnnotationDescriptor.fqName).getDefaultType();
    }
}
