package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Substitutable;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: SubstitutingScope.kt */
public final class SubstitutingScope implements MemberScope {
    public final Lazy _allDescriptors$delegate = TweetUtils.lazy((Function0<? extends T>) new SubstitutingScope$_allDescriptors$2<Object>(this));
    public Map<DeclarationDescriptor, DeclarationDescriptor> substitutedDescriptors;
    public final TypeSubstitutor substitutor;
    public final MemberScope workerScope;

    public SubstitutingScope(MemberScope memberScope, TypeSubstitutor typeSubstitutor) {
        Intrinsics.checkNotNullParameter(memberScope, "workerScope");
        Intrinsics.checkNotNullParameter(typeSubstitutor, "givenSubstitutor");
        this.workerScope = memberScope;
        TypeSubstitution substitution = typeSubstitutor.getSubstitution();
        Intrinsics.checkNotNullExpressionValue(substitution, "givenSubstitutor.substitution");
        this.substitutor = TweetUtils.wrapWithCapturingSubstitution$default(substitution, false, 1).buildSubstitutor();
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
        return (ClassifierDescriptor) substitute((D) contributedClassifier);
    }

    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        return (Collection) this._allDescriptors$delegate.getValue();
    }

    public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return substitute(this.workerScope.getContributedFunctions(name, lookupLocation));
    }

    public Collection<? extends PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return substitute(this.workerScope.getContributedVariables(name, lookupLocation));
    }

    public Set<Name> getFunctionNames() {
        return this.workerScope.getFunctionNames();
    }

    public Set<Name> getVariableNames() {
        return this.workerScope.getVariableNames();
    }

    public final <D extends DeclarationDescriptor> D substitute(D d2) {
        if (this.substitutor.isEmpty()) {
            return d2;
        }
        if (this.substitutedDescriptors == null) {
            this.substitutedDescriptors = new HashMap();
        }
        Map<DeclarationDescriptor, DeclarationDescriptor> map = this.substitutedDescriptors;
        Intrinsics.checkNotNull(map);
        D d3 = map.get(d2);
        if (d3 == null) {
            if (d2 instanceof Substitutable) {
                d3 = ((Substitutable) d2).substitute(this.substitutor);
                if (d3 != null) {
                    map.put(d2, d3);
                } else {
                    throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + d2 + " substitution fails");
                }
            } else {
                throw new IllegalStateException(Intrinsics.stringPlus("Unknown descriptor in scope: ", d2).toString());
            }
        }
        return (DeclarationDescriptor) d3;
    }

    public final <D extends DeclarationDescriptor> Collection<D> substitute(Collection<? extends D> collection) {
        if (this.substitutor.isEmpty() || collection.isEmpty()) {
            return collection;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(TypeUtilsKt.capacity(collection.size()));
        Iterator<? extends D> it = collection.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(substitute((D) (DeclarationDescriptor) it.next()));
        }
        return linkedHashSet;
    }
}
