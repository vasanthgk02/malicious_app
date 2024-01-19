package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: ReflectionTypes.kt */
public final class ReflectionTypes$kotlinReflectScope$2 extends Lambda implements Function0<MemberScope> {
    public final /* synthetic */ ModuleDescriptor $module;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ReflectionTypes$kotlinReflectScope$2(ModuleDescriptor moduleDescriptor) {
        // this.$module = moduleDescriptor;
        super(0);
    }

    public Object invoke() {
        return this.$module.getPackage(StandardNames.KOTLIN_REFLECT_FQ_NAME).getMemberScope();
    }
}
