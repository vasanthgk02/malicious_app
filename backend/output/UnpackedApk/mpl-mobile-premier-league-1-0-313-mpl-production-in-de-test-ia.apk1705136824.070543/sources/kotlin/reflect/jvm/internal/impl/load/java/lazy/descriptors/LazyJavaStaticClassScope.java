package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.mpl.androidapp.login.LoginReactModule;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptySet;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: LazyJavaStaticClassScope.kt */
public final class LazyJavaStaticClassScope extends LazyJavaStaticScope {
    public final JavaClass jClass;
    public final LazyJavaClassDescriptor ownerDescriptor;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaStaticClassScope(LazyJavaResolverContext lazyJavaResolverContext, JavaClass javaClass, LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        // Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        // Intrinsics.checkNotNullParameter(javaClass, "jClass");
        // Intrinsics.checkNotNullParameter(lazyJavaClassDescriptor, "ownerDescriptor");
        super(lazyJavaResolverContext);
        this.jClass = javaClass;
        this.ownerDescriptor = lazyJavaClassDescriptor;
    }

    public Set<Name> computeClassNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        return EmptySet.INSTANCE;
    }

    public Set<Name> computeFunctionNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Set<Name> mutableSet = ArraysKt___ArraysJvmKt.toMutableSet(((DeclaredMemberIndex) this.declaredMemberIndex.invoke()).getMethodNames());
        LazyJavaStaticClassScope parentJavaStaticClassScope = TweetUtils.getParentJavaStaticClassScope(this.ownerDescriptor);
        Collection functionNames = parentJavaStaticClassScope == null ? null : parentJavaStaticClassScope.getFunctionNames();
        if (functionNames == null) {
            functionNames = EmptySet.INSTANCE;
        }
        mutableSet.addAll(functionNames);
        if (this.jClass.isEnum()) {
            mutableSet.addAll(TweetUtils.listOf((T[]) new Name[]{StandardNames.ENUM_VALUE_OF, StandardNames.ENUM_VALUES}));
        }
        return mutableSet;
    }

    public DeclaredMemberIndex computeMemberIndex() {
        return new ClassDeclaredMemberIndex(this.jClass, LazyJavaStaticClassScope$computeMemberIndex$1.INSTANCE);
    }

    public void computeNonDeclaredFunctions(Collection<SimpleFunctionDescriptor> collection, Name name) {
        Set<T> set;
        Intrinsics.checkNotNullParameter(collection, LoginReactModule.RESULT);
        Intrinsics.checkNotNullParameter(name, "name");
        LazyJavaStaticClassScope parentJavaStaticClassScope = TweetUtils.getParentJavaStaticClassScope(this.ownerDescriptor);
        if (parentJavaStaticClassScope == null) {
            set = EmptySet.INSTANCE;
        } else {
            set = ArraysKt___ArraysJvmKt.toSet(parentJavaStaticClassScope.getContributedFunctions(name, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
        }
        Collection collection2 = set;
        LazyJavaClassDescriptor lazyJavaClassDescriptor = this.ownerDescriptor;
        JavaResolverComponents javaResolverComponents = this.f5943c.components;
        Collection<D> resolveOverridesForStaticMembers = TweetUtils.resolveOverridesForStaticMembers(name, collection2, collection, lazyJavaClassDescriptor, javaResolverComponents.errorReporter, javaResolverComponents.kotlinTypeChecker.getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(resolveOverridesForStaticMembers, "resolveOverridesForStaticMembers(\n            name,\n            functionsFromSupertypes,\n            result,\n            ownerDescriptor,\n            c.components.errorReporter,\n            c.components.kotlinTypeChecker.overridingUtil\n        )");
        collection.addAll(resolveOverridesForStaticMembers);
        if (!this.jClass.isEnum()) {
            return;
        }
        if (Intrinsics.areEqual(name, StandardNames.ENUM_VALUE_OF)) {
            SimpleFunctionDescriptor createEnumValueOfMethod = TweetUtils.createEnumValueOfMethod(this.ownerDescriptor);
            Intrinsics.checkNotNullExpressionValue(createEnumValueOfMethod, "createEnumValueOfMethod(ownerDescriptor)");
            collection.add(createEnumValueOfMethod);
        } else if (Intrinsics.areEqual(name, StandardNames.ENUM_VALUES)) {
            SimpleFunctionDescriptor createEnumValuesMethod = TweetUtils.createEnumValuesMethod(this.ownerDescriptor);
            Intrinsics.checkNotNullExpressionValue(createEnumValuesMethod, "createEnumValuesMethod(ownerDescriptor)");
            collection.add(createEnumValuesMethod);
        }
    }

    public void computeNonDeclaredProperties(Name name, Collection<PropertyDescriptor> collection) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(collection, LoginReactModule.RESULT);
        LazyJavaClassDescriptor lazyJavaClassDescriptor = this.ownerDescriptor;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        TypeUtilsKt.dfs(TweetUtils.listOf(lazyJavaClassDescriptor), LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1.INSTANCE, new LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$2(lazyJavaClassDescriptor, linkedHashSet, new LazyJavaStaticClassScope$computeNonDeclaredProperties$propertiesFromSupertypes$1(name)));
        if (!collection.isEmpty()) {
            LazyJavaClassDescriptor lazyJavaClassDescriptor2 = this.ownerDescriptor;
            JavaResolverComponents javaResolverComponents = this.f5943c.components;
            Collection<D> resolveOverridesForStaticMembers = TweetUtils.resolveOverridesForStaticMembers(name, linkedHashSet, collection, lazyJavaClassDescriptor2, javaResolverComponents.errorReporter, javaResolverComponents.kotlinTypeChecker.getOverridingUtil());
            Intrinsics.checkNotNullExpressionValue(resolveOverridesForStaticMembers, "resolveOverridesForStaticMembers(\n                    name,\n                    propertiesFromSupertypes,\n                    result,\n                    ownerDescriptor,\n                    c.components.errorReporter,\n                    c.components.kotlinTypeChecker.overridingUtil\n                )");
            collection.addAll(resolveOverridesForStaticMembers);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            PropertyDescriptor realOriginal = getRealOriginal((PropertyDescriptor) next);
            Object obj = linkedHashMap.get(realOriginal);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(realOriginal, obj);
            }
            ((List) obj).add(next);
        }
        ArrayList arrayList = new ArrayList();
        for (Entry value : linkedHashMap.entrySet()) {
            LazyJavaClassDescriptor lazyJavaClassDescriptor3 = this.ownerDescriptor;
            JavaResolverComponents javaResolverComponents2 = this.f5943c.components;
            Collection<D> resolveOverridesForStaticMembers2 = TweetUtils.resolveOverridesForStaticMembers(name, (Collection) value.getValue(), collection, lazyJavaClassDescriptor3, javaResolverComponents2.errorReporter, javaResolverComponents2.kotlinTypeChecker.getOverridingUtil());
            Intrinsics.checkNotNullExpressionValue(resolveOverridesForStaticMembers2, "resolveOverridesForStaticMembers(\n                    name, it.value, result, ownerDescriptor, c.components.errorReporter,\n                    c.components.kotlinTypeChecker.overridingUtil\n                )");
            TweetUtils.addAll(arrayList, resolveOverridesForStaticMembers2);
        }
        collection.addAll(arrayList);
    }

    public Set<Name> computePropertyNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Set<Name> mutableSet = ArraysKt___ArraysJvmKt.toMutableSet(((DeclaredMemberIndex) this.declaredMemberIndex.invoke()).getFieldNames());
        LazyJavaClassDescriptor lazyJavaClassDescriptor = this.ownerDescriptor;
        TypeUtilsKt.dfs(TweetUtils.listOf(lazyJavaClassDescriptor), LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1.INSTANCE, new LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$2(lazyJavaClassDescriptor, mutableSet, LazyJavaStaticClassScope$computePropertyNames$1$1.INSTANCE));
        return mutableSet;
    }

    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return null;
    }

    public DeclarationDescriptor getOwnerDescriptor() {
        return this.ownerDescriptor;
    }

    public final PropertyDescriptor getRealOriginal(PropertyDescriptor propertyDescriptor) {
        if (propertyDescriptor.getKind().isReal()) {
            return propertyDescriptor;
        }
        Collection<? extends PropertyDescriptor> overriddenDescriptors = propertyDescriptor.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "this.overriddenDescriptors");
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(overriddenDescriptors, 10));
        for (PropertyDescriptor propertyDescriptor2 : overriddenDescriptors) {
            Intrinsics.checkNotNullExpressionValue(propertyDescriptor2, "it");
            arrayList.add(getRealOriginal(propertyDescriptor2));
        }
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        return (PropertyDescriptor) ArraysKt___ArraysJvmKt.single(ArraysKt___ArraysJvmKt.toList(ArraysKt___ArraysJvmKt.toMutableSet(arrayList)));
    }
}
