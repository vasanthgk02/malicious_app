package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin._Assertions;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleException;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: ModuleDescriptorImpl.kt */
public final class ModuleDescriptorImpl extends DeclarationDescriptorImpl implements ModuleDescriptor {
    public final KotlinBuiltIns builtIns;
    public final Map<ModuleCapability<?>, Object> capabilities;
    public ModuleDependencies dependencies;
    public boolean isValid;
    public PackageFragmentProvider packageFragmentProviderForModuleContent;
    public final Lazy packageFragmentProviderForWholeModuleWithDependencies$delegate;
    public final MemoizedFunctionToNotNull<FqName, PackageViewDescriptor> packages;
    public final StorageManager storageManager;

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ModuleDescriptorImpl(kotlin.reflect.jvm.internal.impl.name.Name r1, kotlin.reflect.jvm.internal.impl.storage.StorageManager r2, kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r3, java.util.Map r4, kotlin.reflect.jvm.internal.impl.name.Name r5, int r6) {
        /*
            r0 = this;
            r4 = r6 & 16
            r5 = 0
            if (r4 == 0) goto L_0x000a
            java.util.Map r4 = kotlin.collections.ArraysKt___ArraysJvmKt.emptyMap()
            goto L_0x000b
        L_0x000a:
            r4 = r5
        L_0x000b:
            java.lang.String r6 = "moduleName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r6)
            java.lang.String r6 = "storageManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r6)
            java.lang.String r6 = "builtIns"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r6)
            java.lang.String r6 = "capabilities"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r6)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r6 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
            if (r6 == 0) goto L_0x006b
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r6 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.EMPTY
            r0.<init>(r6, r1)
            r0.storageManager = r2
            r0.builtIns = r3
            boolean r2 = r1.special
            if (r2 == 0) goto L_0x005f
            java.util.Map r1 = kotlin.collections.ArraysKt___ArraysJvmKt.toMutableMap(r4)
            r0.capabilities = r1
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability<kotlin.reflect.jvm.internal.impl.types.checker.Ref<kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner>> r2 = kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt.REFINER_CAPABILITY
            kotlin.reflect.jvm.internal.impl.types.checker.Ref r3 = new kotlin.reflect.jvm.internal.impl.types.checker.Ref
            r3.<init>(r5)
            java.util.HashMap r1 = (java.util.HashMap) r1
            r1.put(r2, r3)
            r1 = 1
            r0.isValid = r1
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r1 = r0.storageManager
            kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl$packages$1 r2 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl$packages$1
            r2.<init>(r0)
            kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull r1 = r1.createMemoizedFunction(r2)
            r0.packages = r1
            kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2 r1 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2
            r1.<init>(r0)
            kotlin.Lazy r1 = com.twitter.sdk.android.tweetui.TweetUtils.lazy(r1)
            r0.packageFragmentProviderForWholeModuleWithDependencies$delegate = r1
            return
        L_0x005f:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Module name must be special: "
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r1)
            r2.<init>(r1)
            throw r2
        L_0x006b:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl.<init>(kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.storage.StorageManager, kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns, java.util.Map, kotlin.reflect.jvm.internal.impl.name.Name, int):void");
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d2) {
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(declarationDescriptorVisitor, "visitor");
        return declarationDescriptorVisitor.visitModuleDeclaration(this, d2);
    }

    public void assertValid() {
        if (!this.isValid) {
            throw new InvalidModuleException(Intrinsics.stringPlus("Accessing invalid module descriptor ", this));
        }
    }

    public KotlinBuiltIns getBuiltIns() {
        return this.builtIns;
    }

    public <T> T getCapability(ModuleCapability<T> moduleCapability) {
        Intrinsics.checkNotNullParameter(moduleCapability, "capability");
        return this.capabilities.get(moduleCapability);
    }

    public DeclarationDescriptor getContainingDeclaration() {
        Intrinsics.checkNotNullParameter(this, "this");
        return null;
    }

    public List<ModuleDescriptor> getExpectedByModules() {
        ModuleDependencies moduleDependencies = this.dependencies;
        if (moduleDependencies != null) {
            return moduleDependencies.getDirectExpectedByDependencies();
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Dependencies of module ");
        outline73.append(getId());
        outline73.append(" were not set");
        throw new AssertionError(outline73.toString());
    }

    public final String getId() {
        String str = getName().name;
        Intrinsics.checkNotNullExpressionValue(str, "name.toString()");
        return str;
    }

    public PackageViewDescriptor getPackage(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        assertValid();
        return (PackageViewDescriptor) this.packages.invoke(fqName);
    }

    public Collection<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        assertValid();
        assertValid();
        return ((CompositePackageFragmentProvider) this.packageFragmentProviderForWholeModuleWithDependencies$delegate.getValue()).getSubPackagesOf(fqName, function1);
    }

    public final void initialize(PackageFragmentProvider packageFragmentProvider) {
        Intrinsics.checkNotNullParameter(packageFragmentProvider, "providerForModuleContent");
        boolean z = !(this.packageFragmentProviderForModuleContent != null);
        if (!_Assertions.ENABLED || z) {
            this.packageFragmentProviderForModuleContent = packageFragmentProvider;
            return;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Attempt to initialize module ");
        outline73.append(getId());
        outline73.append(" twice");
        throw new AssertionError(outline73.toString());
    }

    public final void setDependencies(ModuleDescriptorImpl... moduleDescriptorImplArr) {
        Intrinsics.checkNotNullParameter(moduleDescriptorImplArr, "descriptors");
        List list = TweetUtils.toList(moduleDescriptorImplArr);
        Intrinsics.checkNotNullParameter(list, "descriptors");
        EmptySet emptySet = EmptySet.INSTANCE;
        Intrinsics.checkNotNullParameter(list, "descriptors");
        Intrinsics.checkNotNullParameter(emptySet, "friends");
        ModuleDependenciesImpl moduleDependenciesImpl = new ModuleDependenciesImpl(list, emptySet, EmptyList.INSTANCE, EmptySet.INSTANCE);
        Intrinsics.checkNotNullParameter(moduleDependenciesImpl, "dependencies");
        boolean z = this.dependencies == null;
        if (!_Assertions.ENABLED || z) {
            this.dependencies = moduleDependenciesImpl;
            return;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Dependencies of ");
        outline73.append(getId());
        outline73.append(" were already set");
        throw new AssertionError(outline73.toString());
    }

    public boolean shouldSeeInternalsOf(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "targetModule");
        if (Intrinsics.areEqual(this, moduleDescriptor)) {
            return true;
        }
        ModuleDependencies moduleDependencies = this.dependencies;
        Intrinsics.checkNotNull(moduleDependencies);
        if (!ArraysKt___ArraysJvmKt.contains(moduleDependencies.getModulesWhoseInternalsAreVisible(), moduleDescriptor) && !getExpectedByModules().contains(moduleDescriptor) && !moduleDescriptor.getExpectedByModules().contains(this)) {
            return false;
        }
        return true;
    }
}
