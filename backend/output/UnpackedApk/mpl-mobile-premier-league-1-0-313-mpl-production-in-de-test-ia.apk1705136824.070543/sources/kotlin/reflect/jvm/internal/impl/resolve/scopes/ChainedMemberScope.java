package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* compiled from: ChainedMemberScope.kt */
public final class ChainedMemberScope implements MemberScope {
    public final String debugName;
    public final MemberScope[] scopes;

    public ChainedMemberScope(String str, MemberScope[] memberScopeArr, DefaultConstructorMarker defaultConstructorMarker) {
        this.debugName = str;
        this.scopes = memberScopeArr;
    }

    public static final MemberScope create(String str, Iterable<? extends MemberScope> iterable) {
        Intrinsics.checkNotNullParameter(str, "debugName");
        Intrinsics.checkNotNullParameter(iterable, "scopes");
        SmartList smartList = new SmartList();
        for (MemberScope memberScope : iterable) {
            if (memberScope != Empty.INSTANCE) {
                if (memberScope instanceof ChainedMemberScope) {
                    MemberScope[] memberScopeArr = ((ChainedMemberScope) memberScope).scopes;
                    Intrinsics.checkNotNullParameter(smartList, "<this>");
                    Intrinsics.checkNotNullParameter(memberScopeArr, "elements");
                    smartList.addAll(ArraysKt___ArraysJvmKt.asList(memberScopeArr));
                } else {
                    smartList.add(memberScope);
                }
            }
        }
        return createOrSingle$descriptors(str, smartList);
    }

    public static final MemberScope createOrSingle$descriptors(String str, List<? extends MemberScope> list) {
        Intrinsics.checkNotNullParameter(str, "debugName");
        Intrinsics.checkNotNullParameter(list, "scopes");
        int size = list.size();
        if (size == 0) {
            return Empty.INSTANCE;
        }
        if (size == 1) {
            return (MemberScope) list.get(0);
        }
        Object[] array = list.toArray(new MemberScope[0]);
        if (array != null) {
            return new ChainedMemberScope(str, (MemberScope[]) array, null);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public Set<Name> getClassifierNames() {
        return TweetUtils.flatMapClassifierNamesOrNull(TweetUtils.asIterable(this.scopes));
    }

    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        MemberScope[] memberScopeArr = this.scopes;
        int length = memberScopeArr.length;
        ClassifierDescriptor classifierDescriptor = null;
        int i = 0;
        while (i < length) {
            MemberScope memberScope = memberScopeArr[i];
            i++;
            ClassifierDescriptor contributedClassifier = memberScope.getContributedClassifier(name, lookupLocation);
            if (contributedClassifier != null) {
                if (!(contributedClassifier instanceof ClassifierDescriptorWithTypeParameters) || !((ClassifierDescriptorWithTypeParameters) contributedClassifier).isExpect()) {
                    return contributedClassifier;
                }
                if (classifierDescriptor == null) {
                    classifierDescriptor = contributedClassifier;
                }
            }
        }
        return classifierDescriptor;
    }

    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        MemberScope[] memberScopeArr = this.scopes;
        int length = memberScopeArr.length;
        if (length == 0) {
            return EmptyList.INSTANCE;
        }
        int i = 0;
        if (length == 1) {
            return memberScopeArr[0].getContributedDescriptors(descriptorKindFilter, function1);
        }
        Collection<DeclarationDescriptor> collection = null;
        int length2 = memberScopeArr.length;
        while (i < length2) {
            MemberScope memberScope = memberScopeArr[i];
            i++;
            collection = TypeUtilsKt.concat(collection, memberScope.getContributedDescriptors(descriptorKindFilter, function1));
        }
        if (collection == null) {
            return EmptySet.INSTANCE;
        }
        return collection;
    }

    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        MemberScope[] memberScopeArr = this.scopes;
        int length = memberScopeArr.length;
        if (length == 0) {
            return EmptyList.INSTANCE;
        }
        int i = 0;
        if (length == 1) {
            return memberScopeArr[0].getContributedFunctions(name, lookupLocation);
        }
        Collection<SimpleFunctionDescriptor> collection = null;
        int length2 = memberScopeArr.length;
        while (i < length2) {
            MemberScope memberScope = memberScopeArr[i];
            i++;
            collection = TypeUtilsKt.concat(collection, memberScope.getContributedFunctions(name, lookupLocation));
        }
        if (collection == null) {
            return EmptySet.INSTANCE;
        }
        return collection;
    }

    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        MemberScope[] memberScopeArr = this.scopes;
        int length = memberScopeArr.length;
        if (length == 0) {
            return EmptyList.INSTANCE;
        }
        int i = 0;
        if (length == 1) {
            return memberScopeArr[0].getContributedVariables(name, lookupLocation);
        }
        Collection<PropertyDescriptor> collection = null;
        int length2 = memberScopeArr.length;
        while (i < length2) {
            MemberScope memberScope = memberScopeArr[i];
            i++;
            collection = TypeUtilsKt.concat(collection, memberScope.getContributedVariables(name, lookupLocation));
        }
        if (collection == null) {
            return EmptySet.INSTANCE;
        }
        return collection;
    }

    public Set<Name> getFunctionNames() {
        MemberScope[] memberScopeArr = this.scopes;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope functionNames : memberScopeArr) {
            TweetUtils.addAll(linkedHashSet, functionNames.getFunctionNames());
        }
        return linkedHashSet;
    }

    public Set<Name> getVariableNames() {
        MemberScope[] memberScopeArr = this.scopes;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope variableNames : memberScopeArr) {
            TweetUtils.addAll(linkedHashSet, variableNames.getVariableNames());
        }
        return linkedHashSet;
    }

    public String toString() {
        return this.debugName;
    }
}
