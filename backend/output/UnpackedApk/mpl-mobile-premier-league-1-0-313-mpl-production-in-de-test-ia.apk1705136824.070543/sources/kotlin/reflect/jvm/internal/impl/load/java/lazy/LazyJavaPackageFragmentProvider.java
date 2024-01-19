package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Collection;
import java.util.List;
import kotlin.InitializedLazyImpl;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver.EMPTY;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.CacheWithNotNullValuesBasedOnMemoizedFunction;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: LazyJavaPackageFragmentProvider.kt */
public final class LazyJavaPackageFragmentProvider implements PackageFragmentProviderOptimized {

    /* renamed from: c  reason: collision with root package name */
    public final LazyJavaResolverContext f5937c;
    public final CacheWithNotNullValues<FqName, LazyJavaPackageFragment> packageFragments;

    public LazyJavaPackageFragmentProvider(JavaResolverComponents javaResolverComponents) {
        Intrinsics.checkNotNullParameter(javaResolverComponents, "components");
        LazyJavaResolverContext lazyJavaResolverContext = new LazyJavaResolverContext(javaResolverComponents, EMPTY.INSTANCE, new InitializedLazyImpl(null));
        this.f5937c = lazyJavaResolverContext;
        this.packageFragments = lazyJavaResolverContext.components.storageManager.createCacheWithNotNullValues();
    }

    public void collectPackageFragments(FqName fqName, Collection<PackageFragmentDescriptor> collection) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(collection, "packageFragments");
        TypeUtilsKt.addIfNotNull(collection, getPackageFragment(fqName));
    }

    public final LazyJavaPackageFragment getPackageFragment(FqName fqName) {
        JavaPackage findPackage = this.f5937c.components.finder.findPackage(fqName);
        if (findPackage == null) {
            return null;
        }
        return (LazyJavaPackageFragment) ((CacheWithNotNullValuesBasedOnMemoizedFunction) this.packageFragments).computeIfAbsent(fqName, new LazyJavaPackageFragmentProvider$getPackageFragment$1(this, findPackage));
    }

    public List<LazyJavaPackageFragment> getPackageFragments(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return TweetUtils.listOfNotNull(getPackageFragment(fqName));
    }

    public Collection getSubPackagesOf(FqName fqName, Function1 function1) {
        List list;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        LazyJavaPackageFragment packageFragment = getPackageFragment(fqName);
        if (packageFragment == null) {
            list = null;
        } else {
            list = (List) packageFragment.subPackages.invoke();
        }
        return list != null ? list : EmptyList.INSTANCE;
    }
}
