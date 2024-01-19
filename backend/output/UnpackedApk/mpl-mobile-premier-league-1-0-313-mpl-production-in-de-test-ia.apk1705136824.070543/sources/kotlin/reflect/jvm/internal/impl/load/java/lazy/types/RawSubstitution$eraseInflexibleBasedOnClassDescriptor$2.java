package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: RawType.kt */
public final class RawSubstitution$eraseInflexibleBasedOnClassDescriptor$2 extends Lambda implements Function1<KotlinTypeRefiner, SimpleType> {
    public final /* synthetic */ JavaTypeAttributes $attr;
    public final /* synthetic */ ClassDescriptor $declaration;
    public final /* synthetic */ SimpleType $type;
    public final /* synthetic */ RawSubstitution this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public RawSubstitution$eraseInflexibleBasedOnClassDescriptor$2(ClassDescriptor classDescriptor, RawSubstitution rawSubstitution, SimpleType simpleType, JavaTypeAttributes javaTypeAttributes) {
        // this.$declaration = classDescriptor;
        // this.this$0 = rawSubstitution;
        // this.$type = simpleType;
        // this.$attr = javaTypeAttributes;
        super(1);
    }

    public Object invoke(Object obj) {
        Intrinsics.checkNotNullParameter((KotlinTypeRefiner) obj, "kotlinTypeRefiner");
        ClassDescriptor classDescriptor = this.$declaration;
        if (!(classDescriptor instanceof ClassDescriptor)) {
            classDescriptor = null;
        }
        Object classId = classDescriptor == null ? null : DescriptorUtilsKt.getClassId(classDescriptor);
        if (classId != null) {
            Intrinsics.checkNotNullParameter(classId, "classId");
        }
        return null;
    }
}
