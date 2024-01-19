package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude.NonExtensions;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Companion;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: LazyJavaScope.kt */
public final class LazyJavaScope$allDescriptors$1 extends Lambda implements Function0<Collection<? extends DeclarationDescriptor>> {
    public final /* synthetic */ LazyJavaScope this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaScope$allDescriptors$1(LazyJavaScope lazyJavaScope) {
        // this.this$0 = lazyJavaScope;
        super(0);
    }

    public Object invoke() {
        LazyJavaScope lazyJavaScope = this.this$0;
        DescriptorKindFilter descriptorKindFilter = DescriptorKindFilter.ALL;
        if (MemberScope.Companion != null) {
            Function1<Name, Boolean> function1 = Companion.ALL_NAME_FILTER;
            if (lazyJavaScope != null) {
                Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
                Intrinsics.checkNotNullParameter(function1, "nameFilter");
                NoLookupLocation noLookupLocation = NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS;
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                DescriptorKindFilter.Companion companion = DescriptorKindFilter.Companion;
                if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.CLASSIFIERS_MASK)) {
                    for (Name next : lazyJavaScope.computeClassNames(descriptorKindFilter, function1)) {
                        if (((Boolean) function1.invoke(next)).booleanValue()) {
                            TypeUtilsKt.addIfNotNull(linkedHashSet, lazyJavaScope.getContributedClassifier(next, noLookupLocation));
                        }
                    }
                }
                DescriptorKindFilter.Companion companion2 = DescriptorKindFilter.Companion;
                if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.FUNCTIONS_MASK) && !descriptorKindFilter.excludes.contains(NonExtensions.INSTANCE)) {
                    for (Name next2 : lazyJavaScope.computeFunctionNames(descriptorKindFilter, function1)) {
                        if (((Boolean) function1.invoke(next2)).booleanValue()) {
                            linkedHashSet.addAll(lazyJavaScope.getContributedFunctions(next2, noLookupLocation));
                        }
                    }
                }
                DescriptorKindFilter.Companion companion3 = DescriptorKindFilter.Companion;
                if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.VARIABLES_MASK) && !descriptorKindFilter.excludes.contains(NonExtensions.INSTANCE)) {
                    for (Name next3 : lazyJavaScope.computePropertyNames(descriptorKindFilter, function1)) {
                        if (((Boolean) function1.invoke(next3)).booleanValue()) {
                            linkedHashSet.addAll(lazyJavaScope.getContributedVariables(next3, noLookupLocation));
                        }
                    }
                }
                return ArraysKt___ArraysJvmKt.toList(linkedHashSet);
            }
            throw null;
        }
        throw null;
    }
}
