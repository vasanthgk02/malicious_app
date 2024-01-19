package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Type;", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: KParameterImpl.kt */
public final class KParameterImpl$type$1 extends Lambda implements Function0<Type> {
    public final /* synthetic */ KParameterImpl this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KParameterImpl$type$1(KParameterImpl kParameterImpl) {
        // this.this$0 = kParameterImpl;
        super(0);
    }

    public Object invoke() {
        ParameterDescriptor descriptor = this.this$0.getDescriptor();
        if (!(descriptor instanceof ReceiverParameterDescriptor) || !Intrinsics.areEqual(UtilKt.getInstanceReceiverParameter(this.this$0.callable.getDescriptor()), descriptor) || this.this$0.callable.getDescriptor().getKind() != Kind.FAKE_OVERRIDE) {
            return this.this$0.callable.getCaller().getParameterTypes().get(this.this$0.index);
        }
        DeclarationDescriptor containingDeclaration = this.this$0.callable.getDescriptor().getContainingDeclaration();
        if (containingDeclaration != null) {
            Class<?> javaClass = UtilKt.toJavaClass((ClassDescriptor) containingDeclaration);
            if (javaClass != null) {
                return javaClass;
            }
            throw new KotlinReflectionInternalError("Cannot determine receiver Java type of inherited declaration: " + descriptor);
        }
        throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
    }
}
