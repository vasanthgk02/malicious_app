package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter.All;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;

/* compiled from: JvmBuiltInsCustomizer.kt */
public final class FallbackBuiltIns extends KotlinBuiltIns {
    public static final FallbackBuiltIns Companion = null;
    public static final KotlinBuiltIns Instance = new FallbackBuiltIns();

    public FallbackBuiltIns() {
        super(new LockBasedStorageManager("FallbackBuiltIns"));
        createBuiltInsModule(true);
    }

    public PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        return All.INSTANCE;
    }
}
