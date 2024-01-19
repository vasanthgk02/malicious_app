package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.Settings;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;

/* compiled from: JvmBuiltIns.kt */
public final class JvmBuiltIns$initialize$1 extends Lambda implements Function0<Settings> {
    public final /* synthetic */ boolean $isAdditionalBuiltInsFeatureSupported;
    public final /* synthetic */ ModuleDescriptor $moduleDescriptor;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public JvmBuiltIns$initialize$1(ModuleDescriptor moduleDescriptor, boolean z) {
        // this.$moduleDescriptor = moduleDescriptor;
        // this.$isAdditionalBuiltInsFeatureSupported = z;
        super(0);
    }

    public Object invoke() {
        return new Settings(this.$moduleDescriptor, this.$isAdditionalBuiltInsFeatureSupported);
    }
}
