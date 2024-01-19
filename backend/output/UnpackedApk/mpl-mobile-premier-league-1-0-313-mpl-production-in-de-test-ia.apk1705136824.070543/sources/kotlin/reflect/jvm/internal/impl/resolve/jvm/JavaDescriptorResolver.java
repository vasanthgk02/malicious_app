package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache.AnonymousClass1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;

/* compiled from: JavaDescriptorResolver.kt */
public final class JavaDescriptorResolver {
    public final JavaResolverCache javaResolverCache;
    public final LazyJavaPackageFragmentProvider packageFragmentProvider;

    public JavaDescriptorResolver(LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, JavaResolverCache javaResolverCache2) {
        Intrinsics.checkNotNullParameter(lazyJavaPackageFragmentProvider, "packageFragmentProvider");
        Intrinsics.checkNotNullParameter(javaResolverCache2, "javaResolverCache");
        this.packageFragmentProvider = lazyJavaPackageFragmentProvider;
        this.javaResolverCache = javaResolverCache2;
    }

    public final ClassDescriptor resolveClass(JavaClass javaClass) {
        ClassifierDescriptor classifierDescriptor;
        Intrinsics.checkNotNullParameter(javaClass, "javaClass");
        FqName fqName = javaClass.getFqName();
        ClassDescriptor classDescriptor = null;
        if (fqName == null || javaClass.getLightClassOriginKind() != LightClassOriginKind.SOURCE) {
            JavaClass outerClass = javaClass.getOuterClass();
            if (outerClass != null) {
                ClassDescriptor resolveClass = resolveClass(outerClass);
                ResolutionScope unsubstitutedInnerClassesScope = resolveClass == null ? null : resolveClass.getUnsubstitutedInnerClassesScope();
                if (unsubstitutedInnerClassesScope == null) {
                    classifierDescriptor = null;
                } else {
                    classifierDescriptor = unsubstitutedInnerClassesScope.getContributedClassifier(javaClass.getName(), NoLookupLocation.FROM_JAVA_LOADER);
                }
                if (classifierDescriptor instanceof ClassDescriptor) {
                    classDescriptor = (ClassDescriptor) classifierDescriptor;
                }
                return classDescriptor;
            } else if (fqName == null) {
                return null;
            } else {
                LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider = this.packageFragmentProvider;
                FqName parent = fqName.parent();
                Intrinsics.checkNotNullExpressionValue(parent, "fqName.parent()");
                if (lazyJavaPackageFragmentProvider != null) {
                    Intrinsics.checkNotNullParameter(parent, "fqName");
                    LazyJavaPackageFragment lazyJavaPackageFragment = (LazyJavaPackageFragment) ArraysKt___ArraysJvmKt.firstOrNull(TweetUtils.listOfNotNull(lazyJavaPackageFragmentProvider.getPackageFragment(parent)));
                    if (lazyJavaPackageFragment != null) {
                        Intrinsics.checkNotNullParameter(javaClass, "jClass");
                        LazyJavaPackageScope lazyJavaPackageScope = lazyJavaPackageFragment.scope.javaScope;
                        if (lazyJavaPackageScope != null) {
                            Intrinsics.checkNotNullParameter(javaClass, "javaClass");
                            classDescriptor = lazyJavaPackageScope.findClassifier(javaClass.getName(), javaClass);
                        } else {
                            throw null;
                        }
                    }
                    return classDescriptor;
                }
                throw null;
            }
        } else if (((AnonymousClass1) this.javaResolverCache) != null) {
            return null;
        } else {
            throw null;
        }
    }
}
