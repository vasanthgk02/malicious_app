package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* compiled from: AbstractTypeAliasDescriptor.kt */
public final class AbstractTypeAliasDescriptor$typeConstructor$1 implements TypeConstructor {
    public final /* synthetic */ AbstractTypeAliasDescriptor this$0;

    public AbstractTypeAliasDescriptor$typeConstructor$1(AbstractTypeAliasDescriptor abstractTypeAliasDescriptor) {
        this.this$0 = abstractTypeAliasDescriptor;
    }

    public KotlinBuiltIns getBuiltIns() {
        return DescriptorUtilsKt.getBuiltIns(this.this$0);
    }

    public ClassifierDescriptor getDeclarationDescriptor() {
        return this.this$0;
    }

    public List<TypeParameterDescriptor> getParameters() {
        List<? extends TypeParameterDescriptor> list = ((DeserializedTypeAliasDescriptor) this.this$0).typeConstructorParameters;
        if (list != null) {
            return list;
        }
        Intrinsics.throwUninitializedPropertyAccessException("typeConstructorParameters");
        throw null;
    }

    public Collection<KotlinType> getSupertypes() {
        Collection<KotlinType> supertypes = this.this$0.getUnderlyingType().getConstructor().getSupertypes();
        Intrinsics.checkNotNullExpressionValue(supertypes, "declarationDescriptor.underlyingType.constructor.supertypes");
        return supertypes;
    }

    public boolean isDenotable() {
        return true;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("[typealias ");
        outline73.append(this.this$0.getName().asString());
        outline73.append(']');
        return outline73.toString();
    }
}
