package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.EmptySet;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: JvmPackageScope.kt */
public final class JvmPackageScope implements MemberScope {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmPackageScope.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};

    /* renamed from: c  reason: collision with root package name */
    public final LazyJavaResolverContext f5939c;
    public final LazyJavaPackageScope javaScope;
    public final NotNullLazyValue kotlinScopes$delegate = this.f5939c.components.storageManager.createLazyValue(new JvmPackageScope$kotlinScopes$2(this));
    public final LazyJavaPackageFragment packageFragment;

    public JvmPackageScope(LazyJavaResolverContext lazyJavaResolverContext, JavaPackage javaPackage, LazyJavaPackageFragment lazyJavaPackageFragment) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        Intrinsics.checkNotNullParameter(javaPackage, "jPackage");
        Intrinsics.checkNotNullParameter(lazyJavaPackageFragment, "packageFragment");
        this.f5939c = lazyJavaResolverContext;
        this.packageFragment = lazyJavaPackageFragment;
        this.javaScope = new LazyJavaPackageScope(this.f5939c, javaPackage, this.packageFragment);
    }

    public Set<Name> getClassifierNames() {
        Set<Name> flatMapClassifierNamesOrNull = TweetUtils.flatMapClassifierNamesOrNull(TweetUtils.asIterable(getKotlinScopes()));
        if (flatMapClassifierNamesOrNull == null) {
            return null;
        }
        flatMapClassifierNamesOrNull.addAll(this.javaScope.getClassifierNames());
        return flatMapClassifierNamesOrNull;
    }

    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation lookupLocation) {
        ClassifierDescriptor contributedClassifier;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        recordLookup(name, lookupLocation);
        LazyJavaPackageScope lazyJavaPackageScope = this.javaScope;
        ClassifierDescriptor classifierDescriptor = null;
        if (lazyJavaPackageScope != null) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            ClassDescriptor findClassifier = lazyJavaPackageScope.findClassifier(name, null);
            if (findClassifier != null) {
                return findClassifier;
            }
            MemberScope[] kotlinScopes = getKotlinScopes();
            int i = 0;
            int length = kotlinScopes.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                MemberScope memberScope = kotlinScopes[i];
                i++;
                contributedClassifier = memberScope.getContributedClassifier(name, lookupLocation);
                if (contributedClassifier != null) {
                    if (!(contributedClassifier instanceof ClassifierDescriptorWithTypeParameters) || !((ClassifierDescriptorWithTypeParameters) contributedClassifier).isExpect()) {
                        classifierDescriptor = contributedClassifier;
                    } else if (classifierDescriptor == null) {
                        classifierDescriptor = contributedClassifier;
                    }
                }
            }
            classifierDescriptor = contributedClassifier;
            return classifierDescriptor;
        }
        throw null;
    }

    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        LazyJavaPackageScope lazyJavaPackageScope = this.javaScope;
        MemberScope[] kotlinScopes = getKotlinScopes();
        Collection contributedDescriptors = lazyJavaPackageScope.getContributedDescriptors(descriptorKindFilter, function1);
        int length = kotlinScopes.length;
        int i = 0;
        while (i < length) {
            MemberScope memberScope = kotlinScopes[i];
            i++;
            contributedDescriptors = TypeUtilsKt.concat(contributedDescriptors, memberScope.getContributedDescriptors(descriptorKindFilter, function1));
        }
        return contributedDescriptors == null ? EmptySet.INSTANCE : contributedDescriptors;
    }

    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        recordLookup(name, lookupLocation);
        LazyJavaPackageScope lazyJavaPackageScope = this.javaScope;
        MemberScope[] kotlinScopes = getKotlinScopes();
        Collection contributedFunctions = lazyJavaPackageScope.getContributedFunctions(name, lookupLocation);
        int length = kotlinScopes.length;
        int i = 0;
        while (i < length) {
            MemberScope memberScope = kotlinScopes[i];
            i++;
            contributedFunctions = TypeUtilsKt.concat(contributedFunctions, memberScope.getContributedFunctions(name, lookupLocation));
        }
        return contributedFunctions == null ? EmptySet.INSTANCE : contributedFunctions;
    }

    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        recordLookup(name, lookupLocation);
        LazyJavaPackageScope lazyJavaPackageScope = this.javaScope;
        MemberScope[] kotlinScopes = getKotlinScopes();
        Collection contributedVariables = lazyJavaPackageScope.getContributedVariables(name, lookupLocation);
        int length = kotlinScopes.length;
        int i = 0;
        while (i < length) {
            MemberScope memberScope = kotlinScopes[i];
            i++;
            contributedVariables = TypeUtilsKt.concat(contributedVariables, memberScope.getContributedVariables(name, lookupLocation));
        }
        return contributedVariables == null ? EmptySet.INSTANCE : contributedVariables;
    }

    public Set<Name> getFunctionNames() {
        MemberScope[] kotlinScopes = getKotlinScopes();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope functionNames : kotlinScopes) {
            TweetUtils.addAll(linkedHashSet, functionNames.getFunctionNames());
        }
        linkedHashSet.addAll(this.javaScope.getFunctionNames());
        return linkedHashSet;
    }

    public final MemberScope[] getKotlinScopes() {
        return (MemberScope[]) TweetUtils.getValue(this.kotlinScopes$delegate, $$delegatedProperties[0]);
    }

    public Set<Name> getVariableNames() {
        MemberScope[] kotlinScopes = getKotlinScopes();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope variableNames : kotlinScopes) {
            TweetUtils.addAll(linkedHashSet, variableNames.getVariableNames());
        }
        linkedHashSet.addAll(this.javaScope.getVariableNames());
        return linkedHashSet;
    }

    public void recordLookup(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        TweetUtils.record(this.f5939c.components.lookupTracker, lookupLocation, (PackageFragmentDescriptor) this.packageFragment, name);
    }
}
