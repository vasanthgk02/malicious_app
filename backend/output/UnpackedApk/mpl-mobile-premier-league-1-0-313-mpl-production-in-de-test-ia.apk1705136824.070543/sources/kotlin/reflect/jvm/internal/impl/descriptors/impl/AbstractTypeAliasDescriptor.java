package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

/* compiled from: AbstractTypeAliasDescriptor.kt */
public abstract class AbstractTypeAliasDescriptor extends DeclarationDescriptorNonRootImpl implements TypeAliasDescriptor {
    public List<? extends TypeParameterDescriptor> declaredTypeParametersImpl;
    public final AbstractTypeAliasDescriptor$typeConstructor$1 typeConstructor = new AbstractTypeAliasDescriptor$typeConstructor$1(this);
    public final DescriptorVisibility visibilityImpl;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public AbstractTypeAliasDescriptor(DeclarationDescriptor declarationDescriptor, Annotations annotations, Name name, SourceElement sourceElement, DescriptorVisibility descriptorVisibility) {
        // Intrinsics.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        // Intrinsics.checkNotNullParameter(annotations, "annotations");
        // Intrinsics.checkNotNullParameter(name, "name");
        // Intrinsics.checkNotNullParameter(sourceElement, "sourceElement");
        // Intrinsics.checkNotNullParameter(descriptorVisibility, "visibilityImpl");
        super(declarationDescriptor, annotations, name, sourceElement);
        this.visibilityImpl = descriptorVisibility;
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d2) {
        Intrinsics.checkNotNullParameter(declarationDescriptorVisitor, "visitor");
        return declarationDescriptorVisitor.visitTypeAliasDescriptor(this, d2);
    }

    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        List<? extends TypeParameterDescriptor> list = this.declaredTypeParametersImpl;
        if (list != null) {
            return list;
        }
        Intrinsics.throwUninitializedPropertyAccessException("declaredTypeParametersImpl");
        throw null;
    }

    public Modality getModality() {
        return Modality.FINAL;
    }

    public ClassifierDescriptor getOriginal() {
        return this;
    }

    /* renamed from: getOriginal  reason: collision with other method in class */
    public DeclarationDescriptor m898getOriginal() {
        return this;
    }

    /* renamed from: getOriginal  reason: collision with other method in class */
    public DeclarationDescriptorWithSource m899getOriginal() {
        return this;
    }

    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    public DescriptorVisibility getVisibility() {
        return this.visibilityImpl;
    }

    public boolean isActual() {
        return false;
    }

    public boolean isExpect() {
        return false;
    }

    public boolean isExternal() {
        return false;
    }

    public boolean isInner() {
        return TypeUtils.contains(getUnderlyingType(), new AbstractTypeAliasDescriptor$isInner$1(this));
    }

    public String toString() {
        return Intrinsics.stringPlus("typealias ", getName().asString());
    }
}
