package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* compiled from: TypeIntersectionScope.kt */
public final class TypeIntersectionScope extends AbstractScopeAdapter {
    public final MemberScope workerScope;

    /* compiled from: TypeIntersectionScope.kt */
    public static final class Companion {
        public static final MemberScope create(String str, Collection<? extends KotlinType> collection) {
            Intrinsics.checkNotNullParameter(str, "message");
            Intrinsics.checkNotNullParameter(collection, "types");
            ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(collection, 10));
            for (KotlinType memberScope : collection) {
                arrayList.add(memberScope.getMemberScope());
            }
            SmartList<MemberScope> listOfNonEmptyScopes = TypeUtilsKt.listOfNonEmptyScopes(arrayList);
            MemberScope createOrSingle$descriptors = ChainedMemberScope.createOrSingle$descriptors(str, listOfNonEmptyScopes);
            if (listOfNonEmptyScopes.mySize <= 1) {
                return createOrSingle$descriptors;
            }
            return new TypeIntersectionScope(str, createOrSingle$descriptors, null);
        }
    }

    public TypeIntersectionScope(String str, MemberScope memberScope, DefaultConstructorMarker defaultConstructorMarker) {
        this.workerScope = memberScope;
    }

    public static final MemberScope create(String str, Collection<? extends KotlinType> collection) {
        MemberScope memberScope;
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(collection, "types");
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(collection, 10));
        for (KotlinType memberScope2 : collection) {
            arrayList.add(memberScope2.getMemberScope());
        }
        SmartList<MemberScope> listOfNonEmptyScopes = TypeUtilsKt.listOfNonEmptyScopes(arrayList);
        Intrinsics.checkNotNullParameter(str, "debugName");
        Intrinsics.checkNotNullParameter(listOfNonEmptyScopes, "scopes");
        int size = listOfNonEmptyScopes.size();
        if (size == 0) {
            memberScope = Empty.INSTANCE;
        } else if (size != 1) {
            Object[] array = listOfNonEmptyScopes.toArray(new MemberScope[0]);
            if (array != null) {
                new ChainedMemberScope(str, (MemberScope[]) array, null);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        } else {
            memberScope = (MemberScope) listOfNonEmptyScopes.get(0);
        }
        return listOfNonEmptyScopes.mySize <= 1 ? memberScope : new TypeIntersectionScope(str, memberScope, null);
    }

    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        Collection<DeclarationDescriptor> contributedDescriptors = super.getContributedDescriptors(descriptorKindFilter, function1);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T next : contributedDescriptors) {
            if (((DeclarationDescriptor) next) instanceof CallableDescriptor) {
                arrayList.add(next);
            } else {
                arrayList2.add(next);
            }
        }
        return ArraysKt___ArraysJvmKt.plus(TweetUtils.selectMostSpecificInEachOverridableGroup(arrayList, TypeIntersectionScope$getContributedDescriptors$2.INSTANCE), (Iterable<? extends T>) arrayList2);
    }

    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return TweetUtils.selectMostSpecificInEachOverridableGroup(super.getContributedFunctions(name, lookupLocation), TypeIntersectionScope$getContributedFunctions$1.INSTANCE);
    }

    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return TweetUtils.selectMostSpecificInEachOverridableGroup(super.getContributedVariables(name, lookupLocation), TypeIntersectionScope$getContributedVariables$1.INSTANCE);
    }

    public MemberScope getWorkerScope() {
        return this.workerScope;
    }
}
