package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude.TopLevelPackages;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: SubpackagesScope.kt */
public class SubpackagesScope extends MemberScopeImpl {
    public final FqName fqName;
    public final ModuleDescriptor moduleDescriptor;

    public SubpackagesScope(ModuleDescriptor moduleDescriptor2, FqName fqName2) {
        Intrinsics.checkNotNullParameter(moduleDescriptor2, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(fqName2, "fqName");
        this.moduleDescriptor = moduleDescriptor2;
        this.fqName = fqName2;
    }

    public Set<Name> getClassifierNames() {
        return EmptySet.INSTANCE;
    }

    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        Companion companion = DescriptorKindFilter.Companion;
        if (!descriptorKindFilter.acceptsKinds(DescriptorKindFilter.PACKAGES_MASK)) {
            return EmptyList.INSTANCE;
        }
        if (this.fqName.isRoot() && descriptorKindFilter.excludes.contains(TopLevelPackages.INSTANCE)) {
            return EmptyList.INSTANCE;
        }
        Collection<FqName> subPackagesOf = this.moduleDescriptor.getSubPackagesOf(this.fqName, function1);
        ArrayList arrayList = new ArrayList(subPackagesOf.size());
        for (FqName shortName : subPackagesOf) {
            Name shortName2 = shortName.shortName();
            Intrinsics.checkNotNullExpressionValue(shortName2, "subFqName.shortName()");
            if (((Boolean) function1.invoke(shortName2)).booleanValue()) {
                Intrinsics.checkNotNullParameter(shortName2, "name");
                PackageViewDescriptor packageViewDescriptor = null;
                if (!shortName2.special) {
                    ModuleDescriptor moduleDescriptor2 = this.moduleDescriptor;
                    FqName child = this.fqName.child(shortName2);
                    Intrinsics.checkNotNullExpressionValue(child, "fqName.child(name)");
                    PackageViewDescriptor packageViewDescriptor2 = moduleDescriptor2.getPackage(child);
                    if (!packageViewDescriptor2.isEmpty()) {
                        packageViewDescriptor = packageViewDescriptor2;
                    }
                }
                TypeUtilsKt.addIfNotNull(arrayList, packageViewDescriptor);
            }
        }
        return arrayList;
    }
}
