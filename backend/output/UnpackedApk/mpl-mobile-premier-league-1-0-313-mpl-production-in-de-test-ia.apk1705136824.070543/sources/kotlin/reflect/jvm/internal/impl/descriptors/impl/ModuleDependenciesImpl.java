package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModuleDescriptorImpl.kt */
public final class ModuleDependenciesImpl implements ModuleDependencies {
    public final List<ModuleDescriptorImpl> allDependencies;
    public final List<ModuleDescriptorImpl> directExpectedByDependencies;
    public final Set<ModuleDescriptorImpl> modulesWhoseInternalsAreVisible;

    public ModuleDependenciesImpl(List<ModuleDescriptorImpl> list, Set<ModuleDescriptorImpl> set, List<ModuleDescriptorImpl> list2, Set<ModuleDescriptorImpl> set2) {
        Intrinsics.checkNotNullParameter(list, "allDependencies");
        Intrinsics.checkNotNullParameter(set, "modulesWhoseInternalsAreVisible");
        Intrinsics.checkNotNullParameter(list2, "directExpectedByDependencies");
        Intrinsics.checkNotNullParameter(set2, "allExpectedByDependencies");
        this.allDependencies = list;
        this.modulesWhoseInternalsAreVisible = set;
        this.directExpectedByDependencies = list2;
    }

    public List<ModuleDescriptorImpl> getAllDependencies() {
        return this.allDependencies;
    }

    public List<ModuleDescriptorImpl> getDirectExpectedByDependencies() {
        return this.directExpectedByDependencies;
    }

    public Set<ModuleDescriptorImpl> getModulesWhoseInternalsAreVisible() {
        return this.modulesWhoseInternalsAreVisible;
    }
}
