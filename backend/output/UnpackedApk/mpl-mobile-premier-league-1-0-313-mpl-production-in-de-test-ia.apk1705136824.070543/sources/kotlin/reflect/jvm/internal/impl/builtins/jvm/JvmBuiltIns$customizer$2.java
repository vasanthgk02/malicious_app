package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.Settings;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: JvmBuiltIns.kt */
public final class JvmBuiltIns$customizer$2 extends Lambda implements Function0<JvmBuiltInsCustomizer> {
    public final /* synthetic */ StorageManager $storageManager;
    public final /* synthetic */ JvmBuiltIns this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public JvmBuiltIns$customizer$2(JvmBuiltIns jvmBuiltIns, StorageManager storageManager) {
        // this.this$0 = jvmBuiltIns;
        // this.$storageManager = storageManager;
        super(0);
    }

    public Object invoke() {
        ModuleDescriptorImpl moduleDescriptorImpl = this.this$0.builtInsModule;
        if (moduleDescriptorImpl != null) {
            Intrinsics.checkNotNullExpressionValue(moduleDescriptorImpl, "builtInsModule");
            StorageManager storageManager = this.$storageManager;
            final JvmBuiltIns jvmBuiltIns = this.this$0;
            return new JvmBuiltInsCustomizer(moduleDescriptorImpl, storageManager, new Function0<Settings>() {
                public Object invoke() {
                    Function0<Settings> function0 = JvmBuiltIns.this.settingsComputation;
                    if (function0 != null) {
                        Settings settings = (Settings) function0.invoke();
                        JvmBuiltIns.this.settingsComputation = null;
                        return settings;
                    }
                    throw new AssertionError("JvmBuiltins instance has not been initialized properly");
                }
            });
        }
        KotlinBuiltIns.$$$reportNull$$$0(6);
        throw null;
    }
}
