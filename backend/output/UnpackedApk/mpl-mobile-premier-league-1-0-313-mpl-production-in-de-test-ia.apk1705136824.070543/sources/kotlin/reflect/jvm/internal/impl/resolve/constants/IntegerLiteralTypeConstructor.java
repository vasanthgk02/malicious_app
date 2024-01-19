package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* compiled from: IntegerLiteralTypeConstructor.kt */
public final class IntegerLiteralTypeConstructor implements TypeConstructor {
    public final ModuleDescriptor module;
    public final Set<KotlinType> possibleTypes;
    public final Lazy supertypes$delegate;
    public final SimpleType type;
    public final long value;

    public IntegerLiteralTypeConstructor(long j, ModuleDescriptor moduleDescriptor, Set set, DefaultConstructorMarker defaultConstructorMarker) {
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        if (Annotations.Companion != null) {
            this.type = KotlinTypeFactory.integerLiteralType(Companion.EMPTY, this, false);
            this.supertypes$delegate = TweetUtils.lazy((Function0<? extends T>) new IntegerLiteralTypeConstructor$supertypes$2<Object>(this));
            this.value = j;
            this.module = moduleDescriptor;
            this.possibleTypes = set;
            return;
        }
        throw null;
    }

    public final boolean checkConstructor(TypeConstructor typeConstructor) {
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        Set<KotlinType> set = this.possibleTypes;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            for (KotlinType constructor : set) {
                if (Intrinsics.areEqual(constructor.getConstructor(), typeConstructor)) {
                    return true;
                }
            }
        }
        return false;
    }

    public KotlinBuiltIns getBuiltIns() {
        return this.module.getBuiltIns();
    }

    public ClassifierDescriptor getDeclarationDescriptor() {
        return null;
    }

    public List<TypeParameterDescriptor> getParameters() {
        return EmptyList.INSTANCE;
    }

    public Collection<KotlinType> getSupertypes() {
        return (List) this.supertypes$delegate.getValue();
    }

    public boolean isDenotable() {
        return false;
    }

    public String toString() {
        StringBuilder outline72 = GeneratedOutlineSupport.outline72('[');
        outline72.append(ArraysKt___ArraysJvmKt.joinToString$default(this.possibleTypes, ",", null, null, 0, null, IntegerLiteralTypeConstructor$valueToString$1.INSTANCE, 30));
        outline72.append(']');
        return Intrinsics.stringPlus("IntegerLiteralType", outline72.toString());
    }
}
