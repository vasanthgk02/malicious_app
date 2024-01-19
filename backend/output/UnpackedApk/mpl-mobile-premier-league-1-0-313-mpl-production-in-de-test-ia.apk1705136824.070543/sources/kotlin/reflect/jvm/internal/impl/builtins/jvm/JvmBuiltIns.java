package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: JvmBuiltIns.kt */
public final class JvmBuiltIns extends KotlinBuiltIns {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltIns.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;"))};
    public final NotNullLazyValue customizer$delegate;
    public Function0<Settings> settingsComputation;

    /* compiled from: JvmBuiltIns.kt */
    public enum Kind {
        FROM_DEPENDENCIES,
        FROM_CLASS_LOADER,
        FALLBACK
    }

    /* compiled from: JvmBuiltIns.kt */
    public static final class Settings {
        public final boolean isAdditionalBuiltInsFeatureSupported;
        public final ModuleDescriptor ownerModuleDescriptor;

        public Settings(ModuleDescriptor moduleDescriptor, boolean z) {
            Intrinsics.checkNotNullParameter(moduleDescriptor, "ownerModuleDescriptor");
            this.ownerModuleDescriptor = moduleDescriptor;
            this.isAdditionalBuiltInsFeatureSupported = z;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public JvmBuiltIns(StorageManager storageManager, Kind kind) {
        // Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        // Intrinsics.checkNotNullParameter(kind, "kind");
        super(storageManager);
        this.customizer$delegate = storageManager.createLazyValue(new JvmBuiltIns$customizer$2(this, storageManager));
        int ordinal = kind.ordinal();
        if (ordinal == 1) {
            createBuiltInsModule(false);
        } else if (ordinal == 2) {
            createBuiltInsModule(true);
        }
    }

    public AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        return getCustomizer();
    }

    public Iterable getClassDescriptorFactories() {
        Iterable<ClassDescriptorFactory> classDescriptorFactories = super.getClassDescriptorFactories();
        Intrinsics.checkNotNullExpressionValue(classDescriptorFactories, "super.getClassDescriptorFactories()");
        StorageManager storageManager = this.storageManager;
        if (storageManager != null) {
            Intrinsics.checkNotNullExpressionValue(storageManager, "storageManager");
            ModuleDescriptorImpl moduleDescriptorImpl = this.builtInsModule;
            if (moduleDescriptorImpl != null) {
                Intrinsics.checkNotNullExpressionValue(moduleDescriptorImpl, "builtInsModule");
                return ArraysKt___ArraysJvmKt.plus(classDescriptorFactories, new JvmBuiltInClassDescriptorFactory(storageManager, moduleDescriptorImpl, null, 4));
            }
            KotlinBuiltIns.$$$reportNull$$$0(6);
            throw null;
        }
        KotlinBuiltIns.$$$reportNull$$$0(5);
        throw null;
    }

    public final JvmBuiltInsCustomizer getCustomizer() {
        return (JvmBuiltInsCustomizer) TweetUtils.getValue(this.customizer$delegate, $$delegatedProperties[0]);
    }

    public PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        return getCustomizer();
    }
}
