package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: CompositePackageFragmentProvider.kt */
public final class CompositePackageFragmentProvider implements PackageFragmentProviderOptimized {
    public final List<PackageFragmentProvider> providers;

    public CompositePackageFragmentProvider(List<? extends PackageFragmentProvider> list) {
        Intrinsics.checkNotNullParameter(list, "providers");
        this.providers = list;
        boolean z = list.size() == ArraysKt___ArraysJvmKt.toSet(this.providers).size();
        if (_Assertions.ENABLED && !z) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("providers.size is ");
            outline73.append(this.providers.size());
            outline73.append(" while only ");
            outline73.append(ArraysKt___ArraysJvmKt.toSet(this.providers).size());
            outline73.append(" unique providers");
            throw new AssertionError(outline73.toString());
        }
    }

    public void collectPackageFragments(FqName fqName, Collection<PackageFragmentDescriptor> collection) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(collection, "packageFragments");
        for (PackageFragmentProvider collectPackageFragmentsOptimizedIfPossible : this.providers) {
            TweetUtils.collectPackageFragmentsOptimizedIfPossible(collectPackageFragmentsOptimizedIfPossible, fqName, collection);
        }
    }

    public List<PackageFragmentDescriptor> getPackageFragments(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        ArrayList arrayList = new ArrayList();
        for (PackageFragmentProvider collectPackageFragmentsOptimizedIfPossible : this.providers) {
            TweetUtils.collectPackageFragmentsOptimizedIfPossible(collectPackageFragmentsOptimizedIfPossible, fqName, arrayList);
        }
        return ArraysKt___ArraysJvmKt.toList(arrayList);
    }

    public Collection<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        HashSet hashSet = new HashSet();
        for (PackageFragmentProvider subPackagesOf : this.providers) {
            hashSet.addAll(subPackagesOf.getSubPackagesOf(fqName, function1));
        }
        return hashSet;
    }
}
