package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.name.Name;

public interface DeclarationDescriptor extends Annotated {
    <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d2);

    DeclarationDescriptor getContainingDeclaration();

    Name getName();

    DeclarationDescriptor getOriginal();
}
