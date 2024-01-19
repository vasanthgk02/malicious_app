package kotlin.reflect.jvm.internal.impl.load.java.components;

import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: JavaAnnotationMapper.kt */
public final class JavaAnnotationMapper {
    public static final Name DEPRECATED_ANNOTATION_MESSAGE;
    public static final JavaAnnotationMapper INSTANCE = new JavaAnnotationMapper();
    public static final Name RETENTION_ANNOTATION_VALUE;
    public static final Name TARGET_ANNOTATION_ALLOWED_TARGETS;
    public static final Map<FqName, FqName> kotlinToJavaNameMap = ArraysKt___ArraysJvmKt.mapOf(new Pair(FqNames.target, JvmAnnotationNames.TARGET_ANNOTATION), new Pair(FqNames.retention, JvmAnnotationNames.RETENTION_ANNOTATION), new Pair(FqNames.repeatable, JvmAnnotationNames.REPEATABLE_ANNOTATION), new Pair(FqNames.mustBeDocumented, JvmAnnotationNames.DOCUMENTED_ANNOTATION));

    static {
        Name identifier = Name.identifier("message");
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(\"message\")");
        DEPRECATED_ANNOTATION_MESSAGE = identifier;
        Name identifier2 = Name.identifier("allowedTargets");
        Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(\"allowedTargets\")");
        TARGET_ANNOTATION_ALLOWED_TARGETS = identifier2;
        Name identifier3 = Name.identifier(HSLCriteriaBuilder.VALUE);
        Intrinsics.checkNotNullExpressionValue(identifier3, "identifier(\"value\")");
        RETENTION_ANNOTATION_VALUE = identifier3;
        ArraysKt___ArraysJvmKt.mapOf(new Pair(JvmAnnotationNames.TARGET_ANNOTATION, FqNames.target), new Pair(JvmAnnotationNames.RETENTION_ANNOTATION, FqNames.retention), new Pair(JvmAnnotationNames.DEPRECATED_ANNOTATION, FqNames.deprecated), new Pair(JvmAnnotationNames.REPEATABLE_ANNOTATION, FqNames.repeatable), new Pair(JvmAnnotationNames.DOCUMENTED_ANNOTATION, FqNames.mustBeDocumented));
    }

    public final AnnotationDescriptor findMappedJavaAnnotation(FqName fqName, JavaAnnotationOwner javaAnnotationOwner, LazyJavaResolverContext lazyJavaResolverContext) {
        Intrinsics.checkNotNullParameter(fqName, "kotlinName");
        Intrinsics.checkNotNullParameter(javaAnnotationOwner, "annotationOwner");
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        if (Intrinsics.areEqual(fqName, FqNames.deprecated)) {
            FqName fqName2 = JvmAnnotationNames.DEPRECATED_ANNOTATION;
            Intrinsics.checkNotNullExpressionValue(fqName2, "DEPRECATED_ANNOTATION");
            JavaAnnotation findAnnotation = javaAnnotationOwner.findAnnotation(fqName2);
            if (findAnnotation != null || javaAnnotationOwner.isDeprecatedInJavaDoc()) {
                return new JavaDeprecatedAnnotationDescriptor(findAnnotation, lazyJavaResolverContext);
            }
        }
        FqName fqName3 = kotlinToJavaNameMap.get(fqName);
        AnnotationDescriptor annotationDescriptor = null;
        if (fqName3 != null) {
            JavaAnnotation findAnnotation2 = javaAnnotationOwner.findAnnotation(fqName3);
            if (findAnnotation2 != null) {
                annotationDescriptor = mapOrResolveJavaAnnotation(findAnnotation2, lazyJavaResolverContext, false);
            }
        }
        return annotationDescriptor;
    }

    public final AnnotationDescriptor mapOrResolveJavaAnnotation(JavaAnnotation javaAnnotation, LazyJavaResolverContext lazyJavaResolverContext, boolean z) {
        Intrinsics.checkNotNullParameter(javaAnnotation, "annotation");
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        ClassId classId = javaAnnotation.getClassId();
        if (Intrinsics.areEqual(classId, ClassId.topLevel(JvmAnnotationNames.TARGET_ANNOTATION))) {
            return new JavaTargetAnnotationDescriptor(javaAnnotation, lazyJavaResolverContext);
        }
        if (Intrinsics.areEqual(classId, ClassId.topLevel(JvmAnnotationNames.RETENTION_ANNOTATION))) {
            return new JavaRetentionAnnotationDescriptor(javaAnnotation, lazyJavaResolverContext);
        }
        if (Intrinsics.areEqual(classId, ClassId.topLevel(JvmAnnotationNames.REPEATABLE_ANNOTATION))) {
            return new JavaAnnotationDescriptor(lazyJavaResolverContext, javaAnnotation, FqNames.repeatable);
        }
        if (Intrinsics.areEqual(classId, ClassId.topLevel(JvmAnnotationNames.DOCUMENTED_ANNOTATION))) {
            return new JavaAnnotationDescriptor(lazyJavaResolverContext, javaAnnotation, FqNames.mustBeDocumented);
        }
        if (Intrinsics.areEqual(classId, ClassId.topLevel(JvmAnnotationNames.DEPRECATED_ANNOTATION))) {
            return null;
        }
        return new LazyJavaAnnotationDescriptor(lazyJavaResolverContext, javaAnnotation, z);
    }
}
