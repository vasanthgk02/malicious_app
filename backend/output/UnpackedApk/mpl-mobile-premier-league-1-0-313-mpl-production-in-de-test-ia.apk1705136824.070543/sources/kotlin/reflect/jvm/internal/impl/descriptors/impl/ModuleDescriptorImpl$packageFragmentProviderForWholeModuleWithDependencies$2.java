package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin._Assertions;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;

/* compiled from: ModuleDescriptorImpl.kt */
public final class ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2 extends Lambda implements Function0<CompositePackageFragmentProvider> {
    public final /* synthetic */ ModuleDescriptorImpl this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2(ModuleDescriptorImpl moduleDescriptorImpl) {
        // this.this$0 = moduleDescriptorImpl;
        super(0);
    }

    public Object invoke() {
        ModuleDescriptorImpl moduleDescriptorImpl = this.this$0;
        ModuleDependencies moduleDependencies = moduleDescriptorImpl.dependencies;
        if (moduleDependencies != null) {
            List<ModuleDescriptorImpl> allDependencies = moduleDependencies.getAllDependencies();
            boolean contains = allDependencies.contains(this.this$0);
            ModuleDescriptorImpl moduleDescriptorImpl2 = this.this$0;
            if (!_Assertions.ENABLED || contains) {
                ModuleDescriptorImpl moduleDescriptorImpl3 = this.this$0;
                for (ModuleDescriptorImpl moduleDescriptorImpl4 : allDependencies) {
                    boolean z = moduleDescriptorImpl4.packageFragmentProviderForModuleContent != null;
                    if (_Assertions.ENABLED && !z) {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Dependency module ");
                        outline73.append(moduleDescriptorImpl4.getId());
                        outline73.append(" was not initialized by the time contents of dependent module ");
                        outline73.append(moduleDescriptorImpl3.getId());
                        outline73.append(" were queried");
                        throw new AssertionError(outline73.toString());
                    }
                }
                ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(allDependencies, 10));
                for (ModuleDescriptorImpl moduleDescriptorImpl5 : allDependencies) {
                    PackageFragmentProvider packageFragmentProvider = moduleDescriptorImpl5.packageFragmentProviderForModuleContent;
                    Intrinsics.checkNotNull(packageFragmentProvider);
                    arrayList.add(packageFragmentProvider);
                }
                return new CompositePackageFragmentProvider(arrayList);
            }
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Module ");
            outline732.append(moduleDescriptorImpl2.getId());
            outline732.append(" is not contained in his own dependencies, this is probably a misconfiguration");
            throw new AssertionError(outline732.toString());
        }
        StringBuilder outline733 = GeneratedOutlineSupport.outline73("Dependencies of module ");
        outline733.append(moduleDescriptorImpl.getId());
        outline733.append(" were not set before querying module content");
        throw new AssertionError(outline733.toString());
    }
}
