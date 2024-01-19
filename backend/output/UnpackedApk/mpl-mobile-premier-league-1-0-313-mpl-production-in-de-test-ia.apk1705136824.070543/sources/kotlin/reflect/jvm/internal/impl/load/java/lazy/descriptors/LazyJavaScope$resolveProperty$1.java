package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;

/* compiled from: LazyJavaScope.kt */
public final class LazyJavaScope$resolveProperty$1 extends Lambda implements Function0<ConstantValue<?>> {
    public final /* synthetic */ JavaField $field;
    public final /* synthetic */ PropertyDescriptorImpl $propertyDescriptor;
    public final /* synthetic */ LazyJavaScope this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaScope$resolveProperty$1(LazyJavaScope lazyJavaScope, JavaField javaField, PropertyDescriptorImpl propertyDescriptorImpl) {
        // this.this$0 = lazyJavaScope;
        // this.$field = javaField;
        // this.$propertyDescriptor = propertyDescriptorImpl;
        super(0);
    }

    public Object invoke() {
        return this.this$0.f5943c.components.javaPropertyInitializerEvaluator.getInitializerConstant(this.$field, this.$propertyDescriptor);
    }
}
