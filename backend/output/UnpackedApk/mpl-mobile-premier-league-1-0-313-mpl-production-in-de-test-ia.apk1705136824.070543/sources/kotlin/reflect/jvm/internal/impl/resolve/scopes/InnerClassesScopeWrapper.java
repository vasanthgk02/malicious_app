package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion;

/* compiled from: InnerClassesScopeWrapper.kt */
public final class InnerClassesScopeWrapper extends MemberScopeImpl {
    public final MemberScope workerScope;

    public InnerClassesScopeWrapper(MemberScope memberScope) {
        Intrinsics.checkNotNullParameter(memberScope, "workerScope");
        this.workerScope = memberScope;
    }

    public Set<Name> getClassifierNames() {
        return this.workerScope.getClassifierNames();
    }

    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        ClassifierDescriptor contributedClassifier = this.workerScope.getContributedClassifier(name, lookupLocation);
        if (contributedClassifier == null) {
            return null;
        }
        ClassifierDescriptor classifierDescriptor = contributedClassifier instanceof ClassDescriptor ? (ClassDescriptor) contributedClassifier : null;
        if (classifierDescriptor != null) {
            return classifierDescriptor;
        }
        if (contributedClassifier instanceof TypeAliasDescriptor) {
            return (TypeAliasDescriptor) contributedClassifier;
        }
        return null;
    }

    public Collection getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1 function1) {
        DescriptorKindFilter descriptorKindFilter2;
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        Companion companion = DescriptorKindFilter.Companion;
        int i = DescriptorKindFilter.CLASSIFIERS_MASK & descriptorKindFilter.kindMask;
        if (i == 0) {
            descriptorKindFilter2 = null;
        } else {
            descriptorKindFilter2 = new DescriptorKindFilter(i, descriptorKindFilter.excludes);
        }
        if (descriptorKindFilter2 == null) {
            return EmptyList.INSTANCE;
        }
        Collection<DeclarationDescriptor> contributedDescriptors = this.workerScope.getContributedDescriptors(descriptorKindFilter2, function1);
        ArrayList arrayList = new ArrayList();
        for (T next : contributedDescriptors) {
            if (next instanceof ClassifierDescriptorWithTypeParameters) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public Set<Name> getFunctionNames() {
        return this.workerScope.getFunctionNames();
    }

    public Set<Name> getVariableNames() {
        return this.workerScope.getVariableNames();
    }

    public String toString() {
        return Intrinsics.stringPlus("Classes from ", this.workerScope);
    }
}
