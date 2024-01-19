package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl.WithDestructuringDeclaration;

/* compiled from: ValueParameterDescriptorImpl.kt */
public final class ValueParameterDescriptorImpl$WithDestructuringDeclaration$copy$1 extends Lambda implements Function0<List<? extends VariableDescriptor>> {
    public final /* synthetic */ WithDestructuringDeclaration this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ValueParameterDescriptorImpl$WithDestructuringDeclaration$copy$1(WithDestructuringDeclaration withDestructuringDeclaration) {
        // this.this$0 = withDestructuringDeclaration;
        super(0);
    }

    public Object invoke() {
        return (List) this.this$0.destructuringVariables$delegate.getValue();
    }
}
