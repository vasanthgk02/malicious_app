package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;

/* compiled from: AnnotationTypeQualifierResolver.kt */
public /* synthetic */ class AnnotationTypeQualifierResolver$resolvedNicknames$1 extends FunctionReference implements Function1<ClassDescriptor, AnnotationDescriptor> {
    public AnnotationTypeQualifierResolver$resolvedNicknames$1(AnnotationTypeQualifierResolver annotationTypeQualifierResolver) {
        super(1, annotationTypeQualifierResolver);
    }

    public final String getName() {
        return "computeTypeQualifierNickname";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(AnnotationTypeQualifierResolver.class);
    }

    public final String getSignature() {
        return "computeTypeQualifierNickname(Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;)Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;";
    }

    public Object invoke(Object obj) {
        ClassDescriptor classDescriptor = (ClassDescriptor) obj;
        Intrinsics.checkNotNullParameter(classDescriptor, "p0");
        AnnotationTypeQualifierResolver annotationTypeQualifierResolver = (AnnotationTypeQualifierResolver) this.receiver;
        if (annotationTypeQualifierResolver == null) {
            throw null;
        } else if (!classDescriptor.getAnnotations().hasAnnotation(AnnotationQualifiersFqNamesKt.TYPE_QUALIFIER_NICKNAME_FQNAME)) {
            return null;
        } else {
            for (AnnotationDescriptor resolveTypeQualifierAnnotation : classDescriptor.getAnnotations()) {
                AnnotationDescriptor resolveTypeQualifierAnnotation2 = annotationTypeQualifierResolver.resolveTypeQualifierAnnotation(resolveTypeQualifierAnnotation);
                if (resolveTypeQualifierAnnotation2 != null) {
                    return resolveTypeQualifierAnnotation2;
                }
            }
            return null;
        }
    }
}
