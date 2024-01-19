package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;

/* compiled from: JavaTypeResolver.kt */
public final class JavaTypeAttributes {
    public final JavaTypeFlexibility flexibility;
    public final TypeUsage howThisTypeIsUsed;
    public final boolean isForAnnotationParameter;
    public final TypeParameterDescriptor upperBoundOfTypeParameter;

    public JavaTypeAttributes(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics.checkNotNullParameter(typeUsage, "howThisTypeIsUsed");
        Intrinsics.checkNotNullParameter(javaTypeFlexibility, "flexibility");
        this.howThisTypeIsUsed = typeUsage;
        this.flexibility = javaTypeFlexibility;
        this.isForAnnotationParameter = z;
        this.upperBoundOfTypeParameter = typeParameterDescriptor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JavaTypeAttributes)) {
            return false;
        }
        JavaTypeAttributes javaTypeAttributes = (JavaTypeAttributes) obj;
        return this.howThisTypeIsUsed == javaTypeAttributes.howThisTypeIsUsed && this.flexibility == javaTypeAttributes.flexibility && this.isForAnnotationParameter == javaTypeAttributes.isForAnnotationParameter && Intrinsics.areEqual(this.upperBoundOfTypeParameter, javaTypeAttributes.upperBoundOfTypeParameter);
    }

    public int hashCode() {
        int hashCode = (this.flexibility.hashCode() + (this.howThisTypeIsUsed.hashCode() * 31)) * 31;
        boolean z = this.isForAnnotationParameter;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        TypeParameterDescriptor typeParameterDescriptor = this.upperBoundOfTypeParameter;
        return i + (typeParameterDescriptor == null ? 0 : typeParameterDescriptor.hashCode());
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("JavaTypeAttributes(howThisTypeIsUsed=");
        outline73.append(this.howThisTypeIsUsed);
        outline73.append(", flexibility=");
        outline73.append(this.flexibility);
        outline73.append(", isForAnnotationParameter=");
        outline73.append(this.isForAnnotationParameter);
        outline73.append(", upperBoundOfTypeParameter=");
        outline73.append(this.upperBoundOfTypeParameter);
        outline73.append(')');
        return outline73.toString();
    }

    public final JavaTypeAttributes withFlexibility(JavaTypeFlexibility javaTypeFlexibility) {
        Intrinsics.checkNotNullParameter(javaTypeFlexibility, "flexibility");
        TypeUsage typeUsage = this.howThisTypeIsUsed;
        boolean z = this.isForAnnotationParameter;
        TypeParameterDescriptor typeParameterDescriptor = this.upperBoundOfTypeParameter;
        Intrinsics.checkNotNullParameter(typeUsage, "howThisTypeIsUsed");
        Intrinsics.checkNotNullParameter(javaTypeFlexibility, "flexibility");
        return new JavaTypeAttributes(typeUsage, javaTypeFlexibility, z, typeParameterDescriptor);
    }

    public JavaTypeAttributes(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, TypeParameterDescriptor typeParameterDescriptor, int i) {
        JavaTypeFlexibility javaTypeFlexibility2 = (i & 2) != 0 ? JavaTypeFlexibility.INFLEXIBLE : null;
        z = (i & 4) != 0 ? false : z;
        typeParameterDescriptor = (i & 8) != 0 ? null : typeParameterDescriptor;
        Intrinsics.checkNotNullParameter(typeUsage, "howThisTypeIsUsed");
        Intrinsics.checkNotNullParameter(javaTypeFlexibility2, "flexibility");
        this.howThisTypeIsUsed = typeUsage;
        this.flexibility = javaTypeFlexibility2;
        this.isForAnnotationParameter = z;
        this.upperBoundOfTypeParameter = typeParameterDescriptor;
    }
}
